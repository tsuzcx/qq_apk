package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;
import java.util.LinkedList;

public final class dmu
  extends com.tencent.mm.bx.a
{
  public cis ECI;
  public abv ECJ;
  public int ECK;
  public LinkedList<Integer> ECL;
  public int ECM;
  public LinkedList<Integer> ECN;
  public cis ECO;
  public int zjj;
  
  public dmu()
  {
    AppMethodBeat.i(115897);
    this.ECL = new LinkedList();
    this.ECN = new LinkedList();
    AppMethodBeat.o(115897);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(115898);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.ECI != null)
      {
        paramVarArgs.kX(1, this.ECI.computeSize());
        this.ECI.writeFields(paramVarArgs);
      }
      if (this.ECJ != null)
      {
        paramVarArgs.kX(2, this.ECJ.computeSize());
        this.ECJ.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(3, this.ECK);
      paramVarArgs.f(4, 2, this.ECL);
      paramVarArgs.aR(5, this.ECM);
      paramVarArgs.f(6, 2, this.ECN);
      paramVarArgs.aR(7, this.zjj);
      if (this.ECO != null)
      {
        paramVarArgs.kX(8, this.ECO.computeSize());
        this.ECO.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(115898);
      return 0;
    }
    if (paramInt == 1) {
      if (this.ECI == null) {
        break label896;
      }
    }
    label896:
    for (paramInt = f.a.a.a.kW(1, this.ECI.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.ECJ != null) {
        i = paramInt + f.a.a.a.kW(2, this.ECJ.computeSize());
      }
      i = i + f.a.a.b.b.a.bA(3, this.ECK) + f.a.a.a.d(4, 2, this.ECL) + f.a.a.b.b.a.bA(5, this.ECM) + f.a.a.a.d(6, 2, this.ECN) + f.a.a.b.b.a.bA(7, this.zjj);
      paramInt = i;
      if (this.ECO != null) {
        paramInt = i + f.a.a.a.kW(8, this.ECO.computeSize());
      }
      AppMethodBeat.o(115898);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.ECL.clear();
        this.ECN.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(115898);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        dmu localdmu = (dmu)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(115898);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cis();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cis)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdmu.ECI = ((cis)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(115898);
          return 0;
        case 2: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new abv();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((abv)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdmu.ECJ = ((abv)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(115898);
          return 0;
        case 3: 
          localdmu.ECK = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(115898);
          return 0;
        case 4: 
          localdmu.ECL = new f.a.a.a.a(((f.a.a.a.a)localObject1).KhF.fMu().wA, unknownTagHandler).KhF.fMs();
          AppMethodBeat.o(115898);
          return 0;
        case 5: 
          localdmu.ECM = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(115898);
          return 0;
        case 6: 
          localdmu.ECN = new f.a.a.a.a(((f.a.a.a.a)localObject1).KhF.fMu().wA, unknownTagHandler).KhF.fMs();
          AppMethodBeat.o(115898);
          return 0;
        case 7: 
          localdmu.zjj = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(115898);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new cis();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((cis)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localdmu.ECO = ((cis)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(115898);
        return 0;
      }
      AppMethodBeat.o(115898);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dmu
 * JD-Core Version:    0.7.0.1
 */