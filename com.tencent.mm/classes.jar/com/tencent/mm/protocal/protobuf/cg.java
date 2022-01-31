package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class cg
  extends com.tencent.mm.bv.a
{
  public int jKs;
  public int woD;
  public int woE;
  public int woF;
  public int woG;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(51362);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aO(1, this.woD);
      paramVarArgs.aO(2, this.jKs);
      paramVarArgs.aO(3, this.woE);
      paramVarArgs.aO(4, this.woF);
      paramVarArgs.aO(5, this.woG);
      AppMethodBeat.o(51362);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = e.a.a.b.b.a.bl(1, this.woD);
      int i = e.a.a.b.b.a.bl(2, this.jKs);
      int j = e.a.a.b.b.a.bl(3, this.woE);
      int k = e.a.a.b.b.a.bl(4, this.woF);
      int m = e.a.a.b.b.a.bl(5, this.woG);
      AppMethodBeat.o(51362);
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
      AppMethodBeat.o(51362);
      return 0;
    }
    if (paramInt == 3)
    {
      e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
      cg localcg = (cg)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(51362);
        return -1;
      case 1: 
        localcg.woD = locala.CLY.sl();
        AppMethodBeat.o(51362);
        return 0;
      case 2: 
        localcg.jKs = locala.CLY.sl();
        AppMethodBeat.o(51362);
        return 0;
      case 3: 
        localcg.woE = locala.CLY.sl();
        AppMethodBeat.o(51362);
        return 0;
      case 4: 
        localcg.woF = locala.CLY.sl();
        AppMethodBeat.o(51362);
        return 0;
      }
      localcg.woG = locala.CLY.sl();
      AppMethodBeat.o(51362);
      return 0;
    }
    AppMethodBeat.o(51362);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cg
 * JD-Core Version:    0.7.0.1
 */