package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dwp
  extends com.tencent.mm.bx.a
{
  public String EKB;
  public String EKC;
  public String dlB;
  public int lrW;
  public int lty;
  public int type;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(123710);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aR(1, this.type);
      if (this.dlB != null) {
        paramVarArgs.d(2, this.dlB);
      }
      if (this.EKB != null) {
        paramVarArgs.d(3, this.EKB);
      }
      if (this.EKC != null) {
        paramVarArgs.d(4, this.EKC);
      }
      paramVarArgs.aR(5, this.lrW);
      paramVarArgs.aR(6, this.lty);
      AppMethodBeat.o(123710);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bA(1, this.type) + 0;
      paramInt = i;
      if (this.dlB != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.dlB);
      }
      i = paramInt;
      if (this.EKB != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.EKB);
      }
      paramInt = i;
      if (this.EKC != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.EKC);
      }
      i = f.a.a.b.b.a.bA(5, this.lrW);
      int j = f.a.a.b.b.a.bA(6, this.lty);
      AppMethodBeat.o(123710);
      return paramInt + i + j;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.fMq();
        }
      }
      AppMethodBeat.o(123710);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      dwp localdwp = (dwp)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(123710);
        return -1;
      case 1: 
        localdwp.type = locala.KhF.xS();
        AppMethodBeat.o(123710);
        return 0;
      case 2: 
        localdwp.dlB = locala.KhF.readString();
        AppMethodBeat.o(123710);
        return 0;
      case 3: 
        localdwp.EKB = locala.KhF.readString();
        AppMethodBeat.o(123710);
        return 0;
      case 4: 
        localdwp.EKC = locala.KhF.readString();
        AppMethodBeat.o(123710);
        return 0;
      case 5: 
        localdwp.lrW = locala.KhF.xS();
        AppMethodBeat.o(123710);
        return 0;
      }
      localdwp.lty = locala.KhF.xS();
      AppMethodBeat.o(123710);
      return 0;
    }
    AppMethodBeat.o(123710);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dwp
 * JD-Core Version:    0.7.0.1
 */