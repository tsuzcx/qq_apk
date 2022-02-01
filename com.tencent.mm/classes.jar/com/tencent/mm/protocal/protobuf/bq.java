package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.b;

public final class bq
  extends com.tencent.mm.cd.a
{
  public String JyL;
  public int RGP;
  public int RGQ;
  public b RGR;
  public int RGS;
  public int RGT;
  public String RGU;
  public String RGV;
  public String RGW;
  public String RGX;
  public String RGY;
  public String RGZ;
  public String imei;
  public int uin;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(125690);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aY(1, this.uin);
      paramVarArgs.aY(2, this.RGP);
      paramVarArgs.aY(3, this.RGQ);
      if (this.RGR != null) {
        paramVarArgs.c(4, this.RGR);
      }
      paramVarArgs.aY(5, this.RGS);
      paramVarArgs.aY(6, this.RGT);
      if (this.JyL != null) {
        paramVarArgs.f(7, this.JyL);
      }
      if (this.imei != null) {
        paramVarArgs.f(8, this.imei);
      }
      if (this.RGU != null) {
        paramVarArgs.f(9, this.RGU);
      }
      if (this.RGV != null) {
        paramVarArgs.f(10, this.RGV);
      }
      if (this.RGW != null) {
        paramVarArgs.f(11, this.RGW);
      }
      if (this.RGX != null) {
        paramVarArgs.f(12, this.RGX);
      }
      if (this.RGY != null) {
        paramVarArgs.f(13, this.RGY);
      }
      if (this.RGZ != null) {
        paramVarArgs.f(14, this.RGZ);
      }
      AppMethodBeat.o(125690);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = g.a.a.b.b.a.bM(1, this.uin) + 0 + g.a.a.b.b.a.bM(2, this.RGP) + g.a.a.b.b.a.bM(3, this.RGQ);
      paramInt = i;
      if (this.RGR != null) {
        paramInt = i + g.a.a.b.b.a.b(4, this.RGR);
      }
      i = paramInt + g.a.a.b.b.a.bM(5, this.RGS) + g.a.a.b.b.a.bM(6, this.RGT);
      paramInt = i;
      if (this.JyL != null) {
        paramInt = i + g.a.a.b.b.a.g(7, this.JyL);
      }
      i = paramInt;
      if (this.imei != null) {
        i = paramInt + g.a.a.b.b.a.g(8, this.imei);
      }
      paramInt = i;
      if (this.RGU != null) {
        paramInt = i + g.a.a.b.b.a.g(9, this.RGU);
      }
      i = paramInt;
      if (this.RGV != null) {
        i = paramInt + g.a.a.b.b.a.g(10, this.RGV);
      }
      paramInt = i;
      if (this.RGW != null) {
        paramInt = i + g.a.a.b.b.a.g(11, this.RGW);
      }
      i = paramInt;
      if (this.RGX != null) {
        i = paramInt + g.a.a.b.b.a.g(12, this.RGX);
      }
      paramInt = i;
      if (this.RGY != null) {
        paramInt = i + g.a.a.b.b.a.g(13, this.RGY);
      }
      i = paramInt;
      if (this.RGZ != null) {
        i = paramInt + g.a.a.b.b.a.g(14, this.RGZ);
      }
      AppMethodBeat.o(125690);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.iUs();
        }
      }
      AppMethodBeat.o(125690);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      bq localbq = (bq)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(125690);
        return -1;
      case 1: 
        localbq.uin = locala.abFh.AK();
        AppMethodBeat.o(125690);
        return 0;
      case 2: 
        localbq.RGP = locala.abFh.AK();
        AppMethodBeat.o(125690);
        return 0;
      case 3: 
        localbq.RGQ = locala.abFh.AK();
        AppMethodBeat.o(125690);
        return 0;
      case 4: 
        localbq.RGR = locala.abFh.iUw();
        AppMethodBeat.o(125690);
        return 0;
      case 5: 
        localbq.RGS = locala.abFh.AK();
        AppMethodBeat.o(125690);
        return 0;
      case 6: 
        localbq.RGT = locala.abFh.AK();
        AppMethodBeat.o(125690);
        return 0;
      case 7: 
        localbq.JyL = locala.abFh.readString();
        AppMethodBeat.o(125690);
        return 0;
      case 8: 
        localbq.imei = locala.abFh.readString();
        AppMethodBeat.o(125690);
        return 0;
      case 9: 
        localbq.RGU = locala.abFh.readString();
        AppMethodBeat.o(125690);
        return 0;
      case 10: 
        localbq.RGV = locala.abFh.readString();
        AppMethodBeat.o(125690);
        return 0;
      case 11: 
        localbq.RGW = locala.abFh.readString();
        AppMethodBeat.o(125690);
        return 0;
      case 12: 
        localbq.RGX = locala.abFh.readString();
        AppMethodBeat.o(125690);
        return 0;
      case 13: 
        localbq.RGY = locala.abFh.readString();
        AppMethodBeat.o(125690);
        return 0;
      }
      localbq.RGZ = locala.abFh.readString();
      AppMethodBeat.o(125690);
      return 0;
    }
    AppMethodBeat.o(125690);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bq
 * JD-Core Version:    0.7.0.1
 */