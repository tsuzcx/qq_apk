package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class cyq
  extends cvw
{
  public String category;
  public String mac;
  public String userName;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32419);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.mac == null)
      {
        paramVarArgs = new b("Not all required fields were included: mac");
        AppMethodBeat.o(32419);
        throw paramVarArgs;
      }
      if (this.userName == null)
      {
        paramVarArgs = new b("Not all required fields were included: userName");
        AppMethodBeat.o(32419);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.lJ(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.mac != null) {
        paramVarArgs.d(2, this.mac);
      }
      if (this.userName != null) {
        paramVarArgs.d(3, this.userName);
      }
      if (this.category != null) {
        paramVarArgs.d(4, this.category);
      }
      AppMethodBeat.o(32419);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label600;
      }
    }
    label600:
    for (int i = f.a.a.a.lI(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.mac != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.mac);
      }
      i = paramInt;
      if (this.userName != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.userName);
      }
      paramInt = i;
      if (this.category != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.category);
      }
      AppMethodBeat.o(32419);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cvw.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvw.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        if (this.mac == null)
        {
          paramVarArgs = new b("Not all required fields were included: mac");
          AppMethodBeat.o(32419);
          throw paramVarArgs;
        }
        if (this.userName == null)
        {
          paramVarArgs = new b("Not all required fields were included: userName");
          AppMethodBeat.o(32419);
          throw paramVarArgs;
        }
        AppMethodBeat.o(32419);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        cyq localcyq = (cyq)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(32419);
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
            localcyq.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32419);
          return 0;
        case 2: 
          localcyq.mac = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(32419);
          return 0;
        case 3: 
          localcyq.userName = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(32419);
          return 0;
        }
        localcyq.category = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(32419);
        return 0;
      }
      AppMethodBeat.o(32419);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cyq
 * JD-Core Version:    0.7.0.1
 */