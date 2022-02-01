package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;

public final class dnx
  extends com.tencent.mm.bx.a
{
  public b DcU;
  public int EEq;
  public int EiC;
  public int amt;
  public String category;
  public int htk;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(147790);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aR(1, this.htk);
      paramVarArgs.aR(2, this.amt);
      if (this.category != null) {
        paramVarArgs.d(3, this.category);
      }
      if (this.DcU != null) {
        paramVarArgs.c(4, this.DcU);
      }
      paramVarArgs.aR(5, this.EiC);
      paramVarArgs.aR(6, this.EEq);
      AppMethodBeat.o(147790);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bA(1, this.htk) + 0 + f.a.a.b.b.a.bA(2, this.amt);
      paramInt = i;
      if (this.category != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.category);
      }
      i = paramInt;
      if (this.DcU != null) {
        i = paramInt + f.a.a.b.b.a.b(4, this.DcU);
      }
      paramInt = f.a.a.b.b.a.bA(5, this.EiC);
      int j = f.a.a.b.b.a.bA(6, this.EEq);
      AppMethodBeat.o(147790);
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
      AppMethodBeat.o(147790);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      dnx localdnx = (dnx)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(147790);
        return -1;
      case 1: 
        localdnx.htk = locala.KhF.xS();
        AppMethodBeat.o(147790);
        return 0;
      case 2: 
        localdnx.amt = locala.KhF.xS();
        AppMethodBeat.o(147790);
        return 0;
      case 3: 
        localdnx.category = locala.KhF.readString();
        AppMethodBeat.o(147790);
        return 0;
      case 4: 
        localdnx.DcU = locala.KhF.fMu();
        AppMethodBeat.o(147790);
        return 0;
      case 5: 
        localdnx.EiC = locala.KhF.xS();
        AppMethodBeat.o(147790);
        return 0;
      }
      localdnx.EEq = locala.KhF.xS();
      AppMethodBeat.o(147790);
      return 0;
    }
    AppMethodBeat.o(147790);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dnx
 * JD-Core Version:    0.7.0.1
 */