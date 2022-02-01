package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;
import java.util.LinkedList;

public final class gat
  extends erp
{
  public int ZkT;
  public long ZvA;
  public int Zvz;
  public int abGP;
  public gbh abWP;
  public gbh abWQ;
  public long abWT;
  public int abWU;
  public int abWV;
  public LinkedList<dtl> abWW;
  public int abWX;
  public int abXQ;
  public int abYc;
  public LinkedList<etl> abYd;
  public int abYe;
  public int abmP;
  public String abnl;
  
  public gat()
  {
    AppMethodBeat.i(115883);
    this.abYd = new LinkedList();
    this.abWW = new LinkedList();
    AppMethodBeat.o(115883);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(115884);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.abWP == null)
      {
        paramVarArgs = new b("Not all required fields were included: PeerId");
        AppMethodBeat.o(115884);
        throw paramVarArgs;
      }
      if (this.abWQ == null)
      {
        paramVarArgs = new b("Not all required fields were included: CapInfo");
        AppMethodBeat.o(115884);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.qD(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.abnl != null) {
        paramVarArgs.g(2, this.abnl);
      }
      paramVarArgs.bS(3, this.abYc);
      paramVarArgs.e(4, 8, this.abYd);
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
      paramVarArgs.bS(9, this.abGP);
      paramVarArgs.bS(10, this.Zvz);
      paramVarArgs.bv(11, this.ZvA);
      paramVarArgs.bS(12, this.abXQ);
      paramVarArgs.bv(13, this.abWT);
      paramVarArgs.bS(14, this.abYe);
      paramVarArgs.bS(15, this.abmP);
      paramVarArgs.bS(16, this.abWU);
      paramVarArgs.bS(17, this.abWV);
      paramVarArgs.e(18, 8, this.abWW);
      paramVarArgs.bS(19, this.abWX);
      AppMethodBeat.o(115884);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label1520;
      }
    }
    label1520:
    for (paramInt = i.a.a.a.qC(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.abnl != null) {
        i = paramInt + i.a.a.b.b.a.h(2, this.abnl);
      }
      i = i + i.a.a.b.b.a.cJ(3, this.abYc) + i.a.a.a.c(4, 8, this.abYd);
      paramInt = i;
      if (this.abWP != null) {
        paramInt = i + i.a.a.a.qC(6, this.abWP.computeSize());
      }
      i = paramInt;
      if (this.abWQ != null) {
        i = paramInt + i.a.a.a.qC(7, this.abWQ.computeSize());
      }
      paramInt = i.a.a.b.b.a.cJ(8, this.ZkT);
      int j = i.a.a.b.b.a.cJ(9, this.abGP);
      int k = i.a.a.b.b.a.cJ(10, this.Zvz);
      int m = i.a.a.b.b.a.q(11, this.ZvA);
      int n = i.a.a.b.b.a.cJ(12, this.abXQ);
      int i1 = i.a.a.b.b.a.q(13, this.abWT);
      int i2 = i.a.a.b.b.a.cJ(14, this.abYe);
      int i3 = i.a.a.b.b.a.cJ(15, this.abmP);
      int i4 = i.a.a.b.b.a.cJ(16, this.abWU);
      int i5 = i.a.a.b.b.a.cJ(17, this.abWV);
      int i6 = i.a.a.a.c(18, 8, this.abWW);
      int i7 = i.a.a.b.b.a.cJ(19, this.abWX);
      AppMethodBeat.o(115884);
      return i + paramInt + j + k + m + n + i1 + i2 + i3 + i4 + i5 + i6 + i7;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.abYd.clear();
        this.abWW.clear();
        paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = erp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = erp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        if (this.abWP == null)
        {
          paramVarArgs = new b("Not all required fields were included: PeerId");
          AppMethodBeat.o(115884);
          throw paramVarArgs;
        }
        if (this.abWQ == null)
        {
          paramVarArgs = new b("Not all required fields were included: CapInfo");
          AppMethodBeat.o(115884);
          throw paramVarArgs;
        }
        AppMethodBeat.o(115884);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        gat localgat = (gat)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        case 5: 
        default: 
          AppMethodBeat.o(115884);
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
            localgat.BaseRequest = ((kc)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(115884);
          return 0;
        case 2: 
          localgat.abnl = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(115884);
          return 0;
        case 3: 
          localgat.abYc = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(115884);
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
            localgat.abYd.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(115884);
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
            localgat.abWP = ((gbh)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(115884);
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
            localgat.abWQ = ((gbh)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(115884);
          return 0;
        case 8: 
          localgat.ZkT = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(115884);
          return 0;
        case 9: 
          localgat.abGP = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(115884);
          return 0;
        case 10: 
          localgat.Zvz = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(115884);
          return 0;
        case 11: 
          localgat.ZvA = ((i.a.a.a.a)localObject1).ajGk.aaw();
          AppMethodBeat.o(115884);
          return 0;
        case 12: 
          localgat.abXQ = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(115884);
          return 0;
        case 13: 
          localgat.abWT = ((i.a.a.a.a)localObject1).ajGk.aaw();
          AppMethodBeat.o(115884);
          return 0;
        case 14: 
          localgat.abYe = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(115884);
          return 0;
        case 15: 
          localgat.abmP = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(115884);
          return 0;
        case 16: 
          localgat.abWU = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(115884);
          return 0;
        case 17: 
          localgat.abWV = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(115884);
          return 0;
        case 18: 
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
            localgat.abWW.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(115884);
          return 0;
        }
        localgat.abWX = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(115884);
        return 0;
      }
      AppMethodBeat.o(115884);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.gat
 * JD-Core Version:    0.7.0.1
 */