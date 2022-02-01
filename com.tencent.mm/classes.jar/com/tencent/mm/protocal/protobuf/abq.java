package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class abq
  extends com.tencent.mm.bw.a
{
  public String content;
  public String url;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(214283);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.content != null) {
        paramVarArgs.e(1, this.content);
      }
      if (this.url != null) {
        paramVarArgs.e(2, this.url);
      }
      AppMethodBeat.o(214283);
      return 0;
    }
    if (paramInt == 1) {
      if (this.content == null) {
        break label274;
      }
    }
    label274:
    for (paramInt = g.a.a.b.b.a.f(1, this.content) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.url != null) {
        i = paramInt + g.a.a.b.b.a.f(2, this.url);
      }
      AppMethodBeat.o(214283);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(214283);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        abq localabq = (abq)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(214283);
          return -1;
        case 1: 
          localabq.content = locala.UbS.readString();
          AppMethodBeat.o(214283);
          return 0;
        }
        localabq.url = locala.UbS.readString();
        AppMethodBeat.o(214283);
        return 0;
      }
      AppMethodBeat.o(214283);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.abq
 * JD-Core Version:    0.7.0.1
 */