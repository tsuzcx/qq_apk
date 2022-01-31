package com.tencent.mm.plugin.webview.fts.c;

import android.content.Context;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.fts.ui.FtsWebVideoView;
import com.tencent.mm.plugin.webview.fts.ui.FtsWebVideoView.a;
import com.tencent.mm.plugin.webview.fts.ui.b.4;
import com.tencent.mm.plugin.webview.fts.ui.b.5;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.bj;
import com.tencent.mm.ui.widget.MMWebView;
import org.json.JSONException;
import org.json.JSONObject;

public final class b
  implements e
{
  private Context context;
  private b.b uQO;
  public com.tencent.mm.plugin.webview.ui.tools.jsapi.d uQS;
  com.tencent.mm.plugin.webview.fts.ui.b uQT;
  private bg<FtsWebVideoView> uQU;
  
  public b(Context paramContext, MMWebView paramMMWebView, b.b paramb)
  {
    AppMethodBeat.i(5940);
    this.uQU = new bg(3);
    this.context = paramContext;
    this.uQO = paramb;
    this.uQT = new com.tencent.mm.plugin.webview.fts.ui.b(paramMMWebView, paramb);
    AppMethodBeat.o(5940);
  }
  
  public final void F(final int paramInt, String paramString1, String paramString2)
  {
    AppMethodBeat.i(5941);
    ab.i("FtsVideoPlayerMgr", "insert player id %d,viewProps %s,videoProps %s", new Object[] { Integer.valueOf(paramInt), paramString1, paramString2 });
    for (;;)
    {
      try
      {
        if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2)))
        {
          ab.e("FtsVideoPlayerMgr", "insert args invalid");
          AppMethodBeat.o(5941);
          return;
        }
        JSONObject localJSONObject = new JSONObject(paramString1);
        paramString2 = new JSONObject(paramString2);
        paramString1 = (FtsWebVideoView)this.uQU.acquire();
        if (paramString1 == null)
        {
          paramString1 = new FtsWebVideoView(this.context, paramString2.optBoolean("autoPlay"));
          paramString1.setIsShowBasicControls(true);
          paramString1.setVideoSizeByte(paramString2.optInt("fileSize"));
          paramString1.setMute(paramString2.optBoolean("isMute"));
          paramString1.setCover$16da05f7(paramString2.optString("coverUrl"));
          paramString1.setVideoPlayerId(paramInt);
          paramString1.setAutoPlay(paramString2.optBoolean("autoPlay"));
          paramString1.dM(c.aQ(paramString2), paramString2.optInt("durationSec"));
          paramString1.setFullScreenDelegate(new FtsWebVideoView.a()
          {
            public final void aDh()
            {
              AppMethodBeat.i(5931);
              com.tencent.mm.plugin.webview.fts.ui.b localb = b.this.uQT;
              int i = paramInt;
              b.5 local5 = new b.5(localb, Boolean.FALSE, i);
              if (Thread.currentThread() == Looper.getMainLooper().getThread())
              {
                ((Boolean)local5.b(null)).booleanValue();
                AppMethodBeat.o(5931);
                return;
              }
              ((Boolean)local5.b(localb.mHandler)).booleanValue();
              AppMethodBeat.o(5931);
            }
            
            public final boolean isFullScreen()
            {
              AppMethodBeat.i(5932);
              boolean bool = b.this.uQT.pk(paramInt);
              AppMethodBeat.o(5932);
              return bool;
            }
            
            public final void ol(boolean paramAnonymousBoolean)
            {
              AppMethodBeat.i(5930);
              com.tencent.mm.plugin.webview.fts.ui.b localb = b.this.uQT;
              int i = paramInt;
              Object localObject = this.uQY;
              localObject = new b.4(localb, Boolean.FALSE, i, (a)localObject, paramAnonymousBoolean);
              if (Thread.currentThread() == Looper.getMainLooper().getThread())
              {
                ((Boolean)((bj)localObject).b(null)).booleanValue();
                AppMethodBeat.o(5930);
                return;
              }
              ((Boolean)((bj)localObject).b(localb.mHandler)).booleanValue();
              AppMethodBeat.o(5930);
            }
          });
          paramString2 = new b.3(this, paramString1);
          paramString1.setUiLifecycleListener(paramString2);
          this.uQO.a(paramString2);
          paramString1.setCallback(new d(paramString1, this.uQO, this.uQS));
          paramString2 = this.uQT;
          float[] arrayOfFloat = c.a(localJSONObject, this.context);
          int i = c.y(localJSONObject);
          paramString1 = new com.tencent.mm.plugin.webview.fts.ui.b.1(paramString2, Boolean.FALSE, paramString1, paramInt, arrayOfFloat, i);
          if (Thread.currentThread() != Looper.getMainLooper().getThread()) {
            break;
          }
          ((Boolean)paramString1.b(null)).booleanValue();
          AppMethodBeat.o(5941);
          return;
        }
      }
      catch (JSONException paramString1)
      {
        ab.e("FtsVideoPlayerMgr", "", new Object[] { paramString1 });
        AppMethodBeat.o(5941);
        return;
      }
      paramString1.stop();
    }
    ((Boolean)paramString1.b(paramString2.mHandler)).booleanValue();
    AppMethodBeat.o(5941);
  }
  
  public final void G(int paramInt, String paramString1, String paramString2)
  {
    AppMethodBeat.i(5942);
    ab.i("FtsVideoPlayerMgr", "update player id %d,viewProps %s,videoProps %s", new Object[] { Integer.valueOf(paramInt), paramString1, paramString2 });
    try
    {
      Object localObject;
      if (!TextUtils.isEmpty(paramString1))
      {
        localObject = new JSONObject(paramString1);
        paramString1 = this.uQT;
        float[] arrayOfFloat = c.a((JSONObject)localObject, this.context);
        int i = c.y((JSONObject)localObject);
        localObject = new com.tencent.mm.plugin.webview.fts.ui.b.3(paramString1, Boolean.FALSE, paramInt, arrayOfFloat, i);
        if (Thread.currentThread() != Looper.getMainLooper().getThread()) {
          break label172;
        }
        ((Boolean)((bj)localObject).b(null)).booleanValue();
      }
      for (;;)
      {
        if (TextUtils.isEmpty(paramString2)) {
          break label314;
        }
        paramString1 = new JSONObject(paramString2);
        paramString2 = (FtsWebVideoView)this.uQT.getViewById(paramInt);
        if (paramString2 != null) {
          break;
        }
        ab.i("FtsVideoPlayerMgr", "can not find video View by id %d", new Object[] { Integer.valueOf(paramInt) });
        AppMethodBeat.o(5942);
        return;
        label172:
        ((Boolean)((bj)localObject).b(paramString1.mHandler)).booleanValue();
      }
      if (!paramString1.has("autoPlay")) {
        break label233;
      }
    }
    catch (JSONException paramString1)
    {
      ab.e("FtsVideoPlayerMgr", "", new Object[] { paramString1 });
      AppMethodBeat.o(5942);
      return;
    }
    paramString2.setAutoPlay(paramString1.optBoolean("autoPlay"));
    label233:
    if (paramString1.has("coverUrl")) {
      paramString2.setCover$16da05f7(paramString1.optString("coverUrl"));
    }
    if (paramString1.has("durationSec")) {
      paramString2.setDuration(paramString1.optInt("durationSec"));
    }
    if (paramString1.has("playUrl")) {
      paramString2.dM(c.aQ(paramString1), paramString1.optInt("durationSec"));
    }
    if (paramString1.has("isMute")) {
      paramString2.setMute(paramString1.optBoolean("isMute"));
    }
    label314:
    AppMethodBeat.o(5942);
  }
  
  public final void JO(int paramInt)
  {
    AppMethodBeat.i(5943);
    ab.i("FtsVideoPlayerMgr", "remove palyer id %d", new Object[] { Integer.valueOf(paramInt) });
    FtsWebVideoView localFtsWebVideoView = (FtsWebVideoView)this.uQT.getViewById(paramInt);
    com.tencent.mm.plugin.webview.fts.ui.b localb;
    com.tencent.mm.plugin.webview.fts.ui.b.2 local2;
    if (localFtsWebVideoView != null)
    {
      localFtsWebVideoView.getUiLifecycleListener();
      localb = this.uQT;
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
        this.uQU.release(localFtsWebVideoView);
      }
      AppMethodBeat.o(5943);
      return;
      ab.w("FtsVideoPlayerMgr", "can not find player by id %d", new Object[] { Integer.valueOf(paramInt) });
      break;
      label158:
      ((Boolean)local2.b(localb.mHandler)).booleanValue();
    }
  }
  
  public final void bC(int paramInt, String paramString)
  {
    AppMethodBeat.i(5944);
    ab.i("FtsVideoPlayerMgr", "op player id %d,type %s", new Object[] { Integer.valueOf(paramInt), paramString });
    FtsWebVideoView localFtsWebVideoView = (FtsWebVideoView)this.uQT.getViewById(paramInt);
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
          ab.i("FtsVideoPlayerMgr", "unknown op type %s", new Object[] { paramString });
          AppMethodBeat.o(5944);
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
      AppMethodBeat.o(5944);
      return;
      localFtsWebVideoView.pause();
      AppMethodBeat.o(5944);
      return;
      localFtsWebVideoView.stop();
      AppMethodBeat.o(5944);
      return;
      localFtsWebVideoView.setMute(true);
      AppMethodBeat.o(5944);
      return;
      localFtsWebVideoView.setMute(false);
      AppMethodBeat.o(5944);
      return;
    }
    ab.i("FtsVideoPlayerMgr", "can not find player by id %d", new Object[] { Integer.valueOf(paramInt) });
    AppMethodBeat.o(5944);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.fts.c.b
 * JD-Core Version:    0.7.0.1
 */