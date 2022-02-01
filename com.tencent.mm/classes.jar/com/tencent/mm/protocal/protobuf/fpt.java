package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class fpt
  extends esc
{
  public String Vpa;
  public boolean Vpm;
  public boolean Vpn;
  public aez abPD;
  public String wording;
  public boolean wtT;
  public String wuA;
  public int wuz;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(72601);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse != null)
      {
        paramVarArgs.qD(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(2, this.wuz);
      if (this.wuA != null) {
        paramVarArgs.g(3, this.wuA);
      }
      paramVarArgs.di(4, this.wtT);
      paramVarArgs.di(5, this.Vpm);
      if (this.Vpa != null) {
        paramVarArgs.g(6, this.Vpa);
      }
      if (this.wording != null) {
        paramVarArgs.g(7, this.wording);
      }
      paramVarArgs.di(11, this.Vpn);
      if (this.abPD != null)
      {
        paramVarArgs.qD(12, this.abPD.computeSize());
        this.abPD.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(72601);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label786;
      }
    }
    label786:
    for (paramInt = i.a.a.a.qC(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + i.a.a.b.b.a.cJ(2, this.wuz);
      paramInt = i;
      if (this.wuA != null) {
        paramInt = i + i.a.a.b.b.a.h(3, this.wuA);
      }
      i = paramInt + (i.a.a.b.b.a.ko(4) + 1) + (i.a.a.b.b.a.ko(5) + 1);
      paramInt = i;
      if (this.Vpa != null) {
        paramInt = i + i.a.a.b.b.a.h(6, this.Vpa);
      }
      i = paramInt;
      if (this.wording != null) {
        i = paramInt + i.a.a.b.b.a.h(7, this.wording);
      }
      i += i.a.a.b.b.a.ko(11) + 1;
      paramInt = i;
      if (this.abPD != null) {
        paramInt = i + i.a.a.a.qC(12, this.abPD.computeSize());
      }
      AppMethodBeat.o(72601);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = esc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = esc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(72601);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        fpt localfpt = (fpt)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        case 8: 
        case 9: 
        case 10: 
        default: 
          AppMethodBeat.o(72601);
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
            localfpt.BaseResponse = ((kd)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(72601);
          return 0;
        case 2: 
          localfpt.wuz = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(72601);
          return 0;
        case 3: 
          localfpt.wuA = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(72601);
          return 0;
        case 4: 
          localfpt.wtT = ((i.a.a.a.a)localObject1).ajGk.aai();
          AppMethodBeat.o(72601);
          return 0;
        case 5: 
          localfpt.Vpm = ((i.a.a.a.a)localObject1).ajGk.aai();
          AppMethodBeat.o(72601);
          return 0;
        case 6: 
          localfpt.Vpa = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(72601);
          return 0;
        case 7: 
          localfpt.wording = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(72601);
          return 0;
        case 11: 
          localfpt.Vpn = ((i.a.a.a.a)localObject1).ajGk.aai();
          AppMethodBeat.o(72601);
          return 0;
        }
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new aez();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((aez)localObject2).parseFrom((byte[])localObject1);
          }
          localfpt.abPD = ((aez)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(72601);
        return 0;
      }
      AppMethodBeat.o(72601);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fpt
 * JD-Core Version:    0.7.0.1
 */