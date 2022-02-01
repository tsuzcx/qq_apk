package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class fs
  extends com.tencent.mm.cd.a
{
  public String RKL;
  public int RKM;
  public int RKN;
  public long RKO;
  public int RKP;
  public int idx;
  public long lqo;
  public String url;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(124388);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.RKL != null) {
        paramVarArgs.f(1, this.RKL);
      }
      paramVarArgs.bm(2, this.lqo);
      paramVarArgs.aY(3, this.idx);
      paramVarArgs.aY(4, this.RKM);
      paramVarArgs.aY(5, this.RKN);
      paramVarArgs.bm(6, this.RKO);
      paramVarArgs.aY(7, this.RKP);
      if (this.url != null) {
        paramVarArgs.f(8, this.url);
      }
      AppMethodBeat.o(124388);
      return 0;
    }
    if (paramInt == 1) {
      if (this.RKL == null) {
        break label534;
      }
    }
    label534:
    for (paramInt = g.a.a.b.b.a.g(1, this.RKL) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.p(2, this.lqo) + g.a.a.b.b.a.bM(3, this.idx) + g.a.a.b.b.a.bM(4, this.RKM) + g.a.a.b.b.a.bM(5, this.RKN) + g.a.a.b.b.a.p(6, this.RKO) + g.a.a.b.b.a.bM(7, this.RKP);
      paramInt = i;
      if (this.url != null) {
        paramInt = i + g.a.a.b.b.a.g(8, this.url);
      }
      AppMethodBeat.o(124388);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(124388);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        fs localfs = (fs)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(124388);
          return -1;
        case 1: 
          localfs.RKL = locala.abFh.readString();
          AppMethodBeat.o(124388);
          return 0;
        case 2: 
          localfs.lqo = locala.abFh.AN();
          AppMethodBeat.o(124388);
          return 0;
        case 3: 
          localfs.idx = locala.abFh.AK();
          AppMethodBeat.o(124388);
          return 0;
        case 4: 
          localfs.RKM = locala.abFh.AK();
          AppMethodBeat.o(124388);
          return 0;
        case 5: 
          localfs.RKN = locala.abFh.AK();
          AppMethodBeat.o(124388);
          return 0;
        case 6: 
          localfs.RKO = locala.abFh.AN();
          AppMethodBeat.o(124388);
          return 0;
        case 7: 
          localfs.RKP = locala.abFh.AK();
          AppMethodBeat.o(124388);
          return 0;
        }
        localfs.url = locala.abFh.readString();
        AppMethodBeat.o(124388);
        return 0;
      }
      AppMethodBeat.o(124388);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fs
 * JD-Core Version:    0.7.0.1
 */