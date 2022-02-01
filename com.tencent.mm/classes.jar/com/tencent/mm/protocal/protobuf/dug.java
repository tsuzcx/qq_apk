package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;
import java.util.LinkedList;

public final class dug
  extends esc
{
  public String UserName;
  public String YBV;
  public int YBY;
  public String YCb;
  public String YCc;
  public int YCd;
  public String YCe;
  public int YCg;
  public gnr YCh;
  public gno YCi;
  public String YJq;
  public fck YJt;
  public int YJy;
  public int YJz;
  public sc YOA;
  public dts YOB;
  public dal YOz;
  public uu YPa;
  public uu YPb;
  public uu YPc;
  public String aaJJ;
  public String aayV;
  public gol aayX;
  public String abaa;
  public int abab;
  public String abac;
  public int abad;
  public edz abae;
  public int abaf;
  public String abag;
  public String abah;
  public ewn abai;
  public int vhk;
  public int yth;
  public String ytj;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(133185);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(133185);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.qD(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(2, this.yth);
      if (this.aaJJ != null) {
        paramVarArgs.g(3, this.aaJJ);
      }
      if (this.YCb != null) {
        paramVarArgs.g(4, this.YCb);
      }
      if (this.YCc != null) {
        paramVarArgs.g(5, this.YCc);
      }
      if (this.abaa != null) {
        paramVarArgs.g(6, this.abaa);
      }
      if (this.YBV != null) {
        paramVarArgs.g(7, this.YBV);
      }
      paramVarArgs.bS(8, this.YCd);
      paramVarArgs.bS(9, this.abab);
      if (this.abac != null) {
        paramVarArgs.g(10, this.abac);
      }
      if (this.YOA != null)
      {
        paramVarArgs.qD(14, this.YOA.computeSize());
        this.YOA.writeFields(paramVarArgs);
      }
      if (this.YCe != null) {
        paramVarArgs.g(15, this.YCe);
      }
      if (this.UserName != null) {
        paramVarArgs.g(16, this.UserName);
      }
      paramVarArgs.bS(17, this.vhk);
      if (this.YOB != null)
      {
        paramVarArgs.qD(18, this.YOB.computeSize());
        this.YOB.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(19, this.abad);
      paramVarArgs.bS(20, this.YBY);
      if (this.YJq != null) {
        paramVarArgs.g(21, this.YJq);
      }
      if (this.abae != null)
      {
        paramVarArgs.qD(22, this.abae.computeSize());
        this.abae.writeFields(paramVarArgs);
      }
      if (this.ytj != null) {
        paramVarArgs.g(23, this.ytj);
      }
      paramVarArgs.bS(24, this.abaf);
      if (this.YOz != null)
      {
        paramVarArgs.qD(25, this.YOz.computeSize());
        this.YOz.writeFields(paramVarArgs);
      }
      if (this.abag != null) {
        paramVarArgs.g(26, this.abag);
      }
      if (this.YPa != null)
      {
        paramVarArgs.qD(27, this.YPa.computeSize());
        this.YPa.writeFields(paramVarArgs);
      }
      if (this.abah != null) {
        paramVarArgs.g(28, this.abah);
      }
      if (this.aayV != null) {
        paramVarArgs.g(29, this.aayV);
      }
      if (this.aayX != null)
      {
        paramVarArgs.qD(30, this.aayX.computeSize());
        this.aayX.writeFields(paramVarArgs);
      }
      if (this.YJt != null)
      {
        paramVarArgs.qD(31, this.YJt.computeSize());
        this.YJt.writeFields(paramVarArgs);
      }
      if (this.YPb != null)
      {
        paramVarArgs.qD(32, this.YPb.computeSize());
        this.YPb.writeFields(paramVarArgs);
      }
      if (this.YPc != null)
      {
        paramVarArgs.qD(33, this.YPc.computeSize());
        this.YPc.writeFields(paramVarArgs);
      }
      if (this.abai != null)
      {
        paramVarArgs.qD(34, this.abai.computeSize());
        this.abai.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(35, this.YJy);
      paramVarArgs.bS(36, this.YJz);
      paramVarArgs.bS(37, this.YCg);
      if (this.YCh != null)
      {
        paramVarArgs.qD(38, this.YCh.computeSize());
        this.YCh.writeFields(paramVarArgs);
      }
      if (this.YCi != null)
      {
        paramVarArgs.qD(39, this.YCi.computeSize());
        this.YCi.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(133185);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label3204;
      }
    }
    label3204:
    for (paramInt = i.a.a.a.qC(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + i.a.a.b.b.a.cJ(2, this.yth);
      paramInt = i;
      if (this.aaJJ != null) {
        paramInt = i + i.a.a.b.b.a.h(3, this.aaJJ);
      }
      i = paramInt;
      if (this.YCb != null) {
        i = paramInt + i.a.a.b.b.a.h(4, this.YCb);
      }
      paramInt = i;
      if (this.YCc != null) {
        paramInt = i + i.a.a.b.b.a.h(5, this.YCc);
      }
      i = paramInt;
      if (this.abaa != null) {
        i = paramInt + i.a.a.b.b.a.h(6, this.abaa);
      }
      paramInt = i;
      if (this.YBV != null) {
        paramInt = i + i.a.a.b.b.a.h(7, this.YBV);
      }
      i = paramInt + i.a.a.b.b.a.cJ(8, this.YCd) + i.a.a.b.b.a.cJ(9, this.abab);
      paramInt = i;
      if (this.abac != null) {
        paramInt = i + i.a.a.b.b.a.h(10, this.abac);
      }
      i = paramInt;
      if (this.YOA != null) {
        i = paramInt + i.a.a.a.qC(14, this.YOA.computeSize());
      }
      paramInt = i;
      if (this.YCe != null) {
        paramInt = i + i.a.a.b.b.a.h(15, this.YCe);
      }
      i = paramInt;
      if (this.UserName != null) {
        i = paramInt + i.a.a.b.b.a.h(16, this.UserName);
      }
      i += i.a.a.b.b.a.cJ(17, this.vhk);
      paramInt = i;
      if (this.YOB != null) {
        paramInt = i + i.a.a.a.qC(18, this.YOB.computeSize());
      }
      i = paramInt + i.a.a.b.b.a.cJ(19, this.abad) + i.a.a.b.b.a.cJ(20, this.YBY);
      paramInt = i;
      if (this.YJq != null) {
        paramInt = i + i.a.a.b.b.a.h(21, this.YJq);
      }
      i = paramInt;
      if (this.abae != null) {
        i = paramInt + i.a.a.a.qC(22, this.abae.computeSize());
      }
      paramInt = i;
      if (this.ytj != null) {
        paramInt = i + i.a.a.b.b.a.h(23, this.ytj);
      }
      i = paramInt + i.a.a.b.b.a.cJ(24, this.abaf);
      paramInt = i;
      if (this.YOz != null) {
        paramInt = i + i.a.a.a.qC(25, this.YOz.computeSize());
      }
      i = paramInt;
      if (this.abag != null) {
        i = paramInt + i.a.a.b.b.a.h(26, this.abag);
      }
      paramInt = i;
      if (this.YPa != null) {
        paramInt = i + i.a.a.a.qC(27, this.YPa.computeSize());
      }
      i = paramInt;
      if (this.abah != null) {
        i = paramInt + i.a.a.b.b.a.h(28, this.abah);
      }
      paramInt = i;
      if (this.aayV != null) {
        paramInt = i + i.a.a.b.b.a.h(29, this.aayV);
      }
      i = paramInt;
      if (this.aayX != null) {
        i = paramInt + i.a.a.a.qC(30, this.aayX.computeSize());
      }
      paramInt = i;
      if (this.YJt != null) {
        paramInt = i + i.a.a.a.qC(31, this.YJt.computeSize());
      }
      i = paramInt;
      if (this.YPb != null) {
        i = paramInt + i.a.a.a.qC(32, this.YPb.computeSize());
      }
      paramInt = i;
      if (this.YPc != null) {
        paramInt = i + i.a.a.a.qC(33, this.YPc.computeSize());
      }
      i = paramInt;
      if (this.abai != null) {
        i = paramInt + i.a.a.a.qC(34, this.abai.computeSize());
      }
      i = i + i.a.a.b.b.a.cJ(35, this.YJy) + i.a.a.b.b.a.cJ(36, this.YJz) + i.a.a.b.b.a.cJ(37, this.YCg);
      paramInt = i;
      if (this.YCh != null) {
        paramInt = i + i.a.a.a.qC(38, this.YCh.computeSize());
      }
      i = paramInt;
      if (this.YCi != null) {
        i = paramInt + i.a.a.a.qC(39, this.YCi.computeSize());
      }
      AppMethodBeat.o(133185);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = esc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = esc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(133185);
          throw paramVarArgs;
        }
        AppMethodBeat.o(133185);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        dug localdug = (dug)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        case 11: 
        case 12: 
        case 13: 
        default: 
          AppMethodBeat.o(133185);
          return -1;
        case 1: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new kd();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((kd)localObject2).parseFrom((byte[])localObject1);
            }
            localdug.BaseResponse = ((kd)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(133185);
          return 0;
        case 2: 
          localdug.yth = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(133185);
          return 0;
        case 3: 
          localdug.aaJJ = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(133185);
          return 0;
        case 4: 
          localdug.YCb = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(133185);
          return 0;
        case 5: 
          localdug.YCc = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(133185);
          return 0;
        case 6: 
          localdug.abaa = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(133185);
          return 0;
        case 7: 
          localdug.YBV = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(133185);
          return 0;
        case 8: 
          localdug.YCd = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(133185);
          return 0;
        case 9: 
          localdug.abab = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(133185);
          return 0;
        case 10: 
          localdug.abac = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(133185);
          return 0;
        case 14: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new sc();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((sc)localObject2).parseFrom((byte[])localObject1);
            }
            localdug.YOA = ((sc)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(133185);
          return 0;
        case 15: 
          localdug.YCe = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(133185);
          return 0;
        case 16: 
          localdug.UserName = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(133185);
          return 0;
        case 17: 
          localdug.vhk = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(133185);
          return 0;
        case 18: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new dts();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((dts)localObject2).parseFrom((byte[])localObject1);
            }
            localdug.YOB = ((dts)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(133185);
          return 0;
        case 19: 
          localdug.abad = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(133185);
          return 0;
        case 20: 
          localdug.YBY = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(133185);
          return 0;
        case 21: 
          localdug.YJq = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(133185);
          return 0;
        case 22: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new edz();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((edz)localObject2).parseFrom((byte[])localObject1);
            }
            localdug.abae = ((edz)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(133185);
          return 0;
        case 23: 
          localdug.ytj = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(133185);
          return 0;
        case 24: 
          localdug.abaf = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(133185);
          return 0;
        case 25: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new dal();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((dal)localObject2).parseFrom((byte[])localObject1);
            }
            localdug.YOz = ((dal)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(133185);
          return 0;
        case 26: 
          localdug.abag = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(133185);
          return 0;
        case 27: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new uu();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((uu)localObject2).parseFrom((byte[])localObject1);
            }
            localdug.YPa = ((uu)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(133185);
          return 0;
        case 28: 
          localdug.abah = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(133185);
          return 0;
        case 29: 
          localdug.aayV = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(133185);
          return 0;
        case 30: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new gol();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((gol)localObject2).dg((byte[])localObject1);
            }
            localdug.aayX = ((gol)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(133185);
          return 0;
        case 31: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new fck();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((fck)localObject2).parseFrom((byte[])localObject1);
            }
            localdug.YJt = ((fck)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(133185);
          return 0;
        case 32: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new uu();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((uu)localObject2).parseFrom((byte[])localObject1);
            }
            localdug.YPb = ((uu)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(133185);
          return 0;
        case 33: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new uu();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((uu)localObject2).parseFrom((byte[])localObject1);
            }
            localdug.YPc = ((uu)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(133185);
          return 0;
        case 34: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new ewn();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((ewn)localObject2).parseFrom((byte[])localObject1);
            }
            localdug.abai = ((ewn)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(133185);
          return 0;
        case 35: 
          localdug.YJy = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(133185);
          return 0;
        case 36: 
          localdug.YJz = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(133185);
          return 0;
        case 37: 
          localdug.YCg = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(133185);
          return 0;
        case 38: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new gnr();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((gnr)localObject2).parseFrom((byte[])localObject1);
            }
            localdug.YCh = ((gnr)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(133185);
          return 0;
        }
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new gno();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((gno)localObject2).parseFrom((byte[])localObject1);
          }
          localdug.YCi = ((gno)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(133185);
        return 0;
      }
      AppMethodBeat.o(133185);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dug
 * JD-Core Version:    0.7.0.1
 */