package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class cdf
  extends com.tencent.mm.bw.a
{
  public String FVO;
  public String Gtk;
  public int GxI;
  public int Hee;
  public String HpG;
  public String nIJ;
  public String nJO;
  public int qkC;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(155445);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.qkC);
      if (this.nJO != null) {
        paramVarArgs.d(2, this.nJO);
      }
      if (this.FVO != null) {
        paramVarArgs.d(3, this.FVO);
      }
      if (this.Gtk != null) {
        paramVarArgs.d(4, this.Gtk);
      }
      if (this.nIJ != null) {
        paramVarArgs.d(5, this.nIJ);
      }
      paramVarArgs.aS(6, this.Hee);
      paramVarArgs.aS(7, this.GxI);
      if (this.HpG != null) {
        paramVarArgs.d(8, this.HpG);
      }
      AppMethodBeat.o(155445);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bz(1, this.qkC) + 0;
      paramInt = i;
      if (this.nJO != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.nJO);
      }
      i = paramInt;
      if (this.FVO != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.FVO);
      }
      paramInt = i;
      if (this.Gtk != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.Gtk);
      }
      i = paramInt;
      if (this.nIJ != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.nIJ);
      }
      i = i + f.a.a.b.b.a.bz(6, this.Hee) + f.a.a.b.b.a.bz(7, this.GxI);
      paramInt = i;
      if (this.HpG != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.HpG);
      }
      AppMethodBeat.o(155445);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gCg();
        }
      }
      AppMethodBeat.o(155445);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      cdf localcdf = (cdf)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(155445);
        return -1;
      case 1: 
        localcdf.qkC = locala.OmT.zc();
        AppMethodBeat.o(155445);
        return 0;
      case 2: 
        localcdf.nJO = locala.OmT.readString();
        AppMethodBeat.o(155445);
        return 0;
      case 3: 
        localcdf.FVO = locala.OmT.readString();
        AppMethodBeat.o(155445);
        return 0;
      case 4: 
        localcdf.Gtk = locala.OmT.readString();
        AppMethodBeat.o(155445);
        return 0;
      case 5: 
        localcdf.nIJ = locala.OmT.readString();
        AppMethodBeat.o(155445);
        return 0;
      case 6: 
        localcdf.Hee = locala.OmT.zc();
        AppMethodBeat.o(155445);
        return 0;
      case 7: 
        localcdf.GxI = locala.OmT.zc();
        AppMethodBeat.o(155445);
        return 0;
      }
      localcdf.HpG = locala.OmT.readString();
      AppMethodBeat.o(155445);
      return 0;
    }
    AppMethodBeat.o(155445);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cdf
 * JD-Core Version:    0.7.0.1
 */