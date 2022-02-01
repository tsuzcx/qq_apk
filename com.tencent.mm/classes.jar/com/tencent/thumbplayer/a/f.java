package com.tencent.thumbplayer.a;

import android.os.ParcelFileDescriptor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.thumbplayer.a.a.e;
import com.tencent.thumbplayer.api.composition.ITPMediaAsset;
import java.util.HashMap;
import java.util.Map;

public final class f
{
  public ParcelFileDescriptor RWn;
  public Map<String, String> RWo;
  ITPMediaAsset RWp;
  e RWq;
  public int mType;
  public String mUrl;
  
  protected f()
  {
    AppMethodBeat.i(188722);
    this.RWo = new HashMap();
    AppMethodBeat.o(188722);
  }
  
  protected final void cn(Map<String, String> paramMap)
  {
    AppMethodBeat.i(188723);
    this.RWo.clear();
    Map localMap = this.RWo;
    Object localObject = paramMap;
    if (paramMap == null) {
      localObject = new HashMap(0);
    }
    localMap.putAll((Map)localObject);
    AppMethodBeat.o(188723);
  }
  
  protected final void setUrl(String paramString)
  {
    this.mUrl = paramString;
    this.mType = 0;
    this.RWn = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.thumbplayer.a.f
 * JD-Core Version:    0.7.0.1
 */