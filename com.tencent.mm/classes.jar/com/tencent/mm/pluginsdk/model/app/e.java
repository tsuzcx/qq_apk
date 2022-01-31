package com.tencent.mm.pluginsdk.model.app;

import android.os.HandlerThread;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.z.a;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.am;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.util.List;
import java.util.Map;

public final class e
{
  public Map<String, Integer> fXi = null;
  private ah handler = new e.2(this, g.DS().mnU.getLooper());
  public List<r> nVU = null;
  public List<r> rTX = null;
  private am rTY = new am(new e.1(this), false);
  
  public e()
  {
    this.rTY.S(600000L, 600000L);
  }
  
  final boolean a(r paramr)
  {
    if (paramr == null)
    {
      y.e("MicroMsg.AppIconService", "startDownload fail, geticoninfo is null");
      return false;
    }
    int i;
    if (paramr == null)
    {
      y.e("MicroMsg.AppIconService", "increaseCounter fail, info is null");
      i = 0;
    }
    while (i == 0)
    {
      y.e("MicroMsg.AppIconService", "increaseCounter fail");
      return false;
      localObject = Integer.valueOf(bk.a((Integer)this.fXi.get(paramr.toString()), 0));
      if (((Integer)localObject).intValue() >= 5)
      {
        y.e("MicroMsg.AppIconService", "increaseCounter fail, has reached the max try count");
        i = 0;
      }
      else
      {
        this.fXi.put(paramr.toString(), Integer.valueOf(((Integer)localObject).intValue() + 1));
        i = 1;
      }
    }
    Object localObject = a.brn().VU(paramr.appId);
    if (localObject == null)
    {
      y.e("MicroMsg.AppIconService", "push, appinfo does not exist, appId = " + paramr.appId);
      return false;
    }
    switch (paramr.ezA)
    {
    default: 
      y.e("MicroMsg.AppIconService", "push, unknown iconType = " + paramr.ezA);
      return false;
    case 1: 
      if ((((f)localObject).field_appIconUrl == null) || (((f)localObject).field_appIconUrl.length() == 0))
      {
        y.e("MicroMsg.AppIconService", "push, appIconUrl is null, appId = " + paramr.appId);
        return false;
      }
      localObject = ((f)localObject).field_appIconUrl;
    }
    for (;;)
    {
      y.i("MicroMsg.AppIconService", "appIconUrl = " + (String)localObject);
      com.tencent.mm.sdk.f.e.post(new s(this.handler, paramr.appId, paramr.ezA, (String)localObject), "AppIconService_getIcon");
      return true;
      if ((((f)localObject).field_appWatermarkUrl == null) || (((f)localObject).field_appWatermarkUrl.length() == 0))
      {
        y.e("MicroMsg.AppIconService", "push, appWatermarkUrl is null, appId = " + paramr.appId);
        return false;
      }
      localObject = ((f)localObject).field_appWatermarkUrl;
      continue;
      if ((((com.tencent.mm.h.c.r)localObject).cvF == null) || (((com.tencent.mm.h.c.r)localObject).cvF.length() == 0))
      {
        y.e("MicroMsg.AppIconService", "push, appSuggestionIconUrl is null, appId = " + paramr.appId);
        return false;
      }
      localObject = ((com.tencent.mm.h.c.r)localObject).cvF;
      continue;
      if ((((com.tencent.mm.h.c.r)localObject).cvQ == null) || (((com.tencent.mm.h.c.r)localObject).cvQ.length() == 0))
      {
        y.e("MicroMsg.AppIconService", "push, servicePanelIconUrl is null, appId = " + paramr.appId);
        return false;
      }
      localObject = ((com.tencent.mm.h.c.r)localObject).cvQ;
      continue;
      if ((((com.tencent.mm.h.c.r)localObject).cvR == null) || (((com.tencent.mm.h.c.r)localObject).cvR.length() == 0))
      {
        y.e("MicroMsg.AppIconService", "push, serviceListIconUrl is null, appId = " + paramr.appId);
        return false;
      }
      localObject = ((com.tencent.mm.h.c.r)localObject).cvR;
    }
  }
  
  public final void dg(String paramString, int paramInt)
  {
    if ((paramString == null) || (paramString.length() == 0)) {
      y.e("MicroMsg.AppIconService", "push fail, appId is null");
    }
    r localr;
    do
    {
      do
      {
        return;
        localr = new r(paramString, paramInt);
        if (this.rTX.contains(localr))
        {
          y.i("MicroMsg.AppIconService", "push, appId = " + paramString + ", iconType = " + paramInt + " already in running list");
          return;
        }
        if (this.rTX.size() < 5) {
          break;
        }
        y.i("MicroMsg.AppIconService", "running list has reached the max count");
      } while (this.nVU.contains(localr));
      this.nVU.add(localr);
      return;
    } while (!a(localr));
    this.rTX.add(localr);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.model.app.e
 * JD-Core Version:    0.7.0.1
 */