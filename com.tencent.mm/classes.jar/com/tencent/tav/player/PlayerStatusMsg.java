package com.tencent.tav.player;

public class PlayerStatusMsg
{
  private String errorMsg;
  private IPlayer.PlayerStatus playerStatus;
  
  public PlayerStatusMsg(IPlayer.PlayerStatus paramPlayerStatus, String paramString)
  {
    this.playerStatus = paramPlayerStatus;
    this.errorMsg = paramString;
  }
  
  public String getErrorMsg()
  {
    return this.errorMsg;
  }
  
  public IPlayer.PlayerStatus getPlayerStatus()
  {
    return this.playerStatus;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.tav.player.PlayerStatusMsg
 * JD-Core Version:    0.7.0.1
 */