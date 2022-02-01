package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class bha
  extends cvc
{
  public String GCj;
  public int Height;
  public String URL;
  public int Width;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(82416);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.URL == null)
      {
        paramVarArgs = new b("Not all required fields were included: URL");
        AppMethodBeat.o(82416);
        throw paramVarArgs;
      }
      if (this.GCj == null)
      {
        paramVarArgs = new b("Not all required fields were included: UserAgent");
        AppMethodBeat.o(82416);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.lC(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.URL != null) {
        paramVarArgs.d(2, this.URL);
      }
      if (this.GCj != null) {
        paramVarArgs.d(3, this.GCj);
      }
      paramVarArgs.aS(4, this.Width);
      paramVarArgs.aS(5, this.Height);
      AppMethodBeat.o(82416);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label618;
      }
    }
    label618:
    for (int i = f.a.a.a.lB(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.URL != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.URL);
      }
      i = paramInt;
      if (this.GCj != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.GCj);
      }
      paramInt = f.a.a.b.b.a.bz(4, this.Width);
      int j = f.a.a.b.b.a.bz(5, this.Height);
      AppMethodBeat.o(82416);
      return i + paramInt + j;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cvc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        if (this.URL == null)
        {
          paramVarArgs = new b("Not all required fields were included: URL");
          AppMethodBeat.o(82416);
          throw paramVarArgs;
        }
        if (this.GCj == null)
        {
          paramVarArgs = new b("Not all required fields were included: UserAgent");
          AppMethodBeat.o(82416);
          throw paramVarArgs;
        }
        AppMethodBeat.o(82416);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        bha localbha = (bha)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(82416);
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
            localbha.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(82416);
          return 0;
        case 2: 
          localbha.URL = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(82416);
          return 0;
        case 3: 
          localbha.GCj = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(82416);
          return 0;
        case 4: 
          localbha.Width = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(82416);
          return 0;
        }
        localbha.Height = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(82416);
        return 0;
      }
      AppMethodBeat.o(82416);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bha
 * JD-Core Version:    0.7.0.1
 */