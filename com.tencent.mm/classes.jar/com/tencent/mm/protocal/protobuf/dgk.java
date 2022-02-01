package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class dgk
  extends cvc
{
  public LinkedList<cwt> BlackList;
  public int BlackListCount;
  public SKBuiltinBuffer_t FzK;
  public SKBuiltinBuffer_t FzL;
  public int GTg;
  public LinkedList<dfv> GTm;
  public dgj GTr;
  public int GroupCount;
  public LinkedList<cwt> GroupUser;
  public int GroupUserCount;
  public dqc Hex;
  public int HuD;
  public int HuE;
  public int HuF;
  public dgi HuG;
  public SKBuiltinBuffer_t HuH;
  public String HuI;
  public sm HuJ;
  public int HuK;
  public LinkedList<byl> HuL;
  public dfj HuM;
  public cfy HuN;
  public SKBuiltinBuffer_t ObjectDesc;
  public long ReferId;
  public dgo SnsRedEnvelops;
  public LinkedList<cwt> WithUserList;
  public int WithUserListCount;
  public String hCW;
  
  public dgk()
  {
    AppMethodBeat.i(125805);
    this.WithUserList = new LinkedList();
    this.GTm = new LinkedList();
    this.BlackList = new LinkedList();
    this.GroupUser = new LinkedList();
    this.HuL = new LinkedList();
    AppMethodBeat.o(125805);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(125806);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.ObjectDesc == null)
      {
        paramVarArgs = new b("Not all required fields were included: ObjectDesc");
        AppMethodBeat.o(125806);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.lC(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.ObjectDesc != null)
      {
        paramVarArgs.lC(2, this.ObjectDesc.computeSize());
        this.ObjectDesc.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(3, this.WithUserListCount);
      paramVarArgs.e(4, 8, this.WithUserList);
      paramVarArgs.aS(5, this.HuD);
      paramVarArgs.aS(6, this.GTg);
      if (this.hCW != null) {
        paramVarArgs.d(7, this.hCW);
      }
      paramVarArgs.aS(8, this.HuE);
      paramVarArgs.aS(9, this.GroupCount);
      paramVarArgs.e(10, 8, this.GTm);
      paramVarArgs.aS(11, this.HuF);
      paramVarArgs.aY(12, this.ReferId);
      paramVarArgs.aS(13, this.BlackListCount);
      paramVarArgs.e(14, 8, this.BlackList);
      if (this.Hex != null)
      {
        paramVarArgs.lC(15, this.Hex.computeSize());
        this.Hex.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(16, this.GroupUserCount);
      paramVarArgs.e(17, 8, this.GroupUser);
      if (this.HuG != null)
      {
        paramVarArgs.lC(18, this.HuG.computeSize());
        this.HuG.writeFields(paramVarArgs);
      }
      if (this.GTr != null)
      {
        paramVarArgs.lC(19, this.GTr.computeSize());
        this.GTr.writeFields(paramVarArgs);
      }
      if (this.SnsRedEnvelops != null)
      {
        paramVarArgs.lC(20, this.SnsRedEnvelops.computeSize());
        this.SnsRedEnvelops.writeFields(paramVarArgs);
      }
      if (this.HuH != null)
      {
        paramVarArgs.lC(21, this.HuH.computeSize());
        this.HuH.writeFields(paramVarArgs);
      }
      if (this.HuI != null) {
        paramVarArgs.d(22, this.HuI);
      }
      if (this.HuJ != null)
      {
        paramVarArgs.lC(23, this.HuJ.computeSize());
        this.HuJ.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(24, this.HuK);
      paramVarArgs.e(25, 8, this.HuL);
      if (this.HuM != null)
      {
        paramVarArgs.lC(26, this.HuM.computeSize());
        this.HuM.writeFields(paramVarArgs);
      }
      if (this.FzK != null)
      {
        paramVarArgs.lC(27, this.FzK.computeSize());
        this.FzK.writeFields(paramVarArgs);
      }
      if (this.FzL != null)
      {
        paramVarArgs.lC(28, this.FzL.computeSize());
        this.FzL.writeFields(paramVarArgs);
      }
      if (this.HuN != null)
      {
        paramVarArgs.lC(29, this.HuN.computeSize());
        this.HuN.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(125806);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label3334;
      }
    }
    label3334:
    for (paramInt = f.a.a.a.lB(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.ObjectDesc != null) {
        i = paramInt + f.a.a.a.lB(2, this.ObjectDesc.computeSize());
      }
      i = i + f.a.a.b.b.a.bz(3, this.WithUserListCount) + f.a.a.a.c(4, 8, this.WithUserList) + f.a.a.b.b.a.bz(5, this.HuD) + f.a.a.b.b.a.bz(6, this.GTg);
      paramInt = i;
      if (this.hCW != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.hCW);
      }
      i = paramInt + f.a.a.b.b.a.bz(8, this.HuE) + f.a.a.b.b.a.bz(9, this.GroupCount) + f.a.a.a.c(10, 8, this.GTm) + f.a.a.b.b.a.bz(11, this.HuF) + f.a.a.b.b.a.p(12, this.ReferId) + f.a.a.b.b.a.bz(13, this.BlackListCount) + f.a.a.a.c(14, 8, this.BlackList);
      paramInt = i;
      if (this.Hex != null) {
        paramInt = i + f.a.a.a.lB(15, this.Hex.computeSize());
      }
      i = paramInt + f.a.a.b.b.a.bz(16, this.GroupUserCount) + f.a.a.a.c(17, 8, this.GroupUser);
      paramInt = i;
      if (this.HuG != null) {
        paramInt = i + f.a.a.a.lB(18, this.HuG.computeSize());
      }
      i = paramInt;
      if (this.GTr != null) {
        i = paramInt + f.a.a.a.lB(19, this.GTr.computeSize());
      }
      paramInt = i;
      if (this.SnsRedEnvelops != null) {
        paramInt = i + f.a.a.a.lB(20, this.SnsRedEnvelops.computeSize());
      }
      i = paramInt;
      if (this.HuH != null) {
        i = paramInt + f.a.a.a.lB(21, this.HuH.computeSize());
      }
      paramInt = i;
      if (this.HuI != null) {
        paramInt = i + f.a.a.b.b.a.e(22, this.HuI);
      }
      i = paramInt;
      if (this.HuJ != null) {
        i = paramInt + f.a.a.a.lB(23, this.HuJ.computeSize());
      }
      i = i + f.a.a.b.b.a.bz(24, this.HuK) + f.a.a.a.c(25, 8, this.HuL);
      paramInt = i;
      if (this.HuM != null) {
        paramInt = i + f.a.a.a.lB(26, this.HuM.computeSize());
      }
      i = paramInt;
      if (this.FzK != null) {
        i = paramInt + f.a.a.a.lB(27, this.FzK.computeSize());
      }
      paramInt = i;
      if (this.FzL != null) {
        paramInt = i + f.a.a.a.lB(28, this.FzL.computeSize());
      }
      i = paramInt;
      if (this.HuN != null) {
        i = paramInt + f.a.a.a.lB(29, this.HuN.computeSize());
      }
      AppMethodBeat.o(125806);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.WithUserList.clear();
        this.GTm.clear();
        this.BlackList.clear();
        this.GroupUser.clear();
        this.HuL.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cvc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
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
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        dgk localdgk = (dgk)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(125806);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new jc();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((jc)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvc.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdgk.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(125806);
          return 0;
        case 2: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvc.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdgk.ObjectDesc = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(125806);
          return 0;
        case 3: 
          localdgk.WithUserListCount = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(125806);
          return 0;
        case 4: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cwt();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cwt)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvc.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdgk.WithUserList.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(125806);
          return 0;
        case 5: 
          localdgk.HuD = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(125806);
          return 0;
        case 6: 
          localdgk.GTg = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(125806);
          return 0;
        case 7: 
          localdgk.hCW = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(125806);
          return 0;
        case 8: 
          localdgk.HuE = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(125806);
          return 0;
        case 9: 
          localdgk.GroupCount = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(125806);
          return 0;
        case 10: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dfv();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dfv)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvc.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdgk.GTm.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(125806);
          return 0;
        case 11: 
          localdgk.HuF = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(125806);
          return 0;
        case 12: 
          localdgk.ReferId = ((f.a.a.a.a)localObject1).NPN.zd();
          AppMethodBeat.o(125806);
          return 0;
        case 13: 
          localdgk.BlackListCount = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(125806);
          return 0;
        case 14: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cwt();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cwt)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvc.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdgk.BlackList.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(125806);
          return 0;
        case 15: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dqc();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dqc)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvc.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdgk.Hex = ((dqc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(125806);
          return 0;
        case 16: 
          localdgk.GroupUserCount = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(125806);
          return 0;
        case 17: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cwt();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cwt)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvc.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdgk.GroupUser.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(125806);
          return 0;
        case 18: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dgi();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dgi)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvc.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdgk.HuG = ((dgi)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(125806);
          return 0;
        case 19: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dgj();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dgj)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvc.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdgk.GTr = ((dgj)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(125806);
          return 0;
        case 20: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dgo();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dgo)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvc.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdgk.SnsRedEnvelops = ((dgo)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(125806);
          return 0;
        case 21: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvc.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdgk.HuH = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(125806);
          return 0;
        case 22: 
          localdgk.HuI = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(125806);
          return 0;
        case 23: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new sm();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((sm)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvc.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdgk.HuJ = ((sm)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(125806);
          return 0;
        case 24: 
          localdgk.HuK = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(125806);
          return 0;
        case 25: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new byl();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((byl)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvc.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdgk.HuL.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(125806);
          return 0;
        case 26: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dfj();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dfj)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvc.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdgk.HuM = ((dfj)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(125806);
          return 0;
        case 27: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvc.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdgk.FzK = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(125806);
          return 0;
        case 28: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvc.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdgk.FzL = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(125806);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new cfy();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((cfy)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvc.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localdgk.HuN = ((cfy)localObject1);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dgk
 * JD-Core Version:    0.7.0.1
 */