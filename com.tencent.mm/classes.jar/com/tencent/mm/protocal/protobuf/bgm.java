package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bgm
  extends com.tencent.mm.bw.a
{
  public String LQo;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(42647);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.LQo != null) {
        paramVarArgs.e(1, this.LQo);
      }
      AppMethodBeat.o(42647);
      return 0;
    }
    if (paramInt == 1) {
      if (this.LQo == null) {
        break label213;
      }
    }
    label213:
    for (paramInt = g.a.a.b.b.a.f(1, this.LQo) + 0;; paramInt = 0)
    {
      AppMethodBeat.o(42647);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(42647);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        bgm localbgm = (bgm)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(42647);
          return -1;
        }
        localbgm.LQo = locala.UbS.readString();
        AppMethodBeat.o(42647);
        return 0;
      }
      AppMethodBeat.o(42647);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bgm
 * JD-Core Version:    0.7.0.1
 */