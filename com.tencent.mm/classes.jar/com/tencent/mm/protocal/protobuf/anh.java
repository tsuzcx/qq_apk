package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;
import java.util.LinkedList;

public final class anh
  extends com.tencent.mm.bx.a
{
  public cjb akjR;
  public ani akjS;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(104768);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.akjR == null)
      {
        paramVarArgs = new b("Not all required fields were included: BannerSummary");
        AppMethodBeat.o(104768);
        throw paramVarArgs;
      }
      if (this.akjS == null)
      {
        paramVarArgs = new b("Not all required fields were included: BannerImg");
        AppMethodBeat.o(104768);
        throw paramVarArgs;
      }
      if (this.akjR != null)
      {
        paramVarArgs.qD(1, this.akjR.computeSize());
        this.akjR.writeFields(paramVarArgs);
      }
      if (this.akjS != null)
      {
        paramVarArgs.qD(2, this.akjS.computeSize());
        this.akjS.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(104768);
      return 0;
    }
    if (paramInt == 1) {
      if (this.akjR == null) {
        break label514;
      }
    }
    label514:
    for (paramInt = i.a.a.a.qC(1, this.akjR.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.akjS != null) {
        i = paramInt + i.a.a.a.qC(2, this.akjS.computeSize());
      }
      AppMethodBeat.o(104768);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        if (this.akjR == null)
        {
          paramVarArgs = new b("Not all required fields were included: BannerSummary");
          AppMethodBeat.o(104768);
          throw paramVarArgs;
        }
        if (this.akjS == null)
        {
          paramVarArgs = new b("Not all required fields were included: BannerImg");
          AppMethodBeat.o(104768);
          throw paramVarArgs;
        }
        AppMethodBeat.o(104768);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        anh localanh = (anh)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(104768);
          return -1;
        case 1: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new cjb();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((cjb)localObject2).parseFrom((byte[])localObject1);
            }
            localanh.akjR = ((cjb)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(104768);
          return 0;
        }
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new ani();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((ani)localObject2).parseFrom((byte[])localObject1);
          }
          localanh.akjS = ((ani)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(104768);
        return 0;
      }
      AppMethodBeat.o(104768);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.anh
 * JD-Core Version:    0.7.0.1
 */