package com.tencent.thumbplayer.a;

import android.content.res.AssetFileDescriptor;
import android.os.ParcelFileDescriptor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.thumbplayer.a.a.e;
import com.tencent.thumbplayer.api.composition.ITPMediaAsset;
import java.util.HashMap;
import java.util.Map;

public final class f
{
  public AssetFileDescriptor JgJ;
  public ParcelFileDescriptor ahEa;
  ITPMediaAsset ahEb;
  e ahEc;
  public Map<String, String> mHttpHeaders;
  public int mType;
  public String mUrl;
  
  protected f()
  {
    AppMethodBeat.i(228454);
    this.mHttpHeaders = new HashMap();
    AppMethodBeat.o(228454);
  }
  
  protected final void dm(Map<String, String> paramMap)
  {
    AppMethodBeat.i(228463);
    this.mHttpHeaders.clear();
    Map localMap = this.mHttpHeaders;
    Object localObject = paramMap;
    if (paramMap == null) {
      localObject = new HashMap(0);
    }
    localMap.putAll((Map)localObject);
    AppMethodBeat.o(228463);
  }
  
  protected final void setUrl(String paramString)
  {
    this.mUrl = paramString;
    this.mType = 0;
    this.ahEa = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.thumbplayer.a.f
 * JD-Core Version:    0.7.0.1
 */