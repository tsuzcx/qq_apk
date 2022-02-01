package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cde
  extends erp
{
  public int IJG;
  public String UserName;
  public int YFu;
  public int YIc;
  public int YIq;
  public gol YJr;
  public String YKc;
  public int YKo;
  public int ZiC;
  public int ZiD;
  public int aajd;
  public String aamA;
  public int aamC;
  public gol aamD;
  public int aamE;
  public String aamF;
  public etl aamX;
  public etl aamY;
  public etl aamZ;
  public String aamz;
  public etl aana;
  public String aanb;
  public int aanc;
  public gol aand;
  public int aane;
  public String aanf;
  public int aang;
  public gol aanh;
  public String aani;
  public String aanj;
  public String aank;
  public cdi aanl;
  public String vYk;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(152552);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.qD(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(2, this.YIq);
      if (this.YJr != null)
      {
        paramVarArgs.qD(3, this.YJr.computeSize());
        this.YJr.writeFields(paramVarArgs);
      }
      if (this.aamX != null)
      {
        paramVarArgs.qD(4, this.aamX.computeSize());
        this.aamX.writeFields(paramVarArgs);
      }
      if (this.aamY != null)
      {
        paramVarArgs.qD(5, this.aamY.computeSize());
        this.aamY.writeFields(paramVarArgs);
      }
      if (this.aamZ != null)
      {
        paramVarArgs.qD(6, this.aamZ.computeSize());
        this.aamZ.writeFields(paramVarArgs);
      }
      if (this.aana != null)
      {
        paramVarArgs.qD(7, this.aana.computeSize());
        this.aana.writeFields(paramVarArgs);
      }
      if (this.aanb != null) {
        paramVarArgs.g(8, this.aanb);
      }
      paramVarArgs.bS(9, this.aanc);
      paramVarArgs.bS(10, this.IJG);
      if (this.UserName != null) {
        paramVarArgs.g(11, this.UserName);
      }
      if (this.YKc != null) {
        paramVarArgs.g(12, this.YKc);
      }
      if (this.aand != null)
      {
        paramVarArgs.qD(13, this.aand.computeSize());
        this.aand.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(14, this.YKo);
      paramVarArgs.bS(15, this.aamE);
      paramVarArgs.bS(16, this.YFu);
      if (this.vYk != null) {
        paramVarArgs.g(17, this.vYk);
      }
      paramVarArgs.bS(18, this.ZiC);
      paramVarArgs.bS(19, this.ZiD);
      paramVarArgs.bS(20, this.aane);
      if (this.aanf != null) {
        paramVarArgs.g(21, this.aanf);
      }
      paramVarArgs.bS(22, this.aang);
      if (this.aanh != null)
      {
        paramVarArgs.qD(23, this.aanh.computeSize());
        this.aanh.writeFields(paramVarArgs);
      }
      if (this.aamF != null) {
        paramVarArgs.g(24, this.aamF);
      }
      paramVarArgs.bS(25, this.YIc);
      if (this.aamz != null) {
        paramVarArgs.g(26, this.aamz);
      }
      if (this.aamA != null) {
        paramVarArgs.g(27, this.aamA);
      }
      if (this.aani != null) {
        paramVarArgs.g(28, this.aani);
      }
      if (this.aanj != null) {
        paramVarArgs.g(29, this.aanj);
      }
      if (this.aank != null) {
        paramVarArgs.g(30, this.aank);
      }
      if (this.aanl != null)
      {
        paramVarArgs.qD(31, this.aanl.computeSize());
        this.aanl.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(33, this.aamC);
      paramVarArgs.bS(34, this.aajd);
      if (this.aamD != null)
      {
        paramVarArgs.qD(35, this.aamD.computeSize());
        this.aamD.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(152552);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label2754;
      }
    }
    label2754:
    for (paramInt = i.a.a.a.qC(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + i.a.a.b.b.a.cJ(2, this.YIq);
      paramInt = i;
      if (this.YJr != null) {
        paramInt = i + i.a.a.a.qC(3, this.YJr.computeSize());
      }
      i = paramInt;
      if (this.aamX != null) {
        i = paramInt + i.a.a.a.qC(4, this.aamX.computeSize());
      }
      paramInt = i;
      if (this.aamY != null) {
        paramInt = i + i.a.a.a.qC(5, this.aamY.computeSize());
      }
      i = paramInt;
      if (this.aamZ != null) {
        i = paramInt + i.a.a.a.qC(6, this.aamZ.computeSize());
      }
      paramInt = i;
      if (this.aana != null) {
        paramInt = i + i.a.a.a.qC(7, this.aana.computeSize());
      }
      i = paramInt;
      if (this.aanb != null) {
        i = paramInt + i.a.a.b.b.a.h(8, this.aanb);
      }
      i = i + i.a.a.b.b.a.cJ(9, this.aanc) + i.a.a.b.b.a.cJ(10, this.IJG);
      paramInt = i;
      if (this.UserName != null) {
        paramInt = i + i.a.a.b.b.a.h(11, this.UserName);
      }
      i = paramInt;
      if (this.YKc != null) {
        i = paramInt + i.a.a.b.b.a.h(12, this.YKc);
      }
      paramInt = i;
      if (this.aand != null) {
        paramInt = i + i.a.a.a.qC(13, this.aand.computeSize());
      }
      i = paramInt + i.a.a.b.b.a.cJ(14, this.YKo) + i.a.a.b.b.a.cJ(15, this.aamE) + i.a.a.b.b.a.cJ(16, this.YFu);
      paramInt = i;
      if (this.vYk != null) {
        paramInt = i + i.a.a.b.b.a.h(17, this.vYk);
      }
      i = paramInt + i.a.a.b.b.a.cJ(18, this.ZiC) + i.a.a.b.b.a.cJ(19, this.ZiD) + i.a.a.b.b.a.cJ(20, this.aane);
      paramInt = i;
      if (this.aanf != null) {
        paramInt = i + i.a.a.b.b.a.h(21, this.aanf);
      }
      i = paramInt + i.a.a.b.b.a.cJ(22, this.aang);
      paramInt = i;
      if (this.aanh != null) {
        paramInt = i + i.a.a.a.qC(23, this.aanh.computeSize());
      }
      i = paramInt;
      if (this.aamF != null) {
        i = paramInt + i.a.a.b.b.a.h(24, this.aamF);
      }
      i += i.a.a.b.b.a.cJ(25, this.YIc);
      paramInt = i;
      if (this.aamz != null) {
        paramInt = i + i.a.a.b.b.a.h(26, this.aamz);
      }
      i = paramInt;
      if (this.aamA != null) {
        i = paramInt + i.a.a.b.b.a.h(27, this.aamA);
      }
      paramInt = i;
      if (this.aani != null) {
        paramInt = i + i.a.a.b.b.a.h(28, this.aani);
      }
      i = paramInt;
      if (this.aanj != null) {
        i = paramInt + i.a.a.b.b.a.h(29, this.aanj);
      }
      paramInt = i;
      if (this.aank != null) {
        paramInt = i + i.a.a.b.b.a.h(30, this.aank);
      }
      i = paramInt;
      if (this.aanl != null) {
        i = paramInt + i.a.a.a.qC(31, this.aanl.computeSize());
      }
      i = i + i.a.a.b.b.a.cJ(33, this.aamC) + i.a.a.b.b.a.cJ(34, this.aajd);
      paramInt = i;
      if (this.aamD != null) {
        paramInt = i + i.a.a.a.qC(35, this.aamD.computeSize());
      }
      AppMethodBeat.o(152552);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = erp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = erp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(152552);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        cde localcde = (cde)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        case 32: 
        default: 
          AppMethodBeat.o(152552);
          return -1;
        case 1: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new kc();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((kc)localObject2).parseFrom((byte[])localObject1);
            }
            localcde.BaseRequest = ((kc)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(152552);
          return 0;
        case 2: 
          localcde.YIq = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(152552);
          return 0;
        case 3: 
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
            localcde.YJr = ((gol)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(152552);
          return 0;
        case 4: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new etl();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((etl)localObject2).dh((byte[])localObject1);
            }
            localcde.aamX = ((etl)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(152552);
          return 0;
        case 5: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new etl();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((etl)localObject2).dh((byte[])localObject1);
            }
            localcde.aamY = ((etl)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(152552);
          return 0;
        case 6: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new etl();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((etl)localObject2).dh((byte[])localObject1);
            }
            localcde.aamZ = ((etl)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(152552);
          return 0;
        case 7: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new etl();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((etl)localObject2).dh((byte[])localObject1);
            }
            localcde.aana = ((etl)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(152552);
          return 0;
        case 8: 
          localcde.aanb = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(152552);
          return 0;
        case 9: 
          localcde.aanc = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(152552);
          return 0;
        case 10: 
          localcde.IJG = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(152552);
          return 0;
        case 11: 
          localcde.UserName = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(152552);
          return 0;
        case 12: 
          localcde.YKc = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(152552);
          return 0;
        case 13: 
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
            localcde.aand = ((gol)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(152552);
          return 0;
        case 14: 
          localcde.YKo = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(152552);
          return 0;
        case 15: 
          localcde.aamE = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(152552);
          return 0;
        case 16: 
          localcde.YFu = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(152552);
          return 0;
        case 17: 
          localcde.vYk = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(152552);
          return 0;
        case 18: 
          localcde.ZiC = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(152552);
          return 0;
        case 19: 
          localcde.ZiD = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(152552);
          return 0;
        case 20: 
          localcde.aane = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(152552);
          return 0;
        case 21: 
          localcde.aanf = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(152552);
          return 0;
        case 22: 
          localcde.aang = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(152552);
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
            localcde.aanh = ((gol)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(152552);
          return 0;
        case 24: 
          localcde.aamF = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(152552);
          return 0;
        case 25: 
          localcde.YIc = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(152552);
          return 0;
        case 26: 
          localcde.aamz = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(152552);
          return 0;
        case 27: 
          localcde.aamA = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(152552);
          return 0;
        case 28: 
          localcde.aani = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(152552);
          return 0;
        case 29: 
          localcde.aanj = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(152552);
          return 0;
        case 30: 
          localcde.aank = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(152552);
          return 0;
        case 31: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new cdi();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((cdi)localObject2).parseFrom((byte[])localObject1);
            }
            localcde.aanl = ((cdi)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(152552);
          return 0;
        case 33: 
          localcde.aamC = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(152552);
          return 0;
        case 34: 
          localcde.aajd = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(152552);
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
          localcde.aamD = ((gol)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(152552);
        return 0;
      }
      AppMethodBeat.o(152552);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cde
 * JD-Core Version:    0.7.0.1
 */