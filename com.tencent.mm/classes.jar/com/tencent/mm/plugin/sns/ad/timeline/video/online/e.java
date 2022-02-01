package com.tencent.mm.plugin.sns.ad.timeline.video.online;

import android.content.Context;
import android.text.TextUtils;
import android.util.ArrayMap;
import android.view.ViewGroup.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.ui.OnlineVideoView;
import com.tencent.mm.plugin.sns.ui.video.SnsTimelineVideoView;
import com.tencent.mm.plugin.sns.ui.video.c;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public final class e
{
  final Map<String, OnlineVideoView> DzX;
  String DzY;
  
  public e()
  {
    AppMethodBeat.i(202327);
    this.DzX = new ArrayMap();
    AppMethodBeat.o(202327);
  }
  
  private static boolean a(OnlineVideoView paramOnlineVideoView)
  {
    AppMethodBeat.i(202333);
    if ((paramOnlineVideoView instanceof SnsTimelineVideoView))
    {
      boolean bool = ((SnsTimelineVideoView)paramOnlineVideoView).YY();
      AppMethodBeat.o(202333);
      return bool;
    }
    AppMethodBeat.o(202333);
    return false;
  }
  
  private static boolean b(OnlineVideoView paramOnlineVideoView)
  {
    AppMethodBeat.i(202334);
    if ((paramOnlineVideoView instanceof SnsTimelineVideoView))
    {
      paramOnlineVideoView = (SnsTimelineVideoView)paramOnlineVideoView;
      if ((paramOnlineVideoView.Fdd) || (paramOnlineVideoView.Fdb) || (paramOnlineVideoView.EtU))
      {
        Log.i("VideoViewManager", "the video view is destroyed");
        AppMethodBeat.o(202334);
        return true;
      }
      AppMethodBeat.o(202334);
      return false;
    }
    Log.w("VideoViewManager", "the video view is not SnsTimelineVideoView");
    AppMethodBeat.o(202334);
    return true;
  }
  
  public final void a(OnlineVideoView paramOnlineVideoView, c paramc, String paramString1, String paramString2)
  {
    AppMethodBeat.i(202328);
    if ((paramOnlineVideoView == null) || (paramc == null) || (TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2)))
    {
      AppMethodBeat.o(202328);
      return;
    }
    Object localObject;
    try
    {
      paramOnlineVideoView.setVisibility(0);
      paramString1 = this.DzX;
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
              ((OnlineVideoView)localObject).cXa();
            }
          }
        }
      }
      paramString1 = this.DzX;
    }
    catch (Throwable paramOnlineVideoView)
    {
      Log.e("VideoViewManager", "startPlay has something wrong!");
      AppMethodBeat.o(202328);
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
        paramOnlineVideoView.a(paramc.ebR, paramc.dHp, paramc.iXu);
        paramOnlineVideoView.fgg();
        paramOnlineVideoView.setMute(true);
        paramOnlineVideoView.onResume();
        paramc = this.DzX;
        if (paramc != null) {
          paramc.put(paramString2, paramOnlineVideoView);
        }
        Log.d("VideoViewManager", "the view map size is " + paramc.size());
        this.DzY = paramString2;
        AppMethodBeat.o(202328);
        return;
      }
    }
  }
  
  public final void a(OnlineVideoView paramOnlineVideoView, String paramString)
  {
    AppMethodBeat.i(202329);
    if ((paramOnlineVideoView != null) && (paramString != null)) {
      try
      {
        if (paramString.equals(this.DzY))
        {
          if (!a(paramOnlineVideoView)) {
            break label98;
          }
          int i = paramOnlineVideoView.getCurrentPosition();
          if (paramOnlineVideoView.getDuration() - i < 500)
          {
            Log.i("VideoViewManager", "the current position is too near to end of the video!!");
            paramOnlineVideoView.aT(0, true);
            AppMethodBeat.o(202329);
            return;
          }
          paramOnlineVideoView.eYd();
          AppMethodBeat.o(202329);
          return;
        }
      }
      catch (Throwable paramOnlineVideoView)
      {
        Log.e("VideoViewManager", "resumePlay has something wrong!");
        AppMethodBeat.o(202329);
        return;
      }
    } else {
      Log.i("VideoViewManager", "the media is is not same as the current one!!!");
    }
    label98:
    AppMethodBeat.o(202329);
  }
  
  public final void b(OnlineVideoView paramOnlineVideoView, String paramString)
  {
    AppMethodBeat.i(202330);
    for (;;)
    {
      try
      {
        Map localMap = this.DzX;
        if ((localMap != null) && (paramString != null) && ((OnlineVideoView)localMap.get(paramString) == paramOnlineVideoView) && (paramOnlineVideoView != null) && (!b(paramOnlineVideoView)))
        {
          if (paramOnlineVideoView != null)
          {
            paramOnlineVideoView.aT(0, true);
            paramOnlineVideoView.setTag(2131308008, Integer.valueOf(1));
            AppMethodBeat.o(202330);
            return;
          }
          Log.i("VideoViewManager", "the media is is not same as the current one, or the view is destroyed!!!");
          AppMethodBeat.o(202330);
          return;
        }
      }
      catch (Throwable paramOnlineVideoView)
      {
        Log.w("VideoViewManager", "seekPlay has something wrong!");
        AppMethodBeat.o(202330);
        return;
      }
      paramOnlineVideoView = null;
    }
  }
  
  public final OnlineVideoView bx(Context paramContext, String paramString)
  {
    AppMethodBeat.i(202332);
    Map localMap = this.DzX;
    if (localMap == null)
    {
      Log.w("VideoViewManager", "are you sure? the map is null? I don't think the statement can reach!!");
      AppMethodBeat.o(202332);
      return null;
    }
    label116:
    for (;;)
    {
      try
      {
        paramString = (OnlineVideoView)localMap.get(paramString);
        if (paramString != null) {
          if (b(paramString))
          {
            break label116;
            if (i != 0)
            {
              Log.d("VideoViewManager", "to new one video view!");
              paramString = new SnsTimelineVideoView(paramContext);
              paramString.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
            }
            AppMethodBeat.o(202332);
            return paramString;
          }
          else
          {
            i = 0;
            continue;
          }
        }
        int i = 1;
      }
      catch (Throwable paramContext)
      {
        Log.e("VideoViewManager", "getVideoViewWithMediaId has something wrong!");
        AppMethodBeat.o(202332);
        return null;
      }
    }
  }
  
  public final void cXa()
  {
    AppMethodBeat.i(202331);
    Object localObject = this.DzX;
    String str = this.DzY;
    try
    {
      if ((!TextUtils.isEmpty(str)) && (localObject != null))
      {
        localObject = (OnlineVideoView)((Map)localObject).get(str);
        if (localObject != null) {
          ((OnlineVideoView)localObject).cXa();
        }
      }
      AppMethodBeat.o(202331);
      return;
    }
    catch (Throwable localThrowable)
    {
      Log.e("VideoViewManager", "pausePlay has something wrong!");
      AppMethodBeat.o(202331);
    }
  }
  
  public final void stopAll()
  {
    AppMethodBeat.i(202335);
    try
    {
      Object localObject1 = this.DzX;
      if (localObject1 == null)
      {
        AppMethodBeat.o(202335);
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
            ((SnsTimelineVideoView)localObject2).fkP();
          }
        }
      }
      AppMethodBeat.o(202335);
    }
    catch (Throwable localThrowable)
    {
      Log.e("VideoViewManager", "stopAll has something wrong!");
      AppMethodBeat.o(202335);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.timeline.video.online.e
 * JD-Core Version:    0.7.0.1
 */