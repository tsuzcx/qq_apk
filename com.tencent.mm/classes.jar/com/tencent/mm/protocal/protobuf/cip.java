package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class cip
  extends com.tencent.mm.bw.a
{
  public int Gaz;
  public String LpF;
  public String MnB;
  public String MnC;
  public long hyH;
  public int rotation;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(207495);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bb(1, this.hyH);
      if (this.MnB != null) {
        paramVarArgs.e(2, this.MnB);
      }
      paramVarArgs.aM(3, this.rotation);
      if (this.LpF != null) {
        paramVarArgs.e(4, this.LpF);
      }
      paramVarArgs.aM(5, this.Gaz);
      if (this.MnC != null) {
        paramVarArgs.e(6, this.MnC);
      }
      AppMethodBeat.o(207495);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = g.a.a.b.b.a.r(1, this.hyH) + 0;
      paramInt = i;
      if (this.MnB != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.MnB);
      }
      i = paramInt + g.a.a.b.b.a.bu(3, this.rotation);
      paramInt = i;
      if (this.LpF != null) {
        paramInt = i + g.a.a.b.b.a.f(4, this.LpF);
      }
      i = paramInt + g.a.a.b.b.a.bu(5, this.Gaz);
      paramInt = i;
      if (this.MnC != null) {
        paramInt = i + g.a.a.b.b.a.f(6, this.MnC);
      }
      AppMethodBeat.o(207495);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.hPl();
        }
      }
      AppMethodBeat.o(207495);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      cip localcip = (cip)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(207495);
        return -1;
      case 1: 
        localcip.hyH = locala.UbS.zl();
        AppMethodBeat.o(207495);
        return 0;
      case 2: 
        localcip.MnB = locala.UbS.readString();
        AppMethodBeat.o(207495);
        return 0;
      case 3: 
        localcip.rotation = locala.UbS.zi();
        AppMethodBeat.o(207495);
        return 0;
      case 4: 
        localcip.LpF = locala.UbS.readString();
        AppMethodBeat.o(207495);
        return 0;
      case 5: 
        localcip.Gaz = locala.UbS.zi();
        AppMethodBeat.o(207495);
        return 0;
      }
      localcip.MnC = locala.UbS.readString();
      AppMethodBeat.o(207495);
      return 0;
    }
    AppMethodBeat.o(207495);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cip
 * JD-Core Version:    0.7.0.1
 */