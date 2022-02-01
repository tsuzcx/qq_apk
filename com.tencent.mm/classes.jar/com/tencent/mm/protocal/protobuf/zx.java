package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class zx
  extends com.tencent.mm.bx.a
{
  public String appId;
  public String appName;
  public String version;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(117856);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.appId != null) {
        paramVarArgs.d(1, this.appId);
      }
      if (this.appName != null) {
        paramVarArgs.d(2, this.appName);
      }
      if (this.version != null) {
        paramVarArgs.d(3, this.version);
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
    for (int i = f.a.a.b.b.a.e(1, this.appId) + 0;; i = 0)
    {
      paramInt = i;
      if (this.appName != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.appName);
      }
      i = paramInt;
      if (this.version != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.version);
      }
      AppMethodBeat.o(117856);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(117856);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        zx localzx = (zx)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(117856);
          return -1;
        case 1: 
          localzx.appId = locala.NPN.readString();
          AppMethodBeat.o(117856);
          return 0;
        case 2: 
          localzx.appName = locala.NPN.readString();
          AppMethodBeat.o(117856);
          return 0;
        }
        localzx.version = locala.NPN.readString();
        AppMethodBeat.o(117856);
        return 0;
      }
      AppMethodBeat.o(117856);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.zx
 * JD-Core Version:    0.7.0.1
 */