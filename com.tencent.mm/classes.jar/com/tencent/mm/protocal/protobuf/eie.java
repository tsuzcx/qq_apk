package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class eie
  extends com.tencent.mm.bw.a
{
  public boolean Nhu;
  public String Nhv;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(182773);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.cc(1, this.Nhu);
      if (this.Nhv != null) {
        paramVarArgs.e(2, this.Nhv);
      }
      AppMethodBeat.o(182773);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = g.a.a.b.b.a.fS(1) + 1 + 0;
      paramInt = i;
      if (this.Nhv != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.Nhv);
      }
      AppMethodBeat.o(182773);
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
      AppMethodBeat.o(182773);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      eie localeie = (eie)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(182773);
        return -1;
      case 1: 
        localeie.Nhu = locala.UbS.yZ();
        AppMethodBeat.o(182773);
        return 0;
      }
      localeie.Nhv = locala.UbS.readString();
      AppMethodBeat.o(182773);
      return 0;
    }
    AppMethodBeat.o(182773);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.eie
 * JD-Core Version:    0.7.0.1
 */