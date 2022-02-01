package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dgo
  extends com.tencent.mm.bx.a
{
  public int HnC;
  public int HuQ;
  public LinkedList<dfw> HuR;
  public int HuS;
  public int HuT;
  
  public dgo()
  {
    AppMethodBeat.i(125810);
    this.HuR = new LinkedList();
    AppMethodBeat.o(125810);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(125811);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.HuQ);
      paramVarArgs.e(2, 8, this.HuR);
      paramVarArgs.aS(3, this.HuS);
      paramVarArgs.aS(4, this.HnC);
      paramVarArgs.aS(5, this.HuT);
      AppMethodBeat.o(125811);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      paramInt = f.a.a.b.b.a.bz(1, this.HuQ);
      i = f.a.a.a.c(2, 8, this.HuR);
      int j = f.a.a.b.b.a.bz(3, this.HuS);
      int k = f.a.a.b.b.a.bz(4, this.HnC);
      int m = f.a.a.b.b.a.bz(5, this.HuT);
      AppMethodBeat.o(125811);
      return paramInt + 0 + i + j + k + m;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.HuR.clear();
      paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gxE();
        }
      }
      AppMethodBeat.o(125811);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      dgo localdgo = (dgo)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(125811);
        return -1;
      case 1: 
        localdgo.HuQ = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(125811);
        return 0;
      case 2: 
        paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new dfw();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((dfw)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localdgo.HuR.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(125811);
        return 0;
      case 3: 
        localdgo.HuS = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(125811);
        return 0;
      case 4: 
        localdgo.HnC = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(125811);
        return 0;
      }
      localdgo.HuT = ((f.a.a.a.a)localObject1).NPN.zc();
      AppMethodBeat.o(125811);
      return 0;
    }
    AppMethodBeat.o(125811);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dgo
 * JD-Core Version:    0.7.0.1
 */