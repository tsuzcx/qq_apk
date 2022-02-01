package com.tencent.wxperf.jni;

import android.support.annotation.Keep;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.stubs.logger.Log;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class HookManager
{
  public static final HookManager MoC;
  public volatile boolean MoD;
  private Set<a> MoE;
  
  static
  {
    AppMethodBeat.i(211533);
    MoC = new HookManager();
    AppMethodBeat.o(211533);
  }
  
  private HookManager()
  {
    AppMethodBeat.i(211527);
    this.MoE = new HashSet();
    AppMethodBeat.o(211527);
  }
  
  @Keep
  public static String getStack()
  {
    AppMethodBeat.i(211531);
    String str = stackTraceToString(new Throwable().getStackTrace());
    AppMethodBeat.o(211531);
    return str;
  }
  
  private static String stackTraceToString(StackTraceElement[] paramArrayOfStackTraceElement)
  {
    AppMethodBeat.i(211532);
    if (paramArrayOfStackTraceElement == null)
    {
      AppMethodBeat.o(211532);
      return "";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    int j = paramArrayOfStackTraceElement.length;
    int i = 0;
    while (i < j)
    {
      StackTraceElement localStackTraceElement = paramArrayOfStackTraceElement[i];
      if (!localStackTraceElement.getClassName().contains("java.lang.Thread")) {
        localStringBuilder.append("\t").append(localStackTraceElement).append('\n');
      }
      i += 1;
    }
    paramArrayOfStackTraceElement = localStringBuilder.toString();
    AppMethodBeat.o(211532);
    return paramArrayOfStackTraceElement;
  }
  
  private native void xhookClearNative();
  
  private native void xhookEnableDebugNative(boolean paramBoolean);
  
  private native void xhookEnableSigSegvProtectionNative(boolean paramBoolean);
  
  private native int xhookRefreshNative(boolean paramBoolean);
  
  public final HookManager a(a parama)
  {
    AppMethodBeat.i(211529);
    if (parama != null) {
      this.MoE.add(parama);
    }
    AppMethodBeat.o(211529);
    return this;
  }
  
  public final void gah()
  {
    AppMethodBeat.i(211528);
    Object localObject;
    if (this.MoD)
    {
      localObject = new a("this process has already been hooked!");
      AppMethodBeat.o(211528);
      throw ((Throwable)localObject);
    }
    if (this.MoE.isEmpty())
    {
      AppMethodBeat.o(211528);
      return;
    }
    try
    {
      System.loadLibrary("wxperf-jni");
      localObject = this.MoE.iterator();
      while (((Iterator)localObject).hasNext()) {
        ((a)((Iterator)localObject).next()).gaf();
      }
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        Log.printStack(6, "Wxperf.HookManager", localThrowable);
      }
      Iterator localIterator = this.MoE.iterator();
      while (localIterator.hasNext()) {
        ((a)localIterator.next()).gag();
      }
      xhookEnableDebugNative(false);
      xhookEnableSigSegvProtectionNative(true);
      xhookRefreshNative(false);
      this.MoD = true;
      AppMethodBeat.o(211528);
    }
  }
  
  public final HookManager gai()
  {
    AppMethodBeat.i(211530);
    this.MoE.clear();
    AppMethodBeat.o(211530);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.wxperf.jni.HookManager
 * JD-Core Version:    0.7.0.1
 */