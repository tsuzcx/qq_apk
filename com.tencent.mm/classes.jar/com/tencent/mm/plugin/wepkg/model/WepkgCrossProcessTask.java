package com.tencent.mm.plugin.wepkg.model;

import android.database.Cursor;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.n.g;
import com.tencent.mm.plugin.wepkg.b.e;
import com.tencent.mm.plugin.wepkg.b.f;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class WepkgCrossProcessTask
  extends BaseWepkgProcessTask
{
  public static final Parcelable.Creator<WepkgCrossProcessTask> CREATOR;
  public WepkgVersion EET;
  public List<WepkgVersion> EEU;
  public WePkgDiffInfo EEV;
  public WepkgPreloadFile EEW;
  public List<WepkgPreloadFile> EEX;
  public String EEY;
  public int EN;
  public Runnable krg;
  
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
    this.EET = new WepkgVersion();
    this.EEU = new ArrayList();
    this.EEV = new WePkgDiffInfo();
    this.EEW = new WepkgPreloadFile();
    this.EEX = new ArrayList();
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
    paramParcel.writeParcelable(this.EET, paramInt);
    if (this.EEU == null) {
      this.EEU = new ArrayList();
    }
    paramParcel.writeList(this.EEU);
    paramParcel.writeParcelable(this.EEW, paramInt);
    if (this.EEX == null) {
      this.EEX = new ArrayList();
    }
    paramParcel.writeList(this.EEX);
    paramParcel.writeString(this.EEY);
    AppMethodBeat.o(110694);
  }
  
  public final void aOA()
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
            bhX();
            AppMethodBeat.o(110691);
            return;
            this.result = true;
            continue;
            this.result = g.acB().aco();
            continue;
            if (this.EET != null)
            {
              localObject1 = f.eXN().aKy(this.EET.gsn);
              if (localObject1 != null)
              {
                this.EET.a((e)localObject1);
                this.result = true;
              }
              else
              {
                this.EET = null;
                continue;
                if (this.EET != null)
                {
                  this.result = f.eXN().aKA(this.EET.gsn);
                  continue;
                  if (this.EET != null)
                  {
                    this.result = f.eXN().a(this.EET.gsn, this.EET.EFB, this.EET.EFC, this.EET.EFD);
                    continue;
                    if (this.EET != null)
                    {
                      this.result = f.eXN().A(this.EET.gsn, this.EET.pkgPath, this.EET.EFI);
                      continue;
                      if (this.EET != null)
                      {
                        this.result = f.eXN().cw(this.EET.gsn, this.EET.EFJ);
                        continue;
                        if ((this.EET != null) && (!bt.isNullOrNil(this.EET.gsn)))
                        {
                          localObject1 = f.eXN();
                          localObject2 = this.EET;
                          localObject3 = new e();
                          ((e)localObject3).field_pkgId = ((WepkgVersion)localObject2).gsn;
                          ((e)localObject3).field_appId = ((WepkgVersion)localObject2).appId;
                          ((e)localObject3).field_version = ((WepkgVersion)localObject2).version;
                          ((e)localObject3).field_pkgPath = ((WepkgVersion)localObject2).pkgPath;
                          ((e)localObject3).field_disableWvCache = ((WepkgVersion)localObject2).EFB;
                          ((e)localObject3).field_clearPkgTime = ((WepkgVersion)localObject2).EFC;
                          ((e)localObject3).field_checkIntervalTime = ((WepkgVersion)localObject2).EFD;
                          ((e)localObject3).field_packMethod = ((WepkgVersion)localObject2).EFE;
                          ((e)localObject3).field_domain = ((WepkgVersion)localObject2).EFF;
                          ((e)localObject3).field_md5 = ((WepkgVersion)localObject2).md5;
                          ((e)localObject3).field_downloadUrl = ((WepkgVersion)localObject2).downloadUrl;
                          ((e)localObject3).field_pkgSize = ((WepkgVersion)localObject2).EFG;
                          ((e)localObject3).field_downloadNetType = ((WepkgVersion)localObject2).EEL;
                          ((e)localObject3).field_nextCheckTime = ((WepkgVersion)localObject2).EFH;
                          ((e)localObject3).field_createTime = ((WepkgVersion)localObject2).createTime;
                          ((e)localObject3).field_charset = ((WepkgVersion)localObject2).charset;
                          ((e)localObject3).field_bigPackageReady = ((WepkgVersion)localObject2).EFI;
                          ((e)localObject3).field_preloadFilesReady = ((WepkgVersion)localObject2).EFJ;
                          ((e)localObject3).field_preloadFilesAtomic = ((WepkgVersion)localObject2).EFK;
                          ((e)localObject3).field_totalDownloadCount = ((WepkgVersion)localObject2).EFL;
                          ((e)localObject3).field_downloadTriggerType = ((WepkgVersion)localObject2).dOQ;
                          ((f)localObject1).a((e)localObject3, this.EEV);
                          if (!bt.hj(this.EEX))
                          {
                            localObject1 = this.EEX.iterator();
                            while (((Iterator)localObject1).hasNext())
                            {
                              localObject2 = (WepkgPreloadFile)((Iterator)localObject1).next();
                              if (localObject2 != null)
                              {
                                localObject3 = com.tencent.mm.plugin.wepkg.b.d.eXM();
                                localObject4 = new com.tencent.mm.plugin.wepkg.b.c();
                                ((com.tencent.mm.plugin.wepkg.b.c)localObject4).field_key = ((WepkgPreloadFile)localObject2).key;
                                ((com.tencent.mm.plugin.wepkg.b.c)localObject4).field_pkgId = ((WepkgPreloadFile)localObject2).gsn;
                                ((com.tencent.mm.plugin.wepkg.b.c)localObject4).field_version = ((WepkgPreloadFile)localObject2).version;
                                ((com.tencent.mm.plugin.wepkg.b.c)localObject4).field_filePath = ((WepkgPreloadFile)localObject2).filePath;
                                ((com.tencent.mm.plugin.wepkg.b.c)localObject4).field_rid = ((WepkgPreloadFile)localObject2).EEZ;
                                ((com.tencent.mm.plugin.wepkg.b.c)localObject4).field_mimeType = ((WepkgPreloadFile)localObject2).mimeType;
                                ((com.tencent.mm.plugin.wepkg.b.c)localObject4).field_md5 = ((WepkgPreloadFile)localObject2).md5;
                                ((com.tencent.mm.plugin.wepkg.b.c)localObject4).field_downloadUrl = ((WepkgPreloadFile)localObject2).downloadUrl;
                                ((com.tencent.mm.plugin.wepkg.b.c)localObject4).field_size = ((WepkgPreloadFile)localObject2).size;
                                ((com.tencent.mm.plugin.wepkg.b.c)localObject4).field_downloadNetType = ((WepkgPreloadFile)localObject2).EEL;
                                ((com.tencent.mm.plugin.wepkg.b.c)localObject4).field_completeDownload = ((WepkgPreloadFile)localObject2).EFm;
                                ((com.tencent.mm.plugin.wepkg.b.c)localObject4).field_createTime = ((WepkgPreloadFile)localObject2).createTime;
                                if (((com.tencent.mm.plugin.wepkg.b.d)localObject3).kld) {
                                  if (((com.tencent.mm.plugin.wepkg.b.d)localObject3).lj(((com.tencent.mm.plugin.wepkg.b.c)localObject4).field_pkgId, ((com.tencent.mm.plugin.wepkg.b.c)localObject4).field_rid) == null)
                                  {
                                    ((com.tencent.mm.plugin.wepkg.b.c)localObject4).field_createTime = com.tencent.mm.plugin.wepkg.utils.d.currentTime();
                                    bool1 = ((com.tencent.mm.plugin.wepkg.b.d)localObject3).insert((com.tencent.mm.sdk.e.c)localObject4);
                                    ad.i("MicroMsg.Wepkg.WepkgPreloadFilesStorage", "insertPreloadFile pkgid:%s, version:%s, rid:%s, ret:%s", new Object[] { ((com.tencent.mm.plugin.wepkg.b.c)localObject4).field_pkgId, ((com.tencent.mm.plugin.wepkg.b.c)localObject4).field_version, ((com.tencent.mm.plugin.wepkg.b.c)localObject4).field_rid, Boolean.valueOf(bool1) });
                                  }
                                  else
                                  {
                                    bool1 = ((com.tencent.mm.plugin.wepkg.b.d)localObject3).replace((com.tencent.mm.sdk.e.c)localObject4);
                                    ad.i("MicroMsg.Wepkg.WepkgPreloadFilesStorage", "relacePreloadFile pkgid:%s, version:%s, rid:%s, ret:%s", new Object[] { ((com.tencent.mm.plugin.wepkg.b.c)localObject4).field_pkgId, ((com.tencent.mm.plugin.wepkg.b.c)localObject4).field_version, ((com.tencent.mm.plugin.wepkg.b.c)localObject4).field_rid, Boolean.valueOf(bool1) });
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
        } while ((this.EET == null) || (bt.isNullOrNil(this.EET.gsn)));
        for (;;)
        {
          try
          {
            localObject2 = com.tencent.mm.plugin.wepkg.b.d.eXM();
            localObject4 = this.EET.gsn;
            if ((((com.tencent.mm.plugin.wepkg.b.d)localObject2).kld) || (!bt.isNullOrNil((String)localObject4))) {
              continue;
            }
            this.EEX = ((List)localObject1);
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
          ad.i("MicroMsg.Wepkg.WepkgPreloadFilesStorage", "getNeedDownloadPreLoadFileList queryStr:%s", new Object[] { localObject3 });
          if (localObject2 == null)
          {
            ad.i("MicroMsg.Wepkg.WepkgPreloadFilesStorage", "cursor is null");
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
              ad.i("MicroMsg.Wepkg.WepkgPreloadFilesStorage", "record list size:%s", new Object[] { Integer.valueOf(((List)localObject1).size()) });
            }
          }
          else
          {
            ((Cursor)localObject2).close();
            ad.i("MicroMsg.Wepkg.WepkgPreloadFilesStorage", "no record");
            continue;
            if (this.EEW == null) {
              break;
            }
            bool1 = com.tencent.mm.plugin.wepkg.b.d.eXM().f(this.EEW.gsn, this.EEW.EEZ, this.EEW.filePath, this.EEW.EFm);
          }
        }
      } while (this.EET == null);
      localObject1 = f.eXN();
      if (!((f)localObject1).kld) {
        localObject1 = null;
      }
      label1412:
      for (;;)
      {
        label1387:
        if (bt.isNullOrNil((String)localObject1))
        {
          localObject3 = com.tencent.mm.plugin.wepkg.b.d.eXM();
          if (!((com.tencent.mm.plugin.wepkg.b.d)localObject3).kld)
          {
            localObject1 = localObject2;
            if (bt.isNullOrNil((String)localObject1))
            {
              localObject2 = f.eXN();
              if (((f)localObject2).kld)
              {
                ad.i("MicroMsg.Wepkg.WepkgVersionStorage", "WepkgVersionRecord resetAutoDownloadCount ret:%s", new Object[] { Boolean.valueOf(((f)localObject2).execSQL("WepkgVersion", String.format("update %s set %s=0", new Object[] { "WepkgVersion", "autoDownloadCount" }))) });
                ad.i("MicroMsg.Wepkg.WepkgVersionStorage", "WepkgPreloadFilesRecord resetAutoDownloadCount ret:%s", new Object[] { Boolean.valueOf(((f)localObject2).execSQL("WepkgPreloadFiles", String.format("update %s set %s=0", new Object[] { "WepkgPreloadFiles", "autoDownloadCount" }))) });
              }
            }
            this.EET.gsn = ((String)localObject1);
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
    for (i = bt.jw(i - 1, 0);; i = 0)
    {
      ((Cursor)localObject3).move(i);
      localObject4 = new e();
      ((e)localObject4).convertFrom((Cursor)localObject3);
      ((Cursor)localObject3).close();
      ((f)localObject1).aKB(((e)localObject4).field_pkgId);
      ad.i("MicroMsg.Wepkg.WepkgVersionStorage", "randomNeedDownloadPkgid exist record in DB, pkgid:%s, version:%s, bigPackageReady:false, preloadFilesAtomic:true", new Object[] { ((e)localObject4).field_pkgId, ((e)localObject4).field_version });
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
      for (i = bt.jw(i - 1, 0);; i = 0)
      {
        ((Cursor)localObject3).move(i);
        localObject4 = new e();
        ((e)localObject4).convertFrom((Cursor)localObject3);
        ((Cursor)localObject3).close();
        ((f)localObject1).aKB(((e)localObject4).field_pkgId);
        ad.i("MicroMsg.Wepkg.WepkgVersionStorage", "randomNeedDownloadPkgid exist record in DB, pkgid:%s, version:%s, bigPackageReady:false, preloadFilesAtomic:false", new Object[] { ((e)localObject4).field_pkgId, ((e)localObject4).field_version });
        localObject1 = ((e)localObject4).field_pkgId;
        break label1387;
        ((Cursor)localObject3).close();
        ad.i("MicroMsg.Wepkg.WepkgVersionStorage", "randomNeedDownloadPkgid no download record in DB");
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
        for (i = bt.jw(i - 1, 0);; i = 0)
        {
          ((Cursor)localObject4).move(i);
          localObject1 = new com.tencent.mm.plugin.wepkg.b.c();
          ((com.tencent.mm.plugin.wepkg.b.c)localObject1).convertFrom((Cursor)localObject4);
          ((Cursor)localObject4).close();
          localObject2 = ((com.tencent.mm.plugin.wepkg.b.c)localObject1).field_pkgId;
          localObject4 = ((com.tencent.mm.plugin.wepkg.b.c)localObject1).field_rid;
          if ((!((com.tencent.mm.plugin.wepkg.b.d)localObject3).kld) || (bt.isNullOrNil((String)localObject2)) || (bt.isNullOrNil((String)localObject4))) {}
          for (;;)
          {
            ad.i("MicroMsg.Wepkg.WepkgPreloadFilesStorage", "randomNeedDownloadPkgid exist record in DB, pkgid:%s, version:%s, rid:%s", new Object[] { ((com.tencent.mm.plugin.wepkg.b.c)localObject1).field_pkgId, ((com.tencent.mm.plugin.wepkg.b.c)localObject1).field_version, ((com.tencent.mm.plugin.wepkg.b.c)localObject1).field_rid });
            localObject1 = ((com.tencent.mm.plugin.wepkg.b.c)localObject1).field_pkgId;
            break;
            ad.i("MicroMsg.Wepkg.WepkgPreloadFilesStorage", "WepkgPreloadFilesRecord addAutoDownloadCount ret:%s", new Object[] { Boolean.valueOf(((com.tencent.mm.plugin.wepkg.b.d)localObject3).execSQL("WepkgPreloadFiles", String.format("update %s set %s=%s+1 where %s='%s' and %s='%s'", new Object[] { "WepkgPreloadFiles", "autoDownloadCount", "autoDownloadCount", "pkgId", localObject2, "rid", localObject4 }))) });
          }
          ((Cursor)localObject4).close();
          ad.i("MicroMsg.Wepkg.WepkgPreloadFilesStorage", "randomNeedDownloadPkgid no download record in DB");
          localObject1 = localObject2;
          break label1412;
          if (this.EET == null) {
            break;
          }
          this.EEX = com.tencent.mm.plugin.wepkg.b.d.eXM().aKw(this.EET.gsn);
          break label1102;
          if (this.EEW == null) {
            break;
          }
          localObject1 = com.tencent.mm.plugin.wepkg.b.d.eXM().lj(this.EEW.gsn, this.EEW.EEZ);
          if (localObject1 != null)
          {
            this.EEW.a((com.tencent.mm.plugin.wepkg.b.c)localObject1);
            break label1102;
          }
          this.EEW = null;
          break;
          if (this.EET == null) {
            break;
          }
          bool1 = f.eXN().aKC(this.EET.gsn);
          break label1102;
          if (this.EET == null) {
            break;
          }
          localObject1 = f.eXN().aKz(this.EET.gsn);
          if (localObject1 != null)
          {
            this.EET.a((e)localObject1);
            break label1102;
          }
          this.EET = null;
          break;
          this.EEU = f.eXN().eXP();
          break label1102;
          if (this.EET == null) {
            break;
          }
          bool1 = f.eXN().aKD(this.EET.gsn);
          break label1102;
          if (this.EET == null) {
            break;
          }
          localObject1 = f.eXN();
          localObject2 = this.EET.gsn;
          bool1 = bool2;
          if (((f)localObject1).kld) {
            if (!bt.isNullOrNil((String)localObject2)) {
              break label2479;
            }
          }
          for (bool1 = bool2;; bool1 = true)
          {
            this.result = bool1;
            break;
            ad.i("MicroMsg.Wepkg.WepkgVersionStorage", "WepkgVersionRecord addTotalDownloadCount ret:%s", new Object[] { Boolean.valueOf(((f)localObject1).execSQL("WepkgVersion", String.format("update %s set %s=%s+1 where %s='%s'", new Object[] { "WepkgVersion", "totalDownloadCount", "totalDownloadCount", "pkgId", localObject2 }))) });
          }
          if (this.EET == null) {
            break;
          }
          localObject1 = f.eXN();
          localObject2 = this.EET.gsn;
          if ((!((f)localObject1).kld) || (bt.isNullOrNil((String)localObject2))) {}
          for (bool1 = false;; bool1 = bool3)
          {
            this.result = bool1;
            break;
            ad.i("MicroMsg.Wepkg.WepkgVersionStorage", "WepkgVersionRecord addPackageDownloadCount ret:%s", new Object[] { Boolean.valueOf(((f)localObject1).execSQL("WepkgVersion", String.format("update %s set %s=%s+1 where %s='%s'", new Object[] { "WepkgVersion", "packageDownloadCount", "packageDownloadCount", "pkgId", localObject2 }))) });
          }
          if (this.EET == null) {
            break;
          }
          localObject1 = f.eXN();
          localObject2 = this.EET.gsn;
          if ((!((f)localObject1).kld) || (bt.isNullOrNil((String)localObject2))) {}
          for (bool1 = false;; bool1 = bool4)
          {
            this.result = bool1;
            break;
            ad.i("MicroMsg.Wepkg.WepkgVersionStorage", "WepkgVersionRecord resetPackageDownloadCount ret:%s", new Object[] { Boolean.valueOf(((f)localObject1).execSQL("WepkgVersion", String.format("update %s set %s=0 where %s='%s'", new Object[] { "WepkgVersion", "packageDownloadCount", "pkgId", localObject2 }))) });
          }
          if (this.EEW == null) {
            break;
          }
          localObject1 = com.tencent.mm.plugin.wepkg.b.d.eXM();
          localObject2 = this.EEW.gsn;
          localObject3 = this.EEW.EEZ;
          if ((!((com.tencent.mm.plugin.wepkg.b.d)localObject1).kld) || (bt.isNullOrNil((String)localObject2)) || (bt.isNullOrNil((String)localObject3))) {}
          for (bool1 = false;; bool1 = bool5)
          {
            this.result = bool1;
            break;
            ad.i("MicroMsg.Wepkg.WepkgPreloadFilesStorage", "WepkgPreloadFilesRecord addFileDownloadCount ret:%s", new Object[] { Boolean.valueOf(((com.tencent.mm.plugin.wepkg.b.d)localObject1).execSQL("WepkgPreloadFiles", String.format("update %s set %s=%s+1 where %s='%s' and %s='%s'", new Object[] { "WepkgPreloadFiles", "fileDownloadCount", "fileDownloadCount", "pkgId", localObject2, "rid", localObject3 }))) });
          }
          if (this.EEW == null) {
            break;
          }
          localObject1 = com.tencent.mm.plugin.wepkg.b.d.eXM();
          localObject2 = this.EEW.gsn;
          if ((!((com.tencent.mm.plugin.wepkg.b.d)localObject1).kld) || (bt.isNullOrNil((String)localObject2)))
          {
            bool1 = false;
            break label1102;
          }
          ad.i("MicroMsg.Wepkg.WepkgPreloadFilesStorage", "WepkgPreloadFilesRecord resetFileDownloadCount ret:%s", new Object[] { Boolean.valueOf(((com.tencent.mm.plugin.wepkg.b.d)localObject1).execSQL("WepkgPreloadFiles", String.format("update %s set %s=0 where %s='%s'", new Object[] { "WepkgPreloadFiles", "fileDownloadCount", "pkgId", localObject2 }))) });
          break label1102;
        }
        break label1412;
      }
    }
  }
  
  public final void aOB()
  {
    AppMethodBeat.i(110692);
    if (this.krg != null) {
      this.krg.run();
    }
    AppMethodBeat.o(110692);
  }
  
  public final void n(Parcel paramParcel)
  {
    AppMethodBeat.i(110693);
    this.EN = paramParcel.readInt();
    this.EET = ((WepkgVersion)paramParcel.readParcelable(WepkgVersion.class.getClassLoader()));
    if (this.EEU == null) {
      this.EEU = new ArrayList();
    }
    paramParcel.readList(this.EEU, WepkgVersion.class.getClassLoader());
    this.EEW = ((WepkgPreloadFile)paramParcel.readParcelable(WepkgPreloadFile.class.getClassLoader()));
    if (this.EEX == null) {
      this.EEX = new ArrayList();
    }
    paramParcel.readList(this.EEX, WepkgPreloadFile.class.getClassLoader());
    this.EEY = paramParcel.readString();
    AppMethodBeat.o(110693);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wepkg.model.WepkgCrossProcessTask
 * JD-Core Version:    0.7.0.1
 */