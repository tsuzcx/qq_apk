package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class elp
  extends dop
{
  public String KTl;
  public String KTt;
  public nw NkD;
  public nw NkE;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(124570);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.KTt == null)
      {
        paramVarArgs = new b("Not all required fields were included: brand_user_name");
        AppMethodBeat.o(124570);
        throw paramVarArgs;
      }
      if (this.KTl == null)
      {
        paramVarArgs = new b("Not all required fields were included: bizchat_id");
        AppMethodBeat.o(124570);
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
      if (this.NkD != null)
      {
        paramVarArgs.ni(4, this.NkD.computeSize());
        this.NkD.writeFields(paramVarArgs);
      }
      if (this.NkE != null)
      {
        paramVarArgs.ni(5, this.NkE.computeSize());
        this.NkE.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(124570);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label834;
      }
    }
    label834:
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
      paramInt = i;
      if (this.NkD != null) {
        paramInt = i + g.a.a.a.nh(4, this.NkD.computeSize());
      }
      i = paramInt;
      if (this.NkE != null) {
        i = paramInt + g.a.a.a.nh(5, this.NkE.computeSize());
      }
      AppMethodBeat.o(124570);
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
          AppMethodBeat.o(124570);
          throw paramVarArgs;
        }
        if (this.KTl == null)
        {
          paramVarArgs = new b("Not all required fields were included: bizchat_id");
          AppMethodBeat.o(124570);
          throw paramVarArgs;
        }
        AppMethodBeat.o(124570);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        elp localelp = (elp)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(124570);
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
            localelp.BaseRequest = ((jr)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(124570);
          return 0;
        case 2: 
          localelp.KTt = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(124570);
          return 0;
        case 3: 
          localelp.KTl = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(124570);
          return 0;
        case 4: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new nw();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((nw)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dop.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localelp.NkD = ((nw)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(124570);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new nw();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((nw)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dop.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localelp.NkE = ((nw)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(124570);
        return 0;
      }
      AppMethodBeat.o(124570);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.elp
 * JD-Core Version:    0.7.0.1
 */