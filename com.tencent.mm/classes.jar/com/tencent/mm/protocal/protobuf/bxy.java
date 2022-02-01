package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bxy
  extends com.tencent.mm.bw.a
{
  public int HkN;
  public String HkO;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(169926);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.HkN);
      if (this.HkO != null) {
        paramVarArgs.d(2, this.HkO);
      }
      AppMethodBeat.o(169926);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bz(1, this.HkN) + 0;
      paramInt = i;
      if (this.HkO != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.HkO);
      }
      AppMethodBeat.o(169926);
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
      AppMethodBeat.o(169926);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      bxy localbxy = (bxy)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(169926);
        return -1;
      case 1: 
        localbxy.HkN = locala.OmT.zc();
        AppMethodBeat.o(169926);
        return 0;
      }
      localbxy.HkO = locala.OmT.readString();
      AppMethodBeat.o(169926);
      return 0;
    }
    AppMethodBeat.o(169926);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bxy
 * JD-Core Version:    0.7.0.1
 */