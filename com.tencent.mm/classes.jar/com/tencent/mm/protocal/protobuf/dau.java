package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dau
  extends com.tencent.mm.bx.a
{
  public long EsA;
  public LinkedList<String> EsB;
  public dap Esz;
  public long lastUpdateTime;
  public int pos;
  public int style;
  public int weight;
  
  public dau()
  {
    AppMethodBeat.i(124563);
    this.EsB = new LinkedList();
    AppMethodBeat.o(124563);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(124564);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.Esz != null)
      {
        paramVarArgs.kX(1, this.Esz.computeSize());
        this.Esz.writeFields(paramVarArgs);
      }
      paramVarArgs.aG(2, this.lastUpdateTime);
      paramVarArgs.aR(3, this.pos);
      paramVarArgs.aR(4, this.weight);
      paramVarArgs.aG(5, this.EsA);
      paramVarArgs.e(6, 1, this.EsB);
      paramVarArgs.aR(7, this.style);
      AppMethodBeat.o(124564);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Esz == null) {
        break label602;
      }
    }
    label602:
    for (paramInt = f.a.a.a.kW(1, this.Esz.computeSize()) + 0;; paramInt = 0)
    {
      int i = f.a.a.b.b.a.q(2, this.lastUpdateTime);
      int j = f.a.a.b.b.a.bA(3, this.pos);
      int k = f.a.a.b.b.a.bA(4, this.weight);
      int m = f.a.a.b.b.a.q(5, this.EsA);
      int n = f.a.a.a.c(6, 1, this.EsB);
      int i1 = f.a.a.b.b.a.bA(7, this.style);
      AppMethodBeat.o(124564);
      return paramInt + i + j + k + m + n + i1;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.EsB.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(124564);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        dau localdau = (dau)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(124564);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dap();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((dap)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdau.Esz = ((dap)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(124564);
          return 0;
        case 2: 
          localdau.lastUpdateTime = ((f.a.a.a.a)localObject1).KhF.xT();
          AppMethodBeat.o(124564);
          return 0;
        case 3: 
          localdau.pos = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(124564);
          return 0;
        case 4: 
          localdau.weight = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(124564);
          return 0;
        case 5: 
          localdau.EsA = ((f.a.a.a.a)localObject1).KhF.xT();
          AppMethodBeat.o(124564);
          return 0;
        case 6: 
          localdau.EsB.add(((f.a.a.a.a)localObject1).KhF.readString());
          AppMethodBeat.o(124564);
          return 0;
        }
        localdau.style = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(124564);
        return 0;
      }
      AppMethodBeat.o(124564);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dau
 * JD-Core Version:    0.7.0.1
 */