package com.tencent.mm.plugin.qqmail.b;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class g
  extends com.tencent.mm.bx.a
{
  public int FileSize;
  public int mBi;
  public int uKX;
  public String uKY;
  public long uKZ;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(122660);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aR(1, this.uKX);
      if (this.uKY != null) {
        paramVarArgs.d(2, this.uKY);
      }
      paramVarArgs.aR(3, this.mBi);
      paramVarArgs.aR(4, this.FileSize);
      paramVarArgs.aG(5, this.uKZ);
      AppMethodBeat.o(122660);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bA(1, this.uKX) + 0;
      paramInt = i;
      if (this.uKY != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.uKY);
      }
      i = f.a.a.b.b.a.bA(3, this.mBi);
      int j = f.a.a.b.b.a.bA(4, this.FileSize);
      int k = f.a.a.b.b.a.q(5, this.uKZ);
      AppMethodBeat.o(122660);
      return paramInt + i + j + k;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.fMq();
        }
      }
      AppMethodBeat.o(122660);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      g localg = (g)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(122660);
        return -1;
      case 1: 
        localg.uKX = locala.KhF.xS();
        AppMethodBeat.o(122660);
        return 0;
      case 2: 
        localg.uKY = locala.KhF.readString();
        AppMethodBeat.o(122660);
        return 0;
      case 3: 
        localg.mBi = locala.KhF.xS();
        AppMethodBeat.o(122660);
        return 0;
      case 4: 
        localg.FileSize = locala.KhF.xS();
        AppMethodBeat.o(122660);
        return 0;
      }
      localg.uKZ = locala.KhF.xT();
      AppMethodBeat.o(122660);
      return 0;
    }
    AppMethodBeat.o(122660);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.qqmail.b.g
 * JD-Core Version:    0.7.0.1
 */