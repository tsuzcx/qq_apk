package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class cmi
  extends com.tencent.mm.bx.a
{
  public String dDl;
  public int dDm;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(19408);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.dDm);
      if (this.dDl != null) {
        paramVarArgs.d(2, this.dDl);
      }
      AppMethodBeat.o(19408);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bz(1, this.dDm) + 0;
      paramInt = i;
      if (this.dDl != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.dDl);
      }
      AppMethodBeat.o(19408);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gxE();
        }
      }
      AppMethodBeat.o(19408);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      cmi localcmi = (cmi)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(19408);
        return -1;
      case 1: 
        localcmi.dDm = locala.NPN.zc();
        AppMethodBeat.o(19408);
        return 0;
      }
      localcmi.dDl = locala.NPN.readString();
      AppMethodBeat.o(19408);
      return 0;
    }
    AppMethodBeat.o(19408);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cmi
 * JD-Core Version:    0.7.0.1
 */