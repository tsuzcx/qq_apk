package com.tencent.mm.plugin.wepkg.model;

import android.database.Cursor;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mm.m.g;
import com.tencent.mm.plugin.wepkg.b.a;
import com.tencent.mm.plugin.wepkg.b.b;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class WepkgCrossProcessTask
  extends BaseWepkgProcessTask
{
  public static final Parcelable.Creator<WepkgCrossProcessTask> CREATOR = new WepkgCrossProcessTask.1();
  public Runnable gfD;
  public WepkgVersion rPj;
  public List<WepkgVersion> rPk;
  public WepkgPreloadFile rPl;
  public List<WepkgPreloadFile> rPm;
  public String rPn;
  public int uC;
  
  public WepkgCrossProcessTask()
  {
    this.uC = -1;
    this.rPj = new WepkgVersion();
    this.rPk = new ArrayList();
    this.rPl = new WepkgPreloadFile();
    this.rPm = new ArrayList();
  }
  
  private WepkgCrossProcessTask(Parcel paramParcel)
  {
    e(paramParcel);
  }
  
  public final void Zu()
  {
    Object localObject2 = null;
    Object localObject1 = null;
    boolean bool2 = false;
    boolean bool3 = true;
    boolean bool4 = true;
    boolean bool5 = true;
    boolean bool1 = true;
    Object localObject3;
    Object localObject4;
    switch (this.uC)
    {
    default: 
    case 1001: 
    case 1002: 
    case 3001: 
    case 3003: 
    case 3004: 
    case 3005: 
    case 3006: 
    case 2001: 
    case 2002: 
    case 4001: 
    case 4002: 
    case 2003: 
      label1285:
      do
      {
        for (;;)
        {
          pQ();
          return;
          this.bFQ = true;
          continue;
          this.bFQ = g.AB().An();
          continue;
          if (this.rPj != null)
          {
            localObject1 = com.tencent.mm.plugin.wepkg.b.d.cjN().UT(this.rPj.dCD);
            if (localObject1 != null)
            {
              this.rPj.a((com.tencent.mm.plugin.wepkg.b.c)localObject1);
              this.bFQ = true;
            }
            else
            {
              this.rPj = null;
              continue;
              if (this.rPj != null)
              {
                this.bFQ = com.tencent.mm.plugin.wepkg.b.d.cjN().UV(this.rPj.dCD);
                continue;
                if (this.rPj != null)
                {
                  this.bFQ = com.tencent.mm.plugin.wepkg.b.d.cjN().a(this.rPj.dCD, this.rPj.rPS, this.rPj.rPT, this.rPj.rPU);
                  continue;
                  if (this.rPj != null)
                  {
                    this.bFQ = com.tencent.mm.plugin.wepkg.b.d.cjN().t(this.rPj.dCD, this.rPj.fCl, this.rPj.rPY);
                    continue;
                    if (this.rPj != null)
                    {
                      this.bFQ = com.tencent.mm.plugin.wepkg.b.d.cjN().bv(this.rPj.dCD, this.rPj.rPZ);
                      continue;
                      if ((this.rPj != null) && (!bk.bl(this.rPj.dCD)))
                      {
                        localObject1 = this.rPj.dCD;
                        com.tencent.mm.plugin.wepkg.b.d.cjN().US((String)localObject1);
                        b.cjM().US((String)localObject1);
                        e.Vg((String)localObject1);
                        this.bFQ = true;
                        continue;
                        if ((this.rPj != null) && (!bk.bl(this.rPj.dCD)))
                        {
                          localObject1 = this.rPj.dCD;
                          com.tencent.mm.plugin.wepkg.b.d.cjN().US((String)localObject1);
                          b.cjM().US((String)localObject1);
                          localObject1 = com.tencent.mm.plugin.wepkg.b.d.cjN();
                          localObject2 = this.rPj;
                          localObject3 = new com.tencent.mm.plugin.wepkg.b.c();
                          ((com.tencent.mm.plugin.wepkg.b.c)localObject3).field_pkgId = ((WepkgVersion)localObject2).dCD;
                          ((com.tencent.mm.plugin.wepkg.b.c)localObject3).field_appId = ((WepkgVersion)localObject2).appId;
                          ((com.tencent.mm.plugin.wepkg.b.c)localObject3).field_version = ((WepkgVersion)localObject2).version;
                          ((com.tencent.mm.plugin.wepkg.b.c)localObject3).field_pkgPath = ((WepkgVersion)localObject2).fCl;
                          ((com.tencent.mm.plugin.wepkg.b.c)localObject3).field_disableWvCache = ((WepkgVersion)localObject2).rPS;
                          ((com.tencent.mm.plugin.wepkg.b.c)localObject3).field_clearPkgTime = ((WepkgVersion)localObject2).rPT;
                          ((com.tencent.mm.plugin.wepkg.b.c)localObject3).field_checkIntervalTime = ((WepkgVersion)localObject2).rPU;
                          ((com.tencent.mm.plugin.wepkg.b.c)localObject3).field_packMethod = ((WepkgVersion)localObject2).rPV;
                          ((com.tencent.mm.plugin.wepkg.b.c)localObject3).field_domain = ((WepkgVersion)localObject2).ceG;
                          ((com.tencent.mm.plugin.wepkg.b.c)localObject3).field_md5 = ((WepkgVersion)localObject2).bIW;
                          ((com.tencent.mm.plugin.wepkg.b.c)localObject3).field_downloadUrl = ((WepkgVersion)localObject2).downloadUrl;
                          ((com.tencent.mm.plugin.wepkg.b.c)localObject3).field_pkgSize = ((WepkgVersion)localObject2).rPW;
                          ((com.tencent.mm.plugin.wepkg.b.c)localObject3).field_downloadNetType = ((WepkgVersion)localObject2).rPq;
                          ((com.tencent.mm.plugin.wepkg.b.c)localObject3).field_nextCheckTime = ((WepkgVersion)localObject2).rPX;
                          ((com.tencent.mm.plugin.wepkg.b.c)localObject3).field_createTime = ((WepkgVersion)localObject2).createTime;
                          ((com.tencent.mm.plugin.wepkg.b.c)localObject3).field_charset = ((WepkgVersion)localObject2).charset;
                          ((com.tencent.mm.plugin.wepkg.b.c)localObject3).field_bigPackageReady = ((WepkgVersion)localObject2).rPY;
                          ((com.tencent.mm.plugin.wepkg.b.c)localObject3).field_preloadFilesReady = ((WepkgVersion)localObject2).rPZ;
                          ((com.tencent.mm.plugin.wepkg.b.c)localObject3).field_preloadFilesAtomic = ((WepkgVersion)localObject2).rQa;
                          ((com.tencent.mm.plugin.wepkg.b.c)localObject3).field_totalDownloadCount = ((WepkgVersion)localObject2).rQb;
                          ((com.tencent.mm.plugin.wepkg.b.c)localObject3).field_downloadTriggerType = ((WepkgVersion)localObject2).cfl;
                          if ((!((com.tencent.mm.plugin.wepkg.b.d)localObject1).gaO) || (bk.bl(((com.tencent.mm.plugin.wepkg.b.c)localObject3).field_pkgId)))
                          {
                            if (!bk.dk(this.rPm)) {
                              localObject1 = this.rPm.iterator();
                            }
                          }
                          else {
                            for (;;)
                            {
                              if (!((Iterator)localObject1).hasNext()) {
                                break label1285;
                              }
                              localObject2 = (WepkgPreloadFile)((Iterator)localObject1).next();
                              if (localObject2 != null)
                              {
                                localObject3 = b.cjM();
                                localObject4 = new a();
                                ((a)localObject4).field_key = ((WepkgPreloadFile)localObject2).key;
                                ((a)localObject4).field_pkgId = ((WepkgPreloadFile)localObject2).dCD;
                                ((a)localObject4).field_version = ((WepkgPreloadFile)localObject2).version;
                                ((a)localObject4).field_filePath = ((WepkgPreloadFile)localObject2).filePath;
                                ((a)localObject4).field_rid = ((WepkgPreloadFile)localObject2).rPo;
                                ((a)localObject4).field_mimeType = ((WepkgPreloadFile)localObject2).mimeType;
                                ((a)localObject4).field_md5 = ((WepkgPreloadFile)localObject2).bIW;
                                ((a)localObject4).field_downloadUrl = ((WepkgPreloadFile)localObject2).downloadUrl;
                                ((a)localObject4).field_size = ((WepkgPreloadFile)localObject2).size;
                                ((a)localObject4).field_downloadNetType = ((WepkgPreloadFile)localObject2).rPq;
                                ((a)localObject4).field_completeDownload = ((WepkgPreloadFile)localObject2).rPD;
                                ((a)localObject4).field_createTime = ((WepkgPreloadFile)localObject2).createTime;
                                if (((b)localObject3).gaO)
                                {
                                  if (((b)localObject3).fK(((a)localObject4).field_pkgId, ((a)localObject4).field_rid) == null)
                                  {
                                    ((a)localObject4).field_createTime = com.tencent.mm.plugin.wepkg.utils.d.aqv();
                                    bool1 = ((b)localObject3).b((com.tencent.mm.sdk.e.c)localObject4);
                                    y.i("MicroMsg.Wepkg.WepkgPreloadFilesStorage", "insertPreloadFile pkgid:%s, version:%s, rid:%s, ret:%s", new Object[] { ((a)localObject4).field_pkgId, ((a)localObject4).field_version, ((a)localObject4).field_rid, Boolean.valueOf(bool1) });
                                    continue;
                                    if (((com.tencent.mm.plugin.wepkg.b.d)localObject1).UT(((com.tencent.mm.plugin.wepkg.b.c)localObject3).field_pkgId) == null)
                                    {
                                      ((com.tencent.mm.plugin.wepkg.b.c)localObject3).field_nextCheckTime = (com.tencent.mm.plugin.wepkg.utils.d.aqv() + ((com.tencent.mm.plugin.wepkg.b.c)localObject3).field_checkIntervalTime);
                                      ((com.tencent.mm.plugin.wepkg.b.c)localObject3).field_createTime = com.tencent.mm.plugin.wepkg.utils.d.aqv();
                                      ((com.tencent.mm.plugin.wepkg.b.c)localObject3).field_accessTime = com.tencent.mm.plugin.wepkg.utils.d.aqv();
                                      bool1 = ((com.tencent.mm.plugin.wepkg.b.d)localObject1).b((com.tencent.mm.sdk.e.c)localObject3);
                                      y.i("MicroMsg.Wepkg.WepkgVersionStorage", "insertPkgVersion pkgid:%s, version:%s, ret:%s", new Object[] { ((com.tencent.mm.plugin.wepkg.b.c)localObject3).field_pkgId, ((com.tencent.mm.plugin.wepkg.b.c)localObject3).field_version, Boolean.valueOf(bool1) });
                                      break;
                                    }
                                    ((com.tencent.mm.plugin.wepkg.b.c)localObject3).field_nextCheckTime = (com.tencent.mm.plugin.wepkg.utils.d.aqv() + ((com.tencent.mm.plugin.wepkg.b.c)localObject3).field_checkIntervalTime);
                                    bool1 = ((com.tencent.mm.plugin.wepkg.b.d)localObject1).a((com.tencent.mm.sdk.e.c)localObject3);
                                    y.i("MicroMsg.Wepkg.WepkgVersionStorage", "replacePkgVersion pkgid:%s, version:%s, ret:%s", new Object[] { ((com.tencent.mm.plugin.wepkg.b.c)localObject3).field_pkgId, ((com.tencent.mm.plugin.wepkg.b.c)localObject3).field_version, Boolean.valueOf(bool1) });
                                    break;
                                  }
                                  bool1 = ((b)localObject3).a((com.tencent.mm.sdk.e.c)localObject4);
                                  y.i("MicroMsg.Wepkg.WepkgPreloadFilesStorage", "relacePreloadFile pkgid:%s, version:%s, rid:%s, ret:%s", new Object[] { ((a)localObject4).field_pkgId, ((a)localObject4).field_version, ((a)localObject4).field_rid, Boolean.valueOf(bool1) });
                                }
                              }
                            }
                          }
                          this.bFQ = true;
                          continue;
                          if ((this.rPj != null) && (!bk.bl(this.rPj.dCD)))
                          {
                            localObject2 = b.cjM();
                            localObject4 = this.rPj.dCD;
                            if ((!((b)localObject2).gaO) && (bk.bl((String)localObject4))) {}
                            for (;;)
                            {
                              this.rPm = ((List)localObject1);
                              this.bFQ = true;
                              break;
                              localObject3 = String.format("select * from %s where %s=? and %s=0", new Object[] { "WepkgPreloadFiles", "pkgId", "completeDownload" });
                              localObject2 = ((b)localObject2).rawQuery((String)localObject3, new String[] { localObject4 });
                              y.i("MicroMsg.Wepkg.WepkgPreloadFilesStorage", "getNeedDownloadPreLoadFileList queryStr:%s", new Object[] { localObject3 });
                              if (localObject2 == null)
                              {
                                y.i("MicroMsg.Wepkg.WepkgPreloadFilesStorage", "cursor is null");
                              }
                              else if (((Cursor)localObject2).moveToFirst())
                              {
                                localObject1 = new ArrayList();
                                do
                                {
                                  localObject3 = new WepkgPreloadFile();
                                  localObject4 = new a();
                                  ((a)localObject4).d((Cursor)localObject2);
                                  ((WepkgPreloadFile)localObject3).a((a)localObject4);
                                  ((List)localObject1).add(localObject3);
                                } while (((Cursor)localObject2).moveToNext());
                                ((Cursor)localObject2).close();
                                y.i("MicroMsg.Wepkg.WepkgPreloadFilesStorage", "record list size:%s", new Object[] { Integer.valueOf(((List)localObject1).size()) });
                              }
                              else
                              {
                                ((Cursor)localObject2).close();
                                y.i("MicroMsg.Wepkg.WepkgPreloadFilesStorage", "no record");
                              }
                            }
                            if (this.rPl != null) {
                              this.bFQ = b.cjM().g(this.rPl.dCD, this.rPl.rPo, this.rPl.filePath, this.rPl.rPD);
                            }
                          }
                        }
                      }
                    }
                  }
                }
              }
            }
          }
        }
      } while (this.rPj == null);
      localObject1 = com.tencent.mm.plugin.wepkg.b.d.cjN();
      if (!((com.tencent.mm.plugin.wepkg.b.d)localObject1).gaO) {
        localObject1 = null;
      }
      for (;;)
      {
        label1637:
        if (bk.bl((String)localObject1))
        {
          localObject3 = b.cjM();
          if (!((b)localObject3).gaO)
          {
            localObject1 = localObject2;
            label1662:
            if (bk.bl((String)localObject1))
            {
              localObject2 = com.tencent.mm.plugin.wepkg.b.d.cjN();
              if (((com.tencent.mm.plugin.wepkg.b.d)localObject2).gaO)
              {
                y.i("MicroMsg.Wepkg.WepkgVersionStorage", "WepkgVersionRecord resetAutoDownloadCount ret:%s", new Object[] { Boolean.valueOf(((com.tencent.mm.plugin.wepkg.b.d)localObject2).gk("WepkgVersion", String.format("update %s set %s=0", new Object[] { "WepkgVersion", "autoDownloadCount" }))) });
                y.i("MicroMsg.Wepkg.WepkgVersionStorage", "WepkgPreloadFilesRecord resetAutoDownloadCount ret:%s", new Object[] { Boolean.valueOf(((com.tencent.mm.plugin.wepkg.b.d)localObject2).gk("WepkgPreloadFiles", String.format("update %s set %s=0", new Object[] { "WepkgPreloadFiles", "autoDownloadCount" }))) });
              }
            }
            this.rPj.dCD = ((String)localObject1);
            break;
            localObject3 = ((com.tencent.mm.plugin.wepkg.b.d)localObject1).rawQuery(String.format("select * from %s where %s=0 and %s=1 and %s<1 and %s<?", new Object[] { "WepkgVersion", "bigPackageReady", "preloadFilesAtomic", "autoDownloadCount", "packageDownloadCount" }), new String[] { "3" });
            if (localObject3 == null)
            {
              localObject1 = null;
              continue;
            }
            if (((Cursor)localObject3).moveToFirst())
            {
              i = ((Cursor)localObject3).getCount();
              if (i <= 1) {
                break label3446;
              }
            }
          }
        }
      }
    }
    label2755:
    label3433:
    label3441:
    label3446:
    for (int i = bk.fe(i - 1, 0);; i = 0)
    {
      ((Cursor)localObject3).move(i);
      localObject4 = new com.tencent.mm.plugin.wepkg.b.c();
      ((com.tencent.mm.plugin.wepkg.b.c)localObject4).d((Cursor)localObject3);
      ((Cursor)localObject3).close();
      ((com.tencent.mm.plugin.wepkg.b.d)localObject1).UW(((com.tencent.mm.plugin.wepkg.b.c)localObject4).field_pkgId);
      y.i("MicroMsg.Wepkg.WepkgVersionStorage", "randomNeedDownloadPkgid exist record in DB, pkgid:%s, version:%s, bigPackageReady:false, preloadFilesAtomic:true", new Object[] { ((com.tencent.mm.plugin.wepkg.b.c)localObject4).field_pkgId, ((com.tencent.mm.plugin.wepkg.b.c)localObject4).field_version });
      localObject1 = ((com.tencent.mm.plugin.wepkg.b.c)localObject4).field_pkgId;
      break label1637;
      ((Cursor)localObject3).close();
      localObject3 = ((com.tencent.mm.plugin.wepkg.b.d)localObject1).rawQuery(String.format("select * from %s where %s=0 and %s<1 and %s<?", new Object[] { "WepkgVersion", "bigPackageReady", "autoDownloadCount", "packageDownloadCount" }), new String[] { "3" });
      if (localObject3 == null)
      {
        localObject1 = null;
        break label1637;
      }
      if (((Cursor)localObject3).moveToFirst())
      {
        i = ((Cursor)localObject3).getCount();
        if (i <= 1) {
          break label3441;
        }
      }
      for (i = bk.fe(i - 1, 0);; i = 0)
      {
        ((Cursor)localObject3).move(i);
        localObject4 = new com.tencent.mm.plugin.wepkg.b.c();
        ((com.tencent.mm.plugin.wepkg.b.c)localObject4).d((Cursor)localObject3);
        ((Cursor)localObject3).close();
        ((com.tencent.mm.plugin.wepkg.b.d)localObject1).UW(((com.tencent.mm.plugin.wepkg.b.c)localObject4).field_pkgId);
        y.i("MicroMsg.Wepkg.WepkgVersionStorage", "randomNeedDownloadPkgid exist record in DB, pkgid:%s, version:%s, bigPackageReady:false, preloadFilesAtomic:false", new Object[] { ((com.tencent.mm.plugin.wepkg.b.c)localObject4).field_pkgId, ((com.tencent.mm.plugin.wepkg.b.c)localObject4).field_version });
        localObject1 = ((com.tencent.mm.plugin.wepkg.b.c)localObject4).field_pkgId;
        break label1637;
        ((Cursor)localObject3).close();
        y.i("MicroMsg.Wepkg.WepkgVersionStorage", "randomNeedDownloadPkgid no download record in DB");
        localObject1 = null;
        break label1637;
        localObject4 = ((b)localObject3).rawQuery(String.format("select * from %s where %s=0 and %s<1 and %s<?", new Object[] { "WepkgPreloadFiles", "completeDownload", "autoDownloadCount", "fileDownloadCount" }), new String[] { "3" });
        localObject1 = localObject2;
        if (localObject4 == null) {
          break label1662;
        }
        if (((Cursor)localObject4).moveToFirst())
        {
          i = ((Cursor)localObject4).getCount();
          if (i <= 1) {
            break label3433;
          }
        }
        for (i = bk.fe(i - 1, 0);; i = 0)
        {
          ((Cursor)localObject4).move(i);
          localObject1 = new a();
          ((a)localObject1).d((Cursor)localObject4);
          ((Cursor)localObject4).close();
          localObject2 = ((a)localObject1).field_pkgId;
          localObject4 = ((a)localObject1).field_rid;
          if ((!((b)localObject3).gaO) || (bk.bl((String)localObject2)) || (bk.bl((String)localObject4))) {}
          for (;;)
          {
            y.i("MicroMsg.Wepkg.WepkgPreloadFilesStorage", "randomNeedDownloadPkgid exist record in DB, pkgid:%s, version:%s, rid:%s", new Object[] { ((a)localObject1).field_pkgId, ((a)localObject1).field_version, ((a)localObject1).field_rid });
            localObject1 = ((a)localObject1).field_pkgId;
            break;
            y.i("MicroMsg.Wepkg.WepkgPreloadFilesStorage", "WepkgPreloadFilesRecord addAutoDownloadCount ret:%s", new Object[] { Boolean.valueOf(((b)localObject3).gk("WepkgPreloadFiles", String.format("update %s set %s=%s+1 where %s='%s' and %s='%s'", new Object[] { "WepkgPreloadFiles", "autoDownloadCount", "autoDownloadCount", "pkgId", localObject2, "rid", localObject4 }))) });
          }
          ((Cursor)localObject4).close();
          y.i("MicroMsg.Wepkg.WepkgPreloadFilesStorage", "randomNeedDownloadPkgid no download record in DB");
          localObject1 = localObject2;
          break label1662;
          if (this.rPj == null) {
            break;
          }
          this.rPm = b.cjM().UR(this.rPj.dCD);
          this.bFQ = true;
          break;
          if (this.rPl == null) {
            break;
          }
          localObject1 = b.cjM().fK(this.rPl.dCD, this.rPl.rPo);
          if (localObject1 != null)
          {
            this.rPl.a((a)localObject1);
            this.bFQ = true;
            break;
          }
          this.rPl = null;
          break;
          if (this.rPj == null) {
            break;
          }
          this.bFQ = com.tencent.mm.plugin.wepkg.b.d.cjN().UX(this.rPj.dCD);
          break;
          if (this.rPj == null) {
            break;
          }
          localObject1 = com.tencent.mm.plugin.wepkg.b.d.cjN().UU(this.rPj.dCD);
          if (localObject1 != null)
          {
            this.rPj.a((com.tencent.mm.plugin.wepkg.b.c)localObject1);
            this.bFQ = true;
            break;
          }
          this.rPj = null;
          break;
          this.rPk = com.tencent.mm.plugin.wepkg.b.d.cjN().cjP();
          this.bFQ = true;
          break;
          if (this.rPj == null) {
            break;
          }
          this.bFQ = com.tencent.mm.plugin.wepkg.b.d.cjN().UY(this.rPj.dCD);
          break;
          if (this.rPj == null) {
            break;
          }
          localObject1 = com.tencent.mm.plugin.wepkg.b.d.cjN();
          localObject2 = this.rPj.dCD;
          bool1 = bool2;
          if (((com.tencent.mm.plugin.wepkg.b.d)localObject1).gaO) {
            if (!bk.bl((String)localObject2)) {
              break label2755;
            }
          }
          for (bool1 = bool2;; bool1 = true)
          {
            this.bFQ = bool1;
            break;
            y.i("MicroMsg.Wepkg.WepkgVersionStorage", "WepkgVersionRecord addTotalDownloadCount ret:%s", new Object[] { Boolean.valueOf(((com.tencent.mm.plugin.wepkg.b.d)localObject1).gk("WepkgVersion", String.format("update %s set %s=%s+1 where %s='%s'", new Object[] { "WepkgVersion", "totalDownloadCount", "totalDownloadCount", "pkgId", localObject2 }))) });
          }
          if (this.rPj == null) {
            break;
          }
          localObject1 = com.tencent.mm.plugin.wepkg.b.d.cjN();
          localObject2 = this.rPj.dCD;
          if ((!((com.tencent.mm.plugin.wepkg.b.d)localObject1).gaO) || (bk.bl((String)localObject2))) {
            bool1 = false;
          }
          for (;;)
          {
            this.bFQ = bool1;
            break;
            y.i("MicroMsg.Wepkg.WepkgVersionStorage", "WepkgVersionRecord addPackageDownloadCount ret:%s", new Object[] { Boolean.valueOf(((com.tencent.mm.plugin.wepkg.b.d)localObject1).gk("WepkgVersion", String.format("update %s set %s=%s+1 where %s='%s'", new Object[] { "WepkgVersion", "packageDownloadCount", "packageDownloadCount", "pkgId", localObject2 }))) });
          }
          if (this.rPj == null) {
            break;
          }
          localObject1 = com.tencent.mm.plugin.wepkg.b.d.cjN();
          localObject2 = this.rPj.dCD;
          if ((!((com.tencent.mm.plugin.wepkg.b.d)localObject1).gaO) || (bk.bl((String)localObject2))) {}
          for (bool1 = false;; bool1 = bool3)
          {
            this.bFQ = bool1;
            break;
            y.i("MicroMsg.Wepkg.WepkgVersionStorage", "WepkgVersionRecord resetPackageDownloadCount ret:%s", new Object[] { Boolean.valueOf(((com.tencent.mm.plugin.wepkg.b.d)localObject1).gk("WepkgVersion", String.format("update %s set %s=0 where %s='%s'", new Object[] { "WepkgVersion", "packageDownloadCount", "pkgId", localObject2 }))) });
          }
          if (this.rPl == null) {
            break;
          }
          localObject1 = b.cjM();
          localObject2 = this.rPl.dCD;
          localObject3 = this.rPl.rPo;
          if ((!((b)localObject1).gaO) || (bk.bl((String)localObject2)) || (bk.bl((String)localObject3))) {}
          for (bool1 = false;; bool1 = bool4)
          {
            this.bFQ = bool1;
            break;
            y.i("MicroMsg.Wepkg.WepkgPreloadFilesStorage", "WepkgPreloadFilesRecord addFileDownloadCount ret:%s", new Object[] { Boolean.valueOf(((b)localObject1).gk("WepkgPreloadFiles", String.format("update %s set %s=%s+1 where %s='%s' and %s='%s'", new Object[] { "WepkgPreloadFiles", "fileDownloadCount", "fileDownloadCount", "pkgId", localObject2, "rid", localObject3 }))) });
          }
          if (this.rPl == null) {
            break;
          }
          localObject1 = b.cjM();
          localObject2 = this.rPl.dCD;
          if ((!((b)localObject1).gaO) || (bk.bl((String)localObject2))) {}
          for (bool1 = false;; bool1 = bool5)
          {
            this.bFQ = bool1;
            break;
            y.i("MicroMsg.Wepkg.WepkgPreloadFilesStorage", "WepkgPreloadFilesRecord resetFileDownloadCount ret:%s", new Object[] { Boolean.valueOf(((b)localObject1).gk("WepkgPreloadFiles", String.format("update %s set %s=0 where %s='%s'", new Object[] { "WepkgPreloadFiles", "fileDownloadCount", "pkgId", localObject2 }))) });
          }
          localObject1 = com.tencent.mm.plugin.wepkg.b.d.cjN();
          if (((com.tencent.mm.plugin.wepkg.b.d)localObject1).gaO)
          {
            y.i("MicroMsg.Wepkg.WepkgVersionStorage", "WepkgVersionRecord clearWepkg ret:%s", new Object[] { Boolean.valueOf(((com.tencent.mm.plugin.wepkg.b.d)localObject1).gk("WepkgVersion", String.format("delete from %s", new Object[] { "WepkgVersion" }))) });
            y.i("MicroMsg.Wepkg.WepkgVersionStorage", "WepkgPreloadFilesRecord clearWepkg ret:%s", new Object[] { Boolean.valueOf(((com.tencent.mm.plugin.wepkg.b.d)localObject1).gk("WepkgPreloadFiles", String.format("delete from %s", new Object[] { "WepkgPreloadFiles" }))) });
          }
          com.tencent.mm.plugin.wepkg.utils.d.DS().O(new e.2());
          break;
        }
        break label1662;
      }
    }
  }
  
  public final void Zv()
  {
    if (this.gfD != null) {
      this.gfD.run();
    }
  }
  
  public final void a(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.uC);
    paramParcel.writeParcelable(this.rPj, paramInt);
    paramParcel.writeList(this.rPk);
    paramParcel.writeParcelable(this.rPl, paramInt);
    paramParcel.writeList(this.rPm);
    paramParcel.writeString(this.rPn);
  }
  
  public final void j(Parcel paramParcel)
  {
    this.uC = paramParcel.readInt();
    this.rPj = ((WepkgVersion)paramParcel.readParcelable(WepkgVersion.class.getClassLoader()));
    if (this.rPk == null) {
      this.rPk = new ArrayList();
    }
    paramParcel.readList(this.rPk, WepkgVersion.class.getClassLoader());
    this.rPl = ((WepkgPreloadFile)paramParcel.readParcelable(WepkgPreloadFile.class.getClassLoader()));
    if (this.rPm == null) {
      this.rPm = new ArrayList();
    }
    paramParcel.readList(this.rPm, WepkgPreloadFile.class.getClassLoader());
    this.rPn = paramParcel.readString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wepkg.model.WepkgCrossProcessTask
 * JD-Core Version:    0.7.0.1
 */