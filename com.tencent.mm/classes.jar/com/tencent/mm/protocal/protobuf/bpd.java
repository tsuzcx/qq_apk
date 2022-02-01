package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bpd
  extends com.tencent.mm.bw.a
{
  public String GSy;
  public String GoS;
  public long Gub;
  public int HcF;
  public long HcG;
  public long HcH;
  public String dEM;
  public int mwj;
  public String oFF;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(72504);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.GoS != null) {
        paramVarArgs.d(1, this.GoS);
      }
      paramVarArgs.aZ(2, this.Gub);
      paramVarArgs.aS(3, this.HcF);
      paramVarArgs.aZ(4, this.HcG);
      paramVarArgs.aZ(5, this.HcH);
      if (this.GSy != null) {
        paramVarArgs.d(6, this.GSy);
      }
      if (this.oFF != null) {
        paramVarArgs.d(7, this.oFF);
      }
      paramVarArgs.aS(8, this.mwj);
      if (this.dEM != null) {
        paramVarArgs.d(9, this.dEM);
      }
      AppMethodBeat.o(72504);
      return 0;
    }
    if (paramInt == 1) {
      if (this.GoS == null) {
        break label618;
      }
    }
    label618:
    for (paramInt = f.a.a.b.b.a.e(1, this.GoS) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.p(2, this.Gub) + f.a.a.b.b.a.bz(3, this.HcF) + f.a.a.b.b.a.p(4, this.HcG) + f.a.a.b.b.a.p(5, this.HcH);
      paramInt = i;
      if (this.GSy != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.GSy);
      }
      i = paramInt;
      if (this.oFF != null) {
        i = paramInt + f.a.a.b.b.a.e(7, this.oFF);
      }
      i += f.a.a.b.b.a.bz(8, this.mwj);
      paramInt = i;
      if (this.dEM != null) {
        paramInt = i + f.a.a.b.b.a.e(9, this.dEM);
      }
      AppMethodBeat.o(72504);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(72504);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        bpd localbpd = (bpd)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(72504);
          return -1;
        case 1: 
          localbpd.GoS = locala.OmT.readString();
          AppMethodBeat.o(72504);
          return 0;
        case 2: 
          localbpd.Gub = locala.OmT.zd();
          AppMethodBeat.o(72504);
          return 0;
        case 3: 
          localbpd.HcF = locala.OmT.zc();
          AppMethodBeat.o(72504);
          return 0;
        case 4: 
          localbpd.HcG = locala.OmT.zd();
          AppMethodBeat.o(72504);
          return 0;
        case 5: 
          localbpd.HcH = locala.OmT.zd();
          AppMethodBeat.o(72504);
          return 0;
        case 6: 
          localbpd.GSy = locala.OmT.readString();
          AppMethodBeat.o(72504);
          return 0;
        case 7: 
          localbpd.oFF = locala.OmT.readString();
          AppMethodBeat.o(72504);
          return 0;
        case 8: 
          localbpd.mwj = locala.OmT.zc();
          AppMethodBeat.o(72504);
          return 0;
        }
        localbpd.dEM = locala.OmT.readString();
        AppMethodBeat.o(72504);
        return 0;
      }
      AppMethodBeat.o(72504);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bpd
 * JD-Core Version:    0.7.0.1
 */