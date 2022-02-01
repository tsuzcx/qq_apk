package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.b;

public final class ade
  extends com.tencent.mm.cd.a
{
  public b SpH;
  public String openid;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(202958);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.openid != null) {
        paramVarArgs.f(1, this.openid);
      }
      if (this.SpH != null) {
        paramVarArgs.c(2, this.SpH);
      }
      AppMethodBeat.o(202958);
      return 0;
    }
    if (paramInt == 1) {
      if (this.openid == null) {
        break label274;
      }
    }
    label274:
    for (paramInt = g.a.a.b.b.a.g(1, this.openid) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.SpH != null) {
        i = paramInt + g.a.a.b.b.a.b(2, this.SpH);
      }
      AppMethodBeat.o(202958);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(202958);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        ade localade = (ade)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(202958);
          return -1;
        case 1: 
          localade.openid = locala.abFh.readString();
          AppMethodBeat.o(202958);
          return 0;
        }
        localade.SpH = locala.abFh.iUw();
        AppMethodBeat.o(202958);
        return 0;
      }
      AppMethodBeat.o(202958);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ade
 * JD-Core Version:    0.7.0.1
 */