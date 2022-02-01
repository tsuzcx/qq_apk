package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;
import java.util.LinkedList;

public final class fev
  extends erp
{
  public LinkedList<etl> BlackList;
  public int BlackListCount;
  public int GroupCount;
  public LinkedList<etl> GroupUser;
  public int GroupUserCount;
  public gol ObjectDesc;
  public long ReferId;
  public fez SnsRedEnvelops;
  public LinkedList<etl> WithUserList;
  public int WithUserListCount;
  public gol YKa;
  public gol YKb;
  public int aaTH;
  public LinkedList<fee> aaTN;
  public feu aaTS;
  public String abDB;
  public int abEm;
  public int abEn;
  public int abEo;
  public fet abEp;
  public gol abEq;
  public String abEr;
  public vm abEs;
  public int abEt;
  public LinkedList<dmx> abEu;
  public fdr abEv;
  public dyq abEw;
  public int abEx;
  public LinkedList<etl> abEy;
  public fec abEz;
  public fqo abld;
  public String nUv;
  
  public fev()
  {
    AppMethodBeat.i(125805);
    this.WithUserList = new LinkedList();
    this.aaTN = new LinkedList();
    this.BlackList = new LinkedList();
    this.GroupUser = new LinkedList();
    this.abEu = new LinkedList();
    this.abEy = new LinkedList();
    AppMethodBeat.o(125805);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(125806);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.ObjectDesc == null)
      {
        paramVarArgs = new b("Not all required fields were included: ObjectDesc");
        AppMethodBeat.o(125806);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.qD(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.ObjectDesc != null)
      {
        paramVarArgs.qD(2, this.ObjectDesc.computeSize());
        this.ObjectDesc.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(3, this.WithUserListCount);
      paramVarArgs.e(4, 8, this.WithUserList);
      paramVarArgs.bS(5, this.abEm);
      paramVarArgs.bS(6, this.aaTH);
      if (this.nUv != null) {
        paramVarArgs.g(7, this.nUv);
      }
      paramVarArgs.bS(8, this.abEn);
      paramVarArgs.bS(9, this.GroupCount);
      paramVarArgs.e(10, 8, this.aaTN);
      paramVarArgs.bS(11, this.abEo);
      paramVarArgs.bv(12, this.ReferId);
      paramVarArgs.bS(13, this.BlackListCount);
      paramVarArgs.e(14, 8, this.BlackList);
      if (this.abld != null)
      {
        paramVarArgs.qD(15, this.abld.computeSize());
        this.abld.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(16, this.GroupUserCount);
      paramVarArgs.e(17, 8, this.GroupUser);
      if (this.abEp != null)
      {
        paramVarArgs.qD(18, this.abEp.computeSize());
        this.abEp.writeFields(paramVarArgs);
      }
      if (this.aaTS != null)
      {
        paramVarArgs.qD(19, this.aaTS.computeSize());
        this.aaTS.writeFields(paramVarArgs);
      }
      if (this.SnsRedEnvelops != null)
      {
        paramVarArgs.qD(20, this.SnsRedEnvelops.computeSize());
        this.SnsRedEnvelops.writeFields(paramVarArgs);
      }
      if (this.abEq != null)
      {
        paramVarArgs.qD(21, this.abEq.computeSize());
        this.abEq.writeFields(paramVarArgs);
      }
      if (this.abEr != null) {
        paramVarArgs.g(22, this.abEr);
      }
      if (this.abEs != null)
      {
        paramVarArgs.qD(23, this.abEs.computeSize());
        this.abEs.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(24, this.abEt);
      paramVarArgs.e(25, 8, this.abEu);
      if (this.abEv != null)
      {
        paramVarArgs.qD(26, this.abEv.computeSize());
        this.abEv.writeFields(paramVarArgs);
      }
      if (this.YKa != null)
      {
        paramVarArgs.qD(27, this.YKa.computeSize());
        this.YKa.writeFields(paramVarArgs);
      }
      if (this.YKb != null)
      {
        paramVarArgs.qD(28, this.YKb.computeSize());
        this.YKb.writeFields(paramVarArgs);
      }
      if (this.abEw != null)
      {
        paramVarArgs.qD(29, this.abEw.computeSize());
        this.abEw.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(32, this.abEx);
      paramVarArgs.e(33, 8, this.abEy);
      if (this.abDB != null) {
        paramVarArgs.g(34, this.abDB);
      }
      if (this.abEz != null)
      {
        paramVarArgs.qD(35, this.abEz.computeSize());
        this.abEz.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(125806);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label3324;
      }
    }
    label3324:
    for (paramInt = i.a.a.a.qC(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.ObjectDesc != null) {
        i = paramInt + i.a.a.a.qC(2, this.ObjectDesc.computeSize());
      }
      i = i + i.a.a.b.b.a.cJ(3, this.WithUserListCount) + i.a.a.a.c(4, 8, this.WithUserList) + i.a.a.b.b.a.cJ(5, this.abEm) + i.a.a.b.b.a.cJ(6, this.aaTH);
      paramInt = i;
      if (this.nUv != null) {
        paramInt = i + i.a.a.b.b.a.h(7, this.nUv);
      }
      i = paramInt + i.a.a.b.b.a.cJ(8, this.abEn) + i.a.a.b.b.a.cJ(9, this.GroupCount) + i.a.a.a.c(10, 8, this.aaTN) + i.a.a.b.b.a.cJ(11, this.abEo) + i.a.a.b.b.a.q(12, this.ReferId) + i.a.a.b.b.a.cJ(13, this.BlackListCount) + i.a.a.a.c(14, 8, this.BlackList);
      paramInt = i;
      if (this.abld != null) {
        paramInt = i + i.a.a.a.qC(15, this.abld.computeSize());
      }
      i = paramInt + i.a.a.b.b.a.cJ(16, this.GroupUserCount) + i.a.a.a.c(17, 8, this.GroupUser);
      paramInt = i;
      if (this.abEp != null) {
        paramInt = i + i.a.a.a.qC(18, this.abEp.computeSize());
      }
      i = paramInt;
      if (this.aaTS != null) {
        i = paramInt + i.a.a.a.qC(19, this.aaTS.computeSize());
      }
      paramInt = i;
      if (this.SnsRedEnvelops != null) {
        paramInt = i + i.a.a.a.qC(20, this.SnsRedEnvelops.computeSize());
      }
      i = paramInt;
      if (this.abEq != null) {
        i = paramInt + i.a.a.a.qC(21, this.abEq.computeSize());
      }
      paramInt = i;
      if (this.abEr != null) {
        paramInt = i + i.a.a.b.b.a.h(22, this.abEr);
      }
      i = paramInt;
      if (this.abEs != null) {
        i = paramInt + i.a.a.a.qC(23, this.abEs.computeSize());
      }
      i = i + i.a.a.b.b.a.cJ(24, this.abEt) + i.a.a.a.c(25, 8, this.abEu);
      paramInt = i;
      if (this.abEv != null) {
        paramInt = i + i.a.a.a.qC(26, this.abEv.computeSize());
      }
      i = paramInt;
      if (this.YKa != null) {
        i = paramInt + i.a.a.a.qC(27, this.YKa.computeSize());
      }
      paramInt = i;
      if (this.YKb != null) {
        paramInt = i + i.a.a.a.qC(28, this.YKb.computeSize());
      }
      i = paramInt;
      if (this.abEw != null) {
        i = paramInt + i.a.a.a.qC(29, this.abEw.computeSize());
      }
      i = i + i.a.a.b.b.a.cJ(32, this.abEx) + i.a.a.a.c(33, 8, this.abEy);
      paramInt = i;
      if (this.abDB != null) {
        paramInt = i + i.a.a.b.b.a.h(34, this.abDB);
      }
      i = paramInt;
      if (this.abEz != null) {
        i = paramInt + i.a.a.a.qC(35, this.abEz.computeSize());
      }
      AppMethodBeat.o(125806);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.WithUserList.clear();
        this.aaTN.clear();
        this.BlackList.clear();
        this.GroupUser.clear();
        this.abEu.clear();
        this.abEy.clear();
        paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = erp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = erp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        if (this.ObjectDesc == null)
        {
          paramVarArgs = new b("Not all required fields were included: ObjectDesc");
          AppMethodBeat.o(125806);
          throw paramVarArgs;
        }
        AppMethodBeat.o(125806);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        fev localfev = (fev)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        case 30: 
        case 31: 
        default: 
          AppMethodBeat.o(125806);
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
            localfev.BaseRequest = ((kc)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(125806);
          return 0;
        case 2: 
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
            localfev.ObjectDesc = ((gol)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(125806);
          return 0;
        case 3: 
          localfev.WithUserListCount = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(125806);
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
            localfev.WithUserList.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(125806);
          return 0;
        case 5: 
          localfev.abEm = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(125806);
          return 0;
        case 6: 
          localfev.aaTH = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(125806);
          return 0;
        case 7: 
          localfev.nUv = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(125806);
          return 0;
        case 8: 
          localfev.abEn = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(125806);
          return 0;
        case 9: 
          localfev.GroupCount = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(125806);
          return 0;
        case 10: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new fee();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((fee)localObject2).parseFrom((byte[])localObject1);
            }
            localfev.aaTN.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(125806);
          return 0;
        case 11: 
          localfev.abEo = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(125806);
          return 0;
        case 12: 
          localfev.ReferId = ((i.a.a.a.a)localObject1).ajGk.aaw();
          AppMethodBeat.o(125806);
          return 0;
        case 13: 
          localfev.BlackListCount = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(125806);
          return 0;
        case 14: 
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
            localfev.BlackList.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(125806);
          return 0;
        case 15: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new fqo();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((fqo)localObject2).parseFrom((byte[])localObject1);
            }
            localfev.abld = ((fqo)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(125806);
          return 0;
        case 16: 
          localfev.GroupUserCount = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(125806);
          return 0;
        case 17: 
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
            localfev.GroupUser.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(125806);
          return 0;
        case 18: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new fet();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((fet)localObject2).parseFrom((byte[])localObject1);
            }
            localfev.abEp = ((fet)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(125806);
          return 0;
        case 19: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new feu();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((feu)localObject2).parseFrom((byte[])localObject1);
            }
            localfev.aaTS = ((feu)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(125806);
          return 0;
        case 20: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new fez();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((fez)localObject2).parseFrom((byte[])localObject1);
            }
            localfev.SnsRedEnvelops = ((fez)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(125806);
          return 0;
        case 21: 
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
            localfev.abEq = ((gol)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(125806);
          return 0;
        case 22: 
          localfev.abEr = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(125806);
          return 0;
        case 23: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new vm();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((vm)localObject2).parseFrom((byte[])localObject1);
            }
            localfev.abEs = ((vm)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(125806);
          return 0;
        case 24: 
          localfev.abEt = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(125806);
          return 0;
        case 25: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new dmx();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((dmx)localObject2).parseFrom((byte[])localObject1);
            }
            localfev.abEu.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(125806);
          return 0;
        case 26: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new fdr();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((fdr)localObject2).parseFrom((byte[])localObject1);
            }
            localfev.abEv = ((fdr)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(125806);
          return 0;
        case 27: 
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
            localfev.YKa = ((gol)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(125806);
          return 0;
        case 28: 
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
            localfev.YKb = ((gol)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(125806);
          return 0;
        case 29: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new dyq();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((dyq)localObject2).parseFrom((byte[])localObject1);
            }
            localfev.abEw = ((dyq)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(125806);
          return 0;
        case 32: 
          localfev.abEx = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(125806);
          return 0;
        case 33: 
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
            localfev.abEy.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(125806);
          return 0;
        case 34: 
          localfev.abDB = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(125806);
          return 0;
        }
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new fec();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((fec)localObject2).parseFrom((byte[])localObject1);
          }
          localfev.abEz = ((fec)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(125806);
        return 0;
      }
      AppMethodBeat.o(125806);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fev
 * JD-Core Version:    0.7.0.1
 */