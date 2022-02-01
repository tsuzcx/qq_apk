package com.tencent.mm.protocal.protobuf.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class n
  extends com.tencent.mm.bx.a
{
  public int YYs;
  public aa aciQ;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(259689);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bS(1, this.YYs);
      if (this.aciQ != null)
      {
        paramVarArgs.qD(2, this.aciQ.computeSize());
        this.aciQ.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(259689);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = i.a.a.b.b.a.cJ(1, this.YYs) + 0;
      paramInt = i;
      if (this.aciQ != null) {
        paramInt = i + i.a.a.a.qC(2, this.aciQ.computeSize());
      }
      AppMethodBeat.o(259689);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(259689);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject = (i.a.a.a.a)paramVarArgs[0];
      n localn = (n)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(259689);
        return -1;
      case 1: 
        localn.YYs = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(259689);
        return 0;
      }
      paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject = (byte[])paramVarArgs.get(paramInt);
        aa localaa = new aa();
        if ((localObject != null) && (localObject.length > 0)) {
          localaa.parseFrom((byte[])localObject);
        }
        localn.aciQ = localaa;
        paramInt += 1;
      }
      AppMethodBeat.o(259689);
      return 0;
    }
    AppMethodBeat.o(259689);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.a.n
 * JD-Core Version:    0.7.0.1
 */