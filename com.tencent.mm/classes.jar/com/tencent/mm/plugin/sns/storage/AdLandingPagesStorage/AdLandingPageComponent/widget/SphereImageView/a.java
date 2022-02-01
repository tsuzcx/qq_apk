package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.widget.SphereImageView;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.os.AsyncTask;
import android.text.TextUtils;
import android.view.TextureView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.graphics.MMBitmapFactory;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.ar;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.g.a;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.k;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.vfs.u;
import com.tencent.mm.vfs.y;
import java.io.OutputStream;

public final class a
{
  protected d QVH;
  protected int mScreenHeight;
  protected int mScreenWidth;
  
  public a()
  {
    AppMethodBeat.i(97242);
    this.mScreenWidth = 720;
    this.mScreenHeight = 1280;
    try
    {
      int[] arrayOfInt = ar.jR(MMApplicationContext.getContext());
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
    finally
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
        str = mA(paramString2, paramString1);
        localObject2 = localObject4;
        localObject3 = localObject5;
        localObject1 = localObject6;
        paramString1 = y.ap(new u(str));
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
  
  private static String aZE(String paramString)
  {
    AppMethodBeat.i(97244);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(97244);
      return null;
    }
    try
    {
      paramString = k.mC("adId", paramString);
      if (!TextUtils.isEmpty(paramString))
      {
        boolean bool = y.ZC(paramString);
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
  
  private static String mA(String paramString1, String paramString2)
  {
    AppMethodBeat.i(97249);
    paramString1 = k.mC("sphere_shot_".concat(String.valueOf(paramString1)), paramString2);
    AppMethodBeat.o(97249);
    return paramString1;
  }
  
  public static Bitmap my(String paramString1, String paramString2)
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
        paramString1 = mA(paramString2, paramString1);
        if ((TextUtils.isEmpty(paramString1)) || (!y.ZC(paramString1))) {
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
  
  public static boolean mz(String paramString1, String paramString2)
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
      paramString1 = mA(paramString2, paramString1);
      if ((!TextUtils.isEmpty(paramString1)) && (y.ZC(paramString1))) {}
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
  
  public final void a(d paramd)
  {
    this.QVH = paramd;
  }
  
  public final void n(final String paramString1, final int paramInt1, final int paramInt2, final String paramString2)
  {
    AppMethodBeat.i(97243);
    Log.i("SphereImageView.SphereImageLoader", "loadImage, view.w=" + paramInt1 + ", view.h=" + paramInt2 + ", scene=" + paramString2);
    if ((paramInt1 == 0) || (paramInt2 == 0))
    {
      AppMethodBeat.o(97243);
      return;
    }
    if (this.QVH != null) {
      this.QVH.aNZ(paramString1);
    }
    String str = aZE(paramString1);
    if (!TextUtils.isEmpty(str))
    {
      Log.i("SphereImageView.SphereImageLoader", "hit disk cache, path=".concat(String.valueOf(str)));
      new a(paramString1, paramInt1, paramInt2, paramString2).execute(new String[] { str });
      AppMethodBeat.o(97243);
      return;
    }
    Log.i("SphereImageView.SphereImageLoader", "no cache, download");
    k.b("adId", paramString1, new g.a()
    {
      public final void aWn(String paramAnonymousString)
      {
        AppMethodBeat.i(97234);
        Log.i("SphereImageView.SphereImageLoader", "loadImage onDownloaded, path=".concat(String.valueOf(paramAnonymousString)));
        new a.a(a.this, paramString1, paramInt1, paramInt2, paramString2).execute(new String[] { paramAnonymousString });
        AppMethodBeat.o(97234);
      }
      
      public final void gZM()
      {
        AppMethodBeat.i(97232);
        Log.i("SphereImageView.SphereImageLoader", "onStartDownload");
        AppMethodBeat.o(97232);
      }
      
      public final void gZN()
      {
        AppMethodBeat.i(97233);
        Log.e("SphereImageView.SphereImageLoader", "onDownloadError");
        MMHandlerThread.postToMainThread(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(97231);
            if (a.this.QVH != null) {
              a.this.QVH.a(false, "onDownloadError", null, a.1.this.PUd);
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
    int QVK;
    int QVL;
    String errorInfo = "";
    String scene;
    String url;
    
    public a(String paramString1, int paramInt1, int paramInt2, String paramString2)
    {
      this.url = paramString1;
      this.QVK = paramInt1;
      this.QVL = paramInt2;
      this.scene = paramString2;
    }
    
    /* Error */
    private Bitmap P(String... paramVarArgs)
    {
      // Byte code:
      //   0: iconst_1
      //   1: istore 6
      //   3: iconst_1
      //   4: istore 5
      //   6: iconst_0
      //   7: istore 4
      //   9: ldc 44
      //   11: invokestatic 50	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
      //   14: aload_1
      //   15: ifnull +17 -> 32
      //   18: aload_1
      //   19: arraylength
      //   20: ifeq +12 -> 32
      //   23: aload_1
      //   24: iconst_0
      //   25: aaload
      //   26: invokestatic 56	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
      //   29: ifeq +23 -> 52
      //   32: ldc 58
      //   34: ldc 60
      //   36: invokestatic 66	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
      //   39: aload_0
      //   40: ldc 68
      //   42: putfield 28	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/a$a:errorInfo	Ljava/lang/String;
      //   45: ldc 44
      //   47: invokestatic 71	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   50: aconst_null
      //   51: areturn
      //   52: aconst_null
      //   53: astore 13
      //   55: invokestatic 77	java/lang/System:currentTimeMillis	()J
      //   58: lstore 9
      //   60: aload_1
      //   61: iconst_0
      //   62: aaload
      //   63: astore 14
      //   65: iload 6
      //   67: istore_3
      //   68: new 79	android/graphics/BitmapFactory$Options
      //   71: dup
      //   72: invokespecial 80	android/graphics/BitmapFactory$Options:<init>	()V
      //   75: astore_1
      //   76: iload 6
      //   78: istore_3
      //   79: aload_1
      //   80: iconst_1
      //   81: putfield 84	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
      //   84: iload 6
      //   86: istore_3
      //   87: aload 14
      //   89: aload_1
      //   90: invokestatic 90	com/tencent/mm/graphics/MMBitmapFactory:decodeFile	(Ljava/lang/String;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
      //   93: pop
      //   94: iload 6
      //   96: istore_3
      //   97: aload_1
      //   98: getfield 93	android/graphics/BitmapFactory$Options:outWidth	I
      //   101: istore 7
      //   103: iload 6
      //   105: istore_3
      //   106: aload_1
      //   107: getfield 96	android/graphics/BitmapFactory$Options:outHeight	I
      //   110: istore 8
      //   112: iload 6
      //   114: istore_3
      //   115: ldc 98
      //   117: aload_0
      //   118: getfield 36	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/a$a:scene	Ljava/lang/String;
      //   121: if_acmpne +241 -> 362
      //   124: iload 5
      //   126: istore_2
      //   127: iload 7
      //   129: sipush 4000
      //   132: if_icmplt +24 -> 156
      //   135: iload 5
      //   137: istore_2
      //   138: iload 6
      //   140: istore_3
      //   141: aload_0
      //   142: getfield 21	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/a$a:QVI	Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/a;
      //   145: getfield 101	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/a:mScreenWidth	I
      //   148: sipush 1080
      //   151: if_icmpge +5 -> 156
      //   154: iconst_2
      //   155: istore_2
      //   156: iload_2
      //   157: istore_3
      //   158: ldc 58
      //   160: new 103	java/lang/StringBuilder
      //   163: dup
      //   164: ldc 105
      //   166: invokespecial 108	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
      //   169: iload 7
      //   171: invokevirtual 112	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
      //   174: ldc 114
      //   176: invokevirtual 117	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   179: iload 8
      //   181: invokevirtual 112	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
      //   184: ldc 119
      //   186: invokevirtual 117	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   189: aload_0
      //   190: getfield 21	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/a$a:QVI	Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/a;
      //   193: getfield 101	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/a:mScreenWidth	I
      //   196: invokevirtual 112	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
      //   199: ldc 121
      //   201: invokevirtual 117	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   204: aload_0
      //   205: getfield 21	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/a$a:QVI	Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/a;
      //   208: getfield 124	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/a:mScreenHeight	I
      //   211: invokevirtual 112	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
      //   214: ldc 126
      //   216: invokevirtual 117	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   219: aload_0
      //   220: getfield 32	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/a$a:QVK	I
      //   223: invokevirtual 112	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
      //   226: ldc 128
      //   228: invokevirtual 117	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   231: aload_0
      //   232: getfield 34	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/a$a:QVL	I
      //   235: invokevirtual 112	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
      //   238: ldc 130
      //   240: invokevirtual 117	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   243: iload_2
      //   244: invokevirtual 112	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
      //   247: invokevirtual 134	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   250: invokestatic 136	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
      //   253: iload_2
      //   254: istore_3
      //   255: aload_1
      //   256: iconst_0
      //   257: putfield 84	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
      //   260: iload_2
      //   261: istore_3
      //   262: aload_1
      //   263: iload_2
      //   264: putfield 139	android/graphics/BitmapFactory$Options:inSampleSize	I
      //   267: iload_2
      //   268: istore_3
      //   269: aload 14
      //   271: aload_1
      //   272: invokestatic 90	com/tencent/mm/graphics/MMBitmapFactory:decodeFile	(Ljava/lang/String;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
      //   275: astore_1
      //   276: invokestatic 77	java/lang/System:currentTimeMillis	()J
      //   279: lstore 11
      //   281: new 103	java/lang/StringBuilder
      //   284: dup
      //   285: ldc 141
      //   287: invokespecial 108	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
      //   290: lload 11
      //   292: lload 9
      //   294: lsub
      //   295: invokevirtual 144	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
      //   298: ldc 146
      //   300: invokevirtual 117	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   303: astore 13
      //   305: aload_1
      //   306: ifnonnull +288 -> 594
      //   309: iconst_0
      //   310: istore_2
      //   311: aload 13
      //   313: iload_2
      //   314: invokevirtual 112	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
      //   317: ldc 114
      //   319: invokevirtual 117	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   322: astore 13
      //   324: aload_1
      //   325: ifnonnull +277 -> 602
      //   328: iload 4
      //   330: istore_2
      //   331: ldc 58
      //   333: aload 13
      //   335: iload_2
      //   336: invokevirtual 112	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
      //   339: ldc 148
      //   341: invokevirtual 117	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   344: aload 14
      //   346: invokevirtual 117	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   349: invokevirtual 134	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   352: invokestatic 136	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
      //   355: ldc 44
      //   357: invokestatic 71	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   360: aload_1
      //   361: areturn
      //   362: iload 5
      //   364: istore_2
      //   365: iload 6
      //   367: istore_3
      //   368: ldc 150
      //   370: aload_0
      //   371: getfield 36	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/a$a:scene	Ljava/lang/String;
      //   374: if_acmpne -218 -> 156
      //   377: iload 7
      //   379: sipush 4000
      //   382: if_icmplt +24 -> 406
      //   385: iload 6
      //   387: istore_3
      //   388: aload_0
      //   389: getfield 21	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/a$a:QVI	Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/a;
      //   392: getfield 101	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/a:mScreenWidth	I
      //   395: sipush 1080
      //   398: if_icmplt +212 -> 610
      //   401: iconst_2
      //   402: istore_2
      //   403: goto -247 -> 156
      //   406: iload 5
      //   408: istore_2
      //   409: iload 7
      //   411: sipush 2000
      //   414: if_icmplt -258 -> 156
      //   417: iload 6
      //   419: istore_3
      //   420: aload_0
      //   421: getfield 21	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/a$a:QVI	Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/a;
      //   424: getfield 101	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/a:mScreenWidth	I
      //   427: istore 6
      //   429: iload 5
      //   431: istore_2
      //   432: iload 6
      //   434: sipush 1080
      //   437: if_icmpge -281 -> 156
      //   440: iconst_2
      //   441: istore_2
      //   442: goto -286 -> 156
      //   445: astore_1
      //   446: aload_0
      //   447: aload_1
      //   448: invokevirtual 151	java/lang/Exception:toString	()Ljava/lang/String;
      //   451: putfield 28	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/a$a:errorInfo	Ljava/lang/String;
      //   454: ldc 58
      //   456: new 103	java/lang/StringBuilder
      //   459: dup
      //   460: ldc 153
      //   462: invokespecial 108	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
      //   465: aload_0
      //   466: getfield 28	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/a$a:errorInfo	Ljava/lang/String;
      //   469: invokevirtual 117	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   472: invokevirtual 134	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   475: invokestatic 66	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
      //   478: aload 13
      //   480: astore_1
      //   481: goto -205 -> 276
      //   484: astore 15
      //   486: aload_0
      //   487: aload 15
      //   489: invokevirtual 154	java/lang/OutOfMemoryError:toString	()Ljava/lang/String;
      //   492: putfield 28	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/a$a:errorInfo	Ljava/lang/String;
      //   495: ldc 58
      //   497: new 103	java/lang/StringBuilder
      //   500: dup
      //   501: ldc 156
      //   503: invokespecial 108	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
      //   506: aload_0
      //   507: getfield 28	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/a$a:errorInfo	Ljava/lang/String;
      //   510: invokevirtual 117	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   513: invokevirtual 134	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   516: invokestatic 66	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
      //   519: ldc 58
      //   521: ldc 158
      //   523: invokestatic 136	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
      //   526: invokestatic 161	java/lang/System:gc	()V
      //   529: new 79	android/graphics/BitmapFactory$Options
      //   532: dup
      //   533: invokespecial 80	android/graphics/BitmapFactory$Options:<init>	()V
      //   536: astore_1
      //   537: aload_1
      //   538: iload_3
      //   539: iconst_1
      //   540: iadd
      //   541: putfield 139	android/graphics/BitmapFactory$Options:inSampleSize	I
      //   544: aload 14
      //   546: aload_1
      //   547: invokestatic 90	com/tencent/mm/graphics/MMBitmapFactory:decodeFile	(Ljava/lang/String;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
      //   550: astore_1
      //   551: goto -275 -> 276
      //   554: astore_1
      //   555: aload_0
      //   556: aload 15
      //   558: invokevirtual 154	java/lang/OutOfMemoryError:toString	()Ljava/lang/String;
      //   561: putfield 28	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/a$a:errorInfo	Ljava/lang/String;
      //   564: ldc 58
      //   566: new 103	java/lang/StringBuilder
      //   569: dup
      //   570: ldc 163
      //   572: invokespecial 108	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
      //   575: aload_0
      //   576: getfield 28	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/a$a:errorInfo	Ljava/lang/String;
      //   579: invokevirtual 117	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   582: invokevirtual 134	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   585: invokestatic 66	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
      //   588: aload 13
      //   590: astore_1
      //   591: goto -315 -> 276
      //   594: aload_1
      //   595: invokevirtual 169	android/graphics/Bitmap:getWidth	()I
      //   598: istore_2
      //   599: goto -288 -> 311
      //   602: aload_1
      //   603: invokevirtual 172	android/graphics/Bitmap:getHeight	()I
      //   606: istore_2
      //   607: goto -276 -> 331
      //   610: iconst_4
      //   611: istore_2
      //   612: goto -456 -> 156
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	615	0	this	a
      //   0	615	1	paramVarArgs	String[]
      //   126	486	2	i	int
      //   67	474	3	j	int
      //   7	322	4	k	int
      //   4	426	5	m	int
      //   1	437	6	n	int
      //   101	314	7	i1	int
      //   110	70	8	i2	int
      //   58	235	9	l1	long
      //   279	12	11	l2	long
      //   53	536	13	localStringBuilder	StringBuilder
      //   63	482	14	str	String
      //   484	73	15	localOutOfMemoryError	OutOfMemoryError
      // Exception table:
      //   from	to	target	type
      //   68	76	445	java/lang/Exception
      //   79	84	445	java/lang/Exception
      //   87	94	445	java/lang/Exception
      //   97	103	445	java/lang/Exception
      //   106	112	445	java/lang/Exception
      //   115	124	445	java/lang/Exception
      //   141	154	445	java/lang/Exception
      //   158	253	445	java/lang/Exception
      //   255	260	445	java/lang/Exception
      //   262	267	445	java/lang/Exception
      //   269	276	445	java/lang/Exception
      //   368	377	445	java/lang/Exception
      //   388	401	445	java/lang/Exception
      //   420	429	445	java/lang/Exception
      //   68	76	484	java/lang/OutOfMemoryError
      //   79	84	484	java/lang/OutOfMemoryError
      //   87	94	484	java/lang/OutOfMemoryError
      //   97	103	484	java/lang/OutOfMemoryError
      //   106	112	484	java/lang/OutOfMemoryError
      //   115	124	484	java/lang/OutOfMemoryError
      //   141	154	484	java/lang/OutOfMemoryError
      //   158	253	484	java/lang/OutOfMemoryError
      //   255	260	484	java/lang/OutOfMemoryError
      //   262	267	484	java/lang/OutOfMemoryError
      //   269	276	484	java/lang/OutOfMemoryError
      //   368	377	484	java/lang/OutOfMemoryError
      //   388	401	484	java/lang/OutOfMemoryError
      //   420	429	484	java/lang/OutOfMemoryError
      //   519	551	554	finally
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
    a.d QVM;
    String imageUrl;
    String scene;
    String thumbUrl;
    
    public c(String paramString1, String paramString2, String paramString3, a.d paramd)
    {
      this.imageUrl = paramString1;
      this.thumbUrl = paramString2;
      this.scene = paramString3;
      this.QVM = paramd;
    }
    
    private Bitmap gUg()
    {
      AppMethodBeat.i(97239);
      Bitmap localBitmap = a.my(this.imageUrl, this.scene);
      Object localObject1;
      if (localBitmap != null)
      {
        Log.i("SphereImageView.SphereImageLoader", "has shot");
        localObject1 = localBitmap;
      }
      for (;;)
      {
        AppMethodBeat.o(97239);
        return localObject1;
        localObject1 = localBitmap;
        try
        {
          if (TextUtils.isEmpty(this.thumbUrl)) {
            break label109;
          }
          localObject1 = localBitmap;
          localBitmap = k.mH("adId", this.thumbUrl);
          localObject1 = localBitmap;
          if (localBitmap == null) {
            continue;
          }
          localObject1 = localBitmap;
          Log.i("SphereImageView.SphereImageLoader", "has cache thumb");
          localObject1 = localBitmap;
          continue;
        }
        finally
        {
          Log.e("SphereImageView.SphereImageLoader", "getCachedImg exp:" + localObject2.toString());
        }
        continue;
        label109:
        localObject1 = localObject2;
        Log.e("SphereImageView.SphereImageLoader", "thumbUrl is empty");
        localObject1 = localObject2;
      }
    }
  }
  
  public static abstract interface d
  {
    public abstract void a(boolean paramBoolean, String paramString1, Bitmap paramBitmap, String paramString2);
    
    public abstract void aNZ(String paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.widget.SphereImageView.a
 * JD-Core Version:    0.7.0.1
 */