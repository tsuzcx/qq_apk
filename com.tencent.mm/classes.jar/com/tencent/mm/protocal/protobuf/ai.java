package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ai
  extends com.tencent.mm.bw.a
{
  public int DMe;
  public int DMf;
  public int DMg;
  public LinkedList<ag> DMh;
  public int DMi;
  public LinkedList<ag> DMj;
  
  public ai()
  {
    AppMethodBeat.i(143963);
    this.DMh = new LinkedList();
    this.DMj = new LinkedList();
    AppMethodBeat.o(143963);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(143964);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aR(1, this.DMe);
      paramVarArgs.aR(2, this.DMg);
      paramVarArgs.e(3, 8, this.DMh);
      paramVarArgs.aR(4, this.DMf);
      paramVarArgs.aR(5, this.DMi);
      paramVarArgs.e(6, 8, this.DMj);
      AppMethodBeat.o(143964);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      paramInt = f.a.a.b.b.a.bx(1, this.DMe);
      i = f.a.a.b.b.a.bx(2, this.DMg);
      int j = f.a.a.a.c(3, 8, this.DMh);
      int k = f.a.a.b.b.a.bx(4, this.DMf);
      int m = f.a.a.b.b.a.bx(5, this.DMi);
      int n = f.a.a.a.c(6, 8, this.DMj);
      AppMethodBeat.o(143964);
      return paramInt + 0 + i + j + k + m + n;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.DMh.clear();
      this.DMj.clear();
      paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gfg();
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
        localai.DMe = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(143964);
        return 0;
      case 2: 
        localai.DMg = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(143964);
        return 0;
      case 3: 
        paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new ag();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((ag)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localai.DMh.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(143964);
        return 0;
      case 4: 
        localai.DMf = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(143964);
        return 0;
      case 5: 
        localai.DMi = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(143964);
        return 0;
      }
      paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject2 = (byte[])paramVarArgs.get(paramInt);
        localObject1 = new ag();
        localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
        for (bool = true; bool; bool = ((ag)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
        localai.DMj.add(localObject1);
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