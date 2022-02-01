package com.tencent.mm.plugin.shake.shakecard.a;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import java.util.Map;

public final class c
{
  int PzN;
  long PzO;
  String PzP;
  public float lsA;
  public float lsz;
  Map<String, Object> wrx;
  
  public c()
  {
    AppMethodBeat.i(28188);
    this.wrx = new HashMap();
    this.PzN = 0;
    this.PzO = 0L;
    this.lsz = -85.0F;
    this.lsA = -1000.0F;
    this.PzP = "";
    this.wrx.clear();
    AppMethodBeat.o(28188);
  }
  
  public final void z(String paramString, Object paramObject)
  {
    AppMethodBeat.i(28189);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(28189);
      return;
    }
    this.wrx.put(paramString, paramObject);
    AppMethodBeat.o(28189);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.shake.shakecard.a.c
 * JD-Core Version:    0.7.0.1
 */