package com.tencent.mm.ui.g.a;

import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.login.LoginResult;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

final class d$1
  implements FacebookCallback<LoginResult>
{
  d$1(d paramd) {}
  
  public final void onCancel()
  {
    AppMethodBeat.i(80310);
    ab.i("MicroMsg.FacebookAndroid", "facebook auth cancel!");
    if (this.Aoc.Aoa != null) {
      this.Aoc.Aoa.onCancel();
    }
    AppMethodBeat.o(80310);
  }
  
  public final void onError(FacebookException paramFacebookException)
  {
    AppMethodBeat.i(80311);
    ab.e("MicroMsg.FacebookAndroid", "facebook auth error! %s", new Object[] { paramFacebookException.getMessage() });
    if (this.Aoc.Aoa != null) {
      this.Aoc.Aoa.onError(paramFacebookException.getMessage());
    }
    AppMethodBeat.o(80311);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.g.a.d.1
 * JD-Core Version:    0.7.0.1
 */