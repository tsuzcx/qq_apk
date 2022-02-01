package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dcz
  extends com.tencent.mm.cd.a
{
  public String SQm;
  public long TKL;
  public int TKM;
  public int TKN;
  public String TKO;
  public long klE;
  public int liveStatus;
  public long object_id;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(203747);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bm(1, this.klE);
      paramVarArgs.bm(2, this.object_id);
      if (this.SQm != null) {
        paramVarArgs.f(3, this.SQm);
      }
      paramVarArgs.bm(4, this.TKL);
      paramVarArgs.aY(5, this.TKM);
      paramVarArgs.aY(6, this.TKN);
      paramVarArgs.aY(7, this.liveStatus);
      if (this.TKO != null) {
        paramVarArgs.f(8, this.TKO);
      }
      AppMethodBeat.o(203747);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = g.a.a.b.b.a.p(1, this.klE) + 0 + g.a.a.b.b.a.p(2, this.object_id);
      paramInt = i;
      if (this.SQm != null) {
        paramInt = i + g.a.a.b.b.a.g(3, this.SQm);
      }
      i = paramInt + g.a.a.b.b.a.p(4, this.TKL) + g.a.a.b.b.a.bM(5, this.TKM) + g.a.a.b.b.a.bM(6, this.TKN) + g.a.a.b.b.a.bM(7, this.liveStatus);
      paramInt = i;
      if (this.TKO != null) {
        paramInt = i + g.a.a.b.b.a.g(8, this.TKO);
      }
      AppMethodBeat.o(203747);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.iUs();
        }
      }
      AppMethodBeat.o(203747);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      dcz localdcz = (dcz)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(203747);
        return -1;
      case 1: 
        localdcz.klE = locala.abFh.AN();
        AppMethodBeat.o(203747);
        return 0;
      case 2: 
        localdcz.object_id = locala.abFh.AN();
        AppMethodBeat.o(203747);
        return 0;
      case 3: 
        localdcz.SQm = locala.abFh.readString();
        AppMethodBeat.o(203747);
        return 0;
      case 4: 
        localdcz.TKL = locala.abFh.AN();
        AppMethodBeat.o(203747);
        return 0;
      case 5: 
        localdcz.TKM = locala.abFh.AK();
        AppMethodBeat.o(203747);
        return 0;
      case 6: 
        localdcz.TKN = locala.abFh.AK();
        AppMethodBeat.o(203747);
        return 0;
      case 7: 
        localdcz.liveStatus = locala.abFh.AK();
        AppMethodBeat.o(203747);
        return 0;
      }
      localdcz.TKO = locala.abFh.readString();
      AppMethodBeat.o(203747);
      return 0;
    }
    AppMethodBeat.o(203747);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dcz
 * JD-Core Version:    0.7.0.1
 */