package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class sh
  extends com.tencent.mm.bw.a
{
  public String HYG;
  public String IhY;
  public String KDV;
  public String KDW;
  public int KFC;
  public String icon;
  public String title;
  public int type;
  public String url;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91383);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aM(1, this.type);
      if (this.IhY != null) {
        paramVarArgs.e(2, this.IhY);
      }
      if (this.icon != null) {
        paramVarArgs.e(3, this.icon);
      }
      if (this.title != null) {
        paramVarArgs.e(4, this.title);
      }
      if (this.HYG != null) {
        paramVarArgs.e(5, this.HYG);
      }
      if (this.url != null) {
        paramVarArgs.e(6, this.url);
      }
      if (this.KDV != null) {
        paramVarArgs.e(7, this.KDV);
      }
      if (this.KDW != null) {
        paramVarArgs.e(8, this.KDW);
      }
      paramVarArgs.aM(9, this.KFC);
      AppMethodBeat.o(91383);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = g.a.a.b.b.a.bu(1, this.type) + 0;
      paramInt = i;
      if (this.IhY != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.IhY);
      }
      i = paramInt;
      if (this.icon != null) {
        i = paramInt + g.a.a.b.b.a.f(3, this.icon);
      }
      paramInt = i;
      if (this.title != null) {
        paramInt = i + g.a.a.b.b.a.f(4, this.title);
      }
      i = paramInt;
      if (this.HYG != null) {
        i = paramInt + g.a.a.b.b.a.f(5, this.HYG);
      }
      paramInt = i;
      if (this.url != null) {
        paramInt = i + g.a.a.b.b.a.f(6, this.url);
      }
      i = paramInt;
      if (this.KDV != null) {
        i = paramInt + g.a.a.b.b.a.f(7, this.KDV);
      }
      paramInt = i;
      if (this.KDW != null) {
        paramInt = i + g.a.a.b.b.a.f(8, this.KDW);
      }
      i = g.a.a.b.b.a.bu(9, this.KFC);
      AppMethodBeat.o(91383);
      return paramInt + i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.hPl();
        }
      }
      AppMethodBeat.o(91383);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      sh localsh = (sh)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(91383);
        return -1;
      case 1: 
        localsh.type = locala.UbS.zi();
        AppMethodBeat.o(91383);
        return 0;
      case 2: 
        localsh.IhY = locala.UbS.readString();
        AppMethodBeat.o(91383);
        return 0;
      case 3: 
        localsh.icon = locala.UbS.readString();
        AppMethodBeat.o(91383);
        return 0;
      case 4: 
        localsh.title = locala.UbS.readString();
        AppMethodBeat.o(91383);
        return 0;
      case 5: 
        localsh.HYG = locala.UbS.readString();
        AppMethodBeat.o(91383);
        return 0;
      case 6: 
        localsh.url = locala.UbS.readString();
        AppMethodBeat.o(91383);
        return 0;
      case 7: 
        localsh.KDV = locala.UbS.readString();
        AppMethodBeat.o(91383);
        return 0;
      case 8: 
        localsh.KDW = locala.UbS.readString();
        AppMethodBeat.o(91383);
        return 0;
      }
      localsh.KFC = locala.UbS.zi();
      AppMethodBeat.o(91383);
      return 0;
    }
    AppMethodBeat.o(91383);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.sh
 * JD-Core Version:    0.7.0.1
 */