package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class azs
  extends cvc
{
  public LinkedList<cwt> FuM;
  public int GwN;
  public int GwO;
  public LinkedList<cwt> GwP;
  public int GwQ;
  public LinkedList<cwt> GwR;
  public int GwS;
  public cwt GwT;
  
  public azs()
  {
    AppMethodBeat.i(32232);
    this.FuM = new LinkedList();
    this.GwP = new LinkedList();
    this.GwR = new LinkedList();
    AppMethodBeat.o(32232);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32233);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.lC(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(2, this.GwN);
      paramVarArgs.e(3, 8, this.FuM);
      paramVarArgs.aS(4, this.GwO);
      paramVarArgs.e(5, 8, this.GwP);
      paramVarArgs.aS(6, this.GwQ);
      paramVarArgs.e(7, 8, this.GwR);
      paramVarArgs.aS(8, this.GwS);
      if (this.GwT != null)
      {
        paramVarArgs.lC(9, this.GwT.computeSize());
        this.GwT.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(32233);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label1069;
      }
    }
    label1069:
    for (paramInt = f.a.a.a.lB(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bz(2, this.GwN) + f.a.a.a.c(3, 8, this.FuM) + f.a.a.b.b.a.bz(4, this.GwO) + f.a.a.a.c(5, 8, this.GwP) + f.a.a.b.b.a.bz(6, this.GwQ) + f.a.a.a.c(7, 8, this.GwR) + f.a.a.b.b.a.bz(8, this.GwS);
      paramInt = i;
      if (this.GwT != null) {
        paramInt = i + f.a.a.a.lB(9, this.GwT.computeSize());
      }
      AppMethodBeat.o(32233);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.FuM.clear();
        this.GwP.clear();
        this.GwR.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cvc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(32233);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        azs localazs = (azs)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(32233);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new jc();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((jc)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvc.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localazs.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32233);
          return 0;
        case 2: 
          localazs.GwN = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(32233);
          return 0;
        case 3: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cwt();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cwt)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvc.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localazs.FuM.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32233);
          return 0;
        case 4: 
          localazs.GwO = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(32233);
          return 0;
        case 5: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cwt();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cwt)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvc.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localazs.GwP.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32233);
          return 0;
        case 6: 
          localazs.GwQ = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(32233);
          return 0;
        case 7: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cwt();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cwt)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvc.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localazs.GwR.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32233);
          return 0;
        case 8: 
          localazs.GwS = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(32233);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new cwt();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((cwt)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvc.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localazs.GwT = ((cwt)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(32233);
        return 0;
      }
      AppMethodBeat.o(32233);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.azs
 * JD-Core Version:    0.7.0.1
 */