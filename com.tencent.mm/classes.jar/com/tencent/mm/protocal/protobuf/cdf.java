package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;
import java.util.LinkedList;

public final class cdf
  extends esc
{
  public String IHZ;
  public String UserName;
  public gol aamD;
  public int aamK;
  public String aamM;
  public String aamN;
  public LinkedList<dam> aamS;
  public gol aanA;
  public gol aanh;
  public String aanm;
  public String aann;
  public ddq aano;
  public ccm aanp;
  public String aanq;
  public int aanr;
  public LinkedList<rd> aans;
  public String aant;
  public String aanu;
  public String aanv;
  public aht aanw;
  public gol aanx;
  public int aany;
  public gol aanz;
  public String hAP;
  public String nUB;
  
  public cdf()
  {
    AppMethodBeat.i(152553);
    this.aans = new LinkedList();
    this.aamS = new LinkedList();
    AppMethodBeat.o(152553);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(152554);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(152554);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.qD(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.aanm != null) {
        paramVarArgs.g(2, this.aanm);
      }
      if (this.aann != null) {
        paramVarArgs.g(3, this.aann);
      }
      paramVarArgs.bS(4, this.aamK);
      if (this.hAP != null) {
        paramVarArgs.g(5, this.hAP);
      }
      if (this.nUB != null) {
        paramVarArgs.g(6, this.nUB);
      }
      if (this.aano != null)
      {
        paramVarArgs.qD(7, this.aano.computeSize());
        this.aano.writeFields(paramVarArgs);
      }
      if (this.aanp != null)
      {
        paramVarArgs.qD(8, this.aanp.computeSize());
        this.aanp.writeFields(paramVarArgs);
      }
      if (this.UserName != null) {
        paramVarArgs.g(9, this.UserName);
      }
      if (this.aanq != null) {
        paramVarArgs.g(15, this.aanq);
      }
      paramVarArgs.bS(16, this.aanr);
      paramVarArgs.e(17, 8, this.aans);
      if (this.aant != null) {
        paramVarArgs.g(18, this.aant);
      }
      if (this.aanu != null) {
        paramVarArgs.g(20, this.aanu);
      }
      if (this.aanv != null) {
        paramVarArgs.g(21, this.aanv);
      }
      if (this.aanw != null)
      {
        paramVarArgs.qD(22, this.aanw.computeSize());
        this.aanw.writeFields(paramVarArgs);
      }
      if (this.aanx != null)
      {
        paramVarArgs.qD(23, this.aanx.computeSize());
        this.aanx.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(24, this.aany);
      paramVarArgs.e(25, 8, this.aamS);
      if (this.IHZ != null) {
        paramVarArgs.g(26, this.IHZ);
      }
      if (this.aamM != null) {
        paramVarArgs.g(27, this.aamM);
      }
      if (this.aanh != null)
      {
        paramVarArgs.qD(28, this.aanh.computeSize());
        this.aanh.writeFields(paramVarArgs);
      }
      if (this.aamN != null) {
        paramVarArgs.g(29, this.aamN);
      }
      if (this.aanz != null)
      {
        paramVarArgs.qD(30, this.aanz.computeSize());
        this.aanz.writeFields(paramVarArgs);
      }
      if (this.aanA != null)
      {
        paramVarArgs.qD(31, this.aanA.computeSize());
        this.aanA.writeFields(paramVarArgs);
      }
      if (this.aamD != null)
      {
        paramVarArgs.qD(32, this.aamD.computeSize());
        this.aamD.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(152554);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label2540;
      }
    }
    label2540:
    for (int i = i.a.a.a.qC(1, this.BaseResponse.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.aanm != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.aanm);
      }
      i = paramInt;
      if (this.aann != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.aann);
      }
      i += i.a.a.b.b.a.cJ(4, this.aamK);
      paramInt = i;
      if (this.hAP != null) {
        paramInt = i + i.a.a.b.b.a.h(5, this.hAP);
      }
      i = paramInt;
      if (this.nUB != null) {
        i = paramInt + i.a.a.b.b.a.h(6, this.nUB);
      }
      paramInt = i;
      if (this.aano != null) {
        paramInt = i + i.a.a.a.qC(7, this.aano.computeSize());
      }
      i = paramInt;
      if (this.aanp != null) {
        i = paramInt + i.a.a.a.qC(8, this.aanp.computeSize());
      }
      paramInt = i;
      if (this.UserName != null) {
        paramInt = i + i.a.a.b.b.a.h(9, this.UserName);
      }
      i = paramInt;
      if (this.aanq != null) {
        i = paramInt + i.a.a.b.b.a.h(15, this.aanq);
      }
      i = i + i.a.a.b.b.a.cJ(16, this.aanr) + i.a.a.a.c(17, 8, this.aans);
      paramInt = i;
      if (this.aant != null) {
        paramInt = i + i.a.a.b.b.a.h(18, this.aant);
      }
      i = paramInt;
      if (this.aanu != null) {
        i = paramInt + i.a.a.b.b.a.h(20, this.aanu);
      }
      paramInt = i;
      if (this.aanv != null) {
        paramInt = i + i.a.a.b.b.a.h(21, this.aanv);
      }
      i = paramInt;
      if (this.aanw != null) {
        i = paramInt + i.a.a.a.qC(22, this.aanw.computeSize());
      }
      paramInt = i;
      if (this.aanx != null) {
        paramInt = i + i.a.a.a.qC(23, this.aanx.computeSize());
      }
      i = paramInt + i.a.a.b.b.a.cJ(24, this.aany) + i.a.a.a.c(25, 8, this.aamS);
      paramInt = i;
      if (this.IHZ != null) {
        paramInt = i + i.a.a.b.b.a.h(26, this.IHZ);
      }
      i = paramInt;
      if (this.aamM != null) {
        i = paramInt + i.a.a.b.b.a.h(27, this.aamM);
      }
      paramInt = i;
      if (this.aanh != null) {
        paramInt = i + i.a.a.a.qC(28, this.aanh.computeSize());
      }
      i = paramInt;
      if (this.aamN != null) {
        i = paramInt + i.a.a.b.b.a.h(29, this.aamN);
      }
      paramInt = i;
      if (this.aanz != null) {
        paramInt = i + i.a.a.a.qC(30, this.aanz.computeSize());
      }
      i = paramInt;
      if (this.aanA != null) {
        i = paramInt + i.a.a.a.qC(31, this.aanA.computeSize());
      }
      paramInt = i;
      if (this.aamD != null) {
        paramInt = i + i.a.a.a.qC(32, this.aamD.computeSize());
      }
      AppMethodBeat.o(152554);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.aans.clear();
        this.aamS.clear();
        paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = esc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = esc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(152554);
          throw paramVarArgs;
        }
        AppMethodBeat.o(152554);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        cdf localcdf = (cdf)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        case 10: 
        case 11: 
        case 12: 
        case 13: 
        case 14: 
        case 19: 
        default: 
          AppMethodBeat.o(152554);
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
            localcdf.BaseResponse = ((kd)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(152554);
          return 0;
        case 2: 
          localcdf.aanm = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(152554);
          return 0;
        case 3: 
          localcdf.aann = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(152554);
          return 0;
        case 4: 
          localcdf.aamK = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(152554);
          return 0;
        case 5: 
          localcdf.hAP = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(152554);
          return 0;
        case 6: 
          localcdf.nUB = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(152554);
          return 0;
        case 7: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new ddq();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((ddq)localObject2).parseFrom((byte[])localObject1);
            }
            localcdf.aano = ((ddq)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(152554);
          return 0;
        case 8: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new ccm();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((ccm)localObject2).parseFrom((byte[])localObject1);
            }
            localcdf.aanp = ((ccm)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(152554);
          return 0;
        case 9: 
          localcdf.UserName = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(152554);
          return 0;
        case 15: 
          localcdf.aanq = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(152554);
          return 0;
        case 16: 
          localcdf.aanr = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(152554);
          return 0;
        case 17: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new rd();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((rd)localObject2).parseFrom((byte[])localObject1);
            }
            localcdf.aans.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(152554);
          return 0;
        case 18: 
          localcdf.aant = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(152554);
          return 0;
        case 20: 
          localcdf.aanu = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(152554);
          return 0;
        case 21: 
          localcdf.aanv = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(152554);
          return 0;
        case 22: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new aht();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((aht)localObject2).parseFrom((byte[])localObject1);
            }
            localcdf.aanw = ((aht)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(152554);
          return 0;
        case 23: 
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
            localcdf.aanx = ((gol)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(152554);
          return 0;
        case 24: 
          localcdf.aany = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(152554);
          return 0;
        case 25: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new dam();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((dam)localObject2).parseFrom((byte[])localObject1);
            }
            localcdf.aamS.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(152554);
          return 0;
        case 26: 
          localcdf.IHZ = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(152554);
          return 0;
        case 27: 
          localcdf.aamM = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(152554);
          return 0;
        case 28: 
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
            localcdf.aanh = ((gol)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(152554);
          return 0;
        case 29: 
          localcdf.aamN = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(152554);
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
            localcdf.aanz = ((gol)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(152554);
          return 0;
        case 31: 
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
            localcdf.aanA = ((gol)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(152554);
          return 0;
        }
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
          localcdf.aamD = ((gol)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(152554);
        return 0;
      }
      AppMethodBeat.o(152554);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cdf
 * JD-Core Version:    0.7.0.1
 */