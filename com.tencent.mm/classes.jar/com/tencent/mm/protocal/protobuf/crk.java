package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class crk
  extends com.tencent.mm.bx.a
{
  public dgn HjN;
  public cwt HjO;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(125759);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.HjN == null)
      {
        paramVarArgs = new b("Not all required fields were included: SnsRecommendObject");
        AppMethodBeat.o(125759);
        throw paramVarArgs;
      }
      if (this.HjN != null)
      {
        paramVarArgs.lC(1, this.HjN.computeSize());
        this.HjN.writeFields(paramVarArgs);
      }
      if (this.HjO != null)
      {
        paramVarArgs.lC(2, this.HjO.computeSize());
        this.HjO.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(125759);
      return 0;
    }
    if (paramInt == 1) {
      if (this.HjN == null) {
        break label514;
      }
    }
    label514:
    for (paramInt = f.a.a.a.lB(1, this.HjN.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.HjO != null) {
        i = paramInt + f.a.a.a.lB(2, this.HjO.computeSize());
      }
      AppMethodBeat.o(125759);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        if (this.HjN == null)
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
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        crk localcrk = (crk)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(125759);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dgn();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dgn)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcrk.HjN = ((dgn)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(125759);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new cwt();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((cwt)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localcrk.HjO = ((cwt)localObject1);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.crk
 * JD-Core Version:    0.7.0.1
 */