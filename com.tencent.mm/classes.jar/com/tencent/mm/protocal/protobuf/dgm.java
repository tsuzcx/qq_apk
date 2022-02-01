package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dgm
  extends com.tencent.mm.bx.a
{
  public SKBuiltinBuffer_t HuO;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(125808);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.HuO != null)
      {
        paramVarArgs.lC(1, this.HuO.computeSize());
        this.HuO.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(125808);
      return 0;
    }
    if (paramInt == 1) {
      if (this.HuO == null) {
        break label310;
      }
    }
    label310:
    for (paramInt = f.a.a.a.lB(1, this.HuO.computeSize()) + 0;; paramInt = 0)
    {
      AppMethodBeat.o(125808);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(125808);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        dgm localdgm = (dgm)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(125808);
          return -1;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
        int i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new SKBuiltinBuffer_t();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localdgm.HuO = ((SKBuiltinBuffer_t)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(125808);
        return 0;
      }
      AppMethodBeat.o(125808);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dgm
 * JD-Core Version:    0.7.0.1
 */