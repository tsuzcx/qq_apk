package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class afe
  extends cvp
{
  public String iht;
  public String ihw;
  public String nDo;
  public int xcK;
  public int xcL;
  public int xcM;
  public SKBuiltinBuffer_t xcN;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(9591);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(9591);
        throw paramVarArgs;
      }
      if (this.xcN == null)
      {
        paramVarArgs = new b("Not all required fields were included: Data");
        AppMethodBeat.o(9591);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.lC(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.iht != null) {
        paramVarArgs.d(2, this.iht);
      }
      if (this.ihw != null) {
        paramVarArgs.d(3, this.ihw);
      }
      if (this.nDo != null) {
        paramVarArgs.d(4, this.nDo);
      }
      paramVarArgs.aS(5, this.xcK);
      paramVarArgs.aS(6, this.xcL);
      paramVarArgs.aS(7, this.xcM);
      if (this.xcN != null)
      {
        paramVarArgs.lC(8, this.xcN.computeSize());
        this.xcN.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(9591);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label892;
      }
    }
    label892:
    for (int i = f.a.a.a.lB(1, this.BaseResponse.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.iht != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.iht);
      }
      i = paramInt;
      if (this.ihw != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.ihw);
      }
      paramInt = i;
      if (this.nDo != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.nDo);
      }
      i = paramInt + f.a.a.b.b.a.bz(5, this.xcK) + f.a.a.b.b.a.bz(6, this.xcL) + f.a.a.b.b.a.bz(7, this.xcM);
      paramInt = i;
      if (this.xcN != null) {
        paramInt = i + f.a.a.a.lB(8, this.xcN.computeSize());
      }
      AppMethodBeat.o(9591);
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
          AppMethodBeat.o(9591);
          throw paramVarArgs;
        }
        if (this.xcN == null)
        {
          paramVarArgs = new b("Not all required fields were included: Data");
          AppMethodBeat.o(9591);
          throw paramVarArgs;
        }
        AppMethodBeat.o(9591);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        afe localafe = (afe)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(9591);
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
            localafe.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(9591);
          return 0;
        case 2: 
          localafe.iht = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(9591);
          return 0;
        case 3: 
          localafe.ihw = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(9591);
          return 0;
        case 4: 
          localafe.nDo = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(9591);
          return 0;
        case 5: 
          localafe.xcK = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(9591);
          return 0;
        case 6: 
          localafe.xcL = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(9591);
          return 0;
        case 7: 
          localafe.xcM = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(9591);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new SKBuiltinBuffer_t();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localafe.xcN = ((SKBuiltinBuffer_t)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(9591);
        return 0;
      }
      AppMethodBeat.o(9591);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.afe
 * JD-Core Version:    0.7.0.1
 */