package com.tencent.tmediacodec.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import java.util.Map;

public final class a
{
  public final Map<String, Long> ahUA;
  public long ahUB;
  public boolean ahUC;
  public boolean ahUD;
  public boolean ahUE;
  public String ahUF;
  public boolean ahUG;
  
  public a(boolean paramBoolean)
  {
    AppMethodBeat.i(210763);
    this.ahUA = new HashMap();
    this.ahUF = "";
    this.ahUG = paramBoolean;
    AppMethodBeat.o(210763);
  }
  
  private final void setIsReuse(boolean paramBoolean)
  {
    this.ahUC = paramBoolean;
    this.ahUE = true;
  }
  
  public final void OG(boolean paramBoolean)
  {
    AppMethodBeat.i(210786);
    this.ahUD = paramBoolean;
    this.ahUB = System.currentTimeMillis();
    AppMethodBeat.o(210786);
  }
  
  public final void OH(boolean paramBoolean)
  {
    AppMethodBeat.i(210794);
    setIsReuse(paramBoolean);
    this.ahUA.put("configCodec", Long.valueOf(System.currentTimeMillis() - this.ahUB));
    AppMethodBeat.o(210794);
  }
  
  public final void kcF()
  {
    AppMethodBeat.i(210775);
    this.ahUF = "";
    this.ahUA.clear();
    this.ahUB = System.currentTimeMillis();
    AppMethodBeat.o(210775);
  }
  
  public final void kcG()
  {
    AppMethodBeat.i(210782);
    this.ahUA.put("createCodec", Long.valueOf(System.currentTimeMillis() - this.ahUB));
    AppMethodBeat.o(210782);
  }
  
  public final void kcH()
  {
    AppMethodBeat.i(210799);
    this.ahUA.put("startCodec", Long.valueOf(System.currentTimeMillis() - this.ahUB));
    AppMethodBeat.o(210799);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.tmediacodec.f.a
 * JD-Core Version:    0.7.0.1
 */