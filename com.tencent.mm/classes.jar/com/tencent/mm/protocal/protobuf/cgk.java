package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cgk
  extends esc
{
  public String YBA;
  public String YBB;
  public String YBD;
  public String YBE;
  public String YBF;
  public String YBG;
  public String YBH;
  public String YBI;
  public String YBJ;
  public String YBK;
  public String YBk;
  public String YBl;
  public String YBm;
  public String YBn;
  public String YBo;
  public String YBp;
  public String YBq;
  public String YBr;
  public String YBs;
  public String YBt;
  public String YBu;
  public String YBv;
  public boolean YBw = false;
  public int YBx;
  public int YBy;
  public int YBz;
  public int aapx;
  public String content;
  public String nRQ;
  public String wsy;
  public String wtA;
  public String wtB;
  public String wtC;
  public String wtD;
  public String wtE;
  public int wtr;
  public String wts;
  public String wtt;
  public String wtu;
  public String wtv;
  public String wtw;
  public String wtx;
  public int wty;
  public String wtz;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(114009);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse != null)
      {
        paramVarArgs.qD(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.YBk != null) {
        paramVarArgs.g(2, this.YBk);
      }
      if (this.YBl != null) {
        paramVarArgs.g(3, this.YBl);
      }
      if (this.YBm != null) {
        paramVarArgs.g(4, this.YBm);
      }
      if (this.content != null) {
        paramVarArgs.g(5, this.content);
      }
      if (this.YBn != null) {
        paramVarArgs.g(6, this.YBn);
      }
      if (this.YBo != null) {
        paramVarArgs.g(7, this.YBo);
      }
      if (this.YBp != null) {
        paramVarArgs.g(8, this.YBp);
      }
      if (this.YBq != null) {
        paramVarArgs.g(9, this.YBq);
      }
      if (this.YBr != null) {
        paramVarArgs.g(10, this.YBr);
      }
      if (this.YBs != null) {
        paramVarArgs.g(11, this.YBs);
      }
      if (this.YBt != null) {
        paramVarArgs.g(12, this.YBt);
      }
      if (this.YBu != null) {
        paramVarArgs.g(13, this.YBu);
      }
      if (this.wtD != null) {
        paramVarArgs.g(14, this.wtD);
      }
      if (this.wtE != null) {
        paramVarArgs.g(15, this.wtE);
      }
      if (this.YBv != null) {
        paramVarArgs.g(16, this.YBv);
      }
      paramVarArgs.di(17, this.YBw);
      paramVarArgs.bS(18, this.YBx);
      paramVarArgs.bS(19, this.YBy);
      paramVarArgs.bS(20, this.YBz);
      if (this.nRQ != null) {
        paramVarArgs.g(21, this.nRQ);
      }
      if (this.YBA != null) {
        paramVarArgs.g(22, this.YBA);
      }
      if (this.YBB != null) {
        paramVarArgs.g(23, this.YBB);
      }
      paramVarArgs.bS(24, this.aapx);
      if (this.YBD != null) {
        paramVarArgs.g(25, this.YBD);
      }
      if (this.YBE != null) {
        paramVarArgs.g(26, this.YBE);
      }
      if (this.YBF != null) {
        paramVarArgs.g(27, this.YBF);
      }
      if (this.YBG != null) {
        paramVarArgs.g(28, this.YBG);
      }
      if (this.YBH != null) {
        paramVarArgs.g(29, this.YBH);
      }
      if (this.YBI != null) {
        paramVarArgs.g(30, this.YBI);
      }
      if (this.YBJ != null) {
        paramVarArgs.g(31, this.YBJ);
      }
      if (this.wsy != null) {
        paramVarArgs.g(32, this.wsy);
      }
      if (this.YBK != null) {
        paramVarArgs.g(33, this.YBK);
      }
      paramVarArgs.bS(37, this.wtr);
      if (this.wts != null) {
        paramVarArgs.g(38, this.wts);
      }
      if (this.wtt != null) {
        paramVarArgs.g(39, this.wtt);
      }
      if (this.wtu != null) {
        paramVarArgs.g(40, this.wtu);
      }
      if (this.wtv != null) {
        paramVarArgs.g(41, this.wtv);
      }
      if (this.wtw != null) {
        paramVarArgs.g(42, this.wtw);
      }
      if (this.wtx != null) {
        paramVarArgs.g(43, this.wtx);
      }
      paramVarArgs.bS(44, this.wty);
      if (this.wtz != null) {
        paramVarArgs.g(45, this.wtz);
      }
      if (this.wtA != null) {
        paramVarArgs.g(46, this.wtA);
      }
      if (this.wtB != null) {
        paramVarArgs.g(47, this.wtB);
      }
      if (this.wtC != null) {
        paramVarArgs.g(48, this.wtC);
      }
      AppMethodBeat.o(114009);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label2896;
      }
    }
    label2896:
    for (int i = i.a.a.a.qC(1, this.BaseResponse.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.YBk != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.YBk);
      }
      i = paramInt;
      if (this.YBl != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.YBl);
      }
      paramInt = i;
      if (this.YBm != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.YBm);
      }
      i = paramInt;
      if (this.content != null) {
        i = paramInt + i.a.a.b.b.a.h(5, this.content);
      }
      paramInt = i;
      if (this.YBn != null) {
        paramInt = i + i.a.a.b.b.a.h(6, this.YBn);
      }
      i = paramInt;
      if (this.YBo != null) {
        i = paramInt + i.a.a.b.b.a.h(7, this.YBo);
      }
      paramInt = i;
      if (this.YBp != null) {
        paramInt = i + i.a.a.b.b.a.h(8, this.YBp);
      }
      i = paramInt;
      if (this.YBq != null) {
        i = paramInt + i.a.a.b.b.a.h(9, this.YBq);
      }
      paramInt = i;
      if (this.YBr != null) {
        paramInt = i + i.a.a.b.b.a.h(10, this.YBr);
      }
      i = paramInt;
      if (this.YBs != null) {
        i = paramInt + i.a.a.b.b.a.h(11, this.YBs);
      }
      paramInt = i;
      if (this.YBt != null) {
        paramInt = i + i.a.a.b.b.a.h(12, this.YBt);
      }
      i = paramInt;
      if (this.YBu != null) {
        i = paramInt + i.a.a.b.b.a.h(13, this.YBu);
      }
      paramInt = i;
      if (this.wtD != null) {
        paramInt = i + i.a.a.b.b.a.h(14, this.wtD);
      }
      i = paramInt;
      if (this.wtE != null) {
        i = paramInt + i.a.a.b.b.a.h(15, this.wtE);
      }
      paramInt = i;
      if (this.YBv != null) {
        paramInt = i + i.a.a.b.b.a.h(16, this.YBv);
      }
      i = paramInt + (i.a.a.b.b.a.ko(17) + 1) + i.a.a.b.b.a.cJ(18, this.YBx) + i.a.a.b.b.a.cJ(19, this.YBy) + i.a.a.b.b.a.cJ(20, this.YBz);
      paramInt = i;
      if (this.nRQ != null) {
        paramInt = i + i.a.a.b.b.a.h(21, this.nRQ);
      }
      i = paramInt;
      if (this.YBA != null) {
        i = paramInt + i.a.a.b.b.a.h(22, this.YBA);
      }
      paramInt = i;
      if (this.YBB != null) {
        paramInt = i + i.a.a.b.b.a.h(23, this.YBB);
      }
      i = paramInt + i.a.a.b.b.a.cJ(24, this.aapx);
      paramInt = i;
      if (this.YBD != null) {
        paramInt = i + i.a.a.b.b.a.h(25, this.YBD);
      }
      i = paramInt;
      if (this.YBE != null) {
        i = paramInt + i.a.a.b.b.a.h(26, this.YBE);
      }
      paramInt = i;
      if (this.YBF != null) {
        paramInt = i + i.a.a.b.b.a.h(27, this.YBF);
      }
      i = paramInt;
      if (this.YBG != null) {
        i = paramInt + i.a.a.b.b.a.h(28, this.YBG);
      }
      paramInt = i;
      if (this.YBH != null) {
        paramInt = i + i.a.a.b.b.a.h(29, this.YBH);
      }
      i = paramInt;
      if (this.YBI != null) {
        i = paramInt + i.a.a.b.b.a.h(30, this.YBI);
      }
      paramInt = i;
      if (this.YBJ != null) {
        paramInt = i + i.a.a.b.b.a.h(31, this.YBJ);
      }
      i = paramInt;
      if (this.wsy != null) {
        i = paramInt + i.a.a.b.b.a.h(32, this.wsy);
      }
      paramInt = i;
      if (this.YBK != null) {
        paramInt = i + i.a.a.b.b.a.h(33, this.YBK);
      }
      i = paramInt + i.a.a.b.b.a.cJ(37, this.wtr);
      paramInt = i;
      if (this.wts != null) {
        paramInt = i + i.a.a.b.b.a.h(38, this.wts);
      }
      i = paramInt;
      if (this.wtt != null) {
        i = paramInt + i.a.a.b.b.a.h(39, this.wtt);
      }
      paramInt = i;
      if (this.wtu != null) {
        paramInt = i + i.a.a.b.b.a.h(40, this.wtu);
      }
      i = paramInt;
      if (this.wtv != null) {
        i = paramInt + i.a.a.b.b.a.h(41, this.wtv);
      }
      paramInt = i;
      if (this.wtw != null) {
        paramInt = i + i.a.a.b.b.a.h(42, this.wtw);
      }
      i = paramInt;
      if (this.wtx != null) {
        i = paramInt + i.a.a.b.b.a.h(43, this.wtx);
      }
      i += i.a.a.b.b.a.cJ(44, this.wty);
      paramInt = i;
      if (this.wtz != null) {
        paramInt = i + i.a.a.b.b.a.h(45, this.wtz);
      }
      i = paramInt;
      if (this.wtA != null) {
        i = paramInt + i.a.a.b.b.a.h(46, this.wtA);
      }
      paramInt = i;
      if (this.wtB != null) {
        paramInt = i + i.a.a.b.b.a.h(47, this.wtB);
      }
      i = paramInt;
      if (this.wtC != null) {
        i = paramInt + i.a.a.b.b.a.h(48, this.wtC);
      }
      AppMethodBeat.o(114009);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = esc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = esc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(114009);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        cgk localcgk = (cgk)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        case 34: 
        case 35: 
        case 36: 
        default: 
          AppMethodBeat.o(114009);
          return -1;
        case 1: 
          paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            kd localkd = new kd();
            if ((localObject != null) && (localObject.length > 0)) {
              localkd.parseFrom((byte[])localObject);
            }
            localcgk.BaseResponse = localkd;
            paramInt += 1;
          }
          AppMethodBeat.o(114009);
          return 0;
        case 2: 
          localcgk.YBk = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(114009);
          return 0;
        case 3: 
          localcgk.YBl = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(114009);
          return 0;
        case 4: 
          localcgk.YBm = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(114009);
          return 0;
        case 5: 
          localcgk.content = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(114009);
          return 0;
        case 6: 
          localcgk.YBn = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(114009);
          return 0;
        case 7: 
          localcgk.YBo = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(114009);
          return 0;
        case 8: 
          localcgk.YBp = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(114009);
          return 0;
        case 9: 
          localcgk.YBq = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(114009);
          return 0;
        case 10: 
          localcgk.YBr = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(114009);
          return 0;
        case 11: 
          localcgk.YBs = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(114009);
          return 0;
        case 12: 
          localcgk.YBt = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(114009);
          return 0;
        case 13: 
          localcgk.YBu = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(114009);
          return 0;
        case 14: 
          localcgk.wtD = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(114009);
          return 0;
        case 15: 
          localcgk.wtE = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(114009);
          return 0;
        case 16: 
          localcgk.YBv = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(114009);
          return 0;
        case 17: 
          localcgk.YBw = ((i.a.a.a.a)localObject).ajGk.aai();
          AppMethodBeat.o(114009);
          return 0;
        case 18: 
          localcgk.YBx = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(114009);
          return 0;
        case 19: 
          localcgk.YBy = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(114009);
          return 0;
        case 20: 
          localcgk.YBz = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(114009);
          return 0;
        case 21: 
          localcgk.nRQ = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(114009);
          return 0;
        case 22: 
          localcgk.YBA = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(114009);
          return 0;
        case 23: 
          localcgk.YBB = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(114009);
          return 0;
        case 24: 
          localcgk.aapx = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(114009);
          return 0;
        case 25: 
          localcgk.YBD = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(114009);
          return 0;
        case 26: 
          localcgk.YBE = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(114009);
          return 0;
        case 27: 
          localcgk.YBF = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(114009);
          return 0;
        case 28: 
          localcgk.YBG = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(114009);
          return 0;
        case 29: 
          localcgk.YBH = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(114009);
          return 0;
        case 30: 
          localcgk.YBI = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(114009);
          return 0;
        case 31: 
          localcgk.YBJ = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(114009);
          return 0;
        case 32: 
          localcgk.wsy = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(114009);
          return 0;
        case 33: 
          localcgk.YBK = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(114009);
          return 0;
        case 37: 
          localcgk.wtr = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(114009);
          return 0;
        case 38: 
          localcgk.wts = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(114009);
          return 0;
        case 39: 
          localcgk.wtt = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(114009);
          return 0;
        case 40: 
          localcgk.wtu = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(114009);
          return 0;
        case 41: 
          localcgk.wtv = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(114009);
          return 0;
        case 42: 
          localcgk.wtw = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(114009);
          return 0;
        case 43: 
          localcgk.wtx = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(114009);
          return 0;
        case 44: 
          localcgk.wty = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(114009);
          return 0;
        case 45: 
          localcgk.wtz = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(114009);
          return 0;
        case 46: 
          localcgk.wtA = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(114009);
          return 0;
        case 47: 
          localcgk.wtB = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(114009);
          return 0;
        }
        localcgk.wtC = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(114009);
        return 0;
      }
      AppMethodBeat.o(114009);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cgk
 * JD-Core Version:    0.7.0.1
 */