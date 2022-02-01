package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class amd
  extends com.tencent.mm.cd.a
{
  public String Swz;
  public String finderUsername;
  public int mediaType;
  public String sessionBuffer;
  public int videoDuration;
  public long xbk;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(204138);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bm(1, this.xbk);
      if (this.finderUsername != null) {
        paramVarArgs.f(2, this.finderUsername);
      }
      if (this.sessionBuffer != null) {
        paramVarArgs.f(3, this.sessionBuffer);
      }
      if (this.Swz != null) {
        paramVarArgs.f(4, this.Swz);
      }
      paramVarArgs.aY(5, this.videoDuration);
      paramVarArgs.aY(6, this.mediaType);
      AppMethodBeat.o(204138);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = g.a.a.b.b.a.p(1, this.xbk) + 0;
      paramInt = i;
      if (this.finderUsername != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.finderUsername);
      }
      i = paramInt;
      if (this.sessionBuffer != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.sessionBuffer);
      }
      paramInt = i;
      if (this.Swz != null) {
        paramInt = i + g.a.a.b.b.a.g(4, this.Swz);
      }
      i = g.a.a.b.b.a.bM(5, this.videoDuration);
      int j = g.a.a.b.b.a.bM(6, this.mediaType);
      AppMethodBeat.o(204138);
      return paramInt + i + j;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.iUs();
        }
      }
      AppMethodBeat.o(204138);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      amd localamd = (amd)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(204138);
        return -1;
      case 1: 
        localamd.xbk = locala.abFh.AN();
        AppMethodBeat.o(204138);
        return 0;
      case 2: 
        localamd.finderUsername = locala.abFh.readString();
        AppMethodBeat.o(204138);
        return 0;
      case 3: 
        localamd.sessionBuffer = locala.abFh.readString();
        AppMethodBeat.o(204138);
        return 0;
      case 4: 
        localamd.Swz = locala.abFh.readString();
        AppMethodBeat.o(204138);
        return 0;
      case 5: 
        localamd.videoDuration = locala.abFh.AK();
        AppMethodBeat.o(204138);
        return 0;
      }
      localamd.mediaType = locala.abFh.AK();
      AppMethodBeat.o(204138);
      return 0;
    }
    AppMethodBeat.o(204138);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.amd
 * JD-Core Version:    0.7.0.1
 */