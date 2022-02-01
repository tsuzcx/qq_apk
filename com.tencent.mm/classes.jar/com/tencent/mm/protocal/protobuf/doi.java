package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class doi
  extends com.tencent.mm.bw.a
{
  public boolean HVk;
  public String HVl;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(182773);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bC(1, this.HVk);
      if (this.HVl != null) {
        paramVarArgs.d(2, this.HVl);
      }
      AppMethodBeat.o(182773);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.amF(1) + 0;
      paramInt = i;
      if (this.HVl != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.HVl);
      }
      AppMethodBeat.o(182773);
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
      AppMethodBeat.o(182773);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      doi localdoi = (doi)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(182773);
        return -1;
      case 1: 
        localdoi.HVk = locala.OmT.gvY();
        AppMethodBeat.o(182773);
        return 0;
      }
      localdoi.HVl = locala.OmT.readString();
      AppMethodBeat.o(182773);
      return 0;
    }
    AppMethodBeat.o(182773);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.doi
 * JD-Core Version:    0.7.0.1
 */