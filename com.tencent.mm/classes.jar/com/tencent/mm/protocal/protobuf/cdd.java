package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class cdd
  extends com.tencent.mm.bw.a
{
  public int Edq;
  public String EvI;
  public int EvJ;
  public String EvK;
  public String FrL;
  public String FrM;
  public String ncR;
  public String thh;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(117887);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aR(1, this.Edq);
      if (this.thh != null) {
        paramVarArgs.d(2, this.thh);
      }
      if (this.ncR != null) {
        paramVarArgs.d(3, this.ncR);
      }
      if (this.EvI != null) {
        paramVarArgs.d(4, this.EvI);
      }
      paramVarArgs.aR(5, this.EvJ);
      if (this.EvK != null) {
        paramVarArgs.d(6, this.EvK);
      }
      if (this.FrL != null) {
        paramVarArgs.d(7, this.FrL);
      }
      if (this.FrM != null) {
        paramVarArgs.d(8, this.FrM);
      }
      AppMethodBeat.o(117887);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bx(1, this.Edq) + 0;
      paramInt = i;
      if (this.thh != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.thh);
      }
      i = paramInt;
      if (this.ncR != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.ncR);
      }
      paramInt = i;
      if (this.EvI != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.EvI);
      }
      i = paramInt + f.a.a.b.b.a.bx(5, this.EvJ);
      paramInt = i;
      if (this.EvK != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.EvK);
      }
      i = paramInt;
      if (this.FrL != null) {
        i = paramInt + f.a.a.b.b.a.e(7, this.FrL);
      }
      paramInt = i;
      if (this.FrM != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.FrM);
      }
      AppMethodBeat.o(117887);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gfg();
        }
      }
      AppMethodBeat.o(117887);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      cdd localcdd = (cdd)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(117887);
        return -1;
      case 1: 
        localcdd.Edq = locala.LVo.xF();
        AppMethodBeat.o(117887);
        return 0;
      case 2: 
        localcdd.thh = locala.LVo.readString();
        AppMethodBeat.o(117887);
        return 0;
      case 3: 
        localcdd.ncR = locala.LVo.readString();
        AppMethodBeat.o(117887);
        return 0;
      case 4: 
        localcdd.EvI = locala.LVo.readString();
        AppMethodBeat.o(117887);
        return 0;
      case 5: 
        localcdd.EvJ = locala.LVo.xF();
        AppMethodBeat.o(117887);
        return 0;
      case 6: 
        localcdd.EvK = locala.LVo.readString();
        AppMethodBeat.o(117887);
        return 0;
      case 7: 
        localcdd.FrL = locala.LVo.readString();
        AppMethodBeat.o(117887);
        return 0;
      }
      localcdd.FrM = locala.LVo.readString();
      AppMethodBeat.o(117887);
      return 0;
    }
    AppMethodBeat.o(117887);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cdd
 * JD-Core Version:    0.7.0.1
 */