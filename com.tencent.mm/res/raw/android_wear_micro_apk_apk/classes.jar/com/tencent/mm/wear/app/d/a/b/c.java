package com.tencent.mm.wear.app.d.a.b;

import com.tencent.mm.e.a.al;
import com.tencent.mm.wear.app.a.i;
import com.tencent.mm.wear.app.g.a;
import java.io.IOException;

final class c
  extends a
{
  private boolean ahs;
  private boolean aht;
  private byte[] data;
  
  public c(b paramb, byte[] paramArrayOfByte, boolean paramBoolean1, boolean paramBoolean2)
  {
    this.data = paramArrayOfByte;
    this.ahs = paramBoolean1;
    this.aht = paramBoolean2;
  }
  
  protected final void execute()
  {
    al localal = new al();
    localal.XI = b.a(this.ahw);
    localal.Yw = this.ahs;
    localal.Yx = this.aht;
    if (this.data != null)
    {
      localal.Yv = this.data.length;
      localal.Yj = new com.tencent.mm.d.b(this.data, 0, this.data.length);
    }
    try
    {
      b.b(this.ahw).i(localal.toByteArray());
      return;
    }
    catch (IOException localIOException) {}
  }
  
  protected final String getName()
  {
    return "SendVoiceToTextDataTask";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.tencent.mm.wear.app.d.a.b.c
 * JD-Core Version:    0.7.0.1
 */