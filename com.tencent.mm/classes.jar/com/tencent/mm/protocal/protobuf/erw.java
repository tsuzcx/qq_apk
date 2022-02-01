package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;
import java.util.LinkedList;

public final class erw
  extends com.tencent.mm.bx.a
{
  public int abth;
  public gol abvL;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32414);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.abvL == null)
      {
        paramVarArgs = new b("Not all required fields were included: ResData");
        AppMethodBeat.o(32414);
        throw paramVarArgs;
      }
      paramVarArgs.bS(1, this.abth);
      if (this.abvL != null)
      {
        paramVarArgs.qD(2, this.abvL.computeSize());
        this.abvL.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(32414);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = i.a.a.b.b.a.cJ(1, this.abth) + 0;
      paramInt = i;
      if (this.abvL != null) {
        paramInt = i + i.a.a.a.qC(2, this.abvL.computeSize());
      }
      AppMethodBeat.o(32414);
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
      if (this.abvL == null)
      {
        paramVarArgs = new b("Not all required fields were included: ResData");
        AppMethodBeat.o(32414);
        throw paramVarArgs;
      }
      AppMethodBeat.o(32414);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject = (i.a.a.a.a)paramVarArgs[0];
      erw localerw = (erw)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(32414);
        return -1;
      case 1: 
        localerw.abth = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(32414);
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
        localerw.abvL = localgol;
        paramInt += 1;
      }
      AppMethodBeat.o(32414);
      return 0;
    }
    AppMethodBeat.o(32414);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.erw
 * JD-Core Version:    0.7.0.1
 */