package com.tencent.mm.plugin.textstatus.d;

import android.view.View;
import android.view.ViewPropertyAnimator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.secdata.ui.SecDataUIC;
import com.tencent.mm.plugin.secdata.ui.SecDataUIC.a;
import com.tencent.mm.plugin.textstatus.a.n;
import com.tencent.mm.plugin.textstatus.g.y;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/textstatus/logic/BaseProfileLoadLogic;", "Lcom/tencent/mm/plugin/textstatus/logic/BaseStatusLoadLogic;", "Lcom/tencent/mm/plugin/textstatus/logic/IProfileLoadLogic;", "showParam", "Lcom/tencent/mm/plugin/textstatus/api/StatusShowParam;", "(Lcom/tencent/mm/plugin/textstatus/api/StatusShowParam;)V", "vTopLine", "Landroid/view/View;", "getVTopLine", "()Landroid/view/View;", "setVTopLine", "(Landroid/view/View;)V", "init", "", "contentView", "onCoordinationViewClosing", "offset", "", "onCoordinationViewOpening", "onListInnerScroll", "onMuteIn", "onMuteOut", "onPostClose", "onPostOpen", "isMute", "", "onPreClose", "onPreOpen", "plugin-textstatus_release"})
public final class a
  extends b
  implements c
{
  private View FYc;
  
  public a(n paramn)
  {
    super(paramn);
    AppMethodBeat.i(216133);
    AppMethodBeat.o(216133);
  }
  
  public final void UC(int paramInt) {}
  
  public final void UD(int paramInt) {}
  
  public final void UE(int paramInt) {}
  
  public final void ba(View paramView)
  {
    AppMethodBeat.i(216130);
    p.h(paramView, "contentView");
    super.ba(paramView);
    this.FYc = paramView.findViewById(2131309670);
    AppMethodBeat.o(216130);
  }
  
  public final void eEk()
  {
    AppMethodBeat.i(216131);
    Object localObject = this.FYc;
    if (localObject != null)
    {
      localObject = ((View)localObject).animate();
      if (localObject != null)
      {
        localObject = ((ViewPropertyAnimator)localObject).alpha(0.0F);
        if (localObject != null) {
          ((ViewPropertyAnimator)localObject).setDuration(200L);
        }
      }
    }
    localObject = SecDataUIC.CWq;
    localObject = (y)SecDataUIC.a.a(getContext(), 9, y.class);
    if (localObject != null)
    {
      com.tencent.mm.plugin.textstatus.k.a locala = com.tencent.mm.plugin.textstatus.k.a.UsD;
      com.tencent.mm.plugin.textstatus.k.a.a(42L, (y)localObject);
      AppMethodBeat.o(216131);
      return;
    }
    AppMethodBeat.o(216131);
  }
  
  public final void eEl()
  {
    AppMethodBeat.i(216132);
    Object localObject = this.FYc;
    if (localObject != null)
    {
      localObject = ((View)localObject).animate();
      if (localObject != null)
      {
        localObject = ((ViewPropertyAnimator)localObject).alpha(0.15F);
        if (localObject != null)
        {
          ((ViewPropertyAnimator)localObject).setDuration(200L);
          AppMethodBeat.o(216132);
          return;
        }
      }
    }
    AppMethodBeat.o(216132);
  }
  
  public final void eEm() {}
  
  public final void eEn() {}
  
  public final void onPostClose() {}
  
  public final void onPostOpen(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.textstatus.d.a
 * JD-Core Version:    0.7.0.1
 */