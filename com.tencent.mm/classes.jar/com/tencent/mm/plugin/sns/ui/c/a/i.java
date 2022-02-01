package com.tencent.mm.plugin.sns.ui.c.a;

import android.content.Context;
import android.content.res.Resources;
import android.view.Display;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.WindowManager;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.DecelerateInterpolator;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sight.decode.a.b.e;
import com.tencent.mm.plugin.sight.decode.a.b.f;
import com.tencent.mm.plugin.sight.decode.ui.SightPlayImageView;
import com.tencent.mm.plugin.sns.ad.f.l;
import com.tencent.mm.plugin.sns.data.t;
import com.tencent.mm.plugin.sns.i.d;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.i.i;
import com.tencent.mm.plugin.sns.i.j;
import com.tencent.mm.plugin.sns.model.aj;
import com.tencent.mm.plugin.sns.model.aq;
import com.tencent.mm.plugin.sns.model.g;
import com.tencent.mm.plugin.sns.storage.ADXml;
import com.tencent.mm.plugin.sns.storage.ADXml.j;
import com.tencent.mm.plugin.sns.storage.ADXml.o;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.plugin.sns.storage.f;
import com.tencent.mm.plugin.sns.ui.MaskImageView;
import com.tencent.mm.plugin.sns.ui.av;
import com.tencent.mm.plugin.sns.ui.d.c;
import com.tencent.mm.pluginsdk.ui.tools.VideoSightView;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.adw;
import com.tencent.mm.protocal.protobuf.cvt;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.bp;
import com.tencent.mm.ui.widget.MMPinProgressBtn;
import com.tencent.mm.ui.widget.QImageView.a;
import com.tencent.mm.ui.widget.RoundedCornerFrameLayout;
import com.tencent.mm.vfs.u;
import java.util.LinkedList;
import java.util.List;

