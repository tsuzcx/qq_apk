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
import com.tencent.mm.platformtools.ae;
import com.tencent.mm.plugin.sight.decode.ui.SightPlayImageView;
import com.tencent.mm.plugin.sns.a.b.k;
import com.tencent.mm.plugin.sns.b.c;
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.plugin.sns.model.ag;
import com.tencent.mm.plugin.sns.model.f;
import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.plugin.sns.storage.o;
import com.tencent.mm.plugin.sns.ui.item.BaseTimeLineItem.BaseViewHolder;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.cgh;
import com.tencent.mm.protocal.protobuf.cgi;
import com.tencent.mm.protocal.protobuf.du;
import com.tencent.mm.protocal.protobuf.vi;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.HashSet;

public class AdListView
  extends ListView
{
  com.tencent.mm.plugin.sns.a.b.b rDL;
  f rDM;
  private com.tencent.mm.plugin.sns.model.e rDN;
  private boolean rDO;
  private HashSet<String> rDP;
  
  public AdListView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(38054);
    this.rDO = true;
    this.rDP = new HashSet();
    AppMethodBeat.o(38054);
  }
  
  public AdListView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(38053);
    this.rDO = true;
    this.rDP = new HashSet();
    AppMethodBeat.o(38053);
  }
  
  protected void attachViewToParent(View paramView, int paramInt, ViewGroup.LayoutParams paramLayoutParams)
  {
    AppMethodBeat.i(38059);
    super.attachViewToParent(paramView, paramInt, paramLayoutParams);
    String str1 = "";
    paramLayoutParams = str1;
    BaseTimeLineItem.BaseViewHolder localBaseViewHolder;
    boolean bool1;
    com.tencent.mm.plugin.sns.i.e locale;
    String str2;
    if (paramView.getTag() != null)
    {
      paramLayoutParams = str1;
      if ((paramView.getTag() instanceof BaseTimeLineItem.BaseViewHolder))
      {
        localBaseViewHolder = (BaseTimeLineItem.BaseViewHolder)paramView.getTag();
        str1 = localBaseViewHolder.position + " " + localBaseViewHolder.crk;
        if ((localBaseViewHolder.timeLineObject.xTZ != 1) && (localBaseViewHolder.timeLineObject.dqG != 1)) {
          break label494;
        }
        bool1 = true;
        com.tencent.mm.plugin.sns.i.e.roN.br(localBaseViewHolder.timeLineObject.Id, bool1);
        locale = com.tencent.mm.plugin.sns.i.e.roN;
        str2 = localBaseViewHolder.timeLineObject.Id;
        if (localBaseViewHolder.timeLineObject.xTR != null) {
          break label500;
        }
      }
    }
    label494:
    label500:
    for (paramLayoutParams = "";; paramLayoutParams = localBaseViewHolder.timeLineObject.xTR.Id)
    {
      locale.gt(str2, paramLayoutParams);
      com.tencent.mm.plugin.sns.i.e.roN.lN(localBaseViewHolder.sgK);
      if ((this.rDL != null) && (localBaseViewHolder.raZ)) {
        this.rDL.a(localBaseViewHolder.position, localBaseViewHolder.crk, localBaseViewHolder.nmm, paramView, localBaseViewHolder.sgK, localBaseViewHolder.snsobj, localBaseViewHolder.kwo, 1);
      }
      if ((!this.rDP.contains(localBaseViewHolder.czw)) && (((localBaseViewHolder.raZ) && (localBaseViewHolder.timeLineObject.xTS.wNZ == 15)) || (localBaseViewHolder.timeLineObject.xTS.wNZ == 18)))
      {
        boolean bool2 = false;
        bool1 = bool2;
        if (localBaseViewHolder.timeLineObject.xTS.wNZ == 15)
        {
          bool1 = bool2;
          if ((localBaseViewHolder.sfG.qVe instanceof SightPlayImageView)) {
            bool1 = ((SightPlayImageView)localBaseViewHolder.sfG.qVe).qTR.cmA();
          }
        }
        k.a(ag.cpf().abu(localBaseViewHolder.czw), false, bool1, 0);
        this.rDP.add(localBaseViewHolder.czw);
      }
      if (this.rDM != null) {
        this.rDM.a(localBaseViewHolder.crk, localBaseViewHolder.timeLineObject);
      }
      if (this.rDN != null) {
        this.rDN.a(localBaseViewHolder.position, localBaseViewHolder.crk, localBaseViewHolder.sgK, localBaseViewHolder.timeLineObject, localBaseViewHolder.raZ, localBaseViewHolder.rba);
      }
      paramLayoutParams = str1;
      if (ae.glk) {
        ab.d("MicroMsg.AdListView", "3childview  onAdded " + paramLayoutParams + " count:" + getChildCount());
      }
      AppMethodBeat.o(38059);
      return;
      bool1 = false;
      break;
    }
  }
  
  protected void detachViewFromParent(int paramInt)
  {
    AppMethodBeat.i(38058);
    if (ae.glk) {
      ab.d("MicroMsg.AdListView", "2childview  onRemoved " + paramInt + " count:" + getChildCount());
    }
    super.detachViewFromParent(paramInt);
    AppMethodBeat.o(38058);
  }
  
  protected void detachViewFromParent(View paramView)
  {
    AppMethodBeat.i(38057);
    String str = "";
    Object localObject = str;
    if (paramView.getTag() != null)
    {
      localObject = str;
      if ((paramView.getTag() instanceof BaseTimeLineItem.BaseViewHolder))
      {
        localObject = (BaseTimeLineItem.BaseViewHolder)paramView.getTag();
        localObject = ((BaseTimeLineItem.BaseViewHolder)localObject).position + " " + ((BaseTimeLineItem.BaseViewHolder)localObject).crk;
      }
    }
    if (ae.glk) {
      ab.d("MicroMsg.AdListView", "1childview  onRemoved " + (String)localObject + " count:" + getChildCount());
    }
    super.detachViewFromParent(paramView);
    AppMethodBeat.o(38057);
  }
  
  protected void detachViewsFromParent(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(38064);
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
          if ((this.rDL != null) && (((BaseTimeLineItem.BaseViewHolder)localObject).raZ)) {
            this.rDL.k(((BaseTimeLineItem.BaseViewHolder)localObject).position, ((BaseTimeLineItem.BaseViewHolder)localObject).crk, 1);
          }
          if (this.rDM != null) {
            this.rDM.aai(((BaseTimeLineItem.BaseViewHolder)localObject).crk);
          }
          if (this.rDN != null) {
            this.rDN.a(((BaseTimeLineItem.BaseViewHolder)localObject).position, ((BaseTimeLineItem.BaseViewHolder)localObject).crk, ((BaseTimeLineItem.BaseViewHolder)localObject).sgK, ((BaseTimeLineItem.BaseViewHolder)localObject).timeLineObject, ((BaseTimeLineItem.BaseViewHolder)localObject).raZ);
          }
          localObject = ((BaseTimeLineItem.BaseViewHolder)localObject).position + " " + ((BaseTimeLineItem.BaseViewHolder)localObject).crk;
        }
      }
      if (ae.glk) {
        ab.d("MicroMsg.AdListView", "8removeView  detachViewsFromParent " + (String)localObject + " count:" + getChildCount());
      }
      i += 1;
    }
    super.detachViewsFromParent(paramInt1, paramInt2);
    AppMethodBeat.o(38064);
  }
  
  protected void layoutChildren()
  {
    AppMethodBeat.i(38055);
    super.layoutChildren();
    AppMethodBeat.o(38055);
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(38056);
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    AppMethodBeat.o(38056);
  }
  
  public void onViewAdded(View paramView)
  {
    AppMethodBeat.i(38060);
    String str2 = "";
    String str1 = str2;
    BaseTimeLineItem.BaseViewHolder localBaseViewHolder;
    boolean bool1;
    com.tencent.mm.plugin.sns.i.e locale;
    String str3;
    if (paramView.getTag() != null)
    {
      str1 = str2;
      if ((paramView.getTag() instanceof BaseTimeLineItem.BaseViewHolder))
      {
        localBaseViewHolder = (BaseTimeLineItem.BaseViewHolder)paramView.getTag();
        str2 = localBaseViewHolder.position + " " + localBaseViewHolder.crk;
        if ((localBaseViewHolder.timeLineObject.xTZ != 1) && (localBaseViewHolder.timeLineObject.dqG != 1)) {
          break label487;
        }
        bool1 = true;
        com.tencent.mm.plugin.sns.i.e.roN.br(localBaseViewHolder.timeLineObject.Id, bool1);
        locale = com.tencent.mm.plugin.sns.i.e.roN;
        str3 = localBaseViewHolder.timeLineObject.Id;
        if (localBaseViewHolder.timeLineObject.xTR != null) {
          break label492;
        }
      }
    }
    label487:
    label492:
    for (str1 = "";; str1 = localBaseViewHolder.timeLineObject.xTR.Id)
    {
      locale.gt(str3, str1);
      com.tencent.mm.plugin.sns.i.e.roN.lN(localBaseViewHolder.sgK);
      if ((this.rDL != null) && (localBaseViewHolder.raZ)) {
        this.rDL.a(localBaseViewHolder.position, localBaseViewHolder.crk, localBaseViewHolder.nmm, paramView, localBaseViewHolder.sgK, localBaseViewHolder.snsobj, localBaseViewHolder.kwo, 1);
      }
      if ((!this.rDP.contains(localBaseViewHolder.czw)) && (((localBaseViewHolder.raZ) && (localBaseViewHolder.timeLineObject.xTS.wNZ == 15)) || (localBaseViewHolder.timeLineObject.xTS.wNZ == 18)))
      {
        boolean bool2 = false;
        bool1 = bool2;
        if (localBaseViewHolder.timeLineObject.xTS.wNZ == 15)
        {
          bool1 = bool2;
          if ((localBaseViewHolder.sfG.qVe instanceof SightPlayImageView)) {
            bool1 = ((SightPlayImageView)localBaseViewHolder.sfG.qVe).qTR.cmA();
          }
        }
        k.a(ag.cpf().abu(localBaseViewHolder.czw), false, bool1, 0);
        this.rDP.add(localBaseViewHolder.czw);
      }
      if (this.rDM != null) {
        this.rDM.a(localBaseViewHolder.crk, localBaseViewHolder.timeLineObject);
      }
      if (this.rDN != null) {
        this.rDN.a(localBaseViewHolder.position, localBaseViewHolder.crk, localBaseViewHolder.sgK, localBaseViewHolder.timeLineObject, localBaseViewHolder.raZ, localBaseViewHolder.rba);
      }
      str1 = str2;
      if (ae.glk) {
        ab.d("MicroMsg.AdListView", "4childview  onViewAdded " + str1 + " count:" + getChildCount());
      }
      AppMethodBeat.o(38060);
      return;
      bool1 = false;
      break;
    }
  }
  
  public void onViewRemoved(View paramView)
  {
    AppMethodBeat.i(38061);
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
        paramView = ((BaseTimeLineItem.BaseViewHolder)localObject1).position + " " + ((BaseTimeLineItem.BaseViewHolder)localObject1).crk;
        if ((this.rDL != null) && (((BaseTimeLineItem.BaseViewHolder)localObject1).raZ)) {
          this.rDL.k(((BaseTimeLineItem.BaseViewHolder)localObject1).position, ((BaseTimeLineItem.BaseViewHolder)localObject1).crk, 1);
        }
        if (this.rDM != null) {
          this.rDM.aai(((BaseTimeLineItem.BaseViewHolder)localObject1).crk);
        }
        if (this.rDN != null) {
          this.rDN.a(((BaseTimeLineItem.BaseViewHolder)localObject1).position, ((BaseTimeLineItem.BaseViewHolder)localObject1).crk, ((BaseTimeLineItem.BaseViewHolder)localObject1).sgK, ((BaseTimeLineItem.BaseViewHolder)localObject1).timeLineObject, ((BaseTimeLineItem.BaseViewHolder)localObject1).raZ);
        }
        if (((BaseTimeLineItem.BaseViewHolder)localObject1).timeLineObject.xTS.wNZ != 3) {
          break label480;
        }
        localObject2 = ag.cpf().abu(((BaseTimeLineItem.BaseViewHolder)localObject1).czw);
        if (localObject2 != null) {
          break label313;
        }
        i = 0;
        locala = p.a.fUC;
        str1 = ((BaseTimeLineItem.BaseViewHolder)localObject1).timeLineObject.rHA;
        str2 = i.lq(((BaseTimeLineItem.BaseViewHolder)localObject1).sgK);
        if (bo.isNullOrNil(str1)) {
          break label480;
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
        ab.printErrStackTrace("MicroMsg.SnsStatExtUtil", localException2, null, new Object[0]);
      }
    }
    localObject2 = new cgh();
    for (;;)
    {
      try
      {
        ((cgh)localObject2).parseFrom((byte[])localObject1);
        localObject1 = ((cgh)localObject2).xQY;
        if (localObject1 != null) {
          continue;
        }
        localObject1 = paramView;
      }
      catch (Exception localException1)
      {
        ab.printErrStackTrace("MicroMsg.SnsStatExtUtil", localException1, "", new Object[0]);
        localView = paramView;
        continue;
        ab.i("MicroMsg.SnsStatExtUtil", "report adPageExposure(13235): scene(%d), statExtStr:%s(id=%s, uxinfo=%s)", new Object[] { Integer.valueOf(locala.value), str1, localException2.xQY.xRb, localException2.xQY.xRc });
        ((c)g.E(c.class)).a(13235, i, new Object[] { locala.value, localException2.xQY.xRb, localException2.xQY.xRc, str2 });
      }
      if (ae.glk) {
        ab.d("MicroMsg.AdListView", "5childview  onViewRemoved " + (String)localObject1 + " count:" + getChildCount());
      }
      AppMethodBeat.o(38061);
      return;
      i = ((n)localObject2).csR();
      break;
      label480:
      View localView = paramView;
    }
  }
  
  public void removeView(View paramView)
  {
    AppMethodBeat.i(38063);
    super.removeView(paramView);
    String str2 = "";
    String str1 = str2;
    if (paramView.getTag() != null)
    {
      str1 = str2;
      if ((paramView.getTag() instanceof BaseTimeLineItem.BaseViewHolder))
      {
        paramView = (BaseTimeLineItem.BaseViewHolder)paramView.getTag();
        str1 = paramView.position + " " + paramView.crk;
      }
    }
    if (ae.glk) {
      ab.d("MicroMsg.AdListView", "7removeView  onViewRemoved " + str1 + " count:" + getChildCount());
    }
    AppMethodBeat.o(38063);
  }
  
  public void removeViewInLayout(View paramView)
  {
    AppMethodBeat.i(38062);
    String str = "";
    Object localObject = str;
    if (paramView.getTag() != null)
    {
      localObject = str;
      if ((paramView.getTag() instanceof BaseTimeLineItem.BaseViewHolder))
      {
        localObject = (BaseTimeLineItem.BaseViewHolder)paramView.getTag();
        localObject = ((BaseTimeLineItem.BaseViewHolder)localObject).position + " " + ((BaseTimeLineItem.BaseViewHolder)localObject).crk;
      }
    }
    if (ae.glk) {
      ab.d("MicroMsg.AdListView", "6removeViewInLayout  onViewRemoved " + (String)localObject + " count:" + getChildCount());
    }
    super.removeViewInLayout(paramView);
    AppMethodBeat.o(38062);
  }
  
  public void setTimelineEvent(com.tencent.mm.plugin.sns.model.e parame)
  {
    this.rDN = parame;
  }
  
  public void setTimelineStat(f paramf)
  {
    this.rDM = paramf;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.AdListView
 * JD-Core Version:    0.7.0.1
 */