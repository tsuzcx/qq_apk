package com.tencent.mm.plugin.qqmail.d;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class al
  extends com.tencent.mm.bw.a
{
  public String BsK;
  public String nickname;
  public long uin;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(198628);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.nickname != null) {
        paramVarArgs.e(1, this.nickname);
      }
      if (this.BsK != null) {
        paramVarArgs.e(2, this.BsK);
      }
      paramVarArgs.bb(3, this.uin);
      AppMethodBeat.o(198628);
      return 0;
    }
    if (paramInt == 1) {
      if (this.nickname == null) {
        break label318;
      }
    }
    label318:
    for (paramInt = g.a.a.b.b.a.f(1, this.nickname) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.BsK != null) {
        i = paramInt + g.a.a.b.b.a.f(2, this.BsK);
      }
      paramInt = g.a.a.b.b.a.r(3, this.uin);
      AppMethodBeat.o(198628);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(198628);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        al localal = (al)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(198628);
          return -1;
        case 1: 
          localal.nickname = locala.UbS.readString();
          AppMethodBeat.o(198628);
          return 0;
        case 2: 
          localal.BsK = locala.UbS.readString();
          AppMethodBeat.o(198628);
          return 0;
        }
        localal.uin = locala.UbS.zl();
        AppMethodBeat.o(198628);
        return 0;
      }
      AppMethodBeat.o(198628);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.qqmail.d.al
 * JD-Core Version:    0.7.0.1
 */