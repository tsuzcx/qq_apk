package com.tencent.mm.plugin.sns.data;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.dfn;
import java.util.concurrent.ConcurrentHashMap;

public final class k
{
  public ConcurrentHashMap<String, CharSequence> zdn;
  public ConcurrentHashMap<String, String> zdo;
  public ConcurrentHashMap<String, CharSequence> zdp;
  
  public k()
  {
    AppMethodBeat.i(95082);
    this.zdn = new ConcurrentHashMap();
    this.zdo = new ConcurrentHashMap();
    this.zdp = new ConcurrentHashMap();
    AppMethodBeat.o(95082);
  }
  
  public final void a(dfn paramdfn, CharSequence paramCharSequence)
  {
    AppMethodBeat.i(95083);
    this.zdn.put(paramdfn.HtH + "-" + paramdfn.HtJ + "-" + paramdfn.hDa, paramCharSequence);
    AppMethodBeat.o(95083);
  }
  
  public final void a(dfn paramdfn, String paramString)
  {
    AppMethodBeat.i(95084);
    this.zdo.put(paramdfn.HtH + "-" + paramdfn.HtJ + "-" + paramdfn.hDa, paramString);
    AppMethodBeat.o(95084);
  }
  
  public final void b(dfn paramdfn, CharSequence paramCharSequence)
  {
    AppMethodBeat.i(197781);
    this.zdp.put(paramdfn.HtH + "-" + paramdfn.HtJ + "-" + paramdfn.hDa, paramCharSequence);
    AppMethodBeat.o(197781);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.data.k
 * JD-Core Version:    0.7.0.1
 */