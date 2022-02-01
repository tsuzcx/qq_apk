package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class btz
  extends com.tencent.mm.bw.a
{
  public String Desc;
  public int EUH;
  public int FjA;
  public String FjB;
  public String FjC;
  public float FjD;
  public String Fjh;
  public int Fji;
  public int Fjj;
  public bub Fjk;
  public String Fjl;
  public int Fjm;
  public int Fjn;
  public String Fjo;
  public String Fjp;
  public String Fjq;
  public String Fjr;
  public String Fjs;
  public int Fjt;
  public long Fju;
  public String Fjv;
  public String Fjw;
  public int Fjx;
  public String Fjy;
  public String Fjz;
  public String Id;
  public String Title;
  public String Url;
  public int dwR;
  public boolean isAd;
  public String md5;
  public int mediaType;
  public int ndI;
  public String songAlbumUrl;
  public String songLyric;
  public int subType;
  public int yYY;
  public String yyV;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(125743);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.Id != null) {
        paramVarArgs.d(1, this.Id);
      }
      paramVarArgs.aR(2, this.ndI);
      if (this.Desc != null) {
        paramVarArgs.d(3, this.Desc);
      }
      if (this.Url != null) {
        paramVarArgs.d(4, this.Url);
      }
      paramVarArgs.aR(5, this.EUH);
      if (this.Fjh != null) {
        paramVarArgs.d(6, this.Fjh);
      }
      paramVarArgs.aR(7, this.Fji);
      paramVarArgs.aR(8, this.Fjj);
      if (this.Title != null) {
        paramVarArgs.d(9, this.Title);
      }
      if (this.Fjk != null)
      {
        paramVarArgs.ln(10, this.Fjk.computeSize());
        this.Fjk.writeFields(paramVarArgs);
      }
      if (this.Fjl != null) {
        paramVarArgs.d(11, this.Fjl);
      }
      paramVarArgs.aR(12, this.Fjm);
      paramVarArgs.aR(13, this.dwR);
      paramVarArgs.aR(14, this.Fjn);
      if (this.yyV != null) {
        paramVarArgs.d(15, this.yyV);
      }
      paramVarArgs.aR(16, this.subType);
      if (this.md5 != null) {
        paramVarArgs.d(17, this.md5);
      }
      if (this.Fjo != null) {
        paramVarArgs.d(18, this.Fjo);
      }
      if (this.Fjp != null) {
        paramVarArgs.d(19, this.Fjp);
      }
      if (this.Fjq != null) {
        paramVarArgs.d(20, this.Fjq);
      }
      paramVarArgs.aR(21, this.yYY);
      if (this.Fjr != null) {
        paramVarArgs.d(22, this.Fjr);
      }
      if (this.Fjs != null) {
        paramVarArgs.d(23, this.Fjs);
      }
      paramVarArgs.aR(24, this.Fjt);
      paramVarArgs.aO(25, this.Fju);
      if (this.Fjv != null) {
        paramVarArgs.d(26, this.Fjv);
      }
      if (this.Fjw != null) {
        paramVarArgs.d(27, this.Fjw);
      }
      paramVarArgs.aR(28, this.Fjx);
      if (this.Fjy != null) {
        paramVarArgs.d(29, this.Fjy);
      }
      if (this.Fjz != null) {
        paramVarArgs.d(30, this.Fjz);
      }
      paramVarArgs.aR(31, this.FjA);
      if (this.FjB != null) {
        paramVarArgs.d(32, this.FjB);
      }
      if (this.FjC != null) {
        paramVarArgs.d(33, this.FjC);
      }
      paramVarArgs.bl(34, this.isAd);
      if (this.songAlbumUrl != null) {
        paramVarArgs.d(35, this.songAlbumUrl);
      }
      if (this.songLyric != null) {
        paramVarArgs.d(36, this.songLyric);
      }
      paramVarArgs.x(37, this.FjD);
      paramVarArgs.aR(38, this.mediaType);
      AppMethodBeat.o(125743);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Id == null) {
        break label2333;
      }
    }
    label2333:
    for (paramInt = f.a.a.b.b.a.e(1, this.Id) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bx(2, this.ndI);
      paramInt = i;
      if (this.Desc != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.Desc);
      }
      i = paramInt;
      if (this.Url != null) {
        i = paramInt + f.a.a.b.b.a.e(4, this.Url);
      }
      i += f.a.a.b.b.a.bx(5, this.EUH);
      paramInt = i;
      if (this.Fjh != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.Fjh);
      }
      i = paramInt + f.a.a.b.b.a.bx(7, this.Fji) + f.a.a.b.b.a.bx(8, this.Fjj);
      paramInt = i;
      if (this.Title != null) {
        paramInt = i + f.a.a.b.b.a.e(9, this.Title);
      }
      i = paramInt;
      if (this.Fjk != null) {
        i = paramInt + f.a.a.a.lm(10, this.Fjk.computeSize());
      }
      paramInt = i;
      if (this.Fjl != null) {
        paramInt = i + f.a.a.b.b.a.e(11, this.Fjl);
      }
      i = paramInt + f.a.a.b.b.a.bx(12, this.Fjm) + f.a.a.b.b.a.bx(13, this.dwR) + f.a.a.b.b.a.bx(14, this.Fjn);
      paramInt = i;
      if (this.yyV != null) {
        paramInt = i + f.a.a.b.b.a.e(15, this.yyV);
      }
      i = paramInt + f.a.a.b.b.a.bx(16, this.subType);
      paramInt = i;
      if (this.md5 != null) {
        paramInt = i + f.a.a.b.b.a.e(17, this.md5);
      }
      i = paramInt;
      if (this.Fjo != null) {
        i = paramInt + f.a.a.b.b.a.e(18, this.Fjo);
      }
      paramInt = i;
      if (this.Fjp != null) {
        paramInt = i + f.a.a.b.b.a.e(19, this.Fjp);
      }
      i = paramInt;
      if (this.Fjq != null) {
        i = paramInt + f.a.a.b.b.a.e(20, this.Fjq);
      }
      i += f.a.a.b.b.a.bx(21, this.yYY);
      paramInt = i;
      if (this.Fjr != null) {
        paramInt = i + f.a.a.b.b.a.e(22, this.Fjr);
      }
      i = paramInt;
      if (this.Fjs != null) {
        i = paramInt + f.a.a.b.b.a.e(23, this.Fjs);
      }
      i = i + f.a.a.b.b.a.bx(24, this.Fjt) + f.a.a.b.b.a.p(25, this.Fju);
      paramInt = i;
      if (this.Fjv != null) {
        paramInt = i + f.a.a.b.b.a.e(26, this.Fjv);
      }
      i = paramInt;
      if (this.Fjw != null) {
        i = paramInt + f.a.a.b.b.a.e(27, this.Fjw);
      }
      i += f.a.a.b.b.a.bx(28, this.Fjx);
      paramInt = i;
      if (this.Fjy != null) {
        paramInt = i + f.a.a.b.b.a.e(29, this.Fjy);
      }
      i = paramInt;
      if (this.Fjz != null) {
        i = paramInt + f.a.a.b.b.a.e(30, this.Fjz);
      }
      i += f.a.a.b.b.a.bx(31, this.FjA);
      paramInt = i;
      if (this.FjB != null) {
        paramInt = i + f.a.a.b.b.a.e(32, this.FjB);
      }
      i = paramInt;
      if (this.FjC != null) {
        i = paramInt + f.a.a.b.b.a.e(33, this.FjC);
      }
      i += f.a.a.b.b.a.fK(34) + 1;
      paramInt = i;
      if (this.songAlbumUrl != null) {
        paramInt = i + f.a.a.b.b.a.e(35, this.songAlbumUrl);
      }
      i = paramInt;
      if (this.songLyric != null) {
        i = paramInt + f.a.a.b.b.a.e(36, this.songLyric);
      }
      paramInt = f.a.a.b.b.a.fK(37);
      int j = f.a.a.b.b.a.bx(38, this.mediaType);
      AppMethodBeat.o(125743);
      return i + (paramInt + 4) + j;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(125743);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        btz localbtz = (btz)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(125743);
          return -1;
        case 1: 
          localbtz.Id = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(125743);
          return 0;
        case 2: 
          localbtz.ndI = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(125743);
          return 0;
        case 3: 
          localbtz.Desc = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(125743);
          return 0;
        case 4: 
          localbtz.Url = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(125743);
          return 0;
        case 5: 
          localbtz.EUH = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(125743);
          return 0;
        case 6: 
          localbtz.Fjh = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(125743);
          return 0;
        case 7: 
          localbtz.Fji = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(125743);
          return 0;
        case 8: 
          localbtz.Fjj = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(125743);
          return 0;
        case 9: 
          localbtz.Title = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(125743);
          return 0;
        case 10: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bub();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((bub)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbtz.Fjk = ((bub)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(125743);
          return 0;
        case 11: 
          localbtz.Fjl = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(125743);
          return 0;
        case 12: 
          localbtz.Fjm = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(125743);
          return 0;
        case 13: 
          localbtz.dwR = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(125743);
          return 0;
        case 14: 
          localbtz.Fjn = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(125743);
          return 0;
        case 15: 
          localbtz.yyV = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(125743);
          return 0;
        case 16: 
          localbtz.subType = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(125743);
          return 0;
        case 17: 
          localbtz.md5 = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(125743);
          return 0;
        case 18: 
          localbtz.Fjo = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(125743);
          return 0;
        case 19: 
          localbtz.Fjp = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(125743);
          return 0;
        case 20: 
          localbtz.Fjq = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(125743);
          return 0;
        case 21: 
          localbtz.yYY = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(125743);
          return 0;
        case 22: 
          localbtz.Fjr = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(125743);
          return 0;
        case 23: 
          localbtz.Fjs = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(125743);
          return 0;
        case 24: 
          localbtz.Fjt = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(125743);
          return 0;
        case 25: 
          localbtz.Fju = ((f.a.a.a.a)localObject1).LVo.xG();
          AppMethodBeat.o(125743);
          return 0;
        case 26: 
          localbtz.Fjv = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(125743);
          return 0;
        case 27: 
          localbtz.Fjw = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(125743);
          return 0;
        case 28: 
          localbtz.Fjx = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(125743);
          return 0;
        case 29: 
          localbtz.Fjy = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(125743);
          return 0;
        case 30: 
          localbtz.Fjz = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(125743);
          return 0;
        case 31: 
          localbtz.FjA = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(125743);
          return 0;
        case 32: 
          localbtz.FjB = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(125743);
          return 0;
        case 33: 
          localbtz.FjC = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(125743);
          return 0;
        case 34: 
          localbtz.isAd = ((f.a.a.a.a)localObject1).LVo.fZX();
          AppMethodBeat.o(125743);
          return 0;
        case 35: 
          localbtz.songAlbumUrl = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(125743);
          return 0;
        case 36: 
          localbtz.songLyric = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(125743);
          return 0;
        case 37: 
          localbtz.FjD = Float.intBitsToFloat(((f.a.a.a.a)localObject1).LVo.gaa());
          AppMethodBeat.o(125743);
          return 0;
        }
        localbtz.mediaType = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(125743);
        return 0;
      }
      AppMethodBeat.o(125743);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.btz
 * JD-Core Version:    0.7.0.1
 */