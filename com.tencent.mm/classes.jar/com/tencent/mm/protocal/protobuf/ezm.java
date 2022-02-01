package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;

public final class ezm
  extends com.tencent.mm.cd.a
{
  public long SnV;
  public String SnW;
  public String key;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(121106);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.key == null)
      {
        paramVarArgs = new b("Not all required fields were included: key");
        AppMethodBeat.o(121106);
        throw paramVarArgs;
      }
      if (this.key != null) {
        paramVarArgs.f(1, this.key);
      }
      paramVarArgs.bm(2, this.SnV);
      if (this.SnW != null) {
        paramVarArgs.f(3, this.SnW);
      }
      AppMethodBeat.o(121106);
      return 0;
    }
    if (paramInt == 1) {
      if (this.key == null) {
        break label366;
      }
    }
    label366:
    for (paramInt = g.a.a.b.b.a.g(1, this.key) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.p(2, this.SnV);
      paramInt = i;
      if (this.SnW != null) {
        paramInt = i + g.a.a.b.b.a.g(3, this.SnW);
      }
      AppMethodBeat.o(121106);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        if (this.key == null)
        {
          paramVarArgs = new b("Not all required fields were included: key");
          AppMethodBeat.o(121106);
          throw paramVarArgs;
        }
        AppMethodBeat.o(121106);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        ezm localezm = (ezm)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(121106);
          return -1;
        case 1: 
          localezm.key = locala.abFh.readString();
          AppMethodBeat.o(121106);
          return 0;
        case 2: 
          localezm.SnV = locala.abFh.AN();
          AppMethodBeat.o(121106);
          return 0;
        }
        localezm.SnW = locala.abFh.readString();
        AppMethodBeat.o(121106);
        return 0;
      }
      AppMethodBeat.o(121106);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ezm
 * JD-Core Version:    0.7.0.1
 */