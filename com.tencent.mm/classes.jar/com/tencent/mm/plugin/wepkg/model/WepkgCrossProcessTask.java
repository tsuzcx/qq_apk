package com.tencent.mm.plugin.wepkg.model;

import android.database.Cursor;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.m.g;
import com.tencent.mm.plugin.wepkg.b.e;
import com.tencent.mm.plugin.wepkg.b.f;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class WepkgCrossProcessTask
  extends BaseWepkgProcessTask
{
  public static final Parcelable.Creator<WepkgCrossProcessTask> CREATOR;
  public Runnable hxp;
  public int vA;
  public WepkgVersion vGb;
  public List<WepkgVersion> vGc;
  public WePkgDiffInfo vGd;
  public WepkgPreloadFile vGe;
  public List<WepkgPreloadFile> vGf;
  public String vGg;
  
  static
  {
    AppMethodBeat.i(63537);
    CREATOR = new WepkgCrossProcessTask.1();
    AppMethodBeat.o(63537);
  }
  
  public WepkgCrossProcessTask()
  {
    AppMethodBeat.i(63531);
    this.vA = -1;
    this.vGb = new WepkgVersion();
    this.vGc = new ArrayList();
    this.vGd = new WePkgDiffInfo();
    this.vGe = new WepkgPreloadFile();
    this.vGf = new ArrayList();
    AppMethodBeat.o(63531);
  }
  
  private WepkgCrossProcessTask(Parcel paramParcel)
  {
    AppMethodBeat.i(63532);
    f(paramParcel);
    AppMethodBeat.o(63532);
  }
  
  public final void a(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(63536);
    paramParcel.writeInt(this.vA);
    paramParcel.writeParcelable(this.vGb, paramInt);
    paramParcel.writeList(this.vGc);
    paramParcel.writeParcelable(this.vGe, paramInt);
    paramParcel.writeList(this.vGf);
    paramParcel.writeString(this.vGg);
    AppMethodBeat.o(63536);
  }
  
  public final void ata()
  {
    Object localObject2 = null;
    Object localObject1 = null;
    boolean bool2 = false;
    boolean bool3 = true;
    boolean bool4 = true;
    boolean bool5 = true;
    boolean bool1 = true;
    AppMethodBeat.i(63533);
    label226:
    Object localObject3;
    Object localObject4;
    switch (this.vA)
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
      do
      {
        tU();
        AppMethodBeat.o(63533);
        return;
        for (;;)
        {
          this.cmX = bool1;
          break;
          bool1 = g.Nr().Nd();
          continue;
          if (this.vGb == null) {
            break;
          }
          localObject1 = f.dkq().ako(this.vGb.ezY);
          if (localObject1 != null)
          {
            this.vGb.a((e)localObject1);
          }
          else
          {
            this.vGb = null;
            break;
            if (this.vGb == null) {
              break;
            }
            bool1 = f.dkq().akq(this.vGb.ezY);
            continue;
            if (this.vGb == null) {
              break;
            }
            bool1 = f.dkq().a(this.vGb.ezY, this.vGb.vGJ, this.vGb.vGK, this.vGb.vGL);
            continue;
            if (this.vGb == null) {
              break;
            }
            bool1 = f.dkq().B(this.vGb.ezY, this.vGb.gUy, this.vGb.vGQ);
            continue;
            if (this.vGb == null) {
              break;
            }
            bool1 = f.dkq().bW(this.vGb.ezY, this.vGb.vGR);
            continue;
            if ((this.vGb == null) || (bo.isNullOrNil(this.vGb.ezY))) {
              break;
            }
            localObject1 = f.dkq();
            localObject2 = this.vGb;
            localObject3 = new e();
            ((e)localObject3).field_pkgId = ((WepkgVersion)localObject2).ezY;
            ((e)localObject3).field_appId = ((WepkgVersion)localObject2).appId;
            ((e)localObject3).field_version = ((WepkgVersion)localObject2).version;
            ((e)localObject3).field_pkgPath = ((WepkgVersion)localObject2).gUy;
            ((e)localObject3).field_disableWvCache = ((WepkgVersion)localObject2).vGJ;
            ((e)localObject3).field_clearPkgTime = ((WepkgVersion)localObject2).vGK;
            ((e)localObject3).field_checkIntervalTime = ((WepkgVersion)localObject2).vGL;
            ((e)localObject3).field_packMethod = ((WepkgVersion)localObject2).vGM;
            ((e)localObject3).field_domain = ((WepkgVersion)localObject2).vGN;
            ((e)localObject3).field_md5 = ((WepkgVersion)localObject2).cqq;
            ((e)localObject3).field_downloadUrl = ((WepkgVersion)localObject2).downloadUrl;
            ((e)localObject3).field_pkgSize = ((WepkgVersion)localObject2).vGO;
            ((e)localObject3).field_downloadNetType = ((WepkgVersion)localObject2).vFT;
            ((e)localObject3).field_nextCheckTime = ((WepkgVersion)localObject2).vGP;
            ((e)localObject3).field_createTime = ((WepkgVersion)localObject2).createTime;
            ((e)localObject3).field_charset = ((WepkgVersion)localObject2).charset;
            ((e)localObject3).field_bigPackageReady = ((WepkgVersion)localObject2).vGQ;
            ((e)localObject3).field_preloadFilesReady = ((WepkgVersion)localObject2).vGR;
            ((e)localObject3).field_preloadFilesAtomic = ((WepkgVersion)localObject2).vGS;
            ((e)localObject3).field_totalDownloadCount = ((WepkgVersion)localObject2).vGT;
            ((e)localObject3).field_downloadTriggerType = ((WepkgVersion)localObject2).cNS;
            ((f)localObject1).a((e)localObject3, this.vGd);
            if (!bo.es(this.vGf))
            {
              localObject1 = this.vGf.iterator();
              while (((Iterator)localObject1).hasNext())
              {
                localObject2 = (WepkgPreloadFile)((Iterator)localObject1).next();
                if (localObject2 != null)
                {
                  localObject3 = com.tencent.mm.plugin.wepkg.b.d.dkp();
                  localObject4 = new com.tencent.mm.plugin.wepkg.b.c();
                  ((com.tencent.mm.plugin.wepkg.b.c)localObject4).field_key = ((WepkgPreloadFile)localObject2).key;
                  ((com.tencent.mm.plugin.wepkg.b.c)localObject4).field_pkgId = ((WepkgPreloadFile)localObject2).ezY;
                  ((com.tencent.mm.plugin.wepkg.b.c)localObject4).field_version = ((WepkgPreloadFile)localObject2).version;
                  ((com.tencent.mm.plugin.wepkg.b.c)localObject4).field_filePath = ((WepkgPreloadFile)localObject2).filePath;
                  ((com.tencent.mm.plugin.wepkg.b.c)localObject4).field_rid = ((WepkgPreloadFile)localObject2).vGh;
                  ((com.tencent.mm.plugin.wepkg.b.c)localObject4).field_mimeType = ((WepkgPreloadFile)localObject2).mimeType;
                  ((com.tencent.mm.plugin.wepkg.b.c)localObject4).field_md5 = ((WepkgPreloadFile)localObject2).cqq;
                  ((com.tencent.mm.plugin.wepkg.b.c)localObject4).field_downloadUrl = ((WepkgPreloadFile)localObject2).downloadUrl;
                  ((com.tencent.mm.plugin.wepkg.b.c)localObject4).field_size = ((WepkgPreloadFile)localObject2).size;
                  ((com.tencent.mm.plugin.wepkg.b.c)localObject4).field_downloadNetType = ((WepkgPreloadFile)localObject2).vFT;
                  ((com.tencent.mm.plugin.wepkg.b.c)localObject4).field_completeDownload = ((WepkgPreloadFile)localObject2).vGu;
                  ((com.tencent.mm.plugin.wepkg.b.c)localObject4).field_createTime = ((WepkgPreloadFile)localObject2).createTime;
                  if (((com.tencent.mm.plugin.wepkg.b.d)localObject3).hsO) {
                    if (((com.tencent.mm.plugin.wepkg.b.d)localObject3).hK(((com.tencent.mm.plugin.wepkg.b.c)localObject4).field_pkgId, ((com.tencent.mm.plugin.wepkg.b.c)localObject4).field_rid) == null)
                    {
                      ((com.tencent.mm.plugin.wepkg.b.c)localObject4).field_createTime = com.tencent.mm.plugin.wepkg.utils.d.aNY();
                      bool2 = ((com.tencent.mm.plugin.wepkg.b.d)localObject3).insert((com.tencent.mm.sdk.e.c)localObject4);
                      ab.i("MicroMsg.Wepkg.WepkgPreloadFilesStorage", "insertPreloadFile pkgid:%s, version:%s, rid:%s, ret:%s", new Object[] { ((com.tencent.mm.plugin.wepkg.b.c)localObject4).field_pkgId, ((com.tencent.mm.plugin.wepkg.b.c)localObject4).field_version, ((com.tencent.mm.plugin.wepkg.b.c)localObject4).field_rid, Boolean.valueOf(bool2) });
                    }
                    else
                    {
                      bool2 = ((com.tencent.mm.plugin.wepkg.b.d)localObject3).replace((com.tencent.mm.sdk.e.c)localObject4);
                      ab.i("MicroMsg.Wepkg.WepkgPreloadFilesStorage", "relacePreloadFile pkgid:%s, version:%s, rid:%s, ret:%s", new Object[] { ((com.tencent.mm.plugin.wepkg.b.c)localObject4).field_pkgId, ((com.tencent.mm.plugin.wepkg.b.c)localObject4).field_version, ((com.tencent.mm.plugin.wepkg.b.c)localObject4).field_rid, Boolean.valueOf(bool2) });
                    }
                  }
                }
              }
            }
            continue;
            if ((this.vGb == null) || (bo.isNullOrNil(this.vGb.ezY))) {
              break;
            }
            localObject2 = com.tencent.mm.plugin.wepkg.b.d.dkp();
            localObject4 = this.vGb.ezY;
            if ((!((com.tencent.mm.plugin.wepkg.b.d)localObject2).hsO) && (bo.isNullOrNil((String)localObject4))) {}
            for (;;)
            {
              this.vGf = ((List)localObject1);
              break;
              localObject3 = String.format("select * from %s where %s=? and %s=0", new Object[] { "WepkgPreloadFiles", "pkgId", "completeDownload" });
              localObject2 = ((com.tencent.mm.plugin.wepkg.b.d)localObject2).rawQuery((String)localObject3, new String[] { localObject4 });
              ab.i("MicroMsg.Wepkg.WepkgPreloadFilesStorage", "getNeedDownloadPreLoadFileList queryStr:%s", new Object[] { localObject3 });
              if (localObject2 == null)
              {
                ab.i("MicroMsg.Wepkg.WepkgPreloadFilesStorage", "cursor is null");
              }
              else if (((Cursor)localObject2).moveToFirst())
              {
                localObject1 = new ArrayList();
                do
                {
                  localObject3 = new WepkgPreloadFile();
                  localObject4 = new com.tencent.mm.plugin.wepkg.b.c();
                  ((com.tencent.mm.plugin.wepkg.b.c)localObject4).convertFrom((Cursor)localObject2);
                  ((WepkgPreloadFile)localObject3).a((com.tencent.mm.plugin.wepkg.b.c)localObject4);
                  ((List)localObject1).add(localObject3);
                } while (((Cursor)localObject2).moveToNext());
                ((Cursor)localObject2).close();
                ab.i("MicroMsg.Wepkg.WepkgPreloadFilesStorage", "record list size:%s", new Object[] { Integer.valueOf(((List)localObject1).size()) });
              }
              else
              {
                ((Cursor)localObject2).close();
                ab.i("MicroMsg.Wepkg.WepkgPreloadFilesStorage", "no record");
              }
            }
            if (this.vGe == null) {
              break;
            }
            bool1 = com.tencent.mm.plugin.wepkg.b.d.dkp().g(this.vGe.ezY, this.vGe.vGh, this.vGe.filePath, this.vGe.vGu);
          }
        }
      } while (this.vGb == null);
      localObject1 = f.dkq();
      if (!((f)localObject1).hsO) {
        localObject1 = null;
      }
      for (;;)
      {
        label1356:
        if (bo.isNullOrNil((String)localObject1))
        {
          localObject3 = com.tencent.mm.plugin.wepkg.b.d.dkp();
          if (!((com.tencent.mm.plugin.wepkg.b.d)localObject3).hsO)
          {
            localObject1 = localObject2;
            label1381:
            if (bo.isNullOrNil((String)localObject1))
            {
              localObject2 = f.dkq();
              if (((f)localObject2).hsO)
              {
                ab.i("MicroMsg.Wepkg.WepkgVersionStorage", "WepkgVersionRecord resetAutoDownloadCount ret:%s", new Object[] { Boolean.valueOf(((f)localObject2).execSQL("WepkgVersion", String.format("update %s set %s=0", new Object[] { "WepkgVersion", "autoDownloadCount" }))) });
                ab.i("MicroMsg.Wepkg.WepkgVersionStorage", "WepkgPreloadFilesRecord resetAutoDownloadCount ret:%s", new Object[] { Boolean.valueOf(((f)localObject2).execSQL("WepkgPreloadFiles", String.format("update %s set %s=0", new Object[] { "WepkgPreloadFiles", "autoDownloadCount" }))) });
              }
            }
            this.vGb.ezY = ((String)localObject1);
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
                break label3018;
              }
            }
          }
        }
      }
    }
    label2448:
    label3005:
    label3013:
    label3018:
    for (int i = bo.hk(i - 1, 0);; i = 0)
    {
      ((Cursor)localObject3).move(i);
      localObject4 = new e();
      ((e)localObject4).convertFrom((Cursor)localObject3);
      ((Cursor)localObject3).close();
      ((f)localObject1).akr(((e)localObject4).field_pkgId);
      ab.i("MicroMsg.Wepkg.WepkgVersionStorage", "randomNeedDownloadPkgid exist record in DB, pkgid:%s, version:%s, bigPackageReady:false, preloadFilesAtomic:true", new Object[] { ((e)localObject4).field_pkgId, ((e)localObject4).field_version });
      localObject1 = ((e)localObject4).field_pkgId;
      break label1356;
      ((Cursor)localObject3).close();
      localObject3 = ((f)localObject1).rawQuery(String.format("select * from %s where %s=0 and %s<1 and %s<?", new Object[] { "WepkgVersion", "bigPackageReady", "autoDownloadCount", "packageDownloadCount" }), new String[] { "3" });
      if (localObject3 == null)
      {
        localObject1 = null;
        break label1356;
      }
      if (((Cursor)localObject3).moveToFirst())
      {
        i = ((Cursor)localObject3).getCount();
        if (i <= 1) {
          break label3013;
        }
      }
      for (i = bo.hk(i - 1, 0);; i = 0)
      {
        ((Cursor)localObject3).move(i);
        localObject4 = new e();
        ((e)localObject4).convertFrom((Cursor)localObject3);
        ((Cursor)localObject3).close();
        ((f)localObject1).akr(((e)localObject4).field_pkgId);
        ab.i("MicroMsg.Wepkg.WepkgVersionStorage", "randomNeedDownloadPkgid exist record in DB, pkgid:%s, version:%s, bigPackageReady:false, preloadFilesAtomic:false", new Object[] { ((e)localObject4).field_pkgId, ((e)localObject4).field_version });
        localObject1 = ((e)localObject4).field_pkgId;
        break label1356;
        ((Cursor)localObject3).close();
        ab.i("MicroMsg.Wepkg.WepkgVersionStorage", "randomNeedDownloadPkgid no download record in DB");
        localObject1 = null;
        break label1356;
        localObject4 = ((com.tencent.mm.plugin.wepkg.b.d)localObject3).rawQuery(String.format("select * from %s where %s=0 and %s<1 and %s<?", new Object[] { "WepkgPreloadFiles", "completeDownload", "autoDownloadCount", "fileDownloadCount" }), new String[] { "3" });
        localObject1 = localObject2;
        if (localObject4 == null) {
          break label1381;
        }
        if (((Cursor)localObject4).moveToFirst())
        {
          i = ((Cursor)localObject4).getCount();
          if (i <= 1) {
            break label3005;
          }
        }
        for (i = bo.hk(i - 1, 0);; i = 0)
        {
          ((Cursor)localObject4).move(i);
          localObject1 = new com.tencent.mm.plugin.wepkg.b.c();
          ((com.tencent.mm.plugin.wepkg.b.c)localObject1).convertFrom((Cursor)localObject4);
          ((Cursor)localObject4).close();
          localObject2 = ((com.tencent.mm.plugin.wepkg.b.c)localObject1).field_pkgId;
          localObject4 = ((com.tencent.mm.plugin.wepkg.b.c)localObject1).field_rid;
          if ((!((com.tencent.mm.plugin.wepkg.b.d)localObject3).hsO) || (bo.isNullOrNil((String)localObject2)) || (bo.isNullOrNil((String)localObject4))) {}
          for (;;)
          {
            ab.i("MicroMsg.Wepkg.WepkgPreloadFilesStorage", "randomNeedDownloadPkgid exist record in DB, pkgid:%s, version:%s, rid:%s", new Object[] { ((com.tencent.mm.plugin.wepkg.b.c)localObject1).field_pkgId, ((com.tencent.mm.plugin.wepkg.b.c)localObject1).field_version, ((com.tencent.mm.plugin.wepkg.b.c)localObject1).field_rid });
            localObject1 = ((com.tencent.mm.plugin.wepkg.b.c)localObject1).field_pkgId;
            break;
            ab.i("MicroMsg.Wepkg.WepkgPreloadFilesStorage", "WepkgPreloadFilesRecord addAutoDownloadCount ret:%s", new Object[] { Boolean.valueOf(((com.tencent.mm.plugin.wepkg.b.d)localObject3).execSQL("WepkgPreloadFiles", String.format("update %s set %s=%s+1 where %s='%s' and %s='%s'", new Object[] { "WepkgPreloadFiles", "autoDownloadCount", "autoDownloadCount", "pkgId", localObject2, "rid", localObject4 }))) });
          }
          ((Cursor)localObject4).close();
          ab.i("MicroMsg.Wepkg.WepkgPreloadFilesStorage", "randomNeedDownloadPkgid no download record in DB");
          localObject1 = localObject2;
          break label1381;
          if (this.vGb == null) {
            break;
          }
          this.vGf = com.tencent.mm.plugin.wepkg.b.d.dkp().akm(this.vGb.ezY);
          break label226;
          if (this.vGe == null) {
            break;
          }
          localObject1 = com.tencent.mm.plugin.wepkg.b.d.dkp().hK(this.vGe.ezY, this.vGe.vGh);
          if (localObject1 != null)
          {
            this.vGe.a((com.tencent.mm.plugin.wepkg.b.c)localObject1);
            break label226;
          }
          this.vGe = null;
          break;
          if (this.vGb == null) {
            break;
          }
          bool1 = f.dkq().aks(this.vGb.ezY);
          break label226;
          if (this.vGb == null) {
            break;
          }
          localObject1 = f.dkq().akp(this.vGb.ezY);
          if (localObject1 != null)
          {
            this.vGb.a((e)localObject1);
            break label226;
          }
          this.vGb = null;
          break;
          this.vGc = f.dkq().dkt();
          break label226;
          if (this.vGb == null) {
            break;
          }
          bool1 = f.dkq().akt(this.vGb.ezY);
          break label226;
          if (this.vGb == null) {
            break;
          }
          localObject1 = f.dkq();
          localObject2 = this.vGb.ezY;
          bool1 = bool2;
          if (((f)localObject1).hsO) {
            if (!bo.isNullOrNil((String)localObject2)) {
              break label2448;
            }
          }
          for (bool1 = bool2;; bool1 = true)
          {
            this.cmX = bool1;
            break;
            ab.i("MicroMsg.Wepkg.WepkgVersionStorage", "WepkgVersionRecord addTotalDownloadCount ret:%s", new Object[] { Boolean.valueOf(((f)localObject1).execSQL("WepkgVersion", String.format("update %s set %s=%s+1 where %s='%s'", new Object[] { "WepkgVersion", "totalDownloadCount", "totalDownloadCount", "pkgId", localObject2 }))) });
          }
          if (this.vGb == null) {
            break;
          }
          localObject1 = f.dkq();
          localObject2 = this.vGb.ezY;
          if ((!((f)localObject1).hsO) || (bo.isNullOrNil((String)localObject2))) {}
          for (bool1 = false;; bool1 = bool3)
          {
            this.cmX = bool1;
            break;
            ab.i("MicroMsg.Wepkg.WepkgVersionStorage", "WepkgVersionRecord addPackageDownloadCount ret:%s", new Object[] { Boolean.valueOf(((f)localObject1).execSQL("WepkgVersion", String.format("update %s set %s=%s+1 where %s='%s'", new Object[] { "WepkgVersion", "packageDownloadCount", "packageDownloadCount", "pkgId", localObject2 }))) });
          }
          if (this.vGb == null) {
            break;
          }
          localObject1 = f.dkq();
          localObject2 = this.vGb.ezY;
          if ((!((f)localObject1).hsO) || (bo.isNullOrNil((String)localObject2))) {}
          for (bool1 = false;; bool1 = bool4)
          {
            this.cmX = bool1;
            break;
            ab.i("MicroMsg.Wepkg.WepkgVersionStorage", "WepkgVersionRecord resetPackageDownloadCount ret:%s", new Object[] { Boolean.valueOf(((f)localObject1).execSQL("WepkgVersion", String.format("update %s set %s=0 where %s='%s'", new Object[] { "WepkgVersion", "packageDownloadCount", "pkgId", localObject2 }))) });
          }
          if (this.vGe == null) {
            break;
          }
          localObject1 = com.tencent.mm.plugin.wepkg.b.d.dkp();
          localObject2 = this.vGe.ezY;
          localObject3 = this.vGe.vGh;
          if ((!((com.tencent.mm.plugin.wepkg.b.d)localObject1).hsO) || (bo.isNullOrNil((String)localObject2)) || (bo.isNullOrNil((String)localObject3))) {}
          for (bool1 = false;; bool1 = bool5)
          {
            this.cmX = bool1;
            break;
            ab.i("MicroMsg.Wepkg.WepkgPreloadFilesStorage", "WepkgPreloadFilesRecord addFileDownloadCount ret:%s", new Object[] { Boolean.valueOf(((com.tencent.mm.plugin.wepkg.b.d)localObject1).execSQL("WepkgPreloadFiles", String.format("update %s set %s=%s+1 where %s='%s' and %s='%s'", new Object[] { "WepkgPreloadFiles", "fileDownloadCount", "fileDownloadCount", "pkgId", localObject2, "rid", localObject3 }))) });
          }
          if (this.vGe == null) {
            break;
          }
          localObject1 = com.tencent.mm.plugin.wepkg.b.d.dkp();
          localObject2 = this.vGe.ezY;
          if ((!((com.tencent.mm.plugin.wepkg.b.d)localObject1).hsO) || (bo.isNullOrNil((String)localObject2)))
          {
            bool1 = false;
            break label226;
          }
          ab.i("MicroMsg.Wepkg.WepkgPreloadFilesStorage", "WepkgPreloadFilesRecord resetFileDownloadCount ret:%s", new Object[] { Boolean.valueOf(((com.tencent.mm.plugin.wepkg.b.d)localObject1).execSQL("WepkgPreloadFiles", String.format("update %s set %s=0 where %s='%s'", new Object[] { "WepkgPreloadFiles", "fileDownloadCount", "pkgId", localObject2 }))) });
          break label226;
        }
        break label1381;
      }
    }
  }
  
  public final void atb()
  {
    AppMethodBeat.i(63534);
    if (this.hxp != null) {
      this.hxp.run();
    }
    AppMethodBeat.o(63534);
  }
  
  public final void m(Parcel paramParcel)
  {
    AppMethodBeat.i(63535);
    this.vA = paramParcel.readInt();
    this.vGb = ((WepkgVersion)paramParcel.readParcelable(WepkgVersion.class.getClassLoader()));
    if (this.vGc == null) {
      this.vGc = new ArrayList();
    }
    paramParcel.readList(this.vGc, WepkgVersion.class.getClassLoader());
    this.vGe = ((WepkgPreloadFile)paramParcel.readParcelable(WepkgPreloadFile.class.getClassLoader()));
    if (this.vGf == null) {
      this.vGf = new ArrayList();
    }
    paramParcel.readList(this.vGf, WepkgPreloadFile.class.getClassLoader());
    this.vGg = paramParcel.readString();
    AppMethodBeat.o(63535);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wepkg.model.WepkgCrossProcessTask
 * JD-Core Version:    0.7.0.1
 */