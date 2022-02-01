package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class cci
  extends com.tencent.mm.bw.a
{
  public int FqQ;
  public String FqR;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32367);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aR(1, this.FqQ);
      if (this.FqR != null) {
        paramVarArgs.d(2, this.FqR);
      }
      AppMethodBeat.o(32367);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bx(1, this.FqQ) + 0;
      paramInt = i;
      if (this.FqR != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.FqR);
      }
      AppMethodBeat.o(32367);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gfg();
        }
      }
      AppMethodBeat.o(32367);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      cci localcci = (cci)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(32367);
        return -1;
      case 1: 
        localcci.FqQ = locala.LVo.xF();
        AppMethodBeat.o(32367);
        return 0;
      }
      localcci.FqR = locala.LVo.readString();
      AppMethodBeat.o(32367);
      return 0;
    }
    AppMethodBeat.o(32367);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cci
 * JD-Core Version:    0.7.0.1
 */