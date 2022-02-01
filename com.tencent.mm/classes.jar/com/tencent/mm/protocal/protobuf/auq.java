package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public class auq
  extends com.tencent.mm.bx.a
{
  public int ZEX;
  public awt ZEY;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(257778);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bS(1, this.ZEX);
      if (this.ZEY != null)
      {
        paramVarArgs.qD(2, this.ZEY.computeSize());
        this.ZEY.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(257778);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = i.a.a.b.b.a.cJ(1, this.ZEX) + 0;
      paramInt = i;
      if (this.ZEY != null) {
        paramInt = i + i.a.a.a.qC(2, this.ZEY.computeSize());
      }
      AppMethodBeat.o(257778);
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
      AppMethodBeat.o(257778);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject = (i.a.a.a.a)paramVarArgs[0];
      auq localauq = (auq)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(257778);
        return -1;
      case 1: 
        localauq.ZEX = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(257778);
        return 0;
      }
      paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject = (byte[])paramVarArgs.get(paramInt);
        awt localawt = new awt();
        if ((localObject != null) && (localObject.length > 0)) {
          localawt.parseFrom((byte[])localObject);
        }
        localauq.ZEY = localawt;
        paramInt += 1;
      }
      AppMethodBeat.o(257778);
      return 0;
    }
    AppMethodBeat.o(257778);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.auq
 * JD-Core Version:    0.7.0.1
 */