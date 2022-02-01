package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class crc
  extends com.tencent.mm.bw.a
{
  public String GNI;
  public String Gzj;
  public int HCr;
  public String SmallImgUrl;
  public String nIJ;
  public String nJO;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(127295);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.nIJ != null) {
        paramVarArgs.d(1, this.nIJ);
      }
      paramVarArgs.aS(2, this.HCr);
      if (this.nJO != null) {
        paramVarArgs.d(3, this.nJO);
      }
      if (this.SmallImgUrl != null) {
        paramVarArgs.d(4, this.SmallImgUrl);
      }
      if (this.Gzj != null) {
        paramVarArgs.d(5, this.Gzj);
      }
      if (this.GNI != null) {
        paramVarArgs.d(6, this.GNI);
      }
      AppMethodBeat.o(127295);
      return 0;
    }
    if (paramInt == 1) {
      if (this.nIJ == null) {
        break label502;
      }
    }
    label502:
    for (paramInt = f.a.a.b.b.a.e(1, this.nIJ) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bz(2, this.HCr);
      paramInt = i;
      if (this.nJO != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.nJO);
      }
      i = paramInt;
      if (this.SmallImgUrl != null) {
        i = paramInt + f.a.a.b.b.a.e(4, this.SmallImgUrl);
      }
      paramInt = i;
      if (this.Gzj != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.Gzj);
      }
      i = paramInt;
      if (this.GNI != null) {
        i = paramInt + f.a.a.b.b.a.e(6, this.GNI);
      }
      AppMethodBeat.o(127295);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(127295);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        crc localcrc = (crc)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(127295);
          return -1;
        case 1: 
          localcrc.nIJ = locala.OmT.readString();
          AppMethodBeat.o(127295);
          return 0;
        case 2: 
          localcrc.HCr = locala.OmT.zc();
          AppMethodBeat.o(127295);
          return 0;
        case 3: 
          localcrc.nJO = locala.OmT.readString();
          AppMethodBeat.o(127295);
          return 0;
        case 4: 
          localcrc.SmallImgUrl = locala.OmT.readString();
          AppMethodBeat.o(127295);
          return 0;
        case 5: 
          localcrc.Gzj = locala.OmT.readString();
          AppMethodBeat.o(127295);
          return 0;
        }
        localcrc.GNI = locala.OmT.readString();
        AppMethodBeat.o(127295);
        return 0;
      }
      AppMethodBeat.o(127295);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.crc
 * JD-Core Version:    0.7.0.1
 */