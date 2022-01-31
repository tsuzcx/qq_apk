package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class je
  extends com.tencent.mm.bv.a
{
  public int wur;
  public int wvf;
  public int wvg;
  public int wvh;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(28341);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aO(1, this.wur);
      paramVarArgs.aO(2, this.wvf);
      paramVarArgs.aO(3, this.wvg);
      paramVarArgs.aO(4, this.wvh);
      AppMethodBeat.o(28341);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = e.a.a.b.b.a.bl(1, this.wur);
      int i = e.a.a.b.b.a.bl(2, this.wvf);
      int j = e.a.a.b.b.a.bl(3, this.wvg);
      int k = e.a.a.b.b.a.bl(4, this.wvh);
      AppMethodBeat.o(28341);
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
      AppMethodBeat.o(28341);
      return 0;
    }
    if (paramInt == 3)
    {
      e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
      je localje = (je)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(28341);
        return -1;
      case 1: 
        localje.wur = locala.CLY.sl();
        AppMethodBeat.o(28341);
        return 0;
      case 2: 
        localje.wvf = locala.CLY.sl();
        AppMethodBeat.o(28341);
        return 0;
      case 3: 
        localje.wvg = locala.CLY.sl();
        AppMethodBeat.o(28341);
        return 0;
      }
      localje.wvh = locala.CLY.sl();
      AppMethodBeat.o(28341);
      return 0;
    }
    AppMethodBeat.o(28341);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.je
 * JD-Core Version:    0.7.0.1
 */