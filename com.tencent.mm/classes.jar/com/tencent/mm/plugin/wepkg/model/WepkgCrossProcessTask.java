package com.tencent.mm.plugin.wepkg.model;

import android.database.Cursor;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.m.g;
import com.tencent.mm.plugin.wepkg.b.e;
import com.tencent.mm.plugin.wepkg.b.f;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class WepkgCrossProcessTask
  extends BaseWepkgProcessTask
{
  public static final Parcelable.Creator<WepkgCrossProcessTask> CREATOR;
  public int CW;
  public WepkgVersion DaU;
  public List<WepkgVersion> DaV;
  public WePkgDiffInfo DaW;
  public WepkgPreloadFile DaX;
  public List<WepkgPreloadFile> DaY;
  public String DaZ;
  public Runnable jWP;
  
  static
  {
    AppMethodBeat.i(110695);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(110695);
  }
  
  public WepkgCrossProcessTask()
  {
    AppMethodBeat.i(110689);
    this.CW = -1;
    this.DaU = new WepkgVersion();
    this.DaV = new ArrayList();
    this.DaW = new WePkgDiffInfo();
    this.DaX = new WepkgPreloadFile();
    this.DaY = new ArrayList();
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
    paramParcel.writeInt(this.CW);
    paramParcel.writeParcelable(this.DaU, paramInt);
    if (this.DaV == null) {
      this.DaV = new ArrayList();
    }
    paramParcel.writeList(this.DaV);
    paramParcel.writeParcelable(this.DaX, paramInt);
    if (this.DaY == null) {
      this.DaY = new ArrayList();
    }
    paramParcel.writeList(this.DaY);
    paramParcel.writeString(this.DaZ);
    AppMethodBeat.o(110694);
  }
  
  public final void aLq()
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
    switch (this.CW)
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
            bet();
            AppMethodBeat.o(110691);
            return;
            this.result = true;
            continue;
            this.result = g.ZZ().ZN();
            continue;
            if (this.DaU != null)
            {
              localObject1 = f.eIT().aEY(this.DaU.fYR);
              if (localObject1 != null)
              {
                this.DaU.a((e)localObject1);
                this.result = true;
              }
              else
              {
                this.DaU = null;
                continue;
                if (this.DaU != null)
                {
                  this.result = f.eIT().aFa(this.DaU.fYR);
                  continue;
                  if (this.DaU != null)
                  {
                    this.result = f.eIT().a(this.DaU.fYR, this.DaU.DbC, this.DaU.DbD, this.DaU.DbE);
                    continue;
                    if (this.DaU != null)
                    {
                      this.result = f.eIT().A(this.DaU.fYR, this.DaU.pkgPath, this.DaU.DbJ);
                      continue;
                      if (this.DaU != null)
                      {
                        this.result = f.eIT().cr(this.DaU.fYR, this.DaU.DbK);
                        continue;
                        if ((this.DaU != null) && (!bs.isNullOrNil(this.DaU.fYR)))
                        {
                          localObject1 = f.eIT();
                          localObject2 = this.DaU;
                          localObject3 = new e();
                          ((e)localObject3).field_pkgId = ((WepkgVersion)localObject2).fYR;
                          ((e)localObject3).field_appId = ((WepkgVersion)localObject2).appId;
                          ((e)localObject3).field_version = ((WepkgVersion)localObject2).version;
                          ((e)localObject3).field_pkgPath = ((WepkgVersion)localObject2).pkgPath;
                          ((e)localObject3).field_disableWvCache = ((WepkgVersion)localObject2).DbC;
                          ((e)localObject3).field_clearPkgTime = ((WepkgVersion)localObject2).DbD;
                          ((e)localObject3).field_checkIntervalTime = ((WepkgVersion)localObject2).DbE;
                          ((e)localObject3).field_packMethod = ((WepkgVersion)localObject2).DbF;
                          ((e)localObject3).field_domain = ((WepkgVersion)localObject2).DbG;
                          ((e)localObject3).field_md5 = ((WepkgVersion)localObject2).md5;
                          ((e)localObject3).field_downloadUrl = ((WepkgVersion)localObject2).downloadUrl;
                          ((e)localObject3).field_pkgSize = ((WepkgVersion)localObject2).DbH;
                          ((e)localObject3).field_downloadNetType = ((WepkgVersion)localObject2).DaM;
                          ((e)localObject3).field_nextCheckTime = ((WepkgVersion)localObject2).DbI;
                          ((e)localObject3).field_createTime = ((WepkgVersion)localObject2).createTime;
                          ((e)localObject3).field_charset = ((WepkgVersion)localObject2).charset;
                          ((e)localObject3).field_bigPackageReady = ((WepkgVersion)localObject2).DbJ;
                          ((e)localObject3).field_preloadFilesReady = ((WepkgVersion)localObject2).DbK;
                          ((e)localObject3).field_preloadFilesAtomic = ((WepkgVersion)localObject2).DbL;
                          ((e)localObject3).field_totalDownloadCount = ((WepkgVersion)localObject2).DbM;
                          ((e)localObject3).field_downloadTriggerType = ((WepkgVersion)localObject2).dCD;
                          ((f)localObject1).a((e)localObject3, this.DaW);
                          if (!bs.gY(this.DaY))
                          {
                            localObject1 = this.DaY.iterator();
                            while (((Iterator)localObject1).hasNext())
                            {
                              localObject2 = (WepkgPreloadFile)((Iterator)localObject1).next();
                              if (localObject2 != null)
                              {
                                localObject3 = com.tencent.mm.plugin.wepkg.b.d.eIS();
                                localObject4 = new com.tencent.mm.plugin.wepkg.b.c();
                                ((com.tencent.mm.plugin.wepkg.b.c)localObject4).field_key = ((WepkgPreloadFile)localObject2).key;
                                ((com.tencent.mm.plugin.wepkg.b.c)localObject4).field_pkgId = ((WepkgPreloadFile)localObject2).fYR;
                                ((com.tencent.mm.plugin.wepkg.b.c)localObject4).field_version = ((WepkgPreloadFile)localObject2).version;
                                ((com.tencent.mm.plugin.wepkg.b.c)localObject4).field_filePath = ((WepkgPreloadFile)localObject2).filePath;
                                ((com.tencent.mm.plugin.wepkg.b.c)localObject4).field_rid = ((WepkgPreloadFile)localObject2).Dba;
                                ((com.tencent.mm.plugin.wepkg.b.c)localObject4).field_mimeType = ((WepkgPreloadFile)localObject2).mimeType;
                                ((com.tencent.mm.plugin.wepkg.b.c)localObject4).field_md5 = ((WepkgPreloadFile)localObject2).md5;
                                ((com.tencent.mm.plugin.wepkg.b.c)localObject4).field_downloadUrl = ((WepkgPreloadFile)localObject2).downloadUrl;
                                ((com.tencent.mm.plugin.wepkg.b.c)localObject4).field_size = ((WepkgPreloadFile)localObject2).size;
                                ((com.tencent.mm.plugin.wepkg.b.c)localObject4).field_downloadNetType = ((WepkgPreloadFile)localObject2).DaM;
                                ((com.tencent.mm.plugin.wepkg.b.c)localObject4).field_completeDownload = ((WepkgPreloadFile)localObject2).Dbn;
                                ((com.tencent.mm.plugin.wepkg.b.c)localObject4).field_createTime = ((WepkgPreloadFile)localObject2).createTime;
                                if (((com.tencent.mm.plugin.wepkg.b.d)localObject3).jQO) {
                                  if (((com.tencent.mm.plugin.wepkg.b.d)localObject3).kM(((com.tencent.mm.plugin.wepkg.b.c)localObject4).field_pkgId, ((com.tencent.mm.plugin.wepkg.b.c)localObject4).field_rid) == null)
                                  {
                                    ((com.tencent.mm.plugin.wepkg.b.c)localObject4).field_createTime = com.tencent.mm.plugin.wepkg.utils.d.bxm();
                                    bool1 = ((com.tencent.mm.plugin.wepkg.b.d)localObject3).insert((com.tencent.mm.sdk.e.c)localObject4);
                                    ac.i("MicroMsg.Wepkg.WepkgPreloadFilesStorage", "insertPreloadFile pkgid:%s, version:%s, rid:%s, ret:%s", new Object[] { ((com.tencent.mm.plugin.wepkg.b.c)localObject4).field_pkgId, ((com.tencent.mm.plugin.wepkg.b.c)localObject4).field_version, ((com.tencent.mm.plugin.wepkg.b.c)localObject4).field_rid, Boolean.valueOf(bool1) });
                                  }
                                  else
                                  {
                                    bool1 = ((com.tencent.mm.plugin.wepkg.b.d)localObject3).replace((com.tencent.mm.sdk.e.c)localObject4);
                                    ac.i("MicroMsg.Wepkg.WepkgPreloadFilesStorage", "relacePreloadFile pkgid:%s, version:%s, rid:%s, ret:%s", new Object[] { ((com.tencent.mm.plugin.wepkg.b.c)localObject4).field_pkgId, ((com.tencent.mm.plugin.wepkg.b.c)localObject4).field_version, ((com.tencent.mm.plugin.wepkg.b.c)localObject4).field_rid, Boolean.valueOf(bool1) });
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
        } while ((this.DaU == null) || (bs.isNullOrNil(this.DaU.fYR)));
        for (;;)
        {
          try
          {
            localObject2 = com.tencent.mm.plugin.wepkg.b.d.eIS();
            localObject4 = this.DaU.fYR;
            if ((((com.tencent.mm.plugin.wepkg.b.d)localObject2).jQO) || (!bs.isNullOrNil((String)localObject4))) {
              continue;
            }
            this.DaY = ((List)localObject1);
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
          ac.i("MicroMsg.Wepkg.WepkgPreloadFilesStorage", "getNeedDownloadPreLoadFileList queryStr:%s", new Object[] { localObject3 });
          if (localObject2 == null)
          {
            ac.i("MicroMsg.Wepkg.WepkgPreloadFilesStorage", "cursor is null");
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
              ac.i("MicroMsg.Wepkg.WepkgPreloadFilesStorage", "record list size:%s", new Object[] { Integer.valueOf(((List)localObject1).size()) });
            }
          }
          else
          {
            ((Cursor)localObject2).close();
            ac.i("MicroMsg.Wepkg.WepkgPreloadFilesStorage", "no record");
            continue;
            if (this.DaX == null) {
              break;
            }
            bool1 = com.tencent.mm.plugin.wepkg.b.d.eIS().f(this.DaX.fYR, this.DaX.Dba, this.DaX.filePath, this.DaX.Dbn);
          }
        }
      } while (this.DaU == null);
      localObject1 = f.eIT();
      if (!((f)localObject1).jQO) {
        localObject1 = null;
      }
      label1412:
      for (;;)
      {
        label1387:
        if (bs.isNullOrNil((String)localObject1))
        {
          localObject3 = com.tencent.mm.plugin.wepkg.b.d.eIS();
          if (!((com.tencent.mm.plugin.wepkg.b.d)localObject3).jQO)
          {
            localObject1 = localObject2;
            if (bs.isNullOrNil((String)localObject1))
            {
              localObject2 = f.eIT();
              if (((f)localObject2).jQO)
              {
                ac.i("MicroMsg.Wepkg.WepkgVersionStorage", "WepkgVersionRecord resetAutoDownloadCount ret:%s", new Object[] { Boolean.valueOf(((f)localObject2).execSQL("WepkgVersion", String.format("update %s set %s=0", new Object[] { "WepkgVersion", "autoDownloadCount" }))) });
                ac.i("MicroMsg.Wepkg.WepkgVersionStorage", "WepkgPreloadFilesRecord resetAutoDownloadCount ret:%s", new Object[] { Boolean.valueOf(((f)localObject2).execSQL("WepkgPreloadFiles", String.format("update %s set %s=0", new Object[] { "WepkgPreloadFiles", "autoDownloadCount" }))) });
              }
            }
            this.DaU.fYR = ((String)localObject1);
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
    for (i = bs.jk(i - 1, 0);; i = 0)
    {
      ((Cursor)localObject3).move(i);
      localObject4 = new e();
      ((e)localObject4).convertFrom((Cursor)localObject3);
      ((Cursor)localObject3).close();
      ((f)localObject1).aFb(((e)localObject4).field_pkgId);
      ac.i("MicroMsg.Wepkg.WepkgVersionStorage", "randomNeedDownloadPkgid exist record in DB, pkgid:%s, version:%s, bigPackageReady:false, preloadFilesAtomic:true", new Object[] { ((e)localObject4).field_pkgId, ((e)localObject4).field_version });
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
      for (i = bs.jk(i - 1, 0);; i = 0)
      {
        ((Cursor)localObject3).move(i);
        localObject4 = new e();
        ((e)localObject4).convertFrom((Cursor)localObject3);
        ((Cursor)localObject3).close();
        ((f)localObject1).aFb(((e)localObject4).field_pkgId);
        ac.i("MicroMsg.Wepkg.WepkgVersionStorage", "randomNeedDownloadPkgid exist record in DB, pkgid:%s, version:%s, bigPackageReady:false, preloadFilesAtomic:false", new Object[] { ((e)localObject4).field_pkgId, ((e)localObject4).field_version });
        localObject1 = ((e)localObject4).field_pkgId;
        break label1387;
        ((Cursor)localObject3).close();
        ac.i("MicroMsg.Wepkg.WepkgVersionStorage", "randomNeedDownloadPkgid no download record in DB");
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
        for (i = bs.jk(i - 1, 0);; i = 0)
        {
          ((Cursor)localObject4).move(i);
          localObject1 = new com.tencent.mm.plugin.wepkg.b.c();
          ((com.tencent.mm.plugin.wepkg.b.c)localObject1).convertFrom((Cursor)localObject4);
          ((Cursor)localObject4).close();
          localObject2 = ((com.tencent.mm.plugin.wepkg.b.c)localObject1).field_pkgId;
          localObject4 = ((com.tencent.mm.plugin.wepkg.b.c)localObject1).field_rid;
          if ((!((com.tencent.mm.plugin.wepkg.b.d)localObject3).jQO) || (bs.isNullOrNil((String)localObject2)) || (bs.isNullOrNil((String)localObject4))) {}
          for (;;)
          {
            ac.i("MicroMsg.Wepkg.WepkgPreloadFilesStorage", "randomNeedDownloadPkgid exist record in DB, pkgid:%s, version:%s, rid:%s", new Object[] { ((com.tencent.mm.plugin.wepkg.b.c)localObject1).field_pkgId, ((com.tencent.mm.plugin.wepkg.b.c)localObject1).field_version, ((com.tencent.mm.plugin.wepkg.b.c)localObject1).field_rid });
            localObject1 = ((com.tencent.mm.plugin.wepkg.b.c)localObject1).field_pkgId;
            break;
            ac.i("MicroMsg.Wepkg.WepkgPreloadFilesStorage", "WepkgPreloadFilesRecord addAutoDownloadCount ret:%s", new Object[] { Boolean.valueOf(((com.tencent.mm.plugin.wepkg.b.d)localObject3).execSQL("WepkgPreloadFiles", String.format("update %s set %s=%s+1 where %s='%s' and %s='%s'", new Object[] { "WepkgPreloadFiles", "autoDownloadCount", "autoDownloadCount", "pkgId", localObject2, "rid", localObject4 }))) });
          }
          ((Cursor)localObject4).close();
          ac.i("MicroMsg.Wepkg.WepkgPreloadFilesStorage", "randomNeedDownloadPkgid no download record in DB");
          localObject1 = localObject2;
          break label1412;
          if (this.DaU == null) {
            break;
          }
          this.DaY = com.tencent.mm.plugin.wepkg.b.d.eIS().aEW(this.DaU.fYR);
          break label1102;
          if (this.DaX == null) {
            break;
          }
          localObject1 = com.tencent.mm.plugin.wepkg.b.d.eIS().kM(this.DaX.fYR, this.DaX.Dba);
          if (localObject1 != null)
          {
            this.DaX.a((com.tencent.mm.plugin.wepkg.b.c)localObject1);
            break label1102;
          }
          this.DaX = null;
          break;
          if (this.DaU == null) {
            break;
          }
          bool1 = f.eIT().aFc(this.DaU.fYR);
          break label1102;
          if (this.DaU == null) {
            break;
          }
          localObject1 = f.eIT().aEZ(this.DaU.fYR);
          if (localObject1 != null)
          {
            this.DaU.a((e)localObject1);
            break label1102;
          }
          this.DaU = null;
          break;
          this.DaV = f.eIT().eIV();
          break label1102;
          if (this.DaU == null) {
            break;
          }
          bool1 = f.eIT().aFd(this.DaU.fYR);
          break label1102;
          if (this.DaU == null) {
            break;
          }
          localObject1 = f.eIT();
          localObject2 = this.DaU.fYR;
          bool1 = bool2;
          if (((f)localObject1).jQO) {
            if (!bs.isNullOrNil((String)localObject2)) {
              break label2479;
            }
          }
          for (bool1 = bool2;; bool1 = true)
          {
            this.result = bool1;
            break;
            ac.i("MicroMsg.Wepkg.WepkgVersionStorage", "WepkgVersionRecord addTotalDownloadCount ret:%s", new Object[] { Boolean.valueOf(((f)localObject1).execSQL("WepkgVersion", String.format("update %s set %s=%s+1 where %s='%s'", new Object[] { "WepkgVersion", "totalDownloadCount", "totalDownloadCount", "pkgId", localObject2 }))) });
          }
          if (this.DaU == null) {
            break;
          }
          localObject1 = f.eIT();
          localObject2 = this.DaU.fYR;
          if ((!((f)localObject1).jQO) || (bs.isNullOrNil((String)localObject2))) {}
          for (bool1 = false;; bool1 = bool3)
          {
            this.result = bool1;
            break;
            ac.i("MicroMsg.Wepkg.WepkgVersionStorage", "WepkgVersionRecord addPackageDownloadCount ret:%s", new Object[] { Boolean.valueOf(((f)localObject1).execSQL("WepkgVersion", String.format("update %s set %s=%s+1 where %s='%s'", new Object[] { "WepkgVersion", "packageDownloadCount", "packageDownloadCount", "pkgId", localObject2 }))) });
          }
          if (this.DaU == null) {
            break;
          }
          localObject1 = f.eIT();
          localObject2 = this.DaU.fYR;
          if ((!((f)localObject1).jQO) || (bs.isNullOrNil((String)localObject2))) {}
          for (bool1 = false;; bool1 = bool4)
          {
            this.result = bool1;
            break;
            ac.i("MicroMsg.Wepkg.WepkgVersionStorage", "WepkgVersionRecord resetPackageDownloadCount ret:%s", new Object[] { Boolean.valueOf(((f)localObject1).execSQL("WepkgVersion", String.format("update %s set %s=0 where %s='%s'", new Object[] { "WepkgVersion", "packageDownloadCount", "pkgId", localObject2 }))) });
          }
          if (this.DaX == null) {
            break;
          }
          localObject1 = com.tencent.mm.plugin.wepkg.b.d.eIS();
          localObject2 = this.DaX.fYR;
          localObject3 = this.DaX.Dba;
          if ((!((com.tencent.mm.plugin.wepkg.b.d)localObject1).jQO) || (bs.isNullOrNil((String)localObject2)) || (bs.isNullOrNil((String)localObject3))) {}
          for (bool1 = false;; bool1 = bool5)
          {
            this.result = bool1;
            break;
            ac.i("MicroMsg.Wepkg.WepkgPreloadFilesStorage", "WepkgPreloadFilesRecord addFileDownloadCount ret:%s", new Object[] { Boolean.valueOf(((com.tencent.mm.plugin.wepkg.b.d)localObject1).execSQL("WepkgPreloadFiles", String.format("update %s set %s=%s+1 where %s='%s' and %s='%s'", new Object[] { "WepkgPreloadFiles", "fileDownloadCount", "fileDownloadCount", "pkgId", localObject2, "rid", localObject3 }))) });
          }
          if (this.DaX == null) {
            break;
          }
          localObject1 = com.tencent.mm.plugin.wepkg.b.d.eIS();
          localObject2 = this.DaX.fYR;
          if ((!((com.tencent.mm.plugin.wepkg.b.d)localObject1).jQO) || (bs.isNullOrNil((String)localObject2)))
          {
            bool1 = false;
            break label1102;
          }
          ac.i("MicroMsg.Wepkg.WepkgPreloadFilesStorage", "WepkgPreloadFilesRecord resetFileDownloadCount ret:%s", new Object[] { Boolean.valueOf(((com.tencent.mm.plugin.wepkg.b.d)localObject1).execSQL("WepkgPreloadFiles", String.format("update %s set %s=0 where %s='%s'", new Object[] { "WepkgPreloadFiles", "fileDownloadCount", "pkgId", localObject2 }))) });
          break label1102;
        }
        break label1412;
      }
    }
  }
  
  public final void aLr()
  {
    AppMethodBeat.i(110692);
    if (this.jWP != null) {
      this.jWP.run();
    }
    AppMethodBeat.o(110692);
  }
  
  public final void n(Parcel paramParcel)
  {
    AppMethodBeat.i(110693);
    this.CW = paramParcel.readInt();
    this.DaU = ((WepkgVersion)paramParcel.readParcelable(WepkgVersion.class.getClassLoader()));
    if (this.DaV == null) {
      this.DaV = new ArrayList();
    }
    paramParcel.readList(this.DaV, WepkgVersion.class.getClassLoader());
    this.DaX = ((WepkgPreloadFile)paramParcel.readParcelable(WepkgPreloadFile.class.getClassLoader()));
    if (this.DaY == null) {
      this.DaY = new ArrayList();
    }
    paramParcel.readList(this.DaY, WepkgPreloadFile.class.getClassLoader());
    this.DaZ = paramParcel.readString();
    AppMethodBeat.o(110693);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.wepkg.model.WepkgCrossProcessTask
 * JD-Core Version:    0.7.0.1
 */