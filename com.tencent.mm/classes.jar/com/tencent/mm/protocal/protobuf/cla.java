package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class cla
  extends com.tencent.mm.bx.a
{
  public int BSu;
  public int DYI;
  public int Egv;
  public int Egx;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(152672);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aR(1, this.DYI);
      paramVarArgs.aR(2, this.Egx);
      paramVarArgs.aR(3, this.Egv);
      paramVarArgs.aR(4, this.BSu);
      AppMethodBeat.o(152672);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = f.a.a.b.b.a.bA(1, this.DYI);
      int i = f.a.a.b.b.a.bA(2, this.Egx);
      int j = f.a.a.b.b.a.bA(3, this.Egv);
      int k = f.a.a.b.b.a.bA(4, this.BSu);
      AppMethodBeat.o(152672);
      return paramInt + 0 + i + j + k;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.fMq();
        }
      }
      AppMethodBeat.o(152672);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      cla localcla = (cla)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(152672);
        return -1;
      case 1: 
        localcla.DYI = locala.KhF.xS();
        AppMethodBeat.o(152672);
        return 0;
      case 2: 
        localcla.Egx = locala.KhF.xS();
        AppMethodBeat.o(152672);
        return 0;
      case 3: 
        localcla.Egv = locala.KhF.xS();
        AppMethodBeat.o(152672);
        return 0;
      }
      localcla.BSu = locala.KhF.xS();
      AppMethodBeat.o(152672);
      return 0;
    }
    AppMethodBeat.o(152672);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cla
 * JD-Core Version:    0.7.0.1
 */