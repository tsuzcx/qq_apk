package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bzu
  extends com.tencent.mm.bw.a
{
  public String Mfs;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32317);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.Mfs != null) {
        paramVarArgs.e(1, this.Mfs);
      }
      AppMethodBeat.o(32317);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Mfs == null) {
        break label220;
      }
    }
    label220:
    for (paramInt = g.a.a.b.b.a.f(1, this.Mfs) + 0;; paramInt = 0)
    {
      AppMethodBeat.o(32317);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(32317);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        bzu localbzu = (bzu)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(32317);
          return -1;
        }
        localbzu.Mfs = locala.UbS.readString();
        AppMethodBeat.o(32317);
        return 0;
      }
      AppMethodBeat.o(32317);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bzu
 * JD-Core Version:    0.7.0.1
 */