package com.tencent.mm.ui.transmit;

import android.content.Context;
import com.tencent.mm.ui.base.p;

public final class e
{
  Context context;
  Runnable gmy = new e.1(this);
  int oYc;
  String text;
  p tipDialog;
  boolean wib;
  boolean wic;
  boolean wid;
  e.a wie;
  
  public e(Context paramContext)
  {
    this.context = paramContext;
  }
  
  public final void cJI()
  {
    if (this.wie != null) {
      this.wie.t(this.wid, this.text);
    }
  }
  
  public final boolean jC()
  {
    return this.wib & this.wic;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.transmit.e
 * JD-Core Version:    0.7.0.1
 */