package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class cnc
  extends com.tencent.mm.bw.a
{
  public String dEq;
  public int dEr;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(19408);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.dEr);
      if (this.dEq != null) {
        paramVarArgs.d(2, this.dEq);
      }
      AppMethodBeat.o(19408);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bz(1, this.dEr) + 0;
      paramInt = i;
      if (this.dEq != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.dEq);
      }
      AppMethodBeat.o(19408);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gCg();
        }
      }
      AppMethodBeat.o(19408);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      cnc localcnc = (cnc)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(19408);
        return -1;
      case 1: 
        localcnc.dEr = locala.OmT.zc();
        AppMethodBeat.o(19408);
        return 0;
      }
      localcnc.dEq = locala.OmT.readString();
      AppMethodBeat.o(19408);
      return 0;
    }
    AppMethodBeat.o(19408);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cnc
 * JD-Core Version:    0.7.0.1
 */