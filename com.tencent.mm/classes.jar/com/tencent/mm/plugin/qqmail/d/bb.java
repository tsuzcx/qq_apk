package com.tencent.mm.plugin.qqmail.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bb
  extends com.tencent.mm.cd.a
{
  public LinkedList<String> HnO;
  public long HnP;
  public long uin;
  
  public bb()
  {
    AppMethodBeat.i(251186);
    this.HnO = new LinkedList();
    AppMethodBeat.o(251186);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(251190);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bm(1, this.uin);
      paramVarArgs.e(2, 1, this.HnO);
      paramVarArgs.bm(3, this.HnP);
      AppMethodBeat.o(251190);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = g.a.a.b.b.a.p(1, this.uin);
      int i = g.a.a.a.c(2, 1, this.HnO);
      int j = g.a.a.b.b.a.p(3, this.HnP);
      AppMethodBeat.o(251190);
      return paramInt + 0 + i + j;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.HnO.clear();
      paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.iUs();
        }
      }
      AppMethodBeat.o(251190);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      bb localbb = (bb)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(251190);
        return -1;
      case 1: 
        localbb.uin = locala.abFh.AN();
        AppMethodBeat.o(251190);
        return 0;
      case 2: 
        localbb.HnO.add(locala.abFh.readString());
        AppMethodBeat.o(251190);
        return 0;
      }
      localbb.HnP = locala.abFh.AN();
      AppMethodBeat.o(251190);
      return 0;
    }
    AppMethodBeat.o(251190);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.qqmail.d.bb
 * JD-Core Version:    0.7.0.1
 */