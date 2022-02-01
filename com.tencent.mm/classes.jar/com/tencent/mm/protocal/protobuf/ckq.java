package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ckq
  extends dop
{
  public String Mqa;
  public String lang;
  public int limit;
  public int offset;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(152624);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.ni(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aM(2, this.offset);
      paramVarArgs.aM(3, this.limit);
      if (this.lang != null) {
        paramVarArgs.e(4, this.lang);
      }
      if (this.Mqa != null) {
        paramVarArgs.e(5, this.Mqa);
      }
      AppMethodBeat.o(152624);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label518;
      }
    }
    label518:
    for (paramInt = g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bu(2, this.offset) + g.a.a.b.b.a.bu(3, this.limit);
      paramInt = i;
      if (this.lang != null) {
        paramInt = i + g.a.a.b.b.a.f(4, this.lang);
      }
      i = paramInt;
      if (this.Mqa != null) {
        i = paramInt + g.a.a.b.b.a.f(5, this.Mqa);
      }
      AppMethodBeat.o(152624);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dop.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dop.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(152624);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        ckq localckq = (ckq)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(152624);
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
            localckq.BaseRequest = ((jr)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152624);
          return 0;
        case 2: 
          localckq.offset = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(152624);
          return 0;
        case 3: 
          localckq.limit = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(152624);
          return 0;
        case 4: 
          localckq.lang = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(152624);
          return 0;
        }
        localckq.Mqa = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(152624);
        return 0;
      }
      AppMethodBeat.o(152624);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ckq
 * JD-Core Version:    0.7.0.1
 */