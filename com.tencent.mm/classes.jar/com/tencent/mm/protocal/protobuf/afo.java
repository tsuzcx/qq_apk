package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class afo
  extends com.tencent.mm.bx.a
{
  public String GdA;
  public boolean Gdy;
  public boolean Gdz;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(113998);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bt(1, this.Gdy);
      paramVarArgs.bt(2, this.Gdz);
      if (this.GdA != null) {
        paramVarArgs.d(3, this.GdA);
      }
      AppMethodBeat.o(113998);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.alV(1) + 0 + f.a.a.b.b.a.alV(2);
      paramInt = i;
      if (this.GdA != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.GdA);
      }
      AppMethodBeat.o(113998);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gxE();
        }
      }
      AppMethodBeat.o(113998);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      afo localafo = (afo)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(113998);
        return -1;
      case 1: 
        localafo.Gdy = locala.NPN.grw();
        AppMethodBeat.o(113998);
        return 0;
      case 2: 
        localafo.Gdz = locala.NPN.grw();
        AppMethodBeat.o(113998);
        return 0;
      }
      localafo.GdA = locala.NPN.readString();
      AppMethodBeat.o(113998);
      return 0;
    }
    AppMethodBeat.o(113998);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.afo
 * JD-Core Version:    0.7.0.1
 */