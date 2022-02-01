package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;
import java.util.LinkedList;

public final class dzb
  extends esc
{
  public int abdR;
  public int abdS;
  public String abdT;
  public String abdU;
  public int abdV;
  public int abdW;
  public int hAV;
  public dus ign;
  public String pHt;
  public String pHu;
  public String wYI;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(72539);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(72539);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.qD(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(2, this.hAV);
      if (this.wYI != null) {
        paramVarArgs.g(3, this.wYI);
      }
      paramVarArgs.bS(4, this.abdR);
      paramVarArgs.bS(5, this.abdS);
      if (this.pHt != null) {
        paramVarArgs.g(6, this.pHt);
      }
      if (this.pHu != null) {
        paramVarArgs.g(7, this.pHu);
      }
      if (this.abdT != null) {
        paramVarArgs.g(8, this.abdT);
      }
      if (this.abdU != null) {
        paramVarArgs.g(9, this.abdU);
      }
      paramVarArgs.bS(10, this.abdV);
      paramVarArgs.bS(11, this.abdW);
      if (this.ign != null)
      {
        paramVarArgs.qD(12, this.ign.computeSize());
        this.ign.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(72539);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label994;
      }
    }
    label994:
    for (paramInt = i.a.a.a.qC(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + i.a.a.b.b.a.cJ(2, this.hAV);
      paramInt = i;
      if (this.wYI != null) {
        paramInt = i + i.a.a.b.b.a.h(3, this.wYI);
      }
      i = paramInt + i.a.a.b.b.a.cJ(4, this.abdR) + i.a.a.b.b.a.cJ(5, this.abdS);
      paramInt = i;
      if (this.pHt != null) {
        paramInt = i + i.a.a.b.b.a.h(6, this.pHt);
      }
      i = paramInt;
      if (this.pHu != null) {
        i = paramInt + i.a.a.b.b.a.h(7, this.pHu);
      }
      paramInt = i;
      if (this.abdT != null) {
        paramInt = i + i.a.a.b.b.a.h(8, this.abdT);
      }
      i = paramInt;
      if (this.abdU != null) {
        i = paramInt + i.a.a.b.b.a.h(9, this.abdU);
      }
      i = i + i.a.a.b.b.a.cJ(10, this.abdV) + i.a.a.b.b.a.cJ(11, this.abdW);
      paramInt = i;
      if (this.ign != null) {
        paramInt = i + i.a.a.a.qC(12, this.ign.computeSize());
      }
      AppMethodBeat.o(72539);
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
          AppMethodBeat.o(72539);
          throw paramVarArgs;
        }
        AppMethodBeat.o(72539);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        dzb localdzb = (dzb)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(72539);
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
            localdzb.BaseResponse = ((kd)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(72539);
          return 0;
        case 2: 
          localdzb.hAV = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(72539);
          return 0;
        case 3: 
          localdzb.wYI = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(72539);
          return 0;
        case 4: 
          localdzb.abdR = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(72539);
          return 0;
        case 5: 
          localdzb.abdS = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(72539);
          return 0;
        case 6: 
          localdzb.pHt = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(72539);
          return 0;
        case 7: 
          localdzb.pHu = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(72539);
          return 0;
        case 8: 
          localdzb.abdT = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(72539);
          return 0;
        case 9: 
          localdzb.abdU = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(72539);
          return 0;
        case 10: 
          localdzb.abdV = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(72539);
          return 0;
        case 11: 
          localdzb.abdW = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(72539);
          return 0;
        }
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
          localdzb.ign = ((dus)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(72539);
        return 0;
      }
      AppMethodBeat.o(72539);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dzb
 * JD-Core Version:    0.7.0.1
 */