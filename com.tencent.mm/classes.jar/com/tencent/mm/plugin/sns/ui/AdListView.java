package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Base64;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelstat.p.a;
import com.tencent.mm.platformtools.ab;
import com.tencent.mm.plugin.sight.decode.a.b;
import com.tencent.mm.plugin.sight.decode.ui.SightPlayImageView;
import com.tencent.mm.plugin.sns.a.b.m;
import com.tencent.mm.plugin.sns.k.f;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.plugin.sns.model.ar;
import com.tencent.mm.plugin.sns.model.e;
import com.tencent.mm.plugin.sns.storage.p;
import com.tencent.mm.plugin.sns.ui.item.BaseTimeLineItem.BaseViewHolder;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.cxi;
import com.tencent.mm.protocal.protobuf.cxj;
import com.tencent.mm.protocal.protobuf.eh;
import com.tencent.mm.protocal.protobuf.yk;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.HashSet;

public class AdListView
  extends ListView
{
  com.tencent.mm.plugin.sns.a.b.d xjv;
  e xjw;
  private com.tencent.mm.plugin.sns.model.d xjx;
  private boolean xjy;
  private HashSet<String> xjz;
  
  public AdListView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(97674);
    this.xjy = true;
    this.xjz = new HashSet();
    AppMethodBeat.o(97674);
  }
  
  public AdListView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(97673);
    this.xjy = true;
    this.xjz = new HashSet();
    AppMethodBeat.o(97673);
  }
  
  private static void c(BaseTimeLineItem.BaseViewHolder paramBaseViewHolder)
  {
    AppMethodBeat.i(179144);
    af.dtD().sQ(paramBaseViewHolder.xQn);
    AppMethodBeat.o(179144);
  }
  
  protected void attachViewToParent(View paramView, int paramInt, ViewGroup.LayoutParams paramLayoutParams)
  {
    AppMethodBeat.i(97679);
    super.attachViewToParent(paramView, paramInt, paramLayoutParams);
    String str1 = "";
    paramLayoutParams = str1;
    BaseTimeLineItem.BaseViewHolder localBaseViewHolder;
    boolean bool1;
    f localf;
    String str2;
    if (paramView.getTag() != null)
    {
      paramLayoutParams = str1;
      if ((paramView.getTag() instanceof BaseTimeLineItem.BaseViewHolder))
      {
        localBaseViewHolder = (BaseTimeLineItem.BaseViewHolder)paramView.getTag();
        str1 = localBaseViewHolder.position + " " + localBaseViewHolder.dgg;
        if ((localBaseViewHolder.timeLineObject.Ett != 1) && (localBaseViewHolder.timeLineObject.evt != 1)) {
          break label496;
        }
        bool1 = true;
        f.wQY.bA(localBaseViewHolder.timeLineObject.Id, bool1);
        localf = f.wQY;
        str2 = localBaseViewHolder.timeLineObject.Id;
        if (localBaseViewHolder.timeLineObject.Etl != null) {
          break label502;
        }
      }
    }
    label496:
    label502:
    for (paramLayoutParams = "";; paramLayoutParams = localBaseViewHolder.timeLineObject.Etl.Id)
    {
      localf.iN(str2, paramLayoutParams);
      f.wQY.sT(localBaseViewHolder.xQn);
      if ((this.xjv != null) && (localBaseViewHolder.isAd)) {
        this.xjv.a(localBaseViewHolder.position, localBaseViewHolder.dgg, localBaseViewHolder.rVk, paramView, localBaseViewHolder.xQn, localBaseViewHolder.snsobj, localBaseViewHolder.nBH, 1);
      }
      if ((!this.xjz.contains(localBaseViewHolder.dpC)) && (((localBaseViewHolder.isAd) && (localBaseViewHolder.timeLineObject.Etm.DaB == 15)) || (localBaseViewHolder.timeLineObject.Etm.DaB == 18)))
      {
        boolean bool2 = false;
        bool1 = bool2;
        if (localBaseViewHolder.timeLineObject.Etm.DaB == 15)
        {
          bool1 = bool2;
          if ((localBaseViewHolder.xOO.xsn instanceof SightPlayImageView)) {
            bool1 = localBaseViewHolder.xOO.xsn.wsq.dqq();
          }
        }
        m.a(af.dtu().apJ(localBaseViewHolder.dpC), false, bool1, 0);
        this.xjz.add(localBaseViewHolder.dpC);
      }
      if (this.xjw != null) {
        this.xjw.a(localBaseViewHolder.dgg, localBaseViewHolder.timeLineObject);
      }
      if (this.xjx != null) {
        this.xjx.a(localBaseViewHolder.position, localBaseViewHolder.dgg, localBaseViewHolder.xQn, localBaseViewHolder.timeLineObject, localBaseViewHolder.isAd, localBaseViewHolder.wAe);
      }
      c(localBaseViewHolder);
      paramLayoutParams = str1;
      if (ab.hWe) {
        ad.d("MicroMsg.AdListView", "3childview  onAdded " + paramLayoutParams + " count:" + getChildCount());
      }
      AppMethodBeat.o(97679);
      return;
      bool1 = false;
      break;
    }
  }
  
  protected void detachViewFromParent(int paramInt)
  {
    AppMethodBeat.i(97678);
    if (ab.hWe) {
      ad.d("MicroMsg.AdListView", "2childview  onRemoved " + paramInt + " count:" + getChildCount());
    }
    super.detachViewFromParent(paramInt);
    AppMethodBeat.o(97678);
  }
  
  protected void detachViewFromParent(View paramView)
  {
    AppMethodBeat.i(97677);
    String str = "";
    Object localObject = str;
    if (paramView.getTag() != null)
    {
      localObject = str;
      if ((paramView.getTag() instanceof BaseTimeLineItem.BaseViewHolder))
      {
        localObject = (BaseTimeLineItem.BaseViewHolder)paramView.getTag();
        localObject = ((BaseTimeLineItem.BaseViewHolder)localObject).position + " " + ((BaseTimeLineItem.BaseViewHolder)localObject).dgg;
      }
    }
    if (ab.hWe) {
      ad.d("MicroMsg.AdListView", "1childview  onRemoved " + (String)localObject + " count:" + getChildCount());
    }
    super.detachViewFromParent(paramView);
    AppMethodBeat.o(97677);
  }
  
  protected void detachViewsFromParent(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(97684);
    int i = paramInt1;
    while (i < paramInt1 + paramInt2)
    {
      View localView = getChildAt(i);
      String str = "";
      Object localObject = str;
      if (localView.getTag() != null)
      {
        localObject = str;
        if ((localView.getTag() instanceof BaseTimeLineItem.BaseViewHolder))
        {
          localObject = (BaseTimeLineItem.BaseViewHolder)localView.getTag();
          if ((this.xjv != null) && (((BaseTimeLineItem.BaseViewHolder)localObject).isAd)) {
            this.xjv.o(((BaseTimeLineItem.BaseViewHolder)localObject).position, ((BaseTimeLineItem.BaseViewHolder)localObject).dgg, 1);
          }
          if (this.xjw != null) {
            this.xjw.aoq(((BaseTimeLineItem.BaseViewHolder)localObject).dgg);
          }
          if (this.xjx != null) {
            this.xjx.a(((BaseTimeLineItem.BaseViewHolder)localObject).position, ((BaseTimeLineItem.BaseViewHolder)localObject).dgg, ((BaseTimeLineItem.BaseViewHolder)localObject).xQn, ((BaseTimeLineItem.BaseViewHolder)localObject).timeLineObject, ((BaseTimeLineItem.BaseViewHolder)localObject).isAd);
          }
          localObject = ((BaseTimeLineItem.BaseViewHolder)localObject).position + " " + ((BaseTimeLineItem.BaseViewHolder)localObject).dgg;
        }
      }
      if (ab.hWe) {
        ad.d("MicroMsg.AdListView", "8removeView  detachViewsFromParent " + (String)localObject + " count:" + getChildCount());
      }
      i += 1;
    }
    super.detachViewsFromParent(paramInt1, paramInt2);
    AppMethodBeat.o(97684);
  }
  
  protected void layoutChildren()
  {
    AppMethodBeat.i(97675);
    super.layoutChildren();
    AppMethodBeat.o(97675);
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(97676);
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    AppMethodBeat.o(97676);
  }
  
  public void onViewAdded(View paramView)
  {
    AppMethodBeat.i(97680);
    String str2 = "";
    String str1 = str2;
    BaseTimeLineItem.BaseViewHolder localBaseViewHolder;
    boolean bool1;
    f localf;
    String str3;
    if (paramView.getTag() != null)
    {
      str1 = str2;
      if ((paramView.getTag() instanceof BaseTimeLineItem.BaseViewHolder))
      {
        localBaseViewHolder = (BaseTimeLineItem.BaseViewHolder)paramView.getTag();
        str2 = localBaseViewHolder.position + " " + localBaseViewHolder.dgg;
        if ((localBaseViewHolder.timeLineObject.Ett != 1) && (localBaseViewHolder.timeLineObject.evt != 1)) {
          break label489;
        }
        bool1 = true;
        f.wQY.bA(localBaseViewHolder.timeLineObject.Id, bool1);
        localf = f.wQY;
        str3 = localBaseViewHolder.timeLineObject.Id;
        if (localBaseViewHolder.timeLineObject.Etl != null) {
          break label494;
        }
      }
    }
    label489:
    label494:
    for (str1 = "";; str1 = localBaseViewHolder.timeLineObject.Etl.Id)
    {
      localf.iN(str3, str1);
      f.wQY.sT(localBaseViewHolder.xQn);
      if ((this.xjv != null) && (localBaseViewHolder.isAd)) {
        this.xjv.a(localBaseViewHolder.position, localBaseViewHolder.dgg, localBaseViewHolder.rVk, paramView, localBaseViewHolder.xQn, localBaseViewHolder.snsobj, localBaseViewHolder.nBH, 1);
      }
      if ((!this.xjz.contains(localBaseViewHolder.dpC)) && (((localBaseViewHolder.isAd) && (localBaseViewHolder.timeLineObject.Etm.DaB == 15)) || (localBaseViewHolder.timeLineObject.Etm.DaB == 18)))
      {
        boolean bool2 = false;
        bool1 = bool2;
        if (localBaseViewHolder.timeLineObject.Etm.DaB == 15)
        {
          bool1 = bool2;
          if ((localBaseViewHolder.xOO.xsn instanceof SightPlayImageView)) {
            bool1 = localBaseViewHolder.xOO.xsn.wsq.dqq();
          }
        }
        m.a(af.dtu().apJ(localBaseViewHolder.dpC), false, bool1, 0);
        this.xjz.add(localBaseViewHolder.dpC);
      }
      if (this.xjw != null) {
        this.xjw.a(localBaseViewHolder.dgg, localBaseViewHolder.timeLineObject);
      }
      if (this.xjx != null) {
        this.xjx.a(localBaseViewHolder.position, localBaseViewHolder.dgg, localBaseViewHolder.xQn, localBaseViewHolder.timeLineObject, localBaseViewHolder.isAd, localBaseViewHolder.wAe);
      }
      c(localBaseViewHolder);
      str1 = str2;
      if (ab.hWe) {
        ad.d("MicroMsg.AdListView", "4childview  onViewAdded " + str1 + " count:" + getChildCount());
      }
      AppMethodBeat.o(97680);
      return;
      bool1 = false;
      break;
    }
  }
  
  public void onViewRemoved(View paramView)
  {
    AppMethodBeat.i(97681);
    Object localObject2 = "";
    Object localObject1 = localObject2;
    int i;
    p.a locala;
    String str1;
    String str2;
    if (paramView.getTag() != null)
    {
      localObject1 = localObject2;
      if ((paramView.getTag() instanceof BaseTimeLineItem.BaseViewHolder))
      {
        localObject1 = (BaseTimeLineItem.BaseViewHolder)paramView.getTag();
        paramView = ((BaseTimeLineItem.BaseViewHolder)localObject1).position + " " + ((BaseTimeLineItem.BaseViewHolder)localObject1).dgg;
        if ((this.xjv != null) && (((BaseTimeLineItem.BaseViewHolder)localObject1).isAd)) {
          this.xjv.o(((BaseTimeLineItem.BaseViewHolder)localObject1).position, ((BaseTimeLineItem.BaseViewHolder)localObject1).dgg, 1);
        }
        if (this.xjw != null) {
          this.xjw.aoq(((BaseTimeLineItem.BaseViewHolder)localObject1).dgg);
        }
        if (this.xjx != null) {
          this.xjx.a(((BaseTimeLineItem.BaseViewHolder)localObject1).position, ((BaseTimeLineItem.BaseViewHolder)localObject1).dgg, ((BaseTimeLineItem.BaseViewHolder)localObject1).xQn, ((BaseTimeLineItem.BaseViewHolder)localObject1).timeLineObject, ((BaseTimeLineItem.BaseViewHolder)localObject1).isAd);
        }
        if (((BaseTimeLineItem.BaseViewHolder)localObject1).timeLineObject.Etm.DaB != 3) {
          break label481;
        }
        localObject2 = af.dtu().apJ(((BaseTimeLineItem.BaseViewHolder)localObject1).dpC);
        if (localObject2 != null) {
          break label313;
        }
        i = 0;
        locala = p.a.hxl;
        str1 = ((BaseTimeLineItem.BaseViewHolder)localObject1).timeLineObject.xns;
        str2 = com.tencent.mm.plugin.sns.data.q.st(((BaseTimeLineItem.BaseViewHolder)localObject1).xQn);
        if (bt.isNullOrNil(str1)) {
          break label481;
        }
        localObject1 = new byte[0];
      }
    }
    try
    {
      localObject2 = Base64.decode(str1, 0);
      localObject1 = localObject2;
    }
    catch (Exception localException2)
    {
      for (;;)
      {
        label313:
        ad.printErrStackTrace("MicroMsg.SnsStatExtUtil", localException2, "", new Object[0]);
      }
    }
    localObject2 = new cxi();
    for (;;)
    {
      try
      {
        ((cxi)localObject2).parseFrom((byte[])localObject1);
        localObject1 = ((cxi)localObject2).Ept;
        if (localObject1 != null) {
          continue;
        }
        localObject1 = paramView;
      }
      catch (Exception localException1)
      {
        ad.printErrStackTrace("MicroMsg.SnsStatExtUtil", localException1, "", new Object[0]);
        localView = paramView;
        continue;
        ad.i("MicroMsg.SnsStatExtUtil", "report adPageExposure(13235): scene(%d), statExtStr:%s(id=%s, uxinfo=%s)", new Object[] { Integer.valueOf(locala.value), str1, localException2.Ept.Epw, localException2.Ept.CoM });
        ((com.tencent.mm.plugin.sns.c.d)g.ab(com.tencent.mm.plugin.sns.c.d.class)).a(13235, i, new Object[] { locala.value, localException2.Ept.Epw, localException2.Ept.CoM, str2 });
      }
      if (ab.hWe) {
        ad.d("MicroMsg.AdListView", "5childview  onViewRemoved " + (String)localObject1 + " count:" + getChildCount());
      }
      AppMethodBeat.o(97681);
      return;
      i = ((p)localObject2).dyi();
      break;
      label481:
      View localView = paramView;
    }
  }
  
  public void removeView(View paramView)
  {
    AppMethodBeat.i(97683);
    super.removeView(paramView);
    String str2 = "";
    String str1 = str2;
    if (paramView.getTag() != null)
    {
      str1 = str2;
      if ((paramView.getTag() instanceof BaseTimeLineItem.BaseViewHolder))
      {
        paramView = (BaseTimeLineItem.BaseViewHolder)paramView.getTag();
        str1 = paramView.position + " " + paramView.dgg;
      }
    }
    if (ab.hWe) {
      ad.d("MicroMsg.AdListView", "7removeView  onViewRemoved " + str1 + " count:" + getChildCount());
    }
    AppMethodBeat.o(97683);
  }
  
  public void removeViewInLayout(View paramView)
  {
    AppMethodBeat.i(97682);
    String str = "";
    Object localObject = str;
    if (paramView.getTag() != null)
    {
      localObject = str;
      if ((paramView.getTag() instanceof BaseTimeLineItem.BaseViewHolder))
      {
        localObject = (BaseTimeLineItem.BaseViewHolder)paramView.getTag();
        localObject = ((BaseTimeLineItem.BaseViewHolder)localObject).position + " " + ((BaseTimeLineItem.BaseViewHolder)localObject).dgg;
      }
    }
    if (ab.hWe) {
      ad.d("MicroMsg.AdListView", "6removeViewInLayout  onViewRemoved " + (String)localObject + " count:" + getChildCount());
    }
    super.removeViewInLayout(paramView);
    AppMethodBeat.o(97682);
  }
  
  public void setTimelineEvent(com.tencent.mm.plugin.sns.model.d paramd)
  {
    this.xjx = paramd;
  }
  
  public void setTimelineStat(e parame)
  {
    this.xjw = parame;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.AdListView
 * JD-Core Version:    0.7.0.1
 */