package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class deg
  extends com.tencent.mm.bx.a
{
  public int FFN;
  public int GLq;
  public String username;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(153304);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.username != null) {
        paramVarArgs.d(1, this.username);
      }
      paramVarArgs.aS(2, this.GLq);
      paramVarArgs.aS(3, this.FFN);
      AppMethodBeat.o(153304);
      return 0;
    }
    if (paramInt == 1) {
      if (this.username == null) {
        break label306;
      }
    }
    label306:
    for (paramInt = f.a.a.b.b.a.e(1, this.username) + 0;; paramInt = 0)
    {
      int i = f.a.a.b.b.a.bz(2, this.GLq);
      int j = f.a.a.b.b.a.bz(3, this.FFN);
      AppMethodBeat.o(153304);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(153304);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        deg localdeg = (deg)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(153304);
          return -1;
        case 1: 
          localdeg.username = locala.NPN.readString();
          AppMethodBeat.o(153304);
          return 0;
        case 2: 
          localdeg.GLq = locala.NPN.zc();
          AppMethodBeat.o(153304);
          return 0;
        }
        localdeg.FFN = locala.NPN.zc();
        AppMethodBeat.o(153304);
        return 0;
      }
      AppMethodBeat.o(153304);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.deg
 * JD-Core Version:    0.7.0.1
 */