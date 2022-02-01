package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class bhj
  extends dpc
{
  public int KCD;
  public String KCt;
  public SKBuiltinBuffer_t LRE;
  public String LRH;
  public String LRI;
  public cee LRJ;
  public bgt LRK;
  public String LRL;
  public int LRM;
  public LinkedList<px> LRN;
  public String LRO;
  public aey LRP;
  public SKBuiltinBuffer_t LRQ;
  public int LRR;
  public SKBuiltinBuffer_t LRS;
  public SKBuiltinBuffer_t LRT;
  public String LRk;
  public String LRl;
  public LinkedList<ccc> LRq;
  public String SSID;
  public String Title;
  public String UserName;
  public String iAc;
  public String xJH;
  
  public bhj()
  {
    AppMethodBeat.i(152553);
    this.LRN = new LinkedList();
    this.LRq = new LinkedList();
    AppMethodBeat.o(152553);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(152554);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(152554);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.ni(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.LRH != null) {
        paramVarArgs.e(2, this.LRH);
      }
      if (this.LRI != null) {
        paramVarArgs.e(3, this.LRI);
      }
      paramVarArgs.aM(4, this.KCD);
      if (this.Title != null) {
        paramVarArgs.e(5, this.Title);
      }
      if (this.iAc != null) {
        paramVarArgs.e(6, this.iAc);
      }
      if (this.LRJ != null)
      {
        paramVarArgs.ni(7, this.LRJ.computeSize());
        this.LRJ.writeFields(paramVarArgs);
      }
      if (this.LRK != null)
      {
        paramVarArgs.ni(8, this.LRK.computeSize());
        this.LRK.writeFields(paramVarArgs);
      }
      if (this.UserName != null) {
        paramVarArgs.e(9, this.UserName);
      }
      if (this.LRL != null) {
        paramVarArgs.e(15, this.LRL);
      }
      paramVarArgs.aM(16, this.LRM);
      paramVarArgs.e(17, 8, this.LRN);
      if (this.LRO != null) {
        paramVarArgs.e(18, this.LRO);
      }
      if (this.SSID != null) {
        paramVarArgs.e(20, this.SSID);
      }
      if (this.KCt != null) {
        paramVarArgs.e(21, this.KCt);
      }
      if (this.LRP != null)
      {
        paramVarArgs.ni(22, this.LRP.computeSize());
        this.LRP.writeFields(paramVarArgs);
      }
      if (this.LRQ != null)
      {
        paramVarArgs.ni(23, this.LRQ.computeSize());
        this.LRQ.writeFields(paramVarArgs);
      }
      paramVarArgs.aM(24, this.LRR);
      paramVarArgs.e(25, 8, this.LRq);
      if (this.xJH != null) {
        paramVarArgs.e(26, this.xJH);
      }
      if (this.LRk != null) {
        paramVarArgs.e(27, this.LRk);
      }
      if (this.LRE != null)
      {
        paramVarArgs.ni(28, this.LRE.computeSize());
        this.LRE.writeFields(paramVarArgs);
      }
      if (this.LRl != null) {
        paramVarArgs.e(29, this.LRl);
      }
      if (this.LRS != null)
      {
        paramVarArgs.ni(30, this.LRS.computeSize());
        this.LRS.writeFields(paramVarArgs);
      }
      if (this.LRT != null)
      {
        paramVarArgs.ni(31, this.LRT.computeSize());
        this.LRT.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(152554);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label2630;
      }
    }
    label2630:
    for (int i = g.a.a.a.nh(1, this.BaseResponse.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.LRH != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.LRH);
      }
      i = paramInt;
      if (this.LRI != null) {
        i = paramInt + g.a.a.b.b.a.f(3, this.LRI);
      }
      i += g.a.a.b.b.a.bu(4, this.KCD);
      paramInt = i;
      if (this.Title != null) {
        paramInt = i + g.a.a.b.b.a.f(5, this.Title);
      }
      i = paramInt;
      if (this.iAc != null) {
        i = paramInt + g.a.a.b.b.a.f(6, this.iAc);
      }
      paramInt = i;
      if (this.LRJ != null) {
        paramInt = i + g.a.a.a.nh(7, this.LRJ.computeSize());
      }
      i = paramInt;
      if (this.LRK != null) {
        i = paramInt + g.a.a.a.nh(8, this.LRK.computeSize());
      }
      paramInt = i;
      if (this.UserName != null) {
        paramInt = i + g.a.a.b.b.a.f(9, this.UserName);
      }
      i = paramInt;
      if (this.LRL != null) {
        i = paramInt + g.a.a.b.b.a.f(15, this.LRL);
      }
      i = i + g.a.a.b.b.a.bu(16, this.LRM) + g.a.a.a.c(17, 8, this.LRN);
      paramInt = i;
      if (this.LRO != null) {
        paramInt = i + g.a.a.b.b.a.f(18, this.LRO);
      }
      i = paramInt;
      if (this.SSID != null) {
        i = paramInt + g.a.a.b.b.a.f(20, this.SSID);
      }
      paramInt = i;
      if (this.KCt != null) {
        paramInt = i + g.a.a.b.b.a.f(21, this.KCt);
      }
      i = paramInt;
      if (this.LRP != null) {
        i = paramInt + g.a.a.a.nh(22, this.LRP.computeSize());
      }
      paramInt = i;
      if (this.LRQ != null) {
        paramInt = i + g.a.a.a.nh(23, this.LRQ.computeSize());
      }
      i = paramInt + g.a.a.b.b.a.bu(24, this.LRR) + g.a.a.a.c(25, 8, this.LRq);
      paramInt = i;
      if (this.xJH != null) {
        paramInt = i + g.a.a.b.b.a.f(26, this.xJH);
      }
      i = paramInt;
      if (this.LRk != null) {
        i = paramInt + g.a.a.b.b.a.f(27, this.LRk);
      }
      paramInt = i;
      if (this.LRE != null) {
        paramInt = i + g.a.a.a.nh(28, this.LRE.computeSize());
      }
      i = paramInt;
      if (this.LRl != null) {
        i = paramInt + g.a.a.b.b.a.f(29, this.LRl);
      }
      paramInt = i;
      if (this.LRS != null) {
        paramInt = i + g.a.a.a.nh(30, this.LRS.computeSize());
      }
      i = paramInt;
      if (this.LRT != null) {
        i = paramInt + g.a.a.a.nh(31, this.LRT.computeSize());
      }
      AppMethodBeat.o(152554);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.LRN.clear();
        this.LRq.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = dpc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dpc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(152554);
          throw paramVarArgs;
        }
        AppMethodBeat.o(152554);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        bhj localbhj = (bhj)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        case 10: 
        case 11: 
        case 12: 
        case 13: 
        case 14: 
        case 19: 
        default: 
          AppMethodBeat.o(152554);
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
            localbhj.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152554);
          return 0;
        case 2: 
          localbhj.LRH = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(152554);
          return 0;
        case 3: 
          localbhj.LRI = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(152554);
          return 0;
        case 4: 
          localbhj.KCD = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(152554);
          return 0;
        case 5: 
          localbhj.Title = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(152554);
          return 0;
        case 6: 
          localbhj.iAc = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(152554);
          return 0;
        case 7: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cee();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cee)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localbhj.LRJ = ((cee)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152554);
          return 0;
        case 8: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bgt();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bgt)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localbhj.LRK = ((bgt)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152554);
          return 0;
        case 9: 
          localbhj.UserName = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(152554);
          return 0;
        case 15: 
          localbhj.LRL = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(152554);
          return 0;
        case 16: 
          localbhj.LRM = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(152554);
          return 0;
        case 17: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new px();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((px)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localbhj.LRN.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152554);
          return 0;
        case 18: 
          localbhj.LRO = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(152554);
          return 0;
        case 20: 
          localbhj.SSID = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(152554);
          return 0;
        case 21: 
          localbhj.KCt = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(152554);
          return 0;
        case 22: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new aey();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((aey)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localbhj.LRP = ((aey)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152554);
          return 0;
        case 23: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localbhj.LRQ = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152554);
          return 0;
        case 24: 
          localbhj.LRR = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(152554);
          return 0;
        case 25: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ccc();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ccc)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localbhj.LRq.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152554);
          return 0;
        case 26: 
          localbhj.xJH = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(152554);
          return 0;
        case 27: 
          localbhj.LRk = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(152554);
          return 0;
        case 28: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localbhj.LRE = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152554);
          return 0;
        case 29: 
          localbhj.LRl = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(152554);
          return 0;
        case 30: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localbhj.LRS = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152554);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new SKBuiltinBuffer_t();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localbhj.LRT = ((SKBuiltinBuffer_t)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(152554);
        return 0;
      }
      AppMethodBeat.o(152554);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bhj
 * JD-Core Version:    0.7.0.1
 */