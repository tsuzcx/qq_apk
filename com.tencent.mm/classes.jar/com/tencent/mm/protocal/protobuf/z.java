package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class z
  extends dyy
{
  public String RDD;
  public String RDG;
  public long RDH;
  public int RDI;
  public long RDJ;
  public int RDK;
  public int RDL;
  public int RDM;
  public int RDN;
  public long RDO;
  public long RDP;
  public long RDQ;
  public int RDR;
  public String RDS;
  public int RDT;
  public long RDU;
  public String RDV;
  public LinkedList<ad> RDW;
  public String RDi;
  public LinkedList<x> RDn;
  public String RDq;
  public String RDr;
  public a RDv;
  public int fwx;
  public int role;
  public int state;
  public String tVo;
  public String title;
  public int type;
  
  public z()
  {
    AppMethodBeat.i(91334);
    this.fwx = 268513600;
    this.tVo = "请求不成功，请稍候再试";
    this.RDn = new LinkedList();
    this.RDW = new LinkedList();
    AppMethodBeat.o(91334);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91335);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(91335);
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
      if (this.RDi != null) {
        paramVarArgs.f(4, this.RDi);
      }
      if (this.title != null) {
        paramVarArgs.f(5, this.title);
      }
      paramVarArgs.aY(6, this.type);
      if (this.RDG != null) {
        paramVarArgs.f(7, this.RDG);
      }
      paramVarArgs.bm(8, this.RDH);
      paramVarArgs.aY(9, this.RDI);
      paramVarArgs.bm(10, this.RDJ);
      paramVarArgs.aY(11, this.RDK);
      paramVarArgs.aY(12, this.state);
      paramVarArgs.aY(13, this.RDL);
      paramVarArgs.aY(14, this.RDM);
      paramVarArgs.aY(15, this.role);
      paramVarArgs.aY(16, this.RDN);
      paramVarArgs.bm(17, this.RDO);
      paramVarArgs.bm(18, this.RDP);
      paramVarArgs.bm(19, this.RDQ);
      paramVarArgs.aY(20, this.RDR);
      if (this.RDD != null) {
        paramVarArgs.f(21, this.RDD);
      }
      paramVarArgs.e(22, 8, this.RDn);
      if (this.RDS != null) {
        paramVarArgs.f(23, this.RDS);
      }
      paramVarArgs.aY(24, this.RDT);
      paramVarArgs.bm(25, this.RDU);
      if (this.RDq != null) {
        paramVarArgs.f(26, this.RDq);
      }
      if (this.RDr != null) {
        paramVarArgs.f(27, this.RDr);
      }
      if (this.RDv != null)
      {
        paramVarArgs.oE(28, this.RDv.computeSize());
        this.RDv.writeFields(paramVarArgs);
      }
      if (this.RDV != null) {
        paramVarArgs.f(29, this.RDV);
      }
      paramVarArgs.e(30, 8, this.RDW);
      AppMethodBeat.o(91335);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label2018;
      }
    }
    label2018:
    for (paramInt = g.a.a.a.oD(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bM(2, this.fwx);
      paramInt = i;
      if (this.tVo != null) {
        paramInt = i + g.a.a.b.b.a.g(3, this.tVo);
      }
      i = paramInt;
      if (this.RDi != null) {
        i = paramInt + g.a.a.b.b.a.g(4, this.RDi);
      }
      paramInt = i;
      if (this.title != null) {
        paramInt = i + g.a.a.b.b.a.g(5, this.title);
      }
      i = paramInt + g.a.a.b.b.a.bM(6, this.type);
      paramInt = i;
      if (this.RDG != null) {
        paramInt = i + g.a.a.b.b.a.g(7, this.RDG);
      }
      i = paramInt + g.a.a.b.b.a.p(8, this.RDH) + g.a.a.b.b.a.bM(9, this.RDI) + g.a.a.b.b.a.p(10, this.RDJ) + g.a.a.b.b.a.bM(11, this.RDK) + g.a.a.b.b.a.bM(12, this.state) + g.a.a.b.b.a.bM(13, this.RDL) + g.a.a.b.b.a.bM(14, this.RDM) + g.a.a.b.b.a.bM(15, this.role) + g.a.a.b.b.a.bM(16, this.RDN) + g.a.a.b.b.a.p(17, this.RDO) + g.a.a.b.b.a.p(18, this.RDP) + g.a.a.b.b.a.p(19, this.RDQ) + g.a.a.b.b.a.bM(20, this.RDR);
      paramInt = i;
      if (this.RDD != null) {
        paramInt = i + g.a.a.b.b.a.g(21, this.RDD);
      }
      i = paramInt + g.a.a.a.c(22, 8, this.RDn);
      paramInt = i;
      if (this.RDS != null) {
        paramInt = i + g.a.a.b.b.a.g(23, this.RDS);
      }
      i = paramInt + g.a.a.b.b.a.bM(24, this.RDT) + g.a.a.b.b.a.p(25, this.RDU);
      paramInt = i;
      if (this.RDq != null) {
        paramInt = i + g.a.a.b.b.a.g(26, this.RDq);
      }
      i = paramInt;
      if (this.RDr != null) {
        i = paramInt + g.a.a.b.b.a.g(27, this.RDr);
      }
      paramInt = i;
      if (this.RDv != null) {
        paramInt = i + g.a.a.a.oD(28, this.RDv.computeSize());
      }
      i = paramInt;
      if (this.RDV != null) {
        i = paramInt + g.a.a.b.b.a.g(29, this.RDV);
      }
      paramInt = g.a.a.a.c(30, 8, this.RDW);
      AppMethodBeat.o(91335);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.RDn.clear();
        this.RDW.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = dyy.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyy.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
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
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        z localz = (z)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91335);
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
            localz.BaseResponse = ((jh)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(91335);
          return 0;
        case 2: 
          localz.fwx = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(91335);
          return 0;
        case 3: 
          localz.tVo = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(91335);
          return 0;
        case 4: 
          localz.RDi = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(91335);
          return 0;
        case 5: 
          localz.title = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(91335);
          return 0;
        case 6: 
          localz.type = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(91335);
          return 0;
        case 7: 
          localz.RDG = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(91335);
          return 0;
        case 8: 
          localz.RDH = ((g.a.a.a.a)localObject1).abFh.AN();
          AppMethodBeat.o(91335);
          return 0;
        case 9: 
          localz.RDI = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(91335);
          return 0;
        case 10: 
          localz.RDJ = ((g.a.a.a.a)localObject1).abFh.AN();
          AppMethodBeat.o(91335);
          return 0;
        case 11: 
          localz.RDK = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(91335);
          return 0;
        case 12: 
          localz.state = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(91335);
          return 0;
        case 13: 
          localz.RDL = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(91335);
          return 0;
        case 14: 
          localz.RDM = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(91335);
          return 0;
        case 15: 
          localz.role = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(91335);
          return 0;
        case 16: 
          localz.RDN = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(91335);
          return 0;
        case 17: 
          localz.RDO = ((g.a.a.a.a)localObject1).abFh.AN();
          AppMethodBeat.o(91335);
          return 0;
        case 18: 
          localz.RDP = ((g.a.a.a.a)localObject1).abFh.AN();
          AppMethodBeat.o(91335);
          return 0;
        case 19: 
          localz.RDQ = ((g.a.a.a.a)localObject1).abFh.AN();
          AppMethodBeat.o(91335);
          return 0;
        case 20: 
          localz.RDR = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(91335);
          return 0;
        case 21: 
          localz.RDD = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(91335);
          return 0;
        case 22: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new x();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((x)localObject2).parseFrom((byte[])localObject1);
            }
            localz.RDn.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(91335);
          return 0;
        case 23: 
          localz.RDS = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(91335);
          return 0;
        case 24: 
          localz.RDT = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(91335);
          return 0;
        case 25: 
          localz.RDU = ((g.a.a.a.a)localObject1).abFh.AN();
          AppMethodBeat.o(91335);
          return 0;
        case 26: 
          localz.RDq = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(91335);
          return 0;
        case 27: 
          localz.RDr = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(91335);
          return 0;
        case 28: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new a();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((a)localObject2).parseFrom((byte[])localObject1);
            }
            localz.RDv = ((a)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(91335);
          return 0;
        case 29: 
          localz.RDV = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(91335);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new ad();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((ad)localObject2).parseFrom((byte[])localObject1);
          }
          localz.RDW.add(localObject2);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.z
 * JD-Core Version:    0.7.0.1
 */