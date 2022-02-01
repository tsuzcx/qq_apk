package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class lp
  extends com.tencent.mm.bw.a
{
  public int DZr;
  public String DZs;
  public int DZt;
  public int DZu;
  public String ncR;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(124393);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.ncR != null) {
        paramVarArgs.d(1, this.ncR);
      }
      paramVarArgs.aR(2, this.DZr);
      if (this.DZs != null) {
        paramVarArgs.d(3, this.DZs);
      }
      paramVarArgs.aR(4, this.DZt);
      paramVarArgs.aR(5, this.DZu);
      AppMethodBeat.o(124393);
      return 0;
    }
    if (paramInt == 1) {
      if (this.ncR == null) {
        break label410;
      }
    }
    label410:
    for (paramInt = f.a.a.b.b.a.e(1, this.ncR) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bx(2, this.DZr);
      paramInt = i;
      if (this.DZs != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.DZs);
      }
      i = f.a.a.b.b.a.bx(4, this.DZt);
      int j = f.a.a.b.b.a.bx(5, this.DZu);
      AppMethodBeat.o(124393);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(124393);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        lp locallp = (lp)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(124393);
          return -1;
        case 1: 
          locallp.ncR = locala.LVo.readString();
          AppMethodBeat.o(124393);
          return 0;
        case 2: 
          locallp.DZr = locala.LVo.xF();
          AppMethodBeat.o(124393);
          return 0;
        case 3: 
          locallp.DZs = locala.LVo.readString();
          AppMethodBeat.o(124393);
          return 0;
        case 4: 
          locallp.DZt = locala.LVo.xF();
          AppMethodBeat.o(124393);
          return 0;
        }
        locallp.DZu = locala.LVo.xF();
        AppMethodBeat.o(124393);
        return 0;
      }
      AppMethodBeat.o(124393);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.lp
 * JD-Core Version:    0.7.0.1
 */