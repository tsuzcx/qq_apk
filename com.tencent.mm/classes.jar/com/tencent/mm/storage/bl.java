package com.tencent.mm.storage;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bl
  extends com.tencent.mm.bv.a
{
  public long cgd;
  public long cpO;
  public long hBy;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(60210);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      paramVarArgs.am(1, this.cpO);
      paramVarArgs.am(2, this.hBy);
      paramVarArgs.am(3, this.cgd);
      AppMethodBeat.o(60210);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = e.a.a.b.b.a.p(1, this.cpO);
      int i = e.a.a.b.b.a.p(2, this.hBy);
      int j = e.a.a.b.b.a.p(3, this.cgd);
      AppMethodBeat.o(60210);
      return paramInt + 0 + i + j;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.eqQ();
        }
      }
      AppMethodBeat.o(60210);
      return 0;
    }
    if (paramInt == 3)
    {
      e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
      bl localbl = (bl)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(60210);
        return -1;
      case 1: 
        localbl.cpO = locala.CLY.sm();
        AppMethodBeat.o(60210);
        return 0;
      case 2: 
        localbl.hBy = locala.CLY.sm();
        AppMethodBeat.o(60210);
        return 0;
      }
      localbl.cgd = locala.CLY.sm();
      AppMethodBeat.o(60210);
      return 0;
    }
    AppMethodBeat.o(60210);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.storage.bl
 * JD-Core Version:    0.7.0.1
 */