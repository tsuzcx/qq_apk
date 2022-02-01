package com.tencent.mm.plugin.wepkg.model;

import android.database.Cursor;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.n.g;
import com.tencent.mm.plugin.wepkg.b.e;
import com.tencent.mm.plugin.wepkg.b.f;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class WepkgCrossProcessTask
  extends BaseWepkgProcessTask
{
  public static final Parcelable.Creator<WepkgCrossProcessTask> CREATOR;
  public int EN;
  public WepkgVersion EXp;
  public List<WepkgVersion> EXq;
  public WePkgDiffInfo EXr;
  public WepkgPreloadFile EXs;
  public List<WepkgPreloadFile> EXt;
  public String EXu;
  public Runnable kuv;
  
  static
  {
    AppMethodBeat.i(110695);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(110695);
  }
  
  public WepkgCrossProcessTask()
  {
    AppMethodBeat.i(110689);
    this.EN = -1;
    this.EXp = new WepkgVersion();
    this.EXq = new ArrayList();
    this.EXr = new WePkgDiffInfo();
    this.EXs = new WepkgPreloadFile();
    this.EXt = new ArrayList();
    AppMethodBeat.o(110689);
  }
  
  private WepkgCrossProcessTask(Parcel paramParcel)
  {
    AppMethodBeat.i(110690);
    e(paramParcel);
    AppMethodBeat.o(110690);
  }
  
  public final void a(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(110694);
    paramParcel.writeInt(this.EN);
    paramParcel.writeParcelable(this.EXp, paramInt);
    if (this.EXq == null) {
      this.EXq = new ArrayList();
    }
    paramParcel.writeList(this.EXq);
    paramParcel.writeParcelable(this.EXs, paramInt);
    if (this.EXt == null) {
      this.EXt = new ArrayList();
    }
    paramParcel.writeList(this.EXt);
    paramParcel.writeString(this.EXu);
    AppMethodBeat.o(110694);
  }
  
  public final void aOX()
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
    switch (this.EN)
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
      label1102:
      do
      {
        do
        {
          for (;;)
          {
            biG();
            AppMethodBeat.o(110691);
            return;
            this.result = true;
            continue;
            this.result = g.acM().acz();
            continue;
            if (this.EXp != null)
            {
              localObject1 = f.fbz().aLU(this.EXp.guO);
              if (localObject1 != null)
              {
                this.EXp.a((e)localObject1);
                this.result = true;
              }
              else
              {
                this.EXp = null;
                continue;
                if (this.EXp != null)
                {
                  this.result = f.fbz().aLW(this.EXp.guO);
                  continue;
                  if (this.EXp != null)
                  {
                    this.result = f.fbz().a(this.EXp.guO, this.EXp.EXX, this.EXp.EXY, this.EXp.EXZ);
                    continue;
                    if (this.EXp != null)
                    {
                      this.result = f.fbz().A(this.EXp.guO, this.EXp.pkgPath, this.EXp.EYe);
                      continue;
                      if (this.EXp != null)
                      {
                        this.result = f.fbz().cA(this.EXp.guO, this.EXp.EYf);
                        continue;
                        if ((this.EXp != null) && (!bu.isNullOrNil(this.EXp.guO)))
                        {
                          localObject1 = f.fbz();
                          localObject2 = this.EXp;
                          localObject3 = new e();
                          ((e)localObject3).field_pkgId = ((WepkgVersion)localObject2).guO;
                          ((e)localObject3).field_appId = ((WepkgVersion)localObject2).appId;
                          ((e)localObject3).field_version = ((WepkgVersion)localObject2).version;
                          ((e)localObject3).field_pkgPath = ((WepkgVersion)localObject2).pkgPath;
                          ((e)localObject3).field_disableWvCache = ((WepkgVersion)localObject2).EXX;
                          ((e)localObject3).field_clearPkgTime = ((WepkgVersion)localObject2).EXY;
                          ((e)localObject3).field_checkIntervalTime = ((WepkgVersion)localObject2).EXZ;
                          ((e)localObject3).field_packMethod = ((WepkgVersion)localObject2).EYa;
                          ((e)localObject3).field_domain = ((WepkgVersion)localObject2).EYb;
                          ((e)localObject3).field_md5 = ((WepkgVersion)localObject2).md5;
                          ((e)localObject3).field_downloadUrl = ((WepkgVersion)localObject2).downloadUrl;
                          ((e)localObject3).field_pkgSize = ((WepkgVersion)localObject2).EYc;
                          ((e)localObject3).field_downloadNetType = ((WepkgVersion)localObject2).EXh;
                          ((e)localObject3).field_nextCheckTime = ((WepkgVersion)localObject2).EYd;
                          ((e)localObject3).field_createTime = ((WepkgVersion)localObject2).createTime;
                          ((e)localObject3).field_charset = ((WepkgVersion)localObject2).charset;
                          ((e)localObject3).field_bigPackageReady = ((WepkgVersion)localObject2).EYe;
                          ((e)localObject3).field_preloadFilesReady = ((WepkgVersion)localObject2).EYf;
                          ((e)localObject3).field_preloadFilesAtomic = ((WepkgVersion)localObject2).EYg;
                          ((e)localObject3).field_totalDownloadCount = ((WepkgVersion)localObject2).EYh;
                          ((e)localObject3).field_downloadTriggerType = ((WepkgVersion)localObject2).dQg;
                          ((f)localObject1).a((e)localObject3, this.EXr);
                          if (!bu.ht(this.EXt))
                          {
                            localObject1 = this.EXt.iterator();
                            while (((Iterator)localObject1).hasNext())
                            {
                              localObject2 = (WepkgPreloadFile)((Iterator)localObject1).next();
                              if (localObject2 != null)
                              {
                                localObject3 = com.tencent.mm.plugin.wepkg.b.d.fby();
                                localObject4 = new com.tencent.mm.plugin.wepkg.b.c();
                                ((com.tencent.mm.plugin.wepkg.b.c)localObject4).field_key = ((WepkgPreloadFile)localObject2).key;
                                ((com.tencent.mm.plugin.wepkg.b.c)localObject4).field_pkgId = ((WepkgPreloadFile)localObject2).guO;
                                ((com.tencent.mm.plugin.wepkg.b.c)localObject4).field_version = ((WepkgPreloadFile)localObject2).version;
                                ((com.tencent.mm.plugin.wepkg.b.c)localObject4).field_filePath = ((WepkgPreloadFile)localObject2).filePath;
                                ((com.tencent.mm.plugin.wepkg.b.c)localObject4).field_rid = ((WepkgPreloadFile)localObject2).EXv;
                                ((com.tencent.mm.plugin.wepkg.b.c)localObject4).field_mimeType = ((WepkgPreloadFile)localObject2).mimeType;
                                ((com.tencent.mm.plugin.wepkg.b.c)localObject4).field_md5 = ((WepkgPreloadFile)localObject2).md5;
                                ((com.tencent.mm.plugin.wepkg.b.c)localObject4).field_downloadUrl = ((WepkgPreloadFile)localObject2).downloadUrl;
                                ((com.tencent.mm.plugin.wepkg.b.c)localObject4).field_size = ((WepkgPreloadFile)localObject2).size;
                                ((com.tencent.mm.plugin.wepkg.b.c)localObject4).field_downloadNetType = ((WepkgPreloadFile)localObject2).EXh;
                                ((com.tencent.mm.plugin.wepkg.b.c)localObject4).field_completeDownload = ((WepkgPreloadFile)localObject2).EXI;
                                ((com.tencent.mm.plugin.wepkg.b.c)localObject4).field_createTime = ((WepkgPreloadFile)localObject2).createTime;
                                if (((com.tencent.mm.plugin.wepkg.b.d)localObject3).kot) {
                                  if (((com.tencent.mm.plugin.wepkg.b.d)localObject3).lq(((com.tencent.mm.plugin.wepkg.b.c)localObject4).field_pkgId, ((com.tencent.mm.plugin.wepkg.b.c)localObject4).field_rid) == null)
                                  {
                                    ((com.tencent.mm.plugin.wepkg.b.c)localObject4).field_createTime = com.tencent.mm.plugin.wepkg.utils.d.currentTime();
                                    bool1 = ((com.tencent.mm.plugin.wepkg.b.d)localObject3).insert((com.tencent.mm.sdk.e.c)localObject4);
                                    ae.i("MicroMsg.Wepkg.WepkgPreloadFilesStorage", "insertPreloadFile pkgid:%s, version:%s, rid:%s, ret:%s", new Object[] { ((com.tencent.mm.plugin.wepkg.b.c)localObject4).field_pkgId, ((com.tencent.mm.plugin.wepkg.b.c)localObject4).field_version, ((com.tencent.mm.plugin.wepkg.b.c)localObject4).field_rid, Boolean.valueOf(bool1) });
                                  }
                                  else
                                  {
                                    bool1 = ((com.tencent.mm.plugin.wepkg.b.d)localObject3).replace((com.tencent.mm.sdk.e.c)localObject4);
                                    ae.i("MicroMsg.Wepkg.WepkgPreloadFilesStorage", "relacePreloadFile pkgid:%s, version:%s, rid:%s, ret:%s", new Object[] { ((com.tencent.mm.plugin.wepkg.b.c)localObject4).field_pkgId, ((com.tencent.mm.plugin.wepkg.b.c)localObject4).field_version, ((com.tencent.mm.plugin.wepkg.b.c)localObject4).field_rid, Boolean.valueOf(bool1) });
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
        } while ((this.EXp == null) || (bu.isNullOrNil(this.EXp.guO)));
        for (;;)
        {
          try
          {
            localObject2 = com.tencent.mm.plugin.wepkg.b.d.fby();
            localObject4 = this.EXp.guO;
            if ((((com.tencent.mm.plugin.wepkg.b.d)localObject2).kot) || (!bu.isNullOrNil((String)localObject4))) {
              continue;
            }
            this.EXt = ((List)localObject1);
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
          ae.i("MicroMsg.Wepkg.WepkgPreloadFilesStorage", "getNeedDownloadPreLoadFileList queryStr:%s", new Object[] { localObject3 });
          if (localObject2 == null)
          {
            ae.i("MicroMsg.Wepkg.WepkgPreloadFilesStorage", "cursor is null");
          }
          else if (((Cursor)localObject2).moveToFirst())
          {
            localObject1 = new ArrayList();
            localObject3 = new WepkgPreloadFile();
            localObject4 = new com.tencent.mm.plugin.wepkg.b.c();
            ((com.tencent.mm.plugin.wepkg.b.c)localObject4).convertFrom((Cursor)localObject2);
            ((WepkgPreloadFile)localObject3).a((com.tencent.mm.plugin.wepkg.b.c)localObject4);
            ((List)localObject1).add(localObject3);
            if (!((Cursor)localObject2).moveToNext())
            {
              ((Cursor)localObject2).close();
              ae.i("MicroMsg.Wepkg.WepkgPreloadFilesStorage", "record list size:%s", new Object[] { Integer.valueOf(((List)localObject1).size()) });
            }
          }
          else
          {
            ((Cursor)localObject2).close();
            ae.i("MicroMsg.Wepkg.WepkgPreloadFilesStorage", "no record");
            continue;
            if (this.EXs == null) {
              break;
            }
            bool1 = com.tencent.mm.plugin.wepkg.b.d.fby().f(this.EXs.guO, this.EXs.EXv, this.EXs.filePath, this.EXs.EXI);
          }
        }
      } while (this.EXp == null);
      localObject1 = f.fbz();
      if (!((f)localObject1).kot) {
        localObject1 = null;
      }
      label1412:
      for (;;)
      {
        label1387:
        if (bu.isNullOrNil((String)localObject1))
        {
          localObject3 = com.tencent.mm.plugin.wepkg.b.d.fby();
          if (!((com.tencent.mm.plugin.wepkg.b.d)localObject3).kot)
          {
            localObject1 = localObject2;
            if (bu.isNullOrNil((String)localObject1))
            {
              localObject2 = f.fbz();
              if (((f)localObject2).kot)
              {
                ae.i("MicroMsg.Wepkg.WepkgVersionStorage", "WepkgVersionRecord resetAutoDownloadCount ret:%s", new Object[] { Boolean.valueOf(((f)localObject2).execSQL("WepkgVersion", String.format("update %s set %s=0", new Object[] { "WepkgVersion", "autoDownloadCount" }))) });
                ae.i("MicroMsg.Wepkg.WepkgVersionStorage", "WepkgPreloadFilesRecord resetAutoDownloadCount ret:%s", new Object[] { Boolean.valueOf(((f)localObject2).execSQL("WepkgPreloadFiles", String.format("update %s set %s=0", new Object[] { "WepkgPreloadFiles", "autoDownloadCount" }))) });
              }
            }
            this.EXp.guO = ((String)localObject1);
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
                break label3049;
              }
            }
          }
        }
      }
    }
    label2479:
    label3036:
    label3044:
    label3049:
    for (i = bu.jA(i - 1, 0);; i = 0)
    {
      ((Cursor)localObject3).move(i);
      localObject4 = new e();
      ((e)localObject4).convertFrom((Cursor)localObject3);
      ((Cursor)localObject3).close();
      ((f)localObject1).aLX(((e)localObject4).field_pkgId);
      ae.i("MicroMsg.Wepkg.WepkgVersionStorage", "randomNeedDownloadPkgid exist record in DB, pkgid:%s, version:%s, bigPackageReady:false, preloadFilesAtomic:true", new Object[] { ((e)localObject4).field_pkgId, ((e)localObject4).field_version });
      localObject1 = ((e)localObject4).field_pkgId;
      break label1387;
      ((Cursor)localObject3).close();
      localObject3 = ((f)localObject1).rawQuery(String.format("select * from %s where %s=0 and %s<1 and %s<?", new Object[] { "WepkgVersion", "bigPackageReady", "autoDownloadCount", "packageDownloadCount" }), new String[] { "3" });
      if (localObject3 == null)
      {
        localObject1 = null;
        break label1387;
      }
      if (((Cursor)localObject3).moveToFirst())
      {
        i = ((Cursor)localObject3).getCount();
        if (i <= 1) {
          break label3044;
        }
      }
      for (i = bu.jA(i - 1, 0);; i = 0)
      {
        ((Cursor)localObject3).move(i);
        localObject4 = new e();
        ((e)localObject4).convertFrom((Cursor)localObject3);
        ((Cursor)localObject3).close();
        ((f)localObject1).aLX(((e)localObject4).field_pkgId);
        ae.i("MicroMsg.Wepkg.WepkgVersionStorage", "randomNeedDownloadPkgid exist record in DB, pkgid:%s, version:%s, bigPackageReady:false, preloadFilesAtomic:false", new Object[] { ((e)localObject4).field_pkgId, ((e)localObject4).field_version });
        localObject1 = ((e)localObject4).field_pkgId;
        break label1387;
        ((Cursor)localObject3).close();
        ae.i("MicroMsg.Wepkg.WepkgVersionStorage", "randomNeedDownloadPkgid no download record in DB");
        localObject1 = null;
        break label1387;
        localObject4 = ((com.tencent.mm.plugin.wepkg.b.d)localObject3).rawQuery(String.format("select * from %s where %s=0 and %s<1 and %s<?", new Object[] { "WepkgPreloadFiles", "completeDownload", "autoDownloadCount", "fileDownloadCount" }), new String[] { "3" });
        localObject1 = localObject2;
        if (localObject4 == null) {
          break label1412;
        }
        if (((Cursor)localObject4).moveToFirst())
        {
          i = ((Cursor)localObject4).getCount();
          if (i <= 1) {
            break label3036;
          }
        }
        for (i = bu.jA(i - 1, 0);; i = 0)
        {
          ((Cursor)localObject4).move(i);
          localObject1 = new com.tencent.mm.plugin.wepkg.b.c();
          ((com.tencent.mm.plugin.wepkg.b.c)localObject1).convertFrom((Cursor)localObject4);
          ((Cursor)localObject4).close();
          localObject2 = ((com.tencent.mm.plugin.wepkg.b.c)localObject1).field_pkgId;
          localObject4 = ((com.tencent.mm.plugin.wepkg.b.c)localObject1).field_rid;
          if ((!((com.tencent.mm.plugin.wepkg.b.d)localObject3).kot) || (bu.isNullOrNil((String)localObject2)) || (bu.isNullOrNil((String)localObject4))) {}
          for (;;)
          {
            ae.i("MicroMsg.Wepkg.WepkgPreloadFilesStorage", "randomNeedDownloadPkgid exist record in DB, pkgid:%s, version:%s, rid:%s", new Object[] { ((com.tencent.mm.plugin.wepkg.b.c)localObject1).field_pkgId, ((com.tencent.mm.plugin.wepkg.b.c)localObject1).field_version, ((com.tencent.mm.plugin.wepkg.b.c)localObject1).field_rid });
            localObject1 = ((com.tencent.mm.plugin.wepkg.b.c)localObject1).field_pkgId;
            break;
            ae.i("MicroMsg.Wepkg.WepkgPreloadFilesStorage", "WepkgPreloadFilesRecord addAutoDownloadCount ret:%s", new Object[] { Boolean.valueOf(((com.tencent.mm.plugin.wepkg.b.d)localObject3).execSQL("WepkgPreloadFiles", String.format("update %s set %s=%s+1 where %s='%s' and %s='%s'", new Object[] { "WepkgPreloadFiles", "autoDownloadCount", "autoDownloadCount", "pkgId", localObject2, "rid", localObject4 }))) });
          }
          ((Cursor)localObject4).close();
          ae.i("MicroMsg.Wepkg.WepkgPreloadFilesStorage", "randomNeedDownloadPkgid no download record in DB");
          localObject1 = localObject2;
          break label1412;
          if (this.EXp == null) {
            break;
          }
          this.EXt = com.tencent.mm.plugin.wepkg.b.d.fby().aLS(this.EXp.guO);
          break label1102;
          if (this.EXs == null) {
            break;
          }
          localObject1 = com.tencent.mm.plugin.wepkg.b.d.fby().lq(this.EXs.guO, this.EXs.EXv);
          if (localObject1 != null)
          {
            this.EXs.a((com.tencent.mm.plugin.wepkg.b.c)localObject1);
            break label1102;
          }
          this.EXs = null;
          break;
          if (this.EXp == null) {
            break;
          }
          bool1 = f.fbz().aLY(this.EXp.guO);
          break label1102;
          if (this.EXp == null) {
            break;
          }
          localObject1 = f.fbz().aLV(this.EXp.guO);
          if (localObject1 != null)
          {
            this.EXp.a((e)localObject1);
            break label1102;
          }
          this.EXp = null;
          break;
          this.EXq = f.fbz().fbB();
          break label1102;
          if (this.EXp == null) {
            break;
          }
          bool1 = f.fbz().aLZ(this.EXp.guO);
          break label1102;
          if (this.EXp == null) {
            break;
          }
          localObject1 = f.fbz();
          localObject2 = this.EXp.guO;
          bool1 = bool2;
          if (((f)localObject1).kot) {
            if (!bu.isNullOrNil((String)localObject2)) {
              break label2479;
            }
          }
          for (bool1 = bool2;; bool1 = true)
          {
            this.result = bool1;
            break;
            ae.i("MicroMsg.Wepkg.WepkgVersionStorage", "WepkgVersionRecord addTotalDownloadCount ret:%s", new Object[] { Boolean.valueOf(((f)localObject1).execSQL("WepkgVersion", String.format("update %s set %s=%s+1 where %s='%s'", new Object[] { "WepkgVersion", "totalDownloadCount", "totalDownloadCount", "pkgId", localObject2 }))) });
          }
          if (this.EXp == null) {
            break;
          }
          localObject1 = f.fbz();
          localObject2 = this.EXp.guO;
          if ((!((f)localObject1).kot) || (bu.isNullOrNil((String)localObject2))) {}
          for (bool1 = false;; bool1 = bool3)
          {
            this.result = bool1;
            break;
            ae.i("MicroMsg.Wepkg.WepkgVersionStorage", "WepkgVersionRecord addPackageDownloadCount ret:%s", new Object[] { Boolean.valueOf(((f)localObject1).execSQL("WepkgVersion", String.format("update %s set %s=%s+1 where %s='%s'", new Object[] { "WepkgVersion", "packageDownloadCount", "packageDownloadCount", "pkgId", localObject2 }))) });
          }
          if (this.EXp == null) {
            break;
          }
          localObject1 = f.fbz();
          localObject2 = this.EXp.guO;
          if ((!((f)localObject1).kot) || (bu.isNullOrNil((String)localObject2))) {}
          for (bool1 = false;; bool1 = bool4)
          {
            this.result = bool1;
            break;
            ae.i("MicroMsg.Wepkg.WepkgVersionStorage", "WepkgVersionRecord resetPackageDownloadCount ret:%s", new Object[] { Boolean.valueOf(((f)localObject1).execSQL("WepkgVersion", String.format("update %s set %s=0 where %s='%s'", new Object[] { "WepkgVersion", "packageDownloadCount", "pkgId", localObject2 }))) });
          }
          if (this.EXs == null) {
            break;
          }
          localObject1 = com.tencent.mm.plugin.wepkg.b.d.fby();
          localObject2 = this.EXs.guO;
          localObject3 = this.EXs.EXv;
          if ((!((com.tencent.mm.plugin.wepkg.b.d)localObject1).kot) || (bu.isNullOrNil((String)localObject2)) || (bu.isNullOrNil((String)localObject3))) {}
          for (bool1 = false;; bool1 = bool5)
          {
            this.result = bool1;
            break;
            ae.i("MicroMsg.Wepkg.WepkgPreloadFilesStorage", "WepkgPreloadFilesRecord addFileDownloadCount ret:%s", new Object[] { Boolean.valueOf(((com.tencent.mm.plugin.wepkg.b.d)localObject1).execSQL("WepkgPreloadFiles", String.format("update %s set %s=%s+1 where %s='%s' and %s='%s'", new Object[] { "WepkgPreloadFiles", "fileDownloadCount", "fileDownloadCount", "pkgId", localObject2, "rid", localObject3 }))) });
          }
          if (this.EXs == null) {
            break;
          }
          localObject1 = com.tencent.mm.plugin.wepkg.b.d.fby();
          localObject2 = this.EXs.guO;
          if ((!((com.tencent.mm.plugin.wepkg.b.d)localObject1).kot) || (bu.isNullOrNil((String)localObject2)))
          {
            bool1 = false;
            break label1102;
          }
          ae.i("MicroMsg.Wepkg.WepkgPreloadFilesStorage", "WepkgPreloadFilesRecord resetFileDownloadCount ret:%s", new Object[] { Boolean.valueOf(((com.tencent.mm.plugin.wepkg.b.d)localObject1).execSQL("WepkgPreloadFiles", String.format("update %s set %s=0 where %s='%s'", new Object[] { "WepkgPreloadFiles", "fileDownloadCount", "pkgId", localObject2 }))) });
          break label1102;
        }
        break label1412;
      }
    }
  }
  
  public final void aOY()
  {
    AppMethodBeat.i(110692);
    if (this.kuv != null) {
      this.kuv.run();
    }
    AppMethodBeat.o(110692);
  }
  
  public final void n(Parcel paramParcel)
  {
    AppMethodBeat.i(110693);
    this.EN = paramParcel.readInt();
    this.EXp = ((WepkgVersion)paramParcel.readParcelable(WepkgVersion.class.getClassLoader()));
    if (this.EXq == null) {
      this.EXq = new ArrayList();
    }
    paramParcel.readList(this.EXq, WepkgVersion.class.getClassLoader());
    this.EXs = ((WepkgPreloadFile)paramParcel.readParcelable(WepkgPreloadFile.class.getClassLoader()));
    if (this.EXt == null) {
      this.EXt = new ArrayList();
    }
    paramParcel.readList(this.EXt, WepkgPreloadFile.class.getClassLoader());
    this.EXu = paramParcel.readString();
    AppMethodBeat.o(110693);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wepkg.model.WepkgCrossProcessTask
 * JD-Core Version:    0.7.0.1
 */