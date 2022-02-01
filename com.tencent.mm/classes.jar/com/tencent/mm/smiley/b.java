package com.tencent.mm.smiley;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class b
  extends com.tencent.mm.bx.a
{
  public LinkedList<Integer> acwM;
  public q acwN;
  
  public b()
  {
    AppMethodBeat.i(242849);
    this.acwM = new LinkedList();
    AppMethodBeat.o(242849);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(242859);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.e(1, 2, this.acwM);
      if (this.acwN != null)
      {
        paramVarArgs.qD(2, this.acwN.computeSize());
        this.acwN.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(242859);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = i.a.a.a.c(1, 2, this.acwM) + 0;
      paramInt = i;
      if (this.acwN != null) {
        paramInt = i + i.a.a.a.qC(2, this.acwN.computeSize());
      }
      AppMethodBeat.o(242859);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.acwM.clear();
      paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(242859);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject = (i.a.a.a.a)paramVarArgs[0];
      b localb = (b)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(242859);
        return -1;
      case 1: 
        localb.acwM.add(Integer.valueOf(((i.a.a.a.a)localObject).ajGk.aar()));
        AppMethodBeat.o(242859);
        return 0;
      }
      paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject = (byte[])paramVarArgs.get(paramInt);
        q localq = new q();
        if ((localObject != null) && (localObject.length > 0)) {
          localq.parseFrom((byte[])localObject);
        }
        localb.acwN = localq;
        paramInt += 1;
      }
      AppMethodBeat.o(242859);
      return 0;
    }
    AppMethodBeat.o(242859);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.smiley.b
 * JD-Core Version:    0.7.0.1
 */