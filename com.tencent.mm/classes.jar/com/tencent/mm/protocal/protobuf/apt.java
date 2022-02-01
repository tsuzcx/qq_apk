package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class apt
  extends com.tencent.mm.bx.a
{
  public apx verifyInfo;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(169016);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.verifyInfo != null)
      {
        paramVarArgs.lC(1, this.verifyInfo.computeSize());
        this.verifyInfo.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(169016);
      return 0;
    }
    if (paramInt == 1) {
      if (this.verifyInfo == null) {
        break label310;
      }
    }
    label310:
    for (paramInt = f.a.a.a.lB(1, this.verifyInfo.computeSize()) + 0;; paramInt = 0)
    {
      AppMethodBeat.o(169016);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(169016);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        apt localapt = (apt)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(169016);
          return -1;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
        int i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new apx();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((apx)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localapt.verifyInfo = ((apx)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(169016);
        return 0;
      }
      AppMethodBeat.o(169016);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.apt
 * JD-Core Version:    0.7.0.1
 */