package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class dem
  extends dpc
{
  public String MJC;
  public String MJD;
  public String MJE;
  public String MJF;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91631);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(91631);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.ni(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.MJC != null) {
        paramVarArgs.e(2, this.MJC);
      }
      if (this.MJD != null) {
        paramVarArgs.e(3, this.MJD);
      }
      if (this.MJE != null) {
        paramVarArgs.e(4, this.MJE);
      }
      if (this.MJF != null) {
        paramVarArgs.e(5, this.MJF);
      }
      AppMethodBeat.o(91631);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label598;
      }
    }
    label598:
    for (int i = g.a.a.a.nh(1, this.BaseResponse.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.MJC != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.MJC);
      }
      i = paramInt;
      if (this.MJD != null) {
        i = paramInt + g.a.a.b.b.a.f(3, this.MJD);
      }
      paramInt = i;
      if (this.MJE != null) {
        paramInt = i + g.a.a.b.b.a.f(4, this.MJE);
      }
      i = paramInt;
      if (this.MJF != null) {
        i = paramInt + g.a.a.b.b.a.f(5, this.MJF);
      }
      AppMethodBeat.o(91631);
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
          AppMethodBeat.o(91631);
          throw paramVarArgs;
        }
        AppMethodBeat.o(91631);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        dem localdem = (dem)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91631);
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
            localdem.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91631);
          return 0;
        case 2: 
          localdem.MJC = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(91631);
          return 0;
        case 3: 
          localdem.MJD = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(91631);
          return 0;
        case 4: 
          localdem.MJE = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(91631);
          return 0;
        }
        localdem.MJF = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(91631);
        return 0;
      }
      AppMethodBeat.o(91631);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dem
 * JD-Core Version:    0.7.0.1
 */