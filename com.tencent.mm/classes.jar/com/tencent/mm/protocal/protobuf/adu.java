package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class adu
  extends com.tencent.mm.bv.a
{
  public int hAu;
  public int index;
  public String username;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(28407);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aO(1, this.index);
      if (this.username != null) {
        paramVarArgs.e(2, this.username);
      }
      paramVarArgs.aO(3, this.hAu);
      AppMethodBeat.o(28407);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = e.a.a.b.b.a.bl(1, this.index) + 0;
      paramInt = i;
      if (this.username != null) {
        paramInt = i + e.a.a.b.b.a.f(2, this.username);
      }
      i = e.a.a.b.b.a.bl(3, this.hAu);
      AppMethodBeat.o(28407);
      return paramInt + i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.eqQ();
        }
      }
      AppMethodBeat.o(28407);
      return 0;
    }
    if (paramInt == 3)
    {
      e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
      adu localadu = (adu)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(28407);
        return -1;
      case 1: 
        localadu.index = locala.CLY.sl();
        AppMethodBeat.o(28407);
        return 0;
      case 2: 
        localadu.username = locala.CLY.readString();
        AppMethodBeat.o(28407);
        return 0;
      }
      localadu.hAu = locala.CLY.sl();
      AppMethodBeat.o(28407);
      return 0;
    }
    AppMethodBeat.o(28407);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.adu
 * JD-Core Version:    0.7.0.1
 */