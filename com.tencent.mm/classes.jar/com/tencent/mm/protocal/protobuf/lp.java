package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class lp
  extends com.tencent.mm.bw.a
{
  public long KPk;
  public long KPl;
  public LinkedList<ln> KPm;
  public boolean KPn;
  public long uin;
  
  public lp()
  {
    AppMethodBeat.i(110888);
    this.KPm = new LinkedList();
    this.KPn = false;
    AppMethodBeat.o(110888);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(110889);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bb(1, this.KPk);
      paramVarArgs.bb(2, this.uin);
      paramVarArgs.bb(3, this.KPl);
      paramVarArgs.e(4, 8, this.KPm);
      paramVarArgs.cc(5, this.KPn);
      AppMethodBeat.o(110889);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      paramInt = g.a.a.b.b.a.r(1, this.KPk);
      i = g.a.a.b.b.a.r(2, this.uin);
      int j = g.a.a.b.b.a.r(3, this.KPl);
      int k = g.a.a.a.c(4, 8, this.KPm);
      int m = g.a.a.b.b.a.fS(5);
      AppMethodBeat.o(110889);
      return paramInt + 0 + i + j + k + (m + 1);
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.KPm.clear();
      paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.hPl();
        }
      }
      AppMethodBeat.o(110889);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
      lp locallp = (lp)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(110889);
        return -1;
      case 1: 
        locallp.KPk = ((g.a.a.a.a)localObject1).UbS.zl();
        AppMethodBeat.o(110889);
        return 0;
      case 2: 
        locallp.uin = ((g.a.a.a.a)localObject1).UbS.zl();
        AppMethodBeat.o(110889);
        return 0;
      case 3: 
        locallp.KPl = ((g.a.a.a.a)localObject1).UbS.zl();
        AppMethodBeat.o(110889);
        return 0;
      case 4: 
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new ln();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((ln)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          locallp.KPm.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(110889);
        return 0;
      }
      locallp.KPn = ((g.a.a.a.a)localObject1).UbS.yZ();
      AppMethodBeat.o(110889);
      return 0;
    }
    AppMethodBeat.o(110889);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.lp
 * JD-Core Version:    0.7.0.1
 */