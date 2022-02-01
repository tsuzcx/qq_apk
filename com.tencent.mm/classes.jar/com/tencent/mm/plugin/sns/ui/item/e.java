package com.tencent.mm.plugin.sns.ui.item;

import android.util.Pair;
import android.view.View;
import android.view.ViewStub;
import android.widget.ImageView;
import androidx.constraintlayout.widget.Guideline;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.modelsns.o;
import com.tencent.mm.plugin.findersdk.a.ak;
import com.tencent.mm.plugin.findersdk.a.p;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.i.g;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.plugin.sns.ui.bm;
import com.tencent.mm.plugin.sns.ui.bn;
import com.tencent.mm.plugin.sns.ui.bu;
import com.tencent.mm.plugin.sns.ui.d.c;
import com.tencent.mm.plugin.sns.ui.view.ImageIndicatorView;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.adw;
import com.tencent.mm.protocal.protobuf.bjc;
import com.tencent.mm.protocal.protobuf.bje;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.widget.b.a;
import com.tencent.mm.view.e.b;
import com.tencent.mm.view.f;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public final class e
  extends BaseTimeLineItem
{
  private Map<String, Boolean> LmJ;
  
  public e()
  {
    AppMethodBeat.i(269935);
    this.LmJ = new HashMap();
    AppMethodBeat.o(269935);
  }
  
  public final void a(ViewStub paramViewStub, BaseTimeLineItem.BaseViewHolder paramBaseViewHolder)
  {
    AppMethodBeat.i(269936);
    paramViewStub = (a)paramBaseViewHolder;
    if ((paramBaseViewHolder.LkR != null) && (paramBaseViewHolder.LkR.getParent() != null))
    {
      paramBaseViewHolder.LkR.setLayoutResource(i.g.sns_finder_media_item);
      if (!paramViewStub.Lmy) {
        paramViewStub.Lmz = paramBaseViewHolder.LkR.inflate();
      }
    }
    for (paramViewStub.Lmy = true;; paramViewStub.Lmy = true)
    {
      paramViewStub.KDh = ((ImageView)paramViewStub.Lmz.findViewById(i.f.sns_finder_media_status_icon));
      paramViewStub.LmN = ((ImageIndicatorView)paramViewStub.Lmz.findViewById(i.f.sns_finder_media_image_count_indicator));
      paramViewStub.wPh = ((ImageView)paramViewStub.Lmz.findViewById(i.f.sns_finder_media_thumb));
      paramViewStub.LmM = ((Guideline)paramViewStub.Lmz.findViewById(i.f.sns_finder_media_image_count_indicator_guide_line));
      AppMethodBeat.o(269936);
      return;
      paramViewStub.Lmz = paramBaseViewHolder.convertView.findViewById(i.f.sns_finder_media_content_rl);
    }
  }
  
  public final void a(BaseTimeLineItem.BaseViewHolder paramBaseViewHolder, int paramInt1, final bn parambn, TimeLineObject paramTimeLineObject, int paramInt2, bm parambm)
  {
    AppMethodBeat.i(269937);
    a locala;
    final bje localbje;
    if ((paramTimeLineObject != null) && (paramTimeLineObject.ContentObj != null) && (paramTimeLineObject.ContentObj.fFJ != null))
    {
      locala = (a)paramBaseViewHolder;
      localbje = paramTimeLineObject.ContentObj.fFJ;
      parambn = parambn.Jws;
      if ((parambn.getSnsId() == null) || (this.LmJ.get(parambn.getSnsId()) == null))
      {
        f.a(paramBaseViewHolder.convertView, new e.b()
        {
          public final long er(View paramAnonymousView)
          {
            AppMethodBeat.i(264805);
            long l = parambn.getSnsId().hashCode() + paramAnonymousView.hashCode();
            AppMethodBeat.o(264805);
            return l;
          }
          
          public final void p(View paramAnonymousView, boolean paramAnonymousBoolean)
          {
            AppMethodBeat.i(264804);
            if (paramAnonymousBoolean)
            {
              paramAnonymousView = parambn.getUserName();
              ((p)h.ae(p.class)).y(3, paramAnonymousView, localbje.objectId);
            }
            AppMethodBeat.o(264804);
          }
        });
        if (parambn.getSnsId() != null) {
          this.LmJ.put(parambn.getSnsId(), Boolean.TRUE);
        }
      }
      if (!Util.isNullOrNil(localbje.mediaList))
      {
        paramBaseViewHolder = (bjc)localbje.mediaList.get(0);
        if (paramBaseViewHolder != null)
        {
          if (localbje.ACQ != 4) {
            break label342;
          }
          locala.KDh.setVisibility(0);
          locala.LmN.setVisibility(8);
          locala.LmM.setGuidelineEnd(0);
          parambn = o.a((int)paramBaseViewHolder.width, (int)paramBaseViewHolder.height, locala.Lmz.getContext(), false);
          paramInt1 = ((Integer)parambn.first).intValue();
          paramInt2 = ((Integer)parambn.second).intValue();
          locala.Lmz.getLayoutParams().width = paramInt1;
          locala.Lmz.getLayoutParams().height = paramInt2;
          locala.Lmz.requestLayout();
        }
      }
    }
    for (;;)
    {
      ((ak)h.ag(ak.class)).loadImage(paramBaseViewHolder.thumbUrl, locala.wPh);
      locala.Lmz.setTag(paramTimeLineObject);
      locala.Lmz.setOnClickListener(parambm.KPg.Lff);
      parambm.fXi().c(locala.Lmz, parambm.Kdz.Lpl, parambm.Kdz.LoP);
      AppMethodBeat.o(269937);
      return;
      label342:
      locala.KDh.setVisibility(8);
      locala.LmN.setVisibility(8);
      locala.LmN.Lsg = localbje.fCa;
      locala.LmM.setGuidelineEnd(0);
      parambn = o.a((int)paramBaseViewHolder.width, (int)paramBaseViewHolder.height, locala.Lmz.getContext());
      paramInt1 = ((Integer)parambn.first).intValue();
      paramInt2 = ((Integer)parambn.second).intValue();
      locala.Lmz.getLayoutParams().width = paramInt1;
      locala.Lmz.getLayoutParams().height = paramInt2;
      locala.Lmz.requestLayout();
    }
  }
  
  public static class a
    extends BaseTimeLineItem.BaseViewHolder
  {
    ImageView KDh;
    Guideline LmM;
    ImageIndicatorView LmN;
    boolean Lmy = false;
    View Lmz;
    ImageView wPh;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.item.e
 * JD-Core Version:    0.7.0.1
 */