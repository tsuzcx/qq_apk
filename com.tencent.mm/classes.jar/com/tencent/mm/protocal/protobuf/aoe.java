package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class aoe
  extends com.tencent.mm.bw.a
{
  public int LAa;
  public String LAb;
  public int LAc;
  public String LAd;
  public long LAe;
  public String LAf;
  public String LAg;
  public long LAh;
  public boolean LzL;
  public long LzM;
  public String LzN;
  public String LzO;
  public long LzP;
  public boolean LzQ;
  public String LzR;
  public String LzS;
  public String LzT;
  public int LzU;
  public String LzV;
  public String LzW;
  public String LzX;
  public String LzY;
  public String LzZ;
  public String appId;
  public String filePath;
  public String gCr;
  public boolean lwF;
  public String processName;
  public int qoX;
  public int scene;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(208702);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.cc(1, this.LzL);
      if (this.filePath != null) {
        paramVarArgs.e(2, this.filePath);
      }
      if (this.gCr != null) {
        paramVarArgs.e(3, this.gCr);
      }
      if (this.appId != null) {
        paramVarArgs.e(4, this.appId);
      }
      if (this.processName != null) {
        paramVarArgs.e(5, this.processName);
      }
      paramVarArgs.aM(6, this.qoX);
      paramVarArgs.cc(7, this.lwF);
      paramVarArgs.bb(8, this.LzM);
      if (this.LzN != null) {
        paramVarArgs.e(9, this.LzN);
      }
      if (this.LzO != null) {
        paramVarArgs.e(10, this.LzO);
      }
      paramVarArgs.bb(11, this.LzP);
      paramVarArgs.cc(12, this.LzQ);
      paramVarArgs.aM(13, this.scene);
      if (this.LzR != null) {
        paramVarArgs.e(14, this.LzR);
      }
      if (this.LzS != null) {
        paramVarArgs.e(15, this.LzS);
      }
      if (this.LzT != null) {
        paramVarArgs.e(16, this.LzT);
      }
      paramVarArgs.aM(17, this.LzU);
      if (this.LzV != null) {
        paramVarArgs.e(18, this.LzV);
      }
      if (this.LzW != null) {
        paramVarArgs.e(19, this.LzW);
      }
      if (this.LzX != null) {
        paramVarArgs.e(20, this.LzX);
      }
      if (this.LzY != null) {
        paramVarArgs.e(21, this.LzY);
      }
      if (this.LzZ != null) {
        paramVarArgs.e(22, this.LzZ);
      }
      paramVarArgs.aM(23, this.LAa);
      if (this.LAb != null) {
        paramVarArgs.e(24, this.LAb);
      }
      paramVarArgs.aM(25, this.LAc);
      if (this.LAd != null) {
        paramVarArgs.e(26, this.LAd);
      }
      paramVarArgs.bb(27, this.LAe);
      if (this.LAf != null) {
        paramVarArgs.e(28, this.LAf);
      }
      if (this.LAg != null) {
        paramVarArgs.e(29, this.LAg);
      }
      paramVarArgs.bb(30, this.LAh);
      AppMethodBeat.o(208702);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = g.a.a.b.b.a.fS(1) + 1 + 0;
      paramInt = i;
      if (this.filePath != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.filePath);
      }
      i = paramInt;
      if (this.gCr != null) {
        i = paramInt + g.a.a.b.b.a.f(3, this.gCr);
      }
      paramInt = i;
      if (this.appId != null) {
        paramInt = i + g.a.a.b.b.a.f(4, this.appId);
      }
      i = paramInt;
      if (this.processName != null) {
        i = paramInt + g.a.a.b.b.a.f(5, this.processName);
      }
      i = i + g.a.a.b.b.a.bu(6, this.qoX) + (g.a.a.b.b.a.fS(7) + 1) + g.a.a.b.b.a.r(8, this.LzM);
      paramInt = i;
      if (this.LzN != null) {
        paramInt = i + g.a.a.b.b.a.f(9, this.LzN);
      }
      i = paramInt;
      if (this.LzO != null) {
        i = paramInt + g.a.a.b.b.a.f(10, this.LzO);
      }
      i = i + g.a.a.b.b.a.r(11, this.LzP) + (g.a.a.b.b.a.fS(12) + 1) + g.a.a.b.b.a.bu(13, this.scene);
      paramInt = i;
      if (this.LzR != null) {
        paramInt = i + g.a.a.b.b.a.f(14, this.LzR);
      }
      i = paramInt;
      if (this.LzS != null) {
        i = paramInt + g.a.a.b.b.a.f(15, this.LzS);
      }
      paramInt = i;
      if (this.LzT != null) {
        paramInt = i + g.a.a.b.b.a.f(16, this.LzT);
      }
      i = paramInt + g.a.a.b.b.a.bu(17, this.LzU);
      paramInt = i;
      if (this.LzV != null) {
        paramInt = i + g.a.a.b.b.a.f(18, this.LzV);
      }
      i = paramInt;
      if (this.LzW != null) {
        i = paramInt + g.a.a.b.b.a.f(19, this.LzW);
      }
      paramInt = i;
      if (this.LzX != null) {
        paramInt = i + g.a.a.b.b.a.f(20, this.LzX);
      }
      i = paramInt;
      if (this.LzY != null) {
        i = paramInt + g.a.a.b.b.a.f(21, this.LzY);
      }
      paramInt = i;
      if (this.LzZ != null) {
        paramInt = i + g.a.a.b.b.a.f(22, this.LzZ);
      }
      i = paramInt + g.a.a.b.b.a.bu(23, this.LAa);
      paramInt = i;
      if (this.LAb != null) {
        paramInt = i + g.a.a.b.b.a.f(24, this.LAb);
      }
      i = paramInt + g.a.a.b.b.a.bu(25, this.LAc);
      paramInt = i;
      if (this.LAd != null) {
        paramInt = i + g.a.a.b.b.a.f(26, this.LAd);
      }
      i = paramInt + g.a.a.b.b.a.r(27, this.LAe);
      paramInt = i;
      if (this.LAf != null) {
        paramInt = i + g.a.a.b.b.a.f(28, this.LAf);
      }
      i = paramInt;
      if (this.LAg != null) {
        i = paramInt + g.a.a.b.b.a.f(29, this.LAg);
      }
      paramInt = g.a.a.b.b.a.r(30, this.LAh);
      AppMethodBeat.o(208702);
      return i + paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.hPl();
        }
      }
      AppMethodBeat.o(208702);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      aoe localaoe = (aoe)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(208702);
        return -1;
      case 1: 
        localaoe.LzL = locala.UbS.yZ();
        AppMethodBeat.o(208702);
        return 0;
      case 2: 
        localaoe.filePath = locala.UbS.readString();
        AppMethodBeat.o(208702);
        return 0;
      case 3: 
        localaoe.gCr = locala.UbS.readString();
        AppMethodBeat.o(208702);
        return 0;
      case 4: 
        localaoe.appId = locala.UbS.readString();
        AppMethodBeat.o(208702);
        return 0;
      case 5: 
        localaoe.processName = locala.UbS.readString();
        AppMethodBeat.o(208702);
        return 0;
      case 6: 
        localaoe.qoX = locala.UbS.zi();
        AppMethodBeat.o(208702);
        return 0;
      case 7: 
        localaoe.lwF = locala.UbS.yZ();
        AppMethodBeat.o(208702);
        return 0;
      case 8: 
        localaoe.LzM = locala.UbS.zl();
        AppMethodBeat.o(208702);
        return 0;
      case 9: 
        localaoe.LzN = locala.UbS.readString();
        AppMethodBeat.o(208702);
        return 0;
      case 10: 
        localaoe.LzO = locala.UbS.readString();
        AppMethodBeat.o(208702);
        return 0;
      case 11: 
        localaoe.LzP = locala.UbS.zl();
        AppMethodBeat.o(208702);
        return 0;
      case 12: 
        localaoe.LzQ = locala.UbS.yZ();
        AppMethodBeat.o(208702);
        return 0;
      case 13: 
        localaoe.scene = locala.UbS.zi();
        AppMethodBeat.o(208702);
        return 0;
      case 14: 
        localaoe.LzR = locala.UbS.readString();
        AppMethodBeat.o(208702);
        return 0;
      case 15: 
        localaoe.LzS = locala.UbS.readString();
        AppMethodBeat.o(208702);
        return 0;
      case 16: 
        localaoe.LzT = locala.UbS.readString();
        AppMethodBeat.o(208702);
        return 0;
      case 17: 
        localaoe.LzU = locala.UbS.zi();
        AppMethodBeat.o(208702);
        return 0;
      case 18: 
        localaoe.LzV = locala.UbS.readString();
        AppMethodBeat.o(208702);
        return 0;
      case 19: 
        localaoe.LzW = locala.UbS.readString();
        AppMethodBeat.o(208702);
        return 0;
      case 20: 
        localaoe.LzX = locala.UbS.readString();
        AppMethodBeat.o(208702);
        return 0;
      case 21: 
        localaoe.LzY = locala.UbS.readString();
        AppMethodBeat.o(208702);
        return 0;
      case 22: 
        localaoe.LzZ = locala.UbS.readString();
        AppMethodBeat.o(208702);
        return 0;
      case 23: 
        localaoe.LAa = locala.UbS.zi();
        AppMethodBeat.o(208702);
        return 0;
      case 24: 
        localaoe.LAb = locala.UbS.readString();
        AppMethodBeat.o(208702);
        return 0;
      case 25: 
        localaoe.LAc = locala.UbS.zi();
        AppMethodBeat.o(208702);
        return 0;
      case 26: 
        localaoe.LAd = locala.UbS.readString();
        AppMethodBeat.o(208702);
        return 0;
      case 27: 
        localaoe.LAe = locala.UbS.zl();
        AppMethodBeat.o(208702);
        return 0;
      case 28: 
        localaoe.LAf = locala.UbS.readString();
        AppMethodBeat.o(208702);
        return 0;
      case 29: 
        localaoe.LAg = locala.UbS.readString();
        AppMethodBeat.o(208702);
        return 0;
      }
      localaoe.LAh = locala.UbS.zl();
      AppMethodBeat.o(208702);
      return 0;
    }
    AppMethodBeat.o(208702);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aoe
 * JD-Core Version:    0.7.0.1
 */