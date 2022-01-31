package com.tencent.smtt.sandbox;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.util.SparseArray;
import java.util.List;

public abstract interface ChildProcessServiceDelegate
{
  public abstract void ExitChildProcess();
  
  public abstract void RegisterFileDescriptors(String[] paramArrayOfString, int[] paramArrayOfInt1, int[] paramArrayOfInt2, long[] paramArrayOfLong1, long[] paramArrayOfLong2);
  
  public abstract SparseArray<String> getFileDescriptorsIdsToKeys();
  
  public abstract void initCommandLine(String[] paramArrayOfString);
  
  public abstract boolean loadNativeLibrary(Context paramContext);
  
  public abstract void onBeforeMain();
  
  public abstract void onConnectionSetup(Bundle paramBundle, List<IBinder> paramList);
  
  public abstract void onDestroy();
  
  public abstract void onServiceBound(Intent paramIntent);
  
  public abstract void onServiceCreated();
  
  public abstract void preloadNativeLibrary(Context paramContext);
  
  public abstract void runMain();
  
  public abstract void startContentMainRunner();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.smtt.sandbox.ChildProcessServiceDelegate
 * JD-Core Version:    0.7.0.1
 */