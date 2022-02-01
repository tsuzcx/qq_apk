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
  private ITPAssetResourceLoaderListener ahHG;
  private long ahHH;
  private String ahHI;
  private String ahHJ;
  private String ahHK;
  private int ahHL;
  private ArrayList<d> ahHM;
  private TPAssetResourceLoadingContentInformationRequest ahHN;
  private HandlerThread ahHO;
  private a ahHP;
  private String mContentType;
  private Context mContext;
  private HandlerThread mHandlerThread;
  
  public b(Context paramContext, Looper paramLooper)
  {
    AppMethodBeat.i(227013);
    this.ahHH = 0L;
    this.mContentType = "";
    this.ahHI = "";
    this.ahHJ = "";
    this.ahHK = ".mp4";
    this.ahHL = 0;
    this.mContext = paramContext;
    this.ahHM = new ArrayList();
    paramContext = paramLooper;
    if (paramLooper == null)
    {
      this.mHandlerThread = new HandlerThread("TPAssetResourceLoader-callbackThread");
      this.mHandlerThread.start();
      paramContext = this.mHandlerThread.getLooper();
    }
    this.ahHP = new a(paramContext);
    this.ahHO = new HandlerThread("TPAssetResourceLoader-dataWriteThread");
    this.ahHO.start();
    AppMethodBeat.o(227013);
  }
  
  /* Error */
  private int Bi(long paramLong)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_3
    //   2: aload_0
    //   3: monitorenter
    //   4: ldc 108
    //   6: invokestatic 54	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   9: aload_0
    //   10: getfield 77	com/tencent/thumbplayer/e/a/b:ahHM	Ljava/util/ArrayList;
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
    //   33: getfield 77	com/tencent/thumbplayer/e/a/b:ahHM	Ljava/util/ArrayList;
    //   36: invokevirtual 112	java/util/ArrayList:size	()I
    //   39: if_icmpge +36 -> 75
    //   42: iload_3
    //   43: aload_0
    //   44: getfield 77	com/tencent/thumbplayer/e/a/b:ahHM	Ljava/util/ArrayList;
    //   47: iload 4
    //   49: invokevirtual 116	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   52: checkcast 118	com/tencent/thumbplayer/e/a/d
    //   55: getfield 122	com/tencent/thumbplayer/e/a/d:ahIa	Lcom/tencent/thumbplayer/e/a/c;
    //   58: lload_1
    //   59: invokevirtual 126	com/tencent/thumbplayer/e/a/c:Bi	(J)I
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
      AppMethodBeat.i(227038);
      if (this.ahHM != null) {
        this.ahHM.add(paramd);
      }
      AppMethodBeat.o(227038);
      return;
    }
    finally {}
  }
  
  private d aHW(int paramInt)
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(227019);
        if (this.ahHM == null)
        {
          AppMethodBeat.o(227019);
          locald = null;
          return locald;
        }
        int i = 0;
        if (i >= this.ahHM.size()) {
          break label81;
        }
        d locald = (d)this.ahHM.get(i);
        if (locald.ahIa.getRequestNum() == paramInt)
        {
          AppMethodBeat.o(227019);
          continue;
        }
        i += 1;
      }
      finally {}
      continue;
      label81:
      AppMethodBeat.o(227019);
      Object localObject2 = null;
    }
  }
  
  private void b(d paramd)
  {
    try
    {
      AppMethodBeat.i(227041);
      if (this.ahHM != null) {
        this.ahHM.remove(paramd);
      }
      AppMethodBeat.o(227041);
      return;
    }
    finally {}
  }
  
  private void e(int paramInt1, int paramInt2, int paramInt3, Object paramObject)
  {
    AppMethodBeat.i(227050);
    if (this.ahHP != null)
    {
      Message localMessage = this.ahHP.obtainMessage();
      localMessage.what = paramInt1;
      localMessage.arg1 = paramInt2;
      localMessage.arg2 = paramInt3;
      localMessage.obj = paramObject;
      this.ahHP.sendMessage(localMessage);
    }
    AppMethodBeat.o(227050);
  }
  
  private void kaz()
  {
    try
    {
      AppMethodBeat.i(227033);
      if (this.ahHM != null)
      {
        Iterator localIterator = this.ahHM.iterator();
        while (localIterator.hasNext())
        {
          ITPAssetResourceLoadingRequest localITPAssetResourceLoadingRequest = (ITPAssetResourceLoadingRequest)localIterator.next();
          ((d)localITPAssetResourceLoadingRequest).kaA();
          this.ahHG.didCancelLoadingRequest(localITPAssetResourceLoadingRequest);
        }
        this.ahHM.clear();
      }
    }
    finally {}
    AppMethodBeat.o(227033);
  }
  
  public final void a(ITPAssetResourceLoaderListener paramITPAssetResourceLoaderListener)
  {
    this.ahHG = paramITPAssetResourceLoaderListener;
  }
  
  public final String getContentType(int paramInt, String paramString)
  {
    return this.mContentType;
  }
  
  public final String getDataFilePath(int paramInt, String paramString)
  {
    AppMethodBeat.i(227179);
    paramString = this.ahHI;
    if (!TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(227179);
      return paramString;
    }
    paramString = this.mContext;
    if (TextUtils.isEmpty(this.ahHJ))
    {
      String str = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
      paramString = TPDLFileSystem.getExternalCacheFile(paramString, "resourceLoader", str + "-" + paramInt + this.ahHK);
      TPDLIOUtil.createFile(paramString);
      this.ahHJ = paramString.getAbsolutePath();
    }
    paramString = this.ahHJ;
    AppMethodBeat.o(227179);
    return paramString;
  }
  
  public final long getDataTotalSize(int paramInt, String paramString)
  {
    return this.ahHH;
  }
  
  public final void kay()
  {
    AppMethodBeat.i(227134);
    if (this.ahHG == null)
    {
      g.e(TAG, "listener not set");
      AppMethodBeat.o(227134);
      return;
    }
    this.ahHN = new TPAssetResourceLoadingContentInformationRequest();
    this.ahHG.fillInContentInformation(this.ahHN);
    this.mContentType = this.ahHN.contentType;
    this.ahHH = this.ahHN.dataTotalSize;
    this.ahHI = this.ahHN.dataFilePath;
    g.i(TAG, "proxy start, mDataTotalSize: " + this.ahHH + " businessPath:" + this.ahHI);
    AppMethodBeat.o(227134);
  }
  
  public final int onReadData(int paramInt, String paramString, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(227153);
    int i = (int)Math.min(Bi(paramLong1), paramLong2);
    if (i <= 0)
    {
      AppMethodBeat.o(227153);
      return -1;
    }
    g.d(TAG, "onReadData, fileId: " + paramInt + " readOffset: " + paramLong1 + " readLength:" + paramLong2 + " readyLength:" + i);
    AppMethodBeat.o(227153);
    return i;
  }
  
  public final int onStartReadData(int paramInt, String paramString, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(227145);
    if (this.ahHG == null)
    {
      g.e(TAG, "listener not set");
      AppMethodBeat.o(227145);
      return 0;
    }
    g.i(TAG, "onStartReadData, fileId:" + paramInt + ", fileKey:" + paramString + ", requestStart:" + paramLong1 + ", requestEnd:" + paramLong2);
    int i = this.ahHL + 1;
    b localb = new b((byte)0);
    localb.requestStart = paramLong1;
    localb.requestEnd = paramLong2;
    localb.fileKey = paramString;
    e(256, paramInt, i, localb);
    this.ahHL = i;
    paramInt = this.ahHL;
    AppMethodBeat.o(227145);
    return paramInt;
  }
  
  public final int onStopReadData(int paramInt1, String paramString, int paramInt2)
  {
    AppMethodBeat.i(227160);
    if (this.ahHG == null)
    {
      g.e(TAG, "listener not set");
      AppMethodBeat.o(227160);
      return 0;
    }
    e(257, paramInt2, 0, null);
    AppMethodBeat.o(227160);
    return 0;
  }
  
  public final void release()
  {
    AppMethodBeat.i(227200);
    g.i(TAG, "release start");
    reset();
    if (this.mHandlerThread != null)
    {
      this.mHandlerThread.quit();
      this.mHandlerThread = null;
    }
    if (this.ahHO != null)
    {
      this.ahHO.quit();
      this.ahHO = null;
    }
    this.ahHM = null;
    AppMethodBeat.o(227200);
  }
  
  public final void reset()
  {
    AppMethodBeat.i(227193);
    g.i(TAG, "reset start");
    kaz();
    this.ahHH = 0L;
    this.mContentType = "";
    this.ahHI = "";
    if (!TextUtils.isEmpty(this.ahHJ)) {
      try
      {
        new File(this.ahHJ).deleteOnExit();
        this.ahHJ = "";
        AppMethodBeat.o(227193);
        return;
      }
      catch (Exception localException)
      {
        g.e(TAG, "reset, delete cache file has exception:" + localException.toString());
      }
    }
    AppMethodBeat.o(227193);
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
      AppMethodBeat.i(227008);
      g.d(b.TAG, "mCallbackForResourceLoaderHandler msg : " + paramMessage.what);
      if (b.a(b.this) == null)
      {
        AppMethodBeat.o(227008);
        return;
      }
      switch (paramMessage.what)
      {
      }
      for (;;)
      {
        AppMethodBeat.o(227008);
        return;
        g.i(b.TAG, "start read data");
        Object localObject = (b.b)paramMessage.obj;
        long l1 = ((b.b)localObject).requestStart;
        long l2 = ((b.b)localObject).requestEnd;
        localObject = ((b.b)localObject).fileKey;
        int i = paramMessage.arg1;
        int j = paramMessage.arg2;
        g.i(b.TAG, "start read data, requestStart: " + l1 + " requestEnd:" + l2 + " requestId:" + j);
        l2 = b.a(b.this, l1, l2);
        if (l2 <= 0L)
        {
          g.e(b.TAG, "requestLength invalid, check requestStart and requestEnd");
          AppMethodBeat.o(227008);
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
        Looper localLooper = b.b(b.this).getLooper();
        c localc = paramMessage.ahIa;
        localc.ahHW = new c.b(localc, localLooper);
        localObject = b.this.getDataFilePath(i, (String)localObject);
        paramMessage.ahIa.ahHX = ((String)localObject);
        paramMessage.ahHN = b.c(b.this);
        if (b.a(b.this).shouldWaitForLoadingOfRequestedResource(paramMessage))
        {
          b.a(b.this, paramMessage);
          g.i(b.TAG, "add to mLoadingRequests, requestId: ".concat(String.valueOf(j)));
        }
        AppMethodBeat.o(227008);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.thumbplayer.e.a.b
 * JD-Core Version:    0.7.0.1
 */