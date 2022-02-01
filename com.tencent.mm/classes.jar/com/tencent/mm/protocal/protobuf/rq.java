package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class rq
  extends com.tencent.mm.bx.a
{
  public String CSs;
  public long CSt;
  public int CSu;
  public int Cxn;
  public int mBi;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(93332);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.CSs != null) {
        paramVarArgs.d(1, this.CSs);
      }
      paramVarArgs.aG(2, this.CSt);
      paramVarArgs.aR(3, this.CSu);
      paramVarArgs.aR(4, this.Cxn);
      paramVarArgs.aR(5, this.mBi);
      AppMethodBeat.o(93332);
      return 0;
    }
    if (paramInt == 1) {
      if (this.CSs == null) {
        break label398;
      }
    }
    label398:
    for (paramInt = f.a.a.b.b.a.e(1, this.CSs) + 0;; paramInt = 0)
    {
      int i = f.a.a.b.b.a.q(2, this.CSt);
      int j = f.a.a.b.b.a.bA(3, this.CSu);
      int k = f.a.a.b.b.a.bA(4, this.Cxn);
      int m = f.a.a.b.b.a.bA(5, this.mBi);
      AppMethodBeat.o(93332);
      return paramInt + i + j + k + m;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(93332);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        rq localrq = (rq)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(93332);
          return -1;
        case 1: 
          localrq.CSs = locala.KhF.readString();
          AppMethodBeat.o(93332);
          return 0;
        case 2: 
          localrq.CSt = locala.KhF.xT();
          AppMethodBeat.o(93332);
          return 0;
        case 3: 
          localrq.CSu = locala.KhF.xS();
          AppMethodBeat.o(93332);
          return 0;
        case 4: 
          localrq.Cxn = locala.KhF.xS();
          AppMethodBeat.o(93332);
          return 0;
        }
        localrq.mBi = locala.KhF.xS();
        AppMethodBeat.o(93332);
        return 0;
      }
      AppMethodBeat.o(93332);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.rq
 * JD-Core Version:    0.7.0.1
 */