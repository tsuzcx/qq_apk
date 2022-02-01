package com.tencent.mm.plugin.sns.ad.timeline.c.a;

import android.os.Handler;
import android.view.ViewGroup;
import android.widget.ImageView.ScaleType;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.ad.i.m;
import com.tencent.mm.plugin.sns.ad.widget.recyclerview.CardLayoutManager;
import com.tencent.mm.plugin.sns.ad.widget.recyclerview.CardLayoutManager.a;
import com.tencent.mm.plugin.sns.ad.widget.recyclerview.CardLayoutManager.c;
import com.tencent.mm.plugin.sns.data.r;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.plugin.sns.ui.OnlineVideoView;
import com.tencent.mm.plugin.sns.ui.OnlineVideoView.a;
import com.tencent.mm.plugin.sns.ui.video.c;
import com.tencent.mm.pluginsdk.ui.i.e;
import com.tencent.mm.protocal.protobuf.cnb;
import com.tencent.mm.sdk.platformtools.Log;

public final class f
  implements CardLayoutManager.c
{
  public SnsInfo DqO;
  final com.tencent.mm.plugin.sns.ad.timeline.video.online.e DyU;
  a DyZ;
  boolean DzK;
  boolean DzL;
  
  public f(com.tencent.mm.plugin.sns.ad.timeline.video.online.e parame, a parama)
  {
    this.DyU = parame;
    this.DyZ = parama;
  }
  
  private static OnlineVideoView E(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(202305);
    if (m.G(paramViewGroup))
    {
      paramViewGroup = paramViewGroup.getChildAt(0);
      if ((paramViewGroup instanceof OnlineVideoView))
      {
        paramViewGroup = (OnlineVideoView)paramViewGroup;
        AppMethodBeat.o(202305);
        return paramViewGroup;
      }
    }
    AppMethodBeat.o(202305);
    return null;
  }
  
  private void a(CardLayoutManager paramCardLayoutManager, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(202301);
    Log.d("SnsAd.TopicCardVideoPlayHelper", "playInner:: currentPosition is " + paramInt + ", the ready to play is " + this.DzL);
    if (paramCardLayoutManager == null)
    {
      AppMethodBeat.o(202301);
      return;
    }
    SnsInfo localSnsInfo = this.DqO;
    com.tencent.mm.plugin.sns.ad.a.e locale = b(paramCardLayoutManager, paramInt);
    e locale1 = c(paramCardLayoutManager, paramInt);
    if ((localSnsInfo == null) || (locale == null) || (locale1 == null) || (locale1.DzD == null))
    {
      Log.w("SnsAd.TopicCardVideoPlayHelper", "playInner::the resInfo or view holder is null");
      AppMethodBeat.o(202301);
      return;
    }
    paramCardLayoutManager.eYC();
    if (this.DzL)
    {
      if (locale.eWB())
      {
        Log.i("SnsAd.TopicCardVideoPlayHelper", "playInner:: currentPosition is " + paramInt + ", the res info is sight");
        a(paramCardLayoutManager, locale1.DzD, localSnsInfo, locale.ebR, paramBoolean);
        AppMethodBeat.o(202301);
        return;
      }
      paramCardLayoutManager.eYB();
      if (this.DyU != null)
      {
        this.DyU.cXa();
        AppMethodBeat.o(202301);
      }
    }
    else
    {
      Log.i("SnsAd.TopicCardVideoPlayHelper", "playInner::the topic item is not able to play video");
    }
    AppMethodBeat.o(202301);
  }
  
  private void a(CardLayoutManager paramCardLayoutManager, ViewGroup paramViewGroup, SnsInfo paramSnsInfo, cnb paramcnb, boolean paramBoolean)
  {
    AppMethodBeat.i(202304);
    com.tencent.mm.plugin.sns.ad.timeline.video.online.e locale = this.DyU;
    if ((locale == null) || (paramCardLayoutManager == null) || (paramViewGroup == null) || (paramSnsInfo == null) || (paramcnb == null))
    {
      Log.e("SnsAd.TopicCardVideoPlayHelper", "the input params are invalid!!!!");
      AppMethodBeat.o(202304);
      return;
    }
    c localc = new c();
    localc.ebR = paramcnb;
    localc.dHp = paramSnsInfo.getLocalid();
    localc.dRS = r.Jb(paramSnsInfo.field_snsId);
    localc.iXu = paramSnsInfo.getCreateTime();
    paramSnsInfo = locale.bx(paramViewGroup.getContext(), paramcnb.Id);
    OnlineVideoView localOnlineVideoView = E(paramViewGroup);
    if (localOnlineVideoView == null)
    {
      Log.d("SnsAd.TopicCardVideoPlayHelper", "the videoViewInContainer need new view");
      a(paramSnsInfo, paramCardLayoutManager, paramViewGroup, localc);
      AppMethodBeat.o(202304);
      return;
    }
    if (localOnlineVideoView == paramSnsInfo)
    {
      Log.d("SnsAd.TopicCardVideoPlayHelper", "the videoViewInContainer and media id view is same, is time line reason ".concat(String.valueOf(paramBoolean)));
      if (paramBoolean)
      {
        locale.a(localOnlineVideoView, paramcnb.Id);
        AppMethodBeat.o(202304);
        return;
      }
      locale.b(localOnlineVideoView, paramcnb.Id);
      AppMethodBeat.o(202304);
      return;
    }
    m.F(paramViewGroup);
    a(paramSnsInfo, paramCardLayoutManager, paramViewGroup, localc);
    AppMethodBeat.o(202304);
  }
  
  private void a(OnlineVideoView paramOnlineVideoView, CardLayoutManager paramCardLayoutManager, ViewGroup paramViewGroup, c paramc)
  {
    AppMethodBeat.i(202306);
    com.tencent.mm.plugin.sns.ad.timeline.video.online.e locale = this.DyU;
    if ((paramOnlineVideoView != null) && (locale != null))
    {
      m.fc(paramOnlineVideoView);
      m.u(paramOnlineVideoView, -1, -1);
      m.a(paramViewGroup, paramOnlineVideoView, 0);
      m.u(paramOnlineVideoView, true);
      paramOnlineVideoView.setThumbViewScaleType(ImageView.ScaleType.CENTER_CROP);
      paramOnlineVideoView.setVideoScaleType(i.e.Kcc);
      paramOnlineVideoView.setVideoCallback(new a(paramCardLayoutManager, paramOnlineVideoView));
      locale.a(paramOnlineVideoView, paramc, paramc.dRS, paramc.ebR.Id);
    }
    AppMethodBeat.o(202306);
  }
  
  private static com.tencent.mm.plugin.sns.ad.a.e b(CardLayoutManager paramCardLayoutManager, int paramInt)
  {
    AppMethodBeat.i(202302);
    if (paramCardLayoutManager == null)
    {
      AppMethodBeat.o(202302);
      return null;
    }
    try
    {
      paramCardLayoutManager = paramCardLayoutManager.cWP();
      if ((paramCardLayoutManager instanceof d))
      {
        paramCardLayoutManager = ((d)paramCardLayoutManager).XQ(paramInt);
        AppMethodBeat.o(202302);
        return paramCardLayoutManager;
      }
    }
    catch (Throwable paramCardLayoutManager)
    {
      Log.d("SnsAd.TopicCardVideoPlayHelper", "get topic resource information failed!");
      AppMethodBeat.o(202302);
    }
    return null;
  }
  
  private static e c(CardLayoutManager paramCardLayoutManager, int paramInt)
  {
    AppMethodBeat.i(202303);
    if (paramCardLayoutManager == null)
    {
      AppMethodBeat.o(202303);
      return null;
    }
    try
    {
      paramCardLayoutManager = paramCardLayoutManager.XZ(paramInt);
      if ((paramCardLayoutManager instanceof e))
      {
        paramCardLayoutManager = (e)paramCardLayoutManager;
        AppMethodBeat.o(202303);
        return paramCardLayoutManager;
      }
    }
    catch (Throwable paramCardLayoutManager)
    {
      AppMethodBeat.o(202303);
    }
    return null;
  }
  
  public final void a(CardLayoutManager paramCardLayoutManager, int paramInt)
  {
    AppMethodBeat.i(202298);
    if (paramInt == 1) {}
    try
    {
      this.DzK = true;
      paramCardLayoutManager.eYC();
      AppMethodBeat.o(202298);
      return;
    }
    catch (Throwable paramCardLayoutManager)
    {
      AppMethodBeat.o(202298);
    }
    this.DzK = false;
    AppMethodBeat.o(202298);
    return;
  }
  
  public final void a(CardLayoutManager paramCardLayoutManager, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(202299);
    Log.d("SnsAd.TopicCardVideoPlayHelper", "the onVisibleItemChanged is called , current position is " + paramInt1 + ", the last position " + paramInt2);
    try
    {
      if (this.DyZ != null)
      {
        Object localObject = this.DyZ;
        if (paramInt1 != ((a)localObject).currentIndex)
        {
          ((a)localObject).currentIndex = paramInt1;
          localObject = ((a)localObject).XP(paramInt1);
          if (localObject != null) {
            ((a.a)localObject).Dzo += 1;
          }
        }
      }
      a(paramCardLayoutManager, paramInt1, false);
      AppMethodBeat.o(202299);
      return;
    }
    catch (Throwable paramCardLayoutManager)
    {
      Log.d("SnsAd.TopicCardVideoPlayHelper", "onVisibleItemChanged has something wrong");
      AppMethodBeat.o(202299);
    }
  }
  
  public final void b(CardLayoutManager paramCardLayoutManager)
  {
    AppMethodBeat.i(202300);
    Log.i("SnsAd.TopicCardVideoPlayHelper", "resumePlayByTimeline is called!");
    this.DzL = true;
    if (paramCardLayoutManager != null) {}
    try
    {
      int i = paramCardLayoutManager.eYD();
      if (i >= 0) {
        a(paramCardLayoutManager, i, true);
      }
      AppMethodBeat.o(202300);
      return;
    }
    catch (Throwable paramCardLayoutManager)
    {
      Log.d("SnsAd.TopicCardVideoPlayHelper", "resumePlayByTimeline has something wrong");
      AppMethodBeat.o(202300);
    }
  }
  
  public final void eYb()
  {
    AppMethodBeat.i(202297);
    this.DzL = false;
    Log.d("SnsAd.TopicCardVideoPlayHelper", "the time line is paused, ready to play is false");
    com.tencent.mm.plugin.sns.ad.timeline.video.online.e locale = this.DyU;
    if (locale != null) {}
    try
    {
      locale.cXa();
      AppMethodBeat.o(202297);
      return;
    }
    catch (Throwable localThrowable)
    {
      AppMethodBeat.o(202297);
    }
  }
  
  final class a
    implements OnlineVideoView.a
  {
    final CardLayoutManager DyT;
    final OnlineVideoView DzM;
    boolean DzN = false;
    
    public a(CardLayoutManager paramCardLayoutManager, OnlineVideoView paramOnlineVideoView)
    {
      this.DzM = paramOnlineVideoView;
      this.DyT = paramCardLayoutManager;
    }
    
    public final void onCompletion()
    {
      AppMethodBeat.i(202295);
      try
      {
        Log.d("SnsAd.TopicCardVideoPlayHelper", "the video is onCompletion");
        this.DzN = false;
        if (this.DyT != null)
        {
          int i = this.DyT.eYD();
          if ((f.this.DyZ != null) && (this.DzM != null))
          {
            localObject = f.this.DyZ.XP(i);
            if (localObject != null)
            {
              ((a.a)localObject).Dzp += 1;
              ((a.a)localObject).Dzq += ((a.a)localObject).Dzs;
              ((a.a)localObject).Dzt = 0;
            }
            f.this.DyZ.io(i, this.DzM.getDuration());
          }
        }
        Object localObject = f.this;
        CardLayoutManager localCardLayoutManager = this.DyT;
        OnlineVideoView localOnlineVideoView = this.DzM;
        if (((f)localObject).DzK)
        {
          if (localOnlineVideoView != null)
          {
            localOnlineVideoView.aT(0, true);
            AppMethodBeat.o(202295);
          }
        }
        else if (localCardLayoutManager == null) {}
        AppMethodBeat.o(202295);
      }
      catch (Throwable localThrowable1)
      {
        try
        {
          if (localCardLayoutManager.DBo != null)
          {
            localObject = localCardLayoutManager.DBo;
            if (((CardLayoutManager.a)localObject).sCt != null)
            {
              ((CardLayoutManager.a)localObject).cancel();
              ((CardLayoutManager.a)localObject).sCt.sendEmptyMessage(0);
            }
          }
          AppMethodBeat.o(202295);
          return;
        }
        catch (Throwable localThrowable2) {}
        localThrowable1 = localThrowable1;
        AppMethodBeat.o(202295);
        return;
      }
    }
    
    public final void onStart(int paramInt)
    {
      AppMethodBeat.i(202294);
      try
      {
        Log.d("SnsAd.TopicCardVideoPlayHelper", "the video is start");
        if (this.DyT != null)
        {
          paramInt = this.DyT.eYD();
          if ((f.this.DyZ != null) && (this.DzM != null)) {
            f.this.DyZ.io(paramInt, this.DzM.getDuration());
          }
        }
        AppMethodBeat.o(202294);
        return;
      }
      catch (Throwable localThrowable)
      {
        AppMethodBeat.o(202294);
      }
    }
    
    public final void xv(int paramInt)
    {
      AppMethodBeat.i(202296);
      try
      {
        if (this.DyT != null)
        {
          int i = this.DyT.eYD();
          if ((f.this.DyZ != null) && (this.DzM != null))
          {
            Object localObject = this.DzM.getTag(2131308008);
            if (((localObject instanceof Integer)) && (((Integer)localObject).intValue() == 1))
            {
              Log.d("SnsAd.TopicCardVideoPlayHelper", "the video view has bean seek to 0");
              this.DzM.setTag(2131308008, Integer.valueOf(0));
              this.DzN = false;
              localObject = f.this.DyZ.XP(i);
              if (localObject != null)
              {
                ((a.a)localObject).Dzq += ((a.a)localObject).Dzt;
                ((a.a)localObject).Dzt = 0;
              }
            }
            localObject = f.this.DyZ;
            int j = paramInt * 1000;
            localObject = ((a)localObject).XP(i);
            if (localObject != null)
            {
              ((a.a)localObject).Dzt = j;
              if (((a.a)localObject).Dzr < j) {
                ((a.a)localObject).Dzr = j;
              }
            }
            if ((!this.DzN) && (paramInt > 0))
            {
              this.DzN = true;
              localObject = f.this.DyZ.XP(i);
              if (localObject != null) {
                ((a.a)localObject).Aiv += 1;
              }
            }
          }
        }
        AppMethodBeat.o(202296);
        return;
      }
      catch (Throwable localThrowable)
      {
        AppMethodBeat.o(202296);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.timeline.c.a.f
 * JD-Core Version:    0.7.0.1
 */