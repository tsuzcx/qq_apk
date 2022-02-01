package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class fr
  extends com.tencent.mm.bw.a
{
  public String FQp;
  public int FQq;
  public int FQr;
  public long FQs;
  public int FQt;
  public long hGH;
  public int idx;
  public String url;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(124388);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.FQp != null) {
        paramVarArgs.d(1, this.FQp);
      }
      paramVarArgs.aZ(2, this.hGH);
      paramVarArgs.aS(3, this.idx);
      paramVarArgs.aS(4, this.FQq);
      paramVarArgs.aS(5, this.FQr);
      paramVarArgs.aZ(6, this.FQs);
      paramVarArgs.aS(7, this.FQt);
      if (this.url != null) {
        paramVarArgs.d(8, this.url);
      }
      AppMethodBeat.o(124388);
      return 0;
    }
    if (paramInt == 1) {
      if (this.FQp == null) {
        break label534;
      }
    }
    label534:
    for (paramInt = f.a.a.b.b.a.e(1, this.FQp) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.p(2, this.hGH) + f.a.a.b.b.a.bz(3, this.idx) + f.a.a.b.b.a.bz(4, this.FQq) + f.a.a.b.b.a.bz(5, this.FQr) + f.a.a.b.b.a.p(6, this.FQs) + f.a.a.b.b.a.bz(7, this.FQt);
      paramInt = i;
      if (this.url != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.url);
      }
      AppMethodBeat.o(124388);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(124388);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        fr localfr = (fr)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(124388);
          return -1;
        case 1: 
          localfr.FQp = locala.OmT.readString();
          AppMethodBeat.o(124388);
          return 0;
        case 2: 
          localfr.hGH = locala.OmT.zd();
          AppMethodBeat.o(124388);
          return 0;
        case 3: 
          localfr.idx = locala.OmT.zc();
          AppMethodBeat.o(124388);
          return 0;
        case 4: 
          localfr.FQq = locala.OmT.zc();
          AppMethodBeat.o(124388);
          return 0;
        case 5: 
          localfr.FQr = locala.OmT.zc();
          AppMethodBeat.o(124388);
          return 0;
        case 6: 
          localfr.FQs = locala.OmT.zd();
          AppMethodBeat.o(124388);
          return 0;
        case 7: 
          localfr.FQt = locala.OmT.zc();
          AppMethodBeat.o(124388);
          return 0;
        }
        localfr.url = locala.OmT.readString();
        AppMethodBeat.o(124388);
        return 0;
      }
      AppMethodBeat.o(124388);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fr
 * JD-Core Version:    0.7.0.1
 */