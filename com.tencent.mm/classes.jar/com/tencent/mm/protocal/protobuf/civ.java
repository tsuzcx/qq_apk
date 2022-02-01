package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class civ
  extends com.tencent.mm.bw.a
{
  public int GbY;
  public String GvL;
  public int GvM;
  public String GvN;
  public String Hvp;
  public String Hvq;
  public String nIJ;
  public String uqf;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(117887);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.GbY);
      if (this.uqf != null) {
        paramVarArgs.d(2, this.uqf);
      }
      if (this.nIJ != null) {
        paramVarArgs.d(3, this.nIJ);
      }
      if (this.GvL != null) {
        paramVarArgs.d(4, this.GvL);
      }
      paramVarArgs.aS(5, this.GvM);
      if (this.GvN != null) {
        paramVarArgs.d(6, this.GvN);
      }
      if (this.Hvp != null) {
        paramVarArgs.d(7, this.Hvp);
      }
      if (this.Hvq != null) {
        paramVarArgs.d(8, this.Hvq);
      }
      AppMethodBeat.o(117887);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bz(1, this.GbY) + 0;
      paramInt = i;
      if (this.uqf != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.uqf);
      }
      i = paramInt;
      if (this.nIJ != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.nIJ);
      }
      paramInt = i;
      if (this.GvL != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.GvL);
      }
      i = paramInt + f.a.a.b.b.a.bz(5, this.GvM);
      paramInt = i;
      if (this.GvN != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.GvN);
      }
      i = paramInt;
      if (this.Hvp != null) {
        i = paramInt + f.a.a.b.b.a.e(7, this.Hvp);
      }
      paramInt = i;
      if (this.Hvq != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.Hvq);
      }
      AppMethodBeat.o(117887);
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
      AppMethodBeat.o(117887);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      civ localciv = (civ)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(117887);
        return -1;
      case 1: 
        localciv.GbY = locala.OmT.zc();
        AppMethodBeat.o(117887);
        return 0;
      case 2: 
        localciv.uqf = locala.OmT.readString();
        AppMethodBeat.o(117887);
        return 0;
      case 3: 
        localciv.nIJ = locala.OmT.readString();
        AppMethodBeat.o(117887);
        return 0;
      case 4: 
        localciv.GvL = locala.OmT.readString();
        AppMethodBeat.o(117887);
        return 0;
      case 5: 
        localciv.GvM = locala.OmT.zc();
        AppMethodBeat.o(117887);
        return 0;
      case 6: 
        localciv.GvN = locala.OmT.readString();
        AppMethodBeat.o(117887);
        return 0;
      case 7: 
        localciv.Hvp = locala.OmT.readString();
        AppMethodBeat.o(117887);
        return 0;
      }
      localciv.Hvq = locala.OmT.readString();
      AppMethodBeat.o(117887);
      return 0;
    }
    AppMethodBeat.o(117887);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.civ
 * JD-Core Version:    0.7.0.1
 */