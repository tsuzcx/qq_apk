package com.tencent.mm.pluginsdk.model.app;

import android.os.Looper;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.b.z;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.openapi.a;
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
  public List<w> XRX;
  public ConcurrentHashMap<String, Integer> XRY;
  private MTimerHandler XRZ;
  private MMHandler handler;
  public List<w> muZ;
  
  public f()
  {
    AppMethodBeat.i(151668);
    this.XRX = null;
    this.muZ = null;
    this.XRY = null;
    this.XRZ = new MTimerHandler("AppIconServiceTimer", new MTimerHandler.CallBack()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(151666);
        f.this.XRY.clear();
        AppMethodBeat.o(151666);
        return false;
      }
    }, false);
    this.handler = new MMHandler(h.baH().getLooper())
    {
      public final void handleMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(151667);
        paramAnonymousMessage = (ab)paramAnonymousMessage.obj;
        w localw = new w(paramAnonymousMessage.appId, paramAnonymousMessage.qvo);
        if (f.this.XRX.contains(localw))
        {
          f.this.XRX.remove(localw);
          if (!a.gxn().d(paramAnonymousMessage.appId, paramAnonymousMessage.data, paramAnonymousMessage.qvo)) {
            Log.e("MicroMsg.AppIconService", "handleMessage, saveIcon fail");
          }
        }
        while (f.this.muZ.size() > 0)
        {
          paramAnonymousMessage = (w)f.this.muZ.remove(0);
          if (f.this.a(paramAnonymousMessage))
          {
            f.this.XRX.add(paramAnonymousMessage);
            AppMethodBeat.o(151667);
            return;
          }
        }
        AppMethodBeat.o(151667);
      }
    };
    this.XRX = new ArrayList();
    this.muZ = new ArrayList();
    this.XRY = new ConcurrentHashMap();
    this.XRZ.startTimer(600000L);
    AppMethodBeat.o(151668);
  }
  
  private boolean b(w paramw)
  {
    AppMethodBeat.i(151671);
    if (paramw == null)
    {
      Log.e("MicroMsg.AppIconService", "increaseCounter fail, info is null");
      AppMethodBeat.o(151671);
      return false;
    }
    Integer localInteger = Integer.valueOf(Util.nullAs((Integer)this.XRY.get(paramw.toString()), 0));
    if (localInteger.intValue() >= 5)
    {
      Log.e("MicroMsg.AppIconService", "increaseCounter fail, has reached the max try count");
      AppMethodBeat.o(151671);
      return false;
    }
    this.XRY.put(paramw.toString(), Integer.valueOf(localInteger.intValue() + 1));
    AppMethodBeat.o(151671);
    return true;
  }
  
  final boolean a(w paramw)
  {
    AppMethodBeat.i(151670);
    if (paramw == null)
    {
      Log.e("MicroMsg.AppIconService", "startDownload fail, geticoninfo is null");
      AppMethodBeat.o(151670);
      return false;
    }
    if (!b(paramw))
    {
      Log.e("MicroMsg.AppIconService", "increaseCounter fail");
      AppMethodBeat.o(151670);
      return false;
    }
    Object localObject = a.gxn().bpR(paramw.appId);
    if (localObject == null)
    {
      Log.e("MicroMsg.AppIconService", "push, appinfo does not exist, appId = " + paramw.appId);
      AppMethodBeat.o(151670);
      return false;
    }
    switch (paramw.qvo)
    {
    default: 
      Log.e("MicroMsg.AppIconService", "push, unknown iconType = " + paramw.qvo);
      AppMethodBeat.o(151670);
      return false;
    case 1: 
      if ((((g)localObject).field_appIconUrl == null) || (((g)localObject).field_appIconUrl.length() == 0))
      {
        Log.e("MicroMsg.AppIconService", "push, appIconUrl is null, appId = " + paramw.appId);
        AppMethodBeat.o(151670);
        return false;
      }
      localObject = ((g)localObject).field_appIconUrl;
    }
    for (;;)
    {
      Log.i("MicroMsg.AppIconService", "appIconUrl = ".concat(String.valueOf(localObject)));
      ThreadPool.post(new x(this.handler, paramw.appId, paramw.qvo, (String)localObject), "AppIconService_getIcon");
      AppMethodBeat.o(151670);
      return true;
      if ((((g)localObject).field_appWatermarkUrl == null) || (((g)localObject).field_appWatermarkUrl.length() == 0))
      {
        Log.e("MicroMsg.AppIconService", "push, appWatermarkUrl is null, appId = " + paramw.appId);
        AppMethodBeat.o(151670);
        return false;
      }
      localObject = ((g)localObject).field_appWatermarkUrl;
      continue;
      if ((((z)localObject).jOx == null) || (((z)localObject).jOx.length() == 0))
      {
        Log.e("MicroMsg.AppIconService", "push, appSuggestionIconUrl is null, appId = " + paramw.appId);
        AppMethodBeat.o(151670);
        return false;
      }
      localObject = ((z)localObject).jOx;
      continue;
      if ((((z)localObject).jOI == null) || (((z)localObject).jOI.length() == 0))
      {
        Log.e("MicroMsg.AppIconService", "push, servicePanelIconUrl is null, appId = " + paramw.appId);
        AppMethodBeat.o(151670);
        return false;
      }
      localObject = ((z)localObject).jOI;
      continue;
      if ((((z)localObject).jOJ == null) || (((z)localObject).jOJ.length() == 0))
      {
        Log.e("MicroMsg.AppIconService", "push, serviceListIconUrl is null, appId = " + paramw.appId);
        AppMethodBeat.o(151670);
        return false;
      }
      localObject = ((z)localObject).jOJ;
    }
  }
  
  public final void ir(String paramString, int paramInt)
  {
    AppMethodBeat.i(151669);
    if ((paramString == null) || (paramString.length() == 0))
    {
      Log.e("MicroMsg.AppIconService", "push fail, appId is null");
      AppMethodBeat.o(151669);
      return;
    }
    w localw = new w(paramString, paramInt);
    if (this.XRX.contains(localw))
    {
      Log.i("MicroMsg.AppIconService", "push, appId = " + paramString + ", iconType = " + paramInt + " already in running list");
      AppMethodBeat.o(151669);
      return;
    }
    if (this.XRX.size() >= 5)
    {
      Log.i("MicroMsg.AppIconService", "running list has reached the max count");
      if (!this.muZ.contains(localw)) {
        this.muZ.add(localw);
      }
      AppMethodBeat.o(151669);
      return;
    }
    if (a(localw)) {
      this.XRX.add(localw);
    }
    AppMethodBeat.o(151669);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.model.app.f
 * JD-Core Version:    0.7.0.1
 */