package com.tencent.mm.plugin.textstatus.proto;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ap
  extends com.tencent.mm.cd.a
{
  public String MGH;
  public String content;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(235674);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.content != null) {
        paramVarArgs.f(1, this.content);
      }
      if (this.MGH != null) {
        paramVarArgs.f(2, this.MGH);
      }
      AppMethodBeat.o(235674);
      return 0;
    }
    if (paramInt == 1) {
      if (this.content == null) {
        break label274;
      }
    }
    label274:
    for (paramInt = g.a.a.b.b.a.g(1, this.content) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.MGH != null) {
        i = paramInt + g.a.a.b.b.a.g(2, this.MGH);
      }
      AppMethodBeat.o(235674);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(235674);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        ap localap = (ap)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(235674);
          return -1;
        case 1: 
          localap.content = locala.abFh.readString();
          AppMethodBeat.o(235674);
          return 0;
        }
        localap.MGH = locala.abFh.readString();
        AppMethodBeat.o(235674);
        return 0;
      }
      AppMethodBeat.o(235674);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.textstatus.proto.ap
 * JD-Core Version:    0.7.0.1
 */