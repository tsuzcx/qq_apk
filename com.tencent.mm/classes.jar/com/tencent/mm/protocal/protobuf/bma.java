package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class bma
  extends dpc
{
  public int LUO;
  public uh LUP;
  public un LUQ;
  public String LUR;
  public int LUS;
  public int LUT;
  public uw LUU;
  public int pTZ;
  public String pUa;
  public int qGg;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(201338);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(201338);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.ni(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aM(2, this.pTZ);
      if (this.pUa != null) {
        paramVarArgs.e(3, this.pUa);
      }
      paramVarArgs.aM(4, this.qGg);
      paramVarArgs.aM(5, this.LUO);
      if (this.LUP != null)
      {
        paramVarArgs.ni(6, this.LUP.computeSize());
        this.LUP.writeFields(paramVarArgs);
      }
      if (this.LUQ != null)
      {
        paramVarArgs.ni(7, this.LUQ.computeSize());
        this.LUQ.writeFields(paramVarArgs);
      }
      if (this.LUR != null) {
        paramVarArgs.e(8, this.LUR);
      }
      paramVarArgs.aM(9, this.LUS);
      paramVarArgs.aM(10, this.LUT);
      if (this.LUU != null)
      {
        paramVarArgs.ni(11, this.LUU.computeSize());
        this.LUU.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(201338);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1170;
      }
    }
    label1170:
    for (paramInt = g.a.a.a.nh(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bu(2, this.pTZ);
      paramInt = i;
      if (this.pUa != null) {
        paramInt = i + g.a.a.b.b.a.f(3, this.pUa);
      }
      i = paramInt + g.a.a.b.b.a.bu(4, this.qGg) + g.a.a.b.b.a.bu(5, this.LUO);
      paramInt = i;
      if (this.LUP != null) {
        paramInt = i + g.a.a.a.nh(6, this.LUP.computeSize());
      }
      i = paramInt;
      if (this.LUQ != null) {
        i = paramInt + g.a.a.a.nh(7, this.LUQ.computeSize());
      }
      paramInt = i;
      if (this.LUR != null) {
        paramInt = i + g.a.a.b.b.a.f(8, this.LUR);
      }
      i = paramInt + g.a.a.b.b.a.bu(9, this.LUS) + g.a.a.b.b.a.bu(10, this.LUT);
      paramInt = i;
      if (this.LUU != null) {
        paramInt = i + g.a.a.a.nh(11, this.LUU.computeSize());
      }
      AppMethodBeat.o(201338);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dpc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dpc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(201338);
          throw paramVarArgs;
        }
        AppMethodBeat.o(201338);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        bma localbma = (bma)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(201338);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new BaseResponse();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((BaseResponse)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localbma.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(201338);
          return 0;
        case 2: 
          localbma.pTZ = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(201338);
          return 0;
        case 3: 
          localbma.pUa = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(201338);
          return 0;
        case 4: 
          localbma.qGg = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(201338);
          return 0;
        case 5: 
          localbma.LUO = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(201338);
          return 0;
        case 6: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new uh();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((uh)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localbma.LUP = ((uh)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(201338);
          return 0;
        case 7: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new un();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((un)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localbma.LUQ = ((un)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(201338);
          return 0;
        case 8: 
          localbma.LUR = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(201338);
          return 0;
        case 9: 
          localbma.LUS = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(201338);
          return 0;
        case 10: 
          localbma.LUT = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(201338);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new uw();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((uw)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localbma.LUU = ((uw)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(201338);
        return 0;
      }
      AppMethodBeat.o(201338);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bma
 * JD-Core Version:    0.7.0.1
 */