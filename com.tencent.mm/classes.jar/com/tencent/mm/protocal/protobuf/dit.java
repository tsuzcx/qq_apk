package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class dit
  extends dop
{
  public String KTl;
  public String KTt;
  public int time_stamp;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(124544);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.KTt == null)
      {
        paramVarArgs = new b("Not all required fields were included: brand_user_name");
        AppMethodBeat.o(124544);
        throw paramVarArgs;
      }
      if (this.KTl == null)
      {
        paramVarArgs = new b("Not all required fields were included: bizchat_id");
        AppMethodBeat.o(124544);
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
      if (this.KTl != null) {
        paramVarArgs.e(3, this.KTl);
      }
      paramVarArgs.aM(4, this.time_stamp);
      AppMethodBeat.o(124544);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label570;
      }
    }
    label570:
    for (int i = g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.KTt != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.KTt);
      }
      i = paramInt;
      if (this.KTl != null) {
        i = paramInt + g.a.a.b.b.a.f(3, this.KTl);
      }
      paramInt = g.a.a.b.b.a.bu(4, this.time_stamp);
      AppMethodBeat.o(124544);
      return i + paramInt;
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
          AppMethodBeat.o(124544);
          throw paramVarArgs;
        }
        if (this.KTl == null)
        {
          paramVarArgs = new b("Not all required fields were included: bizchat_id");
          AppMethodBeat.o(124544);
          throw paramVarArgs;
        }
        AppMethodBeat.o(124544);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        dit localdit = (dit)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(124544);
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
            localdit.BaseRequest = ((jr)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(124544);
          return 0;
        case 2: 
          localdit.KTt = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(124544);
          return 0;
        case 3: 
          localdit.KTl = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(124544);
          return 0;
        }
        localdit.time_stamp = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(124544);
        return 0;
      }
      AppMethodBeat.o(124544);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dit
 * JD-Core Version:    0.7.0.1
 */