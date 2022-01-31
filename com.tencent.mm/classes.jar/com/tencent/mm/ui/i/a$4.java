package com.tencent.mm.ui.i;

import android.os.Bundle;
import android.os.Looper;
import com.tencent.mm.sdk.platformtools.ah;
import org.c.d.i;
import org.c.d.k;
import org.c.e.b;

final class a$4
  implements Runnable
{
  a$4(a parama, Bundle paramBundle) {}
  
  public final void run()
  {
    Object localObject3 = null;
    if (this.win.wii == null) {
      return;
    }
    a.nN(true);
    String str = this.wio.getString("oauth_verifier");
    Object localObject1 = localObject3;
    if (str != null) {
      localObject1 = new k(str);
    }
    try
    {
      localObject1 = this.win.wig.a(this.win.wii, (k)localObject1);
      if (localObject1 != null)
      {
        this.win.wih = ((i)localObject1);
        a.a(this.win.wih);
        new ah(Looper.getMainLooper()).post(new a.4.1(this));
        return;
      }
      new ah(Looper.getMainLooper()).post(new a.4.2(this));
      return;
    }
    catch (org.c.b.a locala)
    {
      for (;;)
      {
        Object localObject2 = localObject3;
      }
    }
  }
  
  public final String toString()
  {
    return super.toString() + "|onComplete";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.i.a.4
 * JD-Core Version:    0.7.0.1
 */