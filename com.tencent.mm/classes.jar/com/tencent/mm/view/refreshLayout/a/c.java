package com.tencent.mm.view.refreshLayout.a;

import android.content.res.TypedArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.a.m;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.view.d;
import com.tencent.mm.view.refreshLayout.e.a;
import com.tencent.mm.view.refreshLayout.e.a.a;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/view/refreshLayout/config/FooterConfig;", "", "()V", "footerHeight", "", "getFooterHeight", "()I", "setFooterHeight", "(I)V", "footerHeightStatus", "Lcom/tencent/mm/view/refreshLayout/status/DimensionStatus;", "getFooterHeightStatus", "()Lcom/tencent/mm/view/refreshLayout/status/DimensionStatus;", "setFooterHeightStatus", "(Lcom/tencent/mm/view/refreshLayout/status/DimensionStatus;)V", "footerMaxDragRate", "", "getFooterMaxDragRate", "()F", "setFooterMaxDragRate", "(F)V", "footerTriggerRate", "getFooterTriggerRate", "setFooterTriggerRate", "initConfig", "ta", "Landroid/content/res/TypedArray;", "Builder", "libmmui_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class c
{
  public a agQj;
  public float agQk;
  public float agQl;
  public int footerHeight;
  
  public c()
  {
    AppMethodBeat.i(235123);
    this.footerHeight = d.e(MMApplicationContext.getContext(), 60.0F);
    a.a locala = a.agQt;
    this.agQj = a.jNC();
    this.agQk = 3.0F;
    this.agQl = 1.0F;
    AppMethodBeat.o(235123);
  }
  
  public final void a(a parama)
  {
    AppMethodBeat.i(235128);
    s.u(parama, "<set-?>");
    this.agQj = parama;
    AppMethodBeat.o(235128);
  }
  
  public final c f(TypedArray paramTypedArray)
  {
    AppMethodBeat.i(235136);
    s.u(paramTypedArray, "ta");
    this.footerHeight = paramTypedArray.getDimensionPixelOffset(a.m.WxRefreshLayout_footerHeight, this.footerHeight);
    if (paramTypedArray.hasValue(a.m.WxRefreshLayout_footerHeight)) {
      localObject = a.agQt;
    }
    for (Object localObject = a.jNF();; localObject = this.agQj)
    {
      this.agQj = ((a)localObject);
      this.agQk = paramTypedArray.getFloat(a.m.WxRefreshLayout_footerMaxDragRate, this.agQk);
      this.agQl = paramTypedArray.getFloat(a.m.WxRefreshLayout_footerTriggerRate, this.agQl);
      AppMethodBeat.o(235136);
      return this;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.view.refreshLayout.a.c
 * JD-Core Version:    0.7.0.1
 */