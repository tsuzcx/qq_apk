package com.tencent.mm.plugin.sns.ui.item;

import android.app.Activity;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Handler;
import android.os.Looper;
import android.view.Display;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewStub;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.ad.timeline.c.b.a.b;
import com.tencent.mm.plugin.sns.ad.timeline.c.b.a.c;
import com.tencent.mm.plugin.sns.data.t;
import com.tencent.mm.plugin.sns.i.d;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.i.g;
import com.tencent.mm.plugin.sns.i.i;
import com.tencent.mm.plugin.sns.i.j;
import com.tencent.mm.plugin.sns.model.aj;
import com.tencent.mm.plugin.sns.model.g;
import com.tencent.mm.plugin.sns.storage.ADXml;
import com.tencent.mm.plugin.sns.storage.ADXml.g;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.plugin.sns.ui.MaskImageView;
import com.tencent.mm.plugin.sns.ui.av;
import com.tencent.mm.plugin.sns.ui.ay;
import com.tencent.mm.plugin.sns.ui.bm;
import com.tencent.mm.plugin.sns.ui.bn;
import com.tencent.mm.plugin.sns.ui.d.c;
import com.tencent.mm.plugin.sns.ui.video.SnsTimelineVideoView;
import com.tencent.mm.plugin.sns.ui.video.e;
import com.tencent.mm.plugin.sns.ui.widget.SnsAdCardVideoEndView;
import com.tencent.mm.plugin.sns.ui.widget.SnsAdTimelineVideoView;
import com.tencent.mm.plugin.thumbplayer.view.ThumbPlayerVideoView;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.adw;
import com.tencent.mm.protocal.protobuf.cvt;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.widget.MMPinProgressBtn;
import java.util.LinkedList;

