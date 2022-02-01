package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class djo
  extends com.tencent.mm.bw.a
{
  public long HRo;
  public int HRp;
  public int HRq;
  public String ThumbUrl;
  public String nIJ;
  public String usR;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(118434);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.nIJ != null) {
        paramVarArgs.d(1, this.nIJ);
      }
      paramVarArgs.aZ(2, this.HRo);
      paramVarArgs.aS(3, this.HRp);
      if (this.ThumbUrl != null) {
        paramVarArgs.d(4, this.ThumbUrl);
      }
      paramVarArgs.aS(5, this.HRq);
      if (this.usR != null) {
        paramVarArgs.d(6, this.usR);
      }
      AppMethodBeat.o(118434);
      return 0;
    }
    if (paramInt == 1) {
      if (this.nIJ == null) {
        break label466;
      }
    }
    label466:
    for (paramInt = f.a.a.b.b.a.e(1, this.nIJ) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.p(2, this.HRo) + f.a.a.b.b.a.bz(3, this.HRp);
      paramInt = i;
      if (this.ThumbUrl != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.ThumbUrl);
      }
      i = paramInt + f.a.a.b.b.a.bz(5, this.HRq);
      paramInt = i;
      if (this.usR != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.usR);
      }
      AppMethodBeat.o(118434);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(118434);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        djo localdjo = (djo)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(118434);
          return -1;
        case 1: 
          localdjo.nIJ = locala.OmT.readString();
          AppMethodBeat.o(118434);
          return 0;
        case 2: 
          localdjo.HRo = locala.OmT.zd();
          AppMethodBeat.o(118434);
          return 0;
        case 3: 
          localdjo.HRp = locala.OmT.zc();
          AppMethodBeat.o(118434);
          return 0;
        case 4: 
          localdjo.ThumbUrl = locala.OmT.readString();
          AppMethodBeat.o(118434);
          return 0;
        case 5: 
          localdjo.HRq = locala.OmT.zc();
          AppMethodBeat.o(118434);
          return 0;
        }
        localdjo.usR = locala.OmT.readString();
        AppMethodBeat.o(118434);
        return 0;
      }
      AppMethodBeat.o(118434);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.djo
 * JD-Core Version:    0.7.0.1
 */