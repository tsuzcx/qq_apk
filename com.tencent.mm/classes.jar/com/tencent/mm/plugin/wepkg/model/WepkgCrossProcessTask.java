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
  public int EX;
  public WepkgVersion JNh;
  public List<WepkgVersion> JNi;
  public WePkgDiffInfo JNj;
  public WepkgPreloadFile JNk;
  public List<WepkgPreloadFile> JNl;
  public String JNm;
  public Runnable lyv;
  
  static
  {
    AppMethodBeat.i(110695);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(110695);
  }
  
  public WepkgCrossProcessTask()
  {
    AppMethodBeat.i(110689);
    this.EX = -1;
    this.JNh = new WepkgVersion();
    this.JNi = new ArrayList();
    this.JNj = new WePkgDiffInfo();
    this.JNk = new WepkgPreloadFile();
    this.JNl = new ArrayList();
    AppMethodBeat.o(110689);
  }
  
  private WepkgCrossProcessTask(Parcel paramParcel)
  {
    AppMethodBeat.i(110690);
    f(paramParcel);
    AppMethodBeat.o(110690);
  }
  
  public final void a(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(110694);
    paramParcel.writeInt(this.EX);
    paramParcel.writeParcelable(this.JNh, paramInt);
    if (this.JNi == null) {
      this.JNi = new ArrayList();
    }
    paramParcel.writeList(this.JNi);
    paramParcel.writeParcelable(this.JNk, paramInt);
    if (this.JNl == null) {
      this.JNl = new ArrayList();
    }
    paramParcel.writeList(this.JNl);
    paramParcel.writeString(this.JNm);
    AppMethodBeat.o(110694);
  }
  
  public final void bjj()
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
    switch (this.EX)
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
            bDU();
            AppMethodBeat.o(110691);
            return;
            this.result = true;
            continue;
            this.result = a.dSV();
            continue;
            if (this.JNh != null)
            {
              localObject1 = f.gkF().bcm(this.JNh.hhD);
              if (localObject1 != null)
              {
                this.JNh.a((e)localObject1);
                this.result = true;
              }
              else
              {
                this.JNh = null;
                continue;
                if (this.JNh != null)
                {
                  this.result = f.gkF().bco(this.JNh.hhD);
                  continue;
                  if (this.JNh != null)
                  {
                    this.result = f.gkF().a(this.JNh.hhD, this.JNh.JNP, this.JNh.JNQ, this.JNh.JNR);
                    continue;
                    if (this.JNh != null)
                    {
                      this.result = f.gkF().C(this.JNh.hhD, this.JNh.pkgPath, this.JNh.JNV);
                      continue;
                      if (this.JNh != null)
                      {
                        this.result = f.gkF().cV(this.JNh.hhD, this.JNh.JNW);
                        continue;
                        if ((this.JNh != null) && (!Util.isNullOrNil(this.JNh.hhD)))
                        {
                          localObject1 = f.gkF();
                          localObject2 = this.JNh;
                          localObject3 = new e();
                          ((e)localObject3).field_pkgId = ((WepkgVersion)localObject2).hhD;
                          ((e)localObject3).field_appId = ((WepkgVersion)localObject2).appId;
                          ((e)localObject3).field_version = ((WepkgVersion)localObject2).version;
                          ((e)localObject3).field_pkgPath = ((WepkgVersion)localObject2).pkgPath;
                          ((e)localObject3).field_disableWvCache = ((WepkgVersion)localObject2).JNP;
                          ((e)localObject3).field_clearPkgTime = ((WepkgVersion)localObject2).JNQ;
                          ((e)localObject3).field_checkIntervalTime = ((WepkgVersion)localObject2).JNR;
                          ((e)localObject3).field_packMethod = ((WepkgVersion)localObject2).JNS;
                          ((e)localObject3).field_domain = ((WepkgVersion)localObject2).domain;
                          ((e)localObject3).field_md5 = ((WepkgVersion)localObject2).md5;
                          ((e)localObject3).field_downloadUrl = ((WepkgVersion)localObject2).downloadUrl;
                          ((e)localObject3).field_pkgSize = ((WepkgVersion)localObject2).JNT;
                          ((e)localObject3).field_downloadNetType = ((WepkgVersion)localObject2).JMZ;
                          ((e)localObject3).field_nextCheckTime = ((WepkgVersion)localObject2).JNU;
                          ((e)localObject3).field_createTime = ((WepkgVersion)localObject2).createTime;
                          ((e)localObject3).field_charset = ((WepkgVersion)localObject2).charset;
                          ((e)localObject3).field_bigPackageReady = ((WepkgVersion)localObject2).JNV;
                          ((e)localObject3).field_preloadFilesReady = ((WepkgVersion)localObject2).JNW;
                          ((e)localObject3).field_preloadFilesAtomic = ((WepkgVersion)localObject2).JNX;
                          ((e)localObject3).field_totalDownloadCount = ((WepkgVersion)localObject2).JNY;
                          ((e)localObject3).field_downloadTriggerType = ((WepkgVersion)localObject2).eij;
                          ((f)localObject1).a((e)localObject3, this.JNj);
                          if (!Util.isNullOrNil(this.JNl))
                          {
                            localObject1 = this.JNl.iterator();
                            while (((Iterator)localObject1).hasNext())
                            {
                              localObject2 = (WepkgPreloadFile)((Iterator)localObject1).next();
                              if (localObject2 != null)
                              {
                                localObject3 = com.tencent.mm.plugin.wepkg.b.d.gkE();
                                localObject4 = new c();
                                ((c)localObject4).field_key = ((WepkgPreloadFile)localObject2).key;
                                ((c)localObject4).field_pkgId = ((WepkgPreloadFile)localObject2).hhD;
                                ((c)localObject4).field_version = ((WepkgPreloadFile)localObject2).version;
                                ((c)localObject4).field_filePath = ((WepkgPreloadFile)localObject2).filePath;
                                ((c)localObject4).field_rid = ((WepkgPreloadFile)localObject2).JNn;
                                ((c)localObject4).field_mimeType = ((WepkgPreloadFile)localObject2).mimeType;
                                ((c)localObject4).field_md5 = ((WepkgPreloadFile)localObject2).md5;
                                ((c)localObject4).field_downloadUrl = ((WepkgPreloadFile)localObject2).downloadUrl;
                                ((c)localObject4).field_size = ((WepkgPreloadFile)localObject2).size;
                                ((c)localObject4).field_downloadNetType = ((WepkgPreloadFile)localObject2).JMZ;
                                ((c)localObject4).field_completeDownload = ((WepkgPreloadFile)localObject2).JNA;
                                ((c)localObject4).field_createTime = ((WepkgPreloadFile)localObject2).createTime;
                                if (((com.tencent.mm.plugin.wepkg.b.d)localObject3).lsb) {
                                  if (((com.tencent.mm.plugin.wepkg.b.d)localObject3).mp(((c)localObject4).field_pkgId, ((c)localObject4).field_rid) == null)
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
        } while ((this.JNh == null) || (Util.isNullOrNil(this.JNh.hhD)));
        for (;;)
        {
          try
          {
            localObject2 = com.tencent.mm.plugin.wepkg.b.d.gkE();
            localObject4 = this.JNh.hhD;
            if ((((com.tencent.mm.plugin.wepkg.b.d)localObject2).lsb) || (!Util.isNullOrNil((String)localObject4))) {
              continue;
            }
            this.JNl = ((List)localObject1);
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
            if (this.JNk == null) {
              break;
            }
            bool1 = com.tencent.mm.plugin.wepkg.b.d.gkE().h(this.JNk.hhD, this.JNk.JNn, this.JNk.filePath, this.JNk.JNA);
          }
        }
      } while (this.JNh == null);
      localObject1 = f.gkF();
      if (!((f)localObject1).lsb) {
        localObject1 = null;
      }
      label1409:
      for (;;)
      {
        label1384:
        if (Util.isNullOrNil((String)localObject1))
        {
          localObject3 = com.tencent.mm.plugin.wepkg.b.d.gkE();
          if (!((com.tencent.mm.plugin.wepkg.b.d)localObject3).lsb)
          {
            localObject1 = localObject2;
            if (Util.isNullOrNil((String)localObject1))
            {
              localObject2 = f.gkF();
              if (((f)localObject2).lsb)
              {
                Log.i("MicroMsg.Wepkg.WepkgVersionStorage", "WepkgVersionRecord resetAutoDownloadCount ret:%s", new Object[] { Boolean.valueOf(((f)localObject2).execSQL("WepkgVersion", String.format("update %s set %s=0", new Object[] { "WepkgVersion", "autoDownloadCount" }))) });
                Log.i("MicroMsg.Wepkg.WepkgVersionStorage", "WepkgPreloadFilesRecord resetAutoDownloadCount ret:%s", new Object[] { Boolean.valueOf(((f)localObject2).execSQL("WepkgPreloadFiles", String.format("update %s set %s=0", new Object[] { "WepkgPreloadFiles", "autoDownloadCount" }))) });
              }
            }
            this.JNh.hhD = ((String)localObject1);
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
      ((f)localObject1).bcp(((e)localObject4).field_pkgId);
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
        ((f)localObject1).bcp(((e)localObject4).field_pkgId);
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
          if ((!((com.tencent.mm.plugin.wepkg.b.d)localObject3).lsb) || (Util.isNullOrNil((String)localObject2)) || (Util.isNullOrNil((String)localObject4))) {}
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
          if (this.JNh == null) {
            break;
          }
          this.JNl = com.tencent.mm.plugin.wepkg.b.d.gkE().bck(this.JNh.hhD);
          break label1099;
          if (this.JNk == null) {
            break;
          }
          localObject1 = com.tencent.mm.plugin.wepkg.b.d.gkE().mp(this.JNk.hhD, this.JNk.JNn);
          if (localObject1 != null)
          {
            this.JNk.a((c)localObject1);
            break label1099;
          }
          this.JNk = null;
          break;
          if (this.JNh == null) {
            break;
          }
          bool1 = f.gkF().bcq(this.JNh.hhD);
          break label1099;
          if (this.JNh == null) {
            break;
          }
          localObject1 = f.gkF().bcn(this.JNh.hhD);
          if (localObject1 != null)
          {
            this.JNh.a((e)localObject1);
            break label1099;
          }
          this.JNh = null;
          break;
          this.JNi = f.gkF().gkH();
          break label1099;
          if (this.JNh == null) {
            break;
          }
          bool1 = f.gkF().bcr(this.JNh.hhD);
          break label1099;
          if (this.JNh == null) {
            break;
          }
          localObject1 = f.gkF();
          localObject2 = this.JNh.hhD;
          bool1 = bool2;
          if (((f)localObject1).lsb) {
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
          if (this.JNh == null) {
            break;
          }
          localObject1 = f.gkF();
          localObject2 = this.JNh.hhD;
          if ((!((f)localObject1).lsb) || (Util.isNullOrNil((String)localObject2))) {}
          for (bool1 = false;; bool1 = bool3)
          {
            this.result = bool1;
            break;
            Log.i("MicroMsg.Wepkg.WepkgVersionStorage", "WepkgVersionRecord addPackageDownloadCount ret:%s", new Object[] { Boolean.valueOf(((f)localObject1).execSQL("WepkgVersion", String.format("update %s set %s=%s+1 where %s='%s'", new Object[] { "WepkgVersion", "packageDownloadCount", "packageDownloadCount", "pkgId", localObject2 }))) });
          }
          if (this.JNh == null) {
            break;
          }
          localObject1 = f.gkF();
          localObject2 = this.JNh.hhD;
          if ((!((f)localObject1).lsb) || (Util.isNullOrNil((String)localObject2))) {}
          for (bool1 = false;; bool1 = bool4)
          {
            this.result = bool1;
            break;
            Log.i("MicroMsg.Wepkg.WepkgVersionStorage", "WepkgVersionRecord resetPackageDownloadCount ret:%s", new Object[] { Boolean.valueOf(((f)localObject1).execSQL("WepkgVersion", String.format("update %s set %s=0 where %s='%s'", new Object[] { "WepkgVersion", "packageDownloadCount", "pkgId", localObject2 }))) });
          }
          if (this.JNk == null) {
            break;
          }
          localObject1 = com.tencent.mm.plugin.wepkg.b.d.gkE();
          localObject2 = this.JNk.hhD;
          localObject3 = this.JNk.JNn;
          if ((!((com.tencent.mm.plugin.wepkg.b.d)localObject1).lsb) || (Util.isNullOrNil((String)localObject2)) || (Util.isNullOrNil((String)localObject3))) {}
          for (bool1 = false;; bool1 = bool5)
          {
            this.result = bool1;
            break;
            Log.i("MicroMsg.Wepkg.WepkgPreloadFilesStorage", "WepkgPreloadFilesRecord addFileDownloadCount ret:%s", new Object[] { Boolean.valueOf(((com.tencent.mm.plugin.wepkg.b.d)localObject1).execSQL("WepkgPreloadFiles", String.format("update %s set %s=%s+1 where %s='%s' and %s='%s'", new Object[] { "WepkgPreloadFiles", "fileDownloadCount", "fileDownloadCount", "pkgId", localObject2, "rid", localObject3 }))) });
          }
          if (this.JNk == null) {
            break;
          }
          localObject1 = com.tencent.mm.plugin.wepkg.b.d.gkE();
          localObject2 = this.JNk.hhD;
          if ((!((com.tencent.mm.plugin.wepkg.b.d)localObject1).lsb) || (Util.isNullOrNil((String)localObject2)))
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
  
  public final void bjk()
  {
    AppMethodBeat.i(110692);
    if (this.lyv != null) {
      this.lyv.run();
    }
    AppMethodBeat.o(110692);
  }
  
  public final void p(Parcel paramParcel)
  {
    AppMethodBeat.i(110693);
    this.EX = paramParcel.readInt();
    this.JNh = ((WepkgVersion)paramParcel.readParcelable(WepkgVersion.class.getClassLoader()));
    if (this.JNi == null) {
      this.JNi = new ArrayList();
    }
    paramParcel.readList(this.JNi, WepkgVersion.class.getClassLoader());
    this.JNk = ((WepkgPreloadFile)paramParcel.readParcelable(WepkgPreloadFile.class.getClassLoader()));
    if (this.JNl == null) {
      this.JNl = new ArrayList();
    }
    paramParcel.readList(this.JNl, WepkgPreloadFile.class.getClassLoader());
    this.JNm = paramParcel.readString();
    AppMethodBeat.o(110693);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wepkg.model.WepkgCrossProcessTask
 * JD-Core Version:    0.7.0.1
 */