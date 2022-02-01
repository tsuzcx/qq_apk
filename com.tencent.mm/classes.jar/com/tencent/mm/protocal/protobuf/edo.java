package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class edo
  extends com.tencent.mm.bx.a
{
  public LinkedList<String> abiJ;
  public int lwJ;
  
  public edo()
  {
    AppMethodBeat.i(257321);
    this.abiJ = new LinkedList();
    AppMethodBeat.o(257321);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(257325);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bS(1, this.lwJ);
      paramVarArgs.e(2, 1, this.abiJ);
      AppMethodBeat.o(257325);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = i.a.a.b.b.a.cJ(1, this.lwJ);
      int i = i.a.a.a.c(2, 1, this.abiJ);
      AppMethodBeat.o(257325);
      return paramInt + 0 + i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.abiJ.clear();
      paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(257325);
      return 0;
    }
    if (paramInt == 3)
    {
      i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
      edo localedo = (edo)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(257325);
        return -1;
      case 1: 
        localedo.lwJ = locala.ajGk.aar();
        AppMethodBeat.o(257325);
        return 0;
      }
      localedo.abiJ.add(locala.ajGk.readString());
      AppMethodBeat.o(257325);
      return 0;
    }
    AppMethodBeat.o(257325);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.edo
 * JD-Core Version:    0.7.0.1
 */