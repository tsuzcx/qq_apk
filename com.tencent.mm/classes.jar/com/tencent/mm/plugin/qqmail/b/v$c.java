package com.tencent.mm.plugin.qqmail.b;

import android.os.Bundle;

public final class v$c
{
  public boolean neA = true;
  public boolean ney = false;
  public boolean nez = true;
  
  public final void fromBundle(Bundle paramBundle)
  {
    this.ney = paramBundle.getBoolean("qqmail_httpoptions_expired");
    this.nez = paramBundle.getBoolean("qqmail_httpoptions_needcache");
    this.neA = paramBundle.getBoolean("qqmail_httpoptions_needparse");
  }
  
  public final void toBundle(Bundle paramBundle)
  {
    paramBundle.putBoolean("qqmail_httpoptions_expired", this.ney);
    paramBundle.putBoolean("qqmail_httpoptions_needcache", this.nez);
    paramBundle.putBoolean("qqmail_httpoptions_needparse", this.neA);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.qqmail.b.v.c
 * JD-Core Version:    0.7.0.1
 */