package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;
import java.util.LinkedList;

public final class fcg
  extends esc
{
  public String YJg;
  public int abBK;
  public ic abBL;
  public LinkedList<ie> abBM;
  public String abBN;
  public String abBO;
  public if abBP;
  public LinkedList<if> abBQ;
  public fxc abBR;
  public boolean abBS;
  public String abBT;
  public ib abBU;
  public String abaT;
  public id abzA;
  public String hFb;
  public String nSt;
  public String title;
  
  public fcg()
  {
    AppMethodBeat.i(123652);
    this.abBM = new LinkedList();
    this.abBQ = new LinkedList();
    AppMethodBeat.o(123652);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(123653);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(123653);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.qD(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.abzA != null)
      {
        paramVarArgs.qD(2, this.abzA.computeSize());
        this.abzA.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(3, this.abBK);
      if (this.abBL != null)
      {
        paramVarArgs.qD(4, this.abBL.computeSize());
        this.abBL.writeFields(paramVarArgs);
      }
      if (this.title != null) {
        paramVarArgs.g(5, this.title);
      }
      if (this.abaT != null) {
        paramVarArgs.g(6, this.abaT);
      }
      if (this.nSt != null) {
        paramVarArgs.g(7, this.nSt);
      }
      if (this.YJg != null) {
        paramVarArgs.g(8, this.YJg);
      }
      paramVarArgs.e(9, 8, this.abBM);
      if (this.abBN != null) {
        paramVarArgs.g(10, this.abBN);
      }
      if (this.abBO != null) {
        paramVarArgs.g(11, this.abBO);
      }
      if (this.abBP != null)
      {
        paramVarArgs.qD(12, this.abBP.computeSize());
        this.abBP.writeFields(paramVarArgs);
      }
      paramVarArgs.e(13, 8, this.abBQ);
      if (this.hFb != null) {
        paramVarArgs.g(14, this.hFb);
      }
      if (this.abBR != null)
      {
        paramVarArgs.qD(15, this.abBR.computeSize());
        this.abBR.writeFields(paramVarArgs);
      }
      paramVarArgs.di(16, this.abBS);
      if (this.abBT != null) {
        paramVarArgs.g(17, this.abBT);
      }
      if (this.abBU != null)
      {
        paramVarArgs.qD(19, this.abBU.computeSize());
        this.abBU.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(123653);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1826;
      }
    }
    label1826:
    for (paramInt = i.a.a.a.qC(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.abzA != null) {
        i = paramInt + i.a.a.a.qC(2, this.abzA.computeSize());
      }
      i += i.a.a.b.b.a.cJ(3, this.abBK);
      paramInt = i;
      if (this.abBL != null) {
        paramInt = i + i.a.a.a.qC(4, this.abBL.computeSize());
      }
      i = paramInt;
      if (this.title != null) {
        i = paramInt + i.a.a.b.b.a.h(5, this.title);
      }
      paramInt = i;
      if (this.abaT != null) {
        paramInt = i + i.a.a.b.b.a.h(6, this.abaT);
      }
      i = paramInt;
      if (this.nSt != null) {
        i = paramInt + i.a.a.b.b.a.h(7, this.nSt);
      }
      paramInt = i;
      if (this.YJg != null) {
        paramInt = i + i.a.a.b.b.a.h(8, this.YJg);
      }
      i = paramInt + i.a.a.a.c(9, 8, this.abBM);
      paramInt = i;
      if (this.abBN != null) {
        paramInt = i + i.a.a.b.b.a.h(10, this.abBN);
      }
      i = paramInt;
      if (this.abBO != null) {
        i = paramInt + i.a.a.b.b.a.h(11, this.abBO);
      }
      paramInt = i;
      if (this.abBP != null) {
        paramInt = i + i.a.a.a.qC(12, this.abBP.computeSize());
      }
      i = paramInt + i.a.a.a.c(13, 8, this.abBQ);
      paramInt = i;
      if (this.hFb != null) {
        paramInt = i + i.a.a.b.b.a.h(14, this.hFb);
      }
      i = paramInt;
      if (this.abBR != null) {
        i = paramInt + i.a.a.a.qC(15, this.abBR.computeSize());
      }
      i += i.a.a.b.b.a.ko(16) + 1;
      paramInt = i;
      if (this.abBT != null) {
        paramInt = i + i.a.a.b.b.a.h(17, this.abBT);
      }
      i = paramInt;
      if (this.abBU != null) {
        i = paramInt + i.a.a.a.qC(19, this.abBU.computeSize());
      }
      AppMethodBeat.o(123653);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.abBM.clear();
        this.abBQ.clear();
        paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = esc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = esc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(123653);
          throw paramVarArgs;
        }
        AppMethodBeat.o(123653);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        fcg localfcg = (fcg)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        case 18: 
        default: 
          AppMethodBeat.o(123653);
          return -1;
        case 1: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new kd();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((kd)localObject2).parseFrom((byte[])localObject1);
            }
            localfcg.BaseResponse = ((kd)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(123653);
          return 0;
        case 2: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new id();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((id)localObject2).parseFrom((byte[])localObject1);
            }
            localfcg.abzA = ((id)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(123653);
          return 0;
        case 3: 
          localfcg.abBK = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(123653);
          return 0;
        case 4: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new ic();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((ic)localObject2).parseFrom((byte[])localObject1);
            }
            localfcg.abBL = ((ic)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(123653);
          return 0;
        case 5: 
          localfcg.title = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(123653);
          return 0;
        case 6: 
          localfcg.abaT = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(123653);
          return 0;
        case 7: 
          localfcg.nSt = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(123653);
          return 0;
        case 8: 
          localfcg.YJg = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(123653);
          return 0;
        case 9: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new ie();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((ie)localObject2).parseFrom((byte[])localObject1);
            }
            localfcg.abBM.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(123653);
          return 0;
        case 10: 
          localfcg.abBN = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(123653);
          return 0;
        case 11: 
          localfcg.abBO = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(123653);
          return 0;
        case 12: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new if();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((if)localObject2).parseFrom((byte[])localObject1);
            }
            localfcg.abBP = ((if)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(123653);
          return 0;
        case 13: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new if();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((if)localObject2).parseFrom((byte[])localObject1);
            }
            localfcg.abBQ.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(123653);
          return 0;
        case 14: 
          localfcg.hFb = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(123653);
          return 0;
        case 15: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new fxc();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((fxc)localObject2).parseFrom((byte[])localObject1);
            }
            localfcg.abBR = ((fxc)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(123653);
          return 0;
        case 16: 
          localfcg.abBS = ((i.a.a.a.a)localObject1).ajGk.aai();
          AppMethodBeat.o(123653);
          return 0;
        case 17: 
          localfcg.abBT = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(123653);
          return 0;
        }
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new ib();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((ib)localObject2).parseFrom((byte[])localObject1);
          }
          localfcg.abBU = ((ib)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(123653);
        return 0;
      }
      AppMethodBeat.o(123653);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fcg
 * JD-Core Version:    0.7.0.1
 */