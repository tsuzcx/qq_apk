package com.tencent.qqmusic.mediaplayer.upstream;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;

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
    AppMethodBeat.i(114296);
    if (TextUtils.isEmpty(this.filePath))
    {
      localObject = new DataSourceException(-5, "filePath is empty!", null);
      AppMethodBeat.o(114296);
      throw ((Throwable)localObject);
    }
    Object localObject = new FileDataSource(this.filePath);
    AppMethodBeat.o(114296);
    return localObject;
  }
  
  public INativeDataSource createNativeDataSource()
  {
    AppMethodBeat.i(114297);
    INativeDataSource localINativeDataSource = NativeDataSourceFactory.fileDataSource(this.filePath, 0);
    AppMethodBeat.o(114297);
    return localINativeDataSource;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.qqmusic.mediaplayer.upstream.DefaultFileDataSourceFactory
 * JD-Core Version:    0.7.0.1
 */