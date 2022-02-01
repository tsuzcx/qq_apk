package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class elr
  extends dop
{
  public String KTt;
  public nt LPp;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(124572);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.KTt == null)
      {
        paramVarArgs = new b("Not all required fields were included: brand_user_name");
        AppMethodBeat.o(124572);
        throw paramVarArgs;
      }
      if (this.LPp == null)
      {
        paramVarArgs = new b("Not all required fields were included: chat");
        AppMethodBeat.o(124572);
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
      if (this.LPp != null)
      {
        paramVarArgs.ni(3, this.LPp.computeSize());
        this.LPp.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(124572);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label622;
      }
    }
    label622:
    for (int i = g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.KTt != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.KTt);
      }
      i = paramInt;
      if (this.LPp != null) {
        i = paramInt + g.a.a.a.nh(3, this.LPp.computeSize());
      }
      AppMethodBeat.o(124572);
      return i;
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
          AppMethodBeat.o(124572);
          throw paramVarArgs;
        }
        if (this.LPp == null)
        {
          paramVarArgs = new b("Not all required fields were included: chat");
          AppMethodBeat.o(124572);
          throw paramVarArgs;
        }
        AppMethodBeat.o(124572);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        elr localelr = (elr)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(124572);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new jr();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((jr)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dop.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localelr.BaseRequest = ((jr)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(124572);
          return 0;
        case 2: 
          localelr.KTt = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(124572);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new nt();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((nt)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dop.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localelr.LPp = ((nt)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(124572);
        return 0;
      }
      AppMethodBeat.o(124572);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.elr
 * JD-Core Version:    0.7.0.1
 */