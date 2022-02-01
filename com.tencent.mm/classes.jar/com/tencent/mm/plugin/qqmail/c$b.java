package com.tencent.mm.plugin.qqmail;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class c$b
{
  public boolean Hld = false;
  public boolean Hle = true;
  public boolean Hlf = true;
  
  public final void fromBundle(Bundle paramBundle)
  {
    AppMethodBeat.i(249644);
    this.Hld = paramBundle.getBoolean("qqmail_httpoptions_expired");
    this.Hle = paramBundle.getBoolean("qqmail_httpoptions_needcache");
    this.Hlf = paramBundle.getBoolean("qqmail_httpoptions_needparse");
    AppMethodBeat.o(249644);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.qqmail.c.b
 * JD-Core Version:    0.7.0.1
 */