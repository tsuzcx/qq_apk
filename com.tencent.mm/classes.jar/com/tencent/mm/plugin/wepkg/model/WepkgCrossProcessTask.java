package com.tencent.mm.plugin.wepkg.model;

import android.database.Cursor;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.m.g;
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
  public WepkgVersion BIL;
  public List<WepkgVersion> BIM;
  public WePkgDiffInfo BIN;
  public WepkgPreloadFile BIO;
  public List<WepkgPreloadFile> BIP;
  public String BIQ;
  public int BX;
  public Runnable jwt;
  
  static
  {
    AppMethodBeat.i(110695);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(110695);
  }
  
  public WepkgCrossProcessTask()
  {
    AppMethodBeat.i(110689);
    this.BX = -1;
    this.BIL = new WepkgVersion();
    this.BIM = new ArrayList();
    this.BIN = new WePkgDiffInfo();
    this.BIO = new WepkgPreloadFile();
    this.BIP = new ArrayList();
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
    paramParcel.writeInt(this.BX);
    paramParcel.writeParcelable(this.BIL, paramInt);
    if (this.BIM == null) {
      this.BIM = new ArrayList();
    }
    paramParcel.writeList(this.BIM);
    paramParcel.writeParcelable(this.BIO, paramInt);
    if (this.BIP == null) {
      this.BIP = new ArrayList();
    }
    paramParcel.writeList(this.BIP);
    paramParcel.writeString(this.BIQ);
    AppMethodBeat.o(110694);
  }
  
  public final void aEA()
  {
    AppMethodBeat.i(110692);
    if (this.jwt != null) {
      this.jwt.run();
    }
    AppMethodBeat.o(110692);
  }
  
  public final void aEz()
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
    switch (this.BX)
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
            aXw();
            AppMethodBeat.o(110691);
            return;
            this.result = true;
            continue;
            this.result = g.Ze().YQ();
            continue;
            if (this.BIL != null)
            {
              localObject1 = f.etA().azH(this.BIL.fUW);
              if (localObject1 != null)
              {
                this.BIL.a((e)localObject1);
                this.result = true;
              }
              else
              {
                this.BIL = null;
                continue;
                if (this.BIL != null)
                {
                  this.result = f.etA().azJ(this.BIL.fUW);
                  continue;
                  if (this.BIL != null)
                  {
                    this.result = f.etA().a(this.BIL.fUW, this.BIL.BJt, this.BIL.BJu, this.BIL.BJv);
                    continue;
                    if (this.BIL != null)
                    {
                      this.result = f.etA().A(this.BIL.fUW, this.BIL.pkgPath, this.BIL.BJA);
                      continue;
                      if (this.BIL != null)
                      {
                        this.result = f.etA().cl(this.BIL.fUW, this.BIL.BJB);
                        continue;
                        if ((this.BIL != null) && (!bt.isNullOrNil(this.BIL.fUW)))
                        {
                          localObject1 = f.etA();
                          localObject2 = this.BIL;
                          localObject3 = new e();
                          ((e)localObject3).field_pkgId = ((WepkgVersion)localObject2).fUW;
                          ((e)localObject3).field_appId = ((WepkgVersion)localObject2).appId;
                          ((e)localObject3).field_version = ((WepkgVersion)localObject2).version;
                          ((e)localObject3).field_pkgPath = ((WepkgVersion)localObject2).pkgPath;
                          ((e)localObject3).field_disableWvCache = ((WepkgVersion)localObject2).BJt;
                          ((e)localObject3).field_clearPkgTime = ((WepkgVersion)localObject2).BJu;
                          ((e)localObject3).field_checkIntervalTime = ((WepkgVersion)localObject2).BJv;
                          ((e)localObject3).field_packMethod = ((WepkgVersion)localObject2).BJw;
                          ((e)localObject3).field_domain = ((WepkgVersion)localObject2).BJx;
                          ((e)localObject3).field_md5 = ((WepkgVersion)localObject2).md5;
                          ((e)localObject3).field_downloadUrl = ((WepkgVersion)localObject2).downloadUrl;
                          ((e)localObject3).field_pkgSize = ((WepkgVersion)localObject2).BJy;
                          ((e)localObject3).field_downloadNetType = ((WepkgVersion)localObject2).BID;
                          ((e)localObject3).field_nextCheckTime = ((WepkgVersion)localObject2).BJz;
                          ((e)localObject3).field_createTime = ((WepkgVersion)localObject2).createTime;
                          ((e)localObject3).field_charset = ((WepkgVersion)localObject2).charset;
                          ((e)localObject3).field_bigPackageReady = ((WepkgVersion)localObject2).BJA;
                          ((e)localObject3).field_preloadFilesReady = ((WepkgVersion)localObject2).BJB;
                          ((e)localObject3).field_preloadFilesAtomic = ((WepkgVersion)localObject2).BJC;
                          ((e)localObject3).field_totalDownloadCount = ((WepkgVersion)localObject2).BJD;
                          ((e)localObject3).field_downloadTriggerType = ((WepkgVersion)localObject2).dER;
                          ((f)localObject1).a((e)localObject3, this.BIN);
                          if (!bt.gL(this.BIP))
                          {
                            localObject1 = this.BIP.iterator();
                            while (((Iterator)localObject1).hasNext())
                            {
                              localObject2 = (WepkgPreloadFile)((Iterator)localObject1).next();
                              if (localObject2 != null)
                              {
                                localObject3 = com.tencent.mm.plugin.wepkg.b.d.etz();
                                localObject4 = new com.tencent.mm.plugin.wepkg.b.c();
                                ((com.tencent.mm.plugin.wepkg.b.c)localObject4).field_key = ((WepkgPreloadFile)localObject2).key;
                                ((com.tencent.mm.plugin.wepkg.b.c)localObject4).field_pkgId = ((WepkgPreloadFile)localObject2).fUW;
                                ((com.tencent.mm.plugin.wepkg.b.c)localObject4).field_version = ((WepkgPreloadFile)localObject2).version;
                                ((com.tencent.mm.plugin.wepkg.b.c)localObject4).field_filePath = ((WepkgPreloadFile)localObject2).filePath;
                                ((com.tencent.mm.plugin.wepkg.b.c)localObject4).field_rid = ((WepkgPreloadFile)localObject2).BIR;
                                ((com.tencent.mm.plugin.wepkg.b.c)localObject4).field_mimeType = ((WepkgPreloadFile)localObject2).mimeType;
                                ((com.tencent.mm.plugin.wepkg.b.c)localObject4).field_md5 = ((WepkgPreloadFile)localObject2).md5;
                                ((com.tencent.mm.plugin.wepkg.b.c)localObject4).field_downloadUrl = ((WepkgPreloadFile)localObject2).downloadUrl;
                                ((com.tencent.mm.plugin.wepkg.b.c)localObject4).field_size = ((WepkgPreloadFile)localObject2).size;
                                ((com.tencent.mm.plugin.wepkg.b.c)localObject4).field_downloadNetType = ((WepkgPreloadFile)localObject2).BID;
                                ((com.tencent.mm.plugin.wepkg.b.c)localObject4).field_completeDownload = ((WepkgPreloadFile)localObject2).BJe;
                                ((com.tencent.mm.plugin.wepkg.b.c)localObject4).field_createTime = ((WepkgPreloadFile)localObject2).createTime;
                                if (((com.tencent.mm.plugin.wepkg.b.d)localObject3).jqw) {
                                  if (((com.tencent.mm.plugin.wepkg.b.d)localObject3).kq(((com.tencent.mm.plugin.wepkg.b.c)localObject4).field_pkgId, ((com.tencent.mm.plugin.wepkg.b.c)localObject4).field_rid) == null)
                                  {
                                    ((com.tencent.mm.plugin.wepkg.b.c)localObject4).field_createTime = com.tencent.mm.plugin.wepkg.utils.d.bqp();
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
        } while ((this.BIL == null) || (bt.isNullOrNil(this.BIL.fUW)));
        for (;;)
        {
          try
          {
            localObject2 = com.tencent.mm.plugin.wepkg.b.d.etz();
            localObject4 = this.BIL.fUW;
            if ((((com.tencent.mm.plugin.wepkg.b.d)localObject2).jqw) || (!bt.isNullOrNil((String)localObject4))) {
              continue;
            }
            this.BIP = ((List)localObject1);
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
            if (this.BIO == null) {
              break;
            }
            bool1 = com.tencent.mm.plugin.wepkg.b.d.etz().f(this.BIO.fUW, this.BIO.BIR, this.BIO.filePath, this.BIO.BJe);
          }
        }
      } while (this.BIL == null);
      localObject1 = f.etA();
      if (!((f)localObject1).jqw) {
        localObject1 = null;
      }
      label1412:
      for (;;)
      {
        label1387:
        if (bt.isNullOrNil((String)localObject1))
        {
          localObject3 = com.tencent.mm.plugin.wepkg.b.d.etz();
          if (!((com.tencent.mm.plugin.wepkg.b.d)localObject3).jqw)
          {
            localObject1 = localObject2;
            if (bt.isNullOrNil((String)localObject1))
            {
              localObject2 = f.etA();
              if (((f)localObject2).jqw)
              {
                ad.i("MicroMsg.Wepkg.WepkgVersionStorage", "WepkgVersionRecord resetAutoDownloadCount ret:%s", new Object[] { Boolean.valueOf(((f)localObject2).execSQL("WepkgVersion", String.format("update %s set %s=0", new Object[] { "WepkgVersion", "autoDownloadCount" }))) });
                ad.i("MicroMsg.Wepkg.WepkgVersionStorage", "WepkgPreloadFilesRecord resetAutoDownloadCount ret:%s", new Object[] { Boolean.valueOf(((f)localObject2).execSQL("WepkgPreloadFiles", String.format("update %s set %s=0", new Object[] { "WepkgPreloadFiles", "autoDownloadCount" }))) });
              }
            }
            this.BIL.fUW = ((String)localObject1);
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
    for (i = bt.iX(i - 1, 0);; i = 0)
    {
      ((Cursor)localObject3).move(i);
      localObject4 = new e();
      ((e)localObject4).convertFrom((Cursor)localObject3);
      ((Cursor)localObject3).close();
      ((f)localObject1).azK(((e)localObject4).field_pkgId);
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
      for (i = bt.iX(i - 1, 0);; i = 0)
      {
        ((Cursor)localObject3).move(i);
        localObject4 = new e();
        ((e)localObject4).convertFrom((Cursor)localObject3);
        ((Cursor)localObject3).close();
        ((f)localObject1).azK(((e)localObject4).field_pkgId);
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
        for (i = bt.iX(i - 1, 0);; i = 0)
        {
          ((Cursor)localObject4).move(i);
          localObject1 = new com.tencent.mm.plugin.wepkg.b.c();
          ((com.tencent.mm.plugin.wepkg.b.c)localObject1).convertFrom((Cursor)localObject4);
          ((Cursor)localObject4).close();
          localObject2 = ((com.tencent.mm.plugin.wepkg.b.c)localObject1).field_pkgId;
          localObject4 = ((com.tencent.mm.plugin.wepkg.b.c)localObject1).field_rid;
          if ((!((com.tencent.mm.plugin.wepkg.b.d)localObject3).jqw) || (bt.isNullOrNil((String)localObject2)) || (bt.isNullOrNil((String)localObject4))) {}
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
          if (this.BIL == null) {
            break;
          }
          this.BIP = com.tencent.mm.plugin.wepkg.b.d.etz().azF(this.BIL.fUW);
          break label1102;
          if (this.BIO == null) {
            break;
          }
          localObject1 = com.tencent.mm.plugin.wepkg.b.d.etz().kq(this.BIO.fUW, this.BIO.BIR);
          if (localObject1 != null)
          {
            this.BIO.a((com.tencent.mm.plugin.wepkg.b.c)localObject1);
            break label1102;
          }
          this.BIO = null;
          break;
          if (this.BIL == null) {
            break;
          }
          bool1 = f.etA().azL(this.BIL.fUW);
          break label1102;
          if (this.BIL == null) {
            break;
          }
          localObject1 = f.etA().azI(this.BIL.fUW);
          if (localObject1 != null)
          {
            this.BIL.a((e)localObject1);
            break label1102;
          }
          this.BIL = null;
          break;
          this.BIM = f.etA().etC();
          break label1102;
          if (this.BIL == null) {
            break;
          }
          bool1 = f.etA().azM(this.BIL.fUW);
          break label1102;
          if (this.BIL == null) {
            break;
          }
          localObject1 = f.etA();
          localObject2 = this.BIL.fUW;
          bool1 = bool2;
          if (((f)localObject1).jqw) {
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
          if (this.BIL == null) {
            break;
          }
          localObject1 = f.etA();
          localObject2 = this.BIL.fUW;
          if ((!((f)localObject1).jqw) || (bt.isNullOrNil((String)localObject2))) {}
          for (bool1 = false;; bool1 = bool3)
          {
            this.result = bool1;
            break;
            ad.i("MicroMsg.Wepkg.WepkgVersionStorage", "WepkgVersionRecord addPackageDownloadCount ret:%s", new Object[] { Boolean.valueOf(((f)localObject1).execSQL("WepkgVersion", String.format("update %s set %s=%s+1 where %s='%s'", new Object[] { "WepkgVersion", "packageDownloadCount", "packageDownloadCount", "pkgId", localObject2 }))) });
          }
          if (this.BIL == null) {
            break;
          }
          localObject1 = f.etA();
          localObject2 = this.BIL.fUW;
          if ((!((f)localObject1).jqw) || (bt.isNullOrNil((String)localObject2))) {}
          for (bool1 = false;; bool1 = bool4)
          {
            this.result = bool1;
            break;
            ad.i("MicroMsg.Wepkg.WepkgVersionStorage", "WepkgVersionRecord resetPackageDownloadCount ret:%s", new Object[] { Boolean.valueOf(((f)localObject1).execSQL("WepkgVersion", String.format("update %s set %s=0 where %s='%s'", new Object[] { "WepkgVersion", "packageDownloadCount", "pkgId", localObject2 }))) });
          }
          if (this.BIO == null) {
            break;
          }
          localObject1 = com.tencent.mm.plugin.wepkg.b.d.etz();
          localObject2 = this.BIO.fUW;
          localObject3 = this.BIO.BIR;
          if ((!((com.tencent.mm.plugin.wepkg.b.d)localObject1).jqw) || (bt.isNullOrNil((String)localObject2)) || (bt.isNullOrNil((String)localObject3))) {}
          for (bool1 = false;; bool1 = bool5)
          {
            this.result = bool1;
            break;
            ad.i("MicroMsg.Wepkg.WepkgPreloadFilesStorage", "WepkgPreloadFilesRecord addFileDownloadCount ret:%s", new Object[] { Boolean.valueOf(((com.tencent.mm.plugin.wepkg.b.d)localObject1).execSQL("WepkgPreloadFiles", String.format("update %s set %s=%s+1 where %s='%s' and %s='%s'", new Object[] { "WepkgPreloadFiles", "fileDownloadCount", "fileDownloadCount", "pkgId", localObject2, "rid", localObject3 }))) });
          }
          if (this.BIO == null) {
            break;
          }
          localObject1 = com.tencent.mm.plugin.wepkg.b.d.etz();
          localObject2 = this.BIO.fUW;
          if ((!((com.tencent.mm.plugin.wepkg.b.d)localObject1).jqw) || (bt.isNullOrNil((String)localObject2)))
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
  
  public final void m(Parcel paramParcel)
  {
    AppMethodBeat.i(110693);
    this.BX = paramParcel.readInt();
    this.BIL = ((WepkgVersion)paramParcel.readParcelable(WepkgVersion.class.getClassLoader()));
    if (this.BIM == null) {
      this.BIM = new ArrayList();
    }
    paramParcel.readList(this.BIM, WepkgVersion.class.getClassLoader());
    this.BIO = ((WepkgPreloadFile)paramParcel.readParcelable(WepkgPreloadFile.class.getClassLoader()));
    if (this.BIP == null) {
      this.BIP = new ArrayList();
    }
    paramParcel.readList(this.BIP, WepkgPreloadFile.class.getClassLoader());
    this.BIQ = paramParcel.readString();
    AppMethodBeat.o(110693);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.wepkg.model.WepkgCrossProcessTask
 * JD-Core Version:    0.7.0.1
 */