package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bgy
  extends com.tencent.mm.bw.a
{
  public LinkedList<cmt> GzC;
  public long KPk;
  public long KPl;
  public boolean KPn;
  public dus LQH;
  public long LQI;
  public long LQJ;
  public long LQK;
  public long LQL;
  public long LQM;
  public long uin;
  
  public bgy()
  {
    AppMethodBeat.i(110895);
    this.GzC = new LinkedList();
    this.LQI = 10L;
    this.LQJ = 0L;
    this.KPn = false;
    this.LQK = 0L;
    this.LQL = 0L;
    this.LQM = 0L;
    AppMethodBeat.o(110895);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(110896);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bb(1, this.KPk);
      paramVarArgs.bb(2, this.uin);
      paramVarArgs.bb(3, this.KPl);
      paramVarArgs.e(4, 8, this.GzC);
      if (this.LQH != null)
      {
        paramVarArgs.ni(5, this.LQH.computeSize());
        this.LQH.writeFields(paramVarArgs);
      }
      paramVarArgs.bb(6, this.LQI);
      paramVarArgs.bb(7, this.LQJ);
      paramVarArgs.cc(8, this.KPn);
      paramVarArgs.bb(9, this.LQK);
      paramVarArgs.bb(10, this.LQL);
      paramVarArgs.bb(11, this.LQM);
      AppMethodBeat.o(110896);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = g.a.a.b.b.a.r(1, this.KPk) + 0 + g.a.a.b.b.a.r(2, this.uin) + g.a.a.b.b.a.r(3, this.KPl) + g.a.a.a.c(4, 8, this.GzC);
      paramInt = i;
      if (this.LQH != null) {
        paramInt = i + g.a.a.a.nh(5, this.LQH.computeSize());
      }
      i = g.a.a.b.b.a.r(6, this.LQI);
      int j = g.a.a.b.b.a.r(7, this.LQJ);
      int k = g.a.a.b.b.a.fS(8);
      int m = g.a.a.b.b.a.r(9, this.LQK);
      int n = g.a.a.b.b.a.r(10, this.LQL);
      int i1 = g.a.a.b.b.a.r(11, this.LQM);
      AppMethodBeat.o(110896);
      return paramInt + i + j + (k + 1) + m + n + i1;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.GzC.clear();
      paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.hPl();
        }
      }
      AppMethodBeat.o(110896);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
      bgy localbgy = (bgy)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(110896);
        return -1;
      case 1: 
        localbgy.KPk = ((g.a.a.a.a)localObject1).UbS.zl();
        AppMethodBeat.o(110896);
        return 0;
      case 2: 
        localbgy.uin = ((g.a.a.a.a)localObject1).UbS.zl();
        AppMethodBeat.o(110896);
        return 0;
      case 3: 
        localbgy.KPl = ((g.a.a.a.a)localObject1).UbS.zl();
        AppMethodBeat.o(110896);
        return 0;
      case 4: 
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new cmt();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((cmt)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localbgy.GzC.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(110896);
        return 0;
      case 5: 
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new dus();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((dus)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localbgy.LQH = ((dus)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(110896);
        return 0;
      case 6: 
        localbgy.LQI = ((g.a.a.a.a)localObject1).UbS.zl();
        AppMethodBeat.o(110896);
        return 0;
      case 7: 
        localbgy.LQJ = ((g.a.a.a.a)localObject1).UbS.zl();
        AppMethodBeat.o(110896);
        return 0;
      case 8: 
        localbgy.KPn = ((g.a.a.a.a)localObject1).UbS.yZ();
        AppMethodBeat.o(110896);
        return 0;
      case 9: 
        localbgy.LQK = ((g.a.a.a.a)localObject1).UbS.zl();
        AppMethodBeat.o(110896);
        return 0;
      case 10: 
        localbgy.LQL = ((g.a.a.a.a)localObject1).UbS.zl();
        AppMethodBeat.o(110896);
        return 0;
      }
      localbgy.LQM = ((g.a.a.a.a)localObject1).UbS.zl();
      AppMethodBeat.o(110896);
      return 0;
    }
    AppMethodBeat.o(110896);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bgy
 * JD-Core Version:    0.7.0.1
 */