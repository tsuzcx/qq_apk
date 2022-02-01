package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;

public final class dey
  extends com.tencent.mm.bx.a
{
  public int EwA;
  public int EwB;
  public String EwC;
  public b EwD;
  public int EwE;
  public int EwF;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(82481);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aR(1, this.EwA);
      paramVarArgs.aR(2, this.EwB);
      if (this.EwC != null) {
        paramVarArgs.d(3, this.EwC);
      }
      if (this.EwD != null) {
        paramVarArgs.c(4, this.EwD);
      }
      paramVarArgs.aR(5, this.EwE);
      paramVarArgs.aR(6, this.EwF);
      AppMethodBeat.o(82481);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bA(1, this.EwA) + 0 + f.a.a.b.b.a.bA(2, this.EwB);
      paramInt = i;
      if (this.EwC != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.EwC);
      }
      i = paramInt;
      if (this.EwD != null) {
        i = paramInt + f.a.a.b.b.a.b(4, this.EwD);
      }
      paramInt = f.a.a.b.b.a.bA(5, this.EwE);
      int j = f.a.a.b.b.a.bA(6, this.EwF);
      AppMethodBeat.o(82481);
      return i + paramInt + j;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.fMq();
        }
      }
      AppMethodBeat.o(82481);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      dey localdey = (dey)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(82481);
        return -1;
      case 1: 
        localdey.EwA = locala.KhF.xS();
        AppMethodBeat.o(82481);
        return 0;
      case 2: 
        localdey.EwB = locala.KhF.xS();
        AppMethodBeat.o(82481);
        return 0;
      case 3: 
        localdey.EwC = locala.KhF.readString();
        AppMethodBeat.o(82481);
        return 0;
      case 4: 
        localdey.EwD = locala.KhF.fMu();
        AppMethodBeat.o(82481);
        return 0;
      case 5: 
        localdey.EwE = locala.KhF.xS();
        AppMethodBeat.o(82481);
        return 0;
      }
      localdey.EwF = locala.KhF.xS();
      AppMethodBeat.o(82481);
      return 0;
    }
    AppMethodBeat.o(82481);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dey
 * JD-Core Version:    0.7.0.1
 */