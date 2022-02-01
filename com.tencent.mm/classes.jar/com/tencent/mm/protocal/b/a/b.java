package com.tencent.mm.protocal.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class b
  extends com.tencent.mm.bx.a
{
  public LinkedList<a> FpE;
  public int id;
  public String msg;
  public String title;
  
  public b()
  {
    AppMethodBeat.i(123717);
    this.FpE = new LinkedList();
    AppMethodBeat.o(123717);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(123718);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.id);
      if (this.title != null) {
        paramVarArgs.d(2, this.title);
      }
      if (this.msg != null) {
        paramVarArgs.d(3, this.msg);
      }
      paramVarArgs.e(4, 8, this.FpE);
      AppMethodBeat.o(123718);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.b.b.a.bz(1, this.id) + 0;
      paramInt = i;
      if (this.title != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.title);
      }
      i = paramInt;
      if (this.msg != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.msg);
      }
      paramInt = f.a.a.a.c(4, 8, this.FpE);
      AppMethodBeat.o(123718);
      return i + paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.FpE.clear();
      paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gxE();
        }
      }
      AppMethodBeat.o(123718);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      b localb = (b)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(123718);
        return -1;
      case 1: 
        localb.id = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(123718);
        return 0;
      case 2: 
        localb.title = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(123718);
        return 0;
      case 3: 
        localb.msg = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(123718);
        return 0;
      }
      paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        Object localObject2 = (byte[])paramVarArgs.get(paramInt);
        localObject1 = new a();
        localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
        for (boolean bool = true; bool; bool = ((a)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
        localb.FpE.add(localObject1);
        paramInt += 1;
      }
      AppMethodBeat.o(123718);
      return 0;
    }
    AppMethodBeat.o(123718);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.b.a.b
 * JD-Core Version:    0.7.0.1
 */