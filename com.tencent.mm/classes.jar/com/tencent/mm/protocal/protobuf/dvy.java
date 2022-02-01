package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class dvy
  extends dop
{
  public String KTt;
  public int MWH;
  public int MWI;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(124553);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.KTt == null)
      {
        paramVarArgs = new b("Not all required fields were included: brand_user_name");
        AppMethodBeat.o(124553);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.ni(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.KTt != null) {
        paramVarArgs.e(2, this.KTt);
      }
      paramVarArgs.aM(3, this.MWH);
      paramVarArgs.aM(4, this.MWI);
      AppMethodBeat.o(124553);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label510;
      }
    }
    label510:
    for (paramInt = g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.KTt != null) {
        i = paramInt + g.a.a.b.b.a.f(2, this.KTt);
      }
      paramInt = g.a.a.b.b.a.bu(3, this.MWH);
      int j = g.a.a.b.b.a.bu(4, this.MWI);
      AppMethodBeat.o(124553);
      return i + paramInt + j;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dop.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dop.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        if (this.KTt == null)
        {
          paramVarArgs = new b("Not all required fields were included: brand_user_name");
          AppMethodBeat.o(124553);
          throw paramVarArgs;
        }
        AppMethodBeat.o(124553);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        dvy localdvy = (dvy)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(124553);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new jr();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((jr)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dop.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localdvy.BaseRequest = ((jr)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(124553);
          return 0;
        case 2: 
          localdvy.KTt = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(124553);
          return 0;
        case 3: 
          localdvy.MWH = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(124553);
          return 0;
        }
        localdvy.MWI = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(124553);
        return 0;
      }
      AppMethodBeat.o(124553);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dvy
 * JD-Core Version:    0.7.0.1
 */