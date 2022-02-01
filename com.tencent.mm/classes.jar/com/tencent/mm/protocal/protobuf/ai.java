package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ai
  extends com.tencent.mm.bx.a
{
  public int CtN;
  public int CtO;
  public int CtP;
  public LinkedList<ag> CtQ;
  public int CtR;
  public LinkedList<ag> CtS;
  
  public ai()
  {
    AppMethodBeat.i(143963);
    this.CtQ = new LinkedList();
    this.CtS = new LinkedList();
    AppMethodBeat.o(143963);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(143964);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aR(1, this.CtN);
      paramVarArgs.aR(2, this.CtP);
      paramVarArgs.e(3, 8, this.CtQ);
      paramVarArgs.aR(4, this.CtO);
      paramVarArgs.aR(5, this.CtR);
      paramVarArgs.e(6, 8, this.CtS);
      AppMethodBeat.o(143964);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      paramInt = f.a.a.b.b.a.bA(1, this.CtN);
      i = f.a.a.b.b.a.bA(2, this.CtP);
      int j = f.a.a.a.c(3, 8, this.CtQ);
      int k = f.a.a.b.b.a.bA(4, this.CtO);
      int m = f.a.a.b.b.a.bA(5, this.CtR);
      int n = f.a.a.a.c(6, 8, this.CtS);
      AppMethodBeat.o(143964);
      return paramInt + 0 + i + j + k + m + n;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.CtQ.clear();
      this.CtS.clear();
      paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.fMq();
        }
      }
      AppMethodBeat.o(143964);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      ai localai = (ai)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(143964);
        return -1;
      case 1: 
        localai.CtN = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(143964);
        return 0;
      case 2: 
        localai.CtP = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(143964);
        return 0;
      case 3: 
        paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new ag();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((ag)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localai.CtQ.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(143964);
        return 0;
      case 4: 
        localai.CtO = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(143964);
        return 0;
      case 5: 
        localai.CtR = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(143964);
        return 0;
      }
      paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject2 = (byte[])paramVarArgs.get(paramInt);
        localObject1 = new ag();
        localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
        for (bool = true; bool; bool = ((ag)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
        localai.CtS.add(localObject1);
        paramInt += 1;
      }
      AppMethodBeat.o(143964);
      return 0;
    }
    AppMethodBeat.o(143964);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ai
 * JD-Core Version:    0.7.0.1
 */