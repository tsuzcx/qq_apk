package com.tencent.mm.plugin.sns.ui.previewimageview;

final class DynamicGridView$i
  implements DynamicGridView.j
{
  private int qP;
  private int qQ;
  
  public DynamicGridView$i(DynamicGridView paramDynamicGridView, int paramInt1, int paramInt2)
  {
    this.qP = paramInt1;
    this.qQ = paramInt2;
  }
  
  public final void ee(int paramInt1, int paramInt2)
  {
    DynamicGridView.a(this.pqL, DynamicGridView.e(this.pqL) + this.qQ);
    DynamicGridView.b(this.pqL, DynamicGridView.f(this.pqL) + this.qP);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.previewimageview.DynamicGridView.i
 * JD-Core Version:    0.7.0.1
 */