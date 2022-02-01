package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class jy
  extends com.tencent.mm.bx.a
{
  public gol YMl;
  public int dataType;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(140925);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bS(1, this.dataType);
      if (this.YMl != null)
      {
        paramVarArgs.qD(2, this.YMl.computeSize());
        this.YMl.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(140925);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = i.a.a.b.b.a.cJ(1, this.dataType) + 0;
      paramInt = i;
      if (this.YMl != null) {
        paramInt = i + i.a.a.a.qC(2, this.YMl.computeSize());
      }
      AppMethodBeat.o(140925);
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
      AppMethodBeat.o(140925);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject = (i.a.a.a.a)paramVarArgs[0];
      jy localjy = (jy)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(140925);
        return -1;
      case 1: 
        localjy.dataType = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(140925);
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
        localjy.YMl = localgol;
        paramInt += 1;
      }
      AppMethodBeat.o(140925);
      return 0;
    }
    AppMethodBeat.o(140925);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.jy
 * JD-Core Version:    0.7.0.1
 */