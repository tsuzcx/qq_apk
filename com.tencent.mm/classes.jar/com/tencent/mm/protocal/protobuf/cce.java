package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cce
  extends com.tencent.mm.bx.a
{
  public cch aalC;
  public cyf aalD;
  public int jump_type;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(258032);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bS(1, this.jump_type);
      if (this.aalC != null)
      {
        paramVarArgs.qD(2, this.aalC.computeSize());
        this.aalC.writeFields(paramVarArgs);
      }
      if (this.aalD != null)
      {
        paramVarArgs.qD(3, this.aalD.computeSize());
        this.aalD.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(258032);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = i.a.a.b.b.a.cJ(1, this.jump_type) + 0;
      paramInt = i;
      if (this.aalC != null) {
        paramInt = i + i.a.a.a.qC(2, this.aalC.computeSize());
      }
      i = paramInt;
      if (this.aalD != null) {
        i = paramInt + i.a.a.a.qC(3, this.aalD.computeSize());
      }
      AppMethodBeat.o(258032);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(258032);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
      cce localcce = (cce)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(258032);
        return -1;
      case 1: 
        localcce.jump_type = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(258032);
        return 0;
      case 2: 
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new cch();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((cch)localObject2).parseFrom((byte[])localObject1);
          }
          localcce.aalC = ((cch)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(258032);
        return 0;
      }
      paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject1 = (byte[])paramVarArgs.get(paramInt);
        localObject2 = new cyf();
        if ((localObject1 != null) && (localObject1.length > 0)) {
          ((cyf)localObject2).parseFrom((byte[])localObject1);
        }
        localcce.aalD = ((cyf)localObject2);
        paramInt += 1;
      }
      AppMethodBeat.o(258032);
      return 0;
    }
    AppMethodBeat.o(258032);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cce
 * JD-Core Version:    0.7.0.1
 */