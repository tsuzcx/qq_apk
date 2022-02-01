package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cxr
  extends com.tencent.mm.bw.a
{
  public LinkedList<bwr> HIh;
  public boolean HIi;
  public boolean HIj;
  public boolean HIk;
  public boolean HIl;
  public boolean HIm;
  
  public cxr()
  {
    AppMethodBeat.i(155454);
    this.HIh = new LinkedList();
    AppMethodBeat.o(155454);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(155455);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.e(1, 8, this.HIh);
      paramVarArgs.bC(2, this.HIi);
      paramVarArgs.bC(3, this.HIj);
      paramVarArgs.bC(4, this.HIk);
      paramVarArgs.bC(5, this.HIl);
      paramVarArgs.bC(6, this.HIm);
      AppMethodBeat.o(155455);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      paramInt = f.a.a.a.c(1, 8, this.HIh);
      i = f.a.a.b.b.a.amF(2);
      int j = f.a.a.b.b.a.amF(3);
      int k = f.a.a.b.b.a.amF(4);
      int m = f.a.a.b.b.a.amF(5);
      int n = f.a.a.b.b.a.amF(6);
      AppMethodBeat.o(155455);
      return paramInt + 0 + i + j + k + m + n;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.HIh.clear();
      paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gCg();
        }
      }
      AppMethodBeat.o(155455);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      cxr localcxr = (cxr)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(155455);
        return -1;
      case 1: 
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new bwr();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((bwr)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localcxr.HIh.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(155455);
        return 0;
      case 2: 
        localcxr.HIi = ((f.a.a.a.a)localObject1).OmT.gvY();
        AppMethodBeat.o(155455);
        return 0;
      case 3: 
        localcxr.HIj = ((f.a.a.a.a)localObject1).OmT.gvY();
        AppMethodBeat.o(155455);
        return 0;
      case 4: 
        localcxr.HIk = ((f.a.a.a.a)localObject1).OmT.gvY();
        AppMethodBeat.o(155455);
        return 0;
      case 5: 
        localcxr.HIl = ((f.a.a.a.a)localObject1).OmT.gvY();
        AppMethodBeat.o(155455);
        return 0;
      }
      localcxr.HIm = ((f.a.a.a.a)localObject1).OmT.gvY();
      AppMethodBeat.o(155455);
      return 0;
    }
    AppMethodBeat.o(155455);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cxr
 * JD-Core Version:    0.7.0.1
 */