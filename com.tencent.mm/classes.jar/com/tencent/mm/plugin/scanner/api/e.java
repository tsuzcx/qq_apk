package com.tencent.mm.plugin.scanner.api;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.ml;
import com.tencent.mm.protocal.protobuf.mu;

public final class e
{
  public ml IGA;
  public ScanImagePHashInfo IGB;
  public boolean IGC;
  public boolean IGD;
  public e.a IGE;
  public Bundle IGp;
  public int IGy;
  public mu IGz;
  public boolean gaj;
  public String imagePath;
  public int mode;
  public long msgId;
  public long sessionId;
  public int source;
  public int type;
  
  public e()
  {
    AppMethodBeat.i(210467);
    this.imagePath = "";
    this.IGC = true;
    this.gaj = true;
    this.IGD = true;
    this.IGE = new e.a();
    this.IGp = new Bundle();
    AppMethodBeat.o(210467);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.api.e
 * JD-Core Version:    0.7.0.1
 */