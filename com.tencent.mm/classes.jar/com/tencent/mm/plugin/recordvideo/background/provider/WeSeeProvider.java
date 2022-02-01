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
import com.tencent.mm.sdk.platformtools.ad;
import d.g.b.p;
import d.l;
import d.n.n;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/recordvideo/background/provider/WeSeeProvider;", "Landroid/content/ContentProvider;", "()V", "queueSql", "", "uriMatcher", "Landroid/content/UriMatcher;", "weSeeStorage", "Lcom/tencent/mm/plugin/recordvideo/background/provider/WeSeeDataStorage;", "checkMD5", "", "checkTime", "checkValid", "delete", "", "uri", "Landroid/net/Uri;", "selection", "selectionArgs", "", "(Landroid/net/Uri;Ljava/lang/String;[Ljava/lang/String;)I", "getCallingPackages", "()[Ljava/lang/String;", "getType", "insert", "values", "Landroid/content/ContentValues;", "onCreate", "query", "Landroid/database/Cursor;", "projection", "sortOrder", "(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;", "update", "(Landroid/net/Uri;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I", "Companion", "plugin-recordvideo_release"})
public final class WeSeeProvider
  extends ContentProvider
{
  private static final String AUTHORITY = "com.tencent.mm.plugin.recordvideo.background.provider.WeSeeProvider";
  private static final String TAG = "MicroMsg.WeSeeProvider";
  private static final int xwA = 3600000;
  public static final a xwB;
  private static final String xws = "KEY_INSERT_VIDEO_PATH";
  private static final String xwt = "KEY_INSERT_TIME";
  private static final String xwu = "query";
  private static final String xwv = "delete";
  private static final String xww = "insert";
  private static final int xwx = 100;
  private static final int xwy = 101;
  private static final int xwz = 1;
  private UriMatcher rdQ;
  private a xwq;
  private final String xwr;
  
  static
  {
    AppMethodBeat.i(75338);
    xwB = new a((byte)0);
    TAG = "MicroMsg.WeSeeProvider";
    AUTHORITY = "com.tencent.mm.plugin.recordvideo.background.provider.WeSeeProvider";
    xws = "KEY_INSERT_VIDEO_PATH";
    xwt = "KEY_INSERT_TIME";
    xwu = "query";
    xwv = "delete";
    xww = "insert";
    xwx = 100;
    xwy = 101;
    xwz = 1;
    xwA = 3600000;
    AppMethodBeat.o(75338);
  }
  
  public WeSeeProvider()
  {
    AppMethodBeat.i(75337);
    this.rdQ = new UriMatcher(-1);
    StringBuilder localStringBuilder = new StringBuilder("select * from ");
    b.a locala = b.xwC;
    this.xwr = b.dEI();
    this.rdQ.addURI(AUTHORITY, xwu, xwx);
    this.rdQ.addURI(AUTHORITY, xwv, xwy);
    AppMethodBeat.o(75337);
  }
  
  private boolean checkValid()
  {
    AppMethodBeat.i(75329);
    Object localObject1 = dFm();
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
        localObject2 = q.bO(getContext(), (String)localObject1);
        if (localObject2 == null) {
          p.gfZ();
        }
        String str = com.tencent.mm.b.g.getMessageDigest(localObject2[0].toByteArray());
        ad.i(TAG, "checkMD5 packageName:" + (String)localObject1 + ", signatures:" + localObject2 + ", sig:" + str);
        if (n.H("2A281593D71DF33374E6124E9106DF08", str, true))
        {
          ad.i(TAG, "checkMD5 success sig:".concat(String.valueOf(str)));
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
        ad.i(TAG, "checkMD5 failed diff sig:".concat(String.valueOf(str)));
      }
    }
    for (;;)
    {
      i = 0;
      break;
      ad.i(TAG, "checkMD5 failed, packages is empty");
    }
    label191:
    if ((!com.tencent.mm.kernel.g.ajD().ajw()) || (!com.tencent.mm.kernel.g.ajA().aiK()))
    {
      ad.e(TAG, "MMKernel uninit");
      AppMethodBeat.o(75329);
      return false;
    }
    if (this.xwq == null)
    {
      localObject1 = com.tencent.mm.kernel.g.ajC();
      p.g(localObject1, "MMKernel.storage()");
      localObject1 = ((com.tencent.mm.kernel.e)localObject1).getDataDB();
      p.g(localObject1, "MMKernel.storage().dataDB");
      this.xwq = new a((com.tencent.mm.sdk.e.e)localObject1);
      ad.i(TAG, "checkValid, init database");
    }
    localObject1 = this.xwq;
    if (localObject1 != null)
    {
      localObject1 = ((a)localObject1).rawQuery(this.xwr, new String[0]);
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
      ad.e(TAG, "checkTime count error : ".concat(String.valueOf(localObject2)));
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
        ad.d(TAG, "checkTime db time: " + l1 + ", current time: " + l2 + ", diff: " + (l2 - l1));
        if (l1 - l2 < xwA) {
          break label555;
        }
        ad.i(TAG, "checkTime timeout diff is: " + (l1 - l2));
        i = 0;
        continue;
        label526:
        if (((Integer)localObject2).intValue() != 0) {
          break label350;
        }
        ad.i(TAG, "checkTime no data in db");
        i = 1;
        continue;
      }
      AppMethodBeat.o(75329);
      return true;
      label555:
      i = 1;
    }
  }
  
  private final String[] dFm()
  {
    AppMethodBeat.i(75330);
    try
    {
      int i = Binder.getCallingUid();
      Object localObject = getContext();
      if (localObject == null) {
        p.gfZ();
      }
      String[] arrayOfString = ((Context)localObject).getPackageManager().getPackagesForUid(Binder.getCallingUid());
      String str = TAG;
      if (arrayOfString != null) {}
      for (localObject = Integer.valueOf(arrayOfString.length);; localObject = Integer.valueOf(0))
      {
        ad.i(str, "getCallingPackages, callingUid = %d, packages size = %d", new Object[] { Integer.valueOf(i), localObject });
        if (arrayOfString != null) {
          break;
        }
        ad.w(TAG, "getCallingPackages fail, packages is null");
        AppMethodBeat.o(75330);
        return new String[0];
      }
      int j = arrayOfString.length;
      i = 0;
      while (i < j)
      {
        localObject = arrayOfString[i];
        ad.i(TAG, "getCallingPackages = %s", new Object[] { localObject });
        i += 1;
      }
      AppMethodBeat.o(75330);
      return arrayOfString;
    }
    catch (Exception localException)
    {
      ad.e(TAG, "getCallingPackages, ex = %s", new Object[] { localException.getMessage() });
      AppMethodBeat.o(75330);
    }
    return new String[0];
  }
  
  public final int delete(Uri paramUri, String paramString, String[] paramArrayOfString)
  {
    AppMethodBeat.i(75333);
    p.h(paramUri, "uri");
    ad.d(TAG, "delete uri" + paramUri + ", selection" + paramString + ", selectionArgs:" + paramArrayOfString);
    if (!checkValid())
    {
      ad.e(TAG, "delete checkValid failed");
      AppMethodBeat.o(75333);
      return 0;
    }
    int i;
    if (this.rdQ.match(paramUri) == xwy)
    {
      paramUri = this.xwq;
      if (paramUri != null)
      {
        paramUri = Integer.valueOf(paramUri.getCount());
        if (paramUri == null) {
          p.gfZ();
        }
        i = paramUri.intValue();
        if (i != 0) {
          break label151;
        }
        ad.d(TAG, "delete fail count == 0");
      }
    }
    for (;;)
    {
      AppMethodBeat.o(75333);
      return 0;
      paramUri = null;
      break;
      label151:
      ad.d(TAG, "delete into count: ".concat(String.valueOf(i)));
      if (i > 1) {
        ad.e(TAG, "delete count error, count: " + i + ' ');
      }
      paramUri = this.xwq;
      if (paramUri != null)
      {
        paramUri.delete(xwz);
        continue;
        ad.i(TAG, "delete uriMatcher match failed");
      }
    }
  }
  
  public final String getType(Uri paramUri)
  {
    AppMethodBeat.i(75336);
    p.h(paramUri, "uri");
    ad.d(TAG, "getType uri: ".concat(String.valueOf(paramUri)));
    AppMethodBeat.o(75336);
    return null;
  }
  
  public final Uri insert(Uri paramUri, ContentValues paramContentValues)
  {
    AppMethodBeat.i(75334);
    p.h(paramUri, "uri");
    ad.d(TAG, "insert uri:" + paramUri + ", values:" + paramContentValues);
    AppMethodBeat.o(75334);
    return null;
  }
  
  public final boolean onCreate()
  {
    AppMethodBeat.i(75331);
    ad.d(TAG, "onCreate");
    AppMethodBeat.o(75331);
    return true;
  }
  
  public final Cursor query(Uri paramUri, String[] paramArrayOfString1, String paramString1, String[] paramArrayOfString2, String paramString2)
  {
    AppMethodBeat.i(75332);
    p.h(paramUri, "uri");
    ad.d(TAG, "query uri:" + paramUri + ", projection:" + paramArrayOfString1 + ", selection:" + paramString1 + ", selectionArgs:" + paramArrayOfString2 + ", sortOrder:" + paramString2);
    if (!checkValid())
    {
      ad.e(TAG, "query checkValid failed");
      AppMethodBeat.o(75332);
      return null;
    }
    if (this.rdQ.match(paramUri) == xwx)
    {
      ad.i(TAG, "query inner ");
      paramUri = this.xwq;
      if (paramUri != null)
      {
        paramUri = paramUri.rawQuery(this.xwr, new String[0]);
        AppMethodBeat.o(75332);
        return paramUri;
      }
      AppMethodBeat.o(75332);
      return null;
    }
    ad.i(TAG, "query uriMatcher match failed");
    AppMethodBeat.o(75332);
    return null;
  }
  
  public final int update(Uri paramUri, ContentValues paramContentValues, String paramString, String[] paramArrayOfString)
  {
    AppMethodBeat.i(75335);
    p.h(paramUri, "uri");
    ad.d(TAG, "update uri" + paramUri + ", values:" + paramContentValues + ", selection:" + paramString + ", selectionArgs:" + paramArrayOfString);
    AppMethodBeat.o(75335);
    return 0;
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/recordvideo/background/provider/WeSeeProvider$Companion;", "", "()V", "AUTHORITY", "", "getAUTHORITY", "()Ljava/lang/String;", "CHECK_TIME", "", "CODE_DELETE", "CODE_QUERY", "KEY_INSERT_TIME", "getKEY_INSERT_TIME", "KEY_INSERT_VIDEO_PATH", "getKEY_INSERT_VIDEO_PATH", "PATH_DELETE", "PATH_INSERT", "PATH_QUERY", "TAG", "getTAG", "VALUE_INDEX", "delete", "", "insert", "weSeeUri", "time", "", "plugin-recordvideo_release"})
  public static final class a
  {
    public static void bd(String paramString, long paramLong)
    {
      AppMethodBeat.i(163417);
      p.h(paramString, "weSeeUri");
      ad.i(WeSeeProvider.access$getTAG$cp(), "insert fun");
      Object localObject = com.tencent.mm.kernel.g.ajC();
      p.g(localObject, "MMKernel.storage()");
      localObject = ((com.tencent.mm.kernel.e)localObject).getDataDB();
      p.g(localObject, "MMKernel.storage().dataDB");
      localObject = new a((com.tencent.mm.sdk.e.e)localObject);
      b localb = new b();
      localb.field_weSeeUri = paramString;
      localb.field_time = paramLong;
      if (((a)localObject).getCount() == 0)
      {
        ad.i(WeSeeProvider.access$getTAG$cp(), "insert weseeProvider:" + paramString + ", time:" + paramLong);
        ((a)localObject).insert((c)localb);
        AppMethodBeat.o(163417);
        return;
      }
      ad.i(WeSeeProvider.access$getTAG$cp(), "update weseeProvider:" + paramString + ", time:" + paramLong);
      ((a)localObject).update(WeSeeProvider.dFn(), (c)localb);
      AppMethodBeat.o(163417);
    }
    
    public static void delete()
    {
      AppMethodBeat.i(163418);
      ad.i(WeSeeProvider.access$getTAG$cp(), "delete fun");
      Object localObject = com.tencent.mm.kernel.g.ajC();
      p.g(localObject, "MMKernel.storage()");
      localObject = ((com.tencent.mm.kernel.e)localObject).getDataDB();
      p.g(localObject, "MMKernel.storage().dataDB");
      localObject = new a((com.tencent.mm.sdk.e.e)localObject);
      int i = ((a)localObject).getCount();
      if (i == 0)
      {
        ad.d(WeSeeProvider.access$getTAG$cp(), "delete fail count == 0");
        AppMethodBeat.o(163418);
        return;
      }
      ad.d(WeSeeProvider.access$getTAG$cp(), "delete into count: ".concat(String.valueOf(i)));
      if (i > 1) {
        ad.e(WeSeeProvider.access$getTAG$cp(), "delete count error, count: " + i + ' ');
      }
      ((a)localObject).delete(WeSeeProvider.dFn());
      AppMethodBeat.o(163418);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.background.provider.WeSeeProvider
 * JD-Core Version:    0.7.0.1
 */