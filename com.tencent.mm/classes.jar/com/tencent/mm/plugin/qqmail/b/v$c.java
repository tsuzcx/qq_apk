package com.tencent.mm.plugin.qqmail.b;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class v$c
{
  public boolean pJN = false;
  public boolean pJO = true;
  public boolean pJP = true;
  
  public final void fromBundle(Bundle paramBundle)
  {
    AppMethodBeat.i(68002);
    this.pJN = paramBundle.getBoolean("qqmail_httpoptions_expired");
    this.pJO = paramBundle.getBoolean("qqmail_httpoptions_needcache");
    this.pJP = paramBundle.getBoolean("qqmail_httpoptions_needparse");
    AppMethodBeat.o(68002);
  }
  
  public final void toBundle(Bundle paramBundle)
  {
    AppMethodBeat.i(68001);
    paramBundle.putBoolean("qqmail_httpoptions_expired", this.pJN);
    paramBundle.putBoolean("qqmail_httpoptions_needcache", this.pJO);
    paramBundle.putBoolean("qqmail_httpoptions_needparse", this.pJP);
    AppMethodBeat.o(68001);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.qqmail.b.v.c
 * JD-Core Version:    0.7.0.1
 */