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
import com.tencent.mm.plugin.sns.ad.e.j;
import com.tencent.mm.plugin.sns.data.r;
import com.tencent.mm.plugin.sns.model.ah;
import com.tencent.mm.plugin.sns.model.ap;
import com.tencent.mm.plugin.sns.model.g;
import com.tencent.mm.plugin.sns.storage.b.k;
import com.tencent.mm.plugin.sns.storage.b.o;
import com.tencent.mm.plugin.sns.storage.h;
import com.tencent.mm.plugin.sns.storage.p;
import com.tencent.mm.plugin.sns.ui.MaskImageView;
import com.tencent.mm.plugin.sns.ui.aq;
import com.tencent.mm.plugin.sns.ui.d.c;
import com.tencent.mm.pluginsdk.ui.tools.VideoSightView;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.abo;
import com.tencent.mm.protocal.protobuf.bzh;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.bk;
import com.tencent.mm.ui.widget.MMPinProgressBtn;
import com.tencent.mm.ui.widget.QImageView.a;
import com.tencent.mm.ui.widget.RoundedCornerFrameLayout;
import com.tencent.mm.vfs.o;
import java.util.LinkedList;
import java.util.List;

public final class e
  extends a
{
  boolean AIs;
  public View ALT;
  public View ALU;
  private int[] ALV;
  private final int ALW;
  j Asq;
  Context context;
  public int currentIndex;
  
  public e(TimeLineObject paramTimeLineObject, p paramp, c paramc, j paramj)
  {
    AppMethodBeat.i(100040);
    this.AIs = false;
    this.ALV = new int[] { 2131306089, 2131306090 };
    this.ALW = 2131306091;
    this.timeLineObject = paramTimeLineObject;
    this.znm = paramp;
    this.zrv = paramc;
    this.Asq = paramj;
    AppMethodBeat.o(100040);
  }
  
  private View a(bzh parambzh, int paramInt, boolean paramBoolean)
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
      parambzh = this.contentView.findViewById(arrayOfInt[paramInt]);
      AppMethodBeat.o(100044);
      return parambzh;
    }
    if (parambzh.nJA == 6)
    {
      parambzh = this.contentView.findViewById(2131306091);
      AppMethodBeat.o(100044);
      return parambzh;
    }
    if (parambzh.nJA == 2)
    {
      parambzh = this.contentView.findViewById(arrayOfInt[paramInt]);
      AppMethodBeat.o(100044);
      return parambzh;
    }
    AppMethodBeat.o(100044);
    return null;
  }
  
  final void Sh(int paramInt)
  {
    AppMethodBeat.i(100042);
    if ((this.ALU == null) || (this.ALT == null))
    {
      AppMethodBeat.o(100042);
      return;
    }
    this.currentIndex = paramInt;
    this.ALU.setVisibility(8);
    this.ALT.setVisibility(8);
    ((TextView)this.contentView.findViewById(2131306094)).setText(null);
    ((TextView)this.contentView.findViewById(2131306095)).setText(null);
    ((TextView)this.contentView.findViewById(2131306092)).setText(null);
    ((TextView)this.contentView.findViewById(2131306093)).setText(null);
    Object localObject2 = { 2131306095, 2131306093 };
    Object localObject3 = { 2131306094, 2131306092 };
    int[] arrayOfInt = { 2131306094, 2131306093 };
    Object localObject1 = this.znm.dVj();
    if ((((com.tencent.mm.plugin.sns.storage.b)localObject1).zNJ != null) && (((com.tencent.mm.plugin.sns.storage.b)localObject1).zNJ.zOY != null) && (((com.tencent.mm.plugin.sns.storage.b)localObject1).zNJ.zOY.size() >= 2))
    {
      localObject1 = (b.o)((com.tencent.mm.plugin.sns.storage.b)localObject1).zNJ.zOY.get(paramInt);
      if ((((b.o)localObject1).zOE >= 0) && (((b.o)localObject1).zOE < 3))
      {
        paramInt = ((b.o)localObject1).zOE;
        localObject3 = new int[][] { localObject2, localObject3, arrayOfInt }[paramInt];
        localObject2 = (TextView)this.contentView.findViewById(localObject3[0]);
        localObject3 = (TextView)this.contentView.findViewById(localObject3[1]);
        if (!bu.isNullOrNil(((b.o)localObject1).title)) {
          break label349;
        }
        ((TextView)localObject2).setVisibility(8);
        if (!bu.isNullOrNil(((b.o)localObject1).desc)) {
          break label365;
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
      label349:
      ((TextView)localObject2).setVisibility(0);
      ((TextView)localObject2).setText(((b.o)localObject1).title);
      break;
      label365:
      ((TextView)localObject3).setVisibility(0);
      ((TextView)localObject3).setText(((b.o)localObject1).desc);
    }
  }
  
  public final void ehL()
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
    if (this.timeLineObject.HUG.Gtx.size() >= 2)
    {
      long l;
      if (this.znm.field_likeFlag == 1)
      {
        i = 1;
        if ((this.Asq != null) && (((bzh)this.timeLineObject.HUG.Gtx.get(i)).nJA == 6))
        {
          localObject1 = this.Asq;
          l = this.znm.field_snsId;
          if (this.znm.field_likeFlag != 1) {
            break label130;
          }
        }
      }
      for (boolean bool = true;; bool = false)
      {
        ((j)localObject1).F(l, bool);
        if (!this.AIs) {
          break label136;
        }
        ae.i("MicroMsg.TurnCardAdDetailItem", "isPlayAnimation, return");
        AppMethodBeat.o(100043);
        return;
        i = 0;
        break;
      }
      if (this.znm.field_likeFlag != 1) {
        break label399;
      }
      i = 0;
      j = 1;
      localObject1 = (bzh)this.timeLineObject.HUG.Gtx.get(j);
      localObject2 = (bzh)this.timeLineObject.HUG.Gtx.get(i);
      localObject1 = a((bzh)localObject1, j, false);
      localObject2 = a((bzh)localObject2, i, true);
      j = ((WindowManager)this.context.getSystemService("window")).getDefaultDisplay().getWidth();
      localObject3 = new int[2];
      this.contentView.getLocationOnScreen((int[])localObject3);
      f1 = j / 2 - localObject3[1];
      this.contentView.setPivotY(f1);
      this.contentView.setCameraDistance(8000.0F);
      f1 = this.contentView.getWidth() / 2.0F;
      f2 = this.contentView.getHeight() / 2.0F;
      if (this.znm.field_likeFlag != 1) {
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
          this.ALY.setVisibility(0);
          this.ALZ.setVisibility(8);
          e.this.Sh(i);
          paramAnonymousAnimation = new com.tencent.mm.plugin.sns.ui.widget.a(e.this.context, k, 0.0F, f1, f2, false);
          paramAnonymousAnimation.setDuration(187L);
          paramAnonymousAnimation.setInterpolator(new DecelerateInterpolator());
          e.this.contentView.startAnimation(paramAnonymousAnimation);
          e.this.AIs = false;
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
      this.AIs = true;
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
    this.ArR = paramView2;
    this.context = paramView1.getContext();
    paramView2 = (WindowManager)this.context.getSystemService("window");
    int j = Math.min(paramView2.getDefaultDisplay().getWidth(), paramView2.getDefaultDisplay().getHeight()) - com.tencent.mm.cb.a.ax(this.context, 2131166827) - com.tencent.mm.cb.a.ax(this.context, 2131165575) - this.context.getResources().getDimensionPixelSize(2131165516) - this.context.getResources().getDimensionPixelSize(2131165516) - this.context.getResources().getDimensionPixelSize(2131165568);
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
    paramView2 = this.ALV;
    int k = paramView2.length;
    int i = 0;
    while (i < k)
    {
      MaskImageView localMaskImageView = (MaskImageView)paramView1.findViewById(paramView2[i]);
      localMaskImageView.setVisibility(8);
      localMaskImageView.setOnTouchListener(new e.1(this));
      i += 1;
    }
    paramView2 = paramView1.findViewById(this.ALW);
    paramView2.setBackground(null);
    paramView2.setVisibility(8);
    ((ViewGroup)paramView2).setClipChildren(false);
    this.AKJ = new aq();
    this.AKJ.AnJ = paramView2;
    this.AKJ.AnG = this.AKJ.AnJ;
    this.AKJ.AnH = ((VideoSightView)this.AKJ.AnJ.findViewById(2131300914));
    this.AKJ.AnH.setMute(true);
    this.AKJ.zWJ = ((ImageView)this.AKJ.AnJ.findViewById(2131305196));
    this.AKJ.AnK = ((MMPinProgressBtn)this.AKJ.AnJ.findViewById(2131303515));
    this.AKJ.AnL = ((TextView)this.AKJ.AnJ.findViewById(2131299492));
    this.AKJ.zWK = ((TextView)this.AKJ.AnJ.findViewById(2131299517));
    this.AKJ.AnJ.setTag(this);
    this.AKJ.AnJ.setOnClickListener(null);
    this.AKJ.AnH.ziI = true;
    this.AKJ.AnH.setScaleType(QImageView.a.Lpz);
    this.AKJ.AnH.hy(j, j);
    this.ALU = paramView1.findViewById(2131305720);
    this.ALT = paramView1.findViewById(2131305719);
    Sh(0);
    AppMethodBeat.o(100041);
  }
  
  public final void refreshView()
  {
    AppMethodBeat.i(100045);
    this.znm = h.aBq(this.znm.getSnsId());
    ae.i("MicroMsg.TurnCardAdDetailItem", "refresh view");
    int k = ((WindowManager)this.context.getSystemService("window")).getDefaultDisplay().getWidth() - com.tencent.mm.cb.a.fromDPToPix(this.context, 50) - this.context.getResources().getDimensionPixelSize(2131165516) - this.context.getResources().getDimensionPixelSize(2131165516) - this.context.getResources().getDimensionPixelSize(2131165568);
    label141:
    label306:
    label572:
    label709:
    label1478:
    label1480:
    if (this.znm.ebP().HUG.Gtx.size() >= 2)
    {
      final int i;
      final int j;
      Object localObject1;
      Object localObject2;
      g localg;
      int m;
      bk localbk;
      label252:
      final boolean bool1;
      label328:
      final long l1;
      if (this.znm.field_likeFlag == 1)
      {
        i = 1;
        Sh(i);
        j = 0;
        if (j >= 2) {
          break label1504;
        }
        localObject1 = (bzh)this.znm.ebP().HUG.Gtx.get(j);
        localObject2 = (MaskImageView)this.contentView.findViewById(this.ALV[j]);
        ViewGroup.LayoutParams localLayoutParams = ((MaskImageView)localObject2).getLayoutParams();
        ((MaskImageView)localObject2).setTag(this);
        if (((bzh)localObject1).nJA != 2) {
          break label820;
        }
        localg = ah.dXB();
        m = hashCode();
        localbk = bk.fvr();
        localbk.heF = this.timeLineObject.CreateTime;
        localg.a((bzh)localObject1, (View)localObject2, -1, m, localbk, 3);
        ((MaskImageView)localObject2).setScaleType(QImageView.a.Lpz);
        localLayoutParams.width = k;
        localLayoutParams.height = k;
        if ((i != j) || (((bzh)localObject1).nJA != 2)) {
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
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/detail/item/TurnCardAdDetailItem$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
            if ((e.this.Asq != null) && (i > 0)) {
              e.this.Asq.zN(e.this.znm.field_snsId);
            }
            e.this.zrv.AQy.onClick(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/detail/item/TurnCardAdDetailItem$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(100036);
          }
        });
        if ((((bzh)localObject1).nJA == 6) && (i == j))
        {
          if (i <= 0) {
            break label880;
          }
          bool1 = true;
          l1 = this.znm.field_snsId;
          localObject2 = this.AKJ.AnG.getLayoutParams();
          ((ViewGroup.LayoutParams)localObject2).width = k;
          ((ViewGroup.LayoutParams)localObject2).height = k;
          this.AKJ.AnH.hy(k, k);
          this.AKJ.AnG.setVisibility(0);
          ah.dXB().a(this.znm, (bzh)localObject1, this.AKJ.AnH, this.context.hashCode(), 0, bk.JgB, this.znm.Rt(32), true);
          this.AKJ.AnH.start();
          this.AKJ.AnN = true;
          this.AKJ.AnO = j;
          this.AKJ.AnF = this.timeLineObject;
          this.AKJ.position = 0;
          this.AKJ.dqc = this.znm.eco();
          this.AKJ.AnJ.setOnClickListener(new View.OnClickListener()
          {
            public final void onClick(View paramAnonymousView)
            {
              AppMethodBeat.i(100037);
              com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
              localb.bd(paramAnonymousView);
              com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/detail/item/TurnCardAdDetailItem$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
              if ((e.this.Asq != null) && (bool1)) {
                e.this.Asq.zN(e.this.znm.field_snsId);
              }
              e.this.zrv.AQy.onClick(paramAnonymousView);
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/detail/item/TurnCardAdDetailItem$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(100037);
            }
          });
          this.AKJ.AnH.setOnCompletionListener(new b.e()
          {
            public final void c(com.tencent.mm.plugin.sight.decode.a.b paramAnonymousb, int paramAnonymousInt)
            {
              AppMethodBeat.i(100038);
              if (paramAnonymousInt != -1) {
                e.this.Asq.C(l1, this.zpp);
              }
              AppMethodBeat.o(100038);
            }
          });
          if (this.Asq != null)
          {
            if (this.Asq.zL(j + l1)) {
              break label886;
            }
            this.AKJ.AnH.setOnDecodeDurationListener(new b.f()
            {
              public final void b(com.tencent.mm.plugin.sight.decode.a.b paramAnonymousb, long paramAnonymousLong)
              {
                AppMethodBeat.i(100039);
                if (paramAnonymousLong >= 3L)
                {
                  int i = (int)paramAnonymousb.dTD();
                  if (e.this.Asq != null)
                  {
                    e.this.Asq.d(l1, bu.HQ(), j);
                    e.this.Asq.e(l1, i, j);
                    e.this.Asq.ai(l1, l1 + this.val$index);
                  }
                  e.this.AKJ.AnH.setOnDecodeDurationListener(null);
                }
                AppMethodBeat.o(100039);
              }
            });
          }
          this.AKJ.a(this.timeLineObject, 0, this.znm.eco(), this.znm.Rt(32));
          this.AKJ.zWK.setVisibility(8);
          localObject2 = ah.dXB();
          long l2 = System.nanoTime();
          bool2 = g.t((bzh)localObject1);
          ae.i("MicroMsg.TurnCardAdDetailItem", "isMediaSightExist %b duration %s", new Object[] { Boolean.valueOf(bool2), Long.valueOf(System.nanoTime() - l2) });
          if (bool2) {
            break label1107;
          }
          if (!((g)localObject2).w((bzh)localObject1)) {
            break label903;
          }
          this.AKJ.zWJ.setVisibility(8);
          this.AKJ.AnK.setVisibility(0);
          this.AKJ.AnK.fPL();
          if (this.Asq != null)
          {
            localObject2 = ap.jv(ah.getAccSnsPath(), ((bzh)localObject1).Id);
            localObject1 = r.i((bzh)localObject1);
            if (!o.fB((String)localObject2 + (String)localObject1)) {
              break label1480;
            }
            this.Asq.D(this.znm.field_snsId, true);
            if (ah.dXB().b(this.znm, null) != 5) {
              break label1498;
            }
          }
        }
      }
      label1107:
      label1498:
      for (boolean bool2 = true;; bool2 = false)
      {
        this.Asq.c(l1, bool2, bool1);
        j += 1;
        break label141;
        i = 0;
        break;
        localg = ah.dXB();
        m = hashCode();
        localbk = bk.fvr();
        localbk.heF = this.timeLineObject.CreateTime;
        localg.a((bzh)localObject1, (View)localObject2, m, localbk);
        break label252;
        label864:
        ((MaskImageView)localObject2).setVisibility(8);
        ((MaskImageView)localObject2).setOnClickListener(null);
        break label306;
        label880:
        bool1 = false;
        break label328;
        label886:
        this.Asq.d(l1, bu.HQ(), bool1);
        break label572;
        if (((g)localObject2).b(this.znm, null) == 5)
        {
          ((g)localObject2).A((bzh)localObject1);
          this.AKJ.zWJ.setVisibility(8);
          this.AKJ.AnK.setVisibility(0);
          this.AKJ.AnK.fPL();
          break label709;
        }
        if (((g)localObject2).x((bzh)localObject1))
        {
          this.AKJ.AnK.setVisibility(8);
          this.AKJ.zWJ.setImageResource(2131691612);
          this.AKJ.zWJ.setVisibility(0);
          break label709;
        }
        ((g)localObject2).y((bzh)localObject1);
        this.AKJ.zWJ.setVisibility(0);
        this.AKJ.AnK.setVisibility(8);
        this.AKJ.zWJ.setImageDrawable(com.tencent.mm.cb.a.l(this.context, 2131691166));
        this.AKJ.zWJ.setContentDescription(this.context.getString(2131761939));
        if (((g)localObject2).b(this.znm, null) != 4) {
          break label709;
        }
        this.AKJ.zWK.setVisibility(0);
        break label709;
        if (((g)localObject2).u((bzh)localObject1))
        {
          this.AKJ.zWJ.setVisibility(0);
          this.AKJ.AnK.setVisibility(8);
          this.AKJ.zWJ.setImageDrawable(com.tencent.mm.cb.a.l(this.context, 2131691166));
          this.AKJ.zWJ.setContentDescription(this.context.getString(2131761939));
        }
        for (;;)
        {
          if (!this.AKJ.AnH.ziA.dTA()) {
            break label1478;
          }
          ae.d("MicroMsg.TurnCardAdDetailItem", "play video error " + ((bzh)localObject1).Id + " " + ((bzh)localObject1).Url + " " + ((bzh)localObject1).Hmj + " 0");
          ((g)localObject2).y((bzh)localObject1);
          this.AKJ.zWJ.setVisibility(0);
          this.AKJ.AnK.setVisibility(8);
          this.AKJ.zWJ.setImageDrawable(com.tencent.mm.cb.a.l(this.context, 2131691166));
          this.AKJ.zWJ.setContentDescription(this.context.getString(2131761939));
          break;
          if (((g)localObject2).v((bzh)localObject1))
          {
            this.AKJ.zWJ.setVisibility(8);
            this.AKJ.AnK.setVisibility(8);
          }
          else if (((g)localObject2).b(this.znm, null) <= 5)
          {
            this.AKJ.zWJ.setVisibility(8);
            this.AKJ.AnK.setVisibility(8);
          }
          else
          {
            ((g)localObject2).y((bzh)localObject1);
            this.AKJ.zWJ.setVisibility(0);
            this.AKJ.AnK.setVisibility(8);
            this.AKJ.zWJ.setImageDrawable(com.tencent.mm.cb.a.l(this.context, 2131691166));
            this.AKJ.zWJ.setContentDescription(this.context.getString(2131761939));
          }
        }
        break label709;
        this.Asq.D(this.znm.field_snsId, false);
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