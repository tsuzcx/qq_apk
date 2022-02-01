package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.b;

public final class ciz
  extends com.tencent.mm.cd.a
{
  public b RPd;
  public b RPf;
  public b Tqd;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32321);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.RPf != null) {
        paramVarArgs.c(1, this.RPf);
      }
      if (this.RPd != null) {
        paramVarArgs.c(2, this.RPd);
      }
      if (this.Tqd != null) {
        paramVarArgs.c(3, this.Tqd);
      }
      AppMethodBeat.o(32321);
      return 0;
    }
    if (paramInt == 1) {
      if (this.RPf == null) {
        break label343;
      }
    }
    label343:
    for (int i = g.a.a.b.b.a.b(1, this.RPf) + 0;; i = 0)
    {
      paramInt = i;
      if (this.RPd != null) {
        paramInt = i + g.a.a.b.b.a.b(2, this.RPd);
      }
      i = paramInt;
      if (this.Tqd != null) {
        i = paramInt + g.a.a.b.b.a.b(3, this.Tqd);
      }
      AppMethodBeat.o(32321);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(32321);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        ciz localciz = (ciz)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(32321);
          return -1;
        case 1: 
          localciz.RPf = locala.abFh.iUw();
          AppMethodBeat.o(32321);
          return 0;
        case 2: 
          localciz.RPd = locala.abFh.iUw();
          AppMethodBeat.o(32321);
          return 0;
        }
        localciz.Tqd = locala.abFh.iUw();
        AppMethodBeat.o(32321);
        return 0;
      }
      AppMethodBeat.o(32321);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ciz
 * JD-Core Version:    0.7.0.1
 */