package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dbm
  extends com.tencent.mm.bx.a
{
  public int KPQ;
  public int aaGX;
  public int dataType;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(259577);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bS(1, this.aaGX);
      paramVarArgs.bS(2, this.KPQ);
      paramVarArgs.bS(3, this.dataType);
      AppMethodBeat.o(259577);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = i.a.a.b.b.a.cJ(1, this.aaGX);
      int i = i.a.a.b.b.a.cJ(2, this.KPQ);
      int j = i.a.a.b.b.a.cJ(3, this.dataType);
      AppMethodBeat.o(259577);
      return paramInt + 0 + i + j;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(259577);
      return 0;
    }
    if (paramInt == 3)
    {
      i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
      dbm localdbm = (dbm)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(259577);
        return -1;
      case 1: 
        localdbm.aaGX = locala.ajGk.aar();
        AppMethodBeat.o(259577);
        return 0;
      case 2: 
        localdbm.KPQ = locala.ajGk.aar();
        AppMethodBeat.o(259577);
        return 0;
      }
      localdbm.dataType = locala.ajGk.aar();
      AppMethodBeat.o(259577);
      return 0;
    }
    AppMethodBeat.o(259577);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dbm
 * JD-Core Version:    0.7.0.1
 */