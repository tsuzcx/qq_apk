package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bfy
  extends com.tencent.mm.bx.a
{
  public int ZGN;
  public int ZGO;
  public boe ZPJ;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(258287);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bS(1, this.ZGN);
      paramVarArgs.bS(2, this.ZGO);
      if (this.ZPJ != null)
      {
        paramVarArgs.qD(3, this.ZPJ.computeSize());
        this.ZPJ.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(258287);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = i.a.a.b.b.a.cJ(1, this.ZGN) + 0 + i.a.a.b.b.a.cJ(2, this.ZGO);
      paramInt = i;
      if (this.ZPJ != null) {
        paramInt = i + i.a.a.a.qC(3, this.ZPJ.computeSize());
      }
      AppMethodBeat.o(258287);
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
      AppMethodBeat.o(258287);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject = (i.a.a.a.a)paramVarArgs[0];
      bfy localbfy = (bfy)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(258287);
        return -1;
      case 1: 
        localbfy.ZGN = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(258287);
        return 0;
      case 2: 
        localbfy.ZGO = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(258287);
        return 0;
      }
      paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject = (byte[])paramVarArgs.get(paramInt);
        boe localboe = new boe();
        if ((localObject != null) && (localObject.length > 0)) {
          localboe.parseFrom((byte[])localObject);
        }
        localbfy.ZPJ = localboe;
        paramInt += 1;
      }
      AppMethodBeat.o(258287);
      return 0;
    }
    AppMethodBeat.o(258287);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bfy
 * JD-Core Version:    0.7.0.1
 */