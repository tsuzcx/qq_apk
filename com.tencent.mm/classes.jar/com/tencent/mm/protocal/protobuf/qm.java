package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;
import java.util.LinkedList;

public final class qm
  extends esc
{
  public int YRD;
  public nj YVl;
  public ol YVm;
  public py YVn;
  public on YVo;
  public py YVp;
  public re YVq;
  public LinkedList<cao> YVr;
  public int YVs;
  public ehk YVt;
  public String YVu;
  public rm YVv;
  public rp YVw;
  public int YVx;
  public LinkedList<pj> YVy;
  
  public qm()
  {
    AppMethodBeat.i(124444);
    this.YVr = new LinkedList();
    this.YVy = new LinkedList();
    AppMethodBeat.o(124444);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(124445);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(124445);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.qD(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.YVl != null)
      {
        paramVarArgs.qD(2, this.YVl.computeSize());
        this.YVl.writeFields(paramVarArgs);
      }
      if (this.YVm != null)
      {
        paramVarArgs.qD(3, this.YVm.computeSize());
        this.YVm.writeFields(paramVarArgs);
      }
      if (this.YVn != null)
      {
        paramVarArgs.qD(4, this.YVn.computeSize());
        this.YVn.writeFields(paramVarArgs);
      }
      if (this.YVo != null)
      {
        paramVarArgs.qD(5, this.YVo.computeSize());
        this.YVo.writeFields(paramVarArgs);
      }
      if (this.YVp != null)
      {
        paramVarArgs.qD(6, this.YVp.computeSize());
        this.YVp.writeFields(paramVarArgs);
      }
      if (this.YVq != null)
      {
        paramVarArgs.qD(7, this.YVq.computeSize());
        this.YVq.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(8, this.YRD);
      paramVarArgs.e(9, 8, this.YVr);
      paramVarArgs.bS(10, this.YVs);
      if (this.YVt != null)
      {
        paramVarArgs.qD(11, this.YVt.computeSize());
        this.YVt.writeFields(paramVarArgs);
      }
      if (this.YVu != null) {
        paramVarArgs.g(12, this.YVu);
      }
      if (this.YVv != null)
      {
        paramVarArgs.qD(13, this.YVv.computeSize());
        this.YVv.writeFields(paramVarArgs);
      }
      if (this.YVw != null)
      {
        paramVarArgs.qD(14, this.YVw.computeSize());
        this.YVw.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(17, this.YVx);
      paramVarArgs.e(20, 8, this.YVy);
      AppMethodBeat.o(124445);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1986;
      }
    }
    label1986:
    for (int i = i.a.a.a.qC(1, this.BaseResponse.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.YVl != null) {
        paramInt = i + i.a.a.a.qC(2, this.YVl.computeSize());
      }
      i = paramInt;
      if (this.YVm != null) {
        i = paramInt + i.a.a.a.qC(3, this.YVm.computeSize());
      }
      paramInt = i;
      if (this.YVn != null) {
        paramInt = i + i.a.a.a.qC(4, this.YVn.computeSize());
      }
      i = paramInt;
      if (this.YVo != null) {
        i = paramInt + i.a.a.a.qC(5, this.YVo.computeSize());
      }
      paramInt = i;
      if (this.YVp != null) {
        paramInt = i + i.a.a.a.qC(6, this.YVp.computeSize());
      }
      i = paramInt;
      if (this.YVq != null) {
        i = paramInt + i.a.a.a.qC(7, this.YVq.computeSize());
      }
      i = i + i.a.a.b.b.a.cJ(8, this.YRD) + i.a.a.a.c(9, 8, this.YVr) + i.a.a.b.b.a.cJ(10, this.YVs);
      paramInt = i;
      if (this.YVt != null) {
        paramInt = i + i.a.a.a.qC(11, this.YVt.computeSize());
      }
      i = paramInt;
      if (this.YVu != null) {
        i = paramInt + i.a.a.b.b.a.h(12, this.YVu);
      }
      paramInt = i;
      if (this.YVv != null) {
        paramInt = i + i.a.a.a.qC(13, this.YVv.computeSize());
      }
      i = paramInt;
      if (this.YVw != null) {
        i = paramInt + i.a.a.a.qC(14, this.YVw.computeSize());
      }
      paramInt = i.a.a.b.b.a.cJ(17, this.YVx);
      int j = i.a.a.a.c(20, 8, this.YVy);
      AppMethodBeat.o(124445);
      return i + paramInt + j;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.YVr.clear();
        this.YVy.clear();
        paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = esc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = esc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(124445);
          throw paramVarArgs;
        }
        AppMethodBeat.o(124445);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        qm localqm = (qm)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        case 15: 
        case 16: 
        case 18: 
        case 19: 
        default: 
          AppMethodBeat.o(124445);
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
            localqm.BaseResponse = ((kd)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(124445);
          return 0;
        case 2: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new nj();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((nj)localObject2).parseFrom((byte[])localObject1);
            }
            localqm.YVl = ((nj)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(124445);
          return 0;
        case 3: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new ol();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((ol)localObject2).parseFrom((byte[])localObject1);
            }
            localqm.YVm = ((ol)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(124445);
          return 0;
        case 4: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new py();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((py)localObject2).parseFrom((byte[])localObject1);
            }
            localqm.YVn = ((py)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(124445);
          return 0;
        case 5: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new on();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((on)localObject2).parseFrom((byte[])localObject1);
            }
            localqm.YVo = ((on)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(124445);
          return 0;
        case 6: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new py();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((py)localObject2).parseFrom((byte[])localObject1);
            }
            localqm.YVp = ((py)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(124445);
          return 0;
        case 7: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new re();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((re)localObject2).parseFrom((byte[])localObject1);
            }
            localqm.YVq = ((re)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(124445);
          return 0;
        case 8: 
          localqm.YRD = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(124445);
          return 0;
        case 9: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new cao();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((cao)localObject2).parseFrom((byte[])localObject1);
            }
            localqm.YVr.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(124445);
          return 0;
        case 10: 
          localqm.YVs = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(124445);
          return 0;
        case 11: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new ehk();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((ehk)localObject2).parseFrom((byte[])localObject1);
            }
            localqm.YVt = ((ehk)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(124445);
          return 0;
        case 12: 
          localqm.YVu = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(124445);
          return 0;
        case 13: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new rm();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((rm)localObject2).parseFrom((byte[])localObject1);
            }
            localqm.YVv = ((rm)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(124445);
          return 0;
        case 14: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new rp();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((rp)localObject2).parseFrom((byte[])localObject1);
            }
            localqm.YVw = ((rp)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(124445);
          return 0;
        case 17: 
          localqm.YVx = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(124445);
          return 0;
        }
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new pj();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((pj)localObject2).parseFrom((byte[])localObject1);
          }
          localqm.YVy.add(localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(124445);
        return 0;
      }
      AppMethodBeat.o(124445);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.qm
 * JD-Core Version:    0.7.0.1
 */