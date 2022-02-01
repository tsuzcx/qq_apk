package com.tencent.mm.wear.app.ui.widget;

final class f
  implements Runnable
{
  private int alX;
  private int alY;
  
  public f(RecordView paramRecordView, int paramInt1, int paramInt2)
  {
    this.alX = paramInt1;
    this.alY = paramInt2;
  }
  
  public final void run()
  {
    if (RecordView.a(this.alZ) != null) {
      RecordView.a(this.alZ).am(this.alX, this.alY);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.tencent.mm.wear.app.ui.widget.f
 * JD-Core Version:    0.7.0.1
 */