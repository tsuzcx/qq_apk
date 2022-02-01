package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class fql
  extends com.tencent.mm.bx.a
{
  public int Height;
  public int Width;
  public int X;
  public int Y;
  public int ZvY;
  public String abQr;
  public String abQs;
  public int abQt;
  public int abQu;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(120960);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bS(1, this.X);
      paramVarArgs.bS(2, this.Y);
      paramVarArgs.bS(3, this.Width);
      paramVarArgs.bS(4, this.Height);
      if (this.abQr != null) {
        paramVarArgs.g(5, this.abQr);
      }
      if (this.abQs != null) {
        paramVarArgs.g(6, this.abQs);
      }
      paramVarArgs.bS(7, this.abQt);
      paramVarArgs.bS(8, this.ZvY);
      paramVarArgs.bS(9, this.abQu);
      AppMethodBeat.o(120960);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = i.a.a.b.b.a.cJ(1, this.X) + 0 + i.a.a.b.b.a.cJ(2, this.Y) + i.a.a.b.b.a.cJ(3, this.Width) + i.a.a.b.b.a.cJ(4, this.Height);
      paramInt = i;
      if (this.abQr != null) {
        paramInt = i + i.a.a.b.b.a.h(5, this.abQr);
      }
      i = paramInt;
      if (this.abQs != null) {
        i = paramInt + i.a.a.b.b.a.h(6, this.abQs);
      }
      paramInt = i.a.a.b.b.a.cJ(7, this.abQt);
      int j = i.a.a.b.b.a.cJ(8, this.ZvY);
      int k = i.a.a.b.b.a.cJ(9, this.abQu);
      AppMethodBeat.o(120960);
      return i + paramInt + j + k;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(120960);
      return 0;
    }
    if (paramInt == 3)
    {
      i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
      fql localfql = (fql)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(120960);
        return -1;
      case 1: 
        localfql.X = locala.ajGk.aar();
        AppMethodBeat.o(120960);
        return 0;
      case 2: 
        localfql.Y = locala.ajGk.aar();
        AppMethodBeat.o(120960);
        return 0;
      case 3: 
        localfql.Width = locala.ajGk.aar();
        AppMethodBeat.o(120960);
        return 0;
      case 4: 
        localfql.Height = locala.ajGk.aar();
        AppMethodBeat.o(120960);
        return 0;
      case 5: 
        localfql.abQr = locala.ajGk.readString();
        AppMethodBeat.o(120960);
        return 0;
      case 6: 
        localfql.abQs = locala.ajGk.readString();
        AppMethodBeat.o(120960);
        return 0;
      case 7: 
        localfql.abQt = locala.ajGk.aar();
        AppMethodBeat.o(120960);
        return 0;
      case 8: 
        localfql.ZvY = locala.ajGk.aar();
        AppMethodBeat.o(120960);
        return 0;
      }
      localfql.abQu = locala.ajGk.aar();
      AppMethodBeat.o(120960);
      return 0;
    }
    AppMethodBeat.o(120960);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fql
 * JD-Core Version:    0.7.0.1
 */