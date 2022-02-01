package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class aln
  extends com.tencent.mm.bw.a
{
  public String Goj;
  public int Gop;
  public int nJb;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(127494);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.Goj != null) {
        paramVarArgs.d(1, this.Goj);
      }
      paramVarArgs.aS(2, this.Gop);
      paramVarArgs.aS(3, this.nJb);
      AppMethodBeat.o(127494);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Goj == null) {
        break label306;
      }
    }
    label306:
    for (paramInt = f.a.a.b.b.a.e(1, this.Goj) + 0;; paramInt = 0)
    {
      int i = f.a.a.b.b.a.bz(2, this.Gop);
      int j = f.a.a.b.b.a.bz(3, this.nJb);
      AppMethodBeat.o(127494);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(127494);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        aln localaln = (aln)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(127494);
          return -1;
        case 1: 
          localaln.Goj = locala.OmT.readString();
          AppMethodBeat.o(127494);
          return 0;
        case 2: 
          localaln.Gop = locala.OmT.zc();
          AppMethodBeat.o(127494);
          return 0;
        }
        localaln.nJb = locala.OmT.zc();
        AppMethodBeat.o(127494);
        return 0;
      }
      AppMethodBeat.o(127494);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aln
 * JD-Core Version:    0.7.0.1
 */