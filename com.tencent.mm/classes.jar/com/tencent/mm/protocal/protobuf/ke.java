package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ke
  extends com.tencent.mm.bv.a
{
  public int CreateTime;
  public int jKs;
  public int woF;
  public int wxe;
  public int wxf;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(151361);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aO(1, this.wxe);
      paramVarArgs.aO(2, this.CreateTime);
      paramVarArgs.aO(3, this.woF);
      paramVarArgs.aO(4, this.jKs);
      paramVarArgs.aO(5, this.wxf);
      AppMethodBeat.o(151361);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = e.a.a.b.b.a.bl(1, this.wxe);
      int i = e.a.a.b.b.a.bl(2, this.CreateTime);
      int j = e.a.a.b.b.a.bl(3, this.woF);
      int k = e.a.a.b.b.a.bl(4, this.jKs);
      int m = e.a.a.b.b.a.bl(5, this.wxf);
      AppMethodBeat.o(151361);
      return paramInt + 0 + i + j + k + m;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.eqQ();
        }
      }
      AppMethodBeat.o(151361);
      return 0;
    }
    if (paramInt == 3)
    {
      e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
      ke localke = (ke)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(151361);
        return -1;
      case 1: 
        localke.wxe = locala.CLY.sl();
        AppMethodBeat.o(151361);
        return 0;
      case 2: 
        localke.CreateTime = locala.CLY.sl();
        AppMethodBeat.o(151361);
        return 0;
      case 3: 
        localke.woF = locala.CLY.sl();
        AppMethodBeat.o(151361);
        return 0;
      case 4: 
        localke.jKs = locala.CLY.sl();
        AppMethodBeat.o(151361);
        return 0;
      }
      localke.wxf = locala.CLY.sl();
      AppMethodBeat.o(151361);
      return 0;
    }
    AppMethodBeat.o(151361);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ke
 * JD-Core Version:    0.7.0.1
 */