package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cfg
  extends com.tencent.mm.bv.a
{
  public String czq;
  public long xPG;
  public long xPH;
  public long xPI;
  public LinkedList<cdy> xPJ;
  
  public cfg()
  {
    AppMethodBeat.i(73657);
    this.xPG = 0L;
    this.xPH = 0L;
    this.xPI = 0L;
    this.xPJ = new LinkedList();
    AppMethodBeat.o(73657);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(73658);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.czq != null) {
        paramVarArgs.e(1, this.czq);
      }
      paramVarArgs.am(2, this.xPG);
      paramVarArgs.am(3, this.xPH);
      paramVarArgs.am(4, this.xPI);
      paramVarArgs.e(5, 8, this.xPJ);
      AppMethodBeat.o(73658);
      return 0;
    }
    if (paramInt == 1) {
      if (this.czq == null) {
        break label494;
      }
    }
    label494:
    for (paramInt = e.a.a.b.b.a.f(1, this.czq) + 0;; paramInt = 0)
    {
      int i = e.a.a.b.b.a.p(2, this.xPG);
      int j = e.a.a.b.b.a.p(3, this.xPH);
      int k = e.a.a.b.b.a.p(4, this.xPI);
      int m = e.a.a.a.c(5, 8, this.xPJ);
      AppMethodBeat.o(73658);
      return paramInt + i + j + k + m;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.xPJ.clear();
        paramVarArgs = new e.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(73658);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        cfg localcfg = (cfg)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(73658);
          return -1;
        case 1: 
          localcfg.czq = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(73658);
          return 0;
        case 2: 
          localcfg.xPG = ((e.a.a.a.a)localObject1).CLY.sm();
          AppMethodBeat.o(73658);
          return 0;
        case 3: 
          localcfg.xPH = ((e.a.a.a.a)localObject1).CLY.sm();
          AppMethodBeat.o(73658);
          return 0;
        case 4: 
          localcfg.xPI = ((e.a.a.a.a)localObject1).CLY.sm();
          AppMethodBeat.o(73658);
          return 0;
        }
        paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new cdy();
          localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((cdy)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
          localcfg.xPJ.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(73658);
        return 0;
      }
      AppMethodBeat.o(73658);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cfg
 * JD-Core Version:    0.7.0.1
 */