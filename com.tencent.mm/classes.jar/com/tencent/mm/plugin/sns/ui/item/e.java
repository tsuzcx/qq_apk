package com.tencent.mm.plugin.sns.ui.item;

import android.app.Activity;
import android.content.res.Resources;
import android.util.Pair;
import android.view.View;
import android.view.ViewStub;
import android.widget.ImageView;
import androidx.constraintlayout.widget.Guideline;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ae.d;
import com.tencent.mm.kernel.h;
import com.tencent.mm.modelsns.o;
import com.tencent.mm.plugin.findersdk.a.ae;
import com.tencent.mm.plugin.findersdk.a.bq;
import com.tencent.mm.plugin.findersdk.a.cn;
import com.tencent.mm.plugin.sns.b.f;
import com.tencent.mm.plugin.sns.b.g;
import com.tencent.mm.plugin.sns.b.j;
import com.tencent.mm.plugin.sns.data.t;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.plugin.sns.ui.bn;
import com.tencent.mm.plugin.sns.ui.bo;
import com.tencent.mm.plugin.sns.ui.bv;
import com.tencent.mm.plugin.sns.ui.listener.c;
import com.tencent.mm.plugin.sns.ui.view.ImageIndicatorView;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.agh;
import com.tencent.mm.protocal.protobuf.bvj;
import com.tencent.mm.protocal.protobuf.bvl;
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
  private Map<String, Boolean> RMy;
  
  public e()
  {
    AppMethodBeat.i(309015);
    this.RMy = new HashMap();
    AppMethodBeat.o(309015);
  }
  
  public final void a(BaseTimeLineItem.BaseViewHolder paramBaseViewHolder, int paramInt1, bo parambo, TimeLineObject paramTimeLineObject, int paramInt2, bn parambn)
  {
    AppMethodBeat.i(309023);
    final a locala;
    final bvl localbvl;
    Object localObject;
    if ((paramTimeLineObject != null) && (paramTimeLineObject.ContentObj != null) && (paramTimeLineObject.ContentObj.hKU != null))
    {
      locala = (a)paramBaseViewHolder;
      localbvl = paramTimeLineObject.ContentObj.hKU;
      localObject = parambo.PJQ;
      if ((((SnsInfo)localObject).getSnsId() == null) || (this.RMy.get(((SnsInfo)localObject).getSnsId()) == null))
      {
        f.a(paramBaseViewHolder.convertView, new e.b()
        {
          public final void a(View paramAnonymousView, long paramAnonymousLong1, long paramAnonymousLong2, boolean paramAnonymousBoolean)
          {
            AppMethodBeat.i(308965);
            if (paramAnonymousBoolean)
            {
              ((bq)h.ax(bq.class)).a(d.FK(localbvl.objectId), localbvl.objectNonceId, 37, null, locala.RMo.getContext(), false, null);
              paramAnonymousView = this.PNW.getUserName();
              ((ae)h.ax(ae.class)).E(3, paramAnonymousView, localbvl.objectId);
            }
            AppMethodBeat.o(308965);
          }
          
          public final long fq(View paramAnonymousView)
          {
            AppMethodBeat.i(308970);
            long l = this.PNW.getSnsId().hashCode() + paramAnonymousView.hashCode();
            AppMethodBeat.o(308970);
            return l;
          }
        });
        if (((SnsInfo)localObject).getSnsId() != null) {
          this.RMy.put(((SnsInfo)localObject).getSnsId(), Boolean.TRUE);
        }
      }
      if (!Util.isNullOrNil(localbvl.mediaList))
      {
        paramBaseViewHolder = (bvj)localbvl.mediaList.get(0);
        if (paramBaseViewHolder != null)
        {
          if (localbvl.GfT != 4) {
            break label404;
          }
          locala.RcO.setVisibility(0);
          locala.RMC.setVisibility(8);
          locala.RMB.setGuidelineEnd(0);
          localObject = o.a((int)paramBaseViewHolder.width, (int)paramBaseViewHolder.height, locala.RMo.getContext(), false);
          paramInt1 = ((Integer)((Pair)localObject).first).intValue();
          paramInt2 = ((Integer)((Pair)localObject).second).intValue();
          locala.RMo.getLayoutParams().width = paramInt1;
          locala.RMo.getLayoutParams().height = paramInt2;
          locala.RMo.requestLayout();
        }
      }
    }
    for (;;)
    {
      locala.desc = String.format(this.mActivity.getResources().getString(b.j.sns_finder_who_video), new Object[] { t.e(localbvl) });
      locala.AlJ.setContentDescription(locala.desc);
      ((cn)h.az(cn.class)).loadImage(paramBaseViewHolder.thumbUrl, locala.AlJ);
      locala.RMo.setTag(paramTimeLineObject);
      locala.RMo.setOnClickListener(parambn.RoS.RFr);
      parambn.hpB().c(locala.RMo, parambn.QBf.RQq, parambn.QBf.RPU);
      a(parambo, 1);
      AppMethodBeat.o(309023);
      return;
      label404:
      locala.RcO.setVisibility(8);
      locala.RMC.setVisibility(8);
      locala.RMC.RVj = localbvl.hGP;
      locala.RMB.setGuidelineEnd(0);
      localObject = o.a((int)paramBaseViewHolder.width, (int)paramBaseViewHolder.height, locala.RMo.getContext());
      paramInt1 = ((Integer)((Pair)localObject).first).intValue();
      paramInt2 = ((Integer)((Pair)localObject).second).intValue();
      locala.RMo.getLayoutParams().width = paramInt1;
      locala.RMo.getLayoutParams().height = paramInt2;
      locala.RMo.requestLayout();
    }
  }
  
  public final void d(BaseTimeLineItem.BaseViewHolder paramBaseViewHolder)
  {
    AppMethodBeat.i(309018);
    a locala = (a)paramBaseViewHolder;
    if ((paramBaseViewHolder.RKG != null) && (paramBaseViewHolder.RKG.getParent() != null))
    {
      paramBaseViewHolder.RKG.setLayoutResource(b.g.sns_finder_media_item);
      if (!locala.RMn) {
        locala.RMo = paramBaseViewHolder.RKG.inflate();
      }
    }
    for (locala.RMn = true;; locala.RMn = true)
    {
      locala.RcO = ((ImageView)locala.RMo.findViewById(b.f.sns_finder_media_status_icon));
      locala.RMC = ((ImageIndicatorView)locala.RMo.findViewById(b.f.sns_finder_media_image_count_indicator));
      locala.AlJ = ((ImageView)locala.RMo.findViewById(b.f.sns_finder_media_thumb));
      locala.RMB = ((Guideline)locala.RMo.findViewById(b.f.sns_finder_media_image_count_indicator_guide_line));
      AppMethodBeat.o(309018);
      return;
      locala.RMo = paramBaseViewHolder.convertView.findViewById(b.f.sns_finder_media_content_rl);
    }
  }
  
  public static class a
    extends BaseTimeLineItem.BaseViewHolder
  {
    ImageView AlJ;
    Guideline RMB;
    ImageIndicatorView RMC;
    boolean RMn = false;
    View RMo;
    ImageView RcO;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.item.e
 * JD-Core Version:    0.7.0.1
 */