package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class cop
  extends com.tencent.mm.bx.a
{
  public com.tencent.mm.bx.b DcU;
  public int EiA;
  public int EiB;
  public int EiC;
  public int EiD;
  public int EiE;
  public int EiF;
  public int Eiz;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32425);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.DcU == null)
      {
        paramVarArgs = new f.a.a.b("Not all required fields were included: data");
        AppMethodBeat.o(32425);
        throw paramVarArgs;
      }
      paramVarArgs.aR(1, this.Eiz);
      paramVarArgs.aR(2, this.EiA);
      paramVarArgs.aR(3, this.EiB);
      paramVarArgs.aR(4, this.EiC);
      paramVarArgs.aR(5, this.EiD);
      paramVarArgs.aR(6, this.EiE);
      paramVarArgs.aR(7, this.EiF);
      if (this.DcU != null) {
        paramVarArgs.c(8, this.DcU);
      }
      AppMethodBeat.o(32425);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bA(1, this.Eiz) + 0 + f.a.a.b.b.a.bA(2, this.EiA) + f.a.a.b.b.a.bA(3, this.EiB) + f.a.a.b.b.a.bA(4, this.EiC) + f.a.a.b.b.a.bA(5, this.EiD) + f.a.a.b.b.a.bA(6, this.EiE) + f.a.a.b.b.a.bA(7, this.EiF);
      paramInt = i;
      if (this.DcU != null) {
        paramInt = i + f.a.a.b.b.a.b(8, this.DcU);
      }
      AppMethodBeat.o(32425);
      return paramInt;
    }
    f.a.a.a.a locala;
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      locala = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(locala); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(locala)) {
        if (!super.populateBuilderWithField(locala, this, paramInt)) {
          locala.fMq();
        }
      }
      if (paramVarArgs == null)
      {
        paramVarArgs = new f.a.a.b("Not all required fields were included: data");
        AppMethodBeat.o(32425);
        throw paramVarArgs;
      }
      AppMethodBeat.o(32425);
      return 0;
    }
    if (paramInt == 3)
    {
      locala = (f.a.a.a.a)paramVarArgs[0];
      cop localcop = (cop)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(32425);
        return -1;
      case 1: 
        localcop.Eiz = locala.KhF.xS();
        AppMethodBeat.o(32425);
        return 0;
      case 2: 
        localcop.EiA = locala.KhF.xS();
        AppMethodBeat.o(32425);
        return 0;
      case 3: 
        localcop.EiB = locala.KhF.xS();
        AppMethodBeat.o(32425);
        return 0;
      case 4: 
        localcop.EiC = locala.KhF.xS();
        AppMethodBeat.o(32425);
        return 0;
      case 5: 
        localcop.EiD = locala.KhF.xS();
        AppMethodBeat.o(32425);
        return 0;
      case 6: 
        localcop.EiE = locala.KhF.xS();
        AppMethodBeat.o(32425);
        return 0;
      case 7: 
        localcop.EiF = locala.KhF.xS();
        AppMethodBeat.o(32425);
        return 0;
      }
      localcop.DcU = locala.KhF.fMu();
      AppMethodBeat.o(32425);
      return 0;
    }
    AppMethodBeat.o(32425);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cop
 * JD-Core Version:    0.7.0.1
 */