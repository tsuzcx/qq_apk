package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class flq
  extends com.tencent.mm.cd.a
{
  public int JJP = -1;
  public String UKA;
  public String UKB;
  public String UKC;
  public String UKD;
  public int UKE;
  public float UKF;
  public String UKz;
  public String Uus;
  public String domain;
  public int duration = -1;
  public int fEi;
  public String fmF;
  public int idx;
  public long msgId;
  public long sBg;
  public int scene;
  public int wGA;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(267102);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aY(1, this.duration);
      paramVarArgs.aY(2, this.JJP);
      if (this.fmF != null) {
        paramVarArgs.f(3, this.fmF);
      }
      if (this.UKz != null) {
        paramVarArgs.f(4, this.UKz);
      }
      paramVarArgs.aY(5, this.fEi);
      if (this.Uus != null) {
        paramVarArgs.f(6, this.Uus);
      }
      paramVarArgs.bm(7, this.msgId);
      paramVarArgs.aY(8, this.idx);
      if (this.UKA != null) {
        paramVarArgs.f(9, this.UKA);
      }
      if (this.UKB != null) {
        paramVarArgs.f(10, this.UKB);
      }
      if (this.UKC != null) {
        paramVarArgs.f(11, this.UKC);
      }
      if (this.UKD != null) {
        paramVarArgs.f(12, this.UKD);
      }
      paramVarArgs.bm(13, this.sBg);
      paramVarArgs.aY(14, this.scene);
      paramVarArgs.aY(15, this.wGA);
      paramVarArgs.aY(16, this.UKE);
      if (this.domain != null) {
        paramVarArgs.f(17, this.domain);
      }
      paramVarArgs.i(18, this.UKF);
      AppMethodBeat.o(267102);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = g.a.a.b.b.a.bM(1, this.duration) + 0 + g.a.a.b.b.a.bM(2, this.JJP);
      paramInt = i;
      if (this.fmF != null) {
        paramInt = i + g.a.a.b.b.a.g(3, this.fmF);
      }
      i = paramInt;
      if (this.UKz != null) {
        i = paramInt + g.a.a.b.b.a.g(4, this.UKz);
      }
      i += g.a.a.b.b.a.bM(5, this.fEi);
      paramInt = i;
      if (this.Uus != null) {
        paramInt = i + g.a.a.b.b.a.g(6, this.Uus);
      }
      i = paramInt + g.a.a.b.b.a.p(7, this.msgId) + g.a.a.b.b.a.bM(8, this.idx);
      paramInt = i;
      if (this.UKA != null) {
        paramInt = i + g.a.a.b.b.a.g(9, this.UKA);
      }
      i = paramInt;
      if (this.UKB != null) {
        i = paramInt + g.a.a.b.b.a.g(10, this.UKB);
      }
      paramInt = i;
      if (this.UKC != null) {
        paramInt = i + g.a.a.b.b.a.g(11, this.UKC);
      }
      i = paramInt;
      if (this.UKD != null) {
        i = paramInt + g.a.a.b.b.a.g(12, this.UKD);
      }
      i = i + g.a.a.b.b.a.p(13, this.sBg) + g.a.a.b.b.a.bM(14, this.scene) + g.a.a.b.b.a.bM(15, this.wGA) + g.a.a.b.b.a.bM(16, this.UKE);
      paramInt = i;
      if (this.domain != null) {
        paramInt = i + g.a.a.b.b.a.g(17, this.domain);
      }
      i = g.a.a.b.b.a.gL(18);
      AppMethodBeat.o(267102);
      return paramInt + (i + 4);
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.iUs();
        }
      }
      AppMethodBeat.o(267102);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      flq localflq = (flq)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(267102);
        return -1;
      case 1: 
        localflq.duration = locala.abFh.AK();
        AppMethodBeat.o(267102);
        return 0;
      case 2: 
        localflq.JJP = locala.abFh.AK();
        AppMethodBeat.o(267102);
        return 0;
      case 3: 
        localflq.fmF = locala.abFh.readString();
        AppMethodBeat.o(267102);
        return 0;
      case 4: 
        localflq.UKz = locala.abFh.readString();
        AppMethodBeat.o(267102);
        return 0;
      case 5: 
        localflq.fEi = locala.abFh.AK();
        AppMethodBeat.o(267102);
        return 0;
      case 6: 
        localflq.Uus = locala.abFh.readString();
        AppMethodBeat.o(267102);
        return 0;
      case 7: 
        localflq.msgId = locala.abFh.AN();
        AppMethodBeat.o(267102);
        return 0;
      case 8: 
        localflq.idx = locala.abFh.AK();
        AppMethodBeat.o(267102);
        return 0;
      case 9: 
        localflq.UKA = locala.abFh.readString();
        AppMethodBeat.o(267102);
        return 0;
      case 10: 
        localflq.UKB = locala.abFh.readString();
        AppMethodBeat.o(267102);
        return 0;
      case 11: 
        localflq.UKC = locala.abFh.readString();
        AppMethodBeat.o(267102);
        return 0;
      case 12: 
        localflq.UKD = locala.abFh.readString();
        AppMethodBeat.o(267102);
        return 0;
      case 13: 
        localflq.sBg = locala.abFh.AN();
        AppMethodBeat.o(267102);
        return 0;
      case 14: 
        localflq.scene = locala.abFh.AK();
        AppMethodBeat.o(267102);
        return 0;
      case 15: 
        localflq.wGA = locala.abFh.AK();
        AppMethodBeat.o(267102);
        return 0;
      case 16: 
        localflq.UKE = locala.abFh.AK();
        AppMethodBeat.o(267102);
        return 0;
      case 17: 
        localflq.domain = locala.abFh.readString();
        AppMethodBeat.o(267102);
        return 0;
      }
      localflq.UKF = Float.intBitsToFloat(locala.abFh.AO());
      AppMethodBeat.o(267102);
      return 0;
    }
    AppMethodBeat.o(267102);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.flq
 * JD-Core Version:    0.7.0.1
 */