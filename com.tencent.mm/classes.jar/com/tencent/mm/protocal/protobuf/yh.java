package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class yh
  extends com.tencent.mm.bv.a
{
  public int eoD;
  public int eoE;
  public int fps;
  public int height;
  public int rotate;
  public int wPu;
  public int width;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(145886);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aO(1, this.eoD);
      paramVarArgs.aO(2, this.fps);
      paramVarArgs.aO(3, this.eoE);
      paramVarArgs.aO(4, this.wPu);
      paramVarArgs.aO(5, this.rotate);
      paramVarArgs.aO(6, this.width);
      paramVarArgs.aO(7, this.height);
      AppMethodBeat.o(145886);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = e.a.a.b.b.a.bl(1, this.eoD);
      int i = e.a.a.b.b.a.bl(2, this.fps);
      int j = e.a.a.b.b.a.bl(3, this.eoE);
      int k = e.a.a.b.b.a.bl(4, this.wPu);
      int m = e.a.a.b.b.a.bl(5, this.rotate);
      int n = e.a.a.b.b.a.bl(6, this.width);
      int i1 = e.a.a.b.b.a.bl(7, this.height);
      AppMethodBeat.o(145886);
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
      AppMethodBeat.o(145886);
      return 0;
    }
    if (paramInt == 3)
    {
      e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
      yh localyh = (yh)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(145886);
        return -1;
      case 1: 
        localyh.eoD = locala.CLY.sl();
        AppMethodBeat.o(145886);
        return 0;
      case 2: 
        localyh.fps = locala.CLY.sl();
        AppMethodBeat.o(145886);
        return 0;
      case 3: 
        localyh.eoE = locala.CLY.sl();
        AppMethodBeat.o(145886);
        return 0;
      case 4: 
        localyh.wPu = locala.CLY.sl();
        AppMethodBeat.o(145886);
        return 0;
      case 5: 
        localyh.rotate = locala.CLY.sl();
        AppMethodBeat.o(145886);
        return 0;
      case 6: 
        localyh.width = locala.CLY.sl();
        AppMethodBeat.o(145886);
        return 0;
      }
      localyh.height = locala.CLY.sl();
      AppMethodBeat.o(145886);
      return 0;
    }
    AppMethodBeat.o(145886);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.yh
 * JD-Core Version:    0.7.0.1
 */