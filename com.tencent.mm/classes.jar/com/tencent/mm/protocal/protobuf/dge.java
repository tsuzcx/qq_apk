package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dge
  extends com.tencent.mm.bx.a
{
  public int Hup;
  public cwt Huq;
  public int Scene;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(125797);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.Hup);
      if (this.Huq != null)
      {
        paramVarArgs.lC(2, this.Huq.computeSize());
        this.Huq.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(3, this.Scene);
      AppMethodBeat.o(125797);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.b.b.a.bz(1, this.Hup) + 0;
      paramInt = i;
      if (this.Huq != null) {
        paramInt = i + f.a.a.a.lB(2, this.Huq.computeSize());
      }
      i = f.a.a.b.b.a.bz(3, this.Scene);
      AppMethodBeat.o(125797);
      return paramInt + i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gxE();
        }
      }
      AppMethodBeat.o(125797);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      dge localdge = (dge)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(125797);
        return -1;
      case 1: 
        localdge.Hup = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(125797);
        return 0;
      case 2: 
        paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new cwt();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((cwt)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localdge.Huq = ((cwt)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(125797);
        return 0;
      }
      localdge.Scene = ((f.a.a.a.a)localObject1).NPN.zc();
      AppMethodBeat.o(125797);
      return 0;
    }
    AppMethodBeat.o(125797);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dge
 * JD-Core Version:    0.7.0.1
 */