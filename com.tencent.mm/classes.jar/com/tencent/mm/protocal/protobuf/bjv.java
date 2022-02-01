package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class bjv
  extends dop
{
  public int EX;
  public String Lpg;
  public String data;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(124508);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.Lpg == null)
      {
        paramVarArgs = new b("Not all required fields were included: corp_id");
        AppMethodBeat.o(124508);
        throw paramVarArgs;
      }
      if (this.data == null)
      {
        paramVarArgs = new b("Not all required fields were included: data");
        AppMethodBeat.o(124508);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.ni(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.Lpg != null) {
        paramVarArgs.e(2, this.Lpg);
      }
      paramVarArgs.aM(3, this.EX);
      if (this.data != null) {
        paramVarArgs.e(4, this.data);
      }
      AppMethodBeat.o(124508);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label574;
      }
    }
    label574:
    for (paramInt = g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.Lpg != null) {
        i = paramInt + g.a.a.b.b.a.f(2, this.Lpg);
      }
      i += g.a.a.b.b.a.bu(3, this.EX);
      paramInt = i;
      if (this.data != null) {
        paramInt = i + g.a.a.b.b.a.f(4, this.data);
      }
      AppMethodBeat.o(124508);
      return paramInt;
      Object localObject1;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        localObject1 = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = dop.getNextFieldNumber((g.a.a.a.a)localObject1); paramInt > 0; paramInt = dop.getNextFieldNumber((g.a.a.a.a)localObject1)) {
          if (!super.populateBuilderWithField((g.a.a.a.a)localObject1, this, paramInt)) {
            ((g.a.a.a.a)localObject1).hPl();
          }
        }
        if (this.Lpg == null)
        {
          paramVarArgs = new b("Not all required fields were included: corp_id");
          AppMethodBeat.o(124508);
          throw paramVarArgs;
        }
        if (paramVarArgs == null)
        {
          paramVarArgs = new b("Not all required fields were included: data");
          AppMethodBeat.o(124508);
          throw paramVarArgs;
        }
        AppMethodBeat.o(124508);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject2 = (g.a.a.a.a)paramVarArgs[0];
        localObject1 = (bjv)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(124508);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject2).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject3 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new jr();
            localObject3 = new g.a.a.a.a((byte[])localObject3, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((jr)localObject2).populateBuilderWithField((g.a.a.a.a)localObject3, (com.tencent.mm.bw.a)localObject2, dop.getNextFieldNumber((g.a.a.a.a)localObject3))) {}
            ((bjv)localObject1).BaseRequest = ((jr)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(124508);
          return 0;
        case 2: 
          ((bjv)localObject1).Lpg = ((g.a.a.a.a)localObject2).UbS.readString();
          AppMethodBeat.o(124508);
          return 0;
        case 3: 
          ((bjv)localObject1).EX = ((g.a.a.a.a)localObject2).UbS.zi();
          AppMethodBeat.o(124508);
          return 0;
        }
        ((bjv)localObject1).data = ((g.a.a.a.a)localObject2).UbS.readString();
        AppMethodBeat.o(124508);
        return 0;
      }
      AppMethodBeat.o(124508);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bjv
 * JD-Core Version:    0.7.0.1
 */