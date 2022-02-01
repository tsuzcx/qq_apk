package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class agz
  extends com.tencent.mm.bw.a
{
  public int LqD;
  public LinkedList<abz> LqE;
  public String pRY;
  public String title;
  
  public agz()
  {
    AppMethodBeat.i(113996);
    this.LqE = new LinkedList();
    AppMethodBeat.o(113996);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(113997);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.title != null) {
        paramVarArgs.e(1, this.title);
      }
      if (this.pRY != null) {
        paramVarArgs.e(2, this.pRY);
      }
      paramVarArgs.aM(3, this.LqD);
      paramVarArgs.e(4, 8, this.LqE);
      AppMethodBeat.o(113997);
      return 0;
    }
    if (paramInt == 1) {
      if (this.title == null) {
        break label462;
      }
    }
    label462:
    for (paramInt = g.a.a.b.b.a.f(1, this.title) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.pRY != null) {
        i = paramInt + g.a.a.b.b.a.f(2, this.pRY);
      }
      paramInt = g.a.a.b.b.a.bu(3, this.LqD);
      int j = g.a.a.a.c(4, 8, this.LqE);
      AppMethodBeat.o(113997);
      return i + paramInt + j;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.LqE.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(113997);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        agz localagz = (agz)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(113997);
          return -1;
        case 1: 
          localagz.title = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(113997);
          return 0;
        case 2: 
          localagz.pRY = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(113997);
          return 0;
        case 3: 
          localagz.LqD = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(113997);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new abz();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((abz)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localagz.LqE.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(113997);
        return 0;
      }
      AppMethodBeat.o(113997);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.agz
 * JD-Core Version:    0.7.0.1
 */