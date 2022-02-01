package com.tencent.mm.plugin.shake.c.a;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import java.util.Map;

public final class c
{
  int JmX;
  long JmY;
  String JmZ;
  public float iQD;
  public float iQE;
  Map<String, Object> tmX;
  
  public c()
  {
    AppMethodBeat.i(28188);
    this.tmX = new HashMap();
    this.JmX = 0;
    this.JmY = 0L;
    this.iQD = -85.0F;
    this.iQE = -1000.0F;
    this.JmZ = "";
    this.tmX.clear();
    AppMethodBeat.o(28188);
  }
  
  public final void r(String paramString, Object paramObject)
  {
    AppMethodBeat.i(28189);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(28189);
      return;
    }
    this.tmX.put(paramString, paramObject);
    AppMethodBeat.o(28189);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.shake.c.a.c
 * JD-Core Version:    0.7.0.1
 */