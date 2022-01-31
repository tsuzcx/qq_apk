package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cop
  extends com.tencent.mm.bv.a
{
  public int OpCode;
  public LinkedList<String> xXt;
  
  public cop()
  {
    AppMethodBeat.i(62587);
    this.xXt = new LinkedList();
    AppMethodBeat.o(62587);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(62588);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aO(1, this.OpCode);
      paramVarArgs.e(2, 1, this.xXt);
      AppMethodBeat.o(62588);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = e.a.a.b.b.a.bl(1, this.OpCode);
      int i = e.a.a.a.c(2, 1, this.xXt);
      AppMethodBeat.o(62588);
      return paramInt + 0 + i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.xXt.clear();
      paramVarArgs = new e.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.eqQ();
        }
      }
      AppMethodBeat.o(62588);
      return 0;
    }
    if (paramInt == 3)
    {
      e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
      cop localcop = (cop)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(62588);
        return -1;
      case 1: 
        localcop.OpCode = locala.CLY.sl();
        AppMethodBeat.o(62588);
        return 0;
      }
      localcop.xXt.add(locala.CLY.readString());
      AppMethodBeat.o(62588);
      return 0;
    }
    AppMethodBeat.o(62588);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cop
 * JD-Core Version:    0.7.0.1
 */