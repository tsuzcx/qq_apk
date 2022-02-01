package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class fb
  extends com.tencent.mm.bw.a
{
  public boolean FPA;
  public boolean FPB;
  public boolean FPs;
  public boolean FPt;
  public int FPu;
  public int FPv;
  public int FPw;
  public int FPx;
  public int FPy;
  public boolean FPz;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(124386);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bC(1, this.FPs);
      paramVarArgs.bC(2, this.FPt);
      paramVarArgs.aS(3, this.FPu);
      paramVarArgs.aS(4, this.FPv);
      paramVarArgs.aS(5, this.FPw);
      paramVarArgs.aS(6, this.FPx);
      paramVarArgs.aS(7, this.FPy);
      paramVarArgs.bC(8, this.FPz);
      paramVarArgs.bC(9, this.FPA);
      paramVarArgs.bC(10, this.FPB);
      AppMethodBeat.o(124386);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = f.a.a.b.b.a.amF(1);
      int i = f.a.a.b.b.a.amF(2);
      int j = f.a.a.b.b.a.bz(3, this.FPu);
      int k = f.a.a.b.b.a.bz(4, this.FPv);
      int m = f.a.a.b.b.a.bz(5, this.FPw);
      int n = f.a.a.b.b.a.bz(6, this.FPx);
      int i1 = f.a.a.b.b.a.bz(7, this.FPy);
      int i2 = f.a.a.b.b.a.amF(8);
      int i3 = f.a.a.b.b.a.amF(9);
      int i4 = f.a.a.b.b.a.amF(10);
      AppMethodBeat.o(124386);
      return paramInt + 0 + i + j + k + m + n + i1 + i2 + i3 + i4;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gCg();
        }
      }
      AppMethodBeat.o(124386);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      fb localfb = (fb)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(124386);
        return -1;
      case 1: 
        localfb.FPs = locala.OmT.gvY();
        AppMethodBeat.o(124386);
        return 0;
      case 2: 
        localfb.FPt = locala.OmT.gvY();
        AppMethodBeat.o(124386);
        return 0;
      case 3: 
        localfb.FPu = locala.OmT.zc();
        AppMethodBeat.o(124386);
        return 0;
      case 4: 
        localfb.FPv = locala.OmT.zc();
        AppMethodBeat.o(124386);
        return 0;
      case 5: 
        localfb.FPw = locala.OmT.zc();
        AppMethodBeat.o(124386);
        return 0;
      case 6: 
        localfb.FPx = locala.OmT.zc();
        AppMethodBeat.o(124386);
        return 0;
      case 7: 
        localfb.FPy = locala.OmT.zc();
        AppMethodBeat.o(124386);
        return 0;
      case 8: 
        localfb.FPz = locala.OmT.gvY();
        AppMethodBeat.o(124386);
        return 0;
      case 9: 
        localfb.FPA = locala.OmT.gvY();
        AppMethodBeat.o(124386);
        return 0;
      }
      localfb.FPB = locala.OmT.gvY();
      AppMethodBeat.o(124386);
      return 0;
    }
    AppMethodBeat.o(124386);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fb
 * JD-Core Version:    0.7.0.1
 */