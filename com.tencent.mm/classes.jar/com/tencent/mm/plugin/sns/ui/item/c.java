package com.tencent.mm.plugin.sns.ui.item;

import android.content.Context;
import android.graphics.Point;
import android.util.Pair;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewStub;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.i.a.af;
import com.tencent.mm.plugin.i.a.aj.b;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.plugin.sns.storage.d;
import com.tencent.mm.plugin.sns.ui.bk;
import com.tencent.mm.plugin.sns.ui.bl;
import com.tencent.mm.plugin.sns.ui.br;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.adp;
import com.tencent.mm.protocal.protobuf.axf;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import kotlin.g.b.p;
import kotlin.g.b.z.d;
import kotlin.g.b.z.f;
import kotlin.l;
import kotlin.t;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/sns/ui/item/FinderLiveTimeLineItem;", "Lcom/tencent/mm/plugin/sns/ui/item/BaseTimeLineItem;", "()V", "TAG", "", "buildContent", "", "imagesKeeper", "Landroid/view/ViewStub;", "holder", "Lcom/tencent/mm/plugin/sns/ui/item/BaseTimeLineItem$BaseViewHolder;", "checkLiveStatus", "Lcom/tencent/mm/plugin/sns/ui/item/FinderLiveTimeLineItem$FinderLiveViewHolder;", "tlObj", "Lcom/tencent/mm/protocal/protobuf/TimeLineObject;", "snsInfo", "Lcom/tencent/mm/plugin/sns/storage/SnsInfo;", "fillItem", "position", "", "struct", "Lcom/tencent/mm/plugin/sns/ui/SnsTimeLineVendingStruct;", "viewType", "adapter", "Lcom/tencent/mm/plugin/sns/ui/SnsTimeLineBaseAdapter;", "FinderLiveViewHolder", "plugin-sns_release"})
public final class c
  extends BaseTimeLineItem
{
  private final String TAG = "FinderLiveTimeLineItem";
  
  public final void a(final BaseTimeLineItem.BaseViewHolder paramBaseViewHolder, int paramInt1, bl parambl, final TimeLineObject paramTimeLineObject, int paramInt2, bk parambk)
  {
    AppMethodBeat.i(201818);
    Object localObject1;
    if (paramTimeLineObject != null) {
      localObject1 = paramTimeLineObject.ContentObj;
    }
    while ((localObject1 != null) && (paramTimeLineObject.ContentObj.Lpc != null)) {
      if (paramBaseViewHolder == null)
      {
        paramBaseViewHolder = new t("null cannot be cast to non-null type com.tencent.mm.plugin.sns.ui.item.FinderLiveTimeLineItem.FinderLiveViewHolder");
        AppMethodBeat.o(201818);
        throw paramBaseViewHolder;
        localObject1 = null;
      }
      else
      {
        final a locala = (a)paramBaseViewHolder;
        Object localObject2 = paramTimeLineObject.ContentObj.Lpc;
        localObject1 = com.tencent.mm.plugin.sns.model.aj.ejr();
        paramInt1 = ((Point)localObject1).x;
        paramInt2 = ((Point)localObject1).y;
        localObject1 = locala.EYm;
        Object localObject3;
        label172:
        final long l;
        if (localObject1 != null)
        {
          localObject1 = ((View)localObject1).getContext();
          localObject1 = com.tencent.mm.modelsns.n.a(paramInt1, paramInt2, (Context)localObject1, false);
          localObject3 = (Integer)((Pair)localObject1).first;
          paramInt1 = (int)(((Number)((Pair)localObject1).first).floatValue() * 3.5F / 3.0F);
          localObject1 = locala.EYm;
          if (localObject1 == null) {
            break label580;
          }
          localObject1 = ((View)localObject1).getLayoutParams();
          if (localObject1 != null) {
            ((ViewGroup.LayoutParams)localObject1).width = ((Integer)localObject3).intValue();
          }
          if (localObject1 != null) {
            ((ViewGroup.LayoutParams)localObject1).height = paramInt1;
          }
          localObject3 = locala.EYm;
          if (localObject3 != null) {
            ((View)localObject3).setLayoutParams((ViewGroup.LayoutParams)localObject1);
          }
          localObject1 = locala.EYm;
          if (localObject1 != null) {
            ((View)localObject1).requestLayout();
          }
          localObject1 = "";
          localObject3 = (CharSequence)((axf)localObject2).coverUrl;
          if ((localObject3 != null) && (((CharSequence)localObject3).length() != 0)) {
            break label586;
          }
          paramInt1 = 1;
          label265:
          if (paramInt1 != 0) {
            break label591;
          }
          localObject1 = ((axf)localObject2).coverUrl;
          p.g(localObject1, "finderShareObject.coverUrl");
          label283:
          Log.i(this.TAG, "live status:" + ((axf)localObject2).liveStatus + " cover url:" + (String)localObject1);
          if (((axf)localObject2).liveStatus != 1) {
            break label656;
          }
          localObject2 = ((a)paramBaseViewHolder).EYo;
          if (localObject2 != null) {
            ((View)localObject2).setVisibility(8);
          }
          localObject2 = ((a)paramBaseViewHolder).EYn;
          if (localObject2 != null) {
            ((View)localObject2).setVisibility(0);
          }
          ((com.tencent.mm.plugin.i.a.aj)g.ah(com.tencent.mm.plugin.i.a.aj.class)).loadImage((String)localObject1, ((a)paramBaseViewHolder).puw);
          if (parambl == null) {
            break label645;
          }
          paramBaseViewHolder = parambl.DqO;
          label401:
          parambl = new z.f();
          parambl.SYG = paramTimeLineObject.ContentObj.Lpc;
          localObject1 = ((axf)parambl.SYG).hJs;
          p.g(localObject1, "shareObject.liveId");
          localObject1 = kotlin.n.n.buB((String)localObject1);
          if (localObject1 == null) {
            break label650;
          }
          l = ((Long)localObject1).longValue();
          label459:
          localObject1 = new z.d();
          ((z.d)localObject1).SYE = ((axf)parambl.SYG).liveStatus;
          ((com.tencent.mm.plugin.i.a.aj)g.ah(com.tencent.mm.plugin.i.a.aj.class)).refreshLiveStatus(Long.valueOf(l), (aj.b)new b(this, l, parambl, locala, paramBaseViewHolder, (z.d)localObject1, paramTimeLineObject));
        }
        for (;;)
        {
          paramBaseViewHolder = locala.EYm;
          if (paramBaseViewHolder != null) {
            paramBaseViewHolder.setTag(paramTimeLineObject);
          }
          paramBaseViewHolder = locala.EYm;
          if (paramBaseViewHolder == null) {
            break label739;
          }
          if (parambk == null) {
            p.hyc();
          }
          paramBaseViewHolder.setOnClickListener(parambk.EBo.ERe);
          AppMethodBeat.o(201818);
          return;
          localObject1 = null;
          break;
          label580:
          localObject1 = null;
          break label172;
          label586:
          paramInt1 = 0;
          break label265;
          label591:
          localObject3 = (CharSequence)((axf)localObject2).headUrl;
          if ((localObject3 == null) || (((CharSequence)localObject3).length() == 0)) {}
          for (paramInt1 = 1;; paramInt1 = 0)
          {
            if (paramInt1 != 0) {
              break label643;
            }
            localObject1 = ((axf)localObject2).headUrl;
            p.g(localObject1, "finderShareObject.headUrl");
            break;
          }
          label643:
          break label283;
          label645:
          paramBaseViewHolder = null;
          break label401;
          label650:
          l = 0L;
          break label459;
          label656:
          if (((axf)localObject2).liveStatus == 2)
          {
            parambl = ((a)paramBaseViewHolder).EYn;
            if (parambl != null) {
              parambl.setVisibility(8);
            }
            parambl = ((a)paramBaseViewHolder).EYo;
            if (parambl != null) {
              parambl.setVisibility(0);
            }
            parambl = g.ah(com.tencent.mm.plugin.i.a.aj.class);
            p.g(parambl, "MMKernel.plugin(IPluginFinder::class.java)");
            ((com.tencent.mm.plugin.i.a.aj)parambl).getFinderUtilApi().g(((a)paramBaseViewHolder).puw, (String)localObject1);
          }
        }
      }
    }
    label739:
    AppMethodBeat.o(201818);
  }
  
  public final void d(BaseTimeLineItem.BaseViewHolder paramBaseViewHolder)
  {
    Object localObject1 = null;
    AppMethodBeat.i(201817);
    if (paramBaseViewHolder == null)
    {
      paramBaseViewHolder = new t("null cannot be cast to non-null type com.tencent.mm.plugin.sns.ui.item.FinderLiveTimeLineItem.FinderLiveViewHolder");
      AppMethodBeat.o(201817);
      throw paramBaseViewHolder;
    }
    a locala = (a)paramBaseViewHolder;
    Object localObject2;
    if (BaseTimeLineItem.i(paramBaseViewHolder) != null)
    {
      localObject2 = BaseTimeLineItem.i(paramBaseViewHolder);
      p.g(localObject2, "getImageKeeper(holder)");
      if (((ViewStub)localObject2).getParent() != null)
      {
        localObject2 = BaseTimeLineItem.i(paramBaseViewHolder);
        p.g(localObject2, "getImageKeeper(holder)");
        ((ViewStub)localObject2).setLayoutResource(2131496436);
        if (!locala.EYl)
        {
          locala.EYm = BaseTimeLineItem.i(paramBaseViewHolder).inflate();
          locala.EYl = true;
        }
        paramBaseViewHolder = locala.EYm;
        if (paramBaseViewHolder == null) {
          break label212;
        }
        paramBaseViewHolder = (ImageView)paramBaseViewHolder.findViewById(2131308127);
        label129:
        locala.puw = paramBaseViewHolder;
        paramBaseViewHolder = locala.EYm;
        if (paramBaseViewHolder == null) {
          break label217;
        }
      }
    }
    label212:
    label217:
    for (paramBaseViewHolder = paramBaseViewHolder.findViewById(2131301031);; paramBaseViewHolder = null)
    {
      locala.EYn = paramBaseViewHolder;
      localObject2 = locala.EYm;
      paramBaseViewHolder = localObject1;
      if (localObject2 != null) {
        paramBaseViewHolder = ((View)localObject2).findViewById(2131300979);
      }
      locala.EYo = paramBaseViewHolder;
      AppMethodBeat.o(201817);
      return;
      locala.EYm = paramBaseViewHolder.convertView.findViewById(2131308123);
      locala.EYl = true;
      break;
      paramBaseViewHolder = null;
      break label129;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/sns/ui/item/FinderLiveTimeLineItem$FinderLiveViewHolder;", "Lcom/tencent/mm/plugin/sns/ui/item/BaseTimeLineItem$BaseViewHolder;", "()V", "coverIv", "Landroid/widget/ImageView;", "getCoverIv", "()Landroid/widget/ImageView;", "setCoverIv", "(Landroid/widget/ImageView;)V", "finderLiveEndTag", "Landroid/view/View;", "getFinderLiveEndTag", "()Landroid/view/View;", "setFinderLiveEndTag", "(Landroid/view/View;)V", "finderLiveTag", "getFinderLiveTag", "setFinderLiveTag", "finderMediaRoot", "getFinderMediaRoot", "setFinderMediaRoot", "finderMediaStubHas", "", "getFinderMediaStubHas", "()Z", "setFinderMediaStubHas", "(Z)V", "plugin-sns_release"})
  public static final class a
    extends BaseTimeLineItem.BaseViewHolder
  {
    boolean EYl;
    View EYm;
    View EYn;
    View EYo;
    ImageView puw;
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "liveId", "", "status", "", "liveInfo", "", "kotlin.jvm.PlatformType", "onLiveStatusCallback"})
  static final class b
    implements aj.b
  {
    b(c paramc, long paramLong, z.f paramf, c.a parama, SnsInfo paramSnsInfo, z.d paramd, TimeLineObject paramTimeLineObject) {}
    
    public final void a(long paramLong, int paramInt, Object paramObject)
    {
      AppMethodBeat.i(201816);
      Log.i(c.a(this.EYp), "[checkLiveStatus] thisLiveId:" + l + ",liveID:" + paramLong + ",desc:" + ((axf)locala.SYG).desc + ",share liveStatus:" + ((axf)locala.SYG).liveStatus + ", callback liveStatus:" + paramInt);
      if (l == paramLong)
      {
        paramObject = (CharSequence)((axf)locala.SYG).coverUrl;
        int i;
        label159:
        Object localObject;
        if ((paramObject == null) || (paramObject.length() == 0))
        {
          i = 1;
          if (i != 0) {
            break label339;
          }
          paramObject = ((axf)locala.SYG).coverUrl;
          if (paramInt != 2) {
            break label411;
          }
          localObject = paramBaseViewHolder.EYn;
          if (localObject != null) {
            ((View)localObject).setVisibility(8);
          }
          localObject = paramBaseViewHolder.EYo;
          if (localObject != null) {
            ((View)localObject).setVisibility(0);
          }
          localObject = g.ah(com.tencent.mm.plugin.i.a.aj.class);
          p.g(localObject, "MMKernel.plugin(IPluginFinder::class.java)");
          ((com.tencent.mm.plugin.i.a.aj)localObject).getFinderUtilApi().g(paramBaseViewHolder.puw, paramObject);
        }
        for (;;)
        {
          paramObject = this.EYt;
          if (paramObject == null) {
            break label474;
          }
          if ((paramTimeLineObject.SYE == 1) && (paramInt == 2))
          {
            ((axf)locala.SYG).liveStatus = paramInt;
            paramObject.setTimeLine(this.EYv);
            localObject = d.Emh;
            p.h(paramObject, "snsinfo");
            paramObject = d.bkj().obtainMessage(d.Emg, paramObject);
            d.bkj().sendMessage(paramObject);
          }
          AppMethodBeat.o(201816);
          return;
          i = 0;
          break;
          label339:
          paramObject = (CharSequence)((axf)locala.SYG).headUrl;
          if ((paramObject == null) || (paramObject.length() == 0)) {}
          for (i = 1;; i = 0)
          {
            if (i != 0) {
              break label404;
            }
            paramObject = ((axf)locala.SYG).headUrl;
            break;
          }
          label404:
          paramObject = "";
          break label159;
          label411:
          if (paramInt == 1)
          {
            ((axf)locala.SYG).liveStatus = paramInt;
            paramObject = paramBaseViewHolder.EYo;
            if (paramObject != null) {
              paramObject.setVisibility(8);
            }
            paramObject = paramBaseViewHolder.EYn;
            if (paramObject != null) {
              paramObject.setVisibility(0);
            }
          }
        }
      }
      label474:
      AppMethodBeat.o(201816);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.item.c
 * JD-Core Version:    0.7.0.1
 */