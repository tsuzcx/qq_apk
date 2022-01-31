package com.tencent.mm.plugin.sns.ui.item;

import android.app.Activity;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.GradientDrawable.Orientation;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewStub;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sight.decode.ui.SightPlayImageView;
import com.tencent.mm.plugin.sns.model.ag;
import com.tencent.mm.plugin.sns.model.ao;
import com.tencent.mm.plugin.sns.storage.b.c;
import com.tencent.mm.plugin.sns.storage.b.c.a;
import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.plugin.sns.ui.MaskImageView;
import com.tencent.mm.plugin.sns.ui.aj;
import com.tencent.mm.plugin.sns.ui.av;
import com.tencent.mm.plugin.sns.ui.aw;
import com.tencent.mm.plugin.sns.ui.widget.SnsDrawGestureView;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.bcs;
import com.tencent.mm.protocal.protobuf.vi;
import com.tencent.mm.sdk.g.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.az;
import com.tencent.mm.ui.widget.MMPinProgressBtn;
import com.tencent.mm.ui.widget.QImageView.a;
import com.tencent.mm.ui.widget.RoundedCornerRelativeLayout;
import com.tencent.mm.vfs.e;
import java.util.LinkedList;

public final class c
  extends BaseTimeLineItem
{
  private void a(c.a parama)
  {
    AppMethodBeat.i(40145);
    al.d(new c.5(this, parama));
    AppMethodBeat.o(40145);
  }
  
  public final void a(BaseTimeLineItem.BaseViewHolder paramBaseViewHolder, int paramInt1, aw paramaw, TimeLineObject paramTimeLineObject, int paramInt2, av paramav)
  {
    AppMethodBeat.i(40144);
    ab.i("MicroMsg.FullCardAdTimeLineItem", "fill full card ad item %d", new Object[] { Integer.valueOf(paramInt1) });
    if (paramBaseViewHolder.ezJ)
    {
      ab.i("MicroMsg.FullCardAdTimeLineItem", "holder is busy");
      AppMethodBeat.o(40144);
      return;
    }
    c.a locala = (c.a)paramBaseViewHolder;
    n localn = paramaw.qXp;
    Object localObject1 = null;
    Object localObject2 = localObject1;
    if (localn != null)
    {
      localObject2 = localObject1;
      if (localn.csb() != null) {
        localObject2 = localn.csb().rqI;
      }
    }
    localObject1 = (WindowManager)this.mActivity.getSystemService("window");
    paramInt2 = Math.min(((WindowManager)localObject1).getDefaultDisplay().getWidth(), ((WindowManager)localObject1).getDefaultDisplay().getHeight());
    locala.sfT.setVisibility(8);
    locala.sfV.setVisibility(8);
    locala.sfW.setVisibility(8);
    locala.sfU.setVisibility(8);
    locala.sfX.setVisibility(8);
    locala.sfY.setVisibility(8);
    locala.sfZ.setVisibility(8);
    c.a.b(locala).setVisibility(8);
    locala.sfG.qVe.setOnCompletionListener(null);
    locala.sfG.qVe.setOnDecodeDurationListener(null);
    a(locala);
    if (localObject2 != null)
    {
      paramInt2 = paramInt2 - com.tencent.mm.cb.a.fromDPToPix(this.mActivity, 54) - this.mActivity.getResources().getDimensionPixelSize(2131427782) - this.mActivity.getResources().getDimensionPixelSize(2131427808) - this.mActivity.getResources().getDimensionPixelSize(2131427854);
      if (((b.c)localObject2).rqV == 0)
      {
        localObject1 = new ViewGroup.LayoutParams(-2, -2);
        ((ViewGroup.LayoutParams)localObject1).width = paramInt2;
        ((ViewGroup.LayoutParams)localObject1).height = ((int)(((ViewGroup.LayoutParams)localObject1).width * 0.75F));
      }
    }
    for (;;)
    {
      Object localObject3;
      if (localObject1 != null)
      {
        localObject3 = locala.rMB.getLayoutParams();
        ((ViewGroup.LayoutParams)localObject3).width = ((ViewGroup.LayoutParams)localObject1).width;
        ((ViewGroup.LayoutParams)localObject3).height = ((ViewGroup.LayoutParams)localObject1).height;
        locala.rMB.setLayoutParams((ViewGroup.LayoutParams)localObject3);
        ((RoundedCornerRelativeLayout)locala.rMB).setRadius(8.0F);
        localObject3 = locala.sga.getLayoutParams();
        ((ViewGroup.LayoutParams)localObject3).width = ((ViewGroup.LayoutParams)localObject1).width;
        ((ViewGroup.LayoutParams)localObject3).height = ((ViewGroup.LayoutParams)localObject1).height;
        locala.sga.setLayoutParams((ViewGroup.LayoutParams)localObject3);
        localObject3 = locala.sfG.rLD.getLayoutParams();
        ((ViewGroup.LayoutParams)localObject3).width = ((ViewGroup.LayoutParams)localObject1).width;
        ((ViewGroup.LayoutParams)localObject3).height = ((ViewGroup.LayoutParams)localObject1).height;
        locala.sfG.rLD.setLayoutParams((ViewGroup.LayoutParams)localObject3);
        locala.sfG.qVe.ft(((ViewGroup.LayoutParams)localObject1).width, ((ViewGroup.LayoutParams)localObject1).height);
      }
      int i;
      if (((b.c)localObject2).rqX == 0)
      {
        paramInt2 = Color.argb((int)(((b.c)localObject2).rqW * 2.55F), 0, 0, 0);
        i = Color.argb(0, 0, 0, 0);
        localObject1 = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[] { paramInt2, i });
        ((GradientDrawable)localObject1).setGradientType(0);
        locala.sfT.setBackground((Drawable)localObject1);
        if ((!bo.isNullOrNil(((b.c)localObject2).title)) || (!bo.isNullOrNil(((b.c)localObject2).description))) {
          locala.sfT.setVisibility(0);
        }
        if (!bo.isNullOrNil(((b.c)localObject2).title))
        {
          locala.sfV.setVisibility(0);
          localObject1 = locala.sfV;
          localObject3 = com.tencent.mm.cd.g.dvk();
          locala.sfV.getContext();
          ((TextView)localObject1).setText(((com.tencent.mm.cd.g)localObject3).b(((b.c)localObject2).title, locala.sfV.getTextSize()));
        }
        if (!bo.isNullOrNil(((b.c)localObject2).description))
        {
          locala.sfW.setVisibility(0);
          localObject1 = locala.sfW;
          localObject3 = com.tencent.mm.cd.g.dvk();
          locala.sfW.getContext();
          ((TextView)localObject1).setText(((com.tencent.mm.cd.g)localObject3).b(((b.c)localObject2).description, locala.sfW.getTextSize()));
        }
        label747:
        if (localn.csd().cqi())
        {
          paramInt2 = Color.argb((int)(((b.c)localObject2).rqW * 2.55F), 0, 0, 0);
          i = Color.argb(0, 0, 0, 0);
          localObject1 = new GradientDrawable(GradientDrawable.Orientation.BOTTOM_TOP, new int[] { paramInt2, i });
          ((GradientDrawable)localObject1).setGradientType(0);
          locala.sfU.setVisibility(0);
          locala.sfU.setBackground((Drawable)localObject1);
          locala.sfZ.setVisibility(0);
        }
        label845:
        if ((paramTimeLineObject.xTS == null) || (paramTimeLineObject.xTS.wOa.size() <= 0)) {
          break label1363;
        }
      }
      label1363:
      for (localObject1 = (bcs)paramTimeLineObject.xTS.wOa.get(0);; localObject1 = null)
      {
        paramBaseViewHolder.sfG.a(paramTimeLineObject, paramInt1, paramaw.rGx, paramaw.rEX);
        paramBaseViewHolder.sfG.rwK.setVisibility(8);
        localObject3 = ag.cpc();
        if (localObject1 == null) {
          break label2366;
        }
        if (paramTimeLineObject.xTS.wNZ != 1) {
          break label1369;
        }
        locala.sga.setVisibility(0);
        locala.sfG.rLD.setVisibility(4);
        paramaw = locala.sga;
        paramInt1 = this.mActivity.hashCode();
        localObject2 = az.dxB();
        ((az)localObject2).oLs = paramTimeLineObject.CreateTime;
        ((com.tencent.mm.plugin.sns.model.g)localObject3).b((bcs)localObject1, paramaw, -1, paramInt1, (az)localObject2);
        locala.sga.setTag(paramBaseViewHolder);
        locala.sga.setOnClickListener(paramav.rks.sjX);
        AppMethodBeat.o(40144);
        return;
        if (((b.c)localObject2).rqV != 1) {
          break label2443;
        }
        localObject1 = new ViewGroup.LayoutParams(-2, -2);
        ((ViewGroup.LayoutParams)localObject1).width = paramInt2;
        ((ViewGroup.LayoutParams)localObject1).height = ((ViewGroup.LayoutParams)localObject1).width;
        break;
        if (((b.c)localObject2).rqX != 1) {
          break label747;
        }
        paramInt2 = Color.argb((int)(((b.c)localObject2).rqW * 2.55F), 0, 0, 0);
        i = Color.argb(0, 0, 0, 0);
        localObject1 = new GradientDrawable(GradientDrawable.Orientation.BOTTOM_TOP, new int[] { paramInt2, i });
        ((GradientDrawable)localObject1).setGradientType(0);
        locala.sfU.setBackground((Drawable)localObject1);
        if ((!bo.isNullOrNil(((b.c)localObject2).title)) || (!bo.isNullOrNil(((b.c)localObject2).description)))
        {
          locala.sfU.setVisibility(0);
          localObject1 = (RelativeLayout.LayoutParams)locala.sfZ.getLayoutParams();
          ((RelativeLayout.LayoutParams)localObject1).topMargin = com.tencent.mm.cb.a.fromDPToPix(locala.rMB.getContext(), 4);
          locala.sfZ.setLayoutParams((ViewGroup.LayoutParams)localObject1);
        }
        if (!bo.isNullOrNil(((b.c)localObject2).title))
        {
          locala.sfX.setVisibility(0);
          localObject1 = locala.sfX;
          localObject3 = com.tencent.mm.cd.g.dvk();
          locala.sfX.getContext();
          ((TextView)localObject1).setText(((com.tencent.mm.cd.g)localObject3).b(((b.c)localObject2).title, locala.sfX.getTextSize()));
        }
        if (bo.isNullOrNil(((b.c)localObject2).description)) {
          break label747;
        }
        locala.sfY.setVisibility(0);
        localObject1 = locala.sfY;
        localObject3 = com.tencent.mm.cd.g.dvk();
        locala.sfY.getContext();
        ((TextView)localObject1).setText(((com.tencent.mm.cd.g)localObject3).b(((b.c)localObject2).description, locala.sfY.getTextSize()));
        break label747;
        ab.e("MicroMsg.FullCardAdTimeLineItem", "invalid full card");
        break label845;
      }
      label1369:
      if ((paramTimeLineObject.xTS.wNZ == 15) || (paramTimeLineObject.xTS.wNZ == 5))
      {
        locala.sfG.qVe.setOnCompletionListener(new c.1(this, paramav, paramaw));
        locala.sfG.qVe.setOnDecodeDurationListener(new c.2(this, paramav, paramaw, locala, (b.c)localObject2, localn));
        localObject2 = ((b.c)localObject2).rqY;
        String str = localn.csb().cqw();
        if ((!bo.isNullOrNil(str)) && (localObject2 != null) && (((b.c.a)localObject2).startTime >= 0L) && (((b.c.a)localObject2).endTime > ((b.c.a)localObject2).startTime)) {
          d.post(new c.3(this, str), "preDownloadFloatPage");
        }
        long l = System.nanoTime();
        boolean bool = com.tencent.mm.plugin.sns.model.g.t((bcs)localObject1);
        ab.i("MicroMsg.FullCardAdTimeLineItem", "isMediaSightExist %b duration %s", new Object[] { Boolean.valueOf(bool), Long.valueOf(System.nanoTime() - l) });
        localObject2 = locala.sfG;
        if (!bool) {
          if (((com.tencent.mm.plugin.sns.model.g)localObject3).w((bcs)localObject1))
          {
            ((aj)localObject2).rwJ.setVisibility(8);
            ((aj)localObject2).rLF.setVisibility(0);
            ((aj)localObject2).rLF.dOF();
            locala.sfG.rLD.setVisibility(0);
            locala.sga.setVisibility(4);
            ((aj)localObject2).qVe.setTagObject(localObject2);
            ((aj)localObject2).rLE.setTag(paramBaseViewHolder);
            locala.sfG.rLD.setOnClickListener(paramav.rks.sjX);
            paramBaseViewHolder = ((aj)localObject2).qVe;
            paramInt2 = this.mActivity.hashCode();
            localObject2 = az.dxB();
            ((az)localObject2).oLs = paramTimeLineObject.CreateTime;
            ((com.tencent.mm.plugin.sns.model.g)localObject3).a(localn, (bcs)localObject1, paramBaseViewHolder, paramInt2, paramInt1, (az)localObject2, paramaw.rEX, true);
            paramBaseViewHolder = ao.gl(ag.getAccSnsPath(), ((bcs)localObject1).Id);
            paramTimeLineObject = com.tencent.mm.plugin.sns.data.i.j((bcs)localObject1);
            if (!e.cN(paramBaseViewHolder + paramTimeLineObject)) {
              break label2341;
            }
            paramav.rWP.rFk.w(paramaw.rZw, true);
            label1783:
            if (ag.cpc().b(localn, null) != 5) {
              break label2360;
            }
          }
        }
        for (bool = true;; bool = false)
        {
          paramav.rWP.rFk.c(paramaw.rZw, bool, false);
          AppMethodBeat.o(40144);
          return;
          if (((com.tencent.mm.plugin.sns.model.g)localObject3).b(localn, null) == 5)
          {
            ((com.tencent.mm.plugin.sns.model.g)localObject3).A((bcs)localObject1);
            ((aj)localObject2).rwJ.setVisibility(8);
            ((aj)localObject2).rLF.setVisibility(0);
            ((aj)localObject2).rLF.dOF();
            break;
          }
          if (((com.tencent.mm.plugin.sns.model.g)localObject3).x((bcs)localObject1))
          {
            ((aj)localObject2).rLF.setVisibility(8);
            ((aj)localObject2).rwJ.setImageResource(2130840321);
            ((aj)localObject2).rwJ.setVisibility(0);
            break;
          }
          ((com.tencent.mm.plugin.sns.model.g)localObject3).y((bcs)localObject1);
          ((aj)localObject2).rwJ.setVisibility(0);
          ((aj)localObject2).rLF.setVisibility(8);
          ((aj)localObject2).rwJ.setImageDrawable(com.tencent.mm.cb.a.k(this.mActivity, 2131231980));
          ((aj)localObject2).rwJ.setContentDescription(this.mActivity.getString(2131302100));
          if (((com.tencent.mm.plugin.sns.model.g)localObject3).b(localn, null) != 4) {
            break;
          }
          ((aj)localObject2).rwK.setVisibility(0);
          break;
          if (((com.tencent.mm.plugin.sns.model.g)localObject3).u((bcs)localObject1))
          {
            ((aj)localObject2).rwJ.setVisibility(0);
            ((aj)localObject2).rLF.setVisibility(8);
            ((aj)localObject2).rwJ.setImageDrawable(com.tencent.mm.cb.a.k(this.mActivity, 2131231980));
            ((aj)localObject2).rwJ.setContentDescription(this.mActivity.getString(2131302100));
          }
          for (;;)
          {
            if (!((aj)localObject2).qVe.cmy()) {
              break label2339;
            }
            ab.d("MicroMsg.FullCardAdTimeLineItem", "play video error " + ((bcs)localObject1).Id + " " + ((bcs)localObject1).Url + " " + ((bcs)localObject1).xrS + " " + paramInt1);
            ((com.tencent.mm.plugin.sns.model.g)localObject3).y((bcs)localObject1);
            ((aj)localObject2).rwJ.setVisibility(0);
            ((aj)localObject2).rLF.setVisibility(8);
            ((aj)localObject2).rwJ.setImageDrawable(com.tencent.mm.cb.a.k(this.mActivity, 2131231980));
            ((aj)localObject2).rwJ.setContentDescription(this.mActivity.getString(2131302100));
            break;
            if (((com.tencent.mm.plugin.sns.model.g)localObject3).v((bcs)localObject1))
            {
              ((aj)localObject2).rwJ.setVisibility(8);
              ((aj)localObject2).rLF.setVisibility(8);
            }
            else if (((com.tencent.mm.plugin.sns.model.g)localObject3).b(localn, null) <= 5)
            {
              ((aj)localObject2).rwJ.setVisibility(8);
              ((aj)localObject2).rLF.setVisibility(8);
            }
            else
            {
              ((com.tencent.mm.plugin.sns.model.g)localObject3).y((bcs)localObject1);
              ((aj)localObject2).rwJ.setVisibility(0);
              ((aj)localObject2).rLF.setVisibility(8);
              ((aj)localObject2).rwJ.setImageDrawable(com.tencent.mm.cb.a.k(this.mActivity, 2131231980));
              ((aj)localObject2).rwJ.setContentDescription(this.mActivity.getString(2131302100));
            }
          }
          break;
          paramav.rWP.rFk.w(paramaw.rZw, false);
          break label1783;
        }
        ((com.tencent.mm.plugin.sns.model.g)localObject3).a(paramBaseViewHolder.sfG.qVe, this.mActivity.hashCode());
        paramBaseViewHolder.sfG.rLG.setVisibility(8);
        paramBaseViewHolder.sfG.qVe.setOnSightCompletionAction(null);
        paramBaseViewHolder.sfG.qVe.setOnCompletionListener(null);
        paramBaseViewHolder.sfG.qVe.setOnDecodeDurationListener(null);
      }
      label2339:
      label2341:
      label2360:
      label2366:
      AppMethodBeat.o(40144);
      return;
      label2443:
      localObject1 = null;
    }
  }
  
  public final void d(BaseTimeLineItem.BaseViewHolder paramBaseViewHolder)
  {
    AppMethodBeat.i(40143);
    c.a locala = (c.a)paramBaseViewHolder;
    if (paramBaseViewHolder.sgT != null)
    {
      paramBaseViewHolder.sgT.setLayoutResource(2130970877);
      if (!paramBaseViewHolder.sgU)
      {
        locala.rMB = paramBaseViewHolder.sgT.inflate();
        paramBaseViewHolder.sgU = true;
      }
    }
    for (;;)
    {
      locala.sfT = locala.ngZ.findViewById(2131828116);
      locala.sfU = locala.ngZ.findViewById(2131828119);
      locala.sfV = ((TextView)locala.ngZ.findViewById(2131828117));
      locala.sfW = ((TextView)locala.ngZ.findViewById(2131828118));
      locala.sfX = ((TextView)locala.ngZ.findViewById(2131828120));
      locala.sfY = ((TextView)locala.ngZ.findViewById(2131828121));
      locala.sga = ((MaskImageView)locala.ngZ.findViewById(2131828114));
      locala.sfZ = locala.ngZ.findViewById(2131828122);
      locala.sga.setScaleType(QImageView.a.AED);
      locala.sfG = new aj();
      locala.sfG.rLE = locala.rMB.findViewById(2131828115);
      locala.sfG.rLD = locala.sfG.rLE;
      locala.sfG.rLE.setOnClickListener(this.rkX.rks.sjO);
      locala.sfG.qVe = ((com.tencent.mm.plugin.sight.decode.a.a)locala.sfG.rLE.findViewById(2131820629));
      locala.sfG.rwJ = ((ImageView)locala.sfG.rLE.findViewById(2131820996));
      locala.sfG.rLF = ((MMPinProgressBtn)locala.sfG.rLE.findViewById(2131821404));
      locala.sfG.rLG = ((TextView)locala.sfG.rLE.findViewById(2131827795));
      locala.sfG.rwK = ((TextView)locala.sfG.rLE.findViewById(2131827796));
      ((SightPlayImageView)locala.sfG.qVe).qTZ = true;
      ((SightPlayImageView)locala.sfG.qVe).setScaleType(QImageView.a.AED);
      c.a.a(locala, (SnsDrawGestureView)locala.ngZ.findViewById(2131828123));
      AppMethodBeat.o(40143);
      return;
      if (!paramBaseViewHolder.sgU)
      {
        locala.rMB = paramBaseViewHolder.ngZ.findViewById(2131828113);
        paramBaseViewHolder.sgU = true;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.item.c
 * JD-Core Version:    0.7.0.1
 */