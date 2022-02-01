package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;

public final class cmy
  extends com.tencent.mm.bw.a
{
  public String md5;
  public String uuid;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(169218);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.md5 == null)
      {
        paramVarArgs = new b("Not all required fields were included: md5");
        AppMethodBeat.o(169218);
        throw paramVarArgs;
      }
      if (this.md5 != null) {
        paramVarArgs.e(1, this.md5);
      }
      if (this.uuid != null) {
        paramVarArgs.e(2, this.uuid);
      }
      AppMethodBeat.o(169218);
      return 0;
    }
    if (paramInt == 1) {
      if (this.md5 == null) {
        break label322;
      }
    }
    label322:
    for (paramInt = g.a.a.b.b.a.f(1, this.md5) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.uuid != null) {
        i = paramInt + g.a.a.b.b.a.f(2, this.uuid);
      }
      AppMethodBeat.o(169218);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        if (this.md5 == null)
        {
          paramVarArgs = new b("Not all required fields were included: md5");
          AppMethodBeat.o(169218);
          throw paramVarArgs;
        }
        AppMethodBeat.o(169218);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        cmy localcmy = (cmy)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(169218);
          return -1;
        case 1: 
          localcmy.md5 = locala.UbS.readString();
          AppMethodBeat.o(169218);
          return 0;
        }
        localcmy.uuid = locala.UbS.readString();
        AppMethodBeat.o(169218);
        return 0;
      }
      AppMethodBeat.o(169218);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cmy
 * JD-Core Version:    0.7.0.1
 */