package io.flutter.embedding.engine.plugins.lifecycle;

import android.arch.lifecycle.Lifecycle;
import android.support.annotation.Keep;

@Keep
public class HiddenLifecycleReference
{
  private final Lifecycle lifecycle;
  
  public HiddenLifecycleReference(Lifecycle paramLifecycle)
  {
    this.lifecycle = paramLifecycle;
  }
  
  public Lifecycle getLifecycle()
  {
    return this.lifecycle;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     io.flutter.embedding.engine.plugins.lifecycle.HiddenLifecycleReference
 * JD-Core Version:    0.7.0.1
 */