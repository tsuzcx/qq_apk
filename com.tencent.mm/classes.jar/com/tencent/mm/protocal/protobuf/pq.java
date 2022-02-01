package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class pq
  extends com.tencent.mm.bx.a
{
  public String FKK;
  public String FKL;
  public String Url;
  public int nEf;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(152989);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.FKK != null) {
        paramVarArgs.d(1, this.FKK);
      }
      if (this.FKL != null) {
        paramVarArgs.d(2, this.FKL);
      }
      if (this.Url != null) {
        paramVarArgs.d(3, this.Url);
      }
      paramVarArgs.aS(4, this.nEf);
      AppMethodBeat.o(152989);
      return 0;
    }
    if (paramInt == 1) {
      if (this.FKK == null) {
        break label378;
      }
    }
    label378:
    for (int i = f.a.a.b.b.a.e(1, this.FKK) + 0;; i = 0)
    {
      paramInt = i;
      if (this.FKL != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.FKL);
      }
      i = paramInt;
      if (this.Url != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.Url);
      }
      paramInt = f.a.a.b.b.a.bz(4, this.nEf);
      AppMethodBeat.o(152989);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(152989);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        pq localpq = (pq)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(152989);
          return -1;
        case 1: 
          localpq.FKK = locala.NPN.readString();
          AppMethodBeat.o(152989);
          return 0;
        case 2: 
          localpq.FKL = locala.NPN.readString();
          AppMethodBeat.o(152989);
          return 0;
        case 3: 
          localpq.Url = locala.NPN.readString();
          AppMethodBeat.o(152989);
          return 0;
        }
        localpq.nEf = locala.NPN.zc();
        AppMethodBeat.o(152989);
        return 0;
      }
      AppMethodBeat.o(152989);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.pq
 * JD-Core Version:    0.7.0.1
 */