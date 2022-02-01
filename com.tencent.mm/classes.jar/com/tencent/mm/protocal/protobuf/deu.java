package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class deu
  extends com.tencent.mm.bx.a
{
  public int Der;
  public String Ewr;
  public String Ews;
  public int Ewt;
  public int Ewu;
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
      paramVarArgs.aR(1, this.X);
      paramVarArgs.aR(2, this.Y);
      paramVarArgs.aR(3, this.Width);
      paramVarArgs.aR(4, this.Height);
      if (this.Ewr != null) {
        paramVarArgs.d(5, this.Ewr);
      }
      if (this.Ews != null) {
        paramVarArgs.d(6, this.Ews);
      }
      paramVarArgs.aR(7, this.Ewt);
      paramVarArgs.aR(8, this.Der);
      paramVarArgs.aR(9, this.Ewu);
      AppMethodBeat.o(120960);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bA(1, this.X) + 0 + f.a.a.b.b.a.bA(2, this.Y) + f.a.a.b.b.a.bA(3, this.Width) + f.a.a.b.b.a.bA(4, this.Height);
      paramInt = i;
      if (this.Ewr != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.Ewr);
      }
      i = paramInt;
      if (this.Ews != null) {
        i = paramInt + f.a.a.b.b.a.e(6, this.Ews);
      }
      paramInt = f.a.a.b.b.a.bA(7, this.Ewt);
      int j = f.a.a.b.b.a.bA(8, this.Der);
      int k = f.a.a.b.b.a.bA(9, this.Ewu);
      AppMethodBeat.o(120960);
      return i + paramInt + j + k;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.fMq();
        }
      }
      AppMethodBeat.o(120960);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      deu localdeu = (deu)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(120960);
        return -1;
      case 1: 
        localdeu.X = locala.KhF.xS();
        AppMethodBeat.o(120960);
        return 0;
      case 2: 
        localdeu.Y = locala.KhF.xS();
        AppMethodBeat.o(120960);
        return 0;
      case 3: 
        localdeu.Width = locala.KhF.xS();
        AppMethodBeat.o(120960);
        return 0;
      case 4: 
        localdeu.Height = locala.KhF.xS();
        AppMethodBeat.o(120960);
        return 0;
      case 5: 
        localdeu.Ewr = locala.KhF.readString();
        AppMethodBeat.o(120960);
        return 0;
      case 6: 
        localdeu.Ews = locala.KhF.readString();
        AppMethodBeat.o(120960);
        return 0;
      case 7: 
        localdeu.Ewt = locala.KhF.xS();
        AppMethodBeat.o(120960);
        return 0;
      case 8: 
        localdeu.Der = locala.KhF.xS();
        AppMethodBeat.o(120960);
        return 0;
      }
      localdeu.Ewu = locala.KhF.xS();
      AppMethodBeat.o(120960);
      return 0;
    }
    AppMethodBeat.o(120960);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.deu
 * JD-Core Version:    0.7.0.1
 */