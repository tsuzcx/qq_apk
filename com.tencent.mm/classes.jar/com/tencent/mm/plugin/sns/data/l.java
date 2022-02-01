package com.tencent.mm.plugin.sns.data;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.dgh;
import java.util.concurrent.ConcurrentHashMap;

public final class l
{
  public ConcurrentHashMap<String, CharSequence> zud;
  public ConcurrentHashMap<String, String> zue;
  public ConcurrentHashMap<String, CharSequence> zuf;
  
  public l()
  {
    AppMethodBeat.i(95082);
    this.zud = new ConcurrentHashMap();
    this.zue = new ConcurrentHashMap();
    this.zuf = new ConcurrentHashMap();
    AppMethodBeat.o(95082);
  }
  
  public final void a(dgh paramdgh, CharSequence paramCharSequence)
  {
    AppMethodBeat.i(95083);
    this.zud.put(paramdgh.HNk + "-" + paramdgh.HNm + "-" + paramdgh.hFS, paramCharSequence);
    AppMethodBeat.o(95083);
  }
  
  public final void a(dgh paramdgh, String paramString)
  {
    AppMethodBeat.i(95084);
    this.zue.put(paramdgh.HNk + "-" + paramdgh.HNm + "-" + paramdgh.hFS, paramString);
    AppMethodBeat.o(95084);
  }
  
  public final void b(dgh paramdgh, CharSequence paramCharSequence)
  {
    AppMethodBeat.i(219264);
    this.zuf.put(paramdgh.HNk + "-" + paramdgh.HNm + "-" + paramdgh.hFS, paramCharSequence);
    AppMethodBeat.o(219264);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.data.l
 * JD-Core Version:    0.7.0.1
 */