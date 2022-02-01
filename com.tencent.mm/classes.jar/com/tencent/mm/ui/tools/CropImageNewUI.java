package com.tencent.mm.ui.tools;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory.Options;
import android.graphics.Matrix;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.g;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.k;
import com.tencent.mm.R.l;
import com.tencent.mm.b.g;
import com.tencent.mm.graphics.MMBitmapFactory;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.platformtools.ab;
import com.tencent.mm.plugin.gif.c;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.ExifHelper;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.ImgUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.ag;
import com.tencent.mm.ui.base.k.d;
import com.tencent.mm.ui.base.s;
import com.tencent.mm.ui.base.u.g;
import com.tencent.mm.ui.base.u.i;
import com.tencent.mm.ui.widget.a.f;
import com.tencent.mm.ui.y.b;
import com.tencent.mm.vfs.y;
import com.tencent.threadpool.i.d;
import java.lang.reflect.Array;
import junit.framework.Assert;

@Deprecated
public class CropImageNewUI
  extends MMActivity
{
  private int HKy = 0;
  private final int afDY = 1;
  private final int afDZ = 0;
  private int afEa;
  private int afEb = 0;
  private FilterImageView afEc;
  private LinearLayout afEd;
  private CropImageView afEe;
  private ImageView afEf;
  private View afEg;
  private boolean afEh = false;
  private boolean afEi = false;
  private boolean afEj = false;
  private String filePath;
  private int lCR = 0;
  
  private static Bitmap a(float[][] paramArrayOfFloat, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, CropImageView paramCropImageView)
  {
    AppMethodBeat.i(39041);
    if (paramCropImageView == null)
    {
      AppMethodBeat.o(39041);
      return null;
    }
    float[] arrayOfFloat = n.c(paramArrayOfFloat, new float[] { paramFloat1, paramFloat2, 1.0F });
    paramArrayOfFloat = n.c(paramArrayOfFloat, new float[] { paramFloat3, paramFloat4, 1.0F });
    int j = (int)Math.min(arrayOfFloat[0], paramArrayOfFloat[0]);
    int k = (int)Math.min(arrayOfFloat[1], paramArrayOfFloat[1]);
    int i = j;
    if (j < 0) {
      i = 0;
    }
    j = k;
    if (k < 0) {
      j = 0;
    }
    int m = (int)Math.abs(arrayOfFloat[0] - paramArrayOfFloat[0]);
    int n = (int)Math.abs(arrayOfFloat[1] - paramArrayOfFloat[1]);
    paramArrayOfFloat = new Matrix();
    switch (paramCropImageView.getRotateCount() % 4)
    {
    }
    for (;;)
    {
      paramCropImageView = paramCropImageView.getBmp();
      k = m;
      if (i + m > paramCropImageView.getWidth()) {
        k = paramCropImageView.getWidth() - i;
      }
      m = n;
      if (j + n > paramCropImageView.getHeight()) {
        m = paramCropImageView.getHeight() - j;
      }
      Log.i("MicroMsg.CropImageUI", "rawWidth:%d, rawHeigth:%d, originalLX:%d, originalTY:%d, realWidth:%d, realHeight:%d", new Object[] { Integer.valueOf(paramCropImageView.getWidth()), Integer.valueOf(paramCropImageView.getHeight()), Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(m) });
      paramArrayOfFloat = Bitmap.createBitmap(paramCropImageView, i, j, k, m, paramArrayOfFloat, true);
      AppMethodBeat.o(39041);
      return paramArrayOfFloat;
      paramArrayOfFloat.setRotate(0.0F, m / 2, n / 2);
      continue;
      paramArrayOfFloat.setRotate(90.0F, m / 2, n / 2);
      continue;
      paramArrayOfFloat.setRotate(180.0F, m / 2, n / 2);
      continue;
      paramArrayOfFloat.setRotate(270.0F, m / 2, n / 2);
    }
  }
  
  private boolean a(Bitmap paramBitmap, String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(39042);
    if ((paramString != null) && (!paramString.equals(""))) {}
    for (;;)
    {
      try
      {
        if (this.lCR == 1)
        {
          BitmapUtil.saveBitmapToImage(paramBitmap, 30, Bitmap.CompressFormat.JPEG, paramString, paramBoolean);
          AppMethodBeat.o(39042);
          return true;
        }
        if (this.lCR != 2) {
          break label118;
        }
        BitmapUtil.saveBitmapToImage(paramBitmap, 80, Bitmap.CompressFormat.JPEG, paramString, paramBoolean);
        continue;
        AppMethodBeat.o(39042);
      }
      catch (Exception paramBitmap)
      {
        Log.printErrStackTrace("MicroMsg.CropImageUI", paramBitmap, "", new Object[0]);
        Log.e("MicroMsg.CropImageUI", "saveBitmapToImage failed:" + paramBitmap.toString());
      }
      return false;
      label118:
      BitmapUtil.saveBitmapToImage(paramBitmap, 100, Bitmap.CompressFormat.JPEG, paramString, paramBoolean);
    }
  }
  
  private void c(Runnable paramRunnable1, Runnable paramRunnable2)
  {
    AppMethodBeat.i(39038);
    this.afEc = ((FilterImageView)findViewById(R.h.fEi));
    this.afEc.setOnConfirmImp(paramRunnable1);
    this.afEc.setOnExitImp(paramRunnable2);
    AppMethodBeat.o(39038);
  }
  
  private boolean jCV()
  {
    AppMethodBeat.i(39037);
    Object localObject1;
    if (1 == this.afEa) {
      if (this.afEc != null) {
        localObject1 = this.afEc.getCropAreaView();
      }
    }
    while (localObject1 == null)
    {
      AppMethodBeat.o(39037);
      return false;
      localObject1 = findViewById(R.h.cropimage_frame);
      continue;
      localObject1 = findViewById(R.h.cropimage_fl);
    }
    int n = ((View)localObject1).getWidth();
    int i1 = ((View)localObject1).getHeight();
    Log.v("MicroMsg.CropImageUI", "scrWidth:" + n + " scrHeight:" + i1);
    this.filePath = getIntent().getStringExtra("CropImage_ImgPath");
    if (!y.ZC(this.filePath))
    {
      finish();
      AppMethodBeat.o(39037);
      return false;
    }
    int k = 960;
    int m = 960;
    boolean bool;
    int j;
    int i;
    if (this.afEa == 2)
    {
      bool = true;
      j = i1;
      i = n;
      this.HKy = BackwardSupportUtil.ExifHelper.getExifOrientation(this.filePath);
      if ((this.HKy != 90) && (this.HKy != 270)) {
        break label2275;
      }
    }
    for (;;)
    {
      Object localObject3 = BitmapUtil.extractThumbNail(this.filePath, i, j, bool);
      Object localObject2 = y.bi(this.filePath, 0, 10);
      if (ImgUtil.isGif((byte[])localObject2)) {}
      float f1;
      for (this.afEb = 1;; this.afEb = 0)
      {
        if (localObject3 != null) {
          break label908;
        }
        finish();
        AppMethodBeat.o(39037);
        return false;
        if (this.afEa == 3)
        {
          localObject2 = new BitmapFactory.Options();
          ((BitmapFactory.Options)localObject2).inJustDecodeBounds = true;
          localObject3 = MMBitmapFactory.decodeFile(this.filePath, (BitmapFactory.Options)localObject2);
          if (localObject3 != null) {
            ((Bitmap)localObject3).recycle();
          }
          k = ((BitmapFactory.Options)localObject2).outWidth;
          m = ((BitmapFactory.Options)localObject2).outHeight;
          f1 = 1.0F;
          if ((k > 640) || (m > 640)) {
            if (k > m)
            {
              f1 = m / k;
              j = 640;
              i = (int)(m * f1);
            }
          }
          for (;;)
          {
            Log.d("MicroMsg.CropImageUI", "w:%d h:%d width:%d height:%d scale:%f", new Object[] { Integer.valueOf(k), Integer.valueOf(m), Integer.valueOf(j), Integer.valueOf(i), Float.valueOf(f1) });
            localObject2 = (Button)findViewById(R.h.fEk);
            if (localObject2 != null) {
              ((Button)localObject2).setVisibility(8);
            }
            bool = false;
            k = i;
            i = j;
            j = k;
            break;
            f1 = k / m;
            i = 640;
            j = (int)(960.0F * f1);
            continue;
            i = m;
            j = k;
          }
        }
        if (this.afEa == 1)
        {
          localObject2 = new BitmapFactory.Options();
          ((BitmapFactory.Options)localObject2).inJustDecodeBounds = true;
          localObject3 = MMBitmapFactory.decodeFile(this.filePath, (BitmapFactory.Options)localObject2);
          if (localObject3 != null)
          {
            Log.i("MicroMsg.CropImageUI", "recycle bitmap:%s", new Object[] { localObject3.toString() });
            ((Bitmap)localObject3).recycle();
          }
          if (((BitmapFactory.Options)localObject2).outWidth > ((BitmapFactory.Options)localObject2).outHeight)
          {
            k = (int)(((BitmapFactory.Options)localObject2).outWidth * 960 * 1.0D / ((BitmapFactory.Options)localObject2).outHeight);
            j = m;
            i = k;
            if (k > 1920)
            {
              i = 1920;
              j = m;
            }
          }
          for (;;)
          {
            bool = false;
            break;
            m = (int)(((BitmapFactory.Options)localObject2).outHeight * 960 * 1.0D / ((BitmapFactory.Options)localObject2).outWidth);
            j = m;
            i = k;
            if (m > 1920)
            {
              j = 1920;
              i = k;
            }
          }
        }
        localObject2 = new BitmapFactory.Options();
        ((BitmapFactory.Options)localObject2).inJustDecodeBounds = true;
        BitmapUtil.bindlowMemeryOption((BitmapFactory.Options)localObject2);
        localObject3 = MMBitmapFactory.decodeFile(this.filePath, (BitmapFactory.Options)localObject2);
        if (localObject3 != null)
        {
          Log.i("MicroMsg.CropImageUI", "recycle bitmap:%s", new Object[] { localObject3.toString() });
          ((Bitmap)localObject3).recycle();
        }
        if ((ab.isLongHorizontal(((BitmapFactory.Options)localObject2).outWidth, ((BitmapFactory.Options)localObject2).outHeight)) && (((BitmapFactory.Options)localObject2).outWidth > 480))
        {
          bool = true;
          label770:
          this.afEh = bool;
          if ((!ab.isLongVertical(((BitmapFactory.Options)localObject2).outWidth, ((BitmapFactory.Options)localObject2).outHeight)) || (((BitmapFactory.Options)localObject2).outHeight <= 480)) {
            break label894;
          }
        }
        label894:
        for (bool = true;; bool = false)
        {
          this.afEi = bool;
          if (!this.afEh)
          {
            j = m;
            i = k;
            if (!this.afEi) {}
          }
          else
          {
            j = ((BitmapFactory.Options)localObject2).outHeight;
            i = ((BitmapFactory.Options)localObject2).outWidth;
          }
          Log.e("MicroMsg.CropImageUI", "width is " + i + " height is " + j);
          bool = false;
          break;
          bool = false;
          break label770;
        }
      }
      label908:
      Log.d("temBmp crop", "h:" + ((Bitmap)localObject3).getHeight() + "w: " + ((Bitmap)localObject3).getWidth());
      Bitmap localBitmap = BitmapUtil.rotate((Bitmap)localObject3, this.HKy);
      localObject3 = new Matrix();
      ((Matrix)localObject3).reset();
      float f4 = 1.0F;
      float f2;
      label1022:
      float f3;
      if (bool)
      {
        f1 = localBitmap.getWidth() / n;
        f2 = localBitmap.getHeight() / i1;
        if (f1 < f2)
        {
          if (n <= i1) {
            break label1280;
          }
          f2 = i1;
          f3 = f2 / localBitmap.getWidth();
          f4 = f2 / localBitmap.getHeight();
          f2 = f4;
          if (f3 > f4) {
            f2 = f3;
          }
          if (f1 < 1.0D) {
            ((Matrix)localObject3).postScale(f2, f2);
          }
        }
      }
      for (;;)
      {
        if (1 == this.afEa)
        {
          if (this.afEc != null)
          {
            this.afEc.setMatrix((Matrix)localObject3);
            this.afEc.setImage(localBitmap);
          }
          label1101:
          if (this.afEa != 3) {
            break label2210;
          }
          if (!ImgUtil.isGif((byte[])localObject2)) {
            break label2202;
          }
          this.afEb = 1;
        }
        try
        {
          localObject1 = c.fJa().jj(this.filePath, this.filePath);
          this.afEe.setImageDrawable((Drawable)localObject1);
          ((com.tencent.mm.plugin.gif.b)localObject1).start();
          ((Matrix)localObject3).reset();
          i = ((com.tencent.mm.plugin.gif.b)localObject1).getIntrinsicWidth();
          j = ((com.tencent.mm.plugin.gif.b)localObject1).getIntrinsicHeight();
          f1 = n / i;
          f2 = i1 / j;
          if (f1 >= f2) {
            break label2152;
          }
          label1193:
          f2 = i / n;
          f3 = j / i1;
          if (f2 <= f3) {
            break label2157;
          }
          label1215:
          if (f2 <= 1.0D) {
            break label2162;
          }
          ((Matrix)localObject3).postScale(f1, f1);
          ((Matrix)localObject3).postTranslate((n - i * f1) / 2.0F, (i1 - f1 * j) / 2.0F);
          label1258:
          this.afEe.setImageMatrix((Matrix)localObject3);
        }
        catch (Exception localException)
        {
          for (;;)
          {
            label1267:
            Log.e("MicroMsg.CropImageUI", Util.stackTraceToString(localException));
          }
        }
        AppMethodBeat.o(39037);
        return true;
        f1 = f2;
        break;
        label1280:
        f2 = n;
        break label1022;
        f1 = localBitmap.getWidth() / localBitmap.getHeight();
        f2 = localBitmap.getHeight() / localBitmap.getWidth();
        Log.v("MicroMsg.CropImageUI", "whDiv is " + f1 + " hwDiv is " + f2);
        if ((f2 >= 2.0F) && (localBitmap.getHeight() >= 480))
        {
          f2 = localBitmap.getWidth() / n;
          f1 = n / localBitmap.getWidth();
          if (1 == this.afEa)
          {
            f2 = i1 / localBitmap.getHeight();
            if (f1 > f2) {}
            for (;;)
            {
              ((Matrix)localObject3).postScale(f1, f1);
              ((Matrix)localObject3).postTranslate((n - f1 * localBitmap.getWidth()) / 2.0F + ((View)localObject1).getLeft(), ((View)localObject1).getTop());
              break;
              f1 = f2;
            }
          }
          if (f2 > 1.0D)
          {
            ((Matrix)localObject3).postScale(f1, f1);
            localBitmap.getHeight();
            ((Matrix)localObject3).postTranslate((n - f1 * localBitmap.getWidth()) / 2.0F, 0.0F);
          }
          else
          {
            ((Matrix)localObject3).postScale(1.0F, 1.0F);
            if (3 == this.afEa) {
              ((Matrix)localObject3).postTranslate((n - localBitmap.getWidth()) / 2, (i1 - localBitmap.getHeight()) / 2);
            } else {
              ((Matrix)localObject3).postTranslate((n - localBitmap.getWidth()) / 2, 0.0F);
            }
          }
        }
        else
        {
          label1822:
          label1972:
          if ((f1 >= 2.0F) && (localBitmap.getWidth() >= 480))
          {
            f1 = localBitmap.getHeight() / 480.0F;
            f2 = 480.0F / localBitmap.getHeight();
            if (1 == this.afEa)
            {
              f1 = n / localBitmap.getWidth();
              f2 = i1 / localBitmap.getHeight();
              if (f1 > f2) {}
              for (;;)
              {
                ((Matrix)localObject3).postScale(f1, f1);
                ((Matrix)localObject3).postTranslate((n - localBitmap.getWidth() * f1) / 2.0F + ((View)localObject1).getLeft(), (i1 - f1 * localBitmap.getHeight()) / 2.0F + ((View)localObject1).getTop());
                break;
                f1 = f2;
              }
            }
            if (f1 > 1.0D)
            {
              ((Matrix)localObject3).postScale(f1, f2);
              ((Matrix)localObject3).postTranslate(0.0F, (i1 - 480) / 2);
            }
            else
            {
              ((Matrix)localObject3).postScale(1.0F, 1.0F);
              f1 = (i1 - localBitmap.getHeight()) / 2;
              Log.d("MicroMsg.CropImageUI", " offsety ".concat(String.valueOf(f1)));
              ((Matrix)localObject3).postTranslate(0.0F, f1);
            }
          }
          else
          {
            f2 = n / localBitmap.getWidth();
            f3 = i1 / localBitmap.getHeight();
            if (f2 < f3)
            {
              f1 = f2;
              if (f2 <= f3) {
                break label1900;
              }
            }
            for (;;)
            {
              if (1 != this.afEa) {
                break label1905;
              }
              ((Matrix)localObject3).postScale(f2, f2);
              ((Matrix)localObject3).postTranslate((n - localBitmap.getWidth() * f2) / 2.0F + ((View)localObject1).getLeft(), (i1 - f2 * localBitmap.getHeight()) / 2.0F + ((View)localObject1).getTop());
              break;
              f1 = f3;
              break label1822;
              label1900:
              f2 = f3;
            }
            label1905:
            if (this.afEb == 1)
            {
              this.afEe.setGifPath(this.filePath);
              this.afEe.getGifWidth();
              this.afEe.getGifHeight();
              f1 = this.afEe.getGifWidth() / n;
              f2 = this.afEe.getGifHeight() / i1;
              if (f1 > f2)
              {
                if (f1 <= 1.0D) {
                  break label2270;
                }
                ((Matrix)localObject3).postScale(f1, f1);
              }
            }
          }
        }
      }
      for (;;)
      {
        ((Matrix)localObject3).postTranslate((n - this.afEe.getGifWidth() * f1) / 2.0F, (i1 - f1 * this.afEe.getGifHeight()) / 2.0F);
        break;
        f1 = f2;
        break label1972;
        f2 = localBitmap.getWidth() / n;
        f3 = localBitmap.getHeight() / i1;
        if (f2 > f3) {}
        for (;;)
        {
          f3 = f4;
          if (f2 > 1.0D)
          {
            ((Matrix)localObject3).postScale(f1, f1);
            f3 = f1;
          }
          ((Matrix)localObject3).postTranslate((n - localBitmap.getWidth() * f3) / 2.0F, (i1 - localBitmap.getHeight() * f3) / 2.0F);
          break;
          f2 = f3;
        }
        if (this.afEb == 1) {
          break label1101;
        }
        this.afEe.setImageMatrix((Matrix)localObject3);
        this.afEe.setImageBitmap(localBitmap);
        break label1101;
        label2152:
        f1 = f2;
        break label1193;
        label2157:
        f2 = f3;
        break label1215;
        label2162:
        ((Matrix)localObject3).postTranslate((n - i) / 2, (i1 - j) / 2);
        break label1258;
        label2202:
        this.afEb = 0;
        break label1267;
        label2210:
        if ((this.afEh) || (this.afEi)) {
          findViewById(R.h.fEp).setVisibility(8);
        }
        if (getIntent().getBooleanExtra("CropImage_DirectlyIntoFilter", false)) {
          findViewById(R.h.cropimage_function_bar).setVisibility(8);
        }
        AppMethodBeat.o(39037);
        return true;
        label2270:
        f1 = 1.0F;
      }
      label2275:
      k = i;
      i = j;
      j = k;
    }
  }
  
  private static float[][] l(Matrix paramMatrix)
  {
    AppMethodBeat.i(39043);
    float[][] arrayOfFloat = (float[][])Array.newInstance(Float.TYPE, new int[] { 3, 3 });
    float[] arrayOfFloat1 = new float[9];
    paramMatrix.getValues(arrayOfFloat1);
    int i = 0;
    while (i < 3)
    {
      int j = 0;
      while (j < 3)
      {
        arrayOfFloat[i][j] = arrayOfFloat1[(i * 3 + j)];
        j += 1;
      }
      i += 1;
    }
    AppMethodBeat.o(39043);
    return arrayOfFloat;
  }
  
  private Bitmap oB(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(39040);
    Bitmap localBitmap = BitmapUtil.extractThumbNail(this.filePath, paramInt2, paramInt1, true);
    Object localObject = localBitmap;
    if (this.HKy != 0)
    {
      localObject = new Matrix();
      ((Matrix)localObject).reset();
      ((Matrix)localObject).setRotate(this.HKy, localBitmap.getWidth() / 2, localBitmap.getHeight() / 2);
      localObject = Bitmap.createBitmap(localBitmap, 0, 0, localBitmap.getWidth(), localBitmap.getHeight(), (Matrix)localObject, true);
      if (localBitmap != localObject)
      {
        Log.i("MicroMsg.CropImageUI", "recycle bitmap:%s", new Object[] { localBitmap.toString() });
        localBitmap.recycle();
      }
    }
    Log.d("MicroMsg.CropImageUI", "getcrop degree:" + this.HKy);
    AppMethodBeat.o(39040);
    return localObject;
  }
  
  public void activateBroadcast(boolean paramBoolean)
  {
    AppMethodBeat.i(39032);
    if (paramBoolean)
    {
      ag.d(paramBoolean, new Intent().putExtra("classname", getClass().getName()).putExtra("main_process", false));
      AppMethodBeat.o(39032);
      return;
    }
    super.activateBroadcast(paramBoolean);
    AppMethodBeat.o(39032);
  }
  
  public int getLayoutId()
  {
    return R.i.giO;
  }
  
  public void initView()
  {
    AppMethodBeat.i(39035);
    setMMTitle("");
    this.afEd = ((LinearLayout)findViewById(R.h.cropimage_operator_ll));
    this.afEf = ((ImageView)findViewById(R.h.cropimage_iv));
    this.afEg = findViewById(R.h.cropimage_frame);
    this.afEa = getIntent().getIntExtra("CropImageMode", 0);
    final boolean bool1;
    final boolean bool2;
    Object localObject;
    Button localButton;
    int i;
    if (this.afEa != 0)
    {
      bool1 = true;
      Assert.assertTrue("the image mode must be set", bool1);
      this.lCR = getIntent().getIntExtra("CropImage_from_scene", 0);
      bool1 = getIntent().getBooleanExtra("CropImage_Filter", false);
      bool2 = getIntent().getBooleanExtra("CropImage_DirectlyIntoFilter", false);
      if (bool1) {
        c(new Runnable()new Runnable
        {
          public final void run()
          {
            boolean bool = false;
            AppMethodBeat.i(39028);
            if (CropImageNewUI.e(CropImageNewUI.this) == null)
            {
              AppMethodBeat.o(39028);
              return;
            }
            if (CropImageNewUI.this.getIntent().getBooleanExtra("CropImage_DirectlyIntoFilter", false))
            {
              localObject1 = CropImageNewUI.this.getSharedPreferences(MMApplicationContext.getDefaultPreferencePath(), 0).edit();
              if (CropImageNewUI.e(CropImageNewUI.this).findViewById(R.h.cropimage_filter_gallery).getVisibility() == 0) {
                bool = true;
              }
              ((SharedPreferences.Editor)localObject1).putBoolean("CropImage_Filter_Show", bool);
              ((SharedPreferences.Editor)localObject1).commit();
            }
            Object localObject2 = CropImageNewUI.this.getIntent().getStringExtra("CropImage_OutputPath");
            Object localObject1 = localObject2;
            if (localObject2 == null) {
              localObject1 = com.tencent.mm.loader.i.b.bmL() + g.getMessageDigest(new StringBuilder().append(CropImageNewUI.o(CropImageNewUI.this)).append(System.currentTimeMillis()).toString().getBytes()) + "_fiter.jpg";
            }
            localObject2 = new Intent();
            ((Intent)localObject2).putExtra("CropImage_Compress_Img", true);
            if (CropImageNewUI.e(CropImageNewUI.this) != null) {
              ((Intent)localObject2).putExtra("CropImage_filterId", CropImageNewUI.e(CropImageNewUI.this).getFilterId());
            }
            if (CropImageNewUI.e(CropImageNewUI.this).getFilterId() == 0)
            {
              ((Intent)localObject2).putExtra("CropImage_OutputPath", CropImageNewUI.o(CropImageNewUI.this));
              CropImageNewUI.this.setResult(-1, (Intent)localObject2);
            }
            for (;;)
            {
              CropImageNewUI.this.finish();
              AppMethodBeat.o(39028);
              return;
              if (CropImageNewUI.a(CropImageNewUI.this, CropImageNewUI.e(CropImageNewUI.this).getFilterBmp(), (String)localObject1))
              {
                ((Intent)localObject2).putExtra("CropImage_OutputPath", (String)localObject1);
                CropImageNewUI.this.setResult(-1, (Intent)localObject2);
              }
              else
              {
                CropImageNewUI.this.setResult(-1);
              }
            }
          }
        }, new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(39029);
            if (CropImageNewUI.this.getIntent().getBooleanExtra("CropImage_DirectlyIntoFilter", false))
            {
              CropImageNewUI.this.finish();
              AppMethodBeat.o(39029);
              return;
            }
            CropImageNewUI.e(CropImageNewUI.this).setVisibility(8);
            CropImageNewUI.p(CropImageNewUI.this).setVisibility(0);
            CropImageNewUI.q(CropImageNewUI.this).setVisibility(((Integer)CropImageNewUI.q(CropImageNewUI.this).getTag()).intValue());
            CropImageNewUI.j(CropImageNewUI.this).setVisibility(0);
            AppMethodBeat.o(39029);
          }
        });
      }
      this.afEj = false;
      this.afEe = ((CropImageView)findViewById(R.h.fEo));
      this.afEe.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(39006);
          if (!CropImageNewUI.a(CropImageNewUI.this))
          {
            AppMethodBeat.o(39006);
            return;
          }
          if ((!CropImageNewUI.b(CropImageNewUI.this)) && (!CropImageNewUI.c(CropImageNewUI.this)) && (CropImageNewUI.this.getIntent().getBooleanExtra("CropImage_DirectlyIntoFilter", false)))
          {
            CropImageNewUI.d(CropImageNewUI.this);
            if (!CropImageNewUI.this.getSharedPreferences(MMApplicationContext.getDefaultPreferencePath(), 0).getBoolean("CropImage_Filter_Show", true)) {
              CropImageNewUI.e(CropImageNewUI.this).findViewById(R.h.cropimage_filter_gallery).setVisibility(4);
            }
            AppMethodBeat.o(39006);
            return;
          }
          if (1 == CropImageNewUI.f(CropImageNewUI.this)) {
            CropImageNewUI.g(CropImageNewUI.this);
          }
          AppMethodBeat.o(39006);
        }
      });
      this.afEe.setOnShortClick(new CropImageView.a()
      {
        public final void jCW()
        {
          AppMethodBeat.i(39017);
          CropImageNewUI.h(CropImageNewUI.this);
          AppMethodBeat.o(39017);
        }
      });
      ((Button)findViewById(R.h.fEp)).setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(39009);
          Object localObject = new com.tencent.mm.hellhoundlib.b.b();
          ((com.tencent.mm.hellhoundlib.b.b)localObject).cH(paramAnonymousView);
          a.c("com/tencent/mm/ui/tools/CropImageNewUI$12", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aYj());
          paramAnonymousView = CropImageNewUI.j(CropImageNewUI.this);
          if (paramAnonymousView.wNk == null) {
            Log.w("MicroMsg.CropImageView", "rotate not done! cause: btmp is null!");
          }
          for (;;)
          {
            a.a(this, "com/tencent/mm/ui/tools/CropImageNewUI$12", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(39009);
            return;
            localObject = new float[2];
            localObject[0] = (paramAnonymousView.wNk.getWidth() / 2);
            localObject[1] = (paramAnonymousView.wNk.getHeight() / 2);
            paramAnonymousView.getImageMatrix().mapPoints((float[])localObject);
            paramAnonymousView.getImageMatrix().postRotate(90.0F, localObject[0], localObject[1]);
            paramAnonymousView.setImageBitmap(paramAnonymousView.wNk);
            paramAnonymousView.invalidate();
            paramAnonymousView.hOX += 1;
          }
        }
      });
      localObject = (Button)findViewById(R.h.fEq);
      ((Button)localObject).setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(39010);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.cH(paramAnonymousView);
          a.c("com/tencent/mm/ui/tools/CropImageNewUI$13", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
          CropImageNewUI.j(CropImageNewUI.this).zoomIn();
          a.a(this, "com/tencent/mm/ui/tools/CropImageNewUI$13", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(39010);
        }
      });
      localButton = (Button)findViewById(R.h.fEr);
      localButton.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(39011);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.cH(paramAnonymousView);
          a.c("com/tencent/mm/ui/tools/CropImageNewUI$14", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
          CropImageNewUI.j(CropImageNewUI.this).zoomOut();
          a.a(this, "com/tencent/mm/ui/tools/CropImageNewUI$14", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(39011);
        }
      });
      MTimerHandler localMTimerHandler1 = new MTimerHandler(new MTimerHandler.CallBack()
      {
        public final boolean onTimerExpired()
        {
          AppMethodBeat.i(39012);
          CropImageNewUI.j(CropImageNewUI.this).zoomIn();
          AppMethodBeat.o(39012);
          return true;
        }
      }, true);
      MTimerHandler localMTimerHandler2 = new MTimerHandler(new MTimerHandler.CallBack()
      {
        public final boolean onTimerExpired()
        {
          AppMethodBeat.i(39013);
          CropImageNewUI.j(CropImageNewUI.this).zoomOut();
          AppMethodBeat.o(39013);
          return true;
        }
      }, true);
      ((Button)localObject).setOnTouchListener(new CropImageNewUI.9(this, localMTimerHandler1));
      localButton.setOnTouchListener(new CropImageNewUI.10(this, localMTimerHandler2));
      i = R.l.gDC;
      switch (this.afEa)
      {
      case 4: 
      default: 
        label376:
        Log.d("MicroMsg.CropImageUI", "mode is  " + this.afEa);
        localObject = new MenuItem.OnMenuItemClickListener()
        {
          public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
          {
            AppMethodBeat.i(39021);
            if ((bool1) && (bool2))
            {
              CropImageNewUI.a(CropImageNewUI.this, true);
              AppMethodBeat.o(39021);
              return true;
            }
            switch (CropImageNewUI.f(CropImageNewUI.this))
            {
            }
            for (;;)
            {
              AppMethodBeat.o(39021);
              return true;
              if (CropImageNewUI.e(CropImageNewUI.this) != null)
              {
                CropImageNewUI.a(CropImageNewUI.this, CropImageNewUI.e(CropImageNewUI.this).getCropImageIV(), CropImageNewUI.i(CropImageNewUI.this));
              }
              else
              {
                CropImageNewUI.a(CropImageNewUI.this, CropImageNewUI.j(CropImageNewUI.this), CropImageNewUI.i(CropImageNewUI.this));
                continue;
                CropImageNewUI.k(CropImageNewUI.this);
                continue;
                CropImageNewUI.l(CropImageNewUI.this);
                continue;
                CropImageNewUI.m(CropImageNewUI.this);
                continue;
                CropImageNewUI.n(CropImageNewUI.this);
              }
            }
          }
        };
        if (this.afEa == 5) {
          addIconOptionMenu(0, R.k.icons_outlined_more, (MenuItem.OnMenuItemClickListener)localObject);
        }
        break;
      }
    }
    for (;;)
    {
      if ((bool1) && (bool2)) {
        addTextOptionMenu(0, getString(R.l.gDz), (MenuItem.OnMenuItemClickListener)localObject, null, y.b.adEJ);
      }
      setBackBtn(new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          AppMethodBeat.i(39023);
          CropImageNewUI.this.finish();
          AppMethodBeat.o(39023);
          return true;
        }
      });
      if (this.afEa == 6)
      {
        findViewById(R.h.cropimage_function_bar).setVisibility(8);
        addTextOptionMenu(0, getString(R.l.gDC), new MenuItem.OnMenuItemClickListener()
        {
          public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
          {
            AppMethodBeat.i(39026);
            paramAnonymousMenuItem = new f(CropImageNewUI.this, 1, false);
            paramAnonymousMenuItem.Vtg = new u.g()
            {
              public final void onCreateMMMenu(s paramAnonymous2s)
              {
                AppMethodBeat.i(39024);
                paramAnonymous2s.oh(0, R.l.gDF);
                paramAnonymous2s.oh(1, R.l.gDJ);
                AppMethodBeat.o(39024);
              }
            };
            paramAnonymousMenuItem.GAC = new u.i()
            {
              public final void onMMMenuItemSelected(MenuItem paramAnonymous2MenuItem, int paramAnonymous2Int)
              {
                AppMethodBeat.i(39025);
                switch (paramAnonymous2MenuItem.getItemId())
                {
                }
                for (;;)
                {
                  AppMethodBeat.o(39025);
                  return;
                  paramAnonymous2MenuItem = new Intent();
                  paramAnonymous2MenuItem.putExtra("CropImage_OutputPath", CropImageNewUI.this.getIntent().getStringExtra("CropImage_OutputPath"));
                  paramAnonymous2MenuItem.putExtra("OP_CODE", 1);
                  CropImageNewUI.this.setResult(-1, paramAnonymous2MenuItem);
                  CropImageNewUI.this.finish();
                  AppMethodBeat.o(39025);
                  return;
                  paramAnonymous2MenuItem = new Intent();
                  paramAnonymous2MenuItem.putExtra("CropImage_OutputPath", CropImageNewUI.this.getIntent().getStringExtra("CropImage_OutputPath"));
                  paramAnonymous2MenuItem.putExtra("OP_CODE", 2);
                  CropImageNewUI.this.setResult(-1, paramAnonymous2MenuItem);
                  CropImageNewUI.this.finish();
                }
              }
            };
            paramAnonymousMenuItem.dDn();
            AppMethodBeat.o(39026);
            return true;
          }
        }, null, y.b.adEJ);
      }
      AppMethodBeat.o(39035);
      return;
      bool1 = false;
      break;
      c(new Runnable()new Runnable
      {
        public final void run()
        {
          AppMethodBeat.i(39007);
          CropImageNewUI.a(CropImageNewUI.this, CropImageNewUI.e(CropImageNewUI.this).getCropImageIV(), CropImageNewUI.e(CropImageNewUI.this).getCropAreaView());
          CropImageNewUI.this.finish();
          AppMethodBeat.o(39007);
        }
      }, new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(39008);
          CropImageNewUI.this.finish();
          AppMethodBeat.o(39008);
        }
      });
      this.afEc.setLimitZoomIn(false);
      localObject = this.afEc;
      if (((FilterImageView)localObject).afFa != null)
      {
        ((FilterImageView)localObject).afFa.setScaleType(ImageView.ScaleType.MATRIX);
        ((FilterImageView)localObject).afFa.jCX();
      }
      this.afEc.setCropMaskVisible(0);
      if (this.lCR != 1) {
        break label376;
      }
      this.afEc.setCropMaskBackground(R.g.new_year_capture);
      break label376;
      this.afEe.setEnableOprate(false);
      findViewById(R.h.fEh).setVisibility(8);
      findViewById(R.h.cropimage_function_bar).setVisibility(8);
      break label376;
      this.afEd.setVisibility(8);
      break label376;
      int j = getIntent().getIntExtra("CropImage_CompressType", 1);
      boolean bool3 = getIntent().getBooleanExtra("CropImage_BHasHD", false);
      if ((j != 1) && (bool3))
      {
        findViewById(R.h.cropimage_function_bar).setVisibility(0);
        localObject = (Button)findViewById(R.h.fEk);
        ((Button)localObject).setBackgroundResource(R.g.btn_style_black);
        ((Button)localObject).setPadding(25, 8, 25, 8);
        ((Button)localObject).setOnClickListener(new CropImageNewUI.11(this));
        break label376;
      }
      findViewById(R.h.cropimage_function_bar).setVisibility(8);
      break label376;
      if (this.afEa == 4)
      {
        addIconOptionMenu(0, R.k.icons_outlined_more, (MenuItem.OnMenuItemClickListener)localObject);
        findViewById(R.h.cropimage_function_bar).setVisibility(0);
        localButton = (Button)findViewById(R.h.fEk);
        localButton.setText(R.l.gDz);
        localButton.setOnClickListener(new CropImageNewUI.18(this));
      }
      else
      {
        addTextOptionMenu(0, getString(i), (MenuItem.OnMenuItemClickListener)localObject, null, y.b.adEJ);
      }
    }
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(39036);
    Log.d("MicroMsg.CropImageUI", "onConfigurationChanged, config.orientation = " + paramConfiguration.orientation);
    if ((paramConfiguration.orientation == 1) || (paramConfiguration.orientation == 2))
    {
      Log.v("MicroMsg.CropImageUI", "onConfigurationChanged");
      this.afEe.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(39027);
          CropImageNewUI.a(CropImageNewUI.this);
          AppMethodBeat.o(39027);
        }
      });
    }
    super.onConfigurationChanged(paramConfiguration);
    AppMethodBeat.o(39036);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(39030);
    super.onCreate(paramBundle);
    initView();
    AppMethodBeat.o(39030);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(39034);
    Object localObject;
    if (this.afEe != null)
    {
      localObject = this.afEe;
      if ((((CropImageView)localObject).wNk != null) && (!((CropImageView)localObject).wNk.isRecycled()))
      {
        Log.i("MicroMsg.CropImageView", "recycle bitmap:%s", new Object[] { ((CropImageView)localObject).wNk.toString() });
        ((CropImageView)localObject).wNk.recycle();
      }
      if (((CropImageView)localObject).afEI != null)
      {
        ((CropImageView)localObject).afEI.cancel(false);
        ((CropImageView)localObject).afEI = null;
      }
      ((CropImageView)localObject).afEJ.removeCallbacksAndMessages(null);
      ((CropImageView)localObject).afEL.removeCallbacksAndMessages(null);
    }
    if (this.afEc != null)
    {
      localObject = this.afEc;
      ((FilterImageView)localObject).afEX = null;
      if ((((FilterImageView)localObject).afFb != null) && (!((FilterImageView)localObject).afFb.isRecycled()))
      {
        Log.i("MicroMsg.FilterView", "recycle bitmap:%s", new Object[] { ((FilterImageView)localObject).afFb.toString() });
        ((FilterImageView)localObject).afFb.recycle();
      }
      ((FilterImageView)localObject).afFb = null;
    }
    super.onDestroy();
    AppMethodBeat.o(39034);
  }
  
  public void onNewIntent(Intent paramIntent)
  {
    AppMethodBeat.i(39031);
    super.onNewIntent(paramIntent);
    setIntent(paramIntent);
    initView();
    AppMethodBeat.o(39031);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(39033);
    super.onResume();
    setRequestedOrientation(1);
    AppMethodBeat.o(39033);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.ui.tools.CropImageNewUI
 * JD-Core Version:    0.7.0.1
 */