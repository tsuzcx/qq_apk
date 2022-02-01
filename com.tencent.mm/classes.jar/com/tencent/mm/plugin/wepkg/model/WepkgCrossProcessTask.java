package com.tencent.mm.plugin.wepkg.model;

import android.database.Cursor;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.game.commlib.a;
import com.tencent.mm.plugin.wepkg.b.c;
import com.tencent.mm.plugin.wepkg.b.e;
import com.tencent.mm.plugin.wepkg.b.f;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class WepkgCrossProcessTask
  extends BaseWepkgProcessTask
{
  public static final Parcelable.Creator<WepkgCrossProcessTask> CREATOR;
  public WepkgVersion XFY;
  public List<WepkgVersion> XFZ;
  public WePkgDiffInfo XGa;
  public WepkgPreloadFile XGb;
  public List<WepkgPreloadFile> XGc;
  public String XGd;
  public int bUl;
  public Runnable rxj;
  
  static
  {
    AppMethodBeat.i(110695);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(110695);
  }
  
  public WepkgCrossProcessTask()
  {
    AppMethodBeat.i(110689);
    this.bUl = -1;
    this.XFY = new WepkgVersion();
    this.XFZ = new ArrayList();
    this.XGa = new WePkgDiffInfo();
    this.XGb = new WepkgPreloadFile();
    this.XGc = new ArrayList();
    AppMethodBeat.o(110689);
  }
  
  private WepkgCrossProcessTask(Parcel paramParcel)
  {
    AppMethodBeat.i(110690);
    h(paramParcel);
    AppMethodBeat.o(110690);
  }
  
  public final void a(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(110694);
    paramParcel.writeInt(this.bUl);
    paramParcel.writeParcelable(this.XFY, paramInt);
    if (this.XFZ == null) {
      this.XFZ = new ArrayList();
    }
    paramParcel.writeList(this.XFZ);
    paramParcel.writeParcelable(this.XGb, paramInt);
    if (this.XGc == null) {
      this.XGc = new ArrayList();
    }
    paramParcel.writeList(this.XGc);
    paramParcel.writeString(this.XGd);
    AppMethodBeat.o(110694);
  }
  
  public final void asn()
  {
    Object localObject2 = null;
    Object localObject1 = null;
    boolean bool2 = false;
    boolean bool3 = true;
    boolean bool4 = true;
    boolean bool5 = true;
    boolean bool1 = true;
    AppMethodBeat.i(110691);
    Object localObject3;
    Object localObject4;
    switch (this.bUl)
    {
    default: 
    case 1001: 
    case 1002: 
    case 3001: 
    case 3003: 
    case 3004: 
    case 3005: 
    case 3006: 
    case 2002: 
    case 4001: 
    case 4002: 
    case 2003: 
      label1099:
      do
      {
        do
        {
          for (;;)
          {
            cpA();
            AppMethodBeat.o(110691);
            return;
            this.result = true;
            continue;
            this.result = a.fDT();
            continue;
            if (this.XFY != null)
            {
              localObject1 = f.iFe().boa(this.XFY.mtT);
              if (localObject1 != null)
              {
                this.XFY.a((e)localObject1);
                this.result = true;
              }
              else
              {
                this.XFY = null;
                continue;
                if (this.XFY != null)
                {
                  this.result = f.iFe().boc(this.XFY.mtT);
                  continue;
                  if (this.XFY != null)
                  {
                    this.result = f.iFe().a(this.XFY.mtT, this.XFY.XGG, this.XFY.XGH, this.XFY.XGI);
                    continue;
                    if (this.XFY != null)
                    {
                      this.result = f.iFe().K(this.XFY.mtT, this.XFY.pkgPath, this.XFY.XGM);
                      continue;
                      if (this.XFY != null)
                      {
                        this.result = f.iFe().dT(this.XFY.mtT, this.XFY.XGN);
                        continue;
                        if ((this.XFY != null) && (!Util.isNullOrNil(this.XFY.mtT)))
                        {
                          localObject1 = f.iFe();
                          localObject2 = this.XFY;
                          localObject3 = new e();
                          ((e)localObject3).field_pkgId = ((WepkgVersion)localObject2).mtT;
                          ((e)localObject3).field_appId = ((WepkgVersion)localObject2).appId;
                          ((e)localObject3).field_version = ((WepkgVersion)localObject2).version;
                          ((e)localObject3).field_pkgPath = ((WepkgVersion)localObject2).pkgPath;
                          ((e)localObject3).field_disableWvCache = ((WepkgVersion)localObject2).XGG;
                          ((e)localObject3).field_clearPkgTime = ((WepkgVersion)localObject2).XGH;
                          ((e)localObject3).field_checkIntervalTime = ((WepkgVersion)localObject2).XGI;
                          ((e)localObject3).field_packMethod = ((WepkgVersion)localObject2).XGJ;
                          ((e)localObject3).field_domain = ((WepkgVersion)localObject2).domain;
                          ((e)localObject3).field_md5 = ((WepkgVersion)localObject2).md5;
                          ((e)localObject3).field_downloadUrl = ((WepkgVersion)localObject2).downloadUrl;
                          ((e)localObject3).field_pkgSize = ((WepkgVersion)localObject2).XGK;
                          ((e)localObject3).field_downloadNetType = ((WepkgVersion)localObject2).XFQ;
                          ((e)localObject3).field_nextCheckTime = ((WepkgVersion)localObject2).XGL;
                          ((e)localObject3).field_createTime = ((WepkgVersion)localObject2).createTime;
                          ((e)localObject3).field_charset = ((WepkgVersion)localObject2).charset;
                          ((e)localObject3).field_bigPackageReady = ((WepkgVersion)localObject2).XGM;
                          ((e)localObject3).field_preloadFilesReady = ((WepkgVersion)localObject2).XGN;
                          ((e)localObject3).field_preloadFilesAtomic = ((WepkgVersion)localObject2).XGO;
                          ((e)localObject3).field_totalDownloadCount = ((WepkgVersion)localObject2).XGP;
                          ((e)localObject3).field_downloadTriggerType = ((WepkgVersion)localObject2).iiM;
                          ((f)localObject1).a((e)localObject3, this.XGa);
                          if (!Util.isNullOrNil(this.XGc))
                          {
                            localObject1 = this.XGc.iterator();
                            while (((Iterator)localObject1).hasNext())
                            {
                              localObject2 = (WepkgPreloadFile)((Iterator)localObject1).next();
                              if (localObject2 != null)
                              {
                                localObject3 = com.tencent.mm.plugin.wepkg.b.d.iFd();
                                localObject4 = new c();
                                ((c)localObject4).field_key = ((WepkgPreloadFile)localObject2).key;
                                ((c)localObject4).field_pkgId = ((WepkgPreloadFile)localObject2).mtT;
                                ((c)localObject4).field_version = ((WepkgPreloadFile)localObject2).version;
                                ((c)localObject4).field_filePath = ((WepkgPreloadFile)localObject2).filePath;
                                ((c)localObject4).field_rid = ((WepkgPreloadFile)localObject2).XGe;
                                ((c)localObject4).field_mimeType = ((WepkgPreloadFile)localObject2).mimeType;
                                ((c)localObject4).field_md5 = ((WepkgPreloadFile)localObject2).md5;
                                ((c)localObject4).field_downloadUrl = ((WepkgPreloadFile)localObject2).downloadUrl;
                                ((c)localObject4).field_size = ((WepkgPreloadFile)localObject2).size;
                                ((c)localObject4).field_downloadNetType = ((WepkgPreloadFile)localObject2).XFQ;
                                ((c)localObject4).field_completeDownload = ((WepkgPreloadFile)localObject2).XGr;
                                ((c)localObject4).field_createTime = ((WepkgPreloadFile)localObject2).createTime;
                                if (((com.tencent.mm.plugin.wepkg.b.d)localObject3).rqI) {
                                  if (((com.tencent.mm.plugin.wepkg.b.d)localObject3).oH(((c)localObject4).field_pkgId, ((c)localObject4).field_rid) == null)
                                  {
                                    ((c)localObject4).field_createTime = com.tencent.mm.plugin.wepkg.utils.d.currentTime();
                                    bool1 = ((com.tencent.mm.plugin.wepkg.b.d)localObject3).insert((IAutoDBItem)localObject4);
                                    Log.i("MicroMsg.Wepkg.WepkgPreloadFilesStorage", "insertPreloadFile pkgid:%s, version:%s, rid:%s, ret:%s", new Object[] { ((c)localObject4).field_pkgId, ((c)localObject4).field_version, ((c)localObject4).field_rid, Boolean.valueOf(bool1) });
                                  }
                                  else
                                  {
                                    bool1 = ((com.tencent.mm.plugin.wepkg.b.d)localObject3).replace((IAutoDBItem)localObject4);
                                    Log.i("MicroMsg.Wepkg.WepkgPreloadFilesStorage", "relacePreloadFile pkgid:%s, version:%s, rid:%s, ret:%s", new Object[] { ((c)localObject4).field_pkgId, ((c)localObject4).field_version, ((c)localObject4).field_rid, Boolean.valueOf(bool1) });
                                  }
                                }
                              }
                            }
                          }
                          this.result = true;
                        }
                      }
                    }
                  }
                }
              }
            }
          }
        } while ((this.XFY == null) || (Util.isNullOrNil(this.XFY.mtT)));
        for (;;)
        {
          try
          {
            localObject2 = com.tencent.mm.plugin.wepkg.b.d.iFd();
            localObject4 = this.XFY.mtT;
            if ((((com.tencent.mm.plugin.wepkg.b.d)localObject2).rqI) || (!Util.isNullOrNil((String)localObject4))) {
              continue;
            }
            this.XGc = ((List)localObject1);
          }
          catch (Exception localException)
          {
            int i;
            continue;
          }
          this.result = bool1;
          break;
          localObject3 = String.format("select * from %s where %s=? and %s=0", new Object[] { "WepkgPreloadFiles", "pkgId", "completeDownload" });
          localObject2 = ((com.tencent.mm.plugin.wepkg.b.d)localObject2).rawQuery((String)localObject3, new String[] { localObject4 });
          Log.i("MicroMsg.Wepkg.WepkgPreloadFilesStorage", "getNeedDownloadPreLoadFileList queryStr:%s", new Object[] { localObject3 });
          if (localObject2 == null)
          {
            Log.i("MicroMsg.Wepkg.WepkgPreloadFilesStorage", "cursor is null");
          }
          else if (((Cursor)localObject2).moveToFirst())
          {
            localObject1 = new ArrayList();
            localObject3 = new WepkgPreloadFile();
            localObject4 = new c();
            ((c)localObject4).convertFrom((Cursor)localObject2);
            ((WepkgPreloadFile)localObject3).a((c)localObject4);
            ((List)localObject1).add(localObject3);
            if (!((Cursor)localObject2).moveToNext())
            {
              ((Cursor)localObject2).close();
              Log.i("MicroMsg.Wepkg.WepkgPreloadFilesStorage", "record list size:%s", new Object[] { Integer.valueOf(((List)localObject1).size()) });
            }
          }
          else
          {
            ((Cursor)localObject2).close();
            Log.i("MicroMsg.Wepkg.WepkgPreloadFilesStorage", "no record");
            continue;
            if (this.XGb == null) {
              break;
            }
            bool1 = com.tencent.mm.plugin.wepkg.b.d.iFd().k(this.XGb.mtT, this.XGb.XGe, this.XGb.filePath, this.XGb.XGr);
          }
        }
      } while (this.XFY == null);
      localObject1 = f.iFe();
      if (!((f)localObject1).rqI) {
        localObject1 = null;
      }
      label1409:
      for (;;)
      {
        label1384:
        if (Util.isNullOrNil((String)localObject1))
        {
          localObject3 = com.tencent.mm.plugin.wepkg.b.d.iFd();
          if (!((com.tencent.mm.plugin.wepkg.b.d)localObject3).rqI)
          {
            localObject1 = localObject2;
            if (Util.isNullOrNil((String)localObject1))
            {
              localObject2 = f.iFe();
              if (((f)localObject2).rqI)
              {
                Log.i("MicroMsg.Wepkg.WepkgVersionStorage", "WepkgVersionRecord resetAutoDownloadCount ret:%s", new Object[] { Boolean.valueOf(((f)localObject2).execSQL("WepkgVersion", String.format("update %s set %s=0", new Object[] { "WepkgVersion", "autoDownloadCount" }))) });
                Log.i("MicroMsg.Wepkg.WepkgVersionStorage", "WepkgPreloadFilesRecord resetAutoDownloadCount ret:%s", new Object[] { Boolean.valueOf(((f)localObject2).execSQL("WepkgPreloadFiles", String.format("update %s set %s=0", new Object[] { "WepkgPreloadFiles", "autoDownloadCount" }))) });
              }
            }
            this.XFY.mtT = ((String)localObject1);
            break;
            localObject3 = ((f)localObject1).rawQuery(String.format("select * from %s where %s=0 and %s=1 and %s<1 and %s<?", new Object[] { "WepkgVersion", "bigPackageReady", "preloadFilesAtomic", "autoDownloadCount", "packageDownloadCount" }), new String[] { "3" });
            if (localObject3 == null)
            {
              localObject1 = null;
              continue;
            }
            if (((Cursor)localObject3).moveToFirst())
            {
              i = ((Cursor)localObject3).getCount();
              if (i <= 1) {
                break label3046;
              }
            }
          }
        }
      }
    }
    label2476:
    label3033:
    label3041:
    label3046:
    for (i = Util.getIntRandom(i - 1, 0);; i = 0)
    {
      ((Cursor)localObject3).move(i);
      localObject4 = new e();
      ((e)localObject4).convertFrom((Cursor)localObject3);
      ((Cursor)localObject3).close();
      ((f)localObject1).bod(((e)localObject4).field_pkgId);
      Log.i("MicroMsg.Wepkg.WepkgVersionStorage", "randomNeedDownloadPkgid exist record in DB, pkgid:%s, version:%s, bigPackageReady:false, preloadFilesAtomic:true", new Object[] { ((e)localObject4).field_pkgId, ((e)localObject4).field_version });
      localObject1 = ((e)localObject4).field_pkgId;
      break label1384;
      ((Cursor)localObject3).close();
      localObject3 = ((f)localObject1).rawQuery(String.format("select * from %s where %s=0 and %s<1 and %s<?", new Object[] { "WepkgVersion", "bigPackageReady", "autoDownloadCount", "packageDownloadCount" }), new String[] { "3" });
      if (localObject3 == null)
      {
        localObject1 = null;
        break label1384;
      }
      if (((Cursor)localObject3).moveToFirst())
      {
        i = ((Cursor)localObject3).getCount();
        if (i <= 1) {
          break label3041;
        }
      }
      for (i = Util.getIntRandom(i - 1, 0);; i = 0)
      {
        ((Cursor)localObject3).move(i);
        localObject4 = new e();
        ((e)localObject4).convertFrom((Cursor)localObject3);
        ((Cursor)localObject3).close();
        ((f)localObject1).bod(((e)localObject4).field_pkgId);
        Log.i("MicroMsg.Wepkg.WepkgVersionStorage", "randomNeedDownloadPkgid exist record in DB, pkgid:%s, version:%s, bigPackageReady:false, preloadFilesAtomic:false", new Object[] { ((e)localObject4).field_pkgId, ((e)localObject4).field_version });
        localObject1 = ((e)localObject4).field_pkgId;
        break label1384;
        ((Cursor)localObject3).close();
        Log.i("MicroMsg.Wepkg.WepkgVersionStorage", "randomNeedDownloadPkgid no download record in DB");
        localObject1 = null;
        break label1384;
        localObject4 = ((com.tencent.mm.plugin.wepkg.b.d)localObject3).rawQuery(String.format("select * from %s where %s=0 and %s<1 and %s<?", new Object[] { "WepkgPreloadFiles", "completeDownload", "autoDownloadCount", "fileDownloadCount" }), new String[] { "3" });
        localObject1 = localObject2;
        if (localObject4 == null) {
          break label1409;
        }
        if (((Cursor)localObject4).moveToFirst())
        {
          i = ((Cursor)localObject4).getCount();
          if (i <= 1) {
            break label3033;
          }
        }
        for (i = Util.getIntRandom(i - 1, 0);; i = 0)
        {
          ((Cursor)localObject4).move(i);
          localObject1 = new c();
          ((c)localObject1).convertFrom((Cursor)localObject4);
          ((Cursor)localObject4).close();
          localObject2 = ((c)localObject1).field_pkgId;
          localObject4 = ((c)localObject1).field_rid;
          if ((!((com.tencent.mm.plugin.wepkg.b.d)localObject3).rqI) || (Util.isNullOrNil((String)localObject2)) || (Util.isNullOrNil((String)localObject4))) {}
          for (;;)
          {
            Log.i("MicroMsg.Wepkg.WepkgPreloadFilesStorage", "randomNeedDownloadPkgid exist record in DB, pkgid:%s, version:%s, rid:%s", new Object[] { ((c)localObject1).field_pkgId, ((c)localObject1).field_version, ((c)localObject1).field_rid });
            localObject1 = ((c)localObject1).field_pkgId;
            break;
            Log.i("MicroMsg.Wepkg.WepkgPreloadFilesStorage", "WepkgPreloadFilesRecord addAutoDownloadCount ret:%s", new Object[] { Boolean.valueOf(((com.tencent.mm.plugin.wepkg.b.d)localObject3).execSQL("WepkgPreloadFiles", String.format("update %s set %s=%s+1 where %s='%s' and %s='%s'", new Object[] { "WepkgPreloadFiles", "autoDownloadCount", "autoDownloadCount", "pkgId", localObject2, "rid", localObject4 }))) });
          }
          ((Cursor)localObject4).close();
          Log.i("MicroMsg.Wepkg.WepkgPreloadFilesStorage", "randomNeedDownloadPkgid no download record in DB");
          localObject1 = localObject2;
          break label1409;
          if (this.XFY == null) {
            break;
          }
          this.XGc = com.tencent.mm.plugin.wepkg.b.d.iFd().bnY(this.XFY.mtT);
          break label1099;
          if (this.XGb == null) {
            break;
          }
          localObject1 = com.tencent.mm.plugin.wepkg.b.d.iFd().oH(this.XGb.mtT, this.XGb.XGe);
          if (localObject1 != null)
          {
            this.XGb.a((c)localObject1);
            break label1099;
          }
          this.XGb = null;
          break;
          if (this.XFY == null) {
            break;
          }
          bool1 = f.iFe().boe(this.XFY.mtT);
          break label1099;
          if (this.XFY == null) {
            break;
          }
          localObject1 = f.iFe().bob(this.XFY.mtT);
          if (localObject1 != null)
          {
            this.XFY.a((e)localObject1);
            break label1099;
          }
          this.XFY = null;
          break;
          this.XFZ = f.iFe().iFg();
          break label1099;
          if (this.XFY == null) {
            break;
          }
          bool1 = f.iFe().bof(this.XFY.mtT);
          break label1099;
          if (this.XFY == null) {
            break;
          }
          localObject1 = f.iFe();
          localObject2 = this.XFY.mtT;
          bool1 = bool2;
          if (((f)localObject1).rqI) {
            if (!Util.isNullOrNil((String)localObject2)) {
              break label2476;
            }
          }
          for (bool1 = bool2;; bool1 = true)
          {
            this.result = bool1;
            break;
            Log.i("MicroMsg.Wepkg.WepkgVersionStorage", "WepkgVersionRecord addTotalDownloadCount ret:%s", new Object[] { Boolean.valueOf(((f)localObject1).execSQL("WepkgVersion", String.format("update %s set %s=%s+1 where %s='%s'", new Object[] { "WepkgVersion", "totalDownloadCount", "totalDownloadCount", "pkgId", localObject2 }))) });
          }
          if (this.XFY == null) {
            break;
          }
          localObject1 = f.iFe();
          localObject2 = this.XFY.mtT;
          if ((!((f)localObject1).rqI) || (Util.isNullOrNil((String)localObject2))) {}
          for (bool1 = false;; bool1 = bool3)
          {
            this.result = bool1;
            break;
            Log.i("MicroMsg.Wepkg.WepkgVersionStorage", "WepkgVersionRecord addPackageDownloadCount ret:%s", new Object[] { Boolean.valueOf(((f)localObject1).execSQL("WepkgVersion", String.format("update %s set %s=%s+1 where %s='%s'", new Object[] { "WepkgVersion", "packageDownloadCount", "packageDownloadCount", "pkgId", localObject2 }))) });
          }
          if (this.XFY == null) {
            break;
          }
          localObject1 = f.iFe();
          localObject2 = this.XFY.mtT;
          if ((!((f)localObject1).rqI) || (Util.isNullOrNil((String)localObject2))) {}
          for (bool1 = false;; bool1 = bool4)
          {
            this.result = bool1;
            break;
            Log.i("MicroMsg.Wepkg.WepkgVersionStorage", "WepkgVersionRecord resetPackageDownloadCount ret:%s", new Object[] { Boolean.valueOf(((f)localObject1).execSQL("WepkgVersion", String.format("update %s set %s=0 where %s='%s'", new Object[] { "WepkgVersion", "packageDownloadCount", "pkgId", localObject2 }))) });
          }
          if (this.XGb == null) {
            break;
          }
          localObject1 = com.tencent.mm.plugin.wepkg.b.d.iFd();
          localObject2 = this.XGb.mtT;
          localObject3 = this.XGb.XGe;
          if ((!((com.tencent.mm.plugin.wepkg.b.d)localObject1).rqI) || (Util.isNullOrNil((String)localObject2)) || (Util.isNullOrNil((String)localObject3))) {}
          for (bool1 = false;; bool1 = bool5)
          {
            this.result = bool1;
            break;
            Log.i("MicroMsg.Wepkg.WepkgPreloadFilesStorage", "WepkgPreloadFilesRecord addFileDownloadCount ret:%s", new Object[] { Boolean.valueOf(((com.tencent.mm.plugin.wepkg.b.d)localObject1).execSQL("WepkgPreloadFiles", String.format("update %s set %s=%s+1 where %s='%s' and %s='%s'", new Object[] { "WepkgPreloadFiles", "fileDownloadCount", "fileDownloadCount", "pkgId", localObject2, "rid", localObject3 }))) });
          }
          if (this.XGb == null) {
            break;
          }
          localObject1 = com.tencent.mm.plugin.wepkg.b.d.iFd();
          localObject2 = this.XGb.mtT;
          if ((!((com.tencent.mm.plugin.wepkg.b.d)localObject1).rqI) || (Util.isNullOrNil((String)localObject2)))
          {
            bool1 = false;
            break label1099;
          }
          Log.i("MicroMsg.Wepkg.WepkgPreloadFilesStorage", "WepkgPreloadFilesRecord resetFileDownloadCount ret:%s", new Object[] { Boolean.valueOf(((com.tencent.mm.plugin.wepkg.b.d)localObject1).execSQL("WepkgPreloadFiles", String.format("update %s set %s=0 where %s='%s'", new Object[] { "WepkgPreloadFiles", "fileDownloadCount", "pkgId", localObject2 }))) });
          break label1099;
        }
        break label1409;
      }
    }
  }
  
  public final void bQr()
  {
    AppMethodBeat.i(110692);
    if (this.rxj != null) {
      this.rxj.run();
    }
    AppMethodBeat.o(110692);
  }
  
  public final void t(Parcel paramParcel)
  {
    AppMethodBeat.i(110693);
    this.bUl = paramParcel.readInt();
    this.XFY = ((WepkgVersion)paramParcel.readParcelable(WepkgVersion.class.getClassLoader()));
    if (this.XFZ == null) {
      this.XFZ = new ArrayList();
    }
    paramParcel.readList(this.XFZ, WepkgVersion.class.getClassLoader());
    this.XGb = ((WepkgPreloadFile)paramParcel.readParcelable(WepkgPreloadFile.class.getClassLoader()));
    if (this.XGc == null) {
      this.XGc = new ArrayList();
    }
    paramParcel.readList(this.XGc, WepkgPreloadFile.class.getClassLoader());
    this.XGd = paramParcel.readString();
    AppMethodBeat.o(110693);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.wepkg.model.WepkgCrossProcessTask
 * JD-Core Version:    0.7.0.1
 */