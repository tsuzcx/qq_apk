package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bqb
  extends com.tencent.mm.bw.a
{
  public int HdA;
  public int HdB;
  public int HdC;
  public int HdD;
  public int Hdx;
  public int Hdy;
  public int Hdz;
  public int dms;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(143981);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.Hdx);
      paramVarArgs.aS(2, this.dms);
      paramVarArgs.aS(3, this.Hdy);
      paramVarArgs.aS(4, this.Hdz);
      paramVarArgs.aS(5, this.HdA);
      paramVarArgs.aS(6, this.HdB);
      paramVarArgs.aS(7, this.HdC);
      paramVarArgs.aS(8, this.HdD);
      AppMethodBeat.o(143981);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = f.a.a.b.b.a.bz(1, this.Hdx);
      int i = f.a.a.b.b.a.bz(2, this.dms);
      int j = f.a.a.b.b.a.bz(3, this.Hdy);
      int k = f.a.a.b.b.a.bz(4, this.Hdz);
      int m = f.a.a.b.b.a.bz(5, this.HdA);
      int n = f.a.a.b.b.a.bz(6, this.HdB);
      int i1 = f.a.a.b.b.a.bz(7, this.HdC);
      int i2 = f.a.a.b.b.a.bz(8, this.HdD);
      AppMethodBeat.o(143981);
      return paramInt + 0 + i + j + k + m + n + i1 + i2;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gCg();
        }
      }
      AppMethodBeat.o(143981);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      bqb localbqb = (bqb)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(143981);
        return -1;
      case 1: 
        localbqb.Hdx = locala.OmT.zc();
        AppMethodBeat.o(143981);
        return 0;
      case 2: 
        localbqb.dms = locala.OmT.zc();
        AppMethodBeat.o(143981);
        return 0;
      case 3: 
        localbqb.Hdy = locala.OmT.zc();
        AppMethodBeat.o(143981);
        return 0;
      case 4: 
        localbqb.Hdz = locala.OmT.zc();
        AppMethodBeat.o(143981);
        return 0;
      case 5: 
        localbqb.HdA = locala.OmT.zc();
        AppMethodBeat.o(143981);
        return 0;
      case 6: 
        localbqb.HdB = locala.OmT.zc();
        AppMethodBeat.o(143981);
        return 0;
      case 7: 
        localbqb.HdC = locala.OmT.zc();
        AppMethodBeat.o(143981);
        return 0;
      }
      localbqb.HdD = locala.OmT.zc();
      AppMethodBeat.o(143981);
      return 0;
    }
    AppMethodBeat.o(143981);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bqb
 * JD-Core Version:    0.7.0.1
 */