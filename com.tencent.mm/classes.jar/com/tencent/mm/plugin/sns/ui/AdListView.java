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
import com.tencent.mm.platformtools.ac;
import com.tencent.mm.plugin.sight.decode.a.b;
import com.tencent.mm.plugin.sight.decode.ui.SightPlayImageView;
import com.tencent.mm.plugin.sns.ad.f.p;
import com.tencent.mm.plugin.sns.b.d;
import com.tencent.mm.plugin.sns.data.t;
import com.tencent.mm.plugin.sns.k.g;
import com.tencent.mm.plugin.sns.model.aj;
import com.tencent.mm.plugin.sns.model.f;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.plugin.sns.ui.item.BaseTimeLineItem.BaseViewHolder;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.adw;
import com.tencent.mm.protocal.protobuf.emp;
import com.tencent.mm.protocal.protobuf.emq;
import com.tencent.mm.protocal.protobuf.ex;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.HashSet;

public class AdListView
  extends ListView
{
  com.tencent.mm.plugin.sns.ad.f.e KAk;
  f KAl;
  private com.tencent.mm.plugin.sns.model.e KAm;
  private boolean KAn;
  private HashSet<String> KAo;
  private int KAp;
  private int KAq;
  private int bvH;
  
  public AdListView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(97674);
    this.KAn = true;
    this.KAo = new HashSet();
    this.KAp = -1;
    this.KAq = -1;
    this.bvH = -1;
    AppMethodBeat.o(97674);
  }
  
  public AdListView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(97673);
    this.KAn = true;
    this.KAo = new HashSet();
    this.KAp = -1;
    this.KAq = -1;
    this.bvH = -1;
    AppMethodBeat.o(97673);
  }
  
  private static void f(BaseTimeLineItem.BaseViewHolder paramBaseViewHolder)
  {
    AppMethodBeat.i(179144);
    aj.fOT().QP(paramBaseViewHolder.LkI);
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
    g localg;
    String str2;
    if (paramView.getTag() != null)
    {
      paramLayoutParams = str1;
      if ((paramView.getTag() instanceof BaseTimeLineItem.BaseViewHolder))
      {
        localBaseViewHolder = (BaseTimeLineItem.BaseViewHolder)paramView.getTag();
        str1 = localBaseViewHolder.position + " " + localBaseViewHolder.fAg;
        if ((localBaseViewHolder.timeLineObject.sightFolded != 1) && (localBaseViewHolder.timeLineObject.showFlag != 1)) {
          break label497;
        }
        bool1 = true;
        g.Kia.cx(localBaseViewHolder.timeLineObject.Id, bool1);
        localg = g.Kia;
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
      localg.kL(str2, paramLayoutParams);
      g.Kia.QS(localBaseViewHolder.LkI);
      if ((this.KAk != null) && (localBaseViewHolder.isAd)) {
        this.KAk.a(localBaseViewHolder.position, localBaseViewHolder.fAg, localBaseViewHolder.CIn, paramView, localBaseViewHolder.LkI, localBaseViewHolder.snsobj, localBaseViewHolder.viewType, 1);
      }
      if ((!this.KAo.contains(localBaseViewHolder.fLp)) && (((localBaseViewHolder.isAd) && (localBaseViewHolder.timeLineObject.ContentObj.Sqq == 15)) || (localBaseViewHolder.timeLineObject.ContentObj.Sqq == 18)))
      {
        boolean bool2 = false;
        bool1 = bool2;
        if (localBaseViewHolder.timeLineObject.ContentObj.Sqq == 15)
        {
          bool1 = bool2;
          if ((localBaseViewHolder.JKG.KKk instanceof SightPlayImageView)) {
            bool1 = localBaseViewHolder.JKG.KKk.JsW.fIB();
          }
        }
        p.a(aj.fOI().bbk(localBaseViewHolder.fLp), false, bool1, 0);
        this.KAo.add(localBaseViewHolder.fLp);
      }
      if (this.KAl != null) {
        this.KAl.a(localBaseViewHolder.fAg, localBaseViewHolder.timeLineObject);
      }
      if (this.KAm != null) {
        this.KAm.a(localBaseViewHolder.position, localBaseViewHolder.fAg, localBaseViewHolder.LkI, localBaseViewHolder.timeLineObject, localBaseViewHolder.isAd, localBaseViewHolder.JPW);
      }
      f(localBaseViewHolder);
      paramLayoutParams = str1;
      if (ac.mGo) {
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
    if (ac.mGo) {
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
        localObject = ((BaseTimeLineItem.BaseViewHolder)localObject).position + " " + ((BaseTimeLineItem.BaseViewHolder)localObject).fAg;
      }
    }
    if (ac.mGo) {
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
          if ((this.KAk != null) && (((BaseTimeLineItem.BaseViewHolder)localObject).isAd)) {
            this.KAk.a(((BaseTimeLineItem.BaseViewHolder)localObject).position, ((BaseTimeLineItem.BaseViewHolder)localObject).fAg, ((BaseTimeLineItem.BaseViewHolder)localObject).LkI, 1);
          }
          if (this.KAl != null) {
            this.KAl.aZP(((BaseTimeLineItem.BaseViewHolder)localObject).fAg);
          }
          if (this.KAm != null) {
            this.KAm.a(((BaseTimeLineItem.BaseViewHolder)localObject).position, ((BaseTimeLineItem.BaseViewHolder)localObject).fAg, ((BaseTimeLineItem.BaseViewHolder)localObject).LkI, ((BaseTimeLineItem.BaseViewHolder)localObject).timeLineObject, ((BaseTimeLineItem.BaseViewHolder)localObject).isAd);
          }
          localObject = ((BaseTimeLineItem.BaseViewHolder)localObject).position + " " + ((BaseTimeLineItem.BaseViewHolder)localObject).fAg;
        }
      }
      if (ac.mGo) {
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
    AppMethodBeat.i(205687);
    boolean bool2 = super.onInterceptTouchEvent(paramMotionEvent);
    if (this.bvH < 0) {
      this.bvH = ViewConfiguration.get(getContext()).getScaledTouchSlop();
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
      AppMethodBeat.o(205687);
      return bool1;
      this.KAq = k;
      this.KAp = i;
      j = Math.abs(k - this.KAq);
      i = Math.abs(i - this.KAp);
      bool1 = bool2;
      if (bool2)
      {
        bool1 = bool2;
        if (j > i)
        {
          bool1 = bool2;
          if (i < this.bvH * 2) {
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
    g localg;
    String str3;
    if (paramView.getTag() != null)
    {
      str1 = str2;
      if ((paramView.getTag() instanceof BaseTimeLineItem.BaseViewHolder))
      {
        localBaseViewHolder = (BaseTimeLineItem.BaseViewHolder)paramView.getTag();
        str2 = localBaseViewHolder.position + " " + localBaseViewHolder.fAg;
        if ((localBaseViewHolder.timeLineObject.sightFolded != 1) && (localBaseViewHolder.timeLineObject.showFlag != 1)) {
          break label490;
        }
        bool1 = true;
        g.Kia.cx(localBaseViewHolder.timeLineObject.Id, bool1);
        localg = g.Kia;
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
      localg.kL(str3, str1);
      g.Kia.QS(localBaseViewHolder.LkI);
      if ((this.KAk != null) && (localBaseViewHolder.isAd)) {
        this.KAk.a(localBaseViewHolder.position, localBaseViewHolder.fAg, localBaseViewHolder.CIn, paramView, localBaseViewHolder.LkI, localBaseViewHolder.snsobj, localBaseViewHolder.viewType, 1);
      }
      if ((!this.KAo.contains(localBaseViewHolder.fLp)) && (((localBaseViewHolder.isAd) && (localBaseViewHolder.timeLineObject.ContentObj.Sqq == 15)) || (localBaseViewHolder.timeLineObject.ContentObj.Sqq == 18)))
      {
        boolean bool2 = false;
        bool1 = bool2;
        if (localBaseViewHolder.timeLineObject.ContentObj.Sqq == 15)
        {
          bool1 = bool2;
          if ((localBaseViewHolder.JKG.KKk instanceof SightPlayImageView)) {
            bool1 = localBaseViewHolder.JKG.KKk.JsW.fIB();
          }
        }
        p.a(aj.fOI().bbk(localBaseViewHolder.fLp), false, bool1, 0);
        this.KAo.add(localBaseViewHolder.fLp);
      }
      if (this.KAl != null) {
        this.KAl.a(localBaseViewHolder.fAg, localBaseViewHolder.timeLineObject);
      }
      if (this.KAm != null) {
        this.KAm.a(localBaseViewHolder.position, localBaseViewHolder.fAg, localBaseViewHolder.LkI, localBaseViewHolder.timeLineObject, localBaseViewHolder.isAd, localBaseViewHolder.JPW);
      }
      f(localBaseViewHolder);
      str1 = str2;
      if (ac.mGo) {
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
    int i;
    o.a locala;
    String str2;
    String str3;
    if (paramView.getTag() != null)
    {
      localObject1 = localObject2;
      if ((paramView.getTag() instanceof BaseTimeLineItem.BaseViewHolder))
      {
        paramView = (BaseTimeLineItem.BaseViewHolder)paramView.getTag();
        localObject1 = paramView.position + " " + paramView.fAg;
        if ((this.KAk != null) && (paramView.isAd)) {
          this.KAk.a(paramView.position, paramView.fAg, paramView.LkI, 1);
        }
        if (this.KAl != null) {
          this.KAl.aZP(paramView.fAg);
        }
        if (this.KAm != null) {
          this.KAm.a(paramView.position, paramView.fAg, paramView.LkI, paramView.timeLineObject, paramView.isAd);
        }
        if (paramView.timeLineObject.ContentObj.Sqq != 3) {
          break label629;
        }
        localObject4 = aj.fOI().bbk(paramView.fLp);
        if (localObject4 != null) {
          break label320;
        }
        i = 0;
        locala = o.a.meG;
        str2 = paramView.timeLineObject.statExtStr;
        str3 = t.Qu(paramView.LkI);
        if (Util.isNullOrNil(str2)) {
          break label629;
        }
        paramView = new byte[0];
      }
    }
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
    emp localemp = new emp();
    label320:
    label467:
    label629:
    for (;;)
    {
      try
      {
        localemp.parseFrom(paramView);
        paramView = localemp.Upe;
        if (paramView != null) {
          continue;
        }
      }
      catch (Exception paramView)
      {
        Log.printErrStackTrace("MicroMsg.SnsStatExtUtil", paramView, "", new Object[0]);
        continue;
        str1 = "0";
        paramView = str1;
        if (localObject4 == null) {
          break label467;
        }
        localObject3 = str1;
      }
      if (ac.mGo) {
        Log.d("MicroMsg.AdListView", "5childview  onViewRemoved " + (String)localObject1 + " count:" + getChildCount());
      }
      AppMethodBeat.o(97681);
      return;
      i = ((SnsInfo)localObject4).getAdRecSrc();
      break;
      try
      {
        String str1;
        long l = System.currentTimeMillis();
        localObject3 = str1;
        localObject4 = ((SnsInfo)localObject4).getTimeLine().canvasInfo;
        paramView = str1;
        localObject3 = str1;
        if (!TextUtils.isEmpty((CharSequence)localObject4))
        {
          paramView = str1;
          localObject3 = str1;
          if (((String)localObject4).contains("isInteractiveCanvas")) {
            paramView = "1";
          }
        }
        localObject3 = paramView;
        Log.d("MicroMsg.SnsStatExtUtil", "get adCanvasType cost=" + (System.currentTimeMillis() - l));
      }
      catch (Throwable paramView)
      {
        for (;;)
        {
          Object localObject3;
          paramView = (View)localObject3;
        }
      }
      Log.i("MicroMsg.SnsStatExtUtil", "report adPageExposure(13235): scene=" + locala.value + ", adCanvasType=" + paramView + ", srcSnsId=" + localemp.Upe.Uph + ", uxinfo=" + localemp.Upe.RzC + ", statExtStr=" + str2);
      ((d)h.ae(d.class)).b(13235, i, new Object[] { locala.value, localemp.Upe.Uph, localemp.Upe.RzC, "", str3, paramView });
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
        str1 = paramView.position + " " + paramView.fAg;
      }
    }
    if (ac.mGo) {
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
        localObject = ((BaseTimeLineItem.BaseViewHolder)localObject).position + " " + ((BaseTimeLineItem.BaseViewHolder)localObject).fAg;
      }
    }
    if (ac.mGo) {
      Log.d("MicroMsg.AdListView", "6removeViewInLayout  onViewRemoved " + (String)localObject + " count:" + getChildCount());
    }
    super.removeViewInLayout(paramView);
    AppMethodBeat.o(97682);
  }
  
  public void setTimelineEvent(com.tencent.mm.plugin.sns.model.e parame)
  {
    this.KAm = parame;
  }
  
  public void setTimelineStat(f paramf)
  {
    this.KAl = paramf;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.AdListView
 * JD-Core Version:    0.7.0.1
 */