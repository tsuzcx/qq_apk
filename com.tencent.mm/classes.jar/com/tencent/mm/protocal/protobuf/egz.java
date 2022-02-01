package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class egz
  extends com.tencent.mm.bw.a
{
  public int FYj;
  public String Hvr;
  public String IconUrl;
  public String IkK;
  public String gvv;
  public String nIJ;
  public String nJO;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(117957);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.Hvr != null) {
        paramVarArgs.d(1, this.Hvr);
      }
      if (this.nIJ != null) {
        paramVarArgs.d(2, this.nIJ);
      }
      if (this.nJO != null) {
        paramVarArgs.d(3, this.nJO);
      }
      if (this.gvv != null) {
        paramVarArgs.d(4, this.gvv);
      }
      paramVarArgs.aS(5, this.FYj);
      if (this.IkK != null) {
        paramVarArgs.d(6, this.IkK);
      }
      if (this.IconUrl != null) {
        paramVarArgs.d(7, this.IconUrl);
      }
      AppMethodBeat.o(117957);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Hvr == null) {
        break label562;
      }
    }
    label562:
    for (int i = f.a.a.b.b.a.e(1, this.Hvr) + 0;; i = 0)
    {
      paramInt = i;
      if (this.nIJ != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.nIJ);
      }
      i = paramInt;
      if (this.nJO != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.nJO);
      }
      paramInt = i;
      if (this.gvv != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.gvv);
      }
      i = paramInt + f.a.a.b.b.a.bz(5, this.FYj);
      paramInt = i;
      if (this.IkK != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.IkK);
      }
      i = paramInt;
      if (this.IconUrl != null) {
        i = paramInt + f.a.a.b.b.a.e(7, this.IconUrl);
      }
      AppMethodBeat.o(117957);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(117957);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        egz localegz = (egz)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(117957);
          return -1;
        case 1: 
          localegz.Hvr = locala.OmT.readString();
          AppMethodBeat.o(117957);
          return 0;
        case 2: 
          localegz.nIJ = locala.OmT.readString();
          AppMethodBeat.o(117957);
          return 0;
        case 3: 
          localegz.nJO = locala.OmT.readString();
          AppMethodBeat.o(117957);
          return 0;
        case 4: 
          localegz.gvv = locala.OmT.readString();
          AppMethodBeat.o(117957);
          return 0;
        case 5: 
          localegz.FYj = locala.OmT.zc();
          AppMethodBeat.o(117957);
          return 0;
        case 6: 
          localegz.IkK = locala.OmT.readString();
          AppMethodBeat.o(117957);
          return 0;
        }
        localegz.IconUrl = locala.OmT.readString();
        AppMethodBeat.o(117957);
        return 0;
      }
      AppMethodBeat.o(117957);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.egz
 * JD-Core Version:    0.7.0.1
 */