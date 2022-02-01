package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dju
  extends com.tencent.mm.bx.a
{
  public int CzZ;
  public String DcD;
  public int EzH;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(152724);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aR(1, this.CzZ);
      if (this.DcD != null) {
        paramVarArgs.d(2, this.DcD);
      }
      paramVarArgs.aR(3, this.EzH);
      AppMethodBeat.o(152724);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bA(1, this.CzZ) + 0;
      paramInt = i;
      if (this.DcD != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.DcD);
      }
      i = f.a.a.b.b.a.bA(3, this.EzH);
      AppMethodBeat.o(152724);
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
      AppMethodBeat.o(152724);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      dju localdju = (dju)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(152724);
        return -1;
      case 1: 
        localdju.CzZ = locala.KhF.xS();
        AppMethodBeat.o(152724);
        return 0;
      case 2: 
        localdju.DcD = locala.KhF.readString();
        AppMethodBeat.o(152724);
        return 0;
      }
      localdju.EzH = locala.KhF.xS();
      AppMethodBeat.o(152724);
      return 0;
    }
    AppMethodBeat.o(152724);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dju
 * JD-Core Version:    0.7.0.1
 */