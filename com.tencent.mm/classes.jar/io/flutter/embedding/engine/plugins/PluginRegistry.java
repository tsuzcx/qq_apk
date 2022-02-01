package io.flutter.embedding.engine.plugins;

import java.util.Set;

public abstract interface PluginRegistry
{
  public abstract void add(FlutterPlugin paramFlutterPlugin);
  
  public abstract void add(Set<FlutterPlugin> paramSet);
  
  public abstract FlutterPlugin get(Class<? extends FlutterPlugin> paramClass);
  
  public abstract boolean has(Class<? extends FlutterPlugin> paramClass);
  
  public abstract void remove(Class<? extends FlutterPlugin> paramClass);
  
  public abstract void remove(Set<Class<? extends FlutterPlugin>> paramSet);
  
  public abstract void removeAll();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     io.flutter.embedding.engine.plugins.PluginRegistry
 * JD-Core Version:    0.7.0.1
 */