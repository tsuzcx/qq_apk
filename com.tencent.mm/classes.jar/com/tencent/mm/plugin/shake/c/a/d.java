package com.tencent.mm.plugin.shake.c.a;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import java.util.Map;

public final class d
{
  public float fjD;
  public float fjE;
  Map<String, Object> nqs;
  int wmo;
  long wmp;
  String wmq;
  
  public d()
  {
    AppMethodBeat.i(28188);
    this.nqs = new HashMap();
    this.wmo = 0;
    this.wmp = 0L;
    this.fjD = -85.0F;
    this.fjE = -1000.0F;
    this.wmq = "";
    this.nqs.clear();
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
    this.nqs.put(paramString, paramObject);
    AppMethodBeat.o(28189);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.shake.c.a.d
 * JD-Core Version:    0.7.0.1
 */