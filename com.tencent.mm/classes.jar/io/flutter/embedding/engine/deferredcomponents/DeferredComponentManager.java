package io.flutter.embedding.engine.deferredcomponents;

import io.flutter.embedding.engine.FlutterJNI;
import io.flutter.embedding.engine.b.b;

public abstract interface DeferredComponentManager
{
  public abstract void a(b paramb);
  
  public abstract void dE(int paramInt, String paramString);
  
  public abstract String dF(int paramInt, String paramString);
  
  public abstract boolean dG(int paramInt, String paramString);
  
  public abstract void destroy();
  
  public abstract void setJNI(FlutterJNI paramFlutterJNI);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     io.flutter.embedding.engine.deferredcomponents.DeferredComponentManager
 * JD-Core Version:    0.7.0.1
 */