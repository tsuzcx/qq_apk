package com.tencent.mm.plugin.sns.ad.timeline.b.c;

import android.view.ViewGroup;
import android.widget.ImageView.ScaleType;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.ad.adxml.g;
import com.tencent.mm.plugin.sns.ad.j.l;
import com.tencent.mm.plugin.sns.ad.widget.recyclerview.CardLayoutManager;
import com.tencent.mm.plugin.sns.ad.widget.recyclerview.CardLayoutManager.c;
import com.tencent.mm.plugin.sns.b.f;
import com.tencent.mm.plugin.sns.data.t;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.plugin.sns.ui.OnlineVideoView;
import com.tencent.mm.plugin.sns.ui.OnlineVideoView.b;
import com.tencent.mm.pluginsdk.ui.i.e;
import com.tencent.mm.protocal.protobuf.dmz;
import com.tencent.mm.sdk.platformtools.Log;

public final class f
  implements CardLayoutManager.c
{
  public SnsInfo PJQ;
  final com.tencent.mm.plugin.sns.ad.timeline.video.online.e QaO;
  a QaT;
  boolean QbH;
  boolean QbI;
  
  public f(com.tencent.mm.plugin.sns.ad.timeline.video.online.e parame, a parama)
  {
    this.QaO = parame;
    this.QaT = parama;
  }
  
  private static OnlineVideoView U(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(311247);
    if (l.X(paramViewGroup))
    {
      paramViewGroup = paramViewGroup.getChildAt(0);
      if ((paramViewGroup instanceof OnlineVideoView))
      {
        paramViewGroup = (OnlineVideoView)paramViewGroup;
        AppMethodBeat.o(311247);
        return paramViewGroup;
      }
    }
    AppMethodBeat.o(311247);
    return null;
  }
  
  private void a(CardLayoutManager paramCardLayoutManager, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(311209);
    Log.d("SnsAd.TopicCardVideoPlayHelper", "playInner:: currentPosition is " + paramInt + ", the ready to play is " + this.QbI);
    if (paramCardLayoutManager == null)
    {
      AppMethodBeat.o(311209);
      return;
    }
    SnsInfo localSnsInfo = this.PJQ;
    g localg = d(paramCardLayoutManager, paramInt);
    e locale = e(paramCardLayoutManager, paramInt);
    if ((localSnsInfo == null) || (localg == null) || (locale == null) || (locale.QbB == null))
    {
      Log.w("SnsAd.TopicCardVideoPlayHelper", "playInner::the resInfo or view holder is null");
      AppMethodBeat.o(311209);
      return;
    }
    paramCardLayoutManager.hdj();
    if (this.QbI)
    {
      if (localg.gZy())
      {
        Log.i("SnsAd.TopicCardVideoPlayHelper", "playInner:: currentPosition is " + paramInt + ", the res info is sight");
        a(paramCardLayoutManager, locale.QbB, localSnsInfo, localg.ibT, paramBoolean);
        AppMethodBeat.o(311209);
        return;
      }
      paramCardLayoutManager.hdi();
      if (this.QaO != null)
      {
        this.QaO.bck();
        AppMethodBeat.o(311209);
      }
    }
    else
    {
      Log.i("SnsAd.TopicCardVideoPlayHelper", "playInner::the topic item is not able to play video");
    }
    AppMethodBeat.o(311209);
  }
  
  private void a(CardLayoutManager paramCardLayoutManager, ViewGroup paramViewGroup, SnsInfo paramSnsInfo, dmz paramdmz, boolean paramBoolean)
  {
    AppMethodBeat.i(311235);
    com.tencent.mm.plugin.sns.ad.timeline.video.online.e locale = this.QaO;
    if ((locale == null) || (paramCardLayoutManager == null) || (paramViewGroup == null) || (paramSnsInfo == null) || (paramdmz == null))
    {
      Log.e("SnsAd.TopicCardVideoPlayHelper", "the input params are invalid!!!!");
      AppMethodBeat.o(311235);
      return;
    }
    com.tencent.mm.plugin.sns.ui.video.d locald = new com.tencent.mm.plugin.sns.ui.video.d();
    locald.ibT = paramdmz;
    locald.hES = paramSnsInfo.getLocalid();
    locald.hQX = t.uA(paramSnsInfo.field_snsId);
    locald.createTime = paramSnsInfo.getCreateTime();
    paramSnsInfo = locale.bO(paramViewGroup.getContext(), paramdmz.Id);
    OnlineVideoView localOnlineVideoView = U(paramViewGroup);
    if (localOnlineVideoView == null)
    {
      Log.d("SnsAd.TopicCardVideoPlayHelper", "the videoViewInContainer need new view");
      a(paramSnsInfo, paramCardLayoutManager, paramViewGroup, locald);
      AppMethodBeat.o(311235);
      return;
    }
    if (localOnlineVideoView == paramSnsInfo)
    {
      Log.d("SnsAd.TopicCardVideoPlayHelper", "the videoViewInContainer and media id view is same, is time line reason ".concat(String.valueOf(paramBoolean)));
      if (paramBoolean)
      {
        locale.a(localOnlineVideoView, paramdmz.Id);
        AppMethodBeat.o(311235);
        return;
      }
      locale.b(localOnlineVideoView, paramdmz.Id);
      AppMethodBeat.o(311235);
      return;
    }
    l.W(paramViewGroup);
    a(paramSnsInfo, paramCardLayoutManager, paramViewGroup, locald);
    AppMethodBeat.o(311235);
  }
  
  private void a(OnlineVideoView paramOnlineVideoView, CardLayoutManager paramCardLayoutManager, ViewGroup paramViewGroup, com.tencent.mm.plugin.sns.ui.video.d paramd)
  {
    AppMethodBeat.i(311256);
    com.tencent.mm.plugin.sns.ad.timeline.video.online.e locale = this.QaO;
    if ((paramOnlineVideoView != null) && (locale != null))
    {
      l.jm(paramOnlineVideoView);
      l.z(paramOnlineVideoView, -1, -1);
      l.b(paramViewGroup, paramOnlineVideoView, 0);
      l.C(paramOnlineVideoView, true);
      paramOnlineVideoView.setThumbViewScaleType(ImageView.ScaleType.CENTER_CROP);
      paramOnlineVideoView.setVideoScaleType(i.e.XYN);
      paramOnlineVideoView.setVideoCallback(new a(paramCardLayoutManager, paramOnlineVideoView));
      locale.a(paramOnlineVideoView, paramd, paramd.hQX, paramd.ibT.Id);
    }
    AppMethodBeat.o(311256);
  }
  
  private static g d(CardLayoutManager paramCardLayoutManager, int paramInt)
  {
    AppMethodBeat.i(311217);
    if (paramCardLayoutManager == null)
    {
      AppMethodBeat.o(311217);
      return null;
    }
    try
    {
      paramCardLayoutManager = paramCardLayoutManager.dSN();
      if ((paramCardLayoutManager instanceof d))
      {
        paramCardLayoutManager = ((d)paramCardLayoutManager).ajN(paramInt);
        AppMethodBeat.o(311217);
        return paramCardLayoutManager;
      }
    }
    finally
    {
      Log.d("SnsAd.TopicCardVideoPlayHelper", "get topic resource information failed!");
      AppMethodBeat.o(311217);
    }
    return null;
  }
  
  private static e e(CardLayoutManager paramCardLayoutManager, int paramInt)
  {
    AppMethodBeat.i(311226);
    if (paramCardLayoutManager == null)
    {
      AppMethodBeat.o(311226);
      return null;
    }
    try
    {
      paramCardLayoutManager = paramCardLayoutManager.aka(paramInt);
      if ((paramCardLayoutManager instanceof e))
      {
        paramCardLayoutManager = (e)paramCardLayoutManager;
        return paramCardLayoutManager;
      }
    }
    finally
    {
      AppMethodBeat.o(311226);
    }
    return null;
  }
  
  public final void a(CardLayoutManager paramCardLayoutManager, int paramInt)
  {
    AppMethodBeat.i(311271);
    if (paramInt == 1) {}
    try
    {
      this.QbH = true;
      paramCardLayoutManager.hdj();
      return;
    }
    finally
    {
      AppMethodBeat.o(311271);
    }
    this.QbH = false;
    AppMethodBeat.o(311271);
    return;
  }
  
  public final void a(CardLayoutManager paramCardLayoutManager, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(311281);
    Log.d("SnsAd.TopicCardVideoPlayHelper", "the onVisibleItemChanged is called , current position is " + paramInt1 + ", the last position " + paramInt2);
    try
    {
      if (this.QaT != null)
      {
        Object localObject = this.QaT;
        if (paramInt1 != ((a)localObject).currentIndex)
        {
          ((a)localObject).currentIndex = paramInt1;
          localObject = ((a)localObject).ajM(paramInt1);
          if (localObject != null) {
            ((a.a)localObject).PXy += 1;
          }
        }
      }
      a(paramCardLayoutManager, paramInt1, false);
      AppMethodBeat.o(311281);
      return;
    }
    finally
    {
      Log.d("SnsAd.TopicCardVideoPlayHelper", "onVisibleItemChanged has something wrong");
      AppMethodBeat.o(311281);
    }
  }
  
  public final void ajJ(int paramInt) {}
  
  public final void b(CardLayoutManager paramCardLayoutManager)
  {
    AppMethodBeat.i(311299);
    Log.i("SnsAd.TopicCardVideoPlayHelper", "resumePlayByTimeline is called!");
    this.QbI = true;
    if (paramCardLayoutManager != null) {}
    try
    {
      int i = paramCardLayoutManager.hdk();
      if (i >= 0) {
        a(paramCardLayoutManager, i, true);
      }
      AppMethodBeat.o(311299);
      return;
    }
    finally
    {
      Log.d("SnsAd.TopicCardVideoPlayHelper", "resumePlayByTimeline has something wrong");
      AppMethodBeat.o(311299);
    }
  }
  
  public final void hbY()
  {
    AppMethodBeat.i(311262);
    this.QbI = false;
    Log.d("SnsAd.TopicCardVideoPlayHelper", "the time line is paused, ready to play is false");
    com.tencent.mm.plugin.sns.ad.timeline.video.online.e locale = this.QaO;
    if (locale != null) {}
    try
    {
      locale.bck();
      return;
    }
    finally
    {
      AppMethodBeat.o(311262);
    }
  }
  
  final class a
    implements OnlineVideoView.b
  {
    final CardLayoutManager QaN;
    final OnlineVideoView QbJ;
    boolean QbK = false;
    
    public a(CardLayoutManager paramCardLayoutManager, OnlineVideoView paramOnlineVideoView)
    {
      this.QbJ = paramOnlineVideoView;
      this.QaN = paramCardLayoutManager;
    }
    
    public final void Bh(int paramInt)
    {
      AppMethodBeat.i(311218);
      paramInt /= 1000;
      try
      {
        if (this.QaN != null)
        {
          int i = this.QaN.hdk();
          if ((f.this.QaT != null) && (this.QbJ != null))
          {
            Object localObject1 = this.QbJ.getTag(b.f.sns_ad_finder_topic_card_item_seek_tag);
            if (((localObject1 instanceof Integer)) && (((Integer)localObject1).intValue() == 1))
            {
              Log.d("SnsAd.TopicCardVideoPlayHelper", "the video view has bean seek to 0");
              this.QbJ.setTag(b.f.sns_ad_finder_topic_card_item_seek_tag, Integer.valueOf(0));
              this.QbK = false;
              localObject1 = f.this.QaT.ajM(i);
              if (localObject1 != null)
              {
                ((a.a)localObject1).Qbq += ((a.a)localObject1).Qbt;
                ((a.a)localObject1).Qbt = 0;
              }
            }
            localObject1 = f.this.QaT;
            int j = paramInt * 1000;
            localObject1 = ((a)localObject1).ajM(i);
            if (localObject1 != null)
            {
              ((a.a)localObject1).Qbt = j;
              if (((a.a)localObject1).Qbr < j) {
                ((a.a)localObject1).Qbr = j;
              }
            }
            if ((!this.QbK) && (paramInt > 0))
            {
              this.QbK = true;
              localObject1 = f.this.QaT.ajM(i);
              if (localObject1 != null) {
                ((a.a)localObject1).LKo += 1;
              }
            }
          }
        }
        return;
      }
      finally
      {
        AppMethodBeat.o(311218);
      }
    }
    
    public final void onCompletion()
    {
      AppMethodBeat.i(311208);
      try
      {
        Log.d("SnsAd.TopicCardVideoPlayHelper", "the video is onCompletion");
        this.QbK = false;
        if (this.QaN != null)
        {
          int i = this.QaN.hdk();
          if ((f.this.QaT != null) && (this.QbJ != null))
          {
            localObject1 = f.this.QaT.ajM(i);
            if (localObject1 != null)
            {
              ((a.a)localObject1).Qbp += 1;
              ((a.a)localObject1).Qbq += ((a.a)localObject1).Qbs;
              ((a.a)localObject1).Qbt = 0;
            }
            f.this.QaT.lg(i, this.QbJ.getDuration());
          }
        }
        Object localObject1 = f.this;
        CardLayoutManager localCardLayoutManager = this.QaN;
        OnlineVideoView localOnlineVideoView = this.QbJ;
        if (((f)localObject1).QbH)
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
        AppMethodBeat.o(311208);
      }
    }
    
    public final void onStart(int paramInt)
    {
      AppMethodBeat.i(311198);
      try
      {
        Log.d("SnsAd.TopicCardVideoPlayHelper", "the video is start");
        if (this.QaN != null)
        {
          paramInt = this.QaN.hdk();
          if ((f.this.QaT != null) && (this.QbJ != null)) {
            f.this.QaT.lg(paramInt, this.QbJ.getDuration());
          }
        }
        return;
      }
      finally
      {
        AppMethodBeat.o(311198);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.timeline.b.c.f
 * JD-Core Version:    0.7.0.1
 */