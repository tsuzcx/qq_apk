package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class emc
  extends dyl
{
  public com.tencent.mm.cd.b TAB;
  public String UoA;
  public int UoB;
  public int UoC;
  public int UoD;
  public int UoE;
  public ema UoF;
  public ema UoG;
  public String Uoy;
  public String Uoz;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(133198);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.TAB == null)
      {
        paramVarArgs = new g.a.a.b("Not all required fields were included: ctx");
        AppMethodBeat.o(133198);
        throw paramVarArgs;
      }
      if (this.Uoy == null)
      {
        paramVarArgs = new g.a.a.b("Not all required fields were included: network_type");
        AppMethodBeat.o(133198);
        throw paramVarArgs;
      }
      if (this.Uoz == null)
      {
        paramVarArgs = new g.a.a.b("Not all required fields were included: network_info");
        AppMethodBeat.o(133198);
        throw paramVarArgs;
      }
      if (this.UoA == null)
      {
        paramVarArgs = new g.a.a.b("Not all required fields were included: device_info");
        AppMethodBeat.o(133198);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.oE(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.TAB != null) {
        paramVarArgs.c(2, this.TAB);
      }
      if (this.Uoy != null) {
        paramVarArgs.f(3, this.Uoy);
      }
      if (this.Uoz != null) {
        paramVarArgs.f(4, this.Uoz);
      }
      if (this.UoA != null) {
        paramVarArgs.f(5, this.UoA);
      }
      paramVarArgs.aY(6, this.UoB);
      paramVarArgs.aY(7, this.UoC);
      paramVarArgs.aY(8, this.UoD);
      paramVarArgs.aY(9, this.UoE);
      if (this.UoF != null)
      {
        paramVarArgs.oE(10, this.UoF.computeSize());
        this.UoF.writeFields(paramVarArgs);
      }
      if (this.UoG != null)
      {
        paramVarArgs.oE(11, this.UoG.computeSize());
        this.UoG.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(133198);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label1168;
      }
    }
    label1168:
    for (int i = g.a.a.a.oD(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.TAB != null) {
        paramInt = i + g.a.a.b.b.a.b(2, this.TAB);
      }
      i = paramInt;
      if (this.Uoy != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.Uoy);
      }
      paramInt = i;
      if (this.Uoz != null) {
        paramInt = i + g.a.a.b.b.a.g(4, this.Uoz);
      }
      i = paramInt;
      if (this.UoA != null) {
        i = paramInt + g.a.a.b.b.a.g(5, this.UoA);
      }
      i = i + g.a.a.b.b.a.bM(6, this.UoB) + g.a.a.b.b.a.bM(7, this.UoC) + g.a.a.b.b.a.bM(8, this.UoD) + g.a.a.b.b.a.bM(9, this.UoE);
      paramInt = i;
      if (this.UoF != null) {
        paramInt = i + g.a.a.a.oD(10, this.UoF.computeSize());
      }
      i = paramInt;
      if (this.UoG != null) {
        i = paramInt + g.a.a.a.oD(11, this.UoG.computeSize());
      }
      AppMethodBeat.o(133198);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dyl.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyl.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        if (this.TAB == null)
        {
          paramVarArgs = new g.a.a.b("Not all required fields were included: ctx");
          AppMethodBeat.o(133198);
          throw paramVarArgs;
        }
        if (this.Uoy == null)
        {
          paramVarArgs = new g.a.a.b("Not all required fields were included: network_type");
          AppMethodBeat.o(133198);
          throw paramVarArgs;
        }
        if (this.Uoz == null)
        {
          paramVarArgs = new g.a.a.b("Not all required fields were included: network_info");
          AppMethodBeat.o(133198);
          throw paramVarArgs;
        }
        if (this.UoA == null)
        {
          paramVarArgs = new g.a.a.b("Not all required fields were included: device_info");
          AppMethodBeat.o(133198);
          throw paramVarArgs;
        }
        AppMethodBeat.o(133198);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        emc localemc = (emc)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(133198);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new jg();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((jg)localObject2).parseFrom((byte[])localObject1);
            }
            localemc.BaseRequest = ((jg)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(133198);
          return 0;
        case 2: 
          localemc.TAB = ((g.a.a.a.a)localObject1).abFh.iUw();
          AppMethodBeat.o(133198);
          return 0;
        case 3: 
          localemc.Uoy = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(133198);
          return 0;
        case 4: 
          localemc.Uoz = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(133198);
          return 0;
        case 5: 
          localemc.UoA = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(133198);
          return 0;
        case 6: 
          localemc.UoB = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(133198);
          return 0;
        case 7: 
          localemc.UoC = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(133198);
          return 0;
        case 8: 
          localemc.UoD = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(133198);
          return 0;
        case 9: 
          localemc.UoE = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(133198);
          return 0;
        case 10: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new ema();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((ema)localObject2).parseFrom((byte[])localObject1);
            }
            localemc.UoF = ((ema)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(133198);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new ema();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((ema)localObject2).parseFrom((byte[])localObject1);
          }
          localemc.UoG = ((ema)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(133198);
        return 0;
      }
      AppMethodBeat.o(133198);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.emc
 * JD-Core Version:    0.7.0.1
 */