package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class amq
  extends com.tencent.mm.bw.a
{
  public int GDY;
  public int GEL;
  public int GEM;
  public int GEN;
  public int GEO;
  public int GEP;
  public int GEQ;
  public int count;
  public int imI;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(168947);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.count);
      paramVarArgs.aS(2, this.GEL);
      paramVarArgs.aS(3, this.GEM);
      paramVarArgs.aS(4, this.GEN);
      paramVarArgs.aS(5, this.GEO);
      paramVarArgs.aS(7, this.GDY);
      paramVarArgs.aS(8, this.GEP);
      paramVarArgs.aS(9, this.imI);
      paramVarArgs.aS(10, this.GEQ);
      AppMethodBeat.o(168947);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = f.a.a.b.b.a.bz(1, this.count);
      int i = f.a.a.b.b.a.bz(2, this.GEL);
      int j = f.a.a.b.b.a.bz(3, this.GEM);
      int k = f.a.a.b.b.a.bz(4, this.GEN);
      int m = f.a.a.b.b.a.bz(5, this.GEO);
      int n = f.a.a.b.b.a.bz(7, this.GDY);
      int i1 = f.a.a.b.b.a.bz(8, this.GEP);
      int i2 = f.a.a.b.b.a.bz(9, this.imI);
      int i3 = f.a.a.b.b.a.bz(10, this.GEQ);
      AppMethodBeat.o(168947);
      return paramInt + 0 + i + j + k + m + n + i1 + i2 + i3;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gCg();
        }
      }
      AppMethodBeat.o(168947);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      amq localamq = (amq)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      case 6: 
      default: 
        AppMethodBeat.o(168947);
        return -1;
      case 1: 
        localamq.count = locala.OmT.zc();
        AppMethodBeat.o(168947);
        return 0;
      case 2: 
        localamq.GEL = locala.OmT.zc();
        AppMethodBeat.o(168947);
        return 0;
      case 3: 
        localamq.GEM = locala.OmT.zc();
        AppMethodBeat.o(168947);
        return 0;
      case 4: 
        localamq.GEN = locala.OmT.zc();
        AppMethodBeat.o(168947);
        return 0;
      case 5: 
        localamq.GEO = locala.OmT.zc();
        AppMethodBeat.o(168947);
        return 0;
      case 7: 
        localamq.GDY = locala.OmT.zc();
        AppMethodBeat.o(168947);
        return 0;
      case 8: 
        localamq.GEP = locala.OmT.zc();
        AppMethodBeat.o(168947);
        return 0;
      case 9: 
        localamq.imI = locala.OmT.zc();
        AppMethodBeat.o(168947);
        return 0;
      }
      localamq.GEQ = locala.OmT.zc();
      AppMethodBeat.o(168947);
      return 0;
    }
    AppMethodBeat.o(168947);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.amq
 * JD-Core Version:    0.7.0.1
 */