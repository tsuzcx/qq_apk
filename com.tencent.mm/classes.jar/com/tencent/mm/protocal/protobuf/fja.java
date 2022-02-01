package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;
import java.util.LinkedList;

public final class fja
  extends com.tencent.mm.bx.a
{
  public long abIO;
  public gol abJS;
  public int muC;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(118463);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.abJS == null)
      {
        paramVarArgs = new b("Not all required fields were included: OpContent");
        AppMethodBeat.o(118463);
        throw paramVarArgs;
      }
      paramVarArgs.bv(1, this.abIO);
      paramVarArgs.bS(2, this.muC);
      if (this.abJS != null)
      {
        paramVarArgs.qD(3, this.abJS.computeSize());
        this.abJS.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(118463);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = i.a.a.b.b.a.q(1, this.abIO) + 0 + i.a.a.b.b.a.cJ(2, this.muC);
      paramInt = i;
      if (this.abJS != null) {
        paramInt = i + i.a.a.a.qC(3, this.abJS.computeSize());
      }
      AppMethodBeat.o(118463);
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
      if (this.abJS == null)
      {
        paramVarArgs = new b("Not all required fields were included: OpContent");
        AppMethodBeat.o(118463);
        throw paramVarArgs;
      }
      AppMethodBeat.o(118463);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject = (i.a.a.a.a)paramVarArgs[0];
      fja localfja = (fja)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(118463);
        return -1;
      case 1: 
        localfja.abIO = ((i.a.a.a.a)localObject).ajGk.aaw();
        AppMethodBeat.o(118463);
        return 0;
      case 2: 
        localfja.muC = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(118463);
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
        localfja.abJS = localgol;
        paramInt += 1;
      }
      AppMethodBeat.o(118463);
      return 0;
    }
    AppMethodBeat.o(118463);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fja
 * JD-Core Version:    0.7.0.1
 */