package com.tencent.qqmusic.mediaplayer.upstream;

import android.net.Uri;
import java.io.File;
import java.io.IOException;

public class CacheDataSource$Factory
{
  private static Loader.Factory createDefaultLoaderFactory(File paramFile, UriLoader paramUriLoader)
  {
    return new CacheDataSource.Factory.2(paramUriLoader, paramFile);
  }
  
  public static CacheDataSource createFromLoader(File paramFile, Loader.Factory paramFactory)
  {
    return new CacheDataSource(new FileDataSource(paramFile.getAbsolutePath()), paramFactory);
  }
  
  public static CacheDataSource createFromUri(File paramFile, Uri paramUri)
  {
    return createFromUriLoader(paramFile, new DummyUriLoader(paramUri));
  }
  
  public static CacheDataSource createFromUriLoader(UriLoader paramUriLoader)
  {
    try
    {
      File localFile = File.createTempFile("mediaHttpCommonPlayer", "tmp");
      ensureFile(localFile);
      paramUriLoader = createDefaultLoaderFactory(localFile, paramUriLoader);
      return new CacheDataSource(new CacheDataSource.Factory.1(localFile.getAbsolutePath(), localFile), paramUriLoader);
    }
    catch (IOException paramUriLoader)
    {
      throw new DataSourceException(-8, "failed to ensure buffer file!", paramUriLoader);
    }
  }
  
  public static CacheDataSource createFromUriLoader(File paramFile, UriLoader paramUriLoader)
  {
    paramUriLoader = createDefaultLoaderFactory(paramFile, paramUriLoader);
    return new CacheDataSource(new FileDataSource(paramFile.getAbsolutePath()), paramUriLoader);
  }
  
  private static void ensureFile(File paramFile)
  {
    paramFile.delete();
    if (!paramFile.createNewFile()) {
      throw new IOException("failed to create file!");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.qqmusic.mediaplayer.upstream.CacheDataSource.Factory
 * JD-Core Version:    0.7.0.1
 */