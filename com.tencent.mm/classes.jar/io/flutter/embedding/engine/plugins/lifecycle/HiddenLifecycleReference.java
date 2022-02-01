package io.flutter.embedding.engine.plugins.lifecycle;

import androidx.annotation.Keep;
import androidx.lifecycle.h;

@Keep
public class HiddenLifecycleReference
{
  private final h lifecycle;
  
  public HiddenLifecycleReference(h paramh)
  {
    this.lifecycle = paramh;
  }
  
  public h getLifecycle()
  {
    return this.lifecycle;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     io.flutter.embedding.engine.plugins.lifecycle.HiddenLifecycleReference
 * JD-Core Version:    0.7.0.1
 */