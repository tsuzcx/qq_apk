package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class eyc
  extends dyl
{
  public int COi;
  public int HmZ;
  public int Hna;
  public int Hnb;
  public eae Hnc;
  public String Md5;
  public String RFI;
  public String RFJ;
  public String RFK;
  public eaf RID;
  public eaf RIE;
  public String RII;
  public String ScV;
  public int ScW;
  public int ScX;
  public int ScY;
  public String ScZ;
  public int SmH;
  public int Sue;
  public int TGZ;
  public String TPI;
  public int ThK;
  public String Tse;
  public int UhL;
  public int Uns;
  public eaf Uym;
  public String Uyn;
  public String Uyo;
  public int Uyp;
  public int Uyq;
  public String Uyr;
  public int Uys;
  public int Uyt;
  public int Uyu;
  public String lVG;
  public String lVJ;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(152719);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.Uym == null)
      {
        paramVarArgs = new b("Not all required fields were included: ClientImgId");
        AppMethodBeat.o(152719);
        throw paramVarArgs;
      }
      if (this.RID == null)
      {
        paramVarArgs = new b("Not all required fields were included: FromUserName");
        AppMethodBeat.o(152719);
        throw paramVarArgs;
      }
      if (this.RIE == null)
      {
        paramVarArgs = new b("Not all required fields were included: ToUserName");
        AppMethodBeat.o(152719);
        throw paramVarArgs;
      }
      if (this.Hnc == null)
      {
        paramVarArgs = new b("Not all required fields were included: Data");
        AppMethodBeat.o(152719);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.oE(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.Uym != null)
      {
        paramVarArgs.oE(2, this.Uym.computeSize());
        this.Uym.writeFields(paramVarArgs);
      }
      if (this.RID != null)
      {
        paramVarArgs.oE(3, this.RID.computeSize());
        this.RID.writeFields(paramVarArgs);
      }
      if (this.RIE != null)
      {
        paramVarArgs.oE(4, this.RIE.computeSize());
        this.RIE.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(5, this.HmZ);
      paramVarArgs.aY(6, this.Hna);
      paramVarArgs.aY(7, this.Hnb);
      if (this.Hnc != null)
      {
        paramVarArgs.oE(8, this.Hnc.computeSize());
        this.Hnc.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(9, this.COi);
      if (this.RII != null) {
        paramVarArgs.f(10, this.RII);
      }
      paramVarArgs.aY(11, this.ThK);
      paramVarArgs.aY(12, this.SmH);
      paramVarArgs.aY(13, this.Uns);
      if (this.lVJ != null) {
        paramVarArgs.f(14, this.lVJ);
      }
      if (this.Uyn != null) {
        paramVarArgs.f(15, this.Uyn);
      }
      if (this.Uyo != null) {
        paramVarArgs.f(16, this.Uyo);
      }
      if (this.ScV != null) {
        paramVarArgs.f(17, this.ScV);
      }
      paramVarArgs.aY(18, this.ScW);
      paramVarArgs.aY(19, this.Uyp);
      paramVarArgs.aY(20, this.Uyq);
      if (this.Uyr != null) {
        paramVarArgs.f(21, this.Uyr);
      }
      paramVarArgs.aY(22, this.Uys);
      paramVarArgs.aY(23, this.Uyt);
      paramVarArgs.aY(24, this.Uyu);
      if (this.Tse != null) {
        paramVarArgs.f(25, this.Tse);
      }
      paramVarArgs.aY(26, this.Sue);
      if (this.Md5 != null) {
        paramVarArgs.f(27, this.Md5);
      }
      paramVarArgs.aY(28, this.ScX);
      paramVarArgs.aY(29, this.ScY);
      paramVarArgs.aY(30, this.UhL);
      if (this.lVG != null) {
        paramVarArgs.f(31, this.lVG);
      }
      if (this.RFK != null) {
        paramVarArgs.f(32, this.RFK);
      }
      if (this.RFJ != null) {
        paramVarArgs.f(33, this.RFJ);
      }
      if (this.RFI != null) {
        paramVarArgs.f(34, this.RFI);
      }
      if (this.ScZ != null) {
        paramVarArgs.f(35, this.ScZ);
      }
      paramVarArgs.aY(36, this.TGZ);
      if (this.TPI != null) {
        paramVarArgs.f(37, this.TPI);
      }
      AppMethodBeat.o(152719);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label2684;
      }
    }
    label2684:
    for (int i = g.a.a.a.oD(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.Uym != null) {
        paramInt = i + g.a.a.a.oD(2, this.Uym.computeSize());
      }
      i = paramInt;
      if (this.RID != null) {
        i = paramInt + g.a.a.a.oD(3, this.RID.computeSize());
      }
      paramInt = i;
      if (this.RIE != null) {
        paramInt = i + g.a.a.a.oD(4, this.RIE.computeSize());
      }
      i = paramInt + g.a.a.b.b.a.bM(5, this.HmZ) + g.a.a.b.b.a.bM(6, this.Hna) + g.a.a.b.b.a.bM(7, this.Hnb);
      paramInt = i;
      if (this.Hnc != null) {
        paramInt = i + g.a.a.a.oD(8, this.Hnc.computeSize());
      }
      i = paramInt + g.a.a.b.b.a.bM(9, this.COi);
      paramInt = i;
      if (this.RII != null) {
        paramInt = i + g.a.a.b.b.a.g(10, this.RII);
      }
      i = paramInt + g.a.a.b.b.a.bM(11, this.ThK) + g.a.a.b.b.a.bM(12, this.SmH) + g.a.a.b.b.a.bM(13, this.Uns);
      paramInt = i;
      if (this.lVJ != null) {
        paramInt = i + g.a.a.b.b.a.g(14, this.lVJ);
      }
      i = paramInt;
      if (this.Uyn != null) {
        i = paramInt + g.a.a.b.b.a.g(15, this.Uyn);
      }
      paramInt = i;
      if (this.Uyo != null) {
        paramInt = i + g.a.a.b.b.a.g(16, this.Uyo);
      }
      i = paramInt;
      if (this.ScV != null) {
        i = paramInt + g.a.a.b.b.a.g(17, this.ScV);
      }
      i = i + g.a.a.b.b.a.bM(18, this.ScW) + g.a.a.b.b.a.bM(19, this.Uyp) + g.a.a.b.b.a.bM(20, this.Uyq);
      paramInt = i;
      if (this.Uyr != null) {
        paramInt = i + g.a.a.b.b.a.g(21, this.Uyr);
      }
      i = paramInt + g.a.a.b.b.a.bM(22, this.Uys) + g.a.a.b.b.a.bM(23, this.Uyt) + g.a.a.b.b.a.bM(24, this.Uyu);
      paramInt = i;
      if (this.Tse != null) {
        paramInt = i + g.a.a.b.b.a.g(25, this.Tse);
      }
      i = paramInt + g.a.a.b.b.a.bM(26, this.Sue);
      paramInt = i;
      if (this.Md5 != null) {
        paramInt = i + g.a.a.b.b.a.g(27, this.Md5);
      }
      i = paramInt + g.a.a.b.b.a.bM(28, this.ScX) + g.a.a.b.b.a.bM(29, this.ScY) + g.a.a.b.b.a.bM(30, this.UhL);
      paramInt = i;
      if (this.lVG != null) {
        paramInt = i + g.a.a.b.b.a.g(31, this.lVG);
      }
      i = paramInt;
      if (this.RFK != null) {
        i = paramInt + g.a.a.b.b.a.g(32, this.RFK);
      }
      paramInt = i;
      if (this.RFJ != null) {
        paramInt = i + g.a.a.b.b.a.g(33, this.RFJ);
      }
      i = paramInt;
      if (this.RFI != null) {
        i = paramInt + g.a.a.b.b.a.g(34, this.RFI);
      }
      paramInt = i;
      if (this.ScZ != null) {
        paramInt = i + g.a.a.b.b.a.g(35, this.ScZ);
      }
      i = paramInt + g.a.a.b.b.a.bM(36, this.TGZ);
      paramInt = i;
      if (this.TPI != null) {
        paramInt = i + g.a.a.b.b.a.g(37, this.TPI);
      }
      AppMethodBeat.o(152719);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dyl.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyl.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        if (this.Uym == null)
        {
          paramVarArgs = new b("Not all required fields were included: ClientImgId");
          AppMethodBeat.o(152719);
          throw paramVarArgs;
        }
        if (this.RID == null)
        {
          paramVarArgs = new b("Not all required fields were included: FromUserName");
          AppMethodBeat.o(152719);
          throw paramVarArgs;
        }
        if (this.RIE == null)
        {
          paramVarArgs = new b("Not all required fields were included: ToUserName");
          AppMethodBeat.o(152719);
          throw paramVarArgs;
        }
        if (this.Hnc == null)
        {
          paramVarArgs = new b("Not all required fields were included: Data");
          AppMethodBeat.o(152719);
          throw paramVarArgs;
        }
        AppMethodBeat.o(152719);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        eyc localeyc = (eyc)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(152719);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new jg();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((jg)localObject2).parseFrom((byte[])localObject1);
            }
            localeyc.BaseRequest = ((jg)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(152719);
          return 0;
        case 2: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new eaf();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((eaf)localObject2).de((byte[])localObject1);
            }
            localeyc.Uym = ((eaf)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(152719);
          return 0;
        case 3: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new eaf();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((eaf)localObject2).de((byte[])localObject1);
            }
            localeyc.RID = ((eaf)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(152719);
          return 0;
        case 4: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new eaf();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((eaf)localObject2).de((byte[])localObject1);
            }
            localeyc.RIE = ((eaf)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(152719);
          return 0;
        case 5: 
          localeyc.HmZ = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(152719);
          return 0;
        case 6: 
          localeyc.Hna = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(152719);
          return 0;
        case 7: 
          localeyc.Hnb = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(152719);
          return 0;
        case 8: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new eae();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((eae)localObject2).dd((byte[])localObject1);
            }
            localeyc.Hnc = ((eae)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(152719);
          return 0;
        case 9: 
          localeyc.COi = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(152719);
          return 0;
        case 10: 
          localeyc.RII = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(152719);
          return 0;
        case 11: 
          localeyc.ThK = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(152719);
          return 0;
        case 12: 
          localeyc.SmH = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(152719);
          return 0;
        case 13: 
          localeyc.Uns = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(152719);
          return 0;
        case 14: 
          localeyc.lVJ = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(152719);
          return 0;
        case 15: 
          localeyc.Uyn = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(152719);
          return 0;
        case 16: 
          localeyc.Uyo = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(152719);
          return 0;
        case 17: 
          localeyc.ScV = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(152719);
          return 0;
        case 18: 
          localeyc.ScW = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(152719);
          return 0;
        case 19: 
          localeyc.Uyp = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(152719);
          return 0;
        case 20: 
          localeyc.Uyq = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(152719);
          return 0;
        case 21: 
          localeyc.Uyr = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(152719);
          return 0;
        case 22: 
          localeyc.Uys = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(152719);
          return 0;
        case 23: 
          localeyc.Uyt = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(152719);
          return 0;
        case 24: 
          localeyc.Uyu = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(152719);
          return 0;
        case 25: 
          localeyc.Tse = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(152719);
          return 0;
        case 26: 
          localeyc.Sue = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(152719);
          return 0;
        case 27: 
          localeyc.Md5 = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(152719);
          return 0;
        case 28: 
          localeyc.ScX = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(152719);
          return 0;
        case 29: 
          localeyc.ScY = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(152719);
          return 0;
        case 30: 
          localeyc.UhL = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(152719);
          return 0;
        case 31: 
          localeyc.lVG = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(152719);
          return 0;
        case 32: 
          localeyc.RFK = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(152719);
          return 0;
        case 33: 
          localeyc.RFJ = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(152719);
          return 0;
        case 34: 
          localeyc.RFI = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(152719);
          return 0;
        case 35: 
          localeyc.ScZ = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(152719);
          return 0;
        case 36: 
          localeyc.TGZ = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(152719);
          return 0;
        }
        localeyc.TPI = ((g.a.a.a.a)localObject1).abFh.readString();
        AppMethodBeat.o(152719);
        return 0;
      }
      AppMethodBeat.o(152719);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.eyc
 * JD-Core Version:    0.7.0.1
 */