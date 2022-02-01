package com.tencent.mm.plugin.textstatus.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.textstatus.proto.b;
import com.tencent.mm.plugin.textstatus.proto.k;

public final class z
  extends b
{
  private static String TAG = "MicroMsg.TextStatus.TextStatusActionParam";
  
  public static final class a
  {
    public z ThX;
    
    public a()
    {
      AppMethodBeat.i(289771);
      this.ThX = new z((byte)0);
      AppMethodBeat.o(289771);
    }
    
    public final a a(k paramk)
    {
      this.ThX.Tow = paramk;
      return this;
    }
    
    public final a bdA(String paramString)
    {
      this.ThX.Tou = paramString;
      return this;
    }
    
    public final a bdz(String paramString)
    {
      this.ThX.Tov = paramString;
      return this;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.textstatus.a.z
 * JD-Core Version:    0.7.0.1
 */