package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;

public final class ctx
  extends com.tencent.mm.bw.a
{
  public b GuM;
  public String HET;
  public int Hzh;
  public int nJA;
  public int qlc;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(138185);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.HET != null) {
        paramVarArgs.d(1, this.HET);
      }
      paramVarArgs.aS(2, this.nJA);
      paramVarArgs.aS(3, this.qlc);
      paramVarArgs.aS(4, this.Hzh);
      if (this.GuM != null) {
        paramVarArgs.c(5, this.GuM);
      }
      AppMethodBeat.o(138185);
      return 0;
    }
    if (paramInt == 1) {
      if (this.HET == null) {
        break label402;
      }
    }
    label402:
    for (paramInt = f.a.a.b.b.a.e(1, this.HET) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bz(2, this.nJA) + f.a.a.b.b.a.bz(3, this.qlc) + f.a.a.b.b.a.bz(4, this.Hzh);
      paramInt = i;
      if (this.GuM != null) {
        paramInt = i + f.a.a.b.b.a.b(5, this.GuM);
      }
      AppMethodBeat.o(138185);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(138185);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        ctx localctx = (ctx)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(138185);
          return -1;
        case 1: 
          localctx.HET = locala.OmT.readString();
          AppMethodBeat.o(138185);
          return 0;
        case 2: 
          localctx.nJA = locala.OmT.zc();
          AppMethodBeat.o(138185);
          return 0;
        case 3: 
          localctx.qlc = locala.OmT.zc();
          AppMethodBeat.o(138185);
          return 0;
        case 4: 
          localctx.Hzh = locala.OmT.zc();
          AppMethodBeat.o(138185);
          return 0;
        }
        localctx.GuM = locala.OmT.gCk();
        AppMethodBeat.o(138185);
        return 0;
      }
      AppMethodBeat.o(138185);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ctx
 * JD-Core Version:    0.7.0.1
 */