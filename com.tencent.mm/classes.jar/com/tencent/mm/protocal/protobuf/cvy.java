package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cvy
  extends bvk
{
  public String wAa;
  public int wzS;
  public int xpM;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(93810);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse != null)
      {
        paramVarArgs.iQ(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aO(2, this.xpM);
      paramVarArgs.aO(3, this.wzS);
      if (this.wAa != null) {
        paramVarArgs.e(4, this.wAa);
      }
      AppMethodBeat.o(93810);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label458;
      }
    }
    label458:
    for (paramInt = e.a.a.a.iP(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + e.a.a.b.b.a.bl(2, this.xpM) + e.a.a.b.b.a.bl(3, this.wzS);
      paramInt = i;
      if (this.wAa != null) {
        paramInt = i + e.a.a.b.b.a.f(4, this.wAa);
      }
      AppMethodBeat.o(93810);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = bvk.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = bvk.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(93810);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        cvy localcvy = (cvy)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(93810);
          return -1;
        case 1: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new BaseResponse();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((BaseResponse)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bvk.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localcvy.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(93810);
          return 0;
        case 2: 
          localcvy.xpM = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(93810);
          return 0;
        case 3: 
          localcvy.wzS = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(93810);
          return 0;
        }
        localcvy.wAa = ((e.a.a.a.a)localObject1).CLY.readString();
        AppMethodBeat.o(93810);
        return 0;
      }
      AppMethodBeat.o(93810);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cvy
 * JD-Core Version:    0.7.0.1
 */