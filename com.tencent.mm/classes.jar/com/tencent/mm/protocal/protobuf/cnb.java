package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cnb
  extends com.tencent.mm.bw.a
{
  public String Desc;
  public int ERX;
  public String EpK;
  public String Id;
  public int Mcw;
  public int MsA;
  public cnd MsB;
  public String MsC;
  public int MsD;
  public int MsE;
  public String MsF;
  public String MsG;
  public String MsH;
  public String MsI;
  public String MsJ;
  public int MsK;
  public long MsL;
  public String MsM;
  public int MsN;
  public String MsO;
  public String MsP;
  public int MsQ;
  public String MsR;
  public String MsS;
  public float MsT;
  public String Msz;
  public int Privated;
  public String Title;
  public String Url;
  public int ecf;
  public boolean isAd;
  public String md5;
  public int mediaType;
  public int oUv;
  public String songAlbumUrl;
  public String songLyric;
  public int subType;
  public String viB;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(125743);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.Id != null) {
        paramVarArgs.e(1, this.Id);
      }
      paramVarArgs.aM(2, this.oUv);
      if (this.Desc != null) {
        paramVarArgs.e(3, this.Desc);
      }
      if (this.Url != null) {
        paramVarArgs.e(4, this.Url);
      }
      paramVarArgs.aM(5, this.Mcw);
      if (this.Msz != null) {
        paramVarArgs.e(6, this.Msz);
      }
      paramVarArgs.aM(7, this.MsA);
      paramVarArgs.aM(8, this.Privated);
      if (this.Title != null) {
        paramVarArgs.e(9, this.Title);
      }
      if (this.MsB != null)
      {
        paramVarArgs.ni(10, this.MsB.computeSize());
        this.MsB.writeFields(paramVarArgs);
      }
      if (this.MsC != null) {
        paramVarArgs.e(11, this.MsC);
      }
      paramVarArgs.aM(12, this.MsD);
      paramVarArgs.aM(13, this.ecf);
      paramVarArgs.aM(14, this.MsE);
      if (this.EpK != null) {
        paramVarArgs.e(15, this.EpK);
      }
      paramVarArgs.aM(16, this.subType);
      if (this.md5 != null) {
        paramVarArgs.e(17, this.md5);
      }
      if (this.MsF != null) {
        paramVarArgs.e(18, this.MsF);
      }
      if (this.MsG != null) {
        paramVarArgs.e(19, this.MsG);
      }
      if (this.MsH != null) {
        paramVarArgs.e(20, this.MsH);
      }
      paramVarArgs.aM(21, this.ERX);
      if (this.MsI != null) {
        paramVarArgs.e(22, this.MsI);
      }
      if (this.MsJ != null) {
        paramVarArgs.e(23, this.MsJ);
      }
      paramVarArgs.aM(24, this.MsK);
      paramVarArgs.bb(25, this.MsL);
      if (this.MsM != null) {
        paramVarArgs.e(26, this.MsM);
      }
      if (this.viB != null) {
        paramVarArgs.e(27, this.viB);
      }
      paramVarArgs.aM(28, this.MsN);
      if (this.MsO != null) {
        paramVarArgs.e(29, this.MsO);
      }
      if (this.MsP != null) {
        paramVarArgs.e(30, this.MsP);
      }
      paramVarArgs.aM(31, this.MsQ);
      if (this.MsR != null) {
        paramVarArgs.e(32, this.MsR);
      }
      if (this.MsS != null) {
        paramVarArgs.e(33, this.MsS);
      }
      paramVarArgs.cc(34, this.isAd);
      if (this.songAlbumUrl != null) {
        paramVarArgs.e(35, this.songAlbumUrl);
      }
      if (this.songLyric != null) {
        paramVarArgs.e(36, this.songLyric);
      }
      paramVarArgs.E(37, this.MsT);
      paramVarArgs.aM(38, this.mediaType);
      AppMethodBeat.o(125743);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Id == null) {
        break label2333;
      }
    }
    label2333:
    for (paramInt = g.a.a.b.b.a.f(1, this.Id) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bu(2, this.oUv);
      paramInt = i;
      if (this.Desc != null) {
        paramInt = i + g.a.a.b.b.a.f(3, this.Desc);
      }
      i = paramInt;
      if (this.Url != null) {
        i = paramInt + g.a.a.b.b.a.f(4, this.Url);
      }
      i += g.a.a.b.b.a.bu(5, this.Mcw);
      paramInt = i;
      if (this.Msz != null) {
        paramInt = i + g.a.a.b.b.a.f(6, this.Msz);
      }
      i = paramInt + g.a.a.b.b.a.bu(7, this.MsA) + g.a.a.b.b.a.bu(8, this.Privated);
      paramInt = i;
      if (this.Title != null) {
        paramInt = i + g.a.a.b.b.a.f(9, this.Title);
      }
      i = paramInt;
      if (this.MsB != null) {
        i = paramInt + g.a.a.a.nh(10, this.MsB.computeSize());
      }
      paramInt = i;
      if (this.MsC != null) {
        paramInt = i + g.a.a.b.b.a.f(11, this.MsC);
      }
      i = paramInt + g.a.a.b.b.a.bu(12, this.MsD) + g.a.a.b.b.a.bu(13, this.ecf) + g.a.a.b.b.a.bu(14, this.MsE);
      paramInt = i;
      if (this.EpK != null) {
        paramInt = i + g.a.a.b.b.a.f(15, this.EpK);
      }
      i = paramInt + g.a.a.b.b.a.bu(16, this.subType);
      paramInt = i;
      if (this.md5 != null) {
        paramInt = i + g.a.a.b.b.a.f(17, this.md5);
      }
      i = paramInt;
      if (this.MsF != null) {
        i = paramInt + g.a.a.b.b.a.f(18, this.MsF);
      }
      paramInt = i;
      if (this.MsG != null) {
        paramInt = i + g.a.a.b.b.a.f(19, this.MsG);
      }
      i = paramInt;
      if (this.MsH != null) {
        i = paramInt + g.a.a.b.b.a.f(20, this.MsH);
      }
      i += g.a.a.b.b.a.bu(21, this.ERX);
      paramInt = i;
      if (this.MsI != null) {
        paramInt = i + g.a.a.b.b.a.f(22, this.MsI);
      }
      i = paramInt;
      if (this.MsJ != null) {
        i = paramInt + g.a.a.b.b.a.f(23, this.MsJ);
      }
      i = i + g.a.a.b.b.a.bu(24, this.MsK) + g.a.a.b.b.a.r(25, this.MsL);
      paramInt = i;
      if (this.MsM != null) {
        paramInt = i + g.a.a.b.b.a.f(26, this.MsM);
      }
      i = paramInt;
      if (this.viB != null) {
        i = paramInt + g.a.a.b.b.a.f(27, this.viB);
      }
      i += g.a.a.b.b.a.bu(28, this.MsN);
      paramInt = i;
      if (this.MsO != null) {
        paramInt = i + g.a.a.b.b.a.f(29, this.MsO);
      }
      i = paramInt;
      if (this.MsP != null) {
        i = paramInt + g.a.a.b.b.a.f(30, this.MsP);
      }
      i += g.a.a.b.b.a.bu(31, this.MsQ);
      paramInt = i;
      if (this.MsR != null) {
        paramInt = i + g.a.a.b.b.a.f(32, this.MsR);
      }
      i = paramInt;
      if (this.MsS != null) {
        i = paramInt + g.a.a.b.b.a.f(33, this.MsS);
      }
      i += g.a.a.b.b.a.fS(34) + 1;
      paramInt = i;
      if (this.songAlbumUrl != null) {
        paramInt = i + g.a.a.b.b.a.f(35, this.songAlbumUrl);
      }
      i = paramInt;
      if (this.songLyric != null) {
        i = paramInt + g.a.a.b.b.a.f(36, this.songLyric);
      }
      paramInt = g.a.a.b.b.a.fS(37);
      int j = g.a.a.b.b.a.bu(38, this.mediaType);
      AppMethodBeat.o(125743);
      return i + (paramInt + 4) + j;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(125743);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        cnb localcnb = (cnb)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(125743);
          return -1;
        case 1: 
          localcnb.Id = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(125743);
          return 0;
        case 2: 
          localcnb.oUv = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(125743);
          return 0;
        case 3: 
          localcnb.Desc = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(125743);
          return 0;
        case 4: 
          localcnb.Url = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(125743);
          return 0;
        case 5: 
          localcnb.Mcw = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(125743);
          return 0;
        case 6: 
          localcnb.Msz = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(125743);
          return 0;
        case 7: 
          localcnb.MsA = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(125743);
          return 0;
        case 8: 
          localcnb.Privated = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(125743);
          return 0;
        case 9: 
          localcnb.Title = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(125743);
          return 0;
        case 10: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cnd();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((cnd)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localcnb.MsB = ((cnd)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(125743);
          return 0;
        case 11: 
          localcnb.MsC = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(125743);
          return 0;
        case 12: 
          localcnb.MsD = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(125743);
          return 0;
        case 13: 
          localcnb.ecf = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(125743);
          return 0;
        case 14: 
          localcnb.MsE = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(125743);
          return 0;
        case 15: 
          localcnb.EpK = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(125743);
          return 0;
        case 16: 
          localcnb.subType = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(125743);
          return 0;
        case 17: 
          localcnb.md5 = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(125743);
          return 0;
        case 18: 
          localcnb.MsF = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(125743);
          return 0;
        case 19: 
          localcnb.MsG = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(125743);
          return 0;
        case 20: 
          localcnb.MsH = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(125743);
          return 0;
        case 21: 
          localcnb.ERX = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(125743);
          return 0;
        case 22: 
          localcnb.MsI = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(125743);
          return 0;
        case 23: 
          localcnb.MsJ = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(125743);
          return 0;
        case 24: 
          localcnb.MsK = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(125743);
          return 0;
        case 25: 
          localcnb.MsL = ((g.a.a.a.a)localObject1).UbS.zl();
          AppMethodBeat.o(125743);
          return 0;
        case 26: 
          localcnb.MsM = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(125743);
          return 0;
        case 27: 
          localcnb.viB = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(125743);
          return 0;
        case 28: 
          localcnb.MsN = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(125743);
          return 0;
        case 29: 
          localcnb.MsO = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(125743);
          return 0;
        case 30: 
          localcnb.MsP = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(125743);
          return 0;
        case 31: 
          localcnb.MsQ = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(125743);
          return 0;
        case 32: 
          localcnb.MsR = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(125743);
          return 0;
        case 33: 
          localcnb.MsS = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(125743);
          return 0;
        case 34: 
          localcnb.isAd = ((g.a.a.a.a)localObject1).UbS.yZ();
          AppMethodBeat.o(125743);
          return 0;
        case 35: 
          localcnb.songAlbumUrl = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(125743);
          return 0;
        case 36: 
          localcnb.songLyric = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(125743);
          return 0;
        case 37: 
          localcnb.MsT = Float.intBitsToFloat(((g.a.a.a.a)localObject1).UbS.zm());
          AppMethodBeat.o(125743);
          return 0;
        }
        localcnb.mediaType = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(125743);
        return 0;
      }
      AppMethodBeat.o(125743);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cnb
 * JD-Core Version:    0.7.0.1
 */