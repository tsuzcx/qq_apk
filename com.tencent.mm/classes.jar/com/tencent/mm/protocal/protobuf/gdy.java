package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class gdy
  extends com.tencent.mm.bx.a
{
  public int acbD;
  public gef acbE;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(260156);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bS(1, this.acbD);
      if (this.acbE != null)
      {
        paramVarArgs.qD(2, this.acbE.computeSize());
        this.acbE.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(260156);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = i.a.a.b.b.a.cJ(1, this.acbD) + 0;
      paramInt = i;
      if (this.acbE != null) {
        paramInt = i + i.a.a.a.qC(2, this.acbE.computeSize());
      }
      AppMethodBeat.o(260156);
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
      AppMethodBeat.o(260156);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject = (i.a.a.a.a)paramVarArgs[0];
      gdy localgdy = (gdy)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(260156);
        return -1;
      case 1: 
        localgdy.acbD = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(260156);
        return 0;
      }
      paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject = (byte[])paramVarArgs.get(paramInt);
        gef localgef = new gef();
        if ((localObject != null) && (localObject.length > 0)) {
          localgef.parseFrom((byte[])localObject);
        }
        localgdy.acbE = localgef;
        paramInt += 1;
      }
      AppMethodBeat.o(260156);
      return 0;
    }
    AppMethodBeat.o(260156);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.gdy
 * JD-Core Version:    0.7.0.1
 */