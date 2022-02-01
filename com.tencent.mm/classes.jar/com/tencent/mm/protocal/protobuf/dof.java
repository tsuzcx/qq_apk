package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class dof
  extends com.tencent.mm.bw.a
{
  public int DNg;
  public bpt DQl;
  public String DXY;
  public crp DYL;
  public int EKX;
  public String Eof;
  public String Eog;
  public String FVI;
  public String FVJ;
  public int FVK;
  public int FVL;
  public int FVM;
  public String FVN;
  public int FVO;
  public crm FVP;
  public int FVQ;
  public String FVR;
  public String FVS;
  public String FVT;
  public String FVU;
  public String FVV;
  public cdk FVW;
  public String FVX;
  public int FVY;
  public long FVZ;
  public String FWa;
  public deq FWb;
  public long FWc;
  public int FWd;
  public dbt Few;
  public String FkL;
  public String FkM;
  public int Fws;
  public String eyk;
  public String iKd;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(134260);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.Few == null)
      {
        paramVarArgs = new b("Not all required fields were included: SnsUserInfo");
        AppMethodBeat.o(134260);
        throw paramVarArgs;
      }
      if (this.Few != null)
      {
        paramVarArgs.ln(1, this.Few.computeSize());
        this.Few.writeFields(paramVarArgs);
      }
      if (this.iKd != null) {
        paramVarArgs.d(2, this.iKd);
      }
      if (this.FVI != null) {
        paramVarArgs.d(3, this.FVI);
      }
      if (this.FVJ != null) {
        paramVarArgs.d(4, this.FVJ);
      }
      paramVarArgs.aR(5, this.FVK);
      paramVarArgs.aR(6, this.FVL);
      paramVarArgs.aR(7, this.FVM);
      if (this.FVN != null) {
        paramVarArgs.d(8, this.FVN);
      }
      if (this.Eof != null) {
        paramVarArgs.d(9, this.Eof);
      }
      if (this.Eog != null) {
        paramVarArgs.d(10, this.Eog);
      }
      paramVarArgs.aR(11, this.FVO);
      if (this.FVP != null)
      {
        paramVarArgs.ln(12, this.FVP.computeSize());
        this.FVP.writeFields(paramVarArgs);
      }
      if (this.DYL != null)
      {
        paramVarArgs.ln(13, this.DYL.computeSize());
        this.DYL.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(14, this.DNg);
      paramVarArgs.aR(15, this.FVQ);
      if (this.DXY != null) {
        paramVarArgs.d(16, this.DXY);
      }
      if (this.FkL != null) {
        paramVarArgs.d(17, this.FkL);
      }
      if (this.FkM != null) {
        paramVarArgs.d(18, this.FkM);
      }
      if (this.FVR != null) {
        paramVarArgs.d(19, this.FVR);
      }
      if (this.FVS != null) {
        paramVarArgs.d(20, this.FVS);
      }
      if (this.FVT != null) {
        paramVarArgs.d(21, this.FVT);
      }
      if (this.FVU != null) {
        paramVarArgs.d(22, this.FVU);
      }
      if (this.DQl != null)
      {
        paramVarArgs.ln(23, this.DQl.computeSize());
        this.DQl.writeFields(paramVarArgs);
      }
      if (this.FVV != null) {
        paramVarArgs.d(24, this.FVV);
      }
      if (this.FVW != null)
      {
        paramVarArgs.ln(25, this.FVW.computeSize());
        this.FVW.writeFields(paramVarArgs);
      }
      if (this.FVX != null) {
        paramVarArgs.d(26, this.FVX);
      }
      paramVarArgs.aR(27, this.FVY);
      if (this.eyk != null) {
        paramVarArgs.d(28, this.eyk);
      }
      paramVarArgs.aR(29, this.EKX);
      paramVarArgs.aO(30, this.FVZ);
      if (this.FWa != null) {
        paramVarArgs.d(31, this.FWa);
      }
      paramVarArgs.aR(32, this.Fws);
      if (this.FWb != null)
      {
        paramVarArgs.ln(33, this.FWb.computeSize());
        this.FWb.writeFields(paramVarArgs);
      }
      paramVarArgs.aO(34, this.FWc);
      paramVarArgs.aR(35, this.FWd);
      AppMethodBeat.o(134260);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Few == null) {
        break label2730;
      }
    }
    label2730:
    for (int i = f.a.a.a.lm(1, this.Few.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.iKd != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.iKd);
      }
      i = paramInt;
      if (this.FVI != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.FVI);
      }
      paramInt = i;
      if (this.FVJ != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.FVJ);
      }
      i = paramInt + f.a.a.b.b.a.bx(5, this.FVK) + f.a.a.b.b.a.bx(6, this.FVL) + f.a.a.b.b.a.bx(7, this.FVM);
      paramInt = i;
      if (this.FVN != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.FVN);
      }
      i = paramInt;
      if (this.Eof != null) {
        i = paramInt + f.a.a.b.b.a.e(9, this.Eof);
      }
      paramInt = i;
      if (this.Eog != null) {
        paramInt = i + f.a.a.b.b.a.e(10, this.Eog);
      }
      i = paramInt + f.a.a.b.b.a.bx(11, this.FVO);
      paramInt = i;
      if (this.FVP != null) {
        paramInt = i + f.a.a.a.lm(12, this.FVP.computeSize());
      }
      i = paramInt;
      if (this.DYL != null) {
        i = paramInt + f.a.a.a.lm(13, this.DYL.computeSize());
      }
      i = i + f.a.a.b.b.a.bx(14, this.DNg) + f.a.a.b.b.a.bx(15, this.FVQ);
      paramInt = i;
      if (this.DXY != null) {
        paramInt = i + f.a.a.b.b.a.e(16, this.DXY);
      }
      i = paramInt;
      if (this.FkL != null) {
        i = paramInt + f.a.a.b.b.a.e(17, this.FkL);
      }
      paramInt = i;
      if (this.FkM != null) {
        paramInt = i + f.a.a.b.b.a.e(18, this.FkM);
      }
      i = paramInt;
      if (this.FVR != null) {
        i = paramInt + f.a.a.b.b.a.e(19, this.FVR);
      }
      paramInt = i;
      if (this.FVS != null) {
        paramInt = i + f.a.a.b.b.a.e(20, this.FVS);
      }
      i = paramInt;
      if (this.FVT != null) {
        i = paramInt + f.a.a.b.b.a.e(21, this.FVT);
      }
      paramInt = i;
      if (this.FVU != null) {
        paramInt = i + f.a.a.b.b.a.e(22, this.FVU);
      }
      i = paramInt;
      if (this.DQl != null) {
        i = paramInt + f.a.a.a.lm(23, this.DQl.computeSize());
      }
      paramInt = i;
      if (this.FVV != null) {
        paramInt = i + f.a.a.b.b.a.e(24, this.FVV);
      }
      i = paramInt;
      if (this.FVW != null) {
        i = paramInt + f.a.a.a.lm(25, this.FVW.computeSize());
      }
      paramInt = i;
      if (this.FVX != null) {
        paramInt = i + f.a.a.b.b.a.e(26, this.FVX);
      }
      i = paramInt + f.a.a.b.b.a.bx(27, this.FVY);
      paramInt = i;
      if (this.eyk != null) {
        paramInt = i + f.a.a.b.b.a.e(28, this.eyk);
      }
      i = paramInt + f.a.a.b.b.a.bx(29, this.EKX) + f.a.a.b.b.a.p(30, this.FVZ);
      paramInt = i;
      if (this.FWa != null) {
        paramInt = i + f.a.a.b.b.a.e(31, this.FWa);
      }
      i = paramInt + f.a.a.b.b.a.bx(32, this.Fws);
      paramInt = i;
      if (this.FWb != null) {
        paramInt = i + f.a.a.a.lm(33, this.FWb.computeSize());
      }
      i = f.a.a.b.b.a.p(34, this.FWc);
      int j = f.a.a.b.b.a.bx(35, this.FWd);
      AppMethodBeat.o(134260);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        if (this.Few == null)
        {
          paramVarArgs = new b("Not all required fields were included: SnsUserInfo");
          AppMethodBeat.o(134260);
          throw paramVarArgs;
        }
        AppMethodBeat.o(134260);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        dof localdof = (dof)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(134260);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dbt();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dbt)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdof.Few = ((dbt)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(134260);
          return 0;
        case 2: 
          localdof.iKd = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(134260);
          return 0;
        case 3: 
          localdof.FVI = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(134260);
          return 0;
        case 4: 
          localdof.FVJ = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(134260);
          return 0;
        case 5: 
          localdof.FVK = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(134260);
          return 0;
        case 6: 
          localdof.FVL = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(134260);
          return 0;
        case 7: 
          localdof.FVM = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(134260);
          return 0;
        case 8: 
          localdof.FVN = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(134260);
          return 0;
        case 9: 
          localdof.Eof = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(134260);
          return 0;
        case 10: 
          localdof.Eog = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(134260);
          return 0;
        case 11: 
          localdof.FVO = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(134260);
          return 0;
        case 12: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new crm();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((crm)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdof.FVP = ((crm)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(134260);
          return 0;
        case 13: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new crp();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((crp)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdof.DYL = ((crp)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(134260);
          return 0;
        case 14: 
          localdof.DNg = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(134260);
          return 0;
        case 15: 
          localdof.FVQ = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(134260);
          return 0;
        case 16: 
          localdof.DXY = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(134260);
          return 0;
        case 17: 
          localdof.FkL = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(134260);
          return 0;
        case 18: 
          localdof.FkM = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(134260);
          return 0;
        case 19: 
          localdof.FVR = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(134260);
          return 0;
        case 20: 
          localdof.FVS = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(134260);
          return 0;
        case 21: 
          localdof.FVT = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(134260);
          return 0;
        case 22: 
          localdof.FVU = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(134260);
          return 0;
        case 23: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bpt();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bpt)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdof.DQl = ((bpt)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(134260);
          return 0;
        case 24: 
          localdof.FVV = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(134260);
          return 0;
        case 25: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cdk();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cdk)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdof.FVW = ((cdk)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(134260);
          return 0;
        case 26: 
          localdof.FVX = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(134260);
          return 0;
        case 27: 
          localdof.FVY = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(134260);
          return 0;
        case 28: 
          localdof.eyk = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(134260);
          return 0;
        case 29: 
          localdof.EKX = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(134260);
          return 0;
        case 30: 
          localdof.FVZ = ((f.a.a.a.a)localObject1).LVo.xG();
          AppMethodBeat.o(134260);
          return 0;
        case 31: 
          localdof.FWa = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(134260);
          return 0;
        case 32: 
          localdof.Fws = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(134260);
          return 0;
        case 33: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new deq();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((deq)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdof.FWb = ((deq)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(134260);
          return 0;
        case 34: 
          localdof.FWc = ((f.a.a.a.a)localObject1).LVo.xG();
          AppMethodBeat.o(134260);
          return 0;
        }
        localdof.FWd = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(134260);
        return 0;
      }
      AppMethodBeat.o(134260);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dof
 * JD-Core Version:    0.7.0.1
 */