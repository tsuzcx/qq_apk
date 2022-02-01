package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class ean
  extends dop
{
  public LinkedList<dqi> BlackList;
  public int BlackListCount;
  public int GroupCount;
  public LinkedList<dqi> GroupUser;
  public int GroupUserCount;
  public SKBuiltinBuffer_t KLP;
  public SKBuiltinBuffer_t KLQ;
  public ekv MID;
  public int MZR;
  public int MZS;
  public int MZT;
  public eal MZU;
  public SKBuiltinBuffer_t MZV;
  public String MZW;
  public tt MZX;
  public int MZY;
  public LinkedList<cmz> MZZ;
  public int MsV;
  public LinkedList<dzw> Mtb;
  public eam Mtg;
  public dzk Naa;
  public cwz Nab;
  public SKBuiltinBuffer_t ObjectDesc;
  public long ReferId;
  public ear SnsRedEnvelops;
  public LinkedList<dqi> WithUserList;
  public int WithUserListCount;
  public String izX;
  
  public ean()
  {
    AppMethodBeat.i(125805);
    this.WithUserList = new LinkedList();
    this.Mtb = new LinkedList();
    this.BlackList = new LinkedList();
    this.GroupUser = new LinkedList();
    this.MZZ = new LinkedList();
    AppMethodBeat.o(125805);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(125806);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.ObjectDesc == null)
      {
        paramVarArgs = new b("Not all required fields were included: ObjectDesc");
        AppMethodBeat.o(125806);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.ni(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.ObjectDesc != null)
      {
        paramVarArgs.ni(2, this.ObjectDesc.computeSize());
        this.ObjectDesc.writeFields(paramVarArgs);
      }
      paramVarArgs.aM(3, this.WithUserListCount);
      paramVarArgs.e(4, 8, this.WithUserList);
      paramVarArgs.aM(5, this.MZR);
      paramVarArgs.aM(6, this.MsV);
      if (this.izX != null) {
        paramVarArgs.e(7, this.izX);
      }
      paramVarArgs.aM(8, this.MZS);
      paramVarArgs.aM(9, this.GroupCount);
      paramVarArgs.e(10, 8, this.Mtb);
      paramVarArgs.aM(11, this.MZT);
      paramVarArgs.bb(12, this.ReferId);
      paramVarArgs.aM(13, this.BlackListCount);
      paramVarArgs.e(14, 8, this.BlackList);
      if (this.MID != null)
      {
        paramVarArgs.ni(15, this.MID.computeSize());
        this.MID.writeFields(paramVarArgs);
      }
      paramVarArgs.aM(16, this.GroupUserCount);
      paramVarArgs.e(17, 8, this.GroupUser);
      if (this.MZU != null)
      {
        paramVarArgs.ni(18, this.MZU.computeSize());
        this.MZU.writeFields(paramVarArgs);
      }
      if (this.Mtg != null)
      {
        paramVarArgs.ni(19, this.Mtg.computeSize());
        this.Mtg.writeFields(paramVarArgs);
      }
      if (this.SnsRedEnvelops != null)
      {
        paramVarArgs.ni(20, this.SnsRedEnvelops.computeSize());
        this.SnsRedEnvelops.writeFields(paramVarArgs);
      }
      if (this.MZV != null)
      {
        paramVarArgs.ni(21, this.MZV.computeSize());
        this.MZV.writeFields(paramVarArgs);
      }
      if (this.MZW != null) {
        paramVarArgs.e(22, this.MZW);
      }
      if (this.MZX != null)
      {
        paramVarArgs.ni(23, this.MZX.computeSize());
        this.MZX.writeFields(paramVarArgs);
      }
      paramVarArgs.aM(24, this.MZY);
      paramVarArgs.e(25, 8, this.MZZ);
      if (this.Naa != null)
      {
        paramVarArgs.ni(26, this.Naa.computeSize());
        this.Naa.writeFields(paramVarArgs);
      }
      if (this.KLP != null)
      {
        paramVarArgs.ni(27, this.KLP.computeSize());
        this.KLP.writeFields(paramVarArgs);
      }
      if (this.KLQ != null)
      {
        paramVarArgs.ni(28, this.KLQ.computeSize());
        this.KLQ.writeFields(paramVarArgs);
      }
      if (this.Nab != null)
      {
        paramVarArgs.ni(29, this.Nab.computeSize());
        this.Nab.writeFields(paramVarArgs);
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
    for (paramInt = g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.ObjectDesc != null) {
        i = paramInt + g.a.a.a.nh(2, this.ObjectDesc.computeSize());
      }
      i = i + g.a.a.b.b.a.bu(3, this.WithUserListCount) + g.a.a.a.c(4, 8, this.WithUserList) + g.a.a.b.b.a.bu(5, this.MZR) + g.a.a.b.b.a.bu(6, this.MsV);
      paramInt = i;
      if (this.izX != null) {
        paramInt = i + g.a.a.b.b.a.f(7, this.izX);
      }
      i = paramInt + g.a.a.b.b.a.bu(8, this.MZS) + g.a.a.b.b.a.bu(9, this.GroupCount) + g.a.a.a.c(10, 8, this.Mtb) + g.a.a.b.b.a.bu(11, this.MZT) + g.a.a.b.b.a.r(12, this.ReferId) + g.a.a.b.b.a.bu(13, this.BlackListCount) + g.a.a.a.c(14, 8, this.BlackList);
      paramInt = i;
      if (this.MID != null) {
        paramInt = i + g.a.a.a.nh(15, this.MID.computeSize());
      }
      i = paramInt + g.a.a.b.b.a.bu(16, this.GroupUserCount) + g.a.a.a.c(17, 8, this.GroupUser);
      paramInt = i;
      if (this.MZU != null) {
        paramInt = i + g.a.a.a.nh(18, this.MZU.computeSize());
      }
      i = paramInt;
      if (this.Mtg != null) {
        i = paramInt + g.a.a.a.nh(19, this.Mtg.computeSize());
      }
      paramInt = i;
      if (this.SnsRedEnvelops != null) {
        paramInt = i + g.a.a.a.nh(20, this.SnsRedEnvelops.computeSize());
      }
      i = paramInt;
      if (this.MZV != null) {
        i = paramInt + g.a.a.a.nh(21, this.MZV.computeSize());
      }
      paramInt = i;
      if (this.MZW != null) {
        paramInt = i + g.a.a.b.b.a.f(22, this.MZW);
      }
      i = paramInt;
      if (this.MZX != null) {
        i = paramInt + g.a.a.a.nh(23, this.MZX.computeSize());
      }
      i = i + g.a.a.b.b.a.bu(24, this.MZY) + g.a.a.a.c(25, 8, this.MZZ);
      paramInt = i;
      if (this.Naa != null) {
        paramInt = i + g.a.a.a.nh(26, this.Naa.computeSize());
      }
      i = paramInt;
      if (this.KLP != null) {
        i = paramInt + g.a.a.a.nh(27, this.KLP.computeSize());
      }
      paramInt = i;
      if (this.KLQ != null) {
        paramInt = i + g.a.a.a.nh(28, this.KLQ.computeSize());
      }
      i = paramInt;
      if (this.Nab != null) {
        i = paramInt + g.a.a.a.nh(29, this.Nab.computeSize());
      }
      AppMethodBeat.o(125806);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.WithUserList.clear();
        this.Mtb.clear();
        this.BlackList.clear();
        this.GroupUser.clear();
        this.MZZ.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = dop.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dop.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
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
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        ean localean = (ean)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(125806);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new jr();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((jr)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dop.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localean.BaseRequest = ((jr)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(125806);
          return 0;
        case 2: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dop.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localean.ObjectDesc = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(125806);
          return 0;
        case 3: 
          localean.WithUserListCount = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(125806);
          return 0;
        case 4: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dqi();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dqi)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dop.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localean.WithUserList.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(125806);
          return 0;
        case 5: 
          localean.MZR = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(125806);
          return 0;
        case 6: 
          localean.MsV = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(125806);
          return 0;
        case 7: 
          localean.izX = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(125806);
          return 0;
        case 8: 
          localean.MZS = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(125806);
          return 0;
        case 9: 
          localean.GroupCount = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(125806);
          return 0;
        case 10: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dzw();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dzw)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dop.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localean.Mtb.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(125806);
          return 0;
        case 11: 
          localean.MZT = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(125806);
          return 0;
        case 12: 
          localean.ReferId = ((g.a.a.a.a)localObject1).UbS.zl();
          AppMethodBeat.o(125806);
          return 0;
        case 13: 
          localean.BlackListCount = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(125806);
          return 0;
        case 14: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dqi();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dqi)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dop.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localean.BlackList.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(125806);
          return 0;
        case 15: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ekv();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ekv)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dop.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localean.MID = ((ekv)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(125806);
          return 0;
        case 16: 
          localean.GroupUserCount = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(125806);
          return 0;
        case 17: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dqi();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dqi)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dop.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localean.GroupUser.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(125806);
          return 0;
        case 18: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new eal();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((eal)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dop.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localean.MZU = ((eal)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(125806);
          return 0;
        case 19: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new eam();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((eam)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dop.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localean.Mtg = ((eam)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(125806);
          return 0;
        case 20: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ear();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ear)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dop.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localean.SnsRedEnvelops = ((ear)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(125806);
          return 0;
        case 21: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dop.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localean.MZV = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(125806);
          return 0;
        case 22: 
          localean.MZW = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(125806);
          return 0;
        case 23: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new tt();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((tt)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dop.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localean.MZX = ((tt)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(125806);
          return 0;
        case 24: 
          localean.MZY = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(125806);
          return 0;
        case 25: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cmz();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cmz)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dop.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localean.MZZ.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(125806);
          return 0;
        case 26: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dzk();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dzk)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dop.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localean.Naa = ((dzk)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(125806);
          return 0;
        case 27: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dop.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localean.KLP = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(125806);
          return 0;
        case 28: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dop.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localean.KLQ = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(125806);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new cwz();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((cwz)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dop.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localean.Nab = ((cwz)localObject1);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ean
 * JD-Core Version:    0.7.0.1
 */