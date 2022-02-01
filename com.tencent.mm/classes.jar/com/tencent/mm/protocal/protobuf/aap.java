package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class aap
  extends com.tencent.mm.bx.a
{
  public long FZD;
  public long FZE;
  public LinkedList<Integer> FZF;
  public LinkedList<Integer> FZG;
  
  public aap()
  {
    AppMethodBeat.i(184493);
    this.FZF = new LinkedList();
    this.FZG = new LinkedList();
    AppMethodBeat.o(184493);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(184494);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aY(1, this.FZD);
      paramVarArgs.aY(2, this.FZE);
      paramVarArgs.e(3, 2, this.FZF);
      paramVarArgs.e(4, 2, this.FZG);
      AppMethodBeat.o(184494);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = f.a.a.b.b.a.p(1, this.FZD);
      int i = f.a.a.b.b.a.p(2, this.FZE);
      int j = f.a.a.a.c(3, 2, this.FZF);
      int k = f.a.a.a.c(4, 2, this.FZG);
      AppMethodBeat.o(184494);
      return paramInt + 0 + i + j + k;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.FZF.clear();
      this.FZG.clear();
      paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gxE();
        }
      }
      AppMethodBeat.o(184494);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      aap localaap = (aap)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(184494);
        return -1;
      case 1: 
        localaap.FZD = locala.NPN.zd();
        AppMethodBeat.o(184494);
        return 0;
      case 2: 
        localaap.FZE = locala.NPN.zd();
        AppMethodBeat.o(184494);
        return 0;
      case 3: 
        localaap.FZF.add(Integer.valueOf(locala.NPN.zc()));
        AppMethodBeat.o(184494);
        return 0;
      }
      localaap.FZG.add(Integer.valueOf(locala.NPN.zc()));
      AppMethodBeat.o(184494);
      return 0;
    }
    AppMethodBeat.o(184494);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aap
 * JD-Core Version:    0.7.0.1
 */