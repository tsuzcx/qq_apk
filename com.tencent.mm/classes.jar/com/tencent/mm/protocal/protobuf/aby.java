package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class aby
  extends com.tencent.mm.cd.a
{
  public String appId;
  public String appName;
  public String version;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(117856);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.appId != null) {
        paramVarArgs.f(1, this.appId);
      }
      if (this.appName != null) {
        paramVarArgs.f(2, this.appName);
      }
      if (this.version != null) {
        paramVarArgs.f(3, this.version);
      }
      AppMethodBeat.o(117856);
      return 0;
    }
    if (paramInt == 1) {
      if (this.appId == null) {
        break label334;
      }
    }
    label334:
    for (int i = g.a.a.b.b.a.g(1, this.appId) + 0;; i = 0)
    {
      paramInt = i;
      if (this.appName != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.appName);
      }
      i = paramInt;
      if (this.version != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.version);
      }
      AppMethodBeat.o(117856);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(117856);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        aby localaby = (aby)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(117856);
          return -1;
        case 1: 
          localaby.appId = locala.abFh.readString();
          AppMethodBeat.o(117856);
          return 0;
        case 2: 
          localaby.appName = locala.abFh.readString();
          AppMethodBeat.o(117856);
          return 0;
        }
        localaby.version = locala.abFh.readString();
        AppMethodBeat.o(117856);
        return 0;
      }
      AppMethodBeat.o(117856);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aby
 * JD-Core Version:    0.7.0.1
 */