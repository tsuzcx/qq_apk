package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class tz
  extends com.tencent.mm.bw.a
{
  public int GkU;
  public String GkV;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(50081);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.GkU);
      if (this.GkV != null) {
        paramVarArgs.d(2, this.GkV);
      }
      AppMethodBeat.o(50081);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bz(1, this.GkU) + 0;
      paramInt = i;
      if (this.GkV != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.GkV);
      }
      AppMethodBeat.o(50081);
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
      AppMethodBeat.o(50081);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      tz localtz = (tz)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(50081);
        return -1;
      case 1: 
        localtz.GkU = locala.OmT.zc();
        AppMethodBeat.o(50081);
        return 0;
      }
      localtz.GkV = locala.OmT.readString();
      AppMethodBeat.o(50081);
      return 0;
    }
    AppMethodBeat.o(50081);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.tz
 * JD-Core Version:    0.7.0.1
 */