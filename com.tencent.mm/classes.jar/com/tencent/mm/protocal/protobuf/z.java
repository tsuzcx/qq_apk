package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;
import java.util.LinkedList;

public final class z
  extends esc
{
  public String YAg;
  public String YAj;
  public long YAk;
  public int YAl;
  public long YAm;
  public int YAn;
  public int YAo;
  public int YAp;
  public int YAq;
  public long YAr;
  public long YAs;
  public long YAt;
  public int YAu;
  public String YAv;
  public int YAw;
  public long YAx;
  public String YAy;
  public LinkedList<ad> YAz;
  public String YzL;
  public LinkedList<x> YzQ;
  public String YzT;
  public String YzU;
  public a YzY;
  public int hAV;
  public dus ign;
  public int role;
  public int state;
  public String title;
  public int type;
  public String wYI;
  
  public z()
  {
    AppMethodBeat.i(91334);
    this.hAV = 268513600;
    this.wYI = "请求不成功，请稍候再试";
    this.YzQ = new LinkedList();
    this.YAz = new LinkedList();
    AppMethodBeat.o(91334);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91335);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(91335);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.qD(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(2, this.hAV);
      if (this.wYI != null) {
        paramVarArgs.g(3, this.wYI);
      }
      if (this.YzL != null) {
        paramVarArgs.g(4, this.YzL);
      }
      if (this.title != null) {
        paramVarArgs.g(5, this.title);
      }
      paramVarArgs.bS(6, this.type);
      if (this.YAj != null) {
        paramVarArgs.g(7, this.YAj);
      }
      paramVarArgs.bv(8, this.YAk);
      paramVarArgs.bS(9, this.YAl);
      paramVarArgs.bv(10, this.YAm);
      paramVarArgs.bS(11, this.YAn);
      paramVarArgs.bS(12, this.state);
      paramVarArgs.bS(13, this.YAo);
      paramVarArgs.bS(14, this.YAp);
      paramVarArgs.bS(15, this.role);
      paramVarArgs.bS(16, this.YAq);
      paramVarArgs.bv(17, this.YAr);
      paramVarArgs.bv(18, this.YAs);
      paramVarArgs.bv(19, this.YAt);
      paramVarArgs.bS(20, this.YAu);
      if (this.YAg != null) {
        paramVarArgs.g(21, this.YAg);
      }
      paramVarArgs.e(22, 8, this.YzQ);
      if (this.YAv != null) {
        paramVarArgs.g(23, this.YAv);
      }
      paramVarArgs.bS(24, this.YAw);
      paramVarArgs.bv(25, this.YAx);
      if (this.YzT != null) {
        paramVarArgs.g(26, this.YzT);
      }
      if (this.YzU != null) {
        paramVarArgs.g(27, this.YzU);
      }
      if (this.YzY != null)
      {
        paramVarArgs.qD(28, this.YzY.computeSize());
        this.YzY.writeFields(paramVarArgs);
      }
      if (this.YAy != null) {
        paramVarArgs.g(29, this.YAy);
      }
      paramVarArgs.e(30, 8, this.YAz);
      if (this.ign != null)
      {
        paramVarArgs.qD(31, this.ign.computeSize());
        this.ign.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(91335);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label2148;
      }
    }
    label2148:
    for (paramInt = i.a.a.a.qC(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + i.a.a.b.b.a.cJ(2, this.hAV);
      paramInt = i;
      if (this.wYI != null) {
        paramInt = i + i.a.a.b.b.a.h(3, this.wYI);
      }
      i = paramInt;
      if (this.YzL != null) {
        i = paramInt + i.a.a.b.b.a.h(4, this.YzL);
      }
      paramInt = i;
      if (this.title != null) {
        paramInt = i + i.a.a.b.b.a.h(5, this.title);
      }
      i = paramInt + i.a.a.b.b.a.cJ(6, this.type);
      paramInt = i;
      if (this.YAj != null) {
        paramInt = i + i.a.a.b.b.a.h(7, this.YAj);
      }
      i = paramInt + i.a.a.b.b.a.q(8, this.YAk) + i.a.a.b.b.a.cJ(9, this.YAl) + i.a.a.b.b.a.q(10, this.YAm) + i.a.a.b.b.a.cJ(11, this.YAn) + i.a.a.b.b.a.cJ(12, this.state) + i.a.a.b.b.a.cJ(13, this.YAo) + i.a.a.b.b.a.cJ(14, this.YAp) + i.a.a.b.b.a.cJ(15, this.role) + i.a.a.b.b.a.cJ(16, this.YAq) + i.a.a.b.b.a.q(17, this.YAr) + i.a.a.b.b.a.q(18, this.YAs) + i.a.a.b.b.a.q(19, this.YAt) + i.a.a.b.b.a.cJ(20, this.YAu);
      paramInt = i;
      if (this.YAg != null) {
        paramInt = i + i.a.a.b.b.a.h(21, this.YAg);
      }
      i = paramInt + i.a.a.a.c(22, 8, this.YzQ);
      paramInt = i;
      if (this.YAv != null) {
        paramInt = i + i.a.a.b.b.a.h(23, this.YAv);
      }
      i = paramInt + i.a.a.b.b.a.cJ(24, this.YAw) + i.a.a.b.b.a.q(25, this.YAx);
      paramInt = i;
      if (this.YzT != null) {
        paramInt = i + i.a.a.b.b.a.h(26, this.YzT);
      }
      i = paramInt;
      if (this.YzU != null) {
        i = paramInt + i.a.a.b.b.a.h(27, this.YzU);
      }
      paramInt = i;
      if (this.YzY != null) {
        paramInt = i + i.a.a.a.qC(28, this.YzY.computeSize());
      }
      i = paramInt;
      if (this.YAy != null) {
        i = paramInt + i.a.a.b.b.a.h(29, this.YAy);
      }
      i += i.a.a.a.c(30, 8, this.YAz);
      paramInt = i;
      if (this.ign != null) {
        paramInt = i + i.a.a.a.qC(31, this.ign.computeSize());
      }
      AppMethodBeat.o(91335);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.YzQ.clear();
        this.YAz.clear();
        paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = esc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = esc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(91335);
          throw paramVarArgs;
        }
        AppMethodBeat.o(91335);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        z localz = (z)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91335);
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
            localz.BaseResponse = ((kd)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(91335);
          return 0;
        case 2: 
          localz.hAV = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(91335);
          return 0;
        case 3: 
          localz.wYI = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(91335);
          return 0;
        case 4: 
          localz.YzL = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(91335);
          return 0;
        case 5: 
          localz.title = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(91335);
          return 0;
        case 6: 
          localz.type = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(91335);
          return 0;
        case 7: 
          localz.YAj = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(91335);
          return 0;
        case 8: 
          localz.YAk = ((i.a.a.a.a)localObject1).ajGk.aaw();
          AppMethodBeat.o(91335);
          return 0;
        case 9: 
          localz.YAl = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(91335);
          return 0;
        case 10: 
          localz.YAm = ((i.a.a.a.a)localObject1).ajGk.aaw();
          AppMethodBeat.o(91335);
          return 0;
        case 11: 
          localz.YAn = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(91335);
          return 0;
        case 12: 
          localz.state = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(91335);
          return 0;
        case 13: 
          localz.YAo = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(91335);
          return 0;
        case 14: 
          localz.YAp = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(91335);
          return 0;
        case 15: 
          localz.role = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(91335);
          return 0;
        case 16: 
          localz.YAq = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(91335);
          return 0;
        case 17: 
          localz.YAr = ((i.a.a.a.a)localObject1).ajGk.aaw();
          AppMethodBeat.o(91335);
          return 0;
        case 18: 
          localz.YAs = ((i.a.a.a.a)localObject1).ajGk.aaw();
          AppMethodBeat.o(91335);
          return 0;
        case 19: 
          localz.YAt = ((i.a.a.a.a)localObject1).ajGk.aaw();
          AppMethodBeat.o(91335);
          return 0;
        case 20: 
          localz.YAu = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(91335);
          return 0;
        case 21: 
          localz.YAg = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(91335);
          return 0;
        case 22: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new x();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((x)localObject2).parseFrom((byte[])localObject1);
            }
            localz.YzQ.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(91335);
          return 0;
        case 23: 
          localz.YAv = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(91335);
          return 0;
        case 24: 
          localz.YAw = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(91335);
          return 0;
        case 25: 
          localz.YAx = ((i.a.a.a.a)localObject1).ajGk.aaw();
          AppMethodBeat.o(91335);
          return 0;
        case 26: 
          localz.YzT = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(91335);
          return 0;
        case 27: 
          localz.YzU = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(91335);
          return 0;
        case 28: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new a();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((a)localObject2).parseFrom((byte[])localObject1);
            }
            localz.YzY = ((a)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(91335);
          return 0;
        case 29: 
          localz.YAy = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(91335);
          return 0;
        case 30: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new ad();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((ad)localObject2).parseFrom((byte[])localObject1);
            }
            localz.YAz.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(91335);
          return 0;
        }
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new dus();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((dus)localObject2).parseFrom((byte[])localObject1);
          }
          localz.ign = ((dus)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(91335);
        return 0;
      }
      AppMethodBeat.o(91335);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.z
 * JD-Core Version:    0.7.0.1
 */