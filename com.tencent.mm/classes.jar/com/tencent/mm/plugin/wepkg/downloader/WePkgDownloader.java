package com.tencent.mm.plugin.wepkg.downloader;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.service.IBSPatchJNIService;
import com.tencent.mm.plugin.wepkg.c.a.a;
import com.tencent.mm.plugin.wepkg.model.WepkgCrossProcessTask;
import com.tencent.mm.plugin.wepkg.model.WepkgVersion;
import com.tencent.mm.plugin.wepkg.model.e;
import com.tencent.mm.plugin.wepkg.model.j;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.ah;
import com.tencent.mm.vfs.u;
import com.tencent.mm.vfs.y;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class WePkgDownloader
{
  private static volatile WePkgDownloader XFb = null;
  private a XFc;
  private Map<String, IWepkgUpdateCallback> mCallBackMap;
  
  public WePkgDownloader()
  {
    AppMethodBeat.i(110610);
    this.XFc = new a()
    {
      public final void a(g paramAnonymousg)
      {
        for (;;)
        {
          try
          {
            AppMethodBeat.i(110603);
            if (paramAnonymousg.mStatus == 1)
            {
              com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(859L, 2L, 1L, false);
              localObject1 = paramAnonymousg.XER.mFilePath;
              if ((Util.isNullOrNil((String)localObject1)) || (!new u((String)localObject1).jKS()))
              {
                Log.e("MicroMsg.Wepkg.WepkgDownloader", "onDownloadComplete, pkgPath is null or nil");
                localObject1 = WePkgDownloader.IWepkgUpdateCallback.RetCode.XFi;
                com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(859L, 4L, 1L, false);
                Log.i("MicroMsg.Wepkg.WepkgDownloader", "download callback retCode:".concat(String.valueOf(localObject1)));
                localObject2 = (WePkgDownloader.IWepkgUpdateCallback)WePkgDownloader.a(WePkgDownloader.this).remove(paramAnonymousg.XER.XFp);
                if (localObject2 != null)
                {
                  ((WePkgDownloader.IWepkgUpdateCallback)localObject2).a(paramAnonymousg.XER.XFq, paramAnonymousg.XER.mFilePath, (WePkgDownloader.IWepkgUpdateCallback.RetCode)localObject1);
                  if ((paramAnonymousg.XER.xnM != 1) && (paramAnonymousg.XER.xnM != 3)) {
                    break label401;
                  }
                  localObject1 = paramAnonymousg.XER.XFq;
                  localObject2 = new WepkgCrossProcessTask();
                  ((WepkgCrossProcessTask)localObject2).bUl = 3008;
                  ((WepkgCrossProcessTask)localObject2).XFY.mtT = ((String)localObject1);
                  if (!MMApplicationContext.isMMProcess()) {
                    break label393;
                  }
                  ((WepkgCrossProcessTask)localObject2).asn();
                  WePkgDownloader.b(paramAnonymousg);
                  d.iFk().boj(paramAnonymousg.XER.XFp);
                  AppMethodBeat.o(110603);
                }
              }
              else
              {
                localObject2 = paramAnonymousg.XER.ryW;
                localObject3 = y.bub((String)localObject1);
                if (!Util.nullAsNil((String)localObject3).equalsIgnoreCase((String)localObject2))
                {
                  Log.e("MicroMsg.Wepkg.WepkgDownloader", "onDownloadComplete, file.md5(%s) != net.md5(%s)", new Object[] { localObject3, localObject2 });
                  y.deleteFile((String)localObject1);
                  localObject1 = WePkgDownloader.IWepkgUpdateCallback.RetCode.XFj;
                  paramAnonymousg.yoO = 1012;
                  com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(859L, 3L, 1L, false);
                  continue;
                }
                localObject1 = WePkgDownloader.IWepkgUpdateCallback.RetCode.XFh;
                com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(859L, 5L, 1L, false);
                continue;
              }
            }
            else
            {
              com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(859L, 1L, 1L, false);
              localObject1 = WePkgDownloader.IWepkgUpdateCallback.RetCode.XFl;
              continue;
            }
            Log.i("MicroMsg.Wepkg.WepkgDownloader", "download callback invalid");
            com.tencent.mm.plugin.wepkg.utils.a.b("CallbackInvalid", paramAnonymousg.XER.mUrl, paramAnonymousg.XER.XFq, null, -1L, 0L, null);
            continue;
            ((WepkgCrossProcessTask)localObject2).cpB();
          }
          finally {}
          label393:
          continue;
          label401:
          Object localObject1 = paramAnonymousg.XER.XFq;
          Object localObject2 = paramAnonymousg.XER.XFr;
          Object localObject3 = new WepkgCrossProcessTask();
          ((WepkgCrossProcessTask)localObject3).bUl = 4005;
          ((WepkgCrossProcessTask)localObject3).XGb.mtT = ((String)localObject1);
          ((WepkgCrossProcessTask)localObject3).XGb.XGe = ((String)localObject2);
          if (MMApplicationContext.isMMProcess()) {
            ((WepkgCrossProcessTask)localObject3).asn();
          } else {
            ((WepkgCrossProcessTask)localObject3).cpB();
          }
        }
      }
    };
    if (this.mCallBackMap == null) {
      this.mCallBackMap = new ConcurrentHashMap();
    }
    AppMethodBeat.o(110610);
  }
  
  private void a(u paramu, String paramString, List<String> paramList)
  {
    AppMethodBeat.i(177087);
    if ((paramu == null) || (!paramu.jKS()))
    {
      AppMethodBeat.o(177087);
      return;
    }
    if ((paramu.jKV()) && (paramu.getName().equals(paramString)))
    {
      paramString = paramList;
      if (paramList == null) {
        paramString = new ArrayList();
      }
      paramString.add(ah.v(paramu.jKT()));
      AppMethodBeat.o(177087);
      return;
    }
    if (paramu.isDirectory())
    {
      paramu = paramu.jKX();
      if (paramu != null)
      {
        int i = 0;
        while (i < paramu.length)
        {
          a(paramu[i], paramString, paramList);
          i += 1;
        }
      }
    }
    AppMethodBeat.o(177087);
  }
  
  public static WePkgDownloader iFl()
  {
    AppMethodBeat.i(110609);
    if (XFb == null) {}
    try
    {
      if (XFb == null) {
        XFb = new WePkgDownloader();
      }
      WePkgDownloader localWePkgDownloader = XFb;
      AppMethodBeat.o(110609);
      return localWePkgDownloader;
    }
    finally
    {
      AppMethodBeat.o(110609);
    }
  }
  
  private static boolean k(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    AppMethodBeat.i(110612);
    l1 = System.currentTimeMillis();
    for (;;)
    {
      try
      {
        i = ((IBSPatchJNIService)com.tencent.mm.kernel.h.ax(IBSPatchJNIService.class)).bspatch(paramString3, paramString2, paramString4);
        l2 = System.currentTimeMillis() - l1;
        Log.i("MicroMsg.Wepkg.WepkgDownloader", "mergeDiffPackage, result: %d, cost: %d", new Object[] { Integer.valueOf(i), Long.valueOf(l2) });
        if (i != 0) {
          continue;
        }
        com.tencent.mm.plugin.report.service.h.OAn.kJ(859, 34);
        boolean bool;
        if (Util.isNullOrNil(paramString5))
        {
          bool = true;
          if (bool)
          {
            com.tencent.mm.plugin.wepkg.utils.a.b(paramString1, 0, "", l2);
            AppMethodBeat.o(110612);
            return true;
          }
        }
        else
        {
          String str = y.bub(paramString2);
          if (Util.isNullOrNil(str))
          {
            bool = false;
            continue;
          }
          Log.i("MicroMsg.Wepkg.WepkgDownloader", "matchMd5, fileMd5: %s, md5: %s", new Object[] { str, paramString5 });
          bool = paramString5.trim().equalsIgnoreCase(str.trim());
          continue;
        }
        com.tencent.mm.plugin.report.service.h.OAn.kJ(859, 35);
        com.tencent.mm.plugin.wepkg.utils.a.b(paramString1, 2007, "", l2);
      }
      catch (Exception paramString5)
      {
        int i;
        long l2 = System.currentTimeMillis();
        Log.e("MicroMsg.Wepkg.WepkgDownloader", "mergeDiffPkg e = %s, old[%s], new[%s], diff[%s]", new Object[] { paramString5, paramString3, paramString2, paramString4 });
        Log.printErrStackTrace("MicroMsg.Wepkg.WepkgDownloader", paramString5, "", new Object[0]);
        com.tencent.mm.plugin.report.service.h.OAn.kJ(859, 33);
        com.tencent.mm.plugin.wepkg.utils.a.b(paramString1, 2006, "", l2 - l1);
        continue;
      }
      AppMethodBeat.o(110612);
      return false;
      com.tencent.mm.plugin.report.service.h.OAn.kJ(859, 27);
      com.tencent.mm.plugin.report.service.h.OAn.kJ(859, 25 - i);
      com.tencent.mm.plugin.wepkg.utils.a.b(paramString1, 1998 - i, "", l2);
    }
  }
  
  private static String oI(String paramString1, String paramString2)
  {
    AppMethodBeat.i(110613);
    paramString1 = e.oK(paramString1, paramString2);
    com.tencent.mm.plugin.wepkg.utils.d.checkMkdir(paramString1);
    paramString1 = paramString1 + "/package";
    AppMethodBeat.o(110613);
    return paramString1;
  }
  
  public final void a(int paramInt1, String paramString1, String paramString2, String paramString3, String paramString4, long paramLong, String paramString5, String paramString6, String paramString7, int paramInt2, IWepkgUpdateCallback paramIWepkgUpdateCallback)
  {
    AppMethodBeat.i(110614);
    Log.i("MicroMsg.Wepkg.WepkgDownloader", "triggerDownloadWepkg, fileType:%s, pkgid:%s, downloadUrl:%s, pkgSize:%d, version:%s, md5:%s, downloadNetType:%d", new Object[] { Integer.valueOf(paramInt1), paramString1, paramString4, Long.valueOf(paramLong), paramString5, paramString7, Integer.valueOf(paramInt2) });
    if (paramInt1 == 2)
    {
      paramString2 = e.oK(paramString1, paramString5) + "/preload_files";
      com.tencent.mm.plugin.wepkg.utils.d.checkMkdir(paramString2);
    }
    for (String str = paramString2 + "/" + paramString7;; str = paramString2)
    {
      if (Util.isNullOrNil(str))
      {
        Log.i("MicroMsg.Wepkg.WepkgDownloader", "pkgPath:%s is null", new Object[] { str });
        a.a.iFw().u(paramString1, paramString4, 0L);
        if (paramIWepkgUpdateCallback != null) {
          paramIWepkgUpdateCallback.a(paramString1, "", WePkgDownloader.IWepkgUpdateCallback.RetCode.XFl);
        }
        AppMethodBeat.o(110614);
        return;
      }
      if (com.tencent.mm.pluginsdk.res.downloader.b.a.ZC(str))
      {
        if (Util.nullAsNil(y.bub(str)).equals(paramString7))
        {
          Log.i("MicroMsg.Wepkg.WepkgDownloader", "file exist in current %s version, pkgPath:%s", new Object[] { paramString5, str });
          a.a.iFw().u(paramString1, paramString4, 0L);
          if (paramIWepkgUpdateCallback != null) {
            paramIWepkgUpdateCallback.a(paramString1, str, WePkgDownloader.IWepkgUpdateCallback.RetCode.XFh);
          }
          AppMethodBeat.o(110614);
        }
      }
      else
      {
        paramString2 = e.bol(paramString1);
        if (!Util.isNullOrNil(paramString2))
        {
          u localu = new u(paramString2);
          ArrayList localArrayList = new ArrayList();
          if ((str == null) || (str.length() <= 0)) {
            paramString2 = "";
          }
          for (;;)
          {
            a(localu, paramString2, localArrayList);
            Log.i("MicroMsg.Wepkg.WepkgDownloader", "local have the same file. size:%s", new Object[] { Integer.valueOf(localArrayList.size()) });
            paramString2 = localArrayList.iterator();
            do
            {
              if (!paramString2.hasNext()) {
                break;
              }
              localObject = new u((String)paramString2.next());
            } while ((!((u)localObject).jKV()) || (((u)localObject).length() != paramLong) || (!Util.nullAsNil(y.bub(ah.v(((u)localObject).mUri))).equalsIgnoreCase(paramString7)));
            y.O(ah.v(((u)localObject).jKT()), str, false);
            Log.i("MicroMsg.Wepkg.WepkgDownloader", "file exist in other version path:%s, pkgPath:%s", new Object[] { ah.v(((u)localObject).jKT()), str });
            a.a.iFw().u(paramString1, paramString4, 0L);
            if (paramIWepkgUpdateCallback != null) {
              paramIWepkgUpdateCallback.a(paramString1, str, WePkgDownloader.IWepkgUpdateCallback.RetCode.XFh);
            }
            AppMethodBeat.o(110614);
            return;
            Object localObject = new u(str).getName();
            i = ((String)localObject).lastIndexOf('.');
            paramString2 = (String)localObject;
            if (i >= 0) {
              if (i == 0) {
                paramString2 = "";
              } else {
                paramString2 = ((String)localObject).substring(0, i);
              }
            }
          }
        }
      }
      int j = 0;
      boolean bool4 = false;
      boolean bool6 = false;
      boolean bool5 = false;
      boolean bool3 = false;
      boolean bool1 = bool5;
      int i = j;
      boolean bool2 = bool3;
      switch (paramInt2)
      {
      default: 
        bool2 = bool3;
        i = j;
        bool1 = bool5;
      case 2: 
      case 5: 
      case 6: 
      case 7: 
      case 8: 
        if (i != 0)
        {
          a.a.iFw().u(paramString1, paramString4, paramLong);
          label664:
          Log.i("MicroMsg.Wepkg.WepkgDownloader", "allowDownload:%s", new Object[] { Boolean.valueOf(bool1) });
          if (!bool1) {
            break label1011;
          }
          paramString2 = new c(new f(com.tencent.mm.b.g.getMessageDigest(paramString4.getBytes()), paramInt1, paramString1, paramString3, paramString5, paramString6, paramString4, str, paramLong, paramString7, bool2, this.XFc));
          paramString3 = d.iFk();
          if (paramString3.XFa.containsKey(paramString2.XER.XFp)) {
            break label981;
          }
          paramString2.PL = b.iFi().XEQ.submit(paramString2);
          paramString3.XFa.put(paramString2.XER.XFp, paramString2);
        }
        break;
      }
      label981:
      for (paramInt1 = 1;; paramInt1 = 0)
      {
        if (paramInt1 == 0) {
          break label986;
        }
        this.mCallBackMap.put(com.tencent.mm.b.g.getMessageDigest(paramString4.getBytes()), paramIWepkgUpdateCallback);
        com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(859L, 0L, 1L, false);
        AppMethodBeat.o(110614);
        return;
        bool1 = true;
        for (;;)
        {
          i = 1;
          bool2 = bool3;
          break;
          if (!NetStatusUtil.isWifiOr4G(MMApplicationContext.getContext()))
          {
            bool1 = bool6;
            if (!NetStatusUtil.is3G(MMApplicationContext.getContext())) {}
          }
          else
          {
            bool1 = true;
          }
          i = 1;
          bool2 = bool3;
          break;
          bool1 = bool5;
          i = j;
          bool2 = bool3;
          if (!NetStatusUtil.isWifi(MMApplicationContext.getContext())) {
            break;
          }
          bool1 = true;
          bool2 = true;
          i = j;
          break;
          if (NetStatusUtil.isWifi(MMApplicationContext.getContext()))
          {
            bool1 = true;
          }
          else if (!NetStatusUtil.isWifiOr4G(MMApplicationContext.getContext()))
          {
            bool1 = bool4;
            if (!NetStatusUtil.is3G(MMApplicationContext.getContext())) {}
          }
          else
          {
            bool1 = bool4;
            if (com.tencent.mm.plugin.wepkg.utils.d.iFA()) {
              bool1 = true;
            }
          }
        }
        a.a.iFw().u(paramString1, paramString4, 0L);
        break label664;
      }
      label986:
      if (paramIWepkgUpdateCallback != null) {
        paramIWepkgUpdateCallback.a(paramString1, "", WePkgDownloader.IWepkgUpdateCallback.RetCode.XFm);
      }
      AppMethodBeat.o(110614);
      return;
      label1011:
      Log.i("MicroMsg.Wepkg.WepkgDownloader", "net is not match, dont download");
      if (paramIWepkgUpdateCallback != null) {
        paramIWepkgUpdateCallback.a(paramString1, "", WePkgDownloader.IWepkgUpdateCallback.RetCode.XFm);
      }
      AppMethodBeat.o(110614);
      return;
    }
  }
  
  public final void a(String paramString, final IWepkgUpdateCallback paramIWepkgUpdateCallback)
  {
    final WepkgVersion localWepkgVersion;
    String str;
    try
    {
      AppMethodBeat.i(110611);
      localWepkgVersion = j.bou(paramString);
      if (localWepkgVersion == null)
      {
        Log.e("MicroMsg.Wepkg.WepkgDownloader", "downloadWepkg, wepkgVersion is null");
        AppMethodBeat.o(110611);
      }
      for (;;)
      {
        return;
        str = oI(paramString, localWepkgVersion.version);
        if ((!y.ZC(str)) || (!Util.nullAsNil(y.bub(str)).equals(localWepkgVersion.md5))) {
          break;
        }
        Log.i("MicroMsg.Wepkg.WepkgDownloader", "file exist in current %s version, pkgPath:%s", new Object[] { localWepkgVersion.version, str });
        a.a.iFw().u(paramString, localWepkgVersion.downloadUrl, 0L);
        if (paramIWepkgUpdateCallback != null) {
          paramIWepkgUpdateCallback.a(paramString, str, WePkgDownloader.IWepkgUpdateCallback.RetCode.XFh);
        }
        AppMethodBeat.o(110611);
      }
      locala = com.tencent.mm.plugin.wepkg.b.b.iFc().bnX(paramString);
    }
    finally {}
    final com.tencent.mm.plugin.wepkg.b.a locala;
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (locala != null)
    {
      Log.i("MicroMsg.Wepkg.WepkgDownloader", "diff is not null, pkgId: %s", new Object[] { paramString });
      if (Util.nullAsNil(locala.field_version).equals(localWepkgVersion.version)) {
        break label382;
      }
      Log.i("MicroMsg.Wepkg.WepkgDownloader", "diff version is not equal to package version, pkgId: %s, diffVersion: %s, packageVersion: %s", new Object[] { paramString, locala.field_version, localWepkgVersion.version });
      com.tencent.mm.plugin.wepkg.b.b.iFc().iP(paramString);
      bool1 = bool2;
    }
    for (;;)
    {
      Log.i("MicroMsg.Wepkg.WepkgDownloader", "downloadBigPackage, downloadDiff = %b", new Object[] { Boolean.valueOf(bool1) });
      if (bool1)
      {
        com.tencent.mm.plugin.report.service.h.OAn.kJ(859, 22);
        paramString = new IWepkgUpdateCallback()
        {
          public final void a(String paramAnonymousString1, String paramAnonymousString2, WePkgDownloader.IWepkgUpdateCallback.RetCode paramAnonymousRetCode)
          {
            AppMethodBeat.i(110602);
            String str = WePkgDownloader.oJ(paramAnonymousString1, localWepkgVersion.version);
            if (paramAnonymousRetCode == WePkgDownloader.IWepkgUpdateCallback.RetCode.XFh)
            {
              com.tencent.mm.plugin.report.service.h.OAn.kJ(859, 24);
              boolean bool = WePkgDownloader.l(paramAnonymousString1, str, locala.field_oldPath, paramAnonymousString2, localWepkgVersion.md5);
              y.deleteFile(paramAnonymousString2);
              com.tencent.mm.plugin.wepkg.b.b.iFc().iP(paramAnonymousString1);
              if (bool)
              {
                paramIWepkgUpdateCallback.a(paramAnonymousString1, str, WePkgDownloader.IWepkgUpdateCallback.RetCode.XFh);
                AppMethodBeat.o(110602);
                return;
              }
              WePkgDownloader.this.a(paramAnonymousString1, paramIWepkgUpdateCallback);
              AppMethodBeat.o(110602);
              return;
            }
            if (paramAnonymousRetCode == WePkgDownloader.IWepkgUpdateCallback.RetCode.XFm)
            {
              paramIWepkgUpdateCallback.a(paramAnonymousString1, str, paramAnonymousRetCode);
              AppMethodBeat.o(110602);
              return;
            }
            if (paramAnonymousRetCode == WePkgDownloader.IWepkgUpdateCallback.RetCode.XFl) {
              com.tencent.mm.plugin.report.service.h.OAn.kJ(859, 23);
            }
            for (;;)
            {
              y.deleteFile(paramAnonymousString2);
              com.tencent.mm.plugin.wepkg.b.b.iFc().iP(paramAnonymousString1);
              WePkgDownloader.this.a(paramAnonymousString1, paramIWepkgUpdateCallback);
              AppMethodBeat.o(110602);
              return;
              if (paramAnonymousRetCode == WePkgDownloader.IWepkgUpdateCallback.RetCode.XFj) {
                com.tencent.mm.plugin.report.service.h.OAn.kJ(859, 25);
              } else if (paramAnonymousRetCode == WePkgDownloader.IWepkgUpdateCallback.RetCode.XFi) {
                com.tencent.mm.plugin.report.service.h.OAn.kJ(859, 26);
              }
            }
          }
        };
        paramIWepkgUpdateCallback = e.oK(locala.field_pkgId, locala.field_version);
        com.tencent.mm.plugin.wepkg.utils.d.checkMkdir(paramIWepkgUpdateCallback);
        paramIWepkgUpdateCallback = paramIWepkgUpdateCallback + "/diff";
        a(3, locala.field_pkgId, paramIWepkgUpdateCallback, "", locala.field_downloadUrl, locala.field_pkgSize, locala.field_version, locala.field_oldVersion, locala.field_md5, locala.field_downloadNetType, paramString);
        AppMethodBeat.o(110611);
        break;
        label382:
        if (Util.isNullOrNil(locala.field_downloadUrl))
        {
          Log.i("MicroMsg.Wepkg.WepkgDownloader", "diff downloadurl is null, pkgId: %s, diffVersion: %s", new Object[] { paramString, locala.field_version });
          com.tencent.mm.plugin.wepkg.b.b.iFc().iP(paramString);
          bool1 = bool2;
          continue;
        }
        if (y.ZC(locala.field_oldPath)) {
          break label532;
        }
        Log.i("MicroMsg.Wepkg.WepkgDownloader", "old package is not exists, pkgId: %s, oldPath: %s", new Object[] { paramString, locala.field_oldPath });
        com.tencent.mm.plugin.wepkg.b.b.iFc().iP(paramString);
        bool1 = bool2;
        continue;
      }
      a(1, localWepkgVersion.mtT, str, "", localWepkgVersion.downloadUrl, localWepkgVersion.XGK, localWepkgVersion.version, "", localWepkgVersion.md5, localWepkgVersion.XFQ, paramIWepkgUpdateCallback);
      AppMethodBeat.o(110611);
      break;
      label532:
      bool1 = true;
    }
  }
  
  public static abstract interface IWepkgUpdateCallback
  {
    public abstract void a(String paramString1, String paramString2, RetCode paramRetCode);
    
    public static enum RetCode
      implements Parcelable
    {
      public static final Parcelable.Creator<RetCode> CREATOR;
      
      static
      {
        AppMethodBeat.i(110608);
        XFh = new RetCode("OK", 0);
        XFi = new RetCode("LOCAL_FILE_NOT_FOUND", 1);
        XFj = new RetCode("PKG_INTEGRITY_FAILED", 2);
        XFk = new RetCode("PKG_INVALID", 3);
        XFl = new RetCode("FAILED", 4);
        XFm = new RetCode("CANCEL", 5);
        XFn = new RetCode[] { XFh, XFi, XFj, XFk, XFl, XFm };
        CREATOR = new Parcelable.Creator() {};
        AppMethodBeat.o(110608);
      }
      
      private RetCode() {}
      
      public final int describeContents()
      {
        return 0;
      }
      
      public final void writeToParcel(Parcel paramParcel, int paramInt)
      {
        AppMethodBeat.i(110607);
        paramParcel.writeInt(ordinal());
        AppMethodBeat.o(110607);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.wepkg.downloader.WePkgDownloader
 * JD-Core Version:    0.7.0.1
 */