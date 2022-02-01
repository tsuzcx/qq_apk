package com.tencent.mm.plugin.qqmail.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bb
  extends com.tencent.mm.bw.a
{
  public long uin;
  public LinkedList<String> xtr;
  public long xts;
  
  public bb()
  {
    AppMethodBeat.i(217991);
    this.xtr = new LinkedList();
    AppMethodBeat.o(217991);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(217992);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aZ(1, this.uin);
      paramVarArgs.e(2, 1, this.xtr);
      paramVarArgs.aZ(3, this.xts);
      AppMethodBeat.o(217992);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = f.a.a.b.b.a.p(1, this.uin);
      int i = f.a.a.a.c(2, 1, this.xtr);
      int j = f.a.a.b.b.a.p(3, this.xts);
      AppMethodBeat.o(217992);
      return paramInt + 0 + i + j;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.xtr.clear();
      paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gCg();
        }
      }
      AppMethodBeat.o(217992);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      bb localbb = (bb)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(217992);
        return -1;
      case 1: 
        localbb.uin = locala.OmT.zd();
        AppMethodBeat.o(217992);
        return 0;
      case 2: 
        localbb.xtr.add(locala.OmT.readString());
        AppMethodBeat.o(217992);
        return 0;
      }
      localbb.xts = locala.OmT.zd();
      AppMethodBeat.o(217992);
      return 0;
    }
    AppMethodBeat.o(217992);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.qqmail.d.bb
 * JD-Core Version:    0.7.0.1
 */