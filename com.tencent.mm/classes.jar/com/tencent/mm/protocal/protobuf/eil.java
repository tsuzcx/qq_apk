package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;
import java.util.LinkedList;

public final class eil
  extends com.tencent.mm.bx.a
{
  public gol YKf;
  public int Zsz;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(258613);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.YKf == null)
      {
        paramVarArgs = new b("Not all required fields were included: Key");
        AppMethodBeat.o(258613);
        throw paramVarArgs;
      }
      paramVarArgs.bS(1, this.Zsz);
      if (this.YKf != null)
      {
        paramVarArgs.qD(2, this.YKf.computeSize());
        this.YKf.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(258613);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = i.a.a.b.b.a.cJ(1, this.Zsz) + 0;
      paramInt = i;
      if (this.YKf != null) {
        paramInt = i + i.a.a.a.qC(2, this.YKf.computeSize());
      }
      AppMethodBeat.o(258613);
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
      if (this.YKf == null)
      {
        paramVarArgs = new b("Not all required fields were included: Key");
        AppMethodBeat.o(258613);
        throw paramVarArgs;
      }
      AppMethodBeat.o(258613);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject = (i.a.a.a.a)paramVarArgs[0];
      eil localeil = (eil)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(258613);
        return -1;
      case 1: 
        localeil.Zsz = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(258613);
        return 0;
      }
      paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject = (byte[])paramVarArgs.get(paramInt);
        gol localgol = new gol();
        if ((localObject != null) && (localObject.length > 0)) {
          localgol.dg((byte[])localObject);
        }
        localeil.YKf = localgol;
        paramInt += 1;
      }
      AppMethodBeat.o(258613);
      return 0;
    }
    AppMethodBeat.o(258613);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.eil
 * JD-Core Version:    0.7.0.1
 */