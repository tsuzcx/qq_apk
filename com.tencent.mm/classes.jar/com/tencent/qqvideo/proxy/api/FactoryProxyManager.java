package com.tencent.qqvideo.proxy.api;

import com.tencent.qqvideo.proxy.common.PlayManagerImp;

public class FactoryProxyManager
{
  private static IPlayManager playManager = null;
  
  public static IPlayManager getPlayManager()
  {
    try
    {
      if (playManager == null) {
        playManager = new PlayManagerImp();
      }
      IPlayManager localIPlayManager = playManager;
      return localIPlayManager;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.qqvideo.proxy.api.FactoryProxyManager
 * JD-Core Version:    0.7.0.1
 */