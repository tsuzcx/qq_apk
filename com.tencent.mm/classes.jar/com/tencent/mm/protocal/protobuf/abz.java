package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class abz
  extends cvw
{
  public String FZx;
  public auj GtU;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(124481);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.GtU == null)
      {
        paramVarArgs = new b("Not all required fields were included: full_chat");
        AppMethodBeat.o(124481);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.lJ(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.FZx != null) {
        paramVarArgs.d(2, this.FZx);
      }
      if (this.GtU != null)
      {
        paramVarArgs.lJ(3, this.GtU.computeSize());
        this.GtU.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(124481);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label574;
      }
    }
    label574:
    for (int i = f.a.a.a.lI(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.FZx != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.FZx);
      }
      i = paramInt;
      if (this.GtU != null) {
        i = paramInt + f.a.a.a.lI(3, this.GtU.computeSize());
      }
      AppMethodBeat.o(124481);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cvw.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvw.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        if (this.GtU == null)
        {
          paramVarArgs = new b("Not all required fields were included: full_chat");
          AppMethodBeat.o(124481);
          throw paramVarArgs;
        }
        AppMethodBeat.o(124481);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        abz localabz = (abz)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(124481);
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
            localabz.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(124481);
          return 0;
        case 2: 
          localabz.FZx = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(124481);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new auj();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((auj)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cvw.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localabz.GtU = ((auj)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(124481);
        return 0;
      }
      AppMethodBeat.o(124481);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.abz
 * JD-Core Version:    0.7.0.1
 */