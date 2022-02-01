package com.tencent.mm.plugin.textstatus.proto;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ab
  extends com.tencent.mm.cd.a
{
  public String MFA;
  public String text;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(243614);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.MFA != null) {
        paramVarArgs.f(1, this.MFA);
      }
      if (this.text != null) {
        paramVarArgs.f(2, this.text);
      }
      AppMethodBeat.o(243614);
      return 0;
    }
    if (paramInt == 1) {
      if (this.MFA == null) {
        break label274;
      }
    }
    label274:
    for (paramInt = g.a.a.b.b.a.g(1, this.MFA) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.text != null) {
        i = paramInt + g.a.a.b.b.a.g(2, this.text);
      }
      AppMethodBeat.o(243614);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(243614);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        ab localab = (ab)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(243614);
          return -1;
        case 1: 
          localab.MFA = locala.abFh.readString();
          AppMethodBeat.o(243614);
          return 0;
        }
        localab.text = locala.abFh.readString();
        AppMethodBeat.o(243614);
        return 0;
      }
      AppMethodBeat.o(243614);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.textstatus.proto.ab
 * JD-Core Version:    0.7.0.1
 */