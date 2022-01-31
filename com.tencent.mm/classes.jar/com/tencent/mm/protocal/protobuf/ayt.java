package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bv.b;

public final class ayt
  extends com.tencent.mm.bv.a
{
  public int jJu;
  public int wPI;
  public int xoo;
  public b xop;
  public int xoq;
  public int xor;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(72858);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aO(1, this.xoo);
      if (this.xop != null) {
        paramVarArgs.c(2, this.xop);
      }
      paramVarArgs.aO(3, this.xoq);
      paramVarArgs.aO(4, this.wPI);
      paramVarArgs.aO(5, this.jJu);
      paramVarArgs.aO(6, this.xor);
      AppMethodBeat.o(72858);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = e.a.a.b.b.a.bl(1, this.xoo) + 0;
      paramInt = i;
      if (this.xop != null) {
        paramInt = i + e.a.a.b.b.a.b(2, this.xop);
      }
      i = e.a.a.b.b.a.bl(3, this.xoq);
      int j = e.a.a.b.b.a.bl(4, this.wPI);
      int k = e.a.a.b.b.a.bl(5, this.jJu);
      int m = e.a.a.b.b.a.bl(6, this.xor);
      AppMethodBeat.o(72858);
      return paramInt + i + j + k + m;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.eqQ();
        }
      }
      AppMethodBeat.o(72858);
      return 0;
    }
    if (paramInt == 3)
    {
      e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
      ayt localayt = (ayt)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(72858);
        return -1;
      case 1: 
        localayt.xoo = locala.CLY.sl();
        AppMethodBeat.o(72858);
        return 0;
      case 2: 
        localayt.xop = locala.CLY.eqS();
        AppMethodBeat.o(72858);
        return 0;
      case 3: 
        localayt.xoq = locala.CLY.sl();
        AppMethodBeat.o(72858);
        return 0;
      case 4: 
        localayt.wPI = locala.CLY.sl();
        AppMethodBeat.o(72858);
        return 0;
      case 5: 
        localayt.jJu = locala.CLY.sl();
        AppMethodBeat.o(72858);
        return 0;
      }
      localayt.xor = locala.CLY.sl();
      AppMethodBeat.o(72858);
      return 0;
    }
    AppMethodBeat.o(72858);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ayt
 * JD-Core Version:    0.7.0.1
 */