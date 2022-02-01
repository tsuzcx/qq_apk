package com.tencent.mm.protocal.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class c
  extends com.tencent.mm.bx.a
{
  public int FoP;
  public int FoQ;
  public o FoR;
  public o FoS;
  public int FoT;
  public int FoU;
  public int ret;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(143942);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.ret);
      paramVarArgs.aS(2, this.FoP);
      paramVarArgs.aS(3, this.FoQ);
      if (this.FoR != null)
      {
        paramVarArgs.lC(4, this.FoR.computeSize());
        this.FoR.writeFields(paramVarArgs);
      }
      if (this.FoS != null)
      {
        paramVarArgs.lC(5, this.FoS.computeSize());
        this.FoS.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(6, this.FoT);
      paramVarArgs.aS(7, this.FoU);
      AppMethodBeat.o(143942);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.b.b.a.bz(1, this.ret) + 0 + f.a.a.b.b.a.bz(2, this.FoP) + f.a.a.b.b.a.bz(3, this.FoQ);
      paramInt = i;
      if (this.FoR != null) {
        paramInt = i + f.a.a.a.lB(4, this.FoR.computeSize());
      }
      i = paramInt;
      if (this.FoS != null) {
        i = paramInt + f.a.a.a.lB(5, this.FoS.computeSize());
      }
      paramInt = f.a.a.b.b.a.bz(6, this.FoT);
      int j = f.a.a.b.b.a.bz(7, this.FoU);
      AppMethodBeat.o(143942);
      return i + paramInt + j;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gxE();
        }
      }
      AppMethodBeat.o(143942);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      c localc = (c)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(143942);
        return -1;
      case 1: 
        localc.ret = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(143942);
        return 0;
      case 2: 
        localc.FoP = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(143942);
        return 0;
      case 3: 
        localc.FoQ = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(143942);
        return 0;
      case 4: 
        paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new o();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((o)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localc.FoR = ((o)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(143942);
        return 0;
      case 5: 
        paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new o();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((o)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localc.FoS = ((o)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(143942);
        return 0;
      case 6: 
        localc.FoT = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(143942);
        return 0;
      }
      localc.FoU = ((f.a.a.a.a)localObject1).NPN.zc();
      AppMethodBeat.o(143942);
      return 0;
    }
    AppMethodBeat.o(143942);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.a.a.c
 * JD-Core Version:    0.7.0.1
 */