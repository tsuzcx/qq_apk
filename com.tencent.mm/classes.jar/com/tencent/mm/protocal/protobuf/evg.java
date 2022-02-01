package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;

public final class evg
  extends com.tencent.mm.bw.a
{
  public b LrK;
  public int MVo;
  public int Ntf;
  public int apr;
  public String category;
  public int jlm;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(147790);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aM(1, this.jlm);
      paramVarArgs.aM(2, this.apr);
      if (this.category != null) {
        paramVarArgs.e(3, this.category);
      }
      if (this.LrK != null) {
        paramVarArgs.c(4, this.LrK);
      }
      paramVarArgs.aM(5, this.MVo);
      paramVarArgs.aM(6, this.Ntf);
      AppMethodBeat.o(147790);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = g.a.a.b.b.a.bu(1, this.jlm) + 0 + g.a.a.b.b.a.bu(2, this.apr);
      paramInt = i;
      if (this.category != null) {
        paramInt = i + g.a.a.b.b.a.f(3, this.category);
      }
      i = paramInt;
      if (this.LrK != null) {
        i = paramInt + g.a.a.b.b.a.b(4, this.LrK);
      }
      paramInt = g.a.a.b.b.a.bu(5, this.MVo);
      int j = g.a.a.b.b.a.bu(6, this.Ntf);
      AppMethodBeat.o(147790);
      return i + paramInt + j;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.hPl();
        }
      }
      AppMethodBeat.o(147790);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      evg localevg = (evg)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(147790);
        return -1;
      case 1: 
        localevg.jlm = locala.UbS.zi();
        AppMethodBeat.o(147790);
        return 0;
      case 2: 
        localevg.apr = locala.UbS.zi();
        AppMethodBeat.o(147790);
        return 0;
      case 3: 
        localevg.category = locala.UbS.readString();
        AppMethodBeat.o(147790);
        return 0;
      case 4: 
        localevg.LrK = locala.UbS.hPo();
        AppMethodBeat.o(147790);
        return 0;
      case 5: 
        localevg.MVo = locala.UbS.zi();
        AppMethodBeat.o(147790);
        return 0;
      }
      localevg.Ntf = locala.UbS.zi();
      AppMethodBeat.o(147790);
      return 0;
    }
    AppMethodBeat.o(147790);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.evg
 * JD-Core Version:    0.7.0.1
 */