package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class beg
  extends com.tencent.mm.bv.a
{
  public int qsl;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(56858);
    if (paramInt == 0)
    {
      ((e.a.a.c.a)paramVarArgs[0]).aO(1, this.qsl);
      AppMethodBeat.o(56858);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = e.a.a.b.b.a.bl(1, this.qsl);
      AppMethodBeat.o(56858);
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
      AppMethodBeat.o(56858);
      return 0;
    }
    if (paramInt == 3)
    {
      e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
      beg localbeg = (beg)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(56858);
        return -1;
      }
      localbeg.qsl = locala.CLY.sl();
      AppMethodBeat.o(56858);
      return 0;
    }
    AppMethodBeat.o(56858);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.beg
 * JD-Core Version:    0.7.0.1
 */