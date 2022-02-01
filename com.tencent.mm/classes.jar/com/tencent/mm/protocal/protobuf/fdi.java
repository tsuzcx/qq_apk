package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class fdi
  extends com.tencent.mm.bw.a
{
  public int MqF;
  public int NyM;
  public long NyT;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(50119);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aM(1, this.MqF);
      paramVarArgs.bb(2, this.NyT);
      paramVarArgs.aM(3, this.NyM);
      AppMethodBeat.o(50119);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = g.a.a.b.b.a.bu(1, this.MqF);
      int i = g.a.a.b.b.a.r(2, this.NyT);
      int j = g.a.a.b.b.a.bu(3, this.NyM);
      AppMethodBeat.o(50119);
      return paramInt + 0 + i + j;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.hPl();
        }
      }
      AppMethodBeat.o(50119);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      fdi localfdi = (fdi)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(50119);
        return -1;
      case 1: 
        localfdi.MqF = locala.UbS.zi();
        AppMethodBeat.o(50119);
        return 0;
      case 2: 
        localfdi.NyT = locala.UbS.zl();
        AppMethodBeat.o(50119);
        return 0;
      }
      localfdi.NyM = locala.UbS.zi();
      AppMethodBeat.o(50119);
      return 0;
    }
    AppMethodBeat.o(50119);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fdi
 * JD-Core Version:    0.7.0.1
 */