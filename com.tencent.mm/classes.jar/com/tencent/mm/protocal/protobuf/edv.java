package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class edv
  extends com.tencent.mm.bx.a
{
  public int FIg;
  public com.tencent.mm.bx.b Fyu;
  public boolean HPi;
  public boolean HPj;
  public String Hnp;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32564);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.Hnp == null)
      {
        paramVarArgs = new f.a.a.b("Not all required fields were included: Talker");
        AppMethodBeat.o(32564);
        throw paramVarArgs;
      }
      if (this.Hnp != null) {
        paramVarArgs.d(1, this.Hnp);
      }
      paramVarArgs.aS(2, this.FIg);
      if (this.Fyu != null) {
        paramVarArgs.c(3, this.Fyu);
      }
      paramVarArgs.bt(4, this.HPi);
      paramVarArgs.bt(5, this.HPj);
      AppMethodBeat.o(32564);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Hnp == null) {
        break label461;
      }
    }
    label461:
    for (paramInt = f.a.a.b.b.a.e(1, this.Hnp) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bz(2, this.FIg);
      paramInt = i;
      if (this.Fyu != null) {
        paramInt = i + f.a.a.b.b.a.b(3, this.Fyu);
      }
      i = f.a.a.b.b.a.alV(4);
      int j = f.a.a.b.b.a.alV(5);
      AppMethodBeat.o(32564);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        if (this.Hnp == null)
        {
          paramVarArgs = new f.a.a.b("Not all required fields were included: Talker");
          AppMethodBeat.o(32564);
          throw paramVarArgs;
        }
        AppMethodBeat.o(32564);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        edv localedv = (edv)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(32564);
          return -1;
        case 1: 
          localedv.Hnp = locala.NPN.readString();
          AppMethodBeat.o(32564);
          return 0;
        case 2: 
          localedv.FIg = locala.NPN.zc();
          AppMethodBeat.o(32564);
          return 0;
        case 3: 
          localedv.Fyu = locala.NPN.gxI();
          AppMethodBeat.o(32564);
          return 0;
        case 4: 
          localedv.HPi = locala.NPN.grw();
          AppMethodBeat.o(32564);
          return 0;
        }
        localedv.HPj = locala.NPN.grw();
        AppMethodBeat.o(32564);
        return 0;
      }
      AppMethodBeat.o(32564);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.edv
 * JD-Core Version:    0.7.0.1
 */