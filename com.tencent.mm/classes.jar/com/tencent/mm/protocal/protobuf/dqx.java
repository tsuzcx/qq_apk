package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dqx
  extends com.tencent.mm.bw.a
{
  public int GxI;
  public String HXU;
  public String HXV;
  public int HXW;
  public int HXX;
  public int Height;
  public int Width;
  public int X;
  public int Y;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(120960);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.X);
      paramVarArgs.aS(2, this.Y);
      paramVarArgs.aS(3, this.Width);
      paramVarArgs.aS(4, this.Height);
      if (this.HXU != null) {
        paramVarArgs.d(5, this.HXU);
      }
      if (this.HXV != null) {
        paramVarArgs.d(6, this.HXV);
      }
      paramVarArgs.aS(7, this.HXW);
      paramVarArgs.aS(8, this.GxI);
      paramVarArgs.aS(9, this.HXX);
      AppMethodBeat.o(120960);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bz(1, this.X) + 0 + f.a.a.b.b.a.bz(2, this.Y) + f.a.a.b.b.a.bz(3, this.Width) + f.a.a.b.b.a.bz(4, this.Height);
      paramInt = i;
      if (this.HXU != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.HXU);
      }
      i = paramInt;
      if (this.HXV != null) {
        i = paramInt + f.a.a.b.b.a.e(6, this.HXV);
      }
      paramInt = f.a.a.b.b.a.bz(7, this.HXW);
      int j = f.a.a.b.b.a.bz(8, this.GxI);
      int k = f.a.a.b.b.a.bz(9, this.HXX);
      AppMethodBeat.o(120960);
      return i + paramInt + j + k;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gCg();
        }
      }
      AppMethodBeat.o(120960);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      dqx localdqx = (dqx)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(120960);
        return -1;
      case 1: 
        localdqx.X = locala.OmT.zc();
        AppMethodBeat.o(120960);
        return 0;
      case 2: 
        localdqx.Y = locala.OmT.zc();
        AppMethodBeat.o(120960);
        return 0;
      case 3: 
        localdqx.Width = locala.OmT.zc();
        AppMethodBeat.o(120960);
        return 0;
      case 4: 
        localdqx.Height = locala.OmT.zc();
        AppMethodBeat.o(120960);
        return 0;
      case 5: 
        localdqx.HXU = locala.OmT.readString();
        AppMethodBeat.o(120960);
        return 0;
      case 6: 
        localdqx.HXV = locala.OmT.readString();
        AppMethodBeat.o(120960);
        return 0;
      case 7: 
        localdqx.HXW = locala.OmT.zc();
        AppMethodBeat.o(120960);
        return 0;
      case 8: 
        localdqx.GxI = locala.OmT.zc();
        AppMethodBeat.o(120960);
        return 0;
      }
      localdqx.HXX = locala.OmT.zc();
      AppMethodBeat.o(120960);
      return 0;
    }
    AppMethodBeat.o(120960);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dqx
 * JD-Core Version:    0.7.0.1
 */