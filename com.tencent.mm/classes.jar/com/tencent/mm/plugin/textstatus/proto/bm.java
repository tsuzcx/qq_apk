package com.tencent.mm.plugin.textstatus.proto;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bm
  extends com.tencent.mm.bx.a
{
  public String Trr;
  public String content;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(289908);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.content != null) {
        paramVarArgs.g(1, this.content);
      }
      if (this.Trr != null) {
        paramVarArgs.g(2, this.Trr);
      }
      AppMethodBeat.o(289908);
      return 0;
    }
    if (paramInt == 1) {
      if (this.content == null) {
        break label270;
      }
    }
    label270:
    for (paramInt = i.a.a.b.b.a.h(1, this.content) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.Trr != null) {
        i = paramInt + i.a.a.b.b.a.h(2, this.Trr);
      }
      AppMethodBeat.o(289908);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(289908);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        bm localbm = (bm)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(289908);
          return -1;
        case 1: 
          localbm.content = locala.ajGk.readString();
          AppMethodBeat.o(289908);
          return 0;
        }
        localbm.Trr = locala.ajGk.readString();
        AppMethodBeat.o(289908);
        return 0;
      }
      AppMethodBeat.o(289908);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.textstatus.proto.bm
 * JD-Core Version:    0.7.0.1
 */