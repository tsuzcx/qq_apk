package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class gi
  extends com.tencent.mm.bx.a
{
  public int Fyv;
  public int Fyw;
  public int Fyx;
  public int Fyy;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32126);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.Fyv);
      paramVarArgs.aS(2, this.Fyw);
      paramVarArgs.aS(3, this.Fyx);
      paramVarArgs.aS(4, this.Fyy);
      AppMethodBeat.o(32126);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = f.a.a.b.b.a.bz(1, this.Fyv);
      int i = f.a.a.b.b.a.bz(2, this.Fyw);
      int j = f.a.a.b.b.a.bz(3, this.Fyx);
      int k = f.a.a.b.b.a.bz(4, this.Fyy);
      AppMethodBeat.o(32126);
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
      AppMethodBeat.o(32126);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      gi localgi = (gi)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(32126);
        return -1;
      case 1: 
        localgi.Fyv = locala.NPN.zc();
        AppMethodBeat.o(32126);
        return 0;
      case 2: 
        localgi.Fyw = locala.NPN.zc();
        AppMethodBeat.o(32126);
        return 0;
      case 3: 
        localgi.Fyx = locala.NPN.zc();
        AppMethodBeat.o(32126);
        return 0;
      }
      localgi.Fyy = locala.NPN.zc();
      AppMethodBeat.o(32126);
      return 0;
    }
    AppMethodBeat.o(32126);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.gi
 * JD-Core Version:    0.7.0.1
 */