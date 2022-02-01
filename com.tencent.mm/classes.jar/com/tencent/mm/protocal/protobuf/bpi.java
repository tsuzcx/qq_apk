package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bpi
  extends com.tencent.mm.bx.a
{
  public String DMQ;
  public int DMR;
  public int DMS;
  public bpk DMT;
  public String DMU;
  public int DMV;
  public int DMW;
  public String DMX;
  public String DMY;
  public String DMZ;
  public String DNa;
  public String DNb;
  public int DNc;
  public long DNd;
  public String DNe;
  public String DNf;
  public int DNg;
  public String DNh;
  public String DNi;
  public int DNj;
  public String DNk;
  public String DNl;
  public float DNm;
  public String Desc;
  public int Dzl;
  public String Id;
  public String Title;
  public String Url;
  public int dzf;
  public boolean isAd;
  public int mBH;
  public String md5;
  public int mediaType;
  public String songAlbumUrl;
  public String songLyric;
  public int subType;
  public int xMj;
  public String xmd;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(125743);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.Id != null) {
        paramVarArgs.d(1, this.Id);
      }
      paramVarArgs.aR(2, this.mBH);
      if (this.Desc != null) {
        paramVarArgs.d(3, this.Desc);
      }
      if (this.Url != null) {
        paramVarArgs.d(4, this.Url);
      }
      paramVarArgs.aR(5, this.Dzl);
      if (this.DMQ != null) {
        paramVarArgs.d(6, this.DMQ);
      }
      paramVarArgs.aR(7, this.DMR);
      paramVarArgs.aR(8, this.DMS);
      if (this.Title != null) {
        paramVarArgs.d(9, this.Title);
      }
      if (this.DMT != null)
      {
        paramVarArgs.kX(10, this.DMT.computeSize());
        this.DMT.writeFields(paramVarArgs);
      }
      if (this.DMU != null) {
        paramVarArgs.d(11, this.DMU);
      }
      paramVarArgs.aR(12, this.DMV);
      paramVarArgs.aR(13, this.dzf);
      paramVarArgs.aR(14, this.DMW);
      if (this.xmd != null) {
        paramVarArgs.d(15, this.xmd);
      }
      paramVarArgs.aR(16, this.subType);
      if (this.md5 != null) {
        paramVarArgs.d(17, this.md5);
      }
      if (this.DMX != null) {
        paramVarArgs.d(18, this.DMX);
      }
      if (this.DMY != null) {
        paramVarArgs.d(19, this.DMY);
      }
      if (this.DMZ != null) {
        paramVarArgs.d(20, this.DMZ);
      }
      paramVarArgs.aR(21, this.xMj);
      if (this.DNa != null) {
        paramVarArgs.d(22, this.DNa);
      }
      if (this.DNb != null) {
        paramVarArgs.d(23, this.DNb);
      }
      paramVarArgs.aR(24, this.DNc);
      paramVarArgs.aG(25, this.DNd);
      if (this.DNe != null) {
        paramVarArgs.d(26, this.DNe);
      }
      if (this.DNf != null) {
        paramVarArgs.d(27, this.DNf);
      }
      paramVarArgs.aR(28, this.DNg);
      if (this.DNh != null) {
        paramVarArgs.d(29, this.DNh);
      }
      if (this.DNi != null) {
        paramVarArgs.d(30, this.DNi);
      }
      paramVarArgs.aR(31, this.DNj);
      if (this.DNk != null) {
        paramVarArgs.d(32, this.DNk);
      }
      if (this.DNl != null) {
        paramVarArgs.d(33, this.DNl);
      }
      paramVarArgs.bg(34, this.isAd);
      if (this.songAlbumUrl != null) {
        paramVarArgs.d(35, this.songAlbumUrl);
      }
      if (this.songLyric != null) {
        paramVarArgs.d(36, this.songLyric);
      }
      paramVarArgs.x(37, this.DNm);
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
      int i = paramInt + f.a.a.b.b.a.bA(2, this.mBH);
      paramInt = i;
      if (this.Desc != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.Desc);
      }
      i = paramInt;
      if (this.Url != null) {
        i = paramInt + f.a.a.b.b.a.e(4, this.Url);
      }
      i += f.a.a.b.b.a.bA(5, this.Dzl);
      paramInt = i;
      if (this.DMQ != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.DMQ);
      }
      i = paramInt + f.a.a.b.b.a.bA(7, this.DMR) + f.a.a.b.b.a.bA(8, this.DMS);
      paramInt = i;
      if (this.Title != null) {
        paramInt = i + f.a.a.b.b.a.e(9, this.Title);
      }
      i = paramInt;
      if (this.DMT != null) {
        i = paramInt + f.a.a.a.kW(10, this.DMT.computeSize());
      }
      paramInt = i;
      if (this.DMU != null) {
        paramInt = i + f.a.a.b.b.a.e(11, this.DMU);
      }
      i = paramInt + f.a.a.b.b.a.bA(12, this.DMV) + f.a.a.b.b.a.bA(13, this.dzf) + f.a.a.b.b.a.bA(14, this.DMW);
      paramInt = i;
      if (this.xmd != null) {
        paramInt = i + f.a.a.b.b.a.e(15, this.xmd);
      }
      i = paramInt + f.a.a.b.b.a.bA(16, this.subType);
      paramInt = i;
      if (this.md5 != null) {
        paramInt = i + f.a.a.b.b.a.e(17, this.md5);
      }
      i = paramInt;
      if (this.DMX != null) {
        i = paramInt + f.a.a.b.b.a.e(18, this.DMX);
      }
      paramInt = i;
      if (this.DMY != null) {
        paramInt = i + f.a.a.b.b.a.e(19, this.DMY);
      }
      i = paramInt;
      if (this.DMZ != null) {
        i = paramInt + f.a.a.b.b.a.e(20, this.DMZ);
      }
      i += f.a.a.b.b.a.bA(21, this.xMj);
      paramInt = i;
      if (this.DNa != null) {
        paramInt = i + f.a.a.b.b.a.e(22, this.DNa);
      }
      i = paramInt;
      if (this.DNb != null) {
        i = paramInt + f.a.a.b.b.a.e(23, this.DNb);
      }
      i = i + f.a.a.b.b.a.bA(24, this.DNc) + f.a.a.b.b.a.q(25, this.DNd);
      paramInt = i;
      if (this.DNe != null) {
        paramInt = i + f.a.a.b.b.a.e(26, this.DNe);
      }
      i = paramInt;
      if (this.DNf != null) {
        i = paramInt + f.a.a.b.b.a.e(27, this.DNf);
      }
      i += f.a.a.b.b.a.bA(28, this.DNg);
      paramInt = i;
      if (this.DNh != null) {
        paramInt = i + f.a.a.b.b.a.e(29, this.DNh);
      }
      i = paramInt;
      if (this.DNi != null) {
        i = paramInt + f.a.a.b.b.a.e(30, this.DNi);
      }
      i += f.a.a.b.b.a.bA(31, this.DNj);
      paramInt = i;
      if (this.DNk != null) {
        paramInt = i + f.a.a.b.b.a.e(32, this.DNk);
      }
      i = paramInt;
      if (this.DNl != null) {
        i = paramInt + f.a.a.b.b.a.e(33, this.DNl);
      }
      i += f.a.a.b.b.a.fY(34) + 1;
      paramInt = i;
      if (this.songAlbumUrl != null) {
        paramInt = i + f.a.a.b.b.a.e(35, this.songAlbumUrl);
      }
      i = paramInt;
      if (this.songLyric != null) {
        i = paramInt + f.a.a.b.b.a.e(36, this.songLyric);
      }
      paramInt = f.a.a.b.b.a.fY(37);
      int j = f.a.a.b.b.a.bA(38, this.mediaType);
      AppMethodBeat.o(125743);
      return i + (paramInt + 4) + j;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(125743);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        bpi localbpi = (bpi)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(125743);
          return -1;
        case 1: 
          localbpi.Id = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(125743);
          return 0;
        case 2: 
          localbpi.mBH = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(125743);
          return 0;
        case 3: 
          localbpi.Desc = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(125743);
          return 0;
        case 4: 
          localbpi.Url = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(125743);
          return 0;
        case 5: 
          localbpi.Dzl = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(125743);
          return 0;
        case 6: 
          localbpi.DMQ = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(125743);
          return 0;
        case 7: 
          localbpi.DMR = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(125743);
          return 0;
        case 8: 
          localbpi.DMS = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(125743);
          return 0;
        case 9: 
          localbpi.Title = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(125743);
          return 0;
        case 10: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bpk();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((bpk)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbpi.DMT = ((bpk)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(125743);
          return 0;
        case 11: 
          localbpi.DMU = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(125743);
          return 0;
        case 12: 
          localbpi.DMV = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(125743);
          return 0;
        case 13: 
          localbpi.dzf = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(125743);
          return 0;
        case 14: 
          localbpi.DMW = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(125743);
          return 0;
        case 15: 
          localbpi.xmd = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(125743);
          return 0;
        case 16: 
          localbpi.subType = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(125743);
          return 0;
        case 17: 
          localbpi.md5 = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(125743);
          return 0;
        case 18: 
          localbpi.DMX = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(125743);
          return 0;
        case 19: 
          localbpi.DMY = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(125743);
          return 0;
        case 20: 
          localbpi.DMZ = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(125743);
          return 0;
        case 21: 
          localbpi.xMj = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(125743);
          return 0;
        case 22: 
          localbpi.DNa = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(125743);
          return 0;
        case 23: 
          localbpi.DNb = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(125743);
          return 0;
        case 24: 
          localbpi.DNc = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(125743);
          return 0;
        case 25: 
          localbpi.DNd = ((f.a.a.a.a)localObject1).KhF.xT();
          AppMethodBeat.o(125743);
          return 0;
        case 26: 
          localbpi.DNe = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(125743);
          return 0;
        case 27: 
          localbpi.DNf = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(125743);
          return 0;
        case 28: 
          localbpi.DNg = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(125743);
          return 0;
        case 29: 
          localbpi.DNh = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(125743);
          return 0;
        case 30: 
          localbpi.DNi = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(125743);
          return 0;
        case 31: 
          localbpi.DNj = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(125743);
          return 0;
        case 32: 
          localbpi.DNk = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(125743);
          return 0;
        case 33: 
          localbpi.DNl = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(125743);
          return 0;
        case 34: 
          localbpi.isAd = ((f.a.a.a.a)localObject1).KhF.fHu();
          AppMethodBeat.o(125743);
          return 0;
        case 35: 
          localbpi.songAlbumUrl = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(125743);
          return 0;
        case 36: 
          localbpi.songLyric = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(125743);
          return 0;
        case 37: 
          localbpi.DNm = Float.intBitsToFloat(((f.a.a.a.a)localObject1).KhF.fHx());
          AppMethodBeat.o(125743);
          return 0;
        }
        localbpi.mediaType = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(125743);
        return 0;
      }
      AppMethodBeat.o(125743);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bpi
 * JD-Core Version:    0.7.0.1
 */