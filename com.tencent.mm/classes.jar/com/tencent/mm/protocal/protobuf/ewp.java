package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ewp
  extends com.tencent.mm.bx.a
{
  public LinkedList<ewo> abyQ;
  
  public ewp()
  {
    AppMethodBeat.i(114068);
    this.abyQ = new LinkedList();
    AppMethodBeat.o(114068);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(114069);
    if (paramInt == 0)
    {
      ((i.a.a.c.a)paramVarArgs[0]).e(1, 8, this.abyQ);
      AppMethodBeat.o(114069);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = i.a.a.a.c(1, 8, this.abyQ);
      AppMethodBeat.o(114069);
      return paramInt + 0;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.abyQ.clear();
      paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(114069);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject = (i.a.a.a.a)paramVarArgs[0];
      ewp localewp = (ewp)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(114069);
        return -1;
      }
      paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
      int i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject = (byte[])paramVarArgs.get(paramInt);
        ewo localewo = new ewo();
        if ((localObject != null) && (localObject.length > 0)) {
          localewo.parseFrom((byte[])localObject);
        }
        localewp.abyQ.add(localewo);
        paramInt += 1;
      }
      AppMethodBeat.o(114069);
      return 0;
    }
    AppMethodBeat.o(114069);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ewp
 * JD-Core Version:    0.7.0.1
 */