package com.tencent.mm.plugin.mv.ui.uic;

import android.view.View;
import android.view.ViewPropertyAnimator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/mv/ui/uic/VisibleRecord;", "", "()V", "TAG", "", "changedMap", "Ljava/util/HashMap;", "", "Lcom/tencent/mm/plugin/mv/ui/uic/VisibleRecord$ViewState;", "Lkotlin/collections/HashMap;", "parent", "Landroid/view/View;", "animate", "view", "clean", "", "gone", "ids", "", "hide", "visible", "invisible", "restore", "updateParent", "Companion", "ViewState", "plugin-mv_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class x
{
  public static final a Mhf;
  public final HashMap<Integer, b> Mhg;
  private final String TAG;
  private View nma;
  
  static
  {
    AppMethodBeat.i(287465);
    Mhf = new a((byte)0);
    AppMethodBeat.o(287465);
  }
  
  public x()
  {
    AppMethodBeat.i(287446);
    this.TAG = "MicroMsg.VisibleRecord";
    this.Mhg = new HashMap();
    AppMethodBeat.o(287446);
  }
  
  private final void C(Set<Integer> paramSet)
  {
    AppMethodBeat.i(287451);
    Iterator localIterator = paramSet.iterator();
    if (localIterator.hasNext())
    {
      int i = ((Number)localIterator.next()).intValue();
      paramSet = this.nma;
      label48:
      int j;
      if (paramSet == null)
      {
        paramSet = null;
        if (paramSet == null) {
          break label161;
        }
        j = paramSet.getVisibility();
        if (j == 8) {
          break label163;
        }
      }
      label161:
      label163:
      for (boolean bool = true;; bool = false)
      {
        b localb = new b(i, j, paramSet.getAlpha(), 8, 0.0F, bool);
        ((Map)this.Mhg).put(Integer.valueOf(i), localb);
        if (!bool) {
          break;
        }
        paramSet.animate().cancel();
        paramSet.animate().alpha(localb.Mhj).setDuration(150L).withEndAction(new x..ExternalSyntheticLambda1(paramSet, localb)).start();
        break;
        paramSet = paramSet.findViewById(i);
        break label48;
        break;
      }
    }
    AppMethodBeat.o(287451);
  }
  
  private static final void a(View paramView, b paramb)
  {
    AppMethodBeat.i(287454);
    s.u(paramView, "$child");
    s.u(paramb, "$state");
    paramView.setVisibility(paramb.xoM);
    AppMethodBeat.o(287454);
  }
  
  private static final void b(View paramView, b paramb)
  {
    AppMethodBeat.i(287462);
    s.u(paramView, "$child");
    s.u(paramb, "$state");
    paramView.setVisibility(paramb.Mhi);
    AppMethodBeat.o(287462);
  }
  
  public final x A(Set<Integer> paramSet)
  {
    AppMethodBeat.i(287483);
    s.u(paramSet, "ids");
    Log.i(this.TAG, "gone: ");
    C(paramSet);
    AppMethodBeat.o(287483);
    return this;
  }
  
  public final x B(Set<Integer> paramSet)
  {
    AppMethodBeat.i(287493);
    s.u(paramSet, "ids");
    Iterator localIterator = paramSet.iterator();
    if (localIterator.hasNext())
    {
      int i = ((Number)localIterator.next()).intValue();
      paramSet = this.nma;
      label54:
      int j;
      if (paramSet == null)
      {
        paramSet = null;
        if (paramSet == null) {
          break label156;
        }
        j = paramSet.getVisibility();
        if (j == 0) {
          break label158;
        }
      }
      label156:
      label158:
      for (boolean bool = true;; bool = false)
      {
        b localb = new b(i, j, paramSet.getAlpha(), 0, 1.0F, bool);
        ((Map)this.Mhg).put(Integer.valueOf(i), localb);
        if (!bool) {
          break;
        }
        paramSet.animate().cancel();
        paramSet.setVisibility(0);
        paramSet.animate().alpha(localb.Mhj).setDuration(150L).start();
        break;
        paramSet = paramSet.findViewById(i);
        break label54;
        break;
      }
    }
    AppMethodBeat.o(287493);
    return this;
  }
  
  public final x ix(View paramView)
  {
    AppMethodBeat.i(287479);
    this.nma = paramView;
    this.Mhg.clear();
    AppMethodBeat.o(287479);
    return this;
  }
  
  public final void restore()
  {
    AppMethodBeat.i(287499);
    Iterator localIterator = this.Mhg.values().iterator();
    while (localIterator.hasNext())
    {
      b localb = (b)localIterator.next();
      if (localb.djJ)
      {
        View localView = this.nma;
        if (localView == null) {}
        for (localView = null;; localView = localView.findViewById(localb.id))
        {
          if (localView == null) {
            break label114;
          }
          localView.animate().cancel();
          if (localb.xoM != 0) {
            break label116;
          }
          localView.setVisibility(localb.xoM);
          localView.animate().alpha(localb.Mhh).setDuration(150L).start();
          break;
        }
        label114:
        continue;
        label116:
        localView.animate().alpha(localb.Mhh).setDuration(150L).withEndAction(new x..ExternalSyntheticLambda0(localView, localb)).start();
      }
    }
    this.Mhg.clear();
    AppMethodBeat.o(287499);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/mv/ui/uic/VisibleRecord$Companion;", "", "()V", "ANIMATION_DURATION", "", "simpleSettingMethod", "", "parent", "Landroid/view/View;", "ids", "", "", "visible", "plugin-mv_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
  {
    public static void a(View paramView, List<Integer> paramList, int paramInt)
    {
      AppMethodBeat.i(287888);
      s.u(paramList, "ids");
      Iterator localIterator = paramList.iterator();
      if (localIterator.hasNext())
      {
        int i = ((Number)localIterator.next()).intValue();
        if (paramView == null)
        {
          paramList = null;
          label50:
          if (paramList == null) {
            break label100;
          }
          if (paramInt != 0) {
            break label102;
          }
        }
        label100:
        label102:
        for (float f = 1.0F;; f = 0.0F)
        {
          paramList.animate().alpha(f).setDuration(150L).withEndAction(new x.a..ExternalSyntheticLambda0(paramList, paramInt)).start();
          break;
          paramList = paramView.findViewById(i);
          break label50;
          break;
        }
      }
      AppMethodBeat.o(287888);
    }
    
    private static final void aJ(View paramView, int paramInt)
    {
      AppMethodBeat.i(287892);
      s.u(paramView, "$child");
      paramView.setVisibility(paramInt);
      AppMethodBeat.o(287892);
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/mv/ui/uic/VisibleRecord$ViewState;", "", "id", "", "startState", "startAlpha", "", "endState", "endAlpha", "changed", "", "(IIFIFZ)V", "getChanged", "()Z", "getEndAlpha", "()F", "getEndState", "()I", "getId", "getStartAlpha", "getStartState", "plugin-mv_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
  {
    final float Mhh;
    final int Mhi;
    final float Mhj;
    final boolean djJ;
    final int id;
    final int xoM;
    
    public b(int paramInt1, int paramInt2, float paramFloat1, int paramInt3, float paramFloat2, boolean paramBoolean)
    {
      this.id = paramInt1;
      this.xoM = paramInt2;
      this.Mhh = paramFloat1;
      this.Mhi = paramInt3;
      this.Mhj = paramFloat2;
      this.djJ = paramBoolean;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.mv.ui.uic.x
 * JD-Core Version:    0.7.0.1
 */