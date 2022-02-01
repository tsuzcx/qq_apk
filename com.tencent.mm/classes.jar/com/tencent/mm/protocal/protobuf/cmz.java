package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class cmz
  extends com.tencent.mm.bw.a
{
  public int MlH;
  public int Msw;
  public String SessionId;
  public int xuT;
  public int xub;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(125742);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aM(1, this.xub);
      paramVarArgs.aM(2, this.xuT);
      paramVarArgs.aM(3, this.Msw);
      if (this.SessionId != null) {
        paramVarArgs.e(4, this.SessionId);
      }
      paramVarArgs.aM(5, this.MlH);
      AppMethodBeat.o(125742);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = g.a.a.b.b.a.bu(1, this.xub) + 0 + g.a.a.b.b.a.bu(2, this.xuT) + g.a.a.b.b.a.bu(3, this.Msw);
      paramInt = i;
      if (this.SessionId != null) {
        paramInt = i + g.a.a.b.b.a.f(4, this.SessionId);
      }
      i = g.a.a.b.b.a.bu(5, this.MlH);
      AppMethodBeat.o(125742);
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
      AppMethodBeat.o(125742);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      cmz localcmz = (cmz)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(125742);
        return -1;
      case 1: 
        localcmz.xub = locala.UbS.zi();
        AppMethodBeat.o(125742);
        return 0;
      case 2: 
        localcmz.xuT = locala.UbS.zi();
        AppMethodBeat.o(125742);
        return 0;
      case 3: 
        localcmz.Msw = locala.UbS.zi();
        AppMethodBeat.o(125742);
        return 0;
      case 4: 
        localcmz.SessionId = locala.UbS.readString();
        AppMethodBeat.o(125742);
        return 0;
      }
      localcmz.MlH = locala.UbS.zi();
      AppMethodBeat.o(125742);
      return 0;
    }
    AppMethodBeat.o(125742);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cmz
 * JD-Core Version:    0.7.0.1
 */