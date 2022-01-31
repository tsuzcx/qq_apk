package com.tencent.mm.wear.app.a;

import com.google.android.gms.wearable.Channel;
import com.google.android.gms.wearable.c;
import com.google.android.gms.wearable.z;
import com.tencent.mm.wear.a.c.d;
import java.io.File;

final class b
  implements c
{
  public String aas;
  public String aat;
  public String aau;
  
  private b(a parama) {}
  
  public final void a(Channel paramChannel, int paramInt1, int paramInt2)
  {
    if ((this.aat.equals(paramChannel.getPath())) && (this.aau.equals(paramChannel.kq())))
    {
      new File(this.aas).delete();
      d.c("MicroMsg.GlobalConnection", "delete file %s %s", new Object[] { this.aat, this.aas });
      z.SC.b(a.a(this.aav), this);
      paramChannel.a(a.a(this.aav));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.tencent.mm.wear.app.a.b
 * JD-Core Version:    0.7.0.1
 */