package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class alc
  extends com.tencent.mm.bw.a
{
  public String Lub;
  public String finderUsername;
  public long hFK;
  public int mediaType;
  public String sessionBuffer;
  public int videoDuration;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(209321);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bb(1, this.hFK);
      if (this.finderUsername != null) {
        paramVarArgs.e(2, this.finderUsername);
      }
      if (this.sessionBuffer != null) {
        paramVarArgs.e(3, this.sessionBuffer);
      }
      if (this.Lub != null) {
        paramVarArgs.e(4, this.Lub);
      }
      paramVarArgs.aM(5, this.videoDuration);
      paramVarArgs.aM(6, this.mediaType);
      AppMethodBeat.o(209321);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = g.a.a.b.b.a.r(1, this.hFK) + 0;
      paramInt = i;
      if (this.finderUsername != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.finderUsername);
      }
      i = paramInt;
      if (this.sessionBuffer != null) {
        i = paramInt + g.a.a.b.b.a.f(3, this.sessionBuffer);
      }
      paramInt = i;
      if (this.Lub != null) {
        paramInt = i + g.a.a.b.b.a.f(4, this.Lub);
      }
      i = g.a.a.b.b.a.bu(5, this.videoDuration);
      int j = g.a.a.b.b.a.bu(6, this.mediaType);
      AppMethodBeat.o(209321);
      return paramInt + i + j;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.hPl();
        }
      }
      AppMethodBeat.o(209321);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      alc localalc = (alc)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(209321);
        return -1;
      case 1: 
        localalc.hFK = locala.UbS.zl();
        AppMethodBeat.o(209321);
        return 0;
      case 2: 
        localalc.finderUsername = locala.UbS.readString();
        AppMethodBeat.o(209321);
        return 0;
      case 3: 
        localalc.sessionBuffer = locala.UbS.readString();
        AppMethodBeat.o(209321);
        return 0;
      case 4: 
        localalc.Lub = locala.UbS.readString();
        AppMethodBeat.o(209321);
        return 0;
      case 5: 
        localalc.videoDuration = locala.UbS.zi();
        AppMethodBeat.o(209321);
        return 0;
      }
      localalc.mediaType = locala.UbS.zi();
      AppMethodBeat.o(209321);
      return 0;
    }
    AppMethodBeat.o(209321);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.alc
 * JD-Core Version:    0.7.0.1
 */