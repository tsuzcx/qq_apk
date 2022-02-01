package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cca
  extends com.tencent.mm.bx.a
{
  public int aalp;
  public int aalq;
  public LinkedList<ahu> aalr;
  
  public cca()
  {
    AppMethodBeat.i(257989);
    this.aalr = new LinkedList();
    AppMethodBeat.o(257989);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(257994);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bS(1, this.aalp);
      paramVarArgs.bS(2, this.aalq);
      paramVarArgs.e(3, 8, this.aalr);
      AppMethodBeat.o(257994);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      paramInt = i.a.a.b.b.a.cJ(1, this.aalp);
      i = i.a.a.b.b.a.cJ(2, this.aalq);
      int j = i.a.a.a.c(3, 8, this.aalr);
      AppMethodBeat.o(257994);
      return paramInt + 0 + i + j;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.aalr.clear();
      paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(257994);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject = (i.a.a.a.a)paramVarArgs[0];
      cca localcca = (cca)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(257994);
        return -1;
      case 1: 
        localcca.aalp = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(257994);
        return 0;
      case 2: 
        localcca.aalq = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(257994);
        return 0;
      }
      paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject = (byte[])paramVarArgs.get(paramInt);
        ahu localahu = new ahu();
        if ((localObject != null) && (localObject.length > 0)) {
          localahu.parseFrom((byte[])localObject);
        }
        localcca.aalr.add(localahu);
        paramInt += 1;
      }
      AppMethodBeat.o(257994);
      return 0;
    }
    AppMethodBeat.o(257994);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cca
 * JD-Core Version:    0.7.0.1
 */