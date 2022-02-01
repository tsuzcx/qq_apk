package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class dhe
  extends cvw
{
  public LinkedList<cxn> BlackList;
  public int BlackListCount;
  public SKBuiltinBuffer_t FSi;
  public SKBuiltinBuffer_t FSj;
  public int GroupCount;
  public LinkedList<cxn> GroupUser;
  public int GroupUserCount;
  public int HOg;
  public int HOh;
  public int HOi;
  public dhc HOj;
  public SKBuiltinBuffer_t HOk;
  public String HOl;
  public so HOm;
  public int HOn;
  public LinkedList<bzf> HOo;
  public dgd HOp;
  public cgs HOq;
  public int HmH;
  public LinkedList<dgp> HmN;
  public dhd HmS;
  public dqz HxX;
  public SKBuiltinBuffer_t ObjectDesc;
  public long ReferId;
  public dhi SnsRedEnvelops;
  public LinkedList<cxn> WithUserList;
  public int WithUserListCount;
  public String hFO;
  
  public dhe()
  {
    AppMethodBeat.i(125805);
    this.WithUserList = new LinkedList();
    this.HmN = new LinkedList();
    this.BlackList = new LinkedList();
    this.GroupUser = new LinkedList();
    this.HOo = new LinkedList();
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
        paramVarArgs.lJ(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.ObjectDesc != null)
      {
        paramVarArgs.lJ(2, this.ObjectDesc.computeSize());
        this.ObjectDesc.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(3, this.WithUserListCount);
      paramVarArgs.e(4, 8, this.WithUserList);
      paramVarArgs.aS(5, this.HOg);
      paramVarArgs.aS(6, this.HmH);
      if (this.hFO != null) {
        paramVarArgs.d(7, this.hFO);
      }
      paramVarArgs.aS(8, this.HOh);
      paramVarArgs.aS(9, this.GroupCount);
      paramVarArgs.e(10, 8, this.HmN);
      paramVarArgs.aS(11, this.HOi);
      paramVarArgs.aZ(12, this.ReferId);
      paramVarArgs.aS(13, this.BlackListCount);
      paramVarArgs.e(14, 8, this.BlackList);
      if (this.HxX != null)
      {
        paramVarArgs.lJ(15, this.HxX.computeSize());
        this.HxX.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(16, this.GroupUserCount);
      paramVarArgs.e(17, 8, this.GroupUser);
      if (this.HOj != null)
      {
        paramVarArgs.lJ(18, this.HOj.computeSize());
        this.HOj.writeFields(paramVarArgs);
      }
      if (this.HmS != null)
      {
        paramVarArgs.lJ(19, this.HmS.computeSize());
        this.HmS.writeFields(paramVarArgs);
      }
      if (this.SnsRedEnvelops != null)
      {
        paramVarArgs.lJ(20, this.SnsRedEnvelops.computeSize());
        this.SnsRedEnvelops.writeFields(paramVarArgs);
      }
      if (this.HOk != null)
      {
        paramVarArgs.lJ(21, this.HOk.computeSize());
        this.HOk.writeFields(paramVarArgs);
      }
      if (this.HOl != null) {
        paramVarArgs.d(22, this.HOl);
      }
      if (this.HOm != null)
      {
        paramVarArgs.lJ(23, this.HOm.computeSize());
        this.HOm.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(24, this.HOn);
      paramVarArgs.e(25, 8, this.HOo);
      if (this.HOp != null)
      {
        paramVarArgs.lJ(26, this.HOp.computeSize());
        this.HOp.writeFields(paramVarArgs);
      }
      if (this.FSi != null)
      {
        paramVarArgs.lJ(27, this.FSi.computeSize());
        this.FSi.writeFields(paramVarArgs);
      }
      if (this.FSj != null)
      {
        paramVarArgs.lJ(28, this.FSj.computeSize());
        this.FSj.writeFields(paramVarArgs);
      }
      if (this.HOq != null)
      {
        paramVarArgs.lJ(29, this.HOq.computeSize());
        this.HOq.writeFields(paramVarArgs);
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
    for (paramInt = f.a.a.a.lI(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.ObjectDesc != null) {
        i = paramInt + f.a.a.a.lI(2, this.ObjectDesc.computeSize());
      }
      i = i + f.a.a.b.b.a.bz(3, this.WithUserListCount) + f.a.a.a.c(4, 8, this.WithUserList) + f.a.a.b.b.a.bz(5, this.HOg) + f.a.a.b.b.a.bz(6, this.HmH);
      paramInt = i;
      if (this.hFO != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.hFO);
      }
      i = paramInt + f.a.a.b.b.a.bz(8, this.HOh) + f.a.a.b.b.a.bz(9, this.GroupCount) + f.a.a.a.c(10, 8, this.HmN) + f.a.a.b.b.a.bz(11, this.HOi) + f.a.a.b.b.a.p(12, this.ReferId) + f.a.a.b.b.a.bz(13, this.BlackListCount) + f.a.a.a.c(14, 8, this.BlackList);
      paramInt = i;
      if (this.HxX != null) {
        paramInt = i + f.a.a.a.lI(15, this.HxX.computeSize());
      }
      i = paramInt + f.a.a.b.b.a.bz(16, this.GroupUserCount) + f.a.a.a.c(17, 8, this.GroupUser);
      paramInt = i;
      if (this.HOj != null) {
        paramInt = i + f.a.a.a.lI(18, this.HOj.computeSize());
      }
      i = paramInt;
      if (this.HmS != null) {
        i = paramInt + f.a.a.a.lI(19, this.HmS.computeSize());
      }
      paramInt = i;
      if (this.SnsRedEnvelops != null) {
        paramInt = i + f.a.a.a.lI(20, this.SnsRedEnvelops.computeSize());
      }
      i = paramInt;
      if (this.HOk != null) {
        i = paramInt + f.a.a.a.lI(21, this.HOk.computeSize());
      }
      paramInt = i;
      if (this.HOl != null) {
        paramInt = i + f.a.a.b.b.a.e(22, this.HOl);
      }
      i = paramInt;
      if (this.HOm != null) {
        i = paramInt + f.a.a.a.lI(23, this.HOm.computeSize());
      }
      i = i + f.a.a.b.b.a.bz(24, this.HOn) + f.a.a.a.c(25, 8, this.HOo);
      paramInt = i;
      if (this.HOp != null) {
        paramInt = i + f.a.a.a.lI(26, this.HOp.computeSize());
      }
      i = paramInt;
      if (this.FSi != null) {
        i = paramInt + f.a.a.a.lI(27, this.FSi.computeSize());
      }
      paramInt = i;
      if (this.FSj != null) {
        paramInt = i + f.a.a.a.lI(28, this.FSj.computeSize());
      }
      i = paramInt;
      if (this.HOq != null) {
        i = paramInt + f.a.a.a.lI(29, this.HOq.computeSize());
      }
      AppMethodBeat.o(125806);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.WithUserList.clear();
        this.HmN.clear();
        this.BlackList.clear();
        this.GroupUser.clear();
        this.HOo.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cvw.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvw.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
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
        dhe localdhe = (dhe)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(125806);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new jc();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((jc)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cvw.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdhe.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(125806);
          return 0;
        case 2: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cvw.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdhe.ObjectDesc = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(125806);
          return 0;
        case 3: 
          localdhe.WithUserListCount = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(125806);
          return 0;
        case 4: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cxn();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cxn)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cvw.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdhe.WithUserList.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(125806);
          return 0;
        case 5: 
          localdhe.HOg = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(125806);
          return 0;
        case 6: 
          localdhe.HmH = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(125806);
          return 0;
        case 7: 
          localdhe.hFO = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(125806);
          return 0;
        case 8: 
          localdhe.HOh = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(125806);
          return 0;
        case 9: 
          localdhe.GroupCount = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(125806);
          return 0;
        case 10: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dgp();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dgp)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cvw.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdhe.HmN.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(125806);
          return 0;
        case 11: 
          localdhe.HOi = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(125806);
          return 0;
        case 12: 
          localdhe.ReferId = ((f.a.a.a.a)localObject1).OmT.zd();
          AppMethodBeat.o(125806);
          return 0;
        case 13: 
          localdhe.BlackListCount = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(125806);
          return 0;
        case 14: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cxn();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cxn)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cvw.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdhe.BlackList.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(125806);
          return 0;
        case 15: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dqz();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dqz)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cvw.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdhe.HxX = ((dqz)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(125806);
          return 0;
        case 16: 
          localdhe.GroupUserCount = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(125806);
          return 0;
        case 17: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cxn();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cxn)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cvw.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdhe.GroupUser.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(125806);
          return 0;
        case 18: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dhc();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dhc)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cvw.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdhe.HOj = ((dhc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(125806);
          return 0;
        case 19: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dhd();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dhd)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cvw.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdhe.HmS = ((dhd)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(125806);
          return 0;
        case 20: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dhi();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dhi)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cvw.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdhe.SnsRedEnvelops = ((dhi)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(125806);
          return 0;
        case 21: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cvw.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdhe.HOk = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(125806);
          return 0;
        case 22: 
          localdhe.HOl = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(125806);
          return 0;
        case 23: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new so();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((so)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cvw.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdhe.HOm = ((so)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(125806);
          return 0;
        case 24: 
          localdhe.HOn = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(125806);
          return 0;
        case 25: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bzf();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bzf)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cvw.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdhe.HOo.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(125806);
          return 0;
        case 26: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dgd();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dgd)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cvw.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdhe.HOp = ((dgd)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(125806);
          return 0;
        case 27: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cvw.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdhe.FSi = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(125806);
          return 0;
        case 28: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cvw.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdhe.FSj = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(125806);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new cgs();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((cgs)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cvw.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localdhe.HOq = ((cgs)localObject1);
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
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dhe
 * JD-Core Version:    0.7.0.1
 */