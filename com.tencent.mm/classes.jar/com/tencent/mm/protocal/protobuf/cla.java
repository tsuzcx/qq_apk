package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bv.b;

public final class cla
  extends com.tencent.mm.bv.a
{
  public b wBy;
  public int wBz;
  public int xVv;
  public int xVw;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(56990);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aO(7, this.xVv);
      if (this.wBy != null) {
        paramVarArgs.c(8, this.wBy);
      }
      paramVarArgs.aO(9, this.wBz);
      paramVarArgs.aO(10, this.xVw);
      AppMethodBeat.o(56990);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = e.a.a.b.b.a.bl(7, this.xVv) + 0;
      paramInt = i;
      if (this.wBy != null) {
        paramInt = i + e.a.a.b.b.a.b(8, this.wBy);
      }
      i = e.a.a.b.b.a.bl(9, this.wBz);
      int j = e.a.a.b.b.a.bl(10, this.xVw);
      AppMethodBeat.o(56990);
      return paramInt + i + j;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.eqQ();
        }
      }
      AppMethodBeat.o(56990);
      return 0;
    }
    if (paramInt == 3)
    {
      e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
      cla localcla = (cla)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(56990);
        return -1;
      case 7: 
        localcla.xVv = locala.CLY.sl();
        AppMethodBeat.o(56990);
        return 0;
      case 8: 
        localcla.wBy = locala.CLY.eqS();
        AppMethodBeat.o(56990);
        return 0;
      case 9: 
        localcla.wBz = locala.CLY.sl();
        AppMethodBeat.o(56990);
        return 0;
      }
      localcla.xVw = locala.CLY.sl();
      AppMethodBeat.o(56990);
      return 0;
    }
    AppMethodBeat.o(56990);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cla
 * JD-Core Version:    0.7.0.1
 */