package io.flutter.embedding.engine.renderer;

public abstract interface RenderSurface
{
  public abstract void attachToRenderer(FlutterRenderer paramFlutterRenderer);
  
  public abstract void detachFromRenderer();
  
  public abstract FlutterRenderer getAttachedRenderer();
  
  public abstract void pause();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     io.flutter.embedding.engine.renderer.RenderSurface
 * JD-Core Version:    0.7.0.1
 */