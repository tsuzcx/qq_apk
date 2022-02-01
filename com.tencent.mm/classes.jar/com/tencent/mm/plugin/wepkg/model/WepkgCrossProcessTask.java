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
  public WepkgVersion QMA;
  public List<WepkgVersion> QMB;
  public WePkgDiffInfo QMC;
  public WepkgPreloadFile QMD;
  public List<WepkgPreloadFile> QME;
  public String QMF;
  public int Vh;
  public Runnable otv;
  
  static
  {
    AppMethodBeat.i(110695);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(110695);
  }
  
  public WepkgCrossProcessTask()
  {
    AppMethodBeat.i(110689);
    this.Vh = -1;
    this.QMA = new WepkgVersion();
    this.QMB = new ArrayList();
    this.QMC = new WePkgDiffInfo();
    this.QMD = new WepkgPreloadFile();
    this.QME = new ArrayList();
    AppMethodBeat.o(110689);
  }
  
  private WepkgCrossProcessTask(Parcel paramParcel)
  {
    AppMethodBeat.i(110690);
    f(paramParcel);
    AppMethodBeat.o(110690);
  }
  
  public final void RW()
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
    switch (this.Vh)
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
            bPt();
            AppMethodBeat.o(110691);
            return;
            this.result = true;
            continue;
            this.result = a.ewd();
            continue;
            if (this.QMA != null)
            {
              localObject1 = f.hew().bom(this.QMA.jTB);
              if (localObject1 != null)
              {
                this.QMA.a((e)localObject1);
                this.result = true;
              }
              else
              {
                this.QMA = null;
                continue;
                if (this.QMA != null)
                {
                  this.result = f.hew().boo(this.QMA.jTB);
                  continue;
                  if (this.QMA != null)
                  {
                    this.result = f.hew().a(this.QMA.jTB, this.QMA.QNi, this.QMA.QNj, this.QMA.QNk);
                    continue;
                    if (this.QMA != null)
                    {
                      this.result = f.hew().E(this.QMA.jTB, this.QMA.pkgPath, this.QMA.QNo);
                      continue;
                      if (this.QMA != null)
                      {
                        this.result = f.hew().dj(this.QMA.jTB, this.QMA.QNp);
                        continue;
                        if ((this.QMA != null) && (!Util.isNullOrNil(this.QMA.jTB)))
                        {
                          localObject1 = f.hew();
                          localObject2 = this.QMA;
                          localObject3 = new e();
                          ((e)localObject3).field_pkgId = ((WepkgVersion)localObject2).jTB;
                          ((e)localObject3).field_appId = ((WepkgVersion)localObject2).appId;
                          ((e)localObject3).field_version = ((WepkgVersion)localObject2).version;
                          ((e)localObject3).field_pkgPath = ((WepkgVersion)localObject2).pkgPath;
                          ((e)localObject3).field_disableWvCache = ((WepkgVersion)localObject2).QNi;
                          ((e)localObject3).field_clearPkgTime = ((WepkgVersion)localObject2).QNj;
                          ((e)localObject3).field_checkIntervalTime = ((WepkgVersion)localObject2).QNk;
                          ((e)localObject3).field_packMethod = ((WepkgVersion)localObject2).QNl;
                          ((e)localObject3).field_domain = ((WepkgVersion)localObject2).domain;
                          ((e)localObject3).field_md5 = ((WepkgVersion)localObject2).md5;
                          ((e)localObject3).field_downloadUrl = ((WepkgVersion)localObject2).downloadUrl;
                          ((e)localObject3).field_pkgSize = ((WepkgVersion)localObject2).QNm;
                          ((e)localObject3).field_downloadNetType = ((WepkgVersion)localObject2).QMs;
                          ((e)localObject3).field_nextCheckTime = ((WepkgVersion)localObject2).QNn;
                          ((e)localObject3).field_createTime = ((WepkgVersion)localObject2).createTime;
                          ((e)localObject3).field_charset = ((WepkgVersion)localObject2).charset;
                          ((e)localObject3).field_bigPackageReady = ((WepkgVersion)localObject2).QNo;
                          ((e)localObject3).field_preloadFilesReady = ((WepkgVersion)localObject2).QNp;
                          ((e)localObject3).field_preloadFilesAtomic = ((WepkgVersion)localObject2).QNq;
                          ((e)localObject3).field_totalDownloadCount = ((WepkgVersion)localObject2).QNr;
                          ((e)localObject3).field_downloadTriggerType = ((WepkgVersion)localObject2).gcA;
                          ((f)localObject1).a((e)localObject3, this.QMC);
                          if (!Util.isNullOrNil(this.QME))
                          {
                            localObject1 = this.QME.iterator();
                            while (((Iterator)localObject1).hasNext())
                            {
                              localObject2 = (WepkgPreloadFile)((Iterator)localObject1).next();
                              if (localObject2 != null)
                              {
                                localObject3 = com.tencent.mm.plugin.wepkg.b.d.hev();
                                localObject4 = new c();
                                ((c)localObject4).field_key = ((WepkgPreloadFile)localObject2).key;
                                ((c)localObject4).field_pkgId = ((WepkgPreloadFile)localObject2).jTB;
                                ((c)localObject4).field_version = ((WepkgPreloadFile)localObject2).version;
                                ((c)localObject4).field_filePath = ((WepkgPreloadFile)localObject2).filePath;
                                ((c)localObject4).field_rid = ((WepkgPreloadFile)localObject2).QMG;
                                ((c)localObject4).field_mimeType = ((WepkgPreloadFile)localObject2).mimeType;
                                ((c)localObject4).field_md5 = ((WepkgPreloadFile)localObject2).md5;
                                ((c)localObject4).field_downloadUrl = ((WepkgPreloadFile)localObject2).downloadUrl;
                                ((c)localObject4).field_size = ((WepkgPreloadFile)localObject2).size;
                                ((c)localObject4).field_downloadNetType = ((WepkgPreloadFile)localObject2).QMs;
                                ((c)localObject4).field_completeDownload = ((WepkgPreloadFile)localObject2).QMT;
                                ((c)localObject4).field_createTime = ((WepkgPreloadFile)localObject2).createTime;
                                if (((com.tencent.mm.plugin.wepkg.b.d)localObject3).omY) {
                                  if (((com.tencent.mm.plugin.wepkg.b.d)localObject3).mR(((c)localObject4).field_pkgId, ((c)localObject4).field_rid) == null)
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
        } while ((this.QMA == null) || (Util.isNullOrNil(this.QMA.jTB)));
        for (;;)
        {
          try
          {
            localObject2 = com.tencent.mm.plugin.wepkg.b.d.hev();
            localObject4 = this.QMA.jTB;
            if ((((com.tencent.mm.plugin.wepkg.b.d)localObject2).omY) || (!Util.isNullOrNil((String)localObject4))) {
              continue;
            }
            this.QME = ((List)localObject1);
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
            if (this.QMD == null) {
              break;
            }
            bool1 = com.tencent.mm.plugin.wepkg.b.d.hev().j(this.QMD.jTB, this.QMD.QMG, this.QMD.filePath, this.QMD.QMT);
          }
        }
      } while (this.QMA == null);
      localObject1 = f.hew();
      if (!((f)localObject1).omY) {
        localObject1 = null;
      }
      label1409:
      for (;;)
      {
        label1384:
        if (Util.isNullOrNil((String)localObject1))
        {
          localObject3 = com.tencent.mm.plugin.wepkg.b.d.hev();
          if (!((com.tencent.mm.plugin.wepkg.b.d)localObject3).omY)
          {
            localObject1 = localObject2;
            if (Util.isNullOrNil((String)localObject1))
            {
              localObject2 = f.hew();
              if (((f)localObject2).omY)
              {
                Log.i("MicroMsg.Wepkg.WepkgVersionStorage", "WepkgVersionRecord resetAutoDownloadCount ret:%s", new Object[] { Boolean.valueOf(((f)localObject2).execSQL("WepkgVersion", String.format("update %s set %s=0", new Object[] { "WepkgVersion", "autoDownloadCount" }))) });
                Log.i("MicroMsg.Wepkg.WepkgVersionStorage", "WepkgPreloadFilesRecord resetAutoDownloadCount ret:%s", new Object[] { Boolean.valueOf(((f)localObject2).execSQL("WepkgPreloadFiles", String.format("update %s set %s=0", new Object[] { "WepkgPreloadFiles", "autoDownloadCount" }))) });
              }
            }
            this.QMA.jTB = ((String)localObject1);
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
      ((f)localObject1).bop(((e)localObject4).field_pkgId);
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
        ((f)localObject1).bop(((e)localObject4).field_pkgId);
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
          if ((!((com.tencent.mm.plugin.wepkg.b.d)localObject3).omY) || (Util.isNullOrNil((String)localObject2)) || (Util.isNullOrNil((String)localObject4))) {}
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
          if (this.QMA == null) {
            break;
          }
          this.QME = com.tencent.mm.plugin.wepkg.b.d.hev().bok(this.QMA.jTB);
          break label1099;
          if (this.QMD == null) {
            break;
          }
          localObject1 = com.tencent.mm.plugin.wepkg.b.d.hev().mR(this.QMD.jTB, this.QMD.QMG);
          if (localObject1 != null)
          {
            this.QMD.a((c)localObject1);
            break label1099;
          }
          this.QMD = null;
          break;
          if (this.QMA == null) {
            break;
          }
          bool1 = f.hew().boq(this.QMA.jTB);
          break label1099;
          if (this.QMA == null) {
            break;
          }
          localObject1 = f.hew().bon(this.QMA.jTB);
          if (localObject1 != null)
          {
            this.QMA.a((e)localObject1);
            break label1099;
          }
          this.QMA = null;
          break;
          this.QMB = f.hew().hey();
          break label1099;
          if (this.QMA == null) {
            break;
          }
          bool1 = f.hew().bor(this.QMA.jTB);
          break label1099;
          if (this.QMA == null) {
            break;
          }
          localObject1 = f.hew();
          localObject2 = this.QMA.jTB;
          bool1 = bool2;
          if (((f)localObject1).omY) {
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
          if (this.QMA == null) {
            break;
          }
          localObject1 = f.hew();
          localObject2 = this.QMA.jTB;
          if ((!((f)localObject1).omY) || (Util.isNullOrNil((String)localObject2))) {}
          for (bool1 = false;; bool1 = bool3)
          {
            this.result = bool1;
            break;
            Log.i("MicroMsg.Wepkg.WepkgVersionStorage", "WepkgVersionRecord addPackageDownloadCount ret:%s", new Object[] { Boolean.valueOf(((f)localObject1).execSQL("WepkgVersion", String.format("update %s set %s=%s+1 where %s='%s'", new Object[] { "WepkgVersion", "packageDownloadCount", "packageDownloadCount", "pkgId", localObject2 }))) });
          }
          if (this.QMA == null) {
            break;
          }
          localObject1 = f.hew();
          localObject2 = this.QMA.jTB;
          if ((!((f)localObject1).omY) || (Util.isNullOrNil((String)localObject2))) {}
          for (bool1 = false;; bool1 = bool4)
          {
            this.result = bool1;
            break;
            Log.i("MicroMsg.Wepkg.WepkgVersionStorage", "WepkgVersionRecord resetPackageDownloadCount ret:%s", new Object[] { Boolean.valueOf(((f)localObject1).execSQL("WepkgVersion", String.format("update %s set %s=0 where %s='%s'", new Object[] { "WepkgVersion", "packageDownloadCount", "pkgId", localObject2 }))) });
          }
          if (this.QMD == null) {
            break;
          }
          localObject1 = com.tencent.mm.plugin.wepkg.b.d.hev();
          localObject2 = this.QMD.jTB;
          localObject3 = this.QMD.QMG;
          if ((!((com.tencent.mm.plugin.wepkg.b.d)localObject1).omY) || (Util.isNullOrNil((String)localObject2)) || (Util.isNullOrNil((String)localObject3))) {}
          for (bool1 = false;; bool1 = bool5)
          {
            this.result = bool1;
            break;
            Log.i("MicroMsg.Wepkg.WepkgPreloadFilesStorage", "WepkgPreloadFilesRecord addFileDownloadCount ret:%s", new Object[] { Boolean.valueOf(((com.tencent.mm.plugin.wepkg.b.d)localObject1).execSQL("WepkgPreloadFiles", String.format("update %s set %s=%s+1 where %s='%s' and %s='%s'", new Object[] { "WepkgPreloadFiles", "fileDownloadCount", "fileDownloadCount", "pkgId", localObject2, "rid", localObject3 }))) });
          }
          if (this.QMD == null) {
            break;
          }
          localObject1 = com.tencent.mm.plugin.wepkg.b.d.hev();
          localObject2 = this.QMD.jTB;
          if ((!((com.tencent.mm.plugin.wepkg.b.d)localObject1).omY) || (Util.isNullOrNil((String)localObject2)))
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
  
  public final void a(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(110694);
    paramParcel.writeInt(this.Vh);
    paramParcel.writeParcelable(this.QMA, paramInt);
    if (this.QMB == null) {
      this.QMB = new ArrayList();
    }
    paramParcel.writeList(this.QMB);
    paramParcel.writeParcelable(this.QMD, paramInt);
    if (this.QME == null) {
      this.QME = new ArrayList();
    }
    paramParcel.writeList(this.QME);
    paramParcel.writeString(this.QMF);
    AppMethodBeat.o(110694);
  }
  
  public final void bsK()
  {
    AppMethodBeat.i(110692);
    if (this.otv != null) {
      this.otv.run();
    }
    AppMethodBeat.o(110692);
  }
  
  public final void p(Parcel paramParcel)
  {
    AppMethodBeat.i(110693);
    this.Vh = paramParcel.readInt();
    this.QMA = ((WepkgVersion)paramParcel.readParcelable(WepkgVersion.class.getClassLoader()));
    if (this.QMB == null) {
      this.QMB = new ArrayList();
    }
    paramParcel.readList(this.QMB, WepkgVersion.class.getClassLoader());
    this.QMD = ((WepkgPreloadFile)paramParcel.readParcelable(WepkgPreloadFile.class.getClassLoader()));
    if (this.QME == null) {
      this.QME = new ArrayList();
    }
    paramParcel.readList(this.QME, WepkgPreloadFile.class.getClassLoader());
    this.QMF = paramParcel.readString();
    AppMethodBeat.o(110693);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.wepkg.model.WepkgCrossProcessTask
 * JD-Core Version:    0.7.0.1
 */