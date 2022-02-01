package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class aah
  extends com.tencent.mm.bw.a
{
  public int Lls;
  public int Llt;
  public int Llu;
  public boolean Llv;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(187870);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aM(1, this.Lls);
      paramVarArgs.aM(2, this.Llt);
      paramVarArgs.aM(3, this.Llu);
      paramVarArgs.cc(4, this.Llv);
      AppMethodBeat.o(187870);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = g.a.a.b.b.a.bu(1, this.Lls);
      int i = g.a.a.b.b.a.bu(2, this.Llt);
      int j = g.a.a.b.b.a.bu(3, this.Llu);
      int k = g.a.a.b.b.a.fS(4);
      AppMethodBeat.o(187870);
      return paramInt + 0 + i + j + (k + 1);
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.hPl();
        }
      }
      AppMethodBeat.o(187870);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      aah localaah = (aah)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(187870);
        return -1;
      case 1: 
        localaah.Lls = locala.UbS.zi();
        AppMethodBeat.o(187870);
        return 0;
      case 2: 
        localaah.Llt = locala.UbS.zi();
        AppMethodBeat.o(187870);
        return 0;
      case 3: 
        localaah.Llu = locala.UbS.zi();
        AppMethodBeat.o(187870);
        return 0;
      }
      localaah.Llv = locala.UbS.yZ();
      AppMethodBeat.o(187870);
      return 0;
    }
    AppMethodBeat.o(187870);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aah
 * JD-Core Version:    0.7.0.1
 */