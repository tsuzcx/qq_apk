package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class cht
  extends com.tencent.mm.bw.a
{
  public int Hua;
  public String Hub;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32367);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.Hua);
      if (this.Hub != null) {
        paramVarArgs.d(2, this.Hub);
      }
      AppMethodBeat.o(32367);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bz(1, this.Hua) + 0;
      paramInt = i;
      if (this.Hub != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.Hub);
      }
      AppMethodBeat.o(32367);
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
      AppMethodBeat.o(32367);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      cht localcht = (cht)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(32367);
        return -1;
      case 1: 
        localcht.Hua = locala.OmT.zc();
        AppMethodBeat.o(32367);
        return 0;
      }
      localcht.Hub = locala.OmT.readString();
      AppMethodBeat.o(32367);
      return 0;
    }
    AppMethodBeat.o(32367);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cht
 * JD-Core Version:    0.7.0.1
 */