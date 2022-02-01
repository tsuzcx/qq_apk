package com.tencent.mm.plugin.sns.j;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class l
  extends com.tencent.mm.bw.a
{
  public LinkedList<Long> DSa;
  public int DSb;
  public int DSc;
  public int DSd;
  public int state;
  public LinkedList<Long> tbl;
  public long timestamp;
  
  public l()
  {
    AppMethodBeat.i(179121);
    this.tbl = new LinkedList();
    this.DSa = new LinkedList();
    AppMethodBeat.o(179121);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(179122);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.e(1, 3, this.tbl);
      paramVarArgs.bb(2, this.timestamp);
      paramVarArgs.aM(3, this.state);
      paramVarArgs.e(4, 3, this.DSa);
      paramVarArgs.aM(5, this.DSb);
      paramVarArgs.aM(6, this.DSc);
      paramVarArgs.aM(7, this.DSd);
      AppMethodBeat.o(179122);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = g.a.a.a.c(1, 3, this.tbl);
      int i = g.a.a.b.b.a.r(2, this.timestamp);
      int j = g.a.a.b.b.a.bu(3, this.state);
      int k = g.a.a.a.c(4, 3, this.DSa);
      int m = g.a.a.b.b.a.bu(5, this.DSb);
      int n = g.a.a.b.b.a.bu(6, this.DSc);
      int i1 = g.a.a.b.b.a.bu(7, this.DSd);
      AppMethodBeat.o(179122);
      return paramInt + 0 + i + j + k + m + n + i1;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.tbl.clear();
      this.DSa.clear();
      paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.hPl();
        }
      }
      AppMethodBeat.o(179122);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      l locall = (l)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(179122);
        return -1;
      case 1: 
        locall.tbl.add(Long.valueOf(locala.UbS.zl()));
        AppMethodBeat.o(179122);
        return 0;
      case 2: 
        locall.timestamp = locala.UbS.zl();
        AppMethodBeat.o(179122);
        return 0;
      case 3: 
        locall.state = locala.UbS.zi();
        AppMethodBeat.o(179122);
        return 0;
      case 4: 
        locall.DSa.add(Long.valueOf(locala.UbS.zl()));
        AppMethodBeat.o(179122);
        return 0;
      case 5: 
        locall.DSb = locala.UbS.zi();
        AppMethodBeat.o(179122);
        return 0;
      case 6: 
        locall.DSc = locala.UbS.zi();
        AppMethodBeat.o(179122);
        return 0;
      }
      locall.DSd = locala.UbS.zi();
      AppMethodBeat.o(179122);
      return 0;
    }
    AppMethodBeat.o(179122);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.j.l
 * JD-Core Version:    0.7.0.1
 */