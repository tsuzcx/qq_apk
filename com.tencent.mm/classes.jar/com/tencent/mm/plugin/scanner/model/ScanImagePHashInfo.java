package com.tencent.mm.plugin.scanner.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.p;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/scanner/model/ScanImagePHashInfo;", "", "()V", "pHash", "", "getPHash", "()Ljava/lang/String;", "setPHash", "(Ljava/lang/String;)V", "pHashVersion", "getPHashVersion", "setPHashVersion", "plugin-scan_release"})
public final class ScanImagePHashInfo
{
  private String pHash = "";
  private String pHashVersion = "";
  
  public final String getPHash()
  {
    return this.pHash;
  }
  
  public final String getPHashVersion()
  {
    return this.pHashVersion;
  }
  
  public final void setPHash(String paramString)
  {
    AppMethodBeat.i(186313);
    p.h(paramString, "<set-?>");
    this.pHash = paramString;
    AppMethodBeat.o(186313);
  }
  
  public final void setPHashVersion(String paramString)
  {
    AppMethodBeat.i(186314);
    p.h(paramString, "<set-?>");
    this.pHashVersion = paramString;
    AppMethodBeat.o(186314);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.model.ScanImagePHashInfo
 * JD-Core Version:    0.7.0.1
 */