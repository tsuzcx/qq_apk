package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class cml
  extends com.tencent.mm.bw.a
{
  public int FzM;
  public String tiv;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91660);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aR(1, this.FzM);
      if (this.tiv != null) {
        paramVarArgs.d(2, this.tiv);
      }
      AppMethodBeat.o(91660);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bx(1, this.FzM) + 0;
      paramInt = i;
      if (this.tiv != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.tiv);
      }
      AppMethodBeat.o(91660);
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
      AppMethodBeat.o(91660);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      cml localcml = (cml)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(91660);
        return -1;
      case 1: 
        localcml.FzM = locala.LVo.xF();
        AppMethodBeat.o(91660);
        return 0;
      }
      localcml.tiv = locala.LVo.readString();
      AppMethodBeat.o(91660);
      return 0;
    }
    AppMethodBeat.o(91660);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cml
 * JD-Core Version:    0.7.0.1
 */