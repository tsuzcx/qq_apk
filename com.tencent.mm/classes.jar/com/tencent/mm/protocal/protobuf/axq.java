package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;
import java.util.LinkedList;

public final class axq
  extends dpc
{
  public String HIt;
  public b LBZ;
  public boolean sPX;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(209570);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse != null)
      {
        paramVarArgs.ni(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.cc(2, this.sPX);
      if (this.HIt != null) {
        paramVarArgs.e(3, this.HIt);
      }
      if (this.LBZ != null) {
        paramVarArgs.c(4, this.LBZ);
      }
      AppMethodBeat.o(209570);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label474;
      }
    }
    label474:
    for (paramInt = g.a.a.a.nh(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + (g.a.a.b.b.a.fS(2) + 1);
      paramInt = i;
      if (this.HIt != null) {
        paramInt = i + g.a.a.b.b.a.f(3, this.HIt);
      }
      i = paramInt;
      if (this.LBZ != null) {
        i = paramInt + g.a.a.b.b.a.b(4, this.LBZ);
      }
      AppMethodBeat.o(209570);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dpc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dpc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(209570);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        axq localaxq = (axq)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(209570);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new BaseResponse();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((BaseResponse)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localaxq.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(209570);
          return 0;
        case 2: 
          localaxq.sPX = ((g.a.a.a.a)localObject1).UbS.yZ();
          AppMethodBeat.o(209570);
          return 0;
        case 3: 
          localaxq.HIt = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(209570);
          return 0;
        }
        localaxq.LBZ = ((g.a.a.a.a)localObject1).UbS.hPo();
        AppMethodBeat.o(209570);
        return 0;
      }
      AppMethodBeat.o(209570);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.axq
 * JD-Core Version:    0.7.0.1
 */