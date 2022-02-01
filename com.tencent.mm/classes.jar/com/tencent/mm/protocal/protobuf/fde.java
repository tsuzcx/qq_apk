package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class fde
  extends dyy
{
  public int RNw;
  public LinkedList<fdb> RNx;
  public int Svu;
  public long Svv;
  public int UCN;
  public fep UCO;
  public int UCP;
  public int UCQ;
  public int UCR;
  public int UCS;
  public eae UCT;
  public int UCY;
  public LinkedList<fer> UCZ;
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
  
  public fde()
  {
    AppMethodBeat.i(115865);
    this.RNx = new LinkedList();
    this.UCZ = new LinkedList();
    AppMethodBeat.o(115865);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(115866);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(115866);
        throw paramVarArgs;
      }
      if (this.UCO == null)
      {
        paramVarArgs = new b("Not all required fields were included: RelayData");
        AppMethodBeat.o(115866);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.oE(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(2, this.RNw);
      paramVarArgs.e(3, 8, this.RNx);
      paramVarArgs.aY(4, this.Svu);
      paramVarArgs.bm(5, this.Svv);
      paramVarArgs.aY(6, this.UCN);
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
      paramVarArgs.aY(14, this.UDe);
      paramVarArgs.aY(15, this.UDf);
      paramVarArgs.aY(16, this.UCP);
      paramVarArgs.aY(17, this.UDg);
      paramVarArgs.aY(18, this.UDh);
      paramVarArgs.aY(19, this.UCQ);
      paramVarArgs.aY(20, this.UDi);
      paramVarArgs.aY(21, this.UDj);
      paramVarArgs.aY(22, this.UDk);
      paramVarArgs.aY(23, this.UDl);
      paramVarArgs.aY(24, this.UCR);
      paramVarArgs.aY(25, this.UCS);
      paramVarArgs.aY(26, this.UDm);
      paramVarArgs.aY(27, this.UDn);
      if (this.UCT != null)
      {
        paramVarArgs.oE(28, this.UCT.computeSize());
        this.UCT.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(115866);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1896;
      }
    }
    label1896:
    for (paramInt = g.a.a.a.oD(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bM(2, this.RNw) + g.a.a.a.c(3, 8, this.RNx) + g.a.a.b.b.a.bM(4, this.Svu) + g.a.a.b.b.a.p(5, this.Svv) + g.a.a.b.b.a.bM(6, this.UCN);
      paramInt = i;
      if (this.UCO != null) {
        paramInt = i + g.a.a.a.oD(7, this.UCO.computeSize());
      }
      i = paramInt + g.a.a.b.b.a.bM(8, this.UCY) + g.a.a.a.c(9, 8, this.UCZ) + g.a.a.b.b.a.bM(10, this.UDa) + g.a.a.b.b.a.bM(11, this.UDb) + g.a.a.b.b.a.bM(12, this.UDc) + g.a.a.b.b.a.bM(13, this.UDd) + g.a.a.b.b.a.bM(14, this.UDe) + g.a.a.b.b.a.bM(15, this.UDf) + g.a.a.b.b.a.bM(16, this.UCP) + g.a.a.b.b.a.bM(17, this.UDg) + g.a.a.b.b.a.bM(18, this.UDh) + g.a.a.b.b.a.bM(19, this.UCQ) + g.a.a.b.b.a.bM(20, this.UDi) + g.a.a.b.b.a.bM(21, this.UDj) + g.a.a.b.b.a.bM(22, this.UDk) + g.a.a.b.b.a.bM(23, this.UDl) + g.a.a.b.b.a.bM(24, this.UCR) + g.a.a.b.b.a.bM(25, this.UCS) + g.a.a.b.b.a.bM(26, this.UDm) + g.a.a.b.b.a.bM(27, this.UDn);
      paramInt = i;
      if (this.UCT != null) {
        paramInt = i + g.a.a.a.oD(28, this.UCT.computeSize());
      }
      AppMethodBeat.o(115866);
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
          AppMethodBeat.o(115866);
          throw paramVarArgs;
        }
        if (this.UCO == null)
        {
          paramVarArgs = new b("Not all required fields were included: RelayData");
          AppMethodBeat.o(115866);
          throw paramVarArgs;
        }
        AppMethodBeat.o(115866);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        fde localfde = (fde)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(115866);
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
            localfde.BaseResponse = ((jh)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(115866);
          return 0;
        case 2: 
          localfde.RNw = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(115866);
          return 0;
        case 3: 
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
            localfde.RNx.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(115866);
          return 0;
        case 4: 
          localfde.Svu = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(115866);
          return 0;
        case 5: 
          localfde.Svv = ((g.a.a.a.a)localObject1).abFh.AN();
          AppMethodBeat.o(115866);
          return 0;
        case 6: 
          localfde.UCN = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(115866);
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
            localfde.UCO = ((fep)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(115866);
          return 0;
        case 8: 
          localfde.UCY = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(115866);
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
            localfde.UCZ.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(115866);
          return 0;
        case 10: 
          localfde.UDa = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(115866);
          return 0;
        case 11: 
          localfde.UDb = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(115866);
          return 0;
        case 12: 
          localfde.UDc = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(115866);
          return 0;
        case 13: 
          localfde.UDd = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(115866);
          return 0;
        case 14: 
          localfde.UDe = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(115866);
          return 0;
        case 15: 
          localfde.UDf = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(115866);
          return 0;
        case 16: 
          localfde.UCP = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(115866);
          return 0;
        case 17: 
          localfde.UDg = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(115866);
          return 0;
        case 18: 
          localfde.UDh = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(115866);
          return 0;
        case 19: 
          localfde.UCQ = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(115866);
          return 0;
        case 20: 
          localfde.UDi = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(115866);
          return 0;
        case 21: 
          localfde.UDj = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(115866);
          return 0;
        case 22: 
          localfde.UDk = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(115866);
          return 0;
        case 23: 
          localfde.UDl = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(115866);
          return 0;
        case 24: 
          localfde.UCR = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(115866);
          return 0;
        case 25: 
          localfde.UCS = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(115866);
          return 0;
        case 26: 
          localfde.UDm = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(115866);
          return 0;
        case 27: 
          localfde.UDn = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(115866);
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
          localfde.UCT = ((eae)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(115866);
        return 0;
      }
      AppMethodBeat.o(115866);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fde
 * JD-Core Version:    0.7.0.1
 */