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
import com.tencent.mm.plugin.sns.ad.d.m;
import com.tencent.mm.plugin.sns.j.f;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.plugin.sns.model.as;
import com.tencent.mm.plugin.sns.model.e;
import com.tencent.mm.plugin.sns.storage.p;
import com.tencent.mm.plugin.sns.ui.item.BaseTimeLineItem.BaseViewHolder;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.dcu;
import com.tencent.mm.protocal.protobuf.dcv;
import com.tencent.mm.protocal.protobuf.ej;
import com.tencent.mm.protocal.protobuf.zf;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import java.util.HashSet;

public class AdListView
  extends ListView
{
  com.tencent.mm.plugin.sns.ad.d.d ywm;
  e ywn;
  private com.tencent.mm.plugin.sns.model.d ywo;
  private boolean ywp;
  private HashSet<String> ywq;
  
  public AdListView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(97674);
    this.ywp = true;
    this.ywq = new HashSet();
    AppMethodBeat.o(97674);
  }
  
  public AdListView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(97673);
    this.ywp = true;
    this.ywq = new HashSet();
    AppMethodBeat.o(97673);
  }
  
  private static void c(BaseTimeLineItem.BaseViewHolder paramBaseViewHolder)
  {
    AppMethodBeat.i(179144);
    af.dIa().xt(paramBaseViewHolder.zdd);
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
        str1 = localBaseViewHolder.position + " " + localBaseViewHolder.ddB;
        if ((localBaseViewHolder.timeLineObject.FQv != 1) && (localBaseViewHolder.timeLineObject.exP != 1)) {
          break label496;
        }
        bool1 = true;
        f.ydE.bH(localBaseViewHolder.timeLineObject.Id, bool1);
        localf = f.ydE;
        str2 = localBaseViewHolder.timeLineObject.Id;
        if (localBaseViewHolder.timeLineObject.FQn != null) {
          break label502;
        }
      }
    }
    label496:
    label502:
    for (paramLayoutParams = "";; paramLayoutParams = localBaseViewHolder.timeLineObject.FQn.Id)
    {
      localf.jk(str2, paramLayoutParams);
      f.ydE.xw(localBaseViewHolder.zdd);
      if ((this.ywm != null) && (localBaseViewHolder.isAd)) {
        this.ywm.a(localBaseViewHolder.position, localBaseViewHolder.ddB, localBaseViewHolder.tdc, paramView, localBaseViewHolder.zdd, localBaseViewHolder.snsobj, localBaseViewHolder.oeH, 1);
      }
      if ((!this.ywq.contains(localBaseViewHolder.dnn)) && (((localBaseViewHolder.isAd) && (localBaseViewHolder.timeLineObject.FQo.Ety == 15)) || (localBaseViewHolder.timeLineObject.FQo.Ety == 18)))
      {
        boolean bool2 = false;
        bool1 = bool2;
        if (localBaseViewHolder.timeLineObject.FQo.Ety == 15)
        {
          bool1 = bool2;
          if ((localBaseViewHolder.zbE.yFd instanceof SightPlayImageView)) {
            bool1 = localBaseViewHolder.zbE.yFd.xDG.dEz();
          }
        }
        m.a(af.dHR().auS(localBaseViewHolder.dnn), false, bool1, 0);
        this.ywq.add(localBaseViewHolder.dnn);
      }
      if (this.ywn != null) {
        this.ywn.a(localBaseViewHolder.ddB, localBaseViewHolder.timeLineObject);
      }
      if (this.ywo != null) {
        this.ywo.a(localBaseViewHolder.position, localBaseViewHolder.ddB, localBaseViewHolder.zdd, localBaseViewHolder.timeLineObject, localBaseViewHolder.isAd, localBaseViewHolder.xMy);
      }
      c(localBaseViewHolder);
      paramLayoutParams = str1;
      if (ab.iwi) {
        ac.d("MicroMsg.AdListView", "3childview  onAdded " + paramLayoutParams + " count:" + getChildCount());
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
    if (ab.iwi) {
      ac.d("MicroMsg.AdListView", "2childview  onRemoved " + paramInt + " count:" + getChildCount());
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
        localObject = ((BaseTimeLineItem.BaseViewHolder)localObject).position + " " + ((BaseTimeLineItem.BaseViewHolder)localObject).ddB;
      }
    }
    if (ab.iwi) {
      ac.d("MicroMsg.AdListView", "1childview  onRemoved " + (String)localObject + " count:" + getChildCount());
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
          if ((this.ywm != null) && (((BaseTimeLineItem.BaseViewHolder)localObject).isAd)) {
            this.ywm.q(((BaseTimeLineItem.BaseViewHolder)localObject).position, ((BaseTimeLineItem.BaseViewHolder)localObject).ddB, 1);
          }
          if (this.ywn != null) {
            this.ywn.atC(((BaseTimeLineItem.BaseViewHolder)localObject).ddB);
          }
          if (this.ywo != null) {
            this.ywo.a(((BaseTimeLineItem.BaseViewHolder)localObject).position, ((BaseTimeLineItem.BaseViewHolder)localObject).ddB, ((BaseTimeLineItem.BaseViewHolder)localObject).zdd, ((BaseTimeLineItem.BaseViewHolder)localObject).timeLineObject, ((BaseTimeLineItem.BaseViewHolder)localObject).isAd);
          }
          localObject = ((BaseTimeLineItem.BaseViewHolder)localObject).position + " " + ((BaseTimeLineItem.BaseViewHolder)localObject).ddB;
        }
      }
      if (ab.iwi) {
        ac.d("MicroMsg.AdListView", "8removeView  detachViewsFromParent " + (String)localObject + " count:" + getChildCount());
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
        str2 = localBaseViewHolder.position + " " + localBaseViewHolder.ddB;
        if ((localBaseViewHolder.timeLineObject.FQv != 1) && (localBaseViewHolder.timeLineObject.exP != 1)) {
          break label489;
        }
        bool1 = true;
        f.ydE.bH(localBaseViewHolder.timeLineObject.Id, bool1);
        localf = f.ydE;
        str3 = localBaseViewHolder.timeLineObject.Id;
        if (localBaseViewHolder.timeLineObject.FQn != null) {
          break label494;
        }
      }
    }
    label489:
    label494:
    for (str1 = "";; str1 = localBaseViewHolder.timeLineObject.FQn.Id)
    {
      localf.jk(str3, str1);
      f.ydE.xw(localBaseViewHolder.zdd);
      if ((this.ywm != null) && (localBaseViewHolder.isAd)) {
        this.ywm.a(localBaseViewHolder.position, localBaseViewHolder.ddB, localBaseViewHolder.tdc, paramView, localBaseViewHolder.zdd, localBaseViewHolder.snsobj, localBaseViewHolder.oeH, 1);
      }
      if ((!this.ywq.contains(localBaseViewHolder.dnn)) && (((localBaseViewHolder.isAd) && (localBaseViewHolder.timeLineObject.FQo.Ety == 15)) || (localBaseViewHolder.timeLineObject.FQo.Ety == 18)))
      {
        boolean bool2 = false;
        bool1 = bool2;
        if (localBaseViewHolder.timeLineObject.FQo.Ety == 15)
        {
          bool1 = bool2;
          if ((localBaseViewHolder.zbE.yFd instanceof SightPlayImageView)) {
            bool1 = localBaseViewHolder.zbE.yFd.xDG.dEz();
          }
        }
        m.a(af.dHR().auS(localBaseViewHolder.dnn), false, bool1, 0);
        this.ywq.add(localBaseViewHolder.dnn);
      }
      if (this.ywn != null) {
        this.ywn.a(localBaseViewHolder.ddB, localBaseViewHolder.timeLineObject);
      }
      if (this.ywo != null) {
        this.ywo.a(localBaseViewHolder.position, localBaseViewHolder.ddB, localBaseViewHolder.zdd, localBaseViewHolder.timeLineObject, localBaseViewHolder.isAd, localBaseViewHolder.xMy);
      }
      c(localBaseViewHolder);
      str1 = str2;
      if (ab.iwi) {
        ac.d("MicroMsg.AdListView", "4childview  onViewAdded " + str1 + " count:" + getChildCount());
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
        paramView = ((BaseTimeLineItem.BaseViewHolder)localObject1).position + " " + ((BaseTimeLineItem.BaseViewHolder)localObject1).ddB;
        if ((this.ywm != null) && (((BaseTimeLineItem.BaseViewHolder)localObject1).isAd)) {
          this.ywm.q(((BaseTimeLineItem.BaseViewHolder)localObject1).position, ((BaseTimeLineItem.BaseViewHolder)localObject1).ddB, 1);
        }
        if (this.ywn != null) {
          this.ywn.atC(((BaseTimeLineItem.BaseViewHolder)localObject1).ddB);
        }
        if (this.ywo != null) {
          this.ywo.a(((BaseTimeLineItem.BaseViewHolder)localObject1).position, ((BaseTimeLineItem.BaseViewHolder)localObject1).ddB, ((BaseTimeLineItem.BaseViewHolder)localObject1).zdd, ((BaseTimeLineItem.BaseViewHolder)localObject1).timeLineObject, ((BaseTimeLineItem.BaseViewHolder)localObject1).isAd);
        }
        if (((BaseTimeLineItem.BaseViewHolder)localObject1).timeLineObject.FQo.Ety != 3) {
          break label481;
        }
        localObject2 = af.dHR().auS(((BaseTimeLineItem.BaseViewHolder)localObject1).dnn);
        if (localObject2 != null) {
          break label313;
        }
        i = 0;
        locala = p.a.hXM;
        str1 = ((BaseTimeLineItem.BaseViewHolder)localObject1).timeLineObject.yAj;
        str2 = com.tencent.mm.plugin.sns.data.q.wW(((BaseTimeLineItem.BaseViewHolder)localObject1).zdd);
        if (bs.isNullOrNil(str1)) {
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
        ac.printErrStackTrace("MicroMsg.SnsStatExtUtil", localException2, "", new Object[0]);
      }
    }
    localObject2 = new dcu();
    for (;;)
    {
      try
      {
        ((dcu)localObject2).parseFrom((byte[])localObject1);
        localObject1 = ((dcu)localObject2).FMs;
        if (localObject1 != null) {
          continue;
        }
        localObject1 = paramView;
      }
      catch (Exception localException1)
      {
        ac.printErrStackTrace("MicroMsg.SnsStatExtUtil", localException1, "", new Object[0]);
        localView = paramView;
        continue;
        ac.i("MicroMsg.SnsStatExtUtil", "report adPageExposure(13235): scene(%d), statExtStr:%s(id=%s, uxinfo=%s)", new Object[] { Integer.valueOf(locala.value), str1, localException2.FMs.FMv, localException2.FMs.DHe });
        ((com.tencent.mm.plugin.sns.b.d)g.ab(com.tencent.mm.plugin.sns.b.d.class)).a(13235, i, new Object[] { locala.value, localException2.FMs.FMv, localException2.FMs.DHe, str2 });
      }
      if (ab.iwi) {
        ac.d("MicroMsg.AdListView", "5childview  onViewRemoved " + (String)localObject1 + " count:" + getChildCount());
      }
      AppMethodBeat.o(97681);
      return;
      i = ((p)localObject2).dMF();
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
        str1 = paramView.position + " " + paramView.ddB;
      }
    }
    if (ab.iwi) {
      ac.d("MicroMsg.AdListView", "7removeView  onViewRemoved " + str1 + " count:" + getChildCount());
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
        localObject = ((BaseTimeLineItem.BaseViewHolder)localObject).position + " " + ((BaseTimeLineItem.BaseViewHolder)localObject).ddB;
      }
    }
    if (ab.iwi) {
      ac.d("MicroMsg.AdListView", "6removeViewInLayout  onViewRemoved " + (String)localObject + " count:" + getChildCount());
    }
    super.removeViewInLayout(paramView);
    AppMethodBeat.o(97682);
  }
  
  public void setTimelineEvent(com.tencent.mm.plugin.sns.model.d paramd)
  {
    this.ywo = paramd;
  }
  
  public void setTimelineStat(e parame)
  {
    this.ywn = parame;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.AdListView
 * JD-Core Version:    0.7.0.1
 */