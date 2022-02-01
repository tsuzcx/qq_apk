package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class cgk
  extends com.tencent.mm.bw.a
{
  public String key;
  public String url;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(152657);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.key != null) {
        paramVarArgs.d(1, this.key);
      }
      if (this.url != null) {
        paramVarArgs.d(2, this.url);
      }
      AppMethodBeat.o(152657);
      return 0;
    }
    if (paramInt == 1) {
      if (this.key == null) {
        break label274;
      }
    }
    label274:
    for (paramInt = f.a.a.b.b.a.e(1, this.key) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.url != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.url);
      }
      AppMethodBeat.o(152657);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(152657);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        cgk localcgk = (cgk)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(152657);
          return -1;
        case 1: 
          localcgk.key = locala.OmT.readString();
          AppMethodBeat.o(152657);
          return 0;
        }
        localcgk.url = locala.OmT.readString();
        AppMethodBeat.o(152657);
        return 0;
      }
      AppMethodBeat.o(152657);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cgk
 * JD-Core Version:    0.7.0.1
 */