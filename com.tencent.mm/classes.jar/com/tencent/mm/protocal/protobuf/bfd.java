package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class bfd
  extends ckq
{
  public String hnC;
  public String ijV;
  public String sbA;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(89660);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.hnC == null)
      {
        paramVarArgs = new b("Not all required fields were included: AppId");
        AppMethodBeat.o(89660);
        throw paramVarArgs;
      }
      if (this.sbA == null)
      {
        paramVarArgs = new b("Not all required fields were included: Lang");
        AppMethodBeat.o(89660);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.kX(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.hnC != null) {
        paramVarArgs.d(2, this.hnC);
      }
      if (this.sbA != null) {
        paramVarArgs.d(3, this.sbA);
      }
      if (this.ijV != null) {
        paramVarArgs.d(4, this.ijV);
      }
      AppMethodBeat.o(89660);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label586;
      }
    }
    label586:
    for (int i = f.a.a.a.kW(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.hnC != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.hnC);
      }
      i = paramInt;
      if (this.sbA != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.sbA);
      }
      paramInt = i;
      if (this.ijV != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.ijV);
      }
      AppMethodBeat.o(89660);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = ckq.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = ckq.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        if (this.hnC == null)
        {
          paramVarArgs = new b("Not all required fields were included: AppId");
          AppMethodBeat.o(89660);
          throw paramVarArgs;
        }
        if (this.sbA == null)
        {
          paramVarArgs = new b("Not all required fields were included: Lang");
          AppMethodBeat.o(89660);
          throw paramVarArgs;
        }
        AppMethodBeat.o(89660);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        bfd localbfd = (bfd)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(89660);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ip();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((ip)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, ckq.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbfd.BaseRequest = ((ip)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(89660);
          return 0;
        case 2: 
          localbfd.hnC = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(89660);
          return 0;
        case 3: 
          localbfd.sbA = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(89660);
          return 0;
        }
        localbfd.ijV = ((f.a.a.a.a)localObject1).KhF.readString();
        AppMethodBeat.o(89660);
        return 0;
      }
      AppMethodBeat.o(89660);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bfd
 * JD-Core Version:    0.7.0.1
 */