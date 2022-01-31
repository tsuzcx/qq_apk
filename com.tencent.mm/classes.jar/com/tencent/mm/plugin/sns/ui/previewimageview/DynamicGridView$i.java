package com.tencent.mm.plugin.sns.ui.previewimageview;

import com.tencent.matrix.trace.core.AppMethodBeat;

final class DynamicGridView$i
  implements DynamicGridView.j
{
  private int rM;
  private int rN;
  
  public DynamicGridView$i(DynamicGridView paramDynamicGridView, int paramInt1, int paramInt2)
  {
    this.rM = paramInt1;
    this.rN = paramInt2;
  }
  
  public final void fR(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(40366);
    DynamicGridView.a(this.slD, DynamicGridView.e(this.slD) + this.rN);
    DynamicGridView.b(this.slD, DynamicGridView.f(this.slD) + this.rM);
    AppMethodBeat.o(40366);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.previewimageview.DynamicGridView.i
 * JD-Core Version:    0.7.0.1
 */