package com.tencent.tmediacodec.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import java.util.Map;

public final class a
{
  public final Map<String, Long> SmO;
  public long SmP;
  public boolean SmQ;
  public boolean SmR;
  public boolean SmS;
  public String SmT;
  public boolean SmU;
  
  public a(boolean paramBoolean)
  {
    AppMethodBeat.i(190177);
    this.SmO = new HashMap();
    this.SmT = "";
    this.SmU = paramBoolean;
    AppMethodBeat.o(190177);
  }
  
  private final void Ec(boolean paramBoolean)
  {
    this.SmQ = paramBoolean;
    this.SmS = true;
  }
  
  public final void Ed(boolean paramBoolean)
  {
    AppMethodBeat.i(190180);
    this.SmR = paramBoolean;
    this.SmP = System.currentTimeMillis();
    AppMethodBeat.o(190180);
  }
  
  public final void Ee(boolean paramBoolean)
  {
    AppMethodBeat.i(190181);
    Ec(paramBoolean);
    this.SmO.put("configCodec", Long.valueOf(System.currentTimeMillis() - this.SmP));
    AppMethodBeat.o(190181);
  }
  
  public final void hpE()
  {
    AppMethodBeat.i(190178);
    this.SmT = "";
    this.SmO.clear();
    this.SmP = System.currentTimeMillis();
    AppMethodBeat.o(190178);
  }
  
  public final void hpF()
  {
    AppMethodBeat.i(190179);
    this.SmO.put("createCodec", Long.valueOf(System.currentTimeMillis() - this.SmP));
    AppMethodBeat.o(190179);
  }
  
  public final void hpG()
  {
    AppMethodBeat.i(190182);
    this.SmO.put("startCodec", Long.valueOf(System.currentTimeMillis() - this.SmP));
    AppMethodBeat.o(190182);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.tmediacodec.f.a
 * JD-Core Version:    0.7.0.1
 */