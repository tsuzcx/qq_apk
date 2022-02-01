package com.tencent.mm.plugin.qqmail;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class c$b
{
  public boolean NiQ = false;
  public boolean NiR = true;
  public boolean NiS = true;
  
  public final void fromBundle(Bundle paramBundle)
  {
    AppMethodBeat.i(266882);
    this.NiQ = paramBundle.getBoolean("qqmail_httpoptions_expired");
    this.NiR = paramBundle.getBoolean("qqmail_httpoptions_needcache");
    this.NiS = paramBundle.getBoolean("qqmail_httpoptions_needparse");
    AppMethodBeat.o(266882);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.qqmail.c.b
 * JD-Core Version:    0.7.0.1
 */