package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dbt
  extends com.tencent.mm.bv.a
{
  public int Scene;
  public int wwX;
  public int xmQ;
  public int yhX;
  public int yhY;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(96348);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aO(1, this.xmQ);
      paramVarArgs.aO(2, this.wwX);
      paramVarArgs.aO(3, this.yhX);
      paramVarArgs.aO(4, this.Scene);
      paramVarArgs.aO(10, this.yhY);
      AppMethodBeat.o(96348);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = e.a.a.b.b.a.bl(1, this.xmQ);
      int i = e.a.a.b.b.a.bl(2, this.wwX);
      int j = e.a.a.b.b.a.bl(3, this.yhX);
      int k = e.a.a.b.b.a.bl(4, this.Scene);
      int m = e.a.a.b.b.a.bl(10, this.yhY);
      AppMethodBeat.o(96348);
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
      AppMethodBeat.o(96348);
      return 0;
    }
    if (paramInt == 3)
    {
      e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
      dbt localdbt = (dbt)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      case 5: 
      case 6: 
      case 7: 
      case 8: 
      case 9: 
      default: 
        AppMethodBeat.o(96348);
        return -1;
      case 1: 
        localdbt.xmQ = locala.CLY.sl();
        AppMethodBeat.o(96348);
        return 0;
      case 2: 
        localdbt.wwX = locala.CLY.sl();
        AppMethodBeat.o(96348);
        return 0;
      case 3: 
        localdbt.yhX = locala.CLY.sl();
        AppMethodBeat.o(96348);
        return 0;
      case 4: 
        localdbt.Scene = locala.CLY.sl();
        AppMethodBeat.o(96348);
        return 0;
      }
      localdbt.yhY = locala.CLY.sl();
      AppMethodBeat.o(96348);
      return 0;
    }
    AppMethodBeat.o(96348);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dbt
 * JD-Core Version:    0.7.0.1
 */