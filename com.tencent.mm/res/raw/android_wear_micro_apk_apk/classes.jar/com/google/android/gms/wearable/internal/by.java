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
  private final ExecutorService VM;
  private final as<Object> VN = new as();
  private final as<Object> VO = new as();
  private final as<c> VP = new as();
  private final as<g> VQ = new as();
  private final as<q> VR = new as();
  private final as<com.google.android.gms.wearable.x> VS = new as();
  private final as<Object> VT = new as();
  private final as<Object> VU = new as();
  private final ca VV;
  
  public by(Context paramContext, Looper paramLooper, com.google.android.gms.common.api.r paramr, s params, com.google.android.gms.common.internal.x paramx)
  {
    this(paramContext, paramLooper, paramr, params, paramx, Executors.newCachedThreadPool(), ca.w(paramContext));
  }
  
  private by(Context paramContext, Looper paramLooper, com.google.android.gms.common.api.r paramr, s params, com.google.android.gms.common.internal.x paramx, ExecutorService paramExecutorService, ca paramca)
  {
    super(paramContext, paramLooper, 14, paramx, paramr, params);
    this.VM = ((ExecutorService)d.D(paramExecutorService));
    this.VV = paramca;
  }
  
  protected final void a(int paramInt1, IBinder paramIBinder, Bundle paramBundle, int paramInt2)
  {
    if (Log.isLoggable("WearableClient", 2)) {
      Log.d("WearableClient", 41 + "onPostInitHandler: statusCode " + paramInt1);
    }
    if (paramInt1 == 0)
    {
      this.VN.r(paramIBinder);
      this.VO.r(paramIBinder);
      this.VP.r(paramIBinder);
      this.VQ.r(paramIBinder);
      this.VR.r(paramIBinder);
      this.VS.r(paramIBinder);
      this.VT.r(paramIBinder);
      this.VU.r(paramIBinder);
    }
    super.a(paramInt1, paramIBinder, paramBundle, paramInt2);
  }
  
  public final void a(com.google.android.gms.common.internal.r paramr)
  {
    int i = 0;
    if (!gD()) {
      try
      {
        Object localObject = getContext().getPackageManager().getApplicationInfo("com.google.android.wearable.app.cn", 128).metaData;
        if (localObject != null) {
          i = ((Bundle)localObject).getInt("com.google.android.wearable.api.version", 0);
        }
        if (i < com.google.android.gms.common.h.IX)
        {
          int j = com.google.android.gms.common.h.IX;
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
    Object localObject2 = paramPutDataRequest.kE().entrySet().iterator();
    while (((Iterator)localObject2).hasNext())
    {
      localObject1 = (Asset)((Map.Entry)((Iterator)localObject2).next()).getValue();
      if ((((Asset)localObject1).getData() == null) && (((Asset)localObject1).ky() == null) && (((Asset)localObject1).TY == null) && (((Asset)localObject1).uri == null))
      {
        paramh = String.valueOf(paramPutDataRequest.getUri());
        paramPutDataRequest = String.valueOf(localObject1);
        throw new IllegalArgumentException(String.valueOf(paramh).length() + 33 + String.valueOf(paramPutDataRequest).length() + "Put for " + paramh + " contains invalid asset: " + paramPutDataRequest);
      }
    }
    localObject2 = PutDataRequest.d(paramPutDataRequest.getUri());
    ((PutDataRequest)localObject2).f(paramPutDataRequest.getData());
    if (paramPutDataRequest.kO()) {
      ((PutDataRequest)localObject2).kP();
    }
    Object localObject1 = new ArrayList();
    Iterator localIterator = paramPutDataRequest.kE().entrySet().iterator();
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
            private Boolean kT()
            {
              // Byte code:
              //   0: ldc 29
              //   2: iconst_3
              //   3: invokestatic 35	android/util/Log:isLoggable	(Ljava/lang/String;I)Z
              //   6: ifeq +46 -> 52
              //   9: aload_0
              //   10: getfield 17	com/google/android/gms/wearable/internal/by$1:VW	Landroid/os/ParcelFileDescriptor;
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
              //   57: getfield 17	com/google/android/gms/wearable/internal/by$1:VW	Landroid/os/ParcelFileDescriptor;
              //   60: invokespecial 69	android/os/ParcelFileDescriptor$AutoCloseOutputStream:<init>	(Landroid/os/ParcelFileDescriptor;)V
              //   63: astore_1
              //   64: aload_1
              //   65: aload_0
              //   66: getfield 19	com/google/android/gms/wearable/internal/by$1:Vt	[B
              //   69: invokevirtual 73	android/os/ParcelFileDescriptor$AutoCloseOutputStream:write	([B)V
              //   72: aload_1
              //   73: invokevirtual 76	android/os/ParcelFileDescriptor$AutoCloseOutputStream:flush	()V
              //   76: ldc 29
              //   78: iconst_3
              //   79: invokestatic 35	android/util/Log:isLoggable	(Ljava/lang/String;I)Z
              //   82: ifeq +46 -> 128
              //   85: aload_0
              //   86: getfield 17	com/google/android/gms/wearable/internal/by$1:VW	Landroid/os/ParcelFileDescriptor;
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
              //   128: getstatic 84	java/lang/Boolean:TRUE	Ljava/lang/Boolean;
              //   131: astore_2
              //   132: ldc 29
              //   134: iconst_3
              //   135: invokestatic 35	android/util/Log:isLoggable	(Ljava/lang/String;I)Z
              //   138: ifeq +46 -> 184
              //   141: aload_0
              //   142: getfield 17	com/google/android/gms/wearable/internal/by$1:VW	Landroid/os/ParcelFileDescriptor;
              //   145: invokestatic 41	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
              //   148: astore_3
              //   149: ldc 29
              //   151: new 43	java/lang/StringBuilder
              //   154: dup
              //   155: aload_3
              //   156: invokestatic 41	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
              //   159: invokevirtual 47	java/lang/String:length	()I
              //   162: bipush 24
              //   164: iadd
              //   165: invokespecial 50	java/lang/StringBuilder:<init>	(I)V
              //   168: ldc 86
              //   170: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
              //   173: aload_3
              //   174: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
              //   177: invokevirtual 60	java/lang/StringBuilder:toString	()Ljava/lang/String;
              //   180: invokestatic 64	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
              //   183: pop
              //   184: aload_1
              //   185: invokevirtual 89	android/os/ParcelFileDescriptor$AutoCloseOutputStream:close	()V
              //   188: aload_2
              //   189: areturn
              //   190: astore_2
              //   191: aload_0
              //   192: getfield 17	com/google/android/gms/wearable/internal/by$1:VW	Landroid/os/ParcelFileDescriptor;
              //   195: invokestatic 41	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
              //   198: astore_2
              //   199: ldc 29
              //   201: new 43	java/lang/StringBuilder
              //   204: dup
              //   205: aload_2
              //   206: invokestatic 41	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
              //   209: invokevirtual 47	java/lang/String:length	()I
              //   212: bipush 36
              //   214: iadd
              //   215: invokespecial 50	java/lang/StringBuilder:<init>	(I)V
              //   218: ldc 91
              //   220: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
              //   223: aload_2
              //   224: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
              //   227: invokevirtual 60	java/lang/StringBuilder:toString	()Ljava/lang/String;
              //   230: invokestatic 94	android/util/Log:w	(Ljava/lang/String;Ljava/lang/String;)I
              //   233: pop
              //   234: ldc 29
              //   236: iconst_3
              //   237: invokestatic 35	android/util/Log:isLoggable	(Ljava/lang/String;I)Z
              //   240: ifeq +46 -> 286
              //   243: aload_0
              //   244: getfield 17	com/google/android/gms/wearable/internal/by$1:VW	Landroid/os/ParcelFileDescriptor;
              //   247: invokestatic 41	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
              //   250: astore_2
              //   251: ldc 29
              //   253: new 43	java/lang/StringBuilder
              //   256: dup
              //   257: aload_2
              //   258: invokestatic 41	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
              //   261: invokevirtual 47	java/lang/String:length	()I
              //   264: bipush 24
              //   266: iadd
              //   267: invokespecial 50	java/lang/StringBuilder:<init>	(I)V
              //   270: ldc 86
              //   272: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
              //   275: aload_2
              //   276: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
              //   279: invokevirtual 60	java/lang/StringBuilder:toString	()Ljava/lang/String;
              //   282: invokestatic 64	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
              //   285: pop
              //   286: aload_1
              //   287: invokevirtual 89	android/os/ParcelFileDescriptor$AutoCloseOutputStream:close	()V
              //   290: getstatic 97	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
              //   293: areturn
              //   294: astore_2
              //   295: ldc 29
              //   297: iconst_3
              //   298: invokestatic 35	android/util/Log:isLoggable	(Ljava/lang/String;I)Z
              //   301: ifeq +46 -> 347
              //   304: aload_0
              //   305: getfield 17	com/google/android/gms/wearable/internal/by$1:VW	Landroid/os/ParcelFileDescriptor;
              //   308: invokestatic 41	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
              //   311: astore_3
              //   312: ldc 29
              //   314: new 43	java/lang/StringBuilder
              //   317: dup
              //   318: aload_3
              //   319: invokestatic 41	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
              //   322: invokevirtual 47	java/lang/String:length	()I
              //   325: bipush 24
              //   327: iadd
              //   328: invokespecial 50	java/lang/StringBuilder:<init>	(I)V
              //   331: ldc 86
              //   333: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
              //   336: aload_3
              //   337: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
              //   340: invokevirtual 60	java/lang/StringBuilder:toString	()Ljava/lang/String;
              //   343: invokestatic 64	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
              //   346: pop
              //   347: aload_1
              //   348: invokevirtual 89	android/os/ParcelFileDescriptor$AutoCloseOutputStream:close	()V
              //   351: aload_2
              //   352: athrow
              //   353: astore_1
              //   354: goto -3 -> 351
              //   357: astore_1
              //   358: goto -68 -> 290
              //   361: astore_1
              //   362: aload_2
              //   363: areturn
              // Local variable table:
              //   start	length	slot	name	signature
              //   0	364	0	this	1
              //   16	332	1	localObject1	Object
              //   353	1	1	localIOException1	IOException
              //   357	1	1	localIOException2	IOException
              //   361	1	1	localIOException3	IOException
              //   92	97	2	localObject2	Object
              //   190	1	2	localIOException4	IOException
              //   198	78	2	str1	String
              //   294	69	2	localBoolean	Boolean
              //   148	189	3	str2	String
              // Exception table:
              //   from	to	target	type
              //   64	128	190	java/io/IOException
              //   128	132	190	java/io/IOException
              //   64	128	294	finally
              //   128	132	294	finally
              //   191	234	294	finally
              //   295	347	353	java/io/IOException
              //   347	351	353	java/io/IOException
              //   234	286	357	java/io/IOException
              //   286	290	357	java/io/IOException
              //   132	184	361	java/io/IOException
              //   184	188	361	java/io/IOException
            }
          });
          ((List)localObject1).add(localObject3);
          this.VM.submit((Runnable)localObject3);
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
    ((ap)hr()).a(new bv(paramh, (List)localObject1), (PutDataRequest)localObject2);
  }
  
  public final void a(com.google.android.gms.internal.h<Status> paramh, c paramc, bb<c> parambb, IntentFilter[] paramArrayOfIntentFilter)
  {
    this.VP.a(this, paramh, paramc, bz.a(parambb, paramArrayOfIntentFilter));
  }
  
  public final void a(com.google.android.gms.internal.h<Status> paramh, c paramc, String paramString)
  {
    if (paramString == null)
    {
      this.VP.a(this, paramh, paramc);
      return;
    }
    paramc = new bi(paramString, paramc);
    this.VP.a(this, paramh, paramc);
  }
  
  /* Error */
  public final void a(final com.google.android.gms.internal.h<Status> paramh, final String paramString, final Uri paramUri, final long paramLong1, long paramLong2)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 79	com/google/android/gms/wearable/internal/by:VM	Ljava/util/concurrent/ExecutorService;
    //   4: astore 9
    //   6: aload_1
    //   7: invokestatic 75	com/google/android/gms/common/internal/d:D	(Ljava/lang/Object;)Ljava/lang/Object;
    //   10: pop
    //   11: aload_2
    //   12: invokestatic 75	com/google/android/gms/common/internal/d:D	(Ljava/lang/Object;)Ljava/lang/Object;
    //   15: pop
    //   16: aload_3
    //   17: invokestatic 75	com/google/android/gms/common/internal/d:D	(Ljava/lang/Object;)Ljava/lang/Object;
    //   20: pop
    //   21: lload 4
    //   23: lconst_0
    //   24: lcmp
    //   25: iflt +81 -> 106
    //   28: iconst_1
    //   29: istore 8
    //   31: iload 8
    //   33: ldc_w 427
    //   36: iconst_1
    //   37: anewarray 429	java/lang/Object
    //   40: dup
    //   41: iconst_0
    //   42: lload 4
    //   44: invokestatic 434	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   47: aastore
    //   48: invokestatic 437	com/google/android/gms/common/internal/d:a	(ZLjava/lang/String;[Ljava/lang/Object;)V
    //   51: lload 6
    //   53: ldc2_w 438
    //   56: lcmp
    //   57: iflt +55 -> 112
    //   60: iconst_1
    //   61: istore 8
    //   63: iload 8
    //   65: ldc_w 441
    //   68: iconst_1
    //   69: anewarray 429	java/lang/Object
    //   72: dup
    //   73: iconst_0
    //   74: lload 6
    //   76: invokestatic 434	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   79: aastore
    //   80: invokestatic 437	com/google/android/gms/common/internal/d:a	(ZLjava/lang/String;[Ljava/lang/Object;)V
    //   83: aload 9
    //   85: new 9	com/google/android/gms/wearable/internal/by$2
    //   88: dup
    //   89: aload_0
    //   90: aload_3
    //   91: aload_1
    //   92: aload_2
    //   93: lload 4
    //   95: lload 6
    //   97: invokespecial 444	com/google/android/gms/wearable/internal/by$2:<init>	(Lcom/google/android/gms/wearable/internal/by;Landroid/net/Uri;Lcom/google/android/gms/internal/h;Ljava/lang/String;JJ)V
    //   100: invokeinterface 448 2 0
    //   105: return
    //   106: iconst_0
    //   107: istore 8
    //   109: goto -78 -> 31
    //   112: iconst_0
    //   113: istore 8
    //   115: goto -52 -> 63
    //   118: astore_2
    //   119: aload_1
    //   120: new 450	com/google/android/gms/common/api/Status
    //   123: dup
    //   124: bipush 8
    //   126: invokespecial 451	com/google/android/gms/common/api/Status:<init>	(I)V
    //   129: invokeinterface 456 2 0
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
  
  public final boolean gD()
  {
    return !this.VV.y("com.google.android.wearable.app.cn");
  }
  
  protected final String gF()
  {
    return "com.google.android.gms.wearable.BIND";
  }
  
  protected final String gG()
  {
    return "com.google.android.gms.wearable.internal.IWearableService";
  }
  
  protected final String hn()
  {
    if (this.VV.y("com.google.android.wearable.app.cn")) {
      return "com.google.android.wearable.app.cn";
    }
    return "com.google.android.gms";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.google.android.gms.wearable.internal.by
 * JD-Core Version:    0.7.0.1
 */