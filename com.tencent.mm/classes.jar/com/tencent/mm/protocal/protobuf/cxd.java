package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class cxd
  extends com.tencent.mm.bv.a
{
  public long wsz;
  public boolean yeM;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(28738);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      paramVarArgs.am(1, this.wsz);
      paramVarArgs.aS(2, this.yeM);
      AppMethodBeat.o(28738);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = e.a.a.b.b.a.p(1, this.wsz);
      int i = e.a.a.b.b.a.eW(2);
      AppMethodBeat.o(28738);
      return paramInt + 0 + (i + 1);
    }
    if (paramInt == 2)
    {
      paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.eqQ();
        }
      }
      AppMethodBeat.o(28738);
      return 0;
    }
    if (paramInt == 3)
    {
      e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
      cxd localcxd = (cxd)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(28738);
        return -1;
      case 1: 
        localcxd.wsz = locala.CLY.sm();
        AppMethodBeat.o(28738);
        return 0;
      }
      localcxd.yeM = locala.CLY.emu();
      AppMethodBeat.o(28738);
      return 0;
    }
    AppMethodBeat.o(28738);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cxd
 * JD-Core Version:    0.7.0.1
 */