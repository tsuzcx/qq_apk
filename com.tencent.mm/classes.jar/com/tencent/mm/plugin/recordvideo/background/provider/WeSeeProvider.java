package com.tencent.mm.plugin.recordvideo.background.provider;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.content.UriMatcher;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.database.Cursor;
import android.net.Uri;
import android.os.Binder;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.model.app.q;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.platformtools.ae;
import d.g.b.p;
import d.l;
import d.n.n;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/recordvideo/background/provider/WeSeeProvider;", "Landroid/content/ContentProvider;", "()V", "queueSql", "", "uriMatcher", "Landroid/content/UriMatcher;", "weSeeStorage", "Lcom/tencent/mm/plugin/recordvideo/background/provider/WeSeeDataStorage;", "checkMD5", "", "checkTime", "checkValid", "delete", "", "uri", "Landroid/net/Uri;", "selection", "selectionArgs", "", "(Landroid/net/Uri;Ljava/lang/String;[Ljava/lang/String;)I", "getCallingPackages", "()[Ljava/lang/String;", "getType", "insert", "values", "Landroid/content/ContentValues;", "onCreate", "query", "Landroid/database/Cursor;", "projection", "sortOrder", "(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;", "update", "(Landroid/net/Uri;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I", "Companion", "plugin-recordvideo_release"})
public final class WeSeeProvider
  extends ContentProvider
{
  private static final String AUTHORITY = "com.tencent.mm.plugin.recordvideo.background.provider.WeSeeProvider";
  private static final String TAG = "MicroMsg.WeSeeProvider";
  private static final String xMp = "KEY_INSERT_VIDEO_PATH";
  private static final String xMq = "KEY_INSERT_TIME";
  private static final String xMr = "query";
  private static final String xMs = "delete";
  private static final String xMt = "insert";
  private static final int xMu = 100;
  private static final int xMv = 101;
  private static final int xMw = 1;
  private static final int xMx = 3600000;
  public static final a xMy;
  private UriMatcher rlW;
  private a xMn;
  private final String xMo;
  
  static
  {
    AppMethodBeat.i(75338);
    xMy = new a((byte)0);
    TAG = "MicroMsg.WeSeeProvider";
    AUTHORITY = "com.tencent.mm.plugin.recordvideo.background.provider.WeSeeProvider";
    xMp = "KEY_INSERT_VIDEO_PATH";
    xMq = "KEY_INSERT_TIME";
    xMr = "query";
    xMs = "delete";
    xMt = "insert";
    xMu = 100;
    xMv = 101;
    xMw = 1;
    xMx = 3600000;
    AppMethodBeat.o(75338);
  }
  
  public WeSeeProvider()
  {
    AppMethodBeat.i(75337);
    this.rlW = new UriMatcher(-1);
    StringBuilder localStringBuilder = new StringBuilder("select * from ");
    b.a locala = b.xMz;
    this.xMo = b.dHZ();
    this.rlW.addURI(AUTHORITY, xMr, xMu);
    this.rlW.addURI(AUTHORITY, xMs, xMv);
    AppMethodBeat.o(75337);
  }
  
  private boolean checkValid()
  {
    AppMethodBeat.i(75329);
    Object localObject1 = dID();
    int i;
    if (localObject1.length == 0)
    {
      i = 1;
      if (i != 0) {
        break label154;
      }
      i = 1;
    }
    Object localObject2;
    for (;;)
    {
      if (i != 0)
      {
        localObject1 = localObject1[0];
        localObject2 = q.bP(getContext(), (String)localObject1);
        if (localObject2 == null) {
          p.gkB();
        }
        String str = com.tencent.mm.b.g.getMessageDigest(localObject2[0].toByteArray());
        ae.i(TAG, "checkMD5 packageName:" + (String)localObject1 + ", signatures:" + localObject2 + ", sig:" + str);
        if (n.H("2A281593D71DF33374E6124E9106DF08", str, true))
        {
          ae.i(TAG, "checkMD5 success sig:".concat(String.valueOf(str)));
          i = 1;
          if (i != 0) {
            break label191;
          }
          AppMethodBeat.o(75329);
          return false;
          i = 0;
          break;
          label154:
          i = 0;
          continue;
        }
        ae.i(TAG, "checkMD5 failed diff sig:".concat(String.valueOf(str)));
      }
    }
    for (;;)
    {
      i = 0;
      break;
      ae.i(TAG, "checkMD5 failed, packages is empty");
    }
    label191:
    if ((!com.tencent.mm.kernel.g.ajS().ajL()) || (!com.tencent.mm.kernel.g.ajP().aiZ()))
    {
      ae.e(TAG, "MMKernel uninit");
      AppMethodBeat.o(75329);
      return false;
    }
    if (this.xMn == null)
    {
      localObject1 = com.tencent.mm.kernel.g.ajR();
      p.g(localObject1, "MMKernel.storage()");
      localObject1 = ((com.tencent.mm.kernel.e)localObject1).getDataDB();
      p.g(localObject1, "MMKernel.storage().dataDB");
      this.xMn = new a((com.tencent.mm.sdk.e.e)localObject1);
      ae.i(TAG, "checkValid, init database");
    }
    localObject1 = this.xMn;
    if (localObject1 != null)
    {
      localObject1 = ((a)localObject1).rawQuery(this.xMo, new String[0]);
      if (localObject1 != null) {
        ((Cursor)localObject1).moveToFirst();
      }
      if (localObject1 == null) {
        break label398;
      }
      localObject2 = Integer.valueOf(((Cursor)localObject1).getCount());
      label340:
      if (localObject2 != null) {
        break label404;
      }
      label345:
      if (localObject2 != null) {
        break label526;
      }
      label350:
      ae.e(TAG, "checkTime count error : ".concat(String.valueOf(localObject2)));
      i = 0;
    }
    for (;;)
    {
      if (localObject1 != null) {
        ((Cursor)localObject1).close();
      }
      if (i == 0)
      {
        AppMethodBeat.o(75329);
        return false;
        localObject1 = null;
        break;
        label398:
        localObject2 = null;
        break label340;
        label404:
        if (((Integer)localObject2).intValue() != 1) {
          break label345;
        }
        long l1 = ((Cursor)localObject1).getLong(((Cursor)localObject1).getColumnIndex("time"));
        long l2 = System.currentTimeMillis();
        ae.d(TAG, "checkTime db time: " + l1 + ", current time: " + l2 + ", diff: " + (l2 - l1));
        if (l1 - l2 < xMx) {
          break label555;
        }
        ae.i(TAG, "checkTime timeout diff is: " + (l1 - l2));
        i = 0;
        continue;
        label526:
        if (((Integer)localObject2).intValue() != 0) {
          break label350;
        }
        ae.i(TAG, "checkTime no data in db");
        i = 1;
        continue;
      }
      AppMethodBeat.o(75329);
      return true;
      label555:
      i = 1;
    }
  }
  
  private final String[] dID()
  {
    AppMethodBeat.i(75330);
    try
    {
      int i = Binder.getCallingUid();
      Object localObject = getContext();
      if (localObject == null) {
        p.gkB();
      }
      String[] arrayOfString = ((Context)localObject).getPackageManager().getPackagesForUid(Binder.getCallingUid());
      String str = TAG;
      if (arrayOfString != null) {}
      for (localObject = Integer.valueOf(arrayOfString.length);; localObject = Integer.valueOf(0))
      {
        ae.i(str, "getCallingPackages, callingUid = %d, packages size = %d", new Object[] { Integer.valueOf(i), localObject });
        if (arrayOfString != null) {
          break;
        }
        ae.w(TAG, "getCallingPackages fail, packages is null");
        AppMethodBeat.o(75330);
        return new String[0];
      }
      int j = arrayOfString.length;
      i = 0;
      while (i < j)
      {
        localObject = arrayOfString[i];
        ae.i(TAG, "getCallingPackages = %s", new Object[] { localObject });
        i += 1;
      }
      AppMethodBeat.o(75330);
      return arrayOfString;
    }
    catch (Exception localException)
    {
      ae.e(TAG, "getCallingPackages, ex = %s", new Object[] { localException.getMessage() });
      AppMethodBeat.o(75330);
    }
    return new String[0];
  }
  
  public final int delete(Uri paramUri, String paramString, String[] paramArrayOfString)
  {
    AppMethodBeat.i(75333);
    p.h(paramUri, "uri");
    ae.d(TAG, "delete uri" + paramUri + ", selection" + paramString + ", selectionArgs:" + paramArrayOfString);
    if (!checkValid())
    {
      ae.e(TAG, "delete checkValid failed");
      AppMethodBeat.o(75333);
      return 0;
    }
    int i;
    if (this.rlW.match(paramUri) == xMv)
    {
      paramUri = this.xMn;
      if (paramUri != null)
      {
        paramUri = Integer.valueOf(paramUri.getCount());
        if (paramUri == null) {
          p.gkB();
        }
        i = paramUri.intValue();
        if (i != 0) {
          break label151;
        }
        ae.d(TAG, "delete fail count == 0");
      }
    }
    for (;;)
    {
      AppMethodBeat.o(75333);
      return 0;
      paramUri = null;
      break;
      label151:
      ae.d(TAG, "delete into count: ".concat(String.valueOf(i)));
      if (i > 1) {
        ae.e(TAG, "delete count error, count: " + i + ' ');
      }
      paramUri = this.xMn;
      if (paramUri != null)
      {
        paramUri.delete(xMw);
        continue;
        ae.i(TAG, "delete uriMatcher match failed");
      }
    }
  }
  
  public final String getType(Uri paramUri)
  {
    AppMethodBeat.i(75336);
    p.h(paramUri, "uri");
    ae.d(TAG, "getType uri: ".concat(String.valueOf(paramUri)));
    AppMethodBeat.o(75336);
    return null;
  }
  
  public final Uri insert(Uri paramUri, ContentValues paramContentValues)
  {
    AppMethodBeat.i(75334);
    p.h(paramUri, "uri");
    ae.d(TAG, "insert uri:" + paramUri + ", values:" + paramContentValues);
    AppMethodBeat.o(75334);
    return null;
  }
  
  public final boolean onCreate()
  {
    AppMethodBeat.i(75331);
    ae.d(TAG, "onCreate");
    AppMethodBeat.o(75331);
    return true;
  }
  
  public final Cursor query(Uri paramUri, String[] paramArrayOfString1, String paramString1, String[] paramArrayOfString2, String paramString2)
  {
    AppMethodBeat.i(75332);
    p.h(paramUri, "uri");
    ae.d(TAG, "query uri:" + paramUri + ", projection:" + paramArrayOfString1 + ", selection:" + paramString1 + ", selectionArgs:" + paramArrayOfString2 + ", sortOrder:" + paramString2);
    if (!checkValid())
    {
      ae.e(TAG, "query checkValid failed");
      AppMethodBeat.o(75332);
      return null;
    }
    if (this.rlW.match(paramUri) == xMu)
    {
      ae.i(TAG, "query inner ");
      paramUri = this.xMn;
      if (paramUri != null)
      {
        paramUri = paramUri.rawQuery(this.xMo, new String[0]);
        AppMethodBeat.o(75332);
        return paramUri;
      }
      AppMethodBeat.o(75332);
      return null;
    }
    ae.i(TAG, "query uriMatcher match failed");
    AppMethodBeat.o(75332);
    return null;
  }
  
  public final int update(Uri paramUri, ContentValues paramContentValues, String paramString, String[] paramArrayOfString)
  {
    AppMethodBeat.i(75335);
    p.h(paramUri, "uri");
    ae.d(TAG, "update uri" + paramUri + ", values:" + paramContentValues + ", selection:" + paramString + ", selectionArgs:" + paramArrayOfString);
    AppMethodBeat.o(75335);
    return 0;
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/recordvideo/background/provider/WeSeeProvider$Companion;", "", "()V", "AUTHORITY", "", "getAUTHORITY", "()Ljava/lang/String;", "CHECK_TIME", "", "CODE_DELETE", "CODE_QUERY", "KEY_INSERT_TIME", "getKEY_INSERT_TIME", "KEY_INSERT_VIDEO_PATH", "getKEY_INSERT_VIDEO_PATH", "PATH_DELETE", "PATH_INSERT", "PATH_QUERY", "TAG", "getTAG", "VALUE_INDEX", "delete", "", "insert", "weSeeUri", "time", "", "plugin-recordvideo_release"})
  public static final class a
  {
    public static void be(String paramString, long paramLong)
    {
      AppMethodBeat.i(163417);
      p.h(paramString, "weSeeUri");
      ae.i(WeSeeProvider.access$getTAG$cp(), "insert fun");
      Object localObject = com.tencent.mm.kernel.g.ajR();
      p.g(localObject, "MMKernel.storage()");
      localObject = ((com.tencent.mm.kernel.e)localObject).getDataDB();
      p.g(localObject, "MMKernel.storage().dataDB");
      localObject = new a((com.tencent.mm.sdk.e.e)localObject);
      b localb = new b();
      localb.field_weSeeUri = paramString;
      localb.field_time = paramLong;
      if (((a)localObject).getCount() == 0)
      {
        ae.i(WeSeeProvider.access$getTAG$cp(), "insert weseeProvider:" + paramString + ", time:" + paramLong);
        ((a)localObject).insert((c)localb);
        AppMethodBeat.o(163417);
        return;
      }
      ae.i(WeSeeProvider.access$getTAG$cp(), "update weseeProvider:" + paramString + ", time:" + paramLong);
      ((a)localObject).update(WeSeeProvider.dIE(), (c)localb);
      AppMethodBeat.o(163417);
    }
    
    public static void delete()
    {
      AppMethodBeat.i(163418);
      ae.i(WeSeeProvider.access$getTAG$cp(), "delete fun");
      Object localObject = com.tencent.mm.kernel.g.ajR();
      p.g(localObject, "MMKernel.storage()");
      localObject = ((com.tencent.mm.kernel.e)localObject).getDataDB();
      p.g(localObject, "MMKernel.storage().dataDB");
      localObject = new a((com.tencent.mm.sdk.e.e)localObject);
      int i = ((a)localObject).getCount();
      if (i == 0)
      {
        ae.d(WeSeeProvider.access$getTAG$cp(), "delete fail count == 0");
        AppMethodBeat.o(163418);
        return;
      }
      ae.d(WeSeeProvider.access$getTAG$cp(), "delete into count: ".concat(String.valueOf(i)));
      if (i > 1) {
        ae.e(WeSeeProvider.access$getTAG$cp(), "delete count error, count: " + i + ' ');
      }
      ((a)localObject).delete(WeSeeProvider.dIE());
      AppMethodBeat.o(163418);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.background.provider.WeSeeProvider
 * JD-Core Version:    0.7.0.1
 */