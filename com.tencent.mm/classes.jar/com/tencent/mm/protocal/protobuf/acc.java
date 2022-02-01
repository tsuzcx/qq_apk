package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class acc
  extends cwj
{
  public SKBuiltinBuffer_t FNK;
  public LinkedList<bzn> FNl;
  public cxn FNm;
  public String GnN;
  public String GnO;
  public cxn GtV;
  public cxn GtY;
  public cxn GtZ;
  public int fNf;
  
  public acc()
  {
    AppMethodBeat.i(101799);
    this.FNl = new LinkedList();
    AppMethodBeat.o(101799);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(101800);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(101800);
        throw paramVarArgs;
      }
      if (this.GtV == null)
      {
        paramVarArgs = new b("Not all required fields were included: Topic");
        AppMethodBeat.o(101800);
        throw paramVarArgs;
      }
      if (this.GtY == null)
      {
        paramVarArgs = new b("Not all required fields were included: PYInitial");
        AppMethodBeat.o(101800);
        throw paramVarArgs;
      }
      if (this.GtZ == null)
      {
        paramVarArgs = new b("Not all required fields were included: QuanPin");
        AppMethodBeat.o(101800);
        throw paramVarArgs;
      }
      if (this.FNm == null)
      {
        paramVarArgs = new b("Not all required fields were included: ChatRoomName");
        AppMethodBeat.o(101800);
        throw paramVarArgs;
      }
      if (this.FNK == null)
      {
        paramVarArgs = new b("Not all required fields were included: ImgBuf");
        AppMethodBeat.o(101800);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.lJ(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.GtV != null)
      {
        paramVarArgs.lJ(2, this.GtV.computeSize());
        this.GtV.writeFields(paramVarArgs);
      }
      if (this.GtY != null)
      {
        paramVarArgs.lJ(3, this.GtY.computeSize());
        this.GtY.writeFields(paramVarArgs);
      }
      if (this.GtZ != null)
      {
        paramVarArgs.lJ(4, this.GtZ.computeSize());
        this.GtZ.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(5, this.fNf);
      paramVarArgs.e(6, 8, this.FNl);
      if (this.FNm != null)
      {
        paramVarArgs.lJ(7, this.FNm.computeSize());
        this.FNm.writeFields(paramVarArgs);
      }
      if (this.FNK != null)
      {
        paramVarArgs.lJ(8, this.FNK.computeSize());
        this.FNK.writeFields(paramVarArgs);
      }
      if (this.GnN != null) {
        paramVarArgs.d(9, this.GnN);
      }
      if (this.GnO != null) {
        paramVarArgs.d(10, this.GnO);
      }
      AppMethodBeat.o(101800);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1682;
      }
    }
    label1682:
    for (int i = f.a.a.a.lI(1, this.BaseResponse.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.GtV != null) {
        paramInt = i + f.a.a.a.lI(2, this.GtV.computeSize());
      }
      i = paramInt;
      if (this.GtY != null) {
        i = paramInt + f.a.a.a.lI(3, this.GtY.computeSize());
      }
      paramInt = i;
      if (this.GtZ != null) {
        paramInt = i + f.a.a.a.lI(4, this.GtZ.computeSize());
      }
      i = paramInt + f.a.a.b.b.a.bz(5, this.fNf) + f.a.a.a.c(6, 8, this.FNl);
      paramInt = i;
      if (this.FNm != null) {
        paramInt = i + f.a.a.a.lI(7, this.FNm.computeSize());
      }
      i = paramInt;
      if (this.FNK != null) {
        i = paramInt + f.a.a.a.lI(8, this.FNK.computeSize());
      }
      paramInt = i;
      if (this.GnN != null) {
        paramInt = i + f.a.a.b.b.a.e(9, this.GnN);
      }
      i = paramInt;
      if (this.GnO != null) {
        i = paramInt + f.a.a.b.b.a.e(10, this.GnO);
      }
      AppMethodBeat.o(101800);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.FNl.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cwj.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cwj.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(101800);
          throw paramVarArgs;
        }
        if (this.GtV == null)
        {
          paramVarArgs = new b("Not all required fields were included: Topic");
          AppMethodBeat.o(101800);
          throw paramVarArgs;
        }
        if (this.GtY == null)
        {
          paramVarArgs = new b("Not all required fields were included: PYInitial");
          AppMethodBeat.o(101800);
          throw paramVarArgs;
        }
        if (this.GtZ == null)
        {
          paramVarArgs = new b("Not all required fields were included: QuanPin");
          AppMethodBeat.o(101800);
          throw paramVarArgs;
        }
        if (this.FNm == null)
        {
          paramVarArgs = new b("Not all required fields were included: ChatRoomName");
          AppMethodBeat.o(101800);
          throw paramVarArgs;
        }
        if (this.FNK == null)
        {
          paramVarArgs = new b("Not all required fields were included: ImgBuf");
          AppMethodBeat.o(101800);
          throw paramVarArgs;
        }
        AppMethodBeat.o(101800);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        acc localacc = (acc)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(101800);
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
            localacc.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(101800);
          return 0;
        case 2: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cxn();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cxn)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localacc.GtV = ((cxn)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(101800);
          return 0;
        case 3: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cxn();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cxn)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localacc.GtY = ((cxn)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(101800);
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
            for (bool = true; bool; bool = ((cxn)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localacc.GtZ = ((cxn)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(101800);
          return 0;
        case 5: 
          localacc.fNf = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(101800);
          return 0;
        case 6: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bzn();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bzn)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localacc.FNl.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(101800);
          return 0;
        case 7: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cxn();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cxn)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localacc.FNm = ((cxn)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(101800);
          return 0;
        case 8: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localacc.FNK = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(101800);
          return 0;
        case 9: 
          localacc.GnN = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(101800);
          return 0;
        }
        localacc.GnO = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(101800);
        return 0;
      }
      AppMethodBeat.o(101800);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.acc
 * JD-Core Version:    0.7.0.1
 */