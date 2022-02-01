package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class elt
  extends com.tencent.mm.bx.a
{
  public LinkedList<elu> abql;
  public int count;
  public int fZW;
  
  public elt()
  {
    AppMethodBeat.i(32400);
    this.abql = new LinkedList();
    AppMethodBeat.o(32400);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32401);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bS(1, this.count);
      paramVarArgs.e(2, 8, this.abql);
      paramVarArgs.bS(3, this.fZW);
      AppMethodBeat.o(32401);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      paramInt = i.a.a.b.b.a.cJ(1, this.count);
      i = i.a.a.a.c(2, 8, this.abql);
      int j = i.a.a.b.b.a.cJ(3, this.fZW);
      AppMethodBeat.o(32401);
      return paramInt + 0 + i + j;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.abql.clear();
      paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(32401);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject = (i.a.a.a.a)paramVarArgs[0];
      elt localelt = (elt)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(32401);
        return -1;
      case 1: 
        localelt.count = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(32401);
        return 0;
      case 2: 
        paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject = (byte[])paramVarArgs.get(paramInt);
          elu localelu = new elu();
          if ((localObject != null) && (localObject.length > 0)) {
            localelu.parseFrom((byte[])localObject);
          }
          localelt.abql.add(localelu);
          paramInt += 1;
        }
        AppMethodBeat.o(32401);
        return 0;
      }
      localelt.fZW = ((i.a.a.a.a)localObject).ajGk.aar();
      AppMethodBeat.o(32401);
      return 0;
    }
    AppMethodBeat.o(32401);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.elt
 * JD-Core Version:    0.7.0.1
 */