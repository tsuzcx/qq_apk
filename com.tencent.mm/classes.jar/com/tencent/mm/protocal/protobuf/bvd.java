package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bvd
  extends com.tencent.mm.bw.a
{
  public String GNI;
  public String GnN;
  public String GnO;
  public String nIJ;
  public String nJO;
  public int nJb;
  public String yxn;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(155433);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.yxn != null) {
        paramVarArgs.d(1, this.yxn);
      }
      if (this.nIJ != null) {
        paramVarArgs.d(2, this.nIJ);
      }
      paramVarArgs.aS(3, this.nJb);
      if (this.GnN != null) {
        paramVarArgs.d(4, this.GnN);
      }
      if (this.GnO != null) {
        paramVarArgs.d(5, this.GnO);
      }
      if (this.nJO != null) {
        paramVarArgs.d(6, this.nJO);
      }
      if (this.GNI != null) {
        paramVarArgs.d(7, this.GNI);
      }
      AppMethodBeat.o(155433);
      return 0;
    }
    if (paramInt == 1) {
      if (this.yxn == null) {
        break label562;
      }
    }
    label562:
    for (paramInt = f.a.a.b.b.a.e(1, this.yxn) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.nIJ != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.nIJ);
      }
      i += f.a.a.b.b.a.bz(3, this.nJb);
      paramInt = i;
      if (this.GnN != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.GnN);
      }
      i = paramInt;
      if (this.GnO != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.GnO);
      }
      paramInt = i;
      if (this.nJO != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.nJO);
      }
      i = paramInt;
      if (this.GNI != null) {
        i = paramInt + f.a.a.b.b.a.e(7, this.GNI);
      }
      AppMethodBeat.o(155433);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(155433);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        bvd localbvd = (bvd)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(155433);
          return -1;
        case 1: 
          localbvd.yxn = locala.OmT.readString();
          AppMethodBeat.o(155433);
          return 0;
        case 2: 
          localbvd.nIJ = locala.OmT.readString();
          AppMethodBeat.o(155433);
          return 0;
        case 3: 
          localbvd.nJb = locala.OmT.zc();
          AppMethodBeat.o(155433);
          return 0;
        case 4: 
          localbvd.GnN = locala.OmT.readString();
          AppMethodBeat.o(155433);
          return 0;
        case 5: 
          localbvd.GnO = locala.OmT.readString();
          AppMethodBeat.o(155433);
          return 0;
        case 6: 
          localbvd.nJO = locala.OmT.readString();
          AppMethodBeat.o(155433);
          return 0;
        }
        localbvd.GNI = locala.OmT.readString();
        AppMethodBeat.o(155433);
        return 0;
      }
      AppMethodBeat.o(155433);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bvd
 * JD-Core Version:    0.7.0.1
 */