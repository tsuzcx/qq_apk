package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class fei
  extends dyy
{
  public int RNw;
  public LinkedList<fdb> RNx;
  public int Svu;
  public long Svv;
  public int TWl;
  public fep UCO;
  public int UCP;
  public int UCQ;
  public int UCR;
  public int UCS;
  public eae UCT;
  public int UCY;
  public LinkedList<fer> UCZ;
  public int UDU;
  public int UDV;
  public int UDW;
  public int UDa;
  public int UDb;
  public int UDc;
  public int UDd;
  public int UDe;
  public int UDf;
  public int UDg;
  public int UDh;
  public int UDi;
  public int UDj;
  public int UDk;
  public int UDl;
  public int UDm;
  public int UDn;
  
  public fei()
  {
    AppMethodBeat.i(115885);
    this.RNx = new LinkedList();
    this.UCZ = new LinkedList();
    AppMethodBeat.o(115885);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(115886);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(115886);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.oE(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(2, this.Svu);
      paramVarArgs.aY(3, this.RNw);
      paramVarArgs.e(4, 8, this.RNx);
      paramVarArgs.bm(5, this.Svv);
      paramVarArgs.aY(6, this.TWl);
      if (this.UCO != null)
      {
        paramVarArgs.oE(7, this.UCO.computeSize());
        this.UCO.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(8, this.UCY);
      paramVarArgs.e(9, 8, this.UCZ);
      paramVarArgs.aY(10, this.UDa);
      paramVarArgs.aY(11, this.UDb);
      paramVarArgs.aY(12, this.UDc);
      paramVarArgs.aY(13, this.UDd);
      paramVarArgs.aY(14, this.UDU);
      paramVarArgs.aY(15, this.UDe);
      paramVarArgs.aY(16, this.UDf);
      paramVarArgs.aY(17, this.UCP);
      paramVarArgs.aY(18, this.UDg);
      paramVarArgs.aY(19, this.UDh);
      paramVarArgs.aY(20, this.UCQ);
      paramVarArgs.aY(21, this.UDi);
      paramVarArgs.aY(22, this.UDj);
      paramVarArgs.aY(23, this.UDk);
      paramVarArgs.aY(24, this.UDV);
      paramVarArgs.aY(25, this.UDl);
      paramVarArgs.aY(26, this.UDW);
      paramVarArgs.aY(27, this.UCR);
      paramVarArgs.aY(28, this.UCS);
      paramVarArgs.aY(29, this.UDm);
      paramVarArgs.aY(30, this.UDn);
      if (this.UCT != null)
      {
        paramVarArgs.oE(31, this.UCT.computeSize());
        this.UCT.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(115886);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1980;
      }
    }
    label1980:
    for (paramInt = g.a.a.a.oD(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bM(2, this.Svu) + g.a.a.b.b.a.bM(3, this.RNw) + g.a.a.a.c(4, 8, this.RNx) + g.a.a.b.b.a.p(5, this.Svv) + g.a.a.b.b.a.bM(6, this.TWl);
      paramInt = i;
      if (this.UCO != null) {
        paramInt = i + g.a.a.a.oD(7, this.UCO.computeSize());
      }
      i = paramInt + g.a.a.b.b.a.bM(8, this.UCY) + g.a.a.a.c(9, 8, this.UCZ) + g.a.a.b.b.a.bM(10, this.UDa) + g.a.a.b.b.a.bM(11, this.UDb) + g.a.a.b.b.a.bM(12, this.UDc) + g.a.a.b.b.a.bM(13, this.UDd) + g.a.a.b.b.a.bM(14, this.UDU) + g.a.a.b.b.a.bM(15, this.UDe) + g.a.a.b.b.a.bM(16, this.UDf) + g.a.a.b.b.a.bM(17, this.UCP) + g.a.a.b.b.a.bM(18, this.UDg) + g.a.a.b.b.a.bM(19, this.UDh) + g.a.a.b.b.a.bM(20, this.UCQ) + g.a.a.b.b.a.bM(21, this.UDi) + g.a.a.b.b.a.bM(22, this.UDj) + g.a.a.b.b.a.bM(23, this.UDk) + g.a.a.b.b.a.bM(24, this.UDV) + g.a.a.b.b.a.bM(25, this.UDl) + g.a.a.b.b.a.bM(26, this.UDW) + g.a.a.b.b.a.bM(27, this.UCR) + g.a.a.b.b.a.bM(28, this.UCS) + g.a.a.b.b.a.bM(29, this.UDm) + g.a.a.b.b.a.bM(30, this.UDn);
      paramInt = i;
      if (this.UCT != null) {
        paramInt = i + g.a.a.a.oD(31, this.UCT.computeSize());
      }
      AppMethodBeat.o(115886);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.RNx.clear();
        this.UCZ.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = dyy.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyy.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(115886);
          throw paramVarArgs;
        }
        AppMethodBeat.o(115886);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        fei localfei = (fei)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(115886);
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
            localfei.BaseResponse = ((jh)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(115886);
          return 0;
        case 2: 
          localfei.Svu = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(115886);
          return 0;
        case 3: 
          localfei.RNw = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(115886);
          return 0;
        case 4: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new fdb();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((fdb)localObject2).parseFrom((byte[])localObject1);
            }
            localfei.RNx.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(115886);
          return 0;
        case 5: 
          localfei.Svv = ((g.a.a.a.a)localObject1).abFh.AN();
          AppMethodBeat.o(115886);
          return 0;
        case 6: 
          localfei.TWl = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(115886);
          return 0;
        case 7: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new fep();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((fep)localObject2).parseFrom((byte[])localObject1);
            }
            localfei.UCO = ((fep)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(115886);
          return 0;
        case 8: 
          localfei.UCY = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(115886);
          return 0;
        case 9: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new fer();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((fer)localObject2).parseFrom((byte[])localObject1);
            }
            localfei.UCZ.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(115886);
          return 0;
        case 10: 
          localfei.UDa = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(115886);
          return 0;
        case 11: 
          localfei.UDb = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(115886);
          return 0;
        case 12: 
          localfei.UDc = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(115886);
          return 0;
        case 13: 
          localfei.UDd = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(115886);
          return 0;
        case 14: 
          localfei.UDU = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(115886);
          return 0;
        case 15: 
          localfei.UDe = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(115886);
          return 0;
        case 16: 
          localfei.UDf = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(115886);
          return 0;
        case 17: 
          localfei.UCP = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(115886);
          return 0;
        case 18: 
          localfei.UDg = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(115886);
          return 0;
        case 19: 
          localfei.UDh = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(115886);
          return 0;
        case 20: 
          localfei.UCQ = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(115886);
          return 0;
        case 21: 
          localfei.UDi = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(115886);
          return 0;
        case 22: 
          localfei.UDj = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(115886);
          return 0;
        case 23: 
          localfei.UDk = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(115886);
          return 0;
        case 24: 
          localfei.UDV = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(115886);
          return 0;
        case 25: 
          localfei.UDl = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(115886);
          return 0;
        case 26: 
          localfei.UDW = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(115886);
          return 0;
        case 27: 
          localfei.UCR = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(115886);
          return 0;
        case 28: 
          localfei.UCS = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(115886);
          return 0;
        case 29: 
          localfei.UDm = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(115886);
          return 0;
        case 30: 
          localfei.UDn = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(115886);
          return 0;
        }
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
          localfei.UCT = ((eae)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(115886);
        return 0;
      }
      AppMethodBeat.o(115886);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fei
 * JD-Core Version:    0.7.0.1
 */