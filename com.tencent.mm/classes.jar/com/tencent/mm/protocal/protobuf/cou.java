package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.b;

public final class cou
  extends com.tencent.mm.cd.a
{
  public int TwG;
  public int TwH;
  public int Twy;
  public b Twz;
  public int rVx;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(116337);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aY(1, this.Twy);
      if (this.Twz != null) {
        paramVarArgs.c(2, this.Twz);
      }
      paramVarArgs.aY(3, this.TwG);
      paramVarArgs.aY(4, this.rVx);
      paramVarArgs.aY(5, this.TwH);
      AppMethodBeat.o(116337);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = g.a.a.b.b.a.bM(1, this.Twy) + 0;
      paramInt = i;
      if (this.Twz != null) {
        paramInt = i + g.a.a.b.b.a.b(2, this.Twz);
      }
      i = g.a.a.b.b.a.bM(3, this.TwG);
      int j = g.a.a.b.b.a.bM(4, this.rVx);
      int k = g.a.a.b.b.a.bM(5, this.TwH);
      AppMethodBeat.o(116337);
      return paramInt + i + j + k;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.iUs();
        }
      }
      AppMethodBeat.o(116337);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      cou localcou = (cou)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(116337);
        return -1;
      case 1: 
        localcou.Twy = locala.abFh.AK();
        AppMethodBeat.o(116337);
        return 0;
      case 2: 
        localcou.Twz = locala.abFh.iUw();
        AppMethodBeat.o(116337);
        return 0;
      case 3: 
        localcou.TwG = locala.abFh.AK();
        AppMethodBeat.o(116337);
        return 0;
      case 4: 
        localcou.rVx = locala.abFh.AK();
        AppMethodBeat.o(116337);
        return 0;
      }
      localcou.TwH = locala.abFh.AK();
      AppMethodBeat.o(116337);
      return 0;
    }
    AppMethodBeat.o(116337);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cou
 * JD-Core Version:    0.7.0.1
 */