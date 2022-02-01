package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class acx
  extends com.tencent.mm.bw.a
{
  public String KBt;
  public long Lnw;
  public int Loj;
  public LinkedList<acw> Lok;
  
  public acx()
  {
    AppMethodBeat.i(186798);
    this.Lok = new LinkedList();
    AppMethodBeat.o(186798);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(186799);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bb(1, this.Lnw);
      if (this.KBt != null) {
        paramVarArgs.e(2, this.KBt);
      }
      paramVarArgs.aM(3, this.Loj);
      paramVarArgs.e(4, 8, this.Lok);
      AppMethodBeat.o(186799);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = g.a.a.b.b.a.r(1, this.Lnw) + 0;
      paramInt = i;
      if (this.KBt != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.KBt);
      }
      i = g.a.a.b.b.a.bu(3, this.Loj);
      int j = g.a.a.a.c(4, 8, this.Lok);
      AppMethodBeat.o(186799);
      return paramInt + i + j;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.Lok.clear();
      paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.hPl();
        }
      }
      AppMethodBeat.o(186799);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
      acx localacx = (acx)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(186799);
        return -1;
      case 1: 
        localacx.Lnw = ((g.a.a.a.a)localObject1).UbS.zl();
        AppMethodBeat.o(186799);
        return 0;
      case 2: 
        localacx.KBt = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(186799);
        return 0;
      case 3: 
        localacx.Loj = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(186799);
        return 0;
      }
      paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        Object localObject2 = (byte[])paramVarArgs.get(paramInt);
        localObject1 = new acw();
        localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
        for (boolean bool = true; bool; bool = ((acw)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
        localacx.Lok.add(localObject1);
        paramInt += 1;
      }
      AppMethodBeat.o(186799);
      return 0;
    }
    AppMethodBeat.o(186799);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.acx
 * JD-Core Version:    0.7.0.1
 */