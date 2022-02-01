package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cai
  extends com.tencent.mm.bx.a
{
  public int aajp;
  public azp aajq;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(258528);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bS(1, this.aajp);
      if (this.aajq != null)
      {
        paramVarArgs.qD(2, this.aajq.computeSize());
        this.aajq.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(258528);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = i.a.a.b.b.a.cJ(1, this.aajp) + 0;
      paramInt = i;
      if (this.aajq != null) {
        paramInt = i + i.a.a.a.qC(2, this.aajq.computeSize());
      }
      AppMethodBeat.o(258528);
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
      AppMethodBeat.o(258528);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject = (i.a.a.a.a)paramVarArgs[0];
      cai localcai = (cai)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(258528);
        return -1;
      case 1: 
        localcai.aajp = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(258528);
        return 0;
      }
      paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject = (byte[])paramVarArgs.get(paramInt);
        azp localazp = new azp();
        if ((localObject != null) && (localObject.length > 0)) {
          localazp.parseFrom((byte[])localObject);
        }
        localcai.aajq = localazp;
        paramInt += 1;
      }
      AppMethodBeat.o(258528);
      return 0;
    }
    AppMethodBeat.o(258528);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cai
 * JD-Core Version:    0.7.0.1
 */