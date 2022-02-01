package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ky
  extends com.tencent.mm.bx.a
{
  public long FDe;
  public long FDf;
  public LinkedList<kw> FDg;
  public boolean FDh;
  public long uin;
  
  public ky()
  {
    AppMethodBeat.i(110888);
    this.FDg = new LinkedList();
    this.FDh = false;
    AppMethodBeat.o(110888);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(110889);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aY(1, this.FDe);
      paramVarArgs.aY(2, this.uin);
      paramVarArgs.aY(3, this.FDf);
      paramVarArgs.e(4, 8, this.FDg);
      paramVarArgs.bt(5, this.FDh);
      AppMethodBeat.o(110889);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      paramInt = f.a.a.b.b.a.p(1, this.FDe);
      i = f.a.a.b.b.a.p(2, this.uin);
      int j = f.a.a.b.b.a.p(3, this.FDf);
      int k = f.a.a.a.c(4, 8, this.FDg);
      int m = f.a.a.b.b.a.alV(5);
      AppMethodBeat.o(110889);
      return paramInt + 0 + i + j + k + m;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.FDg.clear();
      paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gxE();
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
        localky.FDe = ((f.a.a.a.a)localObject1).NPN.zd();
        AppMethodBeat.o(110889);
        return 0;
      case 2: 
        localky.uin = ((f.a.a.a.a)localObject1).NPN.zd();
        AppMethodBeat.o(110889);
        return 0;
      case 3: 
        localky.FDf = ((f.a.a.a.a)localObject1).NPN.zd();
        AppMethodBeat.o(110889);
        return 0;
      case 4: 
        paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new kw();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((kw)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localky.FDg.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(110889);
        return 0;
      }
      localky.FDh = ((f.a.a.a.a)localObject1).NPN.grw();
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