package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class boj
  extends com.tencent.mm.bx.a
{
  public boolean DLJ;
  public boolean DLK;
  public int DLL;
  public String DLM;
  public boolean DLN;
  public boolean DLO;
  public String DLP;
  public String dlB;
  public int qRG;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(127172);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bg(1, this.DLJ);
      paramVarArgs.bg(2, this.DLK);
      paramVarArgs.aR(3, this.qRG);
      paramVarArgs.aR(4, this.DLL);
      if (this.DLM != null) {
        paramVarArgs.d(5, this.DLM);
      }
      paramVarArgs.bg(6, this.DLN);
      if (this.dlB != null) {
        paramVarArgs.d(7, this.dlB);
      }
      paramVarArgs.bg(8, this.DLO);
      if (this.DLP != null) {
        paramVarArgs.d(9, this.DLP);
      }
      AppMethodBeat.o(127172);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.fY(1) + 1 + 0 + (f.a.a.b.b.a.fY(2) + 1) + f.a.a.b.b.a.bA(3, this.qRG) + f.a.a.b.b.a.bA(4, this.DLL);
      paramInt = i;
      if (this.DLM != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.DLM);
      }
      i = paramInt + (f.a.a.b.b.a.fY(6) + 1);
      paramInt = i;
      if (this.dlB != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.dlB);
      }
      i = paramInt + (f.a.a.b.b.a.fY(8) + 1);
      paramInt = i;
      if (this.DLP != null) {
        paramInt = i + f.a.a.b.b.a.e(9, this.DLP);
      }
      AppMethodBeat.o(127172);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.fMq();
        }
      }
      AppMethodBeat.o(127172);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      boj localboj = (boj)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(127172);
        return -1;
      case 1: 
        localboj.DLJ = locala.KhF.fHu();
        AppMethodBeat.o(127172);
        return 0;
      case 2: 
        localboj.DLK = locala.KhF.fHu();
        AppMethodBeat.o(127172);
        return 0;
      case 3: 
        localboj.qRG = locala.KhF.xS();
        AppMethodBeat.o(127172);
        return 0;
      case 4: 
        localboj.DLL = locala.KhF.xS();
        AppMethodBeat.o(127172);
        return 0;
      case 5: 
        localboj.DLM = locala.KhF.readString();
        AppMethodBeat.o(127172);
        return 0;
      case 6: 
        localboj.DLN = locala.KhF.fHu();
        AppMethodBeat.o(127172);
        return 0;
      case 7: 
        localboj.dlB = locala.KhF.readString();
        AppMethodBeat.o(127172);
        return 0;
      case 8: 
        localboj.DLO = locala.KhF.fHu();
        AppMethodBeat.o(127172);
        return 0;
      }
      localboj.DLP = locala.KhF.readString();
      AppMethodBeat.o(127172);
      return 0;
    }
    AppMethodBeat.o(127172);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.boj
 * JD-Core Version:    0.7.0.1
 */