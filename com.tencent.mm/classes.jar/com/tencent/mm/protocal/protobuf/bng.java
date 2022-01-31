package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bng
  extends com.tencent.mm.bv.a
{
  public int xBv;
  public int xBw;
  public String xBx;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(94549);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aO(1, this.xBv);
      paramVarArgs.aO(2, this.xBw);
      if (this.xBx != null) {
        paramVarArgs.e(3, this.xBx);
      }
      AppMethodBeat.o(94549);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = e.a.a.b.b.a.bl(1, this.xBv) + 0 + e.a.a.b.b.a.bl(2, this.xBw);
      paramInt = i;
      if (this.xBx != null) {
        paramInt = i + e.a.a.b.b.a.f(3, this.xBx);
      }
      AppMethodBeat.o(94549);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.eqQ();
        }
      }
      AppMethodBeat.o(94549);
      return 0;
    }
    if (paramInt == 3)
    {
      e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
      bng localbng = (bng)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(94549);
        return -1;
      case 1: 
        localbng.xBv = locala.CLY.sl();
        AppMethodBeat.o(94549);
        return 0;
      case 2: 
        localbng.xBw = locala.CLY.sl();
        AppMethodBeat.o(94549);
        return 0;
      }
      localbng.xBx = locala.CLY.readString();
      AppMethodBeat.o(94549);
      return 0;
    }
    AppMethodBeat.o(94549);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bng
 * JD-Core Version:    0.7.0.1
 */