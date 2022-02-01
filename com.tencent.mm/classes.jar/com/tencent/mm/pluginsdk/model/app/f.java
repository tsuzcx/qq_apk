package com.tencent.mm.pluginsdk.model.app;

import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.y;
import com.tencent.mm.plugin.s.a;
import com.tencent.mm.sdk.g.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.av;
import com.tencent.mm.sdk.platformtools.av.a;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public final class f
{
  public List<s> BPA;
  public ConcurrentHashMap<String, Integer> BPB;
  private av BPC;
  public List<s> fVX;
  private ap handler;
  
  public f()
  {
    AppMethodBeat.i(151668);
    this.BPA = null;
    this.fVX = null;
    this.BPB = null;
    this.BPC = new av("AppIconServiceTimer", new av.a()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(151666);
        f.this.BPB.clear();
        AppMethodBeat.o(151666);
        return false;
      }
    }, false);
    this.handler = new ap(com.tencent.mm.kernel.g.afE().EUN.getLooper())
    {
      public final void handleMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(151667);
        paramAnonymousMessage = (x)paramAnonymousMessage.obj;
        s locals = new s(paramAnonymousMessage.appId, paramAnonymousMessage.hrU);
        if (f.this.BPA.contains(locals))
        {
          f.this.BPA.remove(locals);
          if (!a.cZQ().d(paramAnonymousMessage.appId, paramAnonymousMessage.data, paramAnonymousMessage.hrU)) {
            ad.e("MicroMsg.AppIconService", "handleMessage, saveIcon fail");
          }
        }
        while (f.this.fVX.size() > 0)
        {
          paramAnonymousMessage = (s)f.this.fVX.remove(0);
          if (f.this.a(paramAnonymousMessage))
          {
            f.this.BPA.add(paramAnonymousMessage);
            AppMethodBeat.o(151667);
            return;
          }
        }
        AppMethodBeat.o(151667);
      }
    };
    this.BPA = new ArrayList();
    this.fVX = new ArrayList();
    this.BPB = new ConcurrentHashMap();
    this.BPC.av(600000L, 600000L);
    AppMethodBeat.o(151668);
  }
  
  private boolean b(s params)
  {
    AppMethodBeat.i(151671);
    if (params == null)
    {
      ad.e("MicroMsg.AppIconService", "increaseCounter fail, info is null");
      AppMethodBeat.o(151671);
      return false;
    }
    Integer localInteger = Integer.valueOf(bt.a((Integer)this.BPB.get(params.toString()), 0));
    if (localInteger.intValue() >= 5)
    {
      ad.e("MicroMsg.AppIconService", "increaseCounter fail, has reached the max try count");
      AppMethodBeat.o(151671);
      return false;
    }
    this.BPB.put(params.toString(), Integer.valueOf(localInteger.intValue() + 1));
    AppMethodBeat.o(151671);
    return true;
  }
  
  final boolean a(s params)
  {
    AppMethodBeat.i(151670);
    if (params == null)
    {
      ad.e("MicroMsg.AppIconService", "startDownload fail, geticoninfo is null");
      AppMethodBeat.o(151670);
      return false;
    }
    if (!b(params))
    {
      ad.e("MicroMsg.AppIconService", "increaseCounter fail");
      AppMethodBeat.o(151670);
      return false;
    }
    Object localObject = a.cZQ().aAS(params.appId);
    if (localObject == null)
    {
      ad.e("MicroMsg.AppIconService", "push, appinfo does not exist, appId = " + params.appId);
      AppMethodBeat.o(151670);
      return false;
    }
    switch (params.hrU)
    {
    default: 
      ad.e("MicroMsg.AppIconService", "push, unknown iconType = " + params.hrU);
      AppMethodBeat.o(151670);
      return false;
    case 1: 
      if ((((g)localObject).field_appIconUrl == null) || (((g)localObject).field_appIconUrl.length() == 0))
      {
        ad.e("MicroMsg.AppIconService", "push, appIconUrl is null, appId = " + params.appId);
        AppMethodBeat.o(151670);
        return false;
      }
      localObject = ((g)localObject).field_appIconUrl;
    }
    for (;;)
    {
      ad.i("MicroMsg.AppIconService", "appIconUrl = ".concat(String.valueOf(localObject)));
      b.c(new t(this.handler, params.appId, params.hrU, (String)localObject), "AppIconService_getIcon");
      AppMethodBeat.o(151670);
      return true;
      if ((((g)localObject).field_appWatermarkUrl == null) || (((g)localObject).field_appWatermarkUrl.length() == 0))
      {
        ad.e("MicroMsg.AppIconService", "push, appWatermarkUrl is null, appId = " + params.appId);
        AppMethodBeat.o(151670);
        return false;
      }
      localObject = ((g)localObject).field_appWatermarkUrl;
      continue;
      if ((((y)localObject).eon == null) || (((y)localObject).eon.length() == 0))
      {
        ad.e("MicroMsg.AppIconService", "push, appSuggestionIconUrl is null, appId = " + params.appId);
        AppMethodBeat.o(151670);
        return false;
      }
      localObject = ((y)localObject).eon;
      continue;
      if ((((y)localObject).eoy == null) || (((y)localObject).eoy.length() == 0))
      {
        ad.e("MicroMsg.AppIconService", "push, servicePanelIconUrl is null, appId = " + params.appId);
        AppMethodBeat.o(151670);
        return false;
      }
      localObject = ((y)localObject).eoy;
      continue;
      if ((((y)localObject).eoz == null) || (((y)localObject).eoz.length() == 0))
      {
        ad.e("MicroMsg.AppIconService", "push, serviceListIconUrl is null, appId = " + params.appId);
        AppMethodBeat.o(151670);
        return false;
      }
      localObject = ((y)localObject).eoz;
    }
  }
  
  public final void fu(String paramString, int paramInt)
  {
    AppMethodBeat.i(151669);
    if ((paramString == null) || (paramString.length() == 0))
    {
      ad.e("MicroMsg.AppIconService", "push fail, appId is null");
      AppMethodBeat.o(151669);
      return;
    }
    s locals = new s(paramString, paramInt);
    if (this.BPA.contains(locals))
    {
      ad.i("MicroMsg.AppIconService", "push, appId = " + paramString + ", iconType = " + paramInt + " already in running list");
      AppMethodBeat.o(151669);
      return;
    }
    if (this.BPA.size() >= 5)
    {
      ad.i("MicroMsg.AppIconService", "running list has reached the max count");
      if (!this.fVX.contains(locals)) {
        this.fVX.add(locals);
      }
      AppMethodBeat.o(151669);
      return;
    }
    if (a(locals)) {
      this.BPA.add(locals);
    }
    AppMethodBeat.o(151669);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.model.app.f
 * JD-Core Version:    0.7.0.1
 */