package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class doj
  extends com.tencent.mm.bx.a
{
  public boolean EEE;
  public String EEF;
  public String EEG;
  public int EEH;
  public int EEI;
  public int EEJ;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(147805);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bg(1, this.EEE);
      if (this.EEF != null) {
        paramVarArgs.d(2, this.EEF);
      }
      if (this.EEG != null) {
        paramVarArgs.d(3, this.EEG);
      }
      paramVarArgs.aR(4, this.EEH);
      paramVarArgs.aR(5, this.EEI);
      paramVarArgs.aR(6, this.EEJ);
      AppMethodBeat.o(147805);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.fY(1) + 1 + 0;
      paramInt = i;
      if (this.EEF != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.EEF);
      }
      i = paramInt;
      if (this.EEG != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.EEG);
      }
      paramInt = f.a.a.b.b.a.bA(4, this.EEH);
      int j = f.a.a.b.b.a.bA(5, this.EEI);
      int k = f.a.a.b.b.a.bA(6, this.EEJ);
      AppMethodBeat.o(147805);
      return i + paramInt + j + k;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.fMq();
        }
      }
      AppMethodBeat.o(147805);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      doj localdoj = (doj)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(147805);
        return -1;
      case 1: 
        localdoj.EEE = locala.KhF.fHu();
        AppMethodBeat.o(147805);
        return 0;
      case 2: 
        localdoj.EEF = locala.KhF.readString();
        AppMethodBeat.o(147805);
        return 0;
      case 3: 
        localdoj.EEG = locala.KhF.readString();
        AppMethodBeat.o(147805);
        return 0;
      case 4: 
        localdoj.EEH = locala.KhF.xS();
        AppMethodBeat.o(147805);
        return 0;
      case 5: 
        localdoj.EEI = locala.KhF.xS();
        AppMethodBeat.o(147805);
        return 0;
      }
      localdoj.EEJ = locala.KhF.xS();
      AppMethodBeat.o(147805);
      return 0;
    }
    AppMethodBeat.o(147805);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.doj
 * JD-Core Version:    0.7.0.1
 */