package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ege
  extends com.tencent.mm.bw.a
{
  public long IjR;
  public pt IjS;
  public int IjT;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(117950);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aZ(1, this.IjR);
      if (this.IjS != null)
      {
        paramVarArgs.lJ(2, this.IjS.computeSize());
        this.IjS.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(3, this.IjT);
      AppMethodBeat.o(117950);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.b.b.a.p(1, this.IjR) + 0;
      paramInt = i;
      if (this.IjS != null) {
        paramInt = i + f.a.a.a.lI(2, this.IjS.computeSize());
      }
      i = f.a.a.b.b.a.bz(3, this.IjT);
      AppMethodBeat.o(117950);
      return paramInt + i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gCg();
        }
      }
      AppMethodBeat.o(117950);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      ege localege = (ege)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(117950);
        return -1;
      case 1: 
        localege.IjR = ((f.a.a.a.a)localObject1).OmT.zd();
        AppMethodBeat.o(117950);
        return 0;
      case 2: 
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new pt();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((pt)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localege.IjS = ((pt)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(117950);
        return 0;
      }
      localege.IjT = ((f.a.a.a.a)localObject1).OmT.zc();
      AppMethodBeat.o(117950);
      return 0;
    }
    AppMethodBeat.o(117950);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ege
 * JD-Core Version:    0.7.0.1
 */