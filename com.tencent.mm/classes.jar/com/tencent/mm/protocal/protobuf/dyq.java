package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class dyq
  extends cvc
{
  public double FIb;
  public double FIc;
  public int FYc;
  public int GeI;
  public long GeJ;
  public LinkedList<dht> GyQ;
  public long HMb;
  public cwt HMc;
  public cwt HMd;
  public int HMe;
  
  public dyq()
  {
    AppMethodBeat.i(115913);
    this.GyQ = new LinkedList();
    AppMethodBeat.o(115913);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(115914);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.HMc == null)
      {
        paramVarArgs = new b("Not all required fields were included: NetName");
        AppMethodBeat.o(115914);
        throw paramVarArgs;
      }
      if (this.HMd == null)
      {
        paramVarArgs = new b("Not all required fields were included: WifiName");
        AppMethodBeat.o(115914);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.lC(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(2, this.HMb);
      paramVarArgs.aY(3, this.GeJ);
      paramVarArgs.aS(4, this.FYc);
      if (this.HMc != null)
      {
        paramVarArgs.lC(5, this.HMc.computeSize());
        this.HMc.writeFields(paramVarArgs);
      }
      if (this.HMd != null)
      {
        paramVarArgs.lC(6, this.HMd.computeSize());
        this.HMd.writeFields(paramVarArgs);
      }
      paramVarArgs.e(7, this.FIb);
      paramVarArgs.e(8, this.FIc);
      paramVarArgs.aS(9, this.GeI);
      paramVarArgs.aS(10, this.HMe);
      paramVarArgs.e(11, 8, this.GyQ);
      AppMethodBeat.o(115914);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label1176;
      }
    }
    label1176:
    for (paramInt = f.a.a.a.lB(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.p(2, this.HMb) + f.a.a.b.b.a.p(3, this.GeJ) + f.a.a.b.b.a.bz(4, this.FYc);
      paramInt = i;
      if (this.HMc != null) {
        paramInt = i + f.a.a.a.lB(5, this.HMc.computeSize());
      }
      i = paramInt;
      if (this.HMd != null) {
        i = paramInt + f.a.a.a.lB(6, this.HMd.computeSize());
      }
      paramInt = f.a.a.b.b.a.alT(7);
      int j = f.a.a.b.b.a.alT(8);
      int k = f.a.a.b.b.a.bz(9, this.GeI);
      int m = f.a.a.b.b.a.bz(10, this.HMe);
      int n = f.a.a.a.c(11, 8, this.GyQ);
      AppMethodBeat.o(115914);
      return i + paramInt + j + k + m + n;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.GyQ.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cvc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        if (this.HMc == null)
        {
          paramVarArgs = new b("Not all required fields were included: NetName");
          AppMethodBeat.o(115914);
          throw paramVarArgs;
        }
        if (this.HMd == null)
        {
          paramVarArgs = new b("Not all required fields were included: WifiName");
          AppMethodBeat.o(115914);
          throw paramVarArgs;
        }
        AppMethodBeat.o(115914);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        dyq localdyq = (dyq)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(115914);
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
            localdyq.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(115914);
          return 0;
        case 2: 
          localdyq.HMb = ((f.a.a.a.a)localObject1).NPN.zd();
          AppMethodBeat.o(115914);
          return 0;
        case 3: 
          localdyq.GeJ = ((f.a.a.a.a)localObject1).NPN.zd();
          AppMethodBeat.o(115914);
          return 0;
        case 4: 
          localdyq.FYc = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(115914);
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
            localdyq.HMc = ((cwt)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(115914);
          return 0;
        case 6: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cwt();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cwt)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvc.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdyq.HMd = ((cwt)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(115914);
          return 0;
        case 7: 
          localdyq.FIb = Double.longBitsToDouble(((f.a.a.a.a)localObject1).NPN.grA());
          AppMethodBeat.o(115914);
          return 0;
        case 8: 
          localdyq.FIc = Double.longBitsToDouble(((f.a.a.a.a)localObject1).NPN.grA());
          AppMethodBeat.o(115914);
          return 0;
        case 9: 
          localdyq.GeI = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(115914);
          return 0;
        case 10: 
          localdyq.HMe = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(115914);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new dht();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((dht)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvc.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localdyq.GyQ.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(115914);
        return 0;
      }
      AppMethodBeat.o(115914);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dyq
 * JD-Core Version:    0.7.0.1
 */