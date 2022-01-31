package com.tencent.mm.plugin.sns.ui;

import android.os.Process;
import android.view.View;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hardcoder.WXHardCoderJNI;
import com.tencent.mm.plugin.sns.model.ag;
import com.tencent.mm.plugin.sns.model.an.a;
import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.plugin.sns.storage.o;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.ui.base.MMPullDownView;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

final class SnsUserUI$14
  implements SnsUIAction.a
{
  SnsUserUI$14(SnsUserUI paramSnsUserUI) {}
  
  public final void EY(int paramInt)
  {
    AppMethodBeat.i(39802);
    ab.i("MicroMsg.SnsUserUI", "onListViewScoll %s", new Object[] { Integer.valueOf(paramInt) });
    SnsUserUI localSnsUserUI;
    boolean bool;
    int i;
    int j;
    int k;
    if (paramInt == 2)
    {
      WXHardCoderJNI.stopPerformance(WXHardCoderJNI.hcSNSUserScrollEnable, SnsUserUI.h(this.sce));
      localSnsUserUI = this.sce;
      bool = WXHardCoderJNI.hcSNSUserScrollEnable;
      i = WXHardCoderJNI.hcSNSUserScrollDelay;
      j = WXHardCoderJNI.hcSNSUserScrollCPU;
      k = WXHardCoderJNI.hcSNSUserScrollIO;
      if (!WXHardCoderJNI.hcSNSUserScrollThr) {
        break label133;
      }
    }
    label133:
    for (paramInt = Process.myTid();; paramInt = 0)
    {
      SnsUserUI.a(localSnsUserUI, WXHardCoderJNI.startPerformance(bool, i, j, k, paramInt, WXHardCoderJNI.hcSNSUserScrollTimeout, 704, WXHardCoderJNI.hcSNSUserScrollAction, "MicroMsg.SnsUserUI"));
      ab.i("MicroMsg.SnsUserUI", "summer hardcoder sns startPerformance [%s]", new Object[] { Integer.valueOf(SnsUserUI.h(this.sce)) });
      AppMethodBeat.o(39802);
      return;
    }
  }
  
  public final void af(int paramInt, boolean paramBoolean)
  {
    int j = 0;
    AppMethodBeat.i(39803);
    Object localObject;
    n localn;
    if (SnsUserUI.a(this.sce) != null)
    {
      localObject = SnsUserUI.a(this.sce);
      if (((at)localObject).rUx != null)
      {
        localObject = ((at)localObject).rUx;
        localn = ag.cpf().Ez(paramInt);
        if ((localn == null) || (localn.csh().xTS == null) || (((au)localObject).list.size() <= 0))
        {
          AppMethodBeat.o(39803);
          return;
        }
        paramInt = 0;
      }
    }
    for (;;)
    {
      int i = j;
      if (paramInt < ((au)localObject).list.size())
      {
        if (((n)((au)localObject).list.get(paramInt)).csH() == localn.csH())
        {
          i = 1;
          ((au)localObject).list.remove(paramInt);
        }
      }
      else
      {
        if (i != 0)
        {
          ((au)localObject).list.add(localn);
          ((au)localObject).cvN();
          ((au)localObject).cvO();
        }
        AppMethodBeat.o(39803);
        return;
      }
      paramInt += 1;
    }
  }
  
  public final void b(int paramInt, List<Integer> paramList1, List<Integer> paramList2)
  {
    AppMethodBeat.i(39800);
    Object localObject;
    n localn;
    if ((paramInt != -1) && (SnsUserUI.a(this.sce) != null))
    {
      localObject = SnsUserUI.a(this.sce);
      if (((at)localObject).rUx != null)
      {
        localObject = ((at)localObject).rUx;
        localn = ag.cpf().Ez(paramInt);
        if ((localn != null) && (localn.csh().xTS != null) && (((au)localObject).list.size() > 0)) {
          break label147;
        }
      }
    }
    while ((SnsUserUI.a(this.sce) != null) && (paramList1 != null) && (paramList2 != null))
    {
      localObject = SnsUserUI.a(this.sce);
      if (((at)localObject).rUx != null) {
        if ((paramList1 == null) || (paramList2 == null) || (paramList1.size() + paramList2.size() == 0))
        {
          AppMethodBeat.o(39800);
          return;
          label147:
          ((au)localObject).list.add(1, localn);
          ((au)localObject).cvN();
          ((au)localObject).cvO();
        }
        else
        {
          localObject = ((at)localObject).rUx;
          if ((paramList1 != null) && (paramList1.size() != 0)) {
            break label222;
          }
          if ((paramList2 != null) && (paramList2.size() != 0)) {
            break label332;
          }
        }
      }
    }
    for (;;)
    {
      ((au)localObject).cvN();
      ((au)localObject).cvO();
      AppMethodBeat.o(39800);
      return;
      label222:
      ab.d("MicroMsg.SnsSelfHelper", "remove Items");
      paramList1 = paramList1.iterator();
      label236:
      int i;
      label330:
      for (;;)
      {
        int j;
        if (paramList1.hasNext())
        {
          i = ((Integer)paramList1.next()).intValue();
          j = ((au)localObject).list.size();
          paramInt = 1;
        }
        for (;;)
        {
          if (paramInt >= j) {
            break label330;
          }
          localn = (n)((au)localObject).list.get(paramInt);
          if ((localn != null) && (localn.rCV == i))
          {
            ((au)localObject).list.remove(paramInt);
            break label236;
            break;
          }
          paramInt += 1;
        }
      }
      label332:
      ab.d("MicroMsg.SnsSelfHelper", "change Items");
      paramList1 = new LinkedList();
      for (paramInt = 1; paramInt < ((au)localObject).list.size(); paramInt = i + 1)
      {
        localn = (n)((au)localObject).list.get(paramInt);
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
          } while (localn.rCV != i);
          ab.d("MicroMsg.SnsSelfHelper", "update list localId ".concat(String.valueOf(i)));
          ((au)localObject).list.remove(paramInt);
          paramList1.add(ag.cpf().Ez(i));
          i = paramInt - 1;
        }
      }
      paramList1 = paramList1.iterator();
      while (paramList1.hasNext())
      {
        paramList2 = (n)paramList1.next();
        ((au)localObject).list.add(paramList2);
      }
    }
  }
  
  public final void cwg()
  {
    AppMethodBeat.i(39795);
    if (SnsUserUI.b(this.sce) == null) {
      SnsUserUI.a(this.sce, ag.coV());
    }
    an.a locala = SnsUserUI.b(this.sce);
    String str = SnsUserUI.c(this.sce);
    SnsUserUI.d(this.sce);
    locala.b(2, str, SnsUserUI.f(this.sce), SnsUserUI.e(this.sce));
    ag.bEf().postDelayed(SnsUserUI.g(this.sce), 3000L);
    AppMethodBeat.o(39795);
  }
  
  public final View cwh()
  {
    AppMethodBeat.i(39797);
    View localView = this.sce.findViewById(2131821354);
    AppMethodBeat.o(39797);
    return localView;
  }
  
  public final MMPullDownView cwi()
  {
    AppMethodBeat.i(39799);
    MMPullDownView localMMPullDownView = (MMPullDownView)this.sce.findViewById(2131822829);
    AppMethodBeat.o(39799);
    return localMMPullDownView;
  }
  
  public final boolean cwj()
  {
    return false;
  }
  
  public final void cwk()
  {
    AppMethodBeat.i(39801);
    an.a locala = SnsUserUI.b(this.sce);
    String str = SnsUserUI.c(this.sce);
    SnsUserUI.d(this.sce);
    locala.a(2, str, SnsUserUI.f(this.sce), SnsUserUI.e(this.sce));
    AppMethodBeat.o(39801);
  }
  
  public final void cwl() {}
  
  public final void fN(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(39804);
    if (paramInt2 <= 0)
    {
      SnsUserUI.i(this.sce);
      AppMethodBeat.o(39804);
      return;
    }
    SnsUserUI.a(this.sce, paramInt1, paramInt2);
    AppMethodBeat.o(39804);
  }
  
  public final View getMaskView()
  {
    AppMethodBeat.i(39798);
    View localView = this.sce.findViewById(2131828074);
    AppMethodBeat.o(39798);
    return localView;
  }
  
  public final ListView getSnsListView()
  {
    AppMethodBeat.i(39796);
    ListView localListView = (ListView)this.sce.findViewById(2131827968);
    AppMethodBeat.o(39796);
    return localListView;
  }
  
  public final int getType()
  {
    return 2;
  }
  
  public final void lG(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsUserUI.14
 * JD-Core Version:    0.7.0.1
 */