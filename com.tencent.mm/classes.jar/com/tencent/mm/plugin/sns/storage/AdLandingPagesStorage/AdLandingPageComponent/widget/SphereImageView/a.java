package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.widget.SphereImageView;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory.Options;
import android.os.AsyncTask;
import android.text.TextUtils;
import android.view.TextureView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.graphics.MMBitmapFactory;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.ap;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.f.a;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.vfs.o;
import com.tencent.mm.vfs.s;
import java.io.OutputStream;

public final class a
{
  protected d EjP;
  protected int mScreenHeight;
  protected int mScreenWidth;
  
  public a()
  {
    AppMethodBeat.i(97242);
    this.mScreenWidth = 720;
    this.mScreenHeight = 1280;
    try
    {
      int[] arrayOfInt = ap.ha(MMApplicationContext.getContext());
      if ((arrayOfInt[0] > 0) && (arrayOfInt[1] > 0))
      {
        this.mScreenWidth = Math.min(arrayOfInt[0], arrayOfInt[1]);
        this.mScreenHeight = Math.max(arrayOfInt[0], arrayOfInt[1]);
        Log.i("SphereImageView.SphereImageLoader", "screen.w=" + this.mScreenWidth + ", screen.h=" + this.mScreenHeight);
      }
      AppMethodBeat.o(97242);
      return;
    }
    catch (Exception localException)
    {
      Log.e("SphereImageView.SphereImageLoader", "init exp=" + localException.toString());
      AppMethodBeat.o(97242);
    }
  }
  
  public static void a(TextureView paramTextureView, String paramString1, String paramString2)
  {
    AppMethodBeat.i(97245);
    try
    {
      long l1 = System.currentTimeMillis();
      paramTextureView = paramTextureView.getBitmap();
      if ((paramTextureView == null) || (paramTextureView.getWidth() <= 0) || (paramTextureView.getHeight() <= 0) || (TextUtils.isEmpty(paramString1)))
      {
        Log.e("SphereImageView.SphereImageLoader", "saveSphereImageViewShootAsyn, params err");
        AppMethodBeat.o(97245);
        return;
      }
      new b(paramTextureView, paramString1, paramString2).execute(new Void[0]);
      long l2 = System.currentTimeMillis();
      Log.i("SphereImageView.SphereImageLoader", "saveSphereImageViewShootAsyn, timeCost=" + (l2 - l1));
      AppMethodBeat.o(97245);
      return;
    }
    catch (Throwable paramTextureView)
    {
      Log.e("SphereImageView.SphereImageLoader", "saveSphereImageViewShootAsyn, exp=" + paramTextureView.toString());
      AppMethodBeat.o(97245);
    }
  }
  
