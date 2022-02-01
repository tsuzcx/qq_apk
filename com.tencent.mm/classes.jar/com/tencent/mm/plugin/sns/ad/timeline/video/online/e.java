package com.tencent.mm.plugin.sns.ad.timeline.video.online;

import android.content.Context;
import android.text.TextUtils;
import android.util.ArrayMap;
import android.view.ViewGroup.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.b.f;
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
  final Map<String, OnlineVideoView> QcV;
  String QcW;
  
  public e()
  {
    AppMethodBeat.i(310961);
    this.QcV = new ArrayMap();
    AppMethodBeat.o(310961);
  }
  
  private static boolean a(OnlineVideoView paramOnlineVideoView)
  {
    AppMethodBeat.i(310966);
    if ((paramOnlineVideoView instanceof SnsTimelineVideoView))
    {
      boolean bool = ((SnsTimelineVideoView)paramOnlineVideoView).aFF();
      AppMethodBeat.o(310966);
      return bool;
    }
    AppMethodBeat.o(310966);
    return false;
  }
  
  private static boolean b(OnlineVideoView paramOnlineVideoView)
  {
    AppMethodBeat.i(310974);
    if ((paramOnlineVideoView instanceof SnsTimelineVideoView))
    {
      paramOnlineVideoView = (SnsTimelineVideoView)paramOnlineVideoView;
      if ((paramOnlineVideoView.RUD) || (paramOnlineVideoView.RUB) || (paramOnlineVideoView.Rha))
      {
        Log.i("VideoViewManager", "the video view is destroyed");
        AppMethodBeat.o(310974);
        return true;
      }
      AppMethodBeat.o(310974);
      return false;
    }
    Log.w("VideoViewManager", "the video view is not SnsTimelineVideoView");
    AppMethodBeat.o(310974);
    return true;
  }
  
  public final void a(OnlineVideoView paramOnlineVideoView, d paramd, String paramString1, String paramString2)
  {
    AppMethodBeat.i(310986);
    if ((paramOnlineVideoView == null) || (paramd == null) || (TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2)))
    {
      AppMethodBeat.o(310986);
      return;
    }
    Object localObject;
    try
    {
      paramOnlineVideoView.setVisibility(0);
      paramString1 = this.QcV;
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
              ((OnlineVideoView)localObject).bck();
            }
          }
        }
      }
      paramString1 = this.QcV;
    }
    finally
    {
      Log.e("VideoViewManager", "startPlay has something wrong!");
      AppMethodBeat.o(310986);
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
        paramOnlineVideoView.a(paramd.ibT, paramd.hES, paramd.createTime);
        paramOnlineVideoView.hmy();
        paramOnlineVideoView.setMute(true);
        paramOnlineVideoView.onResume();
        paramd = this.QcV;
        if (paramd != null) {
          paramd.put(paramString2, paramOnlineVideoView);
        }
        Log.d("VideoViewManager", "the view map size is " + paramd.size());
        this.QcW = paramString2;
        AppMethodBeat.o(310986);
        return;
      }
    }
  }
  
  public final void a(OnlineVideoView paramOnlineVideoView, String paramString)
  {
    AppMethodBeat.i(310992);
    if ((paramOnlineVideoView != null) && (paramString != null)) {
      try
      {
        if (paramString.equals(this.QcW))
        {
          if (!a(paramOnlineVideoView)) {
            break label98;
          }
          int i = paramOnlineVideoView.getCurrentPosition();
          if (paramOnlineVideoView.getDuration() - i < 500)
          {
            Log.i("VideoViewManager", "the current position is too near to end of the video!!");
            paramOnlineVideoView.bJ(0, true);
            AppMethodBeat.o(310992);
            return;
          }
          paramOnlineVideoView.bcl();
          AppMethodBeat.o(310992);
          return;
        }
      }
      finally
      {
        Log.e("VideoViewManager", "resumePlay has something wrong!");
        AppMethodBeat.o(310992);
        return;
      }
    } else {
      Log.i("VideoViewManager", "the media is is not same as the current one!!!");
    }
    label98:
    AppMethodBeat.o(310992);
  }
  
  public final void b(OnlineVideoView paramOnlineVideoView, String paramString)
  {
    AppMethodBeat.i(310999);
    for (;;)
    {
      try
      {
        Map localMap = this.QcV;
        if ((localMap != null) && (paramString != null) && ((OnlineVideoView)localMap.get(paramString) == paramOnlineVideoView) && (paramOnlineVideoView != null) && (!b(paramOnlineVideoView))) {
          if (paramOnlineVideoView != null)
          {
            paramOnlineVideoView.bJ(0, true);
            paramOnlineVideoView.setTag(b.f.sns_ad_finder_topic_card_item_seek_tag, Integer.valueOf(1));
            AppMethodBeat.o(310999);
            return;
          }
        }
      }
      finally
      {
        Log.w("VideoViewManager", "seekPlay has something wrong!");
        AppMethodBeat.o(310999);
        return;
      }
      paramOnlineVideoView = null;
    }
  }
  
  public final OnlineVideoView bO(Context paramContext, String paramString)
  {
    int i = 0;
    AppMethodBeat.i(311018);
    Map localMap = this.QcV;
    if (localMap == null)
    {
      Log.w("VideoViewManager", "are you sure? the map is null? I don't think the statement can reach!!");
      AppMethodBeat.o(311018);
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
          AppMethodBeat.o(311018);
          return paramString;
        }
      }
      finally
      {
        Log.e("VideoViewManager", "getVideoViewWithMediaId has something wrong!");
        AppMethodBeat.o(311018);
        return null;
      }
      i = 1;
    }
  }
  
  public final void bck()
  {
    AppMethodBeat.i(311008);
    Object localObject1 = this.QcV;
    String str = this.QcW;
    try
    {
      if ((!TextUtils.isEmpty(str)) && (localObject1 != null))
      {
        localObject1 = (OnlineVideoView)((Map)localObject1).get(str);
        if (localObject1 != null) {
          ((OnlineVideoView)localObject1).bck();
        }
      }
      AppMethodBeat.o(311008);
      return;
    }
    finally
    {
      Log.e("VideoViewManager", "pausePlay has something wrong!");
      AppMethodBeat.o(311008);
    }
  }
  
  public final void stopAll()
  {
    AppMethodBeat.i(311031);
    try
    {
      Object localObject1 = this.QcV;
      if (localObject1 == null)
      {
        AppMethodBeat.o(311031);
        return;
      }
      localObject1 = ((Map)localObject1).entrySet().iterator();
      while (((Iterator)localObject1).hasNext())
      {
        Object localObject3 = (Map.Entry)((Iterator)localObject1).next();
        if ((localObject3 != null) && (((Map.Entry)localObject3).getValue() != null))
        {
          localObject3 = (OnlineVideoView)((Map.Entry)localObject3).getValue();
          if ((localObject3 instanceof SnsTimelineVideoView)) {
            ((SnsTimelineVideoView)localObject3).hsl();
          }
        }
      }
      AppMethodBeat.o(311031);
    }
    finally
    {
      Log.e("VideoViewManager", "stopAll has something wrong!");
      AppMethodBeat.o(311031);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.timeline.video.online.e
 * JD-Core Version:    0.7.0.1
 */