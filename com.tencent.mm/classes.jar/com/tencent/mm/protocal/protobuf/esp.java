package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class esp
  extends dpc
{
  public int LsZ;
  public long Lta;
  public int NpI;
  public int NpR;
  public eue NpS;
  public int NpT;
  public int NpU;
  public int NpV;
  public int NpW;
  public SKBuiltinBuffer_t NpX;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(115859);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(115859);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.ni(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aM(2, this.LsZ);
      paramVarArgs.bb(3, this.Lta);
      paramVarArgs.aM(4, this.NpR);
      if (this.NpS != null)
      {
        paramVarArgs.ni(5, this.NpS.computeSize());
        this.NpS.writeFields(paramVarArgs);
      }
      paramVarArgs.aM(6, this.NpI);
      paramVarArgs.aM(7, this.NpT);
      paramVarArgs.aM(8, this.NpU);
      paramVarArgs.aM(9, this.NpV);
      paramVarArgs.aM(10, this.NpW);
      if (this.NpX != null)
      {
        paramVarArgs.ni(11, this.NpX.computeSize());
        this.NpX.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(115859);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1018;
      }
    }
    label1018:
    for (paramInt = g.a.a.a.nh(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bu(2, this.LsZ) + g.a.a.b.b.a.r(3, this.Lta) + g.a.a.b.b.a.bu(4, this.NpR);
      paramInt = i;
      if (this.NpS != null) {
        paramInt = i + g.a.a.a.nh(5, this.NpS.computeSize());
      }
      i = paramInt + g.a.a.b.b.a.bu(6, this.NpI) + g.a.a.b.b.a.bu(7, this.NpT) + g.a.a.b.b.a.bu(8, this.NpU) + g.a.a.b.b.a.bu(9, this.NpV) + g.a.a.b.b.a.bu(10, this.NpW);
      paramInt = i;
      if (this.NpX != null) {
        paramInt = i + g.a.a.a.nh(11, this.NpX.computeSize());
      }
      AppMethodBeat.o(115859);
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
          AppMethodBeat.o(115859);
          throw paramVarArgs;
        }
        AppMethodBeat.o(115859);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        esp localesp = (esp)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(115859);
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
            localesp.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(115859);
          return 0;
        case 2: 
          localesp.LsZ = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(115859);
          return 0;
        case 3: 
          localesp.Lta = ((g.a.a.a.a)localObject1).UbS.zl();
          AppMethodBeat.o(115859);
          return 0;
        case 4: 
          localesp.NpR = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(115859);
          return 0;
        case 5: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new eue();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((eue)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localesp.NpS = ((eue)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(115859);
          return 0;
        case 6: 
          localesp.NpI = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(115859);
          return 0;
        case 7: 
          localesp.NpT = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(115859);
          return 0;
        case 8: 
          localesp.NpU = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(115859);
          return 0;
        case 9: 
          localesp.NpV = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(115859);
          return 0;
        case 10: 
          localesp.NpW = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(115859);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new SKBuiltinBuffer_t();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localesp.NpX = ((SKBuiltinBuffer_t)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(115859);
        return 0;
      }
      AppMethodBeat.o(115859);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.esp
 * JD-Core Version:    0.7.0.1
 */