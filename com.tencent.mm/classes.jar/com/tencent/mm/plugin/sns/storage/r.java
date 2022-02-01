package com.tencent.mm.plugin.sns.storage;

import android.database.Cursor;
import androidx.lifecycle.x;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.openim.PluginOpenIM;
import com.tencent.mm.openim.e.j;
import com.tencent.mm.plugin.sns.c.g;
import com.tencent.mm.plugin.sns.cover.c.b;
import com.tencent.mm.plugin.sns.model.al;
import com.tencent.mm.plugin.sns.model.as;
import com.tencent.mm.plugin.sns.storage.a.a;
import com.tencent.mm.protocal.protobuf.FinderMedia;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.FinderObjectDesc;
import com.tencent.mm.protocal.protobuf.ffs;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.MAutoStorage;
import com.tencent.mm.storage.au;
import com.tencent.mm.vfs.y;
import com.tencent.threadpool.i;
import java.io.IOException;
import java.util.LinkedList;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/sns/storage/SnsCoverStorage;", "Lcom/tencent/mm/sdk/storage/MAutoStorage;", "Lcom/tencent/mm/plugin/sns/storage/SnsCover;", "Lcom/tencent/mm/plugin/sns/api/ISnsCover;", "db", "Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;", "(Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;)V", "coverLRUMap", "Lcom/tencent/mm/algorithm/MMLRUMap;", "", "selectBegin", "getSelectBegin", "()Ljava/lang/String;", "viewModel", "Lcom/tencent/mm/plugin/sns/storage/cover/SnsCoverViewModel;", "getViewModel", "()Lcom/tencent/mm/plugin/sns/storage/cover/SnsCoverViewModel;", "blockCover", "", "userName", "clearCoverResource", "cover", "clearDBData", "downloadBitmap", "", "snsId", "", "path", "downloadPhoto", "downloadThumb", "downloadVideo", "(Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;)Z", "getCoverInfo", "removeSnsCover", "updateBg", "sui", "Lcom/tencent/mm/protocal/protobuf/SnsUserInfo;", "updateCoverFinderInfo", "finderObject", "Lcom/tencent/mm/protocal/protobuf/FinderObject;", "online", "updateCoverImageInfoLocal", "thumb", "updateCoverInfo", "post", "updateCoverVideoInfoLocal", "videoPath", "thumbPath", "imagePath", "updateFinderInfoFromDetail", "updateUserSnsCoverNetScene", "snsUserInfo", "Companion", "SnsCoverClearTask", "plugin-sns_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class r
  extends MAutoStorage<q>
  implements g
{
  public static final a QYI;
  private static final String[] SQL_CREATE;
  public static final String TAG;
  private static final String ptT;
  public final com.tencent.mm.b.h<String, q> QYJ;
  public final a QYK;
  private final ISQLiteDatabase db;
  
  static
  {
    AppMethodBeat.i(306602);
    QYI = new a((byte)0);
    TAG = "MicroMsg.SnsCoverStorage";
    ptT = "SnsCover";
    SQL_CREATE = new String[] { MAutoStorage.getCreateSQLs(q.info, ptT) };
    AppMethodBeat.o(306602);
  }
  
  public r(ISQLiteDatabase paramISQLiteDatabase)
  {
    super(paramISQLiteDatabase, q.info, ptT, null);
    AppMethodBeat.i(306574);
    this.db = paramISQLiteDatabase;
    this.QYJ = new com.tencent.mm.b.h(5);
    this.QYK = new a();
    Log.i(TAG, "createSnsCoverStorage " + this.db + "  " + Thread.currentThread().getId());
    AppMethodBeat.o(306574);
  }
  
  public static void c(q paramq)
  {
    AppMethodBeat.i(306586);
    Log.i(TAG, "clearCoverResource");
    paramq.field_snsBgId = -1L;
    paramq.field_imageBgUrl = "";
    paramq.field_thumbUrl = "";
    paramq.field_videoBgUrl = "";
    paramq.field_finderObject = null;
    paramq.field_success = false;
    paramq.field_isLike = false;
    AppMethodBeat.o(306586);
  }
  
  private final boolean i(String paramString1, long paramLong, String paramString2)
  {
    AppMethodBeat.i(306593);
    Log.i(TAG, "downloadPhoto user:" + paramString1 + " id:" + paramLong + " path:" + paramString2 + " size:" + y.bEl(paramString2));
    paramString1 = aZM(paramString1);
    Long localLong;
    if (paramString1 != null)
    {
      localLong = Long.valueOf(paramString1.field_snsBgId);
      if (localLong != null) {
        break label120;
      }
    }
    for (int i = 0;; i = 1)
    {
      if ((i == 0) || (!paramString1.field_success)) {
        break label136;
      }
      paramString1.field_localImage = paramString2;
      boolean bool = a(paramString1, false);
      AppMethodBeat.o(306593);
      return bool;
      label120:
      if (localLong.longValue() != paramLong) {
        break;
      }
    }
    label136:
    AppMethodBeat.o(306593);
    return false;
  }
  
  private final boolean j(String paramString1, long paramLong, String paramString2)
  {
    AppMethodBeat.i(306597);
    Log.i(TAG, "downloadThumb user:" + paramString1 + " id:" + paramLong + " path:" + paramString2 + " size:" + y.bEl(paramString2));
    paramString1 = aZM(paramString1);
    Long localLong;
    if (paramString1 != null)
    {
      localLong = Long.valueOf(paramString1.field_snsBgId);
      if (localLong != null) {
        break label123;
      }
    }
    for (int i = 0;; i = 1)
    {
      if ((i == 0) || (!paramString1.field_success)) {
        break label139;
      }
      paramString1.field_localThumb = paramString2;
      boolean bool = a(paramString1, false);
      AppMethodBeat.o(306597);
      return bool;
      label123:
      if (localLong.longValue() != paramLong) {
        break;
      }
    }
    label139:
    AppMethodBeat.o(306597);
    return false;
  }
  
  public final boolean a(q paramq, boolean paramBoolean)
  {
    AppMethodBeat.i(306621);
    Log.i(TAG, "updateCoverInfo:" + paramq + " post:" + paramBoolean);
    if (paramq == null) {}
    for (String str = null; (str == null) || (s.p(paramq.field_userName, "")); str = paramq.field_userName)
    {
      AppMethodBeat.o(306621);
      return false;
    }
    boolean bool = super.replace((IAutoDBItem)paramq);
    if (bool) {
      this.QYJ.put(paramq.field_userName, paramq);
    }
    if (paramBoolean) {
      this.QYK.QZH.t(paramq);
    }
    AppMethodBeat.o(306621);
    return bool;
  }
  
  public final boolean a(String paramString, long paramLong, FinderObject paramFinderObject)
  {
    AppMethodBeat.i(306660);
    s.u(paramString, "userName");
    Log.i(TAG, s.X("updateFinderInfoFromDetail :", paramString));
    if (paramFinderObject == null) {}
    for (Object localObject = null; localObject == null; localObject = paramFinderObject.objectDesc)
    {
      AppMethodBeat.o(306660);
      return false;
    }
    paramString = aZM(paramString);
    localObject = Long.valueOf(paramString.field_snsBgId);
    if (localObject == null) {}
    while ((((Long)localObject).longValue() != paramLong) || (!paramString.field_success))
    {
      AppMethodBeat.o(306660);
      return false;
    }
    try
    {
      paramString.field_finderObject = paramFinderObject.toByteArray();
      paramString.field_finderCheckTime = System.currentTimeMillis();
      label118:
      boolean bool = a(paramString, false);
      AppMethodBeat.o(306660);
      return bool;
    }
    catch (Exception paramFinderObject)
    {
      break label118;
    }
  }
  
  public final boolean a(String paramString, ffs paramffs)
  {
    AppMethodBeat.i(306666);
    s.u(paramString, "userName");
    if (paramffs == null)
    {
      AppMethodBeat.o(306666);
      return false;
    }
    this.QYK.vp(paramffs.pSs);
    AppMethodBeat.o(306666);
    return false;
  }
  
  public final q aZM(String paramString)
  {
    AppMethodBeat.i(306614);
    s.u(paramString, "userName");
    if (this.QYJ.get(paramString) != null)
    {
      paramString = this.QYJ.ct(paramString);
      s.s(paramString, "coverLRUMap.getAndUptime(userName)");
      paramString = (q)paramString;
      AppMethodBeat.o(306614);
      return paramString;
    }
    Object localObject1 = "select *, rowid from SnsCover where userName=\"" + Util.escapeSqlValue(paramString) + '"';
    localObject1 = this.db.rawQuery((String)localObject1, null, 2);
    q localq = new q();
    if (((Cursor)localObject1).moveToFirst())
    {
      localq.convertFrom((Cursor)localObject1);
      this.QYJ.put(paramString, localq);
      ((Cursor)localObject1).close();
      AppMethodBeat.o(306614);
      return localq;
    }
    if (au.bwO(paramString))
    {
      localObject2 = al.hgF().aZW(paramString);
      if ((((PluginOpenIM)com.tencent.mm.kernel.h.az(PluginOpenIM.class)).getSnsFlagStg().RV(paramString) & 0x2) == 0L) {
        Log.e(TAG, "openIM bg flag false, do not show bg");
      }
      for (localq.field_type = 5;; localq.field_type = 6)
      {
        localq.field_userName = paramString;
        localq.field_isLike = ((u)localObject2).hkQ();
        localq.field_snsBgId = ((u)localObject2).field_snsBgId;
        localq.QYH = ((u)localObject2).field_bgId;
        break;
      }
    }
    Object localObject2 = a.aZO(paramString);
    u localu = al.hgF().aZW(paramString);
    localq.field_userName = paramString;
    localq.field_snsBgId = localu.field_snsBgId;
    if (localu.field_snsBgId == 0L) {}
    for (int i = 0;; i = 1)
    {
      localq.field_type = i;
      localq.field_success = false;
      localq.field_thumbUrl = localu.field_bgUrl;
      localq.field_isLike = localu.hkQ();
      localq.QYG = "data from extra db,maybe not friend";
      if (y.ZC((String)localObject2)) {
        localq.field_localThumb = ((String)localObject2);
      }
      Log.i(TAG, s.X("snscover not value,load from ext info:", Long.valueOf(localu.field_snsBgId)));
      this.QYK.vp(localu.field_snsBgId);
      break;
    }
  }
  
  public final void aZN(String paramString)
  {
    AppMethodBeat.i(306645);
    s.u(paramString, "userName");
    Log.i(TAG, s.X("blockCover:", paramString));
    paramString = al.hgG().aZM(paramString);
    s.checkNotNull(paramString);
    paramString.field_type = 5;
    b localb = b.Qmn;
    b.b(paramString);
    a(paramString, true);
    AppMethodBeat.o(306645);
  }
  
  public final boolean bb(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(306627);
    s.u(paramString1, "userName");
    s.u(paramString2, "thumb");
    s.u(paramString3, "cover");
    Log.i(TAG, s.X("updateCoverImageInfoLocal :", paramString1));
    q localq = aZM(paramString1);
    s.checkNotNull(localq);
    localq.field_userName = paramString1;
    localq.field_type = 1;
    c(localq);
    if (!s.p(paramString2, localq.field_localThumb))
    {
      com.tencent.threadpool.h.ahAA.bo((Runnable)new r.b(new String[] { localq.field_localThumb }));
      localq.field_localThumb = paramString2;
    }
    if (!s.p(paramString3, localq.field_localImage))
    {
      com.tencent.threadpool.h.ahAA.bo((Runnable)new r.b(new String[] { localq.field_localImage }));
      localq.field_localImage = paramString3;
    }
    boolean bool = a(localq, false);
    AppMethodBeat.o(306627);
    return bool;
  }
  
  public final boolean c(String paramString, FinderObject paramFinderObject)
  {
    AppMethodBeat.i(306638);
    s.u(paramString, "userName");
    Log.i(TAG, s.X("updateCoverFinderInfo :", paramString));
    if (paramFinderObject.objectDesc == null)
    {
      AppMethodBeat.o(306638);
      return false;
    }
    q localq = aZM(paramString);
    c(localq);
    com.tencent.threadpool.h.ahAA.bo((Runnable)new r.b(new String[] { localq.field_localVideo, localq.field_localThumb, localq.field_localImage }));
    localq.field_localVideo = "";
    localq.field_localThumb = "";
    localq.field_localImage = "";
    paramString = paramFinderObject.objectDesc;
    if (paramString == null)
    {
      paramString = null;
      if (paramString != null) {
        break label242;
      }
      label136:
      if (paramString != null) {
        break label259;
      }
      label140:
      localq.field_type = 0;
    }
    for (;;)
    {
      label259:
      try
      {
        localq.field_success = false;
        localq.field_finderCheckTime = System.currentTimeMillis();
        localq.field_finderObject = paramFinderObject.toByteArray();
        paramString = paramFinderObject.objectDesc;
        if (paramString != null)
        {
          paramString = paramString.media;
          if (paramString != null)
          {
            paramString = (FinderMedia)paramString.getFirst();
            if (paramString != null) {
              localq.field_thumbUrl = s.X(paramString.thumbUrl, paramString.thumb_url_token);
            }
          }
        }
      }
      catch (IOException paramString)
      {
        boolean bool;
        label242:
        continue;
      }
      bool = a(localq, false);
      AppMethodBeat.o(306638);
      return bool;
      paramString = Integer.valueOf(paramString.mediaType);
      break;
      if (paramString.intValue() != 2) {
        break label136;
      }
      localq.field_type = 4;
      continue;
      if (paramString.intValue() != 4) {
        break label140;
      }
      localq.field_type = 3;
    }
  }
  
  public final void d(q paramq)
  {
    AppMethodBeat.i(306675);
    paramq.field_imageBgUrl = "";
    paramq.field_thumbUrl = "";
    paramq.field_videoBgUrl = "";
    com.tencent.threadpool.h.ahAA.bo((Runnable)new r.b(new String[] { paramq.field_localThumb, paramq.field_localImage, paramq.field_localVideo }));
    paramq.field_localVideo = "";
    paramq.field_localImage = "";
    paramq.field_localThumb = "";
    a(paramq, false);
    AppMethodBeat.o(306675);
  }
  
  public final boolean h(String paramString1, long paramLong, String paramString2)
  {
    AppMethodBeat.i(306654);
    s.u(paramString1, "userName");
    s.u(paramString2, "path");
    q localq = aZM(paramString1);
    if ((localq.field_type == 1) || (localq.field_type == 6) || (localq.field_type == 0))
    {
      bool = i(paramString1, paramLong, paramString2);
      AppMethodBeat.o(306654);
      return bool;
    }
    boolean bool = j(paramString1, paramLong, paramString2);
    AppMethodBeat.o(306654);
    return bool;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/sns/storage/SnsCoverStorage$Companion;", "", "()V", "SQL_CREATE", "", "", "kotlin.jvm.PlatformType", "getSQL_CREATE", "()[Ljava/lang/String;", "[Ljava/lang/String;", "TABLE", "getTABLE", "()Ljava/lang/String;", "TAG", "getTAG", "getUserCoverPath", "username", "plugin-sns_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
  {
    public static String aZO(String paramString)
    {
      AppMethodBeat.i(306610);
      s.u(paramString, "username");
      String str = as.mg(al.getAccSnsPath(), paramString);
      paramString = str + paramString + "bg_";
      AppMethodBeat.o(306610);
      return paramString;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.r
 * JD-Core Version:    0.7.0.1
 */