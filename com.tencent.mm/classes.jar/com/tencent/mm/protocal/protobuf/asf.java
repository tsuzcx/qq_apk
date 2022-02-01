package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;
import java.util.LinkedList;

public final class asf
  extends dop
{
  public String finderUsername;
  public b lastBuffer;
  public aov uli;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(168979);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.ni(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.lastBuffer != null) {
        paramVarArgs.c(2, this.lastBuffer);
      }
      if (this.finderUsername != null) {
        paramVarArgs.e(3, this.finderUsername);
      }
      if (this.uli != null)
      {
        paramVarArgs.ni(4, this.uli.computeSize());
        this.uli.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(168979);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label586;
      }
    }
    label586:
    for (int i = g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.lastBuffer != null) {
        paramInt = i + g.a.a.b.b.a.b(2, this.lastBuffer);
      }
      i = paramInt;
      if (this.finderUsername != null) {
        i = paramInt + g.a.a.b.b.a.f(3, this.finderUsername);
      }
      paramInt = i;
      if (this.uli != null) {
        paramInt = i + g.a.a.a.nh(4, this.uli.computeSize());
      }
      AppMethodBeat.o(168979);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dop.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dop.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(168979);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        asf localasf = (asf)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(168979);
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
            localasf.BaseRequest = ((jr)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(168979);
          return 0;
        case 2: 
          localasf.lastBuffer = ((g.a.a.a.a)localObject1).UbS.hPo();
          AppMethodBeat.o(168979);
          return 0;
        case 3: 
          localasf.finderUsername = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(168979);
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
          localasf.uli = ((aov)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(168979);
        return 0;
      }
      AppMethodBeat.o(168979);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.asf
 * JD-Core Version:    0.7.0.1
 */