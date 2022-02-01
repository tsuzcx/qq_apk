package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class i
  extends cwj
{
  public String FIe;
  public String FIg;
  public z FIp;
  public a FIq;
  public int dmy = 268513600;
  public String phe = "请求不成功，请稍候再试";
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91320);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(91320);
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
      if (this.FIe != null) {
        paramVarArgs.d(4, this.FIe);
      }
      if (this.FIg != null) {
        paramVarArgs.d(6, this.FIg);
      }
      if (this.FIp != null)
      {
        paramVarArgs.lJ(7, this.FIp.computeSize());
        this.FIp.writeFields(paramVarArgs);
      }
      if (this.FIq != null)
      {
        paramVarArgs.lJ(8, this.FIq.computeSize());
        this.FIq.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(91320);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label902;
      }
    }
    label902:
    for (paramInt = f.a.a.a.lI(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bz(2, this.dmy);
      paramInt = i;
      if (this.phe != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.phe);
      }
      i = paramInt;
      if (this.FIe != null) {
        i = paramInt + f.a.a.b.b.a.e(4, this.FIe);
      }
      paramInt = i;
      if (this.FIg != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.FIg);
      }
      i = paramInt;
      if (this.FIp != null) {
        i = paramInt + f.a.a.a.lI(7, this.FIp.computeSize());
      }
      paramInt = i;
      if (this.FIq != null) {
        paramInt = i + f.a.a.a.lI(8, this.FIq.computeSize());
      }
      AppMethodBeat.o(91320);
      return paramInt;
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
          AppMethodBeat.o(91320);
          throw paramVarArgs;
        }
        AppMethodBeat.o(91320);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        i locali = (i)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        case 5: 
        default: 
          AppMethodBeat.o(91320);
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
            locali.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91320);
          return 0;
        case 2: 
          locali.dmy = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(91320);
          return 0;
        case 3: 
          locali.phe = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(91320);
          return 0;
        case 4: 
          locali.FIe = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(91320);
          return 0;
        case 6: 
          locali.FIg = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(91320);
          return 0;
        case 7: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new z();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((z)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            locali.FIp = ((z)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91320);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new a();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((a)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          locali.FIq = ((a)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(91320);
        return 0;
      }
      AppMethodBeat.o(91320);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.i
 * JD-Core Version:    0.7.0.1
 */