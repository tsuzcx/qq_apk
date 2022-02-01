package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class om
  extends com.tencent.mm.bx.a
{
  public int CMd;
  public int CMe;
  public int CMf;
  public int dtM;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91367);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aR(1, this.dtM);
      paramVarArgs.aR(2, this.CMd);
      paramVarArgs.aR(3, this.CMe);
      paramVarArgs.aR(4, this.CMf);
      AppMethodBeat.o(91367);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = f.a.a.b.b.a.bA(1, this.dtM);
      int i = f.a.a.b.b.a.bA(2, this.CMd);
      int j = f.a.a.b.b.a.bA(3, this.CMe);
      int k = f.a.a.b.b.a.bA(4, this.CMf);
      AppMethodBeat.o(91367);
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
      AppMethodBeat.o(91367);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      om localom = (om)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(91367);
        return -1;
      case 1: 
        localom.dtM = locala.KhF.xS();
        AppMethodBeat.o(91367);
        return 0;
      case 2: 
        localom.CMd = locala.KhF.xS();
        AppMethodBeat.o(91367);
        return 0;
      case 3: 
        localom.CMe = locala.KhF.xS();
        AppMethodBeat.o(91367);
        return 0;
      }
      localom.CMf = locala.KhF.xS();
      AppMethodBeat.o(91367);
      return 0;
    }
    AppMethodBeat.o(91367);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.om
 * JD-Core Version:    0.7.0.1
 */