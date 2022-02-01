package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dwf
  extends com.tencent.mm.bx.a
{
  public int EKa;
  public int EKb;
  public int EKc;
  public int EKd;
  public String EKe;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(153337);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aR(1, this.EKa);
      paramVarArgs.aR(2, this.EKb);
      paramVarArgs.aR(3, this.EKc);
      paramVarArgs.aR(4, this.EKd);
      if (this.EKe != null) {
        paramVarArgs.d(5, this.EKe);
      }
      AppMethodBeat.o(153337);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bA(1, this.EKa) + 0 + f.a.a.b.b.a.bA(2, this.EKb) + f.a.a.b.b.a.bA(3, this.EKc) + f.a.a.b.b.a.bA(4, this.EKd);
      paramInt = i;
      if (this.EKe != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.EKe);
      }
      AppMethodBeat.o(153337);
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
      AppMethodBeat.o(153337);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      dwf localdwf = (dwf)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(153337);
        return -1;
      case 1: 
        localdwf.EKa = locala.KhF.xS();
        AppMethodBeat.o(153337);
        return 0;
      case 2: 
        localdwf.EKb = locala.KhF.xS();
        AppMethodBeat.o(153337);
        return 0;
      case 3: 
        localdwf.EKc = locala.KhF.xS();
        AppMethodBeat.o(153337);
        return 0;
      case 4: 
        localdwf.EKd = locala.KhF.xS();
        AppMethodBeat.o(153337);
        return 0;
      }
      localdwf.EKe = locala.KhF.readString();
      AppMethodBeat.o(153337);
      return 0;
    }
    AppMethodBeat.o(153337);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dwf
 * JD-Core Version:    0.7.0.1
 */