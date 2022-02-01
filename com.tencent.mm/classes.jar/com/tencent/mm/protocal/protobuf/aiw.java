package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;

public final class aiw
  extends com.tencent.mm.bw.a
{
  public int Lst;
  public String Lsu;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(104760);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.Lsu == null)
      {
        paramVarArgs = new b("Not all required fields were included: TagDesc");
        AppMethodBeat.o(104760);
        throw paramVarArgs;
      }
      paramVarArgs.aM(1, this.Lst);
      if (this.Lsu != null) {
        paramVarArgs.e(2, this.Lsu);
      }
      AppMethodBeat.o(104760);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = g.a.a.b.b.a.bu(1, this.Lst) + 0;
      paramInt = i;
      if (this.Lsu != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.Lsu);
      }
      AppMethodBeat.o(104760);
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
      if (this.Lsu == null)
      {
        paramVarArgs = new b("Not all required fields were included: TagDesc");
        AppMethodBeat.o(104760);
        throw paramVarArgs;
      }
      AppMethodBeat.o(104760);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      aiw localaiw = (aiw)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(104760);
        return -1;
      case 1: 
        localaiw.Lst = locala.UbS.zi();
        AppMethodBeat.o(104760);
        return 0;
      }
      localaiw.Lsu = locala.UbS.readString();
      AppMethodBeat.o(104760);
      return 0;
    }
    AppMethodBeat.o(104760);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aiw
 * JD-Core Version:    0.7.0.1
 */