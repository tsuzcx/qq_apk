package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class cqa
  extends cvc
{
  public String FGU;
  public String FHb;
  public int time_stamp;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(124544);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.FHb == null)
      {
        paramVarArgs = new b("Not all required fields were included: brand_user_name");
        AppMethodBeat.o(124544);
        throw paramVarArgs;
      }
      if (this.FGU == null)
      {
        paramVarArgs = new b("Not all required fields were included: bizchat_id");
        AppMethodBeat.o(124544);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.lC(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.FHb != null) {
        paramVarArgs.d(2, this.FHb);
      }
      if (this.FGU != null) {
        paramVarArgs.d(3, this.FGU);
      }
      paramVarArgs.aS(4, this.time_stamp);
      AppMethodBeat.o(124544);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label570;
      }
    }
    label570:
    for (int i = f.a.a.a.lB(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.FHb != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.FHb);
      }
      i = paramInt;
      if (this.FGU != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.FGU);
      }
      paramInt = f.a.a.b.b.a.bz(4, this.time_stamp);
      AppMethodBeat.o(124544);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cvc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        if (this.FHb == null)
        {
          paramVarArgs = new b("Not all required fields were included: brand_user_name");
          AppMethodBeat.o(124544);
          throw paramVarArgs;
        }
        if (this.FGU == null)
        {
          paramVarArgs = new b("Not all required fields were included: bizchat_id");
          AppMethodBeat.o(124544);
          throw paramVarArgs;
        }
        AppMethodBeat.o(124544);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        cqa localcqa = (cqa)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(124544);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new jc();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((jc)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvc.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcqa.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(124544);
          return 0;
        case 2: 
          localcqa.FHb = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(124544);
          return 0;
        case 3: 
          localcqa.FGU = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(124544);
          return 0;
        }
        localcqa.time_stamp = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(124544);
        return 0;
      }
      AppMethodBeat.o(124544);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cqa
 * JD-Core Version:    0.7.0.1
 */