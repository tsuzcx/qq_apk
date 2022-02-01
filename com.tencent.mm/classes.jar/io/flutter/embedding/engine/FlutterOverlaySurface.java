package io.flutter.embedding.engine;

import android.view.Surface;

public class FlutterOverlaySurface
{
  private final int id;
  private final Surface surface;
  
  public FlutterOverlaySurface(int paramInt, Surface paramSurface)
  {
    this.id = paramInt;
    this.surface = paramSurface;
  }
  
  public int getId()
  {
    return this.id;
  }
  
  public Surface getSurface()
  {
    return this.surface;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     io.flutter.embedding.engine.FlutterOverlaySurface
 * JD-Core Version:    0.7.0.1
 */