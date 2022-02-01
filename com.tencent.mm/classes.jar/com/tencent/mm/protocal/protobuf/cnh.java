package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;
import java.util.LinkedList;

public final class cnh
  extends esc
{
  public LinkedList<vt> ZcB;
  public LinkedList<vx> aaqH;
  public int aaqL;
  public wg aaqN;
  public String aaqO;
  public int aaqP;
  public int aaqQ;
  public wp aaqR;
  public wg aauJ;
  public String aauK;
  public String aauL;
  public String wuA;
  public int wuz;
  public int xlj;
  
  public cnh()
  {
    AppMethodBeat.i(260102);
    this.ZcB = new LinkedList();
    this.aaqH = new LinkedList();
    AppMethodBeat.o(260102);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(260111);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(260111);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.qD(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(2, this.wuz);
      if (this.wuA != null) {
        paramVarArgs.g(3, this.wuA);
      }
      paramVarArgs.bS(4, this.xlj);
      paramVarArgs.bS(5, this.aaqL);
      paramVarArgs.e(6, 8, this.ZcB);
      if (this.aaqR != null)
      {
        paramVarArgs.qD(7, this.aaqR.computeSize());
        this.aaqR.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(8, this.aaqP);
      paramVarArgs.bS(9, this.aaqQ);
      if (this.aaqN != null)
      {
        paramVarArgs.qD(10, this.aaqN.computeSize());
        this.aaqN.writeFields(paramVarArgs);
      }
      if (this.aaqO != null) {
        paramVarArgs.g(11, this.aaqO);
      }
      if (this.aauJ != null)
      {
        paramVarArgs.qD(12, this.aauJ.computeSize());
        this.aauJ.writeFields(paramVarArgs);
      }
      if (this.aauK != null) {
        paramVarArgs.g(13, this.aauK);
      }
      if (this.aauL != null) {
        paramVarArgs.g(14, this.aauL);
      }
      paramVarArgs.e(15, 8, this.aaqH);
      AppMethodBeat.o(260111);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1438;
      }
    }
    label1438:
    for (paramInt = i.a.a.a.qC(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + i.a.a.b.b.a.cJ(2, this.wuz);
      paramInt = i;
      if (this.wuA != null) {
        paramInt = i + i.a.a.b.b.a.h(3, this.wuA);
      }
      i = paramInt + i.a.a.b.b.a.cJ(4, this.xlj) + i.a.a.b.b.a.cJ(5, this.aaqL) + i.a.a.a.c(6, 8, this.ZcB);
      paramInt = i;
      if (this.aaqR != null) {
        paramInt = i + i.a.a.a.qC(7, this.aaqR.computeSize());
      }
      i = paramInt + i.a.a.b.b.a.cJ(8, this.aaqP) + i.a.a.b.b.a.cJ(9, this.aaqQ);
      paramInt = i;
      if (this.aaqN != null) {
        paramInt = i + i.a.a.a.qC(10, this.aaqN.computeSize());
      }
      i = paramInt;
      if (this.aaqO != null) {
        i = paramInt + i.a.a.b.b.a.h(11, this.aaqO);
      }
      paramInt = i;
      if (this.aauJ != null) {
        paramInt = i + i.a.a.a.qC(12, this.aauJ.computeSize());
      }
      i = paramInt;
      if (this.aauK != null) {
        i = paramInt + i.a.a.b.b.a.h(13, this.aauK);
      }
      paramInt = i;
      if (this.aauL != null) {
        paramInt = i + i.a.a.b.b.a.h(14, this.aauL);
      }
      i = i.a.a.a.c(15, 8, this.aaqH);
      AppMethodBeat.o(260111);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.ZcB.clear();
        this.aaqH.clear();
        paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = esc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = esc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(260111);
          throw paramVarArgs;
        }
        AppMethodBeat.o(260111);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        cnh localcnh = (cnh)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(260111);
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
            localcnh.BaseResponse = ((kd)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(260111);
          return 0;
        case 2: 
          localcnh.wuz = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(260111);
          return 0;
        case 3: 
          localcnh.wuA = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(260111);
          return 0;
        case 4: 
          localcnh.xlj = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(260111);
          return 0;
        case 5: 
          localcnh.aaqL = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(260111);
          return 0;
        case 6: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new vt();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((vt)localObject2).parseFrom((byte[])localObject1);
            }
            localcnh.ZcB.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(260111);
          return 0;
        case 7: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new wp();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((wp)localObject2).parseFrom((byte[])localObject1);
            }
            localcnh.aaqR = ((wp)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(260111);
          return 0;
        case 8: 
          localcnh.aaqP = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(260111);
          return 0;
        case 9: 
          localcnh.aaqQ = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(260111);
          return 0;
        case 10: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new wg();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((wg)localObject2).parseFrom((byte[])localObject1);
            }
            localcnh.aaqN = ((wg)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(260111);
          return 0;
        case 11: 
          localcnh.aaqO = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(260111);
          return 0;
        case 12: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new wg();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((wg)localObject2).parseFrom((byte[])localObject1);
            }
            localcnh.aauJ = ((wg)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(260111);
          return 0;
        case 13: 
          localcnh.aauK = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(260111);
          return 0;
        case 14: 
          localcnh.aauL = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(260111);
          return 0;
        }
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new vx();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((vx)localObject2).parseFrom((byte[])localObject1);
          }
          localcnh.aaqH.add(localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(260111);
        return 0;
      }
      AppMethodBeat.o(260111);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cnh
 * JD-Core Version:    0.7.0.1
 */