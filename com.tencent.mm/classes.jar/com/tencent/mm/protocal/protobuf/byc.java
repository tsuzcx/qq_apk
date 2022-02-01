package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class byc
  extends com.tencent.mm.bx.a
{
  public int DUN;
  public int DUO;
  public int DUP;
  public long DUQ;
  public int DUR;
  public int DUS;
  public String Dds;
  public String sed;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(104825);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aR(1, this.DUN);
      paramVarArgs.aR(2, this.DUO);
      paramVarArgs.aR(3, this.DUP);
      if (this.sed != null) {
        paramVarArgs.d(4, this.sed);
      }
      paramVarArgs.aG(5, this.DUQ);
      paramVarArgs.aR(6, this.DUR);
      if (this.Dds != null) {
        paramVarArgs.d(7, this.Dds);
      }
      paramVarArgs.aR(8, this.DUS);
      AppMethodBeat.o(104825);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bA(1, this.DUN) + 0 + f.a.a.b.b.a.bA(2, this.DUO) + f.a.a.b.b.a.bA(3, this.DUP);
      paramInt = i;
      if (this.sed != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.sed);
      }
      i = paramInt + f.a.a.b.b.a.q(5, this.DUQ) + f.a.a.b.b.a.bA(6, this.DUR);
      paramInt = i;
      if (this.Dds != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.Dds);
      }
      i = f.a.a.b.b.a.bA(8, this.DUS);
      AppMethodBeat.o(104825);
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
      AppMethodBeat.o(104825);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      byc localbyc = (byc)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(104825);
        return -1;
      case 1: 
        localbyc.DUN = locala.KhF.xS();
        AppMethodBeat.o(104825);
        return 0;
      case 2: 
        localbyc.DUO = locala.KhF.xS();
        AppMethodBeat.o(104825);
        return 0;
      case 3: 
        localbyc.DUP = locala.KhF.xS();
        AppMethodBeat.o(104825);
        return 0;
      case 4: 
        localbyc.sed = locala.KhF.readString();
        AppMethodBeat.o(104825);
        return 0;
      case 5: 
        localbyc.DUQ = locala.KhF.xT();
        AppMethodBeat.o(104825);
        return 0;
      case 6: 
        localbyc.DUR = locala.KhF.xS();
        AppMethodBeat.o(104825);
        return 0;
      case 7: 
        localbyc.Dds = locala.KhF.readString();
        AppMethodBeat.o(104825);
        return 0;
      }
      localbyc.DUS = locala.KhF.xS();
      AppMethodBeat.o(104825);
      return 0;
    }
    AppMethodBeat.o(104825);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.byc
 * JD-Core Version:    0.7.0.1
 */