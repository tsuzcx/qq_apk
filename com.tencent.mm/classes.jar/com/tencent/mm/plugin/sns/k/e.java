package com.tencent.mm.plugin.sns.k;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.tu;
import com.tencent.mm.g.a.tu.a;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.c;
import java.util.HashMap;

public final class e
{
  private static e wQS = null;
  private c<tu> fjL;
  public HashMap<Integer, a> wQT;
  
  private e()
  {
    AppMethodBeat.i(96205);
    this.wQT = null;
    this.fjL = new c() {};
    this.wQT = new HashMap();
    a.ESL.b(this.fjL);
    AppMethodBeat.o(96205);
  }
  
  public static e duR()
  {
    AppMethodBeat.i(96206);
    if (wQS == null) {
      wQS = new e();
    }
    e locale = wQS;
    AppMethodBeat.o(96206);
    return locale;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.k.e
 * JD-Core Version:    0.7.0.1
 */