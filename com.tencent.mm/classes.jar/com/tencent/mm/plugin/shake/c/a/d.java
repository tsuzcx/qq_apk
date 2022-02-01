package com.tencent.mm.plugin.shake.c.a;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import java.util.Map;

public final class d
{
  public float fFf;
  public float fFg;
  Map<String, Object> owN;
  int yMp;
  long yMq;
  String yMr;
  
  public d()
  {
    AppMethodBeat.i(28188);
    this.owN = new HashMap();
    this.yMp = 0;
    this.yMq = 0L;
    this.fFf = -85.0F;
    this.fFg = -1000.0F;
    this.yMr = "";
    this.owN.clear();
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
    this.owN.put(paramString, paramObject);
    AppMethodBeat.o(28189);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.shake.c.a.d
 * JD-Core Version:    0.7.0.1
 */