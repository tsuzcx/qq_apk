package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class cqb
  extends cwj
{
  public LinkedList<j> FIj;
  public dcb HBT;
  public l HBU;
  public long dPq;
  public int dmy;
  public String iWC;
  public String iWE;
  public String iWF;
  public String iWH;
  public String phe;
  
  public cqb()
  {
    AppMethodBeat.i(91649);
    this.dmy = 268513600;
    this.phe = "请求不成功，请稍候再试";
    this.FIj = new LinkedList();
    AppMethodBeat.o(91649);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91650);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(91650);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.lJ(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(2, this.dmy);
      if (this.phe != null) {
        paramVarArgs.d(3, this.phe);
      }
      paramVarArgs.aZ(4, this.dPq);
      if (this.iWC != null) {
        paramVarArgs.d(5, this.iWC);
      }
      paramVarArgs.e(6, 8, this.FIj);
      if (this.iWE != null) {
        paramVarArgs.d(7, this.iWE);
      }
      if (this.iWF != null) {
        paramVarArgs.d(8, this.iWF);
      }
      if (this.HBT != null)
      {
        paramVarArgs.lJ(9, this.HBT.computeSize());
        this.HBT.writeFields(paramVarArgs);
      }
      if (this.iWH != null) {
        paramVarArgs.d(10, this.iWH);
      }
      if (this.HBU != null)
      {
        paramVarArgs.lJ(11, this.HBU.computeSize());
        this.HBU.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(91650);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1206;
      }
    }
    label1206:
    for (paramInt = f.a.a.a.lI(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bz(2, this.dmy);
      paramInt = i;
      if (this.phe != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.phe);
      }
      i = paramInt + f.a.a.b.b.a.p(4, this.dPq);
      paramInt = i;
      if (this.iWC != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.iWC);
      }
      i = paramInt + f.a.a.a.c(6, 8, this.FIj);
      paramInt = i;
      if (this.iWE != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.iWE);
      }
      i = paramInt;
      if (this.iWF != null) {
        i = paramInt + f.a.a.b.b.a.e(8, this.iWF);
      }
      paramInt = i;
      if (this.HBT != null) {
        paramInt = i + f.a.a.a.lI(9, this.HBT.computeSize());
      }
      i = paramInt;
      if (this.iWH != null) {
        i = paramInt + f.a.a.b.b.a.e(10, this.iWH);
      }
      paramInt = i;
      if (this.HBU != null) {
        paramInt = i + f.a.a.a.lI(11, this.HBU.computeSize());
      }
      AppMethodBeat.o(91650);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.FIj.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cwj.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cwj.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(91650);
          throw paramVarArgs;
        }
        AppMethodBeat.o(91650);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        cqb localcqb = (cqb)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91650);
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
            localcqb.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91650);
          return 0;
        case 2: 
          localcqb.dmy = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(91650);
          return 0;
        case 3: 
          localcqb.phe = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(91650);
          return 0;
        case 4: 
          localcqb.dPq = ((f.a.a.a.a)localObject1).OmT.zd();
          AppMethodBeat.o(91650);
          return 0;
        case 5: 
          localcqb.iWC = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(91650);
          return 0;
        case 6: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new j();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((j)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcqb.FIj.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91650);
          return 0;
        case 7: 
          localcqb.iWE = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(91650);
          return 0;
        case 8: 
          localcqb.iWF = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(91650);
          return 0;
        case 9: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dcb();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dcb)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcqb.HBT = ((dcb)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91650);
          return 0;
        case 10: 
          localcqb.iWH = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(91650);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new l();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((l)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localcqb.HBU = ((l)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(91650);
        return 0;
      }
      AppMethodBeat.o(91650);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cqb
 * JD-Core Version:    0.7.0.1
 */