package com.tencent.mm.plugin.webview.fts.c;

import android.content.Context;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.websearch.ui.WebSearchWebVideoViewControlBar;
import com.tencent.mm.plugin.webview.d.h;
import com.tencent.mm.plugin.webview.fts.ui.FtsVideoWrapper;
import com.tencent.mm.plugin.webview.fts.ui.FtsWebVideoView;
import com.tencent.mm.plugin.webview.fts.ui.FtsWebVideoView.a;
import com.tencent.mm.plugin.webview.fts.ui.b.4;
import com.tencent.mm.plugin.webview.fts.ui.b.5;
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
  public h IBw;
  private b IQD;
  com.tencent.mm.plugin.webview.fts.ui.b IQH;
  private SimpleObjectPool<FtsWebVideoView> IQI;
  private Context context;
  
  public b(Context paramContext, MMWebView paramMMWebView, b paramb)
  {
    AppMethodBeat.i(78154);
    this.IQI = new SimpleObjectPool(3);
    this.context = paramContext;
    this.IQD = paramb;
    this.IQH = new com.tencent.mm.plugin.webview.fts.ui.b(paramMMWebView, paramb);
    AppMethodBeat.o(78154);
  }
  
  public final void Q(final int paramInt, final String paramString1, String paramString2)
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
        paramString1 = (FtsWebVideoView)this.IQI.acquire();
        if (paramString1 == null)
        {
          paramString1 = new FtsWebVideoView(this.context, paramString2.optBoolean("autoPlay"));
          paramString1.setIsShowBasicControls(true);
          paramString1.setVideoSizeByte(paramString2.optInt("fileSize"));
          paramString1.setMute(paramString2.optBoolean("isMute"));
          paramString1.setCover$16da05f7(paramString2.optString("coverUrl"));
          paramString1.setVideoPlayerId(paramInt);
          paramString1.setAutoPlay(paramString2.optBoolean("autoPlay"));
          paramString1.cN(c.bX(paramString2), paramString2.optInt("durationSec"));
          paramString1.setFullScreenDelegate(new FtsWebVideoView.a()
          {
            public final void Na()
            {
              AppMethodBeat.i(78143);
              FtsWebVideoView localFtsWebVideoView = paramString1;
              Log.i("MicroMsg.FtsWebVideoView", "onExitFullScreen");
              if (localFtsWebVideoView.IPY.mDo) {
                localFtsWebVideoView.IPY.bGL();
              }
              localFtsWebVideoView.hN(false);
              AppMethodBeat.o(78143);
            }
          }
          {
            public final void bGL()
            {
              AppMethodBeat.i(78145);
              com.tencent.mm.plugin.webview.fts.ui.b localb = b.this.IQH;
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
              boolean bool = b.this.IQH.wH(paramInt);
              AppMethodBeat.o(78146);
              return bool;
            }
            
            public final void yU(boolean paramAnonymousBoolean)
            {
              AppMethodBeat.i(78144);
              com.tencent.mm.plugin.webview.fts.ui.b localb = b.this.IQH;
              int i = paramInt;
              Object localObject = this.IQM;
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
          });
          paramString2 = new b.a()
          {
            public final void Na()
            {
              AppMethodBeat.i(78150);
              com.tencent.mm.plugin.webview.fts.ui.b localb = b.this.IQH;
              Object localObject1 = localb.afR(localb.nsA);
              float[] arrayOfFloat = localb.nsx;
              if ((localObject1 == null) || (((com.tencent.mm.plugin.webview.fts.ui.b.a)localObject1).nsR == null) || (arrayOfFloat == null))
              {
                AppMethodBeat.o(78150);
                return;
              }
              localObject1 = (View)((com.tencent.mm.plugin.webview.fts.ui.b.a)localObject1).nsR.get();
              if (localObject1 != null)
              {
                if (localb.nsA != localb.nsw)
                {
                  Object localObject2 = localb.afR(localb.nsw);
                  if ((localObject2 != null) && (((com.tencent.mm.plugin.webview.fts.ui.b.a)localObject2).nsR != null))
                  {
                    localObject2 = (View)((com.tencent.mm.plugin.webview.fts.ui.b.a)localObject2).nsR.get();
                    if (localObject2 != null) {
                      localb.a(localb.nsw, arrayOfFloat, ((View)localObject2).getVisibility());
                    }
                  }
                }
                int i = localb.nsA;
                localb.nsw = -1;
                localb.nsA = -1;
                if (localb.IQC != null)
                {
                  localb.IQC.Na();
                  localb.IQC = null;
                }
                localb.a(i, arrayOfFloat, ((View)localObject1).getVisibility());
              }
              AppMethodBeat.o(78150);
            }
            
            public final void gaM()
            {
              AppMethodBeat.i(78152);
              FtsWebVideoView localFtsWebVideoView = paramString1;
              if ((!localFtsWebVideoView.guh) && (localFtsWebVideoView.getSystemVolume() == 0)) {
                localFtsWebVideoView.setMute(true);
              }
              AppMethodBeat.o(78152);
            }
            
            public final void gaN()
            {
              AppMethodBeat.i(78153);
              FtsWebVideoView localFtsWebVideoView = paramString1;
              if ((localFtsWebVideoView.guh) && (localFtsWebVideoView.getSystemVolume() > 0)) {
                localFtsWebVideoView.setMute(false);
              }
              AppMethodBeat.o(78153);
            }
            
            public final boolean onBackPressed()
            {
              AppMethodBeat.i(78151);
              if (paramString1.bJb())
              {
                paramString1.yT(false);
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
              localFtsWebVideoView.IPX.onUIPause();
              AppMethodBeat.o(78148);
            }
            
            public final void onDestroy()
            {
              AppMethodBeat.i(78149);
              FtsWebVideoView localFtsWebVideoView = paramString1;
              Log.i("MicroMsg.FtsWebVideoView", "onUIDestroy");
              Log.i("MicroMsg.FtsWebVideoView", "clean");
              localFtsWebVideoView.stop();
              localFtsWebVideoView.IPX.onUIDestroy();
              WebSearchWebVideoViewControlBar localWebSearchWebVideoViewControlBar = localFtsWebVideoView.IPY;
              if (localWebSearchWebVideoViewControlBar.mww != null) {
                localWebSearchWebVideoViewControlBar.mww.stopTimer();
              }
              if (localWebSearchWebVideoViewControlBar.mDn != null) {
                localWebSearchWebVideoViewControlBar.mDn.stopTimer();
              }
              try
              {
                localFtsWebVideoView.getContext().unregisterReceiver(localFtsWebVideoView.IQr);
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
              localFtsWebVideoView.IPX.onUIResume();
              AppMethodBeat.o(78147);
            }
          };
          paramString1.setUiLifecycleListener(paramString2);
          this.IQD.a(paramString2);
          paramString1.setCallback(new d(paramString1, this.IQD, this.IBw));
          paramString2 = this.IQH;
          float[] arrayOfFloat = c.a(localJSONObject, this.context);
          int i = c.M(localJSONObject);
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
  
  public final void R(int paramInt, String paramString1, String paramString2)
  {
    AppMethodBeat.i(78156);
    Log.i("FtsVideoPlayerMgr", "update player id %d,viewProps %s,videoProps %s", new Object[] { Integer.valueOf(paramInt), paramString1, paramString2 });
    try
    {
      Object localObject;
      if (!TextUtils.isEmpty(paramString1))
      {
        localObject = new JSONObject(paramString1);
        paramString1 = this.IQH;
        float[] arrayOfFloat = c.a((JSONObject)localObject, this.context);
        int i = c.M((JSONObject)localObject);
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
        paramString2 = (FtsWebVideoView)this.IQH.getViewById(paramInt);
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
      paramString2.setCover$16da05f7(paramString1.optString("coverUrl"));
    }
    if (paramString1.has("durationSec")) {
      paramString2.setDuration(paramString1.optInt("durationSec"));
    }
    if (paramString1.has("playUrl")) {
      paramString2.cN(c.bX(paramString1), paramString1.optInt("durationSec"));
    }
    if (paramString1.has("isMute")) {
      paramString2.setMute(paramString1.optBoolean("isMute"));
    }
    label312:
    AppMethodBeat.o(78156);
  }
  
  public final void afS(int paramInt)
  {
    AppMethodBeat.i(78157);
    Log.i("FtsVideoPlayerMgr", "remove palyer id %d", new Object[] { Integer.valueOf(paramInt) });
    FtsWebVideoView localFtsWebVideoView = (FtsWebVideoView)this.IQH.getViewById(paramInt);
    com.tencent.mm.plugin.webview.fts.ui.b localb;
    com.tencent.mm.plugin.webview.fts.ui.b.2 local2;
    if (localFtsWebVideoView != null)
    {
      localFtsWebVideoView.getUiLifecycleListener();
      localb = this.IQH;
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
        this.IQI.release(localFtsWebVideoView);
      }
      AppMethodBeat.o(78157);
      return;
      Log.w("FtsVideoPlayerMgr", "can not find player by id %d", new Object[] { Integer.valueOf(paramInt) });
      break;
      label158:
      ((Boolean)local2.exec(localb.mHandler)).booleanValue();
    }
  }
  
  public final void cS(int paramInt, String paramString)
  {
    AppMethodBeat.i(78158);
    Log.i("FtsVideoPlayerMgr", "op player id %d,type %s", new Object[] { Integer.valueOf(paramInt), paramString });
    FtsWebVideoView localFtsWebVideoView = (FtsWebVideoView)this.IQH.getViewById(paramInt);
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
    public abstract void a(b.a parama);
    
    public abstract void gaO();
    
    public abstract void w(View paramView, boolean paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.fts.c.b
 * JD-Core Version:    0.7.0.1
 */