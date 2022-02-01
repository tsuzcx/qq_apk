package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class yq
  extends com.tencent.mm.bw.a
{
  public long Esr;
  public long Ess;
  public LinkedList<Integer> Est;
  public LinkedList<Integer> Esu;
  
  public yq()
  {
    AppMethodBeat.i(184493);
    this.Est = new LinkedList();
    this.Esu = new LinkedList();
    AppMethodBeat.o(184493);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(184494);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aO(1, this.Esr);
      paramVarArgs.aO(2, this.Ess);
      paramVarArgs.e(3, 2, this.Est);
      paramVarArgs.e(4, 2, this.Esu);
      AppMethodBeat.o(184494);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = f.a.a.b.b.a.p(1, this.Esr);
      int i = f.a.a.b.b.a.p(2, this.Ess);
      int j = f.a.a.a.c(3, 2, this.Est);
      int k = f.a.a.a.c(4, 2, this.Esu);
      AppMethodBeat.o(184494);
      return paramInt + 0 + i + j + k;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.Est.clear();
      this.Esu.clear();
      paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gfg();
        }
      }
      AppMethodBeat.o(184494);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      yq localyq = (yq)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(184494);
        return -1;
      case 1: 
        localyq.Esr = locala.LVo.xG();
        AppMethodBeat.o(184494);
        return 0;
      case 2: 
        localyq.Ess = locala.LVo.xG();
        AppMethodBeat.o(184494);
        return 0;
      case 3: 
        localyq.Est.add(Integer.valueOf(locala.LVo.xF()));
        AppMethodBeat.o(184494);
        return 0;
      }
      localyq.Esu.add(Integer.valueOf(locala.LVo.xF()));
      AppMethodBeat.o(184494);
      return 0;
    }
    AppMethodBeat.o(184494);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.yq
 * JD-Core Version:    0.7.0.1
 */