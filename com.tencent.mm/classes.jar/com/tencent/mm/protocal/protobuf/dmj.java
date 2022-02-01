package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class dmj
  extends cvc
{
  public int GJm;
  public int GJn;
  public SKBuiltinBuffer_t GJo;
  public String HAE;
  public SKBuiltinBuffer_t HdC;
  public String sign;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91711);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.GJo == null)
      {
        paramVarArgs = new b("Not all required fields were included: ReqText");
        AppMethodBeat.o(91711);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.lC(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(2, this.GJm);
      paramVarArgs.aS(3, this.GJn);
      if (this.GJo != null)
      {
        paramVarArgs.lC(4, this.GJo.computeSize());
        this.GJo.writeFields(paramVarArgs);
      }
      if (this.HdC != null)
      {
        paramVarArgs.lC(5, this.HdC.computeSize());
        this.HdC.writeFields(paramVarArgs);
      }
      if (this.sign != null) {
        paramVarArgs.d(6, this.sign);
      }
      if (this.HAE != null) {
        paramVarArgs.d(7, this.HAE);
      }
      AppMethodBeat.o(91711);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label878;
      }
    }
    label878:
    for (paramInt = f.a.a.a.lB(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bz(2, this.GJm) + f.a.a.b.b.a.bz(3, this.GJn);
      paramInt = i;
      if (this.GJo != null) {
        paramInt = i + f.a.a.a.lB(4, this.GJo.computeSize());
      }
      i = paramInt;
      if (this.HdC != null) {
        i = paramInt + f.a.a.a.lB(5, this.HdC.computeSize());
      }
      paramInt = i;
      if (this.sign != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.sign);
      }
      i = paramInt;
      if (this.HAE != null) {
        i = paramInt + f.a.a.b.b.a.e(7, this.HAE);
      }
      AppMethodBeat.o(91711);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cvc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        if (this.GJo == null)
        {
          paramVarArgs = new b("Not all required fields were included: ReqText");
          AppMethodBeat.o(91711);
          throw paramVarArgs;
        }
        AppMethodBeat.o(91711);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        dmj localdmj = (dmj)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91711);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new jc();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((jc)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvc.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdmj.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91711);
          return 0;
        case 2: 
          localdmj.GJm = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(91711);
          return 0;
        case 3: 
          localdmj.GJn = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(91711);
          return 0;
        case 4: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvc.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdmj.GJo = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91711);
          return 0;
        case 5: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvc.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdmj.HdC = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91711);
          return 0;
        case 6: 
          localdmj.sign = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(91711);
          return 0;
        }
        localdmj.HAE = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(91711);
        return 0;
      }
      AppMethodBeat.o(91711);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dmj
 * JD-Core Version:    0.7.0.1
 */