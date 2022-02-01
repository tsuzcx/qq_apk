package com.tencent.mm.plugin.shake.c.a;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import java.util.Map;

public final class d
{
  public float fmX;
  public float fmY;
  Map<String, Object> nTs;
  int xxE;
  long xxF;
  String xxG;
  
  public d()
  {
    AppMethodBeat.i(28188);
    this.nTs = new HashMap();
    this.xxE = 0;
    this.xxF = 0L;
    this.fmX = -85.0F;
    this.fmY = -1000.0F;
    this.xxG = "";
    this.nTs.clear();
    AppMethodBeat.o(28188);
  }
  
  public final void putValue(String paramString, Object paramObject)
  {
    AppMethodBeat.i(28189);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(28189);
      return;
    }
    this.nTs.put(paramString, paramObject);
    AppMethodBeat.o(28189);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.shake.c.a.d
 * JD-Core Version:    0.7.0.1
 */