package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class bqs
  extends dpc
{
  public int LUO;
  public cys LYn;
  public int LYo;
  public int pTZ;
  public String pUa;
  public int qGg;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(114031);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(114031);
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
      if (this.LYn != null)
      {
        paramVarArgs.ni(6, this.LYn.computeSize());
        this.LYn.writeFields(paramVarArgs);
      }
      paramVarArgs.aM(7, this.LYo);
      AppMethodBeat.o(114031);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label750;
      }
    }
    label750:
    for (paramInt = g.a.a.a.nh(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bu(2, this.pTZ);
      paramInt = i;
      if (this.pUa != null) {
        paramInt = i + g.a.a.b.b.a.f(3, this.pUa);
      }
      i = paramInt + g.a.a.b.b.a.bu(4, this.qGg) + g.a.a.b.b.a.bu(5, this.LUO);
      paramInt = i;
      if (this.LYn != null) {
        paramInt = i + g.a.a.a.nh(6, this.LYn.computeSize());
      }
      i = g.a.a.b.b.a.bu(7, this.LYo);
      AppMethodBeat.o(114031);
      return paramInt + i;
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
          AppMethodBeat.o(114031);
          throw paramVarArgs;
        }
        AppMethodBeat.o(114031);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        bqs localbqs = (bqs)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(114031);
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
            localbqs.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(114031);
          return 0;
        case 2: 
          localbqs.pTZ = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(114031);
          return 0;
        case 3: 
          localbqs.pUa = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(114031);
          return 0;
        case 4: 
          localbqs.qGg = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(114031);
          return 0;
        case 5: 
          localbqs.LUO = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(114031);
          return 0;
        case 6: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cys();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cys)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localbqs.LYn = ((cys)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(114031);
          return 0;
        }
        localbqs.LYo = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(114031);
        return 0;
      }
      AppMethodBeat.o(114031);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bqs
 * JD-Core Version:    0.7.0.1
 */