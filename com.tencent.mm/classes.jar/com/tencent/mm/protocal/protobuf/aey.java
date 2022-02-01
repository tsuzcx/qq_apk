package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class aey
  extends com.tencent.mm.bx.a
{
  public int Gdb;
  public int Gdc;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(43095);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.Gdb);
      paramVarArgs.aS(2, this.Gdc);
      AppMethodBeat.o(43095);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = f.a.a.b.b.a.bz(1, this.Gdb);
      int i = f.a.a.b.b.a.bz(2, this.Gdc);
      AppMethodBeat.o(43095);
      return paramInt + 0 + i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gxE();
        }
      }
      AppMethodBeat.o(43095);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      aey localaey = (aey)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(43095);
        return -1;
      case 1: 
        localaey.Gdb = locala.NPN.zc();
        AppMethodBeat.o(43095);
        return 0;
      }
      localaey.Gdc = locala.NPN.zc();
      AppMethodBeat.o(43095);
      return 0;
    }
    AppMethodBeat.o(43095);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aey
 * JD-Core Version:    0.7.0.1
 */