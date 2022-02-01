package com.tencent.thumbplayer.core.drm.httpclient;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract interface HttpDataSource
  extends DataSource
{
  public abstract void clearAllRequestProperties();
  
  public abstract void clearRequestProperty(String paramString);
  
  public abstract void close();
  
  public abstract Map<String, List<String>> getResponseHeaders();
  
  public abstract long open(DataSpec paramDataSpec);
  
  public abstract int read(byte[] paramArrayOfByte, int paramInt1, int paramInt2);
  
  public abstract void setRequestProperty(String paramString1, String paramString2);
  
  public static abstract class BaseFactory
    implements HttpDataSource.Factory
  {
    private final HttpDataSource.RequestProperties defaultRequestProperties = new HttpDataSource.RequestProperties();
    
    @Deprecated
    public final void clearAllDefaultRequestProperties()
    {
      this.defaultRequestProperties.clear();
    }
    
    @Deprecated
    public final void clearDefaultRequestProperty(String paramString)
    {
      this.defaultRequestProperties.remove(paramString);
    }
    
    public final HttpDataSource createDataSource()
    {
      return createDataSourceInternal(this.defaultRequestProperties);
    }
    
    public final HttpDataSource createDataSource(int paramInt)
    {
      return createDataSourceInternal(paramInt, this.defaultRequestProperties);
    }
    
    protected abstract HttpDataSource createDataSourceInternal(int paramInt, HttpDataSource.RequestProperties paramRequestProperties);
    
    protected abstract HttpDataSource createDataSourceInternal(HttpDataSource.RequestProperties paramRequestProperties);
    
    public final HttpDataSource.RequestProperties getDefaultRequestProperties()
    {
      return this.defaultRequestProperties;
    }
    
    @Deprecated
    public final void setDefaultRequestProperty(String paramString1, String paramString2)
    {
      this.defaultRequestProperties.set(paramString1, paramString2);
    }
  }
  
  public static abstract interface Factory
    extends DataSource.Factory
  {
    @Deprecated
    public abstract void clearAllDefaultRequestProperties();
    
    @Deprecated
    public abstract void clearDefaultRequestProperty(String paramString);
    
    public abstract HttpDataSource createDataSource();
    
    public abstract HttpDataSource createDataSource(int paramInt);
    
    public abstract HttpDataSource.RequestProperties getDefaultRequestProperties();
    
    @Deprecated
    public abstract void setDefaultRequestProperty(String paramString1, String paramString2);
  }
  
  public static class HttpDataSourceException
    extends IOException
  {
    public static final int TYPE_CLOSE = 3;
    public static final int TYPE_OPEN = 1;
    public static final int TYPE_READ = 2;
    public final DataSpec dataSpec;
    public final int type;
    
    public HttpDataSourceException(DataSpec paramDataSpec, int paramInt)
    {
      this.dataSpec = paramDataSpec;
      this.type = paramInt;
    }
    
    public HttpDataSourceException(IOException paramIOException, DataSpec paramDataSpec, int paramInt)
    {
      super();
      this.dataSpec = paramDataSpec;
      this.type = paramInt;
    }
    
    public HttpDataSourceException(String paramString, DataSpec paramDataSpec, int paramInt)
    {
      super();
      this.dataSpec = paramDataSpec;
      this.type = paramInt;
    }
    
    public HttpDataSourceException(String paramString, IOException paramIOException, DataSpec paramDataSpec, int paramInt)
    {
      super(paramIOException);
      this.dataSpec = paramDataSpec;
      this.type = paramInt;
    }
  }
  
  public static final class InvalidContentTypeException
    extends HttpDataSource.HttpDataSourceException
  {
    public final String contentType;
    
    public InvalidContentTypeException(String paramString, DataSpec paramDataSpec)
    {
      super(paramDataSpec, 1);
      AppMethodBeat.i(197573);
      this.contentType = paramString;
      AppMethodBeat.o(197573);
    }
  }
  
  public static final class InvalidResponseCodeException
    extends HttpDataSource.HttpDataSourceException
  {
    public final Map<String, List<String>> headerFields;
    public final int responseCode;
    public final String responseMessage;
    
    public InvalidResponseCodeException(int paramInt, String paramString, Map<String, List<String>> paramMap, DataSpec paramDataSpec)
    {
      super(paramDataSpec, 1);
      AppMethodBeat.i(197574);
      this.responseCode = paramInt;
      this.responseMessage = paramString;
      this.headerFields = paramMap;
      AppMethodBeat.o(197574);
    }
  }
  
  public static final class RequestProperties
  {
    private final Map<String, String> requestProperties;
    private Map<String, String> requestPropertiesSnapshot;
    
    public RequestProperties()
    {
      AppMethodBeat.i(197575);
      this.requestProperties = new HashMap();
      AppMethodBeat.o(197575);
    }
    
    public final void clear()
    {
      try
      {
        AppMethodBeat.i(197580);
        this.requestPropertiesSnapshot = null;
        this.requestProperties.clear();
        AppMethodBeat.o(197580);
        return;
      }
      finally
      {
        localObject = finally;
        throw localObject;
      }
    }
    
    public final void clearAndSet(Map<String, String> paramMap)
    {
      try
      {
        AppMethodBeat.i(197578);
        this.requestPropertiesSnapshot = null;
        this.requestProperties.clear();
        this.requestProperties.putAll(paramMap);
        AppMethodBeat.o(197578);
        return;
      }
      finally
      {
        paramMap = finally;
        throw paramMap;
      }
    }
    
    public final Map<String, String> getSnapshot()
    {
      try
      {
        AppMethodBeat.i(197581);
        if (this.requestPropertiesSnapshot == null) {
          this.requestPropertiesSnapshot = Collections.unmodifiableMap(new HashMap(this.requestProperties));
        }
        Map localMap = this.requestPropertiesSnapshot;
        AppMethodBeat.o(197581);
        return localMap;
      }
      finally {}
    }
    
    public final void remove(String paramString)
    {
      try
      {
        AppMethodBeat.i(197579);
        this.requestPropertiesSnapshot = null;
        this.requestProperties.remove(paramString);
        AppMethodBeat.o(197579);
        return;
      }
      finally
      {
        paramString = finally;
        throw paramString;
      }
    }
    
    public final void set(String paramString1, String paramString2)
    {
      try
      {
        AppMethodBeat.i(197576);
        this.requestPropertiesSnapshot = null;
        this.requestProperties.put(paramString1, paramString2);
        AppMethodBeat.o(197576);
        return;
      }
      finally
      {
        paramString1 = finally;
        throw paramString1;
      }
    }
    
    public final void set(Map<String, String> paramMap)
    {
      try
      {
        AppMethodBeat.i(197577);
        this.requestPropertiesSnapshot = null;
        this.requestProperties.putAll(paramMap);
        AppMethodBeat.o(197577);
        return;
      }
      finally
      {
        paramMap = finally;
        throw paramMap;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.thumbplayer.core.drm.httpclient.HttpDataSource
 * JD-Core Version:    0.7.0.1
 */