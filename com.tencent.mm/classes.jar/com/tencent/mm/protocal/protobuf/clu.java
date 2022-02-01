package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class clu
  extends com.tencent.mm.bw.a
{
  public String HxN;
  public String HxO;
  public LinkedList<dns> HxP;
  
  public clu()
  {
    AppMethodBeat.i(72550);
    this.HxP = new LinkedList();
    AppMethodBeat.o(72550);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(72551);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.HxN != null) {
        paramVarArgs.d(1, this.HxN);
      }
      if (this.HxO != null) {
        paramVarArgs.d(2, this.HxO);
      }
      paramVarArgs.e(3, 8, this.HxP);
      AppMethodBeat.o(72551);
      return 0;
    }
    if (paramInt == 1) {
      if (this.HxN == null) {
        break label418;
      }
    }
    label418:
    for (paramInt = f.a.a.b.b.a.e(1, this.HxN) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.HxO != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.HxO);
      }
      paramInt = f.a.a.a.c(3, 8, this.HxP);
      AppMethodBeat.o(72551);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.HxP.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(72551);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        clu localclu = (clu)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(72551);
          return -1;
        case 1: 
          localclu.HxN = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(72551);
          return 0;
        case 2: 
          localclu.HxO = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(72551);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new dns();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((dns)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localclu.HxP.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(72551);
        return 0;
      }
      AppMethodBeat.o(72551);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.clu
 * JD-Core Version:    0.7.0.1
 */