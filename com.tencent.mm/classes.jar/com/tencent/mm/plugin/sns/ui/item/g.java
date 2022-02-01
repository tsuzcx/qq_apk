package com.tencent.mm.plugin.sns.ui.item;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.a.b.a;
import com.tencent.mm.plugin.i.a.l;
import com.tencent.mm.plugin.sns.data.q;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.plugin.sns.model.am.a;
import com.tencent.mm.plugin.sns.model.f;
import com.tencent.mm.plugin.sns.storage.p;
import com.tencent.mm.plugin.sns.ui.TagImageView;
import com.tencent.mm.plugin.sns.ui.be;
import com.tencent.mm.plugin.sns.ui.bl;
import com.tencent.mm.plugin.sns.ui.s;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.anw;
import com.tencent.mm.protocal.protobuf.anx;
import com.tencent.mm.protocal.protobuf.any;
import com.tencent.mm.protocal.protobuf.bsj;
import com.tencent.mm.protocal.protobuf.btz;
import com.tencent.mm.protocal.protobuf.bub;
import com.tencent.mm.protocal.protobuf.dwe;
import com.tencent.mm.protocal.protobuf.dyo;
import com.tencent.mm.protocal.protobuf.zf;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.ui.widget.b.a;
import java.util.LinkedList;

