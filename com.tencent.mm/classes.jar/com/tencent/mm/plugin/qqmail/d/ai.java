package com.tencent.mm.plugin.qqmail.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.BaseResponse;
import com.tencent.mm.protocal.protobuf.cvp;
import f.a.a.b;
import java.util.LinkedList;

public final class ai
  extends cvp
{
  public String hCW;
  public String xbs;
  public int xcK;
  public int xcL;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(122800);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(122800);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.lC(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(2, this.xcL);
      if (this.xbs != null) {
        paramVarArgs.d(3, this.xbs);
      }
      paramVarArgs.aS(4, this.xcK);
      if (this.hCW != null) {
        paramVarArgs.d(5, this.hCW);
      }
      AppMethodBeat.o(122800);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label566;
      }
    }
    label566:
    for (paramInt = f.a.a.a.lB(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bz(2, this.xcL);
      paramInt = i;
      if (this.xbs != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.xbs);
      }
      i = paramInt + f.a.a.b.b.a.bz(4, this.xcK);
      paramInt = i;
      if (this.hCW != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.hCW);
      }
      AppMethodBeat.o(122800);
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
          AppMethodBeat.o(122800);
          throw paramVarArgs;
        }
        AppMethodBeat.o(122800);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        ai localai = (ai)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(122800);
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
            localai.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(122800);
          return 0;
        case 2: 
          localai.xcL = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(122800);
          return 0;
        case 3: 
          localai.xbs = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(122800);
          return 0;
        case 4: 
          localai.xcK = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(122800);
          return 0;
        }
        localai.hCW = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(122800);
        return 0;
      }
      AppMethodBeat.o(122800);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.qqmail.d.ai
 * JD-Core Version:    0.7.0.1
 */