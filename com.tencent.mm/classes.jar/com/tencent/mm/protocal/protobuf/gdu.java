package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class gdu
  extends com.tencent.mm.bx.a
{
  public int DnR;
  public gdw acbA;
  public gdv acbz;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(260097);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bS(1, this.DnR);
      if (this.acbz != null)
      {
        paramVarArgs.qD(2, this.acbz.computeSize());
        this.acbz.writeFields(paramVarArgs);
      }
      if (this.acbA != null)
      {
        paramVarArgs.qD(3, this.acbA.computeSize());
        this.acbA.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(260097);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = i.a.a.b.b.a.cJ(1, this.DnR) + 0;
      paramInt = i;
      if (this.acbz != null) {
        paramInt = i + i.a.a.a.qC(2, this.acbz.computeSize());
      }
      i = paramInt;
      if (this.acbA != null) {
        i = paramInt + i.a.a.a.qC(3, this.acbA.computeSize());
      }
      AppMethodBeat.o(260097);
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
      AppMethodBeat.o(260097);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
      gdu localgdu = (gdu)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(260097);
        return -1;
      case 1: 
        localgdu.DnR = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(260097);
        return 0;
      case 2: 
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new gdv();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((gdv)localObject2).parseFrom((byte[])localObject1);
          }
          localgdu.acbz = ((gdv)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(260097);
        return 0;
      }
      paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject1 = (byte[])paramVarArgs.get(paramInt);
        localObject2 = new gdw();
        if ((localObject1 != null) && (localObject1.length > 0)) {
          ((gdw)localObject2).parseFrom((byte[])localObject1);
        }
        localgdu.acbA = ((gdw)localObject2);
        paramInt += 1;
      }
      AppMethodBeat.o(260097);
      return 0;
    }
    AppMethodBeat.o(260097);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.gdu
 * JD-Core Version:    0.7.0.1
 */