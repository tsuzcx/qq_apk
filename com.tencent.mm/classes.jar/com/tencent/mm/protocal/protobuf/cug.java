package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class cug
  extends com.tencent.mm.bv.a
{
  public long ycX;
  public int ycY;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(102413);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      paramVarArgs.am(1, this.ycX);
      paramVarArgs.aO(2, this.ycY);
      AppMethodBeat.o(102413);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = e.a.a.b.b.a.p(1, this.ycX);
      int i = e.a.a.b.b.a.bl(2, this.ycY);
      AppMethodBeat.o(102413);
      return paramInt + 0 + i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.eqQ();
        }
      }
      AppMethodBeat.o(102413);
      return 0;
    }
    if (paramInt == 3)
    {
      e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
      cug localcug = (cug)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(102413);
        return -1;
      case 1: 
        localcug.ycX = locala.CLY.sm();
        AppMethodBeat.o(102413);
        return 0;
      }
      localcug.ycY = locala.CLY.sl();
      AppMethodBeat.o(102413);
      return 0;
    }
    AppMethodBeat.o(102413);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cug
 * JD-Core Version:    0.7.0.1
 */