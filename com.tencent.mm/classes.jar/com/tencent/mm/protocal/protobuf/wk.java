package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class wk
  extends com.tencent.mm.bx.a
{
  public String FVK;
  public String FVL;
  public String FVM;
  public int FVN;
  public int FVO;
  public String FVP;
  public int FVQ;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(127444);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.FVK != null) {
        paramVarArgs.d(1, this.FVK);
      }
      if (this.FVL != null) {
        paramVarArgs.d(2, this.FVL);
      }
      if (this.FVM != null) {
        paramVarArgs.d(3, this.FVM);
      }
      paramVarArgs.aS(4, this.FVN);
      paramVarArgs.aS(5, this.FVO);
      if (this.FVP != null) {
        paramVarArgs.d(6, this.FVP);
      }
      paramVarArgs.aS(7, this.FVQ);
      AppMethodBeat.o(127444);
      return 0;
    }
    if (paramInt == 1) {
      if (this.FVK == null) {
        break label530;
      }
    }
    label530:
    for (int i = f.a.a.b.b.a.e(1, this.FVK) + 0;; i = 0)
    {
      paramInt = i;
      if (this.FVL != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.FVL);
      }
      i = paramInt;
      if (this.FVM != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.FVM);
      }
      i = i + f.a.a.b.b.a.bz(4, this.FVN) + f.a.a.b.b.a.bz(5, this.FVO);
      paramInt = i;
      if (this.FVP != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.FVP);
      }
      i = f.a.a.b.b.a.bz(7, this.FVQ);
      AppMethodBeat.o(127444);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(127444);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        wk localwk = (wk)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(127444);
          return -1;
        case 1: 
          localwk.FVK = locala.NPN.readString();
          AppMethodBeat.o(127444);
          return 0;
        case 2: 
          localwk.FVL = locala.NPN.readString();
          AppMethodBeat.o(127444);
          return 0;
        case 3: 
          localwk.FVM = locala.NPN.readString();
          AppMethodBeat.o(127444);
          return 0;
        case 4: 
          localwk.FVN = locala.NPN.zc();
          AppMethodBeat.o(127444);
          return 0;
        case 5: 
          localwk.FVO = locala.NPN.zc();
          AppMethodBeat.o(127444);
          return 0;
        case 6: 
          localwk.FVP = locala.NPN.readString();
          AppMethodBeat.o(127444);
          return 0;
        }
        localwk.FVQ = locala.NPN.zc();
        AppMethodBeat.o(127444);
        return 0;
      }
      AppMethodBeat.o(127444);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.wk
 * JD-Core Version:    0.7.0.1
 */