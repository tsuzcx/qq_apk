package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class i
  extends cvp
{
  public String FpG;
  public String FpI;
  public z FpR;
  public a FpS;
  public int dlw = 268513600;
  public String paA = "请求不成功，请稍候再试";
  
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
        paramVarArgs.lC(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(2, this.dlw);
      if (this.paA != null) {
        paramVarArgs.d(3, this.paA);
      }
      if (this.FpG != null) {
        paramVarArgs.d(4, this.FpG);
      }
      if (this.FpI != null) {
        paramVarArgs.d(6, this.FpI);
      }
      if (this.FpR != null)
      {
        paramVarArgs.lC(7, this.FpR.computeSize());
        this.FpR.writeFields(paramVarArgs);
      }
      if (this.FpS != null)
      {
        paramVarArgs.lC(8, this.FpS.computeSize());
        this.FpS.writeFields(paramVarArgs);
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
    for (paramInt = f.a.a.a.lB(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bz(2, this.dlw);
      paramInt = i;
      if (this.paA != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.paA);
      }
      i = paramInt;
      if (this.FpG != null) {
        i = paramInt + f.a.a.b.b.a.e(4, this.FpG);
      }
      paramInt = i;
      if (this.FpI != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.FpI);
      }
      i = paramInt;
      if (this.FpR != null) {
        i = paramInt + f.a.a.a.lB(7, this.FpR.computeSize());
      }
      paramInt = i;
      if (this.FpS != null) {
        paramInt = i + f.a.a.a.lB(8, this.FpS.computeSize());
      }
      AppMethodBeat.o(91320);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cvp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
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
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new BaseResponse();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((BaseResponse)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            locali.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91320);
          return 0;
        case 2: 
          locali.dlw = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(91320);
          return 0;
        case 3: 
          locali.paA = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(91320);
          return 0;
        case 4: 
          locali.FpG = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(91320);
          return 0;
        case 6: 
          locali.FpI = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(91320);
          return 0;
        case 7: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new z();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((z)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            locali.FpR = ((z)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91320);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new a();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((a)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          locali.FpS = ((a)localObject1);
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