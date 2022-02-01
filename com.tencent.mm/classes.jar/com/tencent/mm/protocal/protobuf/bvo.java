package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bvo
  extends com.tencent.mm.bx.a
{
  public String GPK;
  public int end;
  public int start;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(192557);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.GPK != null) {
        paramVarArgs.d(1, this.GPK);
      }
      paramVarArgs.aS(2, this.start);
      paramVarArgs.aS(3, this.end);
      AppMethodBeat.o(192557);
      return 0;
    }
    if (paramInt == 1) {
      if (this.GPK == null) {
        break label306;
      }
    }
    label306:
    for (paramInt = f.a.a.b.b.a.e(1, this.GPK) + 0;; paramInt = 0)
    {
      int i = f.a.a.b.b.a.bz(2, this.start);
      int j = f.a.a.b.b.a.bz(3, this.end);
      AppMethodBeat.o(192557);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(192557);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        bvo localbvo = (bvo)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(192557);
          return -1;
        case 1: 
          localbvo.GPK = locala.NPN.readString();
          AppMethodBeat.o(192557);
          return 0;
        case 2: 
          localbvo.start = locala.NPN.zc();
          AppMethodBeat.o(192557);
          return 0;
        }
        localbvo.end = locala.NPN.zc();
        AppMethodBeat.o(192557);
        return 0;
      }
      AppMethodBeat.o(192557);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bvo
 * JD-Core Version:    0.7.0.1
 */