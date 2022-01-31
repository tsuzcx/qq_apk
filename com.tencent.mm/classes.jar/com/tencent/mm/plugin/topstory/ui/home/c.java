package com.tencent.mm.plugin.topstory.ui.home;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.MMActivity;

public final class c
  extends b
{
  public c(MMActivity paramMMActivity)
  {
    super(paramMMActivity, true);
  }
  
  protected final boolean cIQ()
  {
    return false;
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(1679);
    super.onCreate(paramBundle);
    AppMethodBeat.o(1679);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.home.c
 * JD-Core Version:    0.7.0.1
 */