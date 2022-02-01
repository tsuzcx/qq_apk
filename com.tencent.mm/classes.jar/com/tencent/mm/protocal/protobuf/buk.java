package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class buk
  extends com.tencent.mm.bw.a
{
  public String GNI;
  public String GnN;
  public String GnO;
  public String nIJ;
  public String nJO;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(138178);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.nIJ != null) {
        paramVarArgs.d(1, this.nIJ);
      }
      if (this.nJO != null) {
        paramVarArgs.d(2, this.nJO);
      }
      if (this.GnN != null) {
        paramVarArgs.d(3, this.GnN);
      }
      if (this.GnO != null) {
        paramVarArgs.d(4, this.GnO);
      }
      if (this.GNI != null) {
        paramVarArgs.d(5, this.GNI);
      }
      AppMethodBeat.o(138178);
      return 0;
    }
    if (paramInt == 1) {
      if (this.nIJ == null) {
        break label454;
      }
    }
    label454:
    for (int i = f.a.a.b.b.a.e(1, this.nIJ) + 0;; i = 0)
    {
      paramInt = i;
      if (this.nJO != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.nJO);
      }
      i = paramInt;
      if (this.GnN != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.GnN);
      }
      paramInt = i;
      if (this.GnO != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.GnO);
      }
      i = paramInt;
      if (this.GNI != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.GNI);
      }
      AppMethodBeat.o(138178);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(138178);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        buk localbuk = (buk)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(138178);
          return -1;
        case 1: 
          localbuk.nIJ = locala.OmT.readString();
          AppMethodBeat.o(138178);
          return 0;
        case 2: 
          localbuk.nJO = locala.OmT.readString();
          AppMethodBeat.o(138178);
          return 0;
        case 3: 
          localbuk.GnN = locala.OmT.readString();
          AppMethodBeat.o(138178);
          return 0;
        case 4: 
          localbuk.GnO = locala.OmT.readString();
          AppMethodBeat.o(138178);
          return 0;
        }
        localbuk.GNI = locala.OmT.readString();
        AppMethodBeat.o(138178);
        return 0;
      }
      AppMethodBeat.o(138178);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.buk
 * JD-Core Version:    0.7.0.1
 */