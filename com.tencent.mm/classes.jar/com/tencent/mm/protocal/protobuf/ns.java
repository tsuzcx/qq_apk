package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bv.b;
import java.util.LinkedList;

public final class ns
  extends com.tencent.mm.bv.a
{
  public int wDb;
  public LinkedList<Integer> wDc;
  
  public ns()
  {
    AppMethodBeat.i(58900);
    this.wDc = new LinkedList();
    AppMethodBeat.o(58900);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(58901);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aO(1, this.wDb);
      paramVarArgs.f(2, 2, this.wDc);
      AppMethodBeat.o(58901);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = e.a.a.b.b.a.bl(1, this.wDb);
      int i = e.a.a.a.d(2, 2, this.wDc);
      AppMethodBeat.o(58901);
      return paramInt + 0 + i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.wDc.clear();
      paramVarArgs = new e.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.eqQ();
        }
      }
      AppMethodBeat.o(58901);
      return 0;
    }
    if (paramInt == 3)
    {
      e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
      ns localns = (ns)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(58901);
        return -1;
      case 1: 
        localns.wDb = locala.CLY.sl();
        AppMethodBeat.o(58901);
        return 0;
      }
      localns.wDc = new e.a.a.a.a(locala.CLY.eqS().pW, unknownTagHandler).CLY.eqR();
      AppMethodBeat.o(58901);
      return 0;
    }
    AppMethodBeat.o(58901);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ns
 * JD-Core Version:    0.7.0.1
 */