public final class g
  extends BaseTimeLineItem
{
  public final void a(BaseTimeLineItem.BaseViewHolder paramBaseViewHolder, int paramInt1, com.tencent.mm.plugin.sns.ui.bf parambf, TimeLineObject paramTimeLineObject, int paramInt2, be parambe)
  {
    AppMethodBeat.i(100090);
    paramBaseViewHolder.zdp.setPosition(paramInt1);
    Object localObject1 = parambf.yzm;
    Object localObject3 = parambf.xHc;
    paramInt1 = 0;
    int i;
    if (parambf.yxA)
    {
      if (((p)localObject3).dFR().ygg == 2)
      {
        paramInt1 = 1;
        paramBaseViewHolder.yQs.setTag(paramBaseViewHolder);
        paramBaseViewHolder.yQs.setOnClickListener(parambe.xZe.zhe);
      }
      i = 0;
    }
    label2691:
    for (;;)
    {
      label106:
      int j;
      if (paramInt1 != 0)
      {
        parambe.dQx().c(paramBaseViewHolder.yQs, parambe.xZe.zgI, parambe.xZe.zgp);
        if (paramTimeLineObject.FQo.Ety != 9) {
          break label1344;
        }
        j = 1;
        label122:
        if (j == 0) {
          break label1364;
        }
        parambf = be.avL(paramTimeLineObject.FQo.Url);
        label139:
        if ((paramTimeLineObject.FQo.Ety == 9) || (paramTimeLineObject.FQo.Ety == 14) || (paramTimeLineObject.FQo.Ety == 12) || (paramTimeLineObject.FQo.Ety == 13) || (paramInt1 != 0)) {
          parambf = paramTimeLineObject.FQo.Desc;
        }
        if ((paramTimeLineObject.FQo.EtC == null) || (paramTimeLineObject.FQo.EtC.hhb != 1)) {
          break label2685;
        }
      }
      label422:
      label447:
      label1344:
      label1364:
      label2135:
      label2685:
      for (localObject1 = ai.getContext().getString(2131761345);; localObject1 = parambf)
      {
        parambf = paramTimeLineObject.FQo.Title;
        if ((parambf != null) && (parambf.length() > 40)) {
          parambf = parambf.substring(0, 40) + "...";
        }
        for (;;)
        {
          paramBaseViewHolder.yxG.setVisibility(8);
          Object localObject2;
          com.tencent.mm.storage.bf localbf;
          if (!paramTimeLineObject.FQo.Etz.isEmpty())
          {
            paramBaseViewHolder.zdp.setVisibility(0);
            localObject2 = (btz)paramTimeLineObject.FQo.Etz.get(0);
            if (paramTimeLineObject.FQo.Ety == 5)
            {
              parambe = ((btz)localObject2).Title;
              paramBaseViewHolder.yxG.setImageResource(2131234474);
              paramBaseViewHolder.yxG.setVisibility(0);
              parambf = af.dHO();
              localObject3 = paramBaseViewHolder.zdp;
              paramInt1 = this.mActivity.hashCode();
              localbf = com.tencent.mm.storage.bf.fbk();
              localbf.gIh = paramTimeLineObject.CreateTime;
              parambf.a((btz)localObject2, (View)localObject3, 2131689581, paramInt1, localbf);
              localObject2 = localObject1;
              if (bs.isNullOrNil((String)localObject2)) {
                break label2571;
              }
              paramBaseViewHolder.zdq.setVisibility(0);
              paramBaseViewHolder.zdq.setText((CharSequence)localObject2);
              if (bs.isNullOrNil(parambe)) {
                break label2629;
              }
              if (paramBaseViewHolder.zdq.getVisibility() != 8) {
                break label2583;
              }
              if (paramBaseViewHolder.zdr != 2) {
                paramBaseViewHolder.titleTv.setMaxLines(2);
              }
            }
          }
          for (paramBaseViewHolder.zdr = 2;; paramBaseViewHolder.zdr = 1)
          {
            paramBaseViewHolder.titleTv.setVisibility(0);
            if (i == 0) {
              break label2607;
            }
            paramBaseViewHolder.titleTv.setText(q.a(parambe, this.mActivity, paramBaseViewHolder.titleTv));
            AppMethodBeat.o(100090);
            return;
            if (paramTimeLineObject.FQo.Ety == 9)
            {
              if (paramTimeLineObject.FQo.Etz.size() <= 0) {
                break label2691;
              }
              paramBaseViewHolder.yQs.setTag(new s(paramTimeLineObject, (String)localObject1));
              paramBaseViewHolder.yQs.setOnClickListener(parambe.yJC.yYo);
              paramInt1 = 0;
              i = 0;
              break;
            }
            if (paramTimeLineObject.FQo.Ety == 10)
            {
              if (paramTimeLineObject.FQo.Etz.size() <= 0) {
                break label2691;
              }
              paramBaseViewHolder.yQs.setTag(new s(paramTimeLineObject, (String)localObject1));
              paramBaseViewHolder.yQs.setOnClickListener(parambe.yJC.yYq);
              paramInt1 = 0;
              i = 0;
              break;
            }
            if (paramTimeLineObject.FQo.Ety == 17)
            {
              if (paramTimeLineObject.FQo.Etz.size() <= 0) {
                break label2691;
              }
              paramBaseViewHolder.yQs.setTag(new s(paramTimeLineObject, (String)localObject1));
              paramBaseViewHolder.yQs.setOnClickListener(parambe.yJC.yYr);
              paramInt1 = 0;
              i = 0;
              break;
            }
            if (paramTimeLineObject.FQo.Ety == 22)
            {
              if (paramTimeLineObject.FQo.Etz.size() <= 0) {
                break label2691;
              }
              paramBaseViewHolder.yQs.setTag(new s(paramTimeLineObject, (String)localObject1));
              paramBaseViewHolder.yQs.setOnClickListener(parambe.yJC.yYs);
              paramInt1 = 0;
              i = 0;
              break;
            }
            if (paramTimeLineObject.FQo.Ety == 23)
            {
              if (paramTimeLineObject.FQo.Etz.size() <= 0) {
                break label2691;
              }
              paramBaseViewHolder.yQs.setTag(new s(paramTimeLineObject, (String)localObject1));
              paramBaseViewHolder.yQs.setOnClickListener(parambe.yJC.yYt);
              paramInt1 = 0;
              i = 0;
              break;
            }
            if (paramTimeLineObject.FQo.Ety == 14)
            {
              if (paramTimeLineObject.FQo.Etz.size() <= 0) {
                break label2691;
              }
              paramBaseViewHolder.yQs.setTag(new s(paramTimeLineObject, (String)localObject1));
              paramBaseViewHolder.yQs.setOnClickListener(parambe.yJC.yYp);
              paramInt1 = 0;
              i = 0;
              break;
            }
            if (paramTimeLineObject.FQo.Ety == 12)
            {
              if (paramTimeLineObject.FQo.Etz.size() <= 0) {
                break label2691;
              }
              paramBaseViewHolder.yQs.setTag(new s(paramTimeLineObject, (String)localObject1));
              paramBaseViewHolder.yQs.setOnClickListener(parambe.yJC.yYy);
              paramInt1 = 0;
              i = 0;
              break;
            }
            if (paramTimeLineObject.FQo.Ety == 13)
            {
              if (paramTimeLineObject.FQo.Etz.size() > 0)
              {
                paramBaseViewHolder.yQs.setTag(new s(paramTimeLineObject, (String)localObject1));
                paramBaseViewHolder.yQs.setOnClickListener(parambe.yJC.yYz);
                paramInt1 = 0;
                i = 0;
                break;
              }
              paramBaseViewHolder.yQs.setOnClickListener(null);
              paramInt1 = 0;
              i = 0;
              break;
            }
            if (paramTimeLineObject.FQo.Ety == 30)
            {
              paramBaseViewHolder.yQs.setTag(new s(paramTimeLineObject, (String)localObject1));
              paramBaseViewHolder.yQs.setOnClickListener(parambe.yJC.yYw);
              paramInt1 = 0;
              i = 0;
              break;
            }
            if (paramTimeLineObject.FQo.Ety == 26)
            {
              paramBaseViewHolder.yQs.setTag(new s(paramTimeLineObject, (String)localObject1));
              paramBaseViewHolder.yQs.setOnClickListener(parambe.yJC.yYA);
              paramInt1 = 0;
              i = 0;
              break;
            }
            if ((paramTimeLineObject.FQo.Ety == 28) || (paramTimeLineObject.FQo.Ety == 29))
            {
              paramBaseViewHolder.yQs.setTag(new s(paramTimeLineObject, (String)localObject1));
              paramBaseViewHolder.yQs.setOnClickListener(parambe.yJC.yQc);
              paramInt1 = 0;
              i = 0;
              break;
            }
            paramBaseViewHolder.yQs.setTag(new s(paramTimeLineObject, (String)localObject1));
            paramBaseViewHolder.yQs.setOnClickListener(parambe.yJC.yQc);
            if ((paramTimeLineObject.hhK & 0x1) <= 0) {
              break label2691;
            }
            paramInt1 = 0;
            i = 1;
            break;
            parambe.dQx().c(paramBaseViewHolder.yQs, parambe.xZe.zgE, parambe.xZe.zgp);
            break label106;
            if ((am.a.dIw() & 0x1) <= 0)
            {
              j = 1;
              break label122;
            }
            j = 0;
            break label122;
            parambf = "";
            break label139;
            if (paramTimeLineObject.FQo.Ety == 18)
            {
              paramBaseViewHolder.yxG.setVisibility(0);
              paramBaseViewHolder.yxG.setImageResource(2131234474);
              paramBaseViewHolder.zdp.setVisibility(0);
              parambe = af.dHO();
              localObject3 = paramBaseViewHolder.zdp;
              paramInt1 = this.mActivity.hashCode();
              localbf = com.tencent.mm.storage.bf.fbk();
              localbf.gIh = paramTimeLineObject.CreateTime;
              parambe.a((btz)localObject2, (View)localObject3, 2131689581, paramInt1, localbf);
              localObject2 = localObject1;
              parambe = parambf;
              break label422;
            }
            if ((paramTimeLineObject.FQu != null) && (paramTimeLineObject.FQu.path != null) && (paramTimeLineObject.FQu.subType == 1))
            {
              paramBaseViewHolder.yxG.setImageResource(2131234474);
              paramBaseViewHolder.yxG.setVisibility(0);
            }
            if ((paramTimeLineObject.xXT != null) && (!bs.isNullOrNil(paramTimeLineObject.xXT.BYK)))
            {
              paramBaseViewHolder.yxG.setImageResource(2131234474);
              paramBaseViewHolder.yxG.setVisibility(0);
            }
            if ((paramTimeLineObject.FQo.EtC != null) && (paramTimeLineObject.FQo.EtC.hkQ == 5))
            {
              paramBaseViewHolder.yxG.setImageResource(2131234474);
              paramBaseViewHolder.yxG.setVisibility(0);
            }
            parambe = af.dHO();
            localObject3 = paramBaseViewHolder.zdp;
            paramInt1 = this.mActivity.hashCode();
            localbf = com.tencent.mm.storage.bf.fbk();
            localbf.gIh = paramTimeLineObject.CreateTime;
            parambe.b((btz)localObject2, (View)localObject3, paramInt1, localbf);
            localObject2 = localObject1;
            parambe = parambf;
            break label422;
            if (paramTimeLineObject.FQo.Ety == 18)
            {
              paramBaseViewHolder.yxG.setVisibility(0);
              paramBaseViewHolder.yxG.setImageResource(2131234474);
              paramBaseViewHolder.zdp.setVisibility(0);
              af.dHO().c(paramBaseViewHolder.zdp, -1, 2131689581, this.mActivity.hashCode());
              localObject2 = localObject1;
              parambe = parambf;
              break label422;
            }
            if (paramTimeLineObject.FQo.Ety == 26)
            {
              paramBaseViewHolder.zdp.setVisibility(0);
              af.dHO().c(paramBaseViewHolder.zdp, -1, 2131690949, this.mActivity.hashCode());
              localObject2 = localObject1;
              parambe = parambf;
              break label422;
            }
            if (paramTimeLineObject.FQo.Ety == 28)
            {
              localObject2 = localObject1;
              parambe = parambf;
              if (paramTimeLineObject.FQo.EtD == null) {
                break label422;
              }
              if ((((l)com.tencent.mm.kernel.g.ad(l.class)).showFinderEntry()) || (((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(b.a.pVK, 0) == 0))
              {
                if ((!bs.isNullOrNil(paramTimeLineObject.FQo.EtD.nickname)) || (bs.isNullOrNil(paramTimeLineObject.FQo.EtD.desc))) {
                  break label2135;
                }
                parambf = paramTimeLineObject.FQo.EtD.desc;
              }
              for (;;)
              {
                paramBaseViewHolder.zdp.setVisibility(0);
                localObject2 = localObject1;
                parambe = parambf;
                if (paramTimeLineObject.FQo.EtD.mediaList.isEmpty()) {
                  break;
                }
                parambe = new btz();
                parambe.Url = ((anw)paramTimeLineObject.FQo.EtD.mediaList.get(0)).thumbUrl;
                parambe.Fjh = ((anw)paramTimeLineObject.FQo.EtD.mediaList.get(0)).thumbUrl;
                parambe.ndI = 2;
                parambe.Fji = 1;
                parambe.Fjk = new bub();
                parambe.EUH = 1;
                parambe.Fjk.FjY = ((anw)paramTimeLineObject.FQo.EtD.mediaList.get(0)).width;
                parambe.Fjk.FjZ = ((anw)paramTimeLineObject.FQo.EtD.mediaList.get(0)).height;
                parambe.Id = ((p)localObject3).getSnsId();
                localObject2 = af.dHO();
                localObject3 = paramBaseViewHolder.zdp;
                paramInt1 = this.mActivity.hashCode();
                localbf = com.tencent.mm.storage.bf.fbk();
                localbf.gIh = paramTimeLineObject.CreateTime;
                ((f)localObject2).b(parambe, (View)localObject3, paramInt1, localbf);
                localObject2 = localObject1;
                parambe = parambf;
                break;
                if (!bs.isNullOrNil(paramTimeLineObject.FQo.EtD.desc)) {
                  parambf = paramTimeLineObject.FQo.EtD.nickname + ": " + paramTimeLineObject.FQo.EtD.desc;
                } else {
                  parambf = this.mActivity.getString(2131763973, new Object[] { paramTimeLineObject.FQo.EtD.nickname });
                }
              }
            }
            if (paramTimeLineObject.FQo.Ety == 29)
            {
              localObject2 = localObject1;
              parambe = parambf;
              if (paramTimeLineObject.FQo.EtE == null) {
                break label422;
              }
              parambf = this.mActivity.getString(2131755778);
              if (paramTimeLineObject.FQo.EtE != null) {
                if (paramTimeLineObject.FQo.EtE.rPI != 1) {
                  break label2517;
                }
              }
              for (parambf = ai.getContext().getString(2131763974, new Object[] { paramTimeLineObject.FQo.EtE.dol });; parambf = paramTimeLineObject.FQo.EtE.dol)
              {
                paramBaseViewHolder.zdp.setVisibility(0);
                if (!bs.isNullOrNil(paramTimeLineObject.FQo.EtE.iconUrl))
                {
                  parambe = new btz();
                  parambe.Url = paramTimeLineObject.FQo.EtE.iconUrl;
                  parambe.Fjh = paramTimeLineObject.FQo.EtE.iconUrl;
                  parambe.ndI = 2;
                  parambe.Fji = 1;
                  parambe.Fjk = new bub();
                  parambe.EUH = 1;
                  parambe.Fjk.FjY = 0.0F;
                  parambe.Fjk.FjZ = 0.0F;
                  parambe.Id = ((p)localObject3).getSnsId();
                  localObject1 = af.dHO();
                  localObject2 = paramBaseViewHolder.zdp;
                  paramInt1 = this.mActivity.hashCode();
                  localObject3 = com.tencent.mm.storage.bf.fbk();
                  ((com.tencent.mm.storage.bf)localObject3).gIh = paramTimeLineObject.CreateTime;
                  ((f)localObject1).b(parambe, (View)localObject2, paramInt1, (com.tencent.mm.storage.bf)localObject3);
                }
                localObject2 = paramTimeLineObject.FQo.EtE.desc;
                parambe = parambf;
                break;
              }
            }
            paramBaseViewHolder.zdp.setVisibility(0);
            af.dHO().c(paramBaseViewHolder.zdp, -1, 2131689584, this.mActivity.hashCode());
            localObject2 = localObject1;
            parambe = parambf;
            break label422;
            paramBaseViewHolder.zdq.setVisibility(8);
            break label447;
            if (paramBaseViewHolder.zdr != 1) {
              paramBaseViewHolder.titleTv.setMaxLines(1);
            }
          }
          paramBaseViewHolder.titleTv.setText(k.c(this.mActivity, parambe));
          AppMethodBeat.o(100090);
          return;
          if (paramInt2 == 1)
          {
            paramBaseViewHolder.titleTv.setText(be.avL(paramTimeLineObject.FQo.Url));
            paramBaseViewHolder.titleTv.setVisibility(0);
            AppMethodBeat.o(100090);
            return;
          }
          paramBaseViewHolder.titleTv.setVisibility(8);
          AppMethodBeat.o(100090);
          return;
        }
      }
      label2517:
      paramInt1 = 0;
      label2571:
      label2583:
      label2607:
      label2629:
      i = 0;
    }
  }
  
  public final void e(BaseTimeLineItem.BaseViewHolder paramBaseViewHolder)
  {
    AppMethodBeat.i(100089);
    if ((paramBaseViewHolder.zdm != null) && (paramBaseViewHolder.zdm.getParent() != null))
    {
      paramBaseViewHolder.zdm.setLayoutResource(2131495568);
      if (!paramBaseViewHolder.zdZ) {
        paramBaseViewHolder.zea = paramBaseViewHolder.zdm.inflate();
      }
    }
    for (paramBaseViewHolder.zdZ = true;; paramBaseViewHolder.zdZ = true)
    {
      paramBaseViewHolder.yQs = paramBaseViewHolder.zea;
      paramBaseViewHolder.zdp = ((TagImageView)paramBaseViewHolder.yQs.findViewById(2131300948));
      paramBaseViewHolder.yxG = ((ImageView)paramBaseViewHolder.yQs.findViewById(2131305185));
      paramBaseViewHolder.zdq = ((TextView)paramBaseViewHolder.yQs.findViewById(2131304202));
      paramBaseViewHolder.titleTv = ((TextView)paramBaseViewHolder.yQs.findViewById(2131305950));
      paramBaseViewHolder.titleTv.setTextColor(this.mActivity.getResources().getColor(2131100711));
      q.b(paramBaseViewHolder.zdp, this.mActivity);
      AppMethodBeat.o(100089);
      return;
      paramBaseViewHolder.zea = paramBaseViewHolder.sSS.findViewById(2131302207);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.item.g
 * JD-Core Version:    0.7.0.1
 */