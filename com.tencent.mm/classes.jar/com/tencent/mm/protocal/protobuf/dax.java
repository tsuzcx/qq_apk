package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class dax
  extends cpx
{
  public LinkedList<crm> BlackList;
  public int BlackListCount;
  public SKBuiltinBuffer_t DUq;
  public SKBuiltinBuffer_t DUr;
  public int FJV;
  public int FJW;
  public int FJX;
  public dav FJY;
  public SKBuiltinBuffer_t FJZ;
  public String FKa;
  public qv FKb;
  public int FKc;
  public LinkedList<btx> FKd;
  public czw FKe;
  public cbh FKf;
  public int FjF;
  public LinkedList<dai> FjL;
  public daw FjQ;
  public dkl Fus;
  public int GroupCount;
  public LinkedList<crm> GroupUser;
  public int GroupUserCount;
  public SKBuiltinBuffer_t ObjectDesc;
  public long ReferId;
  public dbb SnsRedEnvelops;
  public LinkedList<crm> WithUserList;
  public int WithUserListCount;
  public String hkN;
  
  public dax()
  {
    AppMethodBeat.i(125805);
    this.WithUserList = new LinkedList();
    this.FjL = new LinkedList();
    this.BlackList = new LinkedList();
    this.GroupUser = new LinkedList();
    this.FKd = new LinkedList();
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
        paramVarArgs.ln(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.ObjectDesc != null)
      {
        paramVarArgs.ln(2, this.ObjectDesc.computeSize());
        this.ObjectDesc.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(3, this.WithUserListCount);
      paramVarArgs.e(4, 8, this.WithUserList);
      paramVarArgs.aR(5, this.FJV);
      paramVarArgs.aR(6, this.FjF);
      if (this.hkN != null) {
        paramVarArgs.d(7, this.hkN);
      }
      paramVarArgs.aR(8, this.FJW);
      paramVarArgs.aR(9, this.GroupCount);
      paramVarArgs.e(10, 8, this.FjL);
      paramVarArgs.aR(11, this.FJX);
      paramVarArgs.aO(12, this.ReferId);
      paramVarArgs.aR(13, this.BlackListCount);
      paramVarArgs.e(14, 8, this.BlackList);
      if (this.Fus != null)
      {
        paramVarArgs.ln(15, this.Fus.computeSize());
        this.Fus.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(16, this.GroupUserCount);
      paramVarArgs.e(17, 8, this.GroupUser);
      if (this.FJY != null)
      {
        paramVarArgs.ln(18, this.FJY.computeSize());
        this.FJY.writeFields(paramVarArgs);
      }
      if (this.FjQ != null)
      {
        paramVarArgs.ln(19, this.FjQ.computeSize());
        this.FjQ.writeFields(paramVarArgs);
      }
      if (this.SnsRedEnvelops != null)
      {
        paramVarArgs.ln(20, this.SnsRedEnvelops.computeSize());
        this.SnsRedEnvelops.writeFields(paramVarArgs);
      }
      if (this.FJZ != null)
      {
        paramVarArgs.ln(21, this.FJZ.computeSize());
        this.FJZ.writeFields(paramVarArgs);
      }
      if (this.FKa != null) {
        paramVarArgs.d(22, this.FKa);
      }
      if (this.FKb != null)
      {
        paramVarArgs.ln(23, this.FKb.computeSize());
        this.FKb.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(24, this.FKc);
      paramVarArgs.e(25, 8, this.FKd);
      if (this.FKe != null)
      {
        paramVarArgs.ln(26, this.FKe.computeSize());
        this.FKe.writeFields(paramVarArgs);
      }
      if (this.DUq != null)
      {
        paramVarArgs.ln(27, this.DUq.computeSize());
        this.DUq.writeFields(paramVarArgs);
      }
      if (this.DUr != null)
      {
        paramVarArgs.ln(28, this.DUr.computeSize());
        this.DUr.writeFields(paramVarArgs);
      }
      if (this.FKf != null)
      {
        paramVarArgs.ln(29, this.FKf.computeSize());
        this.FKf.writeFields(paramVarArgs);
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
    for (paramInt = f.a.a.a.lm(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.ObjectDesc != null) {
        i = paramInt + f.a.a.a.lm(2, this.ObjectDesc.computeSize());
      }
      i = i + f.a.a.b.b.a.bx(3, this.WithUserListCount) + f.a.a.a.c(4, 8, this.WithUserList) + f.a.a.b.b.a.bx(5, this.FJV) + f.a.a.b.b.a.bx(6, this.FjF);
      paramInt = i;
      if (this.hkN != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.hkN);
      }
      i = paramInt + f.a.a.b.b.a.bx(8, this.FJW) + f.a.a.b.b.a.bx(9, this.GroupCount) + f.a.a.a.c(10, 8, this.FjL) + f.a.a.b.b.a.bx(11, this.FJX) + f.a.a.b.b.a.p(12, this.ReferId) + f.a.a.b.b.a.bx(13, this.BlackListCount) + f.a.a.a.c(14, 8, this.BlackList);
      paramInt = i;
      if (this.Fus != null) {
        paramInt = i + f.a.a.a.lm(15, this.Fus.computeSize());
      }
      i = paramInt + f.a.a.b.b.a.bx(16, this.GroupUserCount) + f.a.a.a.c(17, 8, this.GroupUser);
      paramInt = i;
      if (this.FJY != null) {
        paramInt = i + f.a.a.a.lm(18, this.FJY.computeSize());
      }
      i = paramInt;
      if (this.FjQ != null) {
        i = paramInt + f.a.a.a.lm(19, this.FjQ.computeSize());
      }
      paramInt = i;
      if (this.SnsRedEnvelops != null) {
        paramInt = i + f.a.a.a.lm(20, this.SnsRedEnvelops.computeSize());
      }
      i = paramInt;
      if (this.FJZ != null) {
        i = paramInt + f.a.a.a.lm(21, this.FJZ.computeSize());
      }
      paramInt = i;
      if (this.FKa != null) {
        paramInt = i + f.a.a.b.b.a.e(22, this.FKa);
      }
      i = paramInt;
      if (this.FKb != null) {
        i = paramInt + f.a.a.a.lm(23, this.FKb.computeSize());
      }
      i = i + f.a.a.b.b.a.bx(24, this.FKc) + f.a.a.a.c(25, 8, this.FKd);
      paramInt = i;
      if (this.FKe != null) {
        paramInt = i + f.a.a.a.lm(26, this.FKe.computeSize());
      }
      i = paramInt;
      if (this.DUq != null) {
        i = paramInt + f.a.a.a.lm(27, this.DUq.computeSize());
      }
      paramInt = i;
      if (this.DUr != null) {
        paramInt = i + f.a.a.a.lm(28, this.DUr.computeSize());
      }
      i = paramInt;
      if (this.FKf != null) {
        i = paramInt + f.a.a.a.lm(29, this.FKf.computeSize());
      }
      AppMethodBeat.o(125806);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.WithUserList.clear();
        this.FjL.clear();
        this.BlackList.clear();
        this.GroupUser.clear();
        this.FKd.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cpx.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cpx.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
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
        dax localdax = (dax)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(125806);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new iv();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((iv)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cpx.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdax.BaseRequest = ((iv)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(125806);
          return 0;
        case 2: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cpx.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdax.ObjectDesc = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(125806);
          return 0;
        case 3: 
          localdax.WithUserListCount = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(125806);
          return 0;
        case 4: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new crm();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((crm)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cpx.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdax.WithUserList.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(125806);
          return 0;
        case 5: 
          localdax.FJV = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(125806);
          return 0;
        case 6: 
          localdax.FjF = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(125806);
          return 0;
        case 7: 
          localdax.hkN = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(125806);
          return 0;
        case 8: 
          localdax.FJW = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(125806);
          return 0;
        case 9: 
          localdax.GroupCount = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(125806);
          return 0;
        case 10: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dai();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dai)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cpx.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdax.FjL.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(125806);
          return 0;
        case 11: 
          localdax.FJX = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(125806);
          return 0;
        case 12: 
          localdax.ReferId = ((f.a.a.a.a)localObject1).LVo.xG();
          AppMethodBeat.o(125806);
          return 0;
        case 13: 
          localdax.BlackListCount = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(125806);
          return 0;
        case 14: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new crm();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((crm)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cpx.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdax.BlackList.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(125806);
          return 0;
        case 15: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dkl();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dkl)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cpx.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdax.Fus = ((dkl)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(125806);
          return 0;
        case 16: 
          localdax.GroupUserCount = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(125806);
          return 0;
        case 17: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new crm();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((crm)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cpx.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdax.GroupUser.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(125806);
          return 0;
        case 18: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dav();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dav)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cpx.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdax.FJY = ((dav)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(125806);
          return 0;
        case 19: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new daw();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((daw)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cpx.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdax.FjQ = ((daw)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(125806);
          return 0;
        case 20: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dbb();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dbb)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cpx.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdax.SnsRedEnvelops = ((dbb)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(125806);
          return 0;
        case 21: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cpx.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdax.FJZ = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(125806);
          return 0;
        case 22: 
          localdax.FKa = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(125806);
          return 0;
        case 23: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new qv();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((qv)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cpx.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdax.FKb = ((qv)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(125806);
          return 0;
        case 24: 
          localdax.FKc = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(125806);
          return 0;
        case 25: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new btx();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((btx)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cpx.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdax.FKd.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(125806);
          return 0;
        case 26: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new czw();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((czw)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cpx.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdax.FKe = ((czw)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(125806);
          return 0;
        case 27: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cpx.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdax.DUq = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(125806);
          return 0;
        case 28: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cpx.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdax.DUr = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(125806);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new cbh();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((cbh)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cpx.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localdax.FKf = ((cbh)localObject1);
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
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dax
 * JD-Core Version:    0.7.0.1
 */