package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class awf
  extends com.tencent.mm.bv.a
{
  public float height;
  public String url;
  public float width;
  public String wug;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(48875);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.url != null) {
        paramVarArgs.e(1, this.url);
      }
      if (this.wug != null) {
        paramVarArgs.e(2, this.wug);
      }
      paramVarArgs.q(3, this.width);
      paramVarArgs.q(4, this.height);
      AppMethodBeat.o(48875);
      return 0;
    }
    if (paramInt == 1) {
      if (this.url == null) {
        break label368;
      }
    }
    label368:
    for (paramInt = e.a.a.b.b.a.f(1, this.url) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.wug != null) {
        i = paramInt + e.a.a.b.b.a.f(2, this.wug);
      }
      paramInt = e.a.a.b.b.a.eW(3);
      int j = e.a.a.b.b.a.eW(4);
      AppMethodBeat.o(48875);
      return i + (paramInt + 4) + (j + 4);
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(48875);
        return 0;
      }
      if (paramInt == 3)
      {
        e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
        awf localawf = (awf)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(48875);
          return -1;
        case 1: 
          localawf.url = locala.CLY.readString();
          AppMethodBeat.o(48875);
          return 0;
        case 2: 
          localawf.wug = locala.CLY.readString();
          AppMethodBeat.o(48875);
          return 0;
        case 3: 
          localawf.width = Float.intBitsToFloat(locala.CLY.emx());
          AppMethodBeat.o(48875);
          return 0;
        }
        localawf.height = Float.intBitsToFloat(locala.CLY.emx());
        AppMethodBeat.o(48875);
        return 0;
      }
      AppMethodBeat.o(48875);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.awf
 * JD-Core Version:    0.7.0.1
 */