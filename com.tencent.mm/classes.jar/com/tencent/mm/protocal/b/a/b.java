package com.tencent.mm.protocal.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class b
  extends com.tencent.mm.bw.a
{
  public LinkedList<a> DKx;
  public String bIO;
  public int id;
  public String title;
  
  public b()
  {
    AppMethodBeat.i(123717);
    this.DKx = new LinkedList();
    AppMethodBeat.o(123717);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(123718);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aR(1, this.id);
      if (this.title != null) {
        paramVarArgs.d(2, this.title);
      }
      if (this.bIO != null) {
        paramVarArgs.d(3, this.bIO);
      }
      paramVarArgs.e(4, 8, this.DKx);
      AppMethodBeat.o(123718);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.b.b.a.bx(1, this.id) + 0;
      paramInt = i;
      if (this.title != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.title);
      }
      i = paramInt;
      if (this.bIO != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.bIO);
      }
      paramInt = f.a.a.a.c(4, 8, this.DKx);
      AppMethodBeat.o(123718);
      return i + paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.DKx.clear();
      paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gfg();
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
        localb.id = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(123718);
        return 0;
      case 2: 
        localb.title = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(123718);
        return 0;
      case 3: 
        localb.bIO = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(123718);
        return 0;
      }
      paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        Object localObject2 = (byte[])paramVarArgs.get(paramInt);
        localObject1 = new a();
        localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
        for (boolean bool = true; bool; bool = ((a)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
        localb.DKx.add(localObject1);
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