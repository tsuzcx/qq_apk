package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class cux
  extends com.tencent.mm.bv.a
{
  public int ID;
  public String ntu;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(28706);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aO(1, this.ID);
      if (this.ntu != null) {
        paramVarArgs.e(2, this.ntu);
      }
      AppMethodBeat.o(28706);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = e.a.a.b.b.a.bl(1, this.ID) + 0;
      paramInt = i;
      if (this.ntu != null) {
        paramInt = i + e.a.a.b.b.a.f(2, this.ntu);
      }
      AppMethodBeat.o(28706);
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
      AppMethodBeat.o(28706);
      return 0;
    }
    if (paramInt == 3)
    {
      e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
      cux localcux = (cux)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(28706);
        return -1;
      case 1: 
        localcux.ID = locala.CLY.sl();
        AppMethodBeat.o(28706);
        return 0;
      }
      localcux.ntu = locala.CLY.readString();
      AppMethodBeat.o(28706);
      return 0;
    }
    AppMethodBeat.o(28706);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cux
 * JD-Core Version:    0.7.0.1
 */