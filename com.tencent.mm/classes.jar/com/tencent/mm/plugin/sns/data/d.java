package com.tencent.mm.plugin.sns.data;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.cds;
import java.util.concurrent.ConcurrentHashMap;

public final class d
{
  public ConcurrentHashMap<String, CharSequence> rbi;
  
  public d()
  {
    AppMethodBeat.i(35794);
    this.rbi = new ConcurrentHashMap();
    AppMethodBeat.o(35794);
  }
  
  public final void a(cds paramcds, CharSequence paramCharSequence)
  {
    AppMethodBeat.i(35795);
    this.rbi.put(paramcds.xNY + "-" + paramcds.xOa + "-" + paramcds.ntu, paramCharSequence);
    AppMethodBeat.o(35795);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.data.d
 * JD-Core Version:    0.7.0.1
 */