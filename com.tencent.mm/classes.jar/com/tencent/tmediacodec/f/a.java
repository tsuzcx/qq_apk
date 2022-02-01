package com.tencent.tmediacodec.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import java.util.Map;

public final class a
{
  public long ZPA;
  public boolean ZPB;
  public boolean ZPC;
  public boolean ZPD;
  public String ZPE;
  public boolean ZPF;
  public final Map<String, Long> ZPz;
  
  public a(boolean paramBoolean)
  {
    AppMethodBeat.i(224580);
    this.ZPz = new HashMap();
    this.ZPE = "";
    this.ZPF = paramBoolean;
    AppMethodBeat.o(224580);
  }
  
  private final void ID(boolean paramBoolean)
  {
    this.ZPB = paramBoolean;
    this.ZPD = true;
  }
  
  public final void IE(boolean paramBoolean)
  {
    AppMethodBeat.i(224583);
    this.ZPC = paramBoolean;
    this.ZPA = System.currentTimeMillis();
    AppMethodBeat.o(224583);
  }
  
  public final void IF(boolean paramBoolean)
  {
    AppMethodBeat.i(224586);
    ID(paramBoolean);
    this.ZPz.put("configCodec", Long.valueOf(System.currentTimeMillis() - this.ZPA));
    AppMethodBeat.o(224586);
  }
  
  public final void itl()
  {
    AppMethodBeat.i(224581);
    this.ZPE = "";
    this.ZPz.clear();
    this.ZPA = System.currentTimeMillis();
    AppMethodBeat.o(224581);
  }
  
  public final void itm()
  {
    AppMethodBeat.i(224582);
    this.ZPz.put("createCodec", Long.valueOf(System.currentTimeMillis() - this.ZPA));
    AppMethodBeat.o(224582);
  }
  
  public final void itn()
  {
    AppMethodBeat.i(224589);
    this.ZPz.put("startCodec", Long.valueOf(System.currentTimeMillis() - this.ZPA));
    AppMethodBeat.o(224589);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.tmediacodec.f.a
 * JD-Core Version:    0.7.0.1
 */