package com.tencent.mm.plugin.sns.ui.item;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.it;
import com.tencent.mm.plugin.sns.k.e;
import com.tencent.mm.plugin.sns.storage.u;
import com.tencent.mm.plugin.sns.ui.AsyncNormalTextView;
import com.tencent.mm.plugin.sns.ui.bk;
import com.tencent.mm.plugin.sns.ui.bl;
import com.tencent.mm.plugin.sns.ui.br;
import com.tencent.mm.plugin.sns.ui.bv;
import com.tencent.mm.pluginsdk.ui.span.l;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.ebn;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public final class r
  extends BaseTimeLineItem
{
  public final void a(BaseTimeLineItem.BaseViewHolder paramBaseViewHolder, int paramInt1, bl parambl, TimeLineObject paramTimeLineObject, int paramInt2, bk parambk)
  {
    AppMethodBeat.i(203949);
    paramBaseViewHolder = (a)paramBaseViewHolder;
    if ((parambl.EOi != null) && (parambl.EOj != null) && (!Util.isNullOrNil(parambl.EOj.Nbk)))
    {
      paramBaseViewHolder.EZS.setText(l.b(paramBaseViewHolder.EZS.getContext(), parambl.EOj.Nbl, paramBaseViewHolder.EZS.getTextSize()));
      paramBaseViewHolder.EZT.setText(paramBaseViewHolder.EZT.getContext().getResources().getString(2131766077, new Object[] { Integer.valueOf(parambl.EOj.Nbk.size()) }));
      paramBaseViewHolder.EWA.setVisibility(8);
      paramBaseViewHolder.EWP.setVisibility(8);
      paramBaseViewHolder.EIm.setVisibility(8);
      paramBaseViewHolder.jBQ.setVisibility(8);
      paramBaseViewHolder.EWO.setVisibility(8);
      bv localbv = new bv();
      localbv.username = paramTimeLineObject.UserName;
      localbv.DIf = ((Long)parambl.EOj.Nbk.get(0)).longValue();
      localbv.DIg = ((Long)parambl.EOj.Nbk.get(parambl.EOj.Nbk.size() - 1)).longValue();
      localbv.EQE = parambl.EOi.field_groupId;
      localbv.idList.addAll(parambl.EOj.Nbk);
      paramBaseViewHolder.EZR.setTag(localbv);
      paramBaseViewHolder.EZR.setOnClickListener(parambk.EBo.ERg);
      parambl.EOd = null;
      parambl.EOe = null;
      parambl.ENM = false;
      parambl.ENK = null;
      parambl.ENW = false;
      paramBaseViewHolder = e.DUQ;
      long l = parambl.ENp;
      paramBaseViewHolder = (it)paramBaseViewHolder.DVH.get(Long.valueOf(l));
      if (paramBaseViewHolder != null)
      {
        paramBaseViewHolder.ePG = 1;
        paramBaseViewHolder.ePJ = (paramInt1 + 1);
      }
    }
    AppMethodBeat.o(203949);
  }
  
  public final void d(BaseTimeLineItem.BaseViewHolder paramBaseViewHolder)
  {
    AppMethodBeat.i(203948);
    a locala = (a)paramBaseViewHolder;
    if ((paramBaseViewHolder.EWD != null) && (paramBaseViewHolder.EWD.getParent() != null))
    {
      paramBaseViewHolder.EWD.setLayoutResource(2131496525);
      if (!locala.EZQ) {
        locala.EZR = ((RelativeLayout)paramBaseViewHolder.EWD.inflate());
      }
    }
    for (locala.EZQ = true;; locala.EZQ = true)
    {
      locala.EZS = ((TextView)locala.EZR.findViewById(2131308271));
      locala.EZT = ((TextView)locala.EZR.findViewById(2131308267));
      AppMethodBeat.o(203948);
      return;
      locala.EZR = ((RelativeLayout)paramBaseViewHolder.convertView.findViewById(2131308265));
    }
  }
  
  public static class a
    extends BaseTimeLineItem.BaseViewHolder
  {
    boolean EZQ = false;
    RelativeLayout EZR = null;
    TextView EZS = null;
    TextView EZT = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.item.r
 * JD-Core Version:    0.7.0.1
 */