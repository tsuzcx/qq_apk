package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class bmf
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
  public int Ezs;
  public String Ezw;
  public int Ezx;
  public String Ezy;
  public LinkedList<bmi> SXd;
  public bmi SXe;
  public int SXf;
  public bmc SXg;
  public LinkedList<bmd> fbZ;
  public int fwx;
  public long gbJ;
  public int gbo;
  public int gbp;
  public int gbq;
  public int tVd;
  public String tVo;
  public String ybP;
  
  public bmf()
  {
    AppMethodBeat.i(271265);
    this.fwx = 0;
    this.tVo = "ok";
    this.SXd = new LinkedList();
    this.fbZ = new LinkedList();
    AppMethodBeat.o(271265);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(271268);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(271268);
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
      paramVarArgs.aY(4, this.EAR);
      paramVarArgs.aY(5, this.tVd);
      paramVarArgs.bm(6, this.Ezg);
      if (this.ybP != null) {
        paramVarArgs.f(7, this.ybP);
      }
      paramVarArgs.bm(8, this.gbJ);
      if (this.EtJ != null) {
        paramVarArgs.f(9, this.EtJ);
      }
      paramVarArgs.aY(10, this.Ezj);
      if (this.Ezh != null) {
        paramVarArgs.f(11, this.Ezh);
      }
      paramVarArgs.e(12, 8, this.SXd);
      paramVarArgs.aY(13, this.gbo);
      paramVarArgs.aY(14, this.Ezk);
      paramVarArgs.aY(15, this.gbp);
      paramVarArgs.aY(16, this.gbq);
      if (this.EyY != null) {
        paramVarArgs.f(17, this.EyY);
      }
      if (this.Ezl != null) {
        paramVarArgs.f(18, this.Ezl);
      }
      paramVarArgs.aY(19, this.Ezs);
      paramVarArgs.bm(20, this.Ezf);
      paramVarArgs.e(21, 8, this.fbZ);
      if (this.SXe != null)
      {
        paramVarArgs.oE(22, this.SXe.computeSize());
        this.SXe.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(23, this.EvK);
      if (this.EvM != null) {
        paramVarArgs.f(24, this.EvM);
      }
      if (this.Ezw != null) {
        paramVarArgs.f(25, this.Ezw);
      }
      if (this.EvL != null) {
        paramVarArgs.f(26, this.EvL);
      }
      paramVarArgs.aY(27, this.Ezx);
      if (this.Ezy != null) {
        paramVarArgs.f(28, this.Ezy);
      }
      paramVarArgs.aY(29, this.SXf);
      paramVarArgs.aY(30, this.EzJ);
      if (this.EzA != null) {
        paramVarArgs.f(31, this.EzA);
      }
      if (this.EzB != null) {
        paramVarArgs.f(32, this.EzB);
      }
      if (this.SXg != null)
      {
        paramVarArgs.oE(33, this.SXg.computeSize());
        this.SXg.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(271268);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label2300;
      }
    }
    label2300:
    for (paramInt = g.a.a.a.oD(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bM(2, this.fwx);
      paramInt = i;
      if (this.tVo != null) {
        paramInt = i + g.a.a.b.b.a.g(3, this.tVo);
      }
      i = paramInt + g.a.a.b.b.a.bM(4, this.EAR) + g.a.a.b.b.a.bM(5, this.tVd) + g.a.a.b.b.a.p(6, this.Ezg);
      paramInt = i;
      if (this.ybP != null) {
        paramInt = i + g.a.a.b.b.a.g(7, this.ybP);
      }
      i = paramInt + g.a.a.b.b.a.p(8, this.gbJ);
      paramInt = i;
      if (this.EtJ != null) {
        paramInt = i + g.a.a.b.b.a.g(9, this.EtJ);
      }
      i = paramInt + g.a.a.b.b.a.bM(10, this.Ezj);
      paramInt = i;
      if (this.Ezh != null) {
        paramInt = i + g.a.a.b.b.a.g(11, this.Ezh);
      }
      i = paramInt + g.a.a.a.c(12, 8, this.SXd) + g.a.a.b.b.a.bM(13, this.gbo) + g.a.a.b.b.a.bM(14, this.Ezk) + g.a.a.b.b.a.bM(15, this.gbp) + g.a.a.b.b.a.bM(16, this.gbq);
      paramInt = i;
      if (this.EyY != null) {
        paramInt = i + g.a.a.b.b.a.g(17, this.EyY);
      }
      i = paramInt;
      if (this.Ezl != null) {
        i = paramInt + g.a.a.b.b.a.g(18, this.Ezl);
      }
      i = i + g.a.a.b.b.a.bM(19, this.Ezs) + g.a.a.b.b.a.p(20, this.Ezf) + g.a.a.a.c(21, 8, this.fbZ);
      paramInt = i;
      if (this.SXe != null) {
        paramInt = i + g.a.a.a.oD(22, this.SXe.computeSize());
      }
      i = paramInt + g.a.a.b.b.a.bM(23, this.EvK);
      paramInt = i;
      if (this.EvM != null) {
        paramInt = i + g.a.a.b.b.a.g(24, this.EvM);
      }
      i = paramInt;
      if (this.Ezw != null) {
        i = paramInt + g.a.a.b.b.a.g(25, this.Ezw);
      }
      paramInt = i;
      if (this.EvL != null) {
        paramInt = i + g.a.a.b.b.a.g(26, this.EvL);
      }
      i = paramInt + g.a.a.b.b.a.bM(27, this.Ezx);
      paramInt = i;
      if (this.Ezy != null) {
        paramInt = i + g.a.a.b.b.a.g(28, this.Ezy);
      }
      i = paramInt + g.a.a.b.b.a.bM(29, this.SXf) + g.a.a.b.b.a.bM(30, this.EzJ);
      paramInt = i;
      if (this.EzA != null) {
        paramInt = i + g.a.a.b.b.a.g(31, this.EzA);
      }
      i = paramInt;
      if (this.EzB != null) {
        i = paramInt + g.a.a.b.b.a.g(32, this.EzB);
      }
      paramInt = i;
      if (this.SXg != null) {
        paramInt = i + g.a.a.a.oD(33, this.SXg.computeSize());
      }
      AppMethodBeat.o(271268);
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
          AppMethodBeat.o(271268);
          throw paramVarArgs;
        }
        AppMethodBeat.o(271268);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        bmf localbmf = (bmf)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(271268);
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
            localbmf.BaseResponse = ((jh)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(271268);
          return 0;
        case 2: 
          localbmf.fwx = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(271268);
          return 0;
        case 3: 
          localbmf.tVo = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(271268);
          return 0;
        case 4: 
          localbmf.EAR = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(271268);
          return 0;
        case 5: 
          localbmf.tVd = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(271268);
          return 0;
        case 6: 
          localbmf.Ezg = ((g.a.a.a.a)localObject1).abFh.AN();
          AppMethodBeat.o(271268);
          return 0;
        case 7: 
          localbmf.ybP = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(271268);
          return 0;
        case 8: 
          localbmf.gbJ = ((g.a.a.a.a)localObject1).abFh.AN();
          AppMethodBeat.o(271268);
          return 0;
        case 9: 
          localbmf.EtJ = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(271268);
          return 0;
        case 10: 
          localbmf.Ezj = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(271268);
          return 0;
        case 11: 
          localbmf.Ezh = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(271268);
          return 0;
        case 12: 
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
            localbmf.SXd.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(271268);
          return 0;
        case 13: 
          localbmf.gbo = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(271268);
          return 0;
        case 14: 
          localbmf.Ezk = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(271268);
          return 0;
        case 15: 
          localbmf.gbp = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(271268);
          return 0;
        case 16: 
          localbmf.gbq = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(271268);
          return 0;
        case 17: 
          localbmf.EyY = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(271268);
          return 0;
        case 18: 
          localbmf.Ezl = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(271268);
          return 0;
        case 19: 
          localbmf.Ezs = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(271268);
          return 0;
        case 20: 
          localbmf.Ezf = ((g.a.a.a.a)localObject1).abFh.AN();
          AppMethodBeat.o(271268);
          return 0;
        case 21: 
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
            localbmf.fbZ.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(271268);
          return 0;
        case 22: 
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
            localbmf.SXe = ((bmi)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(271268);
          return 0;
        case 23: 
          localbmf.EvK = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(271268);
          return 0;
        case 24: 
          localbmf.EvM = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(271268);
          return 0;
        case 25: 
          localbmf.Ezw = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(271268);
          return 0;
        case 26: 
          localbmf.EvL = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(271268);
          return 0;
        case 27: 
          localbmf.Ezx = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(271268);
          return 0;
        case 28: 
          localbmf.Ezy = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(271268);
          return 0;
        case 29: 
          localbmf.SXf = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(271268);
          return 0;
        case 30: 
          localbmf.EzJ = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(271268);
          return 0;
        case 31: 
          localbmf.EzA = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(271268);
          return 0;
        case 32: 
          localbmf.EzB = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(271268);
          return 0;
        }
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
          localbmf.SXg = ((bmc)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(271268);
        return 0;
      }
      AppMethodBeat.o(271268);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bmf
 * JD-Core Version:    0.7.0.1
 */