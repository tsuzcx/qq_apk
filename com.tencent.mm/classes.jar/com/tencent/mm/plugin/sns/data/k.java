package com.tencent.mm.plugin.sns.data;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.cuo;
import java.util.concurrent.ConcurrentHashMap;

public final class k
{
  public ConcurrentHashMap<String, CharSequence> wAZ;
  public ConcurrentHashMap<String, String> wBa;
  
  public k()
  {
    AppMethodBeat.i(95082);
    this.wAZ = new ConcurrentHashMap();
    this.wBa = new ConcurrentHashMap();
    AppMethodBeat.o(95082);
  }
  
  public final void a(cuo paramcuo, CharSequence paramCharSequence)
  {
    AppMethodBeat.i(95083);
    this.wAZ.put(paramcuo.Ema + "-" + paramcuo.Emc + "-" + paramcuo.gKr, paramCharSequence);
    AppMethodBeat.o(95083);
  }
  
  public final void a(cuo paramcuo, String paramString)
  {
    AppMethodBeat.i(95084);
    this.wBa.put(paramcuo.Ema + "-" + paramcuo.Emc + "-" + paramcuo.gKr, paramString);
    AppMethodBeat.o(95084);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.data.k
 * JD-Core Version:    0.7.0.1
 */