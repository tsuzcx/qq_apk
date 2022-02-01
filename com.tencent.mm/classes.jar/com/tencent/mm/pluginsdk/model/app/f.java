package com.tencent.mm.pluginsdk.model.app;

import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.y;
import com.tencent.mm.plugin.s.a;
import com.tencent.mm.sdk.g.b;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.au;
import com.tencent.mm.sdk.platformtools.au.a;
import com.tencent.mm.sdk.platformtools.bs;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public final class f
{
  public List<s> DhO;
  public ConcurrentHashMap<String, Integer> DhP;
  private au DhQ;
  public List<s> fZS;
  private ao handler;
  
  public f()
  {
    AppMethodBeat.i(151668);
    this.DhO = null;
    this.fZS = null;
    this.DhP = null;
    this.DhQ = new au("AppIconServiceTimer", new au.a()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(151666);
        f.this.DhP.clear();
        AppMethodBeat.o(151666);
        return false;
      }
    }, false);
    this.handler = new ao(com.tencent.mm.kernel.g.agU().GrZ.getLooper())
    {
      public final void handleMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(151667);
        paramAnonymousMessage = (x)paramAnonymousMessage.obj;
        s locals = new s(paramAnonymousMessage.appId, paramAnonymousMessage.hSw);
        if (f.this.DhO.contains(locals))
        {
          f.this.DhO.remove(locals);
          if (!a.dny().d(paramAnonymousMessage.appId, paramAnonymousMessage.data, paramAnonymousMessage.hSw)) {
            ac.e("MicroMsg.AppIconService", "handleMessage, saveIcon fail");
          }
        }
        while (f.this.fZS.size() > 0)
        {
          paramAnonymousMessage = (s)f.this.fZS.remove(0);
          if (f.this.a(paramAnonymousMessage))
          {
            f.this.DhO.add(paramAnonymousMessage);
            AppMethodBeat.o(151667);
            return;
          }
        }
        AppMethodBeat.o(151667);
      }
    };
    this.DhO = new ArrayList();
    this.fZS = new ArrayList();
    this.DhP = new ConcurrentHashMap();
    this.DhQ.au(600000L, 600000L);
    AppMethodBeat.o(151668);
  }
  
  private boolean b(s params)
  {
    AppMethodBeat.i(151671);
    if (params == null)
    {
      ac.e("MicroMsg.AppIconService", "increaseCounter fail, info is null");
      AppMethodBeat.o(151671);
      return false;
    }
    Integer localInteger = Integer.valueOf(bs.a((Integer)this.DhP.get(params.toString()), 0));
    if (localInteger.intValue() >= 5)
    {
      ac.e("MicroMsg.AppIconService", "increaseCounter fail, has reached the max try count");
      AppMethodBeat.o(151671);
      return false;
    }
    this.DhP.put(params.toString(), Integer.valueOf(localInteger.intValue() + 1));
    AppMethodBeat.o(151671);
    return true;
  }
  
  final boolean a(s params)
  {
    AppMethodBeat.i(151670);
    if (params == null)
    {
      ac.e("MicroMsg.AppIconService", "startDownload fail, geticoninfo is null");
      AppMethodBeat.o(151670);
      return false;
    }
    if (!b(params))
    {
      ac.e("MicroMsg.AppIconService", "increaseCounter fail");
      AppMethodBeat.o(151670);
      return false;
    }
    Object localObject = a.dny().aGk(params.appId);
    if (localObject == null)
    {
      ac.e("MicroMsg.AppIconService", "push, appinfo does not exist, appId = " + params.appId);
      AppMethodBeat.o(151670);
      return false;
    }
    switch (params.hSw)
    {
    default: 
      ac.e("MicroMsg.AppIconService", "push, unknown iconType = " + params.hSw);
      AppMethodBeat.o(151670);
      return false;
    case 1: 
      if ((((g)localObject).field_appIconUrl == null) || (((g)localObject).field_appIconUrl.length() == 0))
      {
        ac.e("MicroMsg.AppIconService", "push, appIconUrl is null, appId = " + params.appId);
        AppMethodBeat.o(151670);
        return false;
      }
      localObject = ((g)localObject).field_appIconUrl;
    }
    for (;;)
    {
      ac.i("MicroMsg.AppIconService", "appIconUrl = ".concat(String.valueOf(localObject)));
      b.c(new t(this.handler, params.appId, params.hSw, (String)localObject), "AppIconService_getIcon");
      AppMethodBeat.o(151670);
      return true;
      if ((((g)localObject).field_appWatermarkUrl == null) || (((g)localObject).field_appWatermarkUrl.length() == 0))
      {
        ac.e("MicroMsg.AppIconService", "push, appWatermarkUrl is null, appId = " + params.appId);
        AppMethodBeat.o(151670);
        return false;
      }
      localObject = ((g)localObject).field_appWatermarkUrl;
      continue;
      if ((((y)localObject).eqr == null) || (((y)localObject).eqr.length() == 0))
      {
        ac.e("MicroMsg.AppIconService", "push, appSuggestionIconUrl is null, appId = " + params.appId);
        AppMethodBeat.o(151670);
        return false;
      }
      localObject = ((y)localObject).eqr;
      continue;
      if ((((y)localObject).eqC == null) || (((y)localObject).eqC.length() == 0))
      {
        ac.e("MicroMsg.AppIconService", "push, servicePanelIconUrl is null, appId = " + params.appId);
        AppMethodBeat.o(151670);
        return false;
      }
      localObject = ((y)localObject).eqC;
      continue;
      if ((((y)localObject).eqD == null) || (((y)localObject).eqD.length() == 0))
      {
        ac.e("MicroMsg.AppIconService", "push, serviceListIconUrl is null, appId = " + params.appId);
        AppMethodBeat.o(151670);
        return false;
      }
      localObject = ((y)localObject).eqD;
    }
  }
  
  public final void fz(String paramString, int paramInt)
  {
    AppMethodBeat.i(151669);
    if ((paramString == null) || (paramString.length() == 0))
    {
      ac.e("MicroMsg.AppIconService", "push fail, appId is null");
      AppMethodBeat.o(151669);
      return;
    }
    s locals = new s(paramString, paramInt);
    if (this.DhO.contains(locals))
    {
      ac.i("MicroMsg.AppIconService", "push, appId = " + paramString + ", iconType = " + paramInt + " already in running list");
      AppMethodBeat.o(151669);
      return;
    }
    if (this.DhO.size() >= 5)
    {
      ac.i("MicroMsg.AppIconService", "running list has reached the max count");
      if (!this.fZS.contains(locals)) {
        this.fZS.add(locals);
      }
      AppMethodBeat.o(151669);
      return;
    }
    if (a(locals)) {
      this.DhO.add(locals);
    }
    AppMethodBeat.o(151669);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.model.app.f
 * JD-Core Version:    0.7.0.1
 */