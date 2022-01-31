package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bdi
  extends com.tencent.mm.bv.a
{
  public boolean xth;
  public String xti;
  public LinkedList<Integer> xtj;
  
  public bdi()
  {
    AppMethodBeat.i(56856);
    this.xtj = new LinkedList();
    AppMethodBeat.o(56856);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(56857);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.xth);
      if (this.xti != null) {
        paramVarArgs.e(2, this.xti);
      }
      paramVarArgs.e(3, 2, this.xtj);
      AppMethodBeat.o(56857);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = e.a.a.b.b.a.eW(1) + 1 + 0;
      paramInt = i;
      if (this.xti != null) {
        paramInt = i + e.a.a.b.b.a.f(2, this.xti);
      }
      i = e.a.a.a.c(3, 2, this.xtj);
      AppMethodBeat.o(56857);
      return paramInt + i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.xtj.clear();
      paramVarArgs = new e.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.eqQ();
        }
      }
      AppMethodBeat.o(56857);
      return 0;
    }
    if (paramInt == 3)
    {
      e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
      bdi localbdi = (bdi)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(56857);
        return -1;
      case 1: 
        localbdi.xth = locala.CLY.emu();
        AppMethodBeat.o(56857);
        return 0;
      case 2: 
        localbdi.xti = locala.CLY.readString();
        AppMethodBeat.o(56857);
        return 0;
      }
      localbdi.xtj.add(Integer.valueOf(locala.CLY.sl()));
      AppMethodBeat.o(56857);
      return 0;
    }
    AppMethodBeat.o(56857);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bdi
 * JD-Core Version:    0.7.0.1
 */