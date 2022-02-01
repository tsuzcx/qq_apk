package com.tencent.mm.plugin.sns.ad.timeline.b.a;

import android.view.ViewGroup;
import android.widget.ImageView.ScaleType;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.ad.widget.recyclerview.CardLayoutManager;
import com.tencent.mm.plugin.sns.ad.widget.recyclerview.CardLayoutManager.c;
import com.tencent.mm.plugin.sns.b.f;
import com.tencent.mm.plugin.sns.data.m;
import com.tencent.mm.plugin.sns.data.t;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.plugin.sns.ui.OnlineVideoView;
import com.tencent.mm.plugin.sns.ui.OnlineVideoView.b;
import com.tencent.mm.pluginsdk.ui.i.e;
import com.tencent.mm.protocal.protobuf.dmz;
import com.tencent.mm.sdk.platformtools.Log;

public final class e
  implements CardLayoutManager.c
{
  public SnsInfo PJQ;
  final com.tencent.mm.plugin.sns.ad.timeline.video.online.e QaO;
  boolean QbH;
  boolean QbI;
  b Qbi;
  
  public e(com.tencent.mm.plugin.sns.ad.timeline.video.online.e parame, b paramb)
  {
    this.QaO = parame;
    this.Qbi = paramb;
  }
  
  private static OnlineVideoView U(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(311319);
    if (com.tencent.mm.plugin.sns.ad.j.l.X(paramViewGroup))
    {
      paramViewGroup = paramViewGroup.getChildAt(0);
      if ((paramViewGroup instanceof OnlineVideoView))
      {
        paramViewGroup = (OnlineVideoView)paramViewGroup;
        AppMethodBeat.o(311319);
        return paramViewGroup;
      }
    }
    AppMethodBeat.o(311319);
    return null;
  }
  
  private void a(CardLayoutManager paramCardLayoutManager, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(311289);
    Log.d("SnsAd.SlideFullCardVideoPlayHelper", "playInner:: currentPosition is " + paramInt + ", the ready to play is " + this.QbI);
    if (paramCardLayoutManager == null)
    {
      AppMethodBeat.o(311289);
      return;
    }
    SnsInfo localSnsInfo = this.PJQ;
    com.tencent.mm.plugin.sns.ad.adxml.l locall = b(paramCardLayoutManager, paramInt);
    d locald = c(paramCardLayoutManager, paramInt);
    if ((localSnsInfo == null) || (locall == null) || (locald == null) || (locald.QbB == null))
    {
      Log.w("SnsAd.SlideFullCardVideoPlayHelper", "playInner::the resInfo or view holder is null");
      AppMethodBeat.o(311289);
      return;
    }
    paramCardLayoutManager.hdj();
    if (this.QbI)
    {
      if (locall.gZy())
      {
        Log.i("SnsAd.SlideFullCardVideoPlayHelper", "playInner:: currentPosition is " + paramInt + ", the res info is sight");
        a(paramCardLayoutManager, locald.QbB, localSnsInfo, locall.ibT, paramBoolean);
        AppMethodBeat.o(311289);
        return;
      }
      paramCardLayoutManager.hdi();
      if (this.QaO != null)
      {
        this.QaO.bck();
        AppMethodBeat.o(311289);
      }
    }
    else
    {
      Log.i("SnsAd.SlideFullCardVideoPlayHelper", "playInner::the adSlide item is not able to play video");
    }
    AppMethodBeat.o(311289);
  }
  
  private void a(CardLayoutManager paramCardLayoutManager, ViewGroup paramViewGroup, SnsInfo paramSnsInfo, dmz paramdmz, boolean paramBoolean)
  {
    AppMethodBeat.i(311314);
    com.tencent.mm.plugin.sns.ad.timeline.video.online.e locale = this.QaO;
    if ((locale == null) || (paramCardLayoutManager == null) || (paramViewGroup == null) || (paramSnsInfo == null) || (paramdmz == null))
    {
      Log.e("SnsAd.SlideFullCardVideoPlayHelper", "the input params are invalid!!!!");
      AppMethodBeat.o(311314);
      return;
    }
    com.tencent.mm.plugin.sns.ui.video.d locald = new com.tencent.mm.plugin.sns.ui.video.d();
    locald.ibT = paramdmz;
    locald.hES = paramSnsInfo.getLocalid();
    locald.hQX = t.uA(paramSnsInfo.field_snsId);
    locald.createTime = paramSnsInfo.getCreateTime();
    paramSnsInfo = locale.bO(paramViewGroup.getContext(), paramdmz.Id);
    if (paramSnsInfo != null) {
      paramSnsInfo.grj();
    }
    OnlineVideoView localOnlineVideoView = U(paramViewGroup);
    if (localOnlineVideoView == null)
    {
      Log.d("SnsAd.SlideFullCardVideoPlayHelper", "the videoViewInContainer need new view");
      a(paramSnsInfo, paramCardLayoutManager, paramViewGroup, locald);
      AppMethodBeat.o(311314);
      return;
    }
    if (localOnlineVideoView == paramSnsInfo)
    {
      Log.d("SnsAd.SlideFullCardVideoPlayHelper", "the videoViewInContainer and media id view is same, is time line reason ".concat(String.valueOf(paramBoolean)));
      if (paramBoolean)
      {
        locale.a(localOnlineVideoView, paramdmz.Id);
        AppMethodBeat.o(311314);
        return;
      }
      locale.b(localOnlineVideoView, paramdmz.Id);
      AppMethodBeat.o(311314);
      return;
    }
    com.tencent.mm.plugin.sns.ad.j.l.W(paramViewGroup);
    a(paramSnsInfo, paramCardLayoutManager, paramViewGroup, locald);
    AppMethodBeat.o(311314);
  }
  
  private void a(OnlineVideoView paramOnlineVideoView, CardLayoutManager paramCardLayoutManager, ViewGroup paramViewGroup, com.tencent.mm.plugin.sns.ui.video.d paramd)
  {
    AppMethodBeat.i(311328);
    com.tencent.mm.plugin.sns.ad.timeline.video.online.e locale = this.QaO;
    if ((paramOnlineVideoView != null) && (locale != null))
    {
      paramd.hES = m.lW(paramd.hES, paramd.ibT.Id + "_");
      com.tencent.mm.plugin.sns.ad.j.l.jm(paramOnlineVideoView);
      com.tencent.mm.plugin.sns.ad.j.l.z(paramOnlineVideoView, -1, -1);
      com.tencent.mm.plugin.sns.ad.j.l.b(paramViewGroup, paramOnlineVideoView, 0);
      com.tencent.mm.plugin.sns.ad.j.l.C(paramOnlineVideoView, true);
      paramOnlineVideoView.setThumbViewScaleType(ImageView.ScaleType.CENTER_CROP);
      paramOnlineVideoView.setVideoScaleType(i.e.XYN);
      paramOnlineVideoView.setVideoCallback(new a(paramCardLayoutManager, paramOnlineVideoView, paramCardLayoutManager.hdk()));
      locale.a(paramOnlineVideoView, paramd, paramd.hQX, paramd.ibT.Id);
    }
    AppMethodBeat.o(311328);
  }
  
  private static com.tencent.mm.plugin.sns.ad.adxml.l b(CardLayoutManager paramCardLayoutManager, int paramInt)
  {
    AppMethodBeat.i(311293);
    if (paramCardLayoutManager == null)
    {
      AppMethodBeat.o(311293);
      return null;
    }
    try
    {
      paramCardLayoutManager = paramCardLayoutManager.dSN();
      if ((paramCardLayoutManager instanceof c))
      {
        paramCardLayoutManager = ((c)paramCardLayoutManager).ajI(paramInt);
        AppMethodBeat.o(311293);
        return paramCardLayoutManager;
      }
    }
    finally
    {
      Log.d("SnsAd.SlideFullCardVideoPlayHelper", "get adSlide resource information failed!");
      AppMethodBeat.o(311293);
    }
    return null;
  }
  
  private static d c(CardLayoutManager paramCardLayoutManager, int paramInt)
  {
    AppMethodBeat.i(311305);
    if (paramCardLayoutManager == null)
    {
      AppMethodBeat.o(311305);
      return null;
    }
    try
    {
      paramCardLayoutManager = paramCardLayoutManager.aka(paramInt);
      if ((paramCardLayoutManager instanceof d))
      {
        paramCardLayoutManager = (d)paramCardLayoutManager;
        return paramCardLayoutManager;
      }
    }
    finally
    {
      AppMethodBeat.o(311305);
    }
    return null;
  }
  
  public final void a(CardLayoutManager paramCardLayoutManager, int paramInt)
  {
    AppMethodBeat.i(311346);
    if (paramInt == 1) {}
    try
    {
      this.QbH = true;
      paramCardLayoutManager.hdj();
      return;
    }
    finally
    {
      AppMethodBeat.o(311346);
    }
    this.QbH = false;
    AppMethodBeat.o(311346);
    return;
  }
  
  public final void a(CardLayoutManager paramCardLayoutManager, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(311353);
    Log.d("SnsAd.SlideFullCardVideoPlayHelper", "the onVisibleItemChanged is called , current position is " + paramInt1 + ", the last position " + paramInt2);
    try
    {
      if (this.Qbi != null)
      {
        Object localObject = this.Qbi;
        if (paramInt1 != ((b)localObject).currentIndex)
        {
          ((b)localObject).currentIndex = paramInt1;
          localObject = ((b)localObject).ajH(paramInt1);
          if (localObject != null) {
            ((b.a)localObject).PXy += 1;
          }
        }
      }
      a(paramCardLayoutManager, paramInt1, false);
      AppMethodBeat.o(311353);
      return;
    }
    finally
    {
      Log.d("SnsAd.SlideFullCardVideoPlayHelper", "onVisibleItemChanged has something wrong");
      AppMethodBeat.o(311353);
    }
  }
  
  public final void ajJ(int paramInt)
  {
    AppMethodBeat.i(311360);
    try
    {
      if (this.Qbi != null)
      {
        b.a locala = this.Qbi.ajH(paramInt);
        if (locala != null) {
          locala.Qbo += 1;
        }
      }
      return;
    }
    finally
    {
      AppMethodBeat.o(311360);
    }
  }
  
  public final void b(CardLayoutManager paramCardLayoutManager)
  {
    AppMethodBeat.i(311370);
    Log.i("SnsAd.SlideFullCardVideoPlayHelper", "resumePlayByTimeline is called!");
    this.QbI = true;
    if (paramCardLayoutManager != null) {}
    try
    {
      int i = paramCardLayoutManager.hdk();
      if (i >= 0) {
        a(paramCardLayoutManager, i, true);
      }
      AppMethodBeat.o(311370);
      return;
    }
    finally
    {
      Log.d("SnsAd.SlideFullCardVideoPlayHelper", "resumePlayByTimeline has something wrong");
      AppMethodBeat.o(311370);
    }
  }
  
  public final void hbY()
  {
    AppMethodBeat.i(311337);
    this.QbI = false;
    Log.d("SnsAd.SlideFullCardVideoPlayHelper", "the time line is paused, ready to play is false");
    com.tencent.mm.plugin.sns.ad.timeline.video.online.e locale = this.QaO;
    if (locale != null) {}
    try
    {
      locale.bck();
      return;
    }
    finally
    {
      AppMethodBeat.o(311337);
    }
  }
  
  final class a
    implements OnlineVideoView.b
  {
    final CardLayoutManager QaN;
    final OnlineVideoView QbJ;
    boolean QbK;
    volatile int xYG;
    
    public a(CardLayoutManager paramCardLayoutManager, OnlineVideoView paramOnlineVideoView, int paramInt)
    {
      AppMethodBeat.i(311290);
      this.QbK = false;
      this.xYG = -1;
      this.QbJ = paramOnlineVideoView;
      this.QaN = paramCardLayoutManager;
      this.xYG = Math.max(paramInt, 0);
      AppMethodBeat.o(311290);
    }
    
    public final void Bh(int paramInt)
    {
      AppMethodBeat.i(311316);
      try
      {
        if (this.QaN != null)
        {
          int i = this.QaN.hdk();
          if (i != this.xYG)
          {
            Log.d("SnsAd.SlideFullCardVideoPlayHelper", "index = " + i + ", mCurrentIndex = " + this.xYG);
            return;
          }
          if ((e.this.Qbi != null) && (this.QbJ != null))
          {
            Object localObject1 = this.QbJ.getTag(b.f.sns_ad_finder_topic_card_item_seek_tag);
            if (((localObject1 instanceof Integer)) && (((Integer)localObject1).intValue() == 1))
            {
              Log.d("SnsAd.SlideFullCardVideoPlayHelper", "the video view has bean seek to 0");
              this.QbJ.setTag(b.f.sns_ad_finder_topic_card_item_seek_tag, Integer.valueOf(0));
              this.QbK = false;
              localObject1 = e.this.Qbi.ajH(i);
              if (localObject1 != null)
              {
                ((b.a)localObject1).Qbq += ((b.a)localObject1).Qbt;
                ((b.a)localObject1).Qbt = 0;
              }
            }
            localObject1 = e.this.Qbi.ajH(i);
            if (localObject1 != null)
            {
              if (paramInt >= ((b.a)localObject1).Qbt) {
                ((b.a)localObject1).Qbt = paramInt;
              }
              if (((b.a)localObject1).Qbr < paramInt) {
                ((b.a)localObject1).Qbr = paramInt;
              }
            }
            paramInt /= 1000;
            if ((!this.QbK) && (paramInt > 0))
            {
              this.QbK = true;
              localObject1 = e.this.Qbi.ajH(i);
              if (localObject1 != null) {
                ((b.a)localObject1).LKo += 1;
              }
            }
          }
        }
        return;
      }
      finally
      {
        AppMethodBeat.o(311316);
      }
    }
    
    public final void onCompletion()
    {
      AppMethodBeat.i(311307);
      try
      {
        Log.d("SnsAd.SlideFullCardVideoPlayHelper", "the video is onCompletion");
        this.QbK = false;
        if (this.QaN != null)
        {
          int i = this.QaN.hdk();
          if ((e.this.Qbi != null) && (this.QbJ != null))
          {
            localObject1 = e.this.Qbi.ajH(i);
            if (localObject1 != null)
            {
              ((b.a)localObject1).Qbp += 1;
              ((b.a)localObject1).Qbq += ((b.a)localObject1).Qbs;
              ((b.a)localObject1).Qbt = 0;
            }
            e.this.Qbi.lg(i, this.QbJ.getDuration());
          }
        }
        Object localObject1 = e.this;
        CardLayoutManager localCardLayoutManager = this.QaN;
        OnlineVideoView localOnlineVideoView = this.QbJ;
        if (((e)localObject1).QbH)
        {
          if (localOnlineVideoView != null) {
            localOnlineVideoView.bJ(0, true);
          }
        }
        else if (localCardLayoutManager != null) {
          localCardLayoutManager.hdh();
        }
        return;
      }
      finally
      {
        AppMethodBeat.o(311307);
      }
    }
    
    public final void onStart(int paramInt)
    {
      AppMethodBeat.i(311295);
      try
      {
        Log.d("SnsAd.SlideFullCardVideoPlayHelper", "the video is start");
        if (this.QaN != null)
        {
          paramInt = this.QaN.hdk();
          this.xYG = paramInt;
          if ((e.this.Qbi != null) && (this.QbJ != null)) {
            e.this.Qbi.lg(paramInt, this.QbJ.getDuration());
          }
        }
        return;
      }
      finally
      {
        AppMethodBeat.o(311295);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.timeline.b.a.e
 * JD-Core Version:    0.7.0.1
 */