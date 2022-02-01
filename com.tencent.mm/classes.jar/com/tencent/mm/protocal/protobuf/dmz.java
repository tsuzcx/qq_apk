package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public class dmz
  extends com.tencent.mm.bx.a
{
  public String IGG;
  public String Id;
  public int Privated;
  public int RGm;
  public String RcB;
  public String Url;
  public String aaTA;
  public String aaTB;
  public int aaTC;
  public String aaTD;
  public String aaTE;
  public float aaTF;
  public String aaTl;
  public int aaTm;
  public dnb aaTn;
  public String aaTo;
  public int aaTp;
  public int aaTq;
  public String aaTr;
  public String aaTs;
  public String aaTt;
  public String aaTu;
  public String aaTv;
  public int aaTw;
  public long aaTx;
  public String aaTy;
  public int aaTz;
  public int aazR;
  public String hAP;
  public int icg;
  public boolean isAd;
  public String md5;
  public int mediaType;
  public String msf;
  public String songAlbumUrl;
  public String songLyric;
  public int subType;
  public int vhJ;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(125743);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.Id != null) {
        paramVarArgs.g(1, this.Id);
      }
      paramVarArgs.bS(2, this.vhJ);
      if (this.IGG != null) {
        paramVarArgs.g(3, this.IGG);
      }
      if (this.Url != null) {
        paramVarArgs.g(4, this.Url);
      }
      paramVarArgs.bS(5, this.aazR);
      if (this.aaTl != null) {
        paramVarArgs.g(6, this.aaTl);
      }
      paramVarArgs.bS(7, this.aaTm);
      paramVarArgs.bS(8, this.Privated);
      if (this.hAP != null) {
        paramVarArgs.g(9, this.hAP);
      }
      if (this.aaTn != null)
      {
        paramVarArgs.qD(10, this.aaTn.computeSize());
        this.aaTn.writeFields(paramVarArgs);
      }
      if (this.aaTo != null) {
        paramVarArgs.g(11, this.aaTo);
      }
      paramVarArgs.bS(12, this.aaTp);
      paramVarArgs.bS(13, this.icg);
      paramVarArgs.bS(14, this.aaTq);
      if (this.RcB != null) {
        paramVarArgs.g(15, this.RcB);
      }
      paramVarArgs.bS(16, this.subType);
      if (this.md5 != null) {
        paramVarArgs.g(17, this.md5);
      }
      if (this.aaTr != null) {
        paramVarArgs.g(18, this.aaTr);
      }
      if (this.aaTs != null) {
        paramVarArgs.g(19, this.aaTs);
      }
      if (this.aaTt != null) {
        paramVarArgs.g(20, this.aaTt);
      }
      paramVarArgs.bS(21, this.RGm);
      if (this.aaTu != null) {
        paramVarArgs.g(22, this.aaTu);
      }
      if (this.aaTv != null) {
        paramVarArgs.g(23, this.aaTv);
      }
      paramVarArgs.bS(24, this.aaTw);
      paramVarArgs.bv(25, this.aaTx);
      if (this.aaTy != null) {
        paramVarArgs.g(26, this.aaTy);
      }
      if (this.msf != null) {
        paramVarArgs.g(27, this.msf);
      }
      paramVarArgs.bS(28, this.aaTz);
      if (this.aaTA != null) {
        paramVarArgs.g(29, this.aaTA);
      }
      if (this.aaTB != null) {
        paramVarArgs.g(30, this.aaTB);
      }
      paramVarArgs.bS(31, this.aaTC);
      if (this.aaTD != null) {
        paramVarArgs.g(32, this.aaTD);
      }
      if (this.aaTE != null) {
        paramVarArgs.g(33, this.aaTE);
      }
      paramVarArgs.di(34, this.isAd);
      if (this.songAlbumUrl != null) {
        paramVarArgs.g(35, this.songAlbumUrl);
      }
      if (this.songLyric != null) {
        paramVarArgs.g(36, this.songLyric);
      }
      paramVarArgs.l(37, this.aaTF);
      paramVarArgs.bS(38, this.mediaType);
      AppMethodBeat.o(125743);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Id == null) {
        break label2307;
      }
    }
    label2307:
    for (paramInt = i.a.a.b.b.a.h(1, this.Id) + 0;; paramInt = 0)
    {
      int i = paramInt + i.a.a.b.b.a.cJ(2, this.vhJ);
      paramInt = i;
      if (this.IGG != null) {
        paramInt = i + i.a.a.b.b.a.h(3, this.IGG);
      }
      i = paramInt;
      if (this.Url != null) {
        i = paramInt + i.a.a.b.b.a.h(4, this.Url);
      }
      i += i.a.a.b.b.a.cJ(5, this.aazR);
      paramInt = i;
      if (this.aaTl != null) {
        paramInt = i + i.a.a.b.b.a.h(6, this.aaTl);
      }
      i = paramInt + i.a.a.b.b.a.cJ(7, this.aaTm) + i.a.a.b.b.a.cJ(8, this.Privated);
      paramInt = i;
      if (this.hAP != null) {
        paramInt = i + i.a.a.b.b.a.h(9, this.hAP);
      }
      i = paramInt;
      if (this.aaTn != null) {
        i = paramInt + i.a.a.a.qC(10, this.aaTn.computeSize());
      }
      paramInt = i;
      if (this.aaTo != null) {
        paramInt = i + i.a.a.b.b.a.h(11, this.aaTo);
      }
      i = paramInt + i.a.a.b.b.a.cJ(12, this.aaTp) + i.a.a.b.b.a.cJ(13, this.icg) + i.a.a.b.b.a.cJ(14, this.aaTq);
      paramInt = i;
      if (this.RcB != null) {
        paramInt = i + i.a.a.b.b.a.h(15, this.RcB);
      }
      i = paramInt + i.a.a.b.b.a.cJ(16, this.subType);
      paramInt = i;
      if (this.md5 != null) {
        paramInt = i + i.a.a.b.b.a.h(17, this.md5);
      }
      i = paramInt;
      if (this.aaTr != null) {
        i = paramInt + i.a.a.b.b.a.h(18, this.aaTr);
      }
      paramInt = i;
      if (this.aaTs != null) {
        paramInt = i + i.a.a.b.b.a.h(19, this.aaTs);
      }
      i = paramInt;
      if (this.aaTt != null) {
        i = paramInt + i.a.a.b.b.a.h(20, this.aaTt);
      }
      i += i.a.a.b.b.a.cJ(21, this.RGm);
      paramInt = i;
      if (this.aaTu != null) {
        paramInt = i + i.a.a.b.b.a.h(22, this.aaTu);
      }
      i = paramInt;
      if (this.aaTv != null) {
        i = paramInt + i.a.a.b.b.a.h(23, this.aaTv);
      }
      i = i + i.a.a.b.b.a.cJ(24, this.aaTw) + i.a.a.b.b.a.q(25, this.aaTx);
      paramInt = i;
      if (this.aaTy != null) {
        paramInt = i + i.a.a.b.b.a.h(26, this.aaTy);
      }
      i = paramInt;
      if (this.msf != null) {
        i = paramInt + i.a.a.b.b.a.h(27, this.msf);
      }
      i += i.a.a.b.b.a.cJ(28, this.aaTz);
      paramInt = i;
      if (this.aaTA != null) {
        paramInt = i + i.a.a.b.b.a.h(29, this.aaTA);
      }
      i = paramInt;
      if (this.aaTB != null) {
        i = paramInt + i.a.a.b.b.a.h(30, this.aaTB);
      }
      i += i.a.a.b.b.a.cJ(31, this.aaTC);
      paramInt = i;
      if (this.aaTD != null) {
        paramInt = i + i.a.a.b.b.a.h(32, this.aaTD);
      }
      i = paramInt;
      if (this.aaTE != null) {
        i = paramInt + i.a.a.b.b.a.h(33, this.aaTE);
      }
      i += i.a.a.b.b.a.ko(34) + 1;
      paramInt = i;
      if (this.songAlbumUrl != null) {
        paramInt = i + i.a.a.b.b.a.h(35, this.songAlbumUrl);
      }
      i = paramInt;
      if (this.songLyric != null) {
        i = paramInt + i.a.a.b.b.a.h(36, this.songLyric);
      }
      paramInt = i.a.a.b.b.a.ko(37);
      int j = i.a.a.b.b.a.cJ(38, this.mediaType);
      AppMethodBeat.o(125743);
      return i + (paramInt + 4) + j;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(125743);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        dmz localdmz = (dmz)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(125743);
          return -1;
        case 1: 
          localdmz.Id = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(125743);
          return 0;
        case 2: 
          localdmz.vhJ = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(125743);
          return 0;
        case 3: 
          localdmz.IGG = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(125743);
          return 0;
        case 4: 
          localdmz.Url = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(125743);
          return 0;
        case 5: 
          localdmz.aazR = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(125743);
          return 0;
        case 6: 
          localdmz.aaTl = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(125743);
          return 0;
        case 7: 
          localdmz.aaTm = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(125743);
          return 0;
        case 8: 
          localdmz.Privated = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(125743);
          return 0;
        case 9: 
          localdmz.hAP = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(125743);
          return 0;
        case 10: 
          paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            dnb localdnb = new dnb();
            if ((localObject != null) && (localObject.length > 0)) {
              localdnb.parseFrom((byte[])localObject);
            }
            localdmz.aaTn = localdnb;
            paramInt += 1;
          }
          AppMethodBeat.o(125743);
          return 0;
        case 11: 
          localdmz.aaTo = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(125743);
          return 0;
        case 12: 
          localdmz.aaTp = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(125743);
          return 0;
        case 13: 
          localdmz.icg = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(125743);
          return 0;
        case 14: 
          localdmz.aaTq = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(125743);
          return 0;
        case 15: 
          localdmz.RcB = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(125743);
          return 0;
        case 16: 
          localdmz.subType = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(125743);
          return 0;
        case 17: 
          localdmz.md5 = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(125743);
          return 0;
        case 18: 
          localdmz.aaTr = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(125743);
          return 0;
        case 19: 
          localdmz.aaTs = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(125743);
          return 0;
        case 20: 
          localdmz.aaTt = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(125743);
          return 0;
        case 21: 
          localdmz.RGm = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(125743);
          return 0;
        case 22: 
          localdmz.aaTu = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(125743);
          return 0;
        case 23: 
          localdmz.aaTv = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(125743);
          return 0;
        case 24: 
          localdmz.aaTw = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(125743);
          return 0;
        case 25: 
          localdmz.aaTx = ((i.a.a.a.a)localObject).ajGk.aaw();
          AppMethodBeat.o(125743);
          return 0;
        case 26: 
          localdmz.aaTy = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(125743);
          return 0;
        case 27: 
          localdmz.msf = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(125743);
          return 0;
        case 28: 
          localdmz.aaTz = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(125743);
          return 0;
        case 29: 
          localdmz.aaTA = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(125743);
          return 0;
        case 30: 
          localdmz.aaTB = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(125743);
          return 0;
        case 31: 
          localdmz.aaTC = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(125743);
          return 0;
        case 32: 
          localdmz.aaTD = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(125743);
          return 0;
        case 33: 
          localdmz.aaTE = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(125743);
          return 0;
        case 34: 
          localdmz.isAd = ((i.a.a.a.a)localObject).ajGk.aai();
          AppMethodBeat.o(125743);
          return 0;
        case 35: 
          localdmz.songAlbumUrl = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(125743);
          return 0;
        case 36: 
          localdmz.songLyric = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(125743);
          return 0;
        case 37: 
          localdmz.aaTF = Float.intBitsToFloat(((i.a.a.a.a)localObject).ajGk.aax());
          AppMethodBeat.o(125743);
          return 0;
        }
        localdmz.mediaType = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(125743);
        return 0;
      }
      AppMethodBeat.o(125743);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dmz
 * JD-Core Version:    0.7.0.1
 */