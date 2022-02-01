package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class cat
  extends com.tencent.mm.bw.a
{
  public String KLO;
  public String oTH;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(82424);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.KLO != null) {
        paramVarArgs.e(1, this.KLO);
      }
      if (this.oTH != null) {
        paramVarArgs.e(2, this.oTH);
      }
      AppMethodBeat.o(82424);
      return 0;
    }
    if (paramInt == 1) {
      if (this.KLO == null) {
        break label274;
      }
    }
    label274:
    for (paramInt = g.a.a.b.b.a.f(1, this.KLO) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.oTH != null) {
        i = paramInt + g.a.a.b.b.a.f(2, this.oTH);
      }
      AppMethodBeat.o(82424);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(82424);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        cat localcat = (cat)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(82424);
          return -1;
        case 1: 
          localcat.KLO = locala.UbS.readString();
          AppMethodBeat.o(82424);
          return 0;
        }
        localcat.oTH = locala.UbS.readString();
        AppMethodBeat.o(82424);
        return 0;
      }
      AppMethodBeat.o(82424);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cat
 * JD-Core Version:    0.7.0.1
 */