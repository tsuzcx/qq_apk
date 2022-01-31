package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class kh
  extends com.tencent.mm.bv.a
{
  public int enabled;
  public int wqI;
  public int wxH;
  public int wxI;
  public int wxJ;
  public int wxK;
  public int wxL;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(14711);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aO(1, this.enabled);
      paramVarArgs.aO(2, this.wxH);
      paramVarArgs.aO(3, this.wxI);
      paramVarArgs.aO(4, this.wxJ);
      paramVarArgs.aO(5, this.wxK);
      paramVarArgs.aO(6, this.wxL);
      paramVarArgs.aO(7, this.wqI);
      AppMethodBeat.o(14711);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = e.a.a.b.b.a.bl(1, this.enabled);
      int i = e.a.a.b.b.a.bl(2, this.wxH);
      int j = e.a.a.b.b.a.bl(3, this.wxI);
      int k = e.a.a.b.b.a.bl(4, this.wxJ);
      int m = e.a.a.b.b.a.bl(5, this.wxK);
      int n = e.a.a.b.b.a.bl(6, this.wxL);
      int i1 = e.a.a.b.b.a.bl(7, this.wqI);
      AppMethodBeat.o(14711);
      return paramInt + 0 + i + j + k + m + n + i1;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.eqQ();
        }
      }
      AppMethodBeat.o(14711);
      return 0;
    }
    if (paramInt == 3)
    {
      e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
      kh localkh = (kh)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(14711);
        return -1;
      case 1: 
        localkh.enabled = locala.CLY.sl();
        AppMethodBeat.o(14711);
        return 0;
      case 2: 
        localkh.wxH = locala.CLY.sl();
        AppMethodBeat.o(14711);
        return 0;
      case 3: 
        localkh.wxI = locala.CLY.sl();
        AppMethodBeat.o(14711);
        return 0;
      case 4: 
        localkh.wxJ = locala.CLY.sl();
        AppMethodBeat.o(14711);
        return 0;
      case 5: 
        localkh.wxK = locala.CLY.sl();
        AppMethodBeat.o(14711);
        return 0;
      case 6: 
        localkh.wxL = locala.CLY.sl();
        AppMethodBeat.o(14711);
        return 0;
      }
      localkh.wqI = locala.CLY.sl();
      AppMethodBeat.o(14711);
      return 0;
    }
    AppMethodBeat.o(14711);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.kh
 * JD-Core Version:    0.7.0.1
 */