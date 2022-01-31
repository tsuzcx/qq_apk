package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import java.util.LinkedList;

public final class ceo
  extends buy
{
  public LinkedList<bwc> BlackList;
  public int BlackListCount;
  public int GroupCount;
  public LinkedList<bwc> GroupUser;
  public int GroupUserCount;
  public SKBuiltinBuffer_t ObjectDesc;
  public long ReferId;
  public ces SnsRedEnvelops;
  public LinkedList<bwc> WithUserList;
  public int WithUserListCount;
  public String pIw;
  public SKBuiltinBuffer_t wsr;
  public SKBuiltinBuffer_t wss;
  public clw xBi;
  public int xOR;
  public int xOS;
  public int xOT;
  public cem xOU;
  public SKBuiltinBuffer_t xOV;
  public String xOW;
  public og xOX;
  public int xOY;
  public LinkedList<bcq> xOZ;
  public cdo xPa;
  public cen xsA;
  public int xsp;
  public LinkedList<cdz> xsv;
  
  public ceo()
  {
    AppMethodBeat.i(94595);
    this.WithUserList = new LinkedList();
    this.xsv = new LinkedList();
    this.BlackList = new LinkedList();
    this.GroupUser = new LinkedList();
    this.xOZ = new LinkedList();
    AppMethodBeat.o(94595);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(94596);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.ObjectDesc == null)
      {
        paramVarArgs = new b("Not all required fields were included: ObjectDesc");
        AppMethodBeat.o(94596);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.iQ(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.ObjectDesc != null)
      {
        paramVarArgs.iQ(2, this.ObjectDesc.computeSize());
        this.ObjectDesc.writeFields(paramVarArgs);
      }
      paramVarArgs.aO(3, this.WithUserListCount);
      paramVarArgs.e(4, 8, this.WithUserList);
      paramVarArgs.aO(5, this.xOR);
      paramVarArgs.aO(6, this.xsp);
      if (this.pIw != null) {
        paramVarArgs.e(7, this.pIw);
      }
      paramVarArgs.aO(8, this.xOS);
      paramVarArgs.aO(9, this.GroupCount);
      paramVarArgs.e(10, 8, this.xsv);
      paramVarArgs.aO(11, this.xOT);
      paramVarArgs.am(12, this.ReferId);
      paramVarArgs.aO(13, this.BlackListCount);
      paramVarArgs.e(14, 8, this.BlackList);
      if (this.xBi != null)
      {
        paramVarArgs.iQ(15, this.xBi.computeSize());
        this.xBi.writeFields(paramVarArgs);
      }
      paramVarArgs.aO(16, this.GroupUserCount);
      paramVarArgs.e(17, 8, this.GroupUser);
      if (this.xOU != null)
      {
        paramVarArgs.iQ(18, this.xOU.computeSize());
        this.xOU.writeFields(paramVarArgs);
      }
      if (this.xsA != null)
      {
        paramVarArgs.iQ(19, this.xsA.computeSize());
        this.xsA.writeFields(paramVarArgs);
      }
      if (this.SnsRedEnvelops != null)
      {
        paramVarArgs.iQ(20, this.SnsRedEnvelops.computeSize());
        this.SnsRedEnvelops.writeFields(paramVarArgs);
      }
      if (this.xOV != null)
      {
        paramVarArgs.iQ(21, this.xOV.computeSize());
        this.xOV.writeFields(paramVarArgs);
      }
      if (this.xOW != null) {
        paramVarArgs.e(22, this.xOW);
      }
      if (this.xOX != null)
      {
        paramVarArgs.iQ(23, this.xOX.computeSize());
        this.xOX.writeFields(paramVarArgs);
      }
      paramVarArgs.aO(24, this.xOY);
      paramVarArgs.e(25, 8, this.xOZ);
      if (this.xPa != null)
      {
        paramVarArgs.iQ(26, this.xPa.computeSize());
        this.xPa.writeFields(paramVarArgs);
      }
      if (this.wsr != null)
      {
        paramVarArgs.iQ(27, this.wsr.computeSize());
        this.wsr.writeFields(paramVarArgs);
      }
      if (this.wss != null)
      {
        paramVarArgs.iQ(28, this.wss.computeSize());
        this.wss.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(94596);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label3178;
      }
    }
    label3178:
    for (paramInt = e.a.a.a.iP(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.ObjectDesc != null) {
        i = paramInt + e.a.a.a.iP(2, this.ObjectDesc.computeSize());
      }
      i = i + e.a.a.b.b.a.bl(3, this.WithUserListCount) + e.a.a.a.c(4, 8, this.WithUserList) + e.a.a.b.b.a.bl(5, this.xOR) + e.a.a.b.b.a.bl(6, this.xsp);
      paramInt = i;
      if (this.pIw != null) {
        paramInt = i + e.a.a.b.b.a.f(7, this.pIw);
      }
      i = paramInt + e.a.a.b.b.a.bl(8, this.xOS) + e.a.a.b.b.a.bl(9, this.GroupCount) + e.a.a.a.c(10, 8, this.xsv) + e.a.a.b.b.a.bl(11, this.xOT) + e.a.a.b.b.a.p(12, this.ReferId) + e.a.a.b.b.a.bl(13, this.BlackListCount) + e.a.a.a.c(14, 8, this.BlackList);
      paramInt = i;
      if (this.xBi != null) {
        paramInt = i + e.a.a.a.iP(15, this.xBi.computeSize());
      }
      i = paramInt + e.a.a.b.b.a.bl(16, this.GroupUserCount) + e.a.a.a.c(17, 8, this.GroupUser);
      paramInt = i;
      if (this.xOU != null) {
        paramInt = i + e.a.a.a.iP(18, this.xOU.computeSize());
      }
      i = paramInt;
      if (this.xsA != null) {
        i = paramInt + e.a.a.a.iP(19, this.xsA.computeSize());
      }
      paramInt = i;
      if (this.SnsRedEnvelops != null) {
        paramInt = i + e.a.a.a.iP(20, this.SnsRedEnvelops.computeSize());
      }
      i = paramInt;
      if (this.xOV != null) {
        i = paramInt + e.a.a.a.iP(21, this.xOV.computeSize());
      }
      paramInt = i;
      if (this.xOW != null) {
        paramInt = i + e.a.a.b.b.a.f(22, this.xOW);
      }
      i = paramInt;
      if (this.xOX != null) {
        i = paramInt + e.a.a.a.iP(23, this.xOX.computeSize());
      }
      i = i + e.a.a.b.b.a.bl(24, this.xOY) + e.a.a.a.c(25, 8, this.xOZ);
      paramInt = i;
      if (this.xPa != null) {
        paramInt = i + e.a.a.a.iP(26, this.xPa.computeSize());
      }
      i = paramInt;
      if (this.wsr != null) {
        i = paramInt + e.a.a.a.iP(27, this.wsr.computeSize());
      }
      paramInt = i;
      if (this.wss != null) {
        paramInt = i + e.a.a.a.iP(28, this.wss.computeSize());
      }
      AppMethodBeat.o(94596);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.WithUserList.clear();
        this.xsv.clear();
        this.BlackList.clear();
        this.GroupUser.clear();
        this.xOZ.clear();
        paramVarArgs = new e.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = buy.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = buy.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        if (this.ObjectDesc == null)
        {
          paramVarArgs = new b("Not all required fields were included: ObjectDesc");
          AppMethodBeat.o(94596);
          throw paramVarArgs;
        }
        AppMethodBeat.o(94596);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        ceo localceo = (ceo)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(94596);
          return -1;
        case 1: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new hq();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((hq)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, buy.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localceo.BaseRequest = ((hq)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(94596);
          return 0;
        case 2: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, buy.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localceo.ObjectDesc = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(94596);
          return 0;
        case 3: 
          localceo.WithUserListCount = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(94596);
          return 0;
        case 4: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bwc();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bwc)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, buy.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localceo.WithUserList.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(94596);
          return 0;
        case 5: 
          localceo.xOR = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(94596);
          return 0;
        case 6: 
          localceo.xsp = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(94596);
          return 0;
        case 7: 
          localceo.pIw = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(94596);
          return 0;
        case 8: 
          localceo.xOS = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(94596);
          return 0;
        case 9: 
          localceo.GroupCount = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(94596);
          return 0;
        case 10: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cdz();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cdz)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, buy.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localceo.xsv.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(94596);
          return 0;
        case 11: 
          localceo.xOT = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(94596);
          return 0;
        case 12: 
          localceo.ReferId = ((e.a.a.a.a)localObject1).CLY.sm();
          AppMethodBeat.o(94596);
          return 0;
        case 13: 
          localceo.BlackListCount = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(94596);
          return 0;
        case 14: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bwc();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bwc)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, buy.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localceo.BlackList.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(94596);
          return 0;
        case 15: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new clw();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((clw)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, buy.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localceo.xBi = ((clw)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(94596);
          return 0;
        case 16: 
          localceo.GroupUserCount = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(94596);
          return 0;
        case 17: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bwc();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bwc)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, buy.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localceo.GroupUser.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(94596);
          return 0;
        case 18: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cem();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cem)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, buy.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localceo.xOU = ((cem)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(94596);
          return 0;
        case 19: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cen();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cen)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, buy.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localceo.xsA = ((cen)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(94596);
          return 0;
        case 20: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ces();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ces)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, buy.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localceo.SnsRedEnvelops = ((ces)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(94596);
          return 0;
        case 21: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, buy.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localceo.xOV = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(94596);
          return 0;
        case 22: 
          localceo.xOW = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(94596);
          return 0;
        case 23: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new og();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((og)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, buy.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localceo.xOX = ((og)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(94596);
          return 0;
        case 24: 
          localceo.xOY = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(94596);
          return 0;
        case 25: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bcq();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bcq)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, buy.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localceo.xOZ.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(94596);
          return 0;
        case 26: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cdo();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cdo)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, buy.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localceo.xPa = ((cdo)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(94596);
          return 0;
        case 27: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, buy.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localceo.wsr = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(94596);
          return 0;
        }
        paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new SKBuiltinBuffer_t();
          localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, buy.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
          localceo.wss = ((SKBuiltinBuffer_t)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(94596);
        return 0;
      }
      AppMethodBeat.o(94596);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ceo
 * JD-Core Version:    0.7.0.1
 */