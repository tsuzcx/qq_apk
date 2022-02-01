package com.tencent.mm.plugin.qqmail.d;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class al
  extends com.tencent.mm.cd.a
{
  public String Hne;
  public String nickname;
  public long uin;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(250441);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.nickname != null) {
        paramVarArgs.f(1, this.nickname);
      }
      if (this.Hne != null) {
        paramVarArgs.f(2, this.Hne);
      }
      paramVarArgs.bm(3, this.uin);
      AppMethodBeat.o(250441);
      return 0;
    }
    if (paramInt == 1) {
      if (this.nickname == null) {
        break label318;
      }
    }
    label318:
    for (paramInt = g.a.a.b.b.a.g(1, this.nickname) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.Hne != null) {
        i = paramInt + g.a.a.b.b.a.g(2, this.Hne);
      }
      paramInt = g.a.a.b.b.a.p(3, this.uin);
      AppMethodBeat.o(250441);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(250441);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        al localal = (al)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(250441);
          return -1;
        case 1: 
          localal.nickname = locala.abFh.readString();
          AppMethodBeat.o(250441);
          return 0;
        case 2: 
          localal.Hne = locala.abFh.readString();
          AppMethodBeat.o(250441);
          return 0;
        }
        localal.uin = locala.abFh.AN();
        AppMethodBeat.o(250441);
        return 0;
      }
      AppMethodBeat.o(250441);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.qqmail.d.al
 * JD-Core Version:    0.7.0.1
 */