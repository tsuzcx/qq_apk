package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class aii
  extends com.tencent.mm.bx.a
{
  public int GfP;
  public String Name;
  public long pQX;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(155404);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aY(1, this.pQX);
      if (this.Name != null) {
        paramVarArgs.d(2, this.Name);
      }
      paramVarArgs.aS(3, this.GfP);
      AppMethodBeat.o(155404);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.p(1, this.pQX) + 0;
      paramInt = i;
      if (this.Name != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.Name);
      }
      i = f.a.a.b.b.a.bz(3, this.GfP);
      AppMethodBeat.o(155404);
      return paramInt + i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gxE();
        }
      }
      AppMethodBeat.o(155404);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      aii localaii = (aii)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(155404);
        return -1;
      case 1: 
        localaii.pQX = locala.NPN.zd();
        AppMethodBeat.o(155404);
        return 0;
      case 2: 
        localaii.Name = locala.NPN.readString();
        AppMethodBeat.o(155404);
        return 0;
      }
      localaii.GfP = locala.NPN.zc();
      AppMethodBeat.o(155404);
      return 0;
    }
    AppMethodBeat.o(155404);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aii
 * JD-Core Version:    0.7.0.1
 */