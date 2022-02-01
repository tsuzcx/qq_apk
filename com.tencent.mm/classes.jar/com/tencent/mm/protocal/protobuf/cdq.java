package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class cdq
  extends com.tencent.mm.bx.a
{
  public int DZT;
  public int Dec;
  public String DnM;
  public int Dxg;
  public String MD5;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(155451);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aR(1, this.Dxg);
      if (this.DnM != null) {
        paramVarArgs.d(2, this.DnM);
      }
      if (this.MD5 != null) {
        paramVarArgs.d(3, this.MD5);
      }
      paramVarArgs.aR(4, this.Dec);
      paramVarArgs.aR(5, this.DZT);
      AppMethodBeat.o(155451);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bA(1, this.Dxg) + 0;
      paramInt = i;
      if (this.DnM != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.DnM);
      }
      i = paramInt;
      if (this.MD5 != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.MD5);
      }
      paramInt = f.a.a.b.b.a.bA(4, this.Dec);
      int j = f.a.a.b.b.a.bA(5, this.DZT);
      AppMethodBeat.o(155451);
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
      AppMethodBeat.o(155451);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      cdq localcdq = (cdq)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(155451);
        return -1;
      case 1: 
        localcdq.Dxg = locala.KhF.xS();
        AppMethodBeat.o(155451);
        return 0;
      case 2: 
        localcdq.DnM = locala.KhF.readString();
        AppMethodBeat.o(155451);
        return 0;
      case 3: 
        localcdq.MD5 = locala.KhF.readString();
        AppMethodBeat.o(155451);
        return 0;
      case 4: 
        localcdq.Dec = locala.KhF.xS();
        AppMethodBeat.o(155451);
        return 0;
      }
      localcdq.DZT = locala.KhF.xS();
      AppMethodBeat.o(155451);
      return 0;
    }
    AppMethodBeat.o(155451);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cdq
 * JD-Core Version:    0.7.0.1
 */