package com.tencent.mm.plugin.sns.ui;

import android.os.Process;
import android.view.View;
import android.widget.ListView;
import com.tencent.mm.hardcoder.WXHardCoderJNI;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.plugin.sns.model.am.a;
import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.plugin.sns.storage.o;
import com.tencent.mm.protocal.c.bxk;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.base.MMPullDownView;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

final class SnsUserUI$13
  implements ba.a
{
  SnsUserUI$13(SnsUserUI paramSnsUserUI) {}
  
  public final void W(int paramInt, boolean paramBoolean)
  {
    int j = 0;
    Object localObject;
    n localn;
    if (SnsUserUI.a(this.pjB) != null)
    {
      localObject = SnsUserUI.a(this.pjB);
      if (((as)localObject).pbN != null)
      {
        localObject = ((as)localObject).pbN;
        localn = af.bDF().yt(paramInt);
        if ((localn != null) && (localn.bGe().tNr != null) && (((at)localObject).list.size() > 0)) {
          break label76;
        }
      }
    }
    return;
    label76:
    paramInt = 0;
    for (;;)
    {
      int i = j;
      if (paramInt < ((at)localObject).list.size())
      {
        if (((n)((at)localObject).list.get(paramInt)).bGE() == localn.bGE())
        {
          i = 1;
          ((at)localObject).list.remove(paramInt);
        }
      }
      else
      {
        if (i == 0) {
          break;
        }
        ((at)localObject).list.add(localn);
        ((at)localObject).bJl();
        ((at)localObject).bJm();
        return;
      }
      paramInt += 1;
    }
  }
  
  public final void a(int paramInt, List<Integer> paramList1, List<Integer> paramList2)
  {
    n localn;
    if ((paramInt != -1) && (SnsUserUI.a(this.pjB) != null))
    {
      localObject = SnsUserUI.a(this.pjB);
      if (((as)localObject).pbN != null)
      {
        localObject = ((as)localObject).pbN;
        localn = af.bDF().yt(paramInt);
        if ((localn != null) && (localn.bGe().tNr != null) && (((at)localObject).list.size() > 0)) {
          break label137;
        }
      }
    }
    for (;;)
    {
      if ((SnsUserUI.a(this.pjB) != null) && (paramList1 != null) && (paramList2 != null))
      {
        localObject = SnsUserUI.a(this.pjB);
        if ((((as)localObject).pbN != null) && (paramList1 != null) && (paramList2 != null) && (paramList1.size() + paramList2.size() != 0)) {
          break;
        }
      }
      return;
      label137:
      ((at)localObject).list.add(1, localn);
      ((at)localObject).bJl();
      ((at)localObject).bJm();
    }
    Object localObject = ((as)localObject).pbN;
    if ((paramList1 == null) || (paramList1.size() == 0)) {
      if ((paramList2 != null) && (paramList2.size() != 0)) {
        break label317;
      }
    }
    for (;;)
    {
      ((at)localObject).bJl();
      ((at)localObject).bJm();
      return;
      y.d("MicroMsg.SnsSelfHelper", "remove Items");
      paramList1 = paramList1.iterator();
      label221:
      int i;
      label315:
      for (;;)
      {
        int j;
        if (paramList1.hasNext())
        {
          i = ((Integer)paramList1.next()).intValue();
          j = ((at)localObject).list.size();
          paramInt = 1;
        }
        for (;;)
        {
          if (paramInt >= j) {
            break label315;
          }
          localn = (n)((at)localObject).list.get(paramInt);
          if ((localn != null) && (localn.oLk == i))
          {
            ((at)localObject).list.remove(paramInt);
            break label221;
            break;
          }
          paramInt += 1;
        }
      }
      label317:
      y.d("MicroMsg.SnsSelfHelper", "change Items");
      paramList1 = new LinkedList();
      for (paramInt = 1; paramInt < ((at)localObject).list.size(); paramInt = i + 1)
      {
        localn = (n)((at)localObject).list.get(paramInt);
        i = paramInt;
        if (localn != null)
        {
          Iterator localIterator = paramList2.iterator();
          do
          {
            i = paramInt;
            if (!localIterator.hasNext()) {
              break;
            }
            i = ((Integer)localIterator.next()).intValue();
          } while (localn.oLk != i);
          y.d("MicroMsg.SnsSelfHelper", "update list localId " + i);
          ((at)localObject).list.remove(paramInt);
          paramList1.add(af.bDF().yt(i));
          i = paramInt - 1;
        }
      }
      paramList1 = paramList1.iterator();
      while (paramList1.hasNext())
      {
        paramList2 = (n)paramList1.next();
        ((at)localObject).list.add(paramList2);
      }
    }
  }
  
  public final void bJA()
  {
    if (SnsUserUI.b(this.pjB) == null) {
      SnsUserUI.a(this.pjB, af.bDv());
    }
    am.a locala = SnsUserUI.b(this.pjB);
    String str = SnsUserUI.c(this.pjB);
    SnsUserUI.d(this.pjB);
    locala.b(2, str, SnsUserUI.f(this.pjB), SnsUserUI.e(this.pjB));
    af.aXq().postDelayed(SnsUserUI.g(this.pjB), 3000L);
  }
  
  public final ListView bJB()
  {
    return (ListView)this.pjB.findViewById(i.f.sns_photo_list);
  }
  
  public final View bJC()
  {
    return this.pjB.findViewById(i.f.content_root);
  }
  
  public final View bJD()
  {
    return this.pjB.findViewById(i.f.sns_cover_shadow);
  }
  
  public final MMPullDownView bJE()
  {
    return (MMPullDownView)this.pjB.findViewById(i.f.sns_pull_down_view);
  }
  
  public final boolean bJF()
  {
    return false;
  }
  
  public final void bJG()
  {
    am.a locala = SnsUserUI.b(this.pjB);
    String str = SnsUserUI.c(this.pjB);
    SnsUserUI.d(this.pjB);
    locala.a(2, str, SnsUserUI.f(this.pjB), SnsUserUI.e(this.pjB));
  }
  
  public final void bJH() {}
  
  public final void ea(int paramInt1, int paramInt2)
  {
    if (paramInt2 <= 0)
    {
      SnsUserUI.i(this.pjB);
      return;
    }
    SnsUserUI.a(this.pjB, paramInt1, paramInt2);
  }
  
  public final int getType()
  {
    return 2;
  }
  
  public final void jA(boolean paramBoolean) {}
  
  public final void yP(int paramInt)
  {
    y.i("MicroMsg.SnsUserUI", "onListViewScoll %s", new Object[] { Integer.valueOf(paramInt) });
    SnsUserUI localSnsUserUI;
    boolean bool;
    int i;
    int j;
    int k;
    if (paramInt == 2)
    {
      WXHardCoderJNI.stopPerformace(WXHardCoderJNI.hcSNSUserScrollEnable, SnsUserUI.h(this.pjB));
      localSnsUserUI = this.pjB;
      bool = WXHardCoderJNI.hcSNSUserScrollEnable;
      i = WXHardCoderJNI.hcSNSUserScrollDelay;
      j = WXHardCoderJNI.hcSNSUserScrollCPU;
      k = WXHardCoderJNI.hcSNSUserScrollIO;
      if (!WXHardCoderJNI.hcSNSUserScrollThr) {
        break label124;
      }
    }
    label124:
    for (paramInt = Process.myTid();; paramInt = 0)
    {
      SnsUserUI.a(localSnsUserUI, WXHardCoderJNI.startPerformance(bool, i, j, k, paramInt, WXHardCoderJNI.hcSNSUserScrollTimeout, 704, WXHardCoderJNI.hcSNSUserScrollAction, "MicroMsg.SnsUserUI"));
      y.i("MicroMsg.SnsUserUI", "summer hardcoder sns startPerformance [%s]", new Object[] { Integer.valueOf(SnsUserUI.h(this.pjB)) });
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsUserUI.13
 * JD-Core Version:    0.7.0.1
 */