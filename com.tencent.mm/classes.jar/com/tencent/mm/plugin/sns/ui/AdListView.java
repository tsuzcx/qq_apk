package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Base64;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.ListView;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelstat.p.a;
import com.tencent.mm.platformtools.ae;
import com.tencent.mm.plugin.sight.decode.ui.SightPlayImageView;
import com.tencent.mm.plugin.sns.a.b.j;
import com.tencent.mm.plugin.sns.b.c;
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.plugin.sns.h.d;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.plugin.sns.model.e;
import com.tencent.mm.plugin.sns.model.f;
import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.plugin.sns.storage.o;
import com.tencent.mm.plugin.sns.ui.c.a.c;
import com.tencent.mm.protocal.c.bvo;
import com.tencent.mm.protocal.c.bvp;
import com.tencent.mm.protocal.c.bxk;
import com.tencent.mm.protocal.c.dk;
import com.tencent.mm.protocal.c.rp;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.util.HashSet;

public class AdListView
  extends ListView
{
  com.tencent.mm.plugin.sns.a.b.b oMa;
  f oMb;
  private e oMc;
  private boolean oMd = true;
  private HashSet<String> oMe = new HashSet();
  
  public AdListView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public AdListView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  protected void attachViewToParent(View paramView, int paramInt, ViewGroup.LayoutParams paramLayoutParams)
  {
    super.attachViewToParent(paramView, paramInt, paramLayoutParams);
    String str1 = "";
    paramLayoutParams = str1;
    a.c localc;
    boolean bool1;
    d locald;
    String str2;
    if (paramView.getTag() != null)
    {
      paramLayoutParams = str1;
      if ((paramView.getTag() instanceof a.c))
      {
        localc = (a.c)paramView.getTag();
        str1 = localc.position + " " + localc.bJQ;
        if ((localc.plP.tNy != 1) && (localc.plP.cCu != 1)) {
          break label473;
        }
        bool1 = true;
        d.ozJ.bc(localc.plP.lsK, bool1);
        locald = d.ozJ;
        str2 = localc.plP.lsK;
        if (localc.plP.tNq != null) {
          break label479;
        }
      }
    }
    label473:
    label479:
    for (paramLayoutParams = "";; paramLayoutParams = localc.plP.tNq.lsK)
    {
      locald.eQ(str2, paramLayoutParams);
      if ((this.oMa != null) && (localc.omL)) {
        this.oMa.a(localc.position, localc.bJQ, localc.kOp, paramView, localc.pmA, localc.okd, localc.ivk, 1);
      }
      if ((!this.oMe.contains(localc.bRV)) && (((localc.omL) && (localc.plP.tNr.sPI == 15)) || (localc.plP.tNr.sPI == 18)))
      {
        boolean bool2 = false;
        bool1 = bool2;
        if (localc.plP.tNr.sPI == 15)
        {
          bool1 = bool2;
          if ((localc.plQ.ogP instanceof SightPlayImageView)) {
            bool1 = ((SightPlayImageView)localc.plQ.ogP).ofD.bBa();
          }
        }
        j.a(af.bDF().OA(localc.bRV), false, bool1, 0);
        this.oMe.add(localc.bRV);
      }
      if (this.oMb != null) {
        this.oMb.a(localc.bJQ, localc.plP);
      }
      if (this.oMc != null) {
        this.oMc.a(localc.position, localc.bJQ, localc.pmA, localc.plP, localc.omL, localc.omM);
      }
      paramLayoutParams = str1;
      if (ae.eTp) {
        y.d("MicroMsg.AdListView", "3childview  onAdded " + paramLayoutParams + " count:" + getChildCount());
      }
      return;
      bool1 = false;
      break;
    }
  }
  
  protected void detachViewFromParent(int paramInt)
  {
    if (ae.eTp) {
      y.d("MicroMsg.AdListView", "2childview  onRemoved " + paramInt + " count:" + getChildCount());
    }
    super.detachViewFromParent(paramInt);
  }
  
  protected void detachViewFromParent(View paramView)
  {
    String str = "";
    Object localObject = str;
    if (paramView.getTag() != null)
    {
      localObject = str;
      if ((paramView.getTag() instanceof a.c))
      {
        localObject = (a.c)paramView.getTag();
        localObject = ((a.c)localObject).position + " " + ((a.c)localObject).bJQ;
      }
    }
    if (ae.eTp) {
      y.d("MicroMsg.AdListView", "1childview  onRemoved " + (String)localObject + " count:" + getChildCount());
    }
    super.detachViewFromParent(paramView);
  }
  
  protected void detachViewsFromParent(int paramInt1, int paramInt2)
  {
    int i = paramInt1;
    while (i < paramInt1 + paramInt2)
    {
      View localView = getChildAt(i);
      String str = "";
      Object localObject = str;
      if (localView.getTag() != null)
      {
        localObject = str;
        if ((localView.getTag() instanceof a.c))
        {
          localObject = (a.c)localView.getTag();
          if ((this.oMa != null) && (((a.c)localObject).omL)) {
            this.oMa.h(((a.c)localObject).position, ((a.c)localObject).bJQ, 1);
          }
          if (this.oMb != null) {
            this.oMb.Nq(((a.c)localObject).bJQ);
          }
          if (this.oMc != null) {
            this.oMc.a(((a.c)localObject).position, ((a.c)localObject).bJQ, ((a.c)localObject).pmA, ((a.c)localObject).plP, ((a.c)localObject).omL);
          }
          localObject = ((a.c)localObject).position + " " + ((a.c)localObject).bJQ;
        }
      }
      if (ae.eTp) {
        y.d("MicroMsg.AdListView", "8removeView  detachViewsFromParent " + (String)localObject + " count:" + getChildCount());
      }
      i += 1;
    }
    super.detachViewsFromParent(paramInt1, paramInt2);
  }
  
  protected void layoutChildren()
  {
    super.layoutChildren();
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public void onViewAdded(View paramView)
  {
    String str2 = "";
    String str1 = str2;
    a.c localc;
    if (paramView.getTag() != null)
    {
      str1 = str2;
      if ((paramView.getTag() instanceof a.c))
      {
        localc = (a.c)paramView.getTag();
        str2 = localc.position + " " + localc.bJQ;
        if ((localc.plP.tNy != 1) && (localc.plP.cCu != 1)) {
          break label452;
        }
        bool = true;
        d.ozJ.bc(localc.plP.lsK, bool);
        d locald = d.ozJ;
        String str3 = localc.plP.lsK;
        if (localc.plP.tNq != null) {
          break label457;
        }
        str1 = "";
        label139:
        locald.eQ(str3, str1);
        if ((this.oMa != null) && (localc.omL)) {
          this.oMa.a(localc.position, localc.bJQ, localc.kOp, paramView, localc.pmA, localc.okd, localc.ivk, 1);
        }
        if ((!this.oMe.contains(localc.bRV)) && (((localc.omL) && (localc.plP.tNr.sPI == 15)) || (localc.plP.tNr.sPI == 18))) {
          if ((localc.plP.tNr.sPI != 15) || (!(localc.plQ.ogP instanceof SightPlayImageView))) {
            break label472;
          }
        }
      }
    }
    label452:
    label457:
    label472:
    for (boolean bool = ((SightPlayImageView)localc.plQ.ogP).ofD.bBa();; bool = false)
    {
      j.a(af.bDF().OA(localc.bRV), false, bool, 0);
      this.oMe.add(localc.bRV);
      if (this.oMb != null) {
        this.oMb.a(localc.bJQ, localc.plP);
      }
      if (this.oMc != null) {
        this.oMc.a(localc.position, localc.bJQ, localc.pmA, localc.plP, localc.omL, localc.omM);
      }
      str1 = str2;
      if (ae.eTp) {
        y.d("MicroMsg.AdListView", "4childview  onViewAdded " + str1 + " count:" + getChildCount());
      }
      return;
      bool = false;
      break;
      str1 = localc.plP.tNq.lsK;
      break label139;
    }
  }
  
  public void onViewRemoved(View paramView)
  {
    Object localObject2 = "";
    Object localObject1 = localObject2;
    int i;
    p.a locala;
    String str1;
    String str2;
    if (paramView.getTag() != null)
    {
      localObject1 = localObject2;
      if ((paramView.getTag() instanceof a.c))
      {
        localObject1 = (a.c)paramView.getTag();
        paramView = ((a.c)localObject1).position + " " + ((a.c)localObject1).bJQ;
        if ((this.oMa != null) && (((a.c)localObject1).omL)) {
          this.oMa.h(((a.c)localObject1).position, ((a.c)localObject1).bJQ, 1);
        }
        if (this.oMb != null) {
          this.oMb.Nq(((a.c)localObject1).bJQ);
        }
        if (this.oMc != null) {
          this.oMc.a(((a.c)localObject1).position, ((a.c)localObject1).bJQ, ((a.c)localObject1).pmA, ((a.c)localObject1).plP, ((a.c)localObject1).omL);
        }
        if (((a.c)localObject1).plP.tNr.sPI != 3) {
          break label468;
        }
        localObject2 = af.bDF().OA(((a.c)localObject1).bRV);
        if (localObject2 != null) {
          break label301;
        }
        i = 0;
        locala = p.a.eEL;
        str1 = ((a.c)localObject1).plP.oPO;
        str2 = i.fN(((a.c)localObject1).pmA);
        if (bk.bl(str1)) {
          break label468;
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
        label301:
        y.printErrStackTrace("MicroMsg.SnsStatExtUtil", localException2, null, new Object[0]);
      }
    }
    localObject2 = new bvo();
    for (;;)
    {
      try
      {
        ((bvo)localObject2).aH((byte[])localObject1);
        localObject1 = ((bvo)localObject2).tMm;
        if (localObject1 != null) {
          continue;
        }
        localObject1 = paramView;
      }
      catch (Exception localException1)
      {
        y.printErrStackTrace("MicroMsg.SnsStatExtUtil", localException1, "", new Object[0]);
        localView = paramView;
        continue;
        y.i("MicroMsg.SnsStatExtUtil", "report adPageExposure(13235): scene(%d), statExtStr:%s(id=%s, uxinfo=%s)", new Object[] { Integer.valueOf(locala.value), str1, localException2.tMm.tMp, localException2.tMm.tMq });
        ((c)g.r(c.class)).a(13235, i, new Object[] { locala.value, localException2.tMm.tMp, localException2.tMm.tMq, str2 });
      }
      if (ae.eTp) {
        y.d("MicroMsg.AdListView", "5childview  onViewRemoved " + (String)localObject1 + " count:" + getChildCount());
      }
      return;
      i = ((n)localObject2).bGO();
      break;
      label468:
      View localView = paramView;
    }
  }
  
  public void removeView(View paramView)
  {
    super.removeView(paramView);
    String str2 = "";
    String str1 = str2;
    if (paramView.getTag() != null)
    {
      str1 = str2;
      if ((paramView.getTag() instanceof a.c))
      {
        paramView = (a.c)paramView.getTag();
        str1 = paramView.position + " " + paramView.bJQ;
      }
    }
    if (ae.eTp) {
      y.d("MicroMsg.AdListView", "7removeView  onViewRemoved " + str1 + " count:" + getChildCount());
    }
  }
  
  public void removeViewInLayout(View paramView)
  {
    String str = "";
    Object localObject = str;
    if (paramView.getTag() != null)
    {
      localObject = str;
      if ((paramView.getTag() instanceof a.c))
      {
        localObject = (a.c)paramView.getTag();
        localObject = ((a.c)localObject).position + " " + ((a.c)localObject).bJQ;
      }
    }
    if (ae.eTp) {
      y.d("MicroMsg.AdListView", "6removeViewInLayout  onViewRemoved " + (String)localObject + " count:" + getChildCount());
    }
    super.removeViewInLayout(paramView);
  }
  
  public void setTimelineEvent(e parame)
  {
    this.oMc = parame;
  }
  
  public void setTimelineStat(f paramf)
  {
    this.oMb = paramf;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.AdListView
 * JD-Core Version:    0.7.0.1
 */