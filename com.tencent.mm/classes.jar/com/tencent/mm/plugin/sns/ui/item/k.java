package com.tencent.mm.plugin.sns.ui.item;

import android.app.Activity;
import android.content.res.Resources;
import android.text.SpannableString;
import android.view.View;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.TextView.BufferType;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.data.r;
import com.tencent.mm.plugin.sns.model.aj;
import com.tencent.mm.plugin.sns.model.g;
import com.tencent.mm.plugin.sns.ui.TagImageView;
import com.tencent.mm.plugin.sns.ui.bk;
import com.tencent.mm.plugin.sns.ui.bl;
import com.tencent.mm.plugin.sns.ui.br;
import com.tencent.mm.plugin.sns.ui.d.c;
import com.tencent.mm.plugin.sns.ui.s;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.adp;
import com.tencent.mm.protocal.protobuf.cnb;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.bp;
import com.tencent.mm.ui.widget.b.a;
import java.util.LinkedList;

public final class k
  extends BaseTimeLineItem
{
  public final void a(BaseTimeLineItem.BaseViewHolder paramBaseViewHolder, int paramInt1, bl parambl, TimeLineObject paramTimeLineObject, int paramInt2, bk parambk)
  {
    AppMethodBeat.i(100088);
    String str = parambl.Eql;
    if (!paramTimeLineObject.ContentObj.LoV.isEmpty())
    {
      paramBaseViewHolder.EWG.setPosition(paramInt1);
      paramBaseViewHolder.EIs.setVisibility(0);
      parambl = (cnb)paramTimeLineObject.ContentObj.LoV.get(0);
      g localg = aj.faL();
      TagImageView localTagImageView = paramBaseViewHolder.EWG;
      paramInt1 = this.mActivity.hashCode();
      bp localbp = bp.gCU();
      localbp.hXs = paramTimeLineObject.CreateTime;
      localg.a(parambl, localTagImageView, 2131689567, paramInt1, localbp);
      paramBaseViewHolder.uzC.setPressed(false);
      if (bk.aMJ(paramTimeLineObject.Id))
      {
        paramBaseViewHolder.uzC.setImageResource(2131234170);
        paramBaseViewHolder.EWG.setTag(new s(paramTimeLineObject, str));
        paramBaseViewHolder.EWG.setOnClickListener(parambk.EBo.ERq);
        paramBaseViewHolder.EIs.setTag(new s(paramTimeLineObject, str));
        parambk.fiV().c(paramBaseViewHolder.EIs, parambk.DQs.FaG, parambk.DQs.Far);
        paramBaseViewHolder.EIs.setOnClickListener(parambk.EBo.EIc);
        paramTimeLineObject = parambl.Desc;
        if (Util.isNullOrNil(paramTimeLineObject)) {
          break label315;
        }
        paramBaseViewHolder.EWH.setVisibility(0);
        paramBaseViewHolder.EWH.setText(paramTimeLineObject);
      }
      for (;;)
      {
        parambl = parambl.Title;
        if (Util.isNullOrNil(parambl)) {
          break label326;
        }
        paramBaseViewHolder.titleTv.setVisibility(0);
        parambl = new SpannableString(parambl);
        paramBaseViewHolder.titleTv.setText(parambl, TextView.BufferType.SPANNABLE);
        AppMethodBeat.o(100088);
        return;
        paramBaseViewHolder.uzC.setImageResource(2131234185);
        break;
        label315:
        paramBaseViewHolder.EWH.setVisibility(4);
      }
      label326:
      paramBaseViewHolder.titleTv.setVisibility(8);
      AppMethodBeat.o(100088);
      return;
    }
    paramBaseViewHolder.EIs.setVisibility(8);
    AppMethodBeat.o(100088);
  }
  
  public final void d(BaseTimeLineItem.BaseViewHolder paramBaseViewHolder)
  {
    AppMethodBeat.i(100087);
    if (paramBaseViewHolder.EWD != null)
    {
      paramBaseViewHolder.EWD.setLayoutResource(2131496461);
      paramBaseViewHolder.EXp = ((ViewStub)paramBaseViewHolder.convertView.findViewById(2131302605));
      if ((!paramBaseViewHolder.EXq) && (paramBaseViewHolder.EXp != null)) {
        paramBaseViewHolder.EXr = paramBaseViewHolder.EXp.inflate();
      }
    }
    for (paramBaseViewHolder.EXq = true;; paramBaseViewHolder.EXq = true)
    {
      paramBaseViewHolder.EIs = paramBaseViewHolder.EXr;
      paramBaseViewHolder.EIs.findViewById(2131308376).setOnTouchListener(this.DQX.EqE);
      paramBaseViewHolder.EWG = ((TagImageView)paramBaseViewHolder.EIs.findViewById(2131302578));
      paramBaseViewHolder.uzC = ((ImageView)paramBaseViewHolder.EIs.findViewById(2131308376));
      paramBaseViewHolder.EWH = ((TextView)paramBaseViewHolder.EIs.findViewById(2131307116));
      paramBaseViewHolder.titleTv = ((TextView)paramBaseViewHolder.EIs.findViewById(2131309253));
      paramBaseViewHolder.titleTv.setTextColor(this.mActivity.getResources().getColor(2131101131));
      paramBaseViewHolder.titleTv.setMaxLines(1);
      r.b(paramBaseViewHolder.EWG, this.mActivity);
      AppMethodBeat.o(100087);
      return;
      paramBaseViewHolder.EXr = paramBaseViewHolder.convertView.findViewById(2131304553);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.item.k
 * JD-Core Version:    0.7.0.1
 */