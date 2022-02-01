package com.tencent.tav.player;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum IPlayer$PlayerStatus
{
  static
  {
    AppMethodBeat.i(198160);
    IDLE = new PlayerStatus("IDLE", 0);
    READY = new PlayerStatus("READY", 1);
    PLAYING = new PlayerStatus("PLAYING", 2);
    STOPPED = new PlayerStatus("STOPPED", 3);
    PAUSED = new PlayerStatus("PAUSED", 4);
    FINISHED = new PlayerStatus("FINISHED", 5);
    ERROR = new PlayerStatus("ERROR", 6);
    REPLAY = new PlayerStatus("REPLAY", 7);
    $VALUES = new PlayerStatus[] { IDLE, READY, PLAYING, STOPPED, PAUSED, FINISHED, ERROR, REPLAY };
    AppMethodBeat.o(198160);
  }
  
  private IPlayer$PlayerStatus() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.tav.player.IPlayer.PlayerStatus
 * JD-Core Version:    0.7.0.1
 */