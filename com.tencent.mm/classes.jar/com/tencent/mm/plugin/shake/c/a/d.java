package com.tencent.mm.plugin.shake.c.a;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import java.util.Map;

public final class d
{
  int Dhr;
  long Dhs;
  String Dht;
  public float gmu;
  public float gmv;
  Map<String, Object> pQY;
  
  public d()
  {
    AppMethodBeat.i(28188);
    this.pQY = new HashMap();
    this.Dhr = 0;
    this.Dhs = 0L;
    this.gmu = -85.0F;
    this.gmv = -1000.0F;
    this.Dht = "";
    this.pQY.clear();
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
    this.pQY.put(paramString, paramObject);
    AppMethodBeat.o(28189);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.shake.c.a.d
 * JD-Core Version:    0.7.0.1
 */