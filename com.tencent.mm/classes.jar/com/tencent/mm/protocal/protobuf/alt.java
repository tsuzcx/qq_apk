package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class alt
  extends cwj
{
  public String GDU;
  public atc GDV;
  public int GDW;
  public aqk GDX;
  public int GDY;
  public int GDZ;
  public LinkedList<String> GEa;
  public int GEb;
  public chl GEc;
  public arc GEd;
  public LinkedList<FinderObject> GEe;
  public String GEf;
  public FinderContact contact;
  public int continueFlag;
  public com.tencent.mm.bw.b lastBuffer;
  public LinkedList<FinderObject> object;
  public int privateLock;
  
  public alt()
  {
    AppMethodBeat.i(189301);
    this.object = new LinkedList();
    this.GEa = new LinkedList();
    this.GEe = new LinkedList();
    AppMethodBeat.o(189301);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(189302);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new f.a.a.b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(189302);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.lJ(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.e(2, 8, this.object);
      if (this.GDU != null) {
        paramVarArgs.d(3, this.GDU);
      }
      if (this.GDV != null)
      {
        paramVarArgs.lJ(4, this.GDV.computeSize());
        this.GDV.writeFields(paramVarArgs);
      }
      if (this.contact != null)
      {
        paramVarArgs.lJ(5, this.contact.computeSize());
        this.contact.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(6, this.GDW);
      paramVarArgs.aS(7, this.continueFlag);
      if (this.GDX != null)
      {
        paramVarArgs.lJ(8, this.GDX.computeSize());
        this.GDX.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(9, this.GDY);
      if (this.lastBuffer != null) {
        paramVarArgs.c(10, this.lastBuffer);
      }
      paramVarArgs.aS(11, this.GDZ);
      paramVarArgs.e(12, 1, this.GEa);
      paramVarArgs.aS(13, this.GEb);
      if (this.GEc != null)
      {
        paramVarArgs.lJ(14, this.GEc.computeSize());
        this.GEc.writeFields(paramVarArgs);
      }
      if (this.GEd != null)
      {
        paramVarArgs.lJ(15, this.GEd.computeSize());
        this.GEd.writeFields(paramVarArgs);
      }
      paramVarArgs.e(16, 8, this.GEe);
      paramVarArgs.aS(17, this.privateLock);
      if (this.GEf != null) {
        paramVarArgs.d(18, this.GEf);
      }
      AppMethodBeat.o(189302);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1926;
      }
    }
    label1926:
    for (paramInt = f.a.a.a.lI(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.a.c(2, 8, this.object);
      paramInt = i;
      if (this.GDU != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.GDU);
      }
      i = paramInt;
      if (this.GDV != null) {
        i = paramInt + f.a.a.a.lI(4, this.GDV.computeSize());
      }
      paramInt = i;
      if (this.contact != null) {
        paramInt = i + f.a.a.a.lI(5, this.contact.computeSize());
      }
      i = paramInt + f.a.a.b.b.a.bz(6, this.GDW) + f.a.a.b.b.a.bz(7, this.continueFlag);
      paramInt = i;
      if (this.GDX != null) {
        paramInt = i + f.a.a.a.lI(8, this.GDX.computeSize());
      }
      i = paramInt + f.a.a.b.b.a.bz(9, this.GDY);
      paramInt = i;
      if (this.lastBuffer != null) {
        paramInt = i + f.a.a.b.b.a.b(10, this.lastBuffer);
      }
      i = paramInt + f.a.a.b.b.a.bz(11, this.GDZ) + f.a.a.a.c(12, 1, this.GEa) + f.a.a.b.b.a.bz(13, this.GEb);
      paramInt = i;
      if (this.GEc != null) {
        paramInt = i + f.a.a.a.lI(14, this.GEc.computeSize());
      }
      i = paramInt;
      if (this.GEd != null) {
        i = paramInt + f.a.a.a.lI(15, this.GEd.computeSize());
      }
      i = i + f.a.a.a.c(16, 8, this.GEe) + f.a.a.b.b.a.bz(17, this.privateLock);
      paramInt = i;
      if (this.GEf != null) {
        paramInt = i + f.a.a.b.b.a.e(18, this.GEf);
      }
      AppMethodBeat.o(189302);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.object.clear();
        this.GEa.clear();
        this.GEe.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cwj.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cwj.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new f.a.a.b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(189302);
          throw paramVarArgs;
        }
        AppMethodBeat.o(189302);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        alt localalt = (alt)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(189302);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new BaseResponse();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((BaseResponse)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localalt.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(189302);
          return 0;
        case 2: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new FinderObject();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((FinderObject)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localalt.object.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(189302);
          return 0;
        case 3: 
          localalt.GDU = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(189302);
          return 0;
        case 4: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new atc();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((atc)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localalt.GDV = ((atc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(189302);
          return 0;
        case 5: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new FinderContact();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((FinderContact)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localalt.contact = ((FinderContact)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(189302);
          return 0;
        case 6: 
          localalt.GDW = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(189302);
          return 0;
        case 7: 
          localalt.continueFlag = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(189302);
          return 0;
        case 8: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new aqk();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((aqk)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localalt.GDX = ((aqk)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(189302);
          return 0;
        case 9: 
          localalt.GDY = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(189302);
          return 0;
        case 10: 
          localalt.lastBuffer = ((f.a.a.a.a)localObject1).OmT.gCk();
          AppMethodBeat.o(189302);
          return 0;
        case 11: 
          localalt.GDZ = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(189302);
          return 0;
        case 12: 
          localalt.GEa.add(((f.a.a.a.a)localObject1).OmT.readString());
          AppMethodBeat.o(189302);
          return 0;
        case 13: 
          localalt.GEb = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(189302);
          return 0;
        case 14: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new chl();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((chl)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localalt.GEc = ((chl)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(189302);
          return 0;
        case 15: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new arc();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((arc)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localalt.GEd = ((arc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(189302);
          return 0;
        case 16: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new FinderObject();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((FinderObject)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localalt.GEe.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(189302);
          return 0;
        case 17: 
          localalt.privateLock = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(189302);
          return 0;
        }
        localalt.GEf = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(189302);
        return 0;
      }
      AppMethodBeat.o(189302);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.alt
 * JD-Core Version:    0.7.0.1
 */