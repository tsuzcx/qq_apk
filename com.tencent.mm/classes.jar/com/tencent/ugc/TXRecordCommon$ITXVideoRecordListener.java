package com.tencent.ugc;

import android.os.Bundle;

public abstract interface TXRecordCommon$ITXVideoRecordListener
{
  public abstract void onRecordComplete(TXRecordCommon.TXRecordResult paramTXRecordResult);
  
  public abstract void onRecordEvent(int paramInt, Bundle paramBundle);
  
  public abstract void onRecordProgress(long paramLong);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.ugc.TXRecordCommon.ITXVideoRecordListener
 * JD-Core Version:    0.7.0.1
 */