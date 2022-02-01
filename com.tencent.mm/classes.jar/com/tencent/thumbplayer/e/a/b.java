package com.tencent.thumbplayer.e.a;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.thumbplayer.api.resourceloader.ITPAssetResourceLoaderListener;
import com.tencent.thumbplayer.api.resourceloader.ITPAssetResourceLoadingRequest;
import com.tencent.thumbplayer.api.resourceloader.TPAssetResourceLoadingContentInformationRequest;
import com.tencent.thumbplayer.core.downloadproxy.utils.TPDLFileSystem;
import com.tencent.thumbplayer.core.downloadproxy.utils.TPDLIOUtil;
import com.tencent.thumbplayer.utils.g;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

public final class b
  implements a
{
  private static String TAG = "TPAssetResourceLoader";
  private ITPAssetResourceLoaderListener RZT;
  private long RZU;
  private String RZV;
  private String RZW;
  private String RZX;
  private int RZY;
  private ArrayList<d> RZZ;
  private TPAssetResourceLoadingContentInformationRequest Saa;
  private HandlerThread Sab;
  private a Sac;
  private String mContentType;
  private Context mContext;
  private HandlerThread mHandlerThread;
  
  public b(Context paramContext, Looper paramLooper)
  {
    AppMethodBeat.i(189243);
    this.RZU = 0L;
    this.mContentType = "";
    this.RZV = "";
    this.RZW = "";
    this.RZX = ".mp4";
    this.RZY = 0;
    this.mContext = paramContext;
    this.RZZ = new ArrayList();
    paramContext = paramLooper;
    if (paramLooper == null)
    {
      this.mHandlerThread = new HandlerThread("TPAssetResourceLoader-callbackThread");
      this.mHandlerThread.start();
      paramContext = this.mHandlerThread.getLooper();
    }
    this.Sac = new a(paramContext);
    this.Sab = new HandlerThread("TPAssetResourceLoader-dataWriteThread");
    this.Sab.start();
    AppMethodBeat.o(189243);
  }
  
  /* Error */
  private int OF(long paramLong)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_3
    //   2: aload_0
    //   3: monitorenter
    //   4: ldc 108
    //   6: invokestatic 54	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   9: aload_0
    //   10: getfield 77	com/tencent/thumbplayer/e/a/b:RZZ	Ljava/util/ArrayList;
    //   13: ifnonnull +12 -> 25
    //   16: ldc 108
    //   18: invokestatic 105	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   21: aload_0
    //   22: monitorexit
    //   23: iload_3
    //   24: ireturn
    //   25: iconst_0
    //   26: istore 4
    //   28: iconst_0
    //   29: istore_3
    //   30: iload 4
    //   32: aload_0
    //   33: getfield 77	com/tencent/thumbplayer/e/a/b:RZZ	Ljava/util/ArrayList;
    //   36: invokevirtual 112	java/util/ArrayList:size	()I
    //   39: if_icmpge +36 -> 75
    //   42: iload_3
    //   43: aload_0
    //   44: getfield 77	com/tencent/thumbplayer/e/a/b:RZZ	Ljava/util/ArrayList;
    //   47: iload 4
    //   49: invokevirtual 116	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   52: checkcast 118	com/tencent/thumbplayer/e/a/d
    //   55: getfield 122	com/tencent/thumbplayer/e/a/d:San	Lcom/tencent/thumbplayer/e/a/c;
    //   58: lload_1
    //   59: invokevirtual 126	com/tencent/thumbplayer/e/a/c:OF	(J)I
    //   62: invokestatic 132	java/lang/Math:max	(II)I
    //   65: istore_3
    //   66: iload 4
    //   68: iconst_1
    //   69: iadd
    //   70: istore 4
    //   72: goto -42 -> 30
    //   75: ldc 108
    //   77: invokestatic 105	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   80: goto -59 -> 21
    //   83: astore 5
    //   85: aload_0
    //   86: monitorexit
    //   87: aload 5
    //   89: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	90	0	this	b
    //   0	90	1	paramLong	long
    //   1	65	3	i	int
    //   26	45	4	j	int
    //   83	5	5	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   4	21	83	finally
    //   30	66	83	finally
    //   75	80	83	finally
  }
  
  private void a(d paramd)
  {
    try
    {
      AppMethodBeat.i(189254);
      if (this.RZZ != null) {
        this.RZZ.add(paramd);
      }
      AppMethodBeat.o(189254);
      return;
    }
    finally {}
  }
  
  private d arw(int paramInt)
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(189251);
        if (this.RZZ == null)
        {
          AppMethodBeat.o(189251);
          locald = null;
          return locald;
        }
        int i = 0;
        if (i >= this.RZZ.size()) {
          break label81;
        }
        d locald = (d)this.RZZ.get(i);
        if (locald.San.getRequestNum() == paramInt)
        {
          AppMethodBeat.o(189251);
          continue;
        }
        i += 1;
      }
      finally {}
      continue;
      label81:
      AppMethodBeat.o(189251);
      Object localObject2 = null;
    }
  }
  
  private void b(d paramd)
  {
    try
    {
      AppMethodBeat.i(189255);
      if (this.RZZ != null) {
        this.RZZ.remove(paramd);
      }
      AppMethodBeat.o(189255);
      return;
    }
    finally {}
  }
  
  private void e(int paramInt1, int paramInt2, int paramInt3, Object paramObject)
  {
    AppMethodBeat.i(189256);
    if (this.Sac != null)
    {
      Message localMessage = this.Sac.obtainMessage();
      localMessage.what = paramInt1;
      localMessage.arg1 = paramInt2;
      localMessage.arg2 = paramInt3;
      localMessage.obj = paramObject;
      this.Sac.sendMessage(localMessage);
    }
    AppMethodBeat.o(189256);
  }
  
  private void hnC()
  {
    try
    {
      AppMethodBeat.i(189253);
      if (this.RZZ != null)
      {
        Iterator localIterator = this.RZZ.iterator();
        while (localIterator.hasNext())
        {
          ITPAssetResourceLoadingRequest localITPAssetResourceLoadingRequest = (ITPAssetResourceLoadingRequest)localIterator.next();
          ((d)localITPAssetResourceLoadingRequest).hnD();
          this.RZT.didCancelLoadingRequest(localITPAssetResourceLoadingRequest);
        }
        this.RZZ.clear();
      }
    }
    finally {}
    AppMethodBeat.o(189253);
  }
  
  public final String Mf(int paramInt)
  {
    AppMethodBeat.i(189248);
    Object localObject = this.RZV;
    if (!TextUtils.isEmpty((CharSequence)localObject))
    {
      AppMethodBeat.o(189248);
      return localObject;
    }
    localObject = this.mContext;
    if (TextUtils.isEmpty(this.RZW))
    {
      String str = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
      localObject = TPDLFileSystem.getExternalCacheFile((Context)localObject, "resourceLoader", str + "-" + paramInt + this.RZX);
      TPDLIOUtil.createFile((File)localObject);
      this.RZW = ((File)localObject).getAbsolutePath();
    }
    localObject = this.RZW;
    AppMethodBeat.o(189248);
    return localObject;
  }
  
  public final void a(ITPAssetResourceLoaderListener paramITPAssetResourceLoaderListener)
  {
    this.RZT = paramITPAssetResourceLoaderListener;
  }
  
  public final String getContentType(int paramInt, String paramString)
  {
    return this.mContentType;
  }
  
  public final long getDataTotalSize(int paramInt, String paramString)
  {
    return this.RZU;
  }
  
  public final void hnB()
  {
    AppMethodBeat.i(189244);
    if (this.RZT == null)
    {
      g.e(TAG, "listener not set");
      AppMethodBeat.o(189244);
      return;
    }
    this.Saa = new TPAssetResourceLoadingContentInformationRequest();
    this.RZT.fillInContentInformation(this.Saa);
    this.mContentType = this.Saa.contentType;
    this.RZU = this.Saa.dataTotalSize;
    this.RZV = this.Saa.dataFilePath;
    g.i(TAG, "proxy start, mDataTotalSize: " + this.RZU + " businessPath:" + this.RZV);
    AppMethodBeat.o(189244);
  }
  
  public final int k(int paramInt, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(189246);
    int i = (int)Math.min(OF(paramLong1), paramLong2);
    if (i <= 0)
    {
      AppMethodBeat.o(189246);
      return -1;
    }
    g.d(TAG, "onReadData, fileId: " + paramInt + " readOffset: " + paramLong1 + " readLength:" + paramLong2 + " readyLength:" + i);
    AppMethodBeat.o(189246);
    return i;
  }
  
  public final int onStartReadData(int paramInt, String paramString, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(189245);
    if (this.RZT == null)
    {
      g.e(TAG, "listener not set");
      AppMethodBeat.o(189245);
      return 0;
    }
    g.i(TAG, "onStartReadData, fileId:" + paramInt + ", fileKey:" + paramString + ", requestStart:" + paramLong1 + ", requestEnd:" + paramLong2);
    int i = this.RZY + 1;
    b localb = new b((byte)0);
    localb.requestStart = paramLong1;
    localb.requestEnd = paramLong2;
    localb.fileKey = paramString;
    e(256, paramInt, i, localb);
    this.RZY = i;
    paramInt = this.RZY;
    AppMethodBeat.o(189245);
    return paramInt;
  }
  
  public final int onStopReadData(int paramInt1, String paramString, int paramInt2)
  {
    AppMethodBeat.i(189247);
    if (this.RZT == null)
    {
      g.e(TAG, "listener not set");
      AppMethodBeat.o(189247);
      return 0;
    }
    e(257, paramInt2, 0, null);
    AppMethodBeat.o(189247);
    return 0;
  }
  
  public final void release()
  {
    AppMethodBeat.i(189250);
    g.i(TAG, "release start");
    reset();
    if (this.mHandlerThread != null)
    {
      this.mHandlerThread.quit();
      this.mHandlerThread = null;
    }
    if (this.Sab != null)
    {
      this.Sab.quit();
      this.Sab = null;
    }
    this.RZZ = null;
    AppMethodBeat.o(189250);
  }
  
  public final void reset()
  {
    AppMethodBeat.i(189249);
    g.i(TAG, "reset start");
    hnC();
    this.RZU = 0L;
    this.mContentType = "";
    this.RZV = "";
    if (!TextUtils.isEmpty(this.RZW)) {
      try
      {
        new File(this.RZW).deleteOnExit();
        this.RZW = "";
        AppMethodBeat.o(189249);
        return;
      }
      catch (Exception localException)
      {
        g.e(TAG, "reset, delete cache file has exception:" + localException.toString());
      }
    }
    AppMethodBeat.o(189249);
  }
  
  final class a
    extends Handler
  {
    a(Looper paramLooper)
    {
      super();
    }
    
    public final void handleMessage(Message paramMessage)
    {
      AppMethodBeat.i(189242);
      g.d(b.TAG, "mCallbackForResourceLoaderHandler msg : " + paramMessage.what);
      if (b.a(b.this) == null)
      {
        AppMethodBeat.o(189242);
        return;
      }
      switch (paramMessage.what)
      {
      }
      for (;;)
      {
        AppMethodBeat.o(189242);
        return;
        g.i(b.TAG, "start read data");
        Object localObject = (b.b)paramMessage.obj;
        long l1 = ((b.b)localObject).requestStart;
        long l2 = ((b.b)localObject).requestEnd;
        int i = paramMessage.arg1;
        int j = paramMessage.arg2;
        g.i(b.TAG, "start read data, requestStart: " + l1 + " requestEnd:" + l2 + " requestId:" + j);
        l2 = b.a(b.this, l1, l2);
        if (l2 <= 0L)
        {
          g.e(b.TAG, "requestLength invalid, check requestStart and requestEnd");
          AppMethodBeat.o(189242);
          return;
        }
        boolean bool2 = false;
        boolean bool1 = bool2;
        if (b.d(b.this) > 0L)
        {
          bool1 = bool2;
          if (l2 + l1 >= b.d(b.this)) {
            bool1 = true;
          }
        }
        if (bool1) {
          b.e(b.this);
        }
        paramMessage = new d(l1, l2, j, bool1);
        localObject = b.b(b.this).getLooper();
        c localc = paramMessage.San;
        localc.Saj = new c.b(localc, (Looper)localObject);
        localObject = b.this.Mf(i);
        paramMessage.San.Sak = ((String)localObject);
        paramMessage.Saa = b.c(b.this);
        if (b.a(b.this).shouldWaitForLoadingOfRequestedResource(paramMessage))
        {
          b.a(b.this, paramMessage);
          g.i(b.TAG, "add to mLoadingRequests, requestId: ".concat(String.valueOf(j)));
        }
        AppMethodBeat.o(189242);
        return;
        g.i(b.TAG, "stop read data");
        b.a(b.this, paramMessage.arg1);
      }
    }
  }
  
  static final class b
  {
    String fileKey;
    long requestEnd;
    long requestStart;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.thumbplayer.e.a.b
 * JD-Core Version:    0.7.0.1
 */