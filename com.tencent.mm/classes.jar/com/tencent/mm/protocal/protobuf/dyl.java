package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class dyl
  extends cvp
{
  public int GeI;
  public long GeJ;
  public LinkedList<dws> HJV;
  public int HLN;
  public LinkedList<dws> HLO;
  public int HLP;
  public LinkedList<dws> HLQ;
  public int HLR;
  public int HLT;
  public int HLU;
  public dyf HLV;
  public int Hgi;
  
  public dyl()
  {
    AppMethodBeat.i(115907);
    this.HLO = new LinkedList();
    this.HLQ = new LinkedList();
    this.HJV = new LinkedList();
    AppMethodBeat.o(115907);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(115908);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(115908);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.lC(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(2, this.GeI);
      paramVarArgs.aS(3, this.HLN);
      paramVarArgs.e(4, 8, this.HLO);
      paramVarArgs.aS(5, this.HLP);
      paramVarArgs.e(6, 8, this.HLQ);
      paramVarArgs.aY(7, this.GeJ);
      paramVarArgs.aS(8, this.Hgi);
      paramVarArgs.aS(9, this.HLR);
      paramVarArgs.e(10, 8, this.HJV);
      paramVarArgs.aS(11, this.HLT);
      paramVarArgs.aS(12, this.HLU);
      if (this.HLV != null)
      {
        paramVarArgs.lC(13, this.HLV.computeSize());
        this.HLV.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(115908);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1278;
      }
    }
    label1278:
    for (paramInt = f.a.a.a.lB(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bz(2, this.GeI) + f.a.a.b.b.a.bz(3, this.HLN) + f.a.a.a.c(4, 8, this.HLO) + f.a.a.b.b.a.bz(5, this.HLP) + f.a.a.a.c(6, 8, this.HLQ) + f.a.a.b.b.a.p(7, this.GeJ) + f.a.a.b.b.a.bz(8, this.Hgi) + f.a.a.b.b.a.bz(9, this.HLR) + f.a.a.a.c(10, 8, this.HJV) + f.a.a.b.b.a.bz(11, this.HLT) + f.a.a.b.b.a.bz(12, this.HLU);
      paramInt = i;
      if (this.HLV != null) {
        paramInt = i + f.a.a.a.lB(13, this.HLV.computeSize());
      }
      AppMethodBeat.o(115908);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.HLO.clear();
        this.HLQ.clear();
        this.HJV.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cvp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(115908);
          throw paramVarArgs;
        }
        AppMethodBeat.o(115908);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        dyl localdyl = (dyl)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(115908);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new BaseResponse();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((BaseResponse)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdyl.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(115908);
          return 0;
        case 2: 
          localdyl.GeI = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(115908);
          return 0;
        case 3: 
          localdyl.HLN = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(115908);
          return 0;
        case 4: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dws();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dws)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdyl.HLO.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(115908);
          return 0;
        case 5: 
          localdyl.HLP = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(115908);
          return 0;
        case 6: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dws();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dws)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdyl.HLQ.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(115908);
          return 0;
        case 7: 
          localdyl.GeJ = ((f.a.a.a.a)localObject1).NPN.zd();
          AppMethodBeat.o(115908);
          return 0;
        case 8: 
          localdyl.Hgi = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(115908);
          return 0;
        case 9: 
          localdyl.HLR = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(115908);
          return 0;
        case 10: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dws();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dws)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdyl.HJV.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(115908);
          return 0;
        case 11: 
          localdyl.HLT = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(115908);
          return 0;
        case 12: 
          localdyl.HLU = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(115908);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new dyf();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((dyf)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localdyl.HLV = ((dyf)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(115908);
        return 0;
      }
      AppMethodBeat.o(115908);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dyl
 * JD-Core Version:    0.7.0.1
 */