package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class aqh
  extends dop
{
  public String LCo;
  public long id;
  public String objectNonceId;
  public aov uli;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(168950);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.ni(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.bb(2, this.id);
      if (this.LCo != null) {
        paramVarArgs.e(3, this.LCo);
      }
      if (this.objectNonceId != null) {
        paramVarArgs.e(4, this.objectNonceId);
      }
      if (this.uli != null)
      {
        paramVarArgs.ni(5, this.uli.computeSize());
        this.uli.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(168950);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label630;
      }
    }
    label630:
    for (paramInt = g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.r(2, this.id);
      paramInt = i;
      if (this.LCo != null) {
        paramInt = i + g.a.a.b.b.a.f(3, this.LCo);
      }
      i = paramInt;
      if (this.objectNonceId != null) {
        i = paramInt + g.a.a.b.b.a.f(4, this.objectNonceId);
      }
      paramInt = i;
      if (this.uli != null) {
        paramInt = i + g.a.a.a.nh(5, this.uli.computeSize());
      }
      AppMethodBeat.o(168950);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dop.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dop.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(168950);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        aqh localaqh = (aqh)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(168950);
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
            localaqh.BaseRequest = ((jr)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(168950);
          return 0;
        case 2: 
          localaqh.id = ((g.a.a.a.a)localObject1).UbS.zl();
          AppMethodBeat.o(168950);
          return 0;
        case 3: 
          localaqh.LCo = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(168950);
          return 0;
        case 4: 
          localaqh.objectNonceId = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(168950);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new aov();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((aov)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dop.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localaqh.uli = ((aov)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(168950);
        return 0;
      }
      AppMethodBeat.o(168950);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aqh
 * JD-Core Version:    0.7.0.1
 */