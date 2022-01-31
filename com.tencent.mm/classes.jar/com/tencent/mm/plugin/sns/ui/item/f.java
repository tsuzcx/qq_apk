package com.tencent.mm.plugin.sns.ui.item;

import android.app.Activity;
import android.content.res.Resources;
import android.view.View;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.plugin.sns.model.ag;
import com.tencent.mm.plugin.sns.model.an.a;
import com.tencent.mm.plugin.sns.model.g;
import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.plugin.sns.ui.TagImageView;
import com.tencent.mm.plugin.sns.ui.av;
import com.tencent.mm.plugin.sns.ui.aw;
import com.tencent.mm.plugin.sns.ui.bd;
import com.tencent.mm.plugin.sns.ui.q;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.bbs;
import com.tencent.mm.protocal.protobuf.bcs;
import com.tencent.mm.protocal.protobuf.cyl;
import com.tencent.mm.protocal.protobuf.vi;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.az;
import com.tencent.mm.ui.widget.c.a;
import java.util.LinkedList;

public final class f
  extends BaseTimeLineItem
{
  public final void a(BaseTimeLineItem.BaseViewHolder paramBaseViewHolder, int paramInt1, aw paramaw, TimeLineObject paramTimeLineObject, int paramInt2, av paramav)
  {
    AppMethodBeat.i(40152);
    paramBaseViewHolder.sgW.setPosition(paramInt1);
    Object localObject1 = paramaw.rGx;
    Object localObject2 = paramaw.qXp;
    paramInt1 = 0;
    int i;
    if (paramaw.rEX)
    {
      if (((n)localObject2).csb().rqB == 2)
      {
        paramInt1 = 1;
        paramBaseViewHolder.rUS.setTag(paramBaseViewHolder);
        paramBaseViewHolder.rUS.setOnClickListener(paramav.rks.skc);
      }
      i = 0;
    }
    for (;;)
    {
      label106:
      int j;
      if (paramInt1 != 0)
      {
        paramav.jVd.c(paramBaseViewHolder.rUS, paramav.rks.sjK, paramav.rks.sjr);
        if (paramTimeLineObject.xTS.wNZ != 9) {
          break label1183;
        }
        j = 1;
        label122:
        if (j == 0) {
          break label1203;
        }
        paramaw = av.acj(paramTimeLineObject.xTS.Url);
        label139:
        if ((paramTimeLineObject.xTS.wNZ != 9) && (paramTimeLineObject.xTS.wNZ != 14) && (paramTimeLineObject.xTS.wNZ != 12) && (paramTimeLineObject.xTS.wNZ != 13) && (paramInt1 == 0)) {
          break label1674;
        }
      }
      label384:
      label1674:
      for (paramav = paramTimeLineObject.xTS.Desc;; paramav = paramaw)
      {
        paramaw = paramTimeLineObject.xTS.Title;
        if ((paramaw != null) && (paramaw.length() > 40)) {
          paramaw = paramaw.substring(0, 40) + "...";
        }
        for (;;)
        {
          paramBaseViewHolder.rFb.setVisibility(8);
          TagImageView localTagImageView;
          az localaz;
          if (!paramTimeLineObject.xTS.wOa.isEmpty())
          {
            paramBaseViewHolder.sgW.setVisibility(0);
            localObject1 = (bcs)paramTimeLineObject.xTS.wOa.get(0);
            if (paramTimeLineObject.xTS.wNZ == 5)
            {
              paramaw = ((bcs)localObject1).Title;
              paramBaseViewHolder.rFb.setImageResource(2130840664);
              paramBaseViewHolder.rFb.setVisibility(0);
              localObject2 = ag.cpc();
              localTagImageView = paramBaseViewHolder.sgW;
              paramInt1 = this.mActivity.hashCode();
              localaz = az.dxB();
              localaz.oLs = paramTimeLineObject.CreateTime;
              ((g)localObject2).a((bcs)localObject1, localTagImageView, 2131230826, paramInt1, localaz);
              if (bo.isNullOrNil(paramav)) {
                break label1568;
              }
              paramBaseViewHolder.sgX.setVisibility(0);
              paramBaseViewHolder.sgX.setText(paramav);
              label409:
              if (bo.isNullOrNil(paramaw)) {
                break label1618;
              }
              if (paramBaseViewHolder.sgX.getVisibility() != 8) {
                break label1580;
              }
              if (paramBaseViewHolder.sgY != 2) {
                paramBaseViewHolder.titleTv.setMaxLines(2);
              }
            }
          }
          for (paramBaseViewHolder.sgY = 2;; paramBaseViewHolder.sgY = 1)
          {
            paramBaseViewHolder.titleTv.setVisibility(0);
            if (i == 0) {
              break label1604;
            }
            paramBaseViewHolder.titleTv.setText(i.a(paramaw, this.mActivity, paramBaseViewHolder.titleTv));
            AppMethodBeat.o(40152);
            return;
            if (paramTimeLineObject.xTS.wNZ == 9)
            {
              if (paramTimeLineObject.xTS.wOa.size() <= 0) {
                break label1680;
              }
              paramBaseViewHolder.rUS.setTag(new q(paramTimeLineObject, (String)localObject1));
              paramBaseViewHolder.rUS.setOnClickListener(paramav.rON.scy);
              paramInt1 = 0;
              i = 0;
              break;
            }
            if (paramTimeLineObject.xTS.wNZ == 10)
            {
              if (paramTimeLineObject.xTS.wOa.size() <= 0) {
                break label1680;
              }
              paramBaseViewHolder.rUS.setTag(new q(paramTimeLineObject, (String)localObject1));
              paramBaseViewHolder.rUS.setOnClickListener(paramav.rON.scA);
              paramInt1 = 0;
              i = 0;
              break;
            }
            if (paramTimeLineObject.xTS.wNZ == 17)
            {
              if (paramTimeLineObject.xTS.wOa.size() <= 0) {
                break label1680;
              }
              paramBaseViewHolder.rUS.setTag(new q(paramTimeLineObject, (String)localObject1));
              paramBaseViewHolder.rUS.setOnClickListener(paramav.rON.scB);
              paramInt1 = 0;
              i = 0;
              break;
            }
            if (paramTimeLineObject.xTS.wNZ == 22)
            {
              if (paramTimeLineObject.xTS.wOa.size() <= 0) {
                break label1680;
              }
              paramBaseViewHolder.rUS.setTag(new q(paramTimeLineObject, (String)localObject1));
              paramBaseViewHolder.rUS.setOnClickListener(paramav.rON.scC);
              paramInt1 = 0;
              i = 0;
              break;
            }
            if (paramTimeLineObject.xTS.wNZ == 23)
            {
              if (paramTimeLineObject.xTS.wOa.size() <= 0) {
                break label1680;
              }
              paramBaseViewHolder.rUS.setTag(new q(paramTimeLineObject, (String)localObject1));
              paramBaseViewHolder.rUS.setOnClickListener(paramav.rON.scD);
              paramInt1 = 0;
              i = 0;
              break;
            }
            if (paramTimeLineObject.xTS.wNZ == 14)
            {
              if (paramTimeLineObject.xTS.wOa.size() <= 0) {
                break label1680;
              }
              paramBaseViewHolder.rUS.setTag(new q(paramTimeLineObject, (String)localObject1));
              paramBaseViewHolder.rUS.setOnClickListener(paramav.rON.scz);
              paramInt1 = 0;
              i = 0;
              break;
            }
            if (paramTimeLineObject.xTS.wNZ == 12)
            {
              if (paramTimeLineObject.xTS.wOa.size() <= 0) {
                break label1680;
              }
              paramBaseViewHolder.rUS.setTag(new q(paramTimeLineObject, (String)localObject1));
              paramBaseViewHolder.rUS.setOnClickListener(paramav.rON.scH);
              paramInt1 = 0;
              i = 0;
              break;
            }
            if (paramTimeLineObject.xTS.wNZ == 13)
            {
              if (paramTimeLineObject.xTS.wOa.size() > 0)
              {
                paramBaseViewHolder.rUS.setTag(new q(paramTimeLineObject, (String)localObject1));
                paramBaseViewHolder.rUS.setOnClickListener(paramav.rON.scI);
                paramInt1 = 0;
                i = 0;
                break;
              }
              paramBaseViewHolder.rUS.setOnClickListener(null);
              paramInt1 = 0;
              i = 0;
              break;
            }
            if (paramTimeLineObject.xTS.wNZ == 26)
            {
              paramBaseViewHolder.rUS.setTag(new q(paramTimeLineObject, (String)localObject1));
              paramBaseViewHolder.rUS.setOnClickListener(paramav.rON.scJ);
              paramInt1 = 0;
              i = 0;
              break;
            }
            paramBaseViewHolder.rUS.setTag(new q(paramTimeLineObject, (String)localObject1));
            paramBaseViewHolder.rUS.setOnClickListener(paramav.rON.rUE);
            if ((paramTimeLineObject.fgB & 0x1) <= 0) {
              break label1680;
            }
            paramInt1 = 0;
            i = 1;
            break;
            paramav.jVd.c(paramBaseViewHolder.rUS, paramav.rks.sjG, paramav.rks.sjr);
            break label106;
            label1183:
            if ((an.a.cpE() & 0x1) <= 0)
            {
              j = 1;
              break label122;
            }
            j = 0;
            break label122;
            label1203:
            paramaw = "";
            break label139;
            if (paramTimeLineObject.xTS.wNZ == 18)
            {
              paramBaseViewHolder.rFb.setVisibility(0);
              paramBaseViewHolder.rFb.setImageResource(2130840664);
              paramBaseViewHolder.sgW.setVisibility(0);
              localObject2 = ag.cpc();
              localTagImageView = paramBaseViewHolder.sgW;
              paramInt1 = this.mActivity.hashCode();
              localaz = az.dxB();
              localaz.oLs = paramTimeLineObject.CreateTime;
              ((g)localObject2).a((bcs)localObject1, localTagImageView, 2131230826, paramInt1, localaz);
              break label384;
            }
            if ((paramTimeLineObject.rjx != null) && (!bo.isNullOrNil(paramTimeLineObject.rjx.uJi)))
            {
              paramBaseViewHolder.rFb.setImageResource(2130840664);
              paramBaseViewHolder.rFb.setVisibility(0);
            }
            if ((paramTimeLineObject.xTS.wOd != null) && (paramTimeLineObject.xTS.wOd.wqp == 5))
            {
              paramBaseViewHolder.rFb.setImageResource(2130840664);
              paramBaseViewHolder.rFb.setVisibility(0);
            }
            localObject2 = ag.cpc();
            localTagImageView = paramBaseViewHolder.sgW;
            paramInt1 = this.mActivity.hashCode();
            localaz = az.dxB();
            localaz.oLs = paramTimeLineObject.CreateTime;
            ((g)localObject2).b((bcs)localObject1, localTagImageView, paramInt1, localaz);
            break label384;
            if (paramTimeLineObject.xTS.wNZ == 18)
            {
              paramBaseViewHolder.rFb.setVisibility(0);
              paramBaseViewHolder.rFb.setImageResource(2130840664);
              paramBaseViewHolder.sgW.setVisibility(0);
              ag.cpc().a(paramBaseViewHolder.sgW, -1, 2131230826, this.mActivity.hashCode());
              break label384;
            }
            if (paramTimeLineObject.xTS.wNZ == 26)
            {
              paramBaseViewHolder.sgW.setVisibility(0);
              ag.cpc().a(paramBaseViewHolder.sgW, -1, 2131231779, this.mActivity.hashCode());
              break label384;
            }
            paramBaseViewHolder.sgW.setVisibility(0);
            ag.cpc().a(paramBaseViewHolder.sgW, -1, 2131230829, this.mActivity.hashCode());
            break label384;
            label1568:
            paramBaseViewHolder.sgX.setVisibility(8);
            break label409;
            label1580:
            if (paramBaseViewHolder.sgY != 1) {
              paramBaseViewHolder.titleTv.setMaxLines(1);
            }
          }
          label1604:
          paramBaseViewHolder.titleTv.setText(paramaw);
          AppMethodBeat.o(40152);
          return;
          label1618:
          if (paramInt2 == 1)
          {
            paramBaseViewHolder.titleTv.setText(av.acj(paramTimeLineObject.xTS.Url));
            paramBaseViewHolder.titleTv.setVisibility(0);
            AppMethodBeat.o(40152);
            return;
          }
          paramBaseViewHolder.titleTv.setVisibility(8);
          AppMethodBeat.o(40152);
          return;
        }
      }
      label1680:
      paramInt1 = 0;
      i = 0;
    }
  }
  
  public final void d(BaseTimeLineItem.BaseViewHolder paramBaseViewHolder)
  {
    AppMethodBeat.i(40151);
    if ((paramBaseViewHolder.sgT != null) && (paramBaseViewHolder.sgT.getParent() != null))
    {
      paramBaseViewHolder.sgT.setLayoutResource(2130970844);
      if (!paramBaseViewHolder.shD) {
        paramBaseViewHolder.shE = paramBaseViewHolder.sgT.inflate();
      }
    }
    for (paramBaseViewHolder.shD = true;; paramBaseViewHolder.shD = true)
    {
      paramBaseViewHolder.rUS = paramBaseViewHolder.shE;
      paramBaseViewHolder.sgW = ((TagImageView)paramBaseViewHolder.rUS.findViewById(2131825855));
      paramBaseViewHolder.rFb = ((ImageView)paramBaseViewHolder.rUS.findViewById(2131824765));
      paramBaseViewHolder.sgX = ((TextView)paramBaseViewHolder.rUS.findViewById(2131825858));
      paramBaseViewHolder.titleTv = ((TextView)paramBaseViewHolder.rUS.findViewById(2131825857));
      paramBaseViewHolder.titleTv.setTextColor(this.mActivity.getResources().getColor(2131689763));
      i.b(paramBaseViewHolder.sgW, this.mActivity);
      AppMethodBeat.o(40151);
      return;
      paramBaseViewHolder.shE = paramBaseViewHolder.ngZ.findViewById(2131828028);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.item.f
 * JD-Core Version:    0.7.0.1
 */