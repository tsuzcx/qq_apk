package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bsr
  extends com.tencent.mm.bw.a
{
  public int FhK;
  public String FhL;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(169926);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aR(1, this.FhK);
      if (this.FhL != null) {
        paramVarArgs.d(2, this.FhL);
      }
      AppMethodBeat.o(169926);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bx(1, this.FhK) + 0;
      paramInt = i;
      if (this.FhL != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.FhL);
      }
      AppMethodBeat.o(169926);
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
      AppMethodBeat.o(169926);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      bsr localbsr = (bsr)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(169926);
        return -1;
      case 1: 
        localbsr.FhK = locala.LVo.xF();
        AppMethodBeat.o(169926);
        return 0;
      }
      localbsr.FhL = locala.LVo.readString();
      AppMethodBeat.o(169926);
      return 0;
    }
    AppMethodBeat.o(169926);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bsr
 * JD-Core Version:    0.7.0.1
 */