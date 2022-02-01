package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class drg
  extends cvw
{
  public int FNv;
  public bob FVS;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32473);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.FVS == null)
      {
        paramVarArgs = new b("Not all required fields were included: HardDevice");
        AppMethodBeat.o(32473);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.lJ(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.FVS != null)
      {
        paramVarArgs.lJ(2, this.FVS.computeSize());
        this.FVS.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(4, this.FNv);
      AppMethodBeat.o(32473);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label571;
      }
    }
    label571:
    for (paramInt = f.a.a.a.lI(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.FVS != null) {
        i = paramInt + f.a.a.a.lI(2, this.FVS.computeSize());
      }
      paramInt = f.a.a.b.b.a.bz(4, this.FNv);
      AppMethodBeat.o(32473);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cvw.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvw.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        if (this.FVS == null)
        {
          paramVarArgs = new b("Not all required fields were included: HardDevice");
          AppMethodBeat.o(32473);
          throw paramVarArgs;
        }
        AppMethodBeat.o(32473);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        drg localdrg = (drg)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        case 3: 
        default: 
          AppMethodBeat.o(32473);
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
            localdrg.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32473);
          return 0;
        case 2: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bob();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bob)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cvw.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdrg.FVS = ((bob)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32473);
          return 0;
        }
        localdrg.FNv = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(32473);
        return 0;
      }
      AppMethodBeat.o(32473);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.drg
 * JD-Core Version:    0.7.0.1
 */