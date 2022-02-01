package com.tencent.wxperf.jni;

import android.support.annotation.Keep;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.stubs.logger.Log;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class HookManager
{
  public static final HookManager Syn;
  public volatile boolean Syo;
  private Set<a> Syp;
  
  static
  {
    AppMethodBeat.i(199052);
    Syn = new HookManager();
    AppMethodBeat.o(199052);
  }
  
  private HookManager()
  {
    AppMethodBeat.i(199047);
    this.Syp = new HashSet();
    AppMethodBeat.o(199047);
  }
  
  @Keep
  public static String getStack()
  {
    AppMethodBeat.i(199051);
    Object localObject1 = Thread.currentThread().getStackTrace();
    if (localObject1 == null)
    {
      AppMethodBeat.o(199051);
      return "";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    int j = localObject1.length;
    int i = 0;
    while (i < j)
    {
      Object localObject2 = localObject1[i];
      if (!localObject2.getClassName().contains("java.lang.Thread")) {
        localStringBuilder.append(localObject2).append(';');
      }
      i += 1;
    }
    localObject1 = localStringBuilder.toString();
    AppMethodBeat.o(199051);
    return localObject1;
  }
  
  private native void xhookClearNative();
  
  private native void xhookEnableDebugNative(boolean paramBoolean);
  
  private native void xhookEnableSigSegvProtectionNative(boolean paramBoolean);
  
  private native int xhookRefreshNative(boolean paramBoolean);
  
  public final HookManager a(a parama)
  {
    AppMethodBeat.i(199049);
    if (parama != null) {
      this.Syp.add(parama);
    }
    AppMethodBeat.o(199049);
    return this;
  }
  
  public final void hrZ()
  {
    AppMethodBeat.i(199048);
    Object localObject;
    if (this.Syo)
    {
      localObject = new a("this process has already been hooked!");
      AppMethodBeat.o(199048);
      throw ((Throwable)localObject);
    }
    if (this.Syp.isEmpty())
    {
      AppMethodBeat.o(199048);
      return;
    }
    try
    {
      System.loadLibrary("wxperf-jni");
      localObject = this.Syp.iterator();
      while (((Iterator)localObject).hasNext()) {
        ((a)((Iterator)localObject).next()).hrX();
      }
      localIterator = this.Syp.iterator();
    }
    catch (Throwable localThrowable)
    {
      Log.printStack(6, "Wxperf.HookManager", localThrowable);
      AppMethodBeat.o(199048);
      return;
    }
    Iterator localIterator;
    while (localIterator.hasNext()) {
      ((a)localIterator.next()).hrY();
    }
    xhookEnableDebugNative(false);
    xhookEnableSigSegvProtectionNative(true);
    xhookRefreshNative(false);
    this.Syo = true;
    AppMethodBeat.o(199048);
  }
  
  public final HookManager hsa()
  {
    AppMethodBeat.i(199050);
    this.Syp.clear();
    AppMethodBeat.o(199050);
    return this;
  }
  
  public static final class a
    extends Exception
  {
    public a(String paramString)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.wxperf.jni.HookManager
 * JD-Core Version:    0.7.0.1
 */