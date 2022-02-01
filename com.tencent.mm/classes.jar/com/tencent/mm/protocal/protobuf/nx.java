package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;
import java.util.LinkedList;

public final class nx
  extends erp
{
  public String IdD;
  public nq ORh;
  public int YLL;
  public b YPG;
  public long YPK;
  public GoodsObject YPN;
  public long YQc;
  public String YQd;
  public String YQe;
  public nz YQg;
  public String YQh;
  public String YQi;
  public int YQj;
  public int YQk;
  public LinkedList<nn> YQl;
  public int mode;
  public int type;
  
  public nx()
  {
    AppMethodBeat.i(258501);
    this.YQl = new LinkedList();
    AppMethodBeat.o(258501);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(258508);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.qD(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.YPG != null) {
        paramVarArgs.d(2, this.YPG);
      }
      paramVarArgs.bS(11, this.type);
      paramVarArgs.bS(12, this.mode);
      paramVarArgs.bv(18, this.YPK);
      if (this.YPN != null)
      {
        paramVarArgs.qD(21, this.YPN.computeSize());
        this.YPN.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(22, this.YLL);
      if (this.YQg != null)
      {
        paramVarArgs.qD(23, this.YQg.computeSize());
        this.YQg.writeFields(paramVarArgs);
      }
      if (this.ORh != null)
      {
        paramVarArgs.qD(26, this.ORh.computeSize());
        this.ORh.writeFields(paramVarArgs);
      }
      paramVarArgs.bv(27, this.YQc);
      if (this.YQd != null) {
        paramVarArgs.g(28, this.YQd);
      }
      if (this.YQe != null) {
        paramVarArgs.g(29, this.YQe);
      }
      if (this.IdD != null) {
        paramVarArgs.g(30, this.IdD);
      }
      if (this.YQh != null) {
        paramVarArgs.g(31, this.YQh);
      }
      if (this.YQi != null) {
        paramVarArgs.g(32, this.YQi);
      }
      paramVarArgs.bS(33, this.YQj);
      paramVarArgs.bS(34, this.YQk);
      paramVarArgs.e(35, 8, this.YQl);
      AppMethodBeat.o(258508);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label1568;
      }
    }
    label1568:
    for (paramInt = i.a.a.a.qC(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.YPG != null) {
        i = paramInt + i.a.a.b.b.a.c(2, this.YPG);
      }
      i = i + i.a.a.b.b.a.cJ(11, this.type) + i.a.a.b.b.a.cJ(12, this.mode) + i.a.a.b.b.a.q(18, this.YPK);
      paramInt = i;
      if (this.YPN != null) {
        paramInt = i + i.a.a.a.qC(21, this.YPN.computeSize());
      }
      i = paramInt + i.a.a.b.b.a.cJ(22, this.YLL);
      paramInt = i;
      if (this.YQg != null) {
        paramInt = i + i.a.a.a.qC(23, this.YQg.computeSize());
      }
      i = paramInt;
      if (this.ORh != null) {
        i = paramInt + i.a.a.a.qC(26, this.ORh.computeSize());
      }
      i += i.a.a.b.b.a.q(27, this.YQc);
      paramInt = i;
      if (this.YQd != null) {
        paramInt = i + i.a.a.b.b.a.h(28, this.YQd);
      }
      i = paramInt;
      if (this.YQe != null) {
        i = paramInt + i.a.a.b.b.a.h(29, this.YQe);
      }
      paramInt = i;
      if (this.IdD != null) {
        paramInt = i + i.a.a.b.b.a.h(30, this.IdD);
      }
      i = paramInt;
      if (this.YQh != null) {
        i = paramInt + i.a.a.b.b.a.h(31, this.YQh);
      }
      paramInt = i;
      if (this.YQi != null) {
        paramInt = i + i.a.a.b.b.a.h(32, this.YQi);
      }
      i = i.a.a.b.b.a.cJ(33, this.YQj);
      int j = i.a.a.b.b.a.cJ(34, this.YQk);
      int k = i.a.a.a.c(35, 8, this.YQl);
      AppMethodBeat.o(258508);
      return paramInt + i + j + k;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.YQl.clear();
        paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = erp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = erp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(258508);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        nx localnx = (nx)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        case 3: 
        case 4: 
        case 5: 
        case 6: 
        case 7: 
        case 8: 
        case 9: 
        case 10: 
        case 13: 
        case 14: 
        case 15: 
        case 16: 
        case 17: 
        case 19: 
        case 20: 
        case 24: 
        case 25: 
        default: 
          AppMethodBeat.o(258508);
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
            localnx.BaseRequest = ((kc)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(258508);
          return 0;
        case 2: 
          localnx.YPG = ((i.a.a.a.a)localObject1).ajGk.kFX();
          AppMethodBeat.o(258508);
          return 0;
        case 11: 
          localnx.type = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(258508);
          return 0;
        case 12: 
          localnx.mode = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(258508);
          return 0;
        case 18: 
          localnx.YPK = ((i.a.a.a.a)localObject1).ajGk.aaw();
          AppMethodBeat.o(258508);
          return 0;
        case 21: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new GoodsObject();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((GoodsObject)localObject2).parseFrom((byte[])localObject1);
            }
            localnx.YPN = ((GoodsObject)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(258508);
          return 0;
        case 22: 
          localnx.YLL = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(258508);
          return 0;
        case 23: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new nz();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((nz)localObject2).parseFrom((byte[])localObject1);
            }
            localnx.YQg = ((nz)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(258508);
          return 0;
        case 26: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new nq();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((nq)localObject2).parseFrom((byte[])localObject1);
            }
            localnx.ORh = ((nq)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(258508);
          return 0;
        case 27: 
          localnx.YQc = ((i.a.a.a.a)localObject1).ajGk.aaw();
          AppMethodBeat.o(258508);
          return 0;
        case 28: 
          localnx.YQd = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(258508);
          return 0;
        case 29: 
          localnx.YQe = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(258508);
          return 0;
        case 30: 
          localnx.IdD = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(258508);
          return 0;
        case 31: 
          localnx.YQh = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(258508);
          return 0;
        case 32: 
          localnx.YQi = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(258508);
          return 0;
        case 33: 
          localnx.YQj = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(258508);
          return 0;
        case 34: 
          localnx.YQk = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(258508);
          return 0;
        }
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new nn();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((nn)localObject2).parseFrom((byte[])localObject1);
          }
          localnx.YQl.add(localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(258508);
        return 0;
      }
      AppMethodBeat.o(258508);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.nx
 * JD-Core Version:    0.7.0.1
 */