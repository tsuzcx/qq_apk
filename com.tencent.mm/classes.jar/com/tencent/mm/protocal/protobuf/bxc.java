package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class bxc
  extends dpc
{
  public boolean ApK;
  public LinkedList<ecx> KHS;
  public LinkedList<bes> KHh;
  public ffn LpZ;
  public int Lqb;
  public String McL;
  public LinkedList<ffp> McM;
  public LinkedList<ffo> McN;
  public LinkedList<String> McO;
  public String McP;
  public String McQ;
  public LinkedList<sg> McR;
  public boolean McS;
  public LinkedList<ecf> McT;
  public ffm McU;
  public String rCo;
  public String rCp;
  public boolean rCx;
  public int rJh;
  public String source;
  
  public bxc()
  {
    AppMethodBeat.i(32279);
    this.McM = new LinkedList();
    this.McN = new LinkedList();
    this.McO = new LinkedList();
    this.KHS = new LinkedList();
    this.KHh = new LinkedList();
    this.McR = new LinkedList();
    this.McT = new LinkedList();
    AppMethodBeat.o(32279);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32280);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(32280);
        throw paramVarArgs;
      }
      if (this.McL == null)
      {
        paramVarArgs = new b("Not all required fields were included: coverurl");
        AppMethodBeat.o(32280);
        throw paramVarArgs;
      }
      if (this.rCp == null)
      {
        paramVarArgs = new b("Not all required fields were included: motto");
        AppMethodBeat.o(32280);
        throw paramVarArgs;
      }
      if (this.LpZ == null)
      {
        paramVarArgs = new b("Not all required fields were included: rankdesc");
        AppMethodBeat.o(32280);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.ni(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.McL != null) {
        paramVarArgs.e(2, this.McL);
      }
      if (this.rCp != null) {
        paramVarArgs.e(3, this.rCp);
      }
      if (this.LpZ != null)
      {
        paramVarArgs.ni(4, this.LpZ.computeSize());
        this.LpZ.writeFields(paramVarArgs);
      }
      paramVarArgs.e(5, 8, this.McM);
      paramVarArgs.e(6, 8, this.McN);
      if (this.source != null) {
        paramVarArgs.e(7, this.source);
      }
      paramVarArgs.e(8, 1, this.McO);
      if (this.McP != null) {
        paramVarArgs.e(9, this.McP);
      }
      if (this.McQ != null) {
        paramVarArgs.e(10, this.McQ);
      }
      paramVarArgs.e(14, 8, this.KHS);
      paramVarArgs.e(15, 8, this.KHh);
      paramVarArgs.cc(16, this.rCx);
      paramVarArgs.e(17, 8, this.McR);
      paramVarArgs.cc(18, this.McS);
      paramVarArgs.aM(19, this.rJh);
      if (this.rCo != null) {
        paramVarArgs.e(20, this.rCo);
      }
      paramVarArgs.e(21, 8, this.McT);
      paramVarArgs.aM(22, this.Lqb);
      if (this.McU != null)
      {
        paramVarArgs.ni(23, this.McU.computeSize());
        this.McU.writeFields(paramVarArgs);
      }
      paramVarArgs.cc(24, this.ApK);
      AppMethodBeat.o(32280);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label2341;
      }
    }
    label2341:
    for (int i = g.a.a.a.nh(1, this.BaseResponse.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.McL != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.McL);
      }
      i = paramInt;
      if (this.rCp != null) {
        i = paramInt + g.a.a.b.b.a.f(3, this.rCp);
      }
      paramInt = i;
      if (this.LpZ != null) {
        paramInt = i + g.a.a.a.nh(4, this.LpZ.computeSize());
      }
      i = paramInt + g.a.a.a.c(5, 8, this.McM) + g.a.a.a.c(6, 8, this.McN);
      paramInt = i;
      if (this.source != null) {
        paramInt = i + g.a.a.b.b.a.f(7, this.source);
      }
      i = paramInt + g.a.a.a.c(8, 1, this.McO);
      paramInt = i;
      if (this.McP != null) {
        paramInt = i + g.a.a.b.b.a.f(9, this.McP);
      }
      i = paramInt;
      if (this.McQ != null) {
        i = paramInt + g.a.a.b.b.a.f(10, this.McQ);
      }
      i = i + g.a.a.a.c(14, 8, this.KHS) + g.a.a.a.c(15, 8, this.KHh) + (g.a.a.b.b.a.fS(16) + 1) + g.a.a.a.c(17, 8, this.McR) + (g.a.a.b.b.a.fS(18) + 1) + g.a.a.b.b.a.bu(19, this.rJh);
      paramInt = i;
      if (this.rCo != null) {
        paramInt = i + g.a.a.b.b.a.f(20, this.rCo);
      }
      i = paramInt + g.a.a.a.c(21, 8, this.McT) + g.a.a.b.b.a.bu(22, this.Lqb);
      paramInt = i;
      if (this.McU != null) {
        paramInt = i + g.a.a.a.nh(23, this.McU.computeSize());
      }
      i = g.a.a.b.b.a.fS(24);
      AppMethodBeat.o(32280);
      return paramInt + (i + 1);
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.McM.clear();
        this.McN.clear();
        this.McO.clear();
        this.KHS.clear();
        this.KHh.clear();
        this.McR.clear();
        this.McT.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = dpc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dpc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(32280);
          throw paramVarArgs;
        }
        if (this.McL == null)
        {
          paramVarArgs = new b("Not all required fields were included: coverurl");
          AppMethodBeat.o(32280);
          throw paramVarArgs;
        }
        if (this.rCp == null)
        {
          paramVarArgs = new b("Not all required fields were included: motto");
          AppMethodBeat.o(32280);
          throw paramVarArgs;
        }
        if (this.LpZ == null)
        {
          paramVarArgs = new b("Not all required fields were included: rankdesc");
          AppMethodBeat.o(32280);
          throw paramVarArgs;
        }
        AppMethodBeat.o(32280);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        bxc localbxc = (bxc)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        case 11: 
        case 12: 
        case 13: 
        default: 
          AppMethodBeat.o(32280);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new BaseResponse();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((BaseResponse)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localbxc.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32280);
          return 0;
        case 2: 
          localbxc.McL = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(32280);
          return 0;
        case 3: 
          localbxc.rCp = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(32280);
          return 0;
        case 4: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ffn();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ffn)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localbxc.LpZ = ((ffn)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32280);
          return 0;
        case 5: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ffp();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ffp)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localbxc.McM.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32280);
          return 0;
        case 6: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ffo();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ffo)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localbxc.McN.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32280);
          return 0;
        case 7: 
          localbxc.source = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(32280);
          return 0;
        case 8: 
          localbxc.McO.add(((g.a.a.a.a)localObject1).UbS.readString());
          AppMethodBeat.o(32280);
          return 0;
        case 9: 
          localbxc.McP = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(32280);
          return 0;
        case 10: 
          localbxc.McQ = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(32280);
          return 0;
        case 14: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ecx();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ecx)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localbxc.KHS.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32280);
          return 0;
        case 15: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bes();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bes)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localbxc.KHh.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32280);
          return 0;
        case 16: 
          localbxc.rCx = ((g.a.a.a.a)localObject1).UbS.yZ();
          AppMethodBeat.o(32280);
          return 0;
        case 17: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new sg();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((sg)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localbxc.McR.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32280);
          return 0;
        case 18: 
          localbxc.McS = ((g.a.a.a.a)localObject1).UbS.yZ();
          AppMethodBeat.o(32280);
          return 0;
        case 19: 
          localbxc.rJh = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(32280);
          return 0;
        case 20: 
          localbxc.rCo = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(32280);
          return 0;
        case 21: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ecf();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ecf)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localbxc.McT.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32280);
          return 0;
        case 22: 
          localbxc.Lqb = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(32280);
          return 0;
        case 23: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ffm();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ffm)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localbxc.McU = ((ffm)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32280);
          return 0;
        }
        localbxc.ApK = ((g.a.a.a.a)localObject1).UbS.yZ();
        AppMethodBeat.o(32280);
        return 0;
      }
      AppMethodBeat.o(32280);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bxc
 * JD-Core Version:    0.7.0.1
 */