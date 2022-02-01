package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bol
  extends com.tencent.mm.bw.a
{
  public String FdK;
  public int FdL;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32335);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.FdK != null) {
        paramVarArgs.d(1, this.FdK);
      }
      paramVarArgs.aR(2, this.FdL);
      AppMethodBeat.o(32335);
      return 0;
    }
    if (paramInt == 1) {
      if (this.FdK == null) {
        break label266;
      }
    }
    label266:
    for (paramInt = f.a.a.b.b.a.e(1, this.FdK) + 0;; paramInt = 0)
    {
      int i = f.a.a.b.b.a.bx(2, this.FdL);
      AppMethodBeat.o(32335);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(32335);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        bol localbol = (bol)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(32335);
          return -1;
        case 1: 
          localbol.FdK = locala.LVo.readString();
          AppMethodBeat.o(32335);
          return 0;
        }
        localbol.FdL = locala.LVo.xF();
        AppMethodBeat.o(32335);
        return 0;
      }
      AppMethodBeat.o(32335);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bol
 * JD-Core Version:    0.7.0.1
 */