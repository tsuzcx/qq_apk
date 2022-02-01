package com.tencent.mm.smiley;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class i
  extends com.tencent.mm.bx.a
{
  public LinkedList<b> acxC;
  public LinkedList<v> acxD;
  public LinkedList<p> acxE;
  
  public i()
  {
    AppMethodBeat.i(242832);
    this.acxC = new LinkedList();
    this.acxD = new LinkedList();
    this.acxE = new LinkedList();
    AppMethodBeat.o(242832);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(242835);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.e(1, 8, this.acxC);
      paramVarArgs.e(2, 8, this.acxD);
      paramVarArgs.e(3, 8, this.acxE);
      AppMethodBeat.o(242835);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      paramInt = i.a.a.a.c(1, 8, this.acxC);
      i = i.a.a.a.c(2, 8, this.acxD);
      int j = i.a.a.a.c(3, 8, this.acxE);
      AppMethodBeat.o(242835);
      return paramInt + 0 + i + j;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.acxC.clear();
      this.acxD.clear();
      this.acxE.clear();
      paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(242835);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
      i locali = (i)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(242835);
        return -1;
      case 1: 
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new b();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((b)localObject2).parseFrom((byte[])localObject1);
          }
          locali.acxC.add(localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(242835);
        return 0;
      case 2: 
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new v();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((v)localObject2).parseFrom((byte[])localObject1);
          }
          locali.acxD.add(localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(242835);
        return 0;
      }
      paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject1 = (byte[])paramVarArgs.get(paramInt);
        localObject2 = new p();
        if ((localObject1 != null) && (localObject1.length > 0)) {
          ((p)localObject2).parseFrom((byte[])localObject1);
        }
        locali.acxE.add(localObject2);
        paramInt += 1;
      }
      AppMethodBeat.o(242835);
      return 0;
    }
    AppMethodBeat.o(242835);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.smiley.i
 * JD-Core Version:    0.7.0.1
 */