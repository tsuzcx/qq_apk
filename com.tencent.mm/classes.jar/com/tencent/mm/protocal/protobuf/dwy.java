package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;
import java.util.LinkedList;

public final class dwy
  extends esc
{
  public String YNK;
  public eff YNL;
  public dyt YNM;
  public String abcG;
  public String abcN;
  public dck abcO;
  public String wuA;
  public int wuz;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(72531);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(72531);
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
      if (this.abcG != null) {
        paramVarArgs.g(4, this.abcG);
      }
      if (this.YNK != null) {
        paramVarArgs.g(5, this.YNK);
      }
      if (this.abcN != null) {
        paramVarArgs.g(6, this.abcN);
      }
      if (this.YNL != null)
      {
        paramVarArgs.qD(7, this.YNL.computeSize());
        this.YNL.writeFields(paramVarArgs);
      }
      if (this.YNM != null)
      {
        paramVarArgs.qD(8, this.YNM.computeSize());
        this.YNM.writeFields(paramVarArgs);
      }
      if (this.abcO != null)
      {
        paramVarArgs.qD(9, this.abcO.computeSize());
        this.abcO.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(72531);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1022;
      }
    }
    label1022:
    for (paramInt = i.a.a.a.qC(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + i.a.a.b.b.a.cJ(2, this.wuz);
      paramInt = i;
      if (this.wuA != null) {
        paramInt = i + i.a.a.b.b.a.h(3, this.wuA);
      }
      i = paramInt;
      if (this.abcG != null) {
        i = paramInt + i.a.a.b.b.a.h(4, this.abcG);
      }
      paramInt = i;
      if (this.YNK != null) {
        paramInt = i + i.a.a.b.b.a.h(5, this.YNK);
      }
      i = paramInt;
      if (this.abcN != null) {
        i = paramInt + i.a.a.b.b.a.h(6, this.abcN);
      }
      paramInt = i;
      if (this.YNL != null) {
        paramInt = i + i.a.a.a.qC(7, this.YNL.computeSize());
      }
      i = paramInt;
      if (this.YNM != null) {
        i = paramInt + i.a.a.a.qC(8, this.YNM.computeSize());
      }
      paramInt = i;
      if (this.abcO != null) {
        paramInt = i + i.a.a.a.qC(9, this.abcO.computeSize());
      }
      AppMethodBeat.o(72531);
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
          AppMethodBeat.o(72531);
          throw paramVarArgs;
        }
        AppMethodBeat.o(72531);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        dwy localdwy = (dwy)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(72531);
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
            localdwy.BaseResponse = ((kd)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(72531);
          return 0;
        case 2: 
          localdwy.wuz = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(72531);
          return 0;
        case 3: 
          localdwy.wuA = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(72531);
          return 0;
        case 4: 
          localdwy.abcG = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(72531);
          return 0;
        case 5: 
          localdwy.YNK = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(72531);
          return 0;
        case 6: 
          localdwy.abcN = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(72531);
          return 0;
        case 7: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new eff();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((eff)localObject2).parseFrom((byte[])localObject1);
            }
            localdwy.YNL = ((eff)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(72531);
          return 0;
        case 8: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new dyt();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((dyt)localObject2).parseFrom((byte[])localObject1);
            }
            localdwy.YNM = ((dyt)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(72531);
          return 0;
        }
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new dck();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((dck)localObject2).parseFrom((byte[])localObject1);
          }
          localdwy.abcO = ((dck)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(72531);
        return 0;
      }
      AppMethodBeat.o(72531);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dwy
 * JD-Core Version:    0.7.0.1
 */