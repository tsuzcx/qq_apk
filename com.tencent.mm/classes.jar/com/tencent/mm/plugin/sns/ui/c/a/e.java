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
import com.tencent.mm.plugin.sns.data.q;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.plugin.sns.model.f;
import com.tencent.mm.plugin.sns.storage.b.j;
import com.tencent.mm.plugin.sns.storage.b.m;
import com.tencent.mm.plugin.sns.storage.h;
import com.tencent.mm.plugin.sns.storage.p;
import com.tencent.mm.plugin.sns.ui.MaskImageView;
import com.tencent.mm.pluginsdk.ui.tools.VideoSightView;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.btz;
import com.tencent.mm.protocal.protobuf.zf;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.bf;
import com.tencent.mm.ui.widget.MMPinProgressBtn;
import com.tencent.mm.ui.widget.QImageView.a;
import com.tencent.mm.ui.widget.RoundedCornerFrameLayout;
import java.util.LinkedList;
import java.util.List;

public final class e
  extends a
{
  Context context;
  public int currentIndex;
  com.tencent.mm.plugin.sns.ad.d.i yJJ;
  boolean yZo;
  public View zcN;
  public View zcO;
  private int[] zcP;
  private final int zcQ;
  
  public e(TimeLineObject paramTimeLineObject, p paramp, com.tencent.mm.plugin.sns.ui.d.b paramb, com.tencent.mm.plugin.sns.ad.d.i parami)
  {
    AppMethodBeat.i(100040);
    this.yZo = false;
    this.zcP = new int[] { 2131306089, 2131306090 };
    this.zcQ = 2131306091;
    this.timeLineObject = paramTimeLineObject;
    this.xIq = paramp;
    this.xLF = paramb;
    this.yJJ = parami;
    AppMethodBeat.o(100040);
  }
  
  private View a(btz parambtz, int paramInt, boolean paramBoolean)
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
      parambtz = this.contentView.findViewById(arrayOfInt[paramInt]);
      AppMethodBeat.o(100044);
      return parambtz;
    }
    if (parambtz.ndI == 6)
    {
      parambtz = this.contentView.findViewById(2131306091);
      AppMethodBeat.o(100044);
      return parambtz;
    }
    if (parambtz.ndI == 2)
    {
      parambtz = this.contentView.findViewById(arrayOfInt[paramInt]);
      AppMethodBeat.o(100044);
      return parambtz;
    }
    AppMethodBeat.o(100044);
    return null;
  }
  
  final void PR(int paramInt)
  {
    AppMethodBeat.i(100042);
    if ((this.zcO == null) || (this.zcN == null))
    {
      AppMethodBeat.o(100042);
      return;
    }
    this.currentIndex = paramInt;
    this.zcO.setVisibility(8);
    this.zcN.setVisibility(8);
    ((TextView)this.contentView.findViewById(2131306094)).setText(null);
    ((TextView)this.contentView.findViewById(2131306095)).setText(null);
    ((TextView)this.contentView.findViewById(2131306092)).setText(null);
    ((TextView)this.contentView.findViewById(2131306093)).setText(null);
    Object localObject2 = { 2131306095, 2131306093 };
    Object localObject3 = { 2131306094, 2131306092 };
    int[] arrayOfInt = { 2131306094, 2131306093 };
    Object localObject1 = this.xIq.dFR();
    if ((((com.tencent.mm.plugin.sns.storage.b)localObject1).ygm != null) && (((com.tencent.mm.plugin.sns.storage.b)localObject1).ygm.yhs != null) && (((com.tencent.mm.plugin.sns.storage.b)localObject1).ygm.yhs.size() >= 2))
    {
      localObject1 = (b.m)((com.tencent.mm.plugin.sns.storage.b)localObject1).ygm.yhs.get(paramInt);
      if ((((b.m)localObject1).ygY >= 0) && (((b.m)localObject1).ygY < 3))
      {
        paramInt = ((b.m)localObject1).ygY;
        localObject3 = new int[][] { localObject2, localObject3, arrayOfInt }[paramInt];
        localObject2 = (TextView)this.contentView.findViewById(localObject3[0]);
        localObject3 = (TextView)this.contentView.findViewById(localObject3[1]);
        if (!bs.isNullOrNil(((b.m)localObject1).title)) {
          break label349;
        }
        ((TextView)localObject2).setVisibility(8);
        if (!bs.isNullOrNil(((b.m)localObject1).desc)) {
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
      ((TextView)localObject2).setText(((b.m)localObject1).title);
      break;
      label365:
      ((TextView)localObject3).setVisibility(0);
      ((TextView)localObject3).setText(((b.m)localObject1).desc);
    }
  }
  
  public final void dRK()
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
    if (this.timeLineObject.FQo.Etz.size() >= 2)
    {
      long l;
      if (this.xIq.field_likeFlag == 1)
      {
        i = 1;
        if ((this.yJJ != null) && (((btz)this.timeLineObject.FQo.Etz.get(i)).ndI == 6))
        {
          localObject1 = this.yJJ;
          l = this.xIq.field_snsId;
          if (this.xIq.field_likeFlag != 1) {
            break label130;
          }
        }
      }
      for (boolean bool = true;; bool = false)
      {
        ((com.tencent.mm.plugin.sns.ad.d.i)localObject1).D(l, bool);
        if (!this.yZo) {
          break label136;
        }
        ac.i("MicroMsg.TurnCardAdDetailItem", "isPlayAnimation, return");
        AppMethodBeat.o(100043);
        return;
        i = 0;
        break;
      }
      if (this.xIq.field_likeFlag != 1) {
        break label399;
      }
      i = 0;
      j = 1;
      localObject1 = (btz)this.timeLineObject.FQo.Etz.get(j);
      localObject2 = (btz)this.timeLineObject.FQo.Etz.get(i);
      localObject1 = a((btz)localObject1, j, false);
      localObject2 = a((btz)localObject2, i, true);
      j = ((WindowManager)this.context.getSystemService("window")).getDefaultDisplay().getWidth();
      localObject3 = new int[2];
      this.contentView.getLocationOnScreen((int[])localObject3);
      f1 = j / 2 - localObject3[1];
      this.contentView.setPivotY(f1);
      this.contentView.setCameraDistance(8000.0F);
      f1 = this.contentView.getWidth() / 2.0F;
      f2 = this.contentView.getHeight() / 2.0F;
      if (this.xIq.field_likeFlag != 1) {
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
          this.zcS.setVisibility(0);
          this.zcT.setVisibility(8);
          e.this.PR(i);
          paramAnonymousAnimation = new com.tencent.mm.plugin.sns.ui.widget.a(e.this.context, k, 0.0F, f1, f2, false);
          paramAnonymousAnimation.setDuration(187L);
          paramAnonymousAnimation.setInterpolator(new DecelerateInterpolator());
          e.this.contentView.startAnimation(paramAnonymousAnimation);
          e.this.yZo = false;
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
      this.yZo = true;
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
  
  public final void l(View paramView1, View paramView2)
  {
    AppMethodBeat.i(100041);
    this.contentView = paramView1;
    this.yJk = paramView2;
    this.context = paramView1.getContext();
    paramView2 = (WindowManager)this.context.getSystemService("window");
    int j = Math.min(paramView2.getDefaultDisplay().getWidth(), paramView2.getDefaultDisplay().getHeight()) - com.tencent.mm.cc.a.au(this.context, 2131166827) - com.tencent.mm.cc.a.au(this.context, 2131165575) - this.context.getResources().getDimensionPixelSize(2131165516) - this.context.getResources().getDimensionPixelSize(2131165516) - this.context.getResources().getDimensionPixelSize(2131165568);
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
    paramView2 = this.zcP;
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
    paramView2 = paramView1.findViewById(this.zcQ);
    paramView2.setBackground(null);
    paramView2.setVisibility(8);
    ((ViewGroup)paramView2).setClipChildren(false);
    this.zbE = new com.tencent.mm.plugin.sns.ui.an();
    this.zbE.yFf = paramView2;
    this.zbE.yFc = this.zbE.yFf;
    this.zbE.yFd = ((VideoSightView)this.zbE.yFf.findViewById(2131300914));
    this.zbE.yFd.setMute(true);
    this.zbE.yoI = ((ImageView)this.zbE.yFf.findViewById(2131305196));
    this.zbE.yFg = ((MMPinProgressBtn)this.zbE.yFf.findViewById(2131303515));
    this.zbE.yFh = ((TextView)this.zbE.yFf.findViewById(2131299492));
    this.zbE.yoJ = ((TextView)this.zbE.yFf.findViewById(2131299517));
    this.zbE.yFf.setTag(this);
    this.zbE.yFf.setOnClickListener(null);
    this.zbE.yFd.xDO = true;
    this.zbE.yFd.setScaleType(QImageView.a.JbU);
    this.zbE.yFd.hf(j, j);
    this.zcO = paramView1.findViewById(2131305720);
    this.zcN = paramView1.findViewById(2131305719);
    PR(0);
    AppMethodBeat.o(100041);
  }
  
  public final void refreshView()
  {
    AppMethodBeat.i(100045);
    this.xIq = h.auS(this.xIq.getSnsId());
    ac.i("MicroMsg.TurnCardAdDetailItem", "refresh view");
    int k = ((WindowManager)this.context.getSystemService("window")).getDefaultDisplay().getWidth() - com.tencent.mm.cc.a.fromDPToPix(this.context, 50) - this.context.getResources().getDimensionPixelSize(2131165516) - this.context.getResources().getDimensionPixelSize(2131165516) - this.context.getResources().getDimensionPixelSize(2131165568);
    label141:
    label306:
    label572:
    label709:
    label1478:
    label1480:
    if (this.xIq.dLV().FQo.Etz.size() >= 2)
    {
      final int i;
      final int j;
      Object localObject1;
      Object localObject2;
      f localf;
      int m;
      bf localbf;
      label252:
      final boolean bool1;
      label328:
      final long l1;
      if (this.xIq.field_likeFlag == 1)
      {
        i = 1;
        PR(i);
        j = 0;
        if (j >= 2) {
          break label1504;
        }
        localObject1 = (btz)this.xIq.dLV().FQo.Etz.get(j);
        localObject2 = (MaskImageView)this.contentView.findViewById(this.zcP[j]);
        ViewGroup.LayoutParams localLayoutParams = ((MaskImageView)localObject2).getLayoutParams();
        ((MaskImageView)localObject2).setTag(this);
        if (((btz)localObject1).ndI != 2) {
          break label820;
        }
        localf = af.dHO();
        m = hashCode();
        localbf = bf.fbo();
        localbf.gIh = this.timeLineObject.CreateTime;
        localf.a((btz)localObject1, (View)localObject2, -1, m, localbf, 3);
        ((MaskImageView)localObject2).setScaleType(QImageView.a.JbU);
        localLayoutParams.width = k;
        localLayoutParams.height = k;
        if ((i != j) || (((btz)localObject1).ndI != 2)) {
          break label864;
        }
        ((MaskImageView)localObject2).setVisibility(0);
        ((MaskImageView)localObject2).setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(100036);
            if ((e.this.yJJ != null) && (i > 0)) {
              e.this.yJJ.wO(e.this.xIq.field_snsId);
            }
            e.this.xLF.zgZ.onClick(paramAnonymousView);
            AppMethodBeat.o(100036);
          }
        });
        if ((((btz)localObject1).ndI == 6) && (i == j))
        {
          if (i <= 0) {
            break label880;
          }
          bool1 = true;
          l1 = this.xIq.field_snsId;
          localObject2 = this.zbE.yFc.getLayoutParams();
          ((ViewGroup.LayoutParams)localObject2).width = k;
          ((ViewGroup.LayoutParams)localObject2).height = k;
          this.zbE.yFd.hf(k, k);
          this.zbE.yFc.setVisibility(0);
          af.dHO().a(this.xIq, (btz)localObject1, this.zbE.yFd, this.context.hashCode(), 0, bf.GYG, this.xIq.Pe(32), true);
          this.zbE.yFd.start();
          this.zbE.yFj = true;
          this.zbE.yFk = j;
          this.zbE.yFb = this.timeLineObject;
          this.zbE.position = 0;
          this.zbE.ddB = this.xIq.dMu();
          this.zbE.yFf.setOnClickListener(new View.OnClickListener()
          {
            public final void onClick(View paramAnonymousView)
            {
              AppMethodBeat.i(100037);
              if ((e.this.yJJ != null) && (bool1)) {
                e.this.yJJ.wO(e.this.xIq.field_snsId);
              }
              e.this.xLF.zgZ.onClick(paramAnonymousView);
              AppMethodBeat.o(100037);
            }
          });
          this.zbE.yFd.setOnCompletionListener(new b.e()
          {
            public final void c(com.tencent.mm.plugin.sight.decode.a.b paramAnonymousb, int paramAnonymousInt)
            {
              AppMethodBeat.i(100038);
              if (paramAnonymousInt != -1) {
                e.this.yJJ.A(l1, this.xJz);
              }
              AppMethodBeat.o(100038);
            }
          });
          if (this.yJJ != null)
          {
            if (this.yJJ.wM(j + l1)) {
              break label886;
            }
            this.zbE.yFd.setOnDecodeDurationListener(new b.f()
            {
              public final void b(com.tencent.mm.plugin.sight.decode.a.b paramAnonymousb, long paramAnonymousLong)
              {
                AppMethodBeat.i(100039);
                if (paramAnonymousLong >= 3L)
                {
                  int i = (int)paramAnonymousb.dED();
                  if (e.this.yJJ != null)
                  {
                    e.this.yJJ.d(l1, bs.Gn(), j);
                    e.this.yJJ.e(l1, i, j);
                    e.this.yJJ.ag(l1, l1 + this.hNp);
                  }
                  e.this.zbE.yFd.setOnDecodeDurationListener(null);
                }
                AppMethodBeat.o(100039);
              }
            });
          }
          this.zbE.a(this.timeLineObject, 0, this.xIq.dMu(), this.xIq.Pe(32));
          this.zbE.yoJ.setVisibility(8);
          localObject2 = af.dHO();
          long l2 = System.nanoTime();
          bool2 = f.t((btz)localObject1);
          ac.i("MicroMsg.TurnCardAdDetailItem", "isMediaSightExist %b duration %s", new Object[] { Boolean.valueOf(bool2), Long.valueOf(System.nanoTime() - l2) });
          if (bool2) {
            break label1107;
          }
          if (!((f)localObject2).w((btz)localObject1)) {
            break label903;
          }
          this.zbE.yoI.setVisibility(8);
          this.zbE.yFg.setVisibility(0);
          this.zbE.yFg.fuE();
          if (this.yJJ != null)
          {
            localObject2 = com.tencent.mm.plugin.sns.model.an.jc(af.getAccSnsPath(), ((btz)localObject1).Id);
            localObject1 = q.i((btz)localObject1);
            if (!com.tencent.mm.vfs.i.eA((String)localObject2 + (String)localObject1)) {
              break label1480;
            }
            this.yJJ.B(this.xIq.field_snsId, true);
            if (af.dHO().b(this.xIq, null) != 5) {
              break label1498;
            }
          }
        }
      }
      label1107:
      label1498:
      for (boolean bool2 = true;; bool2 = false)
      {
        this.yJJ.c(l1, bool2, bool1);
        j += 1;
        break label141;
        i = 0;
        break;
        localf = af.dHO();
        m = hashCode();
        localbf = bf.fbo();
        localbf.gIh = this.timeLineObject.CreateTime;
        localf.a((btz)localObject1, (View)localObject2, m, localbf);
        break label252;
        label864:
        ((MaskImageView)localObject2).setVisibility(8);
        ((MaskImageView)localObject2).setOnClickListener(null);
        break label306;
        label880:
        bool1 = false;
        break label328;
        label886:
        this.yJJ.d(l1, bs.Gn(), bool1);
        break label572;
        if (((f)localObject2).b(this.xIq, null) == 5)
        {
          ((f)localObject2).A((btz)localObject1);
          this.zbE.yoI.setVisibility(8);
          this.zbE.yFg.setVisibility(0);
          this.zbE.yFg.fuE();
          break label709;
        }
        if (((f)localObject2).x((btz)localObject1))
        {
          this.zbE.yFg.setVisibility(8);
          this.zbE.yoI.setImageResource(2131234034);
          this.zbE.yoI.setVisibility(0);
          break label709;
        }
        ((f)localObject2).y((btz)localObject1);
        this.zbE.yoI.setVisibility(0);
        this.zbE.yFg.setVisibility(8);
        this.zbE.yoI.setImageDrawable(com.tencent.mm.cc.a.l(this.context, 2131691166));
        this.zbE.yoI.setContentDescription(this.context.getString(2131761939));
        if (((f)localObject2).b(this.xIq, null) != 4) {
          break label709;
        }
        this.zbE.yoJ.setVisibility(0);
        break label709;
        if (((f)localObject2).u((btz)localObject1))
        {
          this.zbE.yoI.setVisibility(0);
          this.zbE.yFg.setVisibility(8);
          this.zbE.yoI.setImageDrawable(com.tencent.mm.cc.a.l(this.context, 2131691166));
          this.zbE.yoI.setContentDescription(this.context.getString(2131761939));
        }
        for (;;)
        {
          if (!this.zbE.yFd.xDG.dEA()) {
            break label1478;
          }
          ac.d("MicroMsg.TurnCardAdDetailItem", "play video error " + ((btz)localObject1).Id + " " + ((btz)localObject1).Url + " " + ((btz)localObject1).Fjh + " 0");
          ((f)localObject2).y((btz)localObject1);
          this.zbE.yoI.setVisibility(0);
          this.zbE.yFg.setVisibility(8);
          this.zbE.yoI.setImageDrawable(com.tencent.mm.cc.a.l(this.context, 2131691166));
          this.zbE.yoI.setContentDescription(this.context.getString(2131761939));
          break;
          if (((f)localObject2).v((btz)localObject1))
          {
            this.zbE.yoI.setVisibility(8);
            this.zbE.yFg.setVisibility(8);
          }
          else if (((f)localObject2).b(this.xIq, null) <= 5)
          {
            this.zbE.yoI.setVisibility(8);
            this.zbE.yFg.setVisibility(8);
          }
          else
          {
            ((f)localObject2).y((btz)localObject1);
            this.zbE.yoI.setVisibility(0);
            this.zbE.yFg.setVisibility(8);
            this.zbE.yoI.setImageDrawable(com.tencent.mm.cc.a.l(this.context, 2131691166));
            this.zbE.yoI.setContentDescription(this.context.getString(2131761939));
          }
        }
        break label709;
        this.yJJ.B(this.xIq.field_snsId, false);
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