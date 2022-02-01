package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class epf
  extends dyy
{
  public LinkedList<epd> CNn;
  public com.tencent.mm.cd.b Tkb;
  public String UrL;
  public epi UrM;
  public String UrN;
  public String UrO;
  public int UrP;
  public int UrQ;
  public int UrR;
  public boolean UrS;
  public String UrT;
  public int UrU;
  public int UrV;
  public int UrW;
  public String UrX;
  public boolean UrY;
  public String UrZ;
  public int Urz;
  public String Usa;
  public int Usb;
  public epg Usc;
  public int Usd;
  
  public epf()
  {
    AppMethodBeat.i(152706);
    this.CNn = new LinkedList();
    AppMethodBeat.o(152706);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(152707);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new g.a.a.b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(152707);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.oE(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.e(2, 8, this.CNn);
      if (this.UrM != null)
      {
        paramVarArgs.oE(3, this.UrM.computeSize());
        this.UrM.writeFields(paramVarArgs);
      }
      if (this.UrN != null) {
        paramVarArgs.f(4, this.UrN);
      }
      if (this.UrO != null) {
        paramVarArgs.f(5, this.UrO);
      }
      paramVarArgs.aY(6, this.UrP);
      paramVarArgs.aY(9, this.UrQ);
      paramVarArgs.aY(10, this.UrR);
      paramVarArgs.aY(11, this.Urz);
      paramVarArgs.co(12, this.UrS);
      if (this.UrT != null) {
        paramVarArgs.f(13, this.UrT);
      }
      paramVarArgs.aY(14, this.UrU);
      paramVarArgs.aY(15, this.UrV);
      if (this.Tkb != null) {
        paramVarArgs.c(16, this.Tkb);
      }
      paramVarArgs.aY(17, this.UrW);
      if (this.UrX != null) {
        paramVarArgs.f(18, this.UrX);
      }
      paramVarArgs.co(19, this.UrY);
      if (this.UrZ != null) {
        paramVarArgs.f(20, this.UrZ);
      }
      if (this.Usa != null) {
        paramVarArgs.f(21, this.Usa);
      }
      paramVarArgs.aY(22, this.Usb);
      if (this.Usc != null)
      {
        paramVarArgs.oE(23, this.Usc.computeSize());
        this.Usc.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(24, this.Usd);
      if (this.UrL != null) {
        paramVarArgs.f(25, this.UrL);
      }
      AppMethodBeat.o(152707);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1714;
      }
    }
    label1714:
    for (paramInt = g.a.a.a.oD(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.a.c(2, 8, this.CNn);
      paramInt = i;
      if (this.UrM != null) {
        paramInt = i + g.a.a.a.oD(3, this.UrM.computeSize());
      }
      i = paramInt;
      if (this.UrN != null) {
        i = paramInt + g.a.a.b.b.a.g(4, this.UrN);
      }
      paramInt = i;
      if (this.UrO != null) {
        paramInt = i + g.a.a.b.b.a.g(5, this.UrO);
      }
      i = paramInt + g.a.a.b.b.a.bM(6, this.UrP) + g.a.a.b.b.a.bM(9, this.UrQ) + g.a.a.b.b.a.bM(10, this.UrR) + g.a.a.b.b.a.bM(11, this.Urz) + (g.a.a.b.b.a.gL(12) + 1);
      paramInt = i;
      if (this.UrT != null) {
        paramInt = i + g.a.a.b.b.a.g(13, this.UrT);
      }
      i = paramInt + g.a.a.b.b.a.bM(14, this.UrU) + g.a.a.b.b.a.bM(15, this.UrV);
      paramInt = i;
      if (this.Tkb != null) {
        paramInt = i + g.a.a.b.b.a.b(16, this.Tkb);
      }
      i = paramInt + g.a.a.b.b.a.bM(17, this.UrW);
      paramInt = i;
      if (this.UrX != null) {
        paramInt = i + g.a.a.b.b.a.g(18, this.UrX);
      }
      i = paramInt + (g.a.a.b.b.a.gL(19) + 1);
      paramInt = i;
      if (this.UrZ != null) {
        paramInt = i + g.a.a.b.b.a.g(20, this.UrZ);
      }
      i = paramInt;
      if (this.Usa != null) {
        i = paramInt + g.a.a.b.b.a.g(21, this.Usa);
      }
      i += g.a.a.b.b.a.bM(22, this.Usb);
      paramInt = i;
      if (this.Usc != null) {
        paramInt = i + g.a.a.a.oD(23, this.Usc.computeSize());
      }
      i = paramInt + g.a.a.b.b.a.bM(24, this.Usd);
      paramInt = i;
      if (this.UrL != null) {
        paramInt = i + g.a.a.b.b.a.g(25, this.UrL);
      }
      AppMethodBeat.o(152707);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.CNn.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = dyy.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyy.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new g.a.a.b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(152707);
          throw paramVarArgs;
        }
        AppMethodBeat.o(152707);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        epf localepf = (epf)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        case 7: 
        case 8: 
        default: 
          AppMethodBeat.o(152707);
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
            localepf.BaseResponse = ((jh)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(152707);
          return 0;
        case 2: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new epd();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((epd)localObject2).parseFrom((byte[])localObject1);
            }
            localepf.CNn.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(152707);
          return 0;
        case 3: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new epi();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((epi)localObject2).parseFrom((byte[])localObject1);
            }
            localepf.UrM = ((epi)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(152707);
          return 0;
        case 4: 
          localepf.UrN = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(152707);
          return 0;
        case 5: 
          localepf.UrO = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(152707);
          return 0;
        case 6: 
          localepf.UrP = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(152707);
          return 0;
        case 9: 
          localepf.UrQ = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(152707);
          return 0;
        case 10: 
          localepf.UrR = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(152707);
          return 0;
        case 11: 
          localepf.Urz = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(152707);
          return 0;
        case 12: 
          localepf.UrS = ((g.a.a.a.a)localObject1).abFh.AB();
          AppMethodBeat.o(152707);
          return 0;
        case 13: 
          localepf.UrT = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(152707);
          return 0;
        case 14: 
          localepf.UrU = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(152707);
          return 0;
        case 15: 
          localepf.UrV = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(152707);
          return 0;
        case 16: 
          localepf.Tkb = ((g.a.a.a.a)localObject1).abFh.iUw();
          AppMethodBeat.o(152707);
          return 0;
        case 17: 
          localepf.UrW = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(152707);
          return 0;
        case 18: 
          localepf.UrX = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(152707);
          return 0;
        case 19: 
          localepf.UrY = ((g.a.a.a.a)localObject1).abFh.AB();
          AppMethodBeat.o(152707);
          return 0;
        case 20: 
          localepf.UrZ = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(152707);
          return 0;
        case 21: 
          localepf.Usa = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(152707);
          return 0;
        case 22: 
          localepf.Usb = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(152707);
          return 0;
        case 23: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new epg();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((epg)localObject2).parseFrom((byte[])localObject1);
            }
            localepf.Usc = ((epg)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(152707);
          return 0;
        case 24: 
          localepf.Usd = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(152707);
          return 0;
        }
        localepf.UrL = ((g.a.a.a.a)localObject1).abFh.readString();
        AppMethodBeat.o(152707);
        return 0;
      }
      AppMethodBeat.o(152707);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.epf
 * JD-Core Version:    0.7.0.1
 */