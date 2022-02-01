package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class cpc
  extends cwj
{
  public String HAN;
  public String HAO;
  public sf HAP;
  public String HAQ;
  public String HAR;
  public dpl HAS;
  public String dlT;
  public String hCp;
  public int oGt;
  public String oGu;
  public String wRt;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(72556);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(72556);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.lJ(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(2, this.oGt);
      if (this.oGu != null) {
        paramVarArgs.d(3, this.oGu);
      }
      if (this.HAN != null) {
        paramVarArgs.d(4, this.HAN);
      }
      if (this.hCp != null) {
        paramVarArgs.d(5, this.hCp);
      }
      if (this.HAO != null) {
        paramVarArgs.d(6, this.HAO);
      }
      if (this.HAP != null)
      {
        paramVarArgs.lJ(7, this.HAP.computeSize());
        this.HAP.writeFields(paramVarArgs);
      }
      if (this.HAQ != null) {
        paramVarArgs.d(8, this.HAQ);
      }
      if (this.wRt != null) {
        paramVarArgs.d(9, this.wRt);
      }
      if (this.dlT != null) {
        paramVarArgs.d(10, this.dlT);
      }
      if (this.HAR != null) {
        paramVarArgs.d(11, this.HAR);
      }
      if (this.HAS != null)
      {
        paramVarArgs.lJ(12, this.HAS.computeSize());
        this.HAS.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(72556);
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
      int i = paramInt + f.a.a.b.b.a.bz(2, this.oGt);
      paramInt = i;
      if (this.oGu != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.oGu);
      }
      i = paramInt;
      if (this.HAN != null) {
        i = paramInt + f.a.a.b.b.a.e(4, this.HAN);
      }
      paramInt = i;
      if (this.hCp != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.hCp);
      }
      i = paramInt;
      if (this.HAO != null) {
        i = paramInt + f.a.a.b.b.a.e(6, this.HAO);
      }
      paramInt = i;
      if (this.HAP != null) {
        paramInt = i + f.a.a.a.lI(7, this.HAP.computeSize());
      }
      i = paramInt;
      if (this.HAQ != null) {
        i = paramInt + f.a.a.b.b.a.e(8, this.HAQ);
      }
      paramInt = i;
      if (this.wRt != null) {
        paramInt = i + f.a.a.b.b.a.e(9, this.wRt);
      }
      i = paramInt;
      if (this.dlT != null) {
        i = paramInt + f.a.a.b.b.a.e(10, this.dlT);
      }
      paramInt = i;
      if (this.HAR != null) {
        paramInt = i + f.a.a.b.b.a.e(11, this.HAR);
      }
      i = paramInt;
      if (this.HAS != null) {
        i = paramInt + f.a.a.a.lI(12, this.HAS.computeSize());
      }
      AppMethodBeat.o(72556);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cwj.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cwj.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(72556);
          throw paramVarArgs;
        }
        AppMethodBeat.o(72556);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        cpc localcpc = (cpc)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(72556);
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
            localcpc.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(72556);
          return 0;
        case 2: 
          localcpc.oGt = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(72556);
          return 0;
        case 3: 
          localcpc.oGu = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(72556);
          return 0;
        case 4: 
          localcpc.HAN = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(72556);
          return 0;
        case 5: 
          localcpc.hCp = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(72556);
          return 0;
        case 6: 
          localcpc.HAO = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(72556);
          return 0;
        case 7: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new sf();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((sf)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcpc.HAP = ((sf)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(72556);
          return 0;
        case 8: 
          localcpc.HAQ = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(72556);
          return 0;
        case 9: 
          localcpc.wRt = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(72556);
          return 0;
        case 10: 
          localcpc.dlT = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(72556);
          return 0;
        case 11: 
          localcpc.HAR = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(72556);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new dpl();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((dpl)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localcpc.HAS = ((dpl)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(72556);
        return 0;
      }
      AppMethodBeat.o(72556);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cpc
 * JD-Core Version:    0.7.0.1
 */