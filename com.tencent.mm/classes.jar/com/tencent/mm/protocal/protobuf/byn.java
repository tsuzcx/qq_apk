package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class byn
  extends com.tencent.mm.bx.a
{
  public int AqM;
  public String Desc;
  public int GEe;
  public String GSI;
  public int GSJ;
  public int GSK;
  public byp GSL;
  public String GSM;
  public int GSN;
  public int GSO;
  public String GSP;
  public String GSQ;
  public String GSR;
  public String GSS;
  public String GST;
  public int GSU;
  public long GSV;
  public String GSW;
  public String GSX;
  public int GSY;
  public String GSZ;
  public String GTa;
  public int GTb;
  public String GTc;
  public String GTd;
  public float GTe;
  public String Id;
  public String Title;
  public String Url;
  public int dJd;
  public boolean isAd;
  public String md5;
  public int mediaType;
  public int nEf;
  public String songAlbumUrl;
  public String songLyric;
  public int subType;
  public String zQh;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(125743);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.Id != null) {
        paramVarArgs.d(1, this.Id);
      }
      paramVarArgs.aS(2, this.nEf);
      if (this.Desc != null) {
        paramVarArgs.d(3, this.Desc);
      }
      if (this.Url != null) {
        paramVarArgs.d(4, this.Url);
      }
      paramVarArgs.aS(5, this.GEe);
      if (this.GSI != null) {
        paramVarArgs.d(6, this.GSI);
      }
      paramVarArgs.aS(7, this.GSJ);
      paramVarArgs.aS(8, this.GSK);
      if (this.Title != null) {
        paramVarArgs.d(9, this.Title);
      }
      if (this.GSL != null)
      {
        paramVarArgs.lC(10, this.GSL.computeSize());
        this.GSL.writeFields(paramVarArgs);
      }
      if (this.GSM != null) {
        paramVarArgs.d(11, this.GSM);
      }
      paramVarArgs.aS(12, this.GSN);
      paramVarArgs.aS(13, this.dJd);
      paramVarArgs.aS(14, this.GSO);
      if (this.zQh != null) {
        paramVarArgs.d(15, this.zQh);
      }
      paramVarArgs.aS(16, this.subType);
      if (this.md5 != null) {
        paramVarArgs.d(17, this.md5);
      }
      if (this.GSP != null) {
        paramVarArgs.d(18, this.GSP);
      }
      if (this.GSQ != null) {
        paramVarArgs.d(19, this.GSQ);
      }
      if (this.GSR != null) {
        paramVarArgs.d(20, this.GSR);
      }
      paramVarArgs.aS(21, this.AqM);
      if (this.GSS != null) {
        paramVarArgs.d(22, this.GSS);
      }
      if (this.GST != null) {
        paramVarArgs.d(23, this.GST);
      }
      paramVarArgs.aS(24, this.GSU);
      paramVarArgs.aY(25, this.GSV);
      if (this.GSW != null) {
        paramVarArgs.d(26, this.GSW);
      }
      if (this.GSX != null) {
        paramVarArgs.d(27, this.GSX);
      }
      paramVarArgs.aS(28, this.GSY);
      if (this.GSZ != null) {
        paramVarArgs.d(29, this.GSZ);
      }
      if (this.GTa != null) {
        paramVarArgs.d(30, this.GTa);
      }
      paramVarArgs.aS(31, this.GTb);
      if (this.GTc != null) {
        paramVarArgs.d(32, this.GTc);
      }
      if (this.GTd != null) {
        paramVarArgs.d(33, this.GTd);
      }
      paramVarArgs.bt(34, this.isAd);
      if (this.songAlbumUrl != null) {
        paramVarArgs.d(35, this.songAlbumUrl);
      }
      if (this.songLyric != null) {
        paramVarArgs.d(36, this.songLyric);
      }
      paramVarArgs.z(37, this.GTe);
      paramVarArgs.aS(38, this.mediaType);
      AppMethodBeat.o(125743);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Id == null) {
        break label2329;
      }
    }
    label2329:
    for (paramInt = f.a.a.b.b.a.e(1, this.Id) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bz(2, this.nEf);
      paramInt = i;
      if (this.Desc != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.Desc);
      }
      i = paramInt;
      if (this.Url != null) {
        i = paramInt + f.a.a.b.b.a.e(4, this.Url);
      }
      i += f.a.a.b.b.a.bz(5, this.GEe);
      paramInt = i;
      if (this.GSI != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.GSI);
      }
      i = paramInt + f.a.a.b.b.a.bz(7, this.GSJ) + f.a.a.b.b.a.bz(8, this.GSK);
      paramInt = i;
      if (this.Title != null) {
        paramInt = i + f.a.a.b.b.a.e(9, this.Title);
      }
      i = paramInt;
      if (this.GSL != null) {
        i = paramInt + f.a.a.a.lB(10, this.GSL.computeSize());
      }
      paramInt = i;
      if (this.GSM != null) {
        paramInt = i + f.a.a.b.b.a.e(11, this.GSM);
      }
      i = paramInt + f.a.a.b.b.a.bz(12, this.GSN) + f.a.a.b.b.a.bz(13, this.dJd) + f.a.a.b.b.a.bz(14, this.GSO);
      paramInt = i;
      if (this.zQh != null) {
        paramInt = i + f.a.a.b.b.a.e(15, this.zQh);
      }
      i = paramInt + f.a.a.b.b.a.bz(16, this.subType);
      paramInt = i;
      if (this.md5 != null) {
        paramInt = i + f.a.a.b.b.a.e(17, this.md5);
      }
      i = paramInt;
      if (this.GSP != null) {
        i = paramInt + f.a.a.b.b.a.e(18, this.GSP);
      }
      paramInt = i;
      if (this.GSQ != null) {
        paramInt = i + f.a.a.b.b.a.e(19, this.GSQ);
      }
      i = paramInt;
      if (this.GSR != null) {
        i = paramInt + f.a.a.b.b.a.e(20, this.GSR);
      }
      i += f.a.a.b.b.a.bz(21, this.AqM);
      paramInt = i;
      if (this.GSS != null) {
        paramInt = i + f.a.a.b.b.a.e(22, this.GSS);
      }
      i = paramInt;
      if (this.GST != null) {
        i = paramInt + f.a.a.b.b.a.e(23, this.GST);
      }
      i = i + f.a.a.b.b.a.bz(24, this.GSU) + f.a.a.b.b.a.p(25, this.GSV);
      paramInt = i;
      if (this.GSW != null) {
        paramInt = i + f.a.a.b.b.a.e(26, this.GSW);
      }
      i = paramInt;
      if (this.GSX != null) {
        i = paramInt + f.a.a.b.b.a.e(27, this.GSX);
      }
      i += f.a.a.b.b.a.bz(28, this.GSY);
      paramInt = i;
      if (this.GSZ != null) {
        paramInt = i + f.a.a.b.b.a.e(29, this.GSZ);
      }
      i = paramInt;
      if (this.GTa != null) {
        i = paramInt + f.a.a.b.b.a.e(30, this.GTa);
      }
      i += f.a.a.b.b.a.bz(31, this.GTb);
      paramInt = i;
      if (this.GTc != null) {
        paramInt = i + f.a.a.b.b.a.e(32, this.GTc);
      }
      i = paramInt;
      if (this.GTd != null) {
        i = paramInt + f.a.a.b.b.a.e(33, this.GTd);
      }
      i += f.a.a.b.b.a.alV(34);
      paramInt = i;
      if (this.songAlbumUrl != null) {
        paramInt = i + f.a.a.b.b.a.e(35, this.songAlbumUrl);
      }
      i = paramInt;
      if (this.songLyric != null) {
        i = paramInt + f.a.a.b.b.a.e(36, this.songLyric);
      }
      paramInt = f.a.a.b.b.a.alU(37);
      int j = f.a.a.b.b.a.bz(38, this.mediaType);
      AppMethodBeat.o(125743);
      return i + paramInt + j;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(125743);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        byn localbyn = (byn)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(125743);
          return -1;
        case 1: 
          localbyn.Id = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(125743);
          return 0;
        case 2: 
          localbyn.nEf = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(125743);
          return 0;
        case 3: 
          localbyn.Desc = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(125743);
          return 0;
        case 4: 
          localbyn.Url = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(125743);
          return 0;
        case 5: 
          localbyn.GEe = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(125743);
          return 0;
        case 6: 
          localbyn.GSI = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(125743);
          return 0;
        case 7: 
          localbyn.GSJ = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(125743);
          return 0;
        case 8: 
          localbyn.GSK = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(125743);
          return 0;
        case 9: 
          localbyn.Title = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(125743);
          return 0;
        case 10: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new byp();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((byp)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbyn.GSL = ((byp)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(125743);
          return 0;
        case 11: 
          localbyn.GSM = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(125743);
          return 0;
        case 12: 
          localbyn.GSN = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(125743);
          return 0;
        case 13: 
          localbyn.dJd = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(125743);
          return 0;
        case 14: 
          localbyn.GSO = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(125743);
          return 0;
        case 15: 
          localbyn.zQh = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(125743);
          return 0;
        case 16: 
          localbyn.subType = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(125743);
          return 0;
        case 17: 
          localbyn.md5 = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(125743);
          return 0;
        case 18: 
          localbyn.GSP = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(125743);
          return 0;
        case 19: 
          localbyn.GSQ = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(125743);
          return 0;
        case 20: 
          localbyn.GSR = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(125743);
          return 0;
        case 21: 
          localbyn.AqM = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(125743);
          return 0;
        case 22: 
          localbyn.GSS = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(125743);
          return 0;
        case 23: 
          localbyn.GST = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(125743);
          return 0;
        case 24: 
          localbyn.GSU = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(125743);
          return 0;
        case 25: 
          localbyn.GSV = ((f.a.a.a.a)localObject1).NPN.zd();
          AppMethodBeat.o(125743);
          return 0;
        case 26: 
          localbyn.GSW = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(125743);
          return 0;
        case 27: 
          localbyn.GSX = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(125743);
          return 0;
        case 28: 
          localbyn.GSY = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(125743);
          return 0;
        case 29: 
          localbyn.GSZ = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(125743);
          return 0;
        case 30: 
          localbyn.GTa = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(125743);
          return 0;
        case 31: 
          localbyn.GTb = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(125743);
          return 0;
        case 32: 
          localbyn.GTc = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(125743);
          return 0;
        case 33: 
          localbyn.GTd = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(125743);
          return 0;
        case 34: 
          localbyn.isAd = ((f.a.a.a.a)localObject1).NPN.grw();
          AppMethodBeat.o(125743);
          return 0;
        case 35: 
          localbyn.songAlbumUrl = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(125743);
          return 0;
        case 36: 
          localbyn.songLyric = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(125743);
          return 0;
        case 37: 
          localbyn.GTe = Float.intBitsToFloat(((f.a.a.a.a)localObject1).NPN.grz());
          AppMethodBeat.o(125743);
          return 0;
        }
        localbyn.mediaType = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(125743);
        return 0;
      }
      AppMethodBeat.o(125743);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.byn
 * JD-Core Version:    0.7.0.1
 */