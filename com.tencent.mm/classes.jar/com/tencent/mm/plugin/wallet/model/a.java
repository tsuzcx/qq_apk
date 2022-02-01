package com.tencent.mm.plugin.wallet.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class a
  extends com.tencent.mm.bx.a
{
  public LinkedList<c> Vld;
  public l Vle;
  
  public a()
  {
    AppMethodBeat.i(91283);
    this.Vld = new LinkedList();
    AppMethodBeat.o(91283);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91284);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.e(1, 8, this.Vld);
      if (this.Vle != null)
      {
        paramVarArgs.qD(2, this.Vle.computeSize());
        this.Vle.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(91284);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = i.a.a.a.c(1, 8, this.Vld) + 0;
      paramInt = i;
      if (this.Vle != null) {
        paramInt = i + i.a.a.a.qC(2, this.Vle.computeSize());
      }
      AppMethodBeat.o(91284);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.Vld.clear();
      paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(91284);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
      a locala = (a)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(91284);
        return -1;
      case 1: 
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new c();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((c)localObject2).parseFrom((byte[])localObject1);
          }
          locala.Vld.add(localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(91284);
        return 0;
      }
      paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject1 = (byte[])paramVarArgs.get(paramInt);
        localObject2 = new l();
        if ((localObject1 != null) && (localObject1.length > 0)) {
          ((l)localObject2).parseFrom((byte[])localObject1);
        }
        locala.Vle = ((l)localObject2);
        paramInt += 1;
      }
      AppMethodBeat.o(91284);
      return 0;
    }
    AppMethodBeat.o(91284);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.model.a
 * JD-Core Version:    0.7.0.1
 */