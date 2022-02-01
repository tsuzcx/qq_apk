package com.tencent.thumbplayer.a;

import android.os.ParcelFileDescriptor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.thumbplayer.a.a.e;
import com.tencent.thumbplayer.api.composition.ITPMediaAsset;
import java.util.HashMap;
import java.util.Map;

public final class f
{
  public ParcelFileDescriptor ZyX;
  public Map<String, String> ZyY;
  ITPMediaAsset ZyZ;
  e Zza;
  public int mType;
  public String mUrl;
  
  protected f()
  {
    AppMethodBeat.i(218865);
    this.ZyY = new HashMap();
    AppMethodBeat.o(218865);
  }
  
  protected final void ct(Map<String, String> paramMap)
  {
    AppMethodBeat.i(218868);
    this.ZyY.clear();
    Map localMap = this.ZyY;
    Object localObject = paramMap;
    if (paramMap == null) {
      localObject = new HashMap(0);
    }
    localMap.putAll((Map)localObject);
    AppMethodBeat.o(218868);
  }
  
  protected final void setUrl(String paramString)
  {
    this.mUrl = paramString;
    this.mType = 0;
    this.ZyX = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.thumbplayer.a.f
 * JD-Core Version:    0.7.0.1
 */