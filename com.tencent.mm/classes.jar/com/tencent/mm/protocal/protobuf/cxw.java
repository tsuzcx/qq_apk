package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class cxw
  extends com.tencent.mm.bw.a
{
  public int EdN;
  public String dvO;
  public int nYh;
  public long seq;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(114074);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.dvO != null) {
        paramVarArgs.d(1, this.dvO);
      }
      paramVarArgs.aR(2, this.nYh);
      paramVarArgs.aR(3, this.EdN);
      paramVarArgs.aO(4, this.seq);
      AppMethodBeat.o(114074);
      return 0;
    }
    if (paramInt == 1) {
      if (this.dvO == null) {
        break label350;
      }
    }
    label350:
    for (paramInt = f.a.a.b.b.a.e(1, this.dvO) + 0;; paramInt = 0)
    {
      int i = f.a.a.b.b.a.bx(2, this.nYh);
      int j = f.a.a.b.b.a.bx(3, this.EdN);
      int k = f.a.a.b.b.a.p(4, this.seq);
      AppMethodBeat.o(114074);
      return paramInt + i + j + k;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(114074);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        cxw localcxw = (cxw)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(114074);
          return -1;
        case 1: 
          localcxw.dvO = locala.LVo.readString();
          AppMethodBeat.o(114074);
          return 0;
        case 2: 
          localcxw.nYh = locala.LVo.xF();
          AppMethodBeat.o(114074);
          return 0;
        case 3: 
          localcxw.EdN = locala.LVo.xF();
          AppMethodBeat.o(114074);
          return 0;
        }
        localcxw.seq = locala.LVo.xG();
        AppMethodBeat.o(114074);
        return 0;
      }
      AppMethodBeat.o(114074);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cxw
 * JD-Core Version:    0.7.0.1
 */