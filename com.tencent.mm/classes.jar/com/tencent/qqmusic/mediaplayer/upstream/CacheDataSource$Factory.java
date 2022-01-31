package com.tencent.qqmusic.mediaplayer.upstream;

import android.net.Uri;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;
import java.io.IOException;

public class CacheDataSource$Factory
{
  private static Loader.Factory createDefaultLoaderFactory(File paramFile, UriLoader paramUriLoader)
  {
    AppMethodBeat.i(104545);
    paramFile = new CacheDataSource.Factory.2(paramUriLoader, paramFile);
    AppMethodBeat.o(104545);
    return paramFile;
  }
  
  public static CacheDataSource createFromLoader(File paramFile, Loader.Factory paramFactory)
  {
    AppMethodBeat.i(104540);
    paramFile = new CacheDataSource(new FileDataSource(paramFile.getAbsolutePath()), paramFactory);
    AppMethodBeat.o(104540);
    return paramFile;
  }
  
  public static CacheDataSource createFromUri(File paramFile, Uri paramUri)
  {
    AppMethodBeat.i(104543);
    paramFile = createFromUriLoader(paramFile, new DummyUriLoader(paramUri));
    AppMethodBeat.o(104543);
    return paramFile;
  }
  
  public static CacheDataSource createFromUriLoader(UriLoader paramUriLoader)
  {
    AppMethodBeat.i(104541);
    try
    {
      File localFile = File.createTempFile("mediaHttpCommonPlayer", "tmp");
      ensureFile(localFile);
      paramUriLoader = createDefaultLoaderFactory(localFile, paramUriLoader);
      paramUriLoader = new CacheDataSource(new CacheDataSource.Factory.1(localFile.getAbsolutePath(), localFile), paramUriLoader);
      AppMethodBeat.o(104541);
      return paramUriLoader;
    }
    catch (IOException paramUriLoader)
    {
      paramUriLoader = new DataSourceException(-8, "failed to ensure buffer file!", paramUriLoader);
      AppMethodBeat.o(104541);
      throw paramUriLoader;
    }
  }
  
  public static CacheDataSource createFromUriLoader(File paramFile, UriLoader paramUriLoader)
  {
    AppMethodBeat.i(104542);
    paramUriLoader = createDefaultLoaderFactory(paramFile, paramUriLoader);
    paramFile = new CacheDataSource(new FileDataSource(paramFile.getAbsolutePath()), paramUriLoader);
    AppMethodBeat.o(104542);
    return paramFile;
  }
  
  private static void ensureFile(File paramFile)
  {
    AppMethodBeat.i(104544);
    paramFile.delete();
    if (!paramFile.createNewFile())
    {
      paramFile = new IOException("failed to create file!");
      AppMethodBeat.o(104544);
      throw paramFile;
    }
    AppMethodBeat.o(104544);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.qqmusic.mediaplayer.upstream.CacheDataSource.Factory
 * JD-Core Version:    0.7.0.1
 */