package com.tencent.mm.ui.j;

import android.os.Bundle;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ak;
import org.b.d.i;
import org.b.d.k;
import org.b.e.b;

final class a$4
  implements Runnable
{
  a$4(a parama, Bundle paramBundle) {}
  
  public final void run()
  {
    Object localObject3 = null;
    AppMethodBeat.i(80345);
    if (this.ABh.ABc == null)
    {
      AppMethodBeat.o(80345);
      return;
    }
    a.rx(true);
    String str = this.ABi.getString("oauth_verifier");
    Object localObject1 = localObject3;
    if (str != null) {
      localObject1 = new k(str);
    }
    try
    {
      localObject1 = this.ABh.ABa.a(this.ABh.ABc, (k)localObject1);
      if (localObject1 != null)
      {
        this.ABh.ABb = ((i)localObject1);
        a.a(this.ABh.ABb);
        new ak(Looper.getMainLooper()).post(new a.4.1(this));
        AppMethodBeat.o(80345);
        return;
      }
      new ak(Looper.getMainLooper()).post(new a.4.2(this));
      AppMethodBeat.o(80345);
      return;
    }
    catch (org.b.b.a locala)
    {
      for (;;)
      {
        Object localObject2 = localObject3;
      }
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(80346);
    String str = super.toString() + "|onComplete";
    AppMethodBeat.o(80346);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.j.a.4
 * JD-Core Version:    0.7.0.1
 */