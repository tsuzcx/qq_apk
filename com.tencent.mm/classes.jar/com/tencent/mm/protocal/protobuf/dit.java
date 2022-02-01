package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dit
  extends com.tencent.mm.cd.a
{
  public LinkedList<diu> Ezu;
  public String iRq;
  
  public dit()
  {
    AppMethodBeat.i(239829);
    this.Ezu = new LinkedList();
    AppMethodBeat.o(239829);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(239836);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.iRq != null) {
        paramVarArgs.f(1, this.iRq);
      }
      paramVarArgs.e(2, 8, this.Ezu);
      AppMethodBeat.o(239836);
      return 0;
    }
    if (paramInt == 1) {
      if (this.iRq == null) {
        break label336;
      }
    }
    label336:
    for (paramInt = g.a.a.b.b.a.g(1, this.iRq) + 0;; paramInt = 0)
    {
      int i = g.a.a.a.c(2, 8, this.Ezu);
      AppMethodBeat.o(239836);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.Ezu.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(239836);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (g.a.a.a.a)paramVarArgs[0];
        dit localdit = (dit)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(239836);
          return -1;
        case 1: 
          localdit.iRq = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(239836);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject = (byte[])paramVarArgs.get(paramInt);
          diu localdiu = new diu();
          if ((localObject != null) && (localObject.length > 0)) {
            localdiu.parseFrom((byte[])localObject);
          }
          localdit.Ezu.add(localdiu);
          paramInt += 1;
        }
        AppMethodBeat.o(239836);
        return 0;
      }
      AppMethodBeat.o(239836);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dit
 * JD-Core Version:    0.7.0.1
 */