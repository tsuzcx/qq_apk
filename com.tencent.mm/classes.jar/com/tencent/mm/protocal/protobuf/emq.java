package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;
import java.util.LinkedList;

public final class emq
  extends com.tencent.mm.bx.a
{
  public fey abqV;
  public etl abqW;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(125759);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.abqV == null)
      {
        paramVarArgs = new b("Not all required fields were included: SnsRecommendObject");
        AppMethodBeat.o(125759);
        throw paramVarArgs;
      }
      if (this.abqV != null)
      {
        paramVarArgs.qD(1, this.abqV.computeSize());
        this.abqV.writeFields(paramVarArgs);
      }
      if (this.abqW != null)
      {
        paramVarArgs.qD(2, this.abqW.computeSize());
        this.abqW.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(125759);
      return 0;
    }
    if (paramInt == 1) {
      if (this.abqV == null) {
        break label466;
      }
    }
    label466:
    for (paramInt = i.a.a.a.qC(1, this.abqV.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.abqW != null) {
        i = paramInt + i.a.a.a.qC(2, this.abqW.computeSize());
      }
      AppMethodBeat.o(125759);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        if (this.abqV == null)
        {
          paramVarArgs = new b("Not all required fields were included: SnsRecommendObject");
          AppMethodBeat.o(125759);
          throw paramVarArgs;
        }
        AppMethodBeat.o(125759);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        emq localemq = (emq)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(125759);
          return -1;
        case 1: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new fey();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((fey)localObject2).parseFrom((byte[])localObject1);
            }
            localemq.abqV = ((fey)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(125759);
          return 0;
        }
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new etl();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((etl)localObject2).dh((byte[])localObject1);
          }
          localemq.abqW = ((etl)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(125759);
        return 0;
      }
      AppMethodBeat.o(125759);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.emq
 * JD-Core Version:    0.7.0.1
 */