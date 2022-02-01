package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class fgw
  extends erp
{
  public com.tencent.mm.bx.b aaPP;
  public String abHc;
  public String abHd;
  public String abHe;
  public int abHf;
  public int abHg;
  public int abHh;
  public int abHi;
  public fgt abHj;
  public fgt abHk;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(133198);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.aaPP == null)
      {
        paramVarArgs = new i.a.a.b("Not all required fields were included: ctx");
        AppMethodBeat.o(133198);
        throw paramVarArgs;
      }
      if (this.abHc == null)
      {
        paramVarArgs = new i.a.a.b("Not all required fields were included: network_type");
        AppMethodBeat.o(133198);
        throw paramVarArgs;
      }
      if (this.abHd == null)
      {
        paramVarArgs = new i.a.a.b("Not all required fields were included: network_info");
        AppMethodBeat.o(133198);
        throw paramVarArgs;
      }
      if (this.abHe == null)
      {
        paramVarArgs = new i.a.a.b("Not all required fields were included: device_info");
        AppMethodBeat.o(133198);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.qD(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.aaPP != null) {
        paramVarArgs.d(2, this.aaPP);
      }
      if (this.abHc != null) {
        paramVarArgs.g(3, this.abHc);
      }
      if (this.abHd != null) {
        paramVarArgs.g(4, this.abHd);
      }
      if (this.abHe != null) {
        paramVarArgs.g(5, this.abHe);
      }
      paramVarArgs.bS(6, this.abHf);
      paramVarArgs.bS(7, this.abHg);
      paramVarArgs.bS(8, this.abHh);
      paramVarArgs.bS(9, this.abHi);
      if (this.abHj != null)
      {
        paramVarArgs.qD(10, this.abHj.computeSize());
        this.abHj.writeFields(paramVarArgs);
      }
      if (this.abHk != null)
      {
        paramVarArgs.qD(11, this.abHk.computeSize());
        this.abHk.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(133198);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label1164;
      }
    }
    label1164:
    for (int i = i.a.a.a.qC(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.aaPP != null) {
        paramInt = i + i.a.a.b.b.a.c(2, this.aaPP);
      }
      i = paramInt;
      if (this.abHc != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.abHc);
      }
      paramInt = i;
      if (this.abHd != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.abHd);
      }
      i = paramInt;
      if (this.abHe != null) {
        i = paramInt + i.a.a.b.b.a.h(5, this.abHe);
      }
      i = i + i.a.a.b.b.a.cJ(6, this.abHf) + i.a.a.b.b.a.cJ(7, this.abHg) + i.a.a.b.b.a.cJ(8, this.abHh) + i.a.a.b.b.a.cJ(9, this.abHi);
      paramInt = i;
      if (this.abHj != null) {
        paramInt = i + i.a.a.a.qC(10, this.abHj.computeSize());
      }
      i = paramInt;
      if (this.abHk != null) {
        i = paramInt + i.a.a.a.qC(11, this.abHk.computeSize());
      }
      AppMethodBeat.o(133198);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = erp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = erp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        if (this.aaPP == null)
        {
          paramVarArgs = new i.a.a.b("Not all required fields were included: ctx");
          AppMethodBeat.o(133198);
          throw paramVarArgs;
        }
        if (this.abHc == null)
        {
          paramVarArgs = new i.a.a.b("Not all required fields were included: network_type");
          AppMethodBeat.o(133198);
          throw paramVarArgs;
        }
        if (this.abHd == null)
        {
          paramVarArgs = new i.a.a.b("Not all required fields were included: network_info");
          AppMethodBeat.o(133198);
          throw paramVarArgs;
        }
        if (this.abHe == null)
        {
          paramVarArgs = new i.a.a.b("Not all required fields were included: device_info");
          AppMethodBeat.o(133198);
          throw paramVarArgs;
        }
        AppMethodBeat.o(133198);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        fgw localfgw = (fgw)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(133198);
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
            localfgw.BaseRequest = ((kc)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(133198);
          return 0;
        case 2: 
          localfgw.aaPP = ((i.a.a.a.a)localObject1).ajGk.kFX();
          AppMethodBeat.o(133198);
          return 0;
        case 3: 
          localfgw.abHc = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(133198);
          return 0;
        case 4: 
          localfgw.abHd = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(133198);
          return 0;
        case 5: 
          localfgw.abHe = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(133198);
          return 0;
        case 6: 
          localfgw.abHf = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(133198);
          return 0;
        case 7: 
          localfgw.abHg = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(133198);
          return 0;
        case 8: 
          localfgw.abHh = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(133198);
          return 0;
        case 9: 
          localfgw.abHi = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(133198);
          return 0;
        case 10: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new fgt();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((fgt)localObject2).parseFrom((byte[])localObject1);
            }
            localfgw.abHj = ((fgt)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(133198);
          return 0;
        }
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new fgt();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((fgt)localObject2).parseFrom((byte[])localObject1);
          }
          localfgw.abHk = ((fgt)localObject2);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fgw
 * JD-Core Version:    0.7.0.1
 */