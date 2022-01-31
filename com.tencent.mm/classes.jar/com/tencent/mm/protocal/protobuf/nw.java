package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class nw
  extends com.tencent.mm.bv.a
{
  public int wDx;
  public int wDy;
  public String wDz;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(56734);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aO(1, this.wDx);
      paramVarArgs.aO(2, this.wDy);
      if (this.wDz != null) {
        paramVarArgs.e(3, this.wDz);
      }
      AppMethodBeat.o(56734);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = e.a.a.b.b.a.bl(1, this.wDx) + 0 + e.a.a.b.b.a.bl(2, this.wDy);
      paramInt = i;
      if (this.wDz != null) {
        paramInt = i + e.a.a.b.b.a.f(3, this.wDz);
      }
      AppMethodBeat.o(56734);
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
      AppMethodBeat.o(56734);
      return 0;
    }
    if (paramInt == 3)
    {
      e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
      nw localnw = (nw)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(56734);
        return -1;
      case 1: 
        localnw.wDx = locala.CLY.sl();
        AppMethodBeat.o(56734);
        return 0;
      case 2: 
        localnw.wDy = locala.CLY.sl();
        AppMethodBeat.o(56734);
        return 0;
      }
      localnw.wDz = locala.CLY.readString();
      AppMethodBeat.o(56734);
      return 0;
    }
    AppMethodBeat.o(56734);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.nw
 * JD-Core Version:    0.7.0.1
 */