package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class cqo
  extends com.tencent.mm.bw.a
{
  public String FDD;
  public int FDE;
  public int FDF;
  public int gbd;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91673);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.FDD != null) {
        paramVarArgs.d(1, this.FDD);
      }
      paramVarArgs.aR(2, this.gbd);
      paramVarArgs.aR(3, this.FDE);
      paramVarArgs.aR(4, this.FDF);
      AppMethodBeat.o(91673);
      return 0;
    }
    if (paramInt == 1) {
      if (this.FDD == null) {
        break label350;
      }
    }
    label350:
    for (paramInt = f.a.a.b.b.a.e(1, this.FDD) + 0;; paramInt = 0)
    {
      int i = f.a.a.b.b.a.bx(2, this.gbd);
      int j = f.a.a.b.b.a.bx(3, this.FDE);
      int k = f.a.a.b.b.a.bx(4, this.FDF);
      AppMethodBeat.o(91673);
      return paramInt + i + j + k;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(91673);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        cqo localcqo = (cqo)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(91673);
          return -1;
        case 1: 
          localcqo.FDD = locala.LVo.readString();
          AppMethodBeat.o(91673);
          return 0;
        case 2: 
          localcqo.gbd = locala.LVo.xF();
          AppMethodBeat.o(91673);
          return 0;
        case 3: 
          localcqo.FDE = locala.LVo.xF();
          AppMethodBeat.o(91673);
          return 0;
        }
        localcqo.FDF = locala.LVo.xF();
        AppMethodBeat.o(91673);
        return 0;
      }
      AppMethodBeat.o(91673);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cqo
 * JD-Core Version:    0.7.0.1
 */