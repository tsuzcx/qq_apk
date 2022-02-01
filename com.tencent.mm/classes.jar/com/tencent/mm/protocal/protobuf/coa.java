package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;

public final class coa
  extends com.tencent.mm.bw.a
{
  public b EuL;
  public String FBg;
  public int FvC;
  public int ndI;
  public int pAS;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(138185);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.FBg != null) {
        paramVarArgs.d(1, this.FBg);
      }
      paramVarArgs.aR(2, this.ndI);
      paramVarArgs.aR(3, this.pAS);
      paramVarArgs.aR(4, this.FvC);
      if (this.EuL != null) {
        paramVarArgs.c(5, this.EuL);
      }
      AppMethodBeat.o(138185);
      return 0;
    }
    if (paramInt == 1) {
      if (this.FBg == null) {
        break label402;
      }
    }
    label402:
    for (paramInt = f.a.a.b.b.a.e(1, this.FBg) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bx(2, this.ndI) + f.a.a.b.b.a.bx(3, this.pAS) + f.a.a.b.b.a.bx(4, this.FvC);
      paramInt = i;
      if (this.EuL != null) {
        paramInt = i + f.a.a.b.b.a.b(5, this.EuL);
      }
      AppMethodBeat.o(138185);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(138185);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        coa localcoa = (coa)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(138185);
          return -1;
        case 1: 
          localcoa.FBg = locala.LVo.readString();
          AppMethodBeat.o(138185);
          return 0;
        case 2: 
          localcoa.ndI = locala.LVo.xF();
          AppMethodBeat.o(138185);
          return 0;
        case 3: 
          localcoa.pAS = locala.LVo.xF();
          AppMethodBeat.o(138185);
          return 0;
        case 4: 
          localcoa.FvC = locala.LVo.xF();
          AppMethodBeat.o(138185);
          return 0;
        }
        localcoa.EuL = locala.LVo.gfk();
        AppMethodBeat.o(138185);
        return 0;
      }
      AppMethodBeat.o(138185);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.coa
 * JD-Core Version:    0.7.0.1
 */