package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class dfw
  extends com.tencent.mm.bw.a
{
  public SnsObject HMY;
  public cxn HMZ;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(125765);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.HMY == null)
      {
        paramVarArgs = new b("Not all required fields were included: SnsObject");
        AppMethodBeat.o(125765);
        throw paramVarArgs;
      }
      if (this.HMY != null)
      {
        paramVarArgs.lJ(1, this.HMY.computeSize());
        this.HMY.writeFields(paramVarArgs);
      }
      if (this.HMZ != null)
      {
        paramVarArgs.lJ(2, this.HMZ.computeSize());
        this.HMZ.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(125765);
      return 0;
    }
    if (paramInt == 1) {
      if (this.HMY == null) {
        break label514;
      }
    }
    label514:
    for (paramInt = f.a.a.a.lI(1, this.HMY.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.HMZ != null) {
        i = paramInt + f.a.a.a.lI(2, this.HMZ.computeSize());
      }
      AppMethodBeat.o(125765);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        if (this.HMY == null)
        {
          paramVarArgs = new b("Not all required fields were included: SnsObject");
          AppMethodBeat.o(125765);
          throw paramVarArgs;
        }
        AppMethodBeat.o(125765);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        dfw localdfw = (dfw)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(125765);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SnsObject();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SnsObject)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdfw.HMY = ((SnsObject)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(125765);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new cxn();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((cxn)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localdfw.HMZ = ((cxn)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(125765);
        return 0;
      }
      AppMethodBeat.o(125765);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dfw
 * JD-Core Version:    0.7.0.1
 */