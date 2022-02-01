package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class cab
  extends com.tencent.mm.bw.a
{
  public String GnN;
  public String GnO;
  public int HnJ;
  public int HnK;
  public int jfV;
  public String jfW;
  public String jfX;
  public String jfY;
  public String jge;
  public String nIJ;
  public int nJA;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32348);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.nIJ != null) {
        paramVarArgs.d(1, this.nIJ);
      }
      paramVarArgs.aS(2, this.nJA);
      paramVarArgs.aS(3, this.jfV);
      if (this.jfX != null) {
        paramVarArgs.d(4, this.jfX);
      }
      if (this.jfW != null) {
        paramVarArgs.d(5, this.jfW);
      }
      if (this.jfY != null) {
        paramVarArgs.d(6, this.jfY);
      }
      paramVarArgs.aS(7, this.HnJ);
      paramVarArgs.aS(8, this.HnK);
      if (this.jge != null) {
        paramVarArgs.d(9, this.jge);
      }
      if (this.GnN != null) {
        paramVarArgs.d(10, this.GnN);
      }
      if (this.GnO != null) {
        paramVarArgs.d(11, this.GnO);
      }
      AppMethodBeat.o(32348);
      return 0;
    }
    if (paramInt == 1) {
      if (this.nIJ == null) {
        break label775;
      }
    }
    label775:
    for (paramInt = f.a.a.b.b.a.e(1, this.nIJ) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bz(2, this.nJA) + f.a.a.b.b.a.bz(3, this.jfV);
      paramInt = i;
      if (this.jfX != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.jfX);
      }
      i = paramInt;
      if (this.jfW != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.jfW);
      }
      paramInt = i;
      if (this.jfY != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.jfY);
      }
      i = paramInt + f.a.a.b.b.a.bz(7, this.HnJ) + f.a.a.b.b.a.bz(8, this.HnK);
      paramInt = i;
      if (this.jge != null) {
        paramInt = i + f.a.a.b.b.a.e(9, this.jge);
      }
      i = paramInt;
      if (this.GnN != null) {
        i = paramInt + f.a.a.b.b.a.e(10, this.GnN);
      }
      paramInt = i;
      if (this.GnO != null) {
        paramInt = i + f.a.a.b.b.a.e(11, this.GnO);
      }
      AppMethodBeat.o(32348);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(32348);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        cab localcab = (cab)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(32348);
          return -1;
        case 1: 
          localcab.nIJ = locala.OmT.readString();
          AppMethodBeat.o(32348);
          return 0;
        case 2: 
          localcab.nJA = locala.OmT.zc();
          AppMethodBeat.o(32348);
          return 0;
        case 3: 
          localcab.jfV = locala.OmT.zc();
          AppMethodBeat.o(32348);
          return 0;
        case 4: 
          localcab.jfX = locala.OmT.readString();
          AppMethodBeat.o(32348);
          return 0;
        case 5: 
          localcab.jfW = locala.OmT.readString();
          AppMethodBeat.o(32348);
          return 0;
        case 6: 
          localcab.jfY = locala.OmT.readString();
          AppMethodBeat.o(32348);
          return 0;
        case 7: 
          localcab.HnJ = locala.OmT.zc();
          AppMethodBeat.o(32348);
          return 0;
        case 8: 
          localcab.HnK = locala.OmT.zc();
          AppMethodBeat.o(32348);
          return 0;
        case 9: 
          localcab.jge = locala.OmT.readString();
          AppMethodBeat.o(32348);
          return 0;
        case 10: 
          localcab.GnN = locala.OmT.readString();
          AppMethodBeat.o(32348);
          return 0;
        }
        localcab.GnO = locala.OmT.readString();
        AppMethodBeat.o(32348);
        return 0;
      }
      AppMethodBeat.o(32348);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cab
 * JD-Core Version:    0.7.0.1
 */