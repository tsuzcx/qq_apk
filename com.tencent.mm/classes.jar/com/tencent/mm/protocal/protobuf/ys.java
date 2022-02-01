package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;
import java.util.LinkedList;

public final class ys
  extends com.tencent.mm.bx.a
{
  public int FYd;
  public int FYe;
  public int FYf;
  public LinkedList<yr> FYg;
  public b FYh;
  public bnx FYi;
  
  public ys()
  {
    AppMethodBeat.i(143967);
    this.FYg = new LinkedList();
    AppMethodBeat.o(143967);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(143968);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.FYd);
      paramVarArgs.aS(2, this.FYe);
      paramVarArgs.aS(3, this.FYf);
      paramVarArgs.e(4, 8, this.FYg);
      if (this.FYh != null) {
        paramVarArgs.c(5, this.FYh);
      }
      if (this.FYi != null)
      {
        paramVarArgs.lC(6, this.FYi.computeSize());
        this.FYi.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(143968);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.b.b.a.bz(1, this.FYd) + 0 + f.a.a.b.b.a.bz(2, this.FYe) + f.a.a.b.b.a.bz(3, this.FYf) + f.a.a.a.c(4, 8, this.FYg);
      paramInt = i;
      if (this.FYh != null) {
        paramInt = i + f.a.a.b.b.a.b(5, this.FYh);
      }
      i = paramInt;
      if (this.FYi != null) {
        i = paramInt + f.a.a.a.lB(6, this.FYi.computeSize());
      }
      AppMethodBeat.o(143968);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.FYg.clear();
      paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gxE();
        }
      }
      AppMethodBeat.o(143968);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      ys localys = (ys)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(143968);
        return -1;
      case 1: 
        localys.FYd = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(143968);
        return 0;
      case 2: 
        localys.FYe = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(143968);
        return 0;
      case 3: 
        localys.FYf = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(143968);
        return 0;
      case 4: 
        paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new yr();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((yr)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localys.FYg.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(143968);
        return 0;
      case 5: 
        localys.FYh = ((f.a.a.a.a)localObject1).NPN.gxI();
        AppMethodBeat.o(143968);
        return 0;
      }
      paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject2 = (byte[])paramVarArgs.get(paramInt);
        localObject1 = new bnx();
        localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
        for (bool = true; bool; bool = ((bnx)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
        localys.FYi = ((bnx)localObject1);
        paramInt += 1;
      }
      AppMethodBeat.o(143968);
      return 0;
    }
    AppMethodBeat.o(143968);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ys
 * JD-Core Version:    0.7.0.1
 */