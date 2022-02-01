package com.tencent.mm.plugin.sns.j;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class l
  extends com.tencent.mm.cd.a
{
  public LinkedList<Long> Kfh;
  public int Kfi;
  public int Kfj;
  public int Kfk;
  public LinkedList<Long> Kfl;
  public LinkedList<String> lBi;
  public int state;
  public long timestamp;
  public LinkedList<Long> wHq;
  
  public l()
  {
    AppMethodBeat.i(179121);
    this.wHq = new LinkedList();
    this.Kfh = new LinkedList();
    this.lBi = new LinkedList();
    this.Kfl = new LinkedList();
    AppMethodBeat.o(179121);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(179122);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.e(1, 3, this.wHq);
      paramVarArgs.bm(2, this.timestamp);
      paramVarArgs.aY(3, this.state);
      paramVarArgs.e(4, 3, this.Kfh);
      paramVarArgs.aY(5, this.Kfi);
      paramVarArgs.aY(6, this.Kfj);
      paramVarArgs.aY(7, this.Kfk);
      paramVarArgs.e(8, 1, this.lBi);
      paramVarArgs.e(9, 3, this.Kfl);
      AppMethodBeat.o(179122);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = g.a.a.a.c(1, 3, this.wHq);
      int i = g.a.a.b.b.a.p(2, this.timestamp);
      int j = g.a.a.b.b.a.bM(3, this.state);
      int k = g.a.a.a.c(4, 3, this.Kfh);
      int m = g.a.a.b.b.a.bM(5, this.Kfi);
      int n = g.a.a.b.b.a.bM(6, this.Kfj);
      int i1 = g.a.a.b.b.a.bM(7, this.Kfk);
      int i2 = g.a.a.a.c(8, 1, this.lBi);
      int i3 = g.a.a.a.c(9, 3, this.Kfl);
      AppMethodBeat.o(179122);
      return paramInt + 0 + i + j + k + m + n + i1 + i2 + i3;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.wHq.clear();
      this.Kfh.clear();
      this.lBi.clear();
      this.Kfl.clear();
      paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.iUs();
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
        locall.wHq.add(Long.valueOf(locala.abFh.AN()));
        AppMethodBeat.o(179122);
        return 0;
      case 2: 
        locall.timestamp = locala.abFh.AN();
        AppMethodBeat.o(179122);
        return 0;
      case 3: 
        locall.state = locala.abFh.AK();
        AppMethodBeat.o(179122);
        return 0;
      case 4: 
        locall.Kfh.add(Long.valueOf(locala.abFh.AN()));
        AppMethodBeat.o(179122);
        return 0;
      case 5: 
        locall.Kfi = locala.abFh.AK();
        AppMethodBeat.o(179122);
        return 0;
      case 6: 
        locall.Kfj = locala.abFh.AK();
        AppMethodBeat.o(179122);
        return 0;
      case 7: 
        locall.Kfk = locala.abFh.AK();
        AppMethodBeat.o(179122);
        return 0;
      case 8: 
        locall.lBi.add(locala.abFh.readString());
        AppMethodBeat.o(179122);
        return 0;
      }
      locall.Kfl.add(Long.valueOf(locala.abFh.AN()));
      AppMethodBeat.o(179122);
      return 0;
    }
    AppMethodBeat.o(179122);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.j.l
 * JD-Core Version:    0.7.0.1
 */