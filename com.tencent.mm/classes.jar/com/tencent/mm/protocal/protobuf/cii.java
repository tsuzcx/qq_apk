package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class cii
  extends com.tencent.mm.bw.a
{
  public int Fwr;
  public int Fws;
  public int Fwt;
  public int pAG;
  public String pAH;
  public int tIL;
  public String tIM;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32392);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aR(1, this.Fws);
      paramVarArgs.aR(2, this.Fwt);
      paramVarArgs.aR(3, this.Fwr);
      paramVarArgs.aR(4, this.pAG);
      if (this.pAH != null) {
        paramVarArgs.d(5, this.pAH);
      }
      paramVarArgs.aR(6, this.tIL);
      if (this.tIM != null) {
        paramVarArgs.d(7, this.tIM);
      }
      AppMethodBeat.o(32392);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bx(1, this.Fws) + 0 + f.a.a.b.b.a.bx(2, this.Fwt) + f.a.a.b.b.a.bx(3, this.Fwr) + f.a.a.b.b.a.bx(4, this.pAG);
      paramInt = i;
      if (this.pAH != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.pAH);
      }
      i = paramInt + f.a.a.b.b.a.bx(6, this.tIL);
      paramInt = i;
      if (this.tIM != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.tIM);
      }
      AppMethodBeat.o(32392);
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
      AppMethodBeat.o(32392);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      cii localcii = (cii)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(32392);
        return -1;
      case 1: 
        localcii.Fws = locala.LVo.xF();
        AppMethodBeat.o(32392);
        return 0;
      case 2: 
        localcii.Fwt = locala.LVo.xF();
        AppMethodBeat.o(32392);
        return 0;
      case 3: 
        localcii.Fwr = locala.LVo.xF();
        AppMethodBeat.o(32392);
        return 0;
      case 4: 
        localcii.pAG = locala.LVo.xF();
        AppMethodBeat.o(32392);
        return 0;
      case 5: 
        localcii.pAH = locala.LVo.readString();
        AppMethodBeat.o(32392);
        return 0;
      case 6: 
        localcii.tIL = locala.LVo.xF();
        AppMethodBeat.o(32392);
        return 0;
      }
      localcii.tIM = locala.LVo.readString();
      AppMethodBeat.o(32392);
      return 0;
    }
    AppMethodBeat.o(32392);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cii
 * JD-Core Version:    0.7.0.1
 */