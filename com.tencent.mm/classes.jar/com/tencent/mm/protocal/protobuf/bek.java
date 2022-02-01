package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class bek
  extends cvp
{
  public cwt Fvi;
  public cwt Fvj;
  public int xbr;
  public long xbt;
  public int xcK;
  public int xcL;
  public int xcM;
  public SKBuiltinBuffer_t xcN;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(152573);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(152573);
        throw paramVarArgs;
      }
      if (this.Fvi == null)
      {
        paramVarArgs = new b("Not all required fields were included: FromUserName");
        AppMethodBeat.o(152573);
        throw paramVarArgs;
      }
      if (this.Fvj == null)
      {
        paramVarArgs = new b("Not all required fields were included: ToUserName");
        AppMethodBeat.o(152573);
        throw paramVarArgs;
      }
      if (this.xcN == null)
      {
        paramVarArgs = new b("Not all required fields were included: Data");
        AppMethodBeat.o(152573);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.lC(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(2, this.xbr);
      if (this.Fvi != null)
      {
        paramVarArgs.lC(3, this.Fvi.computeSize());
        this.Fvi.writeFields(paramVarArgs);
      }
      if (this.Fvj != null)
      {
        paramVarArgs.lC(4, this.Fvj.computeSize());
        this.Fvj.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(5, this.xcK);
      paramVarArgs.aS(6, this.xcL);
      paramVarArgs.aS(7, this.xcM);
      if (this.xcN != null)
      {
        paramVarArgs.lC(8, this.xcN.computeSize());
        this.xcN.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(9, this.xbt);
      AppMethodBeat.o(152573);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1190;
      }
    }
    label1190:
    for (paramInt = f.a.a.a.lB(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bz(2, this.xbr);
      paramInt = i;
      if (this.Fvi != null) {
        paramInt = i + f.a.a.a.lB(3, this.Fvi.computeSize());
      }
      i = paramInt;
      if (this.Fvj != null) {
        i = paramInt + f.a.a.a.lB(4, this.Fvj.computeSize());
      }
      i = i + f.a.a.b.b.a.bz(5, this.xcK) + f.a.a.b.b.a.bz(6, this.xcL) + f.a.a.b.b.a.bz(7, this.xcM);
      paramInt = i;
      if (this.xcN != null) {
        paramInt = i + f.a.a.a.lB(8, this.xcN.computeSize());
      }
      i = f.a.a.b.b.a.p(9, this.xbt);
      AppMethodBeat.o(152573);
      return paramInt + i;
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
          AppMethodBeat.o(152573);
          throw paramVarArgs;
        }
        if (this.Fvi == null)
        {
          paramVarArgs = new b("Not all required fields were included: FromUserName");
          AppMethodBeat.o(152573);
          throw paramVarArgs;
        }
        if (this.Fvj == null)
        {
          paramVarArgs = new b("Not all required fields were included: ToUserName");
          AppMethodBeat.o(152573);
          throw paramVarArgs;
        }
        if (this.xcN == null)
        {
          paramVarArgs = new b("Not all required fields were included: Data");
          AppMethodBeat.o(152573);
          throw paramVarArgs;
        }
        AppMethodBeat.o(152573);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        bek localbek = (bek)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(152573);
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
            localbek.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152573);
          return 0;
        case 2: 
          localbek.xbr = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(152573);
          return 0;
        case 3: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cwt();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cwt)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbek.Fvi = ((cwt)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152573);
          return 0;
        case 4: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cwt();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cwt)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbek.Fvj = ((cwt)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152573);
          return 0;
        case 5: 
          localbek.xcK = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(152573);
          return 0;
        case 6: 
          localbek.xcL = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(152573);
          return 0;
        case 7: 
          localbek.xcM = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(152573);
          return 0;
        case 8: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbek.xcN = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152573);
          return 0;
        }
        localbek.xbt = ((f.a.a.a.a)localObject1).NPN.zd();
        AppMethodBeat.o(152573);
        return 0;
      }
      AppMethodBeat.o(152573);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bek
 * JD-Core Version:    0.7.0.1
 */