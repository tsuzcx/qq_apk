package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class cin
  extends com.tencent.mm.bw.a
{
  public String GwI;
  public int HuP;
  public int HuQ;
  public int HuR;
  public long HuS;
  public int HuT;
  public int HuU;
  public String uvT;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(104825);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.HuP);
      paramVarArgs.aS(2, this.HuQ);
      paramVarArgs.aS(3, this.HuR);
      if (this.uvT != null) {
        paramVarArgs.d(4, this.uvT);
      }
      paramVarArgs.aZ(5, this.HuS);
      paramVarArgs.aS(6, this.HuT);
      if (this.GwI != null) {
        paramVarArgs.d(7, this.GwI);
      }
      paramVarArgs.aS(8, this.HuU);
      AppMethodBeat.o(104825);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bz(1, this.HuP) + 0 + f.a.a.b.b.a.bz(2, this.HuQ) + f.a.a.b.b.a.bz(3, this.HuR);
      paramInt = i;
      if (this.uvT != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.uvT);
      }
      i = paramInt + f.a.a.b.b.a.p(5, this.HuS) + f.a.a.b.b.a.bz(6, this.HuT);
      paramInt = i;
      if (this.GwI != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.GwI);
      }
      i = f.a.a.b.b.a.bz(8, this.HuU);
      AppMethodBeat.o(104825);
      return paramInt + i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gCg();
        }
      }
      AppMethodBeat.o(104825);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      cin localcin = (cin)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(104825);
        return -1;
      case 1: 
        localcin.HuP = locala.OmT.zc();
        AppMethodBeat.o(104825);
        return 0;
      case 2: 
        localcin.HuQ = locala.OmT.zc();
        AppMethodBeat.o(104825);
        return 0;
      case 3: 
        localcin.HuR = locala.OmT.zc();
        AppMethodBeat.o(104825);
        return 0;
      case 4: 
        localcin.uvT = locala.OmT.readString();
        AppMethodBeat.o(104825);
        return 0;
      case 5: 
        localcin.HuS = locala.OmT.zd();
        AppMethodBeat.o(104825);
        return 0;
      case 6: 
        localcin.HuT = locala.OmT.zc();
        AppMethodBeat.o(104825);
        return 0;
      case 7: 
        localcin.GwI = locala.OmT.readString();
        AppMethodBeat.o(104825);
        return 0;
      }
      localcin.HuU = locala.OmT.zc();
      AppMethodBeat.o(104825);
      return 0;
    }
    AppMethodBeat.o(104825);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cin
 * JD-Core Version:    0.7.0.1
 */