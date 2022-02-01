package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class avg
  extends dpc
{
  public String LFw;
  public long LFx;
  public String session_id;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(209499);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse != null)
      {
        paramVarArgs.ni(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.LFw != null) {
        paramVarArgs.e(2, this.LFw);
      }
      paramVarArgs.bb(3, this.LFx);
      if (this.session_id != null) {
        paramVarArgs.e(4, this.session_id);
      }
      AppMethodBeat.o(209499);
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
      int i = paramInt;
      if (this.LFw != null) {
        i = paramInt + g.a.a.b.b.a.f(2, this.LFw);
      }
      i += g.a.a.b.b.a.r(3, this.LFx);
      paramInt = i;
      if (this.session_id != null) {
        paramInt = i + g.a.a.b.b.a.f(4, this.session_id);
      }
      AppMethodBeat.o(209499);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dpc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dpc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(209499);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        avg localavg = (avg)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(209499);
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
            localavg.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(209499);
          return 0;
        case 2: 
          localavg.LFw = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(209499);
          return 0;
        case 3: 
          localavg.LFx = ((g.a.a.a.a)localObject1).UbS.zl();
          AppMethodBeat.o(209499);
          return 0;
        }
        localavg.session_id = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(209499);
        return 0;
      }
      AppMethodBeat.o(209499);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.avg
 * JD-Core Version:    0.7.0.1
 */