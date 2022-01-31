package com.tencent.ttpic.gles;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum Texture2dProgram$ProgramType
{
  static
  {
    AppMethodBeat.i(50038);
    TEXTURE_2D = new ProgramType("TEXTURE_2D", 0);
    TEXTURE_EXT = new ProgramType("TEXTURE_EXT", 1);
    TEXTURE_EXT_BW = new ProgramType("TEXTURE_EXT_BW", 2);
    TEXTURE_EXT_FILT = new ProgramType("TEXTURE_EXT_FILT", 3);
    $VALUES = new ProgramType[] { TEXTURE_2D, TEXTURE_EXT, TEXTURE_EXT_BW, TEXTURE_EXT_FILT };
    AppMethodBeat.o(50038);
  }
  
  private Texture2dProgram$ProgramType() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.ttpic.gles.Texture2dProgram.ProgramType
 * JD-Core Version:    0.7.0.1
 */