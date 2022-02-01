package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class atl
  extends esc
{
  public String ZDS;
  public byj ZDT;
  public int ZDU;
  public bqt ZDV;
  public LinkedList<String> ZDW;
  public int ZDX;
  public dzk ZDY;
  public btc ZDZ;
  public LinkedList<FinderObject> ZEa;
  public String ZEb;
  public FinderContact contact;
  public int continueFlag;
  public int fans_count;
  public int friend_follow_count;
  public com.tencent.mm.bx.b lastBuffer;
  public LinkedList<FinderObject> object;
  public int privateLock;
  
  public atl()
  {
    AppMethodBeat.i(258149);
    this.object = new LinkedList();
    this.ZDW = new LinkedList();
    this.ZEa = new LinkedList();
    AppMethodBeat.o(258149);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(258152);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new i.a.a.b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(258152);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.qD(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.e(2, 8, this.object);
      if (this.ZDS != null) {
        paramVarArgs.g(3, this.ZDS);
      }
      if (this.ZDT != null)
      {
        paramVarArgs.qD(4, this.ZDT.computeSize());
        this.ZDT.writeFields(paramVarArgs);
      }
      if (this.contact != null)
      {
        paramVarArgs.qD(5, this.contact.computeSize());
        this.contact.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(6, this.ZDU);
      paramVarArgs.bS(7, this.continueFlag);
      if (this.ZDV != null)
      {
        paramVarArgs.qD(8, this.ZDV.computeSize());
        this.ZDV.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(9, this.fans_count);
      if (this.lastBuffer != null) {
        paramVarArgs.d(10, this.lastBuffer);
      }
      paramVarArgs.bS(11, this.friend_follow_count);
      paramVarArgs.e(12, 1, this.ZDW);
      paramVarArgs.bS(13, this.ZDX);
      if (this.ZDY != null)
      {
        paramVarArgs.qD(14, this.ZDY.computeSize());
        this.ZDY.writeFields(paramVarArgs);
      }
      if (this.ZDZ != null)
      {
        paramVarArgs.qD(15, this.ZDZ.computeSize());
        this.ZDZ.writeFields(paramVarArgs);
      }
      paramVarArgs.e(16, 8, this.ZEa);
      paramVarArgs.bS(17, this.privateLock);
      if (this.ZEb != null) {
        paramVarArgs.g(18, this.ZEb);
      }
      AppMethodBeat.o(258152);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1750;
      }
    }
    label1750:
    for (paramInt = i.a.a.a.qC(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + i.a.a.a.c(2, 8, this.object);
      paramInt = i;
      if (this.ZDS != null) {
        paramInt = i + i.a.a.b.b.a.h(3, this.ZDS);
      }
      i = paramInt;
      if (this.ZDT != null) {
        i = paramInt + i.a.a.a.qC(4, this.ZDT.computeSize());
      }
      paramInt = i;
      if (this.contact != null) {
        paramInt = i + i.a.a.a.qC(5, this.contact.computeSize());
      }
      i = paramInt + i.a.a.b.b.a.cJ(6, this.ZDU) + i.a.a.b.b.a.cJ(7, this.continueFlag);
      paramInt = i;
      if (this.ZDV != null) {
        paramInt = i + i.a.a.a.qC(8, this.ZDV.computeSize());
      }
      i = paramInt + i.a.a.b.b.a.cJ(9, this.fans_count);
      paramInt = i;
      if (this.lastBuffer != null) {
        paramInt = i + i.a.a.b.b.a.c(10, this.lastBuffer);
      }
      i = paramInt + i.a.a.b.b.a.cJ(11, this.friend_follow_count) + i.a.a.a.c(12, 1, this.ZDW) + i.a.a.b.b.a.cJ(13, this.ZDX);
      paramInt = i;
      if (this.ZDY != null) {
        paramInt = i + i.a.a.a.qC(14, this.ZDY.computeSize());
      }
      i = paramInt;
      if (this.ZDZ != null) {
        i = paramInt + i.a.a.a.qC(15, this.ZDZ.computeSize());
      }
      i = i + i.a.a.a.c(16, 8, this.ZEa) + i.a.a.b.b.a.cJ(17, this.privateLock);
      paramInt = i;
      if (this.ZEb != null) {
        paramInt = i + i.a.a.b.b.a.h(18, this.ZEb);
      }
      AppMethodBeat.o(258152);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.object.clear();
        this.ZDW.clear();
        this.ZEa.clear();
        paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = esc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = esc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new i.a.a.b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(258152);
          throw paramVarArgs;
        }
        AppMethodBeat.o(258152);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        atl localatl = (atl)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(258152);
          return -1;
        case 1: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new kd();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((kd)localObject2).parseFrom((byte[])localObject1);
            }
            localatl.BaseResponse = ((kd)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(258152);
          return 0;
        case 2: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new FinderObject();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((FinderObject)localObject2).parseFrom((byte[])localObject1);
            }
            localatl.object.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(258152);
          return 0;
        case 3: 
          localatl.ZDS = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(258152);
          return 0;
        case 4: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new byj();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((byj)localObject2).parseFrom((byte[])localObject1);
            }
            localatl.ZDT = ((byj)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(258152);
          return 0;
        case 5: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new FinderContact();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((FinderContact)localObject2).parseFrom((byte[])localObject1);
            }
            localatl.contact = ((FinderContact)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(258152);
          return 0;
        case 6: 
          localatl.ZDU = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(258152);
          return 0;
        case 7: 
          localatl.continueFlag = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(258152);
          return 0;
        case 8: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new bqt();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((bqt)localObject2).parseFrom((byte[])localObject1);
            }
            localatl.ZDV = ((bqt)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(258152);
          return 0;
        case 9: 
          localatl.fans_count = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(258152);
          return 0;
        case 10: 
          localatl.lastBuffer = ((i.a.a.a.a)localObject1).ajGk.kFX();
          AppMethodBeat.o(258152);
          return 0;
        case 11: 
          localatl.friend_follow_count = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(258152);
          return 0;
        case 12: 
          localatl.ZDW.add(((i.a.a.a.a)localObject1).ajGk.readString());
          AppMethodBeat.o(258152);
          return 0;
        case 13: 
          localatl.ZDX = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(258152);
          return 0;
        case 14: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new dzk();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((dzk)localObject2).parseFrom((byte[])localObject1);
            }
            localatl.ZDY = ((dzk)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(258152);
          return 0;
        case 15: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new btc();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((btc)localObject2).parseFrom((byte[])localObject1);
            }
            localatl.ZDZ = ((btc)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(258152);
          return 0;
        case 16: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new FinderObject();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((FinderObject)localObject2).parseFrom((byte[])localObject1);
            }
            localatl.ZEa.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(258152);
          return 0;
        case 17: 
          localatl.privateLock = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(258152);
          return 0;
        }
        localatl.ZEb = ((i.a.a.a.a)localObject1).ajGk.readString();
        AppMethodBeat.o(258152);
        return 0;
      }
      AppMethodBeat.o(258152);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.atl
 * JD-Core Version:    0.7.0.1
 */