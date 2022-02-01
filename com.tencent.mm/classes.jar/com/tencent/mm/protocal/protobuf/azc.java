package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class azc
  extends ckq
{
  public String Dxu;
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
      if (this.Dxu == null)
      {
        paramVarArgs = new b("Not all required fields were included: UserAgent");
        AppMethodBeat.o(82416);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.kX(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.URL != null) {
        paramVarArgs.d(2, this.URL);
      }
      if (this.Dxu != null) {
        paramVarArgs.d(3, this.Dxu);
      }
      paramVarArgs.aR(4, this.Width);
      paramVarArgs.aR(5, this.Height);
      AppMethodBeat.o(82416);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label618;
      }
    }
    label618:
    for (int i = f.a.a.a.kW(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.URL != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.URL);
      }
      i = paramInt;
      if (this.Dxu != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.Dxu);
      }
      paramInt = f.a.a.b.b.a.bA(4, this.Width);
      int j = f.a.a.b.b.a.bA(5, this.Height);
      AppMethodBeat.o(82416);
      return i + paramInt + j;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = ckq.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = ckq.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        if (this.URL == null)
        {
          paramVarArgs = new b("Not all required fields were included: URL");
          AppMethodBeat.o(82416);
          throw paramVarArgs;
        }
        if (this.Dxu == null)
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
        azc localazc = (azc)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(82416);
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
            localazc.BaseRequest = ((ip)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(82416);
          return 0;
        case 2: 
          localazc.URL = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(82416);
          return 0;
        case 3: 
          localazc.Dxu = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(82416);
          return 0;
        case 4: 
          localazc.Width = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(82416);
          return 0;
        }
        localazc.Height = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(82416);
        return 0;
      }
      AppMethodBeat.o(82416);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.azc
 * JD-Core Version:    0.7.0.1
 */