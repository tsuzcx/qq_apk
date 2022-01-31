package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import java.util.LinkedList;

public final class crg
  extends com.tencent.mm.bv.a
{
  public int fKi;
  public String wAs;
  public SKBuiltinBuffer_t xWZ;
  public int xZO;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(116817);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.xWZ == null)
      {
        paramVarArgs = new b("Not all required fields were included: Text");
        AppMethodBeat.o(116817);
        throw paramVarArgs;
      }
      if (this.xWZ != null)
      {
        paramVarArgs.iQ(1, this.xWZ.computeSize());
        this.xWZ.writeFields(paramVarArgs);
      }
      if (this.wAs != null) {
        paramVarArgs.e(2, this.wAs);
      }
      paramVarArgs.aO(3, this.fKi);
      paramVarArgs.aO(4, this.xZO);
      AppMethodBeat.o(116817);
      return 0;
    }
    if (paramInt == 1) {
      if (this.xWZ == null) {
        break label510;
      }
    }
    label510:
    for (paramInt = e.a.a.a.iP(1, this.xWZ.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.wAs != null) {
        i = paramInt + e.a.a.b.b.a.f(2, this.wAs);
      }
      paramInt = e.a.a.b.b.a.bl(3, this.fKi);
      int j = e.a.a.b.b.a.bl(4, this.xZO);
      AppMethodBeat.o(116817);
      return i + paramInt + j;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        if (this.xWZ == null)
        {
          paramVarArgs = new b("Not all required fields were included: Text");
          AppMethodBeat.o(116817);
          throw paramVarArgs;
        }
        AppMethodBeat.o(116817);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        crg localcrg = (crg)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(116817);
          return -1;
        case 1: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localcrg.xWZ = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(116817);
          return 0;
        case 2: 
          localcrg.wAs = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(116817);
          return 0;
        case 3: 
          localcrg.fKi = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(116817);
          return 0;
        }
        localcrg.xZO = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(116817);
        return 0;
      }
      AppMethodBeat.o(116817);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.crg
 * JD-Core Version:    0.7.0.1
 */