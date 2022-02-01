package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class cbo
  extends com.tencent.mm.bx.a
{
  public int DXR;
  public int DXS;
  public String DXT;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(125754);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aR(1, this.DXR);
      paramVarArgs.aR(2, this.DXS);
      if (this.DXT != null) {
        paramVarArgs.d(3, this.DXT);
      }
      AppMethodBeat.o(125754);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bA(1, this.DXR) + 0 + f.a.a.b.b.a.bA(2, this.DXS);
      paramInt = i;
      if (this.DXT != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.DXT);
      }
      AppMethodBeat.o(125754);
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
      AppMethodBeat.o(125754);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      cbo localcbo = (cbo)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(125754);
        return -1;
      case 1: 
        localcbo.DXR = locala.KhF.xS();
        AppMethodBeat.o(125754);
        return 0;
      case 2: 
        localcbo.DXS = locala.KhF.xS();
        AppMethodBeat.o(125754);
        return 0;
      }
      localcbo.DXT = locala.KhF.readString();
      AppMethodBeat.o(125754);
      return 0;
    }
    AppMethodBeat.o(125754);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cbo
 * JD-Core Version:    0.7.0.1
 */