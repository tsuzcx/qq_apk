package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ean
  extends com.tencent.mm.bx.a
{
  public LinkedList<eam> abfP;
  
  public ean()
  {
    AppMethodBeat.i(114050);
    this.abfP = new LinkedList();
    AppMethodBeat.o(114050);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(114051);
    if (paramInt == 0)
    {
      ((i.a.a.c.a)paramVarArgs[0]).e(1, 8, this.abfP);
      AppMethodBeat.o(114051);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = i.a.a.a.c(1, 8, this.abfP);
      AppMethodBeat.o(114051);
      return paramInt + 0;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.abfP.clear();
      paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(114051);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject = (i.a.a.a.a)paramVarArgs[0];
      ean localean = (ean)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(114051);
        return -1;
      }
      paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
      int i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject = (byte[])paramVarArgs.get(paramInt);
        eam localeam = new eam();
        if ((localObject != null) && (localObject.length > 0)) {
          localeam.parseFrom((byte[])localObject);
        }
        localean.abfP.add(localeam);
        paramInt += 1;
      }
      AppMethodBeat.o(114051);
      return 0;
    }
    AppMethodBeat.o(114051);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ean
 * JD-Core Version:    0.7.0.1
 */