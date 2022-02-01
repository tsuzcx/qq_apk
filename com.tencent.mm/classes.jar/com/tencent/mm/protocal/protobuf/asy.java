package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.b;

public final class asy
  extends com.tencent.mm.cd.a
{
  public int SGa;
  public int SGb;
  public int SGc;
  public int SGd;
  public int SGe;
  public int SGf;
  public int SGg;
  public b SGh;
  public int pullType;
  public int scene;
  public int zWj;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(211085);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aY(1, this.scene);
      paramVarArgs.aY(2, this.SGa);
      paramVarArgs.aY(3, this.pullType);
      paramVarArgs.aY(4, this.zWj);
      paramVarArgs.aY(5, this.SGb);
      paramVarArgs.aY(6, this.SGc);
      paramVarArgs.aY(7, this.SGd);
      paramVarArgs.aY(8, this.SGe);
      paramVarArgs.aY(9, this.SGf);
      paramVarArgs.aY(10, this.SGg);
      if (this.SGh != null) {
        paramVarArgs.c(11, this.SGh);
      }
      AppMethodBeat.o(211085);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = g.a.a.b.b.a.bM(1, this.scene) + 0 + g.a.a.b.b.a.bM(2, this.SGa) + g.a.a.b.b.a.bM(3, this.pullType) + g.a.a.b.b.a.bM(4, this.zWj) + g.a.a.b.b.a.bM(5, this.SGb) + g.a.a.b.b.a.bM(6, this.SGc) + g.a.a.b.b.a.bM(7, this.SGd) + g.a.a.b.b.a.bM(8, this.SGe) + g.a.a.b.b.a.bM(9, this.SGf) + g.a.a.b.b.a.bM(10, this.SGg);
      paramInt = i;
      if (this.SGh != null) {
        paramInt = i + g.a.a.b.b.a.b(11, this.SGh);
      }
      AppMethodBeat.o(211085);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.iUs();
        }
      }
      AppMethodBeat.o(211085);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      asy localasy = (asy)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(211085);
        return -1;
      case 1: 
        localasy.scene = locala.abFh.AK();
        AppMethodBeat.o(211085);
        return 0;
      case 2: 
        localasy.SGa = locala.abFh.AK();
        AppMethodBeat.o(211085);
        return 0;
      case 3: 
        localasy.pullType = locala.abFh.AK();
        AppMethodBeat.o(211085);
        return 0;
      case 4: 
        localasy.zWj = locala.abFh.AK();
        AppMethodBeat.o(211085);
        return 0;
      case 5: 
        localasy.SGb = locala.abFh.AK();
        AppMethodBeat.o(211085);
        return 0;
      case 6: 
        localasy.SGc = locala.abFh.AK();
        AppMethodBeat.o(211085);
        return 0;
      case 7: 
        localasy.SGd = locala.abFh.AK();
        AppMethodBeat.o(211085);
        return 0;
      case 8: 
        localasy.SGe = locala.abFh.AK();
        AppMethodBeat.o(211085);
        return 0;
      case 9: 
        localasy.SGf = locala.abFh.AK();
        AppMethodBeat.o(211085);
        return 0;
      case 10: 
        localasy.SGg = locala.abFh.AK();
        AppMethodBeat.o(211085);
        return 0;
      }
      localasy.SGh = locala.abFh.iUw();
      AppMethodBeat.o(211085);
      return 0;
    }
    AppMethodBeat.o(211085);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.asy
 * JD-Core Version:    0.7.0.1
 */