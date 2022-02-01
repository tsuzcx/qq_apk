package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class bmh
  extends dyy
{
  public int EAR;
  public String EtJ;
  public int EvK;
  public String EvL;
  public String EvM;
  public String EyY;
  public String EzA;
  public String EzB;
  public int EzJ;
  public long Ezf;
  public long Ezg;
  public String Ezh;
  public int Ezj;
  public int Ezk;
  public String Ezl;
  public String Ezw;
  public int Ezx;
  public String Ezy;
  public LinkedList<bmi> SXd;
  public bmi SXe;
  public int SXf;
  public bmc SXg;
  public String SXh;
  public String SXj;
  public coj SXk;
  public dtj Sih;
  public cmb SwQ;
  public LinkedList<bmd> fbZ;
  public int fwx;
  public long gbJ;
  public int gbo;
  public int gbp;
  public int gbq;
  public int tVd;
  public String tVo;
  public String ybP;
  
  public bmh()
  {
    AppMethodBeat.i(232480);
    this.fwx = 0;
    this.tVo = "ok";
    this.SXd = new LinkedList();
    this.fbZ = new LinkedList();
    AppMethodBeat.o(232480);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(232488);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(232488);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.oE(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(2, this.fwx);
      if (this.tVo != null) {
        paramVarArgs.f(3, this.tVo);
      }
      if (this.ybP != null) {
        paramVarArgs.f(4, this.ybP);
      }
      paramVarArgs.bm(5, this.gbJ);
      paramVarArgs.aY(6, this.EAR);
      paramVarArgs.bm(7, this.Ezf);
      paramVarArgs.aY(8, this.tVd);
      paramVarArgs.bm(9, this.Ezg);
      paramVarArgs.aY(10, this.gbo);
      paramVarArgs.aY(11, this.Ezj);
      paramVarArgs.aY(12, this.Ezk);
      paramVarArgs.aY(13, this.gbq);
      paramVarArgs.aY(14, this.gbp);
      if (this.EyY != null) {
        paramVarArgs.f(15, this.EyY);
      }
      if (this.EtJ != null) {
        paramVarArgs.f(16, this.EtJ);
      }
      if (this.Ezh != null) {
        paramVarArgs.f(17, this.Ezh);
      }
      if (this.Ezl != null) {
        paramVarArgs.f(18, this.Ezl);
      }
      paramVarArgs.e(19, 8, this.SXd);
      paramVarArgs.e(20, 8, this.fbZ);
      paramVarArgs.aY(21, this.EvK);
      if (this.EvM != null) {
        paramVarArgs.f(22, this.EvM);
      }
      if (this.Ezw != null) {
        paramVarArgs.f(23, this.Ezw);
      }
      if (this.EvL != null) {
        paramVarArgs.f(24, this.EvL);
      }
      if (this.Sih != null)
      {
        paramVarArgs.oE(25, this.Sih.computeSize());
        this.Sih.writeFields(paramVarArgs);
      }
      if (this.SXj != null) {
        paramVarArgs.f(26, this.SXj);
      }
      if (this.SXh != null) {
        paramVarArgs.f(27, this.SXh);
      }
      paramVarArgs.aY(28, this.Ezx);
      if (this.Ezy != null) {
        paramVarArgs.f(29, this.Ezy);
      }
      if (this.SXk != null)
      {
        paramVarArgs.oE(30, this.SXk.computeSize());
        this.SXk.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(31, this.SXf);
      paramVarArgs.aY(32, this.EzJ);
      if (this.SwQ != null)
      {
        paramVarArgs.oE(33, this.SwQ.computeSize());
        this.SwQ.writeFields(paramVarArgs);
      }
      if (this.EzA != null) {
        paramVarArgs.f(34, this.EzA);
      }
      if (this.EzB != null) {
        paramVarArgs.f(35, this.EzB);
      }
      if (this.SXg != null)
      {
        paramVarArgs.oE(36, this.SXg.computeSize());
        this.SXg.writeFields(paramVarArgs);
      }
      if (this.SXe != null)
      {
        paramVarArgs.oE(37, this.SXe.computeSize());
        this.SXe.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(232488);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label2774;
      }
    }
    label2774:
    for (paramInt = g.a.a.a.oD(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bM(2, this.fwx);
      paramInt = i;
      if (this.tVo != null) {
        paramInt = i + g.a.a.b.b.a.g(3, this.tVo);
      }
      i = paramInt;
      if (this.ybP != null) {
        i = paramInt + g.a.a.b.b.a.g(4, this.ybP);
      }
      i = i + g.a.a.b.b.a.p(5, this.gbJ) + g.a.a.b.b.a.bM(6, this.EAR) + g.a.a.b.b.a.p(7, this.Ezf) + g.a.a.b.b.a.bM(8, this.tVd) + g.a.a.b.b.a.p(9, this.Ezg) + g.a.a.b.b.a.bM(10, this.gbo) + g.a.a.b.b.a.bM(11, this.Ezj) + g.a.a.b.b.a.bM(12, this.Ezk) + g.a.a.b.b.a.bM(13, this.gbq) + g.a.a.b.b.a.bM(14, this.gbp);
      paramInt = i;
      if (this.EyY != null) {
        paramInt = i + g.a.a.b.b.a.g(15, this.EyY);
      }
      i = paramInt;
      if (this.EtJ != null) {
        i = paramInt + g.a.a.b.b.a.g(16, this.EtJ);
      }
      paramInt = i;
      if (this.Ezh != null) {
        paramInt = i + g.a.a.b.b.a.g(17, this.Ezh);
      }
      i = paramInt;
      if (this.Ezl != null) {
        i = paramInt + g.a.a.b.b.a.g(18, this.Ezl);
      }
      i = i + g.a.a.a.c(19, 8, this.SXd) + g.a.a.a.c(20, 8, this.fbZ) + g.a.a.b.b.a.bM(21, this.EvK);
      paramInt = i;
      if (this.EvM != null) {
        paramInt = i + g.a.a.b.b.a.g(22, this.EvM);
      }
      i = paramInt;
      if (this.Ezw != null) {
        i = paramInt + g.a.a.b.b.a.g(23, this.Ezw);
      }
      paramInt = i;
      if (this.EvL != null) {
        paramInt = i + g.a.a.b.b.a.g(24, this.EvL);
      }
      i = paramInt;
      if (this.Sih != null) {
        i = paramInt + g.a.a.a.oD(25, this.Sih.computeSize());
      }
      paramInt = i;
      if (this.SXj != null) {
        paramInt = i + g.a.a.b.b.a.g(26, this.SXj);
      }
      i = paramInt;
      if (this.SXh != null) {
        i = paramInt + g.a.a.b.b.a.g(27, this.SXh);
      }
      i += g.a.a.b.b.a.bM(28, this.Ezx);
      paramInt = i;
      if (this.Ezy != null) {
        paramInt = i + g.a.a.b.b.a.g(29, this.Ezy);
      }
      i = paramInt;
      if (this.SXk != null) {
        i = paramInt + g.a.a.a.oD(30, this.SXk.computeSize());
      }
      i = i + g.a.a.b.b.a.bM(31, this.SXf) + g.a.a.b.b.a.bM(32, this.EzJ);
      paramInt = i;
      if (this.SwQ != null) {
        paramInt = i + g.a.a.a.oD(33, this.SwQ.computeSize());
      }
      i = paramInt;
      if (this.EzA != null) {
        i = paramInt + g.a.a.b.b.a.g(34, this.EzA);
      }
      paramInt = i;
      if (this.EzB != null) {
        paramInt = i + g.a.a.b.b.a.g(35, this.EzB);
      }
      i = paramInt;
      if (this.SXg != null) {
        i = paramInt + g.a.a.a.oD(36, this.SXg.computeSize());
      }
      paramInt = i;
      if (this.SXe != null) {
        paramInt = i + g.a.a.a.oD(37, this.SXe.computeSize());
      }
      AppMethodBeat.o(232488);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.SXd.clear();
        this.fbZ.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = dyy.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyy.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(232488);
          throw paramVarArgs;
        }
        AppMethodBeat.o(232488);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        bmh localbmh = (bmh)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(232488);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new jh();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((jh)localObject2).parseFrom((byte[])localObject1);
            }
            localbmh.BaseResponse = ((jh)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(232488);
          return 0;
        case 2: 
          localbmh.fwx = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(232488);
          return 0;
        case 3: 
          localbmh.tVo = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(232488);
          return 0;
        case 4: 
          localbmh.ybP = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(232488);
          return 0;
        case 5: 
          localbmh.gbJ = ((g.a.a.a.a)localObject1).abFh.AN();
          AppMethodBeat.o(232488);
          return 0;
        case 6: 
          localbmh.EAR = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(232488);
          return 0;
        case 7: 
          localbmh.Ezf = ((g.a.a.a.a)localObject1).abFh.AN();
          AppMethodBeat.o(232488);
          return 0;
        case 8: 
          localbmh.tVd = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(232488);
          return 0;
        case 9: 
          localbmh.Ezg = ((g.a.a.a.a)localObject1).abFh.AN();
          AppMethodBeat.o(232488);
          return 0;
        case 10: 
          localbmh.gbo = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(232488);
          return 0;
        case 11: 
          localbmh.Ezj = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(232488);
          return 0;
        case 12: 
          localbmh.Ezk = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(232488);
          return 0;
        case 13: 
          localbmh.gbq = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(232488);
          return 0;
        case 14: 
          localbmh.gbp = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(232488);
          return 0;
        case 15: 
          localbmh.EyY = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(232488);
          return 0;
        case 16: 
          localbmh.EtJ = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(232488);
          return 0;
        case 17: 
          localbmh.Ezh = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(232488);
          return 0;
        case 18: 
          localbmh.Ezl = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(232488);
          return 0;
        case 19: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new bmi();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((bmi)localObject2).parseFrom((byte[])localObject1);
            }
            localbmh.SXd.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(232488);
          return 0;
        case 20: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new bmd();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((bmd)localObject2).parseFrom((byte[])localObject1);
            }
            localbmh.fbZ.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(232488);
          return 0;
        case 21: 
          localbmh.EvK = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(232488);
          return 0;
        case 22: 
          localbmh.EvM = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(232488);
          return 0;
        case 23: 
          localbmh.Ezw = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(232488);
          return 0;
        case 24: 
          localbmh.EvL = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(232488);
          return 0;
        case 25: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new dtj();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((dtj)localObject2).parseFrom((byte[])localObject1);
            }
            localbmh.Sih = ((dtj)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(232488);
          return 0;
        case 26: 
          localbmh.SXj = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(232488);
          return 0;
        case 27: 
          localbmh.SXh = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(232488);
          return 0;
        case 28: 
          localbmh.Ezx = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(232488);
          return 0;
        case 29: 
          localbmh.Ezy = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(232488);
          return 0;
        case 30: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new coj();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((coj)localObject2).parseFrom((byte[])localObject1);
            }
            localbmh.SXk = ((coj)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(232488);
          return 0;
        case 31: 
          localbmh.SXf = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(232488);
          return 0;
        case 32: 
          localbmh.EzJ = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(232488);
          return 0;
        case 33: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new cmb();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((cmb)localObject2).parseFrom((byte[])localObject1);
            }
            localbmh.SwQ = ((cmb)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(232488);
          return 0;
        case 34: 
          localbmh.EzA = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(232488);
          return 0;
        case 35: 
          localbmh.EzB = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(232488);
          return 0;
        case 36: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new bmc();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((bmc)localObject2).parseFrom((byte[])localObject1);
            }
            localbmh.SXg = ((bmc)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(232488);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new bmi();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((bmi)localObject2).parseFrom((byte[])localObject1);
          }
          localbmh.SXe = ((bmi)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(232488);
        return 0;
      }
      AppMethodBeat.o(232488);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bmh
 * JD-Core Version:    0.7.0.1
 */