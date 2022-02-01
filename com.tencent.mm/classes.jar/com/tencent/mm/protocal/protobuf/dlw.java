package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dlw
  extends com.tencent.mm.bx.a
{
  public String DAq;
  public int mBH;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(125505);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aR(1, this.mBH);
      if (this.DAq != null) {
        paramVarArgs.d(2, this.DAq);
      }
      AppMethodBeat.o(125505);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bA(1, this.mBH) + 0;
      paramInt = i;
      if (this.DAq != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.DAq);
      }
      AppMethodBeat.o(125505);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.fMq();
        }
      }
      AppMethodBeat.o(125505);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      dlw localdlw = (dlw)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(125505);
        return -1;
      case 1: 
        localdlw.mBH = locala.KhF.xS();
        AppMethodBeat.o(125505);
        return 0;
      }
      localdlw.DAq = locala.KhF.readString();
      AppMethodBeat.o(125505);
      return 0;
    }
    AppMethodBeat.o(125505);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dlw
 * JD-Core Version:    0.7.0.1
 */