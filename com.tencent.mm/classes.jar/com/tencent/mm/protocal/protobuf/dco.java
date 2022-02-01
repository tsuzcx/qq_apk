package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class dco
  extends dyy
{
  public int RFA;
  public String RFB;
  public int RFD;
  public fqi RFE;
  public fqf RFF;
  public String RFs;
  public int RFv;
  public String RFy;
  public String RFz;
  public String RMc;
  public eii RMf;
  public int RMk;
  public int RMl;
  public te RRI;
  public te RRJ;
  public te RRK;
  public cke RRh;
  public qr RRi;
  public dca RRj;
  public String TKl;
  public int TKm;
  public String TKn;
  public int TKo;
  public dlo TKp;
  public int TKq;
  public String TKr;
  public String TKs;
  public ecy TKt;
  public String Tll;
  public eae Tln;
  public String Tvd;
  public String UserName;
  public int rVU;
  public int vhf;
  public String vhh;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(133185);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(133185);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.oE(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(2, this.vhf);
      if (this.Tvd != null) {
        paramVarArgs.f(3, this.Tvd);
      }
      if (this.RFy != null) {
        paramVarArgs.f(4, this.RFy);
      }
      if (this.RFz != null) {
        paramVarArgs.f(5, this.RFz);
      }
      if (this.TKl != null) {
        paramVarArgs.f(6, this.TKl);
      }
      if (this.RFs != null) {
        paramVarArgs.f(7, this.RFs);
      }
      paramVarArgs.aY(8, this.RFA);
      paramVarArgs.aY(9, this.TKm);
      if (this.TKn != null) {
        paramVarArgs.f(10, this.TKn);
      }
      if (this.RRi != null)
      {
        paramVarArgs.oE(14, this.RRi.computeSize());
        this.RRi.writeFields(paramVarArgs);
      }
      if (this.RFB != null) {
        paramVarArgs.f(15, this.RFB);
      }
      if (this.UserName != null) {
        paramVarArgs.f(16, this.UserName);
      }
      paramVarArgs.aY(17, this.rVU);
      if (this.RRj != null)
      {
        paramVarArgs.oE(18, this.RRj.computeSize());
        this.RRj.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(19, this.TKo);
      paramVarArgs.aY(20, this.RFv);
      if (this.RMc != null) {
        paramVarArgs.f(21, this.RMc);
      }
      if (this.TKp != null)
      {
        paramVarArgs.oE(22, this.TKp.computeSize());
        this.TKp.writeFields(paramVarArgs);
      }
      if (this.vhh != null) {
        paramVarArgs.f(23, this.vhh);
      }
      paramVarArgs.aY(24, this.TKq);
      if (this.RRh != null)
      {
        paramVarArgs.oE(25, this.RRh.computeSize());
        this.RRh.writeFields(paramVarArgs);
      }
      if (this.TKr != null) {
        paramVarArgs.f(26, this.TKr);
      }
      if (this.RRI != null)
      {
        paramVarArgs.oE(27, this.RRI.computeSize());
        this.RRI.writeFields(paramVarArgs);
      }
      if (this.TKs != null) {
        paramVarArgs.f(28, this.TKs);
      }
      if (this.Tll != null) {
        paramVarArgs.f(29, this.Tll);
      }
      if (this.Tln != null)
      {
        paramVarArgs.oE(30, this.Tln.computeSize());
        this.Tln.writeFields(paramVarArgs);
      }
      if (this.RMf != null)
      {
        paramVarArgs.oE(31, this.RMf.computeSize());
        this.RMf.writeFields(paramVarArgs);
      }
      if (this.RRJ != null)
      {
        paramVarArgs.oE(32, this.RRJ.computeSize());
        this.RRJ.writeFields(paramVarArgs);
      }
      if (this.RRK != null)
      {
        paramVarArgs.oE(33, this.RRK.computeSize());
        this.RRK.writeFields(paramVarArgs);
      }
      if (this.TKt != null)
      {
        paramVarArgs.oE(34, this.TKt.computeSize());
        this.TKt.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(35, this.RMk);
      paramVarArgs.aY(36, this.RMl);
      paramVarArgs.aY(37, this.RFD);
      if (this.RFE != null)
      {
        paramVarArgs.oE(38, this.RFE.computeSize());
        this.RFE.writeFields(paramVarArgs);
      }
      if (this.RFF != null)
      {
        paramVarArgs.oE(39, this.RFF.computeSize());
        this.RFF.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(133185);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label3208;
      }
    }
    label3208:
    for (paramInt = g.a.a.a.oD(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bM(2, this.vhf);
      paramInt = i;
      if (this.Tvd != null) {
        paramInt = i + g.a.a.b.b.a.g(3, this.Tvd);
      }
      i = paramInt;
      if (this.RFy != null) {
        i = paramInt + g.a.a.b.b.a.g(4, this.RFy);
      }
      paramInt = i;
      if (this.RFz != null) {
        paramInt = i + g.a.a.b.b.a.g(5, this.RFz);
      }
      i = paramInt;
      if (this.TKl != null) {
        i = paramInt + g.a.a.b.b.a.g(6, this.TKl);
      }
      paramInt = i;
      if (this.RFs != null) {
        paramInt = i + g.a.a.b.b.a.g(7, this.RFs);
      }
      i = paramInt + g.a.a.b.b.a.bM(8, this.RFA) + g.a.a.b.b.a.bM(9, this.TKm);
      paramInt = i;
      if (this.TKn != null) {
        paramInt = i + g.a.a.b.b.a.g(10, this.TKn);
      }
      i = paramInt;
      if (this.RRi != null) {
        i = paramInt + g.a.a.a.oD(14, this.RRi.computeSize());
      }
      paramInt = i;
      if (this.RFB != null) {
        paramInt = i + g.a.a.b.b.a.g(15, this.RFB);
      }
      i = paramInt;
      if (this.UserName != null) {
        i = paramInt + g.a.a.b.b.a.g(16, this.UserName);
      }
      i += g.a.a.b.b.a.bM(17, this.rVU);
      paramInt = i;
      if (this.RRj != null) {
        paramInt = i + g.a.a.a.oD(18, this.RRj.computeSize());
      }
      i = paramInt + g.a.a.b.b.a.bM(19, this.TKo) + g.a.a.b.b.a.bM(20, this.RFv);
      paramInt = i;
      if (this.RMc != null) {
        paramInt = i + g.a.a.b.b.a.g(21, this.RMc);
      }
      i = paramInt;
      if (this.TKp != null) {
        i = paramInt + g.a.a.a.oD(22, this.TKp.computeSize());
      }
      paramInt = i;
      if (this.vhh != null) {
        paramInt = i + g.a.a.b.b.a.g(23, this.vhh);
      }
      i = paramInt + g.a.a.b.b.a.bM(24, this.TKq);
      paramInt = i;
      if (this.RRh != null) {
        paramInt = i + g.a.a.a.oD(25, this.RRh.computeSize());
      }
      i = paramInt;
      if (this.TKr != null) {
        i = paramInt + g.a.a.b.b.a.g(26, this.TKr);
      }
      paramInt = i;
      if (this.RRI != null) {
        paramInt = i + g.a.a.a.oD(27, this.RRI.computeSize());
      }
      i = paramInt;
      if (this.TKs != null) {
        i = paramInt + g.a.a.b.b.a.g(28, this.TKs);
      }
      paramInt = i;
      if (this.Tll != null) {
        paramInt = i + g.a.a.b.b.a.g(29, this.Tll);
      }
      i = paramInt;
      if (this.Tln != null) {
        i = paramInt + g.a.a.a.oD(30, this.Tln.computeSize());
      }
      paramInt = i;
      if (this.RMf != null) {
        paramInt = i + g.a.a.a.oD(31, this.RMf.computeSize());
      }
      i = paramInt;
      if (this.RRJ != null) {
        i = paramInt + g.a.a.a.oD(32, this.RRJ.computeSize());
      }
      paramInt = i;
      if (this.RRK != null) {
        paramInt = i + g.a.a.a.oD(33, this.RRK.computeSize());
      }
      i = paramInt;
      if (this.TKt != null) {
        i = paramInt + g.a.a.a.oD(34, this.TKt.computeSize());
      }
      i = i + g.a.a.b.b.a.bM(35, this.RMk) + g.a.a.b.b.a.bM(36, this.RMl) + g.a.a.b.b.a.bM(37, this.RFD);
      paramInt = i;
      if (this.RFE != null) {
        paramInt = i + g.a.a.a.oD(38, this.RFE.computeSize());
      }
      i = paramInt;
      if (this.RFF != null) {
        i = paramInt + g.a.a.a.oD(39, this.RFF.computeSize());
      }
      AppMethodBeat.o(133185);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dyy.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyy.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
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
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        dco localdco = (dco)paramVarArgs[1];
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
            localdco.BaseResponse = ((jh)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(133185);
          return 0;
        case 2: 
          localdco.vhf = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(133185);
          return 0;
        case 3: 
          localdco.Tvd = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(133185);
          return 0;
        case 4: 
          localdco.RFy = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(133185);
          return 0;
        case 5: 
          localdco.RFz = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(133185);
          return 0;
        case 6: 
          localdco.TKl = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(133185);
          return 0;
        case 7: 
          localdco.RFs = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(133185);
          return 0;
        case 8: 
          localdco.RFA = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(133185);
          return 0;
        case 9: 
          localdco.TKm = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(133185);
          return 0;
        case 10: 
          localdco.TKn = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(133185);
          return 0;
        case 14: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new qr();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((qr)localObject2).parseFrom((byte[])localObject1);
            }
            localdco.RRi = ((qr)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(133185);
          return 0;
        case 15: 
          localdco.RFB = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(133185);
          return 0;
        case 16: 
          localdco.UserName = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(133185);
          return 0;
        case 17: 
          localdco.rVU = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(133185);
          return 0;
        case 18: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new dca();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((dca)localObject2).parseFrom((byte[])localObject1);
            }
            localdco.RRj = ((dca)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(133185);
          return 0;
        case 19: 
          localdco.TKo = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(133185);
          return 0;
        case 20: 
          localdco.RFv = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(133185);
          return 0;
        case 21: 
          localdco.RMc = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(133185);
          return 0;
        case 22: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new dlo();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((dlo)localObject2).parseFrom((byte[])localObject1);
            }
            localdco.TKp = ((dlo)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(133185);
          return 0;
        case 23: 
          localdco.vhh = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(133185);
          return 0;
        case 24: 
          localdco.TKq = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(133185);
          return 0;
        case 25: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new cke();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((cke)localObject2).parseFrom((byte[])localObject1);
            }
            localdco.RRh = ((cke)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(133185);
          return 0;
        case 26: 
          localdco.TKr = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(133185);
          return 0;
        case 27: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new te();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((te)localObject2).parseFrom((byte[])localObject1);
            }
            localdco.RRI = ((te)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(133185);
          return 0;
        case 28: 
          localdco.TKs = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(133185);
          return 0;
        case 29: 
          localdco.Tll = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(133185);
          return 0;
        case 30: 
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
            localdco.Tln = ((eae)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(133185);
          return 0;
        case 31: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new eii();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((eii)localObject2).parseFrom((byte[])localObject1);
            }
            localdco.RMf = ((eii)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(133185);
          return 0;
        case 32: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new te();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((te)localObject2).parseFrom((byte[])localObject1);
            }
            localdco.RRJ = ((te)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(133185);
          return 0;
        case 33: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new te();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((te)localObject2).parseFrom((byte[])localObject1);
            }
            localdco.RRK = ((te)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(133185);
          return 0;
        case 34: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new ecy();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((ecy)localObject2).parseFrom((byte[])localObject1);
            }
            localdco.TKt = ((ecy)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(133185);
          return 0;
        case 35: 
          localdco.RMk = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(133185);
          return 0;
        case 36: 
          localdco.RMl = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(133185);
          return 0;
        case 37: 
          localdco.RFD = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(133185);
          return 0;
        case 38: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new fqi();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((fqi)localObject2).parseFrom((byte[])localObject1);
            }
            localdco.RFE = ((fqi)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(133185);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new fqf();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((fqf)localObject2).parseFrom((byte[])localObject1);
          }
          localdco.RFF = ((fqf)localObject2);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dco
 * JD-Core Version:    0.7.0.1
 */