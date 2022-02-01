package com.tencent.mm.plugin.sns.statistics;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.f;
import com.tencent.mm.autogen.a.yx;
import com.tencent.mm.sdk.event.IListener;
import java.util.HashMap;

public final class g
{
  private static g QFJ = null;
  public HashMap<Integer, a> QFK;
  private IListener<yx> lsH;
  
  private g()
  {
    AppMethodBeat.i(96205);
    this.QFK = null;
    this.lsH = new SnsPostReportLogic.1(this, f.hfK);
    this.QFK = new HashMap();
    this.lsH.alive();
    AppMethodBeat.o(96205);
  }
  
  public static g hii()
  {
    AppMethodBeat.i(96206);
    if (QFJ == null) {
      QFJ = new g();
    }
    g localg = QFJ;
    AppMethodBeat.o(96206);
    return localg;
  }
  
  public final class a
  {
    String content = "";
    int mediaType = 0;
    
    public a(int paramInt, String paramString)
    {
      this.content = paramString;
      this.mediaType = paramInt;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.statistics.g
 * JD-Core Version:    0.7.0.1
 */