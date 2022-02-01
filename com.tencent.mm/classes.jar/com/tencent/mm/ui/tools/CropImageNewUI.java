package com.tencent.mm.ui.tools;

import android.app.Activity;
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
import com.tencent.mm.b.g;
import com.tencent.mm.graphics.MMBitmapFactory;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.platformtools.af;
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
import com.tencent.mm.ui.base.aa;
import com.tencent.mm.ui.base.h.d;
import com.tencent.mm.ui.base.m;
import com.tencent.mm.ui.base.o.f;
import com.tencent.mm.ui.base.o.g;
import com.tencent.mm.ui.t.b;
import com.tencent.mm.ui.widget.a.e;
import com.tencent.mm.vfs.s;
import java.lang.reflect.Array;
import java.util.Timer;
import junit.framework.Assert;

@Deprecated
public class CropImageNewUI
  extends MMActivity
{
  private boolean PCD = false;
  private int QpA = 0;
  private FilterImageView QpB;
  private LinearLayout QpC;
  private CropImageView QpD;
  private ImageView QpE;
  private View QpF;
  private boolean QpG = false;
  private boolean QpH = false;
  private final int Qpx = 1;
  private final int Qpy = 0;
  private int Qpz;
  private String filePath;
  private int gwE = 0;
  private int xlQ = 0;
  
  private static Bitmap a(float[][] paramArrayOfFloat, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, CropImageView paramCropImageView)
  {
    AppMethodBeat.i(39041);
    if (paramCropImageView == null)
    {
      AppMethodBeat.o(39041);
      return null;
    }
    float[] arrayOfFloat = n.a(paramArrayOfFloat, new float[] { paramFloat1, paramFloat2, 1.0F });
    paramArrayOfFloat = n.a(paramArrayOfFloat, new float[] { paramFloat3, paramFloat4, 1.0F });
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
        if (this.gwE == 1)
        {
          BitmapUtil.saveBitmapToImage(paramBitmap, 30, Bitmap.CompressFormat.JPEG, paramString, paramBoolean);
          AppMethodBeat.o(39042);
          return true;
        }
        if (this.gwE != 2) {
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
  
  private void b(Runnable paramRunnable1, Runnable paramRunnable2)
  {
    AppMethodBeat.i(39038);
    this.QpB = ((FilterImageView)findViewById(2131299346));
    this.QpB.setOnConfirmImp(paramRunnable1);
    this.QpB.setOnExitImp(paramRunnable2);
    AppMethodBeat.o(39038);
  }
  
  private boolean gXz()
  {
    AppMethodBeat.i(39037);
    Object localObject1;
    if (1 == this.Qpz) {
      if (this.QpB != null) {
        localObject1 = this.QpB.getCropAreaView();
      }
    }
    while (localObject1 == null)
    {
      AppMethodBeat.o(39037);
      return false;
      localObject1 = findViewById(2131299349);
      continue;
      localObject1 = findViewById(2131299348);
    }
    int n = ((View)localObject1).getWidth();
    int i1 = ((View)localObject1).getHeight();
    Log.v("MicroMsg.CropImageUI", "scrWidth:" + n + " scrHeight:" + i1);
    this.filePath = getIntent().getStringExtra("CropImage_ImgPath");
    if (!s.YS(this.filePath))
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
    if (this.Qpz == 2)
    {
      bool = true;
      j = i1;
      i = n;
      this.xlQ = BackwardSupportUtil.ExifHelper.getExifOrientation(this.filePath);
      if ((this.xlQ != 90) && (this.xlQ != 270)) {
        break label2275;
      }
    }
    for (;;)
    {
      Object localObject3 = BitmapUtil.extractThumbNail(this.filePath, i, j, bool);
      Object localObject2 = s.aW(this.filePath, 0, 10);
      if (ImgUtil.isGif((byte[])localObject2)) {}
      float f1;
      for (this.QpA = 1;; this.QpA = 0)
      {
        if (localObject3 != null) {
          break label908;
        }
        finish();
        AppMethodBeat.o(39037);
        return false;
        if (this.Qpz == 3)
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
            localObject2 = (Button)findViewById(2131299351);
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
        if (this.Qpz == 1)
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
        if ((af.isLongHorizontal(((BitmapFactory.Options)localObject2).outWidth, ((BitmapFactory.Options)localObject2).outHeight)) && (((BitmapFactory.Options)localObject2).outWidth > 480))
        {
          bool = true;
          label770:
          this.QpG = bool;
          if ((!af.isLongVertical(((BitmapFactory.Options)localObject2).outWidth, ((BitmapFactory.Options)localObject2).outHeight)) || (((BitmapFactory.Options)localObject2).outHeight <= 480)) {
            break label894;
          }
        }
        label894:
        for (bool = true;; bool = false)
        {
          this.PCD = bool;
          if (!this.QpG)
          {
            j = m;
            i = k;
            if (!this.PCD) {}
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
      Bitmap localBitmap = BitmapUtil.rotate((Bitmap)localObject3, this.xlQ);
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
        if (1 == this.Qpz)
        {
          if (this.QpB != null)
          {
            this.QpB.setMatrix((Matrix)localObject3);
            this.QpB.setImage(localBitmap);
          }
          label1101:
          if (this.Qpz != 3) {
            break label2210;
          }
          if (!ImgUtil.isGif((byte[])localObject2)) {
            break label2202;
          }
          this.QpA = 1;
        }
        try
        {
          localObject1 = c.dXx().hT(this.filePath, this.filePath);
          this.QpD.setImageDrawable((Drawable)localObject1);
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
          this.QpD.setImageMatrix((Matrix)localObject3);
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
          if (1 == this.Qpz)
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
            if (3 == this.Qpz) {
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
            if (1 == this.Qpz)
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
              if (1 != this.Qpz) {
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
            if (this.QpA == 1)
            {
              this.QpD.setGifPath(this.filePath);
              this.QpD.getGifWidth();
              this.QpD.getGifHeight();
              f1 = this.QpD.getGifWidth() / n;
              f2 = this.QpD.getGifHeight() / i1;
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
        ((Matrix)localObject3).postTranslate((n - this.QpD.getGifWidth() * f1) / 2.0F, (i1 - f1 * this.QpD.getGifHeight()) / 2.0F);
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
        if (this.QpA == 1) {
          break label1101;
        }
        this.QpD.setImageMatrix((Matrix)localObject3);
        this.QpD.setImageBitmap(localBitmap);
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
        this.QpA = 0;
        break label1267;
        label2210:
        if ((this.QpG) || (this.PCD)) {
          findViewById(2131299358).setVisibility(8);
        }
        if (getIntent().getBooleanExtra("CropImage_DirectlyIntoFilter", false)) {
          findViewById(2131299350).setVisibility(8);
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
  
  private static float[][] j(Matrix paramMatrix)
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
  
  private Bitmap lr(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(39040);
    Bitmap localBitmap = BitmapUtil.extractThumbNail(this.filePath, paramInt2, paramInt1, true);
    Object localObject = localBitmap;
    if (this.xlQ != 0)
    {
      localObject = new Matrix();
      ((Matrix)localObject).reset();
      ((Matrix)localObject).setRotate(this.xlQ, localBitmap.getWidth() / 2, localBitmap.getHeight() / 2);
      localObject = Bitmap.createBitmap(localBitmap, 0, 0, localBitmap.getWidth(), localBitmap.getHeight(), (Matrix)localObject, true);
      if (localBitmap != localObject)
      {
        Log.i("MicroMsg.CropImageUI", "recycle bitmap:%s", new Object[] { localBitmap.toString() });
        localBitmap.recycle();
      }
    }
    Log.d("MicroMsg.CropImageUI", "getcrop degree:" + this.xlQ);
    AppMethodBeat.o(39040);
    return localObject;
  }
  
  public void activateBroadcast(boolean paramBoolean)
  {
    AppMethodBeat.i(39032);
    if (paramBoolean)
    {
      aa.d(paramBoolean, new Intent().putExtra("classname", getClass().getName()).putExtra("main_process", false));
      AppMethodBeat.o(39032);
      return;
    }
    super.activateBroadcast(paramBoolean);
    AppMethodBeat.o(39032);
  }
  
  public int getLayoutId()
  {
    return 2131493807;
  }
  
  public void initView()
  {
    AppMethodBeat.i(39035);
    setMMTitle("");
    this.QpC = ((LinearLayout)findViewById(2131299356));
    this.QpE = ((ImageView)findViewById(2131299354));
    this.QpF = findViewById(2131299349);
    this.Qpz = getIntent().getIntExtra("CropImageMode", 0);
    final boolean bool1;
    final boolean bool2;
    Object localObject;
    Button localButton;
    if (this.Qpz != 0)
    {
      bool1 = true;
      Assert.assertTrue("the image mode must be set", bool1);
      this.gwE = getIntent().getIntExtra("CropImage_from_scene", 0);
      bool1 = getIntent().getBooleanExtra("CropImage_Filter", false);
      bool2 = getIntent().getBooleanExtra("CropImage_DirectlyIntoFilter", false);
      if (bool1) {
        b(new Runnable()new Runnable
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
              if (CropImageNewUI.e(CropImageNewUI.this).findViewById(2131299342).getVisibility() == 0) {
                bool = true;
              }
              ((SharedPreferences.Editor)localObject1).putBoolean("CropImage_Filter_Show", bool);
              ((SharedPreferences.Editor)localObject1).commit();
            }
            Object localObject2 = CropImageNewUI.this.getIntent().getStringExtra("CropImage_OutputPath");
            Object localObject1 = localObject2;
            if (localObject2 == null) {
              localObject1 = com.tencent.mm.loader.j.b.aKV() + g.getMessageDigest(new StringBuilder().append(CropImageNewUI.o(CropImageNewUI.this)).append(System.currentTimeMillis()).toString().getBytes()) + "_fiter.jpg";
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
      this.QpH = false;
      this.QpD = ((CropImageView)findViewById(2131299357));
      this.QpD.post(new Runnable()
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
              CropImageNewUI.e(CropImageNewUI.this).findViewById(2131299342).setVisibility(4);
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
      this.QpD.setOnShortClick(new CropImageView.a()
      {
        public final void gXA()
        {
          AppMethodBeat.i(39017);
          CropImageNewUI.h(CropImageNewUI.this);
          AppMethodBeat.o(39017);
        }
      });
      ((Button)findViewById(2131299358)).setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(39009);
          Object localObject = new com.tencent.mm.hellhoundlib.b.b();
          ((com.tencent.mm.hellhoundlib.b.b)localObject).bm(paramAnonymousView);
          a.b("com/tencent/mm/ui/tools/CropImageNewUI$12", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).axR());
          paramAnonymousView = CropImageNewUI.j(CropImageNewUI.this);
          if (paramAnonymousView.xqp == null) {
            Log.w("MicroMsg.CropImageView", "rotate not done! cause: btmp is null!");
          }
          for (;;)
          {
            a.a(this, "com/tencent/mm/ui/tools/CropImageNewUI$12", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(39009);
            return;
            localObject = new float[2];
            localObject[0] = (paramAnonymousView.xqp.getWidth() / 2);
            localObject[1] = (paramAnonymousView.xqp.getHeight() / 2);
            paramAnonymousView.getImageMatrix().mapPoints((float[])localObject);
            paramAnonymousView.getImageMatrix().postRotate(90.0F, localObject[0], localObject[1]);
            paramAnonymousView.setImageBitmap(paramAnonymousView.xqp);
            paramAnonymousView.invalidate();
            paramAnonymousView.dQd += 1;
          }
        }
      });
      localObject = (Button)findViewById(2131299359);
      ((Button)localObject).setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(39010);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bm(paramAnonymousView);
          a.b("com/tencent/mm/ui/tools/CropImageNewUI$13", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
          CropImageNewUI.j(CropImageNewUI.this).zoomIn();
          a.a(this, "com/tencent/mm/ui/tools/CropImageNewUI$13", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(39010);
        }
      });
      localButton = (Button)findViewById(2131299360);
      localButton.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(39011);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bm(paramAnonymousView);
          a.b("com/tencent/mm/ui/tools/CropImageNewUI$14", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
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
      switch (this.Qpz)
      {
      case 4: 
      default: 
        label372:
        Log.d("MicroMsg.CropImageUI", "mode is  " + this.Qpz);
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
        if (this.Qpz == 5) {
          addIconOptionMenu(0, 2131690843, (MenuItem.OnMenuItemClickListener)localObject);
        }
        break;
      }
    }
    for (;;)
    {
      if ((bool1) && (bool2)) {
        addTextOptionMenu(0, getString(2131758216), (MenuItem.OnMenuItemClickListener)localObject, null, t.b.OGU);
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
      if (this.Qpz == 6)
      {
        findViewById(2131299350).setVisibility(8);
        addTextOptionMenu(0, getString(2131758220), new MenuItem.OnMenuItemClickListener()
        {
          public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
          {
            AppMethodBeat.i(39026);
            paramAnonymousMenuItem = new e(CropImageNewUI.this, 1, false);
            paramAnonymousMenuItem.HLX = new o.f()
            {
              public final void onCreateMMMenu(m paramAnonymous2m)
              {
                AppMethodBeat.i(39024);
                paramAnonymous2m.kV(0, 2131758225);
                paramAnonymous2m.kV(1, 2131758229);
                AppMethodBeat.o(39024);
              }
            };
            paramAnonymousMenuItem.HLY = new o.g()
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
            paramAnonymousMenuItem.dGm();
            AppMethodBeat.o(39026);
            return true;
          }
        }, null, t.b.OGU);
      }
      AppMethodBeat.o(39035);
      return;
      bool1 = false;
      break;
      b(new Runnable()new Runnable
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
      this.QpB.setLimitZoomIn(false);
      localObject = this.QpB;
      if (((FilterImageView)localObject).Qqz != null)
      {
        ((FilterImageView)localObject).Qqz.setScaleType(ImageView.ScaleType.MATRIX);
        ((FilterImageView)localObject).Qqz.gXB();
      }
      this.QpB.setCropMaskVisible(0);
      if (this.gwE != 1) {
        break label372;
      }
      this.QpB.setCropMaskBackground(2131234246);
      break label372;
      this.QpD.setEnableOprate(false);
      findViewById(2131299341).setVisibility(8);
      findViewById(2131299350).setVisibility(8);
      break label372;
      this.QpC.setVisibility(8);
      break label372;
      int i = getIntent().getIntExtra("CropImage_CompressType", 1);
      boolean bool3 = getIntent().getBooleanExtra("CropImage_BHasHD", false);
      if ((i != 1) && (bool3))
      {
        findViewById(2131299350).setVisibility(0);
        localObject = (Button)findViewById(2131299351);
        ((Button)localObject).setBackgroundResource(2131231441);
        ((Button)localObject).setPadding(25, 8, 25, 8);
        ((Button)localObject).setOnClickListener(new CropImageNewUI.11(this));
        break label372;
      }
      findViewById(2131299350).setVisibility(8);
      break label372;
      if (this.Qpz == 4)
      {
        addIconOptionMenu(0, 2131690843, (MenuItem.OnMenuItemClickListener)localObject);
        findViewById(2131299350).setVisibility(0);
        localButton = (Button)findViewById(2131299351);
        localButton.setText(2131758216);
        localButton.setOnClickListener(new CropImageNewUI.18(this));
      }
      else
      {
        addTextOptionMenu(0, getString(2131758220), (MenuItem.OnMenuItemClickListener)localObject, null, t.b.OGU);
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
      this.QpD.post(new Runnable()
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
    if (this.QpD != null)
    {
      localObject = this.QpD;
      if ((((CropImageView)localObject).xqp != null) && (!((CropImageView)localObject).xqp.isRecycled()))
      {
        Log.i("MicroMsg.CropImageView", "recycle bitmap:%s", new Object[] { ((CropImageView)localObject).xqp.toString() });
        ((CropImageView)localObject).xqp.recycle();
      }
      if (((CropImageView)localObject).Qqh != null)
      {
        ((CropImageView)localObject).Qqh.cancel();
        ((CropImageView)localObject).Qqh = null;
      }
      ((CropImageView)localObject).Qqi.removeCallbacksAndMessages(null);
      ((CropImageView)localObject).Qqk.removeCallbacksAndMessages(null);
    }
    if (this.QpB != null)
    {
      localObject = this.QpB;
      ((FilterImageView)localObject).Qqw = null;
      if ((((FilterImageView)localObject).QqA != null) && (!((FilterImageView)localObject).QqA.isRecycled()))
      {
        Log.i("MicroMsg.FilterView", "recycle bitmap:%s", new Object[] { ((FilterImageView)localObject).QqA.toString() });
        ((FilterImageView)localObject).QqA.recycle();
      }
      ((FilterImageView)localObject).QqA = null;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.tools.CropImageNewUI
 * JD-Core Version:    0.7.0.1
 */