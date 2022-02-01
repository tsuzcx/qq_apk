package com.tencent.mm.pluginsdk.model.app;

import android.os.Looper;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.y;
import com.tencent.mm.plugin.r.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.thread.ThreadPool;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public final class f
{
  public List<s> JVN;
  public ConcurrentHashMap<String, Integer> JVO;
  private MTimerHandler JVP;
  private MMHandler handler;
  public List<s> hiK;
  
  public f()
  {
    AppMethodBeat.i(151668);
    this.JVN = null;
    this.hiK = null;
    this.JVO = null;
    this.JVP = new MTimerHandler("AppIconServiceTimer", new MTimerHandler.CallBack()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(151666);
        f.this.JVO.clear();
        AppMethodBeat.o(151666);
        return false;
      }
    }, false);
    this.handler = new MMHandler(com.tencent.mm.kernel.g.aAk().getLooper())
    {
      public final void handleMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(151667);
        paramAnonymousMessage = (x)paramAnonymousMessage.obj;
        s locals = new s(paramAnonymousMessage.appId, paramAnonymousMessage.jjN);
        if (f.this.JVN.contains(locals))
        {
          f.this.JVN.remove(locals);
          if (!a.eAS().d(paramAnonymousMessage.appId, paramAnonymousMessage.data, paramAnonymousMessage.jjN)) {
            Log.e("MicroMsg.AppIconService", "handleMessage, saveIcon fail");
          }
        }
        while (f.this.hiK.size() > 0)
        {
          paramAnonymousMessage = (s)f.this.hiK.remove(0);
          if (f.this.a(paramAnonymousMessage))
          {
            f.this.JVN.add(paramAnonymousMessage);
            AppMethodBeat.o(151667);
            return;
          }
        }
        AppMethodBeat.o(151667);
      }
    };
    this.JVN = new ArrayList();
    this.hiK = new ArrayList();
    this.JVO = new ConcurrentHashMap();
    this.JVP.startTimer(600000L);
    AppMethodBeat.o(151668);
  }
  
  private boolean b(s params)
  {
    AppMethodBeat.i(151671);
    if (params == null)
    {
      Log.e("MicroMsg.AppIconService", "increaseCounter fail, info is null");
      AppMethodBeat.o(151671);
      return false;
    }
    Integer localInteger = Integer.valueOf(Util.nullAs((Integer)this.JVO.get(params.toString()), 0));
    if (localInteger.intValue() >= 5)
    {
      Log.e("MicroMsg.AppIconService", "increaseCounter fail, has reached the max try count");
      AppMethodBeat.o(151671);
      return false;
    }
    this.JVO.put(params.toString(), Integer.valueOf(localInteger.intValue() + 1));
    AppMethodBeat.o(151671);
    return true;
  }
  
  final boolean a(s params)
  {
    AppMethodBeat.i(151670);
    if (params == null)
    {
      Log.e("MicroMsg.AppIconService", "startDownload fail, geticoninfo is null");
      AppMethodBeat.o(151670);
      return false;
    }
    if (!b(params))
    {
      Log.e("MicroMsg.AppIconService", "increaseCounter fail");
      AppMethodBeat.o(151670);
      return false;
    }
    Object localObject = a.eAS().bdG(params.appId);
    if (localObject == null)
    {
      Log.e("MicroMsg.AppIconService", "push, appinfo does not exist, appId = " + params.appId);
      AppMethodBeat.o(151670);
      return false;
    }
    switch (params.jjN)
    {
    default: 
      Log.e("MicroMsg.AppIconService", "push, unknown iconType = " + params.jjN);
      AppMethodBeat.o(151670);
      return false;
    case 1: 
      if ((((g)localObject).field_appIconUrl == null) || (((g)localObject).field_appIconUrl.length() == 0))
      {
        Log.e("MicroMsg.AppIconService", "push, appIconUrl is null, appId = " + params.appId);
        AppMethodBeat.o(151670);
        return false;
      }
      localObject = ((g)localObject).field_appIconUrl;
    }
    for (;;)
    {
      Log.i("MicroMsg.AppIconService", "appIconUrl = ".concat(String.valueOf(localObject)));
      ThreadPool.post(new t(this.handler, params.appId, params.jjN, (String)localObject), "AppIconService_getIcon");
      AppMethodBeat.o(151670);
      return true;
      if ((((g)localObject).field_appWatermarkUrl == null) || (((g)localObject).field_appWatermarkUrl.length() == 0))
      {
        Log.e("MicroMsg.AppIconService", "push, appWatermarkUrl is null, appId = " + params.appId);
        AppMethodBeat.o(151670);
        return false;
      }
      localObject = ((g)localObject).field_appWatermarkUrl;
      continue;
      if ((((y)localObject).fmL == null) || (((y)localObject).fmL.length() == 0))
      {
        Log.e("MicroMsg.AppIconService", "push, appSuggestionIconUrl is null, appId = " + params.appId);
        AppMethodBeat.o(151670);
        return false;
      }
      localObject = ((y)localObject).fmL;
      continue;
      if ((((y)localObject).fmW == null) || (((y)localObject).fmW.length() == 0))
      {
        Log.e("MicroMsg.AppIconService", "push, servicePanelIconUrl is null, appId = " + params.appId);
        AppMethodBeat.o(151670);
        return false;
      }
      localObject = ((y)localObject).fmW;
      continue;
      if ((((y)localObject).fmX == null) || (((y)localObject).fmX.length() == 0))
      {
        Log.e("MicroMsg.AppIconService", "push, serviceListIconUrl is null, appId = " + params.appId);
        AppMethodBeat.o(151670);
        return false;
      }
      localObject = ((y)localObject).fmX;
    }
  }
  
  public final void gD(String paramString, int paramInt)
  {
    AppMethodBeat.i(151669);
    if ((paramString == null) || (paramString.length() == 0))
    {
      Log.e("MicroMsg.AppIconService", "push fail, appId is null");
      AppMethodBeat.o(151669);
      return;
    }
    s locals = new s(paramString, paramInt);
    if (this.JVN.contains(locals))
    {
      Log.i("MicroMsg.AppIconService", "push, appId = " + paramString + ", iconType = " + paramInt + " already in running list");
      AppMethodBeat.o(151669);
      return;
    }
    if (this.JVN.size() >= 5)
    {
      Log.i("MicroMsg.AppIconService", "running list has reached the max count");
      if (!this.hiK.contains(locals)) {
        this.hiK.add(locals);
      }
      AppMethodBeat.o(151669);
      return;
    }
    if (a(locals)) {
      this.JVN.add(locals);
    }
    AppMethodBeat.o(151669);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.model.app.f
 * JD-Core Version:    0.7.0.1
 */