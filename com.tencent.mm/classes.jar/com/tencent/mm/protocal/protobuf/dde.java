package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;

public final class dde
  extends com.tencent.mm.bx.a
{
  public b CMO;
  public int CMP;
  public int Evk;
  public int Evl;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91718);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aR(7, this.Evk);
      if (this.CMO != null) {
        paramVarArgs.c(8, this.CMO);
      }
      paramVarArgs.aR(9, this.CMP);
      paramVarArgs.aR(10, this.Evl);
      AppMethodBeat.o(91718);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bA(7, this.Evk) + 0;
      paramInt = i;
      if (this.CMO != null) {
        paramInt = i + f.a.a.b.b.a.b(8, this.CMO);
      }
      i = f.a.a.b.b.a.bA(9, this.CMP);
      int j = f.a.a.b.b.a.bA(10, this.Evl);
      AppMethodBeat.o(91718);
      return paramInt + i + j;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.fMq();
        }
      }
      AppMethodBeat.o(91718);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      dde localdde = (dde)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(91718);
        return -1;
      case 7: 
        localdde.Evk = locala.KhF.xS();
        AppMethodBeat.o(91718);
        return 0;
      case 8: 
        localdde.CMO = locala.KhF.fMu();
        AppMethodBeat.o(91718);
        return 0;
      case 9: 
        localdde.CMP = locala.KhF.xS();
        AppMethodBeat.o(91718);
        return 0;
      }
      localdde.Evl = locala.KhF.xS();
      AppMethodBeat.o(91718);
      return 0;
    }
    AppMethodBeat.o(91718);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dde
 * JD-Core Version:    0.7.0.1
 */