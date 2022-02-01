package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class fdb
  extends com.tencent.mm.bw.a
{
  public int KHb;
  public int MqF;
  public int NyM;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(123703);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aM(1, this.MqF);
      paramVarArgs.aM(2, this.KHb);
      paramVarArgs.aM(3, this.NyM);
      AppMethodBeat.o(123703);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = g.a.a.b.b.a.bu(1, this.MqF);
      int i = g.a.a.b.b.a.bu(2, this.KHb);
      int j = g.a.a.b.b.a.bu(3, this.NyM);
      AppMethodBeat.o(123703);
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
      AppMethodBeat.o(123703);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      fdb localfdb = (fdb)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(123703);
        return -1;
      case 1: 
        localfdb.MqF = locala.UbS.zi();
        AppMethodBeat.o(123703);
        return 0;
      case 2: 
        localfdb.KHb = locala.UbS.zi();
        AppMethodBeat.o(123703);
        return 0;
      }
      localfdb.NyM = locala.UbS.zi();
      AppMethodBeat.o(123703);
      return 0;
    }
    AppMethodBeat.o(123703);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fdb
 * JD-Core Version:    0.7.0.1
 */