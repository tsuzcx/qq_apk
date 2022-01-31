package com.tencent.rtmp;

import android.os.Bundle;

public abstract interface ITXLivePushListener
{
  public abstract void onNetStatus(Bundle paramBundle);
  
  public abstract void onPushEvent(int paramInt, Bundle paramBundle);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.rtmp.ITXLivePushListener
 * JD-Core Version:    0.7.0.1
 */