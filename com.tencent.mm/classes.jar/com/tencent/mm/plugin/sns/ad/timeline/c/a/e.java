package com.tencent.mm.plugin.sns.ad.timeline.c.a;

import android.view.ViewGroup;
import android.widget.ImageView.ScaleType;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.ad.adxml.i;
import com.tencent.mm.plugin.sns.ad.i.l;
import com.tencent.mm.plugin.sns.ad.widget.recyclerview.CardLayoutManager;
import com.tencent.mm.plugin.sns.ad.widget.recyclerview.CardLayoutManager.c;
import com.tencent.mm.plugin.sns.data.m;
import com.tencent.mm.plugin.sns.data.t;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.plugin.sns.ui.OnlineVideoView;
import com.tencent.mm.plugin.sns.ui.OnlineVideoView.b;
import com.tencent.mm.pluginsdk.ui.i.e;
import com.tencent.mm.protocal.protobuf.cvt;
import com.tencent.mm.sdk.platformtools.Log;

public final class e
  implements CardLayoutManager.c
{
  b JJE;
  final com.tencent.mm.plugin.sns.ad.timeline.video.online.e JJk;
  boolean JKd;
  boolean JKe;
  public SnsInfo Jws;
  
  public e(com.tencent.mm.plugin.sns.ad.timeline.video.online.e parame, b paramb)
  {
    this.JJk = parame;
    this.JJE = paramb;
  }
  
  private static OnlineVideoView K(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(269333);
    if (l.N(paramViewGroup))
    {
      paramViewGroup = paramViewGroup.getChildAt(0);
      if ((paramViewGroup instanceof OnlineVideoView))
      {
        paramViewGroup = (OnlineVideoView)paramViewGroup;
        AppMethodBeat.o(269333);
        return paramViewGroup;
      }
    }
    AppMethodBeat.o(269333);
    return null;
  }
  
  private void a(CardLayoutManager paramCardLayoutManager, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(269328);
    Log.d("SnsAd.SlideFullCardVideoPlayHelper", "playInner:: currentPosition is " + paramInt + ", the ready to play is " + this.JKe);
    if (paramCardLayoutManager == null)
    {
      AppMethodBeat.o(269328);
      return;
    }
    SnsInfo localSnsInfo = this.Jws;
    i locali = b(paramCardLayoutManager, paramInt);
    d locald = c(paramCardLayoutManager, paramInt);
    if ((localSnsInfo == null) || (locali == null) || (locald == null) || (locald.JJX == null))
    {
      Log.w("SnsAd.SlideFullCardVideoPlayHelper", "playInner::the resInfo or view holder is null");
      AppMethodBeat.o(269328);
      return;
    }
    paramCardLayoutManager.fMn();
    if (this.JKe)
    {
      if (locali.fJE())
      {
        Log.i("SnsAd.SlideFullCardVideoPlayHelper", "playInner:: currentPosition is " + paramInt + ", the res info is sight");
        a(paramCardLayoutManager, locald.JJX, localSnsInfo, locali.fVT, paramBoolean);
        AppMethodBeat.o(269328);
        return;
      }
      paramCardLayoutManager.fMm();
      if (this.JJk != null)
      {
        this.JJk.dmi();
        AppMethodBeat.o(269328);
      }
    }
    else
    {
      Log.i("SnsAd.SlideFullCardVideoPlayHelper", "playInner::the adSlide item is not able to play video");
    }
    AppMethodBeat.o(269328);
  }
  
  private void a(CardLayoutManager paramCardLayoutManager, ViewGroup paramViewGroup, SnsInfo paramSnsInfo, cvt paramcvt, boolean paramBoolean)
  {
    AppMethodBeat.i(269332);
    com.tencent.mm.plugin.sns.ad.timeline.video.online.e locale = this.JJk;
    if ((locale == null) || (paramCardLayoutManager == null) || (paramViewGroup == null) || (paramSnsInfo == null) || (paramcvt == null))
    {
      Log.e("SnsAd.SlideFullCardVideoPlayHelper", "the input params are invalid!!!!");
      AppMethodBeat.o(269332);
      return;
    }
    com.tencent.mm.plugin.sns.ui.video.d locald = new com.tencent.mm.plugin.sns.ui.video.d();
    locald.fVT = paramcvt;
    locald.fAg = paramSnsInfo.getLocalid();
    locald.fLp = t.Qu(paramSnsInfo.field_snsId);
    locald.createTime = paramSnsInfo.getCreateTime();
    paramSnsInfo = locale.bL(paramViewGroup.getContext(), paramcvt.Id);
    if (paramSnsInfo != null) {
      paramSnsInfo.fhw();
    }
    OnlineVideoView localOnlineVideoView = K(paramViewGroup);
    if (localOnlineVideoView == null)
    {
      Log.d("SnsAd.SlideFullCardVideoPlayHelper", "the videoViewInContainer need new view");
      a(paramSnsInfo, paramCardLayoutManager, paramViewGroup, locald);
      AppMethodBeat.o(269332);
      return;
    }
    if (localOnlineVideoView == paramSnsInfo)
    {
      Log.d("SnsAd.SlideFullCardVideoPlayHelper", "the videoViewInContainer and media id view is same, is time line reason ".concat(String.valueOf(paramBoolean)));
      if (paramBoolean)
      {
        locale.a(localOnlineVideoView, paramcvt.Id);
        AppMethodBeat.o(269332);
        return;
      }
      locale.b(localOnlineVideoView, paramcvt.Id);
      AppMethodBeat.o(269332);
      return;
    }
    l.M(paramViewGroup);
    a(paramSnsInfo, paramCardLayoutManager, paramViewGroup, locald);
    AppMethodBeat.o(269332);
  }
  
  private void a(OnlineVideoView paramOnlineVideoView, CardLayoutManager paramCardLayoutManager, ViewGroup paramViewGroup, com.tencent.mm.plugin.sns.ui.video.d paramd)
  {
    AppMethodBeat.i(269334);
    com.tencent.mm.plugin.sns.ad.timeline.video.online.e locale = this.JJk;
    if ((paramOnlineVideoView != null) && (locale != null))
    {
      paramd.fAg = m.ku(paramd.fAg, paramd.fVT.Id + "_");
      l.gj(paramOnlineVideoView);
      l.v(paramOnlineVideoView, -1, -1);
      l.b(paramViewGroup, paramOnlineVideoView, 0);
      l.w(paramOnlineVideoView, true);
      paramOnlineVideoView.setThumbViewScaleType(ImageView.ScaleType.CENTER_CROP);
      paramOnlineVideoView.setVideoScaleType(i.e.RcH);
      paramOnlineVideoView.setVideoCallback(new a(paramCardLayoutManager, paramOnlineVideoView, paramCardLayoutManager.fMo()));
      locale.a(paramOnlineVideoView, paramd, paramd.fLp, paramd.fVT.Id);
    }
    AppMethodBeat.o(269334);
  }
  
  private static i b(CardLayoutManager paramCardLayoutManager, int paramInt)
  {
    AppMethodBeat.i(269330);
    if (paramCardLayoutManager == null)
    {
      AppMethodBeat.o(269330);
      return null;
    }
    try
    {
      paramCardLayoutManager = paramCardLayoutManager.dlX();
      if ((paramCardLayoutManager instanceof c))
      {
        paramCardLayoutManager = ((c)paramCardLayoutManager).aeZ(paramInt);
        AppMethodBeat.o(269330);
        return paramCardLayoutManager;
      }
    }
    catch (Throwable paramCardLayoutManager)
    {
      Log.d("SnsAd.SlideFullCardVideoPlayHelper", "get adSlide resource information failed!");
      AppMethodBeat.o(269330);
    }
    return null;
  }
  
  private static d c(CardLayoutManager paramCardLayoutManager, int paramInt)
  {
    AppMethodBeat.i(269331);
    if (paramCardLayoutManager == null)
    {
      AppMethodBeat.o(269331);
      return null;
    }
    try
    {
      paramCardLayoutManager = paramCardLayoutManager.afo(paramInt);
      if ((paramCardLayoutManager instanceof d))
      {
        paramCardLayoutManager = (d)paramCardLayoutManager;
        AppMethodBeat.o(269331);
        return paramCardLayoutManager;
      }
    }
    catch (Throwable paramCardLayoutManager)
    {
      AppMethodBeat.o(269331);
    }
    return null;
  }
  
  public final void a(CardLayoutManager paramCardLayoutManager, int paramInt)
  {
    AppMethodBeat.i(269322);
    if (paramInt == 1) {}
    try
    {
      this.JKd = true;
      paramCardLayoutManager.fMn();
      AppMethodBeat.o(269322);
      return;
    }
    catch (Throwable paramCardLayoutManager)
    {
      AppMethodBeat.o(269322);
    }
    this.JKd = false;
    AppMethodBeat.o(269322);
    return;
  }
  
  public final void a(CardLayoutManager paramCardLayoutManager, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(269324);
    Log.d("SnsAd.SlideFullCardVideoPlayHelper", "the onVisibleItemChanged is called , current position is " + paramInt1 + ", the last position " + paramInt2);
    try
    {
      if (this.JJE != null)
      {
        Object localObject = this.JJE;
        if (paramInt1 != ((b)localObject).currentIndex)
        {
          ((b)localObject).currentIndex = paramInt1;
          localObject = ((b)localObject).aeY(paramInt1);
          if (localObject != null) {
            ((b.a)localObject).JGy += 1;
          }
        }
      }
      a(paramCardLayoutManager, paramInt1, false);
      AppMethodBeat.o(269324);
      return;
    }
    catch (Throwable paramCardLayoutManager)
    {
      Log.d("SnsAd.SlideFullCardVideoPlayHelper", "onVisibleItemChanged has something wrong");
      AppMethodBeat.o(269324);
    }
  }
  
  public final void afa(int paramInt)
  {
    AppMethodBeat.i(269326);
    try
    {
      if (this.JJE != null)
      {
        b.a locala = this.JJE.aeY(paramInt);
        if (locala != null) {
          locala.JJK += 1;
        }
      }
      AppMethodBeat.o(269326);
      return;
    }
    catch (Throwable localThrowable)
    {
      AppMethodBeat.o(269326);
    }
  }
  
  public final void b(CardLayoutManager paramCardLayoutManager)
  {
    AppMethodBeat.i(269327);
    Log.i("SnsAd.SlideFullCardVideoPlayHelper", "resumePlayByTimeline is called!");
    this.JKe = true;
    if (paramCardLayoutManager != null) {}
    try
    {
      int i = paramCardLayoutManager.fMo();
      if (i >= 0) {
        a(paramCardLayoutManager, i, true);
      }
      AppMethodBeat.o(269327);
      return;
    }
    catch (Throwable paramCardLayoutManager)
    {
      Log.d("SnsAd.SlideFullCardVideoPlayHelper", "resumePlayByTimeline has something wrong");
      AppMethodBeat.o(269327);
    }
  }
  
  public final void fLB()
  {
    AppMethodBeat.i(269320);
    this.JKe = false;
    Log.d("SnsAd.SlideFullCardVideoPlayHelper", "the time line is paused, ready to play is false");
    com.tencent.mm.plugin.sns.ad.timeline.video.online.e locale = this.JJk;
    if (locale != null) {}
    try
    {
      locale.dmi();
      AppMethodBeat.o(269320);
      return;
    }
    catch (Throwable localThrowable)
    {
      AppMethodBeat.o(269320);
    }
  }
  
  final class a
    implements OnlineVideoView.b
  {
    final CardLayoutManager JJj;
    final OnlineVideoView JKf;
    boolean JKg;
    volatile int uPV;
    
    public a(CardLayoutManager paramCardLayoutManager, OnlineVideoView paramOnlineVideoView, int paramInt)
    {
      AppMethodBeat.i(266781);
      this.JKg = false;
      this.uPV = -1;
      this.JKf = paramOnlineVideoView;
      this.JJj = paramCardLayoutManager;
      this.uPV = Math.max(paramInt, 0);
      AppMethodBeat.o(266781);
    }
    
    public final void AS(int paramInt)
    {
      AppMethodBeat.i(266789);
      try
      {
        if (this.JJj != null)
        {
          int i = this.JJj.fMo();
          if (i != this.uPV)
          {
            Log.d("SnsAd.SlideFullCardVideoPlayHelper", "index = " + i + ", mCurrentIndex = " + this.uPV);
            AppMethodBeat.o(266789);
            return;
          }
          if ((e.this.JJE != null) && (this.JKf != null))
          {
            Object localObject = this.JKf.getTag(i.f.sns_ad_finder_topic_card_item_seek_tag);
            if (((localObject instanceof Integer)) && (((Integer)localObject).intValue() == 1))
            {
              Log.d("SnsAd.SlideFullCardVideoPlayHelper", "the video view has bean seek to 0");
              this.JKf.setTag(i.f.sns_ad_finder_topic_card_item_seek_tag, Integer.valueOf(0));
              this.JKg = false;
              localObject = e.this.JJE.aeY(i);
              if (localObject != null)
              {
                ((b.a)localObject).JJM += ((b.a)localObject).JJP;
                ((b.a)localObject).JJP = 0;
              }
            }
            localObject = e.this.JJE.aeY(i);
            if (localObject != null)
            {
              if (paramInt >= ((b.a)localObject).JJP) {
                ((b.a)localObject).JJP = paramInt;
              }
              if (((b.a)localObject).JJN < paramInt) {
                ((b.a)localObject).JJN = paramInt;
              }
            }
            paramInt /= 1000;
            if ((!this.JKg) && (paramInt > 0))
            {
              this.JKg = true;
              localObject = e.this.JJE.aeY(i);
              if (localObject != null) {
                ((b.a)localObject).FPs += 1;
              }
            }
          }
        }
        AppMethodBeat.o(266789);
        return;
      }
      catch (Throwable localThrowable)
      {
        AppMethodBeat.o(266789);
      }
    }
    
    public final void onCompletion()
    {
      AppMethodBeat.i(266787);
      try
      {
        Log.d("SnsAd.SlideFullCardVideoPlayHelper", "the video is onCompletion");
        this.JKg = false;
        if (this.JJj != null)
        {
          int i = this.JJj.fMo();
          if ((e.this.JJE != null) && (this.JKf != null))
          {
            localObject = e.this.JJE.aeY(i);
            if (localObject != null)
            {
              ((b.a)localObject).JJL += 1;
              ((b.a)localObject).JJM += ((b.a)localObject).JJO;
              ((b.a)localObject).JJP = 0;
            }
            e.this.JJE.jx(i, this.JKf.getDuration());
          }
        }
        Object localObject = e.this;
        CardLayoutManager localCardLayoutManager = this.JJj;
        OnlineVideoView localOnlineVideoView = this.JKf;
        if (((e)localObject).JKd)
        {
          if (localOnlineVideoView != null)
          {
            localOnlineVideoView.bc(0, true);
            AppMethodBeat.o(266787);
          }
        }
        else if (localCardLayoutManager != null) {
          localCardLayoutManager.fMl();
        }
        AppMethodBeat.o(266787);
        return;
      }
      catch (Throwable localThrowable)
      {
        AppMethodBeat.o(266787);
      }
    }
    
    public final void onStart(int paramInt)
    {
      AppMethodBeat.i(266785);
      try
      {
        Log.d("SnsAd.SlideFullCardVideoPlayHelper", "the video is start");
        if (this.JJj != null)
        {
          paramInt = this.JJj.fMo();
          this.uPV = paramInt;
          if ((e.this.JJE != null) && (this.JKf != null)) {
            e.this.JJE.jx(paramInt, this.JKf.getDuration());
          }
        }
        AppMethodBeat.o(266785);
        return;
      }
      catch (Throwable localThrowable)
      {
        AppMethodBeat.o(266785);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.timeline.c.a.e
 * JD-Core Version:    0.7.0.1
 */