package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class amk
  extends com.tencent.mm.bw.a
{
  public String KSu;
  public String LbJ;
  public int LbK;
  public String LiU;
  public String LiV;
  public String LiW;
  public int LiX;
  public String Lvf;
  public int Lvg;
  public int oTW;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(127456);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.LiU != null) {
        paramVarArgs.e(1, this.LiU);
      }
      if (this.LiV != null) {
        paramVarArgs.e(2, this.LiV);
      }
      if (this.LiW != null) {
        paramVarArgs.e(3, this.LiW);
      }
      paramVarArgs.aM(4, this.LiX);
      if (this.Lvf != null) {
        paramVarArgs.e(5, this.Lvf);
      }
      if (this.LbJ != null) {
        paramVarArgs.e(6, this.LbJ);
      }
      paramVarArgs.aM(7, this.LbK);
      if (this.KSu != null) {
        paramVarArgs.e(8, this.KSu);
      }
      paramVarArgs.aM(9, this.oTW);
      paramVarArgs.aM(10, this.Lvg);
      AppMethodBeat.o(127456);
      return 0;
    }
    if (paramInt == 1) {
      if (this.LiU == null) {
        break label702;
      }
    }
    label702:
    for (int i = g.a.a.b.b.a.f(1, this.LiU) + 0;; i = 0)
    {
      paramInt = i;
      if (this.LiV != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.LiV);
      }
      i = paramInt;
      if (this.LiW != null) {
        i = paramInt + g.a.a.b.b.a.f(3, this.LiW);
      }
      i += g.a.a.b.b.a.bu(4, this.LiX);
      paramInt = i;
      if (this.Lvf != null) {
        paramInt = i + g.a.a.b.b.a.f(5, this.Lvf);
      }
      i = paramInt;
      if (this.LbJ != null) {
        i = paramInt + g.a.a.b.b.a.f(6, this.LbJ);
      }
      i += g.a.a.b.b.a.bu(7, this.LbK);
      paramInt = i;
      if (this.KSu != null) {
        paramInt = i + g.a.a.b.b.a.f(8, this.KSu);
      }
      i = g.a.a.b.b.a.bu(9, this.oTW);
      int j = g.a.a.b.b.a.bu(10, this.Lvg);
      AppMethodBeat.o(127456);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(127456);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        amk localamk = (amk)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(127456);
          return -1;
        case 1: 
          localamk.LiU = locala.UbS.readString();
          AppMethodBeat.o(127456);
          return 0;
        case 2: 
          localamk.LiV = locala.UbS.readString();
          AppMethodBeat.o(127456);
          return 0;
        case 3: 
          localamk.LiW = locala.UbS.readString();
          AppMethodBeat.o(127456);
          return 0;
        case 4: 
          localamk.LiX = locala.UbS.zi();
          AppMethodBeat.o(127456);
          return 0;
        case 5: 
          localamk.Lvf = locala.UbS.readString();
          AppMethodBeat.o(127456);
          return 0;
        case 6: 
          localamk.LbJ = locala.UbS.readString();
          AppMethodBeat.o(127456);
          return 0;
        case 7: 
          localamk.LbK = locala.UbS.zi();
          AppMethodBeat.o(127456);
          return 0;
        case 8: 
          localamk.KSu = locala.UbS.readString();
          AppMethodBeat.o(127456);
          return 0;
        case 9: 
          localamk.oTW = locala.UbS.zi();
          AppMethodBeat.o(127456);
          return 0;
        }
        localamk.Lvg = locala.UbS.zi();
        AppMethodBeat.o(127456);
        return 0;
      }
      AppMethodBeat.o(127456);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.amk
 * JD-Core Version:    0.7.0.1
 */