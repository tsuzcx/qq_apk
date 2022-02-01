package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class aom
  extends dpc
{
  public azn LAA;
  public int LAB;
  public LinkedList<String> LAC;
  public int LAD;
  public cxs LAE;
  public baw LAF;
  public LinkedList<FinderObject> LAG;
  public String LAH;
  public String LAx;
  public bdy LAy;
  public int LAz;
  public FinderContact contact;
  public int continueFlag;
  public int friend_follow_count;
  public com.tencent.mm.bw.b lastBuffer;
  public LinkedList<FinderObject> object;
  public int privateLock;
  
  public aom()
  {
    AppMethodBeat.i(209326);
    this.object = new LinkedList();
    this.LAC = new LinkedList();
    this.LAG = new LinkedList();
    AppMethodBeat.o(209326);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(209327);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new g.a.a.b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(209327);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.ni(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.e(2, 8, this.object);
      if (this.LAx != null) {
        paramVarArgs.e(3, this.LAx);
      }
      if (this.LAy != null)
      {
        paramVarArgs.ni(4, this.LAy.computeSize());
        this.LAy.writeFields(paramVarArgs);
      }
      if (this.contact != null)
      {
        paramVarArgs.ni(5, this.contact.computeSize());
        this.contact.writeFields(paramVarArgs);
      }
      paramVarArgs.aM(6, this.LAz);
      paramVarArgs.aM(7, this.continueFlag);
      if (this.LAA != null)
      {
        paramVarArgs.ni(8, this.LAA.computeSize());
        this.LAA.writeFields(paramVarArgs);
      }
      paramVarArgs.aM(9, this.LAB);
      if (this.lastBuffer != null) {
        paramVarArgs.c(10, this.lastBuffer);
      }
      paramVarArgs.aM(11, this.friend_follow_count);
      paramVarArgs.e(12, 1, this.LAC);
      paramVarArgs.aM(13, this.LAD);
      if (this.LAE != null)
      {
        paramVarArgs.ni(14, this.LAE.computeSize());
        this.LAE.writeFields(paramVarArgs);
      }
      if (this.LAF != null)
      {
        paramVarArgs.ni(15, this.LAF.computeSize());
        this.LAF.writeFields(paramVarArgs);
      }
      paramVarArgs.e(16, 8, this.LAG);
      paramVarArgs.aM(17, this.privateLock);
      if (this.LAH != null) {
        paramVarArgs.e(18, this.LAH);
      }
      AppMethodBeat.o(209327);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1926;
      }
    }
    label1926:
    for (paramInt = g.a.a.a.nh(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.a.c(2, 8, this.object);
      paramInt = i;
      if (this.LAx != null) {
        paramInt = i + g.a.a.b.b.a.f(3, this.LAx);
      }
      i = paramInt;
      if (this.LAy != null) {
        i = paramInt + g.a.a.a.nh(4, this.LAy.computeSize());
      }
      paramInt = i;
      if (this.contact != null) {
        paramInt = i + g.a.a.a.nh(5, this.contact.computeSize());
      }
      i = paramInt + g.a.a.b.b.a.bu(6, this.LAz) + g.a.a.b.b.a.bu(7, this.continueFlag);
      paramInt = i;
      if (this.LAA != null) {
        paramInt = i + g.a.a.a.nh(8, this.LAA.computeSize());
      }
      i = paramInt + g.a.a.b.b.a.bu(9, this.LAB);
      paramInt = i;
      if (this.lastBuffer != null) {
        paramInt = i + g.a.a.b.b.a.b(10, this.lastBuffer);
      }
      i = paramInt + g.a.a.b.b.a.bu(11, this.friend_follow_count) + g.a.a.a.c(12, 1, this.LAC) + g.a.a.b.b.a.bu(13, this.LAD);
      paramInt = i;
      if (this.LAE != null) {
        paramInt = i + g.a.a.a.nh(14, this.LAE.computeSize());
      }
      i = paramInt;
      if (this.LAF != null) {
        i = paramInt + g.a.a.a.nh(15, this.LAF.computeSize());
      }
      i = i + g.a.a.a.c(16, 8, this.LAG) + g.a.a.b.b.a.bu(17, this.privateLock);
      paramInt = i;
      if (this.LAH != null) {
        paramInt = i + g.a.a.b.b.a.f(18, this.LAH);
      }
      AppMethodBeat.o(209327);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.object.clear();
        this.LAC.clear();
        this.LAG.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = dpc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dpc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new g.a.a.b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(209327);
          throw paramVarArgs;
        }
        AppMethodBeat.o(209327);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        aom localaom = (aom)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(209327);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new BaseResponse();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((BaseResponse)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localaom.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(209327);
          return 0;
        case 2: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new FinderObject();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((FinderObject)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localaom.object.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(209327);
          return 0;
        case 3: 
          localaom.LAx = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(209327);
          return 0;
        case 4: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bdy();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bdy)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localaom.LAy = ((bdy)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(209327);
          return 0;
        case 5: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new FinderContact();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((FinderContact)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localaom.contact = ((FinderContact)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(209327);
          return 0;
        case 6: 
          localaom.LAz = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(209327);
          return 0;
        case 7: 
          localaom.continueFlag = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(209327);
          return 0;
        case 8: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new azn();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((azn)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localaom.LAA = ((azn)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(209327);
          return 0;
        case 9: 
          localaom.LAB = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(209327);
          return 0;
        case 10: 
          localaom.lastBuffer = ((g.a.a.a.a)localObject1).UbS.hPo();
          AppMethodBeat.o(209327);
          return 0;
        case 11: 
          localaom.friend_follow_count = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(209327);
          return 0;
        case 12: 
          localaom.LAC.add(((g.a.a.a.a)localObject1).UbS.readString());
          AppMethodBeat.o(209327);
          return 0;
        case 13: 
          localaom.LAD = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(209327);
          return 0;
        case 14: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cxs();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cxs)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localaom.LAE = ((cxs)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(209327);
          return 0;
        case 15: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new baw();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((baw)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localaom.LAF = ((baw)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(209327);
          return 0;
        case 16: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new FinderObject();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((FinderObject)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localaom.LAG.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(209327);
          return 0;
        case 17: 
          localaom.privateLock = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(209327);
          return 0;
        }
        localaom.LAH = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(209327);
        return 0;
      }
      AppMethodBeat.o(209327);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aom
 * JD-Core Version:    0.7.0.1
 */