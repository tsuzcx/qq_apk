package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.b;

public final class cjb
  extends com.tencent.mm.cd.a
{
  public b RPd;
  public b RPf;
  public int jUk;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(124514);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.RPf != null) {
        paramVarArgs.c(1, this.RPf);
      }
      if (this.RPd != null) {
        paramVarArgs.c(2, this.RPd);
      }
      paramVarArgs.aY(3, this.jUk);
      AppMethodBeat.o(124514);
      return 0;
    }
    if (paramInt == 1) {
      if (this.RPf == null) {
        break label318;
      }
    }
    label318:
    for (paramInt = g.a.a.b.b.a.b(1, this.RPf) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.RPd != null) {
        i = paramInt + g.a.a.b.b.a.b(2, this.RPd);
      }
      paramInt = g.a.a.b.b.a.bM(3, this.jUk);
      AppMethodBeat.o(124514);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(124514);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        cjb localcjb = (cjb)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(124514);
          return -1;
        case 1: 
          localcjb.RPf = locala.abFh.iUw();
          AppMethodBeat.o(124514);
          return 0;
        case 2: 
          localcjb.RPd = locala.abFh.iUw();
          AppMethodBeat.o(124514);
          return 0;
        }
        localcjb.jUk = locala.abFh.AK();
        AppMethodBeat.o(124514);
        return 0;
      }
      AppMethodBeat.o(124514);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cjb
 * JD-Core Version:    0.7.0.1
 */