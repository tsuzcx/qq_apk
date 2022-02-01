package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dis
  extends com.tencent.mm.bw.a
{
  public String dJa;
  public int ret;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(124543);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aM(1, this.ret);
      if (this.dJa != null) {
        paramVarArgs.e(2, this.dJa);
      }
      AppMethodBeat.o(124543);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = g.a.a.b.b.a.bu(1, this.ret) + 0;
      paramInt = i;
      if (this.dJa != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.dJa);
      }
      AppMethodBeat.o(124543);
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
      AppMethodBeat.o(124543);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      dis localdis = (dis)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(124543);
        return -1;
      case 1: 
        localdis.ret = locala.UbS.zi();
        AppMethodBeat.o(124543);
        return 0;
      }
      localdis.dJa = locala.UbS.readString();
      AppMethodBeat.o(124543);
      return 0;
    }
    AppMethodBeat.o(124543);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dis
 * JD-Core Version:    0.7.0.1
 */