package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.widget.SphereImageView;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory.Options;
import android.os.AsyncTask;
import android.text.TextUtils;
import android.view.TextureView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.graphics.MMBitmapFactory;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.al;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.f.a;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.h;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.vfs.e;
import com.tencent.mm.vfs.i;
import java.io.OutputStream;

public final class a
{
  protected int mScreenHeight;
  protected int mScreenWidth;
  protected d xgw;
  
  public a()
  {
    AppMethodBeat.i(97242);
    this.mScreenWidth = 720;
    this.mScreenHeight = 1280;
    try
    {
      int[] arrayOfInt = al.fU(aj.getContext());
      if ((arrayOfInt[0] > 0) && (arrayOfInt[1] > 0))
      {
        this.mScreenWidth = Math.min(arrayOfInt[0], arrayOfInt[1]);
        this.mScreenHeight = Math.max(arrayOfInt[0], arrayOfInt[1]);
        ad.i("SphereImageView.SphereImageLoader", "screen.w=" + this.mScreenWidth + ", screen.h=" + this.mScreenHeight);
      }
      AppMethodBeat.o(97242);
      return;
    }
    catch (Exception localException)
    {
      ad.e("SphereImageView.SphereImageLoader", "init exp=" + localException.toString());
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
        ad.e("SphereImageView.SphereImageLoader", "saveSphereImageViewShootAsyn, params err");
        AppMethodBeat.o(97245);
        return;
      }
      new b(paramTextureView, paramString1, paramString2).execute(new Void[0]);
      long l2 = System.currentTimeMillis();
      ad.i("SphereImageView.SphereImageLoader", "saveSphereImageViewShootAsyn, timeCost=" + (l2 - l1));
      AppMethodBeat.o(97245);
      return;
    }
    catch (Throwable paramTextureView)
    {
      ad.e("SphereImageView.SphereImageLoader", "saveSphereImageViewShootAsyn, exp=" + paramTextureView.toString());
      AppMethodBeat.o(97245);
    }
  }
  
  public static boolean a(Bitmap paramBitmap, String paramString1, String paramString2)
  {
    AppMethodBeat.i(97246);
    if (TextUtils.isEmpty(paramString1))
    {
      ad.e("SphereImageView.SphereImageLoader", "doSaveSphereImageViewFrameShot, imageUrl is empty, scene=".concat(String.valueOf(paramString2)));
      AppMethodBeat.o(97246);
      return false;
    }
    if ((paramBitmap == null) || (paramBitmap.getHeight() <= 0) || (paramBitmap.getWidth() <= 0))
    {
      ad.e("SphereImageView.SphereImageLoader", "doSaveSphereImageViewFrameShot, bitmap==null or size<=0, scene=".concat(String.valueOf(paramString2)));
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
        ad.e("SphereImageView.SphereImageLoader", "doSaveSphereImageViewFrameShot exp:" + paramBitmap.toString() + ", scene=" + paramString2);
        if (localObject2 == null) {
          continue;
        }
        try
        {
          ((OutputStream)localObject2).close();
        }
        catch (Exception paramBitmap)
        {
          ad.e("SphereImageView.SphereImageLoader", "doSaveSphereImageViewFrameShot, fout.close exp:" + paramBitmap.toString() + ", scene=" + paramString2);
        }
        continue;
      }
      catch (OutOfMemoryError paramBitmap)
      {
        localObject1 = localObject3;
        ad.e("SphereImageView.SphereImageLoader", "doSaveSphereImageViewFrameShot OOM:" + paramBitmap.toString() + ", scene=" + paramString2);
        if (localObject3 == null) {
          continue;
        }
        try
        {
          ((OutputStream)localObject3).close();
        }
        catch (Exception paramBitmap)
        {
          ad.e("SphereImageView.SphereImageLoader", "doSaveSphereImageViewFrameShot, fout.close exp:" + paramBitmap.toString() + ", scene=" + paramString2);
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
          ad.e("SphereImageView.SphereImageLoader", "doSaveSphereImageViewFrameShot, fout.close exp:" + paramString1.toString() + ", scene=" + paramString2);
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
        str = iT(paramString2, paramString1);
        localObject2 = localObject4;
        localObject3 = localObject5;
        localObject1 = localObject6;
        paramString1 = i.ai(new e(str));
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
        ad.i("SphereImageView.SphereImageLoader", "doSaveSphereImageViewFrameShot, timeCost=" + (l2 - l1) + ", bmp.w=" + paramBitmap.getWidth() + ", h=" + paramBitmap.getHeight() + ", path=" + str + ", isValid=true");
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
          ad.e("SphereImageView.SphereImageLoader", "doSaveSphereImageViewFrameShot, fout.close exp:" + paramBitmap.toString() + ", scene=" + paramString2);
        }
      }
    }
    localObject2 = localObject4;
    localObject3 = localObject5;
    localObject1 = localObject6;
    ad.i("SphereImageView.SphereImageLoader", "doSaveSphereImageViewFrameShot, isValid=false");
    AppMethodBeat.o(97246);
    return false;
  }
  
  private static String apC(String paramString)
  {
    AppMethodBeat.i(97244);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(97244);
      return null;
    }
    try
    {
      paramString = h.iU("adId", paramString);
      if (!TextUtils.isEmpty(paramString))
      {
        boolean bool = i.eK(paramString);
        if (bool)
        {
          AppMethodBeat.o(97244);
          return paramString;
        }
      }
    }
    catch (Exception paramString)
    {
      ad.e("SphereImageView.SphereImageLoader", "getImgCacheFilePath, exp:" + paramString.toString());
      AppMethodBeat.o(97244);
    }
    return "";
  }
  
  public static Bitmap iR(String paramString1, String paramString2)
  {
    boolean bool = false;
    AppMethodBeat.i(97247);
    if (TextUtils.isEmpty(paramString1))
    {
      ad.e("SphereImageView.SphereImageLoader", "getSphereImageViewFrameShot, imageUrl is empty, scene=".concat(String.valueOf(paramString2)));
      AppMethodBeat.o(97247);
      return null;
    }
    for (;;)
    {
      try
      {
        paramString1 = iT(paramString2, paramString1);
        if ((TextUtils.isEmpty(paramString1)) || (!i.eK(paramString1))) {
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
        ad.e("SphereImageView.SphereImageLoader", "getSphereImageViewFrameShot, exp:" + paramString1.toString() + ", scene=" + paramString2);
        continue;
      }
      catch (OutOfMemoryError paramString1)
      {
        Bitmap localBitmap;
        ad.e("SphereImageView.SphereImageLoader", "getSphereImageViewFrameShot, OOM:" + paramString1.toString() + ", scene=" + paramString2);
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
      ad.i("SphereImageView.SphereImageLoader", bool + ", w=" + i + ", h=" + j + ", path=" + paramString1);
      AppMethodBeat.o(97247);
      return localBitmap;
      i = localBitmap.getWidth();
      continue;
      j = localBitmap.getHeight();
    }
    ad.e("SphereImageView.SphereImageLoader", "getSphereImageViewFrameShot, file not exists, scene=" + paramString2 + ", path=" + paramString1);
    AppMethodBeat.o(97247);
    return null;
  }
  
  public static boolean iS(String paramString1, String paramString2)
  {
    AppMethodBeat.i(97248);
    if (TextUtils.isEmpty(paramString1))
    {
      ad.e("SphereImageView.SphereImageLoader", "hasSphereImageViewFrameShot, imageUrl is empty, scene=".concat(String.valueOf(paramString2)));
      AppMethodBeat.o(97248);
      return false;
    }
    try
    {
      paramString1 = iT(paramString2, paramString1);
      if ((!TextUtils.isEmpty(paramString1)) && (i.eK(paramString1))) {}
      for (boolean bool = true;; bool = false)
      {
        ad.i("SphereImageView.SphereImageLoader", "hasSphereImageViewFrameShot, ret=" + bool + ", scene=" + paramString2);
        AppMethodBeat.o(97248);
        return bool;
      }
      return false;
    }
    catch (Exception paramString1)
    {
      ad.e("SphereImageView.SphereImageLoader", "hasSphereImageViewFrameShot, exp:" + paramString1.toString() + ", scene=" + paramString2);
      AppMethodBeat.o(97248);
    }
  }
  
  private static String iT(String paramString1, String paramString2)
  {
    AppMethodBeat.i(97249);
    paramString1 = h.iU("sphere_shot_".concat(String.valueOf(paramString1)), paramString2);
    AppMethodBeat.o(97249);
    return paramString1;
  }
  
  public final void a(d paramd)
  {
    this.xgw = paramd;
  }
  
  public final void j(final String paramString1, final int paramInt1, final int paramInt2, final String paramString2)
  {
    AppMethodBeat.i(97243);
    ad.i("SphereImageView.SphereImageLoader", "loadImage, view.w=" + paramInt1 + ", view.h=" + paramInt2 + ", scene=" + paramString2);
    if ((paramInt1 == 0) || (paramInt2 == 0))
    {
      AppMethodBeat.o(97243);
      return;
    }
    if (this.xgw != null) {
      this.xgw.onStart(paramString1);
    }
    String str = apC(paramString1);
    if (!TextUtils.isEmpty(str))
    {
      ad.i("SphereImageView.SphereImageLoader", "hit disk cache, path=".concat(String.valueOf(str)));
      new a(paramString1, paramInt1, paramInt2, paramString2).execute(new String[] { str });
      AppMethodBeat.o(97243);
      return;
    }
    ad.i("SphereImageView.SphereImageLoader", "no cache, download");
    h.a(paramString1, 133, new f.a()
    {
      public final void apm(String paramAnonymousString)
      {
        AppMethodBeat.i(97234);
        ad.i("SphereImageView.SphereImageLoader", "loadImage onDownloaded, path=".concat(String.valueOf(paramAnonymousString)));
        new a.a(a.this, paramString1, paramInt1, paramInt2, paramString2).execute(new String[] { paramAnonymousString });
        AppMethodBeat.o(97234);
      }
      
      public final void dsA()
      {
        AppMethodBeat.i(97233);
        ad.e("SphereImageView.SphereImageLoader", "onDownloadError");
        aq.f(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(97231);
            if (a.this.xgw != null) {
              a.this.xgw.a(false, "onDownloadError", null, a.1.this.wOJ);
            }
            AppMethodBeat.o(97231);
          }
        });
        AppMethodBeat.o(97233);
      }
      
      public final void duP()
      {
        AppMethodBeat.i(97232);
        ad.i("SphereImageView.SphereImageLoader", "onStartDownload");
        AppMethodBeat.o(97232);
      }
    });
    AppMethodBeat.o(97243);
  }
  
  protected final class a
    extends AsyncTask<String, Void, Bitmap>
  {
    String cko = "";
    String scene;
    String url;
    int xgA;
    int xgz;
    
    public a(String paramString1, int paramInt1, int paramInt2, String paramString2)
    {
      this.url = paramString1;
      this.xgz = paramInt1;
      this.xgA = paramInt2;
      this.scene = paramString2;
    }
    
    private Bitmap J(String... paramVarArgs)
    {
      int n = 1;
      int m = 1;
      int k = 0;
      AppMethodBeat.i(97235);
      if ((paramVarArgs == null) || (paramVarArgs.length == 0) || (TextUtils.isEmpty(paramVarArgs[0])))
      {
        ad.e("SphereImageView.SphereImageLoader", "ImageDecodeTask run, path is empty");
        this.cko = "path is empty";
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
          this.cko = paramVarArgs.toString();
          ad.e("SphereImageView.SphereImageLoader", "ImageDecodeTask, exp:" + this.cko);
          paramVarArgs = localStringBuilder;
          continue;
        }
        catch (OutOfMemoryError localOutOfMemoryError)
        {
          this.cko = localOutOfMemoryError.toString();
          ad.e("SphereImageView.SphereImageLoader", "ImageDecodeTask, oom:" + this.cko);
          try
          {
            ad.i("SphereImageView.SphereImageLoader", "ImageDecodeTask, try again after oom");
            System.gc();
            paramVarArgs = new BitmapFactory.Options();
            paramVarArgs.inSampleSize = (j + 1);
            paramVarArgs = MMBitmapFactory.decodeFile(str, paramVarArgs);
          }
          catch (Throwable paramVarArgs)
          {
            this.cko = localOutOfMemoryError.toString();
            ad.e("SphereImageView.SphereImageLoader", "ImageDecodeTask, try again exp:" + this.cko);
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
        ad.i("SphereImageView.SphereImageLoader", "decode, bmp.w=" + i1 + ", bmp.h=" + i2 + ", screen.w=" + a.this.mScreenWidth + ", screen.h=" + a.this.mScreenHeight + ", view.w=" + this.xgz + ", view.h=" + this.xgA + ", inSampleSize=" + i);
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
        ad.i("SphereImageView.SphereImageLoader", i + ", path=" + str);
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
    String gFC;
    String scene;
    
    public b(Bitmap paramBitmap, String paramString1, String paramString2)
    {
      this.bitmap = paramBitmap;
      this.gFC = paramString1;
      this.scene = paramString2;
    }
  }
  
  public static final class c
    extends AsyncTask<Void, Void, Bitmap>
  {
    String gFC;
    String scene;
    String thumbUrl;
    a.d xgB;
    
    public c(String paramString1, String paramString2, String paramString3, a.d paramd)
    {
      this.gFC = paramString1;
      this.thumbUrl = paramString2;
      this.scene = paramString3;
      this.xgB = paramd;
    }
    
    private Bitmap qa()
    {
      AppMethodBeat.i(97239);
      Bitmap localBitmap = a.iR(this.gFC, this.scene);
      Object localObject;
      if (localBitmap != null)
      {
        ad.i("SphereImageView.SphereImageLoader", "has shot");
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
          localBitmap = h.iY("adId", this.thumbUrl);
          localObject = localBitmap;
          if (localBitmap == null) {
            continue;
          }
          localObject = localBitmap;
          ad.i("SphereImageView.SphereImageLoader", "has cache thumb");
          localObject = localBitmap;
        }
        catch (Throwable localThrowable)
        {
          ad.e("SphereImageView.SphereImageLoader", "getCachedImg exp:" + localThrowable.toString());
        }
        continue;
        label109:
        localObject = localThrowable;
        ad.e("SphereImageView.SphereImageLoader", "thumbUrl is empty");
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.widget.SphereImageView.a
 * JD-Core Version:    0.7.0.1
 */