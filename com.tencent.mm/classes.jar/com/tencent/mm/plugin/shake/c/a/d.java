package com.tencent.mm.plugin.shake.c.a;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import java.util.Map;

public final class d
{
  public float dZu;
  public float dZv;
  Map<String, Object> kln;
  String qNA;
  int qNy;
  long qNz;
  
  public d()
  {
    AppMethodBeat.i(24517);
    this.kln = new HashMap();
    this.qNy = 0;
    this.qNz = 0L;
    this.dZu = -85.0F;
    this.dZv = -1000.0F;
    this.qNA = "";
    this.kln.clear();
    AppMethodBeat.o(24517);
  }
  
  public final void putValue(String paramString, Object paramObject)
  {
    AppMethodBeat.i(24518);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(24518);
      return;
    }
    this.kln.put(paramString, paramObject);
    AppMethodBeat.o(24518);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.shake.c.a.d
 * JD-Core Version:    0.7.0.1
 */