package com.tencent.mm.plugin.sns.data;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.fdv;
import java.util.concurrent.ConcurrentHashMap;

public final class n
{
  public ConcurrentHashMap<String, CharSequence> QnT;
  public ConcurrentHashMap<String, String> QnU;
  public ConcurrentHashMap<String, CharSequence> QnV;
  
  public n()
  {
    AppMethodBeat.i(95082);
    this.QnT = new ConcurrentHashMap();
    this.QnU = new ConcurrentHashMap();
    this.QnV = new ConcurrentHashMap();
    AppMethodBeat.o(95082);
  }
  
  public final void a(fdv paramfdv, CharSequence paramCharSequence)
  {
    AppMethodBeat.i(95083);
    this.QnT.put(paramfdv.abDh + "-" + paramfdv.abDj + "-" + paramfdv.nUB, paramCharSequence);
    AppMethodBeat.o(95083);
  }
  
  public final void a(fdv paramfdv, String paramString)
  {
    AppMethodBeat.i(95084);
    this.QnU.put(paramfdv.abDh + "-" + paramfdv.abDj + "-" + paramfdv.nUB, paramString);
    AppMethodBeat.o(95084);
  }
  
  public final void b(fdv paramfdv, CharSequence paramCharSequence)
  {
    AppMethodBeat.i(306402);
    this.QnV.put(paramfdv.abDh + "-" + paramfdv.abDj + "-" + paramfdv.nUB, paramCharSequence);
    AppMethodBeat.o(306402);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.data.n
 * JD-Core Version:    0.7.0.1
 */