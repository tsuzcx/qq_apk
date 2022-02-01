package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bpg
  extends com.tencent.mm.bx.a
{
  public String CzY;
  public int DIe;
  public int DMN;
  public int rNT;
  public int rNz;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(125742);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aR(1, this.rNz);
      paramVarArgs.aR(2, this.rNT);
      paramVarArgs.aR(3, this.DMN);
      if (this.CzY != null) {
        paramVarArgs.d(4, this.CzY);
      }
      paramVarArgs.aR(5, this.DIe);
      AppMethodBeat.o(125742);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bA(1, this.rNz) + 0 + f.a.a.b.b.a.bA(2, this.rNT) + f.a.a.b.b.a.bA(3, this.DMN);
      paramInt = i;
      if (this.CzY != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.CzY);
      }
      i = f.a.a.b.b.a.bA(5, this.DIe);
      AppMethodBeat.o(125742);
      return paramInt + i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.fMq();
        }
      }
      AppMethodBeat.o(125742);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      bpg localbpg = (bpg)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(125742);
        return -1;
      case 1: 
        localbpg.rNz = locala.KhF.xS();
        AppMethodBeat.o(125742);
        return 0;
      case 2: 
        localbpg.rNT = locala.KhF.xS();
        AppMethodBeat.o(125742);
        return 0;
      case 3: 
        localbpg.DMN = locala.KhF.xS();
        AppMethodBeat.o(125742);
        return 0;
      case 4: 
        localbpg.CzY = locala.KhF.readString();
        AppMethodBeat.o(125742);
        return 0;
      }
      localbpg.DIe = locala.KhF.xS();
      AppMethodBeat.o(125742);
      return 0;
    }
    AppMethodBeat.o(125742);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bpg
 * JD-Core Version:    0.7.0.1
 */