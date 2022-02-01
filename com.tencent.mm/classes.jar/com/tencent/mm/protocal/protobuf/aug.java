package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class aug
  extends ckq
{
  public String Ctz;
  public String Due;
  public String Duf;
  public pi Dug;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(114787);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.Due == null)
      {
        paramVarArgs = new b("Not all required fields were included: FunctionMsgID");
        AppMethodBeat.o(114787);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.kX(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.Due != null) {
        paramVarArgs.d(2, this.Due);
      }
      if (this.Duf != null) {
        paramVarArgs.d(3, this.Duf);
      }
      if (this.Ctz != null) {
        paramVarArgs.d(4, this.Ctz);
      }
      if (this.Dug != null)
      {
        paramVarArgs.kX(5, this.Dug.computeSize());
        this.Dug.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(114787);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label694;
      }
    }
    label694:
    for (int i = f.a.a.a.kW(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.Due != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.Due);
      }
      i = paramInt;
      if (this.Duf != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.Duf);
      }
      paramInt = i;
      if (this.Ctz != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.Ctz);
      }
      i = paramInt;
      if (this.Dug != null) {
        i = paramInt + f.a.a.a.kW(5, this.Dug.computeSize());
      }
      AppMethodBeat.o(114787);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = ckq.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = ckq.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        if (this.Due == null)
        {
          paramVarArgs = new b("Not all required fields were included: FunctionMsgID");
          AppMethodBeat.o(114787);
          throw paramVarArgs;
        }
        AppMethodBeat.o(114787);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        aug localaug = (aug)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(114787);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ip();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ip)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, ckq.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localaug.BaseRequest = ((ip)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(114787);
          return 0;
        case 2: 
          localaug.Due = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(114787);
          return 0;
        case 3: 
          localaug.Duf = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(114787);
          return 0;
        case 4: 
          localaug.Ctz = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(114787);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new pi();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((pi)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, ckq.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localaug.Dug = ((pi)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(114787);
        return 0;
      }
      AppMethodBeat.o(114787);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aug
 * JD-Core Version:    0.7.0.1
 */