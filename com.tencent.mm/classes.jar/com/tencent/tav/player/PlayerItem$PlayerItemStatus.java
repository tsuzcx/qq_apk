package com.tencent.tav.player;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum PlayerItem$PlayerItemStatus
{
  static
  {
    AppMethodBeat.i(215959);
    PlayerItemStatusUnknown = new PlayerItemStatus("PlayerItemStatusUnknown", 0);
    PlayerItemStatusReadyToPlay = new PlayerItemStatus("PlayerItemStatusReadyToPlay", 1);
    PlayerItemStatusFailed = new PlayerItemStatus("PlayerItemStatusFailed", 2);
    $VALUES = new PlayerItemStatus[] { PlayerItemStatusUnknown, PlayerItemStatusReadyToPlay, PlayerItemStatusFailed };
    AppMethodBeat.o(215959);
  }
  
  private PlayerItem$PlayerItemStatus() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.tav.player.PlayerItem.PlayerItemStatus
 * JD-Core Version:    0.7.0.1
 */