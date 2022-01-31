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
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sight.decode.ui.SightPlayImageView;
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.plugin.sns.model.ag;
import com.tencent.mm.plugin.sns.model.ao;
import com.tencent.mm.plugin.sns.storage.b.f;
import com.tencent.mm.plugin.sns.storage.b.i;
import com.tencent.mm.plugin.sns.storage.h;
import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.plugin.sns.ui.MaskImageView;
import com.tencent.mm.plugin.sns.ui.aj;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.bcs;
import com.tencent.mm.protocal.protobuf.vi;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.az;
import com.tencent.mm.ui.widget.MMPinProgressBtn;
import com.tencent.mm.ui.widget.QImageView.a;
import com.tencent.mm.ui.widget.RoundedCornerRelativeLayout;
import java.util.LinkedList;
import java.util.List;

public final class e
  extends a
{
  Context context;
  public int currentIndex;
  com.tencent.mm.plugin.sns.a.b.g rOU;
  boolean sdt;
  public View sgw;
  public View sgx;
  private int[] sgy;
  private final int sgz;
  
  public e(TimeLineObject paramTimeLineObject, n paramn, com.tencent.mm.plugin.sns.ui.d.b paramb, com.tencent.mm.plugin.sns.a.b.g paramg)
  {
    AppMethodBeat.i(40109);
    this.sdt = false;
    this.sgy = new int[] { 2131828155, 2131828156 };
    this.sgz = 2131828157;
    this.timeLineObject = paramTimeLineObject;
    this.rMD = paramn;
    this.rOV = paramb;
    this.rOU = paramg;
    AppMethodBeat.o(40109);
  }
  
  private View a(bcs parambcs, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(40113);
    int[] arrayOfInt = new int[2];
    int[] tmp12_10 = arrayOfInt;
    tmp12_10[0] = 2131828155;
    int[] tmp17_12 = tmp12_10;
    tmp17_12[1] = 2131828156;
    tmp17_12;
    if (paramBoolean)
    {
      parambcs = this.contentView.findViewById(arrayOfInt[paramInt]);
      AppMethodBeat.o(40113);
      return parambcs;
    }
    if (parambcs.jKs == 6)
    {
      parambcs = this.contentView.findViewById(2131828157);
      AppMethodBeat.o(40113);
      return parambcs;
    }
    if (parambcs.jKs == 2)
    {
      parambcs = this.contentView.findViewById(arrayOfInt[paramInt]);
      AppMethodBeat.o(40113);
      return parambcs;
    }
    AppMethodBeat.o(40113);
    return null;
  }
  
  final void Fi(int paramInt)
  {
    AppMethodBeat.i(40111);
    if ((this.sgx == null) || (this.sgw == null))
    {
      AppMethodBeat.o(40111);
      return;
    }
    this.currentIndex = paramInt;
    this.sgx.setVisibility(8);
    this.sgw.setVisibility(8);
    ((TextView)this.contentView.findViewById(2131828159)).setText(null);
    ((TextView)this.contentView.findViewById(2131828162)).setText(null);
    ((TextView)this.contentView.findViewById(2131828160)).setText(null);
    ((TextView)this.contentView.findViewById(2131828163)).setText(null);
    Object localObject2 = { 2131828162, 2131828163 };
    Object localObject3 = { 2131828159, 2131828163 };
    Object localObject1 = this.rMD.csb();
    if ((((com.tencent.mm.plugin.sns.storage.b)localObject1).rqH != null) && (((com.tencent.mm.plugin.sns.storage.b)localObject1).rqH.rrj != null) && (((com.tencent.mm.plugin.sns.storage.b)localObject1).rqH.rrj.size() >= 2))
    {
      localObject1 = (b.i)((com.tencent.mm.plugin.sns.storage.b)localObject1).rqH.rrj.get(paramInt);
      if ((((b.i)localObject1).rqV >= 0) && (((b.i)localObject1).rqV < 3))
      {
        paramInt = ((b.i)localObject1).rqV;
        localObject3 = new int[][] { localObject2, { 2131828159, 2131828160 }, localObject3 }[paramInt];
        localObject2 = (TextView)this.contentView.findViewById(localObject3[0]);
        localObject3 = (TextView)this.contentView.findViewById(localObject3[1]);
        if (!bo.isNullOrNil(((b.i)localObject1).title)) {
          break label345;
        }
        ((TextView)localObject2).setVisibility(8);
        if (!bo.isNullOrNil(((b.i)localObject1).desc)) {
          break label361;
        }
        ((TextView)localObject3).setVisibility(8);
      }
    }
    for (;;)
    {
      ((View)((TextView)localObject2).getParent()).setVisibility(0);
      ((View)((TextView)localObject3).getParent()).setVisibility(0);
      AppMethodBeat.o(40111);
      return;
      label345:
      ((TextView)localObject2).setVisibility(0);
      ((TextView)localObject2).setText(((b.i)localObject1).title);
      break;
      label361:
      ((TextView)localObject3).setVisibility(0);
      ((TextView)localObject3).setText(((b.i)localObject1).desc);
    }
  }
  
  public final void cwU()
  {
    AppMethodBeat.i(40112);
    int i;
    Object localObject1;
    label130:
    label136:
    Object localObject2;
    Object localObject3;
    float f1;
    float f2;
    int k;
    if (this.timeLineObject.xTS.wOa.size() >= 2)
    {
      long l;
      if (this.rMD.field_likeFlag == 1)
      {
        i = 1;
        if ((this.rOU != null) && (((bcs)this.timeLineObject.xTS.wOa.get(i)).jKs == 6))
        {
          localObject1 = this.rOU;
          l = this.rMD.field_snsId;
          if (this.rMD.field_likeFlag != 1) {
            break label130;
          }
        }
      }
      for (boolean bool = true;; bool = false)
      {
        ((com.tencent.mm.plugin.sns.a.b.g)localObject1).y(l, bool);
        if (!this.sdt) {
          break label136;
        }
        ab.i("MicroMsg.TurnCardAdDetailItem", "isPlayAnimation, return");
        AppMethodBeat.o(40112);
        return;
        i = 0;
        break;
      }
      if (this.rMD.field_likeFlag != 1) {
        break label399;
      }
      i = 0;
      j = 1;
      localObject1 = (bcs)this.timeLineObject.xTS.wOa.get(j);
      localObject2 = (bcs)this.timeLineObject.xTS.wOa.get(i);
      localObject1 = a((bcs)localObject1, j, false);
      localObject2 = a((bcs)localObject2, i, true);
      j = ((WindowManager)this.context.getSystemService("window")).getDefaultDisplay().getWidth();
      localObject3 = new int[2];
      this.contentView.getLocationOnScreen((int[])localObject3);
      f1 = j / 2 - localObject3[1];
      this.contentView.setPivotY(f1);
      this.contentView.setCameraDistance(8000.0F);
      f1 = this.contentView.getWidth() / 2.0F;
      f2 = this.contentView.getHeight() / 2.0F;
      if (this.rMD.field_likeFlag != 1) {
        break label407;
      }
      k = -90;
    }
    for (int j = 90;; j = -90)
    {
      localObject3 = new com.tencent.mm.plugin.sns.ui.widget.a(this.context, 0.0F, j, f1, f2, true);
      ((com.tencent.mm.plugin.sns.ui.widget.a)localObject3).setDuration(187L);
      ((com.tencent.mm.plugin.sns.ui.widget.a)localObject3).setInterpolator(new AccelerateInterpolator());
      ((com.tencent.mm.plugin.sns.ui.widget.a)localObject3).setAnimationListener(new e.2(this, (View)localObject2, (View)localObject1, i, k, f1, f2));
      this.contentView.startAnimation((Animation)localObject3);
      this.sdt = true;
      AppMethodBeat.o(40112);
      return;
      label399:
      i = 1;
      j = 0;
      break;
      label407:
      k = 90;
    }
  }
  
  public final void g(View paramView1, View paramView2)
  {
    AppMethodBeat.i(40110);
    this.contentView = paramView1;
    this.rOw = paramView2;
    this.context = paramView1.getContext();
    paramView2 = (WindowManager)this.context.getSystemService("window");
    int j = Math.min(paramView2.getDefaultDisplay().getWidth(), paramView2.getDefaultDisplay().getHeight()) - com.tencent.mm.cb.a.ao(this.context, 2131428700) - com.tencent.mm.cb.a.ao(this.context, 2131427861) - this.context.getResources().getDimensionPixelSize(2131427808) - this.context.getResources().getDimensionPixelSize(2131427808) - this.context.getResources().getDimensionPixelSize(2131427854);
    paramView2 = (LinearLayout.LayoutParams)paramView1.getLayoutParams();
    paramView2.topMargin = this.context.getResources().getDimensionPixelOffset(2131427792);
    paramView2.bottomMargin = 0;
    paramView2.width = j;
    paramView2.height = j;
    paramView1.setLayoutParams(paramView2);
    ((RoundedCornerRelativeLayout)paramView1).setRadius(8.0F);
    if ((paramView1.getParent() instanceof ViewGroup))
    {
      ((ViewGroup)paramView1.getParent()).setClipChildren(false);
      ((ViewGroup)paramView1.getParent()).setClipToPadding(false);
    }
    paramView2 = this.sgy;
    int k = paramView2.length;
    int i = 0;
    while (i < k)
    {
      MaskImageView localMaskImageView = (MaskImageView)paramView1.findViewById(paramView2[i]);
      localMaskImageView.setVisibility(8);
      localMaskImageView.setOnTouchListener(new e.1(this));
      i += 1;
    }
    paramView2 = paramView1.findViewById(this.sgz);
    paramView2.setBackground(null);
    paramView2.setVisibility(8);
    ((ViewGroup)paramView2).setClipChildren(false);
    this.sfG = new aj();
    this.sfG.rLE = paramView2;
    this.sfG.rLD = this.sfG.rLE;
    this.sfG.qVe = ((com.tencent.mm.plugin.sight.decode.a.a)this.sfG.rLE.findViewById(2131820629));
    this.sfG.rwJ = ((ImageView)this.sfG.rLE.findViewById(2131820996));
    this.sfG.rLF = ((MMPinProgressBtn)this.sfG.rLE.findViewById(2131821404));
    this.sfG.rLG = ((TextView)this.sfG.rLE.findViewById(2131827795));
    this.sfG.rwK = ((TextView)this.sfG.rLE.findViewById(2131827796));
    this.sfG.rLE.setTag(this);
    this.sfG.rLE.setOnClickListener(null);
    ((SightPlayImageView)this.sfG.qVe).qTZ = true;
    ((SightPlayImageView)this.sfG.qVe).setScaleType(QImageView.a.AED);
    this.sfG.qVe.ft(j, j);
    paramView1.setLayerType(2, null);
    this.sgx = paramView1.findViewById(2131828158);
    this.sgw = paramView1.findViewById(2131828161);
    Fi(0);
    AppMethodBeat.o(40110);
  }
  
  public final void refreshView()
  {
    AppMethodBeat.i(40114);
    this.rMD = h.abu(this.rMD.getSnsId());
    ab.i("MicroMsg.TurnCardAdDetailItem", "refresh view");
    int k = ((WindowManager)this.context.getSystemService("window")).getDefaultDisplay().getWidth() - com.tencent.mm.cb.a.fromDPToPix(this.context, 50) - this.context.getResources().getDimensionPixelSize(2131427808) - this.context.getResources().getDimensionPixelSize(2131427808) - this.context.getResources().getDimensionPixelSize(2131427854);
    label141:
    label306:
    label567:
    label704:
    label1472:
    label1474:
    if (this.rMD.csh().xTS.wOa.size() >= 2)
    {
      final int i;
      int j;
      Object localObject1;
      Object localObject2;
      com.tencent.mm.plugin.sns.model.g localg;
      int m;
      az localaz;
      label252:
      boolean bool1;
      label328:
      long l1;
      if (this.rMD.field_likeFlag == 1)
      {
        i = 1;
        Fi(i);
        j = 0;
        if (j >= 2) {
          break label1498;
        }
        localObject1 = (bcs)this.rMD.csh().xTS.wOa.get(j);
        localObject2 = (MaskImageView)this.contentView.findViewById(this.sgy[j]);
        ViewGroup.LayoutParams localLayoutParams = ((MaskImageView)localObject2).getLayoutParams();
        ((MaskImageView)localObject2).setTag(this);
        if (((bcs)localObject1).jKs != 2) {
          break label815;
        }
        localg = ag.cpc();
        m = hashCode();
        localaz = az.dxF();
        localaz.oLs = this.timeLineObject.CreateTime;
        localg.a((bcs)localObject1, (View)localObject2, -1, m, localaz, 3);
        ((MaskImageView)localObject2).setScaleType(QImageView.a.AED);
        localLayoutParams.width = k;
        localLayoutParams.height = k;
        if ((i != j) || (((bcs)localObject1).jKs != 2)) {
          break label859;
        }
        ((MaskImageView)localObject2).setVisibility(0);
        ((MaskImageView)localObject2).setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(40105);
            if ((e.this.rOU != null) && (i > 0)) {
              e.this.rOU.ll(e.this.rMD.field_snsId);
            }
            e.this.rOV.sjX.onClick(paramAnonymousView);
            AppMethodBeat.o(40105);
          }
        });
        if ((((bcs)localObject1).jKs == 6) && (i == j))
        {
          if (i <= 0) {
            break label875;
          }
          bool1 = true;
          l1 = this.rMD.field_snsId;
          localObject2 = this.sfG.rLD.getLayoutParams();
          ((ViewGroup.LayoutParams)localObject2).width = k;
          ((ViewGroup.LayoutParams)localObject2).height = k;
          this.sfG.qVe.ft(k, k);
          this.sfG.rLD.setVisibility(0);
          ag.cpc().a(this.rMD, (bcs)localObject1, this.sfG.qVe, this.context.hashCode(), 0, az.yNT, this.rMD.Ex(32), true);
          this.sfG.rLI = true;
          this.sfG.rLJ = j;
          this.sfG.rLC = this.timeLineObject;
          this.sfG.position = 0;
          this.sfG.crk = this.rMD.csH();
          this.sfG.rLE.setOnClickListener(new e.4(this, bool1));
          this.sfG.qVe.setOnCompletionListener(new e.5(this, l1, bool1));
          if (this.rOU != null)
          {
            if (this.rOU.lj(j + l1)) {
              break label881;
            }
            this.sfG.qVe.setOnDecodeDurationListener(new e.6(this, l1, bool1, j));
          }
          this.sfG.a(this.timeLineObject, 0, this.rMD.csH(), this.rMD.Ex(32));
          this.sfG.rwK.setVisibility(8);
          localObject2 = ag.cpc();
          long l2 = System.nanoTime();
          bool2 = com.tencent.mm.plugin.sns.model.g.t((bcs)localObject1);
          ab.i("MicroMsg.TurnCardAdDetailItem", "isMediaSightExist %b duration %s", new Object[] { Boolean.valueOf(bool2), Long.valueOf(System.nanoTime() - l2) });
          if (bool2) {
            break label1102;
          }
          if (!((com.tencent.mm.plugin.sns.model.g)localObject2).w((bcs)localObject1)) {
            break label898;
          }
          this.sfG.rwJ.setVisibility(8);
          this.sfG.rLF.setVisibility(0);
          this.sfG.rLF.dOF();
          if (this.rOU != null)
          {
            localObject2 = ao.gl(ag.getAccSnsPath(), ((bcs)localObject1).Id);
            localObject1 = i.j((bcs)localObject1);
            if (!com.tencent.mm.vfs.e.cN((String)localObject2 + (String)localObject1)) {
              break label1474;
            }
            this.rOU.w(this.rMD.field_snsId, true);
            if (ag.cpc().b(this.rMD, null) != 5) {
              break label1492;
            }
          }
        }
      }
      label1102:
      label1492:
      for (boolean bool2 = true;; bool2 = false)
      {
        this.rOU.c(l1, bool2, bool1);
        j += 1;
        break label141;
        i = 0;
        break;
        localg = ag.cpc();
        m = hashCode();
        localaz = az.dxF();
        localaz.oLs = this.timeLineObject.CreateTime;
        localg.a((bcs)localObject1, (View)localObject2, m, localaz);
        break label252;
        label859:
        ((MaskImageView)localObject2).setVisibility(8);
        ((MaskImageView)localObject2).setOnClickListener(null);
        break label306;
        label875:
        bool1 = false;
        break label328;
        label881:
        this.rOU.c(l1, bo.yB(), bool1);
        break label567;
        if (((com.tencent.mm.plugin.sns.model.g)localObject2).b(this.rMD, null) == 5)
        {
          ((com.tencent.mm.plugin.sns.model.g)localObject2).A((bcs)localObject1);
          this.sfG.rwJ.setVisibility(8);
          this.sfG.rLF.setVisibility(0);
          this.sfG.rLF.dOF();
          break label704;
        }
        if (((com.tencent.mm.plugin.sns.model.g)localObject2).x((bcs)localObject1))
        {
          this.sfG.rLF.setVisibility(8);
          this.sfG.rwJ.setImageResource(2130840321);
          this.sfG.rwJ.setVisibility(0);
          break label704;
        }
        ((com.tencent.mm.plugin.sns.model.g)localObject2).y((bcs)localObject1);
        this.sfG.rwJ.setVisibility(0);
        this.sfG.rLF.setVisibility(8);
        this.sfG.rwJ.setImageDrawable(com.tencent.mm.cb.a.k(this.context, 2131231980));
        this.sfG.rwJ.setContentDescription(this.context.getString(2131302100));
        if (((com.tencent.mm.plugin.sns.model.g)localObject2).b(this.rMD, null) != 4) {
          break label704;
        }
        this.sfG.rwK.setVisibility(0);
        break label704;
        if (((com.tencent.mm.plugin.sns.model.g)localObject2).u((bcs)localObject1))
        {
          this.sfG.rwJ.setVisibility(0);
          this.sfG.rLF.setVisibility(8);
          this.sfG.rwJ.setImageDrawable(com.tencent.mm.cb.a.k(this.context, 2131231980));
          this.sfG.rwJ.setContentDescription(this.context.getString(2131302100));
        }
        for (;;)
        {
          if (!this.sfG.qVe.cmy()) {
            break label1472;
          }
          ab.d("MicroMsg.TurnCardAdDetailItem", "play video error " + ((bcs)localObject1).Id + " " + ((bcs)localObject1).Url + " " + ((bcs)localObject1).xrS + " 0");
          ((com.tencent.mm.plugin.sns.model.g)localObject2).y((bcs)localObject1);
          this.sfG.rwJ.setVisibility(0);
          this.sfG.rLF.setVisibility(8);
          this.sfG.rwJ.setImageDrawable(com.tencent.mm.cb.a.k(this.context, 2131231980));
          this.sfG.rwJ.setContentDescription(this.context.getString(2131302100));
          break;
          if (((com.tencent.mm.plugin.sns.model.g)localObject2).v((bcs)localObject1))
          {
            this.sfG.rwJ.setVisibility(8);
            this.sfG.rLF.setVisibility(8);
          }
          else if (((com.tencent.mm.plugin.sns.model.g)localObject2).b(this.rMD, null) <= 5)
          {
            this.sfG.rwJ.setVisibility(8);
            this.sfG.rLF.setVisibility(8);
          }
          else
          {
            ((com.tencent.mm.plugin.sns.model.g)localObject2).y((bcs)localObject1);
            this.sfG.rwJ.setVisibility(0);
            this.sfG.rLF.setVisibility(8);
            this.sfG.rwJ.setImageDrawable(com.tencent.mm.cb.a.k(this.context, 2131231980));
            this.sfG.rwJ.setContentDescription(this.context.getString(2131302100));
          }
        }
        break label704;
        this.rOU.w(this.rMD.field_snsId, false);
        break label772;
      }
    }
    label772:
    label815:
    label1498:
    AppMethodBeat.o(40114);
    label898:
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.c.a.e
 * JD-Core Version:    0.7.0.1
 */