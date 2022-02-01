package com.tencent.mm.ui.tools;

import android.app.Activity;
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
import com.tencent.mm.b.g;
import com.tencent.mm.graphics.MMBitmapFactory;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.platformtools.af;
import com.tencent.mm.plugin.gif.c;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.ExifHelper;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.aw;
import com.tencent.mm.sdk.platformtools.aw.a;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.sdk.platformtools.h;
import com.tencent.mm.sdk.platformtools.u;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h.c;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.base.n.e;
import com.tencent.mm.ui.base.y;
import com.tencent.mm.ui.s.b;
import com.tencent.mm.ui.widget.a.e;
import com.tencent.mm.vfs.o;
import java.lang.reflect.Array;
import java.util.Timer;
import junit.framework.Assert;

@Deprecated
public class CropImageNewUI
  extends MMActivity
{
  private boolean Kqu = false;
  private FilterImageView LaA;
  private LinearLayout LaB;
  private CropImageView LaC;
  private ImageView LaD;
  private View LaE;
  private boolean LaF = false;
  private boolean LaG = false;
  private final int Law = 1;
  private final int Lax = 0;
  private int Lay;
  private int Laz = 0;
  private int fRv = 0;
  private String filePath;
  private int tUE = 0;
  
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
      ae.i("MicroMsg.CropImageUI", "rawWidth:%d, rawHeigth:%d, originalLX:%d, originalTY:%d, realWidth:%d, realHeight:%d", new Object[] { Integer.valueOf(paramCropImageView.getWidth()), Integer.valueOf(paramCropImageView.getHeight()), Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(m) });
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
        if (this.fRv == 1)
        {
          h.a(paramBitmap, 30, Bitmap.CompressFormat.JPEG, paramString, paramBoolean);
          AppMethodBeat.o(39042);
          return true;
        }
        if (this.fRv != 2) {
          break label118;
        }
        h.a(paramBitmap, 80, Bitmap.CompressFormat.JPEG, paramString, paramBoolean);
        continue;
        AppMethodBeat.o(39042);
      }
      catch (Exception paramBitmap)
      {
        ae.printErrStackTrace("MicroMsg.CropImageUI", paramBitmap, "", new Object[0]);
        ae.e("MicroMsg.CropImageUI", "saveBitmapToImage failed:" + paramBitmap.toString());
      }
      return false;
      label118:
      h.a(paramBitmap, 100, Bitmap.CompressFormat.JPEG, paramString, paramBoolean);
    }
  }
  
  private void b(Runnable paramRunnable1, Runnable paramRunnable2)
  {
    AppMethodBeat.i(39038);
    this.LaA = ((FilterImageView)findViewById(2131298871));
    this.LaA.setOnConfirmImp(paramRunnable1);
    this.LaA.setOnExitImp(paramRunnable2);
    AppMethodBeat.o(39038);
  }
  
  private boolean fOG()
  {
    AppMethodBeat.i(39037);
    Object localObject1;
    if (1 == this.Lay) {
      if (this.LaA != null) {
        localObject1 = this.LaA.getCropAreaView();
      }
    }
    while (localObject1 == null)
    {
      AppMethodBeat.o(39037);
      return false;
      localObject1 = findViewById(2131298874);
      continue;
      localObject1 = findViewById(2131298873);
    }
    int n = ((View)localObject1).getWidth();
    int i1 = ((View)localObject1).getHeight();
    ae.v("MicroMsg.CropImageUI", "scrWidth:" + n + " scrHeight:" + i1);
    this.filePath = getIntent().getStringExtra("CropImage_ImgPath");
    if (!o.fB(this.filePath))
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
    if (this.Lay == 2)
    {
      bool = true;
      j = i1;
      i = n;
      this.tUE = BackwardSupportUtil.ExifHelper.df(this.filePath);
      if ((this.tUE != 90) && (this.tUE != 270)) {
        break label2273;
      }
    }
    for (;;)
    {
      Object localObject3 = h.d(this.filePath, i, j, bool);
      Object localObject2 = o.bb(this.filePath, 0, 10);
      if (u.cw((byte[])localObject2)) {}
      float f1;
      for (this.Laz = 1;; this.Laz = 0)
      {
        if (localObject3 != null) {
          break label906;
        }
        finish();
        AppMethodBeat.o(39037);
        return false;
        if (this.Lay == 3)
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
            ae.d("MicroMsg.CropImageUI", "w:%d h:%d width:%d height:%d scale:%f", new Object[] { Integer.valueOf(k), Integer.valueOf(m), Integer.valueOf(j), Integer.valueOf(i), Float.valueOf(f1) });
            localObject2 = (Button)findViewById(2131298876);
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
        if (this.Lay == 1)
        {
          localObject2 = new BitmapFactory.Options();
          ((BitmapFactory.Options)localObject2).inJustDecodeBounds = true;
          localObject3 = MMBitmapFactory.decodeFile(this.filePath, (BitmapFactory.Options)localObject2);
          if (localObject3 != null)
          {
            ae.i("MicroMsg.CropImageUI", "recycle bitmap:%s", new Object[] { localObject3.toString() });
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
        h.fnS();
        localObject3 = MMBitmapFactory.decodeFile(this.filePath, (BitmapFactory.Options)localObject2);
        if (localObject3 != null)
        {
          ae.i("MicroMsg.CropImageUI", "recycle bitmap:%s", new Object[] { localObject3.toString() });
          ((Bitmap)localObject3).recycle();
        }
        if ((af.dx(((BitmapFactory.Options)localObject2).outWidth, ((BitmapFactory.Options)localObject2).outHeight)) && (((BitmapFactory.Options)localObject2).outWidth > 480))
        {
          bool = true;
          label768:
          this.LaF = bool;
          if ((!af.dw(((BitmapFactory.Options)localObject2).outWidth, ((BitmapFactory.Options)localObject2).outHeight)) || (((BitmapFactory.Options)localObject2).outHeight <= 480)) {
            break label892;
          }
        }
        label892:
        for (bool = true;; bool = false)
        {
          this.Kqu = bool;
          if (!this.LaF)
          {
            j = m;
            i = k;
            if (!this.Kqu) {}
          }
          else
          {
            j = ((BitmapFactory.Options)localObject2).outHeight;
            i = ((BitmapFactory.Options)localObject2).outWidth;
          }
          ae.e("MicroMsg.CropImageUI", "width is " + i + " height is " + j);
          bool = false;
          break;
          bool = false;
          break label768;
        }
      }
      label906:
      ae.d("temBmp crop", "h:" + ((Bitmap)localObject3).getHeight() + "w: " + ((Bitmap)localObject3).getWidth());
      Bitmap localBitmap = h.a((Bitmap)localObject3, this.tUE);
      localObject3 = new Matrix();
      ((Matrix)localObject3).reset();
      float f4 = 1.0F;
      float f2;
      label1020:
      float f3;
      if (bool)
      {
        f1 = localBitmap.getWidth() / n;
        f2 = localBitmap.getHeight() / i1;
        if (f1 < f2)
        {
          if (n <= i1) {
            break label1278;
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
        if (1 == this.Lay)
        {
          if (this.LaA != null)
          {
            this.LaA.setMatrix((Matrix)localObject3);
            this.LaA.setImage(localBitmap);
          }
          label1099:
          if (this.Lay != 3) {
            break label2208;
          }
          if (!u.cw((byte[])localObject2)) {
            break label2200;
          }
          this.Laz = 1;
        }
        try
        {
          localObject1 = c.ddO().hm(this.filePath, this.filePath);
          this.LaC.setImageDrawable((Drawable)localObject1);
          ((com.tencent.mm.plugin.gif.b)localObject1).start();
          ((Matrix)localObject3).reset();
          i = ((com.tencent.mm.plugin.gif.b)localObject1).getIntrinsicWidth();
          j = ((com.tencent.mm.plugin.gif.b)localObject1).getIntrinsicHeight();
          f1 = n / i;
          f2 = i1 / j;
          if (f1 >= f2) {
            break label2150;
          }
          label1191:
          f2 = i / n;
          f3 = j / i1;
          if (f2 <= f3) {
            break label2155;
          }
          label1213:
          if (f2 <= 1.0D) {
            break label2160;
          }
          ((Matrix)localObject3).postScale(f1, f1);
          ((Matrix)localObject3).postTranslate((n - i * f1) / 2.0F, (i1 - f1 * j) / 2.0F);
          label1256:
          this.LaC.setImageMatrix((Matrix)localObject3);
        }
        catch (Exception localException)
        {
          for (;;)
          {
            label1265:
            ae.e("MicroMsg.CropImageUI", bu.o(localException));
          }
        }
        AppMethodBeat.o(39037);
        return true;
        f1 = f2;
        break;
        label1278:
        f2 = n;
        break label1020;
        f1 = localBitmap.getWidth() / localBitmap.getHeight();
        f2 = localBitmap.getHeight() / localBitmap.getWidth();
        ae.v("MicroMsg.CropImageUI", "whDiv is " + f1 + " hwDiv is " + f2);
        if ((f2 >= 2.0F) && (localBitmap.getHeight() >= 480))
        {
          f2 = localBitmap.getWidth() / n;
          f1 = n / localBitmap.getWidth();
          if (1 == this.Lay)
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
            if (3 == this.Lay) {
              ((Matrix)localObject3).postTranslate((n - localBitmap.getWidth()) / 2, (i1 - localBitmap.getHeight()) / 2);
            } else {
              ((Matrix)localObject3).postTranslate((n - localBitmap.getWidth()) / 2, 0.0F);
            }
          }
        }
        else
        {
          label1820:
          label1970:
          if ((f1 >= 2.0F) && (localBitmap.getWidth() >= 480))
          {
            f1 = localBitmap.getHeight() / 480.0F;
            f2 = 480.0F / localBitmap.getHeight();
            if (1 == this.Lay)
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
              ae.d("MicroMsg.CropImageUI", " offsety ".concat(String.valueOf(f1)));
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
                break label1898;
              }
            }
            for (;;)
            {
              if (1 != this.Lay) {
                break label1903;
              }
              ((Matrix)localObject3).postScale(f2, f2);
              ((Matrix)localObject3).postTranslate((n - localBitmap.getWidth() * f2) / 2.0F + ((View)localObject1).getLeft(), (i1 - f2 * localBitmap.getHeight()) / 2.0F + ((View)localObject1).getTop());
              break;
              f1 = f3;
              break label1820;
              label1898:
              f2 = f3;
            }
            label1903:
            if (this.Laz == 1)
            {
              this.LaC.setGifPath(this.filePath);
              this.LaC.getGifWidth();
              this.LaC.getGifHeight();
              f1 = this.LaC.getGifWidth() / n;
              f2 = this.LaC.getGifHeight() / i1;
              if (f1 > f2)
              {
                if (f1 <= 1.0D) {
                  break label2268;
                }
                ((Matrix)localObject3).postScale(f1, f1);
              }
            }
          }
        }
      }
      for (;;)
      {
        ((Matrix)localObject3).postTranslate((n - this.LaC.getGifWidth() * f1) / 2.0F, (i1 - f1 * this.LaC.getGifHeight()) / 2.0F);
        break;
        f1 = f2;
        break label1970;
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
        if (this.Laz == 1) {
          break label1099;
        }
        this.LaC.setImageMatrix((Matrix)localObject3);
        this.LaC.setImageBitmap(localBitmap);
        break label1099;
        label2150:
        f1 = f2;
        break label1191;
        label2155:
        f2 = f3;
        break label1213;
        label2160:
        ((Matrix)localObject3).postTranslate((n - i) / 2, (i1 - j) / 2);
        break label1256;
        label2200:
        this.Laz = 0;
        break label1265;
        label2208:
        if ((this.LaF) || (this.Kqu)) {
          findViewById(2131298883).setVisibility(8);
        }
        if (getIntent().getBooleanExtra("CropImage_DirectlyIntoFilter", false)) {
          findViewById(2131298875).setVisibility(8);
        }
        AppMethodBeat.o(39037);
        return true;
        label2268:
        f1 = 1.0F;
      }
      label2273:
      k = i;
      i = j;
      j = k;
    }
  }
  
  private static float[][] i(Matrix paramMatrix)
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
  
  private Bitmap kf(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(39040);
    Bitmap localBitmap = h.d(this.filePath, paramInt2, paramInt1, true);
    Object localObject = localBitmap;
    if (this.tUE != 0)
    {
      localObject = new Matrix();
      ((Matrix)localObject).reset();
      ((Matrix)localObject).setRotate(this.tUE, localBitmap.getWidth() / 2, localBitmap.getHeight() / 2);
      localObject = Bitmap.createBitmap(localBitmap, 0, 0, localBitmap.getWidth(), localBitmap.getHeight(), (Matrix)localObject, true);
      if (localBitmap != localObject)
      {
        ae.i("MicroMsg.CropImageUI", "recycle bitmap:%s", new Object[] { localBitmap.toString() });
        localBitmap.recycle();
      }
    }
    ae.d("MicroMsg.CropImageUI", "getcrop degree:" + this.tUE);
    AppMethodBeat.o(39040);
    return localObject;
  }
  
  public void activateBroadcast(boolean paramBoolean)
  {
    AppMethodBeat.i(39032);
    if (paramBoolean)
    {
      y.d(paramBoolean, new Intent().putExtra("classname", getClass().getName()).putExtra("main_process", false));
      AppMethodBeat.o(39032);
      return;
    }
    super.activateBroadcast(paramBoolean);
    AppMethodBeat.o(39032);
  }
  
  public int getLayoutId()
  {
    return 2131493676;
  }
  
  public void initView()
  {
    AppMethodBeat.i(39035);
    setMMTitle("");
    this.LaB = ((LinearLayout)findViewById(2131298881));
    this.LaD = ((ImageView)findViewById(2131298879));
    this.LaE = findViewById(2131298874);
    this.Lay = getIntent().getIntExtra("CropImageMode", 0);
    final boolean bool1;
    final boolean bool2;
    Object localObject;
    Button localButton;
    if (this.Lay != 0)
    {
      bool1 = true;
      Assert.assertTrue("the image mode must be set", bool1);
      this.fRv = getIntent().getIntExtra("CropImage_from_scene", 0);
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
              localObject1 = CropImageNewUI.this.getSharedPreferences(ak.fow(), 0).edit();
              if (CropImageNewUI.e(CropImageNewUI.this).findViewById(2131298867).getVisibility() == 0) {
                bool = true;
              }
              ((SharedPreferences.Editor)localObject1).putBoolean("CropImage_Filter_Show", bool);
              ((SharedPreferences.Editor)localObject1).commit();
            }
            Object localObject2 = CropImageNewUI.this.getIntent().getStringExtra("CropImage_OutputPath");
            Object localObject1 = localObject2;
            if (localObject2 == null) {
              localObject1 = com.tencent.mm.loader.j.b.asv() + g.getMessageDigest(new StringBuilder().append(CropImageNewUI.o(CropImageNewUI.this)).append(System.currentTimeMillis()).toString().getBytes()) + "_fiter.jpg";
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
      this.LaG = false;
      this.LaC = ((CropImageView)findViewById(2131298882));
      this.LaC.post(new Runnable()
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
            if (!CropImageNewUI.this.getSharedPreferences(ak.fow(), 0).getBoolean("CropImage_Filter_Show", true)) {
              CropImageNewUI.e(CropImageNewUI.this).findViewById(2131298867).setVisibility(4);
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
      this.LaC.setOnShortClick(new CropImageView.a()
      {
        public final void fOH()
        {
          AppMethodBeat.i(39017);
          CropImageNewUI.h(CropImageNewUI.this);
          AppMethodBeat.o(39017);
        }
      });
      ((Button)findViewById(2131298883)).setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(39009);
          Object localObject = new com.tencent.mm.hellhoundlib.b.b();
          ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymousView);
          a.b("com/tencent/mm/ui/tools/CropImageNewUI$12", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahF());
          paramAnonymousView = CropImageNewUI.j(CropImageNewUI.this);
          if (paramAnonymousView.tZb == null) {
            ae.w("MicroMsg.CropImageView", "rotate not done! cause: btmp is null!");
          }
          for (;;)
          {
            a.a(this, "com/tencent/mm/ui/tools/CropImageNewUI$12", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(39009);
            return;
            localObject = new float[2];
            localObject[0] = (paramAnonymousView.tZb.getWidth() / 2);
            localObject[1] = (paramAnonymousView.tZb.getHeight() / 2);
            paramAnonymousView.getImageMatrix().mapPoints((float[])localObject);
            paramAnonymousView.getImageMatrix().postRotate(90.0F, localObject[0], localObject[1]);
            paramAnonymousView.setImageBitmap(paramAnonymousView.tZb);
            paramAnonymousView.invalidate();
            paramAnonymousView.dyw += 1;
          }
        }
      });
      localObject = (Button)findViewById(2131298884);
      ((Button)localObject).setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(39010);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          a.b("com/tencent/mm/ui/tools/CropImageNewUI$13", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
          CropImageNewUI.j(CropImageNewUI.this).zoomIn();
          a.a(this, "com/tencent/mm/ui/tools/CropImageNewUI$13", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(39010);
        }
      });
      localButton = (Button)findViewById(2131298885);
      localButton.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(39011);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          a.b("com/tencent/mm/ui/tools/CropImageNewUI$14", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
          CropImageNewUI.j(CropImageNewUI.this).zoomOut();
          a.a(this, "com/tencent/mm/ui/tools/CropImageNewUI$14", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(39011);
        }
      });
      aw localaw1 = new aw(new aw.a()
      {
        public final boolean onTimerExpired()
        {
          AppMethodBeat.i(39012);
          CropImageNewUI.j(CropImageNewUI.this).zoomIn();
          AppMethodBeat.o(39012);
          return true;
        }
      }, true);
      aw localaw2 = new aw(new aw.a()
      {
        public final boolean onTimerExpired()
        {
          AppMethodBeat.i(39013);
          CropImageNewUI.j(CropImageNewUI.this).zoomOut();
          AppMethodBeat.o(39013);
          return true;
        }
      }, true);
      ((Button)localObject).setOnTouchListener(new CropImageNewUI.9(this, localaw1));
      localButton.setOnTouchListener(new CropImageNewUI.10(this, localaw2));
      switch (this.Lay)
      {
      case 4: 
      default: 
        label372:
        ae.d("MicroMsg.CropImageUI", "mode is  " + this.Lay);
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
        if (this.Lay == 5) {
          addIconOptionMenu(0, 2131690603, (MenuItem.OnMenuItemClickListener)localObject);
        }
        break;
      }
    }
    for (;;)
    {
      if ((bool1) && (bool2)) {
        addTextOptionMenu(0, getString(2131757967), (MenuItem.OnMenuItemClickListener)localObject, null, s.b.JwA);
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
      if (this.Lay == 6)
      {
        findViewById(2131298875).setVisibility(8);
        addTextOptionMenu(0, getString(2131757971), new MenuItem.OnMenuItemClickListener()
        {
          public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
          {
            AppMethodBeat.i(39026);
            paramAnonymousMenuItem = new e(CropImageNewUI.this, 1, false);
            paramAnonymousMenuItem.LfS = new n.d()
            {
              public final void onCreateMMMenu(l paramAnonymous2l)
              {
                AppMethodBeat.i(39024);
                paramAnonymous2l.jM(0, 2131757976);
                paramAnonymous2l.jM(1, 2131757980);
                AppMethodBeat.o(39024);
              }
            };
            paramAnonymousMenuItem.LfT = new n.e()
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
            paramAnonymousMenuItem.cPF();
            AppMethodBeat.o(39026);
            return true;
          }
        }, null, s.b.JwA);
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
      this.LaA.setLimitZoomIn(false);
      localObject = this.LaA;
      if (((FilterImageView)localObject).Lby != null)
      {
        ((FilterImageView)localObject).Lby.setScaleType(ImageView.ScaleType.MATRIX);
        ((FilterImageView)localObject).Lby.fOI();
      }
      this.LaA.setCropMaskVisible(0);
      if (this.fRv != 1) {
        break label372;
      }
      this.LaA.setCropMaskBackground(2131233443);
      break label372;
      this.LaC.setEnableOprate(false);
      findViewById(2131298866).setVisibility(8);
      findViewById(2131298875).setVisibility(8);
      break label372;
      this.LaB.setVisibility(8);
      break label372;
      int i = getIntent().getIntExtra("CropImage_CompressType", 1);
      boolean bool3 = getIntent().getBooleanExtra("CropImage_BHasHD", false);
      if ((i != 1) && (bool3))
      {
        findViewById(2131298875).setVisibility(0);
        localObject = (Button)findViewById(2131298876);
        ((Button)localObject).setBackgroundResource(2131231377);
        ((Button)localObject).setPadding(25, 8, 25, 8);
        ((Button)localObject).setOnClickListener(new CropImageNewUI.11(this));
        break label372;
      }
      findViewById(2131298875).setVisibility(8);
      break label372;
      if (this.Lay == 4)
      {
        addIconOptionMenu(0, 2131690603, (MenuItem.OnMenuItemClickListener)localObject);
        findViewById(2131298875).setVisibility(0);
        localButton = (Button)findViewById(2131298876);
        localButton.setText(2131757967);
        localButton.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(39022);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.bd(paramAnonymousView);
            a.b("com/tencent/mm/ui/tools/CropImageNewUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
            CropImageNewUI.a(CropImageNewUI.this, true);
            a.a(this, "com/tencent/mm/ui/tools/CropImageNewUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(39022);
          }
        });
      }
      else
      {
        addTextOptionMenu(0, getString(2131757971), (MenuItem.OnMenuItemClickListener)localObject, null, s.b.JwA);
      }
    }
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(39036);
    ae.d("MicroMsg.CropImageUI", "onConfigurationChanged, config.orientation = " + paramConfiguration.orientation);
    if ((paramConfiguration.orientation == 1) || (paramConfiguration.orientation == 2))
    {
      ae.v("MicroMsg.CropImageUI", "onConfigurationChanged");
      this.LaC.post(new Runnable()
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
    if (this.LaC != null)
    {
      localObject = this.LaC;
      if ((((CropImageView)localObject).tZb != null) && (!((CropImageView)localObject).tZb.isRecycled()))
      {
        ae.i("MicroMsg.CropImageView", "recycle bitmap:%s", new Object[] { ((CropImageView)localObject).tZb.toString() });
        ((CropImageView)localObject).tZb.recycle();
      }
      if (((CropImageView)localObject).Lbg != null)
      {
        ((CropImageView)localObject).Lbg.cancel();
        ((CropImageView)localObject).Lbg = null;
      }
      ((CropImageView)localObject).Lbh.removeCallbacksAndMessages(null);
      ((CropImageView)localObject).Lbj.removeCallbacksAndMessages(null);
    }
    if (this.LaA != null)
    {
      localObject = this.LaA;
      ((FilterImageView)localObject).Lbv = null;
      if ((((FilterImageView)localObject).Lbz != null) && (!((FilterImageView)localObject).Lbz.isRecycled()))
      {
        ae.i("MicroMsg.FilterView", "recycle bitmap:%s", new Object[] { ((FilterImageView)localObject).Lbz.toString() });
        ((FilterImageView)localObject).Lbz.recycle();
      }
      ((FilterImageView)localObject).Lbz = null;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.tools.CropImageNewUI
 * JD-Core Version:    0.7.0.1
 */