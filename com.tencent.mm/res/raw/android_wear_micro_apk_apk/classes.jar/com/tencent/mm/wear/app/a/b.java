package com.tencent.mm.wear.app.a;

import com.google.android.gms.wearable.Channel;
import com.google.android.gms.wearable.c;
import com.google.android.gms.wearable.z;
import com.tencent.mm.wear.a.c.d;
import java.io.File;

final class b
  implements c
{
  public String adT;
  public String adU;
  public String adV;
  
  private b(a parama) {}
  
  public final void a(Channel paramChannel, int paramInt1, int paramInt2)
  {
    if ((this.adU.equals(paramChannel.getPath())) && (this.adV.equals(paramChannel.kz())))
    {
      new File(this.adT).delete();
      d.c("MicroMsg.GlobalConnection", "delete file %s %s", new Object[] { this.adU, this.adT });
      z.Ur.b(a.a(this.adW), this);
      paramChannel.a(a.a(this.adW));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.tencent.mm.wear.app.a.b
 * JD-Core Version:    0.7.0.1
 */