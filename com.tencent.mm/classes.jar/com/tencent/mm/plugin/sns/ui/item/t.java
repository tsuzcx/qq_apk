package com.tencent.mm.plugin.sns.ui.item;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.b.a.lc;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.i.g;
import com.tencent.mm.plugin.sns.i.j;
import com.tencent.mm.plugin.sns.k.g;
import com.tencent.mm.plugin.sns.storage.u;
import com.tencent.mm.plugin.sns.ui.AsyncNormalTextView;
import com.tencent.mm.plugin.sns.ui.bm;
import com.tencent.mm.plugin.sns.ui.bn;
import com.tencent.mm.plugin.sns.ui.bu;
import com.tencent.mm.plugin.sns.ui.by;
import com.tencent.mm.pluginsdk.ui.span.l;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.eln;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public final class t
  extends BaseTimeLineItem
{
  public final void a(ViewStub paramViewStub, BaseTimeLineItem.BaseViewHolder paramBaseViewHolder)
  {
    AppMethodBeat.i(203998);
    paramViewStub = (a)paramBaseViewHolder;
    if ((paramBaseViewHolder.LkR != null) && (paramBaseViewHolder.LkR.getParent() != null))
    {
      paramBaseViewHolder.LkR.setLayoutResource(i.g.sns_ws_fold_item);
      if (!paramViewStub.Loj) {
        paramViewStub.Lok = ((LinearLayout)paramBaseViewHolder.LkR.inflate());
      }
    }
    for (paramViewStub.Loj = true;; paramViewStub.Loj = true)
    {
      paramViewStub.Lol = ((TextView)paramViewStub.Lok.findViewById(i.f.sns_ws_fold_title));
      paramViewStub.Lom = ((TextView)paramViewStub.Lok.findViewById(i.f.sns_ws_fold_desc));
      AppMethodBeat.o(203998);
      return;
      paramViewStub.Lok = ((LinearLayout)paramBaseViewHolder.convertView.findViewById(i.f.sns_ws_fold_content_rl));
    }
  }
  
  public final void a(BaseTimeLineItem.BaseViewHolder paramBaseViewHolder, int paramInt1, bn parambn, TimeLineObject paramTimeLineObject, int paramInt2, bm parambm)
  {
    AppMethodBeat.i(204000);
    paramBaseViewHolder = (a)paramBaseViewHolder;
    if ((parambn.Lce != null) && (parambn.Lcf != null) && (!Util.isNullOrNil(parambn.Lcf.UnE)))
    {
      paramBaseViewHolder.Lol.setText(l.b(paramBaseViewHolder.Lol.getContext(), parambn.Lcf.UnF, paramBaseViewHolder.Lol.getTextSize()));
      paramBaseViewHolder.Lom.setText(paramBaseViewHolder.Lom.getContext().getResources().getString(i.j.sns_item_ws_fold_desc, new Object[] { Integer.valueOf(parambn.Lcf.UnE.size()) }));
      paramBaseViewHolder.LkO.setVisibility(8);
      paramBaseViewHolder.Lld.setVisibility(8);
      paramBaseViewHolder.KWo.setVisibility(8);
      paramBaseViewHolder.mrL.setVisibility(8);
      paramBaseViewHolder.Llc.setVisibility(8);
      by localby = new by();
      localby.username = paramTimeLineObject.UserName;
      localby.JVf = ((Long)parambn.Lcf.UnE.get(0)).longValue();
      localby.JVg = ((Long)parambn.Lcf.UnE.get(parambn.Lcf.UnE.size() - 1)).longValue();
      localby.LeD = parambn.Lce.field_groupId;
      localby.idList.addAll(parambn.Lcf.UnE);
      paramBaseViewHolder.Lok.setTag(localby);
      paramBaseViewHolder.Lok.setOnClickListener(parambm.KPg.Lfi);
      parambn.LbZ = null;
      parambn.Lca = null;
      parambn.LbI = false;
      parambn.LbG = null;
      parambn.LbS = false;
      paramBaseViewHolder = g.Kia;
      long l = parambn.Lbm;
      paramBaseViewHolder = (lc)paramBaseViewHolder.KiR.get(Long.valueOf(l));
      if (paramBaseViewHolder != null)
      {
        paramBaseViewHolder.gQc = 1;
        paramBaseViewHolder.gQf = (paramInt1 + 1);
      }
    }
    AppMethodBeat.o(204000);
  }
  
  public static class a
    extends BaseTimeLineItem.BaseViewHolder
  {
    boolean Loj = false;
    LinearLayout Lok = null;
    TextView Lol = null;
    TextView Lom = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.item.t
 * JD-Core Version:    0.7.0.1
 */