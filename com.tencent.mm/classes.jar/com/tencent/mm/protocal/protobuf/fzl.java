package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class fzl
  extends erp
{
  public int ZkT;
  public long ZvA;
  public int Zvz;
  public int abWO;
  public gbh abWP;
  public gbh abWQ;
  public String abWR;
  public int abWS;
  public long abWT;
  public int abWU;
  public int abWV;
  public LinkedList<dtl> abWW;
  public int abWX;
  public String abnl;
  
  public fzl()
  {
    AppMethodBeat.i(115857);
    this.abWW = new LinkedList();
    AppMethodBeat.o(115857);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(115858);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.qD(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(2, this.Zvz);
      paramVarArgs.bv(3, this.ZvA);
      if (this.abnl != null) {
        paramVarArgs.g(4, this.abnl);
      }
      paramVarArgs.bS(5, this.abWO);
      if (this.abWP != null)
      {
        paramVarArgs.qD(6, this.abWP.computeSize());
        this.abWP.writeFields(paramVarArgs);
      }
      if (this.abWQ != null)
      {
        paramVarArgs.qD(7, this.abWQ.computeSize());
        this.abWQ.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(8, this.ZkT);
      if (this.abWR != null) {
        paramVarArgs.g(9, this.abWR);
      }
      paramVarArgs.bS(10, this.abWS);
      paramVarArgs.bv(11, this.abWT);
      paramVarArgs.bS(12, this.abWU);
      paramVarArgs.bS(13, this.abWV);
      paramVarArgs.e(14, 8, this.abWW);
      paramVarArgs.bS(15, this.abWX);
      AppMethodBeat.o(115858);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label1214;
      }
    }
    label1214:
    for (paramInt = i.a.a.a.qC(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + i.a.a.b.b.a.cJ(2, this.Zvz) + i.a.a.b.b.a.q(3, this.ZvA);
      paramInt = i;
      if (this.abnl != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.abnl);
      }
      i = paramInt + i.a.a.b.b.a.cJ(5, this.abWO);
      paramInt = i;
      if (this.abWP != null) {
        paramInt = i + i.a.a.a.qC(6, this.abWP.computeSize());
      }
      i = paramInt;
      if (this.abWQ != null) {
        i = paramInt + i.a.a.a.qC(7, this.abWQ.computeSize());
      }
      i += i.a.a.b.b.a.cJ(8, this.ZkT);
      paramInt = i;
      if (this.abWR != null) {
        paramInt = i + i.a.a.b.b.a.h(9, this.abWR);
      }
      i = i.a.a.b.b.a.cJ(10, this.abWS);
      int j = i.a.a.b.b.a.q(11, this.abWT);
      int k = i.a.a.b.b.a.cJ(12, this.abWU);
      int m = i.a.a.b.b.a.cJ(13, this.abWV);
      int n = i.a.a.a.c(14, 8, this.abWW);
      int i1 = i.a.a.b.b.a.cJ(15, this.abWX);
      AppMethodBeat.o(115858);
      return paramInt + i + j + k + m + n + i1;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.abWW.clear();
        paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = erp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = erp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(115858);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        fzl localfzl = (fzl)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(115858);
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
            localfzl.BaseRequest = ((kc)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(115858);
          return 0;
        case 2: 
          localfzl.Zvz = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(115858);
          return 0;
        case 3: 
          localfzl.ZvA = ((i.a.a.a.a)localObject1).ajGk.aaw();
          AppMethodBeat.o(115858);
          return 0;
        case 4: 
          localfzl.abnl = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(115858);
          return 0;
        case 5: 
          localfzl.abWO = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(115858);
          return 0;
        case 6: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new gbh();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((gbh)localObject2).parseFrom((byte[])localObject1);
            }
            localfzl.abWP = ((gbh)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(115858);
          return 0;
        case 7: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new gbh();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((gbh)localObject2).parseFrom((byte[])localObject1);
            }
            localfzl.abWQ = ((gbh)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(115858);
          return 0;
        case 8: 
          localfzl.ZkT = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(115858);
          return 0;
        case 9: 
          localfzl.abWR = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(115858);
          return 0;
        case 10: 
          localfzl.abWS = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(115858);
          return 0;
        case 11: 
          localfzl.abWT = ((i.a.a.a.a)localObject1).ajGk.aaw();
          AppMethodBeat.o(115858);
          return 0;
        case 12: 
          localfzl.abWU = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(115858);
          return 0;
        case 13: 
          localfzl.abWV = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(115858);
          return 0;
        case 14: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new dtl();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((dtl)localObject2).parseFrom((byte[])localObject1);
            }
            localfzl.abWW.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(115858);
          return 0;
        }
        localfzl.abWX = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(115858);
        return 0;
      }
      AppMethodBeat.o(115858);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fzl
 * JD-Core Version:    0.7.0.1
 */