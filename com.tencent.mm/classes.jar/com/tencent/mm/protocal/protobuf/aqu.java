package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;
import java.util.LinkedList;

public final class aqu
  extends com.tencent.mm.bx.a
{
  public b GoO;
  public LinkedList<ase> GoP;
  public String GoQ;
  public long GoR;
  public long dtq;
  public int priority;
  public int type;
  
  public aqu()
  {
    AppMethodBeat.i(184209);
    this.GoP = new LinkedList();
    AppMethodBeat.o(184209);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(184210);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.priority);
      paramVarArgs.aS(2, this.type);
      if (this.GoO != null) {
        paramVarArgs.c(3, this.GoO);
      }
      paramVarArgs.e(4, 8, this.GoP);
      if (this.GoQ != null) {
        paramVarArgs.d(5, this.GoQ);
      }
      paramVarArgs.aY(100, this.dtq);
      paramVarArgs.aY(101, this.GoR);
      AppMethodBeat.o(184210);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.b.b.a.bz(1, this.priority) + 0 + f.a.a.b.b.a.bz(2, this.type);
      paramInt = i;
      if (this.GoO != null) {
        paramInt = i + f.a.a.b.b.a.b(3, this.GoO);
      }
      i = paramInt + f.a.a.a.c(4, 8, this.GoP);
      paramInt = i;
      if (this.GoQ != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.GoQ);
      }
      i = f.a.a.b.b.a.p(100, this.dtq);
      int j = f.a.a.b.b.a.p(101, this.GoR);
      AppMethodBeat.o(184210);
      return paramInt + i + j;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.GoP.clear();
      paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gxE();
        }
      }
      AppMethodBeat.o(184210);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      aqu localaqu = (aqu)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(184210);
        return -1;
      case 1: 
        localaqu.priority = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(184210);
        return 0;
      case 2: 
        localaqu.type = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(184210);
        return 0;
      case 3: 
        localaqu.GoO = ((f.a.a.a.a)localObject1).NPN.gxI();
        AppMethodBeat.o(184210);
        return 0;
      case 4: 
        paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new ase();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((ase)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localaqu.GoP.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(184210);
        return 0;
      case 5: 
        localaqu.GoQ = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(184210);
        return 0;
      case 100: 
        localaqu.dtq = ((f.a.a.a.a)localObject1).NPN.zd();
        AppMethodBeat.o(184210);
        return 0;
      }
      localaqu.GoR = ((f.a.a.a.a)localObject1).NPN.zd();
      AppMethodBeat.o(184210);
      return 0;
    }
    AppMethodBeat.o(184210);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aqu
 * JD-Core Version:    0.7.0.1
 */