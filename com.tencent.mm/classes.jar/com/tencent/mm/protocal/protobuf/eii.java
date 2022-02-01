package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class eii
  extends com.tencent.mm.bw.a
{
  public int drN;
  public String drO;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(40111);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.drN);
      if (this.drO != null) {
        paramVarArgs.d(2, this.drO);
      }
      AppMethodBeat.o(40111);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bz(1, this.drN) + 0;
      paramInt = i;
      if (this.drO != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.drO);
      }
      AppMethodBeat.o(40111);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gCg();
        }
      }
      AppMethodBeat.o(40111);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      eii localeii = (eii)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(40111);
        return -1;
      case 1: 
        localeii.drN = locala.OmT.zc();
        AppMethodBeat.o(40111);
        return 0;
      }
      localeii.drO = locala.OmT.readString();
      AppMethodBeat.o(40111);
      return 0;
    }
    AppMethodBeat.o(40111);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.eii
 * JD-Core Version:    0.7.0.1
 */