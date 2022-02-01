package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bes
  extends com.tencent.mm.bw.a
{
  public int index;
  public int lCq;
  public String username;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32211);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aM(1, this.index);
      if (this.username != null) {
        paramVarArgs.e(2, this.username);
      }
      paramVarArgs.aM(3, this.lCq);
      AppMethodBeat.o(32211);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = g.a.a.b.b.a.bu(1, this.index) + 0;
      paramInt = i;
      if (this.username != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.username);
      }
      i = g.a.a.b.b.a.bu(3, this.lCq);
      AppMethodBeat.o(32211);
      return paramInt + i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.hPl();
        }
      }
      AppMethodBeat.o(32211);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      bes localbes = (bes)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(32211);
        return -1;
      case 1: 
        localbes.index = locala.UbS.zi();
        AppMethodBeat.o(32211);
        return 0;
      case 2: 
        localbes.username = locala.UbS.readString();
        AppMethodBeat.o(32211);
        return 0;
      }
      localbes.lCq = locala.UbS.zi();
      AppMethodBeat.o(32211);
      return 0;
    }
    AppMethodBeat.o(32211);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bes
 * JD-Core Version:    0.7.0.1
 */