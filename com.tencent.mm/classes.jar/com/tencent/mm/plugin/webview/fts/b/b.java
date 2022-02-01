package com.tencent.mm.plugin.webview.fts.b;

import android.content.Context;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.websearch.ui.WebSearchWebVideoViewControlBar;
import com.tencent.mm.plugin.webview.fts.ui.FtsVideoWrapper;
import com.tencent.mm.plugin.webview.fts.ui.FtsWebVideoView;
import com.tencent.mm.plugin.webview.fts.ui.FtsWebVideoView.a;
import com.tencent.mm.plugin.webview.fts.ui.b.4;
import com.tencent.mm.plugin.webview.fts.ui.b.5;
import com.tencent.mm.plugin.webview.jsapi.j;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.SimpleObjectPool;
import com.tencent.mm.sdk.platformtools.SyncTask;
import com.tencent.mm.ui.widget.MMWebView;
import java.lang.ref.WeakReference;
import org.json.JSONException;
import org.json.JSONObject;

public final class b
  implements e
{
  private b WCZ;
  com.tencent.mm.plugin.webview.fts.ui.b WDd;
  private SimpleObjectPool<FtsWebVideoView> WDe;
  public j WlX;
  private Context context;
  
  public b(Context paramContext, MMWebView paramMMWebView, b paramb)
  {
    AppMethodBeat.i(78154);
    this.WDe = new SimpleObjectPool(3);
    this.context = paramContext;
    this.WCZ = paramb;
    this.WDd = new com.tencent.mm.plugin.webview.fts.ui.b(paramMMWebView, paramb);
    AppMethodBeat.o(78154);
  }
  
  public final void X(final int paramInt, final String paramString1, String paramString2)
  {
    AppMethodBeat.i(78155);
    Log.i("FtsVideoPlayerMgr", "insert player id %d,viewProps %s,videoProps %s", new Object[] { Integer.valueOf(paramInt), paramString1, paramString2 });
    for (;;)
    {
      try
      {
        if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2)))
        {
          Log.e("FtsVideoPlayerMgr", "insert args invalid");
          AppMethodBeat.o(78155);
          return;
        }
        JSONObject localJSONObject = new JSONObject(paramString1);
        paramString2 = new JSONObject(paramString2);
        paramString1 = (FtsWebVideoView)this.WDe.acquire();
        if (paramString1 == null)
        {
          paramString1 = new FtsWebVideoView(this.context, paramString2.optBoolean("autoPlay"));
          paramString1.setIsShowBasicControls(true);
          paramString1.setVideoSizeByte(paramString2.optInt("fileSize"));
          paramString1.setMute(paramString2.optBoolean("isMute"));
          paramString1.abL(paramString2.optString("coverUrl"));
          paramString1.setVideoPlayerId(paramInt);
          paramString1.setAutoPlay(paramString2.optBoolean("autoPlay"));
          paramString1.hQ(c.cE(paramString2), paramString2.optInt("durationSec"));
          paramString1.setFullScreenDelegate(new FtsWebVideoView.a()
          {
            public final void aqb()
            {
              AppMethodBeat.i(78143);
              FtsWebVideoView localFtsWebVideoView = paramString1;
              Log.i("MicroMsg.FtsWebVideoView", "onExitFullScreen");
              if (localFtsWebVideoView.WCt.sHM) {
                localFtsWebVideoView.WCt.csz();
              }
              localFtsWebVideoView.jH(false);
              AppMethodBeat.o(78143);
            }
          }
          {
            public final void Iw(boolean paramAnonymousBoolean)
            {
              AppMethodBeat.i(78144);
              com.tencent.mm.plugin.webview.fts.ui.b localb = b.this.WDd;
              int i = paramInt;
              Object localObject = this.WDi;
              localObject = new b.4(localb, Boolean.FALSE, i, (a)localObject, paramAnonymousBoolean);
              if (Thread.currentThread() == Looper.getMainLooper().getThread())
              {
                ((Boolean)((SyncTask)localObject).exec(null)).booleanValue();
                AppMethodBeat.o(78144);
                return;
              }
              ((Boolean)((SyncTask)localObject).exec(localb.mHandler)).booleanValue();
              AppMethodBeat.o(78144);
            }
            
            public final void csz()
            {
              AppMethodBeat.i(78145);
              com.tencent.mm.plugin.webview.fts.ui.b localb = b.this.WDd;
              int i = paramInt;
              b.5 local5 = new b.5(localb, Boolean.FALSE, i);
              if (Thread.currentThread() == Looper.getMainLooper().getThread())
              {
                ((Boolean)local5.exec(null)).booleanValue();
                AppMethodBeat.o(78145);
                return;
              }
              ((Boolean)local5.exec(localb.mHandler)).booleanValue();
              AppMethodBeat.o(78145);
            }
            
            public final boolean isFullScreen()
            {
              AppMethodBeat.i(78146);
              boolean bool = b.this.WDd.Ao(paramInt);
              AppMethodBeat.o(78146);
              return bool;
            }
          });
          paramString2 = new b.a()
          {
            public final void aqb()
            {
              AppMethodBeat.i(78150);
              com.tencent.mm.plugin.webview.fts.ui.b localb = b.this.WDd;
              Object localObject1 = localb.atz(localb.tzk);
              float[] arrayOfFloat = localb.tzh;
              if ((localObject1 == null) || (((com.tencent.mm.plugin.webview.fts.ui.b.a)localObject1).tzB == null) || (arrayOfFloat == null))
              {
                AppMethodBeat.o(78150);
                return;
              }
              localObject1 = (View)((com.tencent.mm.plugin.webview.fts.ui.b.a)localObject1).tzB.get();
              if (localObject1 != null)
              {
                if (localb.tzk != localb.tzg)
                {
                  Object localObject2 = localb.atz(localb.tzg);
                  if ((localObject2 != null) && (((com.tencent.mm.plugin.webview.fts.ui.b.a)localObject2).tzB != null))
                  {
                    localObject2 = (View)((com.tencent.mm.plugin.webview.fts.ui.b.a)localObject2).tzB.get();
                    if (localObject2 != null) {
                      localb.a(localb.tzg, arrayOfFloat, ((View)localObject2).getVisibility());
                    }
                  }
                }
                int i = localb.tzk;
                localb.tzg = -1;
                localb.tzk = -1;
                if (localb.WCY != null)
                {
                  localb.WCY.aqb();
                  localb.WCY = null;
                }
                localb.a(i, arrayOfFloat, ((View)localObject1).getVisibility());
              }
              AppMethodBeat.o(78150);
            }
            
            public final void itm()
            {
              AppMethodBeat.i(78152);
              FtsWebVideoView localFtsWebVideoView = paramString1;
              if ((!localFtsWebVideoView.lAj) && (localFtsWebVideoView.getSystemVolume() == 0)) {
                localFtsWebVideoView.setMute(true);
              }
              AppMethodBeat.o(78152);
            }
            
            public final void itn()
            {
              AppMethodBeat.i(78153);
              FtsWebVideoView localFtsWebVideoView = paramString1;
              if ((localFtsWebVideoView.lAj) && (localFtsWebVideoView.getSystemVolume() > 0)) {
                localFtsWebVideoView.setMute(false);
              }
              AppMethodBeat.o(78153);
            }
            
            public final boolean onBackPressed()
            {
              AppMethodBeat.i(78151);
              if (paramString1.cuZ())
              {
                paramString1.Iv(false);
                AppMethodBeat.o(78151);
                return true;
              }
              AppMethodBeat.o(78151);
              return false;
            }
            
            public final void onBackground()
            {
              AppMethodBeat.i(78148);
              FtsWebVideoView localFtsWebVideoView = paramString1;
              Log.i("MicroMsg.FtsWebVideoView", "onUIPause");
              localFtsWebVideoView.WCs.onUIPause();
              AppMethodBeat.o(78148);
            }
            
            public final void onDestroy()
            {
              AppMethodBeat.i(78149);
              FtsWebVideoView localFtsWebVideoView = paramString1;
              Log.i("MicroMsg.FtsWebVideoView", "onUIDestroy");
              Log.i("MicroMsg.FtsWebVideoView", "clean");
              localFtsWebVideoView.stop();
              localFtsWebVideoView.WCs.onUIDestroy();
              WebSearchWebVideoViewControlBar localWebSearchWebVideoViewControlBar = localFtsWebVideoView.WCt;
              if (localWebSearchWebVideoViewControlBar.sAc != null) {
                localWebSearchWebVideoViewControlBar.sAc.stopTimer();
              }
              if (localWebSearchWebVideoViewControlBar.sHL != null) {
                localWebSearchWebVideoViewControlBar.sHL.stopTimer();
              }
              try
              {
                localFtsWebVideoView.getContext().unregisterReceiver(localFtsWebVideoView.WCN);
                AppMethodBeat.o(78149);
                return;
              }
              catch (Exception localException)
              {
                AppMethodBeat.o(78149);
              }
            }
            
            public final void onForeground()
            {
              AppMethodBeat.i(78147);
              FtsWebVideoView localFtsWebVideoView = paramString1;
              Log.i("MicroMsg.FtsWebVideoView", "onUIResume");
              localFtsWebVideoView.WCs.onUIResume();
              AppMethodBeat.o(78147);
            }
          };
          paramString1.setUiLifecycleListener(paramString2);
          this.WCZ.a(paramString2);
          paramString1.setCallback(new d(paramString1, this.WCZ, this.WlX));
          paramString2 = this.WDd;
          float[] arrayOfFloat = c.a(localJSONObject, this.context);
          int i = c.ab(localJSONObject);
          paramString1 = new com.tencent.mm.plugin.webview.fts.ui.b.1(paramString2, Boolean.FALSE, paramString1, paramInt, arrayOfFloat, i);
          if (Thread.currentThread() != Looper.getMainLooper().getThread()) {
            break;
          }
          ((Boolean)paramString1.exec(null)).booleanValue();
          AppMethodBeat.o(78155);
          return;
        }
      }
      catch (JSONException paramString1)
      {
        Log.e("FtsVideoPlayerMgr", "", new Object[] { paramString1 });
        AppMethodBeat.o(78155);
        return;
      }
      paramString1.stop();
    }
    ((Boolean)paramString1.exec(paramString2.mHandler)).booleanValue();
    AppMethodBeat.o(78155);
  }
  
  public final void Y(int paramInt, String paramString1, String paramString2)
  {
    AppMethodBeat.i(78156);
    Log.i("FtsVideoPlayerMgr", "update player id %d,viewProps %s,videoProps %s", new Object[] { Integer.valueOf(paramInt), paramString1, paramString2 });
    try
    {
      Object localObject;
      if (!TextUtils.isEmpty(paramString1))
      {
        localObject = new JSONObject(paramString1);
        paramString1 = this.WDd;
        float[] arrayOfFloat = c.a((JSONObject)localObject, this.context);
        int i = c.ab((JSONObject)localObject);
        localObject = new com.tencent.mm.plugin.webview.fts.ui.b.3(paramString1, Boolean.FALSE, paramInt, arrayOfFloat, i);
        if (Thread.currentThread() != Looper.getMainLooper().getThread()) {
          break label171;
        }
        ((Boolean)((SyncTask)localObject).exec(null)).booleanValue();
      }
      for (;;)
      {
        if (TextUtils.isEmpty(paramString2)) {
          break label312;
        }
        paramString1 = new JSONObject(paramString2);
        paramString2 = (FtsWebVideoView)this.WDd.dU(paramInt);
        if (paramString2 != null) {
          break;
        }
        Log.i("FtsVideoPlayerMgr", "can not find video View by id %d", new Object[] { Integer.valueOf(paramInt) });
        AppMethodBeat.o(78156);
        return;
        label171:
        ((Boolean)((SyncTask)localObject).exec(paramString1.mHandler)).booleanValue();
      }
      if (!paramString1.has("autoPlay")) {
        break label231;
      }
    }
    catch (JSONException paramString1)
    {
      Log.e("FtsVideoPlayerMgr", "", new Object[] { paramString1 });
      AppMethodBeat.o(78156);
      return;
    }
    paramString2.setAutoPlay(paramString1.optBoolean("autoPlay"));
    label231:
    if (paramString1.has("coverUrl")) {
      paramString2.abL(paramString1.optString("coverUrl"));
    }
    if (paramString1.has("durationSec")) {
      paramString2.setDuration(paramString1.optInt("durationSec"));
    }
    if (paramString1.has("playUrl")) {
      paramString2.hQ(c.cE(paramString1), paramString1.optInt("durationSec"));
    }
    if (paramString1.has("isMute")) {
      paramString2.setMute(paramString1.optBoolean("isMute"));
    }
    label312:
    AppMethodBeat.o(78156);
  }
  
  public final void atA(int paramInt)
  {
    AppMethodBeat.i(78157);
    Log.i("FtsVideoPlayerMgr", "remove palyer id %d", new Object[] { Integer.valueOf(paramInt) });
    FtsWebVideoView localFtsWebVideoView = (FtsWebVideoView)this.WDd.dU(paramInt);
    com.tencent.mm.plugin.webview.fts.ui.b localb;
    com.tencent.mm.plugin.webview.fts.ui.b.2 local2;
    if (localFtsWebVideoView != null)
    {
      localFtsWebVideoView.getUiLifecycleListener();
      localb = this.WDd;
      local2 = new com.tencent.mm.plugin.webview.fts.ui.b.2(localb, Boolean.FALSE, paramInt);
      if (Thread.currentThread() != Looper.getMainLooper().getThread()) {
        break label158;
      }
      ((Boolean)local2.exec(null)).booleanValue();
    }
    for (;;)
    {
      if (localFtsWebVideoView != null)
      {
        localFtsWebVideoView.stop();
        localFtsWebVideoView.getCallback().clean();
        localFtsWebVideoView.setCallback(null);
        localFtsWebVideoView.setVisibility(0);
        localFtsWebVideoView.setAllowMobileNetPlay(false);
        this.WDe.release(localFtsWebVideoView);
      }
      AppMethodBeat.o(78157);
      return;
      Log.w("FtsVideoPlayerMgr", "can not find player by id %d", new Object[] { Integer.valueOf(paramInt) });
      break;
      label158:
      ((Boolean)local2.exec(localb.mHandler)).booleanValue();
    }
  }
  
  public final void dJ(int paramInt, String paramString)
  {
    AppMethodBeat.i(78158);
    Log.i("FtsVideoPlayerMgr", "op player id %d,type %s", new Object[] { Integer.valueOf(paramInt), paramString });
    FtsWebVideoView localFtsWebVideoView = (FtsWebVideoView)this.WDd.dU(paramInt);
    if (localFtsWebVideoView != null)
    {
      paramInt = -1;
      switch (paramString.hashCode())
      {
      }
      for (;;)
      {
        switch (paramInt)
        {
        default: 
          Log.i("FtsVideoPlayerMgr", "unknown op type %s", new Object[] { paramString });
          AppMethodBeat.o(78158);
          return;
          if (paramString.equals("play"))
          {
            paramInt = 0;
            continue;
            if (paramString.equals("pause"))
            {
              paramInt = 1;
              continue;
              if (paramString.equals("stop"))
              {
                paramInt = 2;
                continue;
                if (paramString.equals("setMute"))
                {
                  paramInt = 3;
                  continue;
                  if (paramString.equals("setUnMute")) {
                    paramInt = 4;
                  }
                }
              }
            }
          }
          break;
        }
      }
      localFtsWebVideoView.start(false);
      AppMethodBeat.o(78158);
      return;
      localFtsWebVideoView.pause();
      AppMethodBeat.o(78158);
      return;
      localFtsWebVideoView.stop();
      AppMethodBeat.o(78158);
      return;
      localFtsWebVideoView.setMute(true);
      AppMethodBeat.o(78158);
      return;
      localFtsWebVideoView.setMute(false);
      AppMethodBeat.o(78158);
      return;
    }
    Log.i("FtsVideoPlayerMgr", "can not find player by id %d", new Object[] { Integer.valueOf(paramInt) });
    AppMethodBeat.o(78158);
  }
  
  public static abstract interface b
  {
    public abstract void E(View paramView, boolean paramBoolean);
    
    public abstract void a(b.a parama);
    
    public abstract void ito();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.fts.b.b
 * JD-Core Version:    0.7.0.1
 */