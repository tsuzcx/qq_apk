package com.tencent.tav.player;

import com.tencent.matrix.trace.core.AppMethodBeat;

 enum Player$AVPlayerActionAtItemEnd
{
  static
  {
    AppMethodBeat.i(198164);
    AVPlayerActionAtItemEndAdvance = new AVPlayerActionAtItemEnd("AVPlayerActionAtItemEndAdvance", 0);
    AVPlayerActionAtItemEndPause = new AVPlayerActionAtItemEnd("AVPlayerActionAtItemEndPause", 1);
    AVPlayerActionAtItemEndNone = new AVPlayerActionAtItemEnd("AVPlayerActionAtItemEndNone", 2);
    $VALUES = new AVPlayerActionAtItemEnd[] { AVPlayerActionAtItemEndAdvance, AVPlayerActionAtItemEndPause, AVPlayerActionAtItemEndNone };
    AppMethodBeat.o(198164);
  }
  
  private Player$AVPlayerActionAtItemEnd() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.tav.player.Player.AVPlayerActionAtItemEnd
 * JD-Core Version:    0.7.0.1
 */