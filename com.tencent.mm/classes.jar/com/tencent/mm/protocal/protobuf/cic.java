package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;
import java.util.LinkedList;

public final class cic
  extends esc
{
  public int aaqL;
  public wa aaqM;
  public wg aaqN;
  public String aaqO;
  public int aaqP;
  public int aaqQ;
  public wp aaqR;
  public String wuA;
  public int wuz;
  public int xlj;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(258857);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(258857);
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
      if (this.aaqN != null)
      {
        paramVarArgs.qD(7, this.aaqN.computeSize());
        this.aaqN.writeFields(paramVarArgs);
      }
      if (this.aaqO != null) {
        paramVarArgs.g(8, this.aaqO);
      }
      paramVarArgs.bS(9, this.aaqP);
      paramVarArgs.bS(10, this.aaqQ);
      if (this.aaqR != null)
      {
        paramVarArgs.qD(11, this.aaqR.computeSize());
        this.aaqR.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(258857);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1078;
      }
    }
    label1078:
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
      if (this.aaqN != null) {
        i = paramInt + i.a.a.a.qC(7, this.aaqN.computeSize());
      }
      paramInt = i;
      if (this.aaqO != null) {
        paramInt = i + i.a.a.b.b.a.h(8, this.aaqO);
      }
      i = paramInt + i.a.a.b.b.a.cJ(9, this.aaqP) + i.a.a.b.b.a.cJ(10, this.aaqQ);
      paramInt = i;
      if (this.aaqR != null) {
        paramInt = i + i.a.a.a.qC(11, this.aaqR.computeSize());
      }
      AppMethodBeat.o(258857);
      return paramInt;
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
          AppMethodBeat.o(258857);
          throw paramVarArgs;
        }
        AppMethodBeat.o(258857);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        cic localcic = (cic)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(258857);
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
            localcic.BaseResponse = ((kd)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(258857);
          return 0;
        case 2: 
          localcic.wuz = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(258857);
          return 0;
        case 3: 
          localcic.wuA = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(258857);
          return 0;
        case 4: 
          localcic.xlj = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(258857);
          return 0;
        case 5: 
          localcic.aaqL = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(258857);
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
            localcic.aaqM = ((wa)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(258857);
          return 0;
        case 7: 
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
            localcic.aaqN = ((wg)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(258857);
          return 0;
        case 8: 
          localcic.aaqO = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(258857);
          return 0;
        case 9: 
          localcic.aaqP = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(258857);
          return 0;
        case 10: 
          localcic.aaqQ = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(258857);
          return 0;
        }
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
          localcic.aaqR = ((wp)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(258857);
        return 0;
      }
      AppMethodBeat.o(258857);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cic
 * JD-Core Version:    0.7.0.1
 */