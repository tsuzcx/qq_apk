package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class chp
  extends com.tencent.mm.bv.a
{
  public long xRw;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(56531);
    if (paramInt == 0)
    {
      ((e.a.a.c.a)paramVarArgs[0]).am(1, this.xRw);
      AppMethodBeat.o(56531);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = e.a.a.b.b.a.p(1, this.xRw);
      AppMethodBeat.o(56531);
      return paramInt + 0;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.eqQ();
        }
      }
      AppMethodBeat.o(56531);
      return 0;
    }
    if (paramInt == 3)
    {
      e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
      chp localchp = (chp)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(56531);
        return -1;
      }
      localchp.xRw = locala.CLY.sm();
      AppMethodBeat.o(56531);
      return 0;
    }
    AppMethodBeat.o(56531);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.chp
 * JD-Core Version:    0.7.0.1
 */