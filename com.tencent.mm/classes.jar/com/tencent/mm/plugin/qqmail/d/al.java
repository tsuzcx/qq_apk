package com.tencent.mm.plugin.qqmail.d;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class al
  extends com.tencent.mm.bw.a
{
  public String nickname;
  public long uin;
  public String xsH;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(217972);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.nickname != null) {
        paramVarArgs.d(1, this.nickname);
      }
      if (this.xsH != null) {
        paramVarArgs.d(2, this.xsH);
      }
      paramVarArgs.aZ(3, this.uin);
      AppMethodBeat.o(217972);
      return 0;
    }
    if (paramInt == 1) {
      if (this.nickname == null) {
        break label318;
      }
    }
    label318:
    for (paramInt = f.a.a.b.b.a.e(1, this.nickname) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.xsH != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.xsH);
      }
      paramInt = f.a.a.b.b.a.p(3, this.uin);
      AppMethodBeat.o(217972);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(217972);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        al localal = (al)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(217972);
          return -1;
        case 1: 
          localal.nickname = locala.OmT.readString();
          AppMethodBeat.o(217972);
          return 0;
        case 2: 
          localal.xsH = locala.OmT.readString();
          AppMethodBeat.o(217972);
          return 0;
        }
        localal.uin = locala.OmT.zd();
        AppMethodBeat.o(217972);
        return 0;
      }
      AppMethodBeat.o(217972);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.qqmail.d.al
 * JD-Core Version:    0.7.0.1
 */