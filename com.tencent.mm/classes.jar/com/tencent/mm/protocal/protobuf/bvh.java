package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bvh
  extends com.tencent.mm.bv.a
{
  public int vNt;
  public int xCa;
  public int xIV;
  public int xIX;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(80166);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aO(1, this.xCa);
      paramVarArgs.aO(2, this.xIX);
      paramVarArgs.aO(3, this.xIV);
      paramVarArgs.aO(4, this.vNt);
      AppMethodBeat.o(80166);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = e.a.a.b.b.a.bl(1, this.xCa);
      int i = e.a.a.b.b.a.bl(2, this.xIX);
      int j = e.a.a.b.b.a.bl(3, this.xIV);
      int k = e.a.a.b.b.a.bl(4, this.vNt);
      AppMethodBeat.o(80166);
      return paramInt + 0 + i + j + k;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.eqQ();
        }
      }
      AppMethodBeat.o(80166);
      return 0;
    }
    if (paramInt == 3)
    {
      e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
      bvh localbvh = (bvh)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(80166);
        return -1;
      case 1: 
        localbvh.xCa = locala.CLY.sl();
        AppMethodBeat.o(80166);
        return 0;
      case 2: 
        localbvh.xIX = locala.CLY.sl();
        AppMethodBeat.o(80166);
        return 0;
      case 3: 
        localbvh.xIV = locala.CLY.sl();
        AppMethodBeat.o(80166);
        return 0;
      }
      localbvh.vNt = locala.CLY.sl();
      AppMethodBeat.o(80166);
      return 0;
    }
    AppMethodBeat.o(80166);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bvh
 * JD-Core Version:    0.7.0.1
 */