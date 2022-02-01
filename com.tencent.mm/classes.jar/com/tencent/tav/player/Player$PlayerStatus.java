package com.tencent.tav.player;

import com.tencent.matrix.trace.core.AppMethodBeat;

 enum Player$PlayerStatus
{
  static
  {
    AppMethodBeat.i(218555);
    PlayerStatusUnknown = new PlayerStatus("PlayerStatusUnknown", 0);
    PlayerStatusReadyToPlay = new PlayerStatus("PlayerStatusReadyToPlay", 1);
    PlayerStatusFailed = new PlayerStatus("PlayerStatusFailed", 2);
    $VALUES = new PlayerStatus[] { PlayerStatusUnknown, PlayerStatusReadyToPlay, PlayerStatusFailed };
    AppMethodBeat.o(218555);
  }
  
  private Player$PlayerStatus() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.tav.player.Player.PlayerStatus
 * JD-Core Version:    0.7.0.1
 */