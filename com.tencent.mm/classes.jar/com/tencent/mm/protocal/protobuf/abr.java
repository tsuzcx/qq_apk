package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class abr
  extends com.tencent.mm.bw.a
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
        paramVarArgs.e(1, this.appId);
      }
      if (this.appName != null) {
        paramVarArgs.e(2, this.appName);
      }
      if (this.version != null) {
        paramVarArgs.e(3, this.version);
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
    for (int i = g.a.a.b.b.a.f(1, this.appId) + 0;; i = 0)
    {
      paramInt = i;
      if (this.appName != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.appName);
      }
      i = paramInt;
      if (this.version != null) {
        i = paramInt + g.a.a.b.b.a.f(3, this.version);
      }
      AppMethodBeat.o(117856);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(117856);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        abr localabr = (abr)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(117856);
          return -1;
        case 1: 
          localabr.appId = locala.UbS.readString();
          AppMethodBeat.o(117856);
          return 0;
        case 2: 
          localabr.appName = locala.UbS.readString();
          AppMethodBeat.o(117856);
          return 0;
        }
        localabr.version = locala.UbS.readString();
        AppMethodBeat.o(117856);
        return 0;
      }
      AppMethodBeat.o(117856);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.abr
 * JD-Core Version:    0.7.0.1
 */