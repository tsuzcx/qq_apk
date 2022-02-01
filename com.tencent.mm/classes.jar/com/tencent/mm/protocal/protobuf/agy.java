package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class agy
  extends cvw
{
  public xv Gxm;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(152538);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.Gxm == null)
      {
        paramVarArgs = new b("Not all required fields were included: CheckResUpdateReq");
        AppMethodBeat.o(152538);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.lJ(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.Gxm != null)
      {
        paramVarArgs.lJ(2, this.Gxm.computeSize());
        this.Gxm.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(152538);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label514;
      }
    }
    label514:
    for (paramInt = f.a.a.a.lI(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.Gxm != null) {
        i = paramInt + f.a.a.a.lI(2, this.Gxm.computeSize());
      }
      AppMethodBeat.o(152538);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cvw.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvw.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        if (this.Gxm == null)
        {
          paramVarArgs = new b("Not all required fields were included: CheckResUpdateReq");
          AppMethodBeat.o(152538);
          throw paramVarArgs;
        }
        AppMethodBeat.o(152538);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        agy localagy = (agy)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(152538);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new jc();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((jc)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cvw.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localagy.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152538);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new xv();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((xv)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cvw.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localagy.Gxm = ((xv)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(152538);
        return 0;
      }
      AppMethodBeat.o(152538);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.agy
 * JD-Core Version:    0.7.0.1
 */