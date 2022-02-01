package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class cbu
  extends dpc
{
  public LinkedList<cbv> MhD;
  public dbi MhE;
  public dpp MhF;
  public boolean MhG;
  public jh MhH;
  public int pTZ;
  public String pUa;
  
  public cbu()
  {
    AppMethodBeat.i(72502);
    this.MhD = new LinkedList();
    AppMethodBeat.o(72502);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(72503);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(72503);
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
      paramVarArgs.e(4, 8, this.MhD);
      if (this.MhE != null)
      {
        paramVarArgs.ni(5, this.MhE.computeSize());
        this.MhE.writeFields(paramVarArgs);
      }
      if (this.MhF != null)
      {
        paramVarArgs.ni(6, this.MhF.computeSize());
        this.MhF.writeFields(paramVarArgs);
      }
      paramVarArgs.cc(7, this.MhG);
      if (this.MhH != null)
      {
        paramVarArgs.ni(8, this.MhH.computeSize());
        this.MhH.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(72503);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1114;
      }
    }
    label1114:
    for (paramInt = g.a.a.a.nh(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bu(2, this.pTZ);
      paramInt = i;
      if (this.pUa != null) {
        paramInt = i + g.a.a.b.b.a.f(3, this.pUa);
      }
      i = paramInt + g.a.a.a.c(4, 8, this.MhD);
      paramInt = i;
      if (this.MhE != null) {
        paramInt = i + g.a.a.a.nh(5, this.MhE.computeSize());
      }
      i = paramInt;
      if (this.MhF != null) {
        i = paramInt + g.a.a.a.nh(6, this.MhF.computeSize());
      }
      i += g.a.a.b.b.a.fS(7) + 1;
      paramInt = i;
      if (this.MhH != null) {
        paramInt = i + g.a.a.a.nh(8, this.MhH.computeSize());
      }
      AppMethodBeat.o(72503);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.MhD.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = dpc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dpc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
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
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        cbu localcbu = (cbu)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(72503);
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
            localcbu.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(72503);
          return 0;
        case 2: 
          localcbu.pTZ = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(72503);
          return 0;
        case 3: 
          localcbu.pUa = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(72503);
          return 0;
        case 4: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cbv();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cbv)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localcbu.MhD.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(72503);
          return 0;
        case 5: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dbi();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dbi)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localcbu.MhE = ((dbi)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(72503);
          return 0;
        case 6: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dpp();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dpp)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localcbu.MhF = ((dpp)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(72503);
          return 0;
        case 7: 
          localcbu.MhG = ((g.a.a.a.a)localObject1).UbS.yZ();
          AppMethodBeat.o(72503);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new jh();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((jh)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localcbu.MhH = ((jh)localObject1);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cbu
 * JD-Core Version:    0.7.0.1
 */