package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class cew
  extends com.tencent.mm.bw.a
{
  public int FileSize;
  public int Gdy;
  public String Gof;
  public int GqB;
  public int HrE;
  public int HrF;
  public String HrG;
  public int HrH;
  public String HrI;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32360);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.Gof != null) {
        paramVarArgs.d(1, this.Gof);
      }
      paramVarArgs.aS(2, this.HrE);
      paramVarArgs.aS(3, this.HrF);
      paramVarArgs.aS(4, this.Gdy);
      if (this.HrG != null) {
        paramVarArgs.d(5, this.HrG);
      }
      paramVarArgs.aS(6, this.FileSize);
      paramVarArgs.aS(7, this.HrH);
      paramVarArgs.aS(8, this.GqB);
      if (this.HrI != null) {
        paramVarArgs.d(9, this.HrI);
      }
      AppMethodBeat.o(32360);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Gof == null) {
        break label613;
      }
    }
    label613:
    for (paramInt = f.a.a.b.b.a.e(1, this.Gof) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bz(2, this.HrE) + f.a.a.b.b.a.bz(3, this.HrF) + f.a.a.b.b.a.bz(4, this.Gdy);
      paramInt = i;
      if (this.HrG != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.HrG);
      }
      i = paramInt + f.a.a.b.b.a.bz(6, this.FileSize) + f.a.a.b.b.a.bz(7, this.HrH) + f.a.a.b.b.a.bz(8, this.GqB);
      paramInt = i;
      if (this.HrI != null) {
        paramInt = i + f.a.a.b.b.a.e(9, this.HrI);
      }
      AppMethodBeat.o(32360);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(32360);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        cew localcew = (cew)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(32360);
          return -1;
        case 1: 
          localcew.Gof = locala.OmT.readString();
          AppMethodBeat.o(32360);
          return 0;
        case 2: 
          localcew.HrE = locala.OmT.zc();
          AppMethodBeat.o(32360);
          return 0;
        case 3: 
          localcew.HrF = locala.OmT.zc();
          AppMethodBeat.o(32360);
          return 0;
        case 4: 
          localcew.Gdy = locala.OmT.zc();
          AppMethodBeat.o(32360);
          return 0;
        case 5: 
          localcew.HrG = locala.OmT.readString();
          AppMethodBeat.o(32360);
          return 0;
        case 6: 
          localcew.FileSize = locala.OmT.zc();
          AppMethodBeat.o(32360);
          return 0;
        case 7: 
          localcew.HrH = locala.OmT.zc();
          AppMethodBeat.o(32360);
          return 0;
        case 8: 
          localcew.GqB = locala.OmT.zc();
          AppMethodBeat.o(32360);
          return 0;
        }
        localcew.HrI = locala.OmT.readString();
        AppMethodBeat.o(32360);
        return 0;
      }
      AppMethodBeat.o(32360);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cew
 * JD-Core Version:    0.7.0.1
 */