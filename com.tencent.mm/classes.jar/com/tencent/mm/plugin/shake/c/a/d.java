package com.tencent.mm.plugin.shake.c.a;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import java.util.Map;

public final class d
{
  public float fHj;
  public float fHk;
  Map<String, Object> oDp;
  long zcA;
  String zcB;
  int zcz;
  
  public d()
  {
    AppMethodBeat.i(28188);
    this.oDp = new HashMap();
    this.zcz = 0;
    this.zcA = 0L;
    this.fHj = -85.0F;
    this.fHk = -1000.0F;
    this.zcB = "";
    this.oDp.clear();
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
    this.oDp.put(paramString, paramObject);
    AppMethodBeat.o(28189);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.shake.c.a.d
 * JD-Core Version:    0.7.0.1
 */