package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;
import java.util.LinkedList;

public final class cnl
  extends esc
{
  public int aaqL;
  public wa aaqM;
  public int aaqP;
  public int aaqQ;
  public wp aaqR;
  public we aauN;
  public vx aauO;
  public String aauP;
  public wd aauQ;
  public String wuA;
  public int wuz;
  public int xlj;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(114029);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(114029);
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
      if (this.aaqM != null)
      {
        paramVarArgs.qD(6, this.aaqM.computeSize());
        this.aaqM.writeFields(paramVarArgs);
      }
      if (this.aauN != null)
      {
        paramVarArgs.qD(7, this.aauN.computeSize());
        this.aauN.writeFields(paramVarArgs);
      }
      if (this.aauO != null)
      {
        paramVarArgs.qD(8, this.aauO.computeSize());
        this.aauO.writeFields(paramVarArgs);
      }
      if (this.aauP != null) {
        paramVarArgs.g(10, this.aauP);
      }
      paramVarArgs.bS(11, this.aaqP);
      paramVarArgs.bS(12, this.aaqQ);
      if (this.aaqR != null)
      {
        paramVarArgs.qD(13, this.aaqR.computeSize());
        this.aaqR.writeFields(paramVarArgs);
      }
      if (this.aauQ != null)
      {
        paramVarArgs.qD(14, this.aauQ.computeSize());
        this.aauQ.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(114029);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1350;
      }
    }
    label1350:
    for (paramInt = i.a.a.a.qC(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + i.a.a.b.b.a.cJ(2, this.wuz);
      paramInt = i;
      if (this.wuA != null) {
        paramInt = i + i.a.a.b.b.a.h(3, this.wuA);
      }
      i = paramInt + i.a.a.b.b.a.cJ(4, this.xlj) + i.a.a.b.b.a.cJ(5, this.aaqL);
      paramInt = i;
      if (this.aaqM != null) {
        paramInt = i + i.a.a.a.qC(6, this.aaqM.computeSize());
      }
      i = paramInt;
      if (this.aauN != null) {
        i = paramInt + i.a.a.a.qC(7, this.aauN.computeSize());
      }
      paramInt = i;
      if (this.aauO != null) {
        paramInt = i + i.a.a.a.qC(8, this.aauO.computeSize());
      }
      i = paramInt;
      if (this.aauP != null) {
        i = paramInt + i.a.a.b.b.a.h(10, this.aauP);
      }
      i = i + i.a.a.b.b.a.cJ(11, this.aaqP) + i.a.a.b.b.a.cJ(12, this.aaqQ);
      paramInt = i;
      if (this.aaqR != null) {
        paramInt = i + i.a.a.a.qC(13, this.aaqR.computeSize());
      }
      i = paramInt;
      if (this.aauQ != null) {
        i = paramInt + i.a.a.a.qC(14, this.aauQ.computeSize());
      }
      AppMethodBeat.o(114029);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = esc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = esc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(114029);
          throw paramVarArgs;
        }
        AppMethodBeat.o(114029);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        cnl localcnl = (cnl)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        case 9: 
        default: 
          AppMethodBeat.o(114029);
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
            localcnl.BaseResponse = ((kd)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(114029);
          return 0;
        case 2: 
          localcnl.wuz = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(114029);
          return 0;
        case 3: 
          localcnl.wuA = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(114029);
          return 0;
        case 4: 
          localcnl.xlj = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(114029);
          return 0;
        case 5: 
          localcnl.aaqL = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(114029);
          return 0;
        case 6: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new wa();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((wa)localObject2).parseFrom((byte[])localObject1);
            }
            localcnl.aaqM = ((wa)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(114029);
          return 0;
        case 7: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new we();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((we)localObject2).parseFrom((byte[])localObject1);
            }
            localcnl.aauN = ((we)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(114029);
          return 0;
        case 8: 
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
            localcnl.aauO = ((vx)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(114029);
          return 0;
        case 10: 
          localcnl.aauP = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(114029);
          return 0;
        case 11: 
          localcnl.aaqP = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(114029);
          return 0;
        case 12: 
          localcnl.aaqQ = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(114029);
          return 0;
        case 13: 
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
            localcnl.aaqR = ((wp)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(114029);
          return 0;
        }
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new wd();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((wd)localObject2).parseFrom((byte[])localObject1);
          }
          localcnl.aauQ = ((wd)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(114029);
        return 0;
      }
      AppMethodBeat.o(114029);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cnl
 * JD-Core Version:    0.7.0.1
 */