package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import java.util.LinkedList;

public final class czh
  extends com.tencent.mm.bv.a
{
  public String xfI;
  public SKBuiltinBuffer_t xfL;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(58942);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.xfL == null)
      {
        paramVarArgs = new b("Not all required fields were included: VerifyBuff");
        AppMethodBeat.o(58942);
        throw paramVarArgs;
      }
      if (this.xfI != null) {
        paramVarArgs.e(1, this.xfI);
      }
      if (this.xfL != null)
      {
        paramVarArgs.iQ(2, this.xfL.computeSize());
        this.xfL.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(58942);
      return 0;
    }
    if (paramInt == 1) {
      if (this.xfI == null) {
        break label418;
      }
    }
    label418:
    for (paramInt = e.a.a.b.b.a.f(1, this.xfI) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.xfL != null) {
        i = paramInt + e.a.a.a.iP(2, this.xfL.computeSize());
      }
      AppMethodBeat.o(58942);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        if (this.xfL == null)
        {
          paramVarArgs = new b("Not all required fields were included: VerifyBuff");
          AppMethodBeat.o(58942);
          throw paramVarArgs;
        }
        AppMethodBeat.o(58942);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        czh localczh = (czh)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(58942);
          return -1;
        case 1: 
          localczh.xfI = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(58942);
          return 0;
        }
        paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new SKBuiltinBuffer_t();
          localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
          localczh.xfL = ((SKBuiltinBuffer_t)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(58942);
        return 0;
      }
      AppMethodBeat.o(58942);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.czh
 * JD-Core Version:    0.7.0.1
 */