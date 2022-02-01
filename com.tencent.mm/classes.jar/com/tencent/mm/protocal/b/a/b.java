package com.tencent.mm.protocal.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class b
  extends com.tencent.mm.bw.a
{
  public LinkedList<a> KBq;
  public int id;
  public String msg;
  public String title;
  
  public b()
  {
    AppMethodBeat.i(123717);
    this.KBq = new LinkedList();
    AppMethodBeat.o(123717);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(123718);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aM(1, this.id);
      if (this.title != null) {
        paramVarArgs.e(2, this.title);
      }
      if (this.msg != null) {
        paramVarArgs.e(3, this.msg);
      }
      paramVarArgs.e(4, 8, this.KBq);
      AppMethodBeat.o(123718);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = g.a.a.b.b.a.bu(1, this.id) + 0;
      paramInt = i;
      if (this.title != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.title);
      }
      i = paramInt;
      if (this.msg != null) {
        i = paramInt + g.a.a.b.b.a.f(3, this.msg);
      }
      paramInt = g.a.a.a.c(4, 8, this.KBq);
      AppMethodBeat.o(123718);
      return i + paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.KBq.clear();
      paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.hPl();
        }
      }
      AppMethodBeat.o(123718);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
      b localb = (b)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(123718);
        return -1;
      case 1: 
        localb.id = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(123718);
        return 0;
      case 2: 
        localb.title = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(123718);
        return 0;
      case 3: 
        localb.msg = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(123718);
        return 0;
      }
      paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        Object localObject2 = (byte[])paramVarArgs.get(paramInt);
        localObject1 = new a();
        localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
        for (boolean bool = true; bool; bool = ((a)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
        localb.KBq.add(localObject1);
        paramInt += 1;
      }
      AppMethodBeat.o(123718);
      return 0;
    }
    AppMethodBeat.o(123718);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.b.a.b
 * JD-Core Version:    0.7.0.1
 */