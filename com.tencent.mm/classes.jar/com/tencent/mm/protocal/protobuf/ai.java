package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ai
  extends com.tencent.mm.bw.a
{
  public int FJH;
  public int FJI;
  public int FJJ;
  public LinkedList<ag> FJK;
  public int FJL;
  public LinkedList<ag> FJM;
  
  public ai()
  {
    AppMethodBeat.i(143963);
    this.FJK = new LinkedList();
    this.FJM = new LinkedList();
    AppMethodBeat.o(143963);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(143964);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.FJH);
      paramVarArgs.aS(2, this.FJJ);
      paramVarArgs.e(3, 8, this.FJK);
      paramVarArgs.aS(4, this.FJI);
      paramVarArgs.aS(5, this.FJL);
      paramVarArgs.e(6, 8, this.FJM);
      AppMethodBeat.o(143964);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      paramInt = f.a.a.b.b.a.bz(1, this.FJH);
      i = f.a.a.b.b.a.bz(2, this.FJJ);
      int j = f.a.a.a.c(3, 8, this.FJK);
      int k = f.a.a.b.b.a.bz(4, this.FJI);
      int m = f.a.a.b.b.a.bz(5, this.FJL);
      int n = f.a.a.a.c(6, 8, this.FJM);
      AppMethodBeat.o(143964);
      return paramInt + 0 + i + j + k + m + n;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.FJK.clear();
      this.FJM.clear();
      paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gCg();
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
        localai.FJH = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(143964);
        return 0;
      case 2: 
        localai.FJJ = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(143964);
        return 0;
      case 3: 
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new ag();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((ag)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localai.FJK.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(143964);
        return 0;
      case 4: 
        localai.FJI = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(143964);
        return 0;
      case 5: 
        localai.FJL = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(143964);
        return 0;
      }
      paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject2 = (byte[])paramVarArgs.get(paramInt);
        localObject1 = new ag();
        localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
        for (bool = true; bool; bool = ((ag)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
        localai.FJM.add(localObject1);
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