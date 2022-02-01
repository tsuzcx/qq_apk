package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class epg
  extends com.tencent.mm.bw.a
{
  public String HZV;
  public String HZW;
  public String HZX;
  public int NgM;
  public int gTx;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(200233);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aM(1, this.gTx);
      if (this.HZV != null) {
        paramVarArgs.e(2, this.HZV);
      }
      if (this.HZW != null) {
        paramVarArgs.e(3, this.HZW);
      }
      if (this.HZX != null) {
        paramVarArgs.e(4, this.HZX);
      }
      paramVarArgs.aM(5, this.NgM);
      AppMethodBeat.o(200233);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = g.a.a.b.b.a.bu(1, this.gTx) + 0;
      paramInt = i;
      if (this.HZV != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.HZV);
      }
      i = paramInt;
      if (this.HZW != null) {
        i = paramInt + g.a.a.b.b.a.f(3, this.HZW);
      }
      paramInt = i;
      if (this.HZX != null) {
        paramInt = i + g.a.a.b.b.a.f(4, this.HZX);
      }
      i = g.a.a.b.b.a.bu(5, this.NgM);
      AppMethodBeat.o(200233);
      return paramInt + i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.hPl();
        }
      }
      AppMethodBeat.o(200233);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      epg localepg = (epg)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(200233);
        return -1;
      case 1: 
        localepg.gTx = locala.UbS.zi();
        AppMethodBeat.o(200233);
        return 0;
      case 2: 
        localepg.HZV = locala.UbS.readString();
        AppMethodBeat.o(200233);
        return 0;
      case 3: 
        localepg.HZW = locala.UbS.readString();
        AppMethodBeat.o(200233);
        return 0;
      case 4: 
        localepg.HZX = locala.UbS.readString();
        AppMethodBeat.o(200233);
        return 0;
      }
      localepg.NgM = locala.UbS.zi();
      AppMethodBeat.o(200233);
      return 0;
    }
    AppMethodBeat.o(200233);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.epg
 * JD-Core Version:    0.7.0.1
 */