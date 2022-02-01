package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;

public final class ecv
  extends com.tencent.mm.bw.a
{
  public String content;
  public String type;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32456);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.type == null)
      {
        paramVarArgs = new b("Not all required fields were included: type");
        AppMethodBeat.o(32456);
        throw paramVarArgs;
      }
      if (this.type != null) {
        paramVarArgs.e(1, this.type);
      }
      if (this.content != null) {
        paramVarArgs.e(2, this.content);
      }
      AppMethodBeat.o(32456);
      return 0;
    }
    if (paramInt == 1) {
      if (this.type == null) {
        break label334;
      }
    }
    label334:
    for (paramInt = g.a.a.b.b.a.f(1, this.type) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.content != null) {
        i = paramInt + g.a.a.b.b.a.f(2, this.content);
      }
      AppMethodBeat.o(32456);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        if (this.type == null)
        {
          paramVarArgs = new b("Not all required fields were included: type");
          AppMethodBeat.o(32456);
          throw paramVarArgs;
        }
        AppMethodBeat.o(32456);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        ecv localecv = (ecv)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(32456);
          return -1;
        case 1: 
          localecv.type = locala.UbS.readString();
          AppMethodBeat.o(32456);
          return 0;
        }
        localecv.content = locala.UbS.readString();
        AppMethodBeat.o(32456);
        return 0;
      }
      AppMethodBeat.o(32456);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ecv
 * JD-Core Version:    0.7.0.1
 */