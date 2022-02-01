package com.tencent.mm.plugin.scanner.api;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.nq;
import com.tencent.mm.protocal.protobuf.nz;

public final class e
{
  public int OMG;
  public nz OMH;
  public nq OMI;
  public ScanImagePHashInfo OMJ;
  public boolean OMK;
  public boolean OML;
  public e.a OMM;
  public Bundle OMx;
  public boolean igs;
  public String imagePath;
  public int mode;
  public long msgId;
  public long sessionId;
  public int source;
  public int type;
  
  public e()
  {
    AppMethodBeat.i(313450);
    this.imagePath = "";
    this.OMK = true;
    this.igs = true;
    this.OML = true;
    this.OMM = new e.a();
    this.OMx = new Bundle();
    AppMethodBeat.o(313450);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.api.e
 * JD-Core Version:    0.7.0.1
 */