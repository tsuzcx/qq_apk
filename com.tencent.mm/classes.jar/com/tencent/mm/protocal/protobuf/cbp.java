package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class cbp
  extends com.tencent.mm.bw.a
{
  public int FpI;
  public int FpJ;
  public String dvO;
  public String nWk;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(114046);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.dvO != null) {
        paramVarArgs.d(1, this.dvO);
      }
      if (this.nWk != null) {
        paramVarArgs.d(2, this.nWk);
      }
      paramVarArgs.aR(3, this.FpI);
      paramVarArgs.aR(4, this.FpJ);
      AppMethodBeat.o(114046);
      return 0;
    }
    if (paramInt == 1) {
      if (this.dvO == null) {
        break label366;
      }
    }
    label366:
    for (paramInt = f.a.a.b.b.a.e(1, this.dvO) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.nWk != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.nWk);
      }
      paramInt = f.a.a.b.b.a.bx(3, this.FpI);
      int j = f.a.a.b.b.a.bx(4, this.FpJ);
      AppMethodBeat.o(114046);
      return i + paramInt + j;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(114046);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        cbp localcbp = (cbp)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(114046);
          return -1;
        case 1: 
          localcbp.dvO = locala.LVo.readString();
          AppMethodBeat.o(114046);
          return 0;
        case 2: 
          localcbp.nWk = locala.LVo.readString();
          AppMethodBeat.o(114046);
          return 0;
        case 3: 
          localcbp.FpI = locala.LVo.xF();
          AppMethodBeat.o(114046);
          return 0;
        }
        localcbp.FpJ = locala.LVo.xF();
        AppMethodBeat.o(114046);
        return 0;
      }
      AppMethodBeat.o(114046);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cbp
 * JD-Core Version:    0.7.0.1
 */