package com.tencent.smtt.sdk;

import android.content.Context;
import android.os.Looper;
import com.tencent.smtt.export.external.jscore.interfaces.IX5JsContext;
import com.tencent.smtt.export.external.jscore.interfaces.IX5JsVirtualMachine;
import java.lang.ref.WeakReference;
import java.util.HashSet;
import java.util.Iterator;

public final class JsVirtualMachine
{
  private final Context a;
  private final IX5JsVirtualMachine b;
  private final HashSet<WeakReference<JsVirtualMachine.a>> c = new HashSet();
  
  public JsVirtualMachine(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public JsVirtualMachine(Context paramContext, Looper paramLooper)
  {
    this.a = paramContext;
    this.b = X5JsCore.a(paramContext, paramLooper);
  }
  
  protected final IX5JsContext a()
  {
    if (this.b == null)
    {
      JsVirtualMachine.a locala = new JsVirtualMachine.a(this.a);
      this.c.add(new WeakReference(locala));
      return locala;
    }
    return this.b.createJsContext();
  }
  
  public final void destroy()
  {
    if (this.b != null) {
      this.b.destroy();
    }
    for (;;)
    {
      return;
      Iterator localIterator = this.c.iterator();
      while (localIterator.hasNext())
      {
        WeakReference localWeakReference = (WeakReference)localIterator.next();
        if (localWeakReference.get() != null) {
          ((JsVirtualMachine.a)localWeakReference.get()).destroy();
        }
      }
    }
  }
  
  public final Looper getLooper()
  {
    if (this.b != null) {
      return this.b.getLooper();
    }
    return Looper.myLooper();
  }
  
  public final boolean isFallback()
  {
    return this.b == null;
  }
  
  public final void onPause()
  {
    if (this.b != null) {
      this.b.onPause();
    }
    for (;;)
    {
      return;
      Iterator localIterator = this.c.iterator();
      while (localIterator.hasNext())
      {
        WeakReference localWeakReference = (WeakReference)localIterator.next();
        if (localWeakReference.get() != null) {
          ((JsVirtualMachine.a)localWeakReference.get()).a();
        }
      }
    }
  }
  
  public final void onResume()
  {
    if (this.b != null) {
      this.b.onResume();
    }
    for (;;)
    {
      return;
      Iterator localIterator = this.c.iterator();
      while (localIterator.hasNext())
      {
        WeakReference localWeakReference = (WeakReference)localIterator.next();
        if (localWeakReference.get() != null) {
          ((JsVirtualMachine.a)localWeakReference.get()).b();
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.smtt.sdk.JsVirtualMachine
 * JD-Core Version:    0.7.0.1
 */