package com.tencent.mm.wear.app.ui.widget;

final class f
  implements Runnable
{
  private int aiv;
  private int aiw;
  
  public f(RecordView paramRecordView, int paramInt1, int paramInt2)
  {
    this.aiv = paramInt1;
    this.aiw = paramInt2;
  }
  
  public final void run()
  {
    if (RecordView.a(this.aix) != null) {
      RecordView.a(this.aix).aj(this.aiv, this.aiw);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.tencent.mm.wear.app.ui.widget.f
 * JD-Core Version:    0.7.0.1
 */