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
import com.tencent.mm.b.g;
import com.tencent.mm.kernel.f;
import com.tencent.mm.kernel.h;
import com.tencent.mm.pluginsdk.model.app.u;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.WeChatAuthorities;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.g.b.c;
import kotlin.g.b.s;
import kotlin.n.n;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/recordvideo/background/provider/WeSeeProvider;", "Landroid/content/ContentProvider;", "()V", "queueSql", "", "uriMatcher", "Landroid/content/UriMatcher;", "weSeeStorage", "Lcom/tencent/mm/plugin/recordvideo/background/provider/WeSeeDataStorage;", "checkMD5", "", "checkTime", "checkValid", "delete", "", "uri", "Landroid/net/Uri;", "selection", "selectionArgs", "", "(Landroid/net/Uri;Ljava/lang/String;[Ljava/lang/String;)I", "getCallingPackages", "()[Ljava/lang/String;", "getType", "insert", "values", "Landroid/content/ContentValues;", "onCreate", "query", "Landroid/database/Cursor;", "projection", "sortOrder", "(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;", "update", "(Landroid/net/Uri;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I", "Companion", "plugin-recordvideo_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class WeSeeProvider
  extends ContentProvider
{
  private static final String AUTHORITY;
  public static final a NFX;
  private static final String NGa;
  private static final String NGb;
  private static final String NGc;
  private static final String NGd;
  private static final String NGe;
  private static final int NGf;
  private static final int NGg;
  private static final int NGh;
  private static final int NGi;
  private static final String TAG;
  private a NFY;
  private final String NFZ;
  private UriMatcher zPC;
  
  static
  {
    AppMethodBeat.i(75338);
    NFX = new a((byte)0);
    TAG = "MicroMsg.WeSeeProvider";
    AUTHORITY = WeChatAuthorities.AUTHORITIES_PLUGIN_RECORDVIDEO_BACKGROUND_PROVIDER_WESEEPROVIDER();
    NGa = "KEY_INSERT_VIDEO_PATH";
    NGb = "KEY_INSERT_TIME";
    NGc = "query";
    NGd = "delete";
    NGe = "insert";
    NGf = 100;
    NGg = 101;
    NGh = 1;
    NGi = 3600000;
    AppMethodBeat.o(75338);
  }
  
  public WeSeeProvider()
  {
    AppMethodBeat.i(75337);
    this.zPC = new UriMatcher(-1);
    b.a locala = b.NGj;
    this.NFZ = s.X("select * from ", b.gGG());
    this.zPC.addURI(AUTHORITY, NGc, NGf);
    this.zPC.addURI(AUTHORITY, NGd, NGg);
    AppMethodBeat.o(75337);
  }
  
  private boolean checkValid()
  {
    AppMethodBeat.i(75329);
    Object localObject1 = gHj();
    int i;
    if (localObject1.length == 0)
    {
      i = 1;
      if (i != 0) {
        break label148;
      }
      i = 1;
    }
    Object localObject2;
    for (;;)
    {
      if (i != 0)
      {
        localObject1 = localObject1[0];
        localObject2 = u.cG(getContext(), (String)localObject1);
        s.checkNotNull(localObject2);
        String str = g.getMessageDigest(localObject2[0].toByteArray());
        Log.i(TAG, "checkMD5 packageName:" + localObject1 + ", signatures:" + localObject2 + ", sig:" + str);
        if (n.T("2A281593D71DF33374E6124E9106DF08", str, true))
        {
          Log.i(TAG, s.X("checkMD5 success sig:", str));
          i = 1;
          if (i != 0) {
            break label182;
          }
          AppMethodBeat.o(75329);
          return false;
          i = 0;
          break;
          label148:
          i = 0;
          continue;
        }
        Log.i(TAG, s.X("checkMD5 failed diff sig:", str));
      }
    }
    for (;;)
    {
      i = 0;
      break;
      Log.i(TAG, "checkMD5 failed, packages is empty");
    }
    label182:
    if ((!h.baF().mDv) || (!h.baC().aZN()))
    {
      Log.e(TAG, "MMKernel uninit");
      AppMethodBeat.o(75329);
      return false;
    }
    if (this.NFY == null)
    {
      localObject1 = h.baE().mCN;
      s.s(localObject1, "storage().dataDB");
      this.NFY = new a((ISQLiteDatabase)localObject1);
      Log.i(TAG, "checkValid, init database");
    }
    localObject1 = this.NFY;
    if (localObject1 == null)
    {
      localObject1 = null;
      if (localObject1 != null) {
        ((Cursor)localObject1).moveToFirst();
      }
      if (localObject1 != null) {
        break label365;
      }
      localObject2 = null;
      label298:
      if (localObject2 != null) {
        break label380;
      }
      label303:
      if (localObject2 != null) {
        break label495;
      }
      label308:
      Log.e(TAG, s.X("checkTime count error : ", localObject2));
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
        localObject1 = ((a)localObject1).rawQuery(this.NFZ, new String[0]);
        break;
        label365:
        localObject2 = Integer.valueOf(((Cursor)localObject1).getCount());
        break label298;
        label380:
        if (((Integer)localObject2).intValue() != 1) {
          break label303;
        }
        long l1 = ((Cursor)localObject1).getLong(((Cursor)localObject1).getColumnIndex("time"));
        long l2 = System.currentTimeMillis();
        Log.d(TAG, "checkTime db time: " + l1 + ", current time: " + l2 + ", diff: " + (l2 - l1));
        if (l1 - l2 < NGi) {
          break label524;
        }
        Log.i(TAG, s.X("checkTime timeout diff is: ", Long.valueOf(l1 - l2)));
        i = 0;
        continue;
        label495:
        if (((Integer)localObject2).intValue() != 0) {
          break label308;
        }
        Log.i(TAG, "checkTime no data in db");
        i = 1;
        continue;
      }
      AppMethodBeat.o(75329);
      return true;
      label524:
      i = 1;
    }
  }
  
  private final String[] gHj()
  {
    AppMethodBeat.i(75330);
    try
    {
      int j = Binder.getCallingUid();
      Object localObject1 = getContext();
      s.checkNotNull(localObject1);
      localObject1 = ((Context)localObject1).getPackageManager().getPackagesForUid(Binder.getCallingUid());
      Object localObject2 = TAG;
      if (localObject1 == null) {}
      for (int i = 0;; i = localObject1.length)
      {
        Log.i((String)localObject2, "getCallingPackages, callingUid = %d, packages size = %d", new Object[] { Integer.valueOf(j), Integer.valueOf(i) });
        if (localObject1 != null) {
          break;
        }
        Log.w(TAG, "getCallingPackages fail, packages is null");
        AppMethodBeat.o(75330);
        return new String[0];
      }
      localObject2 = c.ao((Object[])localObject1);
      while (((Iterator)localObject2).hasNext())
      {
        String str = (String)((Iterator)localObject2).next();
        Log.i(TAG, "getCallingPackages = %s", new Object[] { str });
      }
      AppMethodBeat.o(75330);
    }
    catch (Exception localException)
    {
      Log.e(TAG, "getCallingPackages, ex = %s", new Object[] { localException.getMessage() });
      AppMethodBeat.o(75330);
      return new String[0];
    }
    return localException;
  }
  
  public final int delete(Uri paramUri, String paramString, String[] paramArrayOfString)
  {
    AppMethodBeat.i(75333);
    s.u(paramUri, "uri");
    Log.d(TAG, "delete uri" + paramUri + ", selection" + paramString + ", selectionArgs:" + paramArrayOfString);
    if (!checkValid())
    {
      Log.e(TAG, "delete checkValid failed");
      AppMethodBeat.o(75333);
      return 0;
    }
    int i;
    if (this.zPC.match(paramUri) == NGg)
    {
      paramUri = this.NFY;
      if (paramUri == null)
      {
        paramUri = null;
        s.checkNotNull(paramUri);
        i = paramUri.intValue();
        if (i != 0) {
          break label148;
        }
        Log.d(TAG, "delete fail count == 0");
      }
    }
    for (;;)
    {
      AppMethodBeat.o(75333);
      return 0;
      paramUri = Integer.valueOf(paramUri.getCount());
      break;
      label148:
      Log.d(TAG, s.X("delete into count: ", Integer.valueOf(i)));
      if (i > 1) {
        Log.e(TAG, "delete count error, count: " + i + ' ');
      }
      paramUri = this.NFY;
      if (paramUri != null)
      {
        paramUri.delete(NGh);
        continue;
        Log.i(TAG, "delete uriMatcher match failed");
      }
    }
  }
  
  public final String getType(Uri paramUri)
  {
    AppMethodBeat.i(75336);
    s.u(paramUri, "uri");
    Log.d(TAG, s.X("getType uri: ", paramUri));
    AppMethodBeat.o(75336);
    return null;
  }
  
  public final Uri insert(Uri paramUri, ContentValues paramContentValues)
  {
    AppMethodBeat.i(75334);
    s.u(paramUri, "uri");
    Log.d(TAG, "insert uri:" + paramUri + ", values:" + paramContentValues);
    AppMethodBeat.o(75334);
    return null;
  }
  
  public final boolean onCreate()
  {
    AppMethodBeat.i(75331);
    Log.d(TAG, "onCreate");
    AppMethodBeat.o(75331);
    return true;
  }
  
  public final Cursor query(Uri paramUri, String[] paramArrayOfString1, String paramString1, String[] paramArrayOfString2, String paramString2)
  {
    AppMethodBeat.i(75332);
    s.u(paramUri, "uri");
    Log.d(TAG, "query uri:" + paramUri + ", projection:" + paramArrayOfString1 + ", selection:" + paramString1 + ", selectionArgs:" + paramArrayOfString2 + ", sortOrder:" + paramString2);
    if (!checkValid())
    {
      Log.e(TAG, "query checkValid failed");
      AppMethodBeat.o(75332);
      return null;
    }
    if (this.zPC.match(paramUri) == NGf)
    {
      Log.i(TAG, "query inner ");
      paramUri = this.NFY;
      if (paramUri == null)
      {
        AppMethodBeat.o(75332);
        return null;
      }
      paramUri = paramUri.rawQuery(this.NFZ, new String[0]);
      AppMethodBeat.o(75332);
      return paramUri;
    }
    Log.i(TAG, "query uriMatcher match failed");
    AppMethodBeat.o(75332);
    return null;
  }
  
  public final int update(Uri paramUri, ContentValues paramContentValues, String paramString, String[] paramArrayOfString)
  {
    AppMethodBeat.i(75335);
    s.u(paramUri, "uri");
    Log.d(TAG, "update uri" + paramUri + ", values:" + paramContentValues + ", selection:" + paramString + ", selectionArgs:" + paramArrayOfString);
    AppMethodBeat.o(75335);
    return 0;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/recordvideo/background/provider/WeSeeProvider$Companion;", "", "()V", "AUTHORITY", "", "kotlin.jvm.PlatformType", "getAUTHORITY", "()Ljava/lang/String;", "CHECK_TIME", "", "CODE_DELETE", "CODE_QUERY", "KEY_INSERT_TIME", "getKEY_INSERT_TIME", "KEY_INSERT_VIDEO_PATH", "getKEY_INSERT_VIDEO_PATH", "PATH_DELETE", "PATH_INSERT", "PATH_QUERY", "TAG", "getTAG", "VALUE_INDEX", "delete", "", "insert", "weSeeUri", "time", "", "plugin-recordvideo_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
  {
    public static void bt(String paramString, long paramLong)
    {
      AppMethodBeat.i(163417);
      s.u(paramString, "weSeeUri");
      Log.i(WeSeeProvider.access$getTAG$cp(), "insert fun");
      Object localObject = h.baE().mCN;
      s.s(localObject, "storage().dataDB");
      localObject = new a((ISQLiteDatabase)localObject);
      b localb = new b();
      localb.field_weSeeUri = paramString;
      localb.field_time = paramLong;
      if (((a)localObject).getCount() == 0)
      {
        Log.i(WeSeeProvider.access$getTAG$cp(), "insert weseeProvider:" + paramString + ", time:" + paramLong);
        ((a)localObject).insert((IAutoDBItem)localb);
        AppMethodBeat.o(163417);
        return;
      }
      Log.i(WeSeeProvider.access$getTAG$cp(), "update weseeProvider:" + paramString + ", time:" + paramLong);
      ((a)localObject).update(WeSeeProvider.gHk(), (IAutoDBItem)localb);
      AppMethodBeat.o(163417);
    }
    
    public static void gDE()
    {
      AppMethodBeat.i(163418);
      Log.i(WeSeeProvider.access$getTAG$cp(), "delete fun");
      Object localObject = h.baE().mCN;
      s.s(localObject, "storage().dataDB");
      localObject = new a((ISQLiteDatabase)localObject);
      int i = ((a)localObject).getCount();
      if (i == 0)
      {
        Log.d(WeSeeProvider.access$getTAG$cp(), "delete fail count == 0");
        AppMethodBeat.o(163418);
        return;
      }
      Log.d(WeSeeProvider.access$getTAG$cp(), s.X("delete into count: ", Integer.valueOf(i)));
      if (i > 1) {
        Log.e(WeSeeProvider.access$getTAG$cp(), "delete count error, count: " + i + ' ');
      }
      ((a)localObject).delete(WeSeeProvider.gHk());
      AppMethodBeat.o(163418);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.background.provider.WeSeeProvider
 * JD-Core Version:    0.7.0.1
 */