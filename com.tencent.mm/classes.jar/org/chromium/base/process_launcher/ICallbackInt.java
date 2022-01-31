package org.chromium.base.process_launcher;

import android.os.Bundle;
import android.os.IInterface;

public abstract interface ICallbackInt
  extends IInterface
{
  public abstract void call(int paramInt);
  
  public abstract void invokeMiscMethod(String paramString, Bundle paramBundle);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     org.chromium.base.process_launcher.ICallbackInt
 * JD-Core Version:    0.7.0.1
 */