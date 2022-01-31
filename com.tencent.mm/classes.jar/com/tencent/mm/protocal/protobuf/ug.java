package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ug
  extends com.tencent.mm.bv.a
{
  public String appId;
  public String appName;
  public String version;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(124304);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.appId != null) {
        paramVarArgs.e(1, this.appId);
      }
      if (this.appName != null) {
        paramVarArgs.e(2, this.appName);
      }
      if (this.version != null) {
        paramVarArgs.e(3, this.version);
      }
      AppMethodBeat.o(124304);
      return 0;
    }
    if (paramInt == 1) {
      if (this.appId == null) {
        break label334;
      }
    }
    label334:
    for (int i = e.a.a.b.b.a.f(1, this.appId) + 0;; i = 0)
    {
      paramInt = i;
      if (this.appName != null) {
        paramInt = i + e.a.a.b.b.a.f(2, this.appName);
      }
      i = paramInt;
      if (this.version != null) {
        i = paramInt + e.a.a.b.b.a.f(3, this.version);
      }
      AppMethodBeat.o(124304);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(124304);
        return 0;
      }
      if (paramInt == 3)
      {
        e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
        ug localug = (ug)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(124304);
          return -1;
        case 1: 
          localug.appId = locala.CLY.readString();
          AppMethodBeat.o(124304);
          return 0;
        case 2: 
          localug.appName = locala.CLY.readString();
          AppMethodBeat.o(124304);
          return 0;
        }
        localug.version = locala.CLY.readString();
        AppMethodBeat.o(124304);
        return 0;
      }
      AppMethodBeat.o(124304);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ug
 * JD-Core Version:    0.7.0.1
 */