package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class dhi
  extends cvp
{
  public LinkedList<SnsObject> FCD;
  public dhg GOa;
  public int GUQ;
  public String HtU;
  public int HtY;
  public dgq Hua;
  public int Huv;
  public LinkedList<dhk> Huw;
  public int HvM;
  public long HvN;
  public long HvO;
  public String HvP;
  public boolean HvQ;
  public int Hvp;
  
  public dhi()
  {
    AppMethodBeat.i(125836);
    this.FCD = new LinkedList();
    this.Huw = new LinkedList();
    AppMethodBeat.o(125836);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(125837);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(125837);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.lC(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.HtU != null) {
        paramVarArgs.d(2, this.HtU);
      }
      paramVarArgs.aS(3, this.GUQ);
      paramVarArgs.e(4, 8, this.FCD);
      paramVarArgs.aS(5, this.HvM);
      if (this.GOa != null)
      {
        paramVarArgs.lC(6, this.GOa.computeSize());
        this.GOa.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(7, this.Hvp);
      paramVarArgs.aS(8, this.HtY);
      if (this.Hua != null)
      {
        paramVarArgs.lC(9, this.Hua.computeSize());
        this.Hua.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(10, this.HvN);
      paramVarArgs.aY(11, this.HvO);
      if (this.HvP != null) {
        paramVarArgs.d(12, this.HvP);
      }
      paramVarArgs.aS(13, this.Huv);
      paramVarArgs.e(14, 8, this.Huw);
      paramVarArgs.bt(15, this.HvQ);
      AppMethodBeat.o(125837);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1430;
      }
    }
    label1430:
    for (paramInt = f.a.a.a.lB(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.HtU != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.HtU);
      }
      i = i + f.a.a.b.b.a.bz(3, this.GUQ) + f.a.a.a.c(4, 8, this.FCD) + f.a.a.b.b.a.bz(5, this.HvM);
      paramInt = i;
      if (this.GOa != null) {
        paramInt = i + f.a.a.a.lB(6, this.GOa.computeSize());
      }
      i = paramInt + f.a.a.b.b.a.bz(7, this.Hvp) + f.a.a.b.b.a.bz(8, this.HtY);
      paramInt = i;
      if (this.Hua != null) {
        paramInt = i + f.a.a.a.lB(9, this.Hua.computeSize());
      }
      i = paramInt + f.a.a.b.b.a.p(10, this.HvN) + f.a.a.b.b.a.p(11, this.HvO);
      paramInt = i;
      if (this.HvP != null) {
        paramInt = i + f.a.a.b.b.a.e(12, this.HvP);
      }
      i = f.a.a.b.b.a.bz(13, this.Huv);
      int j = f.a.a.a.c(14, 8, this.Huw);
      int k = f.a.a.b.b.a.alV(15);
      AppMethodBeat.o(125837);
      return paramInt + i + j + k;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.FCD.clear();
        this.Huw.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cvp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(125837);
          throw paramVarArgs;
        }
        AppMethodBeat.o(125837);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        dhi localdhi = (dhi)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(125837);
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
            localdhi.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(125837);
          return 0;
        case 2: 
          localdhi.HtU = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(125837);
          return 0;
        case 3: 
          localdhi.GUQ = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(125837);
          return 0;
        case 4: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SnsObject();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SnsObject)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdhi.FCD.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(125837);
          return 0;
        case 5: 
          localdhi.HvM = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(125837);
          return 0;
        case 6: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dhg();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dhg)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdhi.GOa = ((dhg)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(125837);
          return 0;
        case 7: 
          localdhi.Hvp = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(125837);
          return 0;
        case 8: 
          localdhi.HtY = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(125837);
          return 0;
        case 9: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dgq();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dgq)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdhi.Hua = ((dgq)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(125837);
          return 0;
        case 10: 
          localdhi.HvN = ((f.a.a.a.a)localObject1).NPN.zd();
          AppMethodBeat.o(125837);
          return 0;
        case 11: 
          localdhi.HvO = ((f.a.a.a.a)localObject1).NPN.zd();
          AppMethodBeat.o(125837);
          return 0;
        case 12: 
          localdhi.HvP = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(125837);
          return 0;
        case 13: 
          localdhi.Huv = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(125837);
          return 0;
        case 14: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dhk();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dhk)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdhi.Huw.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(125837);
          return 0;
        }
        localdhi.HvQ = ((f.a.a.a.a)localObject1).NPN.grw();
        AppMethodBeat.o(125837);
        return 0;
      }
      AppMethodBeat.o(125837);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dhi
 * JD-Core Version:    0.7.0.1
 */