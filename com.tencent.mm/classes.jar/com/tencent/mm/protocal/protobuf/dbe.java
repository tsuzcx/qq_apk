package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dbe
  extends com.tencent.mm.bw.a
{
  public String AOT;
  public String AOV;
  public String AOW;
  public int AOX;
  public String AOY;
  public int AOZ;
  public int APa;
  public String APc;
  public String APd;
  public String APe;
  public String APf;
  public int CreateTime;
  public int MFR;
  public String MGf;
  public String MGg;
  public String xMq;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91612);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.AOT != null) {
        paramVarArgs.e(1, this.AOT);
      }
      paramVarArgs.aM(2, this.MFR);
      if (this.AOV != null) {
        paramVarArgs.e(3, this.AOV);
      }
      paramVarArgs.aM(4, this.CreateTime);
      if (this.AOW != null) {
        paramVarArgs.e(5, this.AOW);
      }
      paramVarArgs.aM(6, this.AOX);
      if (this.AOY != null) {
        paramVarArgs.e(7, this.AOY);
      }
      paramVarArgs.aM(8, this.AOZ);
      paramVarArgs.aM(9, this.APa);
      if (this.xMq != null) {
        paramVarArgs.e(11, this.xMq);
      }
      if (this.APc != null) {
        paramVarArgs.e(12, this.APc);
      }
      if (this.APd != null) {
        paramVarArgs.e(13, this.APd);
      }
      if (this.APe != null) {
        paramVarArgs.e(14, this.APe);
      }
      if (this.APf != null) {
        paramVarArgs.e(15, this.APf);
      }
      if (this.MGf != null) {
        paramVarArgs.e(18, this.MGf);
      }
      if (this.MGg != null) {
        paramVarArgs.e(19, this.MGg);
      }
      AppMethodBeat.o(91612);
      return 0;
    }
    if (paramInt == 1) {
      if (this.AOT == null) {
        break label1066;
      }
    }
    label1066:
    for (paramInt = g.a.a.b.b.a.f(1, this.AOT) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bu(2, this.MFR);
      paramInt = i;
      if (this.AOV != null) {
        paramInt = i + g.a.a.b.b.a.f(3, this.AOV);
      }
      i = paramInt + g.a.a.b.b.a.bu(4, this.CreateTime);
      paramInt = i;
      if (this.AOW != null) {
        paramInt = i + g.a.a.b.b.a.f(5, this.AOW);
      }
      i = paramInt + g.a.a.b.b.a.bu(6, this.AOX);
      paramInt = i;
      if (this.AOY != null) {
        paramInt = i + g.a.a.b.b.a.f(7, this.AOY);
      }
      i = paramInt + g.a.a.b.b.a.bu(8, this.AOZ) + g.a.a.b.b.a.bu(9, this.APa);
      paramInt = i;
      if (this.xMq != null) {
        paramInt = i + g.a.a.b.b.a.f(11, this.xMq);
      }
      i = paramInt;
      if (this.APc != null) {
        i = paramInt + g.a.a.b.b.a.f(12, this.APc);
      }
      paramInt = i;
      if (this.APd != null) {
        paramInt = i + g.a.a.b.b.a.f(13, this.APd);
      }
      i = paramInt;
      if (this.APe != null) {
        i = paramInt + g.a.a.b.b.a.f(14, this.APe);
      }
      paramInt = i;
      if (this.APf != null) {
        paramInt = i + g.a.a.b.b.a.f(15, this.APf);
      }
      i = paramInt;
      if (this.MGf != null) {
        i = paramInt + g.a.a.b.b.a.f(18, this.MGf);
      }
      paramInt = i;
      if (this.MGg != null) {
        paramInt = i + g.a.a.b.b.a.f(19, this.MGg);
      }
      AppMethodBeat.o(91612);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(91612);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        dbe localdbe = (dbe)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        case 10: 
        case 16: 
        case 17: 
        default: 
          AppMethodBeat.o(91612);
          return -1;
        case 1: 
          localdbe.AOT = locala.UbS.readString();
          AppMethodBeat.o(91612);
          return 0;
        case 2: 
          localdbe.MFR = locala.UbS.zi();
          AppMethodBeat.o(91612);
          return 0;
        case 3: 
          localdbe.AOV = locala.UbS.readString();
          AppMethodBeat.o(91612);
          return 0;
        case 4: 
          localdbe.CreateTime = locala.UbS.zi();
          AppMethodBeat.o(91612);
          return 0;
        case 5: 
          localdbe.AOW = locala.UbS.readString();
          AppMethodBeat.o(91612);
          return 0;
        case 6: 
          localdbe.AOX = locala.UbS.zi();
          AppMethodBeat.o(91612);
          return 0;
        case 7: 
          localdbe.AOY = locala.UbS.readString();
          AppMethodBeat.o(91612);
          return 0;
        case 8: 
          localdbe.AOZ = locala.UbS.zi();
          AppMethodBeat.o(91612);
          return 0;
        case 9: 
          localdbe.APa = locala.UbS.zi();
          AppMethodBeat.o(91612);
          return 0;
        case 11: 
          localdbe.xMq = locala.UbS.readString();
          AppMethodBeat.o(91612);
          return 0;
        case 12: 
          localdbe.APc = locala.UbS.readString();
          AppMethodBeat.o(91612);
          return 0;
        case 13: 
          localdbe.APd = locala.UbS.readString();
          AppMethodBeat.o(91612);
          return 0;
        case 14: 
          localdbe.APe = locala.UbS.readString();
          AppMethodBeat.o(91612);
          return 0;
        case 15: 
          localdbe.APf = locala.UbS.readString();
          AppMethodBeat.o(91612);
          return 0;
        case 18: 
          localdbe.MGf = locala.UbS.readString();
          AppMethodBeat.o(91612);
          return 0;
        }
        localdbe.MGg = locala.UbS.readString();
        AppMethodBeat.o(91612);
        return 0;
      }
      AppMethodBeat.o(91612);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dbe
 * JD-Core Version:    0.7.0.1
 */