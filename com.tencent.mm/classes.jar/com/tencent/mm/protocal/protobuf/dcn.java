package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dcn
  extends dyl
{
  public String HlB;
  public int RFr;
  public String RFs;
  public String RFt;
  public String RGL;
  public int RMI;
  public String RMJ;
  public eae RMM;
  public eae RMN;
  public String RMO;
  public dpr RMP;
  public aiq RMV;
  public int RQR;
  public eae RQU;
  public int RQX;
  public String RQY;
  public String RRd;
  public String RRg;
  public String StL;
  public int Swu;
  public int Swv;
  public String Sww;
  public String Sxu;
  public String TCH;
  public int TKa;
  public int TKb;
  public String TKc;
  public String TKd;
  public String TKe;
  public String TKf;
  public String TKg;
  public String TKh;
  public int TKi;
  public String TKj;
  public String TKk;
  public String Tll;
  public String Tlm;
  public String UserName;
  public String mVD;
  public String rWI;
  public String vhp;
  public String vhq;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(133184);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.oE(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.UserName != null) {
        paramVarArgs.f(2, this.UserName);
      }
      if (this.RRg != null) {
        paramVarArgs.f(3, this.RRg);
      }
      if (this.rWI != null) {
        paramVarArgs.f(4, this.rWI);
      }
      paramVarArgs.aY(5, this.RFr);
      if (this.RFs != null) {
        paramVarArgs.f(6, this.RFs);
      }
      if (this.RFt != null) {
        paramVarArgs.f(7, this.RFt);
      }
      if (this.HlB != null) {
        paramVarArgs.f(8, this.HlB);
      }
      paramVarArgs.aY(12, this.RMI);
      paramVarArgs.aY(13, this.TKa);
      paramVarArgs.aY(14, this.Swu);
      if (this.vhp != null) {
        paramVarArgs.f(15, this.vhp);
      }
      if (this.vhq != null) {
        paramVarArgs.f(16, this.vhq);
      }
      paramVarArgs.aY(17, this.RQR);
      if (this.StL != null) {
        paramVarArgs.f(18, this.StL);
      }
      if (this.RQU != null)
      {
        paramVarArgs.oE(19, this.RQU.computeSize());
        this.RQU.writeFields(paramVarArgs);
      }
      if (this.mVD != null) {
        paramVarArgs.f(20, this.mVD);
      }
      if (this.Tll != null) {
        paramVarArgs.f(21, this.Tll);
      }
      if (this.Tlm != null) {
        paramVarArgs.f(22, this.Tlm);
      }
      paramVarArgs.aY(23, this.Swv);
      paramVarArgs.aY(24, this.TKb);
      if (this.RMJ != null) {
        paramVarArgs.f(31, this.RMJ);
      }
      if (this.TCH != null) {
        paramVarArgs.f(32, this.TCH);
      }
      if (this.TKc != null) {
        paramVarArgs.f(33, this.TKc);
      }
      if (this.Sxu != null) {
        paramVarArgs.f(34, this.Sxu);
      }
      if (this.TKd != null) {
        paramVarArgs.f(35, this.TKd);
      }
      if (this.TKe != null) {
        paramVarArgs.f(36, this.TKe);
      }
      if (this.RMV != null)
      {
        paramVarArgs.oE(37, this.RMV.computeSize());
        this.RMV.writeFields(paramVarArgs);
      }
      if (this.TKf != null) {
        paramVarArgs.f(38, this.TKf);
      }
      if (this.RMO != null) {
        paramVarArgs.f(39, this.RMO);
      }
      if (this.TKg != null) {
        paramVarArgs.f(40, this.TKg);
      }
      if (this.TKh != null) {
        paramVarArgs.f(41, this.TKh);
      }
      paramVarArgs.aY(42, this.TKi);
      if (this.RMM != null)
      {
        paramVarArgs.oE(43, this.RMM.computeSize());
        this.RMM.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(44, this.RQX);
      if (this.RQY != null) {
        paramVarArgs.f(45, this.RQY);
      }
      if (this.Sww != null) {
        paramVarArgs.f(46, this.Sww);
      }
      if (this.TKj != null) {
        paramVarArgs.f(47, this.TKj);
      }
      if (this.RMN != null)
      {
        paramVarArgs.oE(48, this.RMN.computeSize());
        this.RMN.writeFields(paramVarArgs);
      }
      if (this.TKk != null) {
        paramVarArgs.f(49, this.TKk);
      }
      if (this.RGL != null) {
        paramVarArgs.f(50, this.RGL);
      }
      if (this.RRd != null) {
        paramVarArgs.f(51, this.RRd);
      }
      if (this.RMP != null)
      {
        paramVarArgs.oE(52, this.RMP.computeSize());
        this.RMP.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(133184);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label3130;
      }
    }
    label3130:
    for (int i = g.a.a.a.oD(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.UserName != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.UserName);
      }
      i = paramInt;
      if (this.RRg != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.RRg);
      }
      paramInt = i;
      if (this.rWI != null) {
        paramInt = i + g.a.a.b.b.a.g(4, this.rWI);
      }
      i = paramInt + g.a.a.b.b.a.bM(5, this.RFr);
      paramInt = i;
      if (this.RFs != null) {
        paramInt = i + g.a.a.b.b.a.g(6, this.RFs);
      }
      i = paramInt;
      if (this.RFt != null) {
        i = paramInt + g.a.a.b.b.a.g(7, this.RFt);
      }
      paramInt = i;
      if (this.HlB != null) {
        paramInt = i + g.a.a.b.b.a.g(8, this.HlB);
      }
      i = paramInt + g.a.a.b.b.a.bM(12, this.RMI) + g.a.a.b.b.a.bM(13, this.TKa) + g.a.a.b.b.a.bM(14, this.Swu);
      paramInt = i;
      if (this.vhp != null) {
        paramInt = i + g.a.a.b.b.a.g(15, this.vhp);
      }
      i = paramInt;
      if (this.vhq != null) {
        i = paramInt + g.a.a.b.b.a.g(16, this.vhq);
      }
      i += g.a.a.b.b.a.bM(17, this.RQR);
      paramInt = i;
      if (this.StL != null) {
        paramInt = i + g.a.a.b.b.a.g(18, this.StL);
      }
      i = paramInt;
      if (this.RQU != null) {
        i = paramInt + g.a.a.a.oD(19, this.RQU.computeSize());
      }
      paramInt = i;
      if (this.mVD != null) {
        paramInt = i + g.a.a.b.b.a.g(20, this.mVD);
      }
      i = paramInt;
      if (this.Tll != null) {
        i = paramInt + g.a.a.b.b.a.g(21, this.Tll);
      }
      paramInt = i;
      if (this.Tlm != null) {
        paramInt = i + g.a.a.b.b.a.g(22, this.Tlm);
      }
      i = paramInt + g.a.a.b.b.a.bM(23, this.Swv) + g.a.a.b.b.a.bM(24, this.TKb);
      paramInt = i;
      if (this.RMJ != null) {
        paramInt = i + g.a.a.b.b.a.g(31, this.RMJ);
      }
      i = paramInt;
      if (this.TCH != null) {
        i = paramInt + g.a.a.b.b.a.g(32, this.TCH);
      }
      paramInt = i;
      if (this.TKc != null) {
        paramInt = i + g.a.a.b.b.a.g(33, this.TKc);
      }
      i = paramInt;
      if (this.Sxu != null) {
        i = paramInt + g.a.a.b.b.a.g(34, this.Sxu);
      }
      paramInt = i;
      if (this.TKd != null) {
        paramInt = i + g.a.a.b.b.a.g(35, this.TKd);
      }
      i = paramInt;
      if (this.TKe != null) {
        i = paramInt + g.a.a.b.b.a.g(36, this.TKe);
      }
      paramInt = i;
      if (this.RMV != null) {
        paramInt = i + g.a.a.a.oD(37, this.RMV.computeSize());
      }
      i = paramInt;
      if (this.TKf != null) {
        i = paramInt + g.a.a.b.b.a.g(38, this.TKf);
      }
      paramInt = i;
      if (this.RMO != null) {
        paramInt = i + g.a.a.b.b.a.g(39, this.RMO);
      }
      i = paramInt;
      if (this.TKg != null) {
        i = paramInt + g.a.a.b.b.a.g(40, this.TKg);
      }
      paramInt = i;
      if (this.TKh != null) {
        paramInt = i + g.a.a.b.b.a.g(41, this.TKh);
      }
      i = paramInt + g.a.a.b.b.a.bM(42, this.TKi);
      paramInt = i;
      if (this.RMM != null) {
        paramInt = i + g.a.a.a.oD(43, this.RMM.computeSize());
      }
      i = paramInt + g.a.a.b.b.a.bM(44, this.RQX);
      paramInt = i;
      if (this.RQY != null) {
        paramInt = i + g.a.a.b.b.a.g(45, this.RQY);
      }
      i = paramInt;
      if (this.Sww != null) {
        i = paramInt + g.a.a.b.b.a.g(46, this.Sww);
      }
      paramInt = i;
      if (this.TKj != null) {
        paramInt = i + g.a.a.b.b.a.g(47, this.TKj);
      }
      i = paramInt;
      if (this.RMN != null) {
        i = paramInt + g.a.a.a.oD(48, this.RMN.computeSize());
      }
      paramInt = i;
      if (this.TKk != null) {
        paramInt = i + g.a.a.b.b.a.g(49, this.TKk);
      }
      i = paramInt;
      if (this.RGL != null) {
        i = paramInt + g.a.a.b.b.a.g(50, this.RGL);
      }
      paramInt = i;
      if (this.RRd != null) {
        paramInt = i + g.a.a.b.b.a.g(51, this.RRd);
      }
      i = paramInt;
      if (this.RMP != null) {
        i = paramInt + g.a.a.a.oD(52, this.RMP.computeSize());
      }
      AppMethodBeat.o(133184);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dyl.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyl.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(133184);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        dcn localdcn = (dcn)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        case 9: 
        case 10: 
        case 11: 
        case 25: 
        case 26: 
        case 27: 
        case 28: 
        case 29: 
        case 30: 
        default: 
          AppMethodBeat.o(133184);
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
            localdcn.BaseRequest = ((jg)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(133184);
          return 0;
        case 2: 
          localdcn.UserName = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(133184);
          return 0;
        case 3: 
          localdcn.RRg = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(133184);
          return 0;
        case 4: 
          localdcn.rWI = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(133184);
          return 0;
        case 5: 
          localdcn.RFr = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(133184);
          return 0;
        case 6: 
          localdcn.RFs = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(133184);
          return 0;
        case 7: 
          localdcn.RFt = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(133184);
          return 0;
        case 8: 
          localdcn.HlB = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(133184);
          return 0;
        case 12: 
          localdcn.RMI = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(133184);
          return 0;
        case 13: 
          localdcn.TKa = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(133184);
          return 0;
        case 14: 
          localdcn.Swu = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(133184);
          return 0;
        case 15: 
          localdcn.vhp = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(133184);
          return 0;
        case 16: 
          localdcn.vhq = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(133184);
          return 0;
        case 17: 
          localdcn.RQR = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(133184);
          return 0;
        case 18: 
          localdcn.StL = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(133184);
          return 0;
        case 19: 
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
            localdcn.RQU = ((eae)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(133184);
          return 0;
        case 20: 
          localdcn.mVD = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(133184);
          return 0;
        case 21: 
          localdcn.Tll = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(133184);
          return 0;
        case 22: 
          localdcn.Tlm = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(133184);
          return 0;
        case 23: 
          localdcn.Swv = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(133184);
          return 0;
        case 24: 
          localdcn.TKb = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(133184);
          return 0;
        case 31: 
          localdcn.RMJ = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(133184);
          return 0;
        case 32: 
          localdcn.TCH = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(133184);
          return 0;
        case 33: 
          localdcn.TKc = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(133184);
          return 0;
        case 34: 
          localdcn.Sxu = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(133184);
          return 0;
        case 35: 
          localdcn.TKd = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(133184);
          return 0;
        case 36: 
          localdcn.TKe = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(133184);
          return 0;
        case 37: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new aiq();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((aiq)localObject2).parseFrom((byte[])localObject1);
            }
            localdcn.RMV = ((aiq)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(133184);
          return 0;
        case 38: 
          localdcn.TKf = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(133184);
          return 0;
        case 39: 
          localdcn.RMO = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(133184);
          return 0;
        case 40: 
          localdcn.TKg = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(133184);
          return 0;
        case 41: 
          localdcn.TKh = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(133184);
          return 0;
        case 42: 
          localdcn.TKi = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(133184);
          return 0;
        case 43: 
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
            localdcn.RMM = ((eae)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(133184);
          return 0;
        case 44: 
          localdcn.RQX = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(133184);
          return 0;
        case 45: 
          localdcn.RQY = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(133184);
          return 0;
        case 46: 
          localdcn.Sww = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(133184);
          return 0;
        case 47: 
          localdcn.TKj = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(133184);
          return 0;
        case 48: 
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
            localdcn.RMN = ((eae)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(133184);
          return 0;
        case 49: 
          localdcn.TKk = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(133184);
          return 0;
        case 50: 
          localdcn.RGL = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(133184);
          return 0;
        case 51: 
          localdcn.RRd = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(133184);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new dpr();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((dpr)localObject2).parseFrom((byte[])localObject1);
          }
          localdcn.RMP = ((dpr)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(133184);
        return 0;
      }
      AppMethodBeat.o(133184);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dcn
 * JD-Core Version:    0.7.0.1
 */