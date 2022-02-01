package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ev
  extends com.tencent.mm.bx.a
{
  public boolean Czg;
  public boolean Czh;
  public int Czi;
  public int Czj;
  public int Czk;
  public int Czl;
  public int Czm;
  public boolean Czn;
  public boolean Czo;
  public boolean Czp;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(124386);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bg(1, this.Czg);
      paramVarArgs.bg(2, this.Czh);
      paramVarArgs.aR(3, this.Czi);
      paramVarArgs.aR(4, this.Czj);
      paramVarArgs.aR(5, this.Czk);
      paramVarArgs.aR(6, this.Czl);
      paramVarArgs.aR(7, this.Czm);
      paramVarArgs.bg(8, this.Czn);
      paramVarArgs.bg(9, this.Czo);
      paramVarArgs.bg(10, this.Czp);
      AppMethodBeat.o(124386);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = f.a.a.b.b.a.fY(1);
      int i = f.a.a.b.b.a.fY(2);
      int j = f.a.a.b.b.a.bA(3, this.Czi);
      int k = f.a.a.b.b.a.bA(4, this.Czj);
      int m = f.a.a.b.b.a.bA(5, this.Czk);
      int n = f.a.a.b.b.a.bA(6, this.Czl);
      int i1 = f.a.a.b.b.a.bA(7, this.Czm);
      int i2 = f.a.a.b.b.a.fY(8);
      int i3 = f.a.a.b.b.a.fY(9);
      int i4 = f.a.a.b.b.a.fY(10);
      AppMethodBeat.o(124386);
      return paramInt + 1 + 0 + (i + 1) + j + k + m + n + i1 + (i2 + 1) + (i3 + 1) + (i4 + 1);
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.fMq();
        }
      }
      AppMethodBeat.o(124386);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      ev localev = (ev)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(124386);
        return -1;
      case 1: 
        localev.Czg = locala.KhF.fHu();
        AppMethodBeat.o(124386);
        return 0;
      case 2: 
        localev.Czh = locala.KhF.fHu();
        AppMethodBeat.o(124386);
        return 0;
      case 3: 
        localev.Czi = locala.KhF.xS();
        AppMethodBeat.o(124386);
        return 0;
      case 4: 
        localev.Czj = locala.KhF.xS();
        AppMethodBeat.o(124386);
        return 0;
      case 5: 
        localev.Czk = locala.KhF.xS();
        AppMethodBeat.o(124386);
        return 0;
      case 6: 
        localev.Czl = locala.KhF.xS();
        AppMethodBeat.o(124386);
        return 0;
      case 7: 
        localev.Czm = locala.KhF.xS();
        AppMethodBeat.o(124386);
        return 0;
      case 8: 
        localev.Czn = locala.KhF.fHu();
        AppMethodBeat.o(124386);
        return 0;
      case 9: 
        localev.Czo = locala.KhF.fHu();
        AppMethodBeat.o(124386);
        return 0;
      }
      localev.Czp = locala.KhF.fHu();
      AppMethodBeat.o(124386);
      return 0;
    }
    AppMethodBeat.o(124386);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ev
 * JD-Core Version:    0.7.0.1
 */