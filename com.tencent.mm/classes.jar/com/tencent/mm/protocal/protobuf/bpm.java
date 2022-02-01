package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bpm
  extends dpc
{
  public com.tencent.mm.bw.b LFp;
  public int LIa;
  public LinkedList<cix> LXE;
  public LinkedList<String> LXF;
  public int LXG;
  public boolean LXH;
  public cis LXI;
  
  public bpm()
  {
    AppMethodBeat.i(207474);
    this.LXE = new LinkedList();
    this.LXF = new LinkedList();
    AppMethodBeat.o(207474);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(207475);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new g.a.a.b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(207475);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.ni(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.e(2, 8, this.LXE);
      if (this.LFp != null) {
        paramVarArgs.c(3, this.LFp);
      }
      paramVarArgs.aM(4, this.LIa);
      paramVarArgs.e(5, 1, this.LXF);
      paramVarArgs.aM(6, this.LXG);
      paramVarArgs.cc(7, this.LXH);
      if (this.LXI != null)
      {
        paramVarArgs.ni(8, this.LXI.computeSize());
        this.LXI.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(207475);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label902;
      }
    }
    label902:
    for (paramInt = g.a.a.a.nh(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.a.c(2, 8, this.LXE);
      paramInt = i;
      if (this.LFp != null) {
        paramInt = i + g.a.a.b.b.a.b(3, this.LFp);
      }
      i = paramInt + g.a.a.b.b.a.bu(4, this.LIa) + g.a.a.a.c(5, 1, this.LXF) + g.a.a.b.b.a.bu(6, this.LXG) + (g.a.a.b.b.a.fS(7) + 1);
      paramInt = i;
      if (this.LXI != null) {
        paramInt = i + g.a.a.a.nh(8, this.LXI.computeSize());
      }
      AppMethodBeat.o(207475);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.LXE.clear();
        this.LXF.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = dpc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dpc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new g.a.a.b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(207475);
          throw paramVarArgs;
        }
        AppMethodBeat.o(207475);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        bpm localbpm = (bpm)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(207475);
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
            localbpm.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(207475);
          return 0;
        case 2: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cix();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cix)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localbpm.LXE.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(207475);
          return 0;
        case 3: 
          localbpm.LFp = ((g.a.a.a.a)localObject1).UbS.hPo();
          AppMethodBeat.o(207475);
          return 0;
        case 4: 
          localbpm.LIa = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(207475);
          return 0;
        case 5: 
          localbpm.LXF.add(((g.a.a.a.a)localObject1).UbS.readString());
          AppMethodBeat.o(207475);
          return 0;
        case 6: 
          localbpm.LXG = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(207475);
          return 0;
        case 7: 
          localbpm.LXH = ((g.a.a.a.a)localObject1).UbS.yZ();
          AppMethodBeat.o(207475);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new cis();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((cis)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localbpm.LXI = ((cis)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(207475);
        return 0;
      }
      AppMethodBeat.o(207475);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bpm
 * JD-Core Version:    0.7.0.1
 */