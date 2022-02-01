package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ami
  extends com.tencent.mm.bw.a
{
  public long Lvb;
  public long Lvc;
  public LinkedList<ehm> Lvd;
  
  public ami()
  {
    AppMethodBeat.i(125722);
    this.Lvd = new LinkedList();
    AppMethodBeat.o(125722);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(125723);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bb(1, this.Lvb);
      paramVarArgs.bb(2, this.Lvc);
      paramVarArgs.e(3, 8, this.Lvd);
      AppMethodBeat.o(125723);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      paramInt = g.a.a.b.b.a.r(1, this.Lvb);
      i = g.a.a.b.b.a.r(2, this.Lvc);
      int j = g.a.a.a.c(3, 8, this.Lvd);
      AppMethodBeat.o(125723);
      return paramInt + 0 + i + j;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.Lvd.clear();
      paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.hPl();
        }
      }
      AppMethodBeat.o(125723);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
      ami localami = (ami)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(125723);
        return -1;
      case 1: 
        localami.Lvb = ((g.a.a.a.a)localObject1).UbS.zl();
        AppMethodBeat.o(125723);
        return 0;
      case 2: 
        localami.Lvc = ((g.a.a.a.a)localObject1).UbS.zl();
        AppMethodBeat.o(125723);
        return 0;
      }
      paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        Object localObject2 = (byte[])paramVarArgs.get(paramInt);
        localObject1 = new ehm();
        localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
        for (boolean bool = true; bool; bool = ((ehm)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
        localami.Lvd.add(localObject1);
        paramInt += 1;
      }
      AppMethodBeat.o(125723);
      return 0;
    }
    AppMethodBeat.o(125723);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ami
 * JD-Core Version:    0.7.0.1
 */