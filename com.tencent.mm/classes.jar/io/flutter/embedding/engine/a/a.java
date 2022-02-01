package io.flutter.embedding.engine.a;

import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.LifecycleOwner;
import android.content.Context;

public abstract interface a
{
  public static final class a
    implements LifecycleOwner
  {
    private final Lifecycle IZc;
    private final Context applicationContext;
    public final io.flutter.embedding.engine.a rdu;
    
    public a(Context paramContext, io.flutter.embedding.engine.a parama, Lifecycle paramLifecycle)
    {
      this.applicationContext = paramContext;
      this.rdu = parama;
      this.IZc = paramLifecycle;
    }
    
    public final Lifecycle getLifecycle()
    {
      return this.IZc;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     io.flutter.embedding.engine.a.a
 * JD-Core Version:    0.7.0.1
 */