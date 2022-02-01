package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ara
  extends com.tencent.mm.bw.a
{
  public String Ewu;
  public int ndI;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(191068);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aR(1, this.ndI);
      if (this.Ewu != null) {
        paramVarArgs.d(2, this.Ewu);
      }
      AppMethodBeat.o(191068);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bx(1, this.ndI) + 0;
      paramInt = i;
      if (this.Ewu != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.Ewu);
      }
      AppMethodBeat.o(191068);
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
      AppMethodBeat.o(191068);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      ara localara = (ara)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(191068);
        return -1;
      case 1: 
        localara.ndI = locala.LVo.xF();
        AppMethodBeat.o(191068);
        return 0;
      }
      localara.Ewu = locala.LVo.readString();
      AppMethodBeat.o(191068);
      return 0;
    }
    AppMethodBeat.o(191068);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ara
 * JD-Core Version:    0.7.0.1
 */