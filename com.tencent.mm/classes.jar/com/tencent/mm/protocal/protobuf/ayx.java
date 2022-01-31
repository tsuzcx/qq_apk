package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bv.b;

public final class ayx
  extends com.tencent.mm.bv.a
{
  public int jJu;
  public int xoo;
  public b xop;
  public int xov;
  public int xow;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(70483);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aO(1, this.xoo);
      if (this.xop != null) {
        paramVarArgs.c(2, this.xop);
      }
      paramVarArgs.aO(3, this.xov);
      paramVarArgs.aO(4, this.jJu);
      paramVarArgs.aO(5, this.xow);
      AppMethodBeat.o(70483);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = e.a.a.b.b.a.bl(1, this.xoo) + 0;
      paramInt = i;
      if (this.xop != null) {
        paramInt = i + e.a.a.b.b.a.b(2, this.xop);
      }
      i = e.a.a.b.b.a.bl(3, this.xov);
      int j = e.a.a.b.b.a.bl(4, this.jJu);
      int k = e.a.a.b.b.a.bl(5, this.xow);
      AppMethodBeat.o(70483);
      return paramInt + i + j + k;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.eqQ();
        }
      }
      AppMethodBeat.o(70483);
      return 0;
    }
    if (paramInt == 3)
    {
      e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
      ayx localayx = (ayx)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(70483);
        return -1;
      case 1: 
        localayx.xoo = locala.CLY.sl();
        AppMethodBeat.o(70483);
        return 0;
      case 2: 
        localayx.xop = locala.CLY.eqS();
        AppMethodBeat.o(70483);
        return 0;
      case 3: 
        localayx.xov = locala.CLY.sl();
        AppMethodBeat.o(70483);
        return 0;
      case 4: 
        localayx.jJu = locala.CLY.sl();
        AppMethodBeat.o(70483);
        return 0;
      }
      localayx.xow = locala.CLY.sl();
      AppMethodBeat.o(70483);
      return 0;
    }
    AppMethodBeat.o(70483);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ayx
 * JD-Core Version:    0.7.0.1
 */