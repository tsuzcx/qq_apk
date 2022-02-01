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
import com.tencent.mm.plugin.sight.decode.model.SightPlayController;
import com.tencent.mm.plugin.sight.decode.model.SightPlayController.d;
import com.tencent.mm.plugin.sight.decode.model.SightPlayController.e;
import com.tencent.mm.plugin.sight.decode.ui.SightPlayImageView;
import com.tencent.mm.plugin.sns.b.d;
import com.tencent.mm.plugin.sns.b.f;
import com.tencent.mm.plugin.sns.b.i;
import com.tencent.mm.plugin.sns.b.j;
import com.tencent.mm.plugin.sns.data.t;
import com.tencent.mm.plugin.sns.model.al;
import com.tencent.mm.plugin.sns.model.as;
import com.tencent.mm.plugin.sns.model.g;
import com.tencent.mm.plugin.sns.storage.ADXml;
import com.tencent.mm.plugin.sns.storage.ADXml.j;
import com.tencent.mm.plugin.sns.storage.ADXml.o;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.plugin.sns.ui.MaskImageView;
import com.tencent.mm.plugin.sns.ui.aw;
import com.tencent.mm.plugin.sns.ui.listener.c;
import com.tencent.mm.pluginsdk.ui.tools.VideoSightView;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.agh;
import com.tencent.mm.protocal.protobuf.dmz;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.br;
import com.tencent.mm.ui.widget.MMPinProgressBtn;
import com.tencent.mm.ui.widget.QImageView.a;
import com.tencent.mm.ui.widget.RoundedCornerFrameLayout;
import com.tencent.mm.vfs.y;
import java.util.LinkedList;
import java.util.List;

