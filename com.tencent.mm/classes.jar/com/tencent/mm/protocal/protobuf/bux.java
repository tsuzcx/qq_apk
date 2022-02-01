package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bux
  extends com.tencent.mm.bw.a
{
  public String DPx;
  public int FkC;
  public String ncR;
  public int wTE;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(101826);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.DPx != null) {
        paramVarArgs.d(1, this.DPx);
      }
      if (this.ncR != null) {
        paramVarArgs.d(2, this.ncR);
      }
      paramVarArgs.aR(3, this.FkC);
      paramVarArgs.aR(4, this.wTE);
      AppMethodBeat.o(101826);
      return 0;
    }
    if (paramInt == 1) {
      if (this.DPx == null) {
        break label366;
      }
    }
    label366:
    for (paramInt = f.a.a.b.b.a.e(1, this.DPx) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.ncR != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.ncR);
      }
      paramInt = f.a.a.b.b.a.bx(3, this.FkC);
      int j = f.a.a.b.b.a.bx(4, this.wTE);
      AppMethodBeat.o(101826);
      return i + paramInt + j;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(101826);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        bux localbux = (bux)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(101826);
          return -1;
        case 1: 
          localbux.DPx = locala.LVo.readString();
          AppMethodBeat.o(101826);
          return 0;
        case 2: 
          localbux.ncR = locala.LVo.readString();
          AppMethodBeat.o(101826);
          return 0;
        case 3: 
          localbux.FkC = locala.LVo.xF();
          AppMethodBeat.o(101826);
          return 0;
        }
        localbux.wTE = locala.LVo.xF();
        AppMethodBeat.o(101826);
        return 0;
      }
      AppMethodBeat.o(101826);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bux
 * JD-Core Version:    0.7.0.1
 */