  public static boolean a(Bitmap paramBitmap, String paramString1, String paramString2)
  {
    AppMethodBeat.i(97246);
    if (TextUtils.isEmpty(paramString1))
    {
      Log.e("SphereImageView.SphereImageLoader", "doSaveSphereImageViewFrameShot, imageUrl is empty, scene=".concat(String.valueOf(paramString2)));
      AppMethodBeat.o(97246);
      return false;
    }
    if ((paramBitmap == null) || (paramBitmap.getHeight() <= 0) || (paramBitmap.getWidth() <= 0))
    {
      Log.e("SphereImageView.SphereImageLoader", "doSaveSphereImageViewFrameShot, bitmap==null or size<=0, scene=".concat(String.valueOf(paramString2)));
      AppMethodBeat.o(97246);
      return false;
    }
    Object localObject5 = null;
    Object localObject6 = null;
    Object localObject4 = null;
    localObject2 = localObject4;
    localObject3 = localObject5;
    localObject1 = localObject6;
    for (;;)
    {
      try
      {
        l1 = System.currentTimeMillis();
        if (paramBitmap == null) {
          continue;
        }
        localObject2 = localObject4;
        localObject3 = localObject5;
        localObject1 = localObject6;
        if (paramBitmap.getWidth() < 20) {
          continue;
        }
        localObject2 = localObject4;
        localObject3 = localObject5;
        localObject1 = localObject6;
        if (paramBitmap.getHeight() >= 20) {
          continue;
        }
      }
      catch (Exception paramBitmap)
      {
        long l1;
        String str;
        long l2;
        localObject1 = localObject2;
        Log.e("SphereImageView.SphereImageLoader", "doSaveSphereImageViewFrameShot exp:" + paramBitmap.toString() + ", scene=" + paramString2);
        if (localObject2 == null) {
          continue;
        }
        try
        {
          ((OutputStream)localObject2).close();
        }
        catch (Exception paramBitmap)
        {
          Log.e("SphereImageView.SphereImageLoader", "doSaveSphereImageViewFrameShot, fout.close exp:" + paramBitmap.toString() + ", scene=" + paramString2);
        }
        continue;
      }
      catch (OutOfMemoryError paramBitmap)
      {
        localObject1 = localObject3;
        Log.e("SphereImageView.SphereImageLoader", "doSaveSphereImageViewFrameShot OOM:" + paramBitmap.toString() + ", scene=" + paramString2);
        if (localObject3 == null) {
          continue;
        }
        try
        {
          ((OutputStream)localObject3).close();
        }
        catch (Exception paramBitmap)
        {
          Log.e("SphereImageView.SphereImageLoader", "doSaveSphereImageViewFrameShot, fout.close exp:" + paramBitmap.toString() + ", scene=" + paramString2);
        }
        continue;
      }
      finally
      {
        int n;
        int m;
        if (localObject1 == null) {
          continue;
        }
        try
        {
          ((OutputStream)localObject1).close();
          AppMethodBeat.o(97246);
          throw paramBitmap;
        }
        catch (Exception paramString1)
        {
          Log.e("SphereImageView.SphereImageLoader", "doSaveSphereImageViewFrameShot, fout.close exp:" + paramString1.toString() + ", scene=" + paramString2);
          continue;
        }
        int i = 0;
        continue;
        if (j >= 10) {
          continue;
        }
        int k = 0;
        continue;
        j += 1;
        continue;
        if (i == 0) {
          continue;
        }
        i = 1;
        continue;
        int j = n - 10;
        if (j >= n) {
          continue;
        }
        k = 0;
        continue;
        j += 1;
        continue;
        if (i == 0) {
          continue;
        }
        i = 1;
        continue;
        j = 0;
        if (j >= 10) {
          continue;
        }
        k = m - 10;
        continue;
        j += 1;
        continue;
        if (i == 0) {
          continue;
        }
        i = 1;
        continue;
        j = n - 10;
        if (j >= n) {
          continue;
        }
        k = m - 10;
        continue;
        j += 1;
        continue;
        if (i == 0) {
          continue;
        }
        i = 1;
        continue;
        if (i >= n + 5) {
          continue;
        }
        j = m - 5;
        continue;
      }
      if (i != 0)
      {
        localObject2 = localObject4;
        localObject3 = localObject5;
        localObject1 = localObject6;
        str = ky(paramString2, paramString1);
        localObject2 = localObject4;
        localObject3 = localObject5;
        localObject1 = localObject6;
        paramString1 = s.ap(new o(str));
        localObject2 = paramString1;
        localObject3 = paramString1;
        localObject1 = paramString1;
        paramBitmap.compress(Bitmap.CompressFormat.JPEG, 90, paramString1);
        localObject2 = paramString1;
        localObject3 = paramString1;
        localObject1 = paramString1;
        paramString1.flush();
        localObject2 = paramString1;
        localObject3 = paramString1;
        localObject1 = paramString1;
        l2 = System.currentTimeMillis();
        localObject2 = paramString1;
        localObject3 = paramString1;
        localObject1 = paramString1;
        Log.i("SphereImageView.SphereImageLoader", "doSaveSphereImageViewFrameShot, timeCost=" + (l2 - l1) + ", bmp.w=" + paramBitmap.getWidth() + ", h=" + paramBitmap.getHeight() + ", path=" + str + ", isValid=true");
        if (paramString1 != null) {}
        try
        {
          paramString1.close();
          AppMethodBeat.o(97246);
          return true;
          i = 0;
          localObject2 = localObject4;
          localObject3 = localObject5;
          localObject1 = localObject6;
          n = paramBitmap.getWidth();
          localObject2 = localObject4;
          localObject3 = localObject5;
          localObject1 = localObject6;
          m = paramBitmap.getHeight();
          j = 0;
          continue;
          if (k >= 10) {
            continue;
          }
          localObject2 = localObject4;
          localObject3 = localObject5;
          localObject1 = localObject6;
          i += (paramBitmap.getPixel(j, k) & 0xFFFFFF);
          k += 1;
          continue;
          if (k >= 10) {
            continue;
          }
          localObject2 = localObject4;
          localObject3 = localObject5;
          localObject1 = localObject6;
          i += (paramBitmap.getPixel(j, k) & 0xFFFFFF);
          k += 1;
          continue;
          if (k >= m) {
            continue;
          }
          localObject2 = localObject4;
          localObject3 = localObject5;
          localObject1 = localObject6;
          i += (paramBitmap.getPixel(j, k) & 0xFFFFFF);
          k += 1;
          continue;
          if (k >= m) {
            continue;
          }
          localObject2 = localObject4;
          localObject3 = localObject5;
          localObject1 = localObject6;
          i += (paramBitmap.getPixel(j, k) & 0xFFFFFF);
          k += 1;
          continue;
          localObject2 = localObject4;
          localObject3 = localObject5;
          localObject1 = localObject6;
          n /= 2;
          localObject2 = localObject4;
          localObject3 = localObject5;
          localObject1 = localObject6;
          m /= 2;
          j = n - 5;
          k = i;
          i = j;
          continue;
          if (j < m + 5)
          {
            localObject2 = localObject4;
            localObject3 = localObject5;
            localObject1 = localObject6;
            int i1 = paramBitmap.getPixel(i, j);
            k += (i1 & 0xFFFFFF);
            j += 1;
          }
          else
          {
            i += 1;
            continue;
            if (k != 0) {
              i = 1;
            } else {
              i = 0;
            }
          }
        }
        catch (Exception paramBitmap)
        {
          Log.e("SphereImageView.SphereImageLoader", "doSaveSphereImageViewFrameShot, fout.close exp:" + paramBitmap.toString() + ", scene=" + paramString2);
        }
      }
    }
    localObject2 = localObject4;
    localObject3 = localObject5;
    localObject1 = localObject6;
    Log.i("SphereImageView.SphereImageLoader", "doSaveSphereImageViewFrameShot, isValid=false");
    AppMethodBeat.o(97246);
    return false;
  }
  
