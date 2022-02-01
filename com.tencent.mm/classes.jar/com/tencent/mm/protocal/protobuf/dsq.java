package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class dsq
  extends cvp
{
  public String FVo;
  public String FVp;
  public String HFs;
  public int xcK;
  public int xcL;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(152718);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(152718);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.lC(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(2, this.xcK);
      paramVarArgs.aS(3, this.xcL);
      if (this.HFs != null) {
        paramVarArgs.d(4, this.HFs);
      }
      if (this.FVo != null) {
        paramVarArgs.d(5, this.FVo);
      }
      if (this.FVp != null) {
        paramVarArgs.d(6, this.FVp);
      }
      AppMethodBeat.o(152718);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label626;
      }
    }
    label626:
    for (paramInt = f.a.a.a.lB(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bz(2, this.xcK) + f.a.a.b.b.a.bz(3, this.xcL);
      paramInt = i;
      if (this.HFs != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.HFs);
      }
      i = paramInt;
      if (this.FVo != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.FVo);
      }
      paramInt = i;
      if (this.FVp != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.FVp);
      }
      AppMethodBeat.o(152718);
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
          AppMethodBeat.o(152718);
          throw paramVarArgs;
        }
        AppMethodBeat.o(152718);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        dsq localdsq = (dsq)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(152718);
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
            localdsq.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152718);
          return 0;
        case 2: 
          localdsq.xcK = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(152718);
          return 0;
        case 3: 
          localdsq.xcL = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(152718);
          return 0;
        case 4: 
          localdsq.HFs = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(152718);
          return 0;
        case 5: 
          localdsq.FVo = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(152718);
          return 0;
        }
        localdsq.FVp = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(152718);
        return 0;
      }
      AppMethodBeat.o(152718);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dsq
 * JD-Core Version:    0.7.0.1
 */