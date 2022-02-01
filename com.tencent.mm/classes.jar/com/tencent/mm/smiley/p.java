package com.tencent.mm.smiley;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class p
  extends com.tencent.mm.bx.a
{
  public int acxf;
  public d acyt;
  public int acyu;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(242840);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bS(1, this.acxf);
      if (this.acyt != null)
      {
        paramVarArgs.qD(2, this.acyt.computeSize());
        this.acyt.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(3, this.acyu);
      AppMethodBeat.o(242840);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = i.a.a.b.b.a.cJ(1, this.acxf) + 0;
      paramInt = i;
      if (this.acyt != null) {
        paramInt = i + i.a.a.a.qC(2, this.acyt.computeSize());
      }
      i = i.a.a.b.b.a.cJ(3, this.acyu);
      AppMethodBeat.o(242840);
      return paramInt + i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(242840);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject = (i.a.a.a.a)paramVarArgs[0];
      p localp = (p)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(242840);
        return -1;
      case 1: 
        localp.acxf = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(242840);
        return 0;
      case 2: 
        paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject = (byte[])paramVarArgs.get(paramInt);
          d locald = new d();
          if ((localObject != null) && (localObject.length > 0)) {
            locald.parseFrom((byte[])localObject);
          }
          localp.acyt = locald;
          paramInt += 1;
        }
        AppMethodBeat.o(242840);
        return 0;
      }
      localp.acyu = ((i.a.a.a.a)localObject).ajGk.aar();
      AppMethodBeat.o(242840);
      return 0;
    }
    AppMethodBeat.o(242840);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.smiley.p
 * JD-Core Version:    0.7.0.1
 */