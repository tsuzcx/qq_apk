package io.flutter.embedding.android;

public abstract interface ExclusiveAppComponent<T>
{
  public abstract void detachFromFlutterEngine();
  
  public abstract T getAppComponent();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     io.flutter.embedding.android.ExclusiveAppComponent
 * JD-Core Version:    0.7.0.1
 */