package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bv.b;

public final class daz
  extends com.tencent.mm.bv.a
{
  public int type;
  public b wOQ;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(143704);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aO(1, this.type);
      if (this.wOQ != null) {
        paramVarArgs.c(2, this.wOQ);
      }
      AppMethodBeat.o(143704);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = e.a.a.b.b.a.bl(1, this.type) + 0;
      paramInt = i;
      if (this.wOQ != null) {
        paramInt = i + e.a.a.b.b.a.b(2, this.wOQ);
      }
      AppMethodBeat.o(143704);
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
      AppMethodBeat.o(143704);
      return 0;
    }
    if (paramInt == 3)
    {
      e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
      daz localdaz = (daz)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(143704);
        return -1;
      case 1: 
        localdaz.type = locala.CLY.sl();
        AppMethodBeat.o(143704);
        return 0;
      }
      localdaz.wOQ = locala.CLY.eqS();
      AppMethodBeat.o(143704);
      return 0;
    }
    AppMethodBeat.o(143704);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.daz
 * JD-Core Version:    0.7.0.1
 */