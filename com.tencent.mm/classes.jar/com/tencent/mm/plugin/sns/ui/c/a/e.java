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
import com.tencent.mm.plugin.sns.storage.b.i;
import com.tencent.mm.plugin.sns.storage.b.l;
import com.tencent.mm.plugin.sns.storage.h;
import com.tencent.mm.plugin.sns.storage.p;
import com.tencent.mm.plugin.sns.ui.MaskImageView;
import com.tencent.mm.pluginsdk.ui.tools.VideoSightView;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.bpi;
import com.tencent.mm.protocal.protobuf.yk;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.bc;
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
  boolean xMz;
  public View xPX;
  public View xPY;
  private int[] xPZ;
  private final int xQa;
  com.tencent.mm.plugin.sns.a.b.i xwT;
  
  public e(TimeLineObject paramTimeLineObject, p paramp, com.tencent.mm.plugin.sns.ui.d.b paramb, com.tencent.mm.plugin.sns.a.b.i parami)
  {
    AppMethodBeat.i(100040);
    this.xMz = false;
    this.xPZ = new int[] { 2131306089, 2131306090 };
    this.xQa = 2131306091;
    this.timeLineObject = paramTimeLineObject;
    this.wwP = paramp;
    this.xta = paramb;
    this.xwT = parami;
    AppMethodBeat.o(100040);
  }
  
  private View a(bpi parambpi, int paramInt, boolean paramBoolean)
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
      parambpi = this.contentView.findViewById(arrayOfInt[paramInt]);
      AppMethodBeat.o(100044);
      return parambpi;
    }
    if (parambpi.mBH == 6)
    {
      parambpi = this.contentView.findViewById(2131306091);
      AppMethodBeat.o(100044);
      return parambpi;
    }
    if (parambpi.mBH == 2)
    {
      parambpi = this.contentView.findViewById(arrayOfInt[paramInt]);
      AppMethodBeat.o(100044);
      return parambpi;
    }
    AppMethodBeat.o(100044);
    return null;
  }
  
  final void NN(int paramInt)
  {
    AppMethodBeat.i(100042);
    if ((this.xPY == null) || (this.xPX == null))
    {
      AppMethodBeat.o(100042);
      return;
    }
    this.currentIndex = paramInt;
    this.xPY.setVisibility(8);
    this.xPX.setVisibility(8);
    ((TextView)this.contentView.findViewById(2131306094)).setText(null);
    ((TextView)this.contentView.findViewById(2131306095)).setText(null);
    ((TextView)this.contentView.findViewById(2131306092)).setText(null);
    ((TextView)this.contentView.findViewById(2131306093)).setText(null);
    Object localObject1 = this.wwP.dxs();
    Object localObject2;
    TextView localTextView;
    if ((((com.tencent.mm.plugin.sns.storage.b)localObject1).wTC != null) && (((com.tencent.mm.plugin.sns.storage.b)localObject1).wTC.wUE != null) && (((com.tencent.mm.plugin.sns.storage.b)localObject1).wTC.wUE.size() >= 2))
    {
      localObject1 = (b.l)((com.tencent.mm.plugin.sns.storage.b)localObject1).wTC.wUE.get(paramInt);
      if ((((b.l)localObject1).wUk >= 0) && (((b.l)localObject1).wUk < 3))
      {
        paramInt = ((b.l)localObject1).wUk;
        localObject2 = new int[][] { { 2131306095, 2131306093 }, { 2131306094, 2131306092 }, { 2131306094, 2131306093 } }[paramInt];
        localTextView = (TextView)this.contentView.findViewById(localObject2[0]);
        localObject2 = (TextView)this.contentView.findViewById(localObject2[1]);
        if (!bt.isNullOrNil(((b.l)localObject1).title)) {
          break label339;
        }
        localTextView.setVisibility(8);
        if (!bt.isNullOrNil(((b.l)localObject1).desc)) {
          break label355;
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
      label339:
      localTextView.setVisibility(0);
      localTextView.setText(((b.l)localObject1).title);
      break;
      label355:
      ((TextView)localObject2).setVisibility(0);
      ((TextView)localObject2).setText(((b.l)localObject1).desc);
    }
  }
  
  public final void dDn()
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
    if (this.timeLineObject.Etm.DaC.size() >= 2)
    {
      long l;
      if (this.wwP.field_likeFlag == 1)
      {
        i = 1;
        if ((this.xwT != null) && (((bpi)this.timeLineObject.Etm.DaC.get(i)).mBH == 6))
        {
          localObject1 = this.xwT;
          l = this.wwP.field_snsId;
          if (this.wwP.field_likeFlag != 1) {
            break label130;
          }
        }
      }
      for (boolean bool = true;; bool = false)
      {
        ((com.tencent.mm.plugin.sns.a.b.i)localObject1).D(l, bool);
        if (!this.xMz) {
          break label136;
        }
        ad.i("MicroMsg.TurnCardAdDetailItem", "isPlayAnimation, return");
        AppMethodBeat.o(100043);
        return;
        i = 0;
        break;
      }
      if (this.wwP.field_likeFlag != 1) {
        break label399;
      }
      i = 0;
      j = 1;
      localObject1 = (bpi)this.timeLineObject.Etm.DaC.get(j);
      localObject2 = (bpi)this.timeLineObject.Etm.DaC.get(i);
      localObject1 = a((bpi)localObject1, j, false);
      localObject2 = a((bpi)localObject2, i, true);
      j = ((WindowManager)this.context.getSystemService("window")).getDefaultDisplay().getWidth();
      localObject3 = new int[2];
      this.contentView.getLocationOnScreen((int[])localObject3);
      f1 = j / 2 - localObject3[1];
      this.contentView.setPivotY(f1);
      this.contentView.setCameraDistance(8000.0F);
      f1 = this.contentView.getWidth() / 2.0F;
      f2 = this.contentView.getHeight() / 2.0F;
      if (this.wwP.field_likeFlag != 1) {
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
          this.xQc.setVisibility(0);
          this.xQd.setVisibility(8);
          e.this.NN(i);
          paramAnonymousAnimation = new com.tencent.mm.plugin.sns.ui.widget.a(e.this.context, k, 0.0F, f1, f2, false);
          paramAnonymousAnimation.setDuration(187L);
          paramAnonymousAnimation.setInterpolator(new DecelerateInterpolator());
          e.this.contentView.startAnimation(paramAnonymousAnimation);
          e.this.xMz = false;
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
      this.xMz = true;
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
  
  public final void k(View paramView1, View paramView2)
  {
    AppMethodBeat.i(100041);
    this.contentView = paramView1;
    this.xwu = paramView2;
    this.context = paramView1.getContext();
    paramView2 = (WindowManager)this.context.getSystemService("window");
    int j = Math.min(paramView2.getDefaultDisplay().getWidth(), paramView2.getDefaultDisplay().getHeight()) - com.tencent.mm.cd.a.ao(this.context, 2131166827) - com.tencent.mm.cd.a.ao(this.context, 2131165575) - this.context.getResources().getDimensionPixelSize(2131165516) - this.context.getResources().getDimensionPixelSize(2131165516) - this.context.getResources().getDimensionPixelSize(2131165568);
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
    paramView2 = this.xPZ;
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
    paramView2 = paramView1.findViewById(this.xQa);
    paramView2.setBackground(null);
    paramView2.setVisibility(8);
    ((ViewGroup)paramView2).setClipChildren(false);
    this.xOO = new com.tencent.mm.plugin.sns.ui.an();
    this.xOO.xsp = paramView2;
    this.xOO.xsm = this.xOO.xsp;
    this.xOO.xsn = ((VideoSightView)this.xOO.xsp.findViewById(2131300914));
    this.xOO.xsn.setMute(true);
    this.xOO.xbT = ((ImageView)this.xOO.xsp.findViewById(2131305196));
    this.xOO.xsq = ((MMPinProgressBtn)this.xOO.xsp.findViewById(2131303515));
    this.xOO.xsr = ((TextView)this.xOO.xsp.findViewById(2131299492));
    this.xOO.xbU = ((TextView)this.xOO.xsp.findViewById(2131299517));
    this.xOO.xsp.setTag(this);
    this.xOO.xsp.setOnClickListener(null);
    this.xOO.xsn.wsy = true;
    this.xOO.xsn.setScaleType(QImageView.a.HBy);
    this.xOO.xsn.gW(j, j);
    this.xPY = paramView1.findViewById(2131305720);
    this.xPX = paramView1.findViewById(2131305719);
    NN(0);
    AppMethodBeat.o(100041);
  }
  
  public final void refreshView()
  {
    AppMethodBeat.i(100045);
    this.wwP = h.apJ(this.wwP.getSnsId());
    ad.i("MicroMsg.TurnCardAdDetailItem", "refresh view");
    int k = ((WindowManager)this.context.getSystemService("window")).getDefaultDisplay().getWidth() - com.tencent.mm.cd.a.fromDPToPix(this.context, 50) - this.context.getResources().getDimensionPixelSize(2131165516) - this.context.getResources().getDimensionPixelSize(2131165516) - this.context.getResources().getDimensionPixelSize(2131165568);
    label141:
    label306:
    label572:
    label709:
    label1478:
    label1480:
    if (this.wwP.dxy().Etm.DaC.size() >= 2)
    {
      final int i;
      final int j;
      Object localObject1;
      Object localObject2;
      f localf;
      int m;
      bc localbc;
      label252:
      final boolean bool1;
      label328:
      final long l1;
      if (this.wwP.field_likeFlag == 1)
      {
        i = 1;
        NN(i);
        j = 0;
        if (j >= 2) {
          break label1504;
        }
        localObject1 = (bpi)this.wwP.dxy().Etm.DaC.get(j);
        localObject2 = (MaskImageView)this.contentView.findViewById(this.xPZ[j]);
        ViewGroup.LayoutParams localLayoutParams = ((MaskImageView)localObject2).getLayoutParams();
        ((MaskImageView)localObject2).setTag(this);
        if (((bpi)localObject1).mBH != 2) {
          break label820;
        }
        localf = af.dtr();
        m = hashCode();
        localbc = bc.eLK();
        localbc.tGD = this.timeLineObject.CreateTime;
        localf.a((bpi)localObject1, (View)localObject2, -1, m, localbc, 3);
        ((MaskImageView)localObject2).setScaleType(QImageView.a.HBy);
        localLayoutParams.width = k;
        localLayoutParams.height = k;
        if ((i != j) || (((bpi)localObject1).mBH != 2)) {
          break label864;
        }
        ((MaskImageView)localObject2).setVisibility(0);
        ((MaskImageView)localObject2).setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(100036);
            if ((e.this.xwT != null) && (i > 0)) {
              e.this.xwT.sl(e.this.wwP.field_snsId);
            }
            e.this.xta.xUd.onClick(paramAnonymousView);
            AppMethodBeat.o(100036);
          }
        });
        if ((((bpi)localObject1).mBH == 6) && (i == j))
        {
          if (i <= 0) {
            break label880;
          }
          bool1 = true;
          l1 = this.wwP.field_snsId;
          localObject2 = this.xOO.xsm.getLayoutParams();
          ((ViewGroup.LayoutParams)localObject2).width = k;
          ((ViewGroup.LayoutParams)localObject2).height = k;
          this.xOO.xsn.gW(k, k);
          this.xOO.xsm.setVisibility(0);
          af.dtr().a(this.wwP, (bpi)localObject1, this.xOO.xsn, this.context.hashCode(), 0, bc.FzE, this.wwP.Nb(32), true);
          this.xOO.xsn.start();
          this.xOO.xst = true;
          this.xOO.xsu = j;
          this.xOO.xsl = this.timeLineObject;
          this.xOO.position = 0;
          this.xOO.dgg = this.wwP.dxX();
          this.xOO.xsp.setOnClickListener(new View.OnClickListener()
          {
            public final void onClick(View paramAnonymousView)
            {
              AppMethodBeat.i(100037);
              if ((e.this.xwT != null) && (bool1)) {
                e.this.xwT.sl(e.this.wwP.field_snsId);
              }
              e.this.xta.xUd.onClick(paramAnonymousView);
              AppMethodBeat.o(100037);
            }
          });
          this.xOO.xsn.setOnCompletionListener(new b.e()
          {
            public final void c(com.tencent.mm.plugin.sight.decode.a.b paramAnonymousb, int paramAnonymousInt)
            {
              AppMethodBeat.i(100038);
              if (paramAnonymousInt != -1) {
                e.this.xwT.A(l1, this.wxY);
              }
              AppMethodBeat.o(100038);
            }
          });
          if (this.xwT != null)
          {
            if (this.xwT.sj(j + l1)) {
              break label886;
            }
            this.xOO.xsn.setOnDecodeDurationListener(new b.f()
            {
              public final void b(com.tencent.mm.plugin.sight.decode.a.b paramAnonymousb, long paramAnonymousLong)
              {
                AppMethodBeat.i(100039);
                if (paramAnonymousLong >= 3L)
                {
                  int i = (int)paramAnonymousb.dqu();
                  if (e.this.xwT != null)
                  {
                    e.this.xwT.d(l1, bt.GC(), j);
                    e.this.xwT.e(l1, i, j);
                    e.this.xwT.aj(l1, l1 + this.hmM);
                  }
                  e.this.xOO.xsn.setOnDecodeDurationListener(null);
                }
                AppMethodBeat.o(100039);
              }
            });
          }
          this.xOO.a(this.timeLineObject, 0, this.wwP.dxX(), this.wwP.Nb(32));
          this.xOO.xbU.setVisibility(8);
          localObject2 = af.dtr();
          long l2 = System.nanoTime();
          bool2 = f.t((bpi)localObject1);
          ad.i("MicroMsg.TurnCardAdDetailItem", "isMediaSightExist %b duration %s", new Object[] { Boolean.valueOf(bool2), Long.valueOf(System.nanoTime() - l2) });
          if (bool2) {
            break label1107;
          }
          if (!((f)localObject2).w((bpi)localObject1)) {
            break label903;
          }
          this.xOO.xbT.setVisibility(8);
          this.xOO.xsq.setVisibility(0);
          this.xOO.xsq.feJ();
          if (this.xwT != null)
          {
            localObject2 = com.tencent.mm.plugin.sns.model.an.iF(af.getAccSnsPath(), ((bpi)localObject1).Id);
            localObject1 = q.i((bpi)localObject1);
            if (!com.tencent.mm.vfs.i.eK((String)localObject2 + (String)localObject1)) {
              break label1480;
            }
            this.xwT.B(this.wwP.field_snsId, true);
            if (af.dtr().b(this.wwP, null) != 5) {
              break label1498;
            }
          }
        }
      }
      label1107:
      label1498:
      for (boolean bool2 = true;; bool2 = false)
      {
        this.xwT.e(l1, bool2, bool1);
        j += 1;
        break label141;
        i = 0;
        break;
        localf = af.dtr();
        m = hashCode();
        localbc = bc.eLK();
        localbc.tGD = this.timeLineObject.CreateTime;
        localf.a((bpi)localObject1, (View)localObject2, m, localbc);
        break label252;
        label864:
        ((MaskImageView)localObject2).setVisibility(8);
        ((MaskImageView)localObject2).setOnClickListener(null);
        break label306;
        label880:
        bool1 = false;
        break label328;
        label886:
        this.xwT.d(l1, bt.GC(), bool1);
        break label572;
        if (((f)localObject2).b(this.wwP, null) == 5)
        {
          ((f)localObject2).A((bpi)localObject1);
          this.xOO.xbT.setVisibility(8);
          this.xOO.xsq.setVisibility(0);
          this.xOO.xsq.feJ();
          break label709;
        }
        if (((f)localObject2).x((bpi)localObject1))
        {
          this.xOO.xsq.setVisibility(8);
          this.xOO.xbT.setImageResource(2131234034);
          this.xOO.xbT.setVisibility(0);
          break label709;
        }
        ((f)localObject2).y((bpi)localObject1);
        this.xOO.xbT.setVisibility(0);
        this.xOO.xsq.setVisibility(8);
        this.xOO.xbT.setImageDrawable(com.tencent.mm.cd.a.l(this.context, 2131691166));
        this.xOO.xbT.setContentDescription(this.context.getString(2131761939));
        if (((f)localObject2).b(this.wwP, null) != 4) {
          break label709;
        }
        this.xOO.xbU.setVisibility(0);
        break label709;
        if (((f)localObject2).u((bpi)localObject1))
        {
          this.xOO.xbT.setVisibility(0);
          this.xOO.xsq.setVisibility(8);
          this.xOO.xbT.setImageDrawable(com.tencent.mm.cd.a.l(this.context, 2131691166));
          this.xOO.xbT.setContentDescription(this.context.getString(2131761939));
        }
        for (;;)
        {
          if (!this.xOO.xsn.wsq.dqr()) {
            break label1478;
          }
          ad.d("MicroMsg.TurnCardAdDetailItem", "play video error " + ((bpi)localObject1).Id + " " + ((bpi)localObject1).Url + " " + ((bpi)localObject1).DMQ + " 0");
          ((f)localObject2).y((bpi)localObject1);
          this.xOO.xbT.setVisibility(0);
          this.xOO.xsq.setVisibility(8);
          this.xOO.xbT.setImageDrawable(com.tencent.mm.cd.a.l(this.context, 2131691166));
          this.xOO.xbT.setContentDescription(this.context.getString(2131761939));
          break;
          if (((f)localObject2).v((bpi)localObject1))
          {
            this.xOO.xbT.setVisibility(8);
            this.xOO.xsq.setVisibility(8);
          }
          else if (((f)localObject2).b(this.wwP, null) <= 5)
          {
            this.xOO.xbT.setVisibility(8);
            this.xOO.xsq.setVisibility(8);
          }
          else
          {
            ((f)localObject2).y((bpi)localObject1);
            this.xOO.xbT.setVisibility(0);
            this.xOO.xsq.setVisibility(8);
            this.xOO.xbT.setImageDrawable(com.tencent.mm.cd.a.l(this.context, 2131691166));
            this.xOO.xbT.setContentDescription(this.context.getString(2131761939));
          }
        }
        break label709;
        this.xwT.B(this.wwP.field_snsId, false);
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