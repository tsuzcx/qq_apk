package com.tencent.mm.plugin.sns.data;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.daa;
import java.util.concurrent.ConcurrentHashMap;

public final class k
{
  public ConcurrentHashMap<String, CharSequence> xNt;
  public ConcurrentHashMap<String, String> xNu;
  public ConcurrentHashMap<String, CharSequence> xNv;
  
  public k()
  {
    AppMethodBeat.i(95082);
    this.xNt = new ConcurrentHashMap();
    this.xNu = new ConcurrentHashMap();
    this.xNv = new ConcurrentHashMap();
    AppMethodBeat.o(95082);
  }
  
  public final void a(daa paramdaa, CharSequence paramCharSequence)
  {
    AppMethodBeat.i(95083);
    this.xNt.put(paramdaa.FIZ + "-" + paramdaa.FJb + "-" + paramdaa.hkR, paramCharSequence);
    AppMethodBeat.o(95083);
  }
  
  public final void a(daa paramdaa, String paramString)
  {
    AppMethodBeat.i(95084);
    this.xNu.put(paramdaa.FIZ + "-" + paramdaa.FJb + "-" + paramdaa.hkR, paramString);
    AppMethodBeat.o(95084);
  }
  
  public final void b(daa paramdaa, CharSequence paramCharSequence)
  {
    AppMethodBeat.i(200056);
    this.xNv.put(paramdaa.FIZ + "-" + paramdaa.FJb + "-" + paramdaa.hkR, paramCharSequence);
    AppMethodBeat.o(200056);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.data.k
 * JD-Core Version:    0.7.0.1
 */