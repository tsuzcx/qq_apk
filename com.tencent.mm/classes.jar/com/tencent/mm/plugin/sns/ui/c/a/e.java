package com.tencent.mm.plugin.sns.ui.c.a;

import android.content.Context;
import android.content.res.Resources;
import android.view.Display;
import android.view.View;
import android.view.View.OnClickListener;
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
import com.tencent.mm.plugin.sns.data.q;
import com.tencent.mm.plugin.sns.model.ag;
import com.tencent.mm.plugin.sns.model.ao;
import com.tencent.mm.plugin.sns.model.f;
import com.tencent.mm.plugin.sns.storage.b.j;
import com.tencent.mm.plugin.sns.storage.b.m;
import com.tencent.mm.plugin.sns.storage.h;
import com.tencent.mm.plugin.sns.storage.p;
import com.tencent.mm.plugin.sns.ui.MaskImageView;
import com.tencent.mm.plugin.sns.ui.aq;
import com.tencent.mm.plugin.sns.ui.d.c;
import com.tencent.mm.pluginsdk.ui.tools.VideoSightView;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.abf;
import com.tencent.mm.protocal.protobuf.byn;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.bj;
import com.tencent.mm.ui.widget.MMPinProgressBtn;
import com.tencent.mm.ui.widget.QImageView.a;
import com.tencent.mm.ui.widget.RoundedCornerFrameLayout;
import java.util.LinkedList;
import java.util.List;

