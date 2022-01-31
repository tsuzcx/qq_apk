package com.tencent.mm.plugin.voip.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ak;
import java.util.TimerTask;

final class VoipVideoFragment$9
  extends TimerTask
{
  VoipVideoFragment$9(VoipVideoFragment paramVoipVideoFragment) {}
  
  public final void run()
  {
    AppMethodBeat.i(4878);
    this.tEo.iMP.post(new VoipVideoFragment.9.1(this));
    AppMethodBeat.o(4878);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.ui.VoipVideoFragment.9
 * JD-Core Version:    0.7.0.1
 */