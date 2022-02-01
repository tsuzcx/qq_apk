package com.tencent.mm.plugin.qqmail.d;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ay
  extends com.tencent.mm.bw.a
{
  public long xti;
  public String xtj;
  public String xtk;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(217987);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aZ(1, this.xti);
      if (this.xtj != null) {
        paramVarArgs.d(2, this.xtj);
      }
      if (this.xtk != null) {
        paramVarArgs.d(3, this.xtk);
      }
      AppMethodBeat.o(217987);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.p(1, this.xti) + 0;
      paramInt = i;
      if (this.xtj != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.xtj);
      }
      i = paramInt;
      if (this.xtk != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.xtk);
      }
      AppMethodBeat.o(217987);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gCg();
        }
      }
      AppMethodBeat.o(217987);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      ay localay = (ay)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(217987);
        return -1;
      case 1: 
        localay.xti = locala.OmT.zd();
        AppMethodBeat.o(217987);
        return 0;
      case 2: 
        localay.xtj = locala.OmT.readString();
        AppMethodBeat.o(217987);
        return 0;
      }
      localay.xtk = locala.OmT.readString();
      AppMethodBeat.o(217987);
      return 0;
    }
    AppMethodBeat.o(217987);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.qqmail.d.ay
 * JD-Core Version:    0.7.0.1
 */