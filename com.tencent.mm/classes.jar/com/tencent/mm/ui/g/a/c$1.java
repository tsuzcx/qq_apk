package com.tencent.mm.ui.g.a;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

final class c$1
  implements c.a
{
  c$1(c paramc) {}
  
  public final void a(b paramb)
  {
    AppMethodBeat.i(80295);
    ab.d("Facebook-authorize", "Login failed: ".concat(String.valueOf(paramb)));
    c.a(this.AnX).a(paramb);
    AppMethodBeat.o(80295);
  }
  
  public final void a(e parame)
  {
    AppMethodBeat.i(80296);
    ab.d("Facebook-authorize", "Login failed: ".concat(String.valueOf(parame)));
    c.a(this.AnX).a(parame);
    AppMethodBeat.o(80296);
  }
  
  public final void onCancel()
  {
    AppMethodBeat.i(80297);
    ab.d("Facebook-authorize", "Login canceled");
    c.a(this.AnX).onCancel();
    AppMethodBeat.o(80297);
  }
  
  public final void u(Bundle paramBundle)
  {
    AppMethodBeat.i(80294);
    com.tencent.xweb.c.dYi();
    com.tencent.xweb.c.sync();
    this.AnX.auI(paramBundle.getString("access_token"));
    this.AnX.auJ(paramBundle.getString("expires_in"));
    if (this.AnX.dNf())
    {
      ab.d("Facebook-authorize", "Login Success! access_token=" + this.AnX.gsH + " expires=" + this.AnX.AnR);
      c.a(this.AnX).u(paramBundle);
      AppMethodBeat.o(80294);
      return;
    }
    c.a(this.AnX).a(new e("Failed to receive access token."));
    AppMethodBeat.o(80294);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.g.a.c.1
 * JD-Core Version:    0.7.0.1
 */