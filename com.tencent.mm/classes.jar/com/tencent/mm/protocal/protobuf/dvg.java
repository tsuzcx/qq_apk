package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dvg
  extends com.tencent.mm.bw.a
{
  public LinkedList<cyk> MWl;
  public LinkedList<ere> MWm;
  public String dMl;
  
  public dvg()
  {
    AppMethodBeat.i(122536);
    this.dMl = "";
    this.MWl = new LinkedList();
    this.MWm = new LinkedList();
    AppMethodBeat.o(122536);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(122537);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.dMl != null) {
        paramVarArgs.e(1, this.dMl);
      }
      paramVarArgs.e(2, 8, this.MWl);
      paramVarArgs.e(3, 8, this.MWm);
      AppMethodBeat.o(122537);
      return 0;
    }
    if (paramInt == 1) {
      if (this.dMl == null) {
        break label498;
      }
    }
    label498:
    for (paramInt = g.a.a.b.b.a.f(1, this.dMl) + 0;; paramInt = 0)
    {
      int i = g.a.a.a.c(2, 8, this.MWl);
      int j = g.a.a.a.c(3, 8, this.MWm);
      AppMethodBeat.o(122537);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.MWl.clear();
        this.MWm.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(122537);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        dvg localdvg = (dvg)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(122537);
          return -1;
        case 1: 
          localdvg.dMl = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(122537);
          return 0;
        case 2: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cyk();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cyk)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localdvg.MWl.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(122537);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new ere();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((ere)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localdvg.MWm.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(122537);
        return 0;
      }
      AppMethodBeat.o(122537);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dvg
 * JD-Core Version:    0.7.0.1
 */