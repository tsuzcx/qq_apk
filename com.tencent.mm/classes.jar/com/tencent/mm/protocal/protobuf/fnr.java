package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class fnr
  extends com.tencent.mm.cd.a
{
  public int IyZ;
  public int Iza;
  public int PLx;
  public int SYQ;
  public String SessionId;
  public String SsR;
  public String ULZ;
  public String UMa;
  public String UMb;
  public int UMc;
  public int fXa;
  public String fXb;
  public String lVG;
  public String qLh;
  public int qLl;
  public int rWu;
  public int vhF;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(123693);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aY(1, this.rWu);
      if (this.lVG != null) {
        paramVarArgs.f(2, this.lVG);
      }
      if (this.ULZ != null) {
        paramVarArgs.f(3, this.ULZ);
      }
      paramVarArgs.aY(4, this.IyZ);
      paramVarArgs.aY(5, this.vhF);
      paramVarArgs.aY(6, this.Iza);
      if (this.UMa != null) {
        paramVarArgs.f(7, this.UMa);
      }
      paramVarArgs.aY(8, this.SYQ);
      if (this.SessionId != null) {
        paramVarArgs.f(9, this.SessionId);
      }
      if (this.UMb != null) {
        paramVarArgs.f(10, this.UMb);
      }
      paramVarArgs.aY(11, this.PLx);
      paramVarArgs.aY(12, this.UMc);
      if (this.SsR != null) {
        paramVarArgs.f(13, this.SsR);
      }
      if (this.qLh != null) {
        paramVarArgs.f(14, this.qLh);
      }
      paramVarArgs.aY(15, this.fXa);
      if (this.fXb != null) {
        paramVarArgs.f(16, this.fXb);
      }
      paramVarArgs.aY(17, this.qLl);
      AppMethodBeat.o(123693);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = g.a.a.b.b.a.bM(1, this.rWu) + 0;
      paramInt = i;
      if (this.lVG != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.lVG);
      }
      i = paramInt;
      if (this.ULZ != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.ULZ);
      }
      i = i + g.a.a.b.b.a.bM(4, this.IyZ) + g.a.a.b.b.a.bM(5, this.vhF) + g.a.a.b.b.a.bM(6, this.Iza);
      paramInt = i;
      if (this.UMa != null) {
        paramInt = i + g.a.a.b.b.a.g(7, this.UMa);
      }
      i = paramInt + g.a.a.b.b.a.bM(8, this.SYQ);
      paramInt = i;
      if (this.SessionId != null) {
        paramInt = i + g.a.a.b.b.a.g(9, this.SessionId);
      }
      i = paramInt;
      if (this.UMb != null) {
        i = paramInt + g.a.a.b.b.a.g(10, this.UMb);
      }
      i = i + g.a.a.b.b.a.bM(11, this.PLx) + g.a.a.b.b.a.bM(12, this.UMc);
      paramInt = i;
      if (this.SsR != null) {
        paramInt = i + g.a.a.b.b.a.g(13, this.SsR);
      }
      i = paramInt;
      if (this.qLh != null) {
        i = paramInt + g.a.a.b.b.a.g(14, this.qLh);
      }
      i += g.a.a.b.b.a.bM(15, this.fXa);
      paramInt = i;
      if (this.fXb != null) {
        paramInt = i + g.a.a.b.b.a.g(16, this.fXb);
      }
      i = g.a.a.b.b.a.bM(17, this.qLl);
      AppMethodBeat.o(123693);
      return paramInt + i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.iUs();
        }
      }
      AppMethodBeat.o(123693);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      fnr localfnr = (fnr)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(123693);
        return -1;
      case 1: 
        localfnr.rWu = locala.abFh.AK();
        AppMethodBeat.o(123693);
        return 0;
      case 2: 
        localfnr.lVG = locala.abFh.readString();
        AppMethodBeat.o(123693);
        return 0;
      case 3: 
        localfnr.ULZ = locala.abFh.readString();
        AppMethodBeat.o(123693);
        return 0;
      case 4: 
        localfnr.IyZ = locala.abFh.AK();
        AppMethodBeat.o(123693);
        return 0;
      case 5: 
        localfnr.vhF = locala.abFh.AK();
        AppMethodBeat.o(123693);
        return 0;
      case 6: 
        localfnr.Iza = locala.abFh.AK();
        AppMethodBeat.o(123693);
        return 0;
      case 7: 
        localfnr.UMa = locala.abFh.readString();
        AppMethodBeat.o(123693);
        return 0;
      case 8: 
        localfnr.SYQ = locala.abFh.AK();
        AppMethodBeat.o(123693);
        return 0;
      case 9: 
        localfnr.SessionId = locala.abFh.readString();
        AppMethodBeat.o(123693);
        return 0;
      case 10: 
        localfnr.UMb = locala.abFh.readString();
        AppMethodBeat.o(123693);
        return 0;
      case 11: 
        localfnr.PLx = locala.abFh.AK();
        AppMethodBeat.o(123693);
        return 0;
      case 12: 
        localfnr.UMc = locala.abFh.AK();
        AppMethodBeat.o(123693);
        return 0;
      case 13: 
        localfnr.SsR = locala.abFh.readString();
        AppMethodBeat.o(123693);
        return 0;
      case 14: 
        localfnr.qLh = locala.abFh.readString();
        AppMethodBeat.o(123693);
        return 0;
      case 15: 
        localfnr.fXa = locala.abFh.AK();
        AppMethodBeat.o(123693);
        return 0;
      case 16: 
        localfnr.fXb = locala.abFh.readString();
        AppMethodBeat.o(123693);
        return 0;
      }
      localfnr.qLl = locala.abFh.AK();
      AppMethodBeat.o(123693);
      return 0;
    }
    AppMethodBeat.o(123693);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fnr
 * JD-Core Version:    0.7.0.1
 */