package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class cjd
  extends cvp
{
  public String DaM;
  public ebn HcR;
  public ebk HcS;
  public ebe HcT;
  public ebl HcU;
  public boolean HcV;
  public LinkedList<String> HcW;
  public ebi HcX;
  public int dqI;
  public String dqJ;
  public int vDk;
  
  public cjd()
  {
    AppMethodBeat.i(91588);
    this.HcW = new LinkedList();
    AppMethodBeat.o(91588);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91589);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(91589);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.lC(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(2, this.dqI);
      if (this.dqJ != null) {
        paramVarArgs.d(3, this.dqJ);
      }
      if (this.HcR != null)
      {
        paramVarArgs.lC(4, this.HcR.computeSize());
        this.HcR.writeFields(paramVarArgs);
      }
      if (this.HcS != null)
      {
        paramVarArgs.lC(5, this.HcS.computeSize());
        this.HcS.writeFields(paramVarArgs);
      }
      if (this.HcT != null)
      {
        paramVarArgs.lC(6, this.HcT.computeSize());
        this.HcT.writeFields(paramVarArgs);
      }
      if (this.HcU != null)
      {
        paramVarArgs.lC(7, this.HcU.computeSize());
        this.HcU.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(8, this.vDk);
      paramVarArgs.bt(9, this.HcV);
      if (this.DaM != null) {
        paramVarArgs.d(10, this.DaM);
      }
      paramVarArgs.e(11, 1, this.HcW);
      if (this.HcX != null)
      {
        paramVarArgs.lC(12, this.HcX.computeSize());
        this.HcX.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(91589);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1446;
      }
    }
    label1446:
    for (paramInt = f.a.a.a.lB(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bz(2, this.dqI);
      paramInt = i;
      if (this.dqJ != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.dqJ);
      }
      i = paramInt;
      if (this.HcR != null) {
        i = paramInt + f.a.a.a.lB(4, this.HcR.computeSize());
      }
      paramInt = i;
      if (this.HcS != null) {
        paramInt = i + f.a.a.a.lB(5, this.HcS.computeSize());
      }
      i = paramInt;
      if (this.HcT != null) {
        i = paramInt + f.a.a.a.lB(6, this.HcT.computeSize());
      }
      paramInt = i;
      if (this.HcU != null) {
        paramInt = i + f.a.a.a.lB(7, this.HcU.computeSize());
      }
      i = paramInt + f.a.a.b.b.a.bz(8, this.vDk) + f.a.a.b.b.a.alV(9);
      paramInt = i;
      if (this.DaM != null) {
        paramInt = i + f.a.a.b.b.a.e(10, this.DaM);
      }
      i = paramInt + f.a.a.a.c(11, 1, this.HcW);
      paramInt = i;
      if (this.HcX != null) {
        paramInt = i + f.a.a.a.lB(12, this.HcX.computeSize());
      }
      AppMethodBeat.o(91589);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.HcW.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cvp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(91589);
          throw paramVarArgs;
        }
        AppMethodBeat.o(91589);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        cjd localcjd = (cjd)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91589);
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
            localcjd.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91589);
          return 0;
        case 2: 
          localcjd.dqI = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(91589);
          return 0;
        case 3: 
          localcjd.dqJ = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(91589);
          return 0;
        case 4: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ebn();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ebn)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcjd.HcR = ((ebn)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91589);
          return 0;
        case 5: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ebk();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ebk)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcjd.HcS = ((ebk)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91589);
          return 0;
        case 6: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ebe();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ebe)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcjd.HcT = ((ebe)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91589);
          return 0;
        case 7: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ebl();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ebl)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcjd.HcU = ((ebl)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91589);
          return 0;
        case 8: 
          localcjd.vDk = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(91589);
          return 0;
        case 9: 
          localcjd.HcV = ((f.a.a.a.a)localObject1).NPN.grw();
          AppMethodBeat.o(91589);
          return 0;
        case 10: 
          localcjd.DaM = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(91589);
          return 0;
        case 11: 
          localcjd.HcW.add(((f.a.a.a.a)localObject1).NPN.readString());
          AppMethodBeat.o(91589);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new ebi();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((ebi)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localcjd.HcX = ((ebi)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(91589);
        return 0;
      }
      AppMethodBeat.o(91589);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cjd
 * JD-Core Version:    0.7.0.1
 */