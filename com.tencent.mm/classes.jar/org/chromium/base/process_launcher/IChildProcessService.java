package org.chromium.base.process_launcher;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import java.util.List;

public abstract interface IChildProcessService
  extends IInterface
{
  public abstract boolean bindToCaller();
  
  public abstract void crashIntentionallyForTesting();
  
  public abstract void invokeMiscMethod(String paramString, Bundle paramBundle);
  
  public abstract void setupConnection(Bundle paramBundle, ICallbackInt paramICallbackInt, List<IBinder> paramList);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     org.chromium.base.process_launcher.IChildProcessService
 * JD-Core Version:    0.7.0.1
 */