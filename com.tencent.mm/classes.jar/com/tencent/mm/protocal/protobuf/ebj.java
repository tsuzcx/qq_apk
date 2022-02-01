package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ebj
  extends com.tencent.mm.bw.a
{
  public int Nbc;
  public int Nbd;
  public int kej;
  public String kek;
  public long kel;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(43131);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aM(1, this.kej);
      if (this.kek != null) {
        paramVarArgs.e(2, this.kek);
      }
      paramVarArgs.bb(3, this.kel);
      paramVarArgs.aM(4, this.Nbc);
      paramVarArgs.aM(5, this.Nbd);
      AppMethodBeat.o(43131);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = g.a.a.b.b.a.bu(1, this.kej) + 0;
      paramInt = i;
      if (this.kek != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.kek);
      }
      i = g.a.a.b.b.a.r(3, this.kel);
      int j = g.a.a.b.b.a.bu(4, this.Nbc);
      int k = g.a.a.b.b.a.bu(5, this.Nbd);
      AppMethodBeat.o(43131);
      return paramInt + i + j + k;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.hPl();
        }
      }
      AppMethodBeat.o(43131);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      ebj localebj = (ebj)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(43131);
        return -1;
      case 1: 
        localebj.kej = locala.UbS.zi();
        AppMethodBeat.o(43131);
        return 0;
      case 2: 
        localebj.kek = locala.UbS.readString();
        AppMethodBeat.o(43131);
        return 0;
      case 3: 
        localebj.kel = locala.UbS.zl();
        AppMethodBeat.o(43131);
        return 0;
      case 4: 
        localebj.Nbc = locala.UbS.zi();
        AppMethodBeat.o(43131);
        return 0;
      }
      localebj.Nbd = locala.UbS.zi();
      AppMethodBeat.o(43131);
      return 0;
    }
    AppMethodBeat.o(43131);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ebj
 * JD-Core Version:    0.7.0.1
 */