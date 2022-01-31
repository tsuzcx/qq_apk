package com.tencent.mm.plugin.sns.ui.c.a;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.GradientDrawable.Orientation;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sight.decode.a.b.e;
import com.tencent.mm.plugin.sight.decode.ui.SightPlayImageView;
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.plugin.sns.model.ag;
import com.tencent.mm.plugin.sns.model.ao;
import com.tencent.mm.plugin.sns.storage.b.c;
import com.tencent.mm.plugin.sns.storage.b.c.a;
import com.tencent.mm.plugin.sns.storage.h;
import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.plugin.sns.ui.MaskImageView;
import com.tencent.mm.plugin.sns.ui.aj;
import com.tencent.mm.plugin.sns.ui.widget.SnsDrawGestureView;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.bcs;
import com.tencent.mm.protocal.protobuf.vi;
import com.tencent.mm.sdk.g.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.az;
import com.tencent.mm.ui.widget.MMPinProgressBtn;
import com.tencent.mm.ui.widget.QImageView.a;
import com.tencent.mm.ui.widget.RoundedCornerRelativeLayout;
import com.tencent.mm.vfs.e;
import java.util.LinkedList;

public final class c
  extends a
{
  Context context;
  com.tencent.mm.plugin.sns.a.b.g rOU;
  public View sfT;
  public View sfU;
  private TextView sfV;
  private TextView sfW;
  private TextView sfX;
  private TextView sfY;
  public View sfZ;
  public MaskImageView sga;
  SnsDrawGestureView sgb;
  b.c sgc;
  
  public c(TimeLineObject paramTimeLineObject, n paramn, com.tencent.mm.plugin.sns.ui.d.b paramb, com.tencent.mm.plugin.sns.a.b.g paramg)
  {
    this.timeLineObject = paramTimeLineObject;
    this.rMD = paramn;
    this.rOV = paramb;
    this.rOU = paramg;
  }
  
  public final void g(View paramView1, View paramView2)
  {
    AppMethodBeat.i(40102);
    this.contentView = paramView1;
    this.rOw = paramView2;
    this.context = paramView1.getContext();
    this.sfT = paramView1.findViewById(2131828116);
    this.sfU = paramView1.findViewById(2131828119);
    this.sfV = ((TextView)paramView1.findViewById(2131828117));
    this.sfW = ((TextView)paramView1.findViewById(2131828118));
    this.sfX = ((TextView)paramView1.findViewById(2131828120));
    this.sfY = ((TextView)paramView1.findViewById(2131828121));
    this.sfZ = paramView1.findViewById(2131828122);
    this.sga = ((MaskImageView)paramView1.findViewById(2131828114));
    this.sgb = ((SnsDrawGestureView)paramView1.findViewById(2131828123));
    this.sga.setScaleType(QImageView.a.AED);
    this.sfG = new aj();
    this.sfG.rLE = paramView1.findViewById(2131828115);
    this.sfG.rLD = this.sfG.rLE;
    this.sfG.rLE.setOnClickListener(this.rOV.sjO);
    this.sfG.qVe = ((com.tencent.mm.plugin.sight.decode.a.a)this.sfG.rLE.findViewById(2131820629));
    this.sfG.rwJ = ((ImageView)this.sfG.rLE.findViewById(2131820996));
    this.sfG.rLF = ((MMPinProgressBtn)this.sfG.rLE.findViewById(2131821404));
    this.sfG.rLG = ((TextView)this.sfG.rLE.findViewById(2131827795));
    this.sfG.rwK = ((TextView)this.sfG.rLE.findViewById(2131827796));
    ((SightPlayImageView)this.sfG.qVe).qTZ = true;
    ((SightPlayImageView)this.sfG.qVe).setScaleType(QImageView.a.AED);
    AppMethodBeat.o(40102);
  }
  
  public final void refreshView()
  {
    AppMethodBeat.i(40103);
    this.rMD = h.abu(this.rMD.getSnsId());
    this.sgc = null;
    if ((this.rMD != null) && (this.rMD.csb() != null)) {
      this.sgc = this.rMD.csb().rqI;
    }
    Object localObject1 = null;
    Object localObject2 = (WindowManager)this.context.getSystemService("window");
    int i = Math.min(((WindowManager)localObject2).getDefaultDisplay().getWidth(), ((WindowManager)localObject2).getDefaultDisplay().getHeight());
    this.sfT.setVisibility(8);
    this.sfV.setVisibility(8);
    this.sfW.setVisibility(8);
    this.sfU.setVisibility(8);
    this.sfX.setVisibility(8);
    this.sfY.setVisibility(8);
    this.sfZ.setVisibility(8);
    int j;
    if (this.sgc != null)
    {
      i = i - com.tencent.mm.cb.a.ao(this.context, 2131428700) - com.tencent.mm.cb.a.ao(this.context, 2131427861) - this.context.getResources().getDimensionPixelSize(2131427808) - this.context.getResources().getDimensionPixelSize(2131427808) - this.context.getResources().getDimensionPixelSize(2131427854);
      if (this.sgc.rqV == 0)
      {
        localObject1 = new ViewGroup.LayoutParams(-2, -2);
        ((ViewGroup.LayoutParams)localObject1).width = i;
        ((ViewGroup.LayoutParams)localObject1).height = ((int)(((ViewGroup.LayoutParams)localObject1).width * 0.75F));
        if (localObject1 != null)
        {
          localObject2 = this.contentView.getLayoutParams();
          ((ViewGroup.LayoutParams)localObject2).width = ((ViewGroup.LayoutParams)localObject1).width;
          ((ViewGroup.LayoutParams)localObject2).height = ((ViewGroup.LayoutParams)localObject1).height;
          this.contentView.setLayoutParams((ViewGroup.LayoutParams)localObject2);
          ((RoundedCornerRelativeLayout)this.contentView).setRadius(8.0F);
          localObject2 = this.sga.getLayoutParams();
          ((ViewGroup.LayoutParams)localObject2).width = ((ViewGroup.LayoutParams)localObject1).width;
          ((ViewGroup.LayoutParams)localObject2).height = ((ViewGroup.LayoutParams)localObject1).height;
          this.sga.setLayoutParams((ViewGroup.LayoutParams)localObject2);
          localObject2 = this.sfG.rLD.getLayoutParams();
          ((ViewGroup.LayoutParams)localObject2).width = ((ViewGroup.LayoutParams)localObject1).width;
          ((ViewGroup.LayoutParams)localObject2).height = ((ViewGroup.LayoutParams)localObject1).height;
          this.sfG.rLD.setLayoutParams((ViewGroup.LayoutParams)localObject2);
          this.sfG.qVe.ft(((ViewGroup.LayoutParams)localObject1).width, ((ViewGroup.LayoutParams)localObject1).height);
        }
        if (this.sgc.rqX != 0) {
          break label1009;
        }
        i = Color.argb((int)(this.sgc.rqW * 2.55F), 0, 0, 0);
        j = Color.argb(0, 0, 0, 0);
        localObject1 = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[] { i, j });
        ((GradientDrawable)localObject1).setGradientType(0);
        this.sfT.setBackground((Drawable)localObject1);
        if ((!bo.isNullOrNil(this.sgc.title)) || (!bo.isNullOrNil(this.sgc.description))) {
          this.sfT.setVisibility(0);
        }
        this.sfU.setVisibility(8);
        if (!bo.isNullOrNil(this.sgc.title))
        {
          this.sfV.setVisibility(0);
          localObject1 = this.sfV;
          localObject2 = com.tencent.mm.cd.g.dvk();
          this.sfV.getContext();
          ((TextView)localObject1).setText(((com.tencent.mm.cd.g)localObject2).b(this.sgc.title, this.sfV.getTextSize()));
        }
        if (!bo.isNullOrNil(this.sgc.description))
        {
          this.sfW.setVisibility(0);
          localObject1 = this.sfW;
          localObject2 = com.tencent.mm.cd.g.dvk();
          this.sfW.getContext();
          ((TextView)localObject1).setText(((com.tencent.mm.cd.g)localObject2).b(this.sgc.description, this.sfW.getTextSize()));
        }
        label680:
        if (this.rMD.csd().cqi())
        {
          i = Color.argb((int)(this.sgc.rqW * 2.55F), 0, 0, 0);
          j = Color.argb(0, 0, 0, 0);
          localObject1 = new GradientDrawable(GradientDrawable.Orientation.BOTTOM_TOP, new int[] { i, j });
          ((GradientDrawable)localObject1).setGradientType(0);
          this.sfU.setVisibility(0);
          this.sfU.setBackground((Drawable)localObject1);
          this.sfZ.setVisibility(0);
        }
        label775:
        if ((this.timeLineObject.xTS == null) || (this.timeLineObject.xTS.wOa.size() <= 0)) {
          break label1306;
        }
      }
    }
    final long l1;
    Object localObject3;
    Object localObject4;
    label1306:
    for (localObject1 = (bcs)this.timeLineObject.xTS.wOa.get(0);; localObject1 = null)
    {
      this.sfG.a(this.timeLineObject, 0, this.rMD.csH(), true);
      this.sfG.rwK.setVisibility(8);
      localObject2 = ag.cpc();
      if (localObject1 == null) {
        break label2367;
      }
      l1 = this.rMD.field_snsId;
      if (this.timeLineObject.xTS.wNZ != 1) {
        break label1312;
      }
      this.sga.setVisibility(0);
      this.sga.setTag(this);
      this.sga.setOnClickListener(this.rOV.sjX);
      localObject3 = this.sga;
      i = this.context.hashCode();
      localObject4 = az.dxB();
      ((az)localObject4).oLs = this.timeLineObject.CreateTime;
      ((com.tencent.mm.plugin.sns.model.g)localObject2).a((bcs)localObject1, (View)localObject3, -1, i, (az)localObject4, 3);
      AppMethodBeat.o(40103);
      return;
      if (this.sgc.rqV != 1) {
        break;
      }
      localObject1 = new ViewGroup.LayoutParams(-2, -2);
      ((ViewGroup.LayoutParams)localObject1).width = i;
      ((ViewGroup.LayoutParams)localObject1).height = ((ViewGroup.LayoutParams)localObject1).width;
      break;
      label1009:
      if (this.sgc.rqX != 1) {
        break label680;
      }
      i = Color.argb((int)(this.sgc.rqW * 2.55F), 0, 0, 0);
      j = Color.argb(0, 0, 0, 0);
      localObject1 = new GradientDrawable(GradientDrawable.Orientation.BOTTOM_TOP, new int[] { i, j });
      ((GradientDrawable)localObject1).setGradientType(0);
      this.sfT.setVisibility(8);
      this.sfU.setBackground((Drawable)localObject1);
      if ((!bo.isNullOrNil(this.sgc.title)) || (!bo.isNullOrNil(this.sgc.description)))
      {
        this.sfU.setVisibility(0);
        localObject1 = (RelativeLayout.LayoutParams)this.sfZ.getLayoutParams();
        ((RelativeLayout.LayoutParams)localObject1).topMargin = com.tencent.mm.cb.a.fromDPToPix(this.context, 4);
        this.sfZ.setLayoutParams((ViewGroup.LayoutParams)localObject1);
      }
      if (!bo.isNullOrNil(this.sgc.title))
      {
        this.sfX.setVisibility(0);
        localObject1 = this.sfX;
        localObject2 = com.tencent.mm.cd.g.dvk();
        this.sfX.getContext();
        ((TextView)localObject1).setText(((com.tencent.mm.cd.g)localObject2).b(this.sgc.title, this.sfX.getTextSize()));
      }
      if (bo.isNullOrNil(this.sgc.description)) {
        break label680;
      }
      this.sfY.setVisibility(0);
      localObject1 = this.sfY;
      localObject2 = com.tencent.mm.cd.g.dvk();
      this.sfY.getContext();
      ((TextView)localObject1).setText(((com.tencent.mm.cd.g)localObject2).b(this.sgc.description, this.sfY.getTextSize()));
      break label680;
      ab.e("MicroMsg.FullCardAdDetailItem", "invalid full card");
      break label775;
    }
    label1312:
    if ((this.timeLineObject.xTS.wNZ == 15) || (this.timeLineObject.xTS.wNZ == 5))
    {
      long l2 = System.nanoTime();
      bool = com.tencent.mm.plugin.sns.model.g.t((bcs)localObject1);
      ab.i("MicroMsg.FullCardAdDetailItem", "isMediaSightExist %b duration %s", new Object[] { Boolean.valueOf(bool), Long.valueOf(System.nanoTime() - l2) });
      this.sfG.qVe.setOnCompletionListener(new b.e()
      {
        public final void c(com.tencent.mm.plugin.sight.decode.a.b paramAnonymousb, int paramAnonymousInt)
        {
          AppMethodBeat.i(40094);
          if (paramAnonymousInt != -1) {
            c.this.rOU.v(l1, false);
          }
          AppMethodBeat.o(40094);
        }
      });
      if ((this.rOU != null) && (!this.rOU.lj(l1))) {
        this.sfG.qVe.setOnDecodeDurationListener(new c.2(this, l1));
      }
      localObject3 = this.sgc.rqY;
      localObject4 = this.rMD.csb().cqw();
      if ((!bo.isNullOrNil((String)localObject4)) && (localObject3 != null) && (((b.c.a)localObject3).startTime >= 0L) && (((b.c.a)localObject3).endTime > ((b.c.a)localObject3).startTime)) {
        d.post(new c.3(this, (String)localObject4), "preDownloadFloatPage");
      }
      if (bool) {
        break label1982;
      }
      if (!((com.tencent.mm.plugin.sns.model.g)localObject2).w((bcs)localObject1)) {
        break label1778;
      }
      this.sfG.rwJ.setVisibility(8);
      this.sfG.rLF.setVisibility(0);
      this.sfG.rLF.dOF();
      this.sfG.rLD.setVisibility(0);
      this.sfG.qVe.setTagObject(this.sfG);
      this.sfG.rLE.setTag(this);
      this.sfG.rLD.setOnClickListener(this.rOV.sjX);
      localObject3 = this.rMD;
      localObject4 = this.sfG.qVe;
      i = this.context.hashCode();
      az localaz = az.dxB();
      localaz.oLs = this.timeLineObject.CreateTime;
      ((com.tencent.mm.plugin.sns.model.g)localObject2).a((n)localObject3, (bcs)localObject1, (com.tencent.mm.plugin.sight.decode.a.a)localObject4, i, 0, localaz, true, true);
      localObject2 = ao.gl(ag.getAccSnsPath(), ((bcs)localObject1).Id);
      localObject1 = i.j((bcs)localObject1);
      if (this.rOU != null)
      {
        if (!e.cN((String)localObject2 + (String)localObject1)) {
          break label2349;
        }
        this.rOU.w(l1, true);
        label1743:
        if (ag.cpc().b(this.rMD, null) != 5) {
          break label2361;
        }
      }
    }
    label2347:
    label2349:
    label2361:
    for (boolean bool = true;; bool = false)
    {
      this.rOU.c(l1, bool, false);
      AppMethodBeat.o(40103);
      return;
      label1778:
      if (((com.tencent.mm.plugin.sns.model.g)localObject2).b(this.rMD, null) == 5)
      {
        ((com.tencent.mm.plugin.sns.model.g)localObject2).A((bcs)localObject1);
        this.sfG.rwJ.setVisibility(8);
        this.sfG.rLF.setVisibility(0);
        this.sfG.rLF.dOF();
        break;
      }
      if (((com.tencent.mm.plugin.sns.model.g)localObject2).x((bcs)localObject1))
      {
        this.sfG.rLF.setVisibility(8);
        this.sfG.rwJ.setImageResource(2130840321);
        this.sfG.rwJ.setVisibility(0);
        break;
      }
      ((com.tencent.mm.plugin.sns.model.g)localObject2).y((bcs)localObject1);
      this.sfG.rwJ.setVisibility(0);
      this.sfG.rLF.setVisibility(8);
      this.sfG.rwJ.setImageDrawable(com.tencent.mm.cb.a.k(this.context, 2131231980));
      this.sfG.rwJ.setContentDescription(this.context.getString(2131302100));
      if (((com.tencent.mm.plugin.sns.model.g)localObject2).b(this.rMD, null) != 4) {
        break;
      }
      this.sfG.rwK.setVisibility(0);
      break;
      label1982:
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
          break label2347;
        }
        ab.d("MicroMsg.FullCardAdDetailItem", "play video error " + ((bcs)localObject1).Id + " " + ((bcs)localObject1).Url + " " + ((bcs)localObject1).xrS);
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
      break;
      this.rOU.w(l1, false);
      break label1743;
    }
    label2367:
    ((com.tencent.mm.plugin.sns.model.g)localObject2).a(this.sfG.qVe, this.context.hashCode());
    this.sfG.rLG.setVisibility(8);
    this.sfG.qVe.setOnSightCompletionAction(null);
    this.sfG.qVe.setOnCompletionListener(null);
    this.sfG.qVe.setOnDecodeDurationListener(null);
    AppMethodBeat.o(40103);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.c.a.c
 * JD-Core Version:    0.7.0.1
 */