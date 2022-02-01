package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ccz
  extends com.tencent.mm.bw.a
{
  public int urJ;
  public String uvF;
  public String uvG;
  public int xri;
  public long xrk;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(43113);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.uvG != null) {
        paramVarArgs.d(1, this.uvG);
      }
      if (this.uvF != null) {
        paramVarArgs.d(2, this.uvF);
      }
      paramVarArgs.aS(3, this.xri);
      paramVarArgs.aS(4, this.urJ);
      paramVarArgs.aZ(5, this.xrk);
      AppMethodBeat.o(43113);
      return 0;
    }
    if (paramInt == 1) {
      if (this.uvG == null) {
        break label410;
      }
    }
    label410:
    for (paramInt = f.a.a.b.b.a.e(1, this.uvG) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.uvF != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.uvF);
      }
      paramInt = f.a.a.b.b.a.bz(3, this.xri);
      int j = f.a.a.b.b.a.bz(4, this.urJ);
      int k = f.a.a.b.b.a.p(5, this.xrk);
      AppMethodBeat.o(43113);
      return i + paramInt + j + k;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(43113);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        ccz localccz = (ccz)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(43113);
          return -1;
        case 1: 
          localccz.uvG = locala.OmT.readString();
          AppMethodBeat.o(43113);
          return 0;
        case 2: 
          localccz.uvF = locala.OmT.readString();
          AppMethodBeat.o(43113);
          return 0;
        case 3: 
          localccz.xri = locala.OmT.zc();
          AppMethodBeat.o(43113);
          return 0;
        case 4: 
          localccz.urJ = locala.OmT.zc();
          AppMethodBeat.o(43113);
          return 0;
        }
        localccz.xrk = locala.OmT.zd();
        AppMethodBeat.o(43113);
        return 0;
      }
      AppMethodBeat.o(43113);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ccz
 * JD-Core Version:    0.7.0.1
 */