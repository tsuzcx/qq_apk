package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class adr
  extends dop
{
  public String Lpg;
  public String Lph;
  public String Lpi;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(124479);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.Lpg == null)
      {
        paramVarArgs = new b("Not all required fields were included: corp_id");
        AppMethodBeat.o(124479);
        throw paramVarArgs;
      }
      if (this.Lph == null)
      {
        paramVarArgs = new b("Not all required fields were included: qychat_type");
        AppMethodBeat.o(124479);
        throw paramVarArgs;
      }
      if (this.Lpi == null)
      {
        paramVarArgs = new b("Not all required fields were included: qychat_id");
        AppMethodBeat.o(124479);
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
      if (this.Lph != null) {
        paramVarArgs.e(3, this.Lph);
      }
      if (this.Lpi != null) {
        paramVarArgs.e(4, this.Lpi);
      }
      AppMethodBeat.o(124479);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label634;
      }
    }
    label634:
    for (int i = g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.Lpg != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.Lpg);
      }
      i = paramInt;
      if (this.Lph != null) {
        i = paramInt + g.a.a.b.b.a.f(3, this.Lph);
      }
      paramInt = i;
      if (this.Lpi != null) {
        paramInt = i + g.a.a.b.b.a.f(4, this.Lpi);
      }
      AppMethodBeat.o(124479);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dop.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dop.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        if (this.Lpg == null)
        {
          paramVarArgs = new b("Not all required fields were included: corp_id");
          AppMethodBeat.o(124479);
          throw paramVarArgs;
        }
        if (this.Lph == null)
        {
          paramVarArgs = new b("Not all required fields were included: qychat_type");
          AppMethodBeat.o(124479);
          throw paramVarArgs;
        }
        if (this.Lpi == null)
        {
          paramVarArgs = new b("Not all required fields were included: qychat_id");
          AppMethodBeat.o(124479);
          throw paramVarArgs;
        }
        AppMethodBeat.o(124479);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        adr localadr = (adr)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(124479);
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
            localadr.BaseRequest = ((jr)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(124479);
          return 0;
        case 2: 
          localadr.Lpg = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(124479);
          return 0;
        case 3: 
          localadr.Lph = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(124479);
          return 0;
        }
        localadr.Lpi = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(124479);
        return 0;
      }
      AppMethodBeat.o(124479);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.adr
 * JD-Core Version:    0.7.0.1
 */