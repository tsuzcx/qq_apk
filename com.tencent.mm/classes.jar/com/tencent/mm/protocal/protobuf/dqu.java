package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class dqu
  extends cvc
{
  public String FGU;
  public String FHb;
  public nc HEJ;
  public nc HEK;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(124570);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.FHb == null)
      {
        paramVarArgs = new b("Not all required fields were included: brand_user_name");
        AppMethodBeat.o(124570);
        throw paramVarArgs;
      }
      if (this.FGU == null)
      {
        paramVarArgs = new b("Not all required fields were included: bizchat_id");
        AppMethodBeat.o(124570);
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
      if (this.HEJ != null)
      {
        paramVarArgs.lC(4, this.HEJ.computeSize());
        this.HEJ.writeFields(paramVarArgs);
      }
      if (this.HEK != null)
      {
        paramVarArgs.lC(5, this.HEK.computeSize());
        this.HEK.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(124570);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label834;
      }
    }
    label834:
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
      paramInt = i;
      if (this.HEJ != null) {
        paramInt = i + f.a.a.a.lB(4, this.HEJ.computeSize());
      }
      i = paramInt;
      if (this.HEK != null) {
        i = paramInt + f.a.a.a.lB(5, this.HEK.computeSize());
      }
      AppMethodBeat.o(124570);
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
          AppMethodBeat.o(124570);
          throw paramVarArgs;
        }
        if (this.FGU == null)
        {
          paramVarArgs = new b("Not all required fields were included: bizchat_id");
          AppMethodBeat.o(124570);
          throw paramVarArgs;
        }
        AppMethodBeat.o(124570);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        dqu localdqu = (dqu)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(124570);
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
            localdqu.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(124570);
          return 0;
        case 2: 
          localdqu.FHb = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(124570);
          return 0;
        case 3: 
          localdqu.FGU = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(124570);
          return 0;
        case 4: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new nc();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((nc)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvc.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdqu.HEJ = ((nc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(124570);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new nc();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((nc)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvc.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localdqu.HEK = ((nc)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(124570);
        return 0;
      }
      AppMethodBeat.o(124570);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dqu
 * JD-Core Version:    0.7.0.1
 */