package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ry
  extends com.tencent.mm.bw.a
{
  public int GgA;
  public int GgB;
  public int GgC;
  public int GgD;
  public int GgE;
  public int Ggz;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(133161);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.Ggz);
      paramVarArgs.aS(2, this.GgA);
      paramVarArgs.aS(3, this.GgB);
      paramVarArgs.aS(4, this.GgC);
      paramVarArgs.aS(5, this.GgD);
      paramVarArgs.aS(6, this.GgE);
      AppMethodBeat.o(133161);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = f.a.a.b.b.a.bz(1, this.Ggz);
      int i = f.a.a.b.b.a.bz(2, this.GgA);
      int j = f.a.a.b.b.a.bz(3, this.GgB);
      int k = f.a.a.b.b.a.bz(4, this.GgC);
      int m = f.a.a.b.b.a.bz(5, this.GgD);
      int n = f.a.a.b.b.a.bz(6, this.GgE);
      AppMethodBeat.o(133161);
      return paramInt + 0 + i + j + k + m + n;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gCg();
        }
      }
      AppMethodBeat.o(133161);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      ry localry = (ry)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(133161);
        return -1;
      case 1: 
        localry.Ggz = locala.OmT.zc();
        AppMethodBeat.o(133161);
        return 0;
      case 2: 
        localry.GgA = locala.OmT.zc();
        AppMethodBeat.o(133161);
        return 0;
      case 3: 
        localry.GgB = locala.OmT.zc();
        AppMethodBeat.o(133161);
        return 0;
      case 4: 
        localry.GgC = locala.OmT.zc();
        AppMethodBeat.o(133161);
        return 0;
      case 5: 
        localry.GgD = locala.OmT.zc();
        AppMethodBeat.o(133161);
        return 0;
      }
      localry.GgE = locala.OmT.zc();
      AppMethodBeat.o(133161);
      return 0;
    }
    AppMethodBeat.o(133161);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ry
 * JD-Core Version:    0.7.0.1
 */