package com.tencent.mm.t.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class d
  extends com.tencent.mm.cd.a
{
  public String appid;
  public String jDJ;
  public String jDK;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(249617);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.appid != null) {
        paramVarArgs.f(1, this.appid);
      }
      if (this.jDJ != null) {
        paramVarArgs.f(2, this.jDJ);
      }
      if (this.jDK != null) {
        paramVarArgs.f(3, this.jDK);
      }
      AppMethodBeat.o(249617);
      return 0;
    }
    if (paramInt == 1) {
      if (this.appid == null) {
        break label334;
      }
    }
    label334:
    for (int i = g.a.a.b.b.a.g(1, this.appid) + 0;; i = 0)
    {
      paramInt = i;
      if (this.jDJ != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.jDJ);
      }
      i = paramInt;
      if (this.jDK != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.jDK);
      }
      AppMethodBeat.o(249617);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(249617);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        d locald = (d)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(249617);
          return -1;
        case 1: 
          locald.appid = locala.abFh.readString();
          AppMethodBeat.o(249617);
          return 0;
        case 2: 
          locald.jDJ = locala.abFh.readString();
          AppMethodBeat.o(249617);
          return 0;
        }
        locald.jDK = locala.abFh.readString();
        AppMethodBeat.o(249617);
        return 0;
      }
      AppMethodBeat.o(249617);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.t.a.d
 * JD-Core Version:    0.7.0.1
 */