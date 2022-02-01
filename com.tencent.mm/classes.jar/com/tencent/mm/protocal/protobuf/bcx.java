package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bcx
  extends com.tencent.mm.bw.a
{
  public LinkedList<bcu> LEy;
  public LinkedList<bcw> LLI;
  public LinkedList<Long> LMe;
  
  public bcx()
  {
    AppMethodBeat.i(209686);
    this.LLI = new LinkedList();
    this.LEy = new LinkedList();
    this.LMe = new LinkedList();
    AppMethodBeat.o(209686);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(209687);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.e(1, 8, this.LLI);
      paramVarArgs.e(2, 8, this.LEy);
      paramVarArgs.e(3, 3, this.LMe);
      AppMethodBeat.o(209687);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      paramInt = g.a.a.a.c(1, 8, this.LLI);
      i = g.a.a.a.c(2, 8, this.LEy);
      int j = g.a.a.a.c(3, 3, this.LMe);
      AppMethodBeat.o(209687);
      return paramInt + 0 + i + j;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.LLI.clear();
      this.LEy.clear();
      this.LMe.clear();
      paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.hPl();
        }
      }
      AppMethodBeat.o(209687);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
      bcx localbcx = (bcx)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(209687);
        return -1;
      case 1: 
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new bcw();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((bcw)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localbcx.LLI.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(209687);
        return 0;
      case 2: 
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new bcu();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((bcu)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localbcx.LEy.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(209687);
        return 0;
      }
      localbcx.LMe.add(Long.valueOf(((g.a.a.a.a)localObject1).UbS.zl()));
      AppMethodBeat.o(209687);
      return 0;
    }
    AppMethodBeat.o(209687);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bcx
 * JD-Core Version:    0.7.0.1
 */