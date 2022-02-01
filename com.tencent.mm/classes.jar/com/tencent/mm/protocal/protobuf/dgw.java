package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dgw
  extends dop
{
  public long MLr;
  public long MLs;
  public long offset;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91638);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.ni(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.bb(2, this.MLr);
      paramVarArgs.bb(3, this.offset);
      paramVarArgs.bb(4, this.MLs);
      AppMethodBeat.o(91638);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label446;
      }
    }
    label446:
    for (paramInt = g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = g.a.a.b.b.a.r(2, this.MLr);
      int j = g.a.a.b.b.a.r(3, this.offset);
      int k = g.a.a.b.b.a.r(4, this.MLs);
      AppMethodBeat.o(91638);
      return paramInt + i + j + k;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dop.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dop.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(91638);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        dgw localdgw = (dgw)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91638);
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
            localdgw.BaseRequest = ((jr)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91638);
          return 0;
        case 2: 
          localdgw.MLr = ((g.a.a.a.a)localObject1).UbS.zl();
          AppMethodBeat.o(91638);
          return 0;
        case 3: 
          localdgw.offset = ((g.a.a.a.a)localObject1).UbS.zl();
          AppMethodBeat.o(91638);
          return 0;
        }
        localdgw.MLs = ((g.a.a.a.a)localObject1).UbS.zl();
        AppMethodBeat.o(91638);
        return 0;
      }
      AppMethodBeat.o(91638);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dgw
 * JD-Core Version:    0.7.0.1
 */