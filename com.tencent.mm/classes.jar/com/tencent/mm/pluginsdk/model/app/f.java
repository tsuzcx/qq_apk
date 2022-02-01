package com.tencent.mm.pluginsdk.model.app;

import android.os.Looper;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.c.y;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.ab.a;
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
  public List<s> QWa;
  public ConcurrentHashMap<String, Integer> QWb;
  private MTimerHandler QWc;
  private MMHandler handler;
  public List<s> jUI;
  
  public f()
  {
    AppMethodBeat.i(151668);
    this.QWa = null;
    this.jUI = null;
    this.QWb = null;
    this.QWc = new MTimerHandler("AppIconServiceTimer", new MTimerHandler.CallBack()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(151666);
        f.this.QWb.clear();
        AppMethodBeat.o(151666);
        return false;
      }
    }, false);
    this.handler = new MMHandler(h.aHJ().getLooper())
    {
      public final void handleMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(151667);
        paramAnonymousMessage = (x)paramAnonymousMessage.obj;
        s locals = new s(paramAnonymousMessage.appId, paramAnonymousMessage.lZJ);
        if (f.this.QWa.contains(locals))
        {
          f.this.QWa.remove(locals);
          if (!a.fmz().d(paramAnonymousMessage.appId, paramAnonymousMessage.data, paramAnonymousMessage.lZJ)) {
            Log.e("MicroMsg.AppIconService", "handleMessage, saveIcon fail");
          }
        }
        while (f.this.jUI.size() > 0)
        {
          paramAnonymousMessage = (s)f.this.jUI.remove(0);
          if (f.this.a(paramAnonymousMessage))
          {
            f.this.QWa.add(paramAnonymousMessage);
            AppMethodBeat.o(151667);
            return;
          }
        }
        AppMethodBeat.o(151667);
      }
    };
    this.QWa = new ArrayList();
    this.jUI = new ArrayList();
    this.QWb = new ConcurrentHashMap();
    this.QWc.startTimer(600000L);
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
    Integer localInteger = Integer.valueOf(Util.nullAs((Integer)this.QWb.get(params.toString()), 0));
    if (localInteger.intValue() >= 5)
    {
      Log.e("MicroMsg.AppIconService", "increaseCounter fail, has reached the max try count");
      AppMethodBeat.o(151671);
      return false;
    }
    this.QWb.put(params.toString(), Integer.valueOf(localInteger.intValue() + 1));
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
    Object localObject = a.fmz().bqc(params.appId);
    if (localObject == null)
    {
      Log.e("MicroMsg.AppIconService", "push, appinfo does not exist, appId = " + params.appId);
      AppMethodBeat.o(151670);
      return false;
    }
    switch (params.lZJ)
    {
    default: 
      Log.e("MicroMsg.AppIconService", "push, unknown iconType = " + params.lZJ);
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
      ThreadPool.post(new t(this.handler, params.appId, params.lZJ, (String)localObject), "AppIconService_getIcon");
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
      if ((((y)localObject).hrK == null) || (((y)localObject).hrK.length() == 0))
      {
        Log.e("MicroMsg.AppIconService", "push, appSuggestionIconUrl is null, appId = " + params.appId);
        AppMethodBeat.o(151670);
        return false;
      }
      localObject = ((y)localObject).hrK;
      continue;
      if ((((y)localObject).hrV == null) || (((y)localObject).hrV.length() == 0))
      {
        Log.e("MicroMsg.AppIconService", "push, servicePanelIconUrl is null, appId = " + params.appId);
        AppMethodBeat.o(151670);
        return false;
      }
      localObject = ((y)localObject).hrV;
      continue;
      if ((((y)localObject).hrW == null) || (((y)localObject).hrW.length() == 0))
      {
        Log.e("MicroMsg.AppIconService", "push, serviceListIconUrl is null, appId = " + params.appId);
        AppMethodBeat.o(151670);
        return false;
      }
      localObject = ((y)localObject).hrW;
    }
  }
  
  public final void hm(String paramString, int paramInt)
  {
    AppMethodBeat.i(151669);
    if ((paramString == null) || (paramString.length() == 0))
    {
      Log.e("MicroMsg.AppIconService", "push fail, appId is null");
      AppMethodBeat.o(151669);
      return;
    }
    s locals = new s(paramString, paramInt);
    if (this.QWa.contains(locals))
    {
      Log.i("MicroMsg.AppIconService", "push, appId = " + paramString + ", iconType = " + paramInt + " already in running list");
      AppMethodBeat.o(151669);
      return;
    }
    if (this.QWa.size() >= 5)
    {
      Log.i("MicroMsg.AppIconService", "running list has reached the max count");
      if (!this.jUI.contains(locals)) {
        this.jUI.add(locals);
      }
      AppMethodBeat.o(151669);
      return;
    }
    if (a(locals)) {
      this.QWa.add(locals);
    }
    AppMethodBeat.o(151669);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.model.app.f
 * JD-Core Version:    0.7.0.1
 */