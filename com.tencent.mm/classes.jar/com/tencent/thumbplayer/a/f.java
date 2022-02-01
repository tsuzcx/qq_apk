package com.tencent.thumbplayer.a;

import android.os.ParcelFileDescriptor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.thumbplayer.b.a.a;
import java.util.HashMap;
import java.util.Map;

public final class f
{
  public ParcelFileDescriptor MtQ;
  a MtR;
  public Map<String, String> mHttpHeaders;
  public int mType;
  public String mUrl;
  
  protected f()
  {
    AppMethodBeat.i(194310);
    this.mHttpHeaders = new HashMap();
    AppMethodBeat.o(194310);
  }
  
  protected final void setUrl(String paramString)
  {
    this.mUrl = paramString;
    this.mType = 0;
    this.MtQ = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.thumbplayer.a.f
 * JD-Core Version:    0.7.0.1
 */