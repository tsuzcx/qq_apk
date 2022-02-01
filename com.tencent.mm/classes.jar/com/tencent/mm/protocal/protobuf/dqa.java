package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dqa
  extends com.tencent.mm.bx.a
{
  public int Gfa;
  public String HEh;
  public String HEi;
  public int HEj;
  public int HEk;
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
      if (this.HEh != null) {
        paramVarArgs.d(5, this.HEh);
      }
      if (this.HEi != null) {
        paramVarArgs.d(6, this.HEi);
      }
      paramVarArgs.aS(7, this.HEj);
      paramVarArgs.aS(8, this.Gfa);
      paramVarArgs.aS(9, this.HEk);
      AppMethodBeat.o(120960);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bz(1, this.X) + 0 + f.a.a.b.b.a.bz(2, this.Y) + f.a.a.b.b.a.bz(3, this.Width) + f.a.a.b.b.a.bz(4, this.Height);
      paramInt = i;
      if (this.HEh != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.HEh);
      }
      i = paramInt;
      if (this.HEi != null) {
        i = paramInt + f.a.a.b.b.a.e(6, this.HEi);
      }
      paramInt = f.a.a.b.b.a.bz(7, this.HEj);
      int j = f.a.a.b.b.a.bz(8, this.Gfa);
      int k = f.a.a.b.b.a.bz(9, this.HEk);
      AppMethodBeat.o(120960);
      return i + paramInt + j + k;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gxE();
        }
      }
      AppMethodBeat.o(120960);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      dqa localdqa = (dqa)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(120960);
        return -1;
      case 1: 
        localdqa.X = locala.NPN.zc();
        AppMethodBeat.o(120960);
        return 0;
      case 2: 
        localdqa.Y = locala.NPN.zc();
        AppMethodBeat.o(120960);
        return 0;
      case 3: 
        localdqa.Width = locala.NPN.zc();
        AppMethodBeat.o(120960);
        return 0;
      case 4: 
        localdqa.Height = locala.NPN.zc();
        AppMethodBeat.o(120960);
        return 0;
      case 5: 
        localdqa.HEh = locala.NPN.readString();
        AppMethodBeat.o(120960);
        return 0;
      case 6: 
        localdqa.HEi = locala.NPN.readString();
        AppMethodBeat.o(120960);
        return 0;
      case 7: 
        localdqa.HEj = locala.NPN.zc();
        AppMethodBeat.o(120960);
        return 0;
      case 8: 
        localdqa.Gfa = locala.NPN.zc();
        AppMethodBeat.o(120960);
        return 0;
      }
      localdqa.HEk = locala.NPN.zc();
      AppMethodBeat.o(120960);
      return 0;
    }
    AppMethodBeat.o(120960);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dqa
 * JD-Core Version:    0.7.0.1
 */