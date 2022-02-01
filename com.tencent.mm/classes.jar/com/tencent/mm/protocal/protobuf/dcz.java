package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dcz
  extends com.tencent.mm.bw.a
{
  public String MIg;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(209805);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.MIg != null) {
        paramVarArgs.e(1, this.MIg);
      }
      AppMethodBeat.o(209805);
      return 0;
    }
    if (paramInt == 1) {
      if (this.MIg == null) {
        break label213;
      }
    }
    label213:
    for (paramInt = g.a.a.b.b.a.f(1, this.MIg) + 0;; paramInt = 0)
    {
      AppMethodBeat.o(209805);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(209805);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        dcz localdcz = (dcz)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(209805);
          return -1;
        }
        localdcz.MIg = locala.UbS.readString();
        AppMethodBeat.o(209805);
        return 0;
      }
      AppMethodBeat.o(209805);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dcz
 * JD-Core Version:    0.7.0.1
 */