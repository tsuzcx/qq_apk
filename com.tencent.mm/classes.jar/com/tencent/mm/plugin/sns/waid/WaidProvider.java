package com.tencent.mm.plugin.sns.waid;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.content.UriMatcher;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.database.MatrixCursor.RowBuilder;
import android.net.Uri;
import android.os.Binder;
import android.os.Handler;
import android.os.HandlerThread;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONObject;

public class WaidProvider
  extends ContentProvider
{
  private static String[] AVS;
  private UriMatcher AVT;
  private long AVU;
  private int AVV;
  private a AVW;
  private volatile boolean AVX;
  private final Object mLock;
  
  static
  {
    AppMethodBeat.i(100606);
    AVS = new String[] { "pkg", "appWaid", "errCode" };
    AppMethodBeat.o(100606);
  }
  
  public WaidProvider()
  {
    AppMethodBeat.i(100598);
    this.AVT = new UriMatcher(-1);
    this.AVV = 0;
    this.mLock = new Object();
    this.AVX = false;
    AppMethodBeat.o(100598);
  }
  
  /* Error */
  private boolean a(PInt arg1)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore_2
    //   2: aload_0
    //   3: monitorenter
    //   4: ldc 71
    //   6: invokestatic 33	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   9: ldc 73
    //   11: new 75	java/lang/StringBuilder
    //   14: dup
    //   15: ldc 77
    //   17: invokespecial 80	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   20: invokestatic 86	com/tencent/mm/plugin/sns/waid/b:eiV	()Z
    //   23: invokevirtual 90	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   26: ldc 92
    //   28: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   31: aload_0
    //   32: getfield 66	com/tencent/mm/plugin/sns/waid/WaidProvider:AVX	Z
    //   35: invokevirtual 90	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   38: invokevirtual 99	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   41: invokestatic 104	com/tencent/mm/sdk/platformtools/ae:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   44: invokestatic 86	com/tencent/mm/plugin/sns/waid/b:eiV	()Z
    //   47: ifeq +17 -> 64
    //   50: aload_0
    //   51: iconst_1
    //   52: putfield 66	com/tencent/mm/plugin/sns/waid/WaidProvider:AVX	Z
    //   55: ldc 71
    //   57: invokestatic 46	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   60: aload_0
    //   61: monitorexit
    //   62: iload_2
    //   63: ireturn
    //   64: aload_0
    //   65: iconst_0
    //   66: putfield 66	com/tencent/mm/plugin/sns/waid/WaidProvider:AVX	Z
    //   69: aload_1
    //   70: iconst_1
    //   71: putfield 109	com/tencent/mm/pointers/PInt:value	I
    //   74: new 9	com/tencent/mm/plugin/sns/waid/WaidProvider$b
    //   77: dup
    //   78: aload_0
    //   79: invokespecial 112	com/tencent/mm/plugin/sns/waid/WaidProvider$b:<init>	(Lcom/tencent/mm/plugin/sns/waid/WaidProvider;)V
    //   82: invokevirtual 115	com/tencent/mm/plugin/sns/waid/WaidProvider$b:start	()V
    //   85: ldc 73
    //   87: ldc 117
    //   89: invokestatic 104	com/tencent/mm/sdk/platformtools/ae:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   92: invokestatic 123	java/lang/System:currentTimeMillis	()J
    //   95: lstore_3
    //   96: aload_0
    //   97: getfield 66	com/tencent/mm/plugin/sns/waid/WaidProvider:AVX	Z
    //   100: ifne +69 -> 169
    //   103: aload_0
    //   104: getfield 64	com/tencent/mm/plugin/sns/waid/WaidProvider:mLock	Ljava/lang/Object;
    //   107: astore_1
    //   108: aload_1
    //   109: monitorenter
    //   110: aload_0
    //   111: getfield 64	com/tencent/mm/plugin/sns/waid/WaidProvider:mLock	Ljava/lang/Object;
    //   114: invokevirtual 126	java/lang/Object:wait	()V
    //   117: aload_1
    //   118: monitorexit
    //   119: goto -23 -> 96
    //   122: astore 5
    //   124: aload_1
    //   125: monitorexit
    //   126: ldc 71
    //   128: invokestatic 46	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   131: aload 5
    //   133: athrow
    //   134: astore_1
    //   135: aload_0
    //   136: monitorexit
    //   137: aload_1
    //   138: athrow
    //   139: astore 5
    //   141: ldc 73
    //   143: new 75	java/lang/StringBuilder
    //   146: dup
    //   147: ldc 128
    //   149: invokespecial 80	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   152: aload 5
    //   154: invokevirtual 129	java/lang/Exception:toString	()Ljava/lang/String;
    //   157: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   160: invokevirtual 99	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   163: invokestatic 132	com/tencent/mm/sdk/platformtools/ae:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   166: goto -49 -> 117
    //   169: ldc 73
    //   171: new 75	java/lang/StringBuilder
    //   174: dup
    //   175: ldc 134
    //   177: invokespecial 80	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   180: invokestatic 123	java/lang/System:currentTimeMillis	()J
    //   183: lload_3
    //   184: lsub
    //   185: invokevirtual 137	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   188: ldc 139
    //   190: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   193: invokestatic 123	java/lang/System:currentTimeMillis	()J
    //   196: aload_0
    //   197: getfield 141	com/tencent/mm/plugin/sns/waid/WaidProvider:AVU	J
    //   200: lsub
    //   201: invokevirtual 137	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   204: ldc 143
    //   206: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   209: aload_0
    //   210: getfield 59	com/tencent/mm/plugin/sns/waid/WaidProvider:AVV	I
    //   213: invokevirtual 146	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   216: invokevirtual 99	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   219: invokestatic 104	com/tencent/mm/sdk/platformtools/ae:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   222: aload_0
    //   223: aload_0
    //   224: getfield 59	com/tencent/mm/plugin/sns/waid/WaidProvider:AVV	I
    //   227: iconst_1
    //   228: iadd
    //   229: putfield 59	com/tencent/mm/plugin/sns/waid/WaidProvider:AVV	I
    //   232: invokestatic 86	com/tencent/mm/plugin/sns/waid/b:eiV	()Z
    //   235: ifne +25 -> 260
    //   238: aload_0
    //   239: iconst_0
    //   240: putfield 66	com/tencent/mm/plugin/sns/waid/WaidProvider:AVX	Z
    //   243: ldc 73
    //   245: ldc 148
    //   247: invokestatic 132	com/tencent/mm/sdk/platformtools/ae:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   250: ldc 71
    //   252: invokestatic 46	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   255: iconst_0
    //   256: istore_2
    //   257: goto -197 -> 60
    //   260: ldc 73
    //   262: ldc 150
    //   264: invokestatic 104	com/tencent/mm/sdk/platformtools/ae:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   267: ldc 71
    //   269: invokestatic 46	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   272: goto -212 -> 60
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	275	0	this	WaidProvider
    //   1	256	2	bool	boolean
    //   95	89	3	l	long
    //   122	10	5	localObject	Object
    //   139	14	5	localException	Exception
    // Exception table:
    //   from	to	target	type
    //   110	117	122	finally
    //   117	119	122	finally
    //   124	126	122	finally
    //   141	166	122	finally
    //   4	60	134	finally
    //   64	96	134	finally
    //   96	110	134	finally
    //   126	134	134	finally
    //   169	255	134	finally
    //   260	272	134	finally
    //   110	117	139	java/lang/Exception
  }
  
  private static MatrixCursor af(String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(220194);
    MatrixCursor localMatrixCursor = new MatrixCursor(AVS, 1);
    MatrixCursor.RowBuilder localRowBuilder = localMatrixCursor.newRow();
    localRowBuilder.add("pkg", paramString1);
    localRowBuilder.add("appWaid", paramString2);
    localRowBuilder.add("errCode", Integer.valueOf(paramInt));
    AppMethodBeat.o(220194);
    return localMatrixCursor;
  }
  
  private Cursor b(Uri paramUri, String[] paramArrayOfString)
  {
    int i = 1;
    AppMethodBeat.i(220193);
    for (;;)
    {
      Object localObject1;
      try
      {
        long l = System.currentTimeMillis();
        String str = "";
        Object localObject2 = "";
        a locala = eiW();
        localObject1 = localObject2;
        if (paramArrayOfString != null)
        {
          localObject1 = localObject2;
          if (paramArrayOfString.length > 0) {
            localObject1 = bu.nullAsNil(paramArrayOfString[0]).trim();
          }
        }
        ae.i("ad.waid.WaidProvider", "handleQuery queryPkg=" + (String)localObject1 + ", callingPkg=" + locala.AWb + ", thread.hash=" + Thread.currentThread().hashCode());
        localObject2 = new PInt();
        if (!a((PInt)localObject2))
        {
          ae.e("ad.waid.WaidProvider", "checkWXEnv failed");
          paramUri = af("", "", -1);
          AppMethodBeat.o(220193);
          return paramUri;
        }
        int j;
        int k;
        int m;
        if (TextUtils.isEmpty(locala.AWb))
        {
          ae.e("ad.waid.WaidProvider", "handleQuery callingPkg empty");
          paramUri = "";
          paramArrayOfString = str;
          j = (int)(System.currentTimeMillis() - l);
          str = locala.AWb;
          k = locala.AWa;
          m = ((PInt)localObject2).value;
          if (!b.eiV())
          {
            ae.e("ad.waid.WaidReporter", "reportQuery isWxEnvInitDone==false");
            c.a(locala, (String)localObject1);
            paramUri = af(paramUri, bu.nullAsNil(paramArrayOfString), i);
            AppMethodBeat.o(220193);
            return paramUri;
          }
        }
        else
        {
          if (!b.eiS())
          {
            ae.e("ad.waid.WaidProvider", "handleQuery isExptWaidEnable==false");
            paramUri = "";
            i = 2;
            paramArrayOfString = str;
            continue;
          }
          if (this.AVT.match(paramUri) != 1)
          {
            ae.e("ad.waid.WaidProvider", "handleQuery uriMatch failed");
            i = 3;
            paramUri = "";
            paramArrayOfString = str;
            continue;
          }
          if (!TextUtils.isEmpty((CharSequence)localObject1)) {
            break label592;
          }
          paramUri = locala.AWb;
          if (!locala.AWb.equals(paramUri))
          {
            ae.e("ad.waid.WaidProvider", "handleQuery queryPkg!=callingPkg, queryPkg=" + paramUri + ", callingPkg=" + locala.AWb);
            i = 4;
            paramArrayOfString = str;
            continue;
          }
          paramArrayOfString = b.aCD(paramUri);
          ae.i("ad.waid.WaidProvider", "handleQuery, appWaid=".concat(String.valueOf(paramArrayOfString)));
          boolean bool = TextUtils.isEmpty(paramArrayOfString);
          if (!bool) {
            break label587;
          }
          i = 5;
          continue;
        }
        try
        {
          localObject2 = new JSONObject();
          ((JSONObject)localObject2).put("callPkg", str);
          ((JSONObject)localObject2).put("callPkgType", k);
          ((JSONObject)localObject2).put("queryPkg", localObject1);
          ((JSONObject)localObject2).put("errCode", i);
          ((JSONObject)localObject2).put("waitInit", m);
          ((JSONObject)localObject2).put("timeCost", j);
          str = c.aCF(((JSONObject)localObject2).toString());
          ae.i("ad.waid.WaidReporter", "reportQuery data=".concat(String.valueOf(str)));
          g.yxI.f(18666, new Object[] { Integer.valueOf(2000), str });
        }
        catch (Throwable localThrowable)
        {
          ae.e("ad.waid.WaidReporter", "reportQuery exp=" + Log.getStackTraceString(localThrowable));
        }
        continue;
        i = 0;
      }
      catch (Throwable paramUri)
      {
        ae.e("ad.waid.WaidProvider", "handleQuery exp=" + paramUri.toString());
        AppMethodBeat.o(220193);
        return null;
      }
      label587:
      continue;
      label592:
      paramUri = (Uri)localObject1;
    }
  }
  
  private a eiW()
  {
    AppMethodBeat.i(220195);
    a locala = new a();
    try
    {
      locala.AVY = getCallingPackage();
    }
    catch (Throwable localThrowable1)
    {
      try
      {
        for (;;)
        {
          i = Binder.getCallingUid();
          locala.AVZ = getContext().getPackageManager().getPackagesForUid(i);
          if ((locala.AVZ == null) || (locala.AVZ.length <= 0)) {
            break label252;
          }
          if (!TextUtils.isEmpty(locala.AVY)) {
            break;
          }
          locala.AWa = 1;
          locala.AWb = locala.AVZ[0];
          AppMethodBeat.o(220195);
          return locala;
          localThrowable1 = localThrowable1;
          ae.e("ad.waid.WaidProvider", "getCallingPkg exp=" + localThrowable1.toString());
        }
      }
      catch (Throwable localThrowable2)
      {
        for (;;)
        {
          ae.e("ad.waid.WaidProvider", "getCallingUid exp=" + localThrowable2.toString());
        }
        String[] arrayOfString = locala.AVZ;
        int j = arrayOfString.length;
        int i = 0;
        while (i < j)
        {
          String str = arrayOfString[i];
          if (locala.AVY.equals(str))
          {
            if (locala.AVZ.length > 1) {}
            for (locala.AWa = 2;; locala.AWa = 3)
            {
              locala.AWb = str;
              AppMethodBeat.o(220195);
              return locala;
            }
          }
          i += 1;
        }
        locala.AWa = 4;
        locala.AWb = locala.AVZ[0];
        AppMethodBeat.o(220195);
        return locala;
      }
    }
    label252:
    locala.AWa = 5;
    locala.AWb = locala.AVY;
    AppMethodBeat.o(220195);
    return locala;
  }
  
  public int delete(Uri paramUri, String paramString, String[] paramArrayOfString)
  {
    AppMethodBeat.i(100601);
    AppMethodBeat.o(100601);
    return 0;
  }
  
  public String getType(Uri paramUri)
  {
    return null;
  }
  
  public Uri insert(Uri paramUri, ContentValues paramContentValues)
  {
    AppMethodBeat.i(100600);
    AppMethodBeat.o(100600);
    return null;
  }
  
  public boolean onCreate()
  {
    AppMethodBeat.i(100599);
    this.AVT.addURI("com.tencent.mm.ad.waid", "appWaid", 1);
    this.AVU = System.currentTimeMillis();
    this.AVW = new a();
    a locala = this.AVW;
    try
    {
      ae.i("InitTaskMgr", "start");
      Iterator localIterator = locala.AVN.iterator();
      while (localIterator.hasNext())
      {
        Runnable localRunnable = (Runnable)localIterator.next();
        locala.AVP.post(localRunnable);
        continue;
        ae.i("ad.waid.WaidProvider", "onCreate, this.hash=" + hashCode());
      }
    }
    catch (Exception localException)
    {
      ae.e("InitTaskMgr", "startInit exp=" + localException.toString());
    }
    for (;;)
    {
      AppMethodBeat.o(100599);
      return true;
      localException.AVN.clear();
      localException.AVO.quitSafely();
    }
  }
  
  public Cursor query(Uri paramUri, String[] paramArrayOfString1, String paramString1, String[] paramArrayOfString2, String paramString2)
  {
    AppMethodBeat.i(100602);
    paramUri = b(paramUri, paramArrayOfString2);
    AppMethodBeat.o(100602);
    return paramUri;
  }
  
  public int update(Uri paramUri, ContentValues paramContentValues, String paramString, String[] paramArrayOfString)
  {
    return 0;
  }
  
  protected static final class a
  {
    String AVY;
    String[] AVZ;
    int AWa;
    String AWb;
  }
  
  final class b
    extends Thread
  {
    private int AWc;
    private int dsY;
    
    public b()
    {
      AppMethodBeat.i(220190);
      this.dsY = 0;
      this.AWc = 12000;
      int j = 12000 - WaidProvider.a(WaidProvider.this) * 4000;
      if (j < 2000) {}
      for (;;)
      {
        this.AWc = i;
        AppMethodBeat.o(220190);
        return;
        i = j;
      }
    }
    
    private void eiX()
    {
      AppMethodBeat.i(220192);
      synchronized (WaidProvider.b(WaidProvider.this))
      {
        ae.i("ad.waid.WaidProvider", "break Wait, waitTime=" + this.dsY);
        WaidProvider.c(WaidProvider.this);
        WaidProvider.b(WaidProvider.this).notifyAll();
        AppMethodBeat.o(220192);
        return;
      }
    }
    
    public final void run()
    {
      AppMethodBeat.i(220191);
      ae.i("ad.waid.WaidProvider", "CheckThread run, thread.hash=" + hashCode());
      for (;;)
      {
        if (b.eiV())
        {
          ae.i("ad.waid.WaidProvider", "init done");
          eiX();
          AppMethodBeat.o(220191);
          return;
        }
        ae.d("ad.waid.WaidProvider", "wait, delay=200");
        try
        {
          Thread.sleep(200L);
          this.dsY += 200;
          label77:
          if (this.dsY < this.AWc) {
            continue;
          }
          ae.e("ad.waid.WaidProvider", "wait expired, expiredDuration=" + this.AWc);
          eiX();
          AppMethodBeat.o(220191);
          return;
        }
        catch (Exception localException)
        {
          break label77;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.waid.WaidProvider
 * JD-Core Version:    0.7.0.1
 */