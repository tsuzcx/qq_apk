package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class bkz
  extends dpc
{
  public String LTP;
  public int LTQ;
  public dpu LTS;
  public String LTT;
  public dps LTU;
  public long fvd;
  public int gsc;
  public String gsd;
  public int gse;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(101808);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(101808);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.ni(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.LTP != null) {
        paramVarArgs.e(2, this.LTP);
      }
      paramVarArgs.aM(3, this.gsc);
      if (this.gsd != null) {
        paramVarArgs.e(4, this.gsd);
      }
      paramVarArgs.aM(5, this.gse);
      paramVarArgs.aM(6, this.LTQ);
      paramVarArgs.bb(7, this.fvd);
      if (this.LTS != null)
      {
        paramVarArgs.ni(8, this.LTS.computeSize());
        this.LTS.writeFields(paramVarArgs);
      }
      if (this.LTT != null) {
        paramVarArgs.e(9, this.LTT);
      }
      if (this.LTU != null)
      {
        paramVarArgs.ni(10, this.LTU.computeSize());
        this.LTU.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(101808);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1030;
      }
    }
    label1030:
    for (paramInt = g.a.a.a.nh(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.LTP != null) {
        i = paramInt + g.a.a.b.b.a.f(2, this.LTP);
      }
      i += g.a.a.b.b.a.bu(3, this.gsc);
      paramInt = i;
      if (this.gsd != null) {
        paramInt = i + g.a.a.b.b.a.f(4, this.gsd);
      }
      i = paramInt + g.a.a.b.b.a.bu(5, this.gse) + g.a.a.b.b.a.bu(6, this.LTQ) + g.a.a.b.b.a.r(7, this.fvd);
      paramInt = i;
      if (this.LTS != null) {
        paramInt = i + g.a.a.a.nh(8, this.LTS.computeSize());
      }
      i = paramInt;
      if (this.LTT != null) {
        i = paramInt + g.a.a.b.b.a.f(9, this.LTT);
      }
      paramInt = i;
      if (this.LTU != null) {
        paramInt = i + g.a.a.a.nh(10, this.LTU.computeSize());
      }
      AppMethodBeat.o(101808);
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
          AppMethodBeat.o(101808);
          throw paramVarArgs;
        }
        AppMethodBeat.o(101808);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        bkz localbkz = (bkz)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(101808);
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
            localbkz.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(101808);
          return 0;
        case 2: 
          localbkz.LTP = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(101808);
          return 0;
        case 3: 
          localbkz.gsc = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(101808);
          return 0;
        case 4: 
          localbkz.gsd = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(101808);
          return 0;
        case 5: 
          localbkz.gse = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(101808);
          return 0;
        case 6: 
          localbkz.LTQ = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(101808);
          return 0;
        case 7: 
          localbkz.fvd = ((g.a.a.a.a)localObject1).UbS.zl();
          AppMethodBeat.o(101808);
          return 0;
        case 8: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dpu();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dpu)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localbkz.LTS = ((dpu)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(101808);
          return 0;
        case 9: 
          localbkz.LTT = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(101808);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new dps();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((dps)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localbkz.LTU = ((dps)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(101808);
        return 0;
      }
      AppMethodBeat.o(101808);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bkz
 * JD-Core Version:    0.7.0.1
 */