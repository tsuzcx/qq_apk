package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cwt
  extends dop
{
  public String KDQ;
  public boolean MnK;
  public long hyH;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(207508);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.ni(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.bb(2, this.hyH);
      if (this.KDQ != null) {
        paramVarArgs.e(3, this.KDQ);
      }
      paramVarArgs.cc(4, this.MnK);
      AppMethodBeat.o(207508);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label458;
      }
    }
    label458:
    for (paramInt = g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.r(2, this.hyH);
      paramInt = i;
      if (this.KDQ != null) {
        paramInt = i + g.a.a.b.b.a.f(3, this.KDQ);
      }
      i = g.a.a.b.b.a.fS(4);
      AppMethodBeat.o(207508);
      return paramInt + (i + 1);
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dop.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dop.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(207508);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        cwt localcwt = (cwt)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(207508);
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
            localcwt.BaseRequest = ((jr)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(207508);
          return 0;
        case 2: 
          localcwt.hyH = ((g.a.a.a.a)localObject1).UbS.zl();
          AppMethodBeat.o(207508);
          return 0;
        case 3: 
          localcwt.KDQ = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(207508);
          return 0;
        }
        localcwt.MnK = ((g.a.a.a.a)localObject1).UbS.yZ();
        AppMethodBeat.o(207508);
        return 0;
      }
      AppMethodBeat.o(207508);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cwt
 * JD-Core Version:    0.7.0.1
 */