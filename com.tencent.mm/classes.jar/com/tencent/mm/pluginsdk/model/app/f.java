package com.tencent.mm.pluginsdk.model.app;

import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.y;
import com.tencent.mm.plugin.s.a;
import com.tencent.mm.sdk.g.b;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.aw;
import com.tencent.mm.sdk.platformtools.aw.a;
import com.tencent.mm.sdk.platformtools.bu;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public final class f
{
  public List<s> FeW;
  public ConcurrentHashMap<String, Integer> FeX;
  private aw FeY;
  public List<s> gvV;
  private aq handler;
  
  public f()
  {
    AppMethodBeat.i(151668);
    this.FeW = null;
    this.gvV = null;
    this.FeX = null;
    this.FeY = new aw("AppIconServiceTimer", new aw.a()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(151666);
        f.this.FeX.clear();
        AppMethodBeat.o(151666);
        return false;
      }
    }, false);
    this.handler = new aq(com.tencent.mm.kernel.g.ajU().IxZ.getLooper())
    {
      public final void handleMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(151667);
        paramAnonymousMessage = (x)paramAnonymousMessage.obj;
        s locals = new s(paramAnonymousMessage.appId, paramAnonymousMessage.ioG);
        if (f.this.FeW.contains(locals))
        {
          f.this.FeW.remove(locals);
          if (!a.dBg().d(paramAnonymousMessage.appId, paramAnonymousMessage.data, paramAnonymousMessage.ioG)) {
            ae.e("MicroMsg.AppIconService", "handleMessage, saveIcon fail");
          }
        }
        while (f.this.gvV.size() > 0)
        {
          paramAnonymousMessage = (s)f.this.gvV.remove(0);
          if (f.this.a(paramAnonymousMessage))
          {
            f.this.FeW.add(paramAnonymousMessage);
            AppMethodBeat.o(151667);
            return;
          }
        }
        AppMethodBeat.o(151667);
      }
    };
    this.FeW = new ArrayList();
    this.gvV = new ArrayList();
    this.FeX = new ConcurrentHashMap();
    this.FeY.ay(600000L, 600000L);
    AppMethodBeat.o(151668);
  }
  
  private boolean b(s params)
  {
    AppMethodBeat.i(151671);
    if (params == null)
    {
      ae.e("MicroMsg.AppIconService", "increaseCounter fail, info is null");
      AppMethodBeat.o(151671);
      return false;
    }
    Integer localInteger = Integer.valueOf(bu.a((Integer)this.FeX.get(params.toString()), 0));
    if (localInteger.intValue() >= 5)
    {
      ae.e("MicroMsg.AppIconService", "increaseCounter fail, has reached the max try count");
      AppMethodBeat.o(151671);
      return false;
    }
    this.FeX.put(params.toString(), Integer.valueOf(localInteger.intValue() + 1));
    AppMethodBeat.o(151671);
    return true;
  }
  
  final boolean a(s params)
  {
    AppMethodBeat.i(151670);
    if (params == null)
    {
      ae.e("MicroMsg.AppIconService", "startDownload fail, geticoninfo is null");
      AppMethodBeat.o(151670);
      return false;
    }
    if (!b(params))
    {
      ae.e("MicroMsg.AppIconService", "increaseCounter fail");
      AppMethodBeat.o(151670);
      return false;
    }
    Object localObject = a.dBg().aNg(params.appId);
    if (localObject == null)
    {
      ae.e("MicroMsg.AppIconService", "push, appinfo does not exist, appId = " + params.appId);
      AppMethodBeat.o(151670);
      return false;
    }
    switch (params.ioG)
    {
    default: 
      ae.e("MicroMsg.AppIconService", "push, unknown iconType = " + params.ioG);
      AppMethodBeat.o(151670);
      return false;
    case 1: 
      if ((((g)localObject).field_appIconUrl == null) || (((g)localObject).field_appIconUrl.length() == 0))
      {
        ae.e("MicroMsg.AppIconService", "push, appIconUrl is null, appId = " + params.appId);
        AppMethodBeat.o(151670);
        return false;
      }
      localObject = ((g)localObject).field_appIconUrl;
    }
    for (;;)
    {
      ae.i("MicroMsg.AppIconService", "appIconUrl = ".concat(String.valueOf(localObject)));
      b.c(new t(this.handler, params.appId, params.ioG, (String)localObject), "AppIconService_getIcon");
      AppMethodBeat.o(151670);
      return true;
      if ((((g)localObject).field_appWatermarkUrl == null) || (((g)localObject).field_appWatermarkUrl.length() == 0))
      {
        ae.e("MicroMsg.AppIconService", "push, appWatermarkUrl is null, appId = " + params.appId);
        AppMethodBeat.o(151670);
        return false;
      }
      localObject = ((g)localObject).field_appWatermarkUrl;
      continue;
      if ((((y)localObject).eJj == null) || (((y)localObject).eJj.length() == 0))
      {
        ae.e("MicroMsg.AppIconService", "push, appSuggestionIconUrl is null, appId = " + params.appId);
        AppMethodBeat.o(151670);
        return false;
      }
      localObject = ((y)localObject).eJj;
      continue;
      if ((((y)localObject).eJu == null) || (((y)localObject).eJu.length() == 0))
      {
        ae.e("MicroMsg.AppIconService", "push, servicePanelIconUrl is null, appId = " + params.appId);
        AppMethodBeat.o(151670);
        return false;
      }
      localObject = ((y)localObject).eJu;
      continue;
      if ((((y)localObject).eJv == null) || (((y)localObject).eJv.length() == 0))
      {
        ae.e("MicroMsg.AppIconService", "push, serviceListIconUrl is null, appId = " + params.appId);
        AppMethodBeat.o(151670);
        return false;
      }
      localObject = ((y)localObject).eJv;
    }
  }
  
  public final void gf(String paramString, int paramInt)
  {
    AppMethodBeat.i(151669);
    if ((paramString == null) || (paramString.length() == 0))
    {
      ae.e("MicroMsg.AppIconService", "push fail, appId is null");
      AppMethodBeat.o(151669);
      return;
    }
    s locals = new s(paramString, paramInt);
    if (this.FeW.contains(locals))
    {
      ae.i("MicroMsg.AppIconService", "push, appId = " + paramString + ", iconType = " + paramInt + " already in running list");
      AppMethodBeat.o(151669);
      return;
    }
    if (this.FeW.size() >= 5)
    {
      ae.i("MicroMsg.AppIconService", "running list has reached the max count");
      if (!this.gvV.contains(locals)) {
        this.gvV.add(locals);
      }
      AppMethodBeat.o(151669);
      return;
    }
    if (a(locals)) {
      this.FeW.add(locals);
    }
    AppMethodBeat.o(151669);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.model.app.f
 * JD-Core Version:    0.7.0.1
 */