public final class i
  extends b
{
  l KPn;
  boolean Lgu;
  public View Lkq;
  public View Lkr;
  private int[] Lks;
  private final int Lkt;
  Context context;
  public int currentIndex;
  
  public i(TimeLineObject paramTimeLineObject, SnsInfo paramSnsInfo, c paramc, l paraml)
  {
    AppMethodBeat.i(100040);
    this.Lgu = false;
    this.Lks = new int[] { i.f.turn_media_type_img_0, i.f.turn_media_type_img_1 };
    this.Lkt = i.f.turn_media_type_sight_0;
    this.timeLineObject = paramTimeLineObject;
    this.Jzk = paramSnsInfo;
    this.JIp = paramc;
    this.KPn = paraml;
    AppMethodBeat.o(100040);
  }
  
  private View a(cvt paramcvt, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(100044);
    int[] arrayOfInt = new int[2];
    arrayOfInt[0] = i.f.turn_media_type_img_0;
    arrayOfInt[1] = i.f.turn_media_type_img_1;
    int i = i.f.turn_media_type_sight_0;
    if (paramBoolean)
    {
      paramcvt = this.contentView.findViewById(arrayOfInt[paramInt]);
      AppMethodBeat.o(100044);
      return paramcvt;
    }
    if (paramcvt.rWu == 6)
    {
      paramcvt = this.contentView.findViewById(i);
      AppMethodBeat.o(100044);
      return paramcvt;
    }
    if (paramcvt.rWu == 2)
    {
      paramcvt = this.contentView.findViewById(arrayOfInt[paramInt]);
      AppMethodBeat.o(100044);
      return paramcvt;
    }
    AppMethodBeat.o(100044);
    return null;
  }
  
  final void ahy(int paramInt)
  {
    AppMethodBeat.i(100042);
    if ((this.Lkr == null) || (this.Lkq == null))
    {
      AppMethodBeat.o(100042);
      return;
    }
    this.currentIndex = paramInt;
    this.Lkr.setVisibility(8);
    this.Lkq.setVisibility(8);
    ((TextView)this.contentView.findViewById(i.f.turn_media_type_title_0)).setText(null);
    ((TextView)this.contentView.findViewById(i.f.turn_media_type_title_1)).setText(null);
    ((TextView)this.contentView.findViewById(i.f.turn_media_type_subtitle_0)).setText(null);
    ((TextView)this.contentView.findViewById(i.f.turn_media_type_subtitle_1)).setText(null);
    int i = i.f.turn_media_type_title_1;
    int j = i.f.turn_media_type_subtitle_1;
    int k = i.f.turn_media_type_title_0;
    int m = i.f.turn_media_type_subtitle_0;
    int n = i.f.turn_media_type_title_0;
    int i1 = i.f.turn_media_type_subtitle_1;
    Object localObject1 = this.Jzk.getAdXml();
    Object localObject2;
    TextView localTextView;
    if ((((ADXml)localObject1).adTurnInfo != null) && (((ADXml)localObject1).adTurnInfo.Kka != null) && (((ADXml)localObject1).adTurnInfo.Kka.size() >= 2))
    {
      localObject1 = (ADXml.o)((ADXml)localObject1).adTurnInfo.Kka.get(paramInt);
      if ((((ADXml.o)localObject1).KjH >= 0) && (((ADXml.o)localObject1).KjH < 3))
      {
        paramInt = ((ADXml.o)localObject1).KjH;
        localObject2 = new int[][] { { i, j }, { k, m }, { n, i1 } }[paramInt];
        localTextView = (TextView)this.contentView.findViewById(localObject2[0]);
        localObject2 = (TextView)this.contentView.findViewById(localObject2[1]);
        if (!Util.isNullOrNil(((ADXml.o)localObject1).title)) {
          break label383;
        }
        localTextView.setVisibility(8);
        if (!Util.isNullOrNil(((ADXml.o)localObject1).desc)) {
          break label402;
        }
        ((TextView)localObject2).setVisibility(8);
      }
    }
    for (;;)
    {
      ((View)localTextView.getParent()).setVisibility(0);
      ((View)((TextView)localObject2).getParent()).setVisibility(0);
      AppMethodBeat.o(100042);
      return;
      label383:
      localTextView.setVisibility(0);
      localTextView.setText(((ADXml.o)localObject1).title);
      break;
      label402:
      ((TextView)localObject2).setVisibility(0);
      ((TextView)localObject2).setText(((ADXml.o)localObject1).desc);
    }
  }
  
  public final void fYz()
  {
    AppMethodBeat.i(100043);
    final int i;
    Object localObject1;
    label130:
    label136:
    Object localObject2;
    Object localObject3;
    final float f1;
    final float f2;
    final int k;
    if (this.timeLineObject.ContentObj.Sqr.size() >= 2)
    {
      long l;
      if (this.Jzk.getLikeFlag() == 1)
      {
        i = 1;
        if ((this.KPn != null) && (((cvt)this.timeLineObject.ContentObj.Sqr.get(i)).rWu == 6))
        {
          localObject1 = this.KPn;
          l = this.Jzk.field_snsId;
          if (this.Jzk.getLikeFlag() != 1) {
            break label130;
          }
        }
      }
      for (boolean bool = true;; bool = false)
      {
        ((l)localObject1).K(l, bool);
        if (!this.Lgu) {
          break label136;
        }
        Log.i("MicroMsg.TurnCardAdDetailItem", "isPlayAnimation, return");
        AppMethodBeat.o(100043);
        return;
        i = 0;
        break;
      }
      if (this.Jzk.getLikeFlag() != 1) {
        break label399;
      }
      i = 0;
      j = 1;
      localObject1 = (cvt)this.timeLineObject.ContentObj.Sqr.get(j);
      localObject2 = (cvt)this.timeLineObject.ContentObj.Sqr.get(i);
      localObject1 = a((cvt)localObject1, j, false);
      localObject2 = a((cvt)localObject2, i, true);
      j = ((WindowManager)this.context.getSystemService("window")).getDefaultDisplay().getWidth();
      localObject3 = new int[2];
      this.contentView.getLocationOnScreen((int[])localObject3);
      f1 = j / 2 - localObject3[1];
      this.contentView.setPivotY(f1);
      this.contentView.setCameraDistance(8000.0F);
      f1 = this.contentView.getWidth() / 2.0F;
      f2 = this.contentView.getHeight() / 2.0F;
      if (this.Jzk.getLikeFlag() != 1) {
        break label407;
      }
      k = -90;
    }
    for (int j = 90;; j = -90)
    {
      localObject3 = new com.tencent.mm.plugin.sns.ui.widget.a(this.context, 0.0F, j, f1, f2, true);
      ((com.tencent.mm.plugin.sns.ui.widget.a)localObject3).setDuration(187L);
      ((com.tencent.mm.plugin.sns.ui.widget.a)localObject3).setInterpolator(new AccelerateInterpolator());
      ((com.tencent.mm.plugin.sns.ui.widget.a)localObject3).setAnimationListener(new Animation.AnimationListener()
      {
        public final void onAnimationEnd(Animation paramAnonymousAnimation)
        {
          AppMethodBeat.i(100035);
          i.this.contentView.setLayerType(0, null);
          this.Lkv.setVisibility(0);
          this.Lkw.setVisibility(8);
          i.this.ahy(i);
          paramAnonymousAnimation = new com.tencent.mm.plugin.sns.ui.widget.a(i.this.context, k, 0.0F, f1, f2, false);
          paramAnonymousAnimation.setDuration(187L);
          paramAnonymousAnimation.setInterpolator(new DecelerateInterpolator());
          i.this.contentView.startAnimation(paramAnonymousAnimation);
          i.this.Lgu = false;
          i.this.refreshView();
          AppMethodBeat.o(100035);
        }
        
        public final void onAnimationRepeat(Animation paramAnonymousAnimation) {}
        
        public final void onAnimationStart(Animation paramAnonymousAnimation)
        {
          AppMethodBeat.i(100034);
          i.this.contentView.setLayerType(2, null);
          AppMethodBeat.o(100034);
        }
      });
      this.contentView.startAnimation((Animation)localObject3);
      this.Lgu = true;
      AppMethodBeat.o(100043);
      return;
      label399:
      i = 1;
      j = 0;
      break;
      label407:
      k = 90;
    }
  }
  
  public final void n(View paramView1, View paramView2)
  {
    AppMethodBeat.i(100041);
    this.contentView = paramView1;
    this.KON = paramView2;
    this.context = paramView1.getContext();
    paramView2 = (WindowManager)this.context.getSystemService("window");
    int j = Math.min(paramView2.getDefaultDisplay().getWidth(), paramView2.getDefaultDisplay().getHeight()) - com.tencent.mm.ci.a.aY(this.context, i.d.sns_avatar_size) - com.tencent.mm.ci.a.aY(this.context, i.d.SmallestPadding) - this.context.getResources().getDimensionPixelSize(i.d.NormalPadding) - this.context.getResources().getDimensionPixelSize(i.d.NormalPadding) - this.context.getResources().getDimensionPixelSize(i.d.SmallPadding);
    paramView2 = (LinearLayout.LayoutParams)paramView1.getLayoutParams();
    paramView2.topMargin = this.context.getResources().getDimensionPixelOffset(i.d.MiddlePadding);
    paramView2.bottomMargin = 0;
    paramView2.width = j;
    paramView2.height = j;
    paramView1.setLayoutParams(paramView2);
    ((RoundedCornerFrameLayout)paramView1).setRadius(8.0F);
    if ((paramView1.getParent() instanceof ViewGroup))
    {
      ((ViewGroup)paramView1.getParent()).setClipChildren(false);
      ((ViewGroup)paramView1.getParent()).setClipToPadding(false);
    }
    paramView2 = this.Lks;
    int k = paramView2.length;
    int i = 0;
    while (i < k)
    {
      MaskImageView localMaskImageView = (MaskImageView)paramView1.findViewById(paramView2[i]);
      localMaskImageView.setVisibility(8);
      localMaskImageView.setOnTouchListener(new View.OnTouchListener()
      {
        public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
        {
          return false;
        }
      });
      i += 1;
    }
    paramView2 = paramView1.findViewById(this.Lkt);
    paramView2.setBackground(null);
    paramView2.setVisibility(8);
    ((ViewGroup)paramView2).setClipChildren(false);
    this.JKG = new av();
    this.JKG.KKm = paramView2;
    this.JKG.KKj = this.JKG.KKm;
    this.JKG.KKk = ((VideoSightView)this.JKG.KKm.findViewById(i.f.image));
    this.JKG.KKk.setMute(true);
    this.JKG.JAL = ((ImageView)this.JKG.KKm.findViewById(i.f.status_btn));
    this.JKG.KKn = ((MMPinProgressBtn)this.JKG.KKm.findViewById(i.f.progress));
    this.JKG.KKo = ((TextView)this.JKG.KKm.findViewById(i.f.endtv));
    this.JKG.Ktc = ((TextView)this.JKG.KKm.findViewById(i.f.errorTv));
    this.JKG.KKm.setTag(this);
    this.JKG.KKm.setOnClickListener(null);
    this.JKG.KKk.Jte = true;
    this.JKG.KKk.setScaleType(QImageView.a.Ydm);
    this.JKG.KKk.ju(j, j);
    this.Lkr = paramView1.findViewById(i.f.text_area_top);
    this.Lkq = paramView1.findViewById(i.f.text_area_bottom);
    ahy(0);
    AppMethodBeat.o(100041);
  }
  
  public final void refreshView()
  {
    AppMethodBeat.i(100045);
    this.Jzk = f.bbk(this.Jzk.getSnsId());
    Log.i("MicroMsg.TurnCardAdDetailItem", "refresh view");
    int k = ((WindowManager)this.context.getSystemService("window")).getDefaultDisplay().getWidth() - com.tencent.mm.ci.a.fromDPToPix(this.context, 50) - this.context.getResources().getDimensionPixelSize(i.d.NormalPadding) - this.context.getResources().getDimensionPixelSize(i.d.NormalPadding) - this.context.getResources().getDimensionPixelSize(i.d.SmallPadding);
    label141:
    label306:
    label570:
    label705:
    label1475:
    label1477:
    if (this.Jzk.getTimeLine().ContentObj.Sqr.size() >= 2)
    {
      final int i;
      final int j;
      Object localObject1;
      Object localObject2;
      g localg;
      int m;
      bp localbp;
      label252:
      final boolean bool1;
      label328:
      final long l1;
      if (this.Jzk.field_likeFlag == 1)
      {
        i = 1;
        ahy(i);
        j = 0;
        if (j >= 2) {
          break label1502;
        }
        localObject1 = (cvt)this.Jzk.getTimeLine().ContentObj.Sqr.get(j);
        localObject2 = (MaskImageView)this.contentView.findViewById(this.Lks[j]);
        ViewGroup.LayoutParams localLayoutParams = ((MaskImageView)localObject2).getLayoutParams();
        ((MaskImageView)localObject2).setTag(this);
        if (((cvt)localObject1).rWu != 2) {
          break label817;
        }
        localg = aj.fOF();
        m = hashCode();
        localbp = bp.hzl();
        localbp.time = this.timeLineObject.CreateTime;
        localg.a((cvt)localObject1, (View)localObject2, -1, m, localbp, 3);
        ((MaskImageView)localObject2).setScaleType(QImageView.a.Ydm);
        localLayoutParams.width = k;
        localLayoutParams.height = k;
        if ((i != j) || (((cvt)localObject1).rWu != 2)) {
          break label861;
        }
        ((MaskImageView)localObject2).setVisibility(0);
        ((MaskImageView)localObject2).setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(100036);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.bn(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/sns/ui/detail/item/TurnCardAdDetailItem$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
            if ((i.this.KPn != null) && (i > 0)) {
              i.this.KPn.Ql(i.this.Jzk.field_snsId);
            }
            i.this.JIp.LpB.onClick(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/detail/item/TurnCardAdDetailItem$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(100036);
          }
        });
        if ((((cvt)localObject1).rWu == 6) && (i == j))
        {
          if (i <= 0) {
            break label877;
          }
          bool1 = true;
          l1 = this.Jzk.field_snsId;
          localObject2 = this.JKG.KKj.getLayoutParams();
          ((ViewGroup.LayoutParams)localObject2).width = k;
          ((ViewGroup.LayoutParams)localObject2).height = k;
          this.JKG.KKk.ju(k, k);
          this.JKG.KKj.setVisibility(0);
          aj.fOF().a(this.Jzk, (cvt)localObject1, this.JKG.KKk, this.context.hashCode(), 0, bp.VGo, this.Jzk.isAd(), true);
          this.JKG.KKk.start();
          this.JKG.KKr = true;
          this.JKG.KKs = j;
          this.JKG.KKi = this.timeLineObject;
          this.JKG.position = 0;
          this.JKG.fAg = this.Jzk.getLocalid();
          this.JKG.KKm.setOnClickListener(new View.OnClickListener()
          {
            public final void onClick(View paramAnonymousView)
            {
              AppMethodBeat.i(100037);
              com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
              localb.bn(paramAnonymousView);
              com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/sns/ui/detail/item/TurnCardAdDetailItem$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
              if ((i.this.KPn != null) && (bool1)) {
                i.this.KPn.Ql(i.this.Jzk.field_snsId);
              }
              i.this.JIp.LpB.onClick(paramAnonymousView);
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/detail/item/TurnCardAdDetailItem$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(100037);
            }
          });
          this.JKG.KKk.setOnCompletionListener(new b.e()
          {
            public final void c(com.tencent.mm.plugin.sight.decode.a.b paramAnonymousb, int paramAnonymousInt)
            {
              AppMethodBeat.i(100038);
              if (paramAnonymousInt != -1) {
                i.this.KPn.I(l1, this.JEX);
              }
              AppMethodBeat.o(100038);
            }
          });
          if (this.KPn != null)
          {
            if (this.KPn.Qj(j + l1)) {
              break label883;
            }
            this.JKG.KKk.setOnDecodeDurationListener(new b.f()
            {
              public final void b(com.tencent.mm.plugin.sight.decode.a.b paramAnonymousb, long paramAnonymousLong)
              {
                AppMethodBeat.i(100039);
                if (paramAnonymousLong >= 3L)
                {
                  int i = (int)paramAnonymousb.fIF();
                  if (i.this.KPn != null)
                  {
                    i.this.KPn.c(l1, Util.currentTicks(), j);
                    i.this.KPn.e(l1, i, j);
                    i.this.KPn.ay(l1, l1 + this.val$index);
                  }
                  i.this.JKG.KKk.setOnDecodeDurationListener(null);
                }
                AppMethodBeat.o(100039);
              }
            });
          }
          this.JKG.a(this.timeLineObject, 0, this.Jzk.getLocalid(), this.Jzk.isAd());
          this.JKG.Ktc.setVisibility(8);
          localObject2 = aj.fOF();
          long l2 = System.nanoTime();
          bool2 = g.u((cvt)localObject1);
          Log.i("MicroMsg.TurnCardAdDetailItem", "isMediaSightExist %b duration %s", new Object[] { Boolean.valueOf(bool2), Long.valueOf(System.nanoTime() - l2) });
          if (bool2) {
            break label1104;
          }
          if (!((g)localObject2).x((cvt)localObject1)) {
            break label900;
          }
          this.JKG.JAL.setVisibility(8);
          this.JKG.KKn.setVisibility(0);
          this.JKG.KKn.hZF();
          if (this.KPn != null)
          {
            localObject2 = aq.kD(aj.getAccSnsPath(), ((cvt)localObject1).Id);
            localObject1 = t.i((cvt)localObject1);
            if (!u.agG((String)localObject2 + (String)localObject1)) {
              break label1477;
            }
            this.KPn.f(this.Jzk.field_snsId, 0, true);
            if (aj.fOF().b(this.Jzk, null) != 5) {
              break label1496;
            }
          }
        }
      }
      label1104:
      label1496:
      for (boolean bool2 = true;; bool2 = false)
      {
        this.KPn.d(l1, bool2, bool1);
        j += 1;
        break label141;
        i = 0;
        break;
        localg = aj.fOF();
        m = hashCode();
        localbp = bp.hzl();
        localbp.time = this.timeLineObject.CreateTime;
        localg.a((cvt)localObject1, (View)localObject2, m, localbp);
        break label252;
        label861:
        ((MaskImageView)localObject2).setVisibility(8);
        ((MaskImageView)localObject2).setOnClickListener(null);
        break label306;
        label877:
        bool1 = false;
        break label328;
        label883:
        this.KPn.c(l1, Util.currentTicks(), bool1);
        break label570;
        if (((g)localObject2).b(this.Jzk, null) == 5)
        {
          ((g)localObject2).B((cvt)localObject1);
          this.JKG.JAL.setVisibility(8);
          this.JKG.KKn.setVisibility(0);
          this.JKG.KKn.hZF();
          break label705;
        }
        if (((g)localObject2).y((cvt)localObject1))
        {
          this.JKG.KKn.setVisibility(8);
          this.JKG.JAL.setImageResource(i.i.shortvideo_play_icon_err);
          this.JKG.JAL.setVisibility(0);
          break label705;
        }
        ((g)localObject2).z((cvt)localObject1);
        this.JKG.JAL.setVisibility(0);
        this.JKG.KKn.setVisibility(8);
        this.JKG.JAL.setImageDrawable(com.tencent.mm.ci.a.m(this.context, i.i.shortvideo_play_btn));
        this.JKG.JAL.setContentDescription(this.context.getString(i.j.play_sight_desc));
        if (((g)localObject2).b(this.Jzk, null) != 4) {
          break label705;
        }
        this.JKG.Ktc.setVisibility(0);
        break label705;
        if (((g)localObject2).v((cvt)localObject1))
        {
          this.JKG.JAL.setVisibility(0);
          this.JKG.KKn.setVisibility(8);
          this.JKG.JAL.setImageDrawable(com.tencent.mm.ci.a.m(this.context, i.i.shortvideo_play_btn));
          this.JKG.JAL.setContentDescription(this.context.getString(i.j.play_sight_desc));
        }
        for (;;)
        {
          if (!this.JKG.KKk.JsW.fIC()) {
            break label1475;
          }
          Log.d("MicroMsg.TurnCardAdDetailItem", "play video error " + ((cvt)localObject1).Id + " " + ((cvt)localObject1).Url + " " + ((cvt)localObject1).TDF + " 0");
          ((g)localObject2).z((cvt)localObject1);
          this.JKG.JAL.setVisibility(0);
          this.JKG.KKn.setVisibility(8);
          this.JKG.JAL.setImageDrawable(com.tencent.mm.ci.a.m(this.context, i.i.shortvideo_play_btn));
          this.JKG.JAL.setContentDescription(this.context.getString(i.j.play_sight_desc));
          break;
          if (((g)localObject2).w((cvt)localObject1))
          {
            this.JKG.JAL.setVisibility(8);
            this.JKG.KKn.setVisibility(8);
          }
          else if (((g)localObject2).b(this.Jzk, null) <= 5)
          {
            this.JKG.JAL.setVisibility(8);
            this.JKG.KKn.setVisibility(8);
          }
          else
          {
            ((g)localObject2).z((cvt)localObject1);
            this.JKG.JAL.setVisibility(0);
            this.JKG.KKn.setVisibility(8);
            this.JKG.JAL.setImageDrawable(com.tencent.mm.ci.a.m(this.context, i.i.shortvideo_play_btn));
            this.JKG.JAL.setContentDescription(this.context.getString(i.j.play_sight_desc));
          }
        }
        break label705;
        this.KPn.f(this.Jzk.field_snsId, 0, false);
        break label774;
      }
    }
    label774:
    label817:
    label1502:
    AppMethodBeat.o(100045);
    label900:
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.c.a.i
 * JD-Core Version:    0.7.0.1
 */