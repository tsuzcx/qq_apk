package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Base64;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup.LayoutParams;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelstat.p.a;
import com.tencent.mm.platformtools.ac;
import com.tencent.mm.plugin.sight.decode.a.b;
import com.tencent.mm.plugin.sight.decode.ui.SightPlayImageView;
import com.tencent.mm.plugin.sns.ad.g.o;
import com.tencent.mm.plugin.sns.b.d;
import com.tencent.mm.plugin.sns.data.r;
import com.tencent.mm.plugin.sns.model.aj;
import com.tencent.mm.plugin.sns.model.aw;
import com.tencent.mm.plugin.sns.model.f;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.plugin.sns.ui.item.BaseTimeLineItem.BaseViewHolder;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.adp;
import com.tencent.mm.protocal.protobuf.eco;
import com.tencent.mm.protocal.protobuf.ecp;
import com.tencent.mm.protocal.protobuf.fa;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.HashSet;

public class AdListView
  extends ListView
{
  com.tencent.mm.plugin.sns.ad.g.e Enb;
  f Enc;
  private com.tencent.mm.plugin.sns.model.e End;
  private boolean Ene;
  private HashSet<String> Enf;
  private int Eng;
  private int Enh;
  private int rZ;
  
  public AdListView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(97674);
    this.Ene = true;
    this.Enf = new HashSet();
    this.Eng = -1;
    this.Enh = -1;
    this.rZ = -1;
    AppMethodBeat.o(97674);
  }
  
  public AdListView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(97673);
    this.Ene = true;
    this.Enf = new HashSet();
    this.Eng = -1;
    this.Enh = -1;
    this.rZ = -1;
    AppMethodBeat.o(97673);
  }
  
  private static void g(BaseTimeLineItem.BaseViewHolder paramBaseViewHolder)
  {
    AppMethodBeat.i(179144);
    aj.faZ().Jw(paramBaseViewHolder.EWu);
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
    com.tencent.mm.plugin.sns.k.e locale;
    String str2;
    if (paramView.getTag() != null)
    {
      paramLayoutParams = str1;
      if ((paramView.getTag() instanceof BaseTimeLineItem.BaseViewHolder))
      {
        localBaseViewHolder = (BaseTimeLineItem.BaseViewHolder)paramView.getTag();
        str1 = localBaseViewHolder.position + " " + localBaseViewHolder.dHp;
        if ((localBaseViewHolder.timeLineObject.sightFolded != 1) && (localBaseViewHolder.timeLineObject.showFlag != 1)) {
          break label497;
        }
        bool1 = true;
        com.tencent.mm.plugin.sns.k.e.DUQ.ck(localBaseViewHolder.timeLineObject.Id, bool1);
        locale = com.tencent.mm.plugin.sns.k.e.DUQ;
        str2 = localBaseViewHolder.timeLineObject.Id;
        if (localBaseViewHolder.timeLineObject.AppInfo != null) {
          break label503;
        }
      }
    }
    label497:
    label503:
    for (paramLayoutParams = "";; paramLayoutParams = localBaseViewHolder.timeLineObject.AppInfo.Id)
    {
      locale.kq(str2, paramLayoutParams);
      com.tencent.mm.plugin.sns.k.e.DUQ.Jz(localBaseViewHolder.EWu);
      if ((this.Enb != null) && (localBaseViewHolder.isAd)) {
        this.Enb.a(localBaseViewHolder.position, localBaseViewHolder.dHp, localBaseViewHolder.xEm, paramView, localBaseViewHolder.EWu, localBaseViewHolder.snsobj, localBaseViewHolder.qcr, 1);
      }
      if ((!this.Enf.contains(localBaseViewHolder.dRS)) && (((localBaseViewHolder.isAd) && (localBaseViewHolder.timeLineObject.ContentObj.LoU == 15)) || (localBaseViewHolder.timeLineObject.ContentObj.LoU == 18)))
      {
        boolean bool2 = false;
        bool1 = bool2;
        if (localBaseViewHolder.timeLineObject.ContentObj.LoU == 15)
        {
          bool1 = bool2;
          if ((localBaseViewHolder.EUK.Ews instanceof SightPlayImageView)) {
            bool1 = localBaseViewHolder.EUK.Ews.Dnr.eVy();
          }
        }
        o.a(aj.faO().aQl(localBaseViewHolder.dRS), false, bool1, 0);
        this.Enf.add(localBaseViewHolder.dRS);
      }
      if (this.Enc != null) {
        this.Enc.a(localBaseViewHolder.dHp, localBaseViewHolder.timeLineObject);
      }
      if (this.End != null) {
        this.End.a(localBaseViewHolder.position, localBaseViewHolder.dHp, localBaseViewHolder.EWu, localBaseViewHolder.timeLineObject, localBaseViewHolder.isAd, localBaseViewHolder.DDr);
      }
      g(localBaseViewHolder);
      paramLayoutParams = str1;
      if (ac.jPe) {
        Log.d("MicroMsg.AdListView", "3childview  onAdded " + paramLayoutParams + " count:" + getChildCount());
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
    if (ac.jPe) {
      Log.d("MicroMsg.AdListView", "2childview  onRemoved " + paramInt + " count:" + getChildCount());
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
        localObject = ((BaseTimeLineItem.BaseViewHolder)localObject).position + " " + ((BaseTimeLineItem.BaseViewHolder)localObject).dHp;
      }
    }
    if (ac.jPe) {
      Log.d("MicroMsg.AdListView", "1childview  onRemoved " + (String)localObject + " count:" + getChildCount());
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
          if ((this.Enb != null) && (((BaseTimeLineItem.BaseViewHolder)localObject).isAd)) {
            this.Enb.a(((BaseTimeLineItem.BaseViewHolder)localObject).position, ((BaseTimeLineItem.BaseViewHolder)localObject).dHp, ((BaseTimeLineItem.BaseViewHolder)localObject).EWu, 1);
          }
          if (this.Enc != null) {
            this.Enc.aOU(((BaseTimeLineItem.BaseViewHolder)localObject).dHp);
          }
          if (this.End != null) {
            this.End.a(((BaseTimeLineItem.BaseViewHolder)localObject).position, ((BaseTimeLineItem.BaseViewHolder)localObject).dHp, ((BaseTimeLineItem.BaseViewHolder)localObject).EWu, ((BaseTimeLineItem.BaseViewHolder)localObject).timeLineObject, ((BaseTimeLineItem.BaseViewHolder)localObject).isAd);
          }
          localObject = ((BaseTimeLineItem.BaseViewHolder)localObject).position + " " + ((BaseTimeLineItem.BaseViewHolder)localObject).dHp;
        }
      }
      if (ac.jPe) {
        Log.d("MicroMsg.AdListView", "8removeView  detachViewsFromParent " + (String)localObject + " count:" + getChildCount());
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
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(203227);
    boolean bool2 = super.onInterceptTouchEvent(paramMotionEvent);
    if (this.rZ < 0) {
      this.rZ = ViewConfiguration.get(getContext()).getScaledTouchSlop();
    }
    int j = paramMotionEvent.getActionMasked();
    int k = (int)paramMotionEvent.getX();
    int i = (int)paramMotionEvent.getY();
    boolean bool1 = bool2;
    switch (j)
    {
    default: 
      bool1 = bool2;
    }
    for (;;)
    {
      AppMethodBeat.o(203227);
      return bool1;
      this.Enh = k;
      this.Eng = i;
      j = Math.abs(k - this.Enh);
      i = Math.abs(i - this.Eng);
      bool1 = bool2;
      if (bool2)
      {
        bool1 = bool2;
        if (j > i)
        {
          bool1 = bool2;
          if (i < this.rZ * 2) {
            bool1 = false;
          }
        }
      }
    }
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
    com.tencent.mm.plugin.sns.k.e locale;
    String str3;
    if (paramView.getTag() != null)
    {
      str1 = str2;
      if ((paramView.getTag() instanceof BaseTimeLineItem.BaseViewHolder))
      {
        localBaseViewHolder = (BaseTimeLineItem.BaseViewHolder)paramView.getTag();
        str2 = localBaseViewHolder.position + " " + localBaseViewHolder.dHp;
        if ((localBaseViewHolder.timeLineObject.sightFolded != 1) && (localBaseViewHolder.timeLineObject.showFlag != 1)) {
          break label490;
        }
        bool1 = true;
        com.tencent.mm.plugin.sns.k.e.DUQ.ck(localBaseViewHolder.timeLineObject.Id, bool1);
        locale = com.tencent.mm.plugin.sns.k.e.DUQ;
        str3 = localBaseViewHolder.timeLineObject.Id;
        if (localBaseViewHolder.timeLineObject.AppInfo != null) {
          break label495;
        }
      }
    }
    label490:
    label495:
    for (str1 = "";; str1 = localBaseViewHolder.timeLineObject.AppInfo.Id)
    {
      locale.kq(str3, str1);
      com.tencent.mm.plugin.sns.k.e.DUQ.Jz(localBaseViewHolder.EWu);
      if ((this.Enb != null) && (localBaseViewHolder.isAd)) {
        this.Enb.a(localBaseViewHolder.position, localBaseViewHolder.dHp, localBaseViewHolder.xEm, paramView, localBaseViewHolder.EWu, localBaseViewHolder.snsobj, localBaseViewHolder.qcr, 1);
      }
      if ((!this.Enf.contains(localBaseViewHolder.dRS)) && (((localBaseViewHolder.isAd) && (localBaseViewHolder.timeLineObject.ContentObj.LoU == 15)) || (localBaseViewHolder.timeLineObject.ContentObj.LoU == 18)))
      {
        boolean bool2 = false;
        bool1 = bool2;
        if (localBaseViewHolder.timeLineObject.ContentObj.LoU == 15)
        {
          bool1 = bool2;
          if ((localBaseViewHolder.EUK.Ews instanceof SightPlayImageView)) {
            bool1 = localBaseViewHolder.EUK.Ews.Dnr.eVy();
          }
        }
        o.a(aj.faO().aQl(localBaseViewHolder.dRS), false, bool1, 0);
        this.Enf.add(localBaseViewHolder.dRS);
      }
      if (this.Enc != null) {
        this.Enc.a(localBaseViewHolder.dHp, localBaseViewHolder.timeLineObject);
      }
      if (this.End != null) {
        this.End.a(localBaseViewHolder.position, localBaseViewHolder.dHp, localBaseViewHolder.EWu, localBaseViewHolder.timeLineObject, localBaseViewHolder.isAd, localBaseViewHolder.DDr);
      }
      g(localBaseViewHolder);
      str1 = str2;
      if (ac.jPe) {
        Log.d("MicroMsg.AdListView", "4childview  onViewAdded " + str1 + " count:" + getChildCount());
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
        paramView = ((BaseTimeLineItem.BaseViewHolder)localObject1).position + " " + ((BaseTimeLineItem.BaseViewHolder)localObject1).dHp;
        if ((this.Enb != null) && (((BaseTimeLineItem.BaseViewHolder)localObject1).isAd)) {
          this.Enb.a(((BaseTimeLineItem.BaseViewHolder)localObject1).position, ((BaseTimeLineItem.BaseViewHolder)localObject1).dHp, ((BaseTimeLineItem.BaseViewHolder)localObject1).EWu, 1);
        }
        if (this.Enc != null) {
          this.Enc.aOU(((BaseTimeLineItem.BaseViewHolder)localObject1).dHp);
        }
        if (this.End != null) {
          this.End.a(((BaseTimeLineItem.BaseViewHolder)localObject1).position, ((BaseTimeLineItem.BaseViewHolder)localObject1).dHp, ((BaseTimeLineItem.BaseViewHolder)localObject1).EWu, ((BaseTimeLineItem.BaseViewHolder)localObject1).timeLineObject, ((BaseTimeLineItem.BaseViewHolder)localObject1).isAd);
        }
        if (((BaseTimeLineItem.BaseViewHolder)localObject1).timeLineObject.ContentObj.LoU != 3) {
          break label486;
        }
        localObject2 = aj.faO().aQl(((BaseTimeLineItem.BaseViewHolder)localObject1).dRS);
        if (localObject2 != null) {
          break label318;
        }
        i = 0;
        locala = p.a.jpo;
        str1 = ((BaseTimeLineItem.BaseViewHolder)localObject1).timeLineObject.statExtStr;
        str2 = r.Jb(((BaseTimeLineItem.BaseViewHolder)localObject1).EWu);
        if (Util.isNullOrNil(str1)) {
          break label486;
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
        label318:
        Log.printErrStackTrace("MicroMsg.SnsStatExtUtil", localException2, "", new Object[0]);
      }
    }
    localObject2 = new eco();
    for (;;)
    {
      try
      {
        ((eco)localObject2).parseFrom((byte[])localObject1);
        localObject1 = ((eco)localObject2).NcH;
        if (localObject1 != null) {
          continue;
        }
        localObject1 = paramView;
      }
      catch (Exception localException1)
      {
        Log.printErrStackTrace("MicroMsg.SnsStatExtUtil", localException1, "", new Object[0]);
        localView = paramView;
        continue;
        Log.i("MicroMsg.SnsStatExtUtil", "report adPageExposure(13235): scene(%d), statExtStr:%s(id=%s, uxinfo=%s)", new Object[] { Integer.valueOf(locala.value), str1, localException2.NcH.NcK, localException2.NcH.KxO });
        ((d)g.af(d.class)).a(13235, i, new Object[] { locala.value, localException2.NcH.NcK, localException2.NcH.KxO, str2 });
      }
      if (ac.jPe) {
        Log.d("MicroMsg.AdListView", "5childview  onViewRemoved " + (String)localObject1 + " count:" + getChildCount());
      }
      AppMethodBeat.o(97681);
      return;
      i = ((SnsInfo)localObject2).getAdRecSrc();
      break;
      label486:
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
        str1 = paramView.position + " " + paramView.dHp;
      }
    }
    if (ac.jPe) {
      Log.d("MicroMsg.AdListView", "7removeView  onViewRemoved " + str1 + " count:" + getChildCount());
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
        localObject = ((BaseTimeLineItem.BaseViewHolder)localObject).position + " " + ((BaseTimeLineItem.BaseViewHolder)localObject).dHp;
      }
    }
    if (ac.jPe) {
      Log.d("MicroMsg.AdListView", "6removeViewInLayout  onViewRemoved " + (String)localObject + " count:" + getChildCount());
    }
    super.removeViewInLayout(paramView);
    AppMethodBeat.o(97682);
  }
  
  public void setTimelineEvent(com.tencent.mm.plugin.sns.model.e parame)
  {
    this.End = parame;
  }
  
  public void setTimelineStat(f paramf)
  {
    this.Enc = paramf;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.AdListView
 * JD-Core Version:    0.7.0.1
 */