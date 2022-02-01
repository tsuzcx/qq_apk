package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class rc
  extends com.tencent.mm.bx.a
{
  public boolean YVV;
  public LinkedList<Integer> YVW;
  
  public rc()
  {
    AppMethodBeat.i(257367);
    this.YVW = new LinkedList();
    AppMethodBeat.o(257367);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(257372);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.di(1, this.YVV);
      paramVarArgs.e(2, 2, this.YVW);
      AppMethodBeat.o(257372);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = i.a.a.b.b.a.ko(1);
      int i = i.a.a.a.c(2, 2, this.YVW);
      AppMethodBeat.o(257372);
      return paramInt + 1 + 0 + i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.YVW.clear();
      paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(257372);
      return 0;
    }
    if (paramInt == 3)
    {
      i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
      rc localrc = (rc)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(257372);
        return -1;
      case 1: 
        localrc.YVV = locala.ajGk.aai();
        AppMethodBeat.o(257372);
        return 0;
      }
      localrc.YVW.add(Integer.valueOf(locala.ajGk.aar()));
      AppMethodBeat.o(257372);
      return 0;
    }
    AppMethodBeat.o(257372);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.rc
 * JD-Core Version:    0.7.0.1
 */