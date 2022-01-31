package com.google.android.gms.wearable.internal;

import android.app.PendingIntent;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.net.Uri;
import android.net.Uri.Builder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Looper;
import android.os.ParcelFileDescriptor;
import android.util.Log;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.s;
import com.google.android.gms.common.internal.ac;
import com.google.android.gms.common.internal.d;
import com.google.android.gms.internal.bb;
import com.google.android.gms.wearable.Asset;
import com.google.android.gms.wearable.PutDataRequest;
import com.google.android.gms.wearable.c;
import com.google.android.gms.wearable.f;
import com.google.android.gms.wearable.g;
import com.google.android.gms.wearable.q;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

public final class by
  extends ac<ap>
{
  private final ExecutorService TX;
  private final as<Object> TY = new as();
  private final as<Object> TZ = new as();
  private final as<c> Ua = new as();
  private final as<g> Ub = new as();
  private final as<q> Uc = new as();
  private final as<com.google.android.gms.wearable.x> Ud = new as();
  private final as<Object> Ue = new as();
  private final as<Object> Uf = new as();
  private final ca Ug;
  
  public by(Context paramContext, Looper paramLooper, com.google.android.gms.common.api.r paramr, s params, com.google.android.gms.common.internal.x paramx)
  {
    this(paramContext, paramLooper, paramr, params, paramx, Executors.newCachedThreadPool(), ca.v(paramContext));
  }
  
  private by(Context paramContext, Looper paramLooper, com.google.android.gms.common.api.r paramr, s params, com.google.android.gms.common.internal.x paramx, ExecutorService paramExecutorService, ca paramca)
  {
    super(paramContext, paramLooper, 14, paramx, paramr, params);
    this.TX = ((ExecutorService)d.u(paramExecutorService));
    this.Ug = paramca;
  }
  
  protected final void a(int paramInt1, IBinder paramIBinder, Bundle paramBundle, int paramInt2)
  {
    if (Log.isLoggable("WearableClient", 2)) {
      Log.d("WearableClient", 41 + "onPostInitHandler: statusCode " + paramInt1);
    }
    if (paramInt1 == 0)
    {
      this.TY.r(paramIBinder);
      this.TZ.r(paramIBinder);
      this.Ua.r(paramIBinder);
      this.Ub.r(paramIBinder);
      this.Uc.r(paramIBinder);
      this.Ud.r(paramIBinder);
      this.Ue.r(paramIBinder);
      this.Uf.r(paramIBinder);
    }
    super.a(paramInt1, paramIBinder, paramBundle, paramInt2);
  }
  
  public final void a(com.google.android.gms.common.internal.r paramr)
  {
    int i = 0;
    if (!gt()) {
      try
      {
        Object localObject = getContext().getPackageManager().getApplicationInfo("com.google.android.wearable.app.cn", 128).metaData;
        if (localObject != null) {
          i = ((Bundle)localObject).getInt("com.google.android.wearable.api.version", 0);
        }
        if (i < com.google.android.gms.common.h.Hi)
        {
          int j = com.google.android.gms.common.h.Hi;
          Log.w("WearableClient", 80 + "Android Wear out of date. Requires API version " + j + " but found " + i);
          Context localContext1 = getContext();
          Context localContext2 = getContext();
          localObject = new Intent("com.google.android.wearable.app.cn.UPDATE_ANDROID_WEAR").setPackage("com.google.android.wearable.app.cn");
          if (localContext2.getPackageManager().resolveActivity((Intent)localObject, 65536) != null) {}
          for (;;)
          {
            a(paramr, 6, PendingIntent.getActivity(localContext1, 0, (Intent)localObject, 0));
            return;
            localObject = new Intent("android.intent.action.VIEW", Uri.parse("market://details").buildUpon().appendQueryParameter("id", "com.google.android.wearable.app.cn").build());
          }
        }
        super.a(paramr);
      }
      catch (PackageManager.NameNotFoundException localNameNotFoundException)
      {
        a(paramr, 16, null);
        return;
      }
    }
  }
  
  public final void a(com.google.android.gms.internal.h<f> paramh, PutDataRequest paramPutDataRequest)
  {
    Object localObject2 = paramPutDataRequest.kv().entrySet().iterator();
    while (((Iterator)localObject2).hasNext())
    {
      localObject1 = (Asset)((Map.Entry)((Iterator)localObject2).next()).getValue();
      if ((((Asset)localObject1).getData() == null) && (((Asset)localObject1).kp() == null) && (((Asset)localObject1).Sj == null) && (((Asset)localObject1).uri == null))
      {
        paramh = String.valueOf(paramPutDataRequest.getUri());
        paramPutDataRequest = String.valueOf(localObject1);
        throw new IllegalArgumentException(String.valueOf(paramh).length() + 33 + String.valueOf(paramPutDataRequest).length() + "Put for " + paramh + " contains invalid asset: " + paramPutDataRequest);
      }
    }
    localObject2 = PutDataRequest.d(paramPutDataRequest.getUri());
    ((PutDataRequest)localObject2).f(paramPutDataRequest.getData());
    if (paramPutDataRequest.kF()) {
      ((PutDataRequest)localObject2).kG();
    }
    Object localObject1 = new ArrayList();
    Iterator localIterator = paramPutDataRequest.kv().entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      Object localObject3 = (Asset)localEntry.getValue();
      Object localObject4;
      if (((Asset)localObject3).getData() != null) {
        try
        {
          localObject4 = ParcelFileDescriptor.createPipe();
          if (Log.isLoggable("WearableClient", 3))
          {
            String str1 = String.valueOf(localObject3);
            String str2 = String.valueOf(localObject4[0]);
            String str3 = String.valueOf(localObject4[1]);
            Log.d("WearableClient", String.valueOf(str1).length() + 61 + String.valueOf(str2).length() + String.valueOf(str3).length() + "processAssets: replacing data with FD in asset: " + str1 + " read:" + str2 + " write:" + str3);
          }
          ((PutDataRequest)localObject2).b((String)localEntry.getKey(), Asset.a(localObject4[0]));
          localObject3 = new FutureTask(new Callable()
          {
            /* Error */
            private Boolean kK()
            {
              // Byte code:
              //   0: ldc 29
              //   2: iconst_3
              //   3: invokestatic 35	android/util/Log:isLoggable	(Ljava/lang/String;I)Z
              //   6: ifeq +46 -> 52
              //   9: aload_0
              //   10: getfield 17	com/google/android/gms/wearable/internal/by$1:Uh	Landroid/os/ParcelFileDescriptor;
              //   13: invokestatic 41	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
              //   16: astore_1
              //   17: ldc 29
              //   19: new 43	java/lang/StringBuilder
              //   22: dup
              //   23: aload_1
              //   24: invokestatic 41	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
              //   27: invokevirtual 47	java/lang/String:length	()I
              //   30: bipush 36
              //   32: iadd
              //   33: invokespecial 50	java/lang/StringBuilder:<init>	(I)V
              //   36: ldc 52
              //   38: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
              //   41: aload_1
              //   42: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
              //   45: invokevirtual 60	java/lang/StringBuilder:toString	()Ljava/lang/String;
              //   48: invokestatic 64	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
              //   51: pop
              //   52: new 66	android/os/ParcelFileDescriptor$AutoCloseOutputStream
              //   55: dup
              //   56: aload_0
              //   57: getfield 17	com/google/android/gms/wearable/internal/by$1:Uh	Landroid/os/ParcelFileDescriptor;
              //   60: invokespecial 69	android/os/ParcelFileDescriptor$AutoCloseOutputStream:<init>	(Landroid/os/ParcelFileDescriptor;)V
              //   63: astore_1
              //   64: aload_1
              //   65: aload_0
              //   66: getfield 19	com/google/android/gms/wearable/internal/by$1:TE	[B
              //   69: invokevirtual 73	android/os/ParcelFileDescriptor$AutoCloseOutputStream:write	([B)V
              //   72: aload_1
              //   73: invokevirtual 76	android/os/ParcelFileDescriptor$AutoCloseOutputStream:flush	()V
              //   76: ldc 29
              //   78: iconst_3
              //   79: invokestatic 35	android/util/Log:isLoggable	(Ljava/lang/String;I)Z
              //   82: ifeq +46 -> 128
              //   85: aload_0
              //   86: getfield 17	com/google/android/gms/wearable/internal/by$1:Uh	Landroid/os/ParcelFileDescriptor;
              //   89: invokestatic 41	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
              //   92: astore_2
              //   93: ldc 29
              //   95: new 43	java/lang/StringBuilder
              //   98: dup
              //   99: aload_2
              //   100: invokestatic 41	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
              //   103: invokevirtual 47	java/lang/String:length	()I
              //   106: bipush 27
              //   108: iadd
              //   109: invokespecial 50	java/lang/StringBuilder:<init>	(I)V
              //   112: ldc 78
              //   114: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
              //   117: aload_2
              //   118: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
              //   121: invokevirtual 60	java/lang/StringBuilder:toString	()Ljava/lang/String;
              //   124: invokestatic 64	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
              //   127: pop
              //   128: iconst_1
              //   129: invokestatic 83	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
              //   132: astore_2
              //   133: ldc 29
              //   135: iconst_3
              //   136: invokestatic 35	android/util/Log:isLoggable	(Ljava/lang/String;I)Z
              //   139: ifeq +46 -> 185
              //   142: aload_0
              //   143: getfield 17	com/google/android/gms/wearable/internal/by$1:Uh	Landroid/os/ParcelFileDescriptor;
              //   146: invokestatic 41	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
              //   149: astore_3
              //   150: ldc 29
              //   152: new 43	java/lang/StringBuilder
              //   155: dup
              //   156: aload_3
              //   157: invokestatic 41	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
              //   160: invokevirtual 47	java/lang/String:length	()I
              //   163: bipush 24
              //   165: iadd
              //   166: invokespecial 50	java/lang/StringBuilder:<init>	(I)V
              //   169: ldc 85
              //   171: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
              //   174: aload_3
              //   175: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
              //   178: invokevirtual 60	java/lang/StringBuilder:toString	()Ljava/lang/String;
              //   181: invokestatic 64	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
              //   184: pop
              //   185: aload_1
              //   186: invokevirtual 88	android/os/ParcelFileDescriptor$AutoCloseOutputStream:close	()V
              //   189: aload_2
              //   190: areturn
              //   191: astore_2
              //   192: aload_0
              //   193: getfield 17	com/google/android/gms/wearable/internal/by$1:Uh	Landroid/os/ParcelFileDescriptor;
              //   196: invokestatic 41	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
              //   199: astore_2
              //   200: ldc 29
              //   202: new 43	java/lang/StringBuilder
              //   205: dup
              //   206: aload_2
              //   207: invokestatic 41	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
              //   210: invokevirtual 47	java/lang/String:length	()I
              //   213: bipush 36
              //   215: iadd
              //   216: invokespecial 50	java/lang/StringBuilder:<init>	(I)V
              //   219: ldc 90
              //   221: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
              //   224: aload_2
              //   225: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
              //   228: invokevirtual 60	java/lang/StringBuilder:toString	()Ljava/lang/String;
              //   231: invokestatic 93	android/util/Log:w	(Ljava/lang/String;Ljava/lang/String;)I
              //   234: pop
              //   235: ldc 29
              //   237: iconst_3
              //   238: invokestatic 35	android/util/Log:isLoggable	(Ljava/lang/String;I)Z
              //   241: ifeq +46 -> 287
              //   244: aload_0
              //   245: getfield 17	com/google/android/gms/wearable/internal/by$1:Uh	Landroid/os/ParcelFileDescriptor;
              //   248: invokestatic 41	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
              //   251: astore_2
              //   252: ldc 29
              //   254: new 43	java/lang/StringBuilder
              //   257: dup
              //   258: aload_2
              //   259: invokestatic 41	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
              //   262: invokevirtual 47	java/lang/String:length	()I
              //   265: bipush 24
              //   267: iadd
              //   268: invokespecial 50	java/lang/StringBuilder:<init>	(I)V
              //   271: ldc 85
              //   273: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
              //   276: aload_2
              //   277: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
              //   280: invokevirtual 60	java/lang/StringBuilder:toString	()Ljava/lang/String;
              //   283: invokestatic 64	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
              //   286: pop
              //   287: aload_1
              //   288: invokevirtual 88	android/os/ParcelFileDescriptor$AutoCloseOutputStream:close	()V
              //   291: iconst_0
              //   292: invokestatic 83	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
              //   295: areturn
              //   296: astore_2
              //   297: ldc 29
              //   299: iconst_3
              //   300: invokestatic 35	android/util/Log:isLoggable	(Ljava/lang/String;I)Z
              //   303: ifeq +46 -> 349
              //   306: aload_0
              //   307: getfield 17	com/google/android/gms/wearable/internal/by$1:Uh	Landroid/os/ParcelFileDescriptor;
              //   310: invokestatic 41	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
              //   313: astore_3
              //   314: ldc 29
              //   316: new 43	java/lang/StringBuilder
              //   319: dup
              //   320: aload_3
              //   321: invokestatic 41	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
              //   324: invokevirtual 47	java/lang/String:length	()I
              //   327: bipush 24
              //   329: iadd
              //   330: invokespecial 50	java/lang/StringBuilder:<init>	(I)V
              //   333: ldc 85
              //   335: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
              //   338: aload_3
              //   339: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
              //   342: invokevirtual 60	java/lang/StringBuilder:toString	()Ljava/lang/String;
              //   345: invokestatic 64	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
              //   348: pop
              //   349: aload_1
              //   350: invokevirtual 88	android/os/ParcelFileDescriptor$AutoCloseOutputStream:close	()V
              //   353: aload_2
              //   354: athrow
              //   355: astore_1
              //   356: goto -3 -> 353
              //   359: astore_1
              //   360: goto -69 -> 291
              //   363: astore_1
              //   364: aload_2
              //   365: areturn
              // Local variable table:
              //   start	length	slot	name	signature
              //   0	366	0	this	1
              //   16	334	1	localObject1	Object
              //   355	1	1	localIOException1	IOException
              //   359	1	1	localIOException2	IOException
              //   363	1	1	localIOException3	IOException
              //   92	98	2	localObject2	Object
              //   191	1	2	localIOException4	IOException
              //   199	78	2	str1	String
              //   296	69	2	localBoolean	Boolean
              //   149	190	3	str2	String
              // Exception table:
              //   from	to	target	type
              //   64	128	191	java/io/IOException
              //   128	133	191	java/io/IOException
              //   64	128	296	finally
              //   128	133	296	finally
              //   192	235	296	finally
              //   297	349	355	java/io/IOException
              //   349	353	355	java/io/IOException
              //   235	287	359	java/io/IOException
              //   287	291	359	java/io/IOException
              //   133	185	363	java/io/IOException
              //   185	189	363	java/io/IOException
            }
          });
          ((List)localObject1).add(localObject3);
          this.TX.submit((Runnable)localObject3);
        }
        catch (IOException paramh)
        {
          paramPutDataRequest = String.valueOf(paramPutDataRequest);
          throw new IllegalStateException(String.valueOf(paramPutDataRequest).length() + 60 + "Unable to create ParcelFileDescriptor for asset in request: " + paramPutDataRequest, paramh);
        }
      } else if (((Asset)localObject3).uri != null) {
        try
        {
          localObject4 = Asset.a(getContext().getContentResolver().openFileDescriptor(((Asset)localObject3).uri, "r"));
          ((PutDataRequest)localObject2).b((String)localEntry.getKey(), (Asset)localObject4);
        }
        catch (FileNotFoundException paramPutDataRequest)
        {
          new bv(paramh, (List)localObject1).a(new zzci(4005, null));
          paramh = String.valueOf(((Asset)localObject3).uri);
          Log.w("WearableClient", String.valueOf(paramh).length() + 28 + "Couldn't resolve asset URI: " + paramh);
          return;
        }
      } else {
        ((PutDataRequest)localObject2).b((String)localEntry.getKey(), (Asset)localObject3);
      }
    }
    ((ap)hh()).a(new bv(paramh, (List)localObject1), (PutDataRequest)localObject2);
  }
  
  public final void a(com.google.android.gms.internal.h<Status> paramh, c paramc, bb<c> parambb, IntentFilter[] paramArrayOfIntentFilter)
  {
    this.Ua.a(this, paramh, paramc, bz.a(parambb, paramArrayOfIntentFilter));
  }
  
  public final void a(com.google.android.gms.internal.h<Status> paramh, c paramc, String paramString)
  {
    if (paramString == null)
    {
      this.Ua.a(this, paramh, paramc);
      return;
    }
    paramc = new bi(paramString, paramc);
    this.Ua.a(this, paramh, paramc);
  }
  
  /* Error */
  public final void a(final com.google.android.gms.internal.h<Status> paramh, final String paramString, final Uri paramUri, final long paramLong1, long paramLong2)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 79	com/google/android/gms/wearable/internal/by:TX	Ljava/util/concurrent/ExecutorService;
    //   4: astore 9
    //   6: aload_1
    //   7: invokestatic 75	com/google/android/gms/common/internal/d:u	(Ljava/lang/Object;)Ljava/lang/Object;
    //   10: pop
    //   11: aload_2
    //   12: invokestatic 75	com/google/android/gms/common/internal/d:u	(Ljava/lang/Object;)Ljava/lang/Object;
    //   15: pop
    //   16: aload_3
    //   17: invokestatic 75	com/google/android/gms/common/internal/d:u	(Ljava/lang/Object;)Ljava/lang/Object;
    //   20: pop
    //   21: lload 4
    //   23: lconst_0
    //   24: lcmp
    //   25: iflt +81 -> 106
    //   28: iconst_1
    //   29: istore 8
    //   31: iload 8
    //   33: ldc_w 428
    //   36: iconst_1
    //   37: anewarray 430	java/lang/Object
    //   40: dup
    //   41: iconst_0
    //   42: lload 4
    //   44: invokestatic 435	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   47: aastore
    //   48: invokestatic 438	com/google/android/gms/common/internal/d:a	(ZLjava/lang/String;[Ljava/lang/Object;)V
    //   51: lload 6
    //   53: ldc2_w 439
    //   56: lcmp
    //   57: iflt +55 -> 112
    //   60: iconst_1
    //   61: istore 8
    //   63: iload 8
    //   65: ldc_w 442
    //   68: iconst_1
    //   69: anewarray 430	java/lang/Object
    //   72: dup
    //   73: iconst_0
    //   74: lload 6
    //   76: invokestatic 435	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   79: aastore
    //   80: invokestatic 438	com/google/android/gms/common/internal/d:a	(ZLjava/lang/String;[Ljava/lang/Object;)V
    //   83: aload 9
    //   85: new 9	com/google/android/gms/wearable/internal/by$2
    //   88: dup
    //   89: aload_0
    //   90: aload_3
    //   91: aload_1
    //   92: aload_2
    //   93: lload 4
    //   95: lload 6
    //   97: invokespecial 445	com/google/android/gms/wearable/internal/by$2:<init>	(Lcom/google/android/gms/wearable/internal/by;Landroid/net/Uri;Lcom/google/android/gms/internal/h;Ljava/lang/String;JJ)V
    //   100: invokeinterface 449 2 0
    //   105: return
    //   106: iconst_0
    //   107: istore 8
    //   109: goto -78 -> 31
    //   112: iconst_0
    //   113: istore 8
    //   115: goto -52 -> 63
    //   118: astore_2
    //   119: aload_1
    //   120: new 451	com/google/android/gms/common/api/Status
    //   123: dup
    //   124: bipush 8
    //   126: invokespecial 452	com/google/android/gms/common/api/Status:<init>	(I)V
    //   129: invokeinterface 457 2 0
    //   134: aload_2
    //   135: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	136	0	this	by
    //   0	136	1	paramh	com.google.android.gms.internal.h<Status>
    //   0	136	2	paramString	String
    //   0	136	3	paramUri	Uri
    //   0	136	4	paramLong1	long
    //   0	136	6	paramLong2	long
    //   29	85	8	bool	boolean
    //   4	80	9	localExecutorService	ExecutorService
    // Exception table:
    //   from	to	target	type
    //   0	21	118	java/lang/RuntimeException
    //   31	51	118	java/lang/RuntimeException
    //   63	105	118	java/lang/RuntimeException
  }
  
  public final boolean gt()
  {
    return !this.Ug.y("com.google.android.wearable.app.cn");
  }
  
  protected final String gv()
  {
    return "com.google.android.gms.wearable.BIND";
  }
  
  protected final String gw()
  {
    return "com.google.android.gms.wearable.internal.IWearableService";
  }
  
  protected final String hd()
  {
    if (this.Ug.y("com.google.android.wearable.app.cn")) {
      return "com.google.android.wearable.app.cn";
    }
    return "com.google.android.gms";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.google.android.gms.wearable.internal.by
 * JD-Core Version:    0.7.0.1
 */