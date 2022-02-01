package io.flutter.embedding.engine.plugins.contentprovider;

public abstract interface ContentProviderAware
{
  public abstract void onAttachedToContentProvider(ContentProviderPluginBinding paramContentProviderPluginBinding);
  
  public abstract void onDetachedFromContentProvider();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     io.flutter.embedding.engine.plugins.contentprovider.ContentProviderAware
 * JD-Core Version:    0.7.0.1
 */