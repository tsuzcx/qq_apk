package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class exw
  extends com.tencent.mm.bw.a
{
  public String Nve;
  public String xJH;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(121117);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.xJH != null) {
        paramVarArgs.e(1, this.xJH);
      }
      if (this.Nve != null) {
        paramVarArgs.e(2, this.Nve);
      }
      AppMethodBeat.o(121117);
      return 0;
    }
    if (paramInt == 1) {
      if (this.xJH == null) {
        break label274;
      }
    }
    label274:
    for (paramInt = g.a.a.b.b.a.f(1, this.xJH) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.Nve != null) {
        i = paramInt + g.a.a.b.b.a.f(2, this.Nve);
      }
      AppMethodBeat.o(121117);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(121117);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        exw localexw = (exw)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(121117);
          return -1;
        case 1: 
          localexw.xJH = locala.UbS.readString();
          AppMethodBeat.o(121117);
          return 0;
        }
        localexw.Nve = locala.UbS.readString();
        AppMethodBeat.o(121117);
        return 0;
      }
      AppMethodBeat.o(121117);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.exw
 * JD-Core Version:    0.7.0.1
 */