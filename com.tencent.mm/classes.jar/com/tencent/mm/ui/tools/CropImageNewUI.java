package com.tencent.mm.ui.tools;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.platformtools.ah;
import com.tencent.mm.plugin.gif.b;
import com.tencent.mm.plugin.gif.c;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.ExifHelper;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.y;
import com.tencent.mm.ui.q.b;
import com.tencent.mm.vfs.e;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.util.Timer;
import junit.framework.Assert;

public class CropImageNewUI
  extends MMActivity
{
  private final int AqH = 1;
  private final int AqI = 0;
  private int AqJ;
  private int AqK = 0;
  private FilterImageView AqL;
  private LinearLayout AqM;
  private CropImageView AqN;
  private ImageView AqO;
  private View AqP;
  private int AqQ = 0;
  private boolean AqR = false;
  private boolean AqS = false;
  private boolean AqT = false;
  private int ejF = 0;
  private String filePath;
  
  private static Bitmap a(float[][] paramArrayOfFloat, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, CropImageView paramCropImageView)
  {
    AppMethodBeat.i(34852);
    if (paramCropImageView == null)
    {
      AppMethodBeat.o(34852);
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
      ab.i("MicroMsg.CropImageUI", "rawWidth:%d, rawHeigth:%d, originalLX:%d, originalTY:%d, realWidth:%d, realHeight:%d", new Object[] { Integer.valueOf(paramCropImageView.getWidth()), Integer.valueOf(paramCropImageView.getHeight()), Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(m) });
      paramArrayOfFloat = Bitmap.createBitmap(paramCropImageView, i, j, k, m, paramArrayOfFloat, true);
      AppMethodBeat.o(34852);
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
    AppMethodBeat.i(34853);
    if ((paramString != null) && (!paramString.equals(""))) {
      try
      {
        if (this.ejF == 1) {
          com.tencent.mm.sdk.platformtools.d.a(paramBitmap, 30, Bitmap.CompressFormat.JPEG, paramString, paramBoolean);
        }
        for (;;)
        {
          AppMethodBeat.o(34853);
          return true;
          com.tencent.mm.sdk.platformtools.d.a(paramBitmap, 100, Bitmap.CompressFormat.PNG, paramString, paramBoolean);
        }
        AppMethodBeat.o(34853);
      }
      catch (Exception paramBitmap)
      {
        ab.printErrStackTrace("MicroMsg.CropImageUI", paramBitmap, "", new Object[0]);
        ab.e("MicroMsg.CropImageUI", "saveBitmapToImage failed:" + paramBitmap.toString());
      }
    }
    return false;
  }
  
  private void b(Runnable paramRunnable1, Runnable paramRunnable2)
  {
    AppMethodBeat.i(34845);
    this.AqL = ((FilterImageView)findViewById(2131823288));
    com.tencent.mm.platformtools.r.cn(this.AqL);
    this.AqL.setOnConfirmImp(paramRunnable1);
    this.AqL.setOnExitImp(paramRunnable2);
    AppMethodBeat.o(34845);
  }
  
  private static float[][] c(Matrix paramMatrix)
  {
    AppMethodBeat.i(34854);
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
    AppMethodBeat.o(34854);
    return arrayOfFloat;
  }
  
  private boolean dNH()
  {
    AppMethodBeat.i(34844);
    Object localObject1;
    if (1 == this.AqJ) {
      if (this.AqL != null) {
        localObject1 = this.AqL.getCropAreaView();
      }
    }
    int n;
    int i1;
    for (;;)
    {
      n = ((View)localObject1).getWidth();
      i1 = ((View)localObject1).getHeight();
      ab.v("MicroMsg.CropImageUI", "scrWidth:" + n + " scrHeight:" + i1);
      this.filePath = getIntent().getStringExtra("CropImage_ImgPath");
      if (e.cN(this.filePath)) {
        break;
      }
      finish();
      AppMethodBeat.o(34844);
      return false;
      localObject1 = findViewById(2131823276);
      continue;
      localObject1 = findViewById(2131823279);
    }
    int k = 960;
    int m = 960;
    boolean bool;
    int j;
    int i;
    if (this.AqJ == 2)
    {
      bool = true;
      j = i1;
      i = n;
      this.AqQ = BackwardSupportUtil.ExifHelper.bY(this.filePath);
      if ((this.AqQ != 90) && (this.AqQ != 270)) {
        break label2260;
      }
    }
    for (;;)
    {
      Object localObject3 = com.tencent.mm.sdk.platformtools.d.d(this.filePath, i, j, bool);
      Object localObject2 = e.i(this.filePath, 0, 10);
      if (com.tencent.mm.sdk.platformtools.r.bV((byte[])localObject2)) {}
      float f1;
      for (this.AqK = 1;; this.AqK = 0)
      {
        if (localObject3 != null) {
          break label893;
        }
        finish();
        AppMethodBeat.o(34844);
        return false;
        if (this.AqJ == 3)
        {
          localObject2 = new BitmapFactory.Options();
          ((BitmapFactory.Options)localObject2).inJustDecodeBounds = true;
          localObject3 = BitmapFactory.decodeFile(this.filePath, (BitmapFactory.Options)localObject2);
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
            ab.d("MicroMsg.CropImageUI", "w:%d h:%d width:%d height:%d scale:%f", new Object[] { Integer.valueOf(k), Integer.valueOf(m), Integer.valueOf(j), Integer.valueOf(i), Float.valueOf(f1) });
            localObject2 = (Button)findViewById(2131823287);
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
        if (this.AqJ == 1)
        {
          localObject2 = new BitmapFactory.Options();
          ((BitmapFactory.Options)localObject2).inJustDecodeBounds = true;
          localObject3 = BitmapFactory.decodeFile(this.filePath, (BitmapFactory.Options)localObject2);
          if (localObject3 != null)
          {
            ab.i("MicroMsg.CropImageUI", "recycle bitmap:%s", new Object[] { localObject3.toString() });
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
        com.tencent.mm.sdk.platformtools.d.dsm();
        localObject3 = BitmapFactory.decodeFile(this.filePath, (BitmapFactory.Options)localObject2);
        if (localObject3 != null)
        {
          ab.i("MicroMsg.CropImageUI", "recycle bitmap:%s", new Object[] { localObject3.toString() });
          ((Bitmap)localObject3).recycle();
        }
        if ((ah.cO(((BitmapFactory.Options)localObject2).outWidth, ((BitmapFactory.Options)localObject2).outHeight)) && (((BitmapFactory.Options)localObject2).outWidth > 480))
        {
          bool = true;
          label755:
          this.AqR = bool;
          if ((!ah.cN(((BitmapFactory.Options)localObject2).outWidth, ((BitmapFactory.Options)localObject2).outHeight)) || (((BitmapFactory.Options)localObject2).outHeight <= 480)) {
            break label879;
          }
        }
        label879:
        for (bool = true;; bool = false)
        {
          this.AqS = bool;
          if (!this.AqR)
          {
            j = m;
            i = k;
            if (!this.AqS) {}
          }
          else
          {
            j = ((BitmapFactory.Options)localObject2).outHeight;
            i = ((BitmapFactory.Options)localObject2).outWidth;
          }
          ab.e("MicroMsg.CropImageUI", "width is " + i + " height is " + j);
          bool = false;
          break;
          bool = false;
          break label755;
        }
      }
      label893:
      ab.d("temBmp crop", "h:" + ((Bitmap)localObject3).getHeight() + "w: " + ((Bitmap)localObject3).getWidth());
      Bitmap localBitmap = com.tencent.mm.sdk.platformtools.d.b((Bitmap)localObject3, this.AqQ);
      localObject3 = new Matrix();
      ((Matrix)localObject3).reset();
      float f4 = 1.0F;
      float f2;
      label1007:
      float f3;
      if (bool)
      {
        f1 = localBitmap.getWidth() / n;
        f2 = localBitmap.getHeight() / i1;
        if (f1 < f2)
        {
          if (n <= i1) {
            break label1265;
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
        if (1 == this.AqJ)
        {
          if (this.AqL != null)
          {
            this.AqL.setMatrix((Matrix)localObject3);
            this.AqL.setImage(localBitmap);
          }
          label1086:
          if (this.AqJ != 3) {
            break label2195;
          }
          if (!com.tencent.mm.sdk.platformtools.r.bV((byte[])localObject2)) {
            break label2187;
          }
          this.AqK = 1;
        }
        try
        {
          localObject1 = c.bHK().eK(this.filePath, this.filePath);
          this.AqN.setImageDrawable((Drawable)localObject1);
          ((b)localObject1).start();
          ((Matrix)localObject3).reset();
          i = ((b)localObject1).getIntrinsicWidth();
          j = ((b)localObject1).getIntrinsicHeight();
          f1 = n / i;
          f2 = i1 / j;
          if (f1 >= f2) {
            break label2137;
          }
          label1178:
          f2 = i / n;
          f3 = j / i1;
          if (f2 <= f3) {
            break label2142;
          }
          label1200:
          if (f2 <= 1.0D) {
            break label2147;
          }
          ((Matrix)localObject3).postScale(f1, f1);
          ((Matrix)localObject3).postTranslate((n - i * f1) / 2.0F, (i1 - f1 * j) / 2.0F);
          label1243:
          this.AqN.setImageMatrix((Matrix)localObject3);
        }
        catch (Exception localException)
        {
          for (;;)
          {
            label1252:
            ab.e("MicroMsg.CropImageUI", bo.l(localException));
          }
        }
        AppMethodBeat.o(34844);
        return true;
        f1 = f2;
        break;
        label1265:
        f2 = n;
        break label1007;
        f1 = localBitmap.getWidth() / localBitmap.getHeight();
        f2 = localBitmap.getHeight() / localBitmap.getWidth();
        ab.v("MicroMsg.CropImageUI", "whDiv is " + f1 + " hwDiv is " + f2);
        if ((f2 >= 2.0F) && (localBitmap.getHeight() >= 480))
        {
          f2 = localBitmap.getWidth() / n;
          f1 = n / localBitmap.getWidth();
          if (1 == this.AqJ)
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
            if (3 == this.AqJ) {
              ((Matrix)localObject3).postTranslate((n - localBitmap.getWidth()) / 2, (i1 - localBitmap.getHeight()) / 2);
            } else {
              ((Matrix)localObject3).postTranslate((n - localBitmap.getWidth()) / 2, 0.0F);
            }
          }
        }
        else
        {
          label1807:
          label1957:
          if ((f1 >= 2.0F) && (localBitmap.getWidth() >= 480))
          {
            f1 = localBitmap.getHeight() / 480.0F;
            f2 = 480.0F / localBitmap.getHeight();
            if (1 == this.AqJ)
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
              ab.d("MicroMsg.CropImageUI", " offsety ".concat(String.valueOf(f1)));
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
                break label1885;
              }
            }
            for (;;)
            {
              if (1 != this.AqJ) {
                break label1890;
              }
              ((Matrix)localObject3).postScale(f2, f2);
              ((Matrix)localObject3).postTranslate((n - localBitmap.getWidth() * f2) / 2.0F + ((View)localObject1).getLeft(), (i1 - f2 * localBitmap.getHeight()) / 2.0F + ((View)localObject1).getTop());
              break;
              f1 = f3;
              break label1807;
              label1885:
              f2 = f3;
            }
            label1890:
            if (this.AqK == 1)
            {
              this.AqN.setGifPath(this.filePath);
              this.AqN.getGifWidth();
              this.AqN.getGifHeight();
              f1 = this.AqN.getGifWidth() / n;
              f2 = this.AqN.getGifHeight() / i1;
              if (f1 > f2)
              {
                if (f1 <= 1.0D) {
                  break label2255;
                }
                ((Matrix)localObject3).postScale(f1, f1);
              }
            }
          }
        }
      }
      for (;;)
      {
        ((Matrix)localObject3).postTranslate((n - this.AqN.getGifWidth() * f1) / 2.0F, (i1 - f1 * this.AqN.getGifHeight()) / 2.0F);
        break;
        f1 = f2;
        break label1957;
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
        if (this.AqK == 1) {
          break label1086;
        }
        this.AqN.setImageMatrix((Matrix)localObject3);
        this.AqN.setImageBitmap(localBitmap);
        break label1086;
        label2137:
        f1 = f2;
        break label1178;
        label2142:
        f2 = f3;
        break label1200;
        label2147:
        ((Matrix)localObject3).postTranslate((n - i) / 2, (i1 - j) / 2);
        break label1243;
        label2187:
        this.AqK = 0;
        break label1252;
        label2195:
        if ((this.AqR) || (this.AqS)) {
          findViewById(2131823283).setVisibility(8);
        }
        if (getIntent().getBooleanExtra("CropImage_DirectlyIntoFilter", false)) {
          findViewById(2131823286).setVisibility(8);
        }
        AppMethodBeat.o(34844);
        return true;
        label2255:
        f1 = 1.0F;
      }
      label2260:
      k = i;
      i = j;
      j = k;
    }
  }
  
  private int[] dNI()
  {
    AppMethodBeat.i(34850);
    Object localObject1 = new Rect();
    getWindow().getDecorView().getWindowVisibleDisplayFrame((Rect)localObject1);
    int j = ((Rect)localObject1).top;
    ab.e("MicroMsg.CropImageUI", "window TitleBar.h:".concat(String.valueOf(j)));
    int i = j;
    if (j == 0) {
      i = j;
    }
    label296:
    for (;;)
    {
      try
      {
        localObject1 = Class.forName("com.android.internal.R$dimen");
        i = j;
        Object localObject2 = ((Class)localObject1).newInstance();
        i = j;
        int k = ah.getInt(((Class)localObject1).getField("status_bar_height").get(localObject2).toString(), 0);
        i = j;
        j = getResources().getDimensionPixelSize(k);
        i = j;
        ab.e("MicroMsg.CropImageUI", "sbar:".concat(String.valueOf(j)));
        i = j;
        localObject1 = new DisplayMetrics();
        ((WindowManager)getSystemService("window")).getDefaultDisplay().getMetrics((DisplayMetrics)localObject1);
        int m = (int)(67.0F * ((DisplayMetrics)localObject1).density / 1.5D);
        j = Math.min(this.AqP.getWidth(), this.AqP.getHeight());
        int n = Math.max(this.AqP.getWidth(), this.AqP.getHeight());
        k = j - m * 2 - i;
        if (this.AqQ != 0) {
          break label296;
        }
        j += i + m * 2;
        k += m;
        AppMethodBeat.o(34850);
        return new int[] { j, n - m * 2, k, n + i + m };
      }
      catch (Exception localException)
      {
        ab.printErrStackTrace("MicroMsg.CropImageUI", localException, "", new Object[0]);
      }
    }
  }
  
  private Bitmap hN(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(34851);
    Bitmap localBitmap = com.tencent.mm.sdk.platformtools.d.d(this.filePath, paramInt2, paramInt1, true);
    Object localObject = localBitmap;
    if (this.AqQ != 0)
    {
      localObject = new Matrix();
      ((Matrix)localObject).reset();
      ((Matrix)localObject).setRotate(this.AqQ, localBitmap.getWidth() / 2, localBitmap.getHeight() / 2);
      localObject = Bitmap.createBitmap(localBitmap, 0, 0, localBitmap.getWidth(), localBitmap.getHeight(), (Matrix)localObject, true);
      if (localBitmap != localObject)
      {
        ab.i("MicroMsg.CropImageUI", "recycle bitmap:%s", new Object[] { localBitmap.toString() });
        localBitmap.recycle();
      }
    }
    ab.d("MicroMsg.CropImageUI", "getcrop degree:" + this.AqQ);
    AppMethodBeat.o(34851);
    return localObject;
  }
  
  public void activateBroadcast(boolean paramBoolean)
  {
    AppMethodBeat.i(154012);
    if (paramBoolean)
    {
      y.d(paramBoolean, new Intent().putExtra("classname", getClass().getName()).putExtra("main_process", false));
      AppMethodBeat.o(154012);
      return;
    }
    super.activateBroadcast(paramBoolean);
    AppMethodBeat.o(154012);
  }
  
  public int getLayoutId()
  {
    return 2130969288;
  }
  
  public void initView()
  {
    AppMethodBeat.i(34842);
    setMMTitle("");
    this.AqM = ((LinearLayout)findViewById(2131823281));
    this.AqO = ((ImageView)findViewById(2131823277));
    com.tencent.mm.platformtools.r.cn(this.AqO);
    this.AqP = findViewById(2131823276);
    this.AqJ = getIntent().getIntExtra("CropImageMode", 0);
    final boolean bool1;
    final boolean bool2;
    Object localObject;
    Button localButton;
    if (this.AqJ != 0)
    {
      bool1 = true;
      Assert.assertTrue("the image mode must be set", bool1);
      this.ejF = getIntent().getIntExtra("CropImage_from_scene", 0);
      bool1 = getIntent().getBooleanExtra("CropImage_Filter", false);
      bool2 = getIntent().getBooleanExtra("CropImage_DirectlyIntoFilter", false);
      if (bool1) {
        b(new CropImageNewUI.22(this), new CropImageNewUI.23(this));
      }
      this.AqT = false;
      this.AqN = ((CropImageView)findViewById(2131823280));
      com.tencent.mm.platformtools.r.cn(this.AqN);
      this.AqN.post(new CropImageNewUI.1(this));
      this.AqN.setOnShortClick(new CropImageNewUI.12(this));
      ((Button)findViewById(2131823283)).setOnClickListener(new CropImageNewUI.4(this));
      localObject = (Button)findViewById(2131823285);
      ((Button)localObject).setOnClickListener(new CropImageNewUI.5(this));
      localButton = (Button)findViewById(2131823284);
      localButton.setOnClickListener(new CropImageNewUI.6(this));
      final ap localap1 = new ap(new CropImageNewUI.7(this), true);
      ap localap2 = new ap(new CropImageNewUI.8(this), true);
      ((Button)localObject).setOnTouchListener(new View.OnTouchListener()
      {
        public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
        {
          AppMethodBeat.i(34822);
          switch (paramAnonymousMotionEvent.getAction())
          {
          }
          for (;;)
          {
            AppMethodBeat.o(34822);
            return false;
            localap1.ag(200L, 200L);
            continue;
            localap1.stopTimer();
          }
        }
      });
      localButton.setOnTouchListener(new CropImageNewUI.10(this, localap2));
      switch (this.AqJ)
      {
      case 4: 
      default: 
        label384:
        ab.d("MicroMsg.CropImageUI", "mode is  " + this.AqJ);
        localObject = new MenuItem.OnMenuItemClickListener()
        {
          public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
          {
            AppMethodBeat.i(34829);
            if ((bool1) && (bool2))
            {
              CropImageNewUI.a(CropImageNewUI.this, true);
              AppMethodBeat.o(34829);
              return true;
            }
            switch (CropImageNewUI.f(CropImageNewUI.this))
            {
            }
            for (;;)
            {
              AppMethodBeat.o(34829);
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
        if (this.AqJ == 5) {
          addIconOptionMenu(0, 2130839668, (MenuItem.OnMenuItemClickListener)localObject);
        }
        break;
      }
    }
    for (;;)
    {
      if ((bool1) && (bool2)) {
        addTextOptionMenu(0, getString(2131298887), (MenuItem.OnMenuItemClickListener)localObject, null, q.b.zby);
      }
      setBackBtn(new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          AppMethodBeat.i(34831);
          CropImageNewUI.this.finish();
          AppMethodBeat.o(34831);
          return true;
        }
      });
      if (this.AqJ == 6)
      {
        findViewById(2131823286).setVisibility(8);
        addTextOptionMenu(0, getString(2131298891), new MenuItem.OnMenuItemClickListener()
        {
          public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
          {
            AppMethodBeat.i(34834);
            paramAnonymousMenuItem = new com.tencent.mm.ui.widget.b.d(CropImageNewUI.this, 1, false);
            paramAnonymousMenuItem.sao = new CropImageNewUI.20.1(this);
            paramAnonymousMenuItem.sap = new CropImageNewUI.20.2(this);
            paramAnonymousMenuItem.crd();
            AppMethodBeat.o(34834);
            return true;
          }
        }, null, q.b.zby);
      }
      AppMethodBeat.o(34842);
      return;
      bool1 = false;
      break;
      b(new Runnable()new Runnable
      {
        public final void run()
        {
          AppMethodBeat.i(34815);
          CropImageNewUI.a(CropImageNewUI.this, CropImageNewUI.e(CropImageNewUI.this).getCropImageIV(), CropImageNewUI.e(CropImageNewUI.this).getCropAreaView());
          CropImageNewUI.this.finish();
          AppMethodBeat.o(34815);
        }
      }, new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(34816);
          CropImageNewUI.this.finish();
          AppMethodBeat.o(34816);
        }
      });
      this.AqL.setLimitZoomIn(false);
      localObject = this.AqL;
      if (((FilterImageView)localObject).ArK != null)
      {
        ((FilterImageView)localObject).ArK.setScaleType(ImageView.ScaleType.MATRIX);
        ((FilterImageView)localObject).ArK.dNK();
      }
      this.AqL.setCropMaskVisible(0);
      if (this.ejF != 1) {
        break label384;
      }
      this.AqL.setCropMaskBackground(2130839788);
      break label384;
      this.AqN.setEnableOprate(false);
      findViewById(2131823282).setVisibility(8);
      findViewById(2131823286).setVisibility(8);
      break label384;
      this.AqM.setVisibility(8);
      break label384;
      int i = getIntent().getIntExtra("CropImage_CompressType", 1);
      boolean bool3 = getIntent().getBooleanExtra("CropImage_BHasHD", false);
      if ((i != 1) && (bool3))
      {
        findViewById(2131823286).setVisibility(0);
        localObject = (Button)findViewById(2131823287);
        ((Button)localObject).setBackgroundResource(2130838052);
        ((Button)localObject).setPadding(25, 8, 25, 8);
        ((Button)localObject).setOnClickListener(new CropImageNewUI.11(this));
        break label384;
      }
      findViewById(2131823286).setVisibility(8);
      break label384;
      if (this.AqJ == 4)
      {
        addIconOptionMenu(0, 2130839668, (MenuItem.OnMenuItemClickListener)localObject);
        findViewById(2131823286).setVisibility(0);
        localButton = (Button)findViewById(2131823287);
        localButton.setText(2131298887);
        localButton.setOnClickListener(new CropImageNewUI.18(this));
      }
      else
      {
        addTextOptionMenu(0, getString(2131298891), (MenuItem.OnMenuItemClickListener)localObject, null, q.b.zby);
      }
    }
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(34843);
    ab.d("MicroMsg.CropImageUI", "onConfigurationChanged, config.orientation = " + paramConfiguration.orientation);
    if ((paramConfiguration.orientation == 1) || (paramConfiguration.orientation == 2))
    {
      ab.v("MicroMsg.CropImageUI", "onConfigurationChanged");
      this.AqN.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(34835);
          CropImageNewUI.a(CropImageNewUI.this);
          AppMethodBeat.o(34835);
        }
      });
    }
    super.onConfigurationChanged(paramConfiguration);
    AppMethodBeat.o(34843);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(34838);
    super.onCreate(paramBundle);
    initView();
    AppMethodBeat.o(34838);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(34841);
    Object localObject;
    if (this.AqN != null)
    {
      localObject = this.AqN;
      if ((((CropImageView)localObject).nfX != null) && (!((CropImageView)localObject).nfX.isRecycled()))
      {
        ab.i("MicroMsg.CropImageView", "recycle bitmap:%s", new Object[] { ((CropImageView)localObject).nfX.toString() });
        ((CropImageView)localObject).nfX.recycle();
      }
      if (((CropImageView)localObject).Arq != null)
      {
        ((CropImageView)localObject).Arq.cancel();
        ((CropImageView)localObject).Arq = null;
      }
      ((CropImageView)localObject).Arr.removeCallbacksAndMessages(null);
      ((CropImageView)localObject).Art.removeCallbacksAndMessages(null);
    }
    if (this.AqL != null)
    {
      localObject = this.AqL;
      ((FilterImageView)localObject).ArH = null;
      if ((((FilterImageView)localObject).ArL != null) && (!((FilterImageView)localObject).ArL.isRecycled()))
      {
        ab.i("MicroMsg.FilterView", "recycle bitmap:%s", new Object[] { ((FilterImageView)localObject).ArL.toString() });
        ((FilterImageView)localObject).ArL.recycle();
      }
      ((FilterImageView)localObject).ArL = null;
    }
    super.onDestroy();
    AppMethodBeat.o(34841);
  }
  
  public void onNewIntent(Intent paramIntent)
  {
    AppMethodBeat.i(34839);
    super.onNewIntent(paramIntent);
    setIntent(paramIntent);
    initView();
    AppMethodBeat.o(34839);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(34840);
    super.onResume();
    setRequestedOrientation(1);
    AppMethodBeat.o(34840);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.tools.CropImageNewUI
 * JD-Core Version:    0.7.0.1
 */