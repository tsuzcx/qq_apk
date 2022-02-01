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
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatAuthorities;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONObject;

public class WaidProvider
  extends ContentProvider
{
  private static final String AUTHORITY;
  private static String[] Lvr;
  private long Lvs;
  private int Lvt;
  private a Lvu;
  private volatile boolean Lvv;
  private final Object mLock;
  private UriMatcher mUriMatcher;
  
  static
  {
    AppMethodBeat.i(100606);
    AUTHORITY = WeChatAuthorities.AUTHORITIES_WAIDPROVIDER();
    Lvr = new String[] { "pkg", "appWaid", "errCode" };
    AppMethodBeat.o(100606);
  }
  
  public WaidProvider()
  {
    AppMethodBeat.i(100598);
    this.mUriMatcher = new UriMatcher(-1);
    this.Lvt = 0;
    this.mLock = new Object();
    this.Lvv = false;
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
    //   4: ldc 81
    //   6: invokestatic 35	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   9: ldc 83
    //   11: new 85	java/lang/StringBuilder
    //   14: dup
    //   15: ldc 87
    //   17: invokespecial 90	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   20: invokestatic 96	com/tencent/mm/plugin/sns/waid/b:fZR	()Z
    //   23: invokevirtual 100	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   26: ldc 102
    //   28: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   31: aload_0
    //   32: getfield 76	com/tencent/mm/plugin/sns/waid/WaidProvider:Lvv	Z
    //   35: invokevirtual 100	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   38: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   41: invokestatic 113	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   44: invokestatic 96	com/tencent/mm/plugin/sns/waid/b:fZR	()Z
    //   47: ifeq +17 -> 64
    //   50: aload_0
    //   51: iconst_1
    //   52: putfield 76	com/tencent/mm/plugin/sns/waid/WaidProvider:Lvv	Z
    //   55: ldc 81
    //   57: invokestatic 56	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   60: aload_0
    //   61: monitorexit
    //   62: iload_2
    //   63: ireturn
    //   64: aload_0
    //   65: iconst_0
    //   66: putfield 76	com/tencent/mm/plugin/sns/waid/WaidProvider:Lvv	Z
    //   69: aload_1
    //   70: iconst_1
    //   71: putfield 118	com/tencent/mm/pointers/PInt:value	I
    //   74: new 9	com/tencent/mm/plugin/sns/waid/WaidProvider$b
    //   77: dup
    //   78: aload_0
    //   79: invokespecial 121	com/tencent/mm/plugin/sns/waid/WaidProvider$b:<init>	(Lcom/tencent/mm/plugin/sns/waid/WaidProvider;)V
    //   82: invokevirtual 124	com/tencent/mm/plugin/sns/waid/WaidProvider$b:start	()V
    //   85: ldc 83
    //   87: ldc 126
    //   89: invokestatic 113	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   92: invokestatic 132	java/lang/System:currentTimeMillis	()J
    //   95: lstore_3
    //   96: aload_0
    //   97: getfield 76	com/tencent/mm/plugin/sns/waid/WaidProvider:Lvv	Z
    //   100: ifne +69 -> 169
    //   103: aload_0
    //   104: getfield 74	com/tencent/mm/plugin/sns/waid/WaidProvider:mLock	Ljava/lang/Object;
    //   107: astore_1
    //   108: aload_1
    //   109: monitorenter
    //   110: aload_0
    //   111: getfield 74	com/tencent/mm/plugin/sns/waid/WaidProvider:mLock	Ljava/lang/Object;
    //   114: invokevirtual 135	java/lang/Object:wait	()V
    //   117: aload_1
    //   118: monitorexit
    //   119: goto -23 -> 96
    //   122: astore 5
    //   124: aload_1
    //   125: monitorexit
    //   126: ldc 81
    //   128: invokestatic 56	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   131: aload 5
    //   133: athrow
    //   134: astore_1
    //   135: aload_0
    //   136: monitorexit
    //   137: aload_1
    //   138: athrow
    //   139: astore 5
    //   141: ldc 83
    //   143: new 85	java/lang/StringBuilder
    //   146: dup
    //   147: ldc 137
    //   149: invokespecial 90	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   152: aload 5
    //   154: invokevirtual 138	java/lang/Exception:toString	()Ljava/lang/String;
    //   157: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   160: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   163: invokestatic 141	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   166: goto -49 -> 117
    //   169: ldc 83
    //   171: new 85	java/lang/StringBuilder
    //   174: dup
    //   175: ldc 143
    //   177: invokespecial 90	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   180: invokestatic 132	java/lang/System:currentTimeMillis	()J
    //   183: lload_3
    //   184: lsub
    //   185: invokevirtual 146	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   188: ldc 148
    //   190: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   193: invokestatic 132	java/lang/System:currentTimeMillis	()J
    //   196: aload_0
    //   197: getfield 150	com/tencent/mm/plugin/sns/waid/WaidProvider:Lvs	J
    //   200: lsub
    //   201: invokevirtual 146	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   204: ldc 152
    //   206: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   209: aload_0
    //   210: getfield 69	com/tencent/mm/plugin/sns/waid/WaidProvider:Lvt	I
    //   213: invokevirtual 155	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   216: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   219: invokestatic 113	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   222: aload_0
    //   223: aload_0
    //   224: getfield 69	com/tencent/mm/plugin/sns/waid/WaidProvider:Lvt	I
    //   227: iconst_1
    //   228: iadd
    //   229: putfield 69	com/tencent/mm/plugin/sns/waid/WaidProvider:Lvt	I
    //   232: invokestatic 96	com/tencent/mm/plugin/sns/waid/b:fZR	()Z
    //   235: ifne +25 -> 260
    //   238: aload_0
    //   239: iconst_0
    //   240: putfield 76	com/tencent/mm/plugin/sns/waid/WaidProvider:Lvv	Z
    //   243: ldc 83
    //   245: ldc 157
    //   247: invokestatic 141	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   250: ldc 81
    //   252: invokestatic 56	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   255: iconst_0
    //   256: istore_2
    //   257: goto -197 -> 60
    //   260: ldc 83
    //   262: ldc 159
    //   264: invokestatic 113	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   267: ldc 81
    //   269: invokestatic 56	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
    //   141	166	122	finally
    //   4	60	134	finally
    //   64	96	134	finally
    //   96	110	134	finally
    //   124	134	134	finally
    //   169	255	134	finally
    //   260	272	134	finally
    //   110	117	139	java/lang/Exception
  }
  
  private static MatrixCursor aq(String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(209324);
    MatrixCursor localMatrixCursor = new MatrixCursor(Lvr, 1);
    MatrixCursor.RowBuilder localRowBuilder = localMatrixCursor.newRow();
    localRowBuilder.add("pkg", paramString1);
    localRowBuilder.add("appWaid", paramString2);
    localRowBuilder.add("errCode", Integer.valueOf(paramInt));
    AppMethodBeat.o(209324);
    return localMatrixCursor;
  }
  
  private Cursor b(Uri paramUri, String[] paramArrayOfString)
  {
    int i = 1;
    AppMethodBeat.i(209323);
    for (;;)
    {
      Object localObject1;
      try
      {
        long l = System.currentTimeMillis();
        String str = "";
        Object localObject2 = "";
        a locala = fZS();
        localObject1 = localObject2;
        if (paramArrayOfString != null)
        {
          localObject1 = localObject2;
          if (paramArrayOfString.length > 0) {
            localObject1 = Util.nullAsNil(paramArrayOfString[0]).trim();
          }
        }
        com.tencent.mm.sdk.platformtools.Log.i("ad.waid.WaidProvider", "handleQuery queryPkg=" + (String)localObject1 + ", callingPkg=" + locala.Lvz + ", thread.hash=" + Thread.currentThread().hashCode());
        localObject2 = new PInt();
        if (!a((PInt)localObject2))
        {
          com.tencent.mm.sdk.platformtools.Log.e("ad.waid.WaidProvider", "checkWXEnv failed");
          paramUri = aq("", "", -1);
          AppMethodBeat.o(209323);
          return paramUri;
        }
        int j;
        int k;
        int m;
        if (TextUtils.isEmpty(locala.Lvz))
        {
          com.tencent.mm.sdk.platformtools.Log.e("ad.waid.WaidProvider", "handleQuery callingPkg empty");
          paramUri = "";
          paramArrayOfString = str;
          j = (int)(System.currentTimeMillis() - l);
          str = locala.Lvz;
          k = locala.Lvy;
          m = ((PInt)localObject2).value;
          if (!b.fZR())
          {
            com.tencent.mm.sdk.platformtools.Log.e("ad.waid.WaidReporter", "reportQuery isWxEnvInitDone==false");
            c.a(locala, (String)localObject1);
            paramUri = aq(paramUri, Util.nullAsNil(paramArrayOfString), i);
            AppMethodBeat.o(209323);
            return paramUri;
          }
        }
        else
        {
          if (!b.fZO())
          {
            com.tencent.mm.sdk.platformtools.Log.e("ad.waid.WaidProvider", "handleQuery isExptWaidEnable==false");
            paramUri = "";
            i = 2;
            paramArrayOfString = str;
            continue;
          }
          if (this.mUriMatcher.match(paramUri) != 1)
          {
            com.tencent.mm.sdk.platformtools.Log.e("ad.waid.WaidProvider", "handleQuery uriMatch failed");
            i = 3;
            paramUri = "";
            paramArrayOfString = str;
            continue;
          }
          if (!TextUtils.isEmpty((CharSequence)localObject1)) {
            break label593;
          }
          paramUri = locala.Lvz;
          if (!locala.Lvz.equals(paramUri))
          {
            com.tencent.mm.sdk.platformtools.Log.e("ad.waid.WaidProvider", "handleQuery queryPkg!=callingPkg, queryPkg=" + paramUri + ", callingPkg=" + locala.Lvz);
            i = 4;
            paramArrayOfString = str;
            continue;
          }
          paramArrayOfString = b.bcE(paramUri);
          com.tencent.mm.sdk.platformtools.Log.i("ad.waid.WaidProvider", "handleQuery, appWaid=".concat(String.valueOf(paramArrayOfString)));
          boolean bool = TextUtils.isEmpty(paramArrayOfString);
          if (!bool) {
            break label588;
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
          str = c.bcG(((JSONObject)localObject2).toString());
          com.tencent.mm.sdk.platformtools.Log.i("ad.waid.WaidReporter", "reportQuery data=".concat(String.valueOf(str)));
          h.IzE.a(18666, new Object[] { Integer.valueOf(2000), str });
        }
        catch (Throwable localThrowable)
        {
          com.tencent.mm.sdk.platformtools.Log.e("ad.waid.WaidReporter", "reportQuery exp=" + android.util.Log.getStackTraceString(localThrowable));
        }
        continue;
        i = 0;
      }
      catch (Throwable paramUri)
      {
        com.tencent.mm.sdk.platformtools.Log.e("ad.waid.WaidProvider", "handleQuery exp=" + paramUri.toString());
        AppMethodBeat.o(209323);
        return null;
      }
      label588:
      continue;
      label593:
      paramUri = (Uri)localObject1;
    }
  }
  
  private a fZS()
  {
    AppMethodBeat.i(209325);
    a locala = new a();
    try
    {
      locala.Lvw = getCallingPackage();
    }
    catch (Throwable localThrowable1)
    {
      try
      {
        for (;;)
        {
          i = Binder.getCallingUid();
          locala.Lvx = getContext().getPackageManager().getPackagesForUid(i);
          if ((locala.Lvx == null) || (locala.Lvx.length <= 0)) {
            break label252;
          }
          if (!TextUtils.isEmpty(locala.Lvw)) {
            break;
          }
          locala.Lvy = 1;
          locala.Lvz = locala.Lvx[0];
          AppMethodBeat.o(209325);
          return locala;
          localThrowable1 = localThrowable1;
          com.tencent.mm.sdk.platformtools.Log.e("ad.waid.WaidProvider", "getCallingPkg exp=" + localThrowable1.toString());
        }
      }
      catch (Throwable localThrowable2)
      {
        for (;;)
        {
          com.tencent.mm.sdk.platformtools.Log.e("ad.waid.WaidProvider", "getCallingUid exp=" + localThrowable2.toString());
        }
        String[] arrayOfString = locala.Lvx;
        int j = arrayOfString.length;
        int i = 0;
        while (i < j)
        {
          String str = arrayOfString[i];
          if (locala.Lvw.equals(str))
          {
            if (locala.Lvx.length > 1) {}
            for (locala.Lvy = 2;; locala.Lvy = 3)
            {
              locala.Lvz = str;
              AppMethodBeat.o(209325);
              return locala;
            }
          }
          i += 1;
        }
        locala.Lvy = 4;
        locala.Lvz = locala.Lvx[0];
        AppMethodBeat.o(209325);
        return locala;
      }
    }
    label252:
    locala.Lvy = 5;
    locala.Lvz = locala.Lvw;
    AppMethodBeat.o(209325);
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
    this.mUriMatcher.addURI(AUTHORITY, "appWaid", 1);
    this.Lvs = System.currentTimeMillis();
    this.Lvu = new a();
    a locala = this.Lvu;
    try
    {
      com.tencent.mm.sdk.platformtools.Log.i("InitTaskMgr", "start");
      Iterator localIterator = locala.Lvm.iterator();
      while (localIterator.hasNext())
      {
        Runnable localRunnable = (Runnable)localIterator.next();
        locala.Lvo.post(localRunnable);
        continue;
        com.tencent.mm.sdk.platformtools.Log.i("ad.waid.WaidProvider", "onCreate, this.hash=" + hashCode());
      }
    }
    catch (Exception localException)
    {
      com.tencent.mm.sdk.platformtools.Log.e("InitTaskMgr", "startInit exp=" + localException.toString());
    }
    for (;;)
    {
      AppMethodBeat.o(100599);
      return true;
      localException.Lvm.clear();
      localException.Lvn.quitSafely();
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
    String Lvw;
    String[] Lvx;
    int Lvy;
    String Lvz;
  }
  
  final class b
    extends Thread
  {
    private int LvA;
    private int fCX;
    
    public b()
    {
      AppMethodBeat.i(217311);
      this.fCX = 0;
      this.LvA = 12000;
      int j = 12000 - WaidProvider.a(WaidProvider.this) * 4000;
      if (j < 2000) {}
      for (;;)
      {
        this.LvA = i;
        AppMethodBeat.o(217311);
        return;
        i = j;
      }
    }
    
    private void fZT()
    {
      AppMethodBeat.i(217315);
      synchronized (WaidProvider.b(WaidProvider.this))
      {
        com.tencent.mm.sdk.platformtools.Log.i("ad.waid.WaidProvider", "break Wait, waitTime=" + this.fCX);
        WaidProvider.c(WaidProvider.this);
        WaidProvider.b(WaidProvider.this).notifyAll();
        AppMethodBeat.o(217315);
        return;
      }
    }
    
    public final void run()
    {
      AppMethodBeat.i(217314);
      com.tencent.mm.sdk.platformtools.Log.i("ad.waid.WaidProvider", "CheckThread run, thread.hash=" + hashCode());
      for (;;)
      {
        if (b.fZR())
        {
          com.tencent.mm.sdk.platformtools.Log.i("ad.waid.WaidProvider", "init done");
          fZT();
          AppMethodBeat.o(217314);
          return;
        }
        com.tencent.mm.sdk.platformtools.Log.d("ad.waid.WaidProvider", "wait, delay=200");
        try
        {
          Thread.sleep(200L);
          this.fCX += 200;
          label77:
          if (this.fCX < this.LvA) {
            continue;
          }
          com.tencent.mm.sdk.platformtools.Log.e("ad.waid.WaidProvider", "wait expired, expiredDuration=" + this.LvA);
          fZT();
          AppMethodBeat.o(217314);
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