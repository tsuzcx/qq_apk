package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bkj
  extends com.tencent.mm.bw.a
{
  public int FJl;
  public String GNc;
  public int GXH;
  public String GXI;
  public String GXJ;
  public int Ret;
  public String Title;
  public String nIJ;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(152608);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.Ret);
      if (this.GNc != null) {
        paramVarArgs.d(2, this.GNc);
      }
      paramVarArgs.aS(3, this.FJl);
      paramVarArgs.aS(4, this.GXH);
      if (this.Title != null) {
        paramVarArgs.d(5, this.Title);
      }
      if (this.nIJ != null) {
        paramVarArgs.d(6, this.nIJ);
      }
      if (this.GXI != null) {
        paramVarArgs.d(7, this.GXI);
      }
      if (this.GXJ != null) {
        paramVarArgs.d(8, this.GXJ);
      }
      AppMethodBeat.o(152608);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bz(1, this.Ret) + 0;
      paramInt = i;
      if (this.GNc != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.GNc);
      }
      i = paramInt + f.a.a.b.b.a.bz(3, this.FJl) + f.a.a.b.b.a.bz(4, this.GXH);
      paramInt = i;
      if (this.Title != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.Title);
      }
      i = paramInt;
      if (this.nIJ != null) {
        i = paramInt + f.a.a.b.b.a.e(6, this.nIJ);
      }
      paramInt = i;
      if (this.GXI != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.GXI);
      }
      i = paramInt;
      if (this.GXJ != null) {
        i = paramInt + f.a.a.b.b.a.e(8, this.GXJ);
      }
      AppMethodBeat.o(152608);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gCg();
        }
      }
      AppMethodBeat.o(152608);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      bkj localbkj = (bkj)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(152608);
        return -1;
      case 1: 
        localbkj.Ret = locala.OmT.zc();
        AppMethodBeat.o(152608);
        return 0;
      case 2: 
        localbkj.GNc = locala.OmT.readString();
        AppMethodBeat.o(152608);
        return 0;
      case 3: 
        localbkj.FJl = locala.OmT.zc();
        AppMethodBeat.o(152608);
        return 0;
      case 4: 
        localbkj.GXH = locala.OmT.zc();
        AppMethodBeat.o(152608);
        return 0;
      case 5: 
        localbkj.Title = locala.OmT.readString();
        AppMethodBeat.o(152608);
        return 0;
      case 6: 
        localbkj.nIJ = locala.OmT.readString();
        AppMethodBeat.o(152608);
        return 0;
      case 7: 
        localbkj.GXI = locala.OmT.readString();
        AppMethodBeat.o(152608);
        return 0;
      }
      localbkj.GXJ = locala.OmT.readString();
      AppMethodBeat.o(152608);
      return 0;
    }
    AppMethodBeat.o(152608);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bkj
 * JD-Core Version:    0.7.0.1
 */