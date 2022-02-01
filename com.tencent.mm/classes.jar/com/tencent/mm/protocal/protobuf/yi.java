package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public class yi
  extends cvp
{
  public String FXR;
  public String bxJ;
  public String mjL;
  public String mjM;
  public int status;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(123566);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(123566);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.lC(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(2, this.status);
      if (this.mjL != null) {
        paramVarArgs.d(3, this.mjL);
      }
      if (this.bxJ != null) {
        paramVarArgs.d(4, this.bxJ);
      }
      if (this.FXR != null) {
        paramVarArgs.d(5, this.FXR);
      }
      if (this.mjM != null) {
        paramVarArgs.d(6, this.mjM);
      }
      AppMethodBeat.o(123566);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label646;
      }
    }
    label646:
    for (paramInt = f.a.a.a.lB(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bz(2, this.status);
      paramInt = i;
      if (this.mjL != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.mjL);
      }
      i = paramInt;
      if (this.bxJ != null) {
        i = paramInt + f.a.a.b.b.a.e(4, this.bxJ);
      }
      paramInt = i;
      if (this.FXR != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.FXR);
      }
      i = paramInt;
      if (this.mjM != null) {
        i = paramInt + f.a.a.b.b.a.e(6, this.mjM);
      }
      AppMethodBeat.o(123566);
      return i;
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
          AppMethodBeat.o(123566);
          throw paramVarArgs;
        }
        AppMethodBeat.o(123566);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        yi localyi = (yi)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(123566);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new BaseResponse();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((BaseResponse)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localyi.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(123566);
          return 0;
        case 2: 
          localyi.status = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(123566);
          return 0;
        case 3: 
          localyi.mjL = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(123566);
          return 0;
        case 4: 
          localyi.bxJ = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(123566);
          return 0;
        case 5: 
          localyi.FXR = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(123566);
          return 0;
        }
        localyi.mjM = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(123566);
        return 0;
      }
      AppMethodBeat.o(123566);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.yi
 * JD-Core Version:    0.7.0.1
 */