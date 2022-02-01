package com.tencent.thumbplayer.core.drm;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.thumbplayer.core.drm.httpclient.BasicNetwork;
import com.tencent.thumbplayer.core.drm.httpclient.DefaultHttpDataSourceFactory;
import com.tencent.thumbplayer.core.drm.httpclient.HttpDataSource.Factory;
import com.tencent.thumbplayer.core.drm.httpclient.Request;
import com.tencent.thumbplayer.core.drm.httpclient.Response;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.HashMap;

public class TPHttpUtils
{
  private static final HttpDataSource.Factory mHttpSrcFactory;
  
  static
  {
    AppMethodBeat.i(220566);
    mHttpSrcFactory = new DefaultHttpDataSourceFactory("qqlive");
    AppMethodBeat.o(220566);
  }
  
  private static byte[] onHttp(byte[] paramArrayOfByte1, Object paramObject, byte[] paramArrayOfByte2, int paramInt)
  {
    AppMethodBeat.i(220565);
    if (paramArrayOfByte1 == null)
    {
      AppMethodBeat.o(220565);
      return null;
    }
    paramObject = new HashMap();
    String str = new String(paramArrayOfByte1, Charset.forName("UTF-8"));
    paramArrayOfByte1 = new byte[0];
    if (paramArrayOfByte2 != null) {
      paramArrayOfByte1 = paramArrayOfByte2;
    }
    paramArrayOfByte1 = new Request(2, str, paramObject, paramArrayOfByte1, paramInt, null);
    try
    {
      paramArrayOfByte1 = new BasicNetwork(mHttpSrcFactory).performRequest(paramArrayOfByte1).result;
      AppMethodBeat.o(220565);
      return paramArrayOfByte1;
    }
    catch (IOException paramArrayOfByte1)
    {
      AppMethodBeat.o(220565);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.thumbplayer.core.drm.TPHttpUtils
 * JD-Core Version:    0.7.0.1
 */