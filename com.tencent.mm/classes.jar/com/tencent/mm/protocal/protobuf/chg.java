package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class chg
  extends com.tencent.mm.bx.a
{
  public cvo EcK;
  public cmf EcL;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(125759);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.EcK == null)
      {
        paramVarArgs = new b("Not all required fields were included: SnsRecommendObject");
        AppMethodBeat.o(125759);
        throw paramVarArgs;
      }
      if (this.EcK != null)
      {
        paramVarArgs.kX(1, this.EcK.computeSize());
        this.EcK.writeFields(paramVarArgs);
      }
      if (this.EcL != null)
      {
        paramVarArgs.kX(2, this.EcL.computeSize());
        this.EcL.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(125759);
      return 0;
    }
    if (paramInt == 1) {
      if (this.EcK == null) {
        break label514;
      }
    }
    label514:
    for (paramInt = f.a.a.a.kW(1, this.EcK.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.EcL != null) {
        i = paramInt + f.a.a.a.kW(2, this.EcL.computeSize());
      }
      AppMethodBeat.o(125759);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        if (this.EcK == null)
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
        chg localchg = (chg)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(125759);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cvo();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cvo)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localchg.EcK = ((cvo)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(125759);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new cmf();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((cmf)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localchg.EcL = ((cmf)localObject1);
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
 * Qualified Name:     com.tencent.mm.protocal.protobuf.chg
 * JD-Core Version:    0.7.0.1
 */