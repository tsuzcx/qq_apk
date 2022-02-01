package com.tencent.mm.plugin.sns.ui.item;

import android.content.Context;
import android.graphics.Point;
import android.util.Pair;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewStub;
import android.widget.ImageView;
import com.tencent.c.a.a.a.b.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.modelsns.o;
import com.tencent.mm.plugin.findersdk.a.ag;
import com.tencent.mm.plugin.findersdk.a.ak;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.i.g;
import com.tencent.mm.plugin.sns.model.aj;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.plugin.sns.ui.SnsTimeLineUI;
import com.tencent.mm.plugin.sns.ui.bm;
import com.tencent.mm.plugin.sns.ui.bn;
import com.tencent.mm.plugin.sns.ui.bu;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.adw;
import com.tencent.mm.protocal.protobuf.bcp;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import kotlin.g.b.aa.d;
import kotlin.g.b.aa.f;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.n.n;
import kotlin.t;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/sns/ui/item/FinderLiveTimeLineItem;", "Lcom/tencent/mm/plugin/sns/ui/item/BaseTimeLineItem;", "()V", "TAG", "", "buildContent", "", "imagesKeeper", "Landroid/view/ViewStub;", "holder", "Lcom/tencent/mm/plugin/sns/ui/item/BaseTimeLineItem$BaseViewHolder;", "checkLiveStatus", "Lcom/tencent/mm/plugin/sns/ui/item/FinderLiveTimeLineItem$FinderLiveViewHolder;", "tlObj", "Lcom/tencent/mm/protocal/protobuf/TimeLineObject;", "snsInfo", "Lcom/tencent/mm/plugin/sns/storage/SnsInfo;", "fillItem", "position", "", "struct", "Lcom/tencent/mm/plugin/sns/ui/SnsTimeLineVendingStruct;", "viewType", "adapter", "Lcom/tencent/mm/plugin/sns/ui/SnsTimeLineBaseAdapter;", "getOnClickListener", "Landroid/view/View$OnClickListener;", "updateLiveStatus", "finderShareObject", "Lcom/tencent/mm/protocal/protobuf/FinderLiveShareObject;", "FinderLiveViewHolder", "plugin-sns_release"})
public class d
  extends BaseTimeLineItem
{
  private final String TAG = "FinderLiveTimeLineItem";
  
  public final void a(ViewStub paramViewStub, BaseTimeLineItem.BaseViewHolder paramBaseViewHolder)
  {
    Object localObject = null;
    AppMethodBeat.i(194062);
    if (paramBaseViewHolder == null)
    {
      paramViewStub = new t("null cannot be cast to non-null type com.tencent.mm.plugin.sns.ui.item.FinderLiveTimeLineItem.FinderLiveViewHolder");
      AppMethodBeat.o(194062);
      throw paramViewStub;
    }
    a locala = (a)paramBaseViewHolder;
    if (BaseTimeLineItem.h(paramBaseViewHolder) != null)
    {
      paramViewStub = BaseTimeLineItem.h(paramBaseViewHolder);
      p.j(paramViewStub, "getImageKeeper(holder)");
      if (paramViewStub.getParent() != null)
      {
        paramViewStub = BaseTimeLineItem.h(paramBaseViewHolder);
        p.j(paramViewStub, "getImageKeeper(holder)");
        paramViewStub.setLayoutResource(i.g.sns_finder_live_time_line_item);
        if (!locala.Lmy)
        {
          locala.Lmz = BaseTimeLineItem.h(paramBaseViewHolder).inflate();
          locala.Lmy = true;
        }
        paramViewStub = locala.Lmz;
        if (paramViewStub == null) {
          break label210;
        }
        paramViewStub = (ImageView)paramViewStub.findViewById(i.f.sns_finder_media_thumb);
        label124:
        locala.sDJ = paramViewStub;
        paramViewStub = locala.Lmz;
        if (paramViewStub == null) {
          break label215;
        }
      }
    }
    label210:
    label215:
    for (paramViewStub = paramViewStub.findViewById(i.f.finder_live_icon);; paramViewStub = null)
    {
      locala.LmA = paramViewStub;
      paramBaseViewHolder = locala.Lmz;
      paramViewStub = localObject;
      if (paramBaseViewHolder != null) {
        paramViewStub = paramBaseViewHolder.findViewById(i.f.finder_live_end_tag);
      }
      locala.LmB = paramViewStub;
      AppMethodBeat.o(194062);
      return;
      locala.Lmz = paramBaseViewHolder.convertView.findViewById(i.f.sns_finder_media_content_rl);
      locala.Lmy = true;
      break;
      paramViewStub = null;
      break label124;
    }
  }
  
  public final void a(BaseTimeLineItem.BaseViewHolder paramBaseViewHolder, int paramInt1, bn parambn, TimeLineObject paramTimeLineObject, int paramInt2, bm parambm)
  {
    AppMethodBeat.i(194077);
    Object localObject1;
    if (paramTimeLineObject != null) {
      localObject1 = paramTimeLineObject.ContentObj;
    }
    while ((localObject1 != null) && (paramTimeLineObject.ContentObj.yNL != null)) {
      if (paramBaseViewHolder == null)
      {
        paramBaseViewHolder = new t("null cannot be cast to non-null type com.tencent.mm.plugin.sns.ui.item.FinderLiveTimeLineItem.FinderLiveViewHolder");
        AppMethodBeat.o(194077);
        throw paramBaseViewHolder;
        localObject1 = null;
      }
      else
      {
        a locala = (a)paramBaseViewHolder;
        bcp localbcp = paramTimeLineObject.ContentObj.yNL;
        p.j(localbcp, "finderShareObject");
        e(localbcp);
        localObject1 = aj.eSY();
        paramInt1 = ((Point)localObject1).x;
        paramInt2 = ((Point)localObject1).y;
        localObject1 = locala.Lmz;
        Object localObject2;
        if (localObject1 != null)
        {
          localObject1 = ((View)localObject1).getContext();
          localObject1 = o.a(paramInt1, paramInt2, (Context)localObject1, false);
          localObject2 = (Integer)((Pair)localObject1).first;
          paramInt1 = (int)(((Number)((Pair)localObject1).first).floatValue() * 3.5F / 3.0F);
          localObject1 = locala.Lmz;
          if (localObject1 == null) {
            break label487;
          }
          localObject1 = ((View)localObject1).getLayoutParams();
          label185:
          if (localObject1 != null) {
            ((ViewGroup.LayoutParams)localObject1).width = ((Integer)localObject2).intValue();
          }
          if (localObject1 != null) {
            ((ViewGroup.LayoutParams)localObject1).height = paramInt1;
          }
          localObject2 = locala.Lmz;
          if (localObject2 != null) {
            ((View)localObject2).setLayoutParams((ViewGroup.LayoutParams)localObject1);
          }
          localObject1 = locala.Lmz;
          if (localObject1 != null) {
            ((View)localObject1).requestLayout();
          }
          localObject1 = "";
          localObject2 = (CharSequence)localbcp.coverUrl;
          if ((localObject2 != null) && (((CharSequence)localObject2).length() != 0)) {
            break label493;
          }
          paramInt1 = 1;
          label278:
          if (paramInt1 != 0) {
            break label498;
          }
          localObject2 = localbcp.coverUrl;
          localObject1 = localObject2;
          if (localObject2 == null) {
            localObject1 = "";
          }
          label302:
          Log.i(this.TAG, "live status:" + localbcp.liveStatus + " cover url:" + (String)localObject1);
          if (localbcp.liveStatus != 1) {
            break label562;
          }
          localObject2 = ((a)paramBaseViewHolder).LmB;
          if (localObject2 != null) {
            ((View)localObject2).setVisibility(8);
          }
          localObject2 = ((a)paramBaseViewHolder).LmA;
          if (localObject2 != null) {
            ((View)localObject2).setVisibility(0);
          }
          ((ak)h.ag(ak.class)).loadImage((String)localObject1, ((a)paramBaseViewHolder).sDJ);
          if (parambn == null) {
            break label557;
          }
          paramBaseViewHolder = parambn.Jws;
          label422:
          a(locala, paramTimeLineObject, paramBaseViewHolder);
        }
        for (;;)
        {
          paramBaseViewHolder = locala.Lmz;
          if (paramBaseViewHolder != null) {
            paramBaseViewHolder.setTag(paramTimeLineObject);
          }
          paramBaseViewHolder = locala.Lmz;
          if (paramBaseViewHolder == null) {
            break label646;
          }
          if (parambm == null) {
            p.iCn();
          }
          paramBaseViewHolder.setOnClickListener(c(parambm));
          AppMethodBeat.o(194077);
          return;
          localObject1 = null;
          break;
          label487:
          localObject1 = null;
          break label185;
          label493:
          paramInt1 = 0;
          break label278;
          label498:
          localObject2 = (CharSequence)localbcp.headUrl;
          if ((localObject2 == null) || (((CharSequence)localObject2).length() == 0)) {}
          for (paramInt1 = 1;; paramInt1 = 0)
          {
            if (paramInt1 != 0) {
              break label555;
            }
            localObject2 = localbcp.headUrl;
            localObject1 = localObject2;
            if (localObject2 == null) {
              localObject1 = "";
            }
            break;
          }
          label555:
          break label302;
          label557:
          paramBaseViewHolder = null;
          break label422;
          label562:
          if (localbcp.liveStatus == 2)
          {
            parambn = ((a)paramBaseViewHolder).LmA;
            if (parambn != null) {
              parambn.setVisibility(8);
            }
            parambn = ((a)paramBaseViewHolder).LmB;
            if (parambn != null) {
              parambn.setVisibility(0);
            }
            parambn = h.ag(ak.class);
            p.j(parambn, "MMKernel.plugin(IPluginFinder::class.java)");
            ((ak)parambn).getFinderUtilApi().f(((a)paramBaseViewHolder).sDJ, (String)localObject1);
          }
        }
      }
    }
    label646:
    AppMethodBeat.o(194077);
  }
  
  protected void a(final a parama, final TimeLineObject paramTimeLineObject, final SnsInfo paramSnsInfo)
  {
    AppMethodBeat.i(194085);
    p.k(parama, "holder");
    p.k(paramTimeLineObject, "tlObj");
    aa.f localf = new aa.f();
    localf.aaBC = paramTimeLineObject.ContentObj.yNL;
    Object localObject = ((bcp)localf.aaBC).kwM;
    final long l;
    if (localObject != null)
    {
      localObject = n.bHD((String)localObject);
      if (localObject != null)
      {
        l = ((Long)localObject).longValue();
        localObject = new aa.d();
        ((aa.d)localObject).aaBA = ((bcp)localf.aaBC).liveStatus;
        paramSnsInfo = new b(this, l, localf, parama, paramSnsInfo, (aa.d)localObject, paramTimeLineObject);
        paramTimeLineObject = parama.Lmz;
        if (paramTimeLineObject == null) {
          break label185;
        }
        paramTimeLineObject = paramTimeLineObject.getContext();
        label135:
        if (!(paramTimeLineObject instanceof SnsTimeLineUI)) {
          break label231;
        }
        parama = parama.Lmz;
        if (parama == null) {
          break label190;
        }
      }
    }
    label185:
    label190:
    for (parama = parama.getContext();; parama = null)
    {
      if (parama != null) {
        break label195;
      }
      parama = new t("null cannot be cast to non-null type com.tencent.mm.plugin.sns.ui.SnsTimeLineUI");
      AppMethodBeat.o(194085);
      throw parama;
      l = 0L;
      break;
      paramTimeLineObject = null;
      break label135;
    }
    label195:
    label231:
    for (parama = (SnsTimeLineUI)parama;; parama = null)
    {
      ((com.tencent.c.a.a.a.b)h.ag(com.tencent.c.a.a.a.b.class)).refreshLiveStatus(l, (com.tencent.mm.vending.e.b)parama, (b.d)paramSnsInfo);
      AppMethodBeat.o(194085);
      return;
    }
  }
  
  protected View.OnClickListener c(bm parambm)
  {
    AppMethodBeat.i(194079);
    p.k(parambm, "adapter");
    parambm = parambm.KPg.Lfg;
    p.j(parambm, "adapter.timelineEvent.finderLiveListener");
    AppMethodBeat.o(194079);
    return parambm;
  }
  
  protected void e(bcp parambcp)
  {
    AppMethodBeat.i(194080);
    p.k(parambcp, "finderShareObject");
    AppMethodBeat.o(194080);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/sns/ui/item/FinderLiveTimeLineItem$FinderLiveViewHolder;", "Lcom/tencent/mm/plugin/sns/ui/item/BaseTimeLineItem$BaseViewHolder;", "()V", "coverIv", "Landroid/widget/ImageView;", "getCoverIv", "()Landroid/widget/ImageView;", "setCoverIv", "(Landroid/widget/ImageView;)V", "finderLiveEndTag", "Landroid/view/View;", "getFinderLiveEndTag", "()Landroid/view/View;", "setFinderLiveEndTag", "(Landroid/view/View;)V", "finderLiveTag", "getFinderLiveTag", "setFinderLiveTag", "finderMediaRoot", "getFinderMediaRoot", "setFinderMediaRoot", "finderMediaStubHas", "", "getFinderMediaStubHas", "()Z", "setFinderMediaStubHas", "(Z)V", "plugin-sns_release"})
  public static final class a
    extends BaseTimeLineItem.BaseViewHolder
  {
    View LmA;
    View LmB;
    boolean Lmy;
    View Lmz;
    ImageView sDJ;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/sns/ui/item/FinderLiveTimeLineItem$checkLiveStatus$statusCallBack$1", "Lcom/tencent/plugin/finder/live/api/IPluginFinderLive$FinderLiveStatusCallback;", "onLiveStatusCallback", "", "liveId", "", "status", "", "liveInfo", "", "plugin-sns_release"})
  public static final class b
    implements b.d
  {
    b(long paramLong, aa.f paramf, d.a parama, SnsInfo paramSnsInfo, aa.d paramd, TimeLineObject paramTimeLineObject) {}
    
    public final void a(long paramLong, int paramInt, Object paramObject)
    {
      AppMethodBeat.i(247484);
      Log.i(d.a(this.LmC), "[checkLiveStatus] thisLiveId:" + l + ",liveID:" + paramLong + ",desc:" + ((bcp)parama.aaBC).desc + ",share liveStatus:" + ((bcp)parama.aaBC).liveStatus + ", callback liveStatus:" + paramInt);
      if (l == paramLong)
      {
        paramObject = (CharSequence)((bcp)parama.aaBC).coverUrl;
        int i;
        label159:
        Object localObject;
        if ((paramObject == null) || (paramObject.length() == 0))
        {
          i = 1;
          if (i != 0) {
            break label339;
          }
          paramObject = ((bcp)parama.aaBC).coverUrl;
          if (paramInt != 2) {
            break label411;
          }
          localObject = paramSnsInfo.LmA;
          if (localObject != null) {
            ((View)localObject).setVisibility(8);
          }
          localObject = paramSnsInfo.LmB;
          if (localObject != null) {
            ((View)localObject).setVisibility(0);
          }
          localObject = h.ag(ak.class);
          p.j(localObject, "MMKernel.plugin(IPluginFinder::class.java)");
          ((ak)localObject).getFinderUtilApi().f(paramSnsInfo.sDJ, paramObject);
        }
        for (;;)
        {
          paramObject = this.LmG;
          if (paramObject == null) {
            break label474;
          }
          if ((paramTimeLineObject.aaBA == 1) && (paramInt == 2))
          {
            ((bcp)parama.aaBC).liveStatus = paramInt;
            paramObject.setTimeLine(this.LmI);
            localObject = com.tencent.mm.plugin.sns.storage.d.Kzp;
            p.k(paramObject, "snsinfo");
            paramObject = com.tencent.mm.plugin.sns.storage.d.btS().obtainMessage(com.tencent.mm.plugin.sns.storage.d.Kzo, paramObject);
            com.tencent.mm.plugin.sns.storage.d.btS().sendMessage(paramObject);
          }
          AppMethodBeat.o(247484);
          return;
          i = 0;
          break;
          label339:
          paramObject = (CharSequence)((bcp)parama.aaBC).headUrl;
          if ((paramObject == null) || (paramObject.length() == 0)) {}
          for (i = 1;; i = 0)
          {
            if (i != 0) {
              break label404;
            }
            paramObject = ((bcp)parama.aaBC).headUrl;
            break;
          }
          label404:
          paramObject = "";
          break label159;
          label411:
          if (paramInt == 1)
          {
            ((bcp)parama.aaBC).liveStatus = paramInt;
            paramObject = paramSnsInfo.LmB;
            if (paramObject != null) {
              paramObject.setVisibility(8);
            }
            paramObject = paramSnsInfo.LmA;
            if (paramObject != null) {
              paramObject.setVisibility(0);
            }
          }
        }
      }
      label474:
      AppMethodBeat.o(247484);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.item.d
 * JD-Core Version:    0.7.0.1
 */