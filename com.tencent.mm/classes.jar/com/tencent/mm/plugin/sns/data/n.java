package com.tencent.mm.plugin.sns.data;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.ejo;
import java.util.concurrent.ConcurrentHashMap;

public final class n
{
  public ConcurrentHashMap<String, CharSequence> JRi;
  public ConcurrentHashMap<String, String> JRj;
  public ConcurrentHashMap<String, CharSequence> JRk;
  
  public n()
  {
    AppMethodBeat.i(95082);
    this.JRi = new ConcurrentHashMap();
    this.JRj = new ConcurrentHashMap();
    this.JRk = new ConcurrentHashMap();
    AppMethodBeat.o(95082);
  }
  
  public final void a(ejo paramejo, CharSequence paramCharSequence)
  {
    AppMethodBeat.i(95083);
    this.JRi.put(paramejo.Uln + "-" + paramejo.Ulp + "-" + paramejo.lpy, paramCharSequence);
    AppMethodBeat.o(95083);
  }
  
  public final void a(ejo paramejo, String paramString)
  {
    AppMethodBeat.i(95084);
    this.JRj.put(paramejo.Uln + "-" + paramejo.Ulp + "-" + paramejo.lpy, paramString);
    AppMethodBeat.o(95084);
  }
  
  public final void b(ejo paramejo, CharSequence paramCharSequence)
  {
    AppMethodBeat.i(198533);
    this.JRk.put(paramejo.Uln + "-" + paramejo.Ulp + "-" + paramejo.lpy, paramCharSequence);
    AppMethodBeat.o(198533);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.data.n
 * JD-Core Version:    0.7.0.1
 */