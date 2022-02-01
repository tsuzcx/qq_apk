package com.tencent.mm.plugin.sns.ui.item;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.mmdata.rpt.oc;
import com.tencent.mm.plugin.sns.b.f;
import com.tencent.mm.plugin.sns.b.g;
import com.tencent.mm.plugin.sns.b.j;
import com.tencent.mm.plugin.sns.statistics.j;
import com.tencent.mm.plugin.sns.storage.ae;
import com.tencent.mm.plugin.sns.ui.AsyncNormalTextView;
import com.tencent.mm.plugin.sns.ui.bn;
import com.tencent.mm.plugin.sns.ui.bo;
import com.tencent.mm.plugin.sns.ui.bv;
import com.tencent.mm.plugin.sns.ui.bz;
import com.tencent.mm.pluginsdk.ui.span.p;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.fgb;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public final class r
  extends BaseTimeLineItem
{
  public final void a(BaseTimeLineItem.BaseViewHolder paramBaseViewHolder, int paramInt1, bo parambo, TimeLineObject paramTimeLineObject, int paramInt2, bn parambn)
  {
    AppMethodBeat.i(309011);
    paramBaseViewHolder = (a)paramBaseViewHolder;
    if ((parambo.RCi != null) && (parambo.RCj != null) && (!Util.isNullOrNil(parambo.RCj.abFY)))
    {
      paramBaseViewHolder.RNP.setText(p.b(paramBaseViewHolder.RNP.getContext(), parambo.RCj.abFZ, paramBaseViewHolder.RNP.getTextSize()));
      paramBaseViewHolder.RNQ.setText(paramBaseViewHolder.RNQ.getContext().getResources().getString(b.j.sns_item_ws_fold_desc, new Object[] { Integer.valueOf(parambo.RCj.abFY.size()) }));
      paramBaseViewHolder.RKD.setVisibility(8);
      paramBaseViewHolder.RKS.setVisibility(8);
      paramBaseViewHolder.Rwl.setVisibility(8);
      paramBaseViewHolder.plq.setVisibility(8);
      paramBaseViewHolder.RKR.setVisibility(8);
      bz localbz = new bz();
      localbz.username = paramTimeLineObject.UserName;
      localbz.maxId = ((Long)parambo.RCj.abFY.get(0)).longValue();
      localbz.Qsh = ((Long)parambo.RCj.abFY.get(parambo.RCj.abFY.size() - 1)).longValue();
      localbz.REO = parambo.RCi.field_groupId;
      localbz.idList.addAll(parambo.RCj.abFY);
      paramBaseViewHolder.RNO.setTag(localbz);
      paramBaseViewHolder.RNO.setOnClickListener(parambn.RoS.RFu);
      parambo.RCd = null;
      parambo.RCe = null;
      parambo.RBL = false;
      parambo.RBJ = null;
      parambo.RBV = false;
      paramBaseViewHolder = j.QFS;
      long l = parambo.RBq;
      paramBaseViewHolder = (oc)paramBaseViewHolder.QGO.get(Long.valueOf(l));
      if (paramBaseViewHolder != null)
      {
        paramBaseViewHolder.jiq = 1;
        paramBaseViewHolder.jit = (paramInt1 + 1);
      }
    }
    a(parambo, 1);
    AppMethodBeat.o(309011);
  }
  
  public final void d(BaseTimeLineItem.BaseViewHolder paramBaseViewHolder)
  {
    AppMethodBeat.i(309005);
    a locala = (a)paramBaseViewHolder;
    if ((paramBaseViewHolder.RKG != null) && (paramBaseViewHolder.RKG.getParent() != null))
    {
      paramBaseViewHolder.RKG.setLayoutResource(b.g.sns_ws_fold_item);
      if (!locala.RNN) {
        locala.RNO = ((LinearLayout)paramBaseViewHolder.RKG.inflate());
      }
    }
    for (locala.RNN = true;; locala.RNN = true)
    {
      locala.RNP = ((TextView)locala.RNO.findViewById(b.f.sns_ws_fold_title));
      locala.RNQ = ((TextView)locala.RNO.findViewById(b.f.sns_ws_fold_desc));
      AppMethodBeat.o(309005);
      return;
      locala.RNO = ((LinearLayout)paramBaseViewHolder.convertView.findViewById(b.f.sns_ws_fold_content_rl));
    }
  }
  
  public static class a
    extends BaseTimeLineItem.BaseViewHolder
  {
    boolean RNN = false;
    LinearLayout RNO = null;
    TextView RNP = null;
    TextView RNQ = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.item.r
 * JD-Core Version:    0.7.0.1
 */