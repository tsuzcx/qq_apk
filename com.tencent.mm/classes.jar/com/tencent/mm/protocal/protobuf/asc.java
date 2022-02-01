package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;
import java.util.LinkedList;

public final class asc
  extends com.tencent.mm.bx.a
{
  public int ZdC;
  public gol ZdD;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(127482);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.ZdD == null)
      {
        paramVarArgs = new b("Not all required fields were included: KeyBuf");
        AppMethodBeat.o(127482);
        throw paramVarArgs;
      }
      paramVarArgs.bS(1, this.ZdC);
      if (this.ZdD != null)
      {
        paramVarArgs.qD(3, this.ZdD.computeSize());
        this.ZdD.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(127482);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = i.a.a.b.b.a.cJ(1, this.ZdC) + 0;
      paramInt = i;
      if (this.ZdD != null) {
        paramInt = i + i.a.a.a.qC(3, this.ZdD.computeSize());
      }
      AppMethodBeat.o(127482);
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
      if (this.ZdD == null)
      {
        paramVarArgs = new b("Not all required fields were included: KeyBuf");
        AppMethodBeat.o(127482);
        throw paramVarArgs;
      }
      AppMethodBeat.o(127482);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject = (i.a.a.a.a)paramVarArgs[0];
      asc localasc = (asc)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      case 2: 
      default: 
        AppMethodBeat.o(127482);
        return -1;
      case 1: 
        localasc.ZdC = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(127482);
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
        localasc.ZdD = localgol;
        paramInt += 1;
      }
      AppMethodBeat.o(127482);
      return 0;
    }
    AppMethodBeat.o(127482);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.asc
 * JD-Core Version:    0.7.0.1
 */