package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dth
  extends com.tencent.mm.bw.a
{
  public String GRa;
  public boolean HYZ;
  public boolean HZa = false;
  public String MD5;
  public int Ret;
  public int xsB;
  public int xsC;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(104841);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.Ret);
      paramVarArgs.aS(2, this.xsC);
      paramVarArgs.aS(3, this.xsB);
      if (this.MD5 != null) {
        paramVarArgs.d(4, this.MD5);
      }
      paramVarArgs.bC(5, this.HYZ);
      if (this.GRa != null) {
        paramVarArgs.d(6, this.GRa);
      }
      paramVarArgs.bC(7, this.HZa);
      AppMethodBeat.o(104841);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bz(1, this.Ret) + 0 + f.a.a.b.b.a.bz(2, this.xsC) + f.a.a.b.b.a.bz(3, this.xsB);
      paramInt = i;
      if (this.MD5 != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.MD5);
      }
      i = paramInt + f.a.a.b.b.a.amF(5);
      paramInt = i;
      if (this.GRa != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.GRa);
      }
      i = f.a.a.b.b.a.amF(7);
      AppMethodBeat.o(104841);
      return paramInt + i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gCg();
        }
      }
      AppMethodBeat.o(104841);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      dth localdth = (dth)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(104841);
        return -1;
      case 1: 
        localdth.Ret = locala.OmT.zc();
        AppMethodBeat.o(104841);
        return 0;
      case 2: 
        localdth.xsC = locala.OmT.zc();
        AppMethodBeat.o(104841);
        return 0;
      case 3: 
        localdth.xsB = locala.OmT.zc();
        AppMethodBeat.o(104841);
        return 0;
      case 4: 
        localdth.MD5 = locala.OmT.readString();
        AppMethodBeat.o(104841);
        return 0;
      case 5: 
        localdth.HYZ = locala.OmT.gvY();
        AppMethodBeat.o(104841);
        return 0;
      case 6: 
        localdth.GRa = locala.OmT.readString();
        AppMethodBeat.o(104841);
        return 0;
      }
      localdth.HZa = locala.OmT.gvY();
      AppMethodBeat.o(104841);
      return 0;
    }
    AppMethodBeat.o(104841);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dth
 * JD-Core Version:    0.7.0.1
 */