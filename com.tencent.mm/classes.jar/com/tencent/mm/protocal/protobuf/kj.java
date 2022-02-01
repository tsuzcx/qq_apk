package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class kj
  extends com.tencent.mm.bx.a
{
  public String FCL;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(82387);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.FCL != null) {
        paramVarArgs.d(1, this.FCL);
      }
      AppMethodBeat.o(82387);
      return 0;
    }
    if (paramInt == 1) {
      if (this.FCL == null) {
        break label213;
      }
    }
    label213:
    for (paramInt = f.a.a.b.b.a.e(1, this.FCL) + 0;; paramInt = 0)
    {
      AppMethodBeat.o(82387);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(82387);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        kj localkj = (kj)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(82387);
          return -1;
        }
        localkj.FCL = locala.NPN.readString();
        AppMethodBeat.o(82387);
        return 0;
      }
      AppMethodBeat.o(82387);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.kj
 * JD-Core Version:    0.7.0.1
 */