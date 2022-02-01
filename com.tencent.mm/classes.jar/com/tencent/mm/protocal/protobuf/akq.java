package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class akq
  extends com.tencent.mm.bx.a
{
  public LinkedList<String> GjI;
  public LinkedList<String> GjJ;
  
  public akq()
  {
    AppMethodBeat.i(127490);
    this.GjI = new LinkedList();
    this.GjJ = new LinkedList();
    AppMethodBeat.o(127490);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(127491);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.e(1, 1, this.GjI);
      paramVarArgs.e(2, 1, this.GjJ);
      AppMethodBeat.o(127491);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = f.a.a.a.c(1, 1, this.GjI);
      int i = f.a.a.a.c(2, 1, this.GjJ);
      AppMethodBeat.o(127491);
      return paramInt + 0 + i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.GjI.clear();
      this.GjJ.clear();
      paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gxE();
        }
      }
      AppMethodBeat.o(127491);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      akq localakq = (akq)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(127491);
        return -1;
      case 1: 
        localakq.GjI.add(locala.NPN.readString());
        AppMethodBeat.o(127491);
        return 0;
      }
      localakq.GjJ.add(locala.NPN.readString());
      AppMethodBeat.o(127491);
      return 0;
    }
    AppMethodBeat.o(127491);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.akq
 * JD-Core Version:    0.7.0.1
 */