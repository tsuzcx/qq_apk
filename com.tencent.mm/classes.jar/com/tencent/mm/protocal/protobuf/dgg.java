package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dgg
  extends com.tencent.mm.bw.a
{
  public dgb FPB;
  public long FPC;
  public LinkedList<String> FPD;
  public long lastUpdateTime;
  public int pos;
  public int style;
  public int weight;
  
  public dgg()
  {
    AppMethodBeat.i(124563);
    this.FPD = new LinkedList();
    AppMethodBeat.o(124563);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(124564);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.FPB != null)
      {
        paramVarArgs.ln(1, this.FPB.computeSize());
        this.FPB.writeFields(paramVarArgs);
      }
      paramVarArgs.aO(2, this.lastUpdateTime);
      paramVarArgs.aR(3, this.pos);
      paramVarArgs.aR(4, this.weight);
      paramVarArgs.aO(5, this.FPC);
      paramVarArgs.e(6, 1, this.FPD);
      paramVarArgs.aR(7, this.style);
      AppMethodBeat.o(124564);
      return 0;
    }
    if (paramInt == 1) {
      if (this.FPB == null) {
        break label602;
      }
    }
    label602:
    for (paramInt = f.a.a.a.lm(1, this.FPB.computeSize()) + 0;; paramInt = 0)
    {
      int i = f.a.a.b.b.a.p(2, this.lastUpdateTime);
      int j = f.a.a.b.b.a.bx(3, this.pos);
      int k = f.a.a.b.b.a.bx(4, this.weight);
      int m = f.a.a.b.b.a.p(5, this.FPC);
      int n = f.a.a.a.c(6, 1, this.FPD);
      int i1 = f.a.a.b.b.a.bx(7, this.style);
      AppMethodBeat.o(124564);
      return paramInt + i + j + k + m + n + i1;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.FPD.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(124564);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        dgg localdgg = (dgg)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(124564);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dgb();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((dgb)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdgg.FPB = ((dgb)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(124564);
          return 0;
        case 2: 
          localdgg.lastUpdateTime = ((f.a.a.a.a)localObject1).LVo.xG();
          AppMethodBeat.o(124564);
          return 0;
        case 3: 
          localdgg.pos = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(124564);
          return 0;
        case 4: 
          localdgg.weight = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(124564);
          return 0;
        case 5: 
          localdgg.FPC = ((f.a.a.a.a)localObject1).LVo.xG();
          AppMethodBeat.o(124564);
          return 0;
        case 6: 
          localdgg.FPD.add(((f.a.a.a.a)localObject1).LVo.readString());
          AppMethodBeat.o(124564);
          return 0;
        }
        localdgg.style = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(124564);
        return 0;
      }
      AppMethodBeat.o(124564);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dgg
 * JD-Core Version:    0.7.0.1
 */