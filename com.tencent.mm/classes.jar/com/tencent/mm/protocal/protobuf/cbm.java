package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cbm
  extends com.tencent.mm.bw.a
{
  public LinkedList<cbn> LPG;
  public LinkedList<erd> LPH;
  public LinkedList<cbn> Mho;
  public int aHK;
  public int count;
  public String dMl;
  public String dRM;
  public long duration;
  public long startTime;
  
  public cbm()
  {
    AppMethodBeat.i(122512);
    this.dMl = "";
    this.startTime = 0L;
    this.duration = 0L;
    this.dRM = "";
    this.LPG = new LinkedList();
    this.count = 1;
    this.Mho = new LinkedList();
    this.LPH = new LinkedList();
    AppMethodBeat.o(122512);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(122513);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.dMl != null) {
        paramVarArgs.e(1, this.dMl);
      }
      paramVarArgs.bb(2, this.startTime);
      paramVarArgs.bb(3, this.duration);
      if (this.dRM != null) {
        paramVarArgs.e(4, this.dRM);
      }
      paramVarArgs.e(5, 8, this.LPG);
      paramVarArgs.aM(6, this.count);
      paramVarArgs.e(7, 8, this.Mho);
      paramVarArgs.e(8, 8, this.LPH);
      paramVarArgs.aM(9, this.aHK);
      AppMethodBeat.o(122513);
      return 0;
    }
    if (paramInt == 1) {
      if (this.dMl == null) {
        break label886;
      }
    }
    label886:
    for (paramInt = g.a.a.b.b.a.f(1, this.dMl) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.r(2, this.startTime) + g.a.a.b.b.a.r(3, this.duration);
      paramInt = i;
      if (this.dRM != null) {
        paramInt = i + g.a.a.b.b.a.f(4, this.dRM);
      }
      i = g.a.a.a.c(5, 8, this.LPG);
      int j = g.a.a.b.b.a.bu(6, this.count);
      int k = g.a.a.a.c(7, 8, this.Mho);
      int m = g.a.a.a.c(8, 8, this.LPH);
      int n = g.a.a.b.b.a.bu(9, this.aHK);
      AppMethodBeat.o(122513);
      return paramInt + i + j + k + m + n;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.LPG.clear();
        this.Mho.clear();
        this.LPH.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(122513);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        cbm localcbm = (cbm)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(122513);
          return -1;
        case 1: 
          localcbm.dMl = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(122513);
          return 0;
        case 2: 
          localcbm.startTime = ((g.a.a.a.a)localObject1).UbS.zl();
          AppMethodBeat.o(122513);
          return 0;
        case 3: 
          localcbm.duration = ((g.a.a.a.a)localObject1).UbS.zl();
          AppMethodBeat.o(122513);
          return 0;
        case 4: 
          localcbm.dRM = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(122513);
          return 0;
        case 5: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cbn();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cbn)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localcbm.LPG.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(122513);
          return 0;
        case 6: 
          localcbm.count = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(122513);
          return 0;
        case 7: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cbn();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cbn)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localcbm.Mho.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(122513);
          return 0;
        case 8: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new erd();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((erd)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localcbm.LPH.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(122513);
          return 0;
        }
        localcbm.aHK = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(122513);
        return 0;
      }
      AppMethodBeat.o(122513);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cbm
 * JD-Core Version:    0.7.0.1
 */