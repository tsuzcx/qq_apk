package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;

public final class bh
  extends com.tencent.mm.bw.a
{
  public boolean KEI;
  public boolean KEJ;
  public int KEK;
  public boolean KEL;
  public b KEM;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(123537);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.cc(1, this.KEI);
      paramVarArgs.cc(2, this.KEJ);
      paramVarArgs.aM(3, this.KEK);
      paramVarArgs.cc(4, this.KEL);
      if (this.KEM != null) {
        paramVarArgs.c(5, this.KEM);
      }
      AppMethodBeat.o(123537);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = g.a.a.b.b.a.fS(1) + 1 + 0 + (g.a.a.b.b.a.fS(2) + 1) + g.a.a.b.b.a.bu(3, this.KEK) + (g.a.a.b.b.a.fS(4) + 1);
      paramInt = i;
      if (this.KEM != null) {
        paramInt = i + g.a.a.b.b.a.b(5, this.KEM);
      }
      AppMethodBeat.o(123537);
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
      AppMethodBeat.o(123537);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      bh localbh = (bh)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(123537);
        return -1;
      case 1: 
        localbh.KEI = locala.UbS.yZ();
        AppMethodBeat.o(123537);
        return 0;
      case 2: 
        localbh.KEJ = locala.UbS.yZ();
        AppMethodBeat.o(123537);
        return 0;
      case 3: 
        localbh.KEK = locala.UbS.zi();
        AppMethodBeat.o(123537);
        return 0;
      case 4: 
        localbh.KEL = locala.UbS.yZ();
        AppMethodBeat.o(123537);
        return 0;
      }
      localbh.KEM = locala.UbS.hPo();
      AppMethodBeat.o(123537);
      return 0;
    }
    AppMethodBeat.o(123537);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bh
 * JD-Core Version:    0.7.0.1
 */