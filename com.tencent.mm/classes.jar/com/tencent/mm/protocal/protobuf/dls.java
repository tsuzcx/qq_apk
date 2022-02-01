package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dls
  extends com.tencent.mm.bw.a
{
  public String GYJ;
  public String HTv;
  public int HhE;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(152708);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.HhE);
      if (this.GYJ != null) {
        paramVarArgs.d(2, this.GYJ);
      }
      if (this.HTv != null) {
        paramVarArgs.d(3, this.HTv);
      }
      AppMethodBeat.o(152708);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bz(1, this.HhE) + 0;
      paramInt = i;
      if (this.GYJ != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.GYJ);
      }
      i = paramInt;
      if (this.HTv != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.HTv);
      }
      AppMethodBeat.o(152708);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gCg();
        }
      }
      AppMethodBeat.o(152708);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      dls localdls = (dls)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(152708);
        return -1;
      case 1: 
        localdls.HhE = locala.OmT.zc();
        AppMethodBeat.o(152708);
        return 0;
      case 2: 
        localdls.GYJ = locala.OmT.readString();
        AppMethodBeat.o(152708);
        return 0;
      }
      localdls.HTv = locala.OmT.readString();
      AppMethodBeat.o(152708);
      return 0;
    }
    AppMethodBeat.o(152708);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dls
 * JD-Core Version:    0.7.0.1
 */