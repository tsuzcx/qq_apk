package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class fgb
  extends com.tencent.mm.bx.a
{
  public LinkedList<Long> abFY;
  public String abFZ;
  
  public fgb()
  {
    AppMethodBeat.i(257883);
    this.abFY = new LinkedList();
    AppMethodBeat.o(257883);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(257886);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.e(1, 3, this.abFY);
      if (this.abFZ != null) {
        paramVarArgs.g(2, this.abFZ);
      }
      AppMethodBeat.o(257886);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = i.a.a.a.c(1, 3, this.abFY) + 0;
      paramInt = i;
      if (this.abFZ != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.abFZ);
      }
      AppMethodBeat.o(257886);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.abFY.clear();
      paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(257886);
      return 0;
    }
    if (paramInt == 3)
    {
      i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
      fgb localfgb = (fgb)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(257886);
        return -1;
      case 1: 
        localfgb.abFY.add(Long.valueOf(locala.ajGk.aaw()));
        AppMethodBeat.o(257886);
        return 0;
      }
      localfgb.abFZ = locala.ajGk.readString();
      AppMethodBeat.o(257886);
      return 0;
    }
    AppMethodBeat.o(257886);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fgb
 * JD-Core Version:    0.7.0.1
 */