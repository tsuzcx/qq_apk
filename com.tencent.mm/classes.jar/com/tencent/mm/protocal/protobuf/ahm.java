package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ahm
  extends com.tencent.mm.bx.a
{
  public int GeZ;
  public int Gfa;
  public int Gfb;
  public int count;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(210591);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.GeZ);
      paramVarArgs.aS(2, this.Gfa);
      paramVarArgs.aS(3, this.Gfb);
      paramVarArgs.aS(4, this.count);
      AppMethodBeat.o(210591);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = f.a.a.b.b.a.bz(1, this.GeZ);
      int i = f.a.a.b.b.a.bz(2, this.Gfa);
      int j = f.a.a.b.b.a.bz(3, this.Gfb);
      int k = f.a.a.b.b.a.bz(4, this.count);
      AppMethodBeat.o(210591);
      return paramInt + 0 + i + j + k;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gxE();
        }
      }
      AppMethodBeat.o(210591);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      ahm localahm = (ahm)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(210591);
        return -1;
      case 1: 
        localahm.GeZ = locala.NPN.zc();
        AppMethodBeat.o(210591);
        return 0;
      case 2: 
        localahm.Gfa = locala.NPN.zc();
        AppMethodBeat.o(210591);
        return 0;
      case 3: 
        localahm.Gfb = locala.NPN.zc();
        AppMethodBeat.o(210591);
        return 0;
      }
      localahm.count = locala.NPN.zc();
      AppMethodBeat.o(210591);
      return 0;
    }
    AppMethodBeat.o(210591);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ahm
 * JD-Core Version:    0.7.0.1
 */