package com.tencent.wxperf.jni;

import android.support.annotation.Keep;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.stubs.logger.Log;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class HookManager
{
  public static final HookManager MLy;
  private Set<a> MLA;
  public volatile boolean MLz;
  
  static
  {
    AppMethodBeat.i(195204);
    MLy = new HookManager();
    AppMethodBeat.o(195204);
  }
  
  private HookManager()
  {
    AppMethodBeat.i(195199);
    this.MLA = new HashSet();
    AppMethodBeat.o(195199);
  }
  
  @Keep
  public static String getStack()
  {
    AppMethodBeat.i(195203);
    Object localObject1 = Thread.currentThread().getStackTrace();
    if (localObject1 == null)
    {
      AppMethodBeat.o(195203);
      return "";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    int j = localObject1.length;
    int i = 0;
    while (i < j)
    {
      Object localObject2 = localObject1[i];
      if (!localObject2.getClassName().contains("java.lang.Thread")) {
        localStringBuilder.append("\t").append(localObject2).append('\n');
      }
      i += 1;
    }
    localObject1 = localStringBuilder.toString();
    AppMethodBeat.o(195203);
    return localObject1;
  }
  
  private native void xhookClearNative();
  
  private native void xhookEnableDebugNative(boolean paramBoolean);
  
  private native void xhookEnableSigSegvProtectionNative(boolean paramBoolean);
  
  private native int xhookRefreshNative(boolean paramBoolean);
  
  public final HookManager a(a parama)
  {
    AppMethodBeat.i(195201);
    if (parama != null) {
      this.MLA.add(parama);
    }
    AppMethodBeat.o(195201);
    return this;
  }
  
  public final void geJ()
  {
    AppMethodBeat.i(195200);
    Object localObject;
    if (this.MLz)
    {
      localObject = new a("this process has already been hooked!");
      AppMethodBeat.o(195200);
      throw ((Throwable)localObject);
    }
    if (this.MLA.isEmpty())
    {
      AppMethodBeat.o(195200);
      return;
    }
    try
    {
      System.loadLibrary("wxperf-jni");
      localObject = this.MLA.iterator();
      while (((Iterator)localObject).hasNext()) {
        ((a)((Iterator)localObject).next()).geH();
      }
      localIterator = this.MLA.iterator();
    }
    catch (Throwable localThrowable)
    {
      Log.printStack(6, "Wxperf.HookManager", localThrowable);
      AppMethodBeat.o(195200);
      return;
    }
    Iterator localIterator;
    while (localIterator.hasNext()) {
      ((a)localIterator.next()).geI();
    }
    xhookEnableDebugNative(false);
    xhookEnableSigSegvProtectionNative(true);
    xhookRefreshNative(false);
    this.MLz = true;
    AppMethodBeat.o(195200);
  }
  
  public final HookManager geK()
  {
    AppMethodBeat.i(195202);
    this.MLA.clear();
    AppMethodBeat.o(195202);
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