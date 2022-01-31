package com.tencent.mm.pluginsdk.model.app;

import android.os.HandlerThread;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.t;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.s.a;
import com.tencent.mm.sdk.g.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class e
{
  private ak handler;
  public Map<String, Integer> hqI;
  public List<r> qKd;
  public List<r> vKU;
  private ap vKV;
  
  public e()
  {
    AppMethodBeat.i(79244);
    this.vKU = null;
    this.qKd = null;
    this.hqI = null;
    this.vKV = new ap(new e.1(this), false);
    this.handler = new e.2(this, g.RO().oNc.getLooper());
    this.vKU = new ArrayList();
    this.qKd = new ArrayList();
    this.hqI = new HashMap();
    this.vKV.ag(600000L, 600000L);
    AppMethodBeat.o(79244);
  }
  
  private boolean b(r paramr)
  {
    AppMethodBeat.i(79247);
    if (paramr == null)
    {
      ab.e("MicroMsg.AppIconService", "increaseCounter fail, info is null");
      AppMethodBeat.o(79247);
      return false;
    }
    Integer localInteger = Integer.valueOf(bo.a((Integer)this.hqI.get(paramr.toString()), 0));
    if (localInteger.intValue() >= 5)
    {
      ab.e("MicroMsg.AppIconService", "increaseCounter fail, has reached the max try count");
      AppMethodBeat.o(79247);
      return false;
    }
    this.hqI.put(paramr.toString(), Integer.valueOf(localInteger.intValue() + 1));
    AppMethodBeat.o(79247);
    return true;
  }
  
  final boolean a(r paramr)
  {
    AppMethodBeat.i(79246);
    if (paramr == null)
    {
      ab.e("MicroMsg.AppIconService", "startDownload fail, geticoninfo is null");
      AppMethodBeat.o(79246);
      return false;
    }
    if (!b(paramr))
    {
      ab.e("MicroMsg.AppIconService", "increaseCounter fail");
      AppMethodBeat.o(79246);
      return false;
    }
    Object localObject = a.cac().als(paramr.appId);
    if (localObject == null)
    {
      ab.e("MicroMsg.AppIconService", "push, appinfo does not exist, appId = " + paramr.appId);
      AppMethodBeat.o(79246);
      return false;
    }
    switch (paramr.fPp)
    {
    default: 
      ab.e("MicroMsg.AppIconService", "push, unknown iconType = " + paramr.fPp);
      AppMethodBeat.o(79246);
      return false;
    case 1: 
      if ((((f)localObject).field_appIconUrl == null) || (((f)localObject).field_appIconUrl.length() == 0))
      {
        ab.e("MicroMsg.AppIconService", "push, appIconUrl is null, appId = " + paramr.appId);
        AppMethodBeat.o(79246);
        return false;
      }
      localObject = ((f)localObject).field_appIconUrl;
    }
    for (;;)
    {
      ab.i("MicroMsg.AppIconService", "appIconUrl = ".concat(String.valueOf(localObject)));
      d.post(new s(this.handler, paramr.appId, paramr.fPp, (String)localObject), "AppIconService_getIcon");
      AppMethodBeat.o(79246);
      return true;
      if ((((f)localObject).field_appWatermarkUrl == null) || (((f)localObject).field_appWatermarkUrl.length() == 0))
      {
        ab.e("MicroMsg.AppIconService", "push, appWatermarkUrl is null, appId = " + paramr.appId);
        AppMethodBeat.o(79246);
        return false;
      }
      localObject = ((f)localObject).field_appWatermarkUrl;
      continue;
      if ((((t)localObject).djQ == null) || (((t)localObject).djQ.length() == 0))
      {
        ab.e("MicroMsg.AppIconService", "push, appSuggestionIconUrl is null, appId = " + paramr.appId);
        AppMethodBeat.o(79246);
        return false;
      }
      localObject = ((t)localObject).djQ;
      continue;
      if ((((t)localObject).dkb == null) || (((t)localObject).dkb.length() == 0))
      {
        ab.e("MicroMsg.AppIconService", "push, servicePanelIconUrl is null, appId = " + paramr.appId);
        AppMethodBeat.o(79246);
        return false;
      }
      localObject = ((t)localObject).dkb;
      continue;
      if ((((t)localObject).dkc == null) || (((t)localObject).dkc.length() == 0))
      {
        ab.e("MicroMsg.AppIconService", "push, serviceListIconUrl is null, appId = " + paramr.appId);
        AppMethodBeat.o(79246);
        return false;
      }
      localObject = ((t)localObject).dkc;
    }
  }
  
  public final void el(String paramString, int paramInt)
  {
    AppMethodBeat.i(79245);
    if ((paramString == null) || (paramString.length() == 0))
    {
      ab.e("MicroMsg.AppIconService", "push fail, appId is null");
      AppMethodBeat.o(79245);
      return;
    }
    r localr = new r(paramString, paramInt);
    if (this.vKU.contains(localr))
    {
      ab.i("MicroMsg.AppIconService", "push, appId = " + paramString + ", iconType = " + paramInt + " already in running list");
      AppMethodBeat.o(79245);
      return;
    }
    if (this.vKU.size() >= 5)
    {
      ab.i("MicroMsg.AppIconService", "running list has reached the max count");
      if (!this.qKd.contains(localr)) {
        this.qKd.add(localr);
      }
      AppMethodBeat.o(79245);
      return;
    }
    if (a(localr)) {
      this.vKU.add(localr);
    }
    AppMethodBeat.o(79245);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.model.app.e
 * JD-Core Version:    0.7.0.1
 */