package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class czq
  extends com.tencent.mm.bx.a
{
  public int aaEW;
  public LinkedList<drb> aaEX;
  public int aaEY;
  
  public czq()
  {
    AppMethodBeat.i(143977);
    this.aaEX = new LinkedList();
    AppMethodBeat.o(143977);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(143978);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bS(1, this.aaEW);
      paramVarArgs.e(2, 8, this.aaEX);
      paramVarArgs.bS(3, this.aaEY);
      AppMethodBeat.o(143978);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      paramInt = i.a.a.b.b.a.cJ(1, this.aaEW);
      i = i.a.a.a.c(2, 8, this.aaEX);
      int j = i.a.a.b.b.a.cJ(3, this.aaEY);
      AppMethodBeat.o(143978);
      return paramInt + 0 + i + j;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.aaEX.clear();
      paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(143978);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject = (i.a.a.a.a)paramVarArgs[0];
      czq localczq = (czq)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(143978);
        return -1;
      case 1: 
        localczq.aaEW = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(143978);
        return 0;
      case 2: 
        paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject = (byte[])paramVarArgs.get(paramInt);
          drb localdrb = new drb();
          if ((localObject != null) && (localObject.length > 0)) {
            localdrb.parseFrom((byte[])localObject);
          }
          localczq.aaEX.add(localdrb);
          paramInt += 1;
        }
        AppMethodBeat.o(143978);
        return 0;
      }
      localczq.aaEY = ((i.a.a.a.a)localObject).ajGk.aar();
      AppMethodBeat.o(143978);
      return 0;
    }
    AppMethodBeat.o(143978);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.czq
 * JD-Core Version:    0.7.0.1
 */