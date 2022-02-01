package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class ckb
  extends cvp
{
  public SKBuiltinBuffer_t GJp;
  public int GJq;
  public String GJr;
  public int GJs;
  public int HdD;
  public String HdE;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91611);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(91611);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.lC(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.GJp != null)
      {
        paramVarArgs.lC(2, this.GJp.computeSize());
        this.GJp.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(3, this.GJq);
      if (this.GJr != null) {
        paramVarArgs.d(4, this.GJr);
      }
      paramVarArgs.aS(5, this.GJs);
      paramVarArgs.aS(6, this.HdD);
      if (this.HdE != null) {
        paramVarArgs.d(7, this.HdE);
      }
      AppMethodBeat.o(91611);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label766;
      }
    }
    label766:
    for (paramInt = f.a.a.a.lB(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.GJp != null) {
        i = paramInt + f.a.a.a.lB(2, this.GJp.computeSize());
      }
      i += f.a.a.b.b.a.bz(3, this.GJq);
      paramInt = i;
      if (this.GJr != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.GJr);
      }
      i = paramInt + f.a.a.b.b.a.bz(5, this.GJs) + f.a.a.b.b.a.bz(6, this.HdD);
      paramInt = i;
      if (this.HdE != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.HdE);
      }
      AppMethodBeat.o(91611);
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
          AppMethodBeat.o(91611);
          throw paramVarArgs;
        }
        AppMethodBeat.o(91611);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        ckb localckb = (ckb)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91611);
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
            localckb.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91611);
          return 0;
        case 2: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localckb.GJp = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91611);
          return 0;
        case 3: 
          localckb.GJq = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(91611);
          return 0;
        case 4: 
          localckb.GJr = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(91611);
          return 0;
        case 5: 
          localckb.GJs = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(91611);
          return 0;
        case 6: 
          localckb.HdD = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(91611);
          return 0;
        }
        localckb.HdE = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(91611);
        return 0;
      }
      AppMethodBeat.o(91611);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ckb
 * JD-Core Version:    0.7.0.1
 */