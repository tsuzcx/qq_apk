package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Base64;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup.LayoutParams;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.modelstat.o.a;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.sight.decode.model.SightPlayController;
import com.tencent.mm.plugin.sight.decode.ui.SightPlayImageView;
import com.tencent.mm.plugin.sns.ad.d.a.c;
import com.tencent.mm.plugin.sns.ad.g.p;
import com.tencent.mm.plugin.sns.c.d;
import com.tencent.mm.plugin.sns.data.t;
import com.tencent.mm.plugin.sns.model.al;
import com.tencent.mm.plugin.sns.model.ax;
import com.tencent.mm.plugin.sns.model.f;
import com.tencent.mm.plugin.sns.statistics.j;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.plugin.sns.storage.w;
import com.tencent.mm.plugin.sns.ui.item.BaseTimeLineItem.BaseViewHolder;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.agh;
import com.tencent.mm.protocal.protobuf.fhn;
import com.tencent.mm.protocal.protobuf.fho;
import com.tencent.mm.protocal.protobuf.fr;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.HashSet;

public class AdListView
  extends ListView
{
  com.tencent.mm.plugin.sns.ad.g.e QZR;
  f QZS;
  private com.tencent.mm.plugin.sns.model.e QZT;
  private boolean QZU;
  private HashSet<String> QZV;
  private int QZW;
  private int QZX;
  private int doK;
  
  public AdListView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(97674);
    this.QZU = true;
    this.QZV = new HashSet();
    this.QZW = -1;
    this.QZX = -1;
    this.doK = -1;
    AppMethodBeat.o(97674);
  }
  
  public AdListView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(97673);
    this.QZU = true;
    this.QZV = new HashSet();
    this.QZW = -1;
    this.QZX = -1;
    this.doK = -1;
    AppMethodBeat.o(97673);
  }
  
  private static void g(BaseTimeLineItem.BaseViewHolder paramBaseViewHolder)
  {
    AppMethodBeat.i(179144);
    al.hgN().uV(paramBaseViewHolder.RKx);
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
    j localj;
    String str2;
    if (paramView.getTag() != null)
    {
      paramLayoutParams = str1;
      if ((paramView.getTag() instanceof BaseTimeLineItem.BaseViewHolder))
      {
        localBaseViewHolder = (BaseTimeLineItem.BaseViewHolder)paramView.getTag();
        str1 = localBaseViewHolder.position + " " + localBaseViewHolder.hES;
        if ((localBaseViewHolder.timeLineObject.sightFolded != 1) && (localBaseViewHolder.timeLineObject.showFlag != 1)) {
          break label497;
        }
        bool1 = true;
        j.QFS.cY(localBaseViewHolder.timeLineObject.Id, bool1);
        localj = j.QFS;
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
      localj.ms(str2, paramLayoutParams);
      j.QFS.uY(localBaseViewHolder.RKx);
      if ((this.QZR != null) && (localBaseViewHolder.isAd)) {
        this.QZR.a(localBaseViewHolder.position, localBaseViewHolder.hES, localBaseViewHolder.ICx, paramView, localBaseViewHolder.RKx, localBaseViewHolder.snsobj, localBaseViewHolder.viewType, 1);
      }
      if ((!this.QZV.contains(localBaseViewHolder.hQX)) && (((localBaseViewHolder.isAd) && (localBaseViewHolder.timeLineObject.ContentObj.Zpq == 15)) || (localBaseViewHolder.timeLineObject.ContentObj.Zpq == 18)))
      {
        boolean bool2 = false;
        bool1 = bool2;
        if (localBaseViewHolder.timeLineObject.ContentObj.Zpq == 15)
        {
          bool1 = bool2;
          if ((localBaseViewHolder.Qcj.RjM instanceof SightPlayImageView)) {
            bool1 = localBaseViewHolder.Qcj.RjM.PGy.gYu();
          }
        }
        p.a(al.hgB().aZK(localBaseViewHolder.hQX), false, bool1, 0);
        this.QZV.add(localBaseViewHolder.hQX);
      }
      if (this.QZS != null) {
        this.QZS.a(localBaseViewHolder.hES, localBaseViewHolder.timeLineObject);
      }
      if (this.QZT != null) {
        this.QZT.a(localBaseViewHolder.position, localBaseViewHolder.hES, localBaseViewHolder.RKx, localBaseViewHolder.timeLineObject, localBaseViewHolder.isAd, localBaseViewHolder.QmD);
      }
      g(localBaseViewHolder);
      paramLayoutParams = str1;
      if (z.pCO) {
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
    if (z.pCO) {
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
        localObject = ((BaseTimeLineItem.BaseViewHolder)localObject).position + " " + ((BaseTimeLineItem.BaseViewHolder)localObject).hES;
      }
    }
    if (z.pCO) {
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
          if ((this.QZR != null) && (((BaseTimeLineItem.BaseViewHolder)localObject).isAd)) {
            this.QZR.a(((BaseTimeLineItem.BaseViewHolder)localObject).position, ((BaseTimeLineItem.BaseViewHolder)localObject).hES, ((BaseTimeLineItem.BaseViewHolder)localObject).RKx, 1);
          }
          if (this.QZS != null) {
            this.QZS.aYc(((BaseTimeLineItem.BaseViewHolder)localObject).hES);
          }
          if (this.QZT != null) {
            this.QZT.a(((BaseTimeLineItem.BaseViewHolder)localObject).position, ((BaseTimeLineItem.BaseViewHolder)localObject).hES, ((BaseTimeLineItem.BaseViewHolder)localObject).RKx, ((BaseTimeLineItem.BaseViewHolder)localObject).timeLineObject, ((BaseTimeLineItem.BaseViewHolder)localObject).isAd);
          }
          localObject = ((BaseTimeLineItem.BaseViewHolder)localObject).position + " " + ((BaseTimeLineItem.BaseViewHolder)localObject).hES;
        }
      }
      if (z.pCO) {
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
    AppMethodBeat.i(307771);
    boolean bool2 = super.onInterceptTouchEvent(paramMotionEvent);
    if (this.doK < 0) {
      this.doK = ViewConfiguration.get(getContext()).getScaledTouchSlop();
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
      AppMethodBeat.o(307771);
      return bool1;
      this.QZX = k;
      this.QZW = i;
      j = Math.abs(k - this.QZX);
      i = Math.abs(i - this.QZW);
      bool1 = bool2;
      if (bool2)
      {
        bool1 = bool2;
        if (j > i)
        {
          bool1 = bool2;
          if (i < this.doK * 2) {
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
    j localj;
    String str3;
    if (paramView.getTag() != null)
    {
      str1 = str2;
      if ((paramView.getTag() instanceof BaseTimeLineItem.BaseViewHolder))
      {
        localBaseViewHolder = (BaseTimeLineItem.BaseViewHolder)paramView.getTag();
        str2 = localBaseViewHolder.position + " " + localBaseViewHolder.hES;
        if ((localBaseViewHolder.timeLineObject.sightFolded != 1) && (localBaseViewHolder.timeLineObject.showFlag != 1)) {
          break label490;
        }
        bool1 = true;
        j.QFS.cY(localBaseViewHolder.timeLineObject.Id, bool1);
        localj = j.QFS;
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
      localj.ms(str3, str1);
      j.QFS.uY(localBaseViewHolder.RKx);
      if ((this.QZR != null) && (localBaseViewHolder.isAd)) {
        this.QZR.a(localBaseViewHolder.position, localBaseViewHolder.hES, localBaseViewHolder.ICx, paramView, localBaseViewHolder.RKx, localBaseViewHolder.snsobj, localBaseViewHolder.viewType, 1);
      }
      if ((!this.QZV.contains(localBaseViewHolder.hQX)) && (((localBaseViewHolder.isAd) && (localBaseViewHolder.timeLineObject.ContentObj.Zpq == 15)) || (localBaseViewHolder.timeLineObject.ContentObj.Zpq == 18)))
      {
        boolean bool2 = false;
        bool1 = bool2;
        if (localBaseViewHolder.timeLineObject.ContentObj.Zpq == 15)
        {
          bool1 = bool2;
          if ((localBaseViewHolder.Qcj.RjM instanceof SightPlayImageView)) {
            bool1 = localBaseViewHolder.Qcj.RjM.PGy.gYu();
          }
        }
        p.a(al.hgB().aZK(localBaseViewHolder.hQX), false, bool1, 0);
        this.QZV.add(localBaseViewHolder.hQX);
      }
      if (this.QZS != null) {
        this.QZS.a(localBaseViewHolder.hES, localBaseViewHolder.timeLineObject);
      }
      if (this.QZT != null) {
        this.QZT.a(localBaseViewHolder.position, localBaseViewHolder.hES, localBaseViewHolder.RKx, localBaseViewHolder.timeLineObject, localBaseViewHolder.isAd, localBaseViewHolder.QmD);
      }
      g(localBaseViewHolder);
      str1 = str2;
      if (z.pCO) {
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
    Object localObject4;
    if (paramView.getTag() != null)
    {
      localObject1 = localObject2;
      if ((paramView.getTag() instanceof BaseTimeLineItem.BaseViewHolder))
      {
        paramView = (BaseTimeLineItem.BaseViewHolder)paramView.getTag();
        localObject1 = paramView.position + " " + paramView.hES;
        if ((this.QZR != null) && (paramView.isAd)) {
          this.QZR.a(paramView.position, paramView.hES, paramView.RKx, 1);
        }
        if (this.QZS != null) {
          this.QZS.aYc(paramView.hES);
        }
        if (this.QZT != null) {
          this.QZT.a(paramView.position, paramView.hES, paramView.RKx, paramView.timeLineObject, paramView.isAd);
        }
        if (paramView.timeLineObject.ContentObj.Zpq != 3) {
          break label623;
        }
        localObject4 = al.hgB().aZK(paramView.hQX);
        if (localObject4 != null) {
          break label320;
        }
      }
    }
    o.a locala;
    String str2;
    String str3;
    fhn localfhn;
    label320:
    for (int i = 0;; i = ((SnsInfo)localObject4).getAdRecSrc())
    {
      locala = o.a.oXy;
      str2 = paramView.timeLineObject.statExtStr;
      str3 = t.uA(paramView.RKx);
      if (Util.isNullOrNil(str2)) {
        break label623;
      }
      paramView = new byte[0];
      try
      {
        localObject2 = Base64.decode(str2, 0);
        paramView = (View)localObject2;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          Log.printErrStackTrace("MicroMsg.SnsStatExtUtil", localException, "", new Object[0]);
        }
      }
      localfhn = new fhn();
      try
      {
        localfhn.parseFrom(paramView);
        paramView = localfhn.abIc;
        if (paramView != null) {
          break label365;
        }
      }
      catch (Exception paramView)
      {
        for (;;)
        {
          Log.printErrStackTrace("MicroMsg.SnsStatExtUtil", paramView, "", new Object[0]);
        }
        str1 = "0";
        paramView = str1;
        if (localObject4 == null) {
          break label461;
        }
      }
      if (z.pCO) {
        Log.d("MicroMsg.AdListView", "5childview  onViewRemoved " + (String)localObject1 + " count:" + getChildCount());
      }
      AppMethodBeat.o(97681);
      return;
    }
    label365:
    String str1;
    localObject3 = str1;
    for (;;)
    {
      try
      {
        long l = System.currentTimeMillis();
        localObject3 = str1;
        localObject4 = ((SnsInfo)localObject4).getTimeLine().canvasInfo;
        paramView = str1;
        localObject3 = str1;
        if (!TextUtils.isEmpty((CharSequence)localObject4))
        {
          localObject3 = str1;
          if (!c.aWs((String)localObject4)) {
            continue;
          }
          paramView = "2";
        }
        localObject3 = paramView;
        Log.d("MicroMsg.SnsStatExtUtil", "get adCanvasType cost=" + (System.currentTimeMillis() - l));
      }
      finally
      {
        label461:
        label623:
        paramView = (View)localObject3;
        continue;
      }
      Log.i("MicroMsg.SnsStatExtUtil", "report adPageExposure(13235): scene=" + locala.value + ", adCanvasType=" + paramView + ", srcSnsId=" + localfhn.abIc.abIf + ", uxinfo=" + localfhn.abIc.Ywb + ", statExtStr=" + str2);
      ((d)h.ax(d.class)).b(13235, i, new Object[] { locala.value, localfhn.abIc.abIf, localfhn.abIc.Ywb, "", str3, paramView });
      break;
      paramView = str1;
      localObject3 = str1;
      if (((String)localObject4).contains("isInteractiveCanvas")) {
        paramView = "1";
      }
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
        str1 = paramView.position + " " + paramView.hES;
      }
    }
    if (z.pCO) {
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
        localObject = ((BaseTimeLineItem.BaseViewHolder)localObject).position + " " + ((BaseTimeLineItem.BaseViewHolder)localObject).hES;
      }
    }
    if (z.pCO) {
      Log.d("MicroMsg.AdListView", "6removeViewInLayout  onViewRemoved " + (String)localObject + " count:" + getChildCount());
    }
    super.removeViewInLayout(paramView);
    AppMethodBeat.o(97682);
  }
  
  public void setTimelineEvent(com.tencent.mm.plugin.sns.model.e parame)
  {
    this.QZT = parame;
  }
  
  public void setTimelineStat(f paramf)
  {
    this.QZS = paramf;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.AdListView
 * JD-Core Version:    0.7.0.1
 */