package com.tencent.mm.plugin.sns.ad.timeline.video.online;

import android.content.Context;
import android.text.TextUtils;
import android.util.ArrayMap;
import android.view.ViewGroup.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.ui.OnlineVideoView;
import com.tencent.mm.plugin.sns.ui.video.SnsTimelineVideoView;
import com.tencent.mm.plugin.sns.ui.video.d;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public final class e
{
  final Map<String, OnlineVideoView> JLm;
  String JLn;
  
  public e()
  {
    AppMethodBeat.i(200493);
    this.JLm = new ArrayMap();
    AppMethodBeat.o(200493);
  }
  
  private static boolean a(OnlineVideoView paramOnlineVideoView)
  {
    AppMethodBeat.i(200518);
    if ((paramOnlineVideoView instanceof SnsTimelineVideoView))
    {
      boolean bool = ((SnsTimelineVideoView)paramOnlineVideoView).adH();
      AppMethodBeat.o(200518);
      return bool;
    }
    AppMethodBeat.o(200518);
    return false;
  }
  
  private static boolean b(OnlineVideoView paramOnlineVideoView)
  {
    AppMethodBeat.i(200519);
    if ((paramOnlineVideoView instanceof SnsTimelineVideoView))
    {
      paramOnlineVideoView = (SnsTimelineVideoView)paramOnlineVideoView;
      if ((paramOnlineVideoView.Lrz) || (paramOnlineVideoView.Lrx) || (paramOnlineVideoView.KHA))
      {
        Log.i("VideoViewManager", "the video view is destroyed");
        AppMethodBeat.o(200519);
        return true;
      }
      AppMethodBeat.o(200519);
      return false;
    }
    Log.w("VideoViewManager", "the video view is not SnsTimelineVideoView");
    AppMethodBeat.o(200519);
    return true;
  }
  
  public final void a(OnlineVideoView paramOnlineVideoView, d paramd, String paramString1, String paramString2)
  {
    AppMethodBeat.i(200501);
    if ((paramOnlineVideoView == null) || (paramd == null) || (TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2)))
    {
      AppMethodBeat.o(200501);
      return;
    }
    Object localObject;
    try
    {
      paramOnlineVideoView.setVisibility(0);
      paramString1 = this.JLm;
      if (paramString1 != null)
      {
        paramString1 = paramString1.entrySet().iterator();
        while (paramString1.hasNext())
        {
          localObject = (Map.Entry)paramString1.next();
          if ((localObject != null) && (((Map.Entry)localObject).getValue() != null))
          {
            localObject = (OnlineVideoView)((Map.Entry)localObject).getValue();
            if (localObject != paramOnlineVideoView) {
              ((OnlineVideoView)localObject).dmi();
            }
          }
        }
      }
      paramString1 = this.JLm;
    }
    catch (Throwable paramOnlineVideoView)
    {
      Log.e("VideoViewManager", "startPlay has something wrong!");
      AppMethodBeat.o(200501);
      return;
    }
    if (paramString1 != null) {
      paramString1 = paramString1.entrySet().iterator();
    }
    label300:
    label304:
    for (;;)
    {
      if (paramString1.hasNext())
      {
        localObject = (Map.Entry)paramString1.next();
        if ((localObject == null) || (!b((OnlineVideoView)((Map.Entry)localObject).getValue()))) {
          break label300;
        }
      }
      for (int i = 1;; i = 0)
      {
        if (i == 0) {
          break label304;
        }
        paramString1.remove();
        break;
        paramOnlineVideoView.a(paramd.fVT, paramd.fAg, paramd.createTime);
        paramOnlineVideoView.fUe();
        paramOnlineVideoView.setMute(true);
        paramOnlineVideoView.onResume();
        paramd = this.JLm;
        if (paramd != null) {
          paramd.put(paramString2, paramOnlineVideoView);
        }
        Log.d("VideoViewManager", "the view map size is " + paramd.size());
        this.JLn = paramString2;
        AppMethodBeat.o(200501);
        return;
      }
    }
  }
  
  public final void a(OnlineVideoView paramOnlineVideoView, String paramString)
  {
    AppMethodBeat.i(200504);
    if ((paramOnlineVideoView != null) && (paramString != null)) {
      try
      {
        if (paramString.equals(this.JLn))
        {
          if (!a(paramOnlineVideoView)) {
            break label98;
          }
          int i = paramOnlineVideoView.getCurrentPosition();
          if (paramOnlineVideoView.getDuration() - i < 500)
          {
            Log.i("VideoViewManager", "the current position is too near to end of the video!!");
            paramOnlineVideoView.bc(0, true);
            AppMethodBeat.o(200504);
            return;
          }
          paramOnlineVideoView.fLJ();
          AppMethodBeat.o(200504);
          return;
        }
      }
      catch (Throwable paramOnlineVideoView)
      {
        Log.e("VideoViewManager", "resumePlay has something wrong!");
        AppMethodBeat.o(200504);
        return;
      }
    } else {
      Log.i("VideoViewManager", "the media is is not same as the current one!!!");
    }
    label98:
    AppMethodBeat.o(200504);
  }
  
  public final void b(OnlineVideoView paramOnlineVideoView, String paramString)
  {
    AppMethodBeat.i(200508);
    for (;;)
    {
      try
      {
        Map localMap = this.JLm;
        if ((localMap != null) && (paramString != null) && ((OnlineVideoView)localMap.get(paramString) == paramOnlineVideoView) && (paramOnlineVideoView != null) && (!b(paramOnlineVideoView)))
        {
          if (paramOnlineVideoView != null)
          {
            paramOnlineVideoView.bc(0, true);
            paramOnlineVideoView.setTag(i.f.sns_ad_finder_topic_card_item_seek_tag, Integer.valueOf(1));
            AppMethodBeat.o(200508);
            return;
          }
          Log.i("VideoViewManager", "the media is is not same as the current one, or the view is destroyed!!!");
          AppMethodBeat.o(200508);
          return;
        }
      }
      catch (Throwable paramOnlineVideoView)
      {
        Log.w("VideoViewManager", "seekPlay has something wrong!");
        AppMethodBeat.o(200508);
        return;
      }
      paramOnlineVideoView = null;
    }
  }
  
  public final OnlineVideoView bL(Context paramContext, String paramString)
  {
    int i = 0;
    AppMethodBeat.i(200515);
    Map localMap = this.JLm;
    if (localMap == null)
    {
      Log.w("VideoViewManager", "are you sure? the map is null? I don't think the statement can reach!!");
      AppMethodBeat.o(200515);
      return null;
    }
    for (;;)
    {
      try
      {
        paramString = (OnlineVideoView)localMap.get(paramString);
        if ((paramString != null) && (!b(paramString)))
        {
          if (i != 0)
          {
            Log.d("VideoViewManager", "to new one video view!");
            paramString = new SnsTimelineVideoView(paramContext, (byte)0);
            paramString.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
          }
          AppMethodBeat.o(200515);
          return paramString;
        }
      }
      catch (Throwable paramContext)
      {
        Log.e("VideoViewManager", "getVideoViewWithMediaId has something wrong!");
        AppMethodBeat.o(200515);
        return null;
      }
      i = 1;
    }
  }
  
  public final void dmi()
  {
    AppMethodBeat.i(200510);
    Object localObject = this.JLm;
    String str = this.JLn;
    try
    {
      if ((!TextUtils.isEmpty(str)) && (localObject != null))
      {
        localObject = (OnlineVideoView)((Map)localObject).get(str);
        if (localObject != null) {
          ((OnlineVideoView)localObject).dmi();
        }
      }
      AppMethodBeat.o(200510);
      return;
    }
    catch (Throwable localThrowable)
    {
      Log.e("VideoViewManager", "pausePlay has something wrong!");
      AppMethodBeat.o(200510);
    }
  }
  
  public final void stopAll()
  {
    AppMethodBeat.i(200522);
    try
    {
      Object localObject1 = this.JLm;
      if (localObject1 == null)
      {
        AppMethodBeat.o(200522);
        return;
      }
      localObject1 = ((Map)localObject1).entrySet().iterator();
      while (((Iterator)localObject1).hasNext())
      {
        Object localObject2 = (Map.Entry)((Iterator)localObject1).next();
        if ((localObject2 != null) && (((Map.Entry)localObject2).getValue() != null))
        {
          localObject2 = (OnlineVideoView)((Map.Entry)localObject2).getValue();
          if ((localObject2 instanceof SnsTimelineVideoView)) {
            ((SnsTimelineVideoView)localObject2).fZa();
          }
        }
      }
      AppMethodBeat.o(200522);
    }
    catch (Throwable localThrowable)
    {
      Log.e("VideoViewManager", "stopAll has something wrong!");
      AppMethodBeat.o(200522);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.timeline.video.online.e
 * JD-Core Version:    0.7.0.1
 */