package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bds
  extends com.tencent.mm.cd.a
{
  public String HLH;
  public String SMY;
  public String SOJ;
  public String SOK;
  public String SOL;
  public String SOM;
  public String SON;
  public long SOO;
  public boolean SOP;
  public String SOQ;
  public String albumName;
  public int duration;
  public String extraInfo;
  public String identification;
  public String kkU;
  public String musicDataUrl;
  public String ozs;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(207600);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.HLH != null) {
        paramVarArgs.f(1, this.HLH);
      }
      if (this.ozs != null) {
        paramVarArgs.f(2, this.ozs);
      }
      if (this.musicDataUrl != null) {
        paramVarArgs.f(3, this.musicDataUrl);
      }
      if (this.SOJ != null) {
        paramVarArgs.f(4, this.SOJ);
      }
      if (this.SOK != null) {
        paramVarArgs.f(5, this.SOK);
      }
      if (this.kkU != null) {
        paramVarArgs.f(6, this.kkU);
      }
      if (this.SOL != null) {
        paramVarArgs.f(7, this.SOL);
      }
      if (this.albumName != null) {
        paramVarArgs.f(8, this.albumName);
      }
      if (this.SOM != null) {
        paramVarArgs.f(9, this.SOM);
      }
      if (this.SMY != null) {
        paramVarArgs.f(10, this.SMY);
      }
      if (this.SON != null) {
        paramVarArgs.f(11, this.SON);
      }
      paramVarArgs.bm(12, this.SOO);
      if (this.extraInfo != null) {
        paramVarArgs.f(13, this.extraInfo);
      }
      if (this.identification != null) {
        paramVarArgs.f(14, this.identification);
      }
      paramVarArgs.aY(15, this.duration);
      paramVarArgs.co(16, this.SOP);
      if (this.SOQ != null) {
        paramVarArgs.f(17, this.SOQ);
      }
      AppMethodBeat.o(207600);
      return 0;
    }
    if (paramInt == 1) {
      if (this.HLH == null) {
        break label1146;
      }
    }
    label1146:
    for (int i = g.a.a.b.b.a.g(1, this.HLH) + 0;; i = 0)
    {
      paramInt = i;
      if (this.ozs != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.ozs);
      }
      i = paramInt;
      if (this.musicDataUrl != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.musicDataUrl);
      }
      paramInt = i;
      if (this.SOJ != null) {
        paramInt = i + g.a.a.b.b.a.g(4, this.SOJ);
      }
      i = paramInt;
      if (this.SOK != null) {
        i = paramInt + g.a.a.b.b.a.g(5, this.SOK);
      }
      paramInt = i;
      if (this.kkU != null) {
        paramInt = i + g.a.a.b.b.a.g(6, this.kkU);
      }
      i = paramInt;
      if (this.SOL != null) {
        i = paramInt + g.a.a.b.b.a.g(7, this.SOL);
      }
      paramInt = i;
      if (this.albumName != null) {
        paramInt = i + g.a.a.b.b.a.g(8, this.albumName);
      }
      i = paramInt;
      if (this.SOM != null) {
        i = paramInt + g.a.a.b.b.a.g(9, this.SOM);
      }
      paramInt = i;
      if (this.SMY != null) {
        paramInt = i + g.a.a.b.b.a.g(10, this.SMY);
      }
      i = paramInt;
      if (this.SON != null) {
        i = paramInt + g.a.a.b.b.a.g(11, this.SON);
      }
      i += g.a.a.b.b.a.p(12, this.SOO);
      paramInt = i;
      if (this.extraInfo != null) {
        paramInt = i + g.a.a.b.b.a.g(13, this.extraInfo);
      }
      i = paramInt;
      if (this.identification != null) {
        i = paramInt + g.a.a.b.b.a.g(14, this.identification);
      }
      i = i + g.a.a.b.b.a.bM(15, this.duration) + (g.a.a.b.b.a.gL(16) + 1);
      paramInt = i;
      if (this.SOQ != null) {
        paramInt = i + g.a.a.b.b.a.g(17, this.SOQ);
      }
      AppMethodBeat.o(207600);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(207600);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        bds localbds = (bds)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(207600);
          return -1;
        case 1: 
          localbds.HLH = locala.abFh.readString();
          AppMethodBeat.o(207600);
          return 0;
        case 2: 
          localbds.ozs = locala.abFh.readString();
          AppMethodBeat.o(207600);
          return 0;
        case 3: 
          localbds.musicDataUrl = locala.abFh.readString();
          AppMethodBeat.o(207600);
          return 0;
        case 4: 
          localbds.SOJ = locala.abFh.readString();
          AppMethodBeat.o(207600);
          return 0;
        case 5: 
          localbds.SOK = locala.abFh.readString();
          AppMethodBeat.o(207600);
          return 0;
        case 6: 
          localbds.kkU = locala.abFh.readString();
          AppMethodBeat.o(207600);
          return 0;
        case 7: 
          localbds.SOL = locala.abFh.readString();
          AppMethodBeat.o(207600);
          return 0;
        case 8: 
          localbds.albumName = locala.abFh.readString();
          AppMethodBeat.o(207600);
          return 0;
        case 9: 
          localbds.SOM = locala.abFh.readString();
          AppMethodBeat.o(207600);
          return 0;
        case 10: 
          localbds.SMY = locala.abFh.readString();
          AppMethodBeat.o(207600);
          return 0;
        case 11: 
          localbds.SON = locala.abFh.readString();
          AppMethodBeat.o(207600);
          return 0;
        case 12: 
          localbds.SOO = locala.abFh.AN();
          AppMethodBeat.o(207600);
          return 0;
        case 13: 
          localbds.extraInfo = locala.abFh.readString();
          AppMethodBeat.o(207600);
          return 0;
        case 14: 
          localbds.identification = locala.abFh.readString();
          AppMethodBeat.o(207600);
          return 0;
        case 15: 
          localbds.duration = locala.abFh.AK();
          AppMethodBeat.o(207600);
          return 0;
        case 16: 
          localbds.SOP = locala.abFh.AB();
          AppMethodBeat.o(207600);
          return 0;
        }
        localbds.SOQ = locala.abFh.readString();
        AppMethodBeat.o(207600);
        return 0;
      }
      AppMethodBeat.o(207600);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bds
 * JD-Core Version:    0.7.0.1
 */