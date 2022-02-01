package com.tencent.mm.view.refreshLayout.a;

import android.content.res.TypedArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.a.m;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.view.refreshLayout.e.a;
import com.tencent.mm.view.refreshLayout.e.a.a;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/view/refreshLayout/config/HeaderConfig;", "", "()V", "headerHeight", "", "getHeaderHeight", "()I", "setHeaderHeight", "(I)V", "headerHeightStatus", "Lcom/tencent/mm/view/refreshLayout/status/DimensionStatus;", "getHeaderHeightStatus", "()Lcom/tencent/mm/view/refreshLayout/status/DimensionStatus;", "setHeaderHeightStatus", "(Lcom/tencent/mm/view/refreshLayout/status/DimensionStatus;)V", "headerMaxDragRate", "", "getHeaderMaxDragRate", "()F", "setHeaderMaxDragRate", "(F)V", "headerTriggerRate", "getHeaderTriggerRate", "setHeaderTriggerRate", "initConfig", "ta", "Landroid/content/res/TypedArray;", "Builder", "libmmui_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class d
{
  public a agQm;
  public float agQn;
  public float agQo;
  public int headerHeight;
  
  public d()
  {
    AppMethodBeat.i(235119);
    this.headerHeight = com.tencent.mm.view.d.e(MMApplicationContext.getContext(), 100.0F);
    a.a locala = a.agQt;
    this.agQm = a.jNC();
    this.agQn = 5.0F;
    this.agQo = 1.0F;
    AppMethodBeat.o(235119);
  }
  
  public final void b(a parama)
  {
    AppMethodBeat.i(235125);
    s.u(parama, "<set-?>");
    this.agQm = parama;
    AppMethodBeat.o(235125);
  }
  
  public final d g(TypedArray paramTypedArray)
  {
    AppMethodBeat.i(235132);
    s.u(paramTypedArray, "ta");
    this.headerHeight = paramTypedArray.getDimensionPixelOffset(a.m.WxRefreshLayout_headerHeight, this.headerHeight);
    if (paramTypedArray.hasValue(a.m.WxRefreshLayout_headerHeight)) {
      localObject = a.agQt;
    }
    for (Object localObject = a.jNF();; localObject = this.agQm)
    {
      this.agQm = ((a)localObject);
      this.agQn = paramTypedArray.getFloat(a.m.WxRefreshLayout_headerMaxDragRate, this.agQn);
      this.agQo = paramTypedArray.getFloat(a.m.WxRefreshLayout_headerTriggerRate, this.agQo);
      AppMethodBeat.o(235132);
      return this;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.view.refreshLayout.a.d
 * JD-Core Version:    0.7.0.1
 */