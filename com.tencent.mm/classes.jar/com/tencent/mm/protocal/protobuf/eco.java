package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class eco
  extends com.tencent.mm.bw.a
{
  public int AiS;
  public ecp IhL;
  public ecq IhM;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(188963);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.AiS);
      if (this.IhL != null)
      {
        paramVarArgs.lJ(2, this.IhL.computeSize());
        this.IhL.writeFields(paramVarArgs);
      }
      if (this.IhM != null)
      {
        paramVarArgs.lJ(3, this.IhM.computeSize());
        this.IhM.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(188963);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.b.b.a.bz(1, this.AiS) + 0;
      paramInt = i;
      if (this.IhL != null) {
        paramInt = i + f.a.a.a.lI(2, this.IhL.computeSize());
      }
      i = paramInt;
      if (this.IhM != null) {
        i = paramInt + f.a.a.a.lI(3, this.IhM.computeSize());
      }
      AppMethodBeat.o(188963);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gCg();
        }
      }
      AppMethodBeat.o(188963);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      eco localeco = (eco)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(188963);
        return -1;
      case 1: 
        localeco.AiS = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(188963);
        return 0;
      case 2: 
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new ecp();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((ecp)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localeco.IhL = ((ecp)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(188963);
        return 0;
      }
      paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject2 = (byte[])paramVarArgs.get(paramInt);
        localObject1 = new ecq();
        localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
        for (bool = true; bool; bool = ((ecq)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
        localeco.IhM = ((ecq)localObject1);
        paramInt += 1;
      }
      AppMethodBeat.o(188963);
      return 0;
    }
    AppMethodBeat.o(188963);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.eco
 * JD-Core Version:    0.7.0.1
 */