public final class e
  extends a
{
  com.tencent.mm.plugin.sns.ad.d.i Abd;
  boolean Are;
  public View AuD;
  public View AuE;
  private int[] AuF;
  private final int AuG;
  Context context;
  public int currentIndex;
  
  public e(TimeLineObject paramTimeLineObject, p paramp, c paramc, com.tencent.mm.plugin.sns.ad.d.i parami)
  {
    AppMethodBeat.i(100040);
    this.Are = false;
    this.AuF = new int[] { 2131306089, 2131306090 };
    this.AuG = 2131306091;
    this.timeLineObject = paramTimeLineObject;
    this.yXF = paramp;
    this.zaU = paramc;
    this.Abd = parami;
    AppMethodBeat.o(100040);
  }
  
  private View a(byn parambyn, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(100044);
    int[] arrayOfInt = new int[2];
    int[] tmp12_10 = arrayOfInt;
    tmp12_10[0] = 2131306089;
    int[] tmp17_12 = tmp12_10;
    tmp17_12[1] = 2131306090;
    tmp17_12;
    if (paramBoolean)
    {
      parambyn = this.contentView.findViewById(arrayOfInt[paramInt]);
      AppMethodBeat.o(100044);
      return parambyn;
    }
    if (parambyn.nEf == 6)
    {
      parambyn = this.contentView.findViewById(2131306091);
      AppMethodBeat.o(100044);
      return parambyn;
    }
    if (parambyn.nEf == 2)
    {
      parambyn = this.contentView.findViewById(arrayOfInt[paramInt]);
      AppMethodBeat.o(100044);
      return parambyn;
    }
    AppMethodBeat.o(100044);
    return null;
  }
  
  final void RA(int paramInt)
  {
    AppMethodBeat.i(100042);
    if ((this.AuE == null) || (this.AuD == null))
    {
      AppMethodBeat.o(100042);
      return;
    }
    this.currentIndex = paramInt;
    this.AuE.setVisibility(8);
    this.AuD.setVisibility(8);
    ((TextView)this.contentView.findViewById(2131306094)).setText(null);
    ((TextView)this.contentView.findViewById(2131306095)).setText(null);
    ((TextView)this.contentView.findViewById(2131306092)).setText(null);
    ((TextView)this.contentView.findViewById(2131306093)).setText(null);
    Object localObject2 = { 2131306095, 2131306093 };
    Object localObject3 = { 2131306094, 2131306092 };
    Object localObject1 = this.yXF.dRL();
    if ((((com.tencent.mm.plugin.sns.storage.b)localObject1).zwo != null) && (((com.tencent.mm.plugin.sns.storage.b)localObject1).zwo.zxz != null) && (((com.tencent.mm.plugin.sns.storage.b)localObject1).zwo.zxz.size() >= 2))
    {
      localObject1 = (b.m)((com.tencent.mm.plugin.sns.storage.b)localObject1).zwo.zxz.get(paramInt);
      if ((((b.m)localObject1).zxf >= 0) && (((b.m)localObject1).zxf < 3))
      {
        paramInt = ((b.m)localObject1).zxf;
        localObject3 = new int[][] { localObject2, localObject3, { 2131306094, 2131306093 } }[paramInt];
        localObject2 = (TextView)this.contentView.findViewById(localObject3[0]);
        localObject3 = (TextView)this.contentView.findViewById(localObject3[1]);
        if (!bt.isNullOrNil(((b.m)localObject1).title)) {
          break label345;
        }
        ((TextView)localObject2).setVisibility(8);
        if (!bt.isNullOrNil(((b.m)localObject1).desc)) {
          break label361;
        }
        ((TextView)localObject3).setVisibility(8);
      }
    }
    for (;;)
    {
      ((View)((TextView)localObject2).getParent()).setVisibility(0);
      ((View)((TextView)localObject3).getParent()).setVisibility(0);
      AppMethodBeat.o(100042);
      return;
      label345:
      ((TextView)localObject2).setVisibility(0);
      ((TextView)localObject2).setText(((b.m)localObject1).title);
      break;
      label361:
      ((TextView)localObject3).setVisibility(0);
      ((TextView)localObject3).setText(((b.m)localObject1).desc);
    }
  }
  
  public final void eee()
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
    if (this.timeLineObject.HAT.GaQ.size() >= 2)
    {
      long l;
      if (this.yXF.field_likeFlag == 1)
      {
        i = 1;
        if ((this.Abd != null) && (((byn)this.timeLineObject.HAT.GaQ.get(i)).nEf == 6))
        {
          localObject1 = this.Abd;
          l = this.yXF.field_snsId;
          if (this.yXF.field_likeFlag != 1) {
            break label130;
          }
        }
      }
      for (boolean bool = true;; bool = false)
      {
        ((com.tencent.mm.plugin.sns.ad.d.i)localObject1).D(l, bool);
        if (!this.Are) {
          break label136;
        }
        ad.i("MicroMsg.TurnCardAdDetailItem", "isPlayAnimation, return");
        AppMethodBeat.o(100043);
        return;
        i = 0;
        break;
      }
      if (this.yXF.field_likeFlag != 1) {
        break label399;
      }
      i = 0;
      j = 1;
      localObject1 = (byn)this.timeLineObject.HAT.GaQ.get(j);
      localObject2 = (byn)this.timeLineObject.HAT.GaQ.get(i);
      localObject1 = a((byn)localObject1, j, false);
      localObject2 = a((byn)localObject2, i, true);
      j = ((WindowManager)this.context.getSystemService("window")).getDefaultDisplay().getWidth();
      localObject3 = new int[2];
      this.contentView.getLocationOnScreen((int[])localObject3);
      f1 = j / 2 - localObject3[1];
      this.contentView.setPivotY(f1);
      this.contentView.setCameraDistance(8000.0F);
      f1 = this.contentView.getWidth() / 2.0F;
      f2 = this.contentView.getHeight() / 2.0F;
      if (this.yXF.field_likeFlag != 1) {
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
          e.this.contentView.setLayerType(0, null);
          this.AuI.setVisibility(0);
          this.AuJ.setVisibility(8);
          e.this.RA(i);
          paramAnonymousAnimation = new com.tencent.mm.plugin.sns.ui.widget.a(e.this.context, k, 0.0F, f1, f2, false);
          paramAnonymousAnimation.setDuration(187L);
          paramAnonymousAnimation.setInterpolator(new DecelerateInterpolator());
          e.this.contentView.startAnimation(paramAnonymousAnimation);
          e.this.Are = false;
          e.this.refreshView();
          AppMethodBeat.o(100035);
        }
        
        public final void onAnimationRepeat(Animation paramAnonymousAnimation) {}
        
        public final void onAnimationStart(Animation paramAnonymousAnimation)
        {
          AppMethodBeat.i(100034);
          e.this.contentView.setLayerType(2, null);
          AppMethodBeat.o(100034);
        }
      });
      this.contentView.startAnimation((Animation)localObject3);
      this.Are = true;
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
  
  public final void m(View paramView1, View paramView2)
  {
    AppMethodBeat.i(100041);
    this.contentView = paramView1;
    this.AaE = paramView2;
    this.context = paramView1.getContext();
    paramView2 = (WindowManager)this.context.getSystemService("window");
    int j = Math.min(paramView2.getDefaultDisplay().getWidth(), paramView2.getDefaultDisplay().getHeight()) - com.tencent.mm.cc.a.ax(this.context, 2131166827) - com.tencent.mm.cc.a.ax(this.context, 2131165575) - this.context.getResources().getDimensionPixelSize(2131165516) - this.context.getResources().getDimensionPixelSize(2131165516) - this.context.getResources().getDimensionPixelSize(2131165568);
    paramView2 = (LinearLayout.LayoutParams)paramView1.getLayoutParams();
    paramView2.topMargin = this.context.getResources().getDimensionPixelOffset(2131165500);
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
    paramView2 = this.AuF;
    int k = paramView2.length;
    int i = 0;
    while (i < k)
    {
      MaskImageView localMaskImageView = (MaskImageView)paramView1.findViewById(paramView2[i]);
      localMaskImageView.setVisibility(8);
      localMaskImageView.setOnTouchListener(new e.1(this));
      i += 1;
    }
    paramView2 = paramView1.findViewById(this.AuG);
    paramView2.setBackground(null);
    paramView2.setVisibility(8);
    ((ViewGroup)paramView2).setClipChildren(false);
    this.Atv = new aq();
    this.Atv.zWA = paramView2;
    this.Atv.zWx = this.Atv.zWA;
    this.Atv.zWy = ((VideoSightView)this.Atv.zWA.findViewById(2131300914));
    this.Atv.zWy.setMute(true);
    this.Atv.zFD = ((ImageView)this.Atv.zWA.findViewById(2131305196));
    this.Atv.zWB = ((MMPinProgressBtn)this.Atv.zWA.findViewById(2131303515));
    this.Atv.zWC = ((TextView)this.Atv.zWA.findViewById(2131299492));
    this.Atv.zFE = ((TextView)this.Atv.zWA.findViewById(2131299517));
    this.Atv.zWA.setTag(this);
    this.Atv.zWA.setOnClickListener(null);
    this.Atv.zWy.ySy = true;
    this.Atv.zWy.setScaleType(QImageView.a.KTb);
    this.Atv.zWy.hw(j, j);
    this.AuE = paramView1.findViewById(2131305720);
    this.AuD = paramView1.findViewById(2131305719);
    RA(0);
    AppMethodBeat.o(100041);
  }
  
  public final void refreshView()
  {
    AppMethodBeat.i(100045);
    this.yXF = h.azZ(this.yXF.getSnsId());
    ad.i("MicroMsg.TurnCardAdDetailItem", "refresh view");
    int k = ((WindowManager)this.context.getSystemService("window")).getDefaultDisplay().getWidth() - com.tencent.mm.cc.a.fromDPToPix(this.context, 50) - this.context.getResources().getDimensionPixelSize(2131165516) - this.context.getResources().getDimensionPixelSize(2131165516) - this.context.getResources().getDimensionPixelSize(2131165568);
    label141:
    label306:
    label572:
    label709:
    label1478:
    label1480:
    if (this.yXF.dYl().HAT.GaQ.size() >= 2)
    {
      final int i;
      final int j;
      Object localObject1;
      Object localObject2;
      f localf;
      int m;
      bj localbj;
      label252:
      final boolean bool1;
      label328:
      final long l1;
      if (this.yXF.field_likeFlag == 1)
      {
        i = 1;
        RA(i);
        j = 0;
        if (j >= 2) {
          break label1504;
        }
        localObject1 = (byn)this.yXF.dYl().HAT.GaQ.get(j);
        localObject2 = (MaskImageView)this.contentView.findViewById(this.AuF[j]);
        ViewGroup.LayoutParams localLayoutParams = ((MaskImageView)localObject2).getLayoutParams();
        ((MaskImageView)localObject2).setTag(this);
        if (((byn)localObject1).nEf != 2) {
          break label820;
        }
        localf = ag.dUb();
        m = hashCode();
        localbj = bj.frr();
        localbj.hbR = this.timeLineObject.CreateTime;
        localf.a((byn)localObject1, (View)localObject2, -1, m, localbj, 3);
        ((MaskImageView)localObject2).setScaleType(QImageView.a.KTb);
        localLayoutParams.width = k;
        localLayoutParams.height = k;
        if ((i != j) || (((byn)localObject1).nEf != 2)) {
          break label864;
        }
        ((MaskImageView)localObject2).setVisibility(0);
        ((MaskImageView)localObject2).setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(100036);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.bd(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/detail/item/TurnCardAdDetailItem$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
            if ((e.this.Abd != null) && (i > 0)) {
              e.this.Abd.zo(e.this.yXF.field_snsId);
            }
            e.this.zaU.Azc.onClick(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/detail/item/TurnCardAdDetailItem$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(100036);
          }
        });
        if ((((byn)localObject1).nEf == 6) && (i == j))
        {
          if (i <= 0) {
            break label880;
          }
          bool1 = true;
          l1 = this.yXF.field_snsId;
          localObject2 = this.Atv.zWx.getLayoutParams();
          ((ViewGroup.LayoutParams)localObject2).width = k;
          ((ViewGroup.LayoutParams)localObject2).height = k;
          this.Atv.zWy.hw(k, k);
          this.Atv.zWx.setVisibility(0);
          ag.dUb().a(this.yXF, (byn)localObject1, this.Atv.zWy, this.context.hashCode(), 0, bj.ILU, this.yXF.QM(32), true);
          this.Atv.zWy.start();
          this.Atv.zWE = true;
          this.Atv.zWF = j;
          this.Atv.zWw = this.timeLineObject;
          this.Atv.position = 0;
          this.Atv.doX = this.yXF.dYK();
          this.Atv.zWA.setOnClickListener(new View.OnClickListener()
          {
            public final void onClick(View paramAnonymousView)
            {
              AppMethodBeat.i(100037);
              com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
              localb.bd(paramAnonymousView);
              com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/detail/item/TurnCardAdDetailItem$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
              if ((e.this.Abd != null) && (bool1)) {
                e.this.Abd.zo(e.this.yXF.field_snsId);
              }
              e.this.zaU.Azc.onClick(paramAnonymousView);
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/detail/item/TurnCardAdDetailItem$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(100037);
            }
          });
          this.Atv.zWy.setOnCompletionListener(new b.e()
          {
            public final void c(com.tencent.mm.plugin.sight.decode.a.b paramAnonymousb, int paramAnonymousInt)
            {
              AppMethodBeat.i(100038);
              if (paramAnonymousInt != -1) {
                e.this.Abd.A(l1, this.yYO);
              }
              AppMethodBeat.o(100038);
            }
          });
          if (this.Abd != null)
          {
            if (this.Abd.zm(j + l1)) {
              break label886;
            }
            this.Atv.zWy.setOnDecodeDurationListener(new b.f()
            {
              public final void b(com.tencent.mm.plugin.sight.decode.a.b paramAnonymousb, long paramAnonymousLong)
              {
                AppMethodBeat.i(100039);
                if (paramAnonymousLong >= 3L)
                {
                  int i = (int)paramAnonymousb.dQg();
                  if (e.this.Abd != null)
                  {
                    e.this.Abd.d(l1, bt.HI(), j);
                    e.this.Abd.e(l1, i, j);
                    e.this.Abd.aj(l1, l1 + this.val$index);
                  }
                  e.this.Atv.zWy.setOnDecodeDurationListener(null);
                }
                AppMethodBeat.o(100039);
              }
            });
          }
          this.Atv.a(this.timeLineObject, 0, this.yXF.dYK(), this.yXF.QM(32));
          this.Atv.zFE.setVisibility(8);
          localObject2 = ag.dUb();
          long l2 = System.nanoTime();
          bool2 = f.t((byn)localObject1);
          ad.i("MicroMsg.TurnCardAdDetailItem", "isMediaSightExist %b duration %s", new Object[] { Boolean.valueOf(bool2), Long.valueOf(System.nanoTime() - l2) });
          if (bool2) {
            break label1107;
          }
          if (!((f)localObject2).w((byn)localObject1)) {
            break label903;
          }
          this.Atv.zFD.setVisibility(8);
          this.Atv.zWB.setVisibility(0);
          this.Atv.zWB.fLr();
          if (this.Abd != null)
          {
            localObject2 = ao.jo(ag.getAccSnsPath(), ((byn)localObject1).Id);
            localObject1 = q.i((byn)localObject1);
            if (!com.tencent.mm.vfs.i.fv((String)localObject2 + (String)localObject1)) {
              break label1480;
            }
            this.Abd.B(this.yXF.field_snsId, true);
            if (ag.dUb().b(this.yXF, null) != 5) {
              break label1498;
            }
          }
        }
      }
      label1107:
      label1498:
      for (boolean bool2 = true;; bool2 = false)
      {
        this.Abd.c(l1, bool2, bool1);
        j += 1;
        break label141;
        i = 0;
        break;
        localf = ag.dUb();
        m = hashCode();
        localbj = bj.frr();
        localbj.hbR = this.timeLineObject.CreateTime;
        localf.a((byn)localObject1, (View)localObject2, m, localbj);
        break label252;
        label864:
        ((MaskImageView)localObject2).setVisibility(8);
        ((MaskImageView)localObject2).setOnClickListener(null);
        break label306;
        label880:
        bool1 = false;
        break label328;
        label886:
        this.Abd.d(l1, bt.HI(), bool1);
        break label572;
        if (((f)localObject2).b(this.yXF, null) == 5)
        {
          ((f)localObject2).A((byn)localObject1);
          this.Atv.zFD.setVisibility(8);
          this.Atv.zWB.setVisibility(0);
          this.Atv.zWB.fLr();
          break label709;
        }
        if (((f)localObject2).x((byn)localObject1))
        {
          this.Atv.zWB.setVisibility(8);
          this.Atv.zFD.setImageResource(2131691612);
          this.Atv.zFD.setVisibility(0);
          break label709;
        }
        ((f)localObject2).y((byn)localObject1);
        this.Atv.zFD.setVisibility(0);
        this.Atv.zWB.setVisibility(8);
        this.Atv.zFD.setImageDrawable(com.tencent.mm.cc.a.l(this.context, 2131691166));
        this.Atv.zFD.setContentDescription(this.context.getString(2131761939));
        if (((f)localObject2).b(this.yXF, null) != 4) {
          break label709;
        }
        this.Atv.zFE.setVisibility(0);
        break label709;
        if (((f)localObject2).u((byn)localObject1))
        {
          this.Atv.zFD.setVisibility(0);
          this.Atv.zWB.setVisibility(8);
          this.Atv.zFD.setImageDrawable(com.tencent.mm.cc.a.l(this.context, 2131691166));
          this.Atv.zFD.setContentDescription(this.context.getString(2131761939));
        }
        for (;;)
        {
          if (!this.Atv.zWy.ySq.dQd()) {
            break label1478;
          }
          ad.d("MicroMsg.TurnCardAdDetailItem", "play video error " + ((byn)localObject1).Id + " " + ((byn)localObject1).Url + " " + ((byn)localObject1).GSI + " 0");
          ((f)localObject2).y((byn)localObject1);
          this.Atv.zFD.setVisibility(0);
          this.Atv.zWB.setVisibility(8);
          this.Atv.zFD.setImageDrawable(com.tencent.mm.cc.a.l(this.context, 2131691166));
          this.Atv.zFD.setContentDescription(this.context.getString(2131761939));
          break;
          if (((f)localObject2).v((byn)localObject1))
          {
            this.Atv.zFD.setVisibility(8);
            this.Atv.zWB.setVisibility(8);
          }
          else if (((f)localObject2).b(this.yXF, null) <= 5)
          {
            this.Atv.zFD.setVisibility(8);
            this.Atv.zWB.setVisibility(8);
          }
          else
          {
            ((f)localObject2).y((byn)localObject1);
            this.Atv.zFD.setVisibility(0);
            this.Atv.zWB.setVisibility(8);
            this.Atv.zFD.setImageDrawable(com.tencent.mm.cc.a.l(this.context, 2131691166));
            this.Atv.zFD.setContentDescription(this.context.getString(2131761939));
          }
        }
        break label709;
        this.Abd.B(this.yXF.field_snsId, false);
        break label777;
      }
    }
    label777:
    label820:
    label1504:
    AppMethodBeat.o(100045);
    label903:
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.c.a.e
 * JD-Core Version:    0.7.0.1
 */