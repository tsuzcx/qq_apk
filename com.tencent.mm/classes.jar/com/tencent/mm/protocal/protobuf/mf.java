package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class mf
  extends com.tencent.mm.bx.a
{
  public String CIR;
  public String nvC;
  public int ver;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(124418);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.CIR != null) {
        paramVarArgs.d(1, this.CIR);
      }
      if (this.nvC != null) {
        paramVarArgs.d(2, this.nvC);
      }
      paramVarArgs.aR(3, this.ver);
      AppMethodBeat.o(124418);
      return 0;
    }
    if (paramInt == 1) {
      if (this.CIR == null) {
        break label318;
      }
    }
    label318:
    for (paramInt = f.a.a.b.b.a.e(1, this.CIR) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.nvC != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.nvC);
      }
      paramInt = f.a.a.b.b.a.bA(3, this.ver);
      AppMethodBeat.o(124418);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(124418);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        mf localmf = (mf)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(124418);
          return -1;
        case 1: 
          localmf.CIR = locala.KhF.readString();
          AppMethodBeat.o(124418);
          return 0;
        case 2: 
          localmf.nvC = locala.KhF.readString();
          AppMethodBeat.o(124418);
          return 0;
        }
        localmf.ver = locala.KhF.xS();
        AppMethodBeat.o(124418);
        return 0;
      }
      AppMethodBeat.o(124418);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.mf
 * JD-Core Version:    0.7.0.1
 */