public final class h
  extends b
{
  boolean RGE;
  public View RKe;
  public View RKf;
  private int[] RKg;
  private final int RKh;
  com.tencent.mm.plugin.sns.ad.g.l RoZ;
  Context context;
  public int currentIndex;
  
  public h(TimeLineObject paramTimeLineObject, SnsInfo paramSnsInfo, c paramc, com.tencent.mm.plugin.sns.ad.g.l paraml)
  {
    AppMethodBeat.i(100040);
    this.RGE = false;
    this.RKg = new int[] { b.f.turn_media_type_img_0, b.f.turn_media_type_img_1 };
    this.RKh = b.f.turn_media_type_sight_0;
    this.timeLineObject = paramTimeLineObject;
    this.PNI = paramSnsInfo;
    this.PZr = paramc;
    this.RoZ = paraml;
    AppMethodBeat.o(100040);
  }
  
  private View a(dmz paramdmz, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(100044);
    int[] arrayOfInt = new int[2];
    arrayOfInt[0] = b.f.turn_media_type_img_0;
    arrayOfInt[1] = b.f.turn_media_type_img_1;
    int i = b.f.turn_media_type_sight_0;
    if (paramBoolean)
    {
      paramdmz = this.contentView.findViewById(arrayOfInt[paramInt]);
      AppMethodBeat.o(100044);
      return paramdmz;
    }
    if (paramdmz.vhJ == 6)
    {
      paramdmz = this.contentView.findViewById(i);
      AppMethodBeat.o(100044);
      return paramdmz;
    }
    if (paramdmz.vhJ == 2)
    {
      paramdmz = this.contentView.findViewById(arrayOfInt[paramInt]);
      AppMethodBeat.o(100044);
      return paramdmz;
    }
    AppMethodBeat.o(100044);
    return null;
  }
  
  final void ams(int paramInt)
  {
    AppMethodBeat.i(100042);
    if ((this.RKf == null) || (this.RKe == null))
    {
      AppMethodBeat.o(100042);
      return;
    }
    this.currentIndex = paramInt;
    this.RKf.setVisibility(8);
    this.RKe.setVisibility(8);
    ((TextView)this.contentView.findViewById(b.f.turn_media_type_title_0)).setText(null);
    ((TextView)this.contentView.findViewById(b.f.turn_media_type_title_1)).setText(null);
    ((TextView)this.contentView.findViewById(b.f.turn_media_type_subtitle_0)).setText(null);
    ((TextView)this.contentView.findViewById(b.f.turn_media_type_subtitle_1)).setText(null);
    int i = b.f.turn_media_type_title_1;
    int j = b.f.turn_media_type_subtitle_1;
    int k = b.f.turn_media_type_title_0;
    int m = b.f.turn_media_type_subtitle_0;
    int n = b.f.turn_media_type_title_0;
    int i1 = b.f.turn_media_type_subtitle_1;
    Object localObject1 = this.PNI.getAdXml();
    Object localObject2;
    TextView localTextView;
    if ((((ADXml)localObject1).adTurnInfo != null) && (((ADXml)localObject1).adTurnInfo.QHY != null) && (((ADXml)localObject1).adTurnInfo.QHY.size() >= 2))
    {
      localObject1 = (ADXml.o)((ADXml)localObject1).adTurnInfo.QHY.get(paramInt);
      if ((((ADXml.o)localObject1).QHE >= 0) && (((ADXml.o)localObject1).QHE < 3))
      {
        paramInt = ((ADXml.o)localObject1).QHE;
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
  
  public final void hqT()
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
    if (this.timeLineObject.ContentObj.Zpr.size() >= 2)
    {
      long l;
      if (this.PNI.getLikeFlag() == 1)
      {
        i = 1;
        if ((this.RoZ != null) && (((dmz)this.timeLineObject.ContentObj.Zpr.get(i)).vhJ == 6))
        {
          localObject1 = this.RoZ;
          l = this.PNI.field_snsId;
          if (this.PNI.getLikeFlag() != 1) {
            break label130;
          }
        }
      }
      for (boolean bool = true;; bool = false)
      {
        ((com.tencent.mm.plugin.sns.ad.g.l)localObject1).U(l, bool);
        if (!this.RGE) {
          break label136;
        }
        Log.i("MicroMsg.TurnCardAdDetailItem", "isPlayAnimation, return");
        AppMethodBeat.o(100043);
        return;
        i = 0;
        break;
      }
      if (this.PNI.getLikeFlag() != 1) {
        break label399;
      }
      i = 0;
      j = 1;
      localObject1 = (dmz)this.timeLineObject.ContentObj.Zpr.get(j);
      localObject2 = (dmz)this.timeLineObject.ContentObj.Zpr.get(i);
      localObject1 = a((dmz)localObject1, j, false);
      localObject2 = a((dmz)localObject2, i, true);
      j = ((WindowManager)this.context.getSystemService("window")).getDefaultDisplay().getWidth();
      localObject3 = new int[2];
      this.contentView.getLocationOnScreen((int[])localObject3);
      f1 = j / 2 - localObject3[1];
      this.contentView.setPivotY(f1);
      this.contentView.setCameraDistance(8000.0F);
      f1 = this.contentView.getWidth() / 2.0F;
      f2 = this.contentView.getHeight() / 2.0F;
      if (this.PNI.getLikeFlag() != 1) {
        break label407;
      }
      k = -90;
    }
    for (int j = 90;; j = -90)
    {
      localObject3 = new com.tencent.mm.plugin.sns.ui.widget.b(this.context, 0.0F, j, f1, f2, true);
      ((com.tencent.mm.plugin.sns.ui.widget.b)localObject3).setDuration(187L);
      ((com.tencent.mm.plugin.sns.ui.widget.b)localObject3).setInterpolator(new AccelerateInterpolator());
      ((com.tencent.mm.plugin.sns.ui.widget.b)localObject3).setAnimationListener(new Animation.AnimationListener()
      {
        public final void onAnimationEnd(Animation paramAnonymousAnimation)
        {
          AppMethodBeat.i(100035);
          h.this.contentView.setLayerType(0, null);
          this.RKj.setVisibility(0);
          this.RKk.setVisibility(8);
          h.this.ams(i);
          paramAnonymousAnimation = new com.tencent.mm.plugin.sns.ui.widget.b(h.this.context, k, 0.0F, f1, f2, false);
          paramAnonymousAnimation.setDuration(187L);
          paramAnonymousAnimation.setInterpolator(new DecelerateInterpolator());
          h.this.contentView.startAnimation(paramAnonymousAnimation);
          h.this.RGE = false;
          h.this.refreshView();
          AppMethodBeat.o(100035);
        }
        
        public final void onAnimationRepeat(Animation paramAnonymousAnimation) {}
        
        public final void onAnimationStart(Animation paramAnonymousAnimation)
        {
          AppMethodBeat.i(100034);
          h.this.contentView.setLayerType(2, null);
          AppMethodBeat.o(100034);
        }
      });
      this.contentView.startAnimation((Animation)localObject3);
      this.RGE = true;
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
  
  public final void refreshView()
  {
    AppMethodBeat.i(100045);
    this.PNI = com.tencent.mm.plugin.sns.storage.l.aZK(this.PNI.getSnsId());
    Log.i("MicroMsg.TurnCardAdDetailItem", "refresh view");
    int k = ((WindowManager)this.context.getSystemService("window")).getDefaultDisplay().getWidth() - com.tencent.mm.cd.a.fromDPToPix(this.context, 50) - this.context.getResources().getDimensionPixelSize(b.d.NormalPadding) - this.context.getResources().getDimensionPixelSize(b.d.NormalPadding) - this.context.getResources().getDimensionPixelSize(b.d.SmallPadding);
    label141:
    label306:
    label570:
    label705:
    label1475:
    label1477:
    if (this.PNI.getTimeLine().ContentObj.Zpr.size() >= 2)
    {
      final int i;
      final int j;
      Object localObject1;
      Object localObject2;
      g localg;
      int m;
      br localbr;
      label252:
      final boolean bool1;
      label328:
      final long l1;
      if (this.PNI.field_likeFlag == 1)
      {
        i = 1;
        ams(i);
        j = 0;
        if (j >= 2) {
          break label1502;
        }
        localObject1 = (dmz)this.PNI.getTimeLine().ContentObj.Zpr.get(j);
        localObject2 = (MaskImageView)this.contentView.findViewById(this.RKg[j]);
        ViewGroup.LayoutParams localLayoutParams = ((MaskImageView)localObject2).getLayoutParams();
        ((MaskImageView)localObject2).setTag(this);
        if (((dmz)localObject1).vhJ != 2) {
          break label817;
        }
        localg = al.hgy();
        m = hashCode();
        localbr = br.jbl();
        localbr.time = this.timeLineObject.CreateTime;
        localg.a((dmz)localObject1, (View)localObject2, -1, m, localbr, 3);
        ((MaskImageView)localObject2).setScaleType(QImageView.a.afVc);
        localLayoutParams.width = k;
        localLayoutParams.height = k;
        if ((i != j) || (((dmz)localObject1).vhJ != 2)) {
          break label861;
        }
        ((MaskImageView)localObject2).setVisibility(0);
        ((MaskImageView)localObject2).setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(100036);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.cH(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/sns/ui/detail/item/TurnCardAdDetailItem$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
            if ((h.this.RoZ != null) && (i > 0)) {
              h.this.RoZ.us(h.this.PNI.field_snsId);
            }
            h.this.PZr.RQG.onClick(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/detail/item/TurnCardAdDetailItem$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(100036);
          }
        });
        if ((((dmz)localObject1).vhJ == 6) && (i == j))
        {
          if (i <= 0) {
            break label877;
          }
          bool1 = true;
          l1 = this.PNI.field_snsId;
          localObject2 = this.Qcj.RjL.getLayoutParams();
          ((ViewGroup.LayoutParams)localObject2).width = k;
          ((ViewGroup.LayoutParams)localObject2).height = k;
          this.Qcj.RjM.ld(k, k);
          this.Qcj.RjL.setVisibility(0);
          al.hgy().a(this.PNI, (dmz)localObject1, this.Qcj.RjM, this.context.hashCode(), 0, br.adkc, this.PNI.isAd(), true);
          this.Qcj.RjM.start();
          this.Qcj.RjT = true;
          this.Qcj.RjU = j;
          this.Qcj.RjK = this.timeLineObject;
          this.Qcj.position = 0;
          this.Qcj.hES = this.PNI.getLocalid();
          this.Qcj.RjO.setOnClickListener(new View.OnClickListener()
          {
            public final void onClick(View paramAnonymousView)
            {
              AppMethodBeat.i(100037);
              com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
              localb.cH(paramAnonymousView);
              com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/sns/ui/detail/item/TurnCardAdDetailItem$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
              if ((h.this.RoZ != null) && (bool1)) {
                h.this.RoZ.us(h.this.PNI.field_snsId);
              }
              h.this.PZr.RQG.onClick(paramAnonymousView);
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/detail/item/TurnCardAdDetailItem$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(100037);
            }
          });
          this.Qcj.RjM.setOnCompletionListener(new SightPlayController.d()
          {
            public final void c(SightPlayController paramAnonymousSightPlayController, int paramAnonymousInt)
            {
              AppMethodBeat.i(100038);
              if (paramAnonymousInt != -1) {
                h.this.RoZ.S(l1, this.PVY);
              }
              AppMethodBeat.o(100038);
            }
          });
          if (this.RoZ != null)
          {
            if (this.RoZ.uq(j + l1)) {
              break label883;
            }
            this.Qcj.RjM.setOnDecodeDurationListener(new SightPlayController.e()
            {
              public final void b(SightPlayController paramAnonymousSightPlayController, long paramAnonymousLong)
              {
                AppMethodBeat.i(100039);
                if (paramAnonymousLong >= 3L)
                {
                  int i = (int)paramAnonymousSightPlayController.gYy();
                  if (h.this.RoZ != null)
                  {
                    h.this.RoZ.c(l1, Util.currentTicks(), j);
                    h.this.RoZ.f(l1, i, j);
                    h.this.RoZ.bi(l1, l1 + this.val$index);
                  }
                  h.this.Qcj.RjM.setOnDecodeDurationListener(null);
                }
                AppMethodBeat.o(100039);
              }
            });
          }
          this.Qcj.a(this.timeLineObject, 0, this.PNI.getLocalid(), this.PNI.isAd());
          this.Qcj.QRC.setVisibility(8);
          localObject2 = al.hgy();
          long l2 = System.nanoTime();
          bool2 = g.u((dmz)localObject1);
          Log.i("MicroMsg.TurnCardAdDetailItem", "isMediaSightExist %b duration %s", new Object[] { Boolean.valueOf(bool2), Long.valueOf(System.nanoTime() - l2) });
          if (bool2) {
            break label1104;
          }
          if (!((g)localObject2).x((dmz)localObject1)) {
            break label900;
          }
          this.Qcj.PQu.setVisibility(8);
          this.Qcj.RjP.setVisibility(0);
          this.Qcj.RjP.jEN();
          if (this.RoZ != null)
          {
            localObject2 = as.mg(al.getAccSnsPath(), ((dmz)localObject1).Id);
            localObject1 = t.i((dmz)localObject1);
            if (!y.ZC((String)localObject2 + (String)localObject1)) {
              break label1477;
            }
            this.RoZ.g(this.PNI.field_snsId, 0, true);
            if (al.hgy().b(this.PNI, null) != 5) {
              break label1496;
            }
          }
        }
      }
      label1104:
      label1496:
      for (boolean bool2 = true;; bool2 = false)
      {
        this.RoZ.e(l1, bool2, bool1);
        j += 1;
        break label141;
        i = 0;
        break;
        localg = al.hgy();
        m = hashCode();
        localbr = br.jbl();
        localbr.time = this.timeLineObject.CreateTime;
        localg.a((dmz)localObject1, (View)localObject2, m, localbr);
        break label252;
        label861:
        ((MaskImageView)localObject2).setVisibility(8);
        ((MaskImageView)localObject2).setOnClickListener(null);
        break label306;
        label877:
        bool1 = false;
        break label328;
        label883:
        this.RoZ.c(l1, Util.currentTicks(), bool1);
        break label570;
        if (((g)localObject2).b(this.PNI, null) == 5)
        {
          ((g)localObject2).B((dmz)localObject1);
          this.Qcj.PQu.setVisibility(8);
          this.Qcj.RjP.setVisibility(0);
          this.Qcj.RjP.jEN();
          break label705;
        }
        if (((g)localObject2).y((dmz)localObject1))
        {
          this.Qcj.RjP.setVisibility(8);
          this.Qcj.PQu.setImageResource(b.i.shortvideo_play_icon_err);
          this.Qcj.PQu.setVisibility(0);
          break label705;
        }
        ((g)localObject2).z((dmz)localObject1);
        this.Qcj.PQu.setVisibility(0);
        this.Qcj.RjP.setVisibility(8);
        this.Qcj.PQu.setImageDrawable(com.tencent.mm.cd.a.m(this.context, b.i.shortvideo_play_btn));
        this.Qcj.PQu.setContentDescription(this.context.getString(b.j.play_sight_desc));
        if (((g)localObject2).b(this.PNI, null) != 4) {
          break label705;
        }
        this.Qcj.QRC.setVisibility(0);
        break label705;
        if (((g)localObject2).v((dmz)localObject1))
        {
          this.Qcj.PQu.setVisibility(0);
          this.Qcj.RjP.setVisibility(8);
          this.Qcj.PQu.setImageDrawable(com.tencent.mm.cd.a.m(this.context, b.i.shortvideo_play_btn));
          this.Qcj.PQu.setContentDescription(this.context.getString(b.j.play_sight_desc));
        }
        for (;;)
        {
          if (!this.Qcj.RjM.PGy.gYv()) {
            break label1475;
          }
          Log.d("MicroMsg.TurnCardAdDetailItem", "play video error " + ((dmz)localObject1).Id + " " + ((dmz)localObject1).Url + " " + ((dmz)localObject1).aaTl + " 0");
          ((g)localObject2).z((dmz)localObject1);
          this.Qcj.PQu.setVisibility(0);
          this.Qcj.RjP.setVisibility(8);
          this.Qcj.PQu.setImageDrawable(com.tencent.mm.cd.a.m(this.context, b.i.shortvideo_play_btn));
          this.Qcj.PQu.setContentDescription(this.context.getString(b.j.play_sight_desc));
          break;
          if (((g)localObject2).w((dmz)localObject1))
          {
            this.Qcj.PQu.setVisibility(8);
            this.Qcj.RjP.setVisibility(8);
          }
          else if (((g)localObject2).b(this.PNI, null) <= 5)
          {
            this.Qcj.PQu.setVisibility(8);
            this.Qcj.RjP.setVisibility(8);
          }
          else
          {
            ((g)localObject2).z((dmz)localObject1);
            this.Qcj.PQu.setVisibility(0);
            this.Qcj.RjP.setVisibility(8);
            this.Qcj.PQu.setImageDrawable(com.tencent.mm.cd.a.m(this.context, b.i.shortvideo_play_btn));
            this.Qcj.PQu.setContentDescription(this.context.getString(b.j.play_sight_desc));
          }
        }
        break label705;
        this.RoZ.g(this.PNI.field_snsId, 0, false);
        break label774;
      }
    }
    label774:
    label817:
    label1502:
    AppMethodBeat.o(100045);
    label900:
  }
  
  public final void t(View paramView1, View paramView2)
  {
    AppMethodBeat.i(100041);
    this.contentView = paramView1;
    this.RoA = paramView2;
    this.context = paramView1.getContext();
    paramView2 = (WindowManager)this.context.getSystemService("window");
    int j = Math.min(paramView2.getDefaultDisplay().getWidth(), paramView2.getDefaultDisplay().getHeight()) - com.tencent.mm.cd.a.br(this.context, b.d.sns_avatar_size) - com.tencent.mm.cd.a.br(this.context, b.d.SmallestPadding) - this.context.getResources().getDimensionPixelSize(b.d.NormalPadding) - this.context.getResources().getDimensionPixelSize(b.d.NormalPadding) - this.context.getResources().getDimensionPixelSize(b.d.SmallPadding);
    paramView2 = (LinearLayout.LayoutParams)paramView1.getLayoutParams();
    paramView2.topMargin = this.context.getResources().getDimensionPixelOffset(b.d.MiddlePadding);
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
    paramView2 = this.RKg;
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
    paramView2 = paramView1.findViewById(this.RKh);
    paramView2.setBackground(null);
    paramView2.setVisibility(8);
    ((ViewGroup)paramView2).setClipChildren(false);
    this.Qcj = new aw();
    this.Qcj.RjO = paramView2;
    this.Qcj.RjL = this.Qcj.RjO;
    this.Qcj.RjM = ((VideoSightView)this.Qcj.RjO.findViewById(b.f.image));
    this.Qcj.RjM.setMute(true);
    this.Qcj.PQu = ((ImageView)this.Qcj.RjO.findViewById(b.f.status_btn));
    this.Qcj.RjP = ((MMPinProgressBtn)this.Qcj.RjO.findViewById(b.f.progress));
    this.Qcj.RjQ = ((TextView)this.Qcj.RjO.findViewById(b.f.endtv));
    this.Qcj.QRC = ((TextView)this.Qcj.RjO.findViewById(b.f.errorTv));
    this.Qcj.RjO.setTag(this);
    this.Qcj.RjO.setOnClickListener(null);
    this.Qcj.RjM.PGE = true;
    this.Qcj.RjM.setScaleType(QImageView.a.afVc);
    this.Qcj.RjM.ld(j, j);
    this.RKf = paramView1.findViewById(b.f.text_area_top);
    this.RKe = paramView1.findViewById(b.f.text_area_bottom);
    ams(0);
    AppMethodBeat.o(100041);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.c.a.h
 * JD-Core Version:    0.7.0.1
 */