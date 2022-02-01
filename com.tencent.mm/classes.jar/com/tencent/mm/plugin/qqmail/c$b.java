package com.tencent.mm.plugin.qqmail;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class c$b
{
  public boolean xaN = false;
  public boolean xaO = true;
  public boolean xaP = true;
  
  public final void fromBundle(Bundle paramBundle)
  {
    AppMethodBeat.i(215165);
    this.xaN = paramBundle.getBoolean("qqmail_httpoptions_expired");
    this.xaO = paramBundle.getBoolean("qqmail_httpoptions_needcache");
    this.xaP = paramBundle.getBoolean("qqmail_httpoptions_needparse");
    AppMethodBeat.o(215165);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.qqmail.c.b
 * JD-Core Version:    0.7.0.1
 */