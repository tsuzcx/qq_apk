package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class age
  extends com.tencent.mm.bx.a
{
  public int Cxl;
  public String Cxr;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(127465);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aR(1, this.Cxl);
      if (this.Cxr != null) {
        paramVarArgs.d(2, this.Cxr);
      }
      AppMethodBeat.o(127465);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bA(1, this.Cxl) + 0;
      paramInt = i;
      if (this.Cxr != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.Cxr);
      }
      AppMethodBeat.o(127465);
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
      AppMethodBeat.o(127465);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      age localage = (age)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(127465);
        return -1;
      case 1: 
        localage.Cxl = locala.KhF.xS();
        AppMethodBeat.o(127465);
        return 0;
      }
      localage.Cxr = locala.KhF.readString();
      AppMethodBeat.o(127465);
      return 0;
    }
    AppMethodBeat.o(127465);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.age
 * JD-Core Version:    0.7.0.1
 */