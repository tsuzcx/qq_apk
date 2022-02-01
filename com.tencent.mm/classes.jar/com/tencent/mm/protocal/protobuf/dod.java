package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dod
  extends com.tencent.mm.bx.a
{
  public String DBL;
  public String DBM;
  public String DBN;
  public String DBO;
  public String DBP;
  public LinkedList<aag> DBj;
  public long HCA;
  public long HCB;
  public LinkedList<dof> HCC;
  public int HCD;
  public long HCE;
  public dny HCF;
  public int HCG;
  public int HCH;
  public boolean HCI;
  public String HCJ;
  public dob HCK;
  public int HCL;
  public dod HCM;
  public int HCN;
  public dnw HCO;
  public String HCt;
  public long HCu;
  public String HCv;
  public String HCw;
  public int HCx;
  public String HCy;
  public String HCz;
  public long dle;
  public boolean dmo;
  public String lox;
  public String qeQ;
  public String qeR;
  public String source;
  public LinkedList<dei> tSj;
  public String tSk;
  public int thumbHeight;
  public int thumbWidth;
  public long timestamp;
  public String title;
  public String tul;
  public String uaw;
  public String videoUrl;
  public int zSz;
  
  public dod()
  {
    AppMethodBeat.i(153012);
    this.tSj = new LinkedList();
    this.HCC = new LinkedList();
    this.DBj = new LinkedList();
    AppMethodBeat.o(153012);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(153013);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.title != null) {
        paramVarArgs.d(1, this.title);
      }
      if (this.videoUrl != null) {
        paramVarArgs.d(2, this.videoUrl);
      }
      if (this.HCt != null) {
        paramVarArgs.d(3, this.HCt);
      }
      paramVarArgs.aS(4, this.zSz);
      if (this.tSk != null) {
        paramVarArgs.d(5, this.tSk);
      }
      paramVarArgs.aS(6, this.thumbWidth);
      paramVarArgs.aS(7, this.thumbHeight);
      if (this.qeQ != null) {
        paramVarArgs.d(8, this.qeQ);
      }
      if (this.qeR != null) {
        paramVarArgs.d(9, this.qeR);
      }
      if (this.uaw != null) {
        paramVarArgs.d(10, this.uaw);
      }
      if (this.DBL != null) {
        paramVarArgs.d(11, this.DBL);
      }
      if (this.DBM != null) {
        paramVarArgs.d(12, this.DBM);
      }
      if (this.DBN != null) {
        paramVarArgs.d(13, this.DBN);
      }
      if (this.source != null) {
        paramVarArgs.d(14, this.source);
      }
      if (this.lox != null) {
        paramVarArgs.d(15, this.lox);
      }
      paramVarArgs.aY(16, this.HCu);
      if (this.HCv != null) {
        paramVarArgs.d(17, this.HCv);
      }
      if (this.HCw != null) {
        paramVarArgs.d(18, this.HCw);
      }
      if (this.DBO != null) {
        paramVarArgs.d(19, this.DBO);
      }
      if (this.DBP != null) {
        paramVarArgs.d(20, this.DBP);
      }
      paramVarArgs.aS(21, this.HCx);
      if (this.HCy != null) {
        paramVarArgs.d(22, this.HCy);
      }
      if (this.HCz != null) {
        paramVarArgs.d(23, this.HCz);
      }
      paramVarArgs.e(24, 8, this.tSj);
      paramVarArgs.aY(25, this.timestamp);
      paramVarArgs.bt(26, this.dmo);
      if (this.tul != null) {
        paramVarArgs.d(27, this.tul);
      }
      paramVarArgs.aY(28, this.HCA);
      paramVarArgs.aY(29, this.dle);
      paramVarArgs.aY(30, this.HCB);
      paramVarArgs.e(31, 8, this.HCC);
      paramVarArgs.aS(32, this.HCD);
      paramVarArgs.aY(33, this.HCE);
      if (this.HCF != null)
      {
        paramVarArgs.lC(34, this.HCF.computeSize());
        this.HCF.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(35, this.HCG);
      paramVarArgs.aS(36, this.HCH);
      paramVarArgs.bt(37, this.HCI);
      if (this.HCJ != null) {
        paramVarArgs.d(38, this.HCJ);
      }
      if (this.HCK != null)
      {
        paramVarArgs.lC(39, this.HCK.computeSize());
        this.HCK.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(40, this.HCL);
      if (this.HCM != null)
      {
        paramVarArgs.lC(41, this.HCM.computeSize());
        this.HCM.writeFields(paramVarArgs);
      }
      paramVarArgs.e(42, 8, this.DBj);
      paramVarArgs.aS(43, this.HCN);
      if (this.HCO != null)
      {
        paramVarArgs.lC(44, this.HCO.computeSize());
        this.HCO.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(153013);
      return 0;
    }
    if (paramInt == 1) {
      if (this.title == null) {
        break label3186;
      }
    }
    label3186:
    for (int i = f.a.a.b.b.a.e(1, this.title) + 0;; i = 0)
    {
      paramInt = i;
      if (this.videoUrl != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.videoUrl);
      }
      i = paramInt;
      if (this.HCt != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.HCt);
      }
      i += f.a.a.b.b.a.bz(4, this.zSz);
      paramInt = i;
      if (this.tSk != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.tSk);
      }
      i = paramInt + f.a.a.b.b.a.bz(6, this.thumbWidth) + f.a.a.b.b.a.bz(7, this.thumbHeight);
      paramInt = i;
      if (this.qeQ != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.qeQ);
      }
      i = paramInt;
      if (this.qeR != null) {
        i = paramInt + f.a.a.b.b.a.e(9, this.qeR);
      }
      paramInt = i;
      if (this.uaw != null) {
        paramInt = i + f.a.a.b.b.a.e(10, this.uaw);
      }
      i = paramInt;
      if (this.DBL != null) {
        i = paramInt + f.a.a.b.b.a.e(11, this.DBL);
      }
      paramInt = i;
      if (this.DBM != null) {
        paramInt = i + f.a.a.b.b.a.e(12, this.DBM);
      }
      i = paramInt;
      if (this.DBN != null) {
        i = paramInt + f.a.a.b.b.a.e(13, this.DBN);
      }
      paramInt = i;
      if (this.source != null) {
        paramInt = i + f.a.a.b.b.a.e(14, this.source);
      }
      i = paramInt;
      if (this.lox != null) {
        i = paramInt + f.a.a.b.b.a.e(15, this.lox);
      }
      i += f.a.a.b.b.a.p(16, this.HCu);
      paramInt = i;
      if (this.HCv != null) {
        paramInt = i + f.a.a.b.b.a.e(17, this.HCv);
      }
      i = paramInt;
      if (this.HCw != null) {
        i = paramInt + f.a.a.b.b.a.e(18, this.HCw);
      }
      paramInt = i;
      if (this.DBO != null) {
        paramInt = i + f.a.a.b.b.a.e(19, this.DBO);
      }
      i = paramInt;
      if (this.DBP != null) {
        i = paramInt + f.a.a.b.b.a.e(20, this.DBP);
      }
      i += f.a.a.b.b.a.bz(21, this.HCx);
      paramInt = i;
      if (this.HCy != null) {
        paramInt = i + f.a.a.b.b.a.e(22, this.HCy);
      }
      i = paramInt;
      if (this.HCz != null) {
        i = paramInt + f.a.a.b.b.a.e(23, this.HCz);
      }
      i = i + f.a.a.a.c(24, 8, this.tSj) + f.a.a.b.b.a.p(25, this.timestamp) + f.a.a.b.b.a.alV(26);
      paramInt = i;
      if (this.tul != null) {
        paramInt = i + f.a.a.b.b.a.e(27, this.tul);
      }
      i = paramInt + f.a.a.b.b.a.p(28, this.HCA) + f.a.a.b.b.a.p(29, this.dle) + f.a.a.b.b.a.p(30, this.HCB) + f.a.a.a.c(31, 8, this.HCC) + f.a.a.b.b.a.bz(32, this.HCD) + f.a.a.b.b.a.p(33, this.HCE);
      paramInt = i;
      if (this.HCF != null) {
        paramInt = i + f.a.a.a.lB(34, this.HCF.computeSize());
      }
      i = paramInt + f.a.a.b.b.a.bz(35, this.HCG) + f.a.a.b.b.a.bz(36, this.HCH) + f.a.a.b.b.a.alV(37);
      paramInt = i;
      if (this.HCJ != null) {
        paramInt = i + f.a.a.b.b.a.e(38, this.HCJ);
      }
      i = paramInt;
      if (this.HCK != null) {
        i = paramInt + f.a.a.a.lB(39, this.HCK.computeSize());
      }
      i += f.a.a.b.b.a.bz(40, this.HCL);
      paramInt = i;
      if (this.HCM != null) {
        paramInt = i + f.a.a.a.lB(41, this.HCM.computeSize());
      }
      i = paramInt + f.a.a.a.c(42, 8, this.DBj) + f.a.a.b.b.a.bz(43, this.HCN);
      paramInt = i;
      if (this.HCO != null) {
        paramInt = i + f.a.a.a.lB(44, this.HCO.computeSize());
      }
      AppMethodBeat.o(153013);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.tSj.clear();
        this.HCC.clear();
        this.DBj.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(153013);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        dod localdod = (dod)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(153013);
          return -1;
        case 1: 
          localdod.title = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(153013);
          return 0;
        case 2: 
          localdod.videoUrl = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(153013);
          return 0;
        case 3: 
          localdod.HCt = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(153013);
          return 0;
        case 4: 
          localdod.zSz = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(153013);
          return 0;
        case 5: 
          localdod.tSk = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(153013);
          return 0;
        case 6: 
          localdod.thumbWidth = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(153013);
          return 0;
        case 7: 
          localdod.thumbHeight = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(153013);
          return 0;
        case 8: 
          localdod.qeQ = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(153013);
          return 0;
        case 9: 
          localdod.qeR = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(153013);
          return 0;
        case 10: 
          localdod.uaw = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(153013);
          return 0;
        case 11: 
          localdod.DBL = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(153013);
          return 0;
        case 12: 
          localdod.DBM = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(153013);
          return 0;
        case 13: 
          localdod.DBN = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(153013);
          return 0;
        case 14: 
          localdod.source = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(153013);
          return 0;
        case 15: 
          localdod.lox = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(153013);
          return 0;
        case 16: 
          localdod.HCu = ((f.a.a.a.a)localObject1).NPN.zd();
          AppMethodBeat.o(153013);
          return 0;
        case 17: 
          localdod.HCv = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(153013);
          return 0;
        case 18: 
          localdod.HCw = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(153013);
          return 0;
        case 19: 
          localdod.DBO = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(153013);
          return 0;
        case 20: 
          localdod.DBP = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(153013);
          return 0;
        case 21: 
          localdod.HCx = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(153013);
          return 0;
        case 22: 
          localdod.HCy = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(153013);
          return 0;
        case 23: 
          localdod.HCz = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(153013);
          return 0;
        case 24: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dei();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dei)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdod.tSj.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(153013);
          return 0;
        case 25: 
          localdod.timestamp = ((f.a.a.a.a)localObject1).NPN.zd();
          AppMethodBeat.o(153013);
          return 0;
        case 26: 
          localdod.dmo = ((f.a.a.a.a)localObject1).NPN.grw();
          AppMethodBeat.o(153013);
          return 0;
        case 27: 
          localdod.tul = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(153013);
          return 0;
        case 28: 
          localdod.HCA = ((f.a.a.a.a)localObject1).NPN.zd();
          AppMethodBeat.o(153013);
          return 0;
        case 29: 
          localdod.dle = ((f.a.a.a.a)localObject1).NPN.zd();
          AppMethodBeat.o(153013);
          return 0;
        case 30: 
          localdod.HCB = ((f.a.a.a.a)localObject1).NPN.zd();
          AppMethodBeat.o(153013);
          return 0;
        case 31: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dof();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dof)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdod.HCC.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(153013);
          return 0;
        case 32: 
          localdod.HCD = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(153013);
          return 0;
        case 33: 
          localdod.HCE = ((f.a.a.a.a)localObject1).NPN.zd();
          AppMethodBeat.o(153013);
          return 0;
        case 34: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dny();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dny)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdod.HCF = ((dny)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(153013);
          return 0;
        case 35: 
          localdod.HCG = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(153013);
          return 0;
        case 36: 
          localdod.HCH = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(153013);
          return 0;
        case 37: 
          localdod.HCI = ((f.a.a.a.a)localObject1).NPN.grw();
          AppMethodBeat.o(153013);
          return 0;
        case 38: 
          localdod.HCJ = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(153013);
          return 0;
        case 39: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dob();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dob)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdod.HCK = ((dob)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(153013);
          return 0;
        case 40: 
          localdod.HCL = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(153013);
          return 0;
        case 41: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dod();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dod)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdod.HCM = ((dod)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(153013);
          return 0;
        case 42: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new aag();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((aag)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdod.DBj.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(153013);
          return 0;
        case 43: 
          localdod.HCN = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(153013);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new dnw();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((dnw)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localdod.HCO = ((dnw)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(153013);
        return 0;
      }
      AppMethodBeat.o(153013);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dod
 * JD-Core Version:    0.7.0.1
 */