  private static String aQe(String paramString)
  {
    AppMethodBeat.i(97244);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(97244);
      return null;
    }
    try
    {
      paramString = h.kz("adId", paramString);
      if (!TextUtils.isEmpty(paramString))
      {
        boolean bool = s.YS(paramString);
        if (bool)
        {
          AppMethodBeat.o(97244);
          return paramString;
        }
      }
    }
    catch (Exception paramString)
    {
      Log.e("SphereImageView.SphereImageLoader", "getImgCacheFilePath, exp:" + paramString.toString());
      AppMethodBeat.o(97244);
    }
    return "";
  }
  
  public static Bitmap kw(String paramString1, String paramString2)
  {
    boolean bool = false;
    AppMethodBeat.i(97247);
    if (TextUtils.isEmpty(paramString1))
    {
      Log.e("SphereImageView.SphereImageLoader", "getSphereImageViewFrameShot, imageUrl is empty, scene=".concat(String.valueOf(paramString2)));
      AppMethodBeat.o(97247);
      return null;
    }
    for (;;)
    {
      try
      {
        paramString1 = ky(paramString2, paramString1);
        if ((TextUtils.isEmpty(paramString1)) || (!s.YS(paramString1))) {
          continue;
        }
        l1 = System.currentTimeMillis();
        localBitmap = MMBitmapFactory.decodeFile(paramString1);
        l2 = System.currentTimeMillis();
        if (localBitmap != null) {
          continue;
        }
        i = 0;
      }
      catch (Exception paramString1)
      {
        long l1;
        long l2;
        int i;
        StringBuilder localStringBuilder;
        Log.e("SphereImageView.SphereImageLoader", "getSphereImageViewFrameShot, exp:" + paramString1.toString() + ", scene=" + paramString2);
        continue;
      }
      catch (OutOfMemoryError paramString1)
      {
        Bitmap localBitmap;
        Log.e("SphereImageView.SphereImageLoader", "getSphereImageViewFrameShot, OOM:" + paramString1.toString() + ", scene=" + paramString2);
        continue;
        if (localBitmap != null) {
          continue;
        }
        int j = 0;
        continue;
      }
      localStringBuilder = new StringBuilder("getSphereImageViewFrameShot, timeCost=").append(l2 - l1).append(", bmp==null?");
      if (localBitmap == null) {
        bool = true;
      }
      Log.i("SphereImageView.SphereImageLoader", bool + ", w=" + i + ", h=" + j + ", path=" + paramString1);
      AppMethodBeat.o(97247);
      return localBitmap;
      i = localBitmap.getWidth();
      continue;
      j = localBitmap.getHeight();
    }
    Log.e("SphereImageView.SphereImageLoader", "getSphereImageViewFrameShot, file not exists, scene=" + paramString2 + ", path=" + paramString1);
    AppMethodBeat.o(97247);
    return null;
  }
  
  public static boolean kx(String paramString1, String paramString2)
  {
    AppMethodBeat.i(97248);
    if (TextUtils.isEmpty(paramString1))
    {
      Log.e("SphereImageView.SphereImageLoader", "hasSphereImageViewFrameShot, imageUrl is empty, scene=".concat(String.valueOf(paramString2)));
      AppMethodBeat.o(97248);
      return false;
    }
    try
    {
      paramString1 = ky(paramString2, paramString1);
      if ((!TextUtils.isEmpty(paramString1)) && (s.YS(paramString1))) {}
      for (boolean bool = true;; bool = false)
      {
        Log.i("SphereImageView.SphereImageLoader", "hasSphereImageViewFrameShot, ret=" + bool + ", scene=" + paramString2);
        AppMethodBeat.o(97248);
        return bool;
      }
      return false;
    }
    catch (Exception paramString1)
    {
      Log.e("SphereImageView.SphereImageLoader", "hasSphereImageViewFrameShot, exp:" + paramString1.toString() + ", scene=" + paramString2);
      AppMethodBeat.o(97248);
    }
  }
  
  private static String ky(String paramString1, String paramString2)
  {
    AppMethodBeat.i(97249);
    paramString1 = h.kz("sphere_shot_".concat(String.valueOf(paramString1)), paramString2);
    AppMethodBeat.o(97249);
    return paramString1;
  }
  
  public final void a(d paramd)
  {
    this.EjP = paramd;
  }
  
  public final void l(final String paramString1, final int paramInt1, final int paramInt2, final String paramString2)
  {
    AppMethodBeat.i(97243);
    Log.i("SphereImageView.SphereImageLoader", "loadImage, view.w=" + paramInt1 + ", view.h=" + paramInt2 + ", scene=" + paramString2);
    if ((paramInt1 == 0) || (paramInt2 == 0))
    {
      AppMethodBeat.o(97243);
      return;
    }
    if (this.EjP != null) {
      this.EjP.onStart(paramString1);
    }
    String str = aQe(paramString1);
    if (!TextUtils.isEmpty(str))
    {
      Log.i("SphereImageView.SphereImageLoader", "hit disk cache, path=".concat(String.valueOf(str)));
      new a(paramString1, paramInt1, paramInt2, paramString2).execute(new String[] { str });
      AppMethodBeat.o(97243);
      return;
    }
    Log.i("SphereImageView.SphereImageLoader", "no cache, download");
    h.a(paramString1, 133, new f.a()
    {
      public final void aNH(String paramAnonymousString)
      {
        AppMethodBeat.i(97234);
        Log.i("SphereImageView.SphereImageLoader", "loadImage onDownloaded, path=".concat(String.valueOf(paramAnonymousString)));
        new a.a(a.this, paramString1, paramInt1, paramInt2, paramString2).execute(new String[] { paramAnonymousString });
        AppMethodBeat.o(97234);
      }
      
      public final void eWN()
      {
        AppMethodBeat.i(97232);
        Log.i("SphereImageView.SphereImageLoader", "onStartDownload");
        AppMethodBeat.o(97232);
      }
      
      public final void eWO()
      {
        AppMethodBeat.i(97233);
        Log.e("SphereImageView.SphereImageLoader", "onDownloadError");
        MMHandlerThread.postToMainThread(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(97231);
            if (a.this.EjP != null) {
              a.this.EjP.a(false, "onDownloadError", null, a.1.this.DzZ);
            }
            AppMethodBeat.o(97231);
          }
        });
        AppMethodBeat.o(97233);
      }
    });
    AppMethodBeat.o(97243);
  }
  
  protected final class a
    extends AsyncTask<String, Void, Bitmap>
  {
    int EjS;
    int EjT;
    String errorInfo = "";
    String scene;
    String url;
    
    public a(String paramString1, int paramInt1, int paramInt2, String paramString2)
    {
      this.url = paramString1;
      this.EjS = paramInt1;
      this.EjT = paramInt2;
      this.scene = paramString2;
    }
    
    private Bitmap N(String... paramVarArgs)
    {
      int n = 1;
      int m = 1;
      int k = 0;
      AppMethodBeat.i(97235);
      if ((paramVarArgs == null) || (paramVarArgs.length == 0) || (TextUtils.isEmpty(paramVarArgs[0])))
      {
        Log.e("SphereImageView.SphereImageLoader", "ImageDecodeTask run, path is empty");
        this.errorInfo = "path is empty";
        AppMethodBeat.o(97235);
        return null;
      }
      localStringBuilder = null;
      long l1 = System.currentTimeMillis();
      str = paramVarArgs[0];
      j = n;
      for (;;)
      {
        try
        {
          paramVarArgs = new BitmapFactory.Options();
          j = n;
          paramVarArgs.inJustDecodeBounds = true;
          j = n;
          MMBitmapFactory.decodeFile(str, paramVarArgs);
          j = n;
          i1 = paramVarArgs.outWidth;
          j = n;
          i2 = paramVarArgs.outHeight;
          j = n;
          if ("scene_ad_landing" != this.scene) {
            continue;
          }
          i = m;
          if (i1 >= 4000)
          {
            i = m;
            j = n;
            if (a.this.mScreenWidth < 1080) {
              i = 2;
            }
          }
        }
        catch (Exception paramVarArgs)
        {
          int i1;
          int i2;
          long l2;
          this.errorInfo = paramVarArgs.toString();
          Log.e("SphereImageView.SphereImageLoader", "ImageDecodeTask, exp:" + this.errorInfo);
          paramVarArgs = localStringBuilder;
          continue;
        }
        catch (OutOfMemoryError localOutOfMemoryError)
        {
          this.errorInfo = localOutOfMemoryError.toString();
          Log.e("SphereImageView.SphereImageLoader", "ImageDecodeTask, oom:" + this.errorInfo);
          try
          {
            Log.i("SphereImageView.SphereImageLoader", "ImageDecodeTask, try again after oom");
            System.gc();
            paramVarArgs = new BitmapFactory.Options();
            paramVarArgs.inSampleSize = (j + 1);
            paramVarArgs = MMBitmapFactory.decodeFile(str, paramVarArgs);
          }
          catch (Throwable paramVarArgs)
          {
            this.errorInfo = localOutOfMemoryError.toString();
            Log.e("SphereImageView.SphereImageLoader", "ImageDecodeTask, try again exp:" + this.errorInfo);
            paramVarArgs = localStringBuilder;
          }
          continue;
          int i = paramVarArgs.getWidth();
          continue;
          i = paramVarArgs.getHeight();
          continue;
          i = 4;
          continue;
        }
        j = i;
        Log.i("SphereImageView.SphereImageLoader", "decode, bmp.w=" + i1 + ", bmp.h=" + i2 + ", screen.w=" + a.this.mScreenWidth + ", screen.h=" + a.this.mScreenHeight + ", view.w=" + this.EjS + ", view.h=" + this.EjT + ", inSampleSize=" + i);
        j = i;
        paramVarArgs.inJustDecodeBounds = false;
        j = i;
        paramVarArgs.inSampleSize = i;
        j = i;
        paramVarArgs = MMBitmapFactory.decodeFile(str, paramVarArgs);
        l2 = System.currentTimeMillis();
        localStringBuilder = new StringBuilder("ImageDecodeTask end, totalTime=").append(l2 - l1).append(", bmp.w=");
        if (paramVarArgs != null) {
          continue;
        }
        i = 0;
        localStringBuilder = localStringBuilder.append(i).append(", bmp.h=");
        if (paramVarArgs != null) {
          continue;
        }
        i = k;
        Log.i("SphereImageView.SphereImageLoader", i + ", path=" + str);
        AppMethodBeat.o(97235);
        return paramVarArgs;
        i = m;
        j = n;
        if ("scene_timeline" == this.scene) {
          if (i1 >= 4000)
          {
            j = n;
            if (a.this.mScreenWidth < 1080) {
              continue;
            }
            i = 2;
          }
          else
          {
            i = m;
            if (i1 >= 2000)
            {
              j = n;
              n = a.this.mScreenWidth;
              i = m;
              if (n < 1080) {
                i = 2;
              }
            }
          }
        }
      }
    }
  }
  
  protected static final class b
    extends AsyncTask<Void, Void, Void>
  {
    Bitmap bitmap;
    String imageUrl;
    String scene;
    
    public b(Bitmap paramBitmap, String paramString1, String paramString2)
    {
      this.bitmap = paramBitmap;
      this.imageUrl = paramString1;
      this.scene = paramString2;
    }
  }
  
  public static final class c
    extends AsyncTask<Void, Void, Bitmap>
  {
    a.d EjU;
    String imageUrl;
    String scene;
    String thumbUrl;
    
    public c(String paramString1, String paramString2, String paramString3, a.d paramd)
    {
      this.imageUrl = paramString1;
      this.thumbUrl = paramString2;
      this.scene = paramString3;
      this.EjU = paramd;
    }
    
    private Bitmap rL()
    {
      AppMethodBeat.i(97239);
      Bitmap localBitmap = a.kw(this.imageUrl, this.scene);
      Object localObject;
      if (localBitmap != null)
      {
        Log.i("SphereImageView.SphereImageLoader", "has shot");
        localObject = localBitmap;
      }
      for (;;)
      {
        AppMethodBeat.o(97239);
        return localObject;
        localObject = localBitmap;
        try
        {
          if (TextUtils.isEmpty(this.thumbUrl)) {
            break label109;
          }
          localObject = localBitmap;
          localBitmap = h.kD("adId", this.thumbUrl);
          localObject = localBitmap;
          if (localBitmap == null) {
            continue;
          }
          localObject = localBitmap;
          Log.i("SphereImageView.SphereImageLoader", "has cache thumb");
          localObject = localBitmap;
        }
        catch (Throwable localThrowable)
        {
          Log.e("SphereImageView.SphereImageLoader", "getCachedImg exp:" + localThrowable.toString());
        }
        continue;
        label109:
        localObject = localThrowable;
        Log.e("SphereImageView.SphereImageLoader", "thumbUrl is empty");
        localObject = localThrowable;
      }
    }
  }
  
  public static abstract interface d
  {
    public abstract void a(boolean paramBoolean, String paramString1, Bitmap paramBitmap, String paramString2);
    
    public abstract void onStart(String paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.widget.SphereImageView.a
 * JD-Core Version:    0.7.0.1
 */