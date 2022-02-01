package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bsv
  extends com.tencent.mm.bw.a
{
  public String FhN;
  public long FhP;
  public long FhQ;
  public int FhR;
  public int Scene;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(117877);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aR(1, this.Scene);
      if (this.FhN != null) {
        paramVarArgs.d(2, this.FhN);
      }
      paramVarArgs.aO(3, this.FhQ);
      paramVarArgs.aO(4, this.FhP);
      paramVarArgs.aR(5, this.FhR);
      AppMethodBeat.o(117877);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bx(1, this.Scene) + 0;
      paramInt = i;
      if (this.FhN != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.FhN);
      }
      i = f.a.a.b.b.a.p(3, this.FhQ);
      int j = f.a.a.b.b.a.p(4, this.FhP);
      int k = f.a.a.b.b.a.bx(5, this.FhR);
      AppMethodBeat.o(117877);
      return paramInt + i + j + k;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gfg();
        }
      }
      AppMethodBeat.o(117877);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      bsv localbsv = (bsv)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(117877);
        return -1;
      case 1: 
        localbsv.Scene = locala.LVo.xF();
        AppMethodBeat.o(117877);
        return 0;
      case 2: 
        localbsv.FhN = locala.LVo.readString();
        AppMethodBeat.o(117877);
        return 0;
      case 3: 
        localbsv.FhQ = locala.LVo.xG();
        AppMethodBeat.o(117877);
        return 0;
      case 4: 
        localbsv.FhP = locala.LVo.xG();
        AppMethodBeat.o(117877);
        return 0;
      }
      localbsv.FhR = locala.LVo.xF();
      AppMethodBeat.o(117877);
      return 0;
    }
    AppMethodBeat.o(117877);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bsv
 * JD-Core Version:    0.7.0.1
 */