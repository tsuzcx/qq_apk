package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class nx
  extends com.tencent.mm.bx.a
{
  public int CLx;
  public int CLy;
  public int CLz;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(103204);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aR(1, this.CLx);
      paramVarArgs.aR(2, this.CLy);
      paramVarArgs.aR(3, this.CLz);
      AppMethodBeat.o(103204);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = f.a.a.b.b.a.bA(1, this.CLx);
      int i = f.a.a.b.b.a.bA(2, this.CLy);
      int j = f.a.a.b.b.a.bA(3, this.CLz);
      AppMethodBeat.o(103204);
      return paramInt + 0 + i + j;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.fMq();
        }
      }
      AppMethodBeat.o(103204);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      nx localnx = (nx)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(103204);
        return -1;
      case 1: 
        localnx.CLx = locala.KhF.xS();
        AppMethodBeat.o(103204);
        return 0;
      case 2: 
        localnx.CLy = locala.KhF.xS();
        AppMethodBeat.o(103204);
        return 0;
      }
      localnx.CLz = locala.KhF.xS();
      AppMethodBeat.o(103204);
      return 0;
    }
    AppMethodBeat.o(103204);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.nx
 * JD-Core Version:    0.7.0.1
 */