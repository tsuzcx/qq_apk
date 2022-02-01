package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;
import java.util.LinkedList;

public final class nr
  extends erp
{
  public nq ORh;
  public b YPG;
  public String YPH;
  public int YPI;
  public int YPJ;
  public long YPK;
  public boolean YPL;
  public boolean YPM;
  public GoodsObject YPN;
  public int YPO;
  public int YPP;
  public no YPQ;
  public np YPR;
  public long YPS;
  public String YPy;
  public String YPz;
  public int mode;
  public int type;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(124394);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.qD(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.YPG != null) {
        paramVarArgs.d(2, this.YPG);
      }
      paramVarArgs.bS(11, this.type);
      paramVarArgs.bS(12, this.mode);
      if (this.YPy != null) {
        paramVarArgs.g(13, this.YPy);
      }
      if (this.YPz != null) {
        paramVarArgs.g(14, this.YPz);
      }
      if (this.YPH != null) {
        paramVarArgs.g(15, this.YPH);
      }
      paramVarArgs.bS(16, this.YPI);
      paramVarArgs.bS(17, this.YPJ);
      paramVarArgs.bv(18, this.YPK);
      paramVarArgs.di(19, this.YPL);
      paramVarArgs.di(20, this.YPM);
      if (this.YPN != null)
      {
        paramVarArgs.qD(21, this.YPN.computeSize());
        this.YPN.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(22, this.YPO);
      paramVarArgs.bS(23, this.YPP);
      if (this.ORh != null)
      {
        paramVarArgs.qD(26, this.ORh.computeSize());
        this.ORh.writeFields(paramVarArgs);
      }
      if (this.YPQ != null)
      {
        paramVarArgs.qD(31, this.YPQ.computeSize());
        this.YPQ.writeFields(paramVarArgs);
      }
      if (this.YPR != null)
      {
        paramVarArgs.qD(32, this.YPR.computeSize());
        this.YPR.writeFields(paramVarArgs);
      }
      paramVarArgs.bv(50, this.YPS);
      AppMethodBeat.o(124394);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label1584;
      }
    }
    label1584:
    for (paramInt = i.a.a.a.qC(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.YPG != null) {
        i = paramInt + i.a.a.b.b.a.c(2, this.YPG);
      }
      i = i + i.a.a.b.b.a.cJ(11, this.type) + i.a.a.b.b.a.cJ(12, this.mode);
      paramInt = i;
      if (this.YPy != null) {
        paramInt = i + i.a.a.b.b.a.h(13, this.YPy);
      }
      i = paramInt;
      if (this.YPz != null) {
        i = paramInt + i.a.a.b.b.a.h(14, this.YPz);
      }
      paramInt = i;
      if (this.YPH != null) {
        paramInt = i + i.a.a.b.b.a.h(15, this.YPH);
      }
      i = paramInt + i.a.a.b.b.a.cJ(16, this.YPI) + i.a.a.b.b.a.cJ(17, this.YPJ) + i.a.a.b.b.a.q(18, this.YPK) + (i.a.a.b.b.a.ko(19) + 1) + (i.a.a.b.b.a.ko(20) + 1);
      paramInt = i;
      if (this.YPN != null) {
        paramInt = i + i.a.a.a.qC(21, this.YPN.computeSize());
      }
      i = paramInt + i.a.a.b.b.a.cJ(22, this.YPO) + i.a.a.b.b.a.cJ(23, this.YPP);
      paramInt = i;
      if (this.ORh != null) {
        paramInt = i + i.a.a.a.qC(26, this.ORh.computeSize());
      }
      i = paramInt;
      if (this.YPQ != null) {
        i = paramInt + i.a.a.a.qC(31, this.YPQ.computeSize());
      }
      paramInt = i;
      if (this.YPR != null) {
        paramInt = i + i.a.a.a.qC(32, this.YPR.computeSize());
      }
      i = i.a.a.b.b.a.q(50, this.YPS);
      AppMethodBeat.o(124394);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = erp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = erp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(124394);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        nr localnr = (nr)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(124394);
          return -1;
        case 1: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new kc();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((kc)localObject2).parseFrom((byte[])localObject1);
            }
            localnr.BaseRequest = ((kc)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(124394);
          return 0;
        case 2: 
          localnr.YPG = ((i.a.a.a.a)localObject1).ajGk.kFX();
          AppMethodBeat.o(124394);
          return 0;
        case 11: 
          localnr.type = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(124394);
          return 0;
        case 12: 
          localnr.mode = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(124394);
          return 0;
        case 13: 
          localnr.YPy = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(124394);
          return 0;
        case 14: 
          localnr.YPz = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(124394);
          return 0;
        case 15: 
          localnr.YPH = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(124394);
          return 0;
        case 16: 
          localnr.YPI = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(124394);
          return 0;
        case 17: 
          localnr.YPJ = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(124394);
          return 0;
        case 18: 
          localnr.YPK = ((i.a.a.a.a)localObject1).ajGk.aaw();
          AppMethodBeat.o(124394);
          return 0;
        case 19: 
          localnr.YPL = ((i.a.a.a.a)localObject1).ajGk.aai();
          AppMethodBeat.o(124394);
          return 0;
        case 20: 
          localnr.YPM = ((i.a.a.a.a)localObject1).ajGk.aai();
          AppMethodBeat.o(124394);
          return 0;
        case 21: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new GoodsObject();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((GoodsObject)localObject2).parseFrom((byte[])localObject1);
            }
            localnr.YPN = ((GoodsObject)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(124394);
          return 0;
        case 22: 
          localnr.YPO = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(124394);
          return 0;
        case 23: 
          localnr.YPP = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(124394);
          return 0;
        case 26: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new nq();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((nq)localObject2).parseFrom((byte[])localObject1);
            }
            localnr.ORh = ((nq)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(124394);
          return 0;
        case 31: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new no();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((no)localObject2).parseFrom((byte[])localObject1);
            }
            localnr.YPQ = ((no)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(124394);
          return 0;
        case 32: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new np();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((np)localObject2).parseFrom((byte[])localObject1);
            }
            localnr.YPR = ((np)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(124394);
          return 0;
        }
        localnr.YPS = ((i.a.a.a.a)localObject1).ajGk.aaw();
        AppMethodBeat.o(124394);
        return 0;
      }
      AppMethodBeat.o(124394);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.nr
 * JD-Core Version:    0.7.0.1
 */