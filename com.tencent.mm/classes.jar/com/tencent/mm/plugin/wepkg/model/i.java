package com.tencent.mm.plugin.wepkg.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.wi;
import com.tencent.mm.plugin.wepkg.ipc.WepkgMainProcessService;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.List;

public class i
{
  private static volatile i vGE = null;
  
  private void a(String paramString, List<WepkgPreloadFile> paramList, boolean paramBoolean)
  {
    AppMethodBeat.i(63595);
    for (;;)
    {
      try
      {
        if (!bo.es(paramList)) {
          break label265;
        }
        ab.i("MicroMsg.Wepkg.WepkgUpdater", "loopDownload WepkgPreloadFile is empty");
        if (bo.isNullOrNil(paramString))
        {
          x(paramBoolean, paramString);
          AppMethodBeat.o(63595);
          return;
        }
        paramList = h.akH(paramString);
        if (!bo.es(paramList)) {
          break;
        }
        paramList = new WepkgCrossProcessTask();
        paramList.vA = 3006;
        paramList.vGb.ezY = paramString;
        paramList.vGb.vGR = true;
        if (ah.brt())
        {
          paramList.ata();
          paramList = h.akF(paramString);
          if ((paramList != null) && (paramList.createTime != 0L))
          {
            com.tencent.mm.plugin.wepkg.utils.a.b("downloadCompleteTime", "", paramList.ezY, paramList.version, -1L, System.currentTimeMillis() - paramList.createTime * 1000L, null);
            paramList = new WepkgCrossProcessTask();
            paramList.vA = 3007;
            paramList.vGb.ezY = paramString;
            if (!ah.brt()) {
              break label223;
            }
            paramList.ata();
          }
          x(paramBoolean, paramString);
          ab.i("MicroMsg.Wepkg.WepkgUpdater", "WepkgPreloadFile downloadComplete:true");
          AppMethodBeat.o(63595);
          return;
        }
      }
      catch (Exception paramString)
      {
        ab.e("MicroMsg.Wepkg.WepkgUpdater", "loopDownload err:%s", new Object[] { paramString.getMessage() });
        AppMethodBeat.o(63595);
        return;
      }
      WepkgMainProcessService.b(paramList);
      continue;
      label223:
      WepkgMainProcessService.b(paramList);
    }
    ab.i("MicroMsg.Wepkg.WepkgUpdater", "WepkgPreloadFile downloadComplete:false list.size:%s", new Object[] { Integer.valueOf(paramList.size()) });
    x(paramBoolean, paramString);
    AppMethodBeat.o(63595);
    return;
    label265:
    WepkgPreloadFile localWepkgPreloadFile = (WepkgPreloadFile)paramList.remove(0);
    if (localWepkgPreloadFile != null)
    {
      ab.i("MicroMsg.Wepkg.WepkgUpdater", "download preload files pkgid:%s, version:%s, rid:%s", new Object[] { localWepkgPreloadFile.ezY, localWepkgPreloadFile.version, localWepkgPreloadFile.vGh });
      paramString = new i.3(this, paramString, paramList, paramBoolean);
      paramString.object = localWepkgPreloadFile;
      h.a(2, localWepkgPreloadFile.ezY, localWepkgPreloadFile.vGh, localWepkgPreloadFile.downloadUrl, localWepkgPreloadFile.size, localWepkgPreloadFile.version, localWepkgPreloadFile.cqq, localWepkgPreloadFile.vFT, paramString);
      AppMethodBeat.o(63595);
      return;
    }
    ab.i("MicroMsg.Wepkg.WepkgUpdater", "download item is null, to loop");
    a(paramString, paramList, paramBoolean);
    AppMethodBeat.o(63595);
  }
  
  public static i dkE()
  {
    AppMethodBeat.i(63593);
    if (vGE == null) {}
    try
    {
      if (vGE == null) {
        vGE = new i();
      }
      i locali = vGE;
      AppMethodBeat.o(63593);
      return locali;
    }
    finally
    {
      AppMethodBeat.o(63593);
    }
  }
  
  private static void x(boolean paramBoolean, String paramString)
  {
    AppMethodBeat.i(63596);
    if (paramBoolean)
    {
      wi localwi = new wi();
      localwi.cNO.coO = 0;
      com.tencent.mm.sdk.b.a.ymk.l(localwi);
    }
    h.akK(paramString);
    b.dkA().ee(paramString, 3);
    AppMethodBeat.o(63596);
  }
  
  public final void bX(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(63594);
    if (bo.isNullOrNil(paramString))
    {
      x(paramBoolean, paramString);
      AppMethodBeat.o(63594);
      return;
    }
    i.1 local1 = new i.1(this, paramBoolean, paramString);
    local1.object = paramString;
    ab.i("MicroMsg.Wepkg.WepkgUpdater", "start update wepkg. pkgid:%s, isAutoUpdate:%s", new Object[] { paramString, Boolean.valueOf(paramBoolean) });
    if (bo.isNullOrNil(paramString))
    {
      x(paramBoolean, paramString);
      AppMethodBeat.o(63594);
      return;
    }
    ab.i("MicroMsg.Wepkg.WepkgUpdater", "update big package. pkgid:%s, isAutoUpdate:%s", new Object[] { paramString, Boolean.valueOf(paramBoolean) });
    WepkgVersion localWepkgVersion = h.akF(paramString);
    if (localWepkgVersion == null)
    {
      x(paramBoolean, paramString);
      AppMethodBeat.o(63594);
      return;
    }
    if (!localWepkgVersion.vGQ)
    {
      h.a(1, localWepkgVersion.ezY, "", localWepkgVersion.downloadUrl, localWepkgVersion.vGO, localWepkgVersion.version, localWepkgVersion.cqq, localWepkgVersion.vFT, new i.2(this, local1, paramBoolean, paramString));
      AppMethodBeat.o(63594);
      return;
    }
    paramString = new WepkgCrossProcessTask();
    paramString.cmX = true;
    local1.a(paramString);
    AppMethodBeat.o(63594);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wepkg.model.i
 * JD-Core Version:    0.7.0.1
 */