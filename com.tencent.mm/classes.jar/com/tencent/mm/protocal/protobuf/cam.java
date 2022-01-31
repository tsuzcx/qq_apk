package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import java.util.LinkedList;

public final class cam
  extends buy
{
  public int mask;
  public int wZJ;
  public ky wZL;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(11806);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.wZL == null)
      {
        paramVarArgs = new b("Not all required fields were included: attr");
        AppMethodBeat.o(11806);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.iQ(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aO(2, this.wZJ);
      paramVarArgs.aO(3, this.mask);
      if (this.wZL != null)
      {
        paramVarArgs.iQ(4, this.wZL.computeSize());
        this.wZL.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(11806);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label612;
      }
    }
    label612:
    for (paramInt = e.a.a.a.iP(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + e.a.a.b.b.a.bl(2, this.wZJ) + e.a.a.b.b.a.bl(3, this.mask);
      paramInt = i;
      if (this.wZL != null) {
        paramInt = i + e.a.a.a.iP(4, this.wZL.computeSize());
      }
      AppMethodBeat.o(11806);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = buy.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = buy.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        if (this.wZL == null)
        {
          paramVarArgs = new b("Not all required fields were included: attr");
          AppMethodBeat.o(11806);
          throw paramVarArgs;
        }
        AppMethodBeat.o(11806);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        cam localcam = (cam)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(11806);
          return -1;
        case 1: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new hq();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((hq)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, buy.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localcam.BaseRequest = ((hq)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(11806);
          return 0;
        case 2: 
          localcam.wZJ = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(11806);
          return 0;
        case 3: 
          localcam.mask = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(11806);
          return 0;
        }
        paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new ky();
          localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((ky)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, buy.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
          localcam.wZL = ((ky)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(11806);
        return 0;
      }
      AppMethodBeat.o(11806);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cam
 * JD-Core Version:    0.7.0.1
 */