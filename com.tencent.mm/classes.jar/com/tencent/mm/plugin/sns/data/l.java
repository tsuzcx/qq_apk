package com.tencent.mm.plugin.sns.data;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.dzo;
import java.util.concurrent.ConcurrentHashMap;

public final class l
{
  public ConcurrentHashMap<String, CharSequence> DEn;
  public ConcurrentHashMap<String, String> DEo;
  public ConcurrentHashMap<String, CharSequence> DEp;
  
  public l()
  {
    AppMethodBeat.i(95082);
    this.DEn = new ConcurrentHashMap();
    this.DEo = new ConcurrentHashMap();
    this.DEp = new ConcurrentHashMap();
    AppMethodBeat.o(95082);
  }
  
  public final void a(dzo paramdzo, CharSequence paramCharSequence)
  {
    AppMethodBeat.i(95083);
    this.DEn.put(paramdzo.MYT + "-" + paramdzo.MYV + "-" + paramdzo.iAc, paramCharSequence);
    AppMethodBeat.o(95083);
  }
  
  public final void a(dzo paramdzo, String paramString)
  {
    AppMethodBeat.i(95084);
    this.DEo.put(paramdzo.MYT + "-" + paramdzo.MYV + "-" + paramdzo.iAc, paramString);
    AppMethodBeat.o(95084);
  }
  
  public final void b(dzo paramdzo, CharSequence paramCharSequence)
  {
    AppMethodBeat.i(202617);
    this.DEp.put(paramdzo.MYT + "-" + paramdzo.MYV + "-" + paramdzo.iAc, paramCharSequence);
    AppMethodBeat.o(202617);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.data.l
 * JD-Core Version:    0.7.0.1
 */