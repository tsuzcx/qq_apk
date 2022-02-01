package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class pl
  extends com.tencent.mm.bw.a
{
  public int GcY;
  public int GcZ;
  public int Gda;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(103204);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.GcY);
      paramVarArgs.aS(2, this.GcZ);
      paramVarArgs.aS(3, this.Gda);
      AppMethodBeat.o(103204);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = f.a.a.b.b.a.bz(1, this.GcY);
      int i = f.a.a.b.b.a.bz(2, this.GcZ);
      int j = f.a.a.b.b.a.bz(3, this.Gda);
      AppMethodBeat.o(103204);
      return paramInt + 0 + i + j;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gCg();
        }
      }
      AppMethodBeat.o(103204);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      pl localpl = (pl)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(103204);
        return -1;
      case 1: 
        localpl.GcY = locala.OmT.zc();
        AppMethodBeat.o(103204);
        return 0;
      case 2: 
        localpl.GcZ = locala.OmT.zc();
        AppMethodBeat.o(103204);
        return 0;
      }
      localpl.Gda = locala.OmT.zc();
      AppMethodBeat.o(103204);
      return 0;
    }
    AppMethodBeat.o(103204);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.pl
 * JD-Core Version:    0.7.0.1
 */