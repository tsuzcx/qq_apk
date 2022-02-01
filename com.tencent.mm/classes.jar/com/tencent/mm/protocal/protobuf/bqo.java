package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class bqo
  extends dpc
{
  public int LUO;
  public uh LUP;
  public int LUS;
  public int LUT;
  public uw LUU;
  public ul LYg;
  public ue LYh;
  public String LYi;
  public uk LYj;
  public int pTZ;
  public String pUa;
  public int qGg;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(114029);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(114029);
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
      if (this.LYg != null)
      {
        paramVarArgs.ni(7, this.LYg.computeSize());
        this.LYg.writeFields(paramVarArgs);
      }
      if (this.LYh != null)
      {
        paramVarArgs.ni(8, this.LYh.computeSize());
        this.LYh.writeFields(paramVarArgs);
      }
      if (this.LYi != null) {
        paramVarArgs.e(10, this.LYi);
      }
      paramVarArgs.aM(11, this.LUS);
      paramVarArgs.aM(12, this.LUT);
      if (this.LUU != null)
      {
        paramVarArgs.ni(13, this.LUU.computeSize());
        this.LUU.writeFields(paramVarArgs);
      }
      if (this.LYj != null)
      {
        paramVarArgs.ni(14, this.LYj.computeSize());
        this.LYj.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(114029);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1486;
      }
    }
    label1486:
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
      if (this.LYg != null) {
        i = paramInt + g.a.a.a.nh(7, this.LYg.computeSize());
      }
      paramInt = i;
      if (this.LYh != null) {
        paramInt = i + g.a.a.a.nh(8, this.LYh.computeSize());
      }
      i = paramInt;
      if (this.LYi != null) {
        i = paramInt + g.a.a.b.b.a.f(10, this.LYi);
      }
      i = i + g.a.a.b.b.a.bu(11, this.LUS) + g.a.a.b.b.a.bu(12, this.LUT);
      paramInt = i;
      if (this.LUU != null) {
        paramInt = i + g.a.a.a.nh(13, this.LUU.computeSize());
      }
      i = paramInt;
      if (this.LYj != null) {
        i = paramInt + g.a.a.a.nh(14, this.LYj.computeSize());
      }
      AppMethodBeat.o(114029);
      return i;
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
          AppMethodBeat.o(114029);
          throw paramVarArgs;
        }
        AppMethodBeat.o(114029);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        bqo localbqo = (bqo)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        case 9: 
        default: 
          AppMethodBeat.o(114029);
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
            localbqo.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(114029);
          return 0;
        case 2: 
          localbqo.pTZ = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(114029);
          return 0;
        case 3: 
          localbqo.pUa = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(114029);
          return 0;
        case 4: 
          localbqo.qGg = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(114029);
          return 0;
        case 5: 
          localbqo.LUO = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(114029);
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
            localbqo.LUP = ((uh)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(114029);
          return 0;
        case 7: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ul();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ul)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localbqo.LYg = ((ul)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(114029);
          return 0;
        case 8: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ue();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ue)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localbqo.LYh = ((ue)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(114029);
          return 0;
        case 10: 
          localbqo.LYi = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(114029);
          return 0;
        case 11: 
          localbqo.LUS = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(114029);
          return 0;
        case 12: 
          localbqo.LUT = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(114029);
          return 0;
        case 13: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new uw();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((uw)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localbqo.LUU = ((uw)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(114029);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new uk();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((uk)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localbqo.LYj = ((uk)localObject1);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bqo
 * JD-Core Version:    0.7.0.1
 */