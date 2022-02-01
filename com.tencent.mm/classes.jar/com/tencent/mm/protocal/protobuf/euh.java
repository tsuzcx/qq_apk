package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class euh
  extends erp
{
  public nq ORh;
  public no YPQ;
  public np YPR;
  public long YPS;
  public long aaxM;
  public int abxi;
  public boolean abxj;
  public int mode;
  public LinkedList<eug> msn;
  
  public euh()
  {
    AppMethodBeat.i(257572);
    this.msn = new LinkedList();
    AppMethodBeat.o(257572);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(257578);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.qD(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.bv(2, this.aaxM);
      paramVarArgs.bS(5, this.mode);
      paramVarArgs.bv(7, this.YPS);
      paramVarArgs.bS(9, this.abxi);
      paramVarArgs.di(10, this.abxj);
      paramVarArgs.e(8, 8, this.msn);
      if (this.ORh != null)
      {
        paramVarArgs.qD(101, this.ORh.computeSize());
        this.ORh.writeFields(paramVarArgs);
      }
      if (this.YPQ != null)
      {
        paramVarArgs.qD(102, this.YPQ.computeSize());
        this.YPQ.writeFields(paramVarArgs);
      }
      if (this.YPR != null)
      {
        paramVarArgs.qD(103, this.YPR.computeSize());
        this.YPR.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(257578);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label1060;
      }
    }
    label1060:
    for (paramInt = i.a.a.a.qC(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + i.a.a.b.b.a.q(2, this.aaxM) + i.a.a.b.b.a.cJ(5, this.mode) + i.a.a.b.b.a.q(7, this.YPS) + i.a.a.b.b.a.cJ(9, this.abxi) + (i.a.a.b.b.a.ko(10) + 1) + i.a.a.a.c(8, 8, this.msn);
      paramInt = i;
      if (this.ORh != null) {
        paramInt = i + i.a.a.a.qC(101, this.ORh.computeSize());
      }
      i = paramInt;
      if (this.YPQ != null) {
        i = paramInt + i.a.a.a.qC(102, this.YPQ.computeSize());
      }
      paramInt = i;
      if (this.YPR != null) {
        paramInt = i + i.a.a.a.qC(103, this.YPR.computeSize());
      }
      AppMethodBeat.o(257578);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.msn.clear();
        paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = erp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = erp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(257578);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        euh localeuh = (euh)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(257578);
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
            localeuh.BaseRequest = ((kc)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(257578);
          return 0;
        case 2: 
          localeuh.aaxM = ((i.a.a.a.a)localObject1).ajGk.aaw();
          AppMethodBeat.o(257578);
          return 0;
        case 5: 
          localeuh.mode = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(257578);
          return 0;
        case 7: 
          localeuh.YPS = ((i.a.a.a.a)localObject1).ajGk.aaw();
          AppMethodBeat.o(257578);
          return 0;
        case 9: 
          localeuh.abxi = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(257578);
          return 0;
        case 10: 
          localeuh.abxj = ((i.a.a.a.a)localObject1).ajGk.aai();
          AppMethodBeat.o(257578);
          return 0;
        case 8: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new eug();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((eug)localObject2).parseFrom((byte[])localObject1);
            }
            localeuh.msn.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(257578);
          return 0;
        case 101: 
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
            localeuh.ORh = ((nq)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(257578);
          return 0;
        case 102: 
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
            localeuh.YPQ = ((no)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(257578);
          return 0;
        }
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
          localeuh.YPR = ((np)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(257578);
        return 0;
      }
      AppMethodBeat.o(257578);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.euh
 * JD-Core Version:    0.7.0.1
 */