public class h
  extends BaseTimeLineItem
  implements com.tencent.mm.plugin.sns.ui.video.a
{
  private ADXml.g JKj;
  private Handler JMp;
  public SnsInfo Jws;
  private View.OnClickListener LjD;
  protected com.tencent.mm.plugin.sns.ad.timeline.c.b.a LjN;
  protected a.c LjP;
  public a Lna;
  protected volatile boolean Lnb;
  private boolean Lnc;
  protected int Lnd;
  boolean Lne;
  
  public h()
  {
    AppMethodBeat.i(225772);
    this.JMp = new Handler(Looper.getMainLooper());
    this.Lnb = false;
    this.Lnc = false;
    this.LjN = new com.tencent.mm.plugin.sns.ad.timeline.c.b.a();
    this.LjD = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(207538);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/sns/ui/item/FullCardAdTimeLineItemNew$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        Log.i("MicroMsg.FullCardAdTimeLineItemNew", "ProxyCardClickListener onClick");
        try
        {
          h.this.Kee.Kdz.LpB.onClick(paramAnonymousView);
          if (h.a(h.this)) {
            SnsAdCardVideoEndView.j(h.this.Jws, 1);
          }
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/item/FullCardAdTimeLineItemNew$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(207538);
          return;
        }
        catch (Exception paramAnonymousView)
        {
          for (;;)
          {
            Log.e("MicroMsg.FullCardAdTimeLineItemNew", "ProxyCardClickListener onClick, exp=" + paramAnonymousView.toString());
          }
        }
      }
    };
    this.Lne = false;
    this.LjP = new a.c()
    {
      public final void aV(int paramAnonymousInt, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(268705);
        Log.i("MicroMsg.FullCardAdTimeLineItemNew", "onStart, isOnlineVideoView=" + paramAnonymousBoolean + ", duration=" + paramAnonymousInt + ", hash=" + h.this.hashCode());
        AppMethodBeat.o(268705);
      }
      
      public final void aW(int paramAnonymousInt, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(268707);
        if (paramAnonymousBoolean) {}
        for (int i = h.this.Lna.Lnh.JKM.getDuration() / 1000;; i = h.this.Lna.Lnh.JKG.KKl.getDurationMs() / 1000)
        {
          h.a(h.this, h.this.Jws.field_snsId, h.d(h.this), h.this.Jws, paramAnonymousInt, i, paramAnonymousBoolean);
          AppMethodBeat.o(268707);
          return;
        }
      }
      
      public final void fLF()
      {
        AppMethodBeat.i(268704);
        h.c(h.this);
        AppMethodBeat.o(268704);
      }
      
      public final void yr(boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(268706);
        Log.i("MicroMsg.FullCardAdTimeLineItemNew", "onCompletion, isOnlineVideoView=" + paramAnonymousBoolean + ", hash=" + h.this.hashCode());
        if (h.this.b(h.d(h.this))) {
          h.this.LjN.yq(paramAnonymousBoolean);
        }
        h localh = h.this;
        bm localbm = h.this.Kee;
        long l = h.this.Jws.field_snsId;
        ADXml.g localg = h.d(h.this);
        Log.i("MicroMsg.FullCardAdTimeLineItemNew", "doOnVideoCompletion, ret=0");
        if ((localbm == null) || (localbm.KYo == null) || (localbm.KYo.KBN == null))
        {
          AppMethodBeat.o(268706);
          return;
        }
        localbm.KYo.KBN.I(l, false);
        MMHandlerThread.postToMainThread(new h.5(localh, localg));
        AppMethodBeat.o(268706);
      }
    };
    AppMethodBeat.o(225772);
  }
  
  private void ac(SnsInfo paramSnsInfo)
  {
    AppMethodBeat.i(225838);
    if ((this.Kee != null) && (this.Kee.KYo != null) && (this.Kee.KYo.KBN != null) && (paramSnsInfo != null)) {
      this.Kee.KYo.KBN.Qn(paramSnsInfo.field_snsId);
    }
    AppMethodBeat.o(225838);
  }
  
  private void fLF()
  {
    AppMethodBeat.i(225825);
    Log.d("MicroMsg.FullCardAdTimeLineItemNew", "try show play btn");
    if ((this.Lna != null) && (this.Lna.Lnh.JKG != null) && (!this.Lnb))
    {
      Log.d("MicroMsg.FullCardAdTimeLineItemNew", "show play btn");
      this.Lna.Lnh.JKG.JAL.setVisibility(0);
      this.Lna.Lnh.JKG.KKn.setVisibility(8);
      this.Lna.Lnh.JKG.JAL.setImageDrawable(com.tencent.mm.ci.a.m(this.mActivity, i.i.shortvideo_play_btn));
      this.Lna.Lnh.JKG.JAL.setContentDescription(this.mActivity.getString(i.j.play_sight_desc));
    }
    AppMethodBeat.o(225825);
  }
  
  private boolean fYA()
  {
    AppMethodBeat.i(225816);
    if ((this.Lna.timeLineObject.ContentObj.Sqq == 5) || (this.Lna.timeLineObject.ContentObj.Sqq == 15))
    {
      Log.i("MicroMsg.FullCardAdTimeLineItemNew", "doPause, hash=" + hashCode());
      if ((this.Lna != null) && (this.Lna.Lnh.JKG != null))
      {
        this.LjN.yp(this.Lna.Ljs);
        ac(this.Jws);
        onVideoPause();
      }
      this.Lnb = false;
      AppMethodBeat.o(225816);
      return true;
    }
    AppMethodBeat.o(225816);
    return false;
  }
  
  protected void a(long paramLong1, ADXml.g paramg, SnsInfo paramSnsInfo, long paramLong2, int paramInt)
  {
    AppMethodBeat.i(225842);
    f.a(paramg, (int)paramLong2, this.Lna.Lnh.JKA, this.Lna.Lnh.JKB);
    AppMethodBeat.o(225842);
  }
  
  public final void a(ViewStub paramViewStub, BaseTimeLineItem.BaseViewHolder paramBaseViewHolder)
  {
    AppMethodBeat.i(225788);
    long l1 = System.currentTimeMillis();
    this.Lna = ((a)paramBaseViewHolder);
    Object localObject = null;
    if (paramBaseViewHolder.LkR != null)
    {
      paramBaseViewHolder.LkR.setLayoutResource(i.g.sns_timeline_ad_full_card_new);
      if (!paramBaseViewHolder.LkS)
      {
        localObject = paramBaseViewHolder.LkR.inflate();
        paramBaseViewHolder.LkS = true;
      }
    }
    for (;;)
    {
      this.Lna.Lnh = com.tencent.mm.plugin.sns.ad.timeline.c.b.a.gg(this.Lna.convertView);
      this.Lna.Lnh.xYJ = ((View)localObject);
      this.Lna.Lnh.JKO.scene = 0;
      this.Lna.JKG = this.Lna.Lnh.JKG;
      localObject = (WindowManager)this.mActivity.getSystemService("window");
      this.Lnd = (Math.min(((WindowManager)localObject).getDefaultDisplay().getWidth(), ((WindowManager)localObject).getDefaultDisplay().getHeight()) - com.tencent.mm.ci.a.fromDPToPix(this.mActivity, 56) - this.mActivity.getResources().getDimensionPixelSize(i.d.LittlePadding) - this.mActivity.getResources().getDimensionPixelSize(i.d.NormalPadding));
      this.LjN.JKn = this.LjP;
      b(paramViewStub, paramBaseViewHolder);
      long l2 = System.currentTimeMillis();
      com.tencent.e.h.ZvG.be(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(260384);
          com.tencent.mm.plugin.sns.data.l.a(com.tencent.mm.plugin.sns.data.l.JQW, "1", 1, 1, String.valueOf(this.CGc));
          com.tencent.mm.plugin.report.service.h.IzE.el(1697, 2);
          AppMethodBeat.o(260384);
        }
      });
      AppMethodBeat.o(225788);
      return;
      if (!paramBaseViewHolder.LkS)
      {
        localObject = paramBaseViewHolder.convertView.findViewById(i.f.full_card_container);
        paramBaseViewHolder.LkS = true;
      }
    }
  }
  
  public final void a(ADXml.g paramg)
  {
    AppMethodBeat.i(225837);
    for (;;)
    {
      try
      {
        if (this.Lna.Lnh.JKC == null)
        {
          Log.i("MicroMsg.FullCardAdTimeLineItemNew", "checkShowEndView, videoEndView==null");
          AppMethodBeat.o(225837);
          return;
        }
        if ((paramg == null) || (paramg.KjP == null) || (!this.Lnb)) {
          break;
        }
        if (this.Lna.Ljs)
        {
          this.Lna.Lnh.JKC.setBlurBkg(this.Lna.Lnh.JKM.getInnerVideoView());
          this.Lna.Lnh.JKC.bzz();
          this.Lna.Lnh.JKC.equ();
          this.Lnc = true;
          if (this.Lna.Ljs) {
            break label258;
          }
          this.Lna.JKG.KKl.bc(0, false);
          this.LjN.yp(this.Lna.Ljs);
          fYB();
          this.JMp.postDelayed(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(197642);
              if ((h.this.mActivity != null) && (!h.this.mActivity.isFinishing()))
              {
                h.b(h.this);
                if (h.this.Lnb)
                {
                  h.this.Lna.Lnh.JKC.fv(true);
                  h.this.LjN.yq(h.this.Lna.Ljs);
                  AppMethodBeat.o(197642);
                }
              }
              else
              {
                Log.e("MicroMsg.FullCardAdTimeLineItemNew", "onCompletion, postDelayed-run activity isFinished");
              }
              AppMethodBeat.o(197642);
            }
          }, paramg.KjP.duration);
          AppMethodBeat.o(225837);
          return;
        }
      }
      catch (Exception paramg)
      {
        Log.e("MicroMsg.FullCardAdTimeLineItemNew", "handleVideoCompletion, exp" + paramg.toString());
        AppMethodBeat.o(225837);
        return;
      }
      this.Lna.Lnh.JKC.setBlurBkg(this.Lna.Lnh.JKG.KKl.getInnerVideoView());
      continue;
      label258:
      if ((this.Lna.Lnh.JKM.getInnerVideoView() instanceof ThumbPlayerVideoView))
      {
        this.Lna.Lnh.JKM.bc(0, false);
        this.Lna.Lnh.JKM.dmi();
      }
    }
    this.Lna.Lnh.JKC.fv(false);
    AppMethodBeat.o(225837);
  }
  
  public final void a(BaseTimeLineItem.BaseViewHolder paramBaseViewHolder, int paramInt)
  {
    AppMethodBeat.i(225809);
    if ((paramBaseViewHolder.timeLineObject.ContentObj.Sqq == 5) || (paramBaseViewHolder.timeLineObject.ContentObj.Sqq == 15))
    {
      Log.i("MicroMsg.FullCardAdTimeLineItemNew", "play: hash=" + hashCode() + ", pos=" + paramInt + ", isEndViewShow=" + this.Lnc + ", isPlayingSight=" + this.Lnb);
      e.fZg().dmi();
      com.tencent.mm.plugin.sns.ui.video.b.fYX().a(this);
      if ((!this.Lnc) && ((paramBaseViewHolder instanceof a)))
      {
        a locala = (a)paramBaseViewHolder;
        this.LjN.yd(locala.Ljs);
      }
      Log.d("MicroMsg.FullCardAdTimeLineItemNew", "try hide play btn");
      if ((this.Lna != null) && (this.Lna.Lnh.JKG != null))
      {
        Log.d("MicroMsg.FullCardAdTimeLineItemNew", "hide play btn");
        this.Lna.Lnh.JKG.JAL.setVisibility(8);
        this.Lna.Lnh.JKG.KKn.setVisibility(8);
      }
      this.Lnb = true;
      if ((paramBaseViewHolder instanceof a)) {
        ((a)paramBaseViewHolder).Lnh.JKO.JKq = false;
      }
      if ((!this.Lnc) && (this.Lna.Lnh.JKC != null) && (this.Lna.Lnh.JKC.getVisibility() == 0)) {
        this.Lna.Lnh.JKC.fv(true);
      }
    }
    AppMethodBeat.o(225809);
  }
  
  public final void a(BaseTimeLineItem.BaseViewHolder paramBaseViewHolder, int paramInt1, bn parambn, TimeLineObject paramTimeLineObject, int paramInt2, bm parambm)
  {
    AppMethodBeat.i(225801);
    long l1 = System.currentTimeMillis();
    Log.i("MicroMsg.FullCardAdTimeLineItemNew", "ad fillItem, fullCardAd, pos=" + paramInt1 + ", snsId=" + paramTimeLineObject.Id + ", hash=" + hashCode());
    if (paramBaseViewHolder.jTm)
    {
      Log.i("MicroMsg.FullCardAdTimeLineItemNew", "holder is busy");
      AppMethodBeat.o(225801);
      return;
    }
    SnsInfo localSnsInfo = parambn.Jws;
    this.Jws = localSnsInfo;
    if (this.Jws == null) {}
    final a locala;
    Object localObject;
    for (String str = "";; str = t.Qu(this.Jws.field_snsId))
    {
      locala = null;
      this.JKj = null;
      localObject = locala;
      if (localSnsInfo != null)
      {
        localObject = locala;
        if (localSnsInfo.getAdXml() != null)
        {
          localObject = localSnsInfo.getAdXml();
          this.JKj = ((ADXml)localObject).adFullCardInfo;
        }
      }
      locala = (a)paramBaseViewHolder;
      locala.Ljs = d((ADXml)localObject);
      Log.i("MicroMsg.FullCardAdTimeLineItemNew", "ad fillItem, useOnlineVideo=" + locala.Ljs);
      this.LjN.a(locala.Lnh, this.JKj, localSnsInfo, paramTimeLineObject, this.mActivity, parambm.KYo.KBN);
      localObject = locala.Lnh;
      ((a.b)localObject).JKG.KKl.setVideoCallback(null);
      if (((a.b)localObject).JKM != null) {
        ((a.b)localObject).JKM.setVideoCallback(null);
      }
      if (this.JKj == null) {
        break;
      }
      parambm = this.LjN.afb(this.Lnd);
      if (((a.b)localObject).JKC != null)
      {
        ((a.b)localObject).JKC.a(this.JKj.KjP, 1);
        if ((localSnsInfo != null) && (((a.b)localObject).JKC.ad(localSnsInfo)))
        {
          this.JMp.removeCallbacksAndMessages(null);
          this.Lnc = false;
        }
      }
      a(paramBaseViewHolder, paramInt1, paramTimeLineObject, this.JKj, parambm);
      parambm = aj.fOF();
      if ((((a.b)localObject).JKG.KKi != null) && (!Util.isEqual(((a.b)localObject).JKG.KKi.Id, paramTimeLineObject.Id)))
      {
        Log.i("MicroMsg.FullCardAdTimeLineItemNew", "need clear sightView %s", new Object[] { ((a.b)localObject).JKG.KKi.Id });
        if (!locala.Ljs) {
          parambm.a(((a.b)localObject).JKG.KKl, this.mActivity.hashCode());
        }
      }
      ((a.b)localObject).JKG.a(paramTimeLineObject, paramInt1, parambn.KDB, parambn.KBz);
      ((a.b)localObject).JKG.Ktc.setVisibility(8);
      if ((paramTimeLineObject.ContentObj == null) || (paramTimeLineObject.ContentObj.Sqr.size() <= 0)) {
        break label682;
      }
      parambn = (cvt)paramTimeLineObject.ContentObj.Sqr.get(0);
      label514:
      if (parambn == null) {
        break label763;
      }
      this.LjN.a(parambn, parambm, paramInt1, locala.Ljs);
      if (paramTimeLineObject.ContentObj.Sqq != 1) {
        break label687;
      }
      ((a.b)localObject).JKs.setTag(paramBaseViewHolder);
      ((a.b)localObject).JKs.setOnClickListener(this.LjD);
      label567:
      long l2 = System.currentTimeMillis();
      com.tencent.e.h.ZvG.be(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(246711);
          String str = com.tencent.mm.plugin.sns.data.l.JQW;
          if (locala.Ljs) {}
          for (int i = 1;; i = 2)
          {
            com.tencent.mm.plugin.sns.data.l.a(str, "1", i, 2, String.valueOf(this.CGc));
            AppMethodBeat.o(246711);
            return;
          }
        }
      });
      AppMethodBeat.o(225801);
      return;
    }
    paramInt2 = 0;
    if (localSnsInfo != null) {
      if (localSnsInfo.isFullCardAd()) {
        paramInt2 = 1;
      }
    }
    label637:
    for (parambm = localSnsInfo.getUxinfo();; parambm = "")
    {
      Log.e("MicroMsg.FullCardAdTimeLineItemNew", "invalid full card info, snsId=".concat(String.valueOf(str)));
      com.tencent.mm.plugin.sns.data.l.a(com.tencent.mm.plugin.sns.data.l.JQG, str, 1, paramInt2, parambm);
      break;
      paramInt2 = 0;
      break label637;
      parambn = null;
      break label514;
      if ((paramTimeLineObject.ContentObj.Sqq != 15) && (paramTimeLineObject.ContentObj.Sqq != 5)) {
        break label567;
      }
      ((a.b)localObject).JKG.KKj.setTag(paramBaseViewHolder);
      ((a.b)localObject).JKL.setTag(paramBaseViewHolder);
      ((a.b)localObject).JKG.KKj.setOnClickListener(this.LjD);
      ((a.b)localObject).JKL.setOnClickListener(this.LjD);
      break label567;
      if (locala.Ljs) {
        if (((a.b)localObject).JKM != null) {
          ((a.b)localObject).JKM.setVideoCallback(null);
        }
      }
      for (;;)
      {
        ((a.b)localObject).JKG.KKo.setVisibility(8);
        Log.e("MicroMsg.FullCardAdTimeLineItemNew", "invalid full card media, snsId=".concat(String.valueOf(str)));
        break;
        parambm.a(((a.b)localObject).JKG.KKl, this.mActivity.hashCode());
        ((a.b)localObject).JKG.KKl.setVideoCallback(null);
      }
    }
  }
  
  protected void a(BaseTimeLineItem.BaseViewHolder paramBaseViewHolder, int paramInt, TimeLineObject paramTimeLineObject, ADXml.g paramg, ViewGroup.LayoutParams paramLayoutParams) {}
  
  protected void b(ViewStub paramViewStub, BaseTimeLineItem.BaseViewHolder paramBaseViewHolder) {}
  
  protected boolean b(ADXml.g paramg)
  {
    return (this.Lnb) && (paramg != null) && (paramg.KjP == null);
  }
  
  public boolean d(ADXml paramADXml)
  {
    AppMethodBeat.i(225847);
    boolean bool = com.tencent.mm.plugin.sns.ad.timeline.c.b.a.d(paramADXml);
    if (!this.Lne)
    {
      this.Lne = true;
      paramADXml = com.tencent.mm.plugin.report.service.h.IzE;
      if (!bool) {
        break label49;
      }
    }
    label49:
    for (int i = 4;; i = 3)
    {
      paramADXml.el(1697, i);
      AppMethodBeat.o(225847);
      return bool;
    }
  }
  
  protected void fYB() {}
  
  public final Rect getDisplayRect()
  {
    AppMethodBeat.i(225822);
    if ((this.Lna != null) && (this.Lna.Lnh.xYJ != null))
    {
      Object localObject = new int[2];
      this.Lna.Lnh.xYJ.getLocationOnScreen((int[])localObject);
      int i = localObject[0];
      int j = localObject[1];
      localObject = new Rect(i, j, this.Lna.Lnh.xYJ.getMeasuredWidth() + i, this.Lna.Lnh.xYJ.getMeasuredHeight() + j);
      AppMethodBeat.o(225822);
      return localObject;
    }
    AppMethodBeat.o(225822);
    return null;
  }
  
  protected void onUIDestroy() {}
  
  public final void onUIPause()
  {
    AppMethodBeat.i(225813);
    Log.i("MicroMsg.FullCardAdTimeLineItemNew", "onUIPause");
    fYA();
    AppMethodBeat.o(225813);
  }
  
  protected void onVideoPause() {}
  
  public final void pause()
  {
    AppMethodBeat.i(225812);
    Log.i("MicroMsg.FullCardAdTimeLineItemNew", "pause");
    if (fYA()) {
      fLF();
    }
    AppMethodBeat.o(225812);
  }
  
  public final void stop()
  {
    AppMethodBeat.i(225819);
    Log.i("MicroMsg.FullCardAdTimeLineItemNew", "stop, hash=" + hashCode());
    if ((this.Lna != null) && (this.Lna.Lnh.JKG != null))
    {
      if (!this.Lna.Ljs) {
        this.Lna.Lnh.JKG.KKl.clear();
      }
      onUIDestroy();
    }
    this.Lnb = false;
    AppMethodBeat.o(225819);
  }
  
  public static class a
    extends BaseTimeLineItem.BaseViewHolder
  {
    public boolean Ljs;
    public a.b Lnh;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.item.h
 * JD-Core Version:    0.7.0.1
 */