package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class uv
  extends com.tencent.mm.bw.a
{
  public int Leq;
  public int Ler;
  public String Les;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(113972);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aM(1, this.Leq);
      paramVarArgs.aM(2, this.Ler);
      if (this.Les != null) {
        paramVarArgs.e(3, this.Les);
      }
      AppMethodBeat.o(113972);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = g.a.a.b.b.a.bu(1, this.Leq) + 0 + g.a.a.b.b.a.bu(2, this.Ler);
      paramInt = i;
      if (this.Les != null) {
        paramInt = i + g.a.a.b.b.a.f(3, this.Les);
      }
      AppMethodBeat.o(113972);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.hPl();
        }
      }
      AppMethodBeat.o(113972);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      uv localuv = (uv)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(113972);
        return -1;
      case 1: 
        localuv.Leq = locala.UbS.zi();
        AppMethodBeat.o(113972);
        return 0;
      case 2: 
        localuv.Ler = locala.UbS.zi();
        AppMethodBeat.o(113972);
        return 0;
      }
      localuv.Les = locala.UbS.readString();
      AppMethodBeat.o(113972);
      return 0;
    }
    AppMethodBeat.o(113972);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.uv
 * JD-Core Version:    0.7.0.1
 */