package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bv.b;

public final class bhj
  extends com.tencent.mm.bv.a
{
  public int xww;
  public b xwx;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(93799);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aO(1, this.xww);
      if (this.xwx != null) {
        paramVarArgs.c(2, this.xwx);
      }
      AppMethodBeat.o(93799);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = e.a.a.b.b.a.bl(1, this.xww) + 0;
      paramInt = i;
      if (this.xwx != null) {
        paramInt = i + e.a.a.b.b.a.b(2, this.xwx);
      }
      AppMethodBeat.o(93799);
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
      AppMethodBeat.o(93799);
      return 0;
    }
    if (paramInt == 3)
    {
      e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
      bhj localbhj = (bhj)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(93799);
        return -1;
      case 1: 
        localbhj.xww = locala.CLY.sl();
        AppMethodBeat.o(93799);
        return 0;
      }
      localbhj.xwx = locala.CLY.eqS();
      AppMethodBeat.o(93799);
      return 0;
    }
    AppMethodBeat.o(93799);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bhj
 * JD-Core Version:    0.7.0.1
 */