package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class pi
  extends cvw
{
  public String GcV;
  public int GcW;
  public com.tencent.mm.bw.b GcX;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(188946);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.GcV == null)
      {
        paramVarArgs = new f.a.a.b("Not all required fields were included: main_brand_user_name");
        AppMethodBeat.o(188946);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.lJ(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.GcV != null) {
        paramVarArgs.d(2, this.GcV);
      }
      paramVarArgs.aS(3, this.GcW);
      if (this.GcX != null) {
        paramVarArgs.c(4, this.GcX);
      }
      AppMethodBeat.o(188946);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label522;
      }
    }
    label522:
    for (paramInt = f.a.a.a.lI(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.GcV != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.GcV);
      }
      i += f.a.a.b.b.a.bz(3, this.GcW);
      paramInt = i;
      if (this.GcX != null) {
        paramInt = i + f.a.a.b.b.a.b(4, this.GcX);
      }
      AppMethodBeat.o(188946);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cvw.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvw.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        if (this.GcV == null)
        {
          paramVarArgs = new f.a.a.b("Not all required fields were included: main_brand_user_name");
          AppMethodBeat.o(188946);
          throw paramVarArgs;
        }
        AppMethodBeat.o(188946);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        pi localpi = (pi)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(188946);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new jc();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((jc)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cvw.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localpi.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(188946);
          return 0;
        case 2: 
          localpi.GcV = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(188946);
          return 0;
        case 3: 
          localpi.GcW = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(188946);
          return 0;
        }
        localpi.GcX = ((f.a.a.a.a)localObject1).OmT.gCk();
        AppMethodBeat.o(188946);
        return 0;
      }
      AppMethodBeat.o(188946);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.pi
 * JD-Core Version:    0.7.0.1
 */