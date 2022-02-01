package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bow
  extends com.tencent.mm.cd.a
{
  public int TaH;
  public LinkedList<alf> TaI;
  public int TaJ;
  public int cUP;
  
  public bow()
  {
    AppMethodBeat.i(153145);
    this.TaI = new LinkedList();
    AppMethodBeat.o(153145);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(153146);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aY(1, this.TaH);
      paramVarArgs.e(2, 8, this.TaI);
      paramVarArgs.aY(3, this.TaJ);
      paramVarArgs.aY(4, this.cUP);
      AppMethodBeat.o(153146);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      paramInt = g.a.a.b.b.a.bM(1, this.TaH);
      i = g.a.a.a.c(2, 8, this.TaI);
      int j = g.a.a.b.b.a.bM(3, this.TaJ);
      int k = g.a.a.b.b.a.bM(4, this.cUP);
      AppMethodBeat.o(153146);
      return paramInt + 0 + i + j + k;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.TaI.clear();
      paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.iUs();
        }
      }
      AppMethodBeat.o(153146);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject = (g.a.a.a.a)paramVarArgs[0];
      bow localbow = (bow)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(153146);
        return -1;
      case 1: 
        localbow.TaH = ((g.a.a.a.a)localObject).abFh.AK();
        AppMethodBeat.o(153146);
        return 0;
      case 2: 
        paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject = (byte[])paramVarArgs.get(paramInt);
          alf localalf = new alf();
          if ((localObject != null) && (localObject.length > 0)) {
            localalf.parseFrom((byte[])localObject);
          }
          localbow.TaI.add(localalf);
          paramInt += 1;
        }
        AppMethodBeat.o(153146);
        return 0;
      case 3: 
        localbow.TaJ = ((g.a.a.a.a)localObject).abFh.AK();
        AppMethodBeat.o(153146);
        return 0;
      }
      localbow.cUP = ((g.a.a.a.a)localObject).abFh.AK();
      AppMethodBeat.o(153146);
      return 0;
    }
    AppMethodBeat.o(153146);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bow
 * JD-Core Version:    0.7.0.1
 */