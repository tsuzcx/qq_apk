package com.tencent.mm.plugin.wepkg.downloader;

import com.tencent.mm.a.e;
import com.tencent.mm.a.g;
import com.tencent.mm.plugin.wepkg.c.a.a;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class WePkgDownloader
{
  private static volatile WePkgDownloader rOr = null;
  private Map<String, WePkgDownloader.IWepkgUpdateCallback> rOs;
  private a rOt = new WePkgDownloader.1(this);
  
  public WePkgDownloader()
  {
    if (this.rOs == null) {
      this.rOs = new ConcurrentHashMap();
    }
  }
  
  private void a(File paramFile, String paramString, List<String> paramList)
  {
    if ((paramFile == null) || (!paramFile.exists())) {}
    for (;;)
    {
      return;
      if ((paramFile.isFile()) && (paramFile.getName().equals(paramString)))
      {
        paramString = paramList;
        if (paramList == null) {
          paramString = new ArrayList();
        }
        paramString.add(paramFile.getAbsolutePath());
        return;
      }
      if (paramFile.isDirectory())
      {
        paramFile = paramFile.listFiles();
        if (paramFile != null)
        {
          int i = 0;
          while (i < paramFile.length)
          {
            a(paramFile[i], paramString, paramList);
            i += 1;
          }
        }
      }
    }
  }
  
  public static WePkgDownloader cjU()
  {
    if (rOr == null) {}
    try
    {
      if (rOr == null) {
        rOr = new WePkgDownloader();
      }
      return rOr;
    }
    finally {}
  }
  
  public final void a(int paramInt1, String paramString1, String paramString2, String paramString3, long paramLong, String paramString4, String paramString5, int paramInt2, WePkgDownloader.IWepkgUpdateCallback paramIWepkgUpdateCallback)
  {
    y.i("MicroMsg.Wepkg.WepkgDownloader", "triggerDownloadWepkg, fileType:%s, pkgid:%s, downloadUrl:%s, pkgSize:%d, version:%s, md5:%s, downloadNetType:%d", new Object[] { Integer.valueOf(paramInt1), paramString1, paramString3, Long.valueOf(paramLong), paramString4, paramString5, Integer.valueOf(paramInt2) });
    Object localObject1;
    if (paramInt1 == 1)
    {
      localObject1 = com.tencent.mm.plugin.wepkg.utils.d.fN(paramString1, paramString4);
      com.tencent.mm.plugin.wepkg.utils.d.Vu((String)localObject1);
    }
    for (String str = (String)localObject1 + "/package"; bk.bl(str); str = (String)localObject1 + "/" + paramString5)
    {
      y.i("MicroMsg.Wepkg.WepkgDownloader", "pkgPath:%s is null", new Object[] { str });
      a.a.ckb().g(paramString1, paramString3, 0L);
      paramIWepkgUpdateCallback.a(paramString1, "", WePkgDownloader.IWepkgUpdateCallback.RetCode.rOz);
      return;
      localObject1 = com.tencent.mm.plugin.wepkg.utils.d.fN(paramString1, paramString4) + "/preload_files";
      com.tencent.mm.plugin.wepkg.utils.d.Vu((String)localObject1);
    }
    if (com.tencent.mm.pluginsdk.g.a.d.a.bK(str))
    {
      if (bk.pm(g.bQ(str)).equals(paramString5))
      {
        y.i("MicroMsg.Wepkg.WepkgDownloader", "file exist in current %s version, pkgPath:%s", new Object[] { paramString4, str });
        a.a.ckb().g(paramString1, paramString3, 0L);
        paramIWepkgUpdateCallback.a(paramString1, str, WePkgDownloader.IWepkgUpdateCallback.RetCode.rOv);
      }
    }
    else
    {
      localObject1 = com.tencent.mm.plugin.wepkg.utils.d.Vp(paramString1);
      if (!bk.bl((String)localObject1))
      {
        File localFile = new File((String)localObject1);
        ArrayList localArrayList = new ArrayList();
        if ((str == null) || (str.length() <= 0)) {
          localObject1 = "";
        }
        for (;;)
        {
          a(localFile, (String)localObject1, localArrayList);
          y.i("MicroMsg.Wepkg.WepkgDownloader", "local have the same file. size:%s", new Object[] { Integer.valueOf(localArrayList.size()) });
          localObject1 = localArrayList.iterator();
          do
          {
            if (!((Iterator)localObject1).hasNext()) {
              break;
            }
            localObject2 = new File((String)((Iterator)localObject1).next());
          } while ((!((File)localObject2).isFile()) || (((File)localObject2).length() != paramLong) || (!bk.pm(g.m((File)localObject2)).equalsIgnoreCase(paramString5)));
          e.r(((File)localObject2).getAbsolutePath(), str);
          y.i("MicroMsg.Wepkg.WepkgDownloader", "file exist in other version path:%s, pkgPath:%s", new Object[] { ((File)localObject2).getAbsolutePath(), str });
          a.a.ckb().g(paramString1, paramString3, 0L);
          paramIWepkgUpdateCallback.a(paramString1, str, WePkgDownloader.IWepkgUpdateCallback.RetCode.rOv);
          return;
          Object localObject2 = new File(str).getName();
          i = ((String)localObject2).lastIndexOf('.');
          localObject1 = localObject2;
          if (i >= 0) {
            if (i == 0) {
              localObject1 = "";
            } else {
              localObject1 = ((String)localObject2).substring(0, i);
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
        a.a.ckb().g(paramString1, paramString3, paramLong);
        label660:
        y.i("MicroMsg.Wepkg.WepkgDownloader", "allowDownload:%s", new Object[] { Boolean.valueOf(bool1) });
        if (!bool1) {
          break label987;
        }
        paramString2 = new c(new f(g.o(paramString3.getBytes()), paramInt1, paramString1, paramString2, paramString4, paramString3, str, paramLong, paramString5, bool2, this.rOt));
        paramString4 = d.cjS();
        if (paramString4.rOq.containsKey(paramString2.rOg.rOD)) {
          break label968;
        }
        paramString2.rOh = b.cjQ().rOf.submit(paramString2);
        paramString4.rOq.put(paramString2.rOg.rOD, paramString2);
      }
      break;
    }
    label968:
    for (paramInt1 = 1;; paramInt1 = 0)
    {
      if (paramInt1 == 0) {
        break label973;
      }
      this.rOs.put(g.o(paramString3.getBytes()), paramIWepkgUpdateCallback);
      com.tencent.mm.plugin.report.service.h.nFQ.a(859L, 0L, 1L, false);
      return;
      bool1 = true;
      for (;;)
      {
        i = 1;
        bool2 = bool3;
        break;
        if (!aq.fK(ae.getContext()))
        {
          bool1 = bool6;
          if (!aq.is3G(ae.getContext())) {}
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
        if (!aq.isWifi(ae.getContext())) {
          break;
        }
        bool1 = true;
        bool2 = true;
        i = j;
        break;
        if (aq.isWifi(ae.getContext()))
        {
          bool1 = true;
        }
        else if (!aq.fK(ae.getContext()))
        {
          bool1 = bool4;
          if (!aq.is3G(ae.getContext())) {}
        }
        else
        {
          bool1 = bool4;
          if (com.tencent.mm.plugin.wepkg.utils.d.cke()) {
            bool1 = true;
          }
        }
      }
      a.a.ckb().g(paramString1, paramString3, 0L);
      break label660;
    }
    label973:
    paramIWepkgUpdateCallback.a(paramString1, "", WePkgDownloader.IWepkgUpdateCallback.RetCode.rOA);
    return;
    label987:
    y.i("MicroMsg.Wepkg.WepkgDownloader", "net is not match, dont download");
    paramIWepkgUpdateCallback.a(paramString1, "", WePkgDownloader.IWepkgUpdateCallback.RetCode.rOA);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wepkg.downloader.WePkgDownloader
 * JD-Core Version:    0.7.0.1
 */