package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class aii
  extends com.tencent.mm.bw.a
{
  public int index;
  public String name;
  public int type;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(220690);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aM(1, this.index);
      paramVarArgs.aM(2, this.type);
      if (this.name != null) {
        paramVarArgs.e(3, this.name);
      }
      AppMethodBeat.o(220690);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = g.a.a.b.b.a.bu(1, this.index) + 0 + g.a.a.b.b.a.bu(2, this.type);
      paramInt = i;
      if (this.name != null) {
        paramInt = i + g.a.a.b.b.a.f(3, this.name);
      }
      AppMethodBeat.o(220690);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.hPl();
        }
      }
      AppMethodBeat.o(220690);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      aii localaii = (aii)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(220690);
        return -1;
      case 1: 
        localaii.index = locala.UbS.zi();
        AppMethodBeat.o(220690);
        return 0;
      case 2: 
        localaii.type = locala.UbS.zi();
        AppMethodBeat.o(220690);
        return 0;
      }
      localaii.name = locala.UbS.readString();
      AppMethodBeat.o(220690);
      return 0;
    }
    AppMethodBeat.o(220690);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aii
 * JD-Core Version:    0.7.0.1
 */