package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class csw
  extends com.tencent.mm.bv.a
{
  public int jKs;
  public int ybT;
  public int ybU;
  public int ybV;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(5257);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aO(1, this.jKs);
      paramVarArgs.aO(2, this.ybT);
      paramVarArgs.aO(3, this.ybU);
      paramVarArgs.aO(4, this.ybV);
      AppMethodBeat.o(5257);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = e.a.a.b.b.a.bl(1, this.jKs);
      int i = e.a.a.b.b.a.bl(2, this.ybT);
      int j = e.a.a.b.b.a.bl(3, this.ybU);
      int k = e.a.a.b.b.a.bl(4, this.ybV);
      AppMethodBeat.o(5257);
      return paramInt + 0 + i + j + k;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.eqQ();
        }
      }
      AppMethodBeat.o(5257);
      return 0;
    }
    if (paramInt == 3)
    {
      e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
      csw localcsw = (csw)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(5257);
        return -1;
      case 1: 
        localcsw.jKs = locala.CLY.sl();
        AppMethodBeat.o(5257);
        return 0;
      case 2: 
        localcsw.ybT = locala.CLY.sl();
        AppMethodBeat.o(5257);
        return 0;
      case 3: 
        localcsw.ybU = locala.CLY.sl();
        AppMethodBeat.o(5257);
        return 0;
      }
      localcsw.ybV = locala.CLY.sl();
      AppMethodBeat.o(5257);
      return 0;
    }
    AppMethodBeat.o(5257);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.csw
 * JD-Core Version:    0.7.0.1
 */