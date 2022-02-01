package com.tencent.mm.plugin.webview.fts.c;

import android.content.Context;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.websearch.ui.WebSearchWebVideoViewControlBar;
import com.tencent.mm.plugin.webview.c.f;
import com.tencent.mm.plugin.webview.fts.ui.FtsVideoWrapper;
import com.tencent.mm.plugin.webview.fts.ui.FtsWebVideoView;
import com.tencent.mm.plugin.webview.fts.ui.FtsWebVideoView.a;
import com.tencent.mm.plugin.webview.fts.ui.b.4;
import com.tencent.mm.plugin.webview.fts.ui.b.5;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aw;
import com.tencent.mm.sdk.platformtools.bm;
import com.tencent.mm.sdk.platformtools.bp;
import com.tencent.mm.ui.widget.MMWebView;
import java.lang.ref.WeakReference;
import org.json.JSONException;
import org.json.JSONObject;

public final class b
  implements e
{
  public f DRx;
  private b Eed;
  com.tencent.mm.plugin.webview.fts.ui.b Eeh;
  private bm<FtsWebVideoView> Eei;
  private Context context;
  
  public b(Context paramContext, MMWebView paramMMWebView, b paramb)
  {
    AppMethodBeat.i(78154);
    this.Eei = new bm(3);
    this.context = paramContext;
    this.Eed = paramb;
    this.Eeh = new com.tencent.mm.plugin.webview.fts.ui.b(paramMMWebView, paramb);
    AppMethodBeat.o(78154);
  }
  
  public final void O(final int paramInt, final String paramString1, String paramString2)
  {
    AppMethodBeat.i(78155);
    ae.i("FtsVideoPlayerMgr", "insert player id %d,viewProps %s,videoProps %s", new Object[] { Integer.valueOf(paramInt), paramString1, paramString2 });
    for (;;)
    {
      try
      {
        if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2)))
        {
          ae.e("FtsVideoPlayerMgr", "insert args invalid");
          AppMethodBeat.o(78155);
          return;
        }
        JSONObject localJSONObject = new JSONObject(paramString1);
        paramString2 = new JSONObject(paramString2);
        paramString1 = (FtsWebVideoView)this.Eei.acquire();
        if (paramString1 == null)
        {
          paramString1 = new FtsWebVideoView(this.context, paramString2.optBoolean("autoPlay"));
          paramString1.setIsShowBasicControls(true);
          paramString1.setVideoSizeByte(paramString2.optInt("fileSize"));
          paramString1.setMute(paramString2.optBoolean("isMute"));
          paramString1.setCover$16da05f7(paramString2.optString("coverUrl"));
          paramString1.setVideoPlayerId(paramInt);
          paramString1.setAutoPlay(paramString2.optBoolean("autoPlay"));
          paramString1.cH(c.by(paramString2), paramString2.optInt("durationSec"));
          paramString1.setFullScreenDelegate(new FtsWebVideoView.a()
          {
            public final void DD()
            {
              AppMethodBeat.i(78143);
              FtsWebVideoView localFtsWebVideoView = paramString1;
              ae.i("MicroMsg.FtsWebVideoView", "onExitFullScreen");
              if (localFtsWebVideoView.Edy.lws) {
                localFtsWebVideoView.Edy.blp();
              }
              localFtsWebVideoView.gQ(false);
              AppMethodBeat.o(78143);
            }
          }
          {
            public final void blp()
            {
              AppMethodBeat.i(78145);
              com.tencent.mm.plugin.webview.fts.ui.b localb = b.this.Eeh;
              int i = paramInt;
              b.5 local5 = new b.5(localb, Boolean.FALSE, i);
              if (Thread.currentThread() == Looper.getMainLooper().getThread())
              {
                ((Boolean)local5.b(null)).booleanValue();
                AppMethodBeat.o(78145);
                return;
              }
              ((Boolean)local5.b(localb.mHandler)).booleanValue();
              AppMethodBeat.o(78145);
            }
            
            public final boolean isFullScreen()
            {
              AppMethodBeat.i(78146);
              boolean bool = b.this.Eeh.sL(paramInt);
              AppMethodBeat.o(78146);
              return bool;
            }
            
            public final void vd(boolean paramAnonymousBoolean)
            {
              AppMethodBeat.i(78144);
              com.tencent.mm.plugin.webview.fts.ui.b localb = b.this.Eeh;
              int i = paramInt;
              Object localObject = this.Eem;
              localObject = new b.4(localb, Boolean.FALSE, i, (a)localObject, paramAnonymousBoolean);
              if (Thread.currentThread() == Looper.getMainLooper().getThread())
              {
                ((Boolean)((bp)localObject).b(null)).booleanValue();
                AppMethodBeat.o(78144);
                return;
              }
              ((Boolean)((bp)localObject).b(localb.mHandler)).booleanValue();
              AppMethodBeat.o(78144);
            }
          });
          paramString2 = new b.a()
          {
            public final void DD()
            {
              AppMethodBeat.i(78150);
              com.tencent.mm.plugin.webview.fts.ui.b localb = b.this.Eeh;
              Object localObject1 = localb.Xi(localb.mif);
              float[] arrayOfFloat = localb.mic;
              if ((localObject1 == null) || (((com.tencent.mm.plugin.webview.fts.ui.b.a)localObject1).mix == null) || (arrayOfFloat == null))
              {
                AppMethodBeat.o(78150);
                return;
              }
              localObject1 = (View)((com.tencent.mm.plugin.webview.fts.ui.b.a)localObject1).mix.get();
              if (localObject1 != null)
              {
                if (localb.mif != localb.mib)
                {
                  Object localObject2 = localb.Xi(localb.mib);
                  if ((localObject2 != null) && (((com.tencent.mm.plugin.webview.fts.ui.b.a)localObject2).mix != null))
                  {
                    localObject2 = (View)((com.tencent.mm.plugin.webview.fts.ui.b.a)localObject2).mix.get();
                    if (localObject2 != null) {
                      localb.a(localb.mib, arrayOfFloat, ((View)localObject2).getVisibility());
                    }
                  }
                }
                int i = localb.mif;
                localb.mib = -1;
                localb.mif = -1;
                if (localb.Eec != null)
                {
                  localb.Eec.DD();
                  localb.Eec = null;
                }
                localb.a(i, arrayOfFloat, ((View)localObject1).getVisibility());
              }
              AppMethodBeat.o(78150);
            }
            
            public final void eSa()
            {
              AppMethodBeat.i(78152);
              FtsWebVideoView localFtsWebVideoView = paramString1;
              if ((!localFtsWebVideoView.fOX) && (localFtsWebVideoView.getSystemVolume() == 0)) {
                localFtsWebVideoView.setMute(true);
              }
              AppMethodBeat.o(78152);
            }
            
            public final void eSb()
            {
              AppMethodBeat.i(78153);
              FtsWebVideoView localFtsWebVideoView = paramString1;
              if ((localFtsWebVideoView.fOX) && (localFtsWebVideoView.getSystemVolume() > 0)) {
                localFtsWebVideoView.setMute(false);
              }
              AppMethodBeat.o(78153);
            }
            
            public final boolean onBackPressed()
            {
              AppMethodBeat.i(78151);
              if (paramString1.bnx())
              {
                paramString1.vc(false);
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
              ae.i("MicroMsg.FtsWebVideoView", "onUIPause");
              localFtsWebVideoView.Edx.onUIPause();
              AppMethodBeat.o(78148);
            }
            
            public final void onDestroy()
            {
              AppMethodBeat.i(78149);
              FtsWebVideoView localFtsWebVideoView = paramString1;
              ae.i("MicroMsg.FtsWebVideoView", "onUIDestroy");
              ae.i("MicroMsg.FtsWebVideoView", "clean");
              localFtsWebVideoView.stop();
              localFtsWebVideoView.Edx.onUIDestroy();
              WebSearchWebVideoViewControlBar localWebSearchWebVideoViewControlBar = localFtsWebVideoView.Edy;
              if (localWebSearchWebVideoViewControlBar.lpR != null) {
                localWebSearchWebVideoViewControlBar.lpR.stopTimer();
              }
              if (localWebSearchWebVideoViewControlBar.lwr != null) {
                localWebSearchWebVideoViewControlBar.lwr.stopTimer();
              }
              try
              {
                localFtsWebVideoView.getContext().unregisterReceiver(localFtsWebVideoView.EdR);
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
              ae.i("MicroMsg.FtsWebVideoView", "onUIResume");
              localFtsWebVideoView.Edx.onUIResume();
              AppMethodBeat.o(78147);
            }
          };
          paramString1.setUiLifecycleListener(paramString2);
          this.Eed.a(paramString2);
          paramString1.setCallback(new d(paramString1, this.Eed, this.DRx));
          paramString2 = this.Eeh;
          float[] arrayOfFloat = c.a(localJSONObject, this.context);
          int i = c.F(localJSONObject);
          paramString1 = new com.tencent.mm.plugin.webview.fts.ui.b.1(paramString2, Boolean.FALSE, paramString1, paramInt, arrayOfFloat, i);
          if (Thread.currentThread() != Looper.getMainLooper().getThread()) {
            break;
          }
          ((Boolean)paramString1.b(null)).booleanValue();
          AppMethodBeat.o(78155);
          return;
        }
      }
      catch (JSONException paramString1)
      {
        ae.e("FtsVideoPlayerMgr", "", new Object[] { paramString1 });
        AppMethodBeat.o(78155);
        return;
      }
      paramString1.stop();
    }
    ((Boolean)paramString1.b(paramString2.mHandler)).booleanValue();
    AppMethodBeat.o(78155);
  }
  
  public final void P(int paramInt, String paramString1, String paramString2)
  {
    AppMethodBeat.i(78156);
    ae.i("FtsVideoPlayerMgr", "update player id %d,viewProps %s,videoProps %s", new Object[] { Integer.valueOf(paramInt), paramString1, paramString2 });
    try
    {
      Object localObject;
      if (!TextUtils.isEmpty(paramString1))
      {
        localObject = new JSONObject(paramString1);
        paramString1 = this.Eeh;
        float[] arrayOfFloat = c.a((JSONObject)localObject, this.context);
        int i = c.F((JSONObject)localObject);
        localObject = new com.tencent.mm.plugin.webview.fts.ui.b.3(paramString1, Boolean.FALSE, paramInt, arrayOfFloat, i);
        if (Thread.currentThread() != Looper.getMainLooper().getThread()) {
          break label170;
        }
        ((Boolean)((bp)localObject).b(null)).booleanValue();
      }
      for (;;)
      {
        if (TextUtils.isEmpty(paramString2)) {
          break label311;
        }
        paramString1 = new JSONObject(paramString2);
        paramString2 = (FtsWebVideoView)this.Eeh.getViewById(paramInt);
        if (paramString2 != null) {
          break;
        }
        ae.i("FtsVideoPlayerMgr", "can not find video View by id %d", new Object[] { Integer.valueOf(paramInt) });
        AppMethodBeat.o(78156);
        return;
        label170:
        ((Boolean)((bp)localObject).b(paramString1.mHandler)).booleanValue();
      }
      if (!paramString1.has("autoPlay")) {
        break label230;
      }
    }
    catch (JSONException paramString1)
    {
      ae.e("FtsVideoPlayerMgr", "", new Object[] { paramString1 });
      AppMethodBeat.o(78156);
      return;
    }
    paramString2.setAutoPlay(paramString1.optBoolean("autoPlay"));
    label230:
    if (paramString1.has("coverUrl")) {
      paramString2.setCover$16da05f7(paramString1.optString("coverUrl"));
    }
    if (paramString1.has("durationSec")) {
      paramString2.setDuration(paramString1.optInt("durationSec"));
    }
    if (paramString1.has("playUrl")) {
      paramString2.cH(c.by(paramString1), paramString1.optInt("durationSec"));
    }
    if (paramString1.has("isMute")) {
      paramString2.setMute(paramString1.optBoolean("isMute"));
    }
    label311:
    AppMethodBeat.o(78156);
  }
  
  public final void Xj(int paramInt)
  {
    AppMethodBeat.i(78157);
    ae.i("FtsVideoPlayerMgr", "remove palyer id %d", new Object[] { Integer.valueOf(paramInt) });
    FtsWebVideoView localFtsWebVideoView = (FtsWebVideoView)this.Eeh.getViewById(paramInt);
    com.tencent.mm.plugin.webview.fts.ui.b localb;
    com.tencent.mm.plugin.webview.fts.ui.b.2 local2;
    if (localFtsWebVideoView != null)
    {
      localFtsWebVideoView.getUiLifecycleListener();
      localb = this.Eeh;
      local2 = new com.tencent.mm.plugin.webview.fts.ui.b.2(localb, Boolean.FALSE, paramInt);
      if (Thread.currentThread() != Looper.getMainLooper().getThread()) {
        break label158;
      }
      ((Boolean)local2.b(null)).booleanValue();
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
        this.Eei.release(localFtsWebVideoView);
      }
      AppMethodBeat.o(78157);
      return;
      ae.w("FtsVideoPlayerMgr", "can not find player by id %d", new Object[] { Integer.valueOf(paramInt) });
      break;
      label158:
      ((Boolean)local2.b(localb.mHandler)).booleanValue();
    }
  }
  
  public final void cy(int paramInt, String paramString)
  {
    AppMethodBeat.i(78158);
    ae.i("FtsVideoPlayerMgr", "op player id %d,type %s", new Object[] { Integer.valueOf(paramInt), paramString });
    FtsWebVideoView localFtsWebVideoView = (FtsWebVideoView)this.Eeh.getViewById(paramInt);
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
          ae.i("FtsVideoPlayerMgr", "unknown op type %s", new Object[] { paramString });
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
    ae.i("FtsVideoPlayerMgr", "can not find player by id %d", new Object[] { Integer.valueOf(paramInt) });
    AppMethodBeat.o(78158);
  }
  
  public static abstract interface b
  {
    public abstract void a(b.a parama);
    
    public abstract void eSc();
    
    public abstract void u(View paramView, boolean paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.fts.c.b
 * JD-Core Version:    0.7.0.1
 */