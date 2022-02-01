package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class arl
  extends com.tencent.mm.bw.a
{
  public int doj;
  public int dvm;
  public long iap;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(189393);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.dvm);
      paramVarArgs.aZ(2, this.iap);
      paramVarArgs.aS(3, this.doj);
      AppMethodBeat.o(189393);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = f.a.a.b.b.a.bz(1, this.dvm);
      int i = f.a.a.b.b.a.p(2, this.iap);
      int j = f.a.a.b.b.a.bz(3, this.doj);
      AppMethodBeat.o(189393);
      return paramInt + 0 + i + j;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gCg();
        }
      }
      AppMethodBeat.o(189393);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      arl localarl = (arl)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(189393);
        return -1;
      case 1: 
        localarl.dvm = locala.OmT.zc();
        AppMethodBeat.o(189393);
        return 0;
      case 2: 
        localarl.iap = locala.OmT.zd();
        AppMethodBeat.o(189393);
        return 0;
      }
      localarl.doj = locala.OmT.zc();
      AppMethodBeat.o(189393);
      return 0;
    }
    AppMethodBeat.o(189393);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.arl
 * JD-Core Version:    0.7.0.1
 */