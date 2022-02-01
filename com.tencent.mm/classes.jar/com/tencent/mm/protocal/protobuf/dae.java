package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;
import java.util.LinkedList;

public final class dae
  extends esc
{
  public LinkedList<daf> aaFA;
  public edh aaFB;
  public esq aaFC;
  public boolean aaFD;
  public js aaFE;
  public boolean aaFF;
  public dac aaFG;
  public dus ign;
  public String wuA;
  public int wuz;
  
  public dae()
  {
    AppMethodBeat.i(72502);
    this.aaFA = new LinkedList();
    AppMethodBeat.o(72502);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(72503);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(72503);
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
      paramVarArgs.e(4, 8, this.aaFA);
      if (this.aaFB != null)
      {
        paramVarArgs.qD(5, this.aaFB.computeSize());
        this.aaFB.writeFields(paramVarArgs);
      }
      if (this.aaFC != null)
      {
        paramVarArgs.qD(6, this.aaFC.computeSize());
        this.aaFC.writeFields(paramVarArgs);
      }
      paramVarArgs.di(7, this.aaFD);
      if (this.aaFE != null)
      {
        paramVarArgs.qD(8, this.aaFE.computeSize());
        this.aaFE.writeFields(paramVarArgs);
      }
      if (this.ign != null)
      {
        paramVarArgs.qD(9, this.ign.computeSize());
        this.ign.writeFields(paramVarArgs);
      }
      paramVarArgs.di(10, this.aaFF);
      if (this.aaFG != null)
      {
        paramVarArgs.qD(11, this.aaFG.computeSize());
        this.aaFG.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(72503);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1312;
      }
    }
    label1312:
    for (paramInt = i.a.a.a.qC(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + i.a.a.b.b.a.cJ(2, this.wuz);
      paramInt = i;
      if (this.wuA != null) {
        paramInt = i + i.a.a.b.b.a.h(3, this.wuA);
      }
      i = paramInt + i.a.a.a.c(4, 8, this.aaFA);
      paramInt = i;
      if (this.aaFB != null) {
        paramInt = i + i.a.a.a.qC(5, this.aaFB.computeSize());
      }
      i = paramInt;
      if (this.aaFC != null) {
        i = paramInt + i.a.a.a.qC(6, this.aaFC.computeSize());
      }
      i += i.a.a.b.b.a.ko(7) + 1;
      paramInt = i;
      if (this.aaFE != null) {
        paramInt = i + i.a.a.a.qC(8, this.aaFE.computeSize());
      }
      i = paramInt;
      if (this.ign != null) {
        i = paramInt + i.a.a.a.qC(9, this.ign.computeSize());
      }
      i += i.a.a.b.b.a.ko(10) + 1;
      paramInt = i;
      if (this.aaFG != null) {
        paramInt = i + i.a.a.a.qC(11, this.aaFG.computeSize());
      }
      AppMethodBeat.o(72503);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.aaFA.clear();
        paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = esc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = esc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(72503);
          throw paramVarArgs;
        }
        AppMethodBeat.o(72503);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        dae localdae = (dae)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(72503);
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
            localdae.BaseResponse = ((kd)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(72503);
          return 0;
        case 2: 
          localdae.wuz = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(72503);
          return 0;
        case 3: 
          localdae.wuA = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(72503);
          return 0;
        case 4: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new daf();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((daf)localObject2).parseFrom((byte[])localObject1);
            }
            localdae.aaFA.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(72503);
          return 0;
        case 5: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new edh();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((edh)localObject2).parseFrom((byte[])localObject1);
            }
            localdae.aaFB = ((edh)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(72503);
          return 0;
        case 6: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new esq();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((esq)localObject2).parseFrom((byte[])localObject1);
            }
            localdae.aaFC = ((esq)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(72503);
          return 0;
        case 7: 
          localdae.aaFD = ((i.a.a.a.a)localObject1).ajGk.aai();
          AppMethodBeat.o(72503);
          return 0;
        case 8: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new js();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((js)localObject2).parseFrom((byte[])localObject1);
            }
            localdae.aaFE = ((js)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(72503);
          return 0;
        case 9: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new dus();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((dus)localObject2).parseFrom((byte[])localObject1);
            }
            localdae.ign = ((dus)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(72503);
          return 0;
        case 10: 
          localdae.aaFF = ((i.a.a.a.a)localObject1).ajGk.aai();
          AppMethodBeat.o(72503);
          return 0;
        }
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new dac();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((dac)localObject2).parseFrom((byte[])localObject1);
          }
          localdae.aaFG = ((dac)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(72503);
        return 0;
      }
      AppMethodBeat.o(72503);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dae
 * JD-Core Version:    0.7.0.1
 */