package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;

public final class ca
  extends com.tencent.mm.bx.a
{
  public String PNk;
  public int YDR;
  public int YDS;
  public b YDT;
  public int YDU;
  public int YDV;
  public String YDW;
  public String YDX;
  public String YDY;
  public String YDZ;
  public String YEa;
  public String YEb;
  public String imei;
  public int uin;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(125690);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bS(1, this.uin);
      paramVarArgs.bS(2, this.YDR);
      paramVarArgs.bS(3, this.YDS);
      if (this.YDT != null) {
        paramVarArgs.d(4, this.YDT);
      }
      paramVarArgs.bS(5, this.YDU);
      paramVarArgs.bS(6, this.YDV);
      if (this.PNk != null) {
        paramVarArgs.g(7, this.PNk);
      }
      if (this.imei != null) {
        paramVarArgs.g(8, this.imei);
      }
      if (this.YDW != null) {
        paramVarArgs.g(9, this.YDW);
      }
      if (this.YDX != null) {
        paramVarArgs.g(10, this.YDX);
      }
      if (this.YDY != null) {
        paramVarArgs.g(11, this.YDY);
      }
      if (this.YDZ != null) {
        paramVarArgs.g(12, this.YDZ);
      }
      if (this.YEa != null) {
        paramVarArgs.g(13, this.YEa);
      }
      if (this.YEb != null) {
        paramVarArgs.g(14, this.YEb);
      }
      AppMethodBeat.o(125690);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = i.a.a.b.b.a.cJ(1, this.uin) + 0 + i.a.a.b.b.a.cJ(2, this.YDR) + i.a.a.b.b.a.cJ(3, this.YDS);
      paramInt = i;
      if (this.YDT != null) {
        paramInt = i + i.a.a.b.b.a.c(4, this.YDT);
      }
      i = paramInt + i.a.a.b.b.a.cJ(5, this.YDU) + i.a.a.b.b.a.cJ(6, this.YDV);
      paramInt = i;
      if (this.PNk != null) {
        paramInt = i + i.a.a.b.b.a.h(7, this.PNk);
      }
      i = paramInt;
      if (this.imei != null) {
        i = paramInt + i.a.a.b.b.a.h(8, this.imei);
      }
      paramInt = i;
      if (this.YDW != null) {
        paramInt = i + i.a.a.b.b.a.h(9, this.YDW);
      }
      i = paramInt;
      if (this.YDX != null) {
        i = paramInt + i.a.a.b.b.a.h(10, this.YDX);
      }
      paramInt = i;
      if (this.YDY != null) {
        paramInt = i + i.a.a.b.b.a.h(11, this.YDY);
      }
      i = paramInt;
      if (this.YDZ != null) {
        i = paramInt + i.a.a.b.b.a.h(12, this.YDZ);
      }
      paramInt = i;
      if (this.YEa != null) {
        paramInt = i + i.a.a.b.b.a.h(13, this.YEa);
      }
      i = paramInt;
      if (this.YEb != null) {
        i = paramInt + i.a.a.b.b.a.h(14, this.YEb);
      }
      AppMethodBeat.o(125690);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(125690);
      return 0;
    }
    if (paramInt == 3)
    {
      i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
      ca localca = (ca)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(125690);
        return -1;
      case 1: 
        localca.uin = locala.ajGk.aar();
        AppMethodBeat.o(125690);
        return 0;
      case 2: 
        localca.YDR = locala.ajGk.aar();
        AppMethodBeat.o(125690);
        return 0;
      case 3: 
        localca.YDS = locala.ajGk.aar();
        AppMethodBeat.o(125690);
        return 0;
      case 4: 
        localca.YDT = locala.ajGk.kFX();
        AppMethodBeat.o(125690);
        return 0;
      case 5: 
        localca.YDU = locala.ajGk.aar();
        AppMethodBeat.o(125690);
        return 0;
      case 6: 
        localca.YDV = locala.ajGk.aar();
        AppMethodBeat.o(125690);
        return 0;
      case 7: 
        localca.PNk = locala.ajGk.readString();
        AppMethodBeat.o(125690);
        return 0;
      case 8: 
        localca.imei = locala.ajGk.readString();
        AppMethodBeat.o(125690);
        return 0;
      case 9: 
        localca.YDW = locala.ajGk.readString();
        AppMethodBeat.o(125690);
        return 0;
      case 10: 
        localca.YDX = locala.ajGk.readString();
        AppMethodBeat.o(125690);
        return 0;
      case 11: 
        localca.YDY = locala.ajGk.readString();
        AppMethodBeat.o(125690);
        return 0;
      case 12: 
        localca.YDZ = locala.ajGk.readString();
        AppMethodBeat.o(125690);
        return 0;
      case 13: 
        localca.YEa = locala.ajGk.readString();
        AppMethodBeat.o(125690);
        return 0;
      }
      localca.YEb = locala.ajGk.readString();
      AppMethodBeat.o(125690);
      return 0;
    }
    AppMethodBeat.o(125690);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ca
 * JD-Core Version:    0.7.0.1
 */