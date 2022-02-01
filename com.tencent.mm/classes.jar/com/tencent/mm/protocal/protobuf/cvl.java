package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class cvl
  extends ckq
{
  public LinkedList<cmf> BlackList;
  public int BlackListCount;
  public SKBuiltinBuffer_t CBT;
  public SKBuiltinBuffer_t CBU;
  public int DNo;
  public LinkedList<cuw> DNu;
  public cvk DNz;
  public dew DXy;
  public int EmW;
  public int EmX;
  public int EmY;
  public cvj EmZ;
  public SKBuiltinBuffer_t Ena;
  public String Enb;
  public ql Enc;
  public int End;
  public LinkedList<bpg> Ene;
  public cuk Enf;
  public bwn Eng;
  public int GroupCount;
  public LinkedList<cmf> GroupUser;
  public int GroupUserCount;
  public SKBuiltinBuffer_t ObjectDesc;
  public long ReferId;
  public cvp SnsRedEnvelops;
  public LinkedList<cmf> WithUserList;
  public int WithUserListCount;
  public String gKn;
  
  public cvl()
  {
    AppMethodBeat.i(125805);
    this.WithUserList = new LinkedList();
    this.DNu = new LinkedList();
    this.BlackList = new LinkedList();
    this.GroupUser = new LinkedList();
    this.Ene = new LinkedList();
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
        paramVarArgs.kX(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.ObjectDesc != null)
      {
        paramVarArgs.kX(2, this.ObjectDesc.computeSize());
        this.ObjectDesc.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(3, this.WithUserListCount);
      paramVarArgs.e(4, 8, this.WithUserList);
      paramVarArgs.aR(5, this.EmW);
      paramVarArgs.aR(6, this.DNo);
      if (this.gKn != null) {
        paramVarArgs.d(7, this.gKn);
      }
      paramVarArgs.aR(8, this.EmX);
      paramVarArgs.aR(9, this.GroupCount);
      paramVarArgs.e(10, 8, this.DNu);
      paramVarArgs.aR(11, this.EmY);
      paramVarArgs.aG(12, this.ReferId);
      paramVarArgs.aR(13, this.BlackListCount);
      paramVarArgs.e(14, 8, this.BlackList);
      if (this.DXy != null)
      {
        paramVarArgs.kX(15, this.DXy.computeSize());
        this.DXy.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(16, this.GroupUserCount);
      paramVarArgs.e(17, 8, this.GroupUser);
      if (this.EmZ != null)
      {
        paramVarArgs.kX(18, this.EmZ.computeSize());
        this.EmZ.writeFields(paramVarArgs);
      }
      if (this.DNz != null)
      {
        paramVarArgs.kX(19, this.DNz.computeSize());
        this.DNz.writeFields(paramVarArgs);
      }
      if (this.SnsRedEnvelops != null)
      {
        paramVarArgs.kX(20, this.SnsRedEnvelops.computeSize());
        this.SnsRedEnvelops.writeFields(paramVarArgs);
      }
      if (this.Ena != null)
      {
        paramVarArgs.kX(21, this.Ena.computeSize());
        this.Ena.writeFields(paramVarArgs);
      }
      if (this.Enb != null) {
        paramVarArgs.d(22, this.Enb);
      }
      if (this.Enc != null)
      {
        paramVarArgs.kX(23, this.Enc.computeSize());
        this.Enc.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(24, this.End);
      paramVarArgs.e(25, 8, this.Ene);
      if (this.Enf != null)
      {
        paramVarArgs.kX(26, this.Enf.computeSize());
        this.Enf.writeFields(paramVarArgs);
      }
      if (this.CBT != null)
      {
        paramVarArgs.kX(27, this.CBT.computeSize());
        this.CBT.writeFields(paramVarArgs);
      }
      if (this.CBU != null)
      {
        paramVarArgs.kX(28, this.CBU.computeSize());
        this.CBU.writeFields(paramVarArgs);
      }
      if (this.Eng != null)
      {
        paramVarArgs.kX(29, this.Eng.computeSize());
        this.Eng.writeFields(paramVarArgs);
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
    for (paramInt = f.a.a.a.kW(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.ObjectDesc != null) {
        i = paramInt + f.a.a.a.kW(2, this.ObjectDesc.computeSize());
      }
      i = i + f.a.a.b.b.a.bA(3, this.WithUserListCount) + f.a.a.a.c(4, 8, this.WithUserList) + f.a.a.b.b.a.bA(5, this.EmW) + f.a.a.b.b.a.bA(6, this.DNo);
      paramInt = i;
      if (this.gKn != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.gKn);
      }
      i = paramInt + f.a.a.b.b.a.bA(8, this.EmX) + f.a.a.b.b.a.bA(9, this.GroupCount) + f.a.a.a.c(10, 8, this.DNu) + f.a.a.b.b.a.bA(11, this.EmY) + f.a.a.b.b.a.q(12, this.ReferId) + f.a.a.b.b.a.bA(13, this.BlackListCount) + f.a.a.a.c(14, 8, this.BlackList);
      paramInt = i;
      if (this.DXy != null) {
        paramInt = i + f.a.a.a.kW(15, this.DXy.computeSize());
      }
      i = paramInt + f.a.a.b.b.a.bA(16, this.GroupUserCount) + f.a.a.a.c(17, 8, this.GroupUser);
      paramInt = i;
      if (this.EmZ != null) {
        paramInt = i + f.a.a.a.kW(18, this.EmZ.computeSize());
      }
      i = paramInt;
      if (this.DNz != null) {
        i = paramInt + f.a.a.a.kW(19, this.DNz.computeSize());
      }
      paramInt = i;
      if (this.SnsRedEnvelops != null) {
        paramInt = i + f.a.a.a.kW(20, this.SnsRedEnvelops.computeSize());
      }
      i = paramInt;
      if (this.Ena != null) {
        i = paramInt + f.a.a.a.kW(21, this.Ena.computeSize());
      }
      paramInt = i;
      if (this.Enb != null) {
        paramInt = i + f.a.a.b.b.a.e(22, this.Enb);
      }
      i = paramInt;
      if (this.Enc != null) {
        i = paramInt + f.a.a.a.kW(23, this.Enc.computeSize());
      }
      i = i + f.a.a.b.b.a.bA(24, this.End) + f.a.a.a.c(25, 8, this.Ene);
      paramInt = i;
      if (this.Enf != null) {
        paramInt = i + f.a.a.a.kW(26, this.Enf.computeSize());
      }
      i = paramInt;
      if (this.CBT != null) {
        i = paramInt + f.a.a.a.kW(27, this.CBT.computeSize());
      }
      paramInt = i;
      if (this.CBU != null) {
        paramInt = i + f.a.a.a.kW(28, this.CBU.computeSize());
      }
      i = paramInt;
      if (this.Eng != null) {
        i = paramInt + f.a.a.a.kW(29, this.Eng.computeSize());
      }
      AppMethodBeat.o(125806);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.WithUserList.clear();
        this.DNu.clear();
        this.BlackList.clear();
        this.GroupUser.clear();
        this.Ene.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = ckq.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = ckq.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
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
        cvl localcvl = (cvl)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(125806);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ip();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ip)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, ckq.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcvl.BaseRequest = ((ip)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(125806);
          return 0;
        case 2: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, ckq.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcvl.ObjectDesc = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(125806);
          return 0;
        case 3: 
          localcvl.WithUserListCount = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(125806);
          return 0;
        case 4: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cmf();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cmf)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, ckq.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcvl.WithUserList.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(125806);
          return 0;
        case 5: 
          localcvl.EmW = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(125806);
          return 0;
        case 6: 
          localcvl.DNo = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(125806);
          return 0;
        case 7: 
          localcvl.gKn = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(125806);
          return 0;
        case 8: 
          localcvl.EmX = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(125806);
          return 0;
        case 9: 
          localcvl.GroupCount = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(125806);
          return 0;
        case 10: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cuw();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cuw)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, ckq.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcvl.DNu.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(125806);
          return 0;
        case 11: 
          localcvl.EmY = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(125806);
          return 0;
        case 12: 
          localcvl.ReferId = ((f.a.a.a.a)localObject1).KhF.xT();
          AppMethodBeat.o(125806);
          return 0;
        case 13: 
          localcvl.BlackListCount = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(125806);
          return 0;
        case 14: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cmf();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cmf)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, ckq.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcvl.BlackList.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(125806);
          return 0;
        case 15: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dew();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dew)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, ckq.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcvl.DXy = ((dew)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(125806);
          return 0;
        case 16: 
          localcvl.GroupUserCount = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(125806);
          return 0;
        case 17: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cmf();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cmf)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, ckq.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcvl.GroupUser.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(125806);
          return 0;
        case 18: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cvj();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cvj)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, ckq.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcvl.EmZ = ((cvj)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(125806);
          return 0;
        case 19: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cvk();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cvk)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, ckq.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcvl.DNz = ((cvk)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(125806);
          return 0;
        case 20: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cvp();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cvp)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, ckq.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcvl.SnsRedEnvelops = ((cvp)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(125806);
          return 0;
        case 21: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, ckq.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcvl.Ena = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(125806);
          return 0;
        case 22: 
          localcvl.Enb = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(125806);
          return 0;
        case 23: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ql();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ql)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, ckq.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcvl.Enc = ((ql)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(125806);
          return 0;
        case 24: 
          localcvl.End = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(125806);
          return 0;
        case 25: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bpg();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bpg)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, ckq.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcvl.Ene.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(125806);
          return 0;
        case 26: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cuk();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cuk)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, ckq.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcvl.Enf = ((cuk)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(125806);
          return 0;
        case 27: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, ckq.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcvl.CBT = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(125806);
          return 0;
        case 28: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, ckq.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcvl.CBU = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(125806);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new bwn();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((bwn)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, ckq.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localcvl.Eng = ((bwn)localObject1);
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
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cvl
 * JD-Core Version:    0.7.0.1
 */