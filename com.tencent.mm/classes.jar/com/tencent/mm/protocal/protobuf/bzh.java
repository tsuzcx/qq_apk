package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bzh
  extends com.tencent.mm.bw.a
{
  public int AIa;
  public String Aho;
  public String Desc;
  public int GXH;
  public String HmA;
  public String HmB;
  public int HmC;
  public String HmD;
  public String HmE;
  public float HmF;
  public String Hmj;
  public int Hmk;
  public int Hml;
  public bzj Hmm;
  public String Hmn;
  public int Hmo;
  public int Hmp;
  public String Hmq;
  public String Hmr;
  public String Hms;
  public String Hmt;
  public String Hmu;
  public int Hmv;
  public long Hmw;
  public String Hmx;
  public String Hmy;
  public int Hmz;
  public String Id;
  public String Title;
  public String Url;
  public int dKr;
  public boolean isAd;
  public String md5;
  public int mediaType;
  public int nJA;
  public String songAlbumUrl;
  public String songLyric;
  public int subType;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(125743);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.Id != null) {
        paramVarArgs.d(1, this.Id);
      }
      paramVarArgs.aS(2, this.nJA);
      if (this.Desc != null) {
        paramVarArgs.d(3, this.Desc);
      }
      if (this.Url != null) {
        paramVarArgs.d(4, this.Url);
      }
      paramVarArgs.aS(5, this.GXH);
      if (this.Hmj != null) {
        paramVarArgs.d(6, this.Hmj);
      }
      paramVarArgs.aS(7, this.Hmk);
      paramVarArgs.aS(8, this.Hml);
      if (this.Title != null) {
        paramVarArgs.d(9, this.Title);
      }
      if (this.Hmm != null)
      {
        paramVarArgs.lJ(10, this.Hmm.computeSize());
        this.Hmm.writeFields(paramVarArgs);
      }
      if (this.Hmn != null) {
        paramVarArgs.d(11, this.Hmn);
      }
      paramVarArgs.aS(12, this.Hmo);
      paramVarArgs.aS(13, this.dKr);
      paramVarArgs.aS(14, this.Hmp);
      if (this.Aho != null) {
        paramVarArgs.d(15, this.Aho);
      }
      paramVarArgs.aS(16, this.subType);
      if (this.md5 != null) {
        paramVarArgs.d(17, this.md5);
      }
      if (this.Hmq != null) {
        paramVarArgs.d(18, this.Hmq);
      }
      if (this.Hmr != null) {
        paramVarArgs.d(19, this.Hmr);
      }
      if (this.Hms != null) {
        paramVarArgs.d(20, this.Hms);
      }
      paramVarArgs.aS(21, this.AIa);
      if (this.Hmt != null) {
        paramVarArgs.d(22, this.Hmt);
      }
      if (this.Hmu != null) {
        paramVarArgs.d(23, this.Hmu);
      }
      paramVarArgs.aS(24, this.Hmv);
      paramVarArgs.aZ(25, this.Hmw);
      if (this.Hmx != null) {
        paramVarArgs.d(26, this.Hmx);
      }
      if (this.Hmy != null) {
        paramVarArgs.d(27, this.Hmy);
      }
      paramVarArgs.aS(28, this.Hmz);
      if (this.HmA != null) {
        paramVarArgs.d(29, this.HmA);
      }
      if (this.HmB != null) {
        paramVarArgs.d(30, this.HmB);
      }
      paramVarArgs.aS(31, this.HmC);
      if (this.HmD != null) {
        paramVarArgs.d(32, this.HmD);
      }
      if (this.HmE != null) {
        paramVarArgs.d(33, this.HmE);
      }
      paramVarArgs.bC(34, this.isAd);
      if (this.songAlbumUrl != null) {
        paramVarArgs.d(35, this.songAlbumUrl);
      }
      if (this.songLyric != null) {
        paramVarArgs.d(36, this.songLyric);
      }
      paramVarArgs.y(37, this.HmF);
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
      int i = paramInt + f.a.a.b.b.a.bz(2, this.nJA);
      paramInt = i;
      if (this.Desc != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.Desc);
      }
      i = paramInt;
      if (this.Url != null) {
        i = paramInt + f.a.a.b.b.a.e(4, this.Url);
      }
      i += f.a.a.b.b.a.bz(5, this.GXH);
      paramInt = i;
      if (this.Hmj != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.Hmj);
      }
      i = paramInt + f.a.a.b.b.a.bz(7, this.Hmk) + f.a.a.b.b.a.bz(8, this.Hml);
      paramInt = i;
      if (this.Title != null) {
        paramInt = i + f.a.a.b.b.a.e(9, this.Title);
      }
      i = paramInt;
      if (this.Hmm != null) {
        i = paramInt + f.a.a.a.lI(10, this.Hmm.computeSize());
      }
      paramInt = i;
      if (this.Hmn != null) {
        paramInt = i + f.a.a.b.b.a.e(11, this.Hmn);
      }
      i = paramInt + f.a.a.b.b.a.bz(12, this.Hmo) + f.a.a.b.b.a.bz(13, this.dKr) + f.a.a.b.b.a.bz(14, this.Hmp);
      paramInt = i;
      if (this.Aho != null) {
        paramInt = i + f.a.a.b.b.a.e(15, this.Aho);
      }
      i = paramInt + f.a.a.b.b.a.bz(16, this.subType);
      paramInt = i;
      if (this.md5 != null) {
        paramInt = i + f.a.a.b.b.a.e(17, this.md5);
      }
      i = paramInt;
      if (this.Hmq != null) {
        i = paramInt + f.a.a.b.b.a.e(18, this.Hmq);
      }
      paramInt = i;
      if (this.Hmr != null) {
        paramInt = i + f.a.a.b.b.a.e(19, this.Hmr);
      }
      i = paramInt;
      if (this.Hms != null) {
        i = paramInt + f.a.a.b.b.a.e(20, this.Hms);
      }
      i += f.a.a.b.b.a.bz(21, this.AIa);
      paramInt = i;
      if (this.Hmt != null) {
        paramInt = i + f.a.a.b.b.a.e(22, this.Hmt);
      }
      i = paramInt;
      if (this.Hmu != null) {
        i = paramInt + f.a.a.b.b.a.e(23, this.Hmu);
      }
      i = i + f.a.a.b.b.a.bz(24, this.Hmv) + f.a.a.b.b.a.p(25, this.Hmw);
      paramInt = i;
      if (this.Hmx != null) {
        paramInt = i + f.a.a.b.b.a.e(26, this.Hmx);
      }
      i = paramInt;
      if (this.Hmy != null) {
        i = paramInt + f.a.a.b.b.a.e(27, this.Hmy);
      }
      i += f.a.a.b.b.a.bz(28, this.Hmz);
      paramInt = i;
      if (this.HmA != null) {
        paramInt = i + f.a.a.b.b.a.e(29, this.HmA);
      }
      i = paramInt;
      if (this.HmB != null) {
        i = paramInt + f.a.a.b.b.a.e(30, this.HmB);
      }
      i += f.a.a.b.b.a.bz(31, this.HmC);
      paramInt = i;
      if (this.HmD != null) {
        paramInt = i + f.a.a.b.b.a.e(32, this.HmD);
      }
      i = paramInt;
      if (this.HmE != null) {
        i = paramInt + f.a.a.b.b.a.e(33, this.HmE);
      }
      i += f.a.a.b.b.a.amF(34);
      paramInt = i;
      if (this.songAlbumUrl != null) {
        paramInt = i + f.a.a.b.b.a.e(35, this.songAlbumUrl);
      }
      i = paramInt;
      if (this.songLyric != null) {
        i = paramInt + f.a.a.b.b.a.e(36, this.songLyric);
      }
      paramInt = f.a.a.b.b.a.amE(37);
      int j = f.a.a.b.b.a.bz(38, this.mediaType);
      AppMethodBeat.o(125743);
      return i + paramInt + j;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(125743);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        bzh localbzh = (bzh)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(125743);
          return -1;
        case 1: 
          localbzh.Id = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(125743);
          return 0;
        case 2: 
          localbzh.nJA = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(125743);
          return 0;
        case 3: 
          localbzh.Desc = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(125743);
          return 0;
        case 4: 
          localbzh.Url = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(125743);
          return 0;
        case 5: 
          localbzh.GXH = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(125743);
          return 0;
        case 6: 
          localbzh.Hmj = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(125743);
          return 0;
        case 7: 
          localbzh.Hmk = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(125743);
          return 0;
        case 8: 
          localbzh.Hml = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(125743);
          return 0;
        case 9: 
          localbzh.Title = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(125743);
          return 0;
        case 10: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bzj();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((bzj)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbzh.Hmm = ((bzj)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(125743);
          return 0;
        case 11: 
          localbzh.Hmn = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(125743);
          return 0;
        case 12: 
          localbzh.Hmo = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(125743);
          return 0;
        case 13: 
          localbzh.dKr = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(125743);
          return 0;
        case 14: 
          localbzh.Hmp = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(125743);
          return 0;
        case 15: 
          localbzh.Aho = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(125743);
          return 0;
        case 16: 
          localbzh.subType = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(125743);
          return 0;
        case 17: 
          localbzh.md5 = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(125743);
          return 0;
        case 18: 
          localbzh.Hmq = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(125743);
          return 0;
        case 19: 
          localbzh.Hmr = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(125743);
          return 0;
        case 20: 
          localbzh.Hms = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(125743);
          return 0;
        case 21: 
          localbzh.AIa = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(125743);
          return 0;
        case 22: 
          localbzh.Hmt = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(125743);
          return 0;
        case 23: 
          localbzh.Hmu = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(125743);
          return 0;
        case 24: 
          localbzh.Hmv = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(125743);
          return 0;
        case 25: 
          localbzh.Hmw = ((f.a.a.a.a)localObject1).OmT.zd();
          AppMethodBeat.o(125743);
          return 0;
        case 26: 
          localbzh.Hmx = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(125743);
          return 0;
        case 27: 
          localbzh.Hmy = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(125743);
          return 0;
        case 28: 
          localbzh.Hmz = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(125743);
          return 0;
        case 29: 
          localbzh.HmA = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(125743);
          return 0;
        case 30: 
          localbzh.HmB = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(125743);
          return 0;
        case 31: 
          localbzh.HmC = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(125743);
          return 0;
        case 32: 
          localbzh.HmD = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(125743);
          return 0;
        case 33: 
          localbzh.HmE = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(125743);
          return 0;
        case 34: 
          localbzh.isAd = ((f.a.a.a.a)localObject1).OmT.gvY();
          AppMethodBeat.o(125743);
          return 0;
        case 35: 
          localbzh.songAlbumUrl = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(125743);
          return 0;
        case 36: 
          localbzh.songLyric = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(125743);
          return 0;
        case 37: 
          localbzh.HmF = Float.intBitsToFloat(((f.a.a.a.a)localObject1).OmT.gwb());
          AppMethodBeat.o(125743);
          return 0;
        }
        localbzh.mediaType = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(125743);
        return 0;
      }
      AppMethodBeat.o(125743);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bzh
 * JD-Core Version:    0.7.0.1
 */