package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;
import java.util.LinkedList;

public final class mf
  extends erp
{
  public mg YNy;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(110887);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.YNy == null)
      {
        paramVarArgs = new b("Not all required fields were included: vlogreq");
        AppMethodBeat.o(110887);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.qD(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.YNy != null)
      {
        paramVarArgs.qD(2, this.YNy.computeSize());
        this.YNy.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(110887);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label466;
      }
    }
    label466:
    for (paramInt = i.a.a.a.qC(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.YNy != null) {
        i = paramInt + i.a.a.a.qC(2, this.YNy.computeSize());
      }
      AppMethodBeat.o(110887);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = erp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = erp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        if (this.YNy == null)
        {
          paramVarArgs = new b("Not all required fields were included: vlogreq");
          AppMethodBeat.o(110887);
          throw paramVarArgs;
        }
        AppMethodBeat.o(110887);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        mf localmf = (mf)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(110887);
          return -1;
        case 1: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new kc();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((kc)localObject2).parseFrom((byte[])localObject1);
            }
            localmf.BaseRequest = ((kc)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(110887);
          return 0;
        }
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new mg();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((mg)localObject2).parseFrom((byte[])localObject1);
          }
          localmf.YNy = ((mg)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(110887);
        return 0;
      }
      AppMethodBeat.o(110887);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.mf
 * JD-Core Version:    0.7.0.1
 */