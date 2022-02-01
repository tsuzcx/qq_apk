package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ehj
  extends com.tencent.mm.bx.a
{
  public int GKV;
  public String GLe;
  public String HSd;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(123706);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.GLe != null) {
        paramVarArgs.d(1, this.GLe);
      }
      paramVarArgs.aS(2, this.GKV);
      if (this.HSd != null) {
        paramVarArgs.d(3, this.HSd);
      }
      AppMethodBeat.o(123706);
      return 0;
    }
    if (paramInt == 1) {
      if (this.GLe == null) {
        break label318;
      }
    }
    label318:
    for (paramInt = f.a.a.b.b.a.e(1, this.GLe) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bz(2, this.GKV);
      paramInt = i;
      if (this.HSd != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.HSd);
      }
      AppMethodBeat.o(123706);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(123706);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        ehj localehj = (ehj)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(123706);
          return -1;
        case 1: 
          localehj.GLe = locala.NPN.readString();
          AppMethodBeat.o(123706);
          return 0;
        case 2: 
          localehj.GKV = locala.NPN.zc();
          AppMethodBeat.o(123706);
          return 0;
        }
        localehj.HSd = locala.NPN.readString();
        AppMethodBeat.o(123706);
        return 0;
      }
      AppMethodBeat.o(123706);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ehj
 * JD-Core Version:    0.7.0.1
 */