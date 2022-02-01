package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bek
  extends com.tencent.mm.bx.a
{
  public int DBU;
  public int DBV;
  public boolean DBW;
  public boolean DBX;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(50094);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aR(1, this.DBU);
      paramVarArgs.aR(2, this.DBV);
      paramVarArgs.bg(3, this.DBW);
      paramVarArgs.bg(4, this.DBX);
      AppMethodBeat.o(50094);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = f.a.a.b.b.a.bA(1, this.DBU);
      int i = f.a.a.b.b.a.bA(2, this.DBV);
      int j = f.a.a.b.b.a.fY(3);
      int k = f.a.a.b.b.a.fY(4);
      AppMethodBeat.o(50094);
      return paramInt + 0 + i + (j + 1) + (k + 1);
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.fMq();
        }
      }
      AppMethodBeat.o(50094);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      bek localbek = (bek)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(50094);
        return -1;
      case 1: 
        localbek.DBU = locala.KhF.xS();
        AppMethodBeat.o(50094);
        return 0;
      case 2: 
        localbek.DBV = locala.KhF.xS();
        AppMethodBeat.o(50094);
        return 0;
      case 3: 
        localbek.DBW = locala.KhF.fHu();
        AppMethodBeat.o(50094);
        return 0;
      }
      localbek.DBX = locala.KhF.fHu();
      AppMethodBeat.o(50094);
      return 0;
    }
    AppMethodBeat.o(50094);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bek
 * JD-Core Version:    0.7.0.1
 */