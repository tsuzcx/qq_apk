package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class fq
  extends com.tencent.mm.bw.a
{
  public int DSL;
  public String DSM;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(123542);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aR(1, this.DSL);
      if (this.DSM != null) {
        paramVarArgs.d(2, this.DSM);
      }
      AppMethodBeat.o(123542);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bx(1, this.DSL) + 0;
      paramInt = i;
      if (this.DSM != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.DSM);
      }
      AppMethodBeat.o(123542);
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
      AppMethodBeat.o(123542);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      fq localfq = (fq)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(123542);
        return -1;
      case 1: 
        localfq.DSL = locala.LVo.xF();
        AppMethodBeat.o(123542);
        return 0;
      }
      localfq.DSM = locala.LVo.readString();
      AppMethodBeat.o(123542);
      return 0;
    }
    AppMethodBeat.o(123542);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fq
 * JD-Core Version:    0.7.0.1
 */