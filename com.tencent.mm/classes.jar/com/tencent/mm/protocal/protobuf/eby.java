package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class eby
  extends com.tencent.mm.bw.a
{
  public int NbD;
  public int NbE;
  public int NbF;
  public esq NbG;
  public int NbH;
  public int NbI;
  public int NbJ;
  public int NbK;
  public LinkedList<Integer> NbL;
  public int NbM;
  public LinkedList<Integer> NbN;
  public int NbO;
  public LinkedList<Integer> NbP;
  public String NbQ;
  
  public eby()
  {
    AppMethodBeat.i(115851);
    this.NbL = new LinkedList();
    this.NbN = new LinkedList();
    this.NbP = new LinkedList();
    AppMethodBeat.o(115851);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(115852);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.NbG == null)
      {
        paramVarArgs = new g.a.a.b("Not all required fields were included: Addr");
        AppMethodBeat.o(115852);
        throw paramVarArgs;
      }
      paramVarArgs.aM(1, this.NbD);
      paramVarArgs.aM(2, this.NbE);
      paramVarArgs.aM(3, this.NbF);
      if (this.NbG != null)
      {
        paramVarArgs.ni(4, this.NbG.computeSize());
        this.NbG.writeFields(paramVarArgs);
      }
      paramVarArgs.aM(5, this.NbH);
      paramVarArgs.aM(6, this.NbI);
      paramVarArgs.aM(7, this.NbJ);
      paramVarArgs.aM(8, this.NbK);
      paramVarArgs.f(9, 2, this.NbL);
      paramVarArgs.aM(10, this.NbM);
      paramVarArgs.f(11, 2, this.NbN);
      paramVarArgs.aM(12, this.NbO);
      paramVarArgs.f(13, 2, this.NbP);
      if (this.NbQ != null) {
        paramVarArgs.e(14, this.NbQ);
      }
      AppMethodBeat.o(115852);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = g.a.a.b.b.a.bu(1, this.NbD) + 0 + g.a.a.b.b.a.bu(2, this.NbE) + g.a.a.b.b.a.bu(3, this.NbF);
      paramInt = i;
      if (this.NbG != null) {
        paramInt = i + g.a.a.a.nh(4, this.NbG.computeSize());
      }
      i = paramInt + g.a.a.b.b.a.bu(5, this.NbH) + g.a.a.b.b.a.bu(6, this.NbI) + g.a.a.b.b.a.bu(7, this.NbJ) + g.a.a.b.b.a.bu(8, this.NbK) + g.a.a.a.d(9, 2, this.NbL) + g.a.a.b.b.a.bu(10, this.NbM) + g.a.a.a.d(11, 2, this.NbN) + g.a.a.b.b.a.bu(12, this.NbO) + g.a.a.a.d(13, 2, this.NbP);
      paramInt = i;
      if (this.NbQ != null) {
        paramInt = i + g.a.a.b.b.a.f(14, this.NbQ);
      }
      AppMethodBeat.o(115852);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.NbL.clear();
      this.NbN.clear();
      this.NbP.clear();
      paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.hPl();
        }
      }
      if (this.NbG == null)
      {
        paramVarArgs = new g.a.a.b("Not all required fields were included: Addr");
        AppMethodBeat.o(115852);
        throw paramVarArgs;
      }
      AppMethodBeat.o(115852);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
      eby localeby = (eby)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(115852);
        return -1;
      case 1: 
        localeby.NbD = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(115852);
        return 0;
      case 2: 
        localeby.NbE = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(115852);
        return 0;
      case 3: 
        localeby.NbF = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(115852);
        return 0;
      case 4: 
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new esq();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((esq)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localeby.NbG = ((esq)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(115852);
        return 0;
      case 5: 
        localeby.NbH = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(115852);
        return 0;
      case 6: 
        localeby.NbI = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(115852);
        return 0;
      case 7: 
        localeby.NbJ = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(115852);
        return 0;
      case 8: 
        localeby.NbK = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(115852);
        return 0;
      case 9: 
        localeby.NbL = new g.a.a.a.a(((g.a.a.a.a)localObject1).UbS.hPo().zy, unknownTagHandler).UbS.hPm();
        AppMethodBeat.o(115852);
        return 0;
      case 10: 
        localeby.NbM = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(115852);
        return 0;
      case 11: 
        localeby.NbN = new g.a.a.a.a(((g.a.a.a.a)localObject1).UbS.hPo().zy, unknownTagHandler).UbS.hPm();
        AppMethodBeat.o(115852);
        return 0;
      case 12: 
        localeby.NbO = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(115852);
        return 0;
      case 13: 
        localeby.NbP = new g.a.a.a.a(((g.a.a.a.a)localObject1).UbS.hPo().zy, unknownTagHandler).UbS.hPm();
        AppMethodBeat.o(115852);
        return 0;
      }
      localeby.NbQ = ((g.a.a.a.a)localObject1).UbS.readString();
      AppMethodBeat.o(115852);
      return 0;
    }
    AppMethodBeat.o(115852);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.eby
 * JD-Core Version:    0.7.0.1
 */