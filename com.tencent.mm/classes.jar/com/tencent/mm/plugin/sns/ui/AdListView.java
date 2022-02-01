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
import com.tencent.mm.platformtools.ac;
import com.tencent.mm.plugin.sight.decode.a.b;
import com.tencent.mm.plugin.sight.decode.ui.SightPlayImageView;
import com.tencent.mm.plugin.sns.ad.e.n;
import com.tencent.mm.plugin.sns.data.r;
import com.tencent.mm.plugin.sns.model.ah;
import com.tencent.mm.plugin.sns.model.au;
import com.tencent.mm.plugin.sns.model.f;
import com.tencent.mm.plugin.sns.storage.p;
import com.tencent.mm.plugin.sns.storage.q;
import com.tencent.mm.plugin.sns.ui.item.BaseTimeLineItem.BaseViewHolder;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.abo;
import com.tencent.mm.protocal.protobuf.djc;
import com.tencent.mm.protocal.protobuf.djd;
import com.tencent.mm.protocal.protobuf.en;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import java.util.HashSet;

public class AdListView
  extends ListView
{
  com.tencent.mm.plugin.sns.ad.e.d AeG;
  f AeH;
  private com.tencent.mm.plugin.sns.model.e AeI;
  private boolean AeJ;
  private HashSet<String> AeK;
  
  public AdListView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(97674);
    this.AeJ = true;
    this.AeK = new HashSet();
    AppMethodBeat.o(97674);
  }
  
  public AdListView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(97673);
    this.AeJ = true;
    this.AeK = new HashSet();
    AppMethodBeat.o(97673);
  }
  
  private static void f(BaseTimeLineItem.BaseViewHolder paramBaseViewHolder)
  {
    AppMethodBeat.i(179144);
    ah.dXN().Aq(paramBaseViewHolder.AMj);
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
    com.tencent.mm.plugin.sns.j.e locale;
    String str2;
    if (paramView.getTag() != null)
    {
      paramLayoutParams = str1;
      if ((paramView.getTag() instanceof BaseTimeLineItem.BaseViewHolder))
      {
        localBaseViewHolder = (BaseTimeLineItem.BaseViewHolder)paramView.getTag();
        str1 = localBaseViewHolder.position + " " + localBaseViewHolder.dqc;
        if ((localBaseViewHolder.timeLineObject.HUN != 1) && (localBaseViewHolder.timeLineObject.eQZ != 1)) {
          break label496;
        }
        bool1 = true;
        com.tencent.mm.plugin.sns.j.e.zKO.bS(localBaseViewHolder.timeLineObject.Id, bool1);
        locale = com.tencent.mm.plugin.sns.j.e.zKO;
        str2 = localBaseViewHolder.timeLineObject.Id;
        if (localBaseViewHolder.timeLineObject.HUF != null) {
          break label502;
        }
      }
    }
    label496:
    label502:
    for (paramLayoutParams = "";; paramLayoutParams = localBaseViewHolder.timeLineObject.HUF.Id)
    {
      locale.jD(str2, paramLayoutParams);
      com.tencent.mm.plugin.sns.j.e.zKO.As(localBaseViewHolder.AMj);
      if ((this.AeG != null) && (localBaseViewHolder.isAd)) {
        this.AeG.a(localBaseViewHolder.position, localBaseViewHolder.dqc, localBaseViewHolder.ulU, paramView, localBaseViewHolder.AMj, localBaseViewHolder.snsobj, localBaseViewHolder.oOD, 1);
      }
      if ((!this.AeK.contains(localBaseViewHolder.dAg)) && (((localBaseViewHolder.isAd) && (localBaseViewHolder.timeLineObject.HUG.Gtw == 15)) || (localBaseViewHolder.timeLineObject.HUG.Gtw == 18)))
      {
        boolean bool2 = false;
        bool1 = bool2;
        if (localBaseViewHolder.timeLineObject.HUG.Gtw == 15)
        {
          bool1 = bool2;
          if ((localBaseViewHolder.AKJ.AnH instanceof SightPlayImageView)) {
            bool1 = localBaseViewHolder.AKJ.AnH.ziA.dTz();
          }
        }
        n.a(ah.dXE().aBq(localBaseViewHolder.dAg), false, bool1, 0);
        this.AeK.add(localBaseViewHolder.dAg);
      }
      if (this.AeH != null) {
        this.AeH.a(localBaseViewHolder.dqc, localBaseViewHolder.timeLineObject);
      }
      if (this.AeI != null) {
        this.AeI.a(localBaseViewHolder.position, localBaseViewHolder.dqc, localBaseViewHolder.AMj, localBaseViewHolder.timeLineObject, localBaseViewHolder.isAd, localBaseViewHolder.ztd);
      }
      f(localBaseViewHolder);
      paramLayoutParams = str1;
      if (ac.iSj) {
        ae.d("MicroMsg.AdListView", "3childview  onAdded " + paramLayoutParams + " count:" + getChildCount());
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
    if (ac.iSj) {
      ae.d("MicroMsg.AdListView", "2childview  onRemoved " + paramInt + " count:" + getChildCount());
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
        localObject = ((BaseTimeLineItem.BaseViewHolder)localObject).position + " " + ((BaseTimeLineItem.BaseViewHolder)localObject).dqc;
      }
    }
    if (ac.iSj) {
      ae.d("MicroMsg.AdListView", "1childview  onRemoved " + (String)localObject + " count:" + getChildCount());
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
          if ((this.AeG != null) && (((BaseTimeLineItem.BaseViewHolder)localObject).isAd)) {
            this.AeG.a(((BaseTimeLineItem.BaseViewHolder)localObject).position, ((BaseTimeLineItem.BaseViewHolder)localObject).dqc, ((BaseTimeLineItem.BaseViewHolder)localObject).AMj, 1);
          }
          if (this.AeH != null) {
            this.AeH.azY(((BaseTimeLineItem.BaseViewHolder)localObject).dqc);
          }
          if (this.AeI != null) {
            this.AeI.a(((BaseTimeLineItem.BaseViewHolder)localObject).position, ((BaseTimeLineItem.BaseViewHolder)localObject).dqc, ((BaseTimeLineItem.BaseViewHolder)localObject).AMj, ((BaseTimeLineItem.BaseViewHolder)localObject).timeLineObject, ((BaseTimeLineItem.BaseViewHolder)localObject).isAd);
          }
          localObject = ((BaseTimeLineItem.BaseViewHolder)localObject).position + " " + ((BaseTimeLineItem.BaseViewHolder)localObject).dqc;
        }
      }
      if (ac.iSj) {
        ae.d("MicroMsg.AdListView", "8removeView  detachViewsFromParent " + (String)localObject + " count:" + getChildCount());
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
    com.tencent.mm.plugin.sns.j.e locale;
    String str3;
    if (paramView.getTag() != null)
    {
      str1 = str2;
      if ((paramView.getTag() instanceof BaseTimeLineItem.BaseViewHolder))
      {
        localBaseViewHolder = (BaseTimeLineItem.BaseViewHolder)paramView.getTag();
        str2 = localBaseViewHolder.position + " " + localBaseViewHolder.dqc;
        if ((localBaseViewHolder.timeLineObject.HUN != 1) && (localBaseViewHolder.timeLineObject.eQZ != 1)) {
          break label489;
        }
        bool1 = true;
        com.tencent.mm.plugin.sns.j.e.zKO.bS(localBaseViewHolder.timeLineObject.Id, bool1);
        locale = com.tencent.mm.plugin.sns.j.e.zKO;
        str3 = localBaseViewHolder.timeLineObject.Id;
        if (localBaseViewHolder.timeLineObject.HUF != null) {
          break label494;
        }
      }
    }
    label489:
    label494:
    for (str1 = "";; str1 = localBaseViewHolder.timeLineObject.HUF.Id)
    {
      locale.jD(str3, str1);
      com.tencent.mm.plugin.sns.j.e.zKO.As(localBaseViewHolder.AMj);
      if ((this.AeG != null) && (localBaseViewHolder.isAd)) {
        this.AeG.a(localBaseViewHolder.position, localBaseViewHolder.dqc, localBaseViewHolder.ulU, paramView, localBaseViewHolder.AMj, localBaseViewHolder.snsobj, localBaseViewHolder.oOD, 1);
      }
      if ((!this.AeK.contains(localBaseViewHolder.dAg)) && (((localBaseViewHolder.isAd) && (localBaseViewHolder.timeLineObject.HUG.Gtw == 15)) || (localBaseViewHolder.timeLineObject.HUG.Gtw == 18)))
      {
        boolean bool2 = false;
        bool1 = bool2;
        if (localBaseViewHolder.timeLineObject.HUG.Gtw == 15)
        {
          bool1 = bool2;
          if ((localBaseViewHolder.AKJ.AnH instanceof SightPlayImageView)) {
            bool1 = localBaseViewHolder.AKJ.AnH.ziA.dTz();
          }
        }
        n.a(ah.dXE().aBq(localBaseViewHolder.dAg), false, bool1, 0);
        this.AeK.add(localBaseViewHolder.dAg);
      }
      if (this.AeH != null) {
        this.AeH.a(localBaseViewHolder.dqc, localBaseViewHolder.timeLineObject);
      }
      if (this.AeI != null) {
        this.AeI.a(localBaseViewHolder.position, localBaseViewHolder.dqc, localBaseViewHolder.AMj, localBaseViewHolder.timeLineObject, localBaseViewHolder.isAd, localBaseViewHolder.ztd);
      }
      f(localBaseViewHolder);
      str1 = str2;
      if (ac.iSj) {
        ae.d("MicroMsg.AdListView", "4childview  onViewAdded " + str1 + " count:" + getChildCount());
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
        paramView = ((BaseTimeLineItem.BaseViewHolder)localObject1).position + " " + ((BaseTimeLineItem.BaseViewHolder)localObject1).dqc;
        if ((this.AeG != null) && (((BaseTimeLineItem.BaseViewHolder)localObject1).isAd)) {
          this.AeG.a(((BaseTimeLineItem.BaseViewHolder)localObject1).position, ((BaseTimeLineItem.BaseViewHolder)localObject1).dqc, ((BaseTimeLineItem.BaseViewHolder)localObject1).AMj, 1);
        }
        if (this.AeH != null) {
          this.AeH.azY(((BaseTimeLineItem.BaseViewHolder)localObject1).dqc);
        }
        if (this.AeI != null) {
          this.AeI.a(((BaseTimeLineItem.BaseViewHolder)localObject1).position, ((BaseTimeLineItem.BaseViewHolder)localObject1).dqc, ((BaseTimeLineItem.BaseViewHolder)localObject1).AMj, ((BaseTimeLineItem.BaseViewHolder)localObject1).timeLineObject, ((BaseTimeLineItem.BaseViewHolder)localObject1).isAd);
        }
        if (((BaseTimeLineItem.BaseViewHolder)localObject1).timeLineObject.HUG.Gtw != 3) {
          break label485;
        }
        localObject2 = ah.dXE().aBq(((BaseTimeLineItem.BaseViewHolder)localObject1).dAg);
        if (localObject2 != null) {
          break label317;
        }
        i = 0;
        locala = p.a.iuc;
        str1 = ((BaseTimeLineItem.BaseViewHolder)localObject1).timeLineObject.AiG;
        str2 = r.zV(((BaseTimeLineItem.BaseViewHolder)localObject1).AMj);
        if (bu.isNullOrNil(str1)) {
          break label485;
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
        label317:
        ae.printErrStackTrace("MicroMsg.SnsStatExtUtil", localException2, "", new Object[0]);
      }
    }
    localObject2 = new djc();
    for (;;)
    {
      try
      {
        ((djc)localObject2).parseFrom((byte[])localObject1);
        localObject1 = ((djc)localObject2).HQJ;
        if (localObject1 != null) {
          continue;
        }
        localObject1 = paramView;
      }
      catch (Exception localException1)
      {
        ae.printErrStackTrace("MicroMsg.SnsStatExtUtil", localException1, "", new Object[0]);
        localView = paramView;
        continue;
        ae.i("MicroMsg.SnsStatExtUtil", "report adPageExposure(13235): scene(%d), statExtStr:%s(id=%s, uxinfo=%s)", new Object[] { Integer.valueOf(locala.value), str1, localException2.HQJ.HQM, localException2.HQJ.FEJ });
        ((com.tencent.mm.plugin.sns.b.d)g.ab(com.tencent.mm.plugin.sns.b.d.class)).a(13235, i, new Object[] { locala.value, localException2.HQJ.HQM, localException2.HQJ.FEJ, str2 });
      }
      if (ac.iSj) {
        ae.d("MicroMsg.AdListView", "5childview  onViewRemoved " + (String)localObject1 + " count:" + getChildCount());
      }
      AppMethodBeat.o(97681);
      return;
      i = ((p)localObject2).ecz();
      break;
      label485:
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
        str1 = paramView.position + " " + paramView.dqc;
      }
    }
    if (ac.iSj) {
      ae.d("MicroMsg.AdListView", "7removeView  onViewRemoved " + str1 + " count:" + getChildCount());
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
        localObject = ((BaseTimeLineItem.BaseViewHolder)localObject).position + " " + ((BaseTimeLineItem.BaseViewHolder)localObject).dqc;
      }
    }
    if (ac.iSj) {
      ae.d("MicroMsg.AdListView", "6removeViewInLayout  onViewRemoved " + (String)localObject + " count:" + getChildCount());
    }
    super.removeViewInLayout(paramView);
    AppMethodBeat.o(97682);
  }
  
  public void setTimelineEvent(com.tencent.mm.plugin.sns.model.e parame)
  {
    this.AeI = parame;
  }
  
  public void setTimelineStat(f paramf)
  {
    this.AeH = paramf;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.AdListView
 * JD-Core Version:    0.7.0.1
 */