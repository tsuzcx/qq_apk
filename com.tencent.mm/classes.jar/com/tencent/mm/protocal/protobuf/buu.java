package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class buu
  extends com.tencent.mm.bw.a
{
  public String KXA;
  public int MaY;
  public String Mba;
  public String Mbb;
  public int Scene;
  public String SessionId;
  public String iAc;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(187873);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aM(1, this.Scene);
      if (this.SessionId != null) {
        paramVarArgs.e(2, this.SessionId);
      }
      if (this.Mba != null) {
        paramVarArgs.e(3, this.Mba);
      }
      if (this.Mbb != null) {
        paramVarArgs.e(4, this.Mbb);
      }
      paramVarArgs.aM(5, this.MaY);
      if (this.KXA != null) {
        paramVarArgs.e(6, this.KXA);
      }
      if (this.iAc != null) {
        paramVarArgs.e(7, this.iAc);
      }
      AppMethodBeat.o(187873);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = g.a.a.b.b.a.bu(1, this.Scene) + 0;
      paramInt = i;
      if (this.SessionId != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.SessionId);
      }
      i = paramInt;
      if (this.Mba != null) {
        i = paramInt + g.a.a.b.b.a.f(3, this.Mba);
      }
      paramInt = i;
      if (this.Mbb != null) {
        paramInt = i + g.a.a.b.b.a.f(4, this.Mbb);
      }
      i = paramInt + g.a.a.b.b.a.bu(5, this.MaY);
      paramInt = i;
      if (this.KXA != null) {
        paramInt = i + g.a.a.b.b.a.f(6, this.KXA);
      }
      i = paramInt;
      if (this.iAc != null) {
        i = paramInt + g.a.a.b.b.a.f(7, this.iAc);
      }
      AppMethodBeat.o(187873);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.hPl();
        }
      }
      AppMethodBeat.o(187873);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      buu localbuu = (buu)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(187873);
        return -1;
      case 1: 
        localbuu.Scene = locala.UbS.zi();
        AppMethodBeat.o(187873);
        return 0;
      case 2: 
        localbuu.SessionId = locala.UbS.readString();
        AppMethodBeat.o(187873);
        return 0;
      case 3: 
        localbuu.Mba = locala.UbS.readString();
        AppMethodBeat.o(187873);
        return 0;
      case 4: 
        localbuu.Mbb = locala.UbS.readString();
        AppMethodBeat.o(187873);
        return 0;
      case 5: 
        localbuu.MaY = locala.UbS.zi();
        AppMethodBeat.o(187873);
        return 0;
      case 6: 
        localbuu.KXA = locala.UbS.readString();
        AppMethodBeat.o(187873);
        return 0;
      }
      localbuu.iAc = locala.UbS.readString();
      AppMethodBeat.o(187873);
      return 0;
    }
    AppMethodBeat.o(187873);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.buu
 * JD-Core Version:    0.7.0.1
 */