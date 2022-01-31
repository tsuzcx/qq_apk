package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ax
  extends com.tencent.mm.bv.a
{
  public String text;
  public String url;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(89003);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.text != null) {
        paramVarArgs.e(1, this.text);
      }
      if (this.url != null) {
        paramVarArgs.e(2, this.url);
      }
      AppMethodBeat.o(89003);
      return 0;
    }
    if (paramInt == 1) {
      if (this.text == null) {
        break label274;
      }
    }
    label274:
    for (paramInt = e.a.a.b.b.a.f(1, this.text) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.url != null) {
        i = paramInt + e.a.a.b.b.a.f(2, this.url);
      }
      AppMethodBeat.o(89003);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(89003);
        return 0;
      }
      if (paramInt == 3)
      {
        e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
        ax localax = (ax)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(89003);
          return -1;
        case 1: 
          localax.text = locala.CLY.readString();
          AppMethodBeat.o(89003);
          return 0;
        }
        localax.url = locala.CLY.readString();
        AppMethodBeat.o(89003);
        return 0;
      }
      AppMethodBeat.o(89003);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ax
 * JD-Core Version:    0.7.0.1
 */