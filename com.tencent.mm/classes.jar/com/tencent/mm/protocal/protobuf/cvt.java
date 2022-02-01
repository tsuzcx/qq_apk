package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public class cvt
  extends com.tencent.mm.cd.a
{
  public String CMB;
  public String Id;
  public String KCT;
  public int Lgc;
  public int Privated;
  public String TDF;
  public int TDG;
  public cvv TDH;
  public String TDI;
  public int TDJ;
  public int TDK;
  public String TDL;
  public String TDM;
  public String TDN;
  public String TDO;
  public String TDP;
  public int TDQ;
  public long TDR;
  public String TDS;
  public int TDT;
  public String TDU;
  public String TDV;
  public int TDW;
  public String TDX;
  public String TDY;
  public float TDZ;
  public int TlV;
  public String Url;
  public int fWh;
  public String fwr;
  public boolean isAd;
  public String md5;
  public int mediaType;
  public int rWu;
  public String songAlbumUrl;
  public String songLyric;
  public int subType;
  public String zZu;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(125743);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.Id != null) {
        paramVarArgs.f(1, this.Id);
      }
      paramVarArgs.aY(2, this.rWu);
      if (this.CMB != null) {
        paramVarArgs.f(3, this.CMB);
      }
      if (this.Url != null) {
        paramVarArgs.f(4, this.Url);
      }
      paramVarArgs.aY(5, this.TlV);
      if (this.TDF != null) {
        paramVarArgs.f(6, this.TDF);
      }
      paramVarArgs.aY(7, this.TDG);
      paramVarArgs.aY(8, this.Privated);
      if (this.fwr != null) {
        paramVarArgs.f(9, this.fwr);
      }
      if (this.TDH != null)
      {
        paramVarArgs.oE(10, this.TDH.computeSize());
        this.TDH.writeFields(paramVarArgs);
      }
      if (this.TDI != null) {
        paramVarArgs.f(11, this.TDI);
      }
      paramVarArgs.aY(12, this.TDJ);
      paramVarArgs.aY(13, this.fWh);
      paramVarArgs.aY(14, this.TDK);
      if (this.KCT != null) {
        paramVarArgs.f(15, this.KCT);
      }
      paramVarArgs.aY(16, this.subType);
      if (this.md5 != null) {
        paramVarArgs.f(17, this.md5);
      }
      if (this.TDL != null) {
        paramVarArgs.f(18, this.TDL);
      }
      if (this.TDM != null) {
        paramVarArgs.f(19, this.TDM);
      }
      if (this.TDN != null) {
        paramVarArgs.f(20, this.TDN);
      }
      paramVarArgs.aY(21, this.Lgc);
      if (this.TDO != null) {
        paramVarArgs.f(22, this.TDO);
      }
      if (this.TDP != null) {
        paramVarArgs.f(23, this.TDP);
      }
      paramVarArgs.aY(24, this.TDQ);
      paramVarArgs.bm(25, this.TDR);
      if (this.TDS != null) {
        paramVarArgs.f(26, this.TDS);
      }
      if (this.zZu != null) {
        paramVarArgs.f(27, this.zZu);
      }
      paramVarArgs.aY(28, this.TDT);
      if (this.TDU != null) {
        paramVarArgs.f(29, this.TDU);
      }
      if (this.TDV != null) {
        paramVarArgs.f(30, this.TDV);
      }
      paramVarArgs.aY(31, this.TDW);
      if (this.TDX != null) {
        paramVarArgs.f(32, this.TDX);
      }
      if (this.TDY != null) {
        paramVarArgs.f(33, this.TDY);
      }
      paramVarArgs.co(34, this.isAd);
      if (this.songAlbumUrl != null) {
        paramVarArgs.f(35, this.songAlbumUrl);
      }
      if (this.songLyric != null) {
        paramVarArgs.f(36, this.songLyric);
      }
      paramVarArgs.i(37, this.TDZ);
      paramVarArgs.aY(38, this.mediaType);
      AppMethodBeat.o(125743);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Id == null) {
        break label2311;
      }
    }
    label2311:
    for (paramInt = g.a.a.b.b.a.g(1, this.Id) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bM(2, this.rWu);
      paramInt = i;
      if (this.CMB != null) {
        paramInt = i + g.a.a.b.b.a.g(3, this.CMB);
      }
      i = paramInt;
      if (this.Url != null) {
        i = paramInt + g.a.a.b.b.a.g(4, this.Url);
      }
      i += g.a.a.b.b.a.bM(5, this.TlV);
      paramInt = i;
      if (this.TDF != null) {
        paramInt = i + g.a.a.b.b.a.g(6, this.TDF);
      }
      i = paramInt + g.a.a.b.b.a.bM(7, this.TDG) + g.a.a.b.b.a.bM(8, this.Privated);
      paramInt = i;
      if (this.fwr != null) {
        paramInt = i + g.a.a.b.b.a.g(9, this.fwr);
      }
      i = paramInt;
      if (this.TDH != null) {
        i = paramInt + g.a.a.a.oD(10, this.TDH.computeSize());
      }
      paramInt = i;
      if (this.TDI != null) {
        paramInt = i + g.a.a.b.b.a.g(11, this.TDI);
      }
      i = paramInt + g.a.a.b.b.a.bM(12, this.TDJ) + g.a.a.b.b.a.bM(13, this.fWh) + g.a.a.b.b.a.bM(14, this.TDK);
      paramInt = i;
      if (this.KCT != null) {
        paramInt = i + g.a.a.b.b.a.g(15, this.KCT);
      }
      i = paramInt + g.a.a.b.b.a.bM(16, this.subType);
      paramInt = i;
      if (this.md5 != null) {
        paramInt = i + g.a.a.b.b.a.g(17, this.md5);
      }
      i = paramInt;
      if (this.TDL != null) {
        i = paramInt + g.a.a.b.b.a.g(18, this.TDL);
      }
      paramInt = i;
      if (this.TDM != null) {
        paramInt = i + g.a.a.b.b.a.g(19, this.TDM);
      }
      i = paramInt;
      if (this.TDN != null) {
        i = paramInt + g.a.a.b.b.a.g(20, this.TDN);
      }
      i += g.a.a.b.b.a.bM(21, this.Lgc);
      paramInt = i;
      if (this.TDO != null) {
        paramInt = i + g.a.a.b.b.a.g(22, this.TDO);
      }
      i = paramInt;
      if (this.TDP != null) {
        i = paramInt + g.a.a.b.b.a.g(23, this.TDP);
      }
      i = i + g.a.a.b.b.a.bM(24, this.TDQ) + g.a.a.b.b.a.p(25, this.TDR);
      paramInt = i;
      if (this.TDS != null) {
        paramInt = i + g.a.a.b.b.a.g(26, this.TDS);
      }
      i = paramInt;
      if (this.zZu != null) {
        i = paramInt + g.a.a.b.b.a.g(27, this.zZu);
      }
      i += g.a.a.b.b.a.bM(28, this.TDT);
      paramInt = i;
      if (this.TDU != null) {
        paramInt = i + g.a.a.b.b.a.g(29, this.TDU);
      }
      i = paramInt;
      if (this.TDV != null) {
        i = paramInt + g.a.a.b.b.a.g(30, this.TDV);
      }
      i += g.a.a.b.b.a.bM(31, this.TDW);
      paramInt = i;
      if (this.TDX != null) {
        paramInt = i + g.a.a.b.b.a.g(32, this.TDX);
      }
      i = paramInt;
      if (this.TDY != null) {
        i = paramInt + g.a.a.b.b.a.g(33, this.TDY);
      }
      i += g.a.a.b.b.a.gL(34) + 1;
      paramInt = i;
      if (this.songAlbumUrl != null) {
        paramInt = i + g.a.a.b.b.a.g(35, this.songAlbumUrl);
      }
      i = paramInt;
      if (this.songLyric != null) {
        i = paramInt + g.a.a.b.b.a.g(36, this.songLyric);
      }
      paramInt = g.a.a.b.b.a.gL(37);
      int j = g.a.a.b.b.a.bM(38, this.mediaType);
      AppMethodBeat.o(125743);
      return i + (paramInt + 4) + j;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(125743);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (g.a.a.a.a)paramVarArgs[0];
        cvt localcvt = (cvt)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(125743);
          return -1;
        case 1: 
          localcvt.Id = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(125743);
          return 0;
        case 2: 
          localcvt.rWu = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(125743);
          return 0;
        case 3: 
          localcvt.CMB = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(125743);
          return 0;
        case 4: 
          localcvt.Url = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(125743);
          return 0;
        case 5: 
          localcvt.TlV = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(125743);
          return 0;
        case 6: 
          localcvt.TDF = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(125743);
          return 0;
        case 7: 
          localcvt.TDG = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(125743);
          return 0;
        case 8: 
          localcvt.Privated = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(125743);
          return 0;
        case 9: 
          localcvt.fwr = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(125743);
          return 0;
        case 10: 
          paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            cvv localcvv = new cvv();
            if ((localObject != null) && (localObject.length > 0)) {
              localcvv.parseFrom((byte[])localObject);
            }
            localcvt.TDH = localcvv;
            paramInt += 1;
          }
          AppMethodBeat.o(125743);
          return 0;
        case 11: 
          localcvt.TDI = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(125743);
          return 0;
        case 12: 
          localcvt.TDJ = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(125743);
          return 0;
        case 13: 
          localcvt.fWh = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(125743);
          return 0;
        case 14: 
          localcvt.TDK = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(125743);
          return 0;
        case 15: 
          localcvt.KCT = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(125743);
          return 0;
        case 16: 
          localcvt.subType = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(125743);
          return 0;
        case 17: 
          localcvt.md5 = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(125743);
          return 0;
        case 18: 
          localcvt.TDL = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(125743);
          return 0;
        case 19: 
          localcvt.TDM = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(125743);
          return 0;
        case 20: 
          localcvt.TDN = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(125743);
          return 0;
        case 21: 
          localcvt.Lgc = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(125743);
          return 0;
        case 22: 
          localcvt.TDO = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(125743);
          return 0;
        case 23: 
          localcvt.TDP = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(125743);
          return 0;
        case 24: 
          localcvt.TDQ = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(125743);
          return 0;
        case 25: 
          localcvt.TDR = ((g.a.a.a.a)localObject).abFh.AN();
          AppMethodBeat.o(125743);
          return 0;
        case 26: 
          localcvt.TDS = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(125743);
          return 0;
        case 27: 
          localcvt.zZu = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(125743);
          return 0;
        case 28: 
          localcvt.TDT = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(125743);
          return 0;
        case 29: 
          localcvt.TDU = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(125743);
          return 0;
        case 30: 
          localcvt.TDV = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(125743);
          return 0;
        case 31: 
          localcvt.TDW = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(125743);
          return 0;
        case 32: 
          localcvt.TDX = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(125743);
          return 0;
        case 33: 
          localcvt.TDY = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(125743);
          return 0;
        case 34: 
          localcvt.isAd = ((g.a.a.a.a)localObject).abFh.AB();
          AppMethodBeat.o(125743);
          return 0;
        case 35: 
          localcvt.songAlbumUrl = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(125743);
          return 0;
        case 36: 
          localcvt.songLyric = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(125743);
          return 0;
        case 37: 
          localcvt.TDZ = Float.intBitsToFloat(((g.a.a.a.a)localObject).abFh.AO());
          AppMethodBeat.o(125743);
          return 0;
        }
        localcvt.mediaType = ((g.a.a.a.a)localObject).abFh.AK();
        AppMethodBeat.o(125743);
        return 0;
      }
      AppMethodBeat.o(125743);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cvt
 * JD-Core Version:    0.7.0.1
 */