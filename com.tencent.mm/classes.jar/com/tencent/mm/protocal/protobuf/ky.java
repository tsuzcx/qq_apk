package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ky
  extends com.tencent.mm.bw.a
{
  public long FVA;
  public LinkedList<kw> FVB;
  public boolean FVC;
  public long FVz;
  public long uin;
  
  public ky()
  {
    AppMethodBeat.i(110888);
    this.FVB = new LinkedList();
    this.FVC = false;
    AppMethodBeat.o(110888);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(110889);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aZ(1, this.FVz);
      paramVarArgs.aZ(2, this.uin);
      paramVarArgs.aZ(3, this.FVA);
      paramVarArgs.e(4, 8, this.FVB);
      paramVarArgs.bC(5, this.FVC);
      AppMethodBeat.o(110889);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      paramInt = f.a.a.b.b.a.p(1, this.FVz);
      i = f.a.a.b.b.a.p(2, this.uin);
      int j = f.a.a.b.b.a.p(3, this.FVA);
      int k = f.a.a.a.c(4, 8, this.FVB);
      int m = f.a.a.b.b.a.amF(5);
      AppMethodBeat.o(110889);
      return paramInt + 0 + i + j + k + m;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.FVB.clear();
      paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gCg();
        }
      }
      AppMethodBeat.o(110889);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      ky localky = (ky)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(110889);
        return -1;
      case 1: 
        localky.FVz = ((f.a.a.a.a)localObject1).OmT.zd();
        AppMethodBeat.o(110889);
        return 0;
      case 2: 
        localky.uin = ((f.a.a.a.a)localObject1).OmT.zd();
        AppMethodBeat.o(110889);
        return 0;
      case 3: 
        localky.FVA = ((f.a.a.a.a)localObject1).OmT.zd();
        AppMethodBeat.o(110889);
        return 0;
      case 4: 
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new kw();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((kw)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localky.FVB.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(110889);
        return 0;
      }
      localky.FVC = ((f.a.a.a.a)localObject1).OmT.gvY();
      AppMethodBeat.o(110889);
      return 0;
    }
    AppMethodBeat.o(110889);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ky
 * JD-Core Version:    0.7.0.1
 */