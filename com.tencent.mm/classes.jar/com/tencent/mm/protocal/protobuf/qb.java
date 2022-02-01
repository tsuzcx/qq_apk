package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class qb
  extends com.tencent.mm.bx.a
{
  public int COY;
  public int COZ;
  public String CPa;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91386);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aR(1, this.COY);
      paramVarArgs.aR(2, this.COZ);
      if (this.CPa != null) {
        paramVarArgs.d(3, this.CPa);
      }
      AppMethodBeat.o(91386);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bA(1, this.COY) + 0 + f.a.a.b.b.a.bA(2, this.COZ);
      paramInt = i;
      if (this.CPa != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.CPa);
      }
      AppMethodBeat.o(91386);
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
      AppMethodBeat.o(91386);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      qb localqb = (qb)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(91386);
        return -1;
      case 1: 
        localqb.COY = locala.KhF.xS();
        AppMethodBeat.o(91386);
        return 0;
      case 2: 
        localqb.COZ = locala.KhF.xS();
        AppMethodBeat.o(91386);
        return 0;
      }
      localqb.CPa = locala.KhF.readString();
      AppMethodBeat.o(91386);
      return 0;
    }
    AppMethodBeat.o(91386);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.qb
 * JD-Core Version:    0.7.0.1
 */