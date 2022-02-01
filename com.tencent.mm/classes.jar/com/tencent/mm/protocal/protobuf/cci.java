package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class cci
  extends com.tencent.mm.bw.a
{
  public String Desc;
  public String Title;
  public String nIJ;
  public long xrk;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(138184);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.Title != null) {
        paramVarArgs.d(1, this.Title);
      }
      if (this.Desc != null) {
        paramVarArgs.d(2, this.Desc);
      }
      if (this.nIJ != null) {
        paramVarArgs.d(3, this.nIJ);
      }
      paramVarArgs.aZ(4, this.xrk);
      AppMethodBeat.o(138184);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Title == null) {
        break label378;
      }
    }
    label378:
    for (int i = f.a.a.b.b.a.e(1, this.Title) + 0;; i = 0)
    {
      paramInt = i;
      if (this.Desc != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.Desc);
      }
      i = paramInt;
      if (this.nIJ != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.nIJ);
      }
      paramInt = f.a.a.b.b.a.p(4, this.xrk);
      AppMethodBeat.o(138184);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(138184);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        cci localcci = (cci)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(138184);
          return -1;
        case 1: 
          localcci.Title = locala.OmT.readString();
          AppMethodBeat.o(138184);
          return 0;
        case 2: 
          localcci.Desc = locala.OmT.readString();
          AppMethodBeat.o(138184);
          return 0;
        case 3: 
          localcci.nIJ = locala.OmT.readString();
          AppMethodBeat.o(138184);
          return 0;
        }
        localcci.xrk = locala.OmT.zd();
        AppMethodBeat.o(138184);
        return 0;
      }
      AppMethodBeat.o(138184);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cci
 * JD-Core Version:    0.7.0.1
 */