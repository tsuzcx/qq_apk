package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class aty
  extends com.tencent.mm.bx.a
{
  public bbm ZEo;
  public int type;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(258119);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bS(1, this.type);
      if (this.ZEo != null)
      {
        paramVarArgs.qD(2, this.ZEo.computeSize());
        this.ZEo.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(258119);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = i.a.a.b.b.a.cJ(1, this.type) + 0;
      paramInt = i;
      if (this.ZEo != null) {
        paramInt = i + i.a.a.a.qC(2, this.ZEo.computeSize());
      }
      AppMethodBeat.o(258119);
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
      AppMethodBeat.o(258119);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject = (i.a.a.a.a)paramVarArgs[0];
      aty localaty = (aty)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(258119);
        return -1;
      case 1: 
        localaty.type = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(258119);
        return 0;
      }
      paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject = (byte[])paramVarArgs.get(paramInt);
        bbm localbbm = new bbm();
        if ((localObject != null) && (localObject.length > 0)) {
          localbbm.parseFrom((byte[])localObject);
        }
        localaty.ZEo = localbbm;
        paramInt += 1;
      }
      AppMethodBeat.o(258119);
      return 0;
    }
    AppMethodBeat.o(258119);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aty
 * JD-Core Version:    0.7.0.1
 */