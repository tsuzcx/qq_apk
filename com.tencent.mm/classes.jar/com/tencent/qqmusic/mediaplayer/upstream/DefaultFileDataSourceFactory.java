package com.tencent.qqmusic.mediaplayer.upstream;

import android.text.TextUtils;

public class DefaultFileDataSourceFactory
  implements IDataSourceFactory
{
  private final String filePath;
  
  public DefaultFileDataSourceFactory(String paramString)
  {
    this.filePath = paramString;
  }
  
  public IDataSource createDataSource()
  {
    if (TextUtils.isEmpty(this.filePath)) {
      throw new DataSourceException(-5, "filePath is empty!", null);
    }
    return new FileDataSource(this.filePath);
  }
  
  public INativeDataSource createNativeDataSource()
  {
    return NativeDataSourceFactory.fileDataSource(this.filePath);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.qqmusic.mediaplayer.upstream.DefaultFileDataSourceFactory
 * JD-Core Version:    0.7.0.1
 */