package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class dqw
  extends cvc
{
  public String FHb;
  public mz GrN;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(124572);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.FHb == null)
      {
        paramVarArgs = new b("Not all required fields were included: brand_user_name");
        AppMethodBeat.o(124572);
        throw paramVarArgs;
      }
      if (this.GrN == null)
      {
        paramVarArgs = new b("Not all required fields were included: chat");
        AppMethodBeat.o(124572);
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
      if (this.GrN != null)
      {
        paramVarArgs.lC(3, this.GrN.computeSize());
        this.GrN.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(124572);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label622;
      }
    }
    label622:
    for (int i = f.a.a.a.lB(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.FHb != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.FHb);
      }
      i = paramInt;
      if (this.GrN != null) {
        i = paramInt + f.a.a.a.lB(3, this.GrN.computeSize());
      }
      AppMethodBeat.o(124572);
      return i;
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
          AppMethodBeat.o(124572);
          throw paramVarArgs;
        }
        if (this.GrN == null)
        {
          paramVarArgs = new b("Not all required fields were included: chat");
          AppMethodBeat.o(124572);
          throw paramVarArgs;
        }
        AppMethodBeat.o(124572);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        dqw localdqw = (dqw)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(124572);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new jc();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((jc)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvc.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdqw.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(124572);
          return 0;
        case 2: 
          localdqw.FHb = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(124572);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new mz();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((mz)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvc.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localdqw.GrN = ((mz)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(124572);
        return 0;
      }
      AppMethodBeat.o(124572);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dqw
 * JD-Core Version:    0.7.0.1
 */