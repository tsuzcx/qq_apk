package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class eax
  extends com.tencent.mm.bx.a
{
  public eay HNE;
  public eaz HNF;
  public int zRL;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(207262);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.zRL);
      if (this.HNE != null)
      {
        paramVarArgs.lC(2, this.HNE.computeSize());
        this.HNE.writeFields(paramVarArgs);
      }
      if (this.HNF != null)
      {
        paramVarArgs.lC(3, this.HNF.computeSize());
        this.HNF.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(207262);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.b.b.a.bz(1, this.zRL) + 0;
      paramInt = i;
      if (this.HNE != null) {
        paramInt = i + f.a.a.a.lB(2, this.HNE.computeSize());
      }
      i = paramInt;
      if (this.HNF != null) {
        i = paramInt + f.a.a.a.lB(3, this.HNF.computeSize());
      }
      AppMethodBeat.o(207262);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gxE();
        }
      }
      AppMethodBeat.o(207262);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      eax localeax = (eax)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(207262);
        return -1;
      case 1: 
        localeax.zRL = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(207262);
        return 0;
      case 2: 
        paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new eay();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((eay)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localeax.HNE = ((eay)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(207262);
        return 0;
      }
      paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject2 = (byte[])paramVarArgs.get(paramInt);
        localObject1 = new eaz();
        localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
        for (bool = true; bool; bool = ((eaz)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
        localeax.HNF = ((eaz)localObject1);
        paramInt += 1;
      }
      AppMethodBeat.o(207262);
      return 0;
    }
    AppMethodBeat.o(207262);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.eax
 * JD-Core Version:    0.7.0.1
 */