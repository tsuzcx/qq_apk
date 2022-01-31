package com.tencent.mm.plugin.webview.fts.c;

import android.content.Context;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.mm.plugin.webview.fts.ui.FtsWebVideoView;
import com.tencent.mm.sdk.platformtools.bc;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.widget.MMWebView;
import org.json.JSONException;
import org.json.JSONObject;

public final class b
  implements e
{
  private Context context;
  private b.b rbg;
  public com.tencent.mm.plugin.webview.ui.tools.jsapi.d rbk;
  com.tencent.mm.plugin.webview.fts.ui.b rbl;
  private bc<FtsWebVideoView> rbm = new bc(3);
  
  public b(Context paramContext, MMWebView paramMMWebView, b.b paramb)
  {
    this.context = paramContext;
    this.rbg = paramb;
    this.rbl = new com.tencent.mm.plugin.webview.fts.ui.b(paramMMWebView, paramb);
  }
  
  public final void BU(int paramInt)
  {
    y.i("FtsVideoPlayerMgr", "remove palyer id %d", new Object[] { Integer.valueOf(paramInt) });
    FtsWebVideoView localFtsWebVideoView = (FtsWebVideoView)this.rbl.mg(paramInt);
    com.tencent.mm.plugin.webview.fts.ui.b localb;
    com.tencent.mm.plugin.webview.fts.ui.b.2 local2;
    if (localFtsWebVideoView != null)
    {
      localFtsWebVideoView.getUiLifecycleListener();
      localb = this.rbl;
      local2 = new com.tencent.mm.plugin.webview.fts.ui.b.2(localb, Boolean.valueOf(false), paramInt);
      if (Thread.currentThread() != Looper.getMainLooper().getThread()) {
        break label145;
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
        this.rbm.D(localFtsWebVideoView);
      }
      return;
      y.w("FtsVideoPlayerMgr", "can not find player by id %d", new Object[] { Integer.valueOf(paramInt) });
      break;
      label145:
      ((Boolean)local2.b(localb.mHandler)).booleanValue();
    }
  }
  
  public final void aV(int paramInt, String paramString)
  {
    y.i("FtsVideoPlayerMgr", "op player id %d,type %s", new Object[] { Integer.valueOf(paramInt), paramString });
    FtsWebVideoView localFtsWebVideoView = (FtsWebVideoView)this.rbl.mg(paramInt);
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
          y.i("FtsVideoPlayerMgr", "unknown op type %s", new Object[] { paramString });
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
      localFtsWebVideoView.eg(false);
      return;
      localFtsWebVideoView.pause();
      return;
      localFtsWebVideoView.stop();
      return;
      localFtsWebVideoView.setMute(true);
      return;
      localFtsWebVideoView.setMute(false);
      return;
    }
    y.i("FtsVideoPlayerMgr", "can not find player by id %d", new Object[] { Integer.valueOf(paramInt) });
  }
  
  public final void w(int paramInt, String paramString1, String paramString2)
  {
    y.i("FtsVideoPlayerMgr", "insert player id %d,viewProps %s,videoProps %s", new Object[] { Integer.valueOf(paramInt), paramString1, paramString2 });
    for (;;)
    {
      try
      {
        if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2)))
        {
          y.e("FtsVideoPlayerMgr", "insert args invalid");
          return;
        }
        JSONObject localJSONObject = new JSONObject(paramString1);
        paramString2 = new JSONObject(paramString2);
        paramString1 = (FtsWebVideoView)this.rbm.de();
        if (paramString1 == null)
        {
          paramString1 = new FtsWebVideoView(this.context, paramString2.optBoolean("autoPlay"));
          paramString1.setIsShowBasicControls(true);
          paramString1.setVideoSizeByte(paramString2.optInt("fileSize"));
          paramString1.setMute(paramString2.optBoolean("isMute"));
          paramString1.setCover$16da05f7(paramString2.optString("coverUrl"));
          paramString1.setVideoPlayerId(paramInt);
          paramString1.setAutoPlay(paramString2.optBoolean("autoPlay"));
          paramString1.cM(c.ax(paramString2), paramString2.optInt("durationSec"));
          paramString1.setFullScreenDelegate(new b.2(this, paramInt, new b.1(this, paramString1)));
          paramString2 = new b.3(this, paramString1);
          paramString1.setUiLifecycleListener(paramString2);
          this.rbg.a(paramString2);
          paramString1.setCallback(new d(paramString1, this.rbg, this.rbk));
          paramString2 = this.rbl;
          paramString1 = new com.tencent.mm.plugin.webview.fts.ui.b.1(paramString2, Boolean.valueOf(false), paramString1, paramInt, c.a(localJSONObject, this.context), c.r(localJSONObject));
          if (Thread.currentThread() != Looper.getMainLooper().getThread()) {
            break;
          }
          ((Boolean)paramString1.b(null)).booleanValue();
          return;
        }
      }
      catch (JSONException paramString1)
      {
        y.e("FtsVideoPlayerMgr", "", new Object[] { paramString1 });
        return;
      }
      paramString1.stop();
    }
    ((Boolean)paramString1.b(paramString2.mHandler)).booleanValue();
  }
  
  public final void x(int paramInt, String paramString1, String paramString2)
  {
    y.i("FtsVideoPlayerMgr", "update player id %d,viewProps %s,videoProps %s", new Object[] { Integer.valueOf(paramInt), paramString1, paramString2 });
    try
    {
      Object localObject;
      if (!TextUtils.isEmpty(paramString1))
      {
        localObject = new JSONObject(paramString1);
        paramString1 = this.rbl;
        localObject = new com.tencent.mm.plugin.webview.fts.ui.b.3(paramString1, Boolean.valueOf(false), paramInt, c.a((JSONObject)localObject, this.context), c.r((JSONObject)localObject));
        if (Thread.currentThread() != Looper.getMainLooper().getThread()) {
          break label155;
        }
        ((Boolean)((bf)localObject).b(null)).booleanValue();
      }
      for (;;)
      {
        if (TextUtils.isEmpty(paramString2)) {
          return;
        }
        paramString1 = new JSONObject(paramString2);
        paramString2 = (FtsWebVideoView)this.rbl.mg(paramInt);
        if (paramString2 != null) {
          break;
        }
        y.i("FtsVideoPlayerMgr", "can not find video View by id %d", new Object[] { Integer.valueOf(paramInt) });
        return;
        label155:
        ((Boolean)((bf)localObject).b(paramString1.mHandler)).booleanValue();
      }
      if (!paramString1.has("autoPlay")) {
        break label211;
      }
    }
    catch (JSONException paramString1)
    {
      y.e("FtsVideoPlayerMgr", "", new Object[] { paramString1 });
      return;
    }
    paramString2.setAutoPlay(paramString1.optBoolean("autoPlay"));
    label211:
    if (paramString1.has("coverUrl")) {
      paramString2.setCover$16da05f7(paramString1.optString("coverUrl"));
    }
    if (paramString1.has("durationSec")) {
      paramString2.setDuration(paramString1.optInt("durationSec"));
    }
    if (paramString1.has("playUrl")) {
      paramString2.cM(c.ax(paramString1), paramString1.optInt("durationSec"));
    }
    if (paramString1.has("isMute")) {
      paramString2.setMute(paramString1.optBoolean("isMute"));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.fts.c.b
 * JD-Core Version:    0.7.0.1
 */