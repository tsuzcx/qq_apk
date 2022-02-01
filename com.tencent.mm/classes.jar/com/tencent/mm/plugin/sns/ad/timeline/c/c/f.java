package com.tencent.mm.plugin.sns.ad.timeline.c.c;

import android.view.ViewGroup;
import android.widget.ImageView.ScaleType;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.ad.i.l;
import com.tencent.mm.plugin.sns.ad.widget.recyclerview.CardLayoutManager;
import com.tencent.mm.plugin.sns.ad.widget.recyclerview.CardLayoutManager.c;
import com.tencent.mm.plugin.sns.data.t;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.plugin.sns.ui.OnlineVideoView;
import com.tencent.mm.plugin.sns.ui.OnlineVideoView.b;
import com.tencent.mm.pluginsdk.ui.i.e;
import com.tencent.mm.protocal.protobuf.cvt;
import com.tencent.mm.sdk.platformtools.Log;

public final class f
  implements CardLayoutManager.c
{
  final com.tencent.mm.plugin.sns.ad.timeline.video.online.e JJk;
  a JJp;
  boolean JKd;
  boolean JKe;
  public SnsInfo Jws;
  
  public f(com.tencent.mm.plugin.sns.ad.timeline.video.online.e parame, a parama)
  {
    this.JJk = parame;
    this.JJp = parama;
  }
  
  private static OnlineVideoView K(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(268243);
    if (l.N(paramViewGroup))
    {
      paramViewGroup = paramViewGroup.getChildAt(0);
      if ((paramViewGroup instanceof OnlineVideoView))
      {
        paramViewGroup = (OnlineVideoView)paramViewGroup;
        AppMethodBeat.o(268243);
        return paramViewGroup;
      }
    }
    AppMethodBeat.o(268243);
    return null;
  }
  
  private void a(CardLayoutManager paramCardLayoutManager, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(268238);
    Log.d("SnsAd.TopicCardVideoPlayHelper", "playInner:: currentPosition is " + paramInt + ", the ready to play is " + this.JKe);
    if (paramCardLayoutManager == null)
    {
      AppMethodBeat.o(268238);
      return;
    }
    SnsInfo localSnsInfo = this.Jws;
    com.tencent.mm.plugin.sns.ad.adxml.e locale = d(paramCardLayoutManager, paramInt);
    e locale1 = e(paramCardLayoutManager, paramInt);
    if ((localSnsInfo == null) || (locale == null) || (locale1 == null) || (locale1.JJX == null))
    {
      Log.w("SnsAd.TopicCardVideoPlayHelper", "playInner::the resInfo or view holder is null");
      AppMethodBeat.o(268238);
      return;
    }
    paramCardLayoutManager.fMn();
    if (this.JKe)
    {
      if (locale.fJE())
      {
        Log.i("SnsAd.TopicCardVideoPlayHelper", "playInner:: currentPosition is " + paramInt + ", the res info is sight");
        a(paramCardLayoutManager, locale1.JJX, localSnsInfo, locale.fVT, paramBoolean);
        AppMethodBeat.o(268238);
        return;
      }
      paramCardLayoutManager.fMm();
      if (this.JJk != null)
      {
        this.JJk.dmi();
        AppMethodBeat.o(268238);
      }
    }
    else
    {
      Log.i("SnsAd.TopicCardVideoPlayHelper", "playInner::the topic item is not able to play video");
    }
    AppMethodBeat.o(268238);
  }
  
  private void a(CardLayoutManager paramCardLayoutManager, ViewGroup paramViewGroup, SnsInfo paramSnsInfo, cvt paramcvt, boolean paramBoolean)
  {
    AppMethodBeat.i(268242);
    com.tencent.mm.plugin.sns.ad.timeline.video.online.e locale = this.JJk;
    if ((locale == null) || (paramCardLayoutManager == null) || (paramViewGroup == null) || (paramSnsInfo == null) || (paramcvt == null))
    {
      Log.e("SnsAd.TopicCardVideoPlayHelper", "the input params are invalid!!!!");
      AppMethodBeat.o(268242);
      return;
    }
    com.tencent.mm.plugin.sns.ui.video.d locald = new com.tencent.mm.plugin.sns.ui.video.d();
    locald.fVT = paramcvt;
    locald.fAg = paramSnsInfo.getLocalid();
    locald.fLp = t.Qu(paramSnsInfo.field_snsId);
    locald.createTime = paramSnsInfo.getCreateTime();
    paramSnsInfo = locale.bL(paramViewGroup.getContext(), paramcvt.Id);
    OnlineVideoView localOnlineVideoView = K(paramViewGroup);
    if (localOnlineVideoView == null)
    {
      Log.d("SnsAd.TopicCardVideoPlayHelper", "the videoViewInContainer need new view");
      a(paramSnsInfo, paramCardLayoutManager, paramViewGroup, locald);
      AppMethodBeat.o(268242);
      return;
    }
    if (localOnlineVideoView == paramSnsInfo)
    {
      Log.d("SnsAd.TopicCardVideoPlayHelper", "the videoViewInContainer and media id view is same, is time line reason ".concat(String.valueOf(paramBoolean)));
      if (paramBoolean)
      {
        locale.a(localOnlineVideoView, paramcvt.Id);
        AppMethodBeat.o(268242);
        return;
      }
      locale.b(localOnlineVideoView, paramcvt.Id);
      AppMethodBeat.o(268242);
      return;
    }
    l.M(paramViewGroup);
    a(paramSnsInfo, paramCardLayoutManager, paramViewGroup, locald);
    AppMethodBeat.o(268242);
  }
  
  private void a(OnlineVideoView paramOnlineVideoView, CardLayoutManager paramCardLayoutManager, ViewGroup paramViewGroup, com.tencent.mm.plugin.sns.ui.video.d paramd)
  {
    AppMethodBeat.i(268244);
    com.tencent.mm.plugin.sns.ad.timeline.video.online.e locale = this.JJk;
    if ((paramOnlineVideoView != null) && (locale != null))
    {
      l.gj(paramOnlineVideoView);
      l.v(paramOnlineVideoView, -1, -1);
      l.b(paramViewGroup, paramOnlineVideoView, 0);
      l.w(paramOnlineVideoView, true);
      paramOnlineVideoView.setThumbViewScaleType(ImageView.ScaleType.CENTER_CROP);
      paramOnlineVideoView.setVideoScaleType(i.e.RcH);
      paramOnlineVideoView.setVideoCallback(new a(paramCardLayoutManager, paramOnlineVideoView));
      locale.a(paramOnlineVideoView, paramd, paramd.fLp, paramd.fVT.Id);
    }
    AppMethodBeat.o(268244);
  }
  
  private static com.tencent.mm.plugin.sns.ad.adxml.e d(CardLayoutManager paramCardLayoutManager, int paramInt)
  {
    AppMethodBeat.i(268240);
    if (paramCardLayoutManager == null)
    {
      AppMethodBeat.o(268240);
      return null;
    }
    try
    {
      paramCardLayoutManager = paramCardLayoutManager.dlX();
      if ((paramCardLayoutManager instanceof d))
      {
        paramCardLayoutManager = ((d)paramCardLayoutManager).afe(paramInt);
        AppMethodBeat.o(268240);
        return paramCardLayoutManager;
      }
    }
    catch (Throwable paramCardLayoutManager)
    {
      Log.d("SnsAd.TopicCardVideoPlayHelper", "get topic resource information failed!");
      AppMethodBeat.o(268240);
    }
    return null;
  }
  
  private static e e(CardLayoutManager paramCardLayoutManager, int paramInt)
  {
    AppMethodBeat.i(268241);
    if (paramCardLayoutManager == null)
    {
      AppMethodBeat.o(268241);
      return null;
    }
    try
    {
      paramCardLayoutManager = paramCardLayoutManager.afo(paramInt);
      if ((paramCardLayoutManager instanceof e))
      {
        paramCardLayoutManager = (e)paramCardLayoutManager;
        AppMethodBeat.o(268241);
        return paramCardLayoutManager;
      }
    }
    catch (Throwable paramCardLayoutManager)
    {
      AppMethodBeat.o(268241);
    }
    return null;
  }
  
  public final void a(CardLayoutManager paramCardLayoutManager, int paramInt)
  {
    AppMethodBeat.i(268234);
    if (paramInt == 1) {}
    try
    {
      this.JKd = true;
      paramCardLayoutManager.fMn();
      AppMethodBeat.o(268234);
      return;
    }
    catch (Throwable paramCardLayoutManager)
    {
      AppMethodBeat.o(268234);
    }
    this.JKd = false;
    AppMethodBeat.o(268234);
    return;
  }
  
  public final void a(CardLayoutManager paramCardLayoutManager, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(268235);
    Log.d("SnsAd.TopicCardVideoPlayHelper", "the onVisibleItemChanged is called , current position is " + paramInt1 + ", the last position " + paramInt2);
    try
    {
      if (this.JJp != null)
      {
        Object localObject = this.JJp;
        if (paramInt1 != ((a)localObject).currentIndex)
        {
          ((a)localObject).currentIndex = paramInt1;
          localObject = ((a)localObject).afd(paramInt1);
          if (localObject != null) {
            ((a.a)localObject).JGy += 1;
          }
        }
      }
      a(paramCardLayoutManager, paramInt1, false);
      AppMethodBeat.o(268235);
      return;
    }
    catch (Throwable paramCardLayoutManager)
    {
      Log.d("SnsAd.TopicCardVideoPlayHelper", "onVisibleItemChanged has something wrong");
      AppMethodBeat.o(268235);
    }
  }
  
  public final void afa(int paramInt) {}
  
  public final void b(CardLayoutManager paramCardLayoutManager)
  {
    AppMethodBeat.i(268237);
    Log.i("SnsAd.TopicCardVideoPlayHelper", "resumePlayByTimeline is called!");
    this.JKe = true;
    if (paramCardLayoutManager != null) {}
    try
    {
      int i = paramCardLayoutManager.fMo();
      if (i >= 0) {
        a(paramCardLayoutManager, i, true);
      }
      AppMethodBeat.o(268237);
      return;
    }
    catch (Throwable paramCardLayoutManager)
    {
      Log.d("SnsAd.TopicCardVideoPlayHelper", "resumePlayByTimeline has something wrong");
      AppMethodBeat.o(268237);
    }
  }
  
  public final void fLB()
  {
    AppMethodBeat.i(268233);
    this.JKe = false;
    Log.d("SnsAd.TopicCardVideoPlayHelper", "the time line is paused, ready to play is false");
    com.tencent.mm.plugin.sns.ad.timeline.video.online.e locale = this.JJk;
    if (locale != null) {}
    try
    {
      locale.dmi();
      AppMethodBeat.o(268233);
      return;
    }
    catch (Throwable localThrowable)
    {
      AppMethodBeat.o(268233);
    }
  }
  
  final class a
    implements OnlineVideoView.b
  {
    final CardLayoutManager JJj;
    final OnlineVideoView JKf;
    boolean JKg = false;
    
    public a(CardLayoutManager paramCardLayoutManager, OnlineVideoView paramOnlineVideoView)
    {
      this.JKf = paramOnlineVideoView;
      this.JJj = paramCardLayoutManager;
    }
    
    public final void AS(int paramInt)
    {
      AppMethodBeat.i(253565);
      paramInt /= 1000;
      try
      {
        if (this.JJj != null)
        {
          int i = this.JJj.fMo();
          if ((f.this.JJp != null) && (this.JKf != null))
          {
            Object localObject = this.JKf.getTag(i.f.sns_ad_finder_topic_card_item_seek_tag);
            if (((localObject instanceof Integer)) && (((Integer)localObject).intValue() == 1))
            {
              Log.d("SnsAd.TopicCardVideoPlayHelper", "the video view has bean seek to 0");
              this.JKf.setTag(i.f.sns_ad_finder_topic_card_item_seek_tag, Integer.valueOf(0));
              this.JKg = false;
              localObject = f.this.JJp.afd(i);
              if (localObject != null)
              {
                ((a.a)localObject).JJM += ((a.a)localObject).JJP;
                ((a.a)localObject).JJP = 0;
              }
            }
            localObject = f.this.JJp;
            int j = paramInt * 1000;
            localObject = ((a)localObject).afd(i);
            if (localObject != null)
            {
              ((a.a)localObject).JJP = j;
              if (((a.a)localObject).JJN < j) {
                ((a.a)localObject).JJN = j;
              }
            }
            if ((!this.JKg) && (paramInt > 0))
            {
              this.JKg = true;
              localObject = f.this.JJp.afd(i);
              if (localObject != null) {
                ((a.a)localObject).FPs += 1;
              }
            }
          }
        }
        AppMethodBeat.o(253565);
        return;
      }
      catch (Throwable localThrowable)
      {
        AppMethodBeat.o(253565);
      }
    }
    
    public final void onCompletion()
    {
      AppMethodBeat.i(253562);
      try
      {
        Log.d("SnsAd.TopicCardVideoPlayHelper", "the video is onCompletion");
        this.JKg = false;
        if (this.JJj != null)
        {
          int i = this.JJj.fMo();
          if ((f.this.JJp != null) && (this.JKf != null))
          {
            localObject = f.this.JJp.afd(i);
            if (localObject != null)
            {
              ((a.a)localObject).JJL += 1;
              ((a.a)localObject).JJM += ((a.a)localObject).JJO;
              ((a.a)localObject).JJP = 0;
            }
            f.this.JJp.jx(i, this.JKf.getDuration());
          }
        }
        Object localObject = f.this;
        CardLayoutManager localCardLayoutManager = this.JJj;
        OnlineVideoView localOnlineVideoView = this.JKf;
        if (((f)localObject).JKd)
        {
          if (localOnlineVideoView != null)
          {
            localOnlineVideoView.bc(0, true);
            AppMethodBeat.o(253562);
          }
        }
        else if (localCardLayoutManager != null) {
          localCardLayoutManager.fMl();
        }
        AppMethodBeat.o(253562);
        return;
      }
      catch (Throwable localThrowable)
      {
        AppMethodBeat.o(253562);
      }
    }
    
    public final void onStart(int paramInt)
    {
      AppMethodBeat.i(253558);
      try
      {
        Log.d("SnsAd.TopicCardVideoPlayHelper", "the video is start");
        if (this.JJj != null)
        {
          paramInt = this.JJj.fMo();
          if ((f.this.JJp != null) && (this.JKf != null)) {
            f.this.JJp.jx(paramInt, this.JKf.getDuration());
          }
        }
        AppMethodBeat.o(253558);
        return;
      }
      catch (Throwable localThrowable)
      {
        AppMethodBeat.o(253558);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.timeline.c.c.f
 * JD-Core Version:    0.7